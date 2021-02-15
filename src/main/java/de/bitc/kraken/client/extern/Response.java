package de.bitc.kraken.client.extern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Response<T> {

	private List<String> error = new ArrayList<>();
	private T result;

	/**
	 * @return the error
	 */
	public List<String> getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(List<String> error) {
		this.error = error;
	}

	/**
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(error, result);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		return Objects.equals(error, other.error) && Objects.equals(result, other.result);
	}

}
