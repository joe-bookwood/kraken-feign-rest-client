package de.bitc.kraken.api.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import de.bitc.kraken.api.config.WireMockConfig;
import de.bitc.kraken.api.model.BalanceResponse;
import de.bitc.kraken.api.model.OpenOrderResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import wiremock.org.apache.commons.io.IOUtils;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApp.class)
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ComponentScan("de.bitc")
@ContextConfiguration(classes = { WireMockConfig.class })
class PrivateApiIT {
	private static final String API_KEY = "gca72q69nRandomGeneratedTestExampleI1Xr/WmrDTOnXGU5cMjud";

	private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

	@Autowired
	private PrivateApi privateApi;

	@Autowired
	private WireMockServer mockKrakenService;

	private String jsonBalanceAnswer;

	private String jsonOpenOrdersAnswer ;

	@BeforeEach
	void setUp() throws Exception {
		jsonBalanceAnswer = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/balance.json"));
		jsonOpenOrdersAnswer = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/open-orders.json"));
	}

	@Test
	void testBalance() throws InvalidKeyException, NoSuchAlgorithmException {
		mockKrakenService.stubFor(post(urlEqualTo("/0/private/Balance")).willReturn(
				aResponse().withHeader("Content-Type", "application/json; charset=utf-8").withBody(jsonBalanceAnswer)));
		BalanceResponse response = privateApi.getBalance(API_KEY,
				"fRF3XSNJO++5RandomizedTestExamplejsepwS634PJGylaIYeEY4gzuWVuL3JkM23vrN1Cr66ibCvQqh65Hz==");
		Assertions.assertNotNull(response);
	}

	@Test
	void testOrder() throws InvalidKeyException, NoSuchAlgorithmException {
		mockKrakenService.stubFor(post(urlEqualTo("/0/private/OpenOrders")).willReturn(
				aResponse().withHeader("Content-Type", "application/json; charset=utf-8")
						.withBody(jsonOpenOrdersAnswer)));
		OpenOrderResponse response = privateApi.getOpenOrders(API_KEY,
				"fRF3XSNJO++5RandomizedTestExamplejsepwS634PJGylaIYeEY4gzuWVuL3JkM23vrN1Cr66ibCvQqh65Hz==");
		Assertions.assertNotNull(response);
	}

	@Configuration
	public static class BalanceTestConfiguration {

		@Bean
		public ServerList<Server> ribbonServerList() {
			return new StaticServerList<>(new Server("localhost", 9561));
		}
	}
}
