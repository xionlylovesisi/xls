package com.xlm.cache.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.text.MessageFormat;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SupplierReferencePrice {

    private Integer id;
    private Integer levelId;
    private Integer skuId;
    private Integer productId;
    private Integer supplierLowPrice;
    private Integer supplierHighPrice;
    private Date createDt;
    private Date operationDt;
    private Integer operatorId;
    private Integer version;
    private Integer priceSource;
    private String skuLevelKey = "skuId:{0}:levelId:{1}";
    @JsonIgnore
    public String getKeyLocateSkuLevel() {
        return getKeyLocateSkuLevel(skuId, levelId);
    }
    @JsonIgnore
    public String getKeyLocateSkuLevel(Integer skuId, Integer productLevelId) {
        return MessageFormat.format(skuLevelKey, skuId, productLevelId);
    }

    public static SupplierReferencePriceBuilder initSupplierReferencePriceBuilder() {
        return new SupplierReferencePriceBuilder();
    }

    public static class SupplierReferencePriceBuilder {
        private SupplierReferencePrice supplierReferencePrice;

        SupplierReferencePriceBuilder() {
            supplierReferencePrice = new SupplierReferencePrice();
        }

        public SupplierReferencePriceBuilder levelId(Integer levelId) {
            supplierReferencePrice.setLevelId(levelId);
            return this;
        }

        public SupplierReferencePriceBuilder skuId(Integer skuId) {
            supplierReferencePrice.setSkuId(skuId);
            return this;
        }

        public SupplierReferencePriceBuilder productId(Integer productId) {
            supplierReferencePrice.setProductId(productId);
            return this;
        }

        public SupplierReferencePriceBuilder supplierLowPrice(Integer supplierLowPrice) {
            supplierReferencePrice.setSupplierLowPrice(supplierLowPrice);
            return this;
        }

        public SupplierReferencePriceBuilder supplierHighPrice(Integer supplierHighPrice) {
            supplierReferencePrice.setSupplierHighPrice(supplierHighPrice);
            return this;
        }

        public SupplierReferencePrice build() {
            return supplierReferencePrice;
        }

    }

}
