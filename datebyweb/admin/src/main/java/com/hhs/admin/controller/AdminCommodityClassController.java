package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.CommodityClassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.CommodityClass;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/commodityclass/")
public class AdminCommodityClassController {

    private final static String path = "admin/commodityclass/";

    @Resource
    private CommodityClassService commodityClassService;
    @Resource
    private CommodityClassService parentService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:commodityclass:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        map.put("parentList", parentService.list());
        return path + "add";
    }


    @RequiresPermissions("admin:commodityclass:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(CommodityClass model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityClassService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityclass:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        CommodityClass model = commodityClassService.get(id);
        map.put("path", path);
        map.put("model", model);
        map.put("parentList", parentService.list());
        return path + "update";
    }


    @RequiresPermissions("admin:commodityclass:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(CommodityClass model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityClassService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityclass:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        CommodityClass model = commodityClassService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:commodityclass:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(CommodityClass.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<CommodityClass> list = commodityClassService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }


    @RequiresPermissions("admin:commodityclass:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityClassService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityclass:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (commodityClassService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:commodityclass:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityClassService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
