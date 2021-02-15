package de.bitc.kraken.api.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.bitc.kraken.api.deserializer.OhlcDeserializer;

@JsonDeserialize(using = OhlcDeserializer.class)
public class OhclPayload {

	private List<CandleStick> candleSticks;

	private Long last;

	public OhclPayload(List<CandleStick> candleSticks, Long last) {
		this.candleSticks = candleSticks;
		this.last = last;
	}

	/**
	 * @return the candleSticks
	 */
	public List<CandleStick> getCandleSticks() {
		return candleSticks;
	}

	/**
	 * @param candleSticks the candleSticks to set
	 */
	public void setCandleSticks(List<CandleStick> candleSticks) {
		this.candleSticks = candleSticks;
	}

	/**
	 * @return the last
	 */
	public Long getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(Long last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		return Objects.hash(candleSticks, last);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OhclPayload other = (OhclPayload) obj;
		return Objects.equals(candleSticks, other.candleSticks) && Objects.equals(last, other.last);
	}
	
}
