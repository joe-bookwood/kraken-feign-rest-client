package de.bitc.kraken.client.extern;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "volume", "percent" })
public class Fee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7824923024905401144L;
	private Integer volume;
	private Float percent;

	/**
	 * @return the volume
	 */
	public Integer getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	/**
	 * @return the percent
	 */
	public Float getPercent() {
		return percent;
	}

	/**
	 * @param percent the percent to set
	 */
	public void setPercent(Float percent) {
		this.percent = percent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(percent, volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fee other = (Fee) obj;
		return Objects.equals(percent, other.percent) && Objects.equals(volume, other.volume);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fee [volume=").append(volume).append(", percent=").append(percent).append("]");
		return builder.toString();
	}

}
