package de.bitc.kraken.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ClosedOrderResponseTest {

	private ObjectMapper mapper;
	private String json;

	@BeforeEach
	void setUp() throws Exception {
		mapper = new ObjectMapper();

		json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/closed-orders.json"),
				Charset.defaultCharset());

	}

	@Test
	void test() throws JsonMappingException, JsonProcessingException {
		ClosedOrderResponse closedOrderResponse = mapper.readValue(json, ClosedOrderResponse.class);
		assertNotNull(closedOrderResponse);
		assertEquals(closedOrderResponse.getResult().getClosed().size(), 5);
	}

}
