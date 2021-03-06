package com.yzh.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzh.common.to.OrderTo;
import com.yzh.common.to.mq.StockLockedTo;
import com.yzh.common.utils.PageUtils;
import com.yzh.mall.ware.entity.WareSkuEntity;
import com.yzh.mall.ware.vo.LockStockResult;
import com.yzh.mall.ware.vo.SkuHasStockVo;
import com.yzh.mall.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author yzh
 * @email sunlightcs@gmail.com
 * @date 2020-10-11 13:42:51
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);

    List<SkuHasStockVo> getSkusHasStack(List<Long> ids);

    boolean lockStock(WareSkuLockVo skuLockVo);

    void test();


    void unLockStock(StockLockedTo stockLockedTo);

    void unLockStock(OrderTo orderTo);
}

