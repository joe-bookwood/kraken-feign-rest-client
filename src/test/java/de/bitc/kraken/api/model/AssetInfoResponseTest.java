package de.bitc.kraken.api.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.bitc.kraken.api.model.AssetInfoResponse;

class AssetInfoResponseTest {

	private String json;
	private ObjectMapper mapper;

	@BeforeEach
	void setUp() throws Exception {
		mapper = new ObjectMapper();

		json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/asset-info.json"),
				Charset.defaultCharset());
	}

	@Test
	void test() throws JsonProcessingException {
		AssetInfoResponse assetInfoResponse = mapper.readValue(json, AssetInfoResponse.class);

		assertNotNull(assetInfoResponse);
	}

}
