package de.bitc.kraken.client.extern;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class OhlcPayload {

	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonPropertyOrder({ "time", "open", "high", "low", "close", "vwap", "volume", "count" })
	private Map<String, List<Candelstick>> candelSticks;

	@JsonProperty("last")
	private Long last;

	/**
	 * @return the candelSticks
	 */
	public Map<String, List<Candelstick>> getCandelSticks() {
		return candelSticks;
	}

	/**
	 * @param candelSticks the candelSticks to set
	 */
	public void setCandelSticks(Map<String, List<Candelstick>> candelSticks) {
		this.candelSticks = candelSticks;
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
		return Objects.hash(candelSticks, last);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OhlcPayload other = (OhlcPayload) obj;
		return Objects.equals(candelSticks, other.candelSticks) && Objects.equals(last, other.last);
	}

}
