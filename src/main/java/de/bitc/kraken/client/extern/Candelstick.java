package de.bitc.kraken.client.extern;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Candelstick implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2368569883506418449L;

	private Integer time;

	private BigDecimal open;

	private BigDecimal high;

	private BigDecimal low;

	private BigDecimal close;

	private BigDecimal vwap;

	private BigDecimal volume;

	private Integer count;

	/**
	 * @return the time
	 */
	public Integer getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Integer time) {
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
	 * @return the vwap
	 */
	public BigDecimal getVwap() {
		return vwap;
	}

	/**
	 * @param vwap the vwap to set
	 */
	public void setVwap(BigDecimal vwap) {
		this.vwap = vwap;
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
		return Objects.hash(close, count, high, low, open, time, volume, vwap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candelstick other = (Candelstick) obj;
		return Objects.equals(close, other.close) && Objects.equals(count, other.count)
				&& Objects.equals(high, other.high) && Objects.equals(low, other.low)
				&& Objects.equals(open, other.open) && Objects.equals(time, other.time)
				&& Objects.equals(volume, other.volume) && Objects.equals(vwap, other.vwap);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Candelstick [time=").append(time).append(", open=").append(open).append(", high=").append(high)
				.append(", low=").append(low).append(", close=").append(close).append(", vwap=").append(vwap)
				.append(", volume=").append(volume).append(", count=").append(count).append("]");
		return builder.toString();
	}

}
