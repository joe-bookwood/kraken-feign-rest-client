package de.bitc.kraken.api.client;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.bitc.kraken.api.model.AssetInfoResponse;

@Service
public class KrakenTestService {

	@Autowired
	private KrakenPublicApiClient krakenPublicApiClientIT;

	public Optional<Set<String>> getAssets() {
		ResponseEntity<AssetInfoResponse> response = krakenPublicApiClientIT.fetchAssets();
		if(response.hasBody() && response.getBody()!=null) {
			return Optional.of(response.getBody().getResult().keySet().stream().collect(Collectors.toSet()));
		}
		return Optional.empty();
	}

}
