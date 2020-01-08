package com.mybatis.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReferencePrice implements Serializable {
    private Long id;

    private Integer levelId;

    private Integer skuId;

    private Integer productId;

    private BigDecimal platformReferencePrice;

    private BigDecimal supplierReferencePrice;

    private BigDecimal recyclerReferencePrice;

    private Byte dataSource;

    private Byte priceSourceType;

    private String priceSource;

    private Byte operateType;

    private Integer version;

    private Integer operatorId;

    private Integer creator;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getPlatformReferencePrice() {
        return platformReferencePrice;
    }

    public void setPlatformReferencePrice(BigDecimal platformReferencePrice) {
        this.platformReferencePrice = platformReferencePrice;
    }

    public BigDecimal getSupplierReferencePrice() {
        return supplierReferencePrice;
    }

    public void setSupplierReferencePrice(BigDecimal supplierReferencePrice) {
        this.supplierReferencePrice = supplierReferencePrice;
    }

    public BigDecimal getRecyclerReferencePrice() {
        return recyclerReferencePrice;
    }

    public void setRecyclerReferencePrice(BigDecimal recyclerReferencePrice) {
        this.recyclerReferencePrice = recyclerReferencePrice;
    }

    public Byte getDataSource() {
        return dataSource;
    }

    public void setDataSource(Byte dataSource) {
        this.dataSource = dataSource;
    }

    public Byte getPriceSourceType() {
        return priceSourceType;
    }

    public void setPriceSourceType(Byte priceSourceType) {
        this.priceSourceType = priceSourceType;
    }

    public String getPriceSource() {
        return priceSource;
    }

    public void setPriceSource(String priceSource) {
        this.priceSource = priceSource == null ? null : priceSource.trim();
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        ReferencePrice other = (ReferencePrice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPlatformReferencePrice() == null ? other.getPlatformReferencePrice() == null : this.getPlatformReferencePrice().equals(other.getPlatformReferencePrice()))
            && (this.getSupplierReferencePrice() == null ? other.getSupplierReferencePrice() == null : this.getSupplierReferencePrice().equals(other.getSupplierReferencePrice()))
            && (this.getRecyclerReferencePrice() == null ? other.getRecyclerReferencePrice() == null : this.getRecyclerReferencePrice().equals(other.getRecyclerReferencePrice()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getPriceSourceType() == null ? other.getPriceSourceType() == null : this.getPriceSourceType().equals(other.getPriceSourceType()))
            && (this.getPriceSource() == null ? other.getPriceSource() == null : this.getPriceSource().equals(other.getPriceSource()))
            && (this.getOperateType() == null ? other.getOperateType() == null : this.getOperateType().equals(other.getOperateType()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPlatformReferencePrice() == null) ? 0 : getPlatformReferencePrice().hashCode());
        result = prime * result + ((getSupplierReferencePrice() == null) ? 0 : getSupplierReferencePrice().hashCode());
        result = prime * result + ((getRecyclerReferencePrice() == null) ? 0 : getRecyclerReferencePrice().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        result = prime * result + ((getPriceSourceType() == null) ? 0 : getPriceSourceType().hashCode());
        result = prime * result + ((getPriceSource() == null) ? 0 : getPriceSource().hashCode());
        result = prime * result + ((getOperateType() == null) ? 0 : getOperateType().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}