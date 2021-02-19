package de.bitc.kraken.api.model.order;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClosedOrders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654308871646027845L;

	@JsonProperty("closed")
	private Map<String, Order> closed;
	
	@JsonProperty("count")
	private Long count;

	/**
	 * @return the closed
	 */
	public Map<String, Order> getClosed() {
		return closed;
	}

	/**
	 * @param closed the closed to set
	 */
	public void setClosed(Map<String, Order> closed) {
		this.closed = closed;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(closed, count);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClosedOrders other = (ClosedOrders) obj;
		return Objects.equals(closed, other.closed) && Objects.equals(count, other.count);
	}


}
