package fr.auctionplus.app.bo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

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
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User sellerId;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyerId;
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

    public User getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    public User getBuyerId() {
        return this.sellerId;
    }

    public void setBuyerId(User buyerId) {
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
        if (!Objects.equals(itemName, auctions.itemName)) return false;
        if (!Objects.equals(itemDescription, auctions.itemDescription))
            return false;
        if (!Objects.equals(startingBid, auctions.startingBid))
            return false;
        if (!Objects.equals(currentBid, auctions.currentBid)) return false;
        if (!Objects.equals(startTime, auctions.startTime)) return false;
        if (!Objects.equals(endTime, auctions.endTime)) return false;
        if (!Objects.equals(buyerId, auctions.buyerId)) return false;

        return true;
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
