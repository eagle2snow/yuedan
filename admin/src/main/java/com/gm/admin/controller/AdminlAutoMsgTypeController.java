package com.gm.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gm.service.AutoMsgTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gm.base.model.AutoMsgType;
import com.gm.base.query.Page;
import com.gm.utils.StringUtil;

@Controller
@RequestMapping("/admin/automsgtype/")
public class AdminlAutoMsgTypeController {

    private final static String path = "admin/automsgtype/";

    @Resource
    private AutoMsgTypeService autoMsgTypeService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:automsgtype:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        return path + "add";
    }


    @RequiresPermissions("admin:automsgtype:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(AutoMsgType model)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgTypeService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:automsgtype:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        AutoMsgType model = autoMsgTypeService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "update";
    }


    @RequiresPermissions("admin:automsgtype:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(AutoMsgType model)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgTypeService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:automsgtype:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        AutoMsgType model = autoMsgTypeService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:automsgtype:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(AutoMsgType.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<AutoMsgType> list = autoMsgTypeService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }


    @RequiresPermissions("admin:automsgtype:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgTypeService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:automsgtype:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (autoMsgTypeService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:automsgtype:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgTypeService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
