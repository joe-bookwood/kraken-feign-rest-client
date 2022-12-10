package de.bitc.kraken.api.client;

import de.bitc.kraken.api.config.KrakenConfiguration;
import de.bitc.kraken.api.model.AssetInfoResponse;
import de.bitc.kraken.api.model.AssetPairResponse;
import de.bitc.kraken.api.model.OhlcResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "public", url = "https://api.kraken.com/0/public", configuration = KrakenConfiguration.class)
public interface KrakenPublicApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/AssetPairs")
    AssetPairResponse fetchPairs();

    @RequestMapping(method = RequestMethod.GET, value = "/Assets")
    AssetInfoResponse fetchAssets();

    @RequestMapping(method = RequestMethod.GET, value = "/OHLC")
    OhlcResponse fetchOhcl(@RequestParam(value = "pair", required = true) String pair,
                           @RequestParam(value = "interval") Integer interval,
						   @RequestParam(value = "since") Integer since);

    @RequestMapping(method = RequestMethod.GET, value = "/Time")
    AssetPairResponse fetchTime();

    @RequestMapping(method = RequestMethod.GET, value = "/Status")
    AssetPairResponse fetchStatus();
}
