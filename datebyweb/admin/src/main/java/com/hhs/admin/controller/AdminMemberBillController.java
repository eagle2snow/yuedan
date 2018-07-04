package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.MemberBillService;
import com.hhs.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.MemberBill;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/memberbill/")
public class AdminMemberBillController {

    private final static String path = "admin/memberbill/";

    @Resource
    private MemberBillService memberBillService;
    @Resource
    private MemberService memberService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:memberbill:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        map.put("memberList", memberService.list());
        return path + "add";
    }

    @RequiresPermissions("admin:memberbill:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(MemberBill model)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberBillService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:memberbill:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        MemberBill model = memberBillService.get(id);
        map.put("path", path);
        map.put("model", model);
        map.put("memberList", memberService.list());
        return path + "update";
    }

    @RequiresPermissions("admin:memberbill:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(MemberBill model)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberBillService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:memberbill:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        MemberBill model = memberBillService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }

    @RequiresPermissions("admin:memberbill:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(MemberBill.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<MemberBill> list = memberBillService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }

    @RequiresPermissions("admin:memberbill:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberBillService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:memberbill:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (memberBillService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:memberbill:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (memberBillService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
