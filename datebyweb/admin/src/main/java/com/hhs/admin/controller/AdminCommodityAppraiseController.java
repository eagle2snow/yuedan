package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.CommodityAppraiseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.CommodityAppraise;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/commodityappraise/")
public class AdminCommodityAppraiseController {

    private final static String path = "admin/commodityappraise/";

    @Resource
    private CommodityAppraiseService commodityAppraiseService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:commodityappraise:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        return path + "add";
    }


    @RequiresPermissions("admin:commodityappraise:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(CommodityAppraise model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityAppraiseService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityappraise:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        CommodityAppraise model = commodityAppraiseService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "update";
    }


    @RequiresPermissions("admin:commodityappraise:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(CommodityAppraise model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityAppraiseService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityappraise:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        CommodityAppraise model = commodityAppraiseService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:commodityappraise:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(CommodityAppraise.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<CommodityAppraise> list = commodityAppraiseService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }


    @RequiresPermissions("admin:commodityappraise:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityAppraiseService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityappraise:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (commodityAppraiseService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:commodityappraise:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityAppraiseService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
