package de.bitc.kraken.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.bitc.kraken.api.deserializer.EpochToLocalDateTimeDeserializer;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "time", "open", "high", "low", "close", "vwap", "volume", "count" })
public class CandleStick implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2368569883506418449L;

	@JsonDeserialize(using = EpochToLocalDateTimeDeserializer.class)
	private LocalDateTime time;

	private BigDecimal open;

	private BigDecimal high;

	private BigDecimal low;

	private BigDecimal close;

	@JsonProperty("vwap")
	private BigDecimal volumeWeightedAveragePrice;

	private BigDecimal volume;

	private Integer count;

	/**
	 * @return the time
	 */
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/**
	 * @return the open
	 */
	public BigDecimal getOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	/**
	 * @return the high
	 */
	public BigDecimal getHigh() {
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	/**
	 * @return the low
	 */
	public BigDecimal getLow() {
		return low;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(BigDecimal low) {
		this.low = low;
	}

	/**
	 * @return the close
	 */
	public BigDecimal getClose() {
		return close;
	}

	/**
	 * @param close the close to set
	 */
	public void setClose(BigDecimal close) {
		this.close = close;
	}

	/**
	 * @return the volumeWeightedAveragePrice
	 */
	public BigDecimal getVolumeWeightedAveragePrice() {
		return volumeWeightedAveragePrice;
	}

	/**
	 * @param volumeWeightedAveragePrice the volumeWeightedAveragePrice to set
	 */
	public void setVolumeWeightedAveragePrice(BigDecimal volumeWeightedAveragePrice) {
		this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
	}

	/**
	 * @return the volume
	 */
	public BigDecimal getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(close, count, high, low, open, time, volume, volumeWeightedAveragePrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandleStick other = (CandleStick) obj;
		return Objects.equals(close, other.close) && Objects.equals(count, other.count)
				&& Objects.equals(high, other.high) && Objects.equals(low, other.low)
				&& Objects.equals(open, other.open) && Objects.equals(time, other.time)
				&& Objects.equals(volume, other.volume)
				&& Objects.equals(volumeWeightedAveragePrice, other.volumeWeightedAveragePrice);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CandleStick [time=").append(time).append(", open=").append(open).append(", high=").append(high)
				.append(", low=").append(low).append(", close=").append(close).append(", volumeWeightedAveragePrice=")
				.append(volumeWeightedAveragePrice).append(", volume=").append(volume).append(", count=").append(count)
				.append("]");
		return builder.toString();
	}


}
