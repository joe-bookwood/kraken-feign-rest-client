package de.bitc.kraken.api.model.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class AssetInfo implements Serializable{


	@JsonProperty("altname")
	private String alternateName;

	@JsonProperty("aclass")
	private String assetClass;

	@JsonProperty("decimals")
	private Byte decimals;

	@JsonProperty("display_decimals")
	private Byte displayDecimals;

	/**
	 * @return the alternateName
	 */
	public String getAlternateName() {
		return alternateName;
	}

	/**
	 * @param alternateName the alternateName to set
	 */
	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	/**
	 * @return the assetClass
	 */
	public String getAssetClass() {
		return assetClass;
	}

	/**
	 * @param assetClass the assetClass to set
	 */
	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	/**
	 * @return the decimals
	 */
	public Byte getDecimals() {
		return decimals;
	}

	/**
	 * @param decimals the decimals to set
	 */
	public void setDecimals(Byte decimals) {
		this.decimals = decimals;
	}

	/**
	 * @return the displayDecimals
	 */
	public Byte getDisplayDecimals() {
		return displayDecimals;
	}

	/**
	 * @param displayDecimals the displayDecimals to set
	 */
	public void setDisplayDecimals(Byte displayDecimals) {
		this.displayDecimals = displayDecimals;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alternateName, assetClass, decimals, displayDecimals);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetInfo other = (AssetInfo) obj;
		return Objects.equals(alternateName, other.alternateName) && Objects.equals(assetClass, other.assetClass)
				&& Objects.equals(decimals, other.decimals) && Objects.equals(displayDecimals, other.displayDecimals);
	}

	@Override
	public String toString() {
		String builder = "AssetInfo [alternateName=" + alternateName + ", assetClass=" + assetClass +
				", decimals=" + decimals + ", displayDecimals=" + displayDecimals +
				"]";
		return builder;
	}

}
