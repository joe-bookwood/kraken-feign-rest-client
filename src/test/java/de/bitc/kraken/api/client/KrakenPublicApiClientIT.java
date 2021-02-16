package de.bitc.kraken.api.client;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
class KrakenPublicApiClientIT {

	@Autowired
	private KrakenTestService service;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Set<String> set = service.getAssets();
		assertNotNull(set);
	}

}
