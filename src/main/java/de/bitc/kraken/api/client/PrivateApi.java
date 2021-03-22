package de.bitc.kraken.api.client;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bitc.kraken.api.model.BalanceResponse;
import de.bitc.kraken.api.model.OpenOrderResponse;

@Service
public class PrivateApi {

	@Autowired
	private CryptUtils cryptUtils;

	@Autowired
	private KrakenPrivateApiClient krakenPrivateApiClient;

	public BalanceResponse getBalance(String apiKey, String apiSecret)
			throws InvalidKeyException, NoSuchAlgorithmException {
		Map<String, String> header = cryptUtils.initParams();
		String signature = cryptUtils.generateSignature(apiSecret, "/0/private/Balance", header);
		return krakenPrivateApiClient.fetchBalance(apiKey, signature);
	}

	public OpenOrderResponse getOpenOrders(String apiKey, String apiSecret)
			throws InvalidKeyException, NoSuchAlgorithmException {
		Map<String, String> header = cryptUtils.initParams();
		String signature = cryptUtils.generateSignature(apiSecret, "/0/private/OpenOrders", header);
		return krakenPrivateApiClient.fetchOpenOrders(apiKey, signature);

	}
}
