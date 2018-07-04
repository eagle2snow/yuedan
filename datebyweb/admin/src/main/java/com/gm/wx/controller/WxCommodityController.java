package com.gm.wx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gm.service.CartService;
import com.gm.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gm.base.model.Cart;
import com.gm.base.model.Commodity;
import com.gm.base.model.Member;
import com.gm.utils.DateUtil;

import static com.gm.controllerUtil.Common.getRequest;
import static com.gm.controllerUtil.WeiXin.getDBMember;
import static com.gm.controllerUtil.WeiXin.getSessionMember;

/**
 * Description: 微信商品
 */
@Controller
@RequestMapping("/wx/commodity")
public class WxCommodityController {

    protected Logger logger = LoggerFactory.getLogger(WxCommodityController.class);

    @Resource
    private CommodityService commodityService;
    @Resource
    private CartService cartService;

    private static final String PATH = "/wx/commodity/";

    /**
     * 商品详情
     */
    @RequestMapping("/commodityDetail/{id}")
    public String commodityDetail(ModelMap map, @PathVariable Integer id)
    {

        Commodity commodity = commodityService.get(id);
        logger.info("commodityDetail:The Commodity to json is {}", JSON.toJSON(commodity.getName()));
        if (!StringUtils.isEmpty(commodity.getBrowse())) {
            commodity.setBrowse(commodity.getBrowse() + 1);
        } else {
            commodity.setBrowse(1);
        }
        commodityService.update(commodity);
        map.put("model", commodity);
        map.put("member", getDBMember());
        map.put("date", DateUtil.dateToStr(new Date(), 12));
        map.put("path", PATH);

        return PATH + "commodityDetail";
    }

    @RequestMapping("/addToCart/{commodityId}/{count}")
    @ResponseBody
    public Map<String, Object> addToCart(@PathVariable Integer commodityId, @PathVariable Integer count)
    {
        Map<String, Object> map = new HashMap<>();
        Member member = getDBMember();
        getRequest().getSession().setAttribute("curMember", member);
        Cart cart = cartService.checkCommodityInCart(member.getId(), commodityId);
        if (cart != null) {
            cart.setBuyCount(cart.getBuyCount() + 1);
            cartService.update(cart);
            map.put("s", "ok");
        } else {
            cart = new Cart();
            cart.setMember(member);
            cart.setBuyCount(count);
            cart.setCommodity(commodityService.get(commodityId));
            if (cartService.save(cart)) {
                map.put("s", "ok");
            } else {
                map.put("s", "no");
            }
        }
        return map;
    }

    /**
     * 查看购物车
     */
    @RequestMapping("/showCart")
    public String showCart(ModelMap map)
    {
        List<Cart> carts = cartService.listEq("member.id", getSessionMember().getId());
        /*
         * BigDecimal total = carts.parallelStream().peek(p -> p.setHad(true)).map(p ->
         * { return
         * p.getCommodity().getShowPrice().multiply(BigDecimal.valueOf(p.getBuyCount()))
         * ; }).reduce(BigDecimal.ZERO, BigDecimal::add); map.put("total", total);
         */
        carts.parallelStream().forEach(p -> p.setHad(true));
        map.put("carts", JSON.toJSONString(carts));

        map.put("path", PATH);
        return PATH + "cart";
    }

    /**
     * 更新购物车购买数量
     */
    @RequestMapping("/updateCart/{cartId}/{count}")
    @ResponseBody
    public Map<String, Object> updateCart(@PathVariable Integer cartId, @PathVariable Integer count)
    {
        Map<String, Object> map = new HashMap<>();
        Cart cart = cartService.get(cartId);
        if (cart.getCommodity().getTotalStock() < count) {
            map.put("s", -1);
        } else {
            cart.setBuyCount(count);
            cartService.update(cart);
            map.put("s", 1);
        }
        return map;
    }

    /**
     * 结算
     */
    @RequestMapping("/sett")
    public String sett(ModelMap map)
    {
        map.put("path", PATH);
        return PATH + "confirmOrder";
    }

}
