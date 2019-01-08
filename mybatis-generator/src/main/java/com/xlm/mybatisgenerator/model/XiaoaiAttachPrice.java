package com.xlm.mybatisgenerator.model;

import java.io.Serializable;
import java.util.Date;

public class XiaoaiAttachPrice implements Serializable {
    private Integer id;

    private Integer levelId;

    private Integer skuId;

    private Integer productId;

    private Double warrantyPrice;

    private Double valueAdded;

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

    public Double getWarrantyPrice() {
        return warrantyPrice;
    }

    public void setWarrantyPrice(Double warrantyPrice) {
        this.warrantyPrice = warrantyPrice;
    }

    public Double getValueAdded() {
        return valueAdded;
    }

    public void setValueAdded(Double valueAdded) {
        this.valueAdded = valueAdded;
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
        XiaoaiAttachPrice other = (XiaoaiAttachPrice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getWarrantyPrice() == null ? other.getWarrantyPrice() == null : this.getWarrantyPrice().equals(other.getWarrantyPrice()))
            && (this.getValueAdded() == null ? other.getValueAdded() == null : this.getValueAdded().equals(other.getValueAdded()))
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
        result = prime * result + ((getWarrantyPrice() == null) ? 0 : getWarrantyPrice().hashCode());
        result = prime * result + ((getValueAdded() == null) ? 0 : getValueAdded().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getUpdateDt() == null) ? 0 : getUpdateDt().hashCode());
        return result;
    }
}