package de.bitc.kraken.client.extern;

public class OhlcLastResponse<T> extends Response<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5356279077013870067L;
	private Long last;

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

}
