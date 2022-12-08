package de.bitc.kraken.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TimeResponseTest {

    private ObjectMapper mapper;
    private String json;

    @BeforeEach
    void setUp() throws IOException {
        mapper = new ObjectMapper();

        json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/server-time.json"),
                Charset.defaultCharset());

    }

    @Test
    void timeResponseTest() throws JsonProcessingException {
        TimeResponse timeResponse = mapper.readValue(json, TimeResponse.class);
        assertNotNull(timeResponse);
        assertEquals("2022-12-08T06:37:11Z",timeResponse.getResult().getUnixtime().toString());
        assertEquals("Thu, 08 Dec 22 06:37:11 +0000", timeResponse.getResult().getRfc1123());
    }
}
