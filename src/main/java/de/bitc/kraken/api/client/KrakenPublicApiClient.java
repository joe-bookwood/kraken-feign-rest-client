package de.bitc.kraken.api.client;

import de.bitc.kraken.api.config.KrakenConfiguration;
import de.bitc.kraken.api.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "public", url = "https://api.kraken.com/0/public", configuration = KrakenConfiguration.class)
public interface KrakenPublicApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/AssetPairs")
    ResponseEntity<AssetPairResponse> fetchPairs();

    @RequestMapping(method = RequestMethod.GET, value = "/Assets")
    ResponseEntity<AssetInfoResponse> fetchAssets();

    @RequestMapping(method = RequestMethod.GET, value = "/OHLC")
    ResponseEntity<OhlcResponse> fetchOhcl(@RequestParam(value = "pair", required = true) String pair,
                           @RequestParam(value = "interval") Integer interval,
                           @RequestParam(value = "since") Integer since);

    @RequestMapping(method = RequestMethod.GET, value = "/Time")
    ResponseEntity<TimeResponse> fetchTime();

    @RequestMapping(method = RequestMethod.GET, value = "/SystemStatus")
    ResponseEntity<StatusResponse> fetchStatus();
}
