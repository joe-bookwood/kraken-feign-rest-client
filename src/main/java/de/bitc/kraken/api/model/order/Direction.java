package de.bitc.kraken.api.model.order;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Direction {
	BUY("buy"), SELL("sell");

	@JsonValue
	private String value;

	Direction(String string) {
		this.value = string;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
