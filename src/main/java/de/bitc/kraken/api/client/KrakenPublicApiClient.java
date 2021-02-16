package de.bitc.kraken.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.bitc.kraken.api.model.AssetInfoResponse;
import de.bitc.kraken.api.model.AssetPairResponse;
import de.bitc.kraken.api.model.OhlcResponse;
import de.bitc.kraken.config.KrakenConfiguration;

@FeignClient(name = "public", url = "https://api.kraken.com/0/public", configuration = KrakenConfiguration.class)
public interface KrakenPublicApiClient {

	@RequestMapping(method = RequestMethod.GET, value = "/AssetPairs")
	public AssetPairResponse fetchPairs();

	@RequestMapping(method = RequestMethod.GET, value = "/Assets")
	public AssetInfoResponse fetchAssets();

	@RequestMapping(method = RequestMethod.GET, value = "/OHLC")
	public OhlcResponse fetchOhcl();

}
