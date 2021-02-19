package de.bitc.kraken.api.model.order;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {

	MARKET("market"), LIMIT("limit"), STOP_LOSS("stop-loss"), TAKE_PROFIT("take-profit"),
	STOP_LOSS_PROFIT("stop-loss-profit"), STOP_LOSS_PROFIT_LIMIT("stop-loss-profit-limit"),
	STOP_LOSS_LIMIT("stop-loss-limit"), TAKE_PROFIT_LIMIT("take-profit-limit"), TRAILING_STOP("trailing-stop"),
	TRAILING_STOP_LIMIT("trailing-stop-limit"), STOP_LOSS_AND_LIMIT("stop-loss-and-limit"),
	SETTLE_POSITION("settle-position");

	@JsonValue
	private String value;

	Type(String string) {
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
