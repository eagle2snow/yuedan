package com.hhs.base.dto;

/**
 * Description: 购物车结算对象
 */
public class CartDto {
    private Integer id;
    private Integer buyCount;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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
