package de.bitc.kraken.api.client;

import de.bitc.kraken.api.model.BalanceResponse;
import de.bitc.kraken.api.model.OpenOrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "krakenPrivate", path = "/0/private", url = "https://api.kraken.com/")
public interface KrakenPrivateApiClient {


	@PostMapping(value = "/Balance")
	BalanceResponse fetchBalance(@RequestHeader("api_key") String apiKey,
								 @RequestHeader("api_signature") String signature);

	@PostMapping(value = "/OpenOrders")
	OpenOrderResponse fetchOpenOrders(@RequestHeader("api_key") String apiKey,
									  @RequestHeader("api_signature") String signature);

}
