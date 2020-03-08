package com.gintoci.secondkill.service;

import com.gintoci.secondkill.error.BusinessException;
import com.gintoci.secondkill.service.model.ItemModel;

import java.util.List;

/**
 * @Classname ItemService
 * @Description TODO
 * @Date 2020-03-05 23:31
 * @Created by gin
 */
public interface ItemService {

    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //浏览商品列表
    List<ItemModel> listItem();

    //查看商品详情
    ItemModel getItemById(Integer id);

    //库存扣减
    boolean decreaseStock(Integer itemId,Integer amount) throws BusinessException;

    //销量增加
    void increaseSales(Integer itemId,Integer amount);
}
