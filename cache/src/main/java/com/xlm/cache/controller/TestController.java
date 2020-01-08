package com.xlm.cache.controller;

import com.xlm.cache.config.Data;
import com.xlm.cache.model.SkuLevelModel;
import com.xlm.cache.model.SupplierReferencePrice;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xls
 * @date 2019-04-29
 * @description
 */
@RestController
public class TestController {
    @PostMapping("/list/test")
    @Cacheable(cacheNames = "test-cache", keyGenerator = "keyGenerator")
    public List<SupplierReferencePrice> getSupplierReferencePrice(
            @RequestBody List<SkuLevelModel> list) {
        return Data.getResultData();
    }

    @PostMapping("/single/test")
    @Cacheable(cacheNames = "test-cache", keyGenerator = "keyGenerator")
    public SupplierReferencePrice getSupplierReferencePrice(
            @RequestBody SkuLevelModel skuLevelModel) {
        return SupplierReferencePrice.initSupplierReferencePriceBuilder().skuId(110).levelId(911).productId(322)
                .supplierHighPrice(888)
                .supplierLowPrice(999)
                .build();
    }

    @GetMapping("/cache/evict")
    @CacheEvict(cacheNames = "test-cache", allEntries = true)
    public String getSupplierReferencePrice() {
        return "success";
    }
}
