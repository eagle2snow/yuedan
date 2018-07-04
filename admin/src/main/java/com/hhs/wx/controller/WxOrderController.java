package com.hhs.wx.controller;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhs.base.model.*;
import com.hhs.base.query.QueryObj;
import com.hhs.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hhs.base.dto.CartDto;
import com.hhs.base.dto.OrderItemDto;
import com.hhs.utils.StringUtil;

import static com.hhs.controllerUtil.WeiXin.getDBMember;

@Controller
@RequestMapping("wx/order")
public class WxOrderController {

    private static final Logger logger = LoggerFactory.getLogger(WxOrderController.class);

    @Resource
    private PayBillService payBillService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private OrderService orderService;
    @Resource
    private OrderItemService orderItemService;
    @Resource
    private MemberAddressService memberAddressService;

    private static final String PATH = "/wx/order/";

    // 查看订单
    @GetMapping("lookOrder/{orderId}")
    public String lookOrderView(@PathVariable Integer orderId, Model model)
    {
        Order order = orderService.get(orderId);
        if (order == null)
            return "error/404";

        BigDecimal sum = new BigDecimal(0);
        int itemSize = 0;
        List<OrderItem> items = orderItemService.listEq("order.id", order.getId());
        if (items == null)
            return "error/404";
        for (OrderItem item : items) {
            sum = sum.add(item.getOriginalPrice().multiply(new BigDecimal(item.getBuyCount())));
            itemSize += item.getBuyCount();
        }

        List<PayBill> bills = payBillService.listEq("orderNo", order.getOrderNo());
        if (bills == null || bills.size() != 1) {
            model.addAttribute("transactionId", "");
            model.addAttribute("reaFee", "");
        } else {
            model.addAttribute("transactionId", bills.get(0).getTransactionId());
            model.addAttribute("reaFee", bills.get(0).getReaFee());
        }

        model.addAttribute("items", items);
        model.addAttribute("itemSize", itemSize);
        model.addAttribute("order", order);
        model.addAttribute("sum", sum);
        BigDecimal discount = sum.subtract(bills.get(0).getReaFee());
        // BigDecimal discount = sum.subtract(order.getTotalMoney());
        model.addAttribute("discount", discount.compareTo(new BigDecimal(0)) < 0 ? 0 : discount);

        if (order.getCreateTime() != null)
            model.addAttribute("createTime",
                    order.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        else
            model.addAttribute("createTime", "");

        if (order.getPaymentTime() != null)
            model.addAttribute("paymentTime",
                    order.getPaymentTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        else
            model.addAttribute("paymentTime", "");

        return PATH + "lookOrder";
    }

    // 给我加急
    @ResponseBody
    @RequestMapping("urgent/{orderId}")
    public Map<String, Object> urgent(@PathVariable Integer orderId)
    {
        logger.info("urgent:method starting ~~~");

        HashMap<String, Object> map = new HashMap<>();
        Order order = orderService.get(orderId);
        if (!order.getStatus().equals("10")) {
            order.setStatus("11");// 加急
            orderService.update(order);
            map.put("status", 1);
            map.put("msg", "加急请求已送达，请耐心等候！");
        }
        logger.info("urgent:Order order = {}", JSON.toJSON(order.getId()));

        return map;
    }

    /**
     * @param orderId
     * @return
     * @throws
     * @Title: confirmGoods
     * @Description: 确定收货
     * @return: Map<String       ,       Object>
     */
    @ResponseBody
    @GetMapping("confirmGoods/{orderId}")
    public Map<String, Object> confirmGoods(@PathVariable Integer orderId)
    {
        HashMap<String, Object> map = new HashMap<>();
        try {
            orderService.confirmGoods(orderId);
            map.put("status", 1);
            map.put("msg", "确认收货成功");
        } catch (Exception e) {
            map.put("status", 2);
            map.put("msg", "系统正在维护");
            logger.error("confirmGoods:Error info is {}", e.getMessage());
        }
        logger.info("confirmGoods:The Map map = {}", JSON.toJSON(map));
        return map;
    }

    /**
     * @param orderId
     * @return
     * @throws
     * @Title: exitGoods
     * @Description:退货申请
     * @return: Map<String       ,       Object>
     */
    @ResponseBody
    @RequestMapping("exitGoods/{orderId}")
    public Map<String, Object> exitGoods(@PathVariable Integer orderId)
    {
        HashMap<String, Object> map = new HashMap<>();

        return map;
    }

    /**
     * @param orderId
     * @return
     * @throws
     * @Title: cancelOrder
     * @Description: 取消订单 物理删除库中订单信息
     * @return: Map<String       ,       Object>
     */
    @ResponseBody
    @GetMapping("cancelOrder/{orderId}")
    public Map<String, Object> cancelOrder(@PathVariable Integer orderId)
    {
        HashMap<String, Object> map = new HashMap<>();

        try {
            // 取消订单要加回商品数量
            Order order = orderService.get(orderId);
            if (order == null)
                throw new Exception("订单不存在");

            List<OrderItem> items = orderItemService.listEq("order.id", orderId);
            if (items != null) {
                for (OrderItem item : items) {
                    Commodity commodity = commodityService.get(item.getCommodity().getId());
                    if (commodity == null || commodity.getTotalStock() == null || item.getBuyCount() == null)
                        continue;
                    commodity.setTotalStock(commodity.getTotalStock() + item.getBuyCount());
                    commodityService.update(commodity);
                }
            }

            // 通过关联的实体删除实体
            orderItemService.deleteByParm("order.id", orderId, true);
            orderService.deleteById(orderId, true);
            map.put("status", 1);
            map.put("msg", "订单取消成功");

        } catch (Exception e) {
            map.put("status", 2);
            map.put("msg", "系统正在维护");
            logger.error("cancelOrder:Error info is {}", e.getMessage());

        }

        logger.error("cancelOrder:The Map map = {}", JSON.toJSON(map));
        return map;
    }

    /**
     * Description: 提交订单
     */
    @RequestMapping("/addOrder")
    @ResponseBody
    public Map<String, Object> addOrder(String cartsStr)
    {
        List<CartDto> carts = JSON.parseArray(cartsStr, CartDto.class);
        Member member = getDBMember();
        Map<String, Object> map = orderService.genOrder(member, carts);
        return map;
    }

    /**
     * Description: 确认订单
     * @param orderId   订单id
     * @param addressId 收货地址id
     * @param map
     */
    @SuppressWarnings("all")
    @RequestMapping("/confirmOrder/{orderId}")
    public String confirmOrder(@PathVariable Integer orderId, ModelMap map, String addressId)
    {
        Member member = getDBMember();
        Order order = orderService.get(orderId);
        if (!StringUtil.strNullOrEmpty(addressId)) {
            MemberAddress orderAddress = memberAddressService.get(Integer.parseInt(addressId));
            if (null != orderAddress) {
                order.setMemberAddress(orderAddress);
                orderService.update(order);
            }
        } else {
            if (null == order.getMemberAddress()) {
                MemberAddress orderAddress = memberAddressService.getMemberAddress(member.getId());
                if (null == orderAddress) {
                    List<MemberAddress> list = memberAddressService.listEq("member.id", member.getId());
                    if (list.size() > 0) {
                        orderAddress = list.get(list.size() - 1);
                    }
                }
                order.setMemberAddress(orderAddress);
                orderService.update(order);
            }
        }

        QueryObj queryObj = new QueryObj();
        queryObj.setReList("id")
                .setReList("name")
                .setReList("mobile")
                .setReList("pca")
                .setReList("address")
                .setReList("defaultAddress")
                .setEqMap("member.id", member.getId());
        List<Map<String, Object>> addressList = memberAddressService.pqList(queryObj);

        map.put("addressList", JSON.toJSON(addressList));
        map.put("order", JSON.toJSON(order));
        List<OrderItem> items = orderItemService.listEq("order.id", orderId);
        map.put("items", JSON.toJSON(items));
        map.put("path", PATH);
        map.put("orderId", orderId);
        if (null != order.getMemberAddress()) {
            map.put("orderAddressId", order.getMemberAddress().getId());
        }
        return PATH + "confirmOrder";
    }

    /**
     * Description:新增收货地址
     */
    @RequestMapping("/addAddress/{orderId}")
    public String addAddress(ModelMap map, @PathVariable Integer orderId)
    {
        map.put("path", PATH);
        map.put("orderId", orderId);
        return PATH + "addAddress";
    }

    @ResponseBody
    @RequestMapping("/addAddressAction")
    public Map<String, Object> addAddressAction(MemberAddress address, String defautlocal)
    {
        Map<String, Object> map = new HashMap<>();
        if (!StringUtil.isMobile(address.getMobile())) {
            map.put("addressId", 0);
            return map;
        }

        Member member = getDBMember();
        if ("on".equals(defautlocal)) {
            address.setDefaultAddress(1);
            memberAddressService.updateAddressId(member.getId());
        } else
            address.setDefaultAddress(2);

        address.setMember(member);
        Integer addressId = memberAddressService.saveReturnId(address);
        if (addressId > 0) {
            map.put("addressId", addressId);
        } else {
            map.put("addressId", 0);
        }
        return map;
    }

    /**
     * Description: 支付前检查
     * @param orderId   订单id
     * @param addressId 订单地址
     * @param content   订单备注
     */
    @RequestMapping("/prePayOrder")
    @ResponseBody
    public Map<String, Object> prePayOrder(Integer orderId, Integer addressId, String itemsStr, String content)
    {
        List<OrderItemDto> items = JSON.parseArray(itemsStr, OrderItemDto.class);
        Member member = getDBMember();
        Map<String, Object> map = orderService.prePayOrder(member, orderId, addressId, items, content);
        return map;
    }

    /**
     * 支付成功
     */
    @RequestMapping("/paySuccess")
    public String paySuccess(ModelMap map, Integer orderId, String amount)
    {
        logger.info("paySuccess:The args orderId={},amount={}", orderId, amount);

        Order order = orderService.getOne("id", orderId);

        PayBill payBill = payBillService.getOne("orderNo", order.getOrderNo());
        map.put("orderId", orderId);
        map.put("amount", payBill.getReaFee());
        map.put("path", PATH);

        return PATH + "paySuccess";
    }

    /**
     * 支付失败
     */
    @RequestMapping("/payFail")
    public String payFail(ModelMap map, Integer orderId)
    {
        map.put("orderId", orderId);
        map.put("path", PATH);
        return PATH + "payFail";
    }

    @RequestMapping("pushOrders")
    public String pushOrders(ModelMap map, Integer orderId)
    {
        map.put("orderId", orderId);
        map.put("path", PATH);
        return PATH + "pushOrders";
    }

}
