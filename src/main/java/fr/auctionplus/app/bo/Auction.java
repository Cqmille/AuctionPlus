package fr.auctionplus.app.bo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "auctions", schema = "dbo", catalog = "BDD_AUCTIONS")
public class Auction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "auction_id")
    private int auctionId;
    @Basic
    @Column(name = "item_name")
    private String itemName;
    @Basic
    @Column(name = "item_description")
    private String itemDescription;
    @Basic
    @Column(name = "starting_bid")
    private BigDecimal startingBid;
    @Basic
    @Column(name = "current_bid")
    private BigDecimal currentBid;
    @Basic
    @Column(name = "start_time")
    private Date startTime;
    @Basic
    @Column(name = "end_time")
    private Date endTime;
    @Basic
    @Column(name = "seller_id")
    private int sellerId;
    @Basic
    @Column(name = "buyer_id")
    private Integer buyerId;
    @Basic
    @Column(name = "is_closed", columnDefinition = "BIT DEFAULT 0")
    private boolean isClosed;

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(BigDecimal startingBid) {
        this.startingBid = startingBid;
    }

    public BigDecimal getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(BigDecimal currentBid) {
        this.currentBid = currentBid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auction auctions = (Auction) o;

        if (auctionId != auctions.auctionId) return false;
        if (sellerId != auctions.sellerId) return false;
        if (isClosed != auctions.isClosed) return false;
        if (itemName != null ? !itemName.equals(auctions.itemName) : auctions.itemName != null) return false;
        if (itemDescription != null ? !itemDescription.equals(auctions.itemDescription) : auctions.itemDescription != null)
            return false;
        if (startingBid != null ? !startingBid.equals(auctions.startingBid) : auctions.startingBid != null)
            return false;
        if (currentBid != null ? !currentBid.equals(auctions.currentBid) : auctions.currentBid != null) return false;
        if (startTime != null ? !startTime.equals(auctions.startTime) : auctions.startTime != null) return false;
        if (endTime != null ? !endTime.equals(auctions.endTime) : auctions.endTime != null) return false;
        if (buyerId != null ? !buyerId.equals(auctions.buyerId) : auctions.buyerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = auctionId;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemDescription != null ? itemDescription.hashCode() : 0);
        result = 31 * result + (startingBid != null ? startingBid.hashCode() : 0);
        result = 31 * result + (currentBid != null ? currentBid.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + sellerId;
        result = 31 * result + (buyerId != null ? buyerId.hashCode() : 0);
        result = 31 * result + (isClosed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", startingBid=" + startingBid +
                ", currentBid=" + currentBid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", sellerId=" + sellerId +
                ", buyerId=" + buyerId +
                ", isClosed=" + isClosed +
                '}';
    }
}
