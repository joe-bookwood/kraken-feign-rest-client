package de.bitc.kraken.api.model.order;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

	PENDING("pending"), OPEN("open"), CLOSED("closed"), CANCELED("canceled"), EXPIRED("expired");

	@JsonValue
	private String value;

	Status(String string) {
		this.value = string;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}