package com.gm.wx.controller;

import java.io.File;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.gm.base.model.*;
import com.gm.service.CommodityService;
import com.gm.service.OrderItemService;
import com.gm.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.gm.service.CommodityAppraiseService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import static com.gm.controllerUtil.WeiXin.getDBMember;
import static com.gm.controllerUtil.WeiXin.getSessionMember;

@Controller
@RequestMapping("wx/comments/")
public class WxCommodityCommentsController {

    private static final Logger logger = LoggerFactory.getLogger(WxCommodityCommentsController.class);
    private static final String PATH = "wx/comments/";

    @Resource
    private OrderItemService itemService;

    @Resource
    private CommodityAppraiseService appraiseService;


    @Resource
    private CommodityAppraiseService appraiseServiceImpl;

    @Resource
    private OrderService orderService;

    @Resource
    private CommodityService commodityService;

    /**
     * @return String
     * @Title: commentSucceedView
     * @Description: 提交评价成功页面
     */
    @RequestMapping("commentSucceed")
    public String commentSucceedView()
    {
        return PATH + "commentSucceed";
    }

    /**
     * @param map
     * @return String
     * @Title: commentFailureView
     * @Description: 提交评价失败页面
     */
    @RequestMapping("commentFailure/{orderId}")
    public String commentFailureView(@PathVariable String orderId, ModelMap map)
    {

        map.put("orderId", orderId);

        return PATH + "commentFailure";
    }

    /**
     * @param map
     * @param orderId
     * @return String
     * @Title: toCommondityComment
     * @Description: 去评价页面并显示商品图片
     */
    @RequestMapping("toCommondityComment/{orderId}")
    public String toCommondityComment(ModelMap map, @PathVariable Integer orderId)
    {

        if (null == orderId) {
            logger.error("toCommondityComment:the args orderId = null");

            return "error/403";

        }

        Order order = orderService.get(orderId);
        if (null != order) {
            order.setAppraiseTime(new Date());
            order.setAppraise(1);
        }

        // List<OrderItem> orderItems = itemService.listEq("order.id", orderId);
        OrderItem orderItems = itemService.getOne("id", orderId);

        map.put("orderItems", orderItems);
        map.put("orderId", orderId);
        map.put("path", PATH);


        return PATH + "commodityComments";
    }

    @RequestMapping(value = "/confirmComments", method = RequestMethod.POST)
    @ResponseBody
    public String confirmComments(HttpServletRequest request, String xx, String text, Integer commodityid, Integer orderid)
    {
        if (!(request instanceof AbstractMultipartHttpServletRequest))
            return "no";

        OrderItem orderItem = itemService.getOne("id", orderid);
        if ("1".equals(orderItem.getAppraise()))
            return "no";

        Commodity commodity = commodityService.get(commodityid);
        Order order = orderService.get(orderItem.getOrder().getId());
        Member member = getDBMember();

        if (!member.getId().equals(order.getMember().getId())) {
            logger.error("!curMember.getId().equals(order.getMember().getId())");
            return "no";
        }

        AbstractMultipartHttpServletRequest req = (AbstractMultipartHttpServletRequest)request;
        Map<String, MultipartFile> fileMap = req.getFileMap();
        int i = 1;
        if (fileMap.entrySet().size() > 5) {
            logger.error("fileMap.entrySet().size() > 5");
            return "no";
        }
        for (Map.Entry<String, MultipartFile> file : fileMap.entrySet()) {
            MultipartFile value = file.getValue();
            String fileName;
            if (File.separator.equals("/"))
                fileName = "/usr/static/comment/" + order.getId() + "_" + i;
            else
                fileName = "D://123" + i++ + ".pic"; // windows 测试用
            File newFile = new File(fileName);
            try {
                value.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        CommodityAppraise t = new CommodityAppraise();
        t.setContent(text);
        t.setStarLevel(xx);
        t.setOrderItem(orderItem);
        t.setMember(member);
        t.setCommodity(commodity);

        if (appraiseService.save(t)) {
            if (commodity.getComment() != null)
                commodity.setComment(commodity.getComment() + 1);
            else
                commodity.setComment(1);
            commodityService.update(commodity);
            orderItem.setAppraise("1");
            itemService.update(orderItem);
            return "ok";
        } else {
            return "no";
        }
    }

    @RequestMapping("myComments")
    public String myComments(ModelMap map)
    {
        map.put("model", appraiseServiceImpl.listEq("openId", getSessionMember().getId()));
        map.put("member", getSessionMember().getId());
        map.put("path", PATH);
        logger.info("商品评论列表 {}.", JSON.toJSONString(appraiseServiceImpl.listEq("openId", getSessionMember().getId())));
        return PATH + "myComments";
    }

    /**
     * <p>Description:查看全部评论</p>
     */
    @RequestMapping("allComments/{type}")
    public String allComments(ModelMap map, @PathVariable Integer type)
    {
        map.put("model", appraiseService.listEqDc("commodity.id", type, "createTime", "desc"));
        map.put("path", PATH);
        map.put("cid", type);

        return PATH + "allComments";
    }
}
