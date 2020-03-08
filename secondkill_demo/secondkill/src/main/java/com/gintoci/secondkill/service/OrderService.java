package com.gintoci.secondkill.service;

import com.gintoci.secondkill.error.BusinessException;
import com.gintoci.secondkill.service.model.OrderModel;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2020-03-07 17:16
 * @Created by gin
 */
public interface OrderService {

    //1.通过前端url传递promoId,后端再校验（一定要校验）是否属于对应商品且活动已开始（使用此方法）
    //2.直接在下单接口内判断对应商品是否存在秒杀活动，若存在进行中的则以秒杀价格下单
    OrderModel createOrder(Integer userId,Integer itemId,Integer promoId,Integer amount) throws BusinessException;
}
