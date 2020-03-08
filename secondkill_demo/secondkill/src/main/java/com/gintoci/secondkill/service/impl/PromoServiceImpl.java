package com.gintoci.secondkill.service.impl;

import com.gintoci.secondkill.dao.PromoDOMapper;
import com.gintoci.secondkill.dataobject.PromoDO;
import com.gintoci.secondkill.service.PromoService;
import com.gintoci.secondkill.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Classname PromoServiceImpl
 * @Description TODO
 * @Date 2020-03-08 15:22
 * @Created by gin
 */
@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);

        //转化DO->Model
        PromoModel promoModel = convertModelFromDO(promoDO);
        if (promoModel == null){
            return null;
        }

        //判断当前时间秒杀活动是否即将开始或正在进行
        DateTime now = new DateTime();
        if (promoModel.getStartTime().isAfter(now)){
            promoModel.setStatus(1);
        }else if (promoModel.getEndTime().isBefore(now)){
            promoModel.setStatus(3);
        }else {
            promoModel.setStatus(2);
        }

        return promoModel;
    }

    private PromoModel convertModelFromDO(PromoDO promoDO){
        if (promoDO == null){
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO,promoModel);
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
        promoModel.setStartTime(new DateTime(promoDO.getStartTime()));
        promoModel.setEndTime(new DateTime(promoDO.getEndTime() ));

        return promoModel;
    }
}
