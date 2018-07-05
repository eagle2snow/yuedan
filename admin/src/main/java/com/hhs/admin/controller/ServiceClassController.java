package com.hhs.admin.controller;

import com.hhs.base.model.ServiceClass;
import com.hhs.base.query.Page;
import com.hhs.service.ClassifyService;
import com.hhs.service.ServiceClassService;
import com.hhs.utils.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/serviceclass/")
public class ServiceClassController {

	private final static String path = "admin/serviceclass/";

	@Resource
    private ServiceClassService serviceClassService;
	@Resource
    private ClassifyService classifyService;


	@RequestMapping("add.htm")
	@RequiresPermissions("admin:serviceclass:add")
	public String addView(ModelMap map)
	{
		map.put("path", path);
		map.put("classifyList",classifyService.list());
		return path + "add";
	}

	@RequiresPermissions("admin:serviceclass:add")
	@ResponseBody
	@RequestMapping("add.json")
	public Map<String, Object> addAction(ServiceClass model)
	{
		Map<String, Object> map = new HashMap<>();
		if (serviceClassService.save(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
	
	@RequiresPermissions("admin:serviceclass:update")
	@RequestMapping("update/{id}.htm")
	public String updateView(@PathVariable Integer id, ModelMap map)
	{
		ServiceClass model = serviceClassService.get(id);
		map.put("path", path);
		map.put("model", model);
		map.put("classifyList",classifyService.list());
		return path + "update";
	}

	@RequiresPermissions("admin:serviceclass:update")
	@RequestMapping("update.json")
	@ResponseBody
	public Map<String, Object> updateAction(ServiceClass model)
	{
		Map<String, Object> map = new HashMap<>();
		if (serviceClassService.update(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("admin:serviceclass:show")
	@RequestMapping("show/{id}.htm")
	public String showView(@PathVariable Integer id, ModelMap map)
	{
		ServiceClass model = serviceClassService.get(id);
		map.put("model", model);
		map.put("path", path);
		return path + "show";
	}
	
	@RequiresPermissions("admin:serviceclass:show")
	@RequestMapping("list/{pageIndex}/{pageSize}.htm")
	public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize,String k)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(ServiceClass.class);
		if (!StringUtil.strNullOrEmpty(k)) {
			dc.add(Restrictions.ilike("name", k.trim(),MatchMode.ANYWHERE));
		}
		Page<ServiceClass> list = serviceClassService.list(dc, pageIndex, pageSize);
		map.put("page", list);
		map.put("path", path);
		map.put("key", k);
		return path + "list";
	}

	@RequiresPermissions("admin:serviceclass:delete")
	@RequestMapping("deleteById/{id}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable Integer id)
	{
		Map<String, Object> map = new HashMap<>();
		if (serviceClassService.deleteById(id, false)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("admin:serviceclass:delete")
	@RequestMapping("deleteByIds/{ids}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable String ids)
	{
		Map<String, Object> map = new HashMap<>();
		List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
    	if (serviceClassService.deleteByIds(arrayId, false)) {
    		map.put("status", "ok");
    	} else {
    		map.put("status", "no");
    	}
    	return map;
    }

    @RequiresPermissions("admin:serviceclass:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
	{
        Map<String, Object> map = new HashMap<>();
		if (serviceClassService.update(p, v, id)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
}
