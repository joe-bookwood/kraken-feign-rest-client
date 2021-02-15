package de.bitc.kraken.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class OhclResponseTest {

	private String json;
	private ObjectMapper mapper;

	@BeforeEach
	void setUp() throws Exception {
		mapper = new ObjectMapper();
//		SimpleModule module = new SimpleModule();
//		module.addDeserializer(OhlcDeserializer.class, new OhlcDeserializer());

		json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/ohlc.json"),
				Charset.defaultCharset());
	}

	@Test
	void test() throws JsonMappingException, JsonProcessingException {
		OhlcResponse response = mapper.readValue(json, OhlcResponse.class);

		assertNotNull(response);
		OhclPayload result = response.getResult();
		assertNotNull(result);
		List<CandleStick> candleStick = result.getCandleSticks();
		assertEquals(2, candleStick.size());
	}

}
