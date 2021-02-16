package de.bitc.kraken.api.client;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bitc.kraken.api.model.AssetInfoResponse;

@Service
public class KrakenTestService {

	@Autowired
	private KrakenPublicApiClient krakenPublicApiClientIT;

	public Set<String> getAssets() {
		AssetInfoResponse response = krakenPublicApiClientIT.fetchAssets();
		return response.getResult().keySet().stream().collect(Collectors.toSet());
	}

}
