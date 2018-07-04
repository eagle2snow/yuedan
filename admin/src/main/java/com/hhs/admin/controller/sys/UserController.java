package com.hhs.admin.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.hhs.base.query.QueryObj;
import com.hhs.service.sys.ResService;
import com.hhs.service.sys.UserResService;
import com.hhs.service.sys.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.sys.Res;
import com.hhs.base.model.sys.User;
import com.hhs.base.model.sys.UserRes;
import com.hhs.base.query.Page;
import com.hhs.utils.StringUtil;

/**
 * 后台用户操作
 *
 * @author Guet
 */
@Controller
@RequestMapping("/admin/sys/user/")
public class UserController {

    private final static String path = "admin/sys/user/";

    @Resource
    private UserService userService;
    @Resource
    private ResService resService;

    @Resource
    private UserResService userResService;

    @RequestMapping("add.htm")
    @RequiresPermissions("admin:sys:user:add")
    public String addView(ModelMap map)
    {
        List<Res> ress = resService.list();
        ress.remove(0);
        StringBuffer sb = new StringBuffer();
        String zNodes = "";
        for (int i = 0; i < ress.size(); i++) {
            zNodes = "{id:" + ress.get(i).getId() + ", pId:" + ress.get(i).getParent().getId() + ", name:\""
                    + ress.get(i).getName() + "\",open:true}," + "\n";
            sb.append(zNodes);
        }
        zNodes = sb.toString();

        map.put("zNodes", zNodes);
        map.put("path", path);
        return path + "add";
    }

    @RequiresPermissions("admin:sys:user:add")
    @ResponseBody
    @RequestMapping("add.json")
    public Map<String, Object> addAction(User model, String resStr)
    {
        Map<String, Object> map = new HashMap<>();
        boolean a = userService.exist("username", model.getUsername());
        if (a) {
            map.put("status", "添加失败，已存在此用户名的管理员");
            return map;
        } else if (userService.exist("mobile", model.getMobile())) {
            map.put("status", "添加失败，已存在此手机号的管理员");
            return map;
        }

        Integer id = userService.saveReturnId(model);
        if (id > 0) {
            if (!StringUtil.strNullOrEmpty(resStr)) {
                model.setId(id);
                String[] permissionId = resStr.split(",");
                for (int i = 0; i < permissionId.length; i++) {
                    UserRes userRes = new UserRes();
                    Res res = new Res();
                    res.setId(Integer.valueOf(permissionId[i]));
                    userRes.setUser(model);
                    userRes.setRes(res);
                    userResService.save(userRes);
                }
            }
            map.put("status", "ok");
            return map;
        } else {
            map.put("status", "no");
            return map;
        }
    }

    @RequiresPermissions("admin:sys:user:update")
    @RequestMapping("update/{id}.htm")
    public String updateView(@PathVariable Integer id, ModelMap map, HttpServletRequest request)
    {
        User model = userService.get(id);

        if ("admin".equals(model.getUsername())) {
            map.put("path", path);
            map.put("model", model);
            return path + "update_admin";
        }

        List<String> ress = (List<String>) request.getSession().getAttribute("ress");

        if (ress.contains("admin:user:setRes")) {
            List<Res> permissionList = resService.list();
            permissionList.remove(0);
            StringBuffer sb = new StringBuffer();
            String zNodes = "";
            List<UserRes> userPermissions = userResService.listEq("user.id", id);
            String checked = "false";
            for (int i = 0; i < userPermissions.size(); i++) {
                for (int j = 0; j < permissionList.size(); j++) {
                    if (permissionList.get(j).getId() == userPermissions.get(i).getRes().getId()) {
                        permissionList.get(j).setHad(true);
                    }
                }
            }
            for (int i = 0; i < permissionList.size(); i++) {
                if (permissionList.get(i).isHad() == true) {
                    checked = "true";
                }
                zNodes = "{id:" + permissionList.get(i).getId() + ", pId:" + permissionList.get(i).getParent().getId()
                        + ", name:\"" + permissionList.get(i).getName() + "\", checked:" + checked + ",open:true},"
                        + "\n";
                sb.append(zNodes);
                checked = "false";
            }
            zNodes = sb.toString();
            map.put("zNodes", zNodes);
            map.put("path", path);
            map.put("model", model);

            return path + "update";
        } else {
            map.put("path", path);
            map.put("model", model);
            return path + "update_noRest";
        }
    }

