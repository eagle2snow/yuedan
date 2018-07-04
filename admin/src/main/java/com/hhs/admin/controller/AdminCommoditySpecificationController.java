package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.CommodityService;
import com.hhs.service.CommoditySpecificationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.CommoditySpecification;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/commodityspecification/")
public class AdminCommoditySpecificationController {

    private final static String path = "admin/commodityspecification/";

    @Resource
    private CommoditySpecificationService commoditySpecificationService;
    @Resource
    private CommodityService commodityService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:commodityspecification:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        map.put("commodityList", commodityService.list());
        return path + "add";
    }


    @RequiresPermissions("admin:commodityspecification:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(CommoditySpecification model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commoditySpecificationService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityspecification:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        CommoditySpecification model = commoditySpecificationService.get(id);
        map.put("path", path);
        map.put("model", model);
        map.put("commodityList", commodityService.list());
        return path + "update";
    }


    @RequiresPermissions("admin:commodityspecification:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(CommoditySpecification model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commoditySpecificationService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityspecification:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        CommoditySpecification model = commoditySpecificationService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:commodityspecification:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(CommoditySpecification.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<CommoditySpecification> list = commoditySpecificationService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }


    @RequiresPermissions("admin:commodityspecification:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commoditySpecificationService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityspecification:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (commoditySpecificationService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:commodityspecification:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commoditySpecificationService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
