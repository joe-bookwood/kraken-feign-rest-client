package de.bitc.kraken.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
	void test() throws JsonProcessingException {
		ClosedOrderResponse closedOrderResponse = mapper.readValue(json, ClosedOrderResponse.class);
		assertNotNull(closedOrderResponse);
		Assertions.assertEquals(closedOrderResponse.getResult().getClosed().size(), 5);
	}

}
