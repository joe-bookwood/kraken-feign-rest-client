package de.bitc.kraken.api.model.order;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenOrders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654308871646027845L;
	@JsonProperty("open")
	private Map<String, Order> open;

	/**
	 * @return the open
	 */
	public Map<String, Order> getOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(Map<String, Order> open) {
		this.open = open;
	}

}
