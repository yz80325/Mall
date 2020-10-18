package com.yzh.mall.ware.dao;

import com.yzh.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author yzh
 * @email sunlightcs@gmail.com
 * @date 2020-10-11 13:42:51
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
