package com.yzh.mall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.yzh.common.valied.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.yzh.mall.product.entity.BrandEntity;
import com.yzh.mall.product.service.BrandService;
import com.yzh.common.utils.PageUtils;
import com.yzh.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author yzh
 * @email sunlightcs@gmail.com
 * @date 2020-10-11 13:53:30
 */
@RefreshScope
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;



    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
   // @RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }
    /**
     * 获取复数id的
     */
    @GetMapping("/infos")
    public R getInfoByIds(@RequestParam("brandIds")List<Long>brandIds){
        List<BrandEntity> brandEntityList=brandService.selectInfoByIds(brandIds);
        return R.ok().put("brands",brandEntityList);
    }
    /**
     * 保存
     */

    @RequestMapping("/save")
 //   @RequiresPermissions("product:brand:save")
    public R save(@Validated({Insert.class}) @RequestBody BrandEntity brand){
/*        if (bindingResult.hasErrors()){
            Map<String,String>map=new HashMap<>();
            bindingResult.getFieldErrors().forEach((item)->
            {
               String messqage=item.getDefaultMessage();
               String Filed=item.getField();
               map.put(Filed,messqage);
            });
            return R.error(400,"数据不合法").put("data",map);
        }*/
		brandService.save(brand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
 //   @RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateDetail(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
 //   @RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
