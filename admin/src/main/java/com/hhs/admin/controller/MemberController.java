package com.hhs.admin.controller;

import java.util.*;

import javax.annotation.Resource;

import com.hhs.service.MemberService;
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
import com.hhs.base.model.Member;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;


@Controller
@RequestMapping("/admin/member/")
public class MemberController {

    private final static String path = "admin/member/";

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MemberService memberService;

    @RequestMapping("add.htm")
    // @RequiresPermissions("admin:member:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        return path + "add";
    }

    @RequiresPermissions("admin:member:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(Member model)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequestMapping("details/{id}.htm")
    public String detailsView(@PathVariable Integer id, ModelMap map)
    {
        Member model = memberService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "details";
    }

    @RequiresPermissions("admin:member:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        Member model = memberService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "update";
    }

    @RequiresPermissions("admin:member:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(Member model)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:member:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        Member model = memberService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }

    // @RequiresPermissions("admin:member:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(Member.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<Member> list = memberService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }

    @RequiresPermissions("admin:member:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:member:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (memberService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:member:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
