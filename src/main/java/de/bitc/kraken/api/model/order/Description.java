package de.bitc.kraken.api.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Description implements Serializable {

    @JsonProperty("pair")
    private String assetPair;

    @JsonProperty("type")
    private Direction orderDirection;

    @JsonProperty("ordertype")
    private Type orderType;

    private BigDecimal price;

    @JsonProperty("price2")
    private BigDecimal secondaryPrice;

    private String leverage;

    private String order;

    private String close;

    /**
     * @return the assetPair
     */
    public String getAssetPair() {
        return assetPair;
    }

    /**
     * @param assetPair the assetPair to set
     */
    public void setAssetPair(String assetPair) {
        this.assetPair = assetPair;
    }

    /**
     * @return the orderDirection
     */
    public Direction getOrderDirection() {
        return orderDirection;
    }

    /**
     * @param orderDirection the orderDirection to set
     */
    public void setOrderDirection(Direction orderDirection) {
        this.orderDirection = orderDirection;
    }

    /**
     * @return the orderType
     */
    public Type getOrderType() {
        return orderType;
    }

    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(Type orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the secondaryPrice
     */
    public BigDecimal getSecondaryPrice() {
        return secondaryPrice;
    }

    /**
     * @param secondaryPrice the secondaryPrice to set
     */
    public void setSecondaryPrice(BigDecimal secondaryPrice) {
        this.secondaryPrice = secondaryPrice;
    }

    /**
     * @return the leverage
     */
    public String getLeverage() {
        return leverage;
    }

    /**
     * @param leverage the leverage to set
     */
    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    /**
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * @return the close
     */
    public String getClose() {
        return close;
    }

    /**
     * @param close the close to set
     */
    public void setClose(String close) {
        this.close = close;
    }


    @Override
    public int hashCode() {
        return Objects.hash(assetPair, close, leverage, order, orderDirection, orderType, price, secondaryPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Description other = (Description) obj;
        return Objects.equals(assetPair, other.assetPair) && Objects.equals(close, other.close)
                && Objects.equals(leverage, other.leverage) && Objects.equals(order, other.order)
                && orderDirection == other.orderDirection && orderType == other.orderType
                && Objects.equals(price, other.price) && Objects.equals(secondaryPrice, other.secondaryPrice);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Description [assetPair=").append(assetPair).append(", orderDirection=").append(orderDirection)
                .append(", orderType=").append(orderType).append(", price=").append(price).append(", secondaryPrice=")
                .append(secondaryPrice).append(", leverage=").append(leverage).append(", order=").append(order)
                .append(", close=").append(close).append("]");
        return builder.toString();
    }


}
