package com.gintoci.secondkill.service.model;

import java.math.BigDecimal;

/**
 * @Classname OrderModel
 * @Description TODO
 * @Date 2020-03-07 16:55
 * @Created by gin
 */
//用户下单的交易模型
public class OrderModel {
    //企业级订单的id一般为String类型，如20200307xxxxxxx
    private String id;
    //购买用户id
    private Integer userId;
    //购买商品id
    private Integer itemId;
    //若非空 则表示以秒杀价格下单
    private Integer promoId;
    //购买商品单价 若promoId非空，则表示秒杀价格
    private BigDecimal itemPrice;
    //购买数量
    private Integer amount;
    //购买金额 若promoId非空，则表示秒杀价格
    private BigDecimal orderPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}
