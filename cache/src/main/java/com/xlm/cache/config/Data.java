package com.xlm.cache.config;

import com.xlm.cache.model.SkuLevelModel;
import com.xlm.cache.model.SupplierReferencePrice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xls
 * @date 2019-04-29
 * @description
 */
public class Data {
    public static List<SupplierReferencePrice> getResultData(){
        SupplierReferencePrice supplierReferencePrice = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice1 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice2 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice3 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice4 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice5 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice6 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice7 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        SupplierReferencePrice supplierReferencePrice8 = SupplierReferencePrice.initSupplierReferencePriceBuilder().
                skuId(123).levelId(321).productId(222).supplierHighPrice(2222).supplierLowPrice(2222).build();
        List<SupplierReferencePrice> result = new ArrayList<>();
        result.add(supplierReferencePrice);
        result.add(supplierReferencePrice1);
        result.add(supplierReferencePrice2);
        result.add(supplierReferencePrice3);
        result.add(supplierReferencePrice4);
        result.add(supplierReferencePrice5);
        result.add(supplierReferencePrice6);
        result.add(supplierReferencePrice7);
        result.add(supplierReferencePrice8);
        return result;
    }



    public static List<SkuLevelModel> getReqData(){
        SkuLevelModel skuLevelModel = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(112).levelId(332).build();
        SkuLevelModel skuLevelModel1 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(113).levelId(331).build();
        SkuLevelModel skuLevelModel2 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(114).levelId(441).build();
        SkuLevelModel skuLevelModel3 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(115).levelId(551).build();
        SkuLevelModel skuLevelModel4 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(116).levelId(661).build();
        SkuLevelModel skuLevelModel5 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(117).levelId(771).build();
        SkuLevelModel skuLevelModel6 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(221).levelId(334).build();
        SkuLevelModel skuLevelModel7 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(223).levelId(322).build();
        SkuLevelModel skuLevelModel8 = SkuLevelModel.initSkuLevelModelBuilder().
                skuId(224).levelId(323).build();
        List<SkuLevelModel> result = new ArrayList<>();
        result.add(skuLevelModel);
        result.add(skuLevelModel1);
        result.add(skuLevelModel2);
        result.add(skuLevelModel3);
        result.add(skuLevelModel4);
        result.add(skuLevelModel5);
        result.add(skuLevelModel6);
        result.add(skuLevelModel7);
        result.add(skuLevelModel8);
        return result;
    }
}