    private boolean checkUserNameAndMobile(Map<String, Object> map, User user)
    {
        QueryObj queryObj = new QueryObj();
        queryObj.setEqMap("mobile", user.getMobile()).setNeMap("id", user.getId());
        List<User> list = userService.list(queryObj);

        if (!list.isEmpty()) {
            map.put("status", "此手机号已存在");
            return false;
        }

        queryObj = new QueryObj();
        queryObj.setEqMap("username", user.getUsername()).setNeMap("id", user.getId());

        List<User> list1 = userService.list(queryObj);
        if (!list1.isEmpty()) {
            map.put("status", "用户名已存在");
            return false;
        }

        return true;

//        List<User> userMobile = userService.listEq("mobile", user.getMobile());
//        if (userMobile.size() > 1) {
//            for (int i = 0; i < userMobile.size(); ++i) {
//                User one = userMobile.get(i);
//                if (!one.getId().equals(user.getId())) {
//                    map.put("status", "此手机号已存在");
//                    return false;
//                }
//            }
//        }
//
//        List<User> userName = userService.listEq("username", user.getUsername());
//        if (userName.size() > 1) {
//            for (int i = 0; i < userName.size(); ++i) {
//                User one = userName.get(i);
//                if (!one.getId().equals(user.getId())) {
//                    map.put("status", "用户名已存在");
//                    return false;
//                }
//            }
//        }
//        return true;
    }

    @RequiresPermissions("admin:sys:user:update")
    @RequestMapping("update.json")
    @ResponseBody
    public Map<String, Object> updateAction(User myself, String resStr, String newPass)
    {
        Map<String, Object> map = new HashMap<>();

        if (!checkUserNameAndMobile(map, myself))
            return map;

        if (!StringUtil.strNullOrEmpty(newPass)) {
            myself.setPassword(newPass);
        }

        if (userService.update(myself)) {
            userResService.deleteByParm("user.id", myself.getId(), true);
            if (!StringUtil.strNullOrEmpty(resStr)) {
                String[] permissionId = resStr.split(",");
                for (int i = 0; i < permissionId.length; i++) {
                    UserRes userRes = new UserRes();
                    Res res = new Res();
                    res.setId(Integer.valueOf(permissionId[i]));
                    userRes.setUser(myself);
                    userRes.setRes(res);
                    userResService.save(userRes);
                }
            }
            map.put("status", "ok");
            return map;
        } else {
            map.put("status", "no");
            return map;
        }
    }

    @RequiresPermissions("admin:sys:user:update")
    @RequestMapping("updateNoRes.json")
    @ResponseBody
    public Map<String, Object> updateNoResAction(User myself, String resStr, String newPass)
    {
        Map<String, Object> map = new HashMap<>();

        if (!checkUserNameAndMobile(map, myself))
            return map;

        if (!StringUtil.strNullOrEmpty(newPass)) {
            myself.setPassword(newPass);
        }

        if (userService.update(myself)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:sys:user:show")
    @RequestMapping("show/{id}.htm")
    public String showView(@PathVariable Integer id, ModelMap map)
    {
        User model = userService.get(id);
        map.put("model", model);
        map.put("path", path);
        return path + "show";
    }

    @RequiresPermissions("admin:sys:user:show")
    @RequestMapping("list/{pageIndex}/{pageSize}.htm")
    public String manager(ModelMap map, @PathVariable Integer pageIndex, @PathVariable Integer pageSize, String k)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        if (!StringUtil.strNullOrEmpty(k)) {
            dc.add(Restrictions.ilike("name", k.trim(), MatchMode.ANYWHERE));
        }
        Page<User> list = userService.list(dc, pageIndex, pageSize);
        map.put("page", list);
        map.put("path", path);
        map.put("key", k);
        return path + "list";
    }

    @RequiresPermissions("admin:sys:user:delete")
    @RequestMapping("deleteById/{id}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (userService.deleteById(id, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:sys:user:delete")
    @RequestMapping("deleteByIds/{ids}.json")
    @ResponseBody
    public Map<String, Object> delete(@PathVariable String ids)
    {
        Map<String, Object> map = new HashMap<>();
        List<Integer> arrayId = StringUtil.splitToInt(ids, ",");
        if (userService.deleteByIds(arrayId, false)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

    @RequiresPermissions("admin:sys:user:update")
    @RequestMapping("updatePVById/{p}/{v}/{id}.json")
    @ResponseBody
    public Map<String, Object> updatePVById(@PathVariable String p, @PathVariable Integer v, @PathVariable Integer id)
    {
        Map<String, Object> map = new HashMap<>();
        if (userService.update(p, v, id)) {
            map.put("status", "ok");
        } else {
            map.put("status", "no");
        }
        return map;
    }

}
