package ${package};

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

import ${entityPackage};
import ${servicePackage}.${entitySimpleName}Service;
import com.gm.base.query.Page;
import com.gm.utils.StringUtil;

@Controller
@RequestMapping("/${path}")
public class ${controllerName}Controller {

	private final static String path = "${path}";

	@Resource
    private ${entitySimpleName}Service ${entityName}Service;
	${services}

	@RequestMapping("add.htm")
	@RequiresPermissions("${addPerm}")
	public String addView(ModelMap map)
	{
		map.put("path", path);
		${addMap}
		return path + "add";
	}

	@RequiresPermissions("${addPerm}")
	@ResponseBody
	@RequestMapping("add.json")
	public Map<String, Object> addAction(${entitySimpleName} model)
	{
		Map<String, Object> map = new HashMap<>();
		if (${entityName}Service.save(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
	
	@RequiresPermissions("${updatePerm}")
	@RequestMapping("update/{id}.htm")
	public String updateView(@PathVariable Integer id, ModelMap map)
	{
		${entitySimpleName} model = ${entityName}Service.get(id);
		map.put("path", path);
		map.put("model", model);
		${addMap}
		return path + "update";
	}

	@RequiresPermissions("${updatePerm}")
	@RequestMapping("update.json")
	@ResponseBody
	public Map<String, Object> updateAction(${entitySimpleName} model)
	{
		Map<String, Object> map = new HashMap<>();
		if (${entityName}Service.update(model)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("${showPerm}")
	@RequestMapping("show/{id}.htm")
	public String showView(@PathVariable Integer id, ModelMap map)
	{
		${entitySimpleName} model = ${entityName}Service.get(id);
		map.put("model", model);
		map.put("path", path);
		return path + "show";
	}
	
	@RequiresPermissions("${showPerm}")
	@RequestMapping("list/{pageIndex}/{pageSize}.htm")
	public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize,String k)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(${entitySimpleName}.class);
		if (!StringUtil.strNullOrEmpty(k)) {
			dc.add(Restrictions.ilike("name", k.trim(),MatchMode.ANYWHERE));
		}
		Page<${entitySimpleName}> list = ${entityName}Service.list(dc, pageIndex, pageSize);
		map.put("page", list);
		map.put("path", path);
		map.put("key", k);
		return path + "list";
	}

	@RequiresPermissions("${deletePerm}")
	@RequestMapping("deleteById/{id}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable Integer id)
	{
		Map<String, Object> map = new HashMap<>();
		if (${entityName}Service.deleteById(id, false)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}

	@RequiresPermissions("${deletePerm}")
	@RequestMapping("deleteByIds/{ids}.json")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable String ids)
	{
		Map<String, Object> map = new HashMap<>();
		List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
    	if (${entityName}Service.deleteByIds(arrayId, false)) {
    		map.put("status", "ok");
    	} else {
    		map.put("status", "no");
    	}
    	return map;
    }

    @RequiresPermissions("${updatePerm}")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
	{
        Map<String, Object> map = new HashMap<>();
		if (${entityName}Service.update(p, v, id)) {
			map.put("status", "ok");
		} else {
			map.put("status", "no");
		}
		return map;
	}
}
