package com.yzh.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.yzh.mall.product.entity.ProductAttrValueEntity;
import com.yzh.mall.product.service.ProductAttrValueService;
import com.yzh.mall.product.vo.AttrResponseVo;
import com.yzh.mall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yzh.mall.product.entity.AttrEntity;
import com.yzh.mall.product.service.AttrService;
import com.yzh.common.utils.PageUtils;
import com.yzh.common.utils.R;



/**
 * 商品属性
 *
 * @author yzh
 * @email sunlightcs@gmail.com
 * @date 2020-10-11 13:53:30
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @GetMapping("/base/listforspu/{spuId}")
    public R baseAttrListForSpu(@PathVariable("spuId") Long spuId){
       List<ProductAttrValueEntity>productAttrValueEntities=productAttrValueService.baseAttrlistforspu(spuId);
       return R.ok().put("data",productAttrValueEntities);
    }


    //获取通常属性product/attr/base/list/{catelog}
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String, Object> params,
                          @PathVariable("catelogId") Long catelogId,
                          @PathVariable("attrType") String type) {
        PageUtils page =attrService.queryBaseAttrPage(params,catelogId,type);
        return R.ok().put("page",page);
    }

    /**
     * 列表
     * Id和公共请求参数
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params,Long catelogId){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
   // @RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
		//AttrEntity attr = attrService.getById(attrId);
        AttrResponseVo attr=attrService.getAttrResponseVo(attrId);
        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
 //   @RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
 //   @RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttrVo(attr);

        return R.ok();
    }

    @PostMapping("/update/{spuId}")
    //   @RequiresPermissions("product:attr:update")
    public R updateBySpuId(@PathVariable("spuId") Long spuId,
                           @RequestBody List<ProductAttrValueEntity> productAttrValueEntities){
        productAttrValueService.updateSpuAttr(spuId,productAttrValueEntities);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
 //   @RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
