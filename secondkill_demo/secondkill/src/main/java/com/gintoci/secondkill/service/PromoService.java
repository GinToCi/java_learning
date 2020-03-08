package com.gintoci.secondkill.service;

import com.gintoci.secondkill.service.model.PromoModel;

/**
 * @Classname PromoService
 * @Description TODO
 * @Date 2020-03-08 15:21
 * @Created by gin
 */
public interface PromoService {

    //根据itemId获得即将进行的秒杀活动或正在进行的秒杀活动
    PromoModel getPromoByItemId(Integer itemId);
}
