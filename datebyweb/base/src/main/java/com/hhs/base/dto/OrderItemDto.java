package com.hhs.base.dto;

/**
 * Description: 订单项传输对象
 */
public class OrderItemDto {
    private Integer orderItemId; // 订单项id
    private Integer orderId; // 订单id
    private Integer commodityId;// 商品id
    private Integer buyCount;// 购买数量

    public Integer getOrderItemId()
    {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId)
    {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }

    public Integer getCommodityId()
    {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId)
    {
        this.commodityId = commodityId;
    }

    public Integer getBuyCount()
    {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount)
    {
        this.buyCount = buyCount;
    }

}
