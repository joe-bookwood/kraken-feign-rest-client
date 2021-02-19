package de.bitc.kraken.api.model.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.bitc.kraken.api.deserializer.EpochMilliesToLocalDateTimeDeserializer;

public class Order {

	@JsonProperty("refid")
	private String referralOrderTransactionId;

	@JsonProperty("userref")
	private String userReferenceId;

	@JsonProperty("status")
	private Status status;

	@JsonProperty("reason")
	private String reason;

	@JsonProperty("opentm")
	@JsonDeserialize(using = EpochMilliesToLocalDateTimeDeserializer.class)
	private LocalDateTime openTimestamp;

	@JsonProperty("closetm")
	@JsonDeserialize(using = EpochMilliesToLocalDateTimeDeserializer.class)
	private LocalDateTime closeTimestamp;

	@JsonProperty("starttm")
	@JsonDeserialize(using = EpochMilliesToLocalDateTimeDeserializer.class)
	private LocalDateTime orderStartTimestamp;

	@JsonProperty("expiretm")
	@JsonDeserialize(using = EpochMilliesToLocalDateTimeDeserializer.class)
	private LocalDateTime orderEndTimestamp;

	@JsonProperty("descr")
	private Description description;

	@JsonProperty("vol")
	private BigDecimal volumeOrder;

	@JsonProperty("vol_exec")
	private BigDecimal volumeExecuted;

	private BigDecimal cost;

	private BigDecimal fee;

	@JsonProperty("price")
	private BigDecimal averagePrice;

	@JsonProperty("stopprice")
	private BigDecimal stopPrice;

	@JsonProperty("limitprice")
	private BigDecimal limitPrice;

	@JsonProperty("misc")
	private String miscellaneous;

	@JsonProperty("oflags")
	private String orderFlags;

	/**
	 * @return the referralOrderTransactionId
	 */
	public String getReferralOrderTransactionId() {
		return referralOrderTransactionId;
	}

	/**
	 * @param referralOrderTransactionId the referralOrderTransactionId to set
	 */
	public void setReferralOrderTransactionId(String referralOrderTransactionId) {
		this.referralOrderTransactionId = referralOrderTransactionId;
	}

	/**
	 * @return the userReferenceId
	 */
	public String getUserReferenceId() {
		return userReferenceId;
	}

	/**
	 * @param userReferenceId the userReferenceId to set
	 */
	public void setUserReferenceId(String userReferenceId) {
		this.userReferenceId = userReferenceId;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the openTimestamp
	 */
	public LocalDateTime getOpenTimestamp() {
		return openTimestamp;
	}

	/**
	 * @param openTimestamp the openTimestamp to set
	 */
	public void setOpenTimestamp(LocalDateTime openTimestamp) {
		this.openTimestamp = openTimestamp;
	}

	/**
	 * @return the closeTimestamp
	 */
	public LocalDateTime getCloseTimestamp() {
		return closeTimestamp;
	}

	/**
	 * @param closeTimestamp the closeTimestamp to set
	 */
	public void setCloseTimestamp(LocalDateTime closeTimestamp) {
		this.closeTimestamp = closeTimestamp;
	}

	/**
	 * @return the orderStartTimestamp
	 */
	public LocalDateTime getOrderStartTimestamp() {
		return orderStartTimestamp;
	}

	/**
	 * @param orderStartTimestamp the orderStartTimestamp to set
	 */
	public void setOrderStartTimestamp(LocalDateTime orderStartTimestamp) {
		this.orderStartTimestamp = orderStartTimestamp;
	}

	/**
	 * @return the orderEndTimestamp
	 */
	public LocalDateTime getOrderEndTimestamp() {
		return orderEndTimestamp;
	}

	/**
	 * @param orderEndTimestamp the orderEndTimestamp to set
	 */
	public void setOrderEndTimestamp(LocalDateTime orderEndTimestamp) {
		this.orderEndTimestamp = orderEndTimestamp;
	}

	/**
	 * @return the description
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(Description description) {
		this.description = description;
	}

	/**
	 * @return the volumeOrder
	 */
	public BigDecimal getVolumeOrder() {
		return volumeOrder;
	}

	/**
	 * @param volumeOrder the volumeOrder to set
	 */
	public void setVolumeOrder(BigDecimal volumeOrder) {
		this.volumeOrder = volumeOrder;
	}

	/**
	 * @return the volumeExecuted
	 */
	public BigDecimal getVolumeExecuted() {
		return volumeExecuted;
	}

	/**
	 * @param volumeExecuted the volumeExecuted to set
	 */
	public void setVolumeExecuted(BigDecimal volumeExecuted) {
		this.volumeExecuted = volumeExecuted;
	}

	/**
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/**
	 * @return the fee
	 */
	public BigDecimal getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	/**
	 * @return the averagePrice
	 */
	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	/**
	 * @param averagePrice the averagePrice to set
	 */
	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

	/**
	 * @return the stopPrice
	 */
	public BigDecimal getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}

	/**
	 * @return the limitPrice
	 */
	public BigDecimal getLimitPrice() {
		return limitPrice;
	}

	/**
	 * @param limitPrice the limitPrice to set
	 */
	public void setLimitPrice(BigDecimal limitPrice) {
		this.limitPrice = limitPrice;
	}

	/**
	 * @return the miscellaneous
	 */
	public String getMiscellaneous() {
		return miscellaneous;
	}

	/**
	 * @param miscellaneous the miscellaneous to set
	 */
	public void setMiscellaneous(String miscellaneous) {
		this.miscellaneous = miscellaneous;
	}

	/**
	 * @return the orderFlags
	 */
	public String getOrderFlags() {
		return orderFlags;
	}

	/**
	 * @param orderFlags the orderFlags to set
	 */
	public void setOrderFlags(String orderFlags) {
		this.orderFlags = orderFlags;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averagePrice, closeTimestamp, cost, description, fee, limitPrice, miscellaneous,
				openTimestamp, orderEndTimestamp, orderFlags, orderStartTimestamp, reason, referralOrderTransactionId,
				status, stopPrice, userReferenceId, volumeExecuted, volumeOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(averagePrice, other.averagePrice) && Objects.equals(closeTimestamp, other.closeTimestamp)
				&& Objects.equals(cost, other.cost) && Objects.equals(description, other.description)
				&& Objects.equals(fee, other.fee) && Objects.equals(limitPrice, other.limitPrice)
				&& Objects.equals(miscellaneous, other.miscellaneous)
				&& Objects.equals(openTimestamp, other.openTimestamp)
				&& Objects.equals(orderEndTimestamp, other.orderEndTimestamp)
				&& Objects.equals(orderFlags, other.orderFlags)
				&& Objects.equals(orderStartTimestamp, other.orderStartTimestamp)
				&& Objects.equals(reason, other.reason)
				&& Objects.equals(referralOrderTransactionId, other.referralOrderTransactionId)
				&& status == other.status && Objects.equals(stopPrice, other.stopPrice)
				&& Objects.equals(userReferenceId, other.userReferenceId)
				&& Objects.equals(volumeExecuted, other.volumeExecuted)
				&& Objects.equals(volumeOrder, other.volumeOrder);
	}


}
