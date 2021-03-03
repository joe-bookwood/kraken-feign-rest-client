package de.bitc.kraken.api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import java.io.IOException;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApp.class)
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ComponentScan("de.bitc")
//@ContextConfiguration(classes = { WireMockConfig.class })
class KrakenPrivateApiClientIT {

	@Autowired
	private KrakenPrivateApiClient krakenPrivateApiClient;

	@Autowired
	private WireMockServer mockKrakenService;

	@ClassRule
	public static WireMockRule wireMockRule = new WireMockRule(options().port(9561));

	@BeforeEach
	void setUp() throws IOException {
		wireMockRule.stubFor(post(urlPathMatching("/0/private/")).withHeader("API-Key",
				equalTo("gca72q69nRandomGeneratedTestExampleI1Xr/WmrDTOnXGU5cMjud")));
//		mockKrakenService.stubFor(WireMock.get(WireMock.urlEqualTo("/Balance"))
//				.willReturn(WireMock.aResponse().withStatus(HttpStatus.OK.value())
//						.withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
//						.withBody(IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/balance.json"),
//								Charset.defaultCharset()))));
	}

//
//	@Test
//	public void testBalance() {
//		BalanceResponse result = krakenPrivateApiClient.fetchBalance();
//		assertNull(result);
//	}

//	@Configuration
//	public static class TestConfiguration {
//
//		@Bean()
//		public ServerList<Server> ribbonServerList() {
//			return new StaticServerList<>(new Server("localhost", 9561));
//		}
//	}
}
