package de.bitc.kraken.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class EpochMilliesToZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {


	@Override
	public ZonedDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		if (parser.hasToken(JsonToken.VALUE_NUMBER_INT)) {
			long nullValue = parser.getLongValue();
			if (nullValue == 0L) {
				return null;
			}
		}
		if (parser.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
			BigDecimal value = parser.getDecimalValue();
			long longValue = value.multiply(new BigDecimal(1000)).longValue();
			Instant instant = Instant.ofEpochMilli(longValue);

            return ZonedDateTime.ofInstant(instant, ZoneOffset.UTC.normalized());
		}
		return null;
	}

}
