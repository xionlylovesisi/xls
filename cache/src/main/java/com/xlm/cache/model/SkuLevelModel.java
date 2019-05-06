package com.xlm.cache.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;

@Data
@NoArgsConstructor
public class SkuLevelModel {

    private Integer skuId;
    private Integer levelId;
    private Integer categoryId;
    private String startDt;
    private String endDt;
	private static String skuLevelKey = "skuId:{0}:levelId:{1}";

    public static SkuLevelModelBuilder initSkuLevelModelBuilder() {
        return new SkuLevelModelBuilder();
    }
    @JsonIgnore
    public String getKeyLocateSkuLevel(){
    	return getKeyLocateSkuLevel(skuId, levelId);
    }
    @JsonIgnore
    public static String getKeyLocateSkuLevel(Integer skuId, Integer productLevelId){
    	return MessageFormat.format(skuLevelKey, skuId, productLevelId);
    }
    public static class SkuLevelModelBuilder{
        private SkuLevelModel skuLevelModel;
        SkuLevelModelBuilder(){
            skuLevelModel = new SkuLevelModel();
        }
        public SkuLevelModelBuilder skuId(Integer skuId){
            skuLevelModel.setSkuId(skuId);
            return this;
        }
        public SkuLevelModelBuilder levelId(Integer levelId){
            skuLevelModel.setLevelId(levelId);
            return this;
        }

        public SkuLevelModel build(){
            return skuLevelModel;
        }
    }
}
