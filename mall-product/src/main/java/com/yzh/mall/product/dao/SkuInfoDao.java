package com.yzh.mall.product.dao;

import com.yzh.mall.product.entity.SkuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * sku信息
 * 
 * @author yzh
 * @email sunlightcs@gmail.com
 * @date 2020-10-11 13:53:30
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfoEntity> {

    BigDecimal getPrice(@Param("skuId") Long skuId);
}
