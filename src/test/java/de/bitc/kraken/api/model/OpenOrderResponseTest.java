package de.bitc.kraken.api.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class OpenOrderResponseTest {

	private ObjectMapper mapper;
	private String json;

	@BeforeEach
	void setUp() throws Exception {
		mapper = new ObjectMapper();

		json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/open-orders.json"),
				Charset.defaultCharset());

	}

	@Test
	void test() throws JsonMappingException, JsonProcessingException {
		OpenOrderResponse openOrderResponse = mapper.readValue(json, OpenOrderResponse.class);
		assertNotNull(openOrderResponse);
	}

}
