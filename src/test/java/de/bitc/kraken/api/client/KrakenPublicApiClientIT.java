package de.bitc.kraken.api.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApp.class)
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ComponentScan("de.bitc")
class KrakenPublicApiClientIT {

	@Autowired
	private KrakenTestService service;

	@Test
	void testAssets() {
		Optional<Set<String>> optionalAssets = service.getAssets();
		Assertions.assertTrue(optionalAssets.isPresent());
		Set<String> set = optionalAssets.get();
		Assertions.assertNotNull(set);
	}

}
