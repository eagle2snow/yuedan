package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.Skill;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/skill/")
public class SkillController {

    private final static String path = "admin/skill/";

    @Resource
    private SkillService skillService;
    @Resource
    private EducationService educationService;
    @Resource
    private WorkService workService;
    @Resource
    private ClientService clientService;
    @Resource
    private ClassifyService classifyService;


    @RequestMapping("add.htm")
    @RequiresPermissions("admin:skill:add")
    public String addView(ModelMap map) {
        map.put("path", path);
        map.put("educationList", educationService.list());
        map.put("workList", workService.list());
        map.put("clientList", clientService.list());
        map.put("classifyList", classifyService.list());
        return path + "add";
    }

    @RequiresPermissions("admin:skill:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(Skill model) {
        Map<String, Object> map = new HashMap<>();
        if (skillService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:skill:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map) {
        Skill model = skillService.get(id);
        map.put("path", path);
        map.put("model", model);
        map.put("educationList", educationService.list());
        map.put("workList", workService.list());
        map.put("clientList", clientService.list());
        map.put("classifyList", classifyService.list());
        return path + "update";
    }

    @RequiresPermissions("admin:skill:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(Skill model) {
        Map<String, Object> map = new HashMap<>();
        if (skillService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:skill:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map) {
        Skill model = skillService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }

    @RequiresPermissions("admin:skill:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k) {
        DetachedCriteria dc = DetachedCriteria.forClass(Skill.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<Skill> list = skillService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }

    @RequiresPermissions("admin:skill:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        if (skillService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:skill:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (skillService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:skill:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        if (skillService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }
}
