package com.hhs.admin.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.sys.LoginLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.sys.LoginLog;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

/**
 * 后台用户操作
 */
@Controller
@RequestMapping("/admin/sys/loginlog/")
public class SysLoginLogController {

    private final static String path = "admin/sys/loginlog/";

    @Resource
    private LoginLogService loginLogService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:sys:loginlog:add")
    public String addView(ModelMap map)
    {

        map.put("path", path);

        return path + "add";
    }


    @RequiresPermissions("admin:sys:loginlog:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(LoginLog model)
    {
        Map<String, Object> map = new HashMap<>();
        if (loginLogService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:sys:loginlog:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        LoginLog model = loginLogService.get(id);
        map.put("path", path);
        map.put("model", model);

        return path + "update";
    }


    @RequiresPermissions("admin:sys:loginlog:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(LoginLog model)
    {
        Map<String, Object> map = new HashMap<>();
        if (loginLogService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:sys:loginlog:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        LoginLog model = loginLogService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:sys:loginlog:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(LoginLog.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<LoginLog> list = loginLogService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }


    @RequiresPermissions("admin:sys:loginlog:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (loginLogService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:sys:loginlog:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (loginLogService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:sys:loginlog:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (loginLogService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
