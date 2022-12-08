package de.bitc.kraken.api.model.asset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.bitc.kraken.api.model.Fee;

public class AssetPair implements Serializable{


	@JsonProperty("altname")
	private String alternatePairName;

	@JsonProperty("wsname")
	private String wsName;

	@JsonProperty("aclass_base")
	private String baseAssetClass;

	@JsonProperty("base")
	private String baseAsset;

	@JsonProperty("aclass_quote")
	private String quoteAssetClass;

	@JsonProperty("quote")
	private String quoteAsset;

	@JsonProperty("lot")
	private String lot;

	@JsonProperty("pair_decimals")
	private Integer pairDecimals;

	@JsonProperty("lot_decimals")
	private Integer lotDecimals;

	@JsonProperty("lot_multiplier")
	private Integer lotMultiplier;

	@JsonProperty("leverage_buy")
	private List<Integer> leverageBuy = new ArrayList<>();;

	@JsonProperty("leverage_sell")
	private List<Integer> leverageSell = new ArrayList<>();;

	private List<Fee> fees = new ArrayList<>();;

	@JsonProperty("fees_maker")
	private List<Fee> feesMaker = new ArrayList<>();

	@JsonProperty("fee_volume_currency")
	private String feeVolumeCurrency;

	@JsonProperty("margin_call")
	private Integer marginCall;

	@JsonProperty("margin_level")
	private Integer marginLevel;

	@JsonProperty("margin_stop")
	private Integer marginStop;

	@JsonProperty("ordermin")
	private String ordermin;

	/**
	 * @return the alternatePairName
	 */
	public String getAlternatePairName() {
		return alternatePairName;
	}

	/**
	 * @param alternatePairName the alternatePairName to set
	 */
	public void setAlternatePairName(String alternatePairName) {
		this.alternatePairName = alternatePairName;
	}

	/**
	 * @return the wsName
	 */
	public String getWsName() {
		return wsName;
	}

	/**
	 * @param wsName the wsName to set
	 */
	public void setWsName(String wsName) {
		this.wsName = wsName;
	}

	/**
	 * @return the baseAssetClass
	 */
	public String getBaseAssetClass() {
		return baseAssetClass;
	}

	/**
	 * @param baseAssetClass the baseAssetClass to set
	 */
	public void setBaseAssetClass(String baseAssetClass) {
		this.baseAssetClass = baseAssetClass;
	}

	/**
	 * @return the baseAsset
	 */
	public String getBaseAsset() {
		return baseAsset;
	}

	/**
	 * @param baseAsset the baseAsset to set
	 */
	public void setBaseAsset(String baseAsset) {
		this.baseAsset = baseAsset;
	}

	/**
	 * @return the quoteAssetClass
	 */
	public String getQuoteAssetClass() {
		return quoteAssetClass;
	}

	/**
	 * @param quoteAssetClass the quoteAssetClass to set
	 */
	public void setQuoteAssetClass(String quoteAssetClass) {
		this.quoteAssetClass = quoteAssetClass;
	}

	/**
	 * @return the quoteAsset
	 */
	public String getQuoteAsset() {
		return quoteAsset;
	}

	/**
	 * @param quoteAsset the quoteAsset to set
	 */
	public void setQuoteAsset(String quoteAsset) {
		this.quoteAsset = quoteAsset;
	}

	/**
	 * @return the lot
	 */
	public String getLot() {
		return lot;
	}

	/**
	 * @param lot the lot to set
	 */
	public void setLot(String lot) {
		this.lot = lot;
	}

	/**
	 * @return the pairDecimals
	 */
	public Integer getPairDecimals() {
		return pairDecimals;
	}

	/**
	 * @param pairDecimals the pairDecimals to set
	 */
	public void setPairDecimals(Integer pairDecimals) {
		this.pairDecimals = pairDecimals;
	}

	/**
	 * @return the lotDecimals
	 */
	public Integer getLotDecimals() {
		return lotDecimals;
	}

	/**
	 * @param lotDecimals the lotDecimals to set
	 */
	public void setLotDecimals(Integer lotDecimals) {
		this.lotDecimals = lotDecimals;
	}

	/**
	 * @return the lotMultiplier
	 */
	public Integer getLotMultiplier() {
		return lotMultiplier;
	}

