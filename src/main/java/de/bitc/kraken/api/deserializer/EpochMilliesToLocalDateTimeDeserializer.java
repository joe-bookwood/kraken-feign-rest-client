package de.bitc.kraken.api.deserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class EpochMilliesToLocalDateTimeDeserializer extends LocalDateTimeDeserializer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5132749395514563528L;

	public EpochMilliesToLocalDateTimeDeserializer() {
		super(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
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

            return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		}
		return super.deserialize(parser, context);
	}

}