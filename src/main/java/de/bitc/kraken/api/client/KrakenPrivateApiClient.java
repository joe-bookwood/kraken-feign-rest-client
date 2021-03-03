package de.bitc.kraken.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import de.bitc.kraken.api.model.AssetPairResponse;
import de.bitc.kraken.api.model.BalanceResponse;


@FeignClient(name = "krakenPrivate", path = "/0/private")
public interface KrakenPrivateApiClient {


	@PostMapping(value = "/Balance")
	public BalanceResponse fetchBalance(@RequestHeader("api_key") String apiKey,
			@RequestHeader("api_signature") String signature);

	@PostMapping(value = "/OpenOrders")
	public AssetPairResponse fetchOpenOrders();

}
