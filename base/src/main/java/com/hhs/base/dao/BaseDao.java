package com.hhs.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.hhs.base.model.Model;
import com.hhs.base.query.ConObj;
import com.hhs.base.query.QueryObj;
import com.hhs.utils.DateUtil;
import com.hhs.utils.StringUtil;
import com.xiaoleilu.hutool.util.ArrayUtil;

@Repository
public class BaseDao<T extends Model, ID extends Serializable> {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private EntityManager entityManager;

    public Session getSession()
    {
        // HibernateEntityManager hEntityManager = (HibernateEntityManager)
        // entityManager;
        // return hEntityManager.getSession();
        return (Session) entityManager.getDelegate();
    }

    private Class<T> entityClass;

    // 父类没有不带参数的构造方法，这里手动构造父类
    /*
     * public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) { //
     * super(domainClass, entityManager); this.entityManager = entityManager;
     * this.entityClass = domainClass; }
     */

    public BaseDao()
    {
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
        }
    }

    public boolean save(T entity)
    {
        try {
            getSession().save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public T get(ID id)
    {
        return getSession().get(entityClass, id);
    }

    // 更新实体
    public boolean update(T entity)
    {
        try {
            // this.flush();
            // this.clear();
            getSession().update(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(T entity, boolean force)
    {
        try {
            if (force) {
                getSession().delete(entity);
            } else {
                deleteById((ID) entity.getId(), force);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public T load(ID id)
    {
        try {
            return getSession().load(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public T getAndLock(ID id)
    {
        return getSession().get(entityClass, id, LockMode.PESSIMISTIC_WRITE);// 悲观锁
    }

    public boolean deleteById(ID id, boolean force)
    {
        try {
            if (force) {
                Integer i = getSession().createQuery("delete from " + entityClass.getName() + " a where a.id=:ID")
                        .setParameter("ID", id).executeUpdate();
                return i == 1;
            } else {
                return updatePropById("deleted", 2, id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByIds(ID[] ids, boolean force)
    {
        try {
            // 数组中封装的是ID的集合;
            String s = ArrayUtil.join(ids, ",");
            if (force) {
                Query q = getSession().createQuery("delete from " + entityClass.getName() + " where id in(" + s + ")");
                q.executeUpdate();
            } else {
                updateByIn("deleted", 2, "id", ids);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByIn(String p, Object[] ids, boolean force)
    {
        try {
            String s = ArrayUtil.join(ids, ",");
            if (force) {
                Query q = getSession()
                        .createQuery("delete from " + entityClass.getName() + " where " + p + " in(" + s + ")");
                q.executeUpdate();
            } else {
                updateByIn("deleted", 2, p, ids);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateByIn(String p, Object v, String pp, Object[] vv)
    {
        String s = ArrayUtil.join(vv, ",");
        Query q = getSession()
                .createQuery("update " + entityClass.getName() + " set " + p + "=:v where " + pp + " in(" + s + ")")
                .setParameter("v", v);
        q.executeUpdate();
    }

    public long count()
    {
        String hql = "select count(*) from " + entityClass.getName() + " where deleted=1";
        java.util.Optional<Long> i = getSession().createQuery(hql).uniqueResultOptional();
        return i.orElse(0L);
    }



    // -------------------------------- Criteria ------------------------------
    public Criteria createCriteria()
    {
        return DetachedCriteria.forClass(entityClass).getExecutableCriteria(getSession())
                .add(Restrictions.eq("deleted", 1));
    }

    public void initialize(Object proxy)
    {
        // getHibernateTemplate().initialize(proxy);
    }

    public void flush()
    {
        getSession().flush();
    }

    public void clear()
    {
        getSession().clear();
    }

    // 根据属性Like
    public List<T> listLike(String p, String v, MatchMode matchMode, boolean ignoreCase)
    {
        Criteria criteria = createCriteria();
        try {
            if (ignoreCase)
                criteria.add(Restrictions.ilike(p.trim(), v.trim(), matchMode));
            else
                criteria.add(Restrictions.like(p.trim(), v.trim(), matchMode));
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // 根据属性Like
    public List<T> listLike(String p, String v, MatchMode matchMode, boolean ignoreCase, String token)
    {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("token", token));
        try {
            if (ignoreCase)
                criteria.add(Restrictions.ilike(p.trim(), v.trim(), matchMode));
            else
                criteria.add(Restrictions.like(p.trim(), v.trim(), matchMode));
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // 根据属性Equal
    public List<T> listEq(String p, Object v)
    {
        String hql = "from " + entityClass.getName() + " e where e.deleted=1 and ";
        if (v instanceof String) {
            hql = hql + " e." + p + "='" + v + "'";
        } else {
            hql = hql + " e." + p + "=" + v;
        }
        return getSession().createQuery(hql).getResultList();
    }

    // 根据属性Equal，并排序
    public List<T> listEqDc(String p, Object v, Object c, String s)
    {
        String hql = "from " + entityClass.getName() + " e where e.deleted=1 and ";
        if (v instanceof String) {
            hql = hql + " e." + p + "='" + v + "'" + " order by " + c + " " + s;
        } else {
            hql = hql + " e." + p + "=" + v + " order by " + c + " " + s;
        }
        return getSession().createQuery(hql).getResultList();
    }

    public boolean exist(String param, Object value)
    {
        String hql = "select count(*) from " + entityClass.getName() + " e where e.deleted=1 and e." + param + "=:v ";
        java.util.Optional<Long> i = getSession().createQuery(hql, Long.class).setParameter("v", value).uniqueResultOptional();
        long result = i.orElse(0L);
        return result > 0;
    }

    public Long count(String fieldName, Object values)
    {
        String hql = "select count(*) from " + entityClass.getName() + " t where deleted=1 and t." + fieldName + "=:V";
        java.util.Optional<Long> i = getSession().createQuery(hql).setParameter("V", values).uniqueResultOptional();
        return i.orElse(0L);
    }

    public List<T> listRam(Integer i)
    {
        return getSession().createQuery(" FROM " + entityClass.getName() + " where deleted=1 order by rand() ")
                .setMaxResults(i).getResultList();
    }

    public Integer countByLike(String fieldName, String value)
    {
        return listLike(fieldName, value, MatchMode.ANYWHERE, false).size();
    }

    protected Long countByHQL(String hql)
    {
        java.util.Optional<Long> i = getSession().createQuery("select count(*) " + hql).uniqueResultOptional();
        return i.orElse(0L);
    }

    public List<T> list(DetachedCriteria dc)
    {
        Criteria criteria = getCriteria(dc);
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        return criteria.list();
    }

    private Criteria getCriteria(DetachedCriteria dc)
    {
        return dc.add(Restrictions.eq("deleted", 1)).getExecutableCriteria(this.getSession());
    }

    public Integer count(DetachedCriteria dc)
    {
        Criteria criteria = getCriteria(dc);
        criteria.setProjection(Projections.rowCount());
        long count = (long) criteria.uniqueResult();
        criteria.setProjection(null);
        return (int) count;
    }

    public List<T> list(DetachedCriteria dc, Integer pageIndex, Integer pageSize)
    {
        Criteria criteria = getCriteria(dc);
        if (pageIndex == 0 || pageSize == 0)
            return list(dc);

        criteria.setResultTransformer(Criteria.ROOT_ENTITY);
        List<T> list = criteria.add(Restrictions.eq("deleted", 1)).setFirstResult((pageIndex - 1) * pageSize)
                .setMaxResults(pageSize).addOrder(Order.asc("id")).list();
        return list;
    }

    public List<T> getToday(String p, Integer i)
    {
        return createCriteria().add(Restrictions.ge(p, DateUtil.getTodayStartTime(new Date())))
                .add(Restrictions.le(p, DateUtil.getTodayEndTime(new Date()))).setMaxResults(i).list();
    }

    public boolean deleteByPV(String p, Object v, boolean force)
    {
        String hql;
        if (force)
            hql = "delete from " + entityClass.getName() + " e where e." + p.trim() + "=:v";
        else
            hql = "update " + entityClass.getName() + " set " + p.trim() + "=:v";
        Integer i = getSession().createQuery(hql).setParameter("v", v).executeUpdate();
        return i > 0;
    }

    public boolean updatePropById(String p, Object v, ID id)
    {
        Integer i = getSession()
                .createQuery("update " + entityClass.getName() + " set " + p.trim() + "=:v" + " where id=:ID")
                .setParameter("v", v).setParameter("ID", id).executeUpdate();
        return i > 0;
    }

    public void update(String p, Object v, List<ID> ids)
    {
        getSession().createQuery("update " + entityClass.getName() + " set " + p.trim() + "=:v" + " where id in(:IDS)")
                .setParameter("v", v).setParameterList("IDS", ids).executeUpdate();
    }

    public boolean deleteByIds(List<ID> ids, boolean force)
    {
        try {
            if (force) {
                Query q = getSession().createQuery("delete from " + entityClass.getName() + " where id in(:IDS)")
                        .setParameterList("IDS", ids);
                q.executeUpdate();
            } else {
                update("deleted", 2, ids);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public T getOne(String p, Object v)
    {
        String hql = " from " + entityClass.getName() + " e where e.deleted=1 and e." + p + " =:V";
        Optional<T> o = getSession().createQuery(hql).setParameter("V", v).uniqueResultOptional();
        return o.orElse(null);
    }

    public List<T> listToday(String p)
    {
        createCriteria().setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        return createCriteria().add(Restrictions.ge(p, DateUtil.getTodayStartTime(new Date())))
                .add(Restrictions.le(p, DateUtil.getTodayEndTime(new Date()))).list();
    }

    public List<T> listNotIn(String p, Object[] arr, String token)
    {
        String hql = " from " + entityClass.getName() + " e where e.deleted=1 and e.token=:T and e." + p
                + " not in (:V)";
        return getSession().createQuery(hql).setParameter("T", token).setParameterList("V", arr).getResultList();
    }

    public List<T> listNotIn(String p, List<Object> arr, String token)
    {
        String hql = " from " + entityClass.getName() + " e where e.deleted=1 and e.token=:T and e." + p
                + " not in (:V)";
        return getSession().createQuery(hql).setParameter("T", token).setParameterList("V", arr).getResultList();
    }

    public List<T> listIn(String p, Object[] arr, String token)
    {
        String hql = " from " + entityClass.getName() + " e where e.deleted=1 and e.token=:T and e." + p + " in (:V)";
        return getSession().createQuery(hql).setParameter("T", token).setParameterList("V", arr).getResultList();
    }

    public List<T> listIn(String p, List<ID> list)
    {
        String hql = " from " + entityClass.getName() + " e where e.deleted=1 and e." + p + " in (:V)";
        return getSession().createQuery(hql).setParameterList("V", list).getResultList();
    }

    public List<T> listNoLike(String p, String v, MatchMode matchMode, boolean ignoreCase)
    {
        Criteria criteria = createCriteria();
        List<T> list = new ArrayList<T>();
        try {
            if (ignoreCase) {
                criteria.add(Restrictions.not(Restrictions.ilike(p.trim(), v.trim(), matchMode)));
            } else {
                criteria.add(Restrictions.not(Restrictions.like(p.trim(), v.trim(), matchMode)));
            }
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<T> listNotEq(String p, Object v, String token)
    {
        return createCriteria().add(Restrictions.ne(p.trim(), v)).add(Restrictions.eq("token", token)).list();
    }

    public List<T> listEq(String p, Object v, Integer n, String token)
    {
        return createCriteria().add(Restrictions.eq(p.trim(), v)).add(Restrictions.eq("token", token)).setMaxResults(n)
                .list();
    }

    public List<T> listEq(String p, Object v, Integer pageIndex, Integer pageSize, String token)
    {
        return createCriteria().add(Restrictions.eq(p.trim(), v)).add(Restrictions.eq("token", token))
                .setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
    }

    public List<T> listEq(String p, Object v, String token)
    {
        List<T> list = createCriteria().add(Restrictions.eq(p.trim(), v)).add(Restrictions.eq("token", token)).list();
        return list;
    }

    public boolean deleteByIn(String p, List<Object> list, boolean force)
    {
        try {
            if (force) {
                getSession().createQuery("delete from " + entityClass.getName() + " e where e." + p + " in (:list)")
                        .setParameterList("list", list).executeUpdate();
            } else {
                updateByIn("deleted", 2, p, list);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateByIn(String p, int v, String pp, List<Object> list)
    {

        Query q = getSession()
                .createQuery("update " + entityClass.getName() + " set " + p + "=:v where " + pp + " in(:list)")
                .setParameter("v", v).setParameterList("list", list);
        q.executeUpdate();
    }

    public List<T> listIsNull(String p, String token)
    {
        return createCriteria().add(Restrictions.isNull(p)).add(Restrictions.eq("token", token)).list();
    }

    public List<T> list()
    {
        String hql = "from " + entityClass.getName() + " where deleted=1";
        return getSession().createQuery(hql).getResultList();
    }

    public List<T> listAll()
    {
        String hql = "from " + entityClass.getName();
        return getSession().createQuery(hql).getResultList();
    }

    private NativeQuery<T> createNativeQuery(String sql)
    {
        return getSession().createNativeQuery(sql);
    }

    public List<T> list(DetachedCriteria criteria, Integer firstResult, Integer maxResults, String token)
    {
        return getCriteria(criteria).add(Restrictions.eq("token", token)).setFirstResult(firstResult)
                .setMaxResults(maxResults).list();
    }

    public List<T> listEq(String p, Object v, Integer n)
    {
        Criteria criteria = createCriteria();
        try {
            criteria.add(Restrictions.eq(p.trim(), v));
            criteria.addOrder(Order.desc("id")).setMaxResults(n);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<T> listLike(String p, String v, Integer n)
    {
        Criteria criteria = createCriteria();
        try {
            criteria.add(Restrictions.ilike(p.trim(), v.trim(), MatchMode.ANYWHERE)).setMaxResults(n);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<T> listLike(String p, String v, Integer n, String token)
    {
        Criteria criteria = createCriteria();
        try {
            criteria.add(Restrictions.eq("token", token)).add(Restrictions.ilike(p.trim(), v.trim(), MatchMode.ANYWHERE)).setMaxResults(n);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public boolean exist(String p, Object v, String token)
    {
        String hql = "select count(*) from " + entityClass.getName() + "e where e.:p=:v and e.token=:T";
        java.util.Optional<Long> i = getSession().createQuery(hql).setParameter("v", v).setParameter("T", token)
                .uniqueResultOptional();
        long result = i.orElse(0L);
        return result > 0;
    }

    public List<T> listAsc(String prop, Integer size)
    {
        return getQuery(" order by :prop ASC").setParameter("prop", prop).setMaxResults(size).getResultList();
    }

    public List<T> listAsc(String prop, Integer size, String token)
    {
        return getQuery(" and token=:T order by :prop ASC").setParameter("prop", prop).setParameter("T", token)
                .setMaxResults(size).getResultList();
    }

    public List<T> listDesc(String prop, Integer size)
    {
        return getQuery(" order by :prop DESC").setParameter("prop", prop).setMaxResults(size).getResultList();
    }

    public List<T> listDesc(String prop, Integer size, String token)
    {
        return getQuery(" and token=:T order by :prop DESC").setParameter("prop", prop).setParameter("T", token)
                .setMaxResults(size).getResultList();
    }

    public List<T> listNotIn(String p, List<Object> arr, Integer pageIndex, Integer pageSize, String token)
    {
        return getQuery(" and e." + p + " not in(:list) and e.token=:T").setParameterList("list", arr)
                .setParameter("T", token).setFirstResult(pageIndex).setMaxResults(pageSize).getResultList();
    }

    private Query getQuery(String str)
    {
        return getSession().createQuery(" from " + entityClass.getName() + " e where deleted=1 " + str);
    }

    public List<T> listIsNotNull(String p, String token)
    {
        return getQuery(" and e." + p + " is not null and token=:T").setParameter("T", token).getResultList();
    }

    public List<T> list(DetachedCriteria dc, String token)
    {
        return getCriteria(dc).add(Restrictions.eq("token", token)).list();
    }

    public List<T> listRam(Integer n, String token)
    {
        return getSession()
                .createQuery(" FROM " + entityClass.getName() + " where deleted=1 and token=:T " + "order by rand() ")
                .setParameter("T", token).setMaxResults(n).getResultList();
    }

    public List<T> listIsNull(String p)
    {
        return createCriteria().add(Restrictions.isNull(p)).list();
    }

    public List<T> listIsNotNull(String p)
    {
        return createCriteria().add(Restrictions.isNotNull(p)).list();
    }

    public List list(QueryObj queryObj)
    {
        return getCriteria(queryObj, 0).list();
    }

    private Criteria getCriteria(QueryObj queryObj, Integer n)
    {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("deleted", 1));

        for (Map<String, Object> map : queryObj.getEqMap())
            map.forEach((k, v) -> criteria.add(Restrictions.eq(k, v)));
        for (Map<String, Object> map : queryObj.getNeMap())
            map.forEach((k, v) -> criteria.add(Restrictions.ne(k, v)));
        for (Entry<String, Object> entry : queryObj.getLtMap().entrySet())
            criteria.add(Restrictions.lt(entry.getKey(), entry.getValue()));
        for (Entry<String, Object> entry : queryObj.getLeMap().entrySet())
            criteria.add(Restrictions.le(entry.getKey(), entry.getValue()));
        for (Entry<String, Object> entry : queryObj.getGtMap().entrySet())
            criteria.add(Restrictions.gt(entry.getKey(), entry.getValue()));
        for (Entry<String, Object> entry : queryObj.getGeMap().entrySet())
            criteria.add(Restrictions.ge(entry.getKey(), entry.getValue()));
        for (Map<String, ConObj> map : queryObj.getBtMap())
            map.forEach((k, v) -> criteria.add(Restrictions.between(k, v.getStart(), v.getEnd())));
        for (Map<String, Object> map : queryObj.getLkMap())
            map.forEach((k, v) -> criteria.add(Restrictions.ilike(k, (String) v, MatchMode.ANYWHERE)));
        if (queryObj.getReList().size() != 0) {
            ProjectionList pList = Projections.projectionList();
            for (String entry : queryObj.getReList())
                pList.add(Projections.property(entry));
            criteria.setProjection(pList);
            criteria.setResultTransformer(Transformers.aliasToBean(entityClass));
            criteria.setResultTransformer(CriteriaSpecification.PROJECTION);
        }
        if (n != 0)
            criteria.setMaxResults(n);
        criteria.addOrder(Order.desc("id"));
        if (queryObj.getAliasSet().size() != 0)
            queryObj.getAliasSet().forEach(q -> criteria.createAlias(q, q));
        return criteria;
    }

    public List<T> list(QueryObj qeuryObj, Integer n)
    {
        return getCriteria(qeuryObj, n).list();
    }

    public List<T> listIn(String p, List<ID> list, String token)
    {
        String hql = " from " + entityClass.getName() + " e where deleted=1 and e.token=:T and e." + p + " in (:V)";
        return getSession().createQuery(hql).setParameter("T", token).setParameterList("V", list).getResultList();
    }

    public boolean renewPropById(String p, Object v, ID id)
    {
        Integer i = getSession()
                .createQuery("update " + entityClass.getName() + " set " + p.trim() + "=:v" + " where id=:ID")
                .setParameter("v", v).setParameter("ID", id).executeUpdate();
        return i > 0;
    }

    public boolean renew(T t)
    {
        try {
            this.flush();
            this.clear();
            getSession().update(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ID saveReturnId(T entity)
    {
        try {
            ID id = (ID) getSession().save(entity);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<T> listAllAsc(String prop)
    {
        String hql = "from " + entityClass.getName() + " where deleted=1 order by :prop ASC";
        return getSession().createQuery(hql).setParameter("prop", prop).getResultList();
    }

    public List<T> listAllDesc(String prop)
    {
        String hql = "from " + entityClass.getName() + " where deleted=1 order by :prop DESC";
        return getSession().createQuery(hql).setParameter("prop", prop).getResultList();
    }

    public List<T> listToday(String p, Integer n)
    {
        createCriteria().setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        return createCriteria().add(Restrictions.ge(p, DateUtil.getTodayStartTime(new Date())))
                .add(Restrictions.le(p, DateUtil.getTodayEndTime(new Date()))).setMaxResults(n).list();
    }

    public List<T> listNoLike(String p, String v)
    {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.ilike(p.trim(), v.trim(), MatchMode.ANYWHERE));
        return criteria.list();
    }

    public List<T> listNotEq(String p, Object v)
    {
        return createCriteria().add(Restrictions.ne(p.trim(), v)).list();
    }

    public List<T> listIn(String p, Object[] arr)
    {
        return createCriteria().add(Restrictions.in(p.trim(), arr)).list();
    }

    public List<T> listNotIn(String p, List<Object> list)
    {
        return createCriteria().add(Restrictions.not(Restrictions.in(p.trim(), list))).list();
    }

    public List<T> listNotIn(String p, Object[] arr)
    {
        return createCriteria().add(Restrictions.not(Restrictions.in(p.trim(), arr))).list();
    }

    public List<T> list(Integer size)
    {
        return createCriteria().setMaxResults(size).list();
    }

    public List<T> listEq(String p, Object v, Integer pageIndex, Integer pageSize)
    {
        return createCriteria().add(Restrictions.eq(p.trim(), v)).setFirstResult((pageIndex - 1) * pageSize)
                .setMaxResults(pageSize).list();
    }

    public List<T> listNoLike(String p, String v, MatchMode matchMode, boolean ignoreCase, String token)
    {
        Criteria criteria = createCriteria();
        List<T> list = new ArrayList<T>();
        criteria.add(Restrictions.eq("token", token));
        try {
            if (ignoreCase) {
                criteria.add(Restrictions.not(Restrictions.ilike(p.trim(), v.trim(), matchMode)));
            } else {
                criteria.add(Restrictions.not(Restrictions.like(p.trim(), v.trim(), matchMode)));
            }
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<T> listToday(String p, String token)
    {
        createCriteria().setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        return createCriteria().add(Restrictions.eq("token", token))
                .add(Restrictions.ge(p, DateUtil.getTodayStartTime(new Date())))
                .add(Restrictions.le(p, DateUtil.getTodayEndTime(new Date()))).list();
    }

    public List<T> listToday(String p, Integer n, String token)
    {
        createCriteria().setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        return createCriteria().add(Restrictions.eq("token", token))
                .add(Restrictions.ge(p, DateUtil.getTodayStartTime(new Date())))
                .add(Restrictions.le(p, DateUtil.getTodayEndTime(new Date()))).setMaxResults(n).list();
    }

    public List<T> listNotEq(String p, Object v, Integer n)
    {
        return createCriteria().add(Restrictions.ne(p.trim(), v)).setMaxResults(n).list();
    }

    public List<T> listIn(String p, String value)
    {
        return getQuery(" and " + p + " in(" + value + ")").getResultList();
    }

    public List<T> listLike(String p, String v, MatchMode matchMode, boolean ignoreCase, Integer size)
    {
        Criteria criteria = createCriteria();
        List<T> list = new ArrayList<>();
        try {
            if (ignoreCase) {
                criteria.add(Restrictions.ilike(p.trim(), v.trim(), matchMode));
            } else {
                criteria.add(Restrictions.like(p.trim(), v.trim(), matchMode));
            }
            return criteria.setMaxResults(size).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<T> list(DetachedCriteria dc, Integer size)
    {
        Criteria criteria = getCriteria(dc);
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        return criteria.setMaxResults(size).list();
    }

    public boolean exist(String p, String v, Integer storeId)
    {
        String hql = "select count(*) from " + entityClass.getName() + " e where e.deleted=1 and e." + p
                + "=:v and e.store.id=:storeId";
        java.util.Optional<Long> i = getSession().createQuery(hql).setParameter("v", v).setParameter("storeId", storeId)
                .uniqueResultOptional();
        long result = i.orElse(0L).longValue();
        return result > 0;
    }

    public List<T> relist(String p)
    {
        List<String> list = StringUtil.toStringList(p, ",");
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        ProjectionList pList = Projections.projectionList();
        for (String string : list)
            pList.add(Projections.property(string));
        dc.setProjection(pList);
        dc.setResultTransformer(Transformers.aliasToBean(entityClass));
        Criteria criteria = getCriteria(dc);
        criteria.setResultTransformer(CriteriaSpecification.PROJECTION);
        return criteria.list();
    }

    public List<T> ReAndEqlist(String p, Map<String, Object> condition)
    {
        List<String> list = StringUtil.toStringList(p, ",");
        DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
        ProjectionList pList = Projections.projectionList();
        for (Entry<String, Object> entry : condition.entrySet())
            dc.add(Restrictions.eq(entry.getKey(), entry.getValue()));
        for (String string : list)
            pList.add(Projections.property(string));
        dc.setProjection(pList);
        dc.setResultTransformer(Transformers.aliasToBean(entityClass));
        Criteria criteria = getCriteria(dc);
        criteria.setResultTransformer(CriteriaSpecification.PROJECTION);
        return criteria.list();
    }

    public List reAndCtlist(String p, DetachedCriteria dc)
    {
        List<String> list = StringUtil.toStringList(p, ",");
        ProjectionList pList = Projections.projectionList();
        for (String string : list)
            pList.add(Projections.property(string));
        dc.setProjection(pList);
        dc.setResultTransformer(Transformers.aliasToBean(entityClass));
        Criteria criteria = getCriteria(dc);
        criteria.setResultTransformer(CriteriaSpecification.PROJECTION);
        return criteria.list();
    }

    public T getOne(DetachedCriteria dc)
    {
        List<T> list = getCriteria(dc).list();
        if (list.size() > 0)
            return list.get(0);
        return null;
    }






    protected List<T> listByHQL(String hql, Integer size)
    {
        return getSession().createQuery(hql).setMaxResults(size).getResultList();
    }

    protected <C> List<C> listFieldBySQL(String sql)
    {
        return (List<C>) getSession().createNativeQuery(sql).getResultList();
    }

    protected List<ID> listIdsBySQL(String sql)
    {
        List<ID> ids = getSession().createNativeQuery(sql).getResultList();
        return ids;
    }

    protected List listBySQL(String sql)
    {
        return getSession().createNativeQuery(sql).getResultList();
    }

    protected List<T> list(String hql, Integer pageIndex, Integer pageSize)
    {
        return getSession().createQuery(hql).setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
    }

    protected boolean updateByHql(String hql)
    {
        try {
            Query<?> query = getSession().createQuery(hql);
            int n = query.executeUpdate();
            logger.info("更新条数：" + n);
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected boolean renewByHql(String hql)
    {
        try {
            Query<?> query = getSession().createQuery(hql);
            int n = query.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected Long countBySQL(String sql)
    {
        java.util.Optional<BigInteger> i = getSession().createNativeQuery(sql).uniqueResultOptional();
        return i.orElse(BigInteger.ZERO).longValue();
    }

    protected boolean updateBySql(String sql)
    {
        Integer i = getSession().createNativeQuery(sql).executeUpdate();
        return i > 0;
    }

    protected List<T> listByHQL(String hql)
    {
        return getSession().createQuery(hql).getResultList();
    }

    protected List<T> listByHQL(String hql, Object[] values)
    {
        Query q = getSession().createQuery(hql);
        for (Integer i = 0; i < values.length; i++)
            q.setParameter(i, values[i]);
        return q.getResultList();
    }

    protected List<T> listByHQL(String hql, String token)
    {
        List<T> list = getSession().createQuery(hql).getResultList();
        return list;
    }

    protected List<T> listByHQL(String hql, Integer n, String token)
    {
        List<T> list = getSession().createQuery(hql).setMaxResults(n).getResultList();
        return list;
    }

    protected T getOne(String hql)
    {
        Optional<T> o = getSession().createQuery(hql).uniqueResultOptional();
        return o.orElse(null);
    }

    protected Integer delete(String hql)
    {
        return getSession().createQuery(hql).executeUpdate();
    }
}