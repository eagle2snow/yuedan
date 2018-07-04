package com.hhs.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import com.hhs.base.dao.BaseDao;
import com.hhs.base.model.Model;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.query.Page;
import com.hhs.base.query.QueryObj;

@Transactional
public abstract class BaseService<T extends Model, PK extends Serializable> {

    public abstract BaseDao<T, PK> getDao();

    public boolean save(T t)
    {
        if (t == null)
            return false;
        return getDao().save(t);
    }

    public boolean update(T t)
    {
        return getDao().update(t);
    }

    public boolean delete(T t, boolean force)
    {
        return getDao().delete(t, force);
    }

    public T get(PK id)
    {
        return getDao().get(id);
    }

    public PK saveReturnId(T t)
    {
        if (t == null)
            return null;
        return getDao().saveReturnId(t);
    }

    public boolean deleteById(PK id, boolean force)
    {
        return getDao().deleteById(id, force);
    }

    public boolean deleteByIds(PK[] ids, boolean force)
    {
        return getDao().deleteByIds(ids, force);
    }

    public boolean deleteByParm(String p, Object v, boolean force)
    {
        return getDao().deleteByPV(p, v, force);
    }

    public boolean deleteByIds(List<PK> ids, boolean force)
    {
        if (ids == null || ids.isEmpty())
            return false;
        return getDao().deleteByIds(ids, force);
    }

    public T getOne(DetachedCriteria dc)
    {
        return getDao().getOne(dc);
    }

    public T getOne(String p, Object v)
    {
        return getDao().getOne(p, v);
    }

    public List<T> list(DetachedCriteria dc)
    {
        return getDao().list(dc);
    }

    //hql语句
    public List<T> list()
    {
        return getDao().list();
    }

    //detachedCriteria
    public List list(QueryObj queryObj)
    {
        return getDao().list(queryObj);
    }

    public List pqList(QueryObj queryObj)
    {
        List<String> selectedFields = queryObj.getReList();
        if (selectedFields.size() == 1)
            return pqListQueryObjReSizeEqOne(queryObj, selectedFields);
        List<Object[]> list = getDao().list(queryObj);
        List<Map<String, Object>> listMap = new ArrayList<>();
        list.forEach(os -> {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < selectedFields.size(); i++)
                map.put(selectedFields.get(i).replace(".", "_"), os[i]);
            listMap.add(map);
        });
        return listMap;
    }

    private List<Map<String, Object>> pqListQueryObjReSizeEqOne(QueryObj queryObj, List<String> selectedFields)
    {
        List<Map<String, Object>> results = new ArrayList<>();
        List<Object> list = getDao().list(queryObj);
        list.forEach(one -> {
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < selectedFields.size(); ++i)
                map.put(selectedFields.get(i).replace(".", "_"), one);
            results.add(map);
        });
        return results;
    }

    public List<T> listAll()
    {
        return getDao().listAll();
    }

    public List<T> listEq(String p, Object v)
    {
        return getDao().listEq(p, v);
    }

    public List<T> listEqDc(String p, Object v, Object c, String s)
    {
        return getDao().listEqDc(p, v, c, s);
    }

    public List<T> listEq(String p, Object v, int n)
    {
        return getDao().listEq(p, v, n);
    }

    public Page<T> list(DetachedCriteria dc, Integer pageIndex, Integer pageSize)
    {
        Integer count = getDao().count(dc);
        if (count > 0) {
            List<T> list = getDao().list(dc, pageIndex, pageSize);
            return new Page<>(pageIndex, pageSize, count, list);
        }
        return new Page<>(pageIndex, pageSize, count, null);
    }

    public Long count()
    {
        return getDao().count();
    }

    public boolean exist(String p, Object v)
    {
        return getDao().exist(p, v);
    }

    public List<T> listNotEq(String p, Object v)
    {
        return getDao().listNotEq(p, v);
    }

    public List<T> listLike(String p, String v, MatchMode matchMode, boolean ignoreCase)
    {
        return getDao().listLike(p, v, matchMode, ignoreCase);
    }

    public List<T> listNotLike(String p, String v, MatchMode matchMode, boolean ignoreCase)
    {
        return getDao().listNoLike(p, v, matchMode, ignoreCase);
    }

    public List<T> listIn(String p, Object[] arr)
    {
        return getDao().listIn(p, arr);
    }

    public List<T> listNotIn(String p, Object[] arr)
    {
        return getDao().listNotIn(p, arr);
    }

    public List<T> listRam(int n)
    {
        return getDao().listRam(n);
    }

    public List<T> listEq(String p, Object v, Integer pageIndex, Integer pageSize)
    {
        return getDao().listEq(p, v, pageIndex, pageSize);
    }

    public Long count(String p, Object v)
    {
        return getDao().count(p, v);
    }

    public List<T> listToday(String p, int n)
    {
        return getDao().listToday(p, n);
    }

    public void update(String p, Object v, List<PK> list)
    {
        getDao().update(p, v, list);
    }

    public boolean update(String p, Object v, PK id)
    {
        return getDao().updatePropById(p, v, id);
    }

    public HttpSession getSession()
    {
        return null;
    }

    public List<T> listIsNull(String p)
    {
        return getDao().listIsNull(p);
    }

    public List<T> listNotNull(String p)
    {
        return getDao().listIsNotNull(p);
    }

    public List<T> listIn(String p, List<PK> list)
    {
        if (null == list || list.size() == 0)
            return new ArrayList<>();
        return getDao().listIn(p, list);
    }

    public T getAndLock(PK id)
    {
        return getDao().getAndLock(id);
    }

    public List<T> listNotEq(String p, Object v, Integer n)
    {
        return getDao().listNotEq(p, v, n);
    }

    public List<T> listNotIn(String p, List<Object> list)
    {
        return getDao().listNotIn(p, list);
    }

    public List<T> listAsc(String p, int n)
    {
        return getDao().listAsc(p, n);
    }

    public List<T> listDesc(String p, int n)
    {
        return getDao().listDesc(p, n);
    }

    public List<T> listToday(String p)
    {
        return getDao().listToday(p);
    }

    public List<T> listIn(String p, String inString)
    {
        return getDao().listIn(p, inString);
    }

    public List<T> listLike(String p, String v, MatchMode matchMode, boolean ignoreCase, Integer size)
    {
        return getDao().listLike(p, v, matchMode, ignoreCase, size);
    }

    public List<T> list(DetachedCriteria dc, Integer size)
    {
        return getDao().list(dc, size);
    }

    public boolean exist(String p, String v, Integer storeId)
    {
        return getDao().exist(p, v, storeId);
    }
}