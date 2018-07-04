package com.gm.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gm.service.*;
import com.gm.service.sys.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.base.model.CommodityEvaluation;
import com.gm.base.query.Page;
import com.gm.utils.StringUtil;

@Controller
@RequestMapping("/admin/commodityevaluation/")
public class AdminCommodityEvaluationController {

    private final static String path = "admin/commodityevaluation/";

    @Resource
    private CommodityEvaluationService commodityEvaluationService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private MemberService memberService;
    @Resource
    private CommodityAppraiseService commodityAppraiseService;
    @Resource
    private UserService userService;
    @Resource
    private OrderItemService orderItemService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:commodityevaluation:add")
    public String addView(ModelMap map)
    {
        map.put("path", path);
        map.put("commodityList", commodityService.list());
        map.put("memberList", memberService.list());
        map.put("commodityAppraiseList", commodityAppraiseService.list());
        map.put("userList", userService.list());
        map.put("orderItemList", orderItemService.list());
        return path + "add";
    }


    @RequiresPermissions("admin:commodityevaluation:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(CommodityEvaluation model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityEvaluationService.save(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityevaluation:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map)
    {
        CommodityEvaluation model = commodityEvaluationService.get(id);
        map.put("path", path);
        map.put("model", model);
        map.put("commodityList", commodityService.list());
        map.put("memberList", memberService.list());
        map.put("commodityAppraiseList", commodityAppraiseService.list());
        map.put("userList", userService.list());
        map.put("orderItemList", orderItemService.list());
        return path + "update";
    }


    @RequiresPermissions("admin:commodityevaluation:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(CommodityEvaluation model)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityEvaluationService.update(model)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityevaluation:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        CommodityEvaluation model = commodityEvaluationService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }


    @RequiresPermissions("admin:commodityevaluation:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(CommodityEvaluation.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<CommodityEvaluation> list = commodityEvaluationService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }


    @RequiresPermissions("admin:commodityevaluation:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityEvaluationService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }


    @RequiresPermissions("admin:commodityevaluation:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (commodityEvaluationService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:commodityevaluation:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (commodityEvaluationService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