	/**
	 * @param lotMultiplier the lotMultiplier to set
	 */
	public void setLotMultiplier(Integer lotMultiplier) {
		this.lotMultiplier = lotMultiplier;
	}

	/**
	 * @return the leverageBuy
	 */
	public List<Integer> getLeverageBuy() {
		return leverageBuy;
	}

	/**
	 * @param leverageBuy the leverageBuy to set
	 */
	public void setLeverageBuy(List<Integer> leverageBuy) {
		this.leverageBuy = leverageBuy;
	}

	/**
	 * @return the leverageSell
	 */
	public List<Integer> getLeverageSell() {
		return leverageSell;
	}

	/**
	 * @param leverageSell the leverageSell to set
	 */
	public void setLeverageSell(List<Integer> leverageSell) {
		this.leverageSell = leverageSell;
	}

	/**
	 * @return the fees
	 */
	public List<Fee> getFees() {
		return fees;
	}

	/**
	 * @param fees the fees to set
	 */
	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	/**
	 * @return the feesMaker
	 */
	public List<Fee> getFeesMaker() {
		return feesMaker;
	}

	/**
	 * @param feesMaker the feesMaker to set
	 */
	public void setFeesMaker(List<Fee> feesMaker) {
		this.feesMaker = feesMaker;
	}

	/**
	 * @return the feeVolumeCurrency
	 */
	public String getFeeVolumeCurrency() {
		return feeVolumeCurrency;
	}

	/**
	 * @param feeVolumeCurrency the feeVolumeCurrency to set
	 */
	public void setFeeVolumeCurrency(String feeVolumeCurrency) {
		this.feeVolumeCurrency = feeVolumeCurrency;
	}

	/**
	 * @return the marginCall
	 */
	public Integer getMarginCall() {
		return marginCall;
	}

	/**
	 * @param marginCall the marginCall to set
	 */
	public void setMarginCall(Integer marginCall) {
		this.marginCall = marginCall;
	}

	/**
	 * @return the marginLevel
	 */
	public Integer getMarginLevel() {
		return marginLevel;
	}

	/**
	 * @param marginLevel the marginLevel to set
	 */
	public void setMarginLevel(Integer marginLevel) {
		this.marginLevel = marginLevel;
	}

	/**
	 * @return the marginStop
	 */
	public Integer getMarginStop() {
		return marginStop;
	}

	/**
	 * @param marginStop the marginStop to set
	 */
	public void setMarginStop(Integer marginStop) {
		this.marginStop = marginStop;
	}

	/**
	 * @return the ordermin
	 */
	public String getOrdermin() {
		return ordermin;
	}

	/**
	 * @param ordermin the ordermin to set
	 */
	public void setOrdermin(String ordermin) {
		this.ordermin = ordermin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alternatePairName, baseAsset, baseAssetClass, feeVolumeCurrency, fees, feesMaker,
				leverageBuy, leverageSell, lot, lotDecimals, lotMultiplier, marginCall, marginLevel, marginStop,
				ordermin, pairDecimals, quoteAsset, quoteAssetClass, wsName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetPair other = (AssetPair) obj;
		return Objects.equals(alternatePairName, other.alternatePairName) && Objects.equals(baseAsset, other.baseAsset)
				&& Objects.equals(baseAssetClass, other.baseAssetClass)
				&& Objects.equals(feeVolumeCurrency, other.feeVolumeCurrency) && Objects.equals(fees, other.fees)
				&& Objects.equals(feesMaker, other.feesMaker) && Objects.equals(leverageBuy, other.leverageBuy)
				&& Objects.equals(leverageSell, other.leverageSell) && Objects.equals(lot, other.lot)
				&& Objects.equals(lotDecimals, other.lotDecimals) && Objects.equals(lotMultiplier, other.lotMultiplier)
				&& Objects.equals(marginCall, other.marginCall) && Objects.equals(marginLevel, other.marginLevel)
				&& Objects.equals(marginStop, other.marginStop) && Objects.equals(ordermin, other.ordermin)
				&& Objects.equals(pairDecimals, other.pairDecimals) && Objects.equals(quoteAsset, other.quoteAsset)
				&& Objects.equals(quoteAssetClass, other.quoteAssetClass) && Objects.equals(wsName, other.wsName);
	}

}
