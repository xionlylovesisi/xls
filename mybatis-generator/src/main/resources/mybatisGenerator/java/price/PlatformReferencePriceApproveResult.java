package price;

import java.io.Serializable;
import java.util.Date;

public class PlatformReferencePriceApproveResult implements Serializable {
    private Integer id;

    private Integer priceWarnId;

    private Integer confirmLowPrice;

    private Integer confirmHighPrice;

    private Integer operatorId;

    private Date createTime;

    private Integer priceChange;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriceWarnId() {
        return priceWarnId;
    }

    public void setPriceWarnId(Integer priceWarnId) {
        this.priceWarnId = priceWarnId;
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Integer priceChange) {
        this.priceChange = priceChange;
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
        PlatformReferencePriceApproveResult other = (PlatformReferencePriceApproveResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPriceWarnId() == null ? other.getPriceWarnId() == null : this.getPriceWarnId().equals(other.getPriceWarnId()))
            && (this.getConfirmLowPrice() == null ? other.getConfirmLowPrice() == null : this.getConfirmLowPrice().equals(other.getConfirmLowPrice()))
            && (this.getConfirmHighPrice() == null ? other.getConfirmHighPrice() == null : this.getConfirmHighPrice().equals(other.getConfirmHighPrice()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPriceChange() == null ? other.getPriceChange() == null : this.getPriceChange().equals(other.getPriceChange()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPriceWarnId() == null) ? 0 : getPriceWarnId().hashCode());
        result = prime * result + ((getConfirmLowPrice() == null) ? 0 : getConfirmLowPrice().hashCode());
        result = prime * result + ((getConfirmHighPrice() == null) ? 0 : getConfirmHighPrice().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPriceChange() == null) ? 0 : getPriceChange().hashCode());
        return result;
    }
}