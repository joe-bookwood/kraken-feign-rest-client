package de.bitc.kraken.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class EpochToZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

	@Override
	public ZonedDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		if(parser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
			long value = parser.getValueAsLong();
			Instant instant = Instant.ofEpochSecond(value);

			return ZonedDateTime.ofInstant(instant, ZoneOffset.UTC.normalized());
		}
		return null;
	}

}
