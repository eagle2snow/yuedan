package com.hhs.admin.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.OrderItemService;
import com.hhs.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.hhs.base.model.Order;
import com.hhs.base.model.OrderItem;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

/**
 * 后台用户操作
 */
@Controller
@RequestMapping("/admin/order/")
public class AdminOrderController {

    private final static String path = "admin/order/";

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private OrderService orderService;

    @Resource
    private OrderItemService orderItemService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:order:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        return path + "add";
    }


    @RequiresPermissions("admin:order:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(Order model)
    {
        Map<String, Object> map = new HashMap<>();
        if (orderService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:order:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        Order model = orderService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "update";
    }


    @RequiresPermissions("admin:order:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(Order model)
    {
        Map<String, Object> map = new HashMap<>();
        if (orderService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:order:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        Order model = orderService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:order:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<Order> list = orderService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        logger.info("订单列表：{}", JSON.toJSON(list));
        return path + "list";
    }


    @RequiresPermissions("admin:order:show")
    @RequestMapping("list1/{pageIndex}/{pageSize}.htm")
    public String manager1(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        if (!StringUtil.strNullOrEmpty(k))
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        dc.add(Restrictions.or(Restrictions.ilike("status", "2", MatchMode.ANYWHERE), Restrictions.ilike("status", "11", MatchMode.ANYWHERE)));

        Page<Order> list = orderService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list1";
    }


    @RequiresPermissions("admin:order:show")
    @RequestMapping("list2/{pageIndex}/{pageSize}.htm")
    public String manager2(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        if (!StringUtil.strNullOrEmpty(k))
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        Page<Order> list = orderService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list2";
    }


    @RequiresPermissions("admin:order:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (orderService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:order:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (orderService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:order:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (orderService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:order:details")
    @RequestMapping("details/{id}.htm")
    public String detailsView(@PathVariable Integer id, ModelMap map)
    {
        Order model = orderService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "details";
    }

    @RequiresPermissions("admin:order:show")
    @RequestMapping("details1/{id}.htm")
    public String detailsView1(@PathVariable Integer id, ModelMap map)
    {
        Order model = orderService.get(id);
        List<OrderItem> models = orderItemService.listEq("order.id", id);
        map.put("path", path);
        map.put("model", model);
        map.put("models", models);
        logger.info("发货订单表详情 = {}", JSON.toJSON(model));
        logger.info("发货订单项表详情 = {}", JSON.toJSON(models));

        return path + "details1";
    }

    @RequiresPermissions("admin:order:show")
    @RequestMapping("details2/{id}.htm")
    public String detailsView2(@PathVariable Integer id, ModelMap map)
    {
        Order model = orderService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "details2";
    }

    @ResponseBody
    @RequestMapping("updateNotes")
    public String updateNotes(Integer id, String content)
    {
        Order order = orderService.get(id);
        order.setBusinessRemarks(content);
        if (orderService.update(order)) {
            return "0";
        } else {
            return "9";
        }
    }

    @ResponseBody
    @RequestMapping("updateExpress")
    public String updateExpress(Integer id, String express, String numbers)
    {
        Order order = orderService.get(id);
        order.setExpressName(express);
        order.setExpressNo(numbers);
        order.setStatus("3");
        order.setShipmentsTime(LocalDateTime.now());
        if (orderService.update(order)) {
            return "0";
        } else {
            return "9";
        }
    }

}
