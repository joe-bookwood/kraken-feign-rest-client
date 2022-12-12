package de.bitc.kraken.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BalanceResponseTest {

	private ObjectMapper mapper;
	private String json;

	@BeforeEach
	void setUp() throws Exception {
		mapper = new ObjectMapper();

		json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/balance.json"),
				Charset.defaultCharset());

	}

	@Test
	void test() throws JsonProcessingException {
		BalanceResponse balanceResponse = mapper.readValue(json, BalanceResponse.class);

		assertNotNull(balanceResponse);
		BigDecimal xxbt = balanceResponse.getResult().get("XXBT");
		assertNotNull(xxbt);

		Assertions.assertEquals( "0.0000679600",xxbt.toString());
	}

}
