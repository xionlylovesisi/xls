package price;

import java.io.Serializable;
import java.util.Date;

public class PlatformReferencePriceWarnHistory implements Serializable {
    private Integer id;

    private Integer levelId;

    private Integer skuId;

    private Integer productId;

    private Integer warnLowPrice;

    private Integer warnHighPrice;

    private Date warnTime;

    private Integer operatorId;

    private Integer version;

    private Integer status;

    private Date effectDate;

    private Integer minPrice;

    private Integer maxPrice;

    private Integer categoryId;

    private Integer brandId;

    private Integer historyCreator;

    private Date historyCreateTime;

    private Date historyUpdateTime;

    private Integer confirmLowPrice;

    private Integer confirmHighPrice;

    private Integer approveHistoryOperatorId;

    private Date approveHistoryCreateTime;

    private Integer approveHistoryPriceChange;

    private Integer creator;

    private Date createTime;

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

    public Integer getWarnLowPrice() {
        return warnLowPrice;
    }

    public void setWarnLowPrice(Integer warnLowPrice) {
        this.warnLowPrice = warnLowPrice;
    }

    public Integer getWarnHighPrice() {
        return warnHighPrice;
    }

    public void setWarnHighPrice(Integer warnHighPrice) {
        this.warnHighPrice = warnHighPrice;
    }

    public Date getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getHistoryCreator() {
        return historyCreator;
    }

    public void setHistoryCreator(Integer historyCreator) {
        this.historyCreator = historyCreator;
    }

    public Date getHistoryCreateTime() {
        return historyCreateTime;
    }

    public void setHistoryCreateTime(Date historyCreateTime) {
        this.historyCreateTime = historyCreateTime;
    }

    public Date getHistoryUpdateTime() {
        return historyUpdateTime;
    }

    public void setHistoryUpdateTime(Date historyUpdateTime) {
        this.historyUpdateTime = historyUpdateTime;
    }

    public Integer getConfirmLowPrice() {
        return confirmLowPrice;
    }

    public void setConfirmLowPrice(Integer confirmLowPrice) {
        this.confirmLowPrice = confirmLowPrice;
    }

    public Integer getConfirmHighPrice() {
        return confirmHighPrice;
    }

    public void setConfirmHighPrice(Integer confirmHighPrice) {
        this.confirmHighPrice = confirmHighPrice;
    }

    public Integer getApproveHistoryOperatorId() {
        return approveHistoryOperatorId;
    }

    public void setApproveHistoryOperatorId(Integer approveHistoryOperatorId) {
        this.approveHistoryOperatorId = approveHistoryOperatorId;
    }

    public Date getApproveHistoryCreateTime() {
        return approveHistoryCreateTime;
    }

    public void setApproveHistoryCreateTime(Date approveHistoryCreateTime) {
        this.approveHistoryCreateTime = approveHistoryCreateTime;
    }

    public Integer getApproveHistoryPriceChange() {
        return approveHistoryPriceChange;
    }

    public void setApproveHistoryPriceChange(Integer approveHistoryPriceChange) {
        this.approveHistoryPriceChange = approveHistoryPriceChange;
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
        PlatformReferencePriceWarnHistory other = (PlatformReferencePriceWarnHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getWarnLowPrice() == null ? other.getWarnLowPrice() == null : this.getWarnLowPrice().equals(other.getWarnLowPrice()))
            && (this.getWarnHighPrice() == null ? other.getWarnHighPrice() == null : this.getWarnHighPrice().equals(other.getWarnHighPrice()))
            && (this.getWarnTime() == null ? other.getWarnTime() == null : this.getWarnTime().equals(other.getWarnTime()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEffectDate() == null ? other.getEffectDate() == null : this.getEffectDate().equals(other.getEffectDate()))
            && (this.getMinPrice() == null ? other.getMinPrice() == null : this.getMinPrice().equals(other.getMinPrice()))
            && (this.getMaxPrice() == null ? other.getMaxPrice() == null : this.getMaxPrice().equals(other.getMaxPrice()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getHistoryCreator() == null ? other.getHistoryCreator() == null : this.getHistoryCreator().equals(other.getHistoryCreator()))
            && (this.getHistoryCreateTime() == null ? other.getHistoryCreateTime() == null : this.getHistoryCreateTime().equals(other.getHistoryCreateTime()))
            && (this.getHistoryUpdateTime() == null ? other.getHistoryUpdateTime() == null : this.getHistoryUpdateTime().equals(other.getHistoryUpdateTime()))
            && (this.getConfirmLowPrice() == null ? other.getConfirmLowPrice() == null : this.getConfirmLowPrice().equals(other.getConfirmLowPrice()))
            && (this.getConfirmHighPrice() == null ? other.getConfirmHighPrice() == null : this.getConfirmHighPrice().equals(other.getConfirmHighPrice()))
            && (this.getApproveHistoryOperatorId() == null ? other.getApproveHistoryOperatorId() == null : this.getApproveHistoryOperatorId().equals(other.getApproveHistoryOperatorId()))
            && (this.getApproveHistoryCreateTime() == null ? other.getApproveHistoryCreateTime() == null : this.getApproveHistoryCreateTime().equals(other.getApproveHistoryCreateTime()))
            && (this.getApproveHistoryPriceChange() == null ? other.getApproveHistoryPriceChange() == null : this.getApproveHistoryPriceChange().equals(other.getApproveHistoryPriceChange()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getWarnLowPrice() == null) ? 0 : getWarnLowPrice().hashCode());
        result = prime * result + ((getWarnHighPrice() == null) ? 0 : getWarnHighPrice().hashCode());
        result = prime * result + ((getWarnTime() == null) ? 0 : getWarnTime().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEffectDate() == null) ? 0 : getEffectDate().hashCode());
        result = prime * result + ((getMinPrice() == null) ? 0 : getMinPrice().hashCode());
        result = prime * result + ((getMaxPrice() == null) ? 0 : getMaxPrice().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getHistoryCreator() == null) ? 0 : getHistoryCreator().hashCode());
        result = prime * result + ((getHistoryCreateTime() == null) ? 0 : getHistoryCreateTime().hashCode());
        result = prime * result + ((getHistoryUpdateTime() == null) ? 0 : getHistoryUpdateTime().hashCode());
        result = prime * result + ((getConfirmLowPrice() == null) ? 0 : getConfirmLowPrice().hashCode());
        result = prime * result + ((getConfirmHighPrice() == null) ? 0 : getConfirmHighPrice().hashCode());
        result = prime * result + ((getApproveHistoryOperatorId() == null) ? 0 : getApproveHistoryOperatorId().hashCode());
        result = prime * result + ((getApproveHistoryCreateTime() == null) ? 0 : getApproveHistoryCreateTime().hashCode());
        result = prime * result + ((getApproveHistoryPriceChange() == null) ? 0 : getApproveHistoryPriceChange().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}