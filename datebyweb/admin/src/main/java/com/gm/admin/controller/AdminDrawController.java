package com.gm.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gm.service.DrawService;
import com.gm.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.base.model.Draw;
import com.gm.base.query.Page;
import com.gm.utils.StringUtil;

/**
 * 后台用户操作
 */
@Controller
@RequestMapping("/admin/draw/")
public class AdminDrawController {

    private final static String path = "admin/draw/";

    @Resource
    private DrawService drawService;
    @Resource
    private MemberService memberService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:draw:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        map.put("memberList", memberService.list());
        return path + "add";
    }


    @RequiresPermissions("admin:draw:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(Draw model)
    {
        Map<String, Object> map = new HashMap<>();
        if (drawService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:draw:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        Draw model = drawService.get(id);
        map.put("path", path);
        map.put("model", model);
        map.put("memberList", memberService.list());
        return path + "update";
    }


    @RequiresPermissions("admin:draw:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(Draw model)
    {
        Map<String, Object> map = new HashMap<>();
        if (drawService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:draw:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        Draw model = drawService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:draw:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(Draw.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<Draw> list = drawService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }


    @RequiresPermissions("admin:draw:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (drawService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:draw:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (drawService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:draw:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (drawService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
