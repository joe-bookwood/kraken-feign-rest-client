package de.bitc.kraken.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class StatusResponseTest {

    private ObjectMapper mapper;
    private String json;

    @BeforeEach
    void setUp() throws IOException {
        mapper = new ObjectMapper();

        json = IOUtils.toString(this.getClass().getResourceAsStream("/kraken/json/server-status.json"),
                Charset.defaultCharset());

    }

    @Test
    void statusResponseTest() throws JsonProcessingException {
        StatusResponse statusResponse = mapper.readValue(json, StatusResponse.class);
        assertNotNull(statusResponse);
        assertEquals("online", statusResponse.getResult().getStatus());
        assertEquals("2022-12-08T06:39:37Z", statusResponse.getResult().getTimestamp());
    }
}
