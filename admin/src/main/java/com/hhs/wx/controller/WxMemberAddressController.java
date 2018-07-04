package com.hhs.wx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.hhs.service.MemberAddressService;
import com.hhs.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hhs.base.model.Member;
import com.hhs.base.model.MemberAddress;

import javax.annotation.Resource;

import static com.hhs.controllerUtil.WeiXin.getDBMember;
import static com.hhs.controllerUtil.WeiXin.getSessionMember;

@Controller
@RequestMapping("wx/myCenter")
public class WxMemberAddressController {

    private static final Logger logger = LoggerFactory.getLogger(WxMemberAddressController.class);
    private static final String PATH = "wx/myCenter/";

    @Resource
    private MemberAddressService memberAddressService;

    @RequestMapping("shippingAddress")
    public String shippingAddressView(ModelMap model)
    {
        Integer id = getSessionMember().getId();
        List<MemberAddress> list = memberAddressService.listEq("member.id", id);
        model.put("list", list);
        model.put("path", PATH);
        return PATH + "shippingAddress";
    }

    @ResponseBody
    @RequestMapping("editDefaultAddress/{addrId}")
    public Map<String, Object> editDefaultAddressAction(@PathVariable Integer addrId)
    {
        Member member = getDBMember();

        HashMap<String, Object> map = new HashMap<>();
        MemberAddress address = memberAddressService.get(addrId);
        if (!address.getMember().getId().equals(member.getId())) {
            logger.error("!address.getMember().getId().equals(member.getId())");
            return map;
        }
        logger.info("editDefaultAddressAction: the MemberAddress to json is {}.", JSON.toJSONString(address));

        List<MemberAddress> list = memberAddressService.list();
        logger.info("editDefaultAddress: the List<MemberAddress> to json is {}.", JSON.toJSONString(list));

        memberAddressService.setDefault(member.getId());
        boolean b = memberAddressService.setAddress(addrId);
        if (b)
            map.put("msg", "ok");
        else
            map.put("msg", "no");
        return map;
    }

    @RequestMapping("addAddress")
    public String addAddressView(ModelMap model)
    {
        model.put("path", PATH);

        return PATH + "addAddress";

    }

    @ResponseBody
    @RequestMapping("/addAddressAction")
    public Map<String, Object> addAddressAction(MemberAddress address, String defautlocal)
    {
        logger.info("addAddressAction: the MemberAddress to json is {} and defaultlocal is {}.",
                JSON.toJSONString(address), defautlocal);

        Map<String, Object> map = new HashMap<>();

        if (!StringUtil.isMobile(address.getMobile())) {
            map.put("addressId", 0);
            map.put("msg", "no");
            return map;
        }

        Member member = getDBMember();
        logger.info("addAddressAction: the Member to json is {}.", JSON.toJSONString(member));

        if ("on".equals(defautlocal)) {
            address.setDefaultAddress(1);
            boolean updateByHql = memberAddressService.updateAddressId(member.getId());
            logger.info("addAddressAction: the updateByHql is {}.", JSON.toJSONString(updateByHql));
        } else
            address.setDefaultAddress(2);
        address.setMember(member);
        Integer addressId = memberAddressService.saveReturnId(address);
        if (addressId > 0) {
            map.put("memberId", member.getId());
            map.put("msg", "ok");
        } else {
            map.put("addressId", 0);
            map.put("msg", "no");
        }
        return map;
    }

    @RequestMapping("/editAddressView/{addrId}")
    public String editAddressView(@PathVariable Integer addrId, ModelMap map)
    {
        logger.info("editAddressView: the arges is {}.", addrId);

        MemberAddress memberAddress = memberAddressService.get(addrId);
        logger.info("editAddressView: the MemberAddress to json is {}.",
                JSON.toJSONString(memberAddress));

        if (null != memberAddress) {
            map.put("model", memberAddress);
            map.put("path", PATH);

        }

        return PATH + "editAddress";
    }

    @ResponseBody
    @RequestMapping("/deleteAddressView/{addrId}")
    public Map<String, Object> deleteAddressView(@PathVariable Integer addrId)
    {
        logger.info("deleteAddressView: the arges is {}.", addrId);

        HashMap<String, Object> map = new HashMap<>();

        if (memberAddressService.deleteById(addrId, false)) {
            logger.info("deleteAddressView: Has it been deleted? is {}.", memberAddressService.deleteById(addrId, false));
            map.put("msg", "ok");

        } else {
            logger.info("deleteAddressView: Has it been deleted? is {}.", memberAddressService.deleteById(addrId, false));
            map.put("msg", "no");

        }
        map.put("path", PATH);

        return map;
    }

    @ResponseBody
    @RequestMapping("/editAddressAction")
    public Map<String, Object> editAddressAction(String defautlocal, MemberAddress address)
    {
        logger.info("editAddressAction: the addrId is {} and defaultlocal is {}.",
                defautlocal);

        Map<String, Object> map = new HashMap<>();

        if (!StringUtil.isMobile(address.getMobile())) {
            map.put("msg", "no");
            return map;
        }

        if ("on".equals(defautlocal)) {
            address.setDefaultAddress(1);
        } else {
            address.setDefaultAddress(2);

        }

        if (memberAddressService.update(address)) {
            map.put("msg", "ok");
        } else {
            map.put("msg", "no");
        }

        return map;
    }

}
