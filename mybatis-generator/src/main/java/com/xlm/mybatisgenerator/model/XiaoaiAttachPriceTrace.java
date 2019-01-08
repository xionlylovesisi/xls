package com.xlm.mybatisgenerator.model;

import java.io.Serializable;
import java.util.Date;

public class XiaoaiAttachPriceTrace implements Serializable {
    private Integer id;

    private Integer levelId;

    private Integer skuId;

    private Integer productId;

    private Double newWarrantyPrice;

    private Double newValueAdded;

    private Double oldWarrantyPrice;

    private Double oldValueAdded;

    private Integer operateType;

    private Double instantCostPrice;

    private Integer version;

    private Integer operatorId;

    private Integer creator;

    private Date createDt;

    private Date updateDt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getNewWarrantyPrice() {
        return newWarrantyPrice;
    }

    public void setNewWarrantyPrice(Double newWarrantyPrice) {
        this.newWarrantyPrice = newWarrantyPrice;
    }

    public Double getNewValueAdded() {
        return newValueAdded;
    }

    public void setNewValueAdded(Double newValueAdded) {
        this.newValueAdded = newValueAdded;
    }

    public Double getOldWarrantyPrice() {
        return oldWarrantyPrice;
    }

    public void setOldWarrantyPrice(Double oldWarrantyPrice) {
        this.oldWarrantyPrice = oldWarrantyPrice;
    }

    public Double getOldValueAdded() {
        return oldValueAdded;
    }

    public void setOldValueAdded(Double oldValueAdded) {
        this.oldValueAdded = oldValueAdded;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Double getInstantCostPrice() {
        return instantCostPrice;
    }

    public void setInstantCostPrice(Double instantCostPrice) {
        this.instantCostPrice = instantCostPrice;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        XiaoaiAttachPriceTrace other = (XiaoaiAttachPriceTrace) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getNewWarrantyPrice() == null ? other.getNewWarrantyPrice() == null : this.getNewWarrantyPrice().equals(other.getNewWarrantyPrice()))
            && (this.getNewValueAdded() == null ? other.getNewValueAdded() == null : this.getNewValueAdded().equals(other.getNewValueAdded()))
            && (this.getOldWarrantyPrice() == null ? other.getOldWarrantyPrice() == null : this.getOldWarrantyPrice().equals(other.getOldWarrantyPrice()))
            && (this.getOldValueAdded() == null ? other.getOldValueAdded() == null : this.getOldValueAdded().equals(other.getOldValueAdded()))
            && (this.getOperateType() == null ? other.getOperateType() == null : this.getOperateType().equals(other.getOperateType()))
            && (this.getInstantCostPrice() == null ? other.getInstantCostPrice() == null : this.getInstantCostPrice().equals(other.getInstantCostPrice()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getUpdateDt() == null ? other.getUpdateDt() == null : this.getUpdateDt().equals(other.getUpdateDt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getNewWarrantyPrice() == null) ? 0 : getNewWarrantyPrice().hashCode());
        result = prime * result + ((getNewValueAdded() == null) ? 0 : getNewValueAdded().hashCode());
        result = prime * result + ((getOldWarrantyPrice() == null) ? 0 : getOldWarrantyPrice().hashCode());
        result = prime * result + ((getOldValueAdded() == null) ? 0 : getOldValueAdded().hashCode());
        result = prime * result + ((getOperateType() == null) ? 0 : getOperateType().hashCode());
        result = prime * result + ((getInstantCostPrice() == null) ? 0 : getInstantCostPrice().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getUpdateDt() == null) ? 0 : getUpdateDt().hashCode());
        return result;
    }
}