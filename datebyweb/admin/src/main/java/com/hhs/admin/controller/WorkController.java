package com.hhs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.Work;
import com.hhs.service.WorkService;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin/work/")
public class WorkController {

	private final static String path = "admin/work/";

	@Resource
    private WorkService workService;
	

	@RequestMapping("add.htm")
	@RequiresPermissions("admin:work:add")
	public String addView(ModelMap map)
	{
		map.put("path", path);
		
		return path + "add";
	}

	@RequiresPermissions("admin:work:add")
	@ResponseBody
	@RequestMapping("add.json")
	public Map<String, Object> addAction(Work model)
	{
		Map<String, Object> map = new HashMap<>();
		if (workService.save(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
	
	@RequiresPermissions("admin:work:update")
	@RequestMapping("update/{id}.htm")
	public String updateView(@PathVariable Integer id, ModelMap map)
	{
		Work model = workService.get(id);
		map.put("path", path);
		map.put("model", model);
		
		return path + "update";
	}

	@RequiresPermissions("admin:work:update")
	@RequestMapping("update.json")
	@ResponseBody
	public Map<String, Object> updateAction(Work model)
	{
		Map<String, Object> map = new HashMap<>();
		if (workService.update(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("admin:work:show")
	@RequestMapping("show/{id}.htm")
	public String showView(@PathVariable Integer id, ModelMap map)
	{
		Work model = workService.get(id);
		map.put("model", model);
		map.put("path", path);
		return path + "show";
	}
	
	@RequiresPermissions("admin:work:show")
	@RequestMapping("list/{pageIndex}/{pageSize}.htm")
	public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize,String k)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(Work.class);
		if (!StringUtil.strNullOrEmpty(k)) {
			dc.add(Restrictions.ilike("name", k.trim(),MatchMode.ANYWHERE));
		}
		Page<Work> list = workService.list(dc, pageIndex, pageSize);
		map.put("page", list);
		map.put("path", path);
		map.put("key", k);
		return path + "list";
	}

	@RequiresPermissions("admin:work:delete")
	@RequestMapping("deleteById/{id}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable Integer id)
	{
		Map<String, Object> map = new HashMap<>();
		if (workService.deleteById(id, false)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("admin:work:delete")
	@RequestMapping("deleteByIds/{ids}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable String ids)
	{
		Map<String, Object> map = new HashMap<>();
		List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
    	if (workService.deleteByIds(arrayId, false)) {
    		map.put("status", "ok");
    	} else {
    		map.put("status", "no");
    	}
    	return map;
    }

    @RequiresPermissions("admin:work:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
	{
        Map<String, Object> map = new HashMap<>();
		if (workService.update(p, v, id)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
}
