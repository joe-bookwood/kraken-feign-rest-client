package de.bitc.kraken.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OhclResponseTest {

	private String json;
	private ObjectMapper mapper;

	@BeforeEach
	void setUp() throws Exception {
		mapper = new ObjectMapper();

		json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/ohlc.json"),
				Charset.defaultCharset());
	}

	@Test
	void test() throws JsonProcessingException {
		OhlcResponse response = mapper.readValue(json, OhlcResponse.class);

		assertNotNull(response);
		OhclPayload result = response.getResult();
		assertNotNull(result);
		List<CandleStick> candleStick = result.getCandleSticks();
		Assertions.assertEquals(8, candleStick.size());
		Assertions.assertEquals("2023-10-23T16:39Z",candleStick.get(6).getTime().toString());
	}

}
