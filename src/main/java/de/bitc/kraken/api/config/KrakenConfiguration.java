package de.bitc.kraken.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "de.bitc.kraken.api.client")
@Import(FeignClientsConfiguration.class)
public class KrakenConfiguration {

	/**
	 * Set the Feign specific log level to log client REST requests.
	 */
	@Bean
	feign.Logger.Level feignLoggerLevel() {
		return feign.Logger.Level.BASIC;
	}

}
