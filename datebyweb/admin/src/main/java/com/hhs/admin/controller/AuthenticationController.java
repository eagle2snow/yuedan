package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.service.ClientService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.Authentication;
import com.hhs.service.AuthenticationService;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/authentication/")
public class AuthenticationController {

	private final static String path = "admin/authentication/";

	@Resource
    private AuthenticationService authenticationService;
	@Resource
    private ClientService clientService;


	@RequestMapping("add.htm")
	@RequiresPermissions("admin:authentication:add")
	public String addView(ModelMap map)
	{
		map.put("path", path);
		map.put("clientList",clientService.list());
		return path + "add";
	}

	@RequiresPermissions("admin:authentication:add")
	@ResponseBody
	@RequestMapping("add.json")
	public Map<String, Object> addAction(Authentication model)
	{
		Map<String, Object> map = new HashMap<>();
		if (authenticationService.save(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
	
	@RequiresPermissions("admin:authentication:update")
	@RequestMapping("update/{id}.htm")
	public String updateView(@PathVariable Integer id, ModelMap map)
	{
		Authentication model = authenticationService.get(id);
		map.put("path", path);
		map.put("model", model);
		map.put("clientList",clientService.list());
		return path + "update";
	}

	@RequiresPermissions("admin:authentication:update")
	@RequestMapping("update.json")
	@ResponseBody
	public Map<String, Object> updateAction(Authentication model)
	{
		Map<String, Object> map = new HashMap<>();
		if (authenticationService.update(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("admin:authentication:show")
	@RequestMapping("show/{id}.htm")
	public String showView(@PathVariable Integer id, ModelMap map)
	{
		Authentication model = authenticationService.get(id);
		map.put("model", model);
		map.put("path", path);
		return path + "show";
	}
	
	@RequiresPermissions("admin:authentication:show")
	@RequestMapping("list/{pageIndex}/{pageSize}.htm")
	public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize,String k)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(Authentication.class);
		if (!StringUtil.strNullOrEmpty(k)) {
			dc.add(Restrictions.ilike("name", k.trim(),MatchMode.ANYWHERE));
		}
		Page<Authentication> list = authenticationService.list(dc, pageIndex, pageSize);
		map.put("page", list);
		map.put("path", path);
		map.put("key", k);
		return path + "list";
	}

	@RequiresPermissions("admin:authentication:delete")
	@RequestMapping("deleteById/{id}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable Integer id)
	{
		Map<String, Object> map = new HashMap<>();
		if (authenticationService.deleteById(id, false)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("admin:authentication:delete")
	@RequestMapping("deleteByIds/{ids}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable String ids)
	{
		Map<String, Object> map = new HashMap<>();
		List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
    	if (authenticationService.deleteByIds(arrayId, false)) {
    		map.put("status", "ok");
    	} else {
    		map.put("status", "no");
    	}
    	return map;
    }

    @RequiresPermissions("admin:authentication:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
	{
        Map<String, Object> map = new HashMap<>();
		if (authenticationService.update(p, v, id)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
}
