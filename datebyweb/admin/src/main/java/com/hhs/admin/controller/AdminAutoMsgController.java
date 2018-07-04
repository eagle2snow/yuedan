package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.AutoMsgService;
import com.hhs.service.AutoMsgTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.AutoMsg;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/automsg/")
public class AdminAutoMsgController {

    private final static String path = "admin/automsg/";

    @Resource
    private AutoMsgService autoMsgService;
    @Resource
    private AutoMsgTypeService typeService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:automsg:add")
    public String addView(ModelMap map)
    {

        map.put("path", path);
        map.put("typeList", typeService.list());
        return path + "add";
    }

    @RequiresPermissions("admin:automsg:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(AutoMsg model)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:automsg:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        AutoMsg model = autoMsgService.get(id);
        map.put("path", path);
        map.put("model", model);
        map.put("typeList", typeService.list());
        return path + "update";
    }

    @RequiresPermissions("admin:automsg:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(AutoMsg model)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:automsg:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        AutoMsg model = autoMsgService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }

    @RequiresPermissions("admin:automsg:show")
    @RequestMapping("list/{type}/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer type, @PathVariable Integer pageIndex,
                          @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(AutoMsg.class);

        if (0 != type) {
            dc.add(Restrictions.eq("type.id", type));
        }

        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<AutoMsg> list = autoMsgService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("typeList", typeService.list());
        map.put("key", k);
        map.put("type", type);
        return path + "list";
    }

    @RequiresPermissions("admin:automsg:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:automsg:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (autoMsgService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:automsg:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (autoMsgService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
