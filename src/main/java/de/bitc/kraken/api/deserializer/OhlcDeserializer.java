package de.bitc.kraken.api.deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import de.bitc.kraken.api.model.CandleStick;
import de.bitc.kraken.api.model.OhclPayload;

public class OhlcDeserializer extends JsonDeserializer<OhclPayload> {

	@Override
	public OhclPayload deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		List<CandleStick> candleSticks = new ArrayList<CandleStick>();

		Long last = null;

		ObjectCodec objectCodec = p.getCodec();
		JsonNode jsonNode = objectCodec.readTree(p);

		Iterator<Entry<String, JsonNode>> payloadIterator = jsonNode.fields();
		while (payloadIterator.hasNext()) {
			Map.Entry<String, JsonNode> entry = payloadIterator.next();
			if (entry.getKey().equals("last")) {
				last = entry.getValue().asLong();
			} else if (entry.getValue().isArray()) {
				for (JsonNode node : entry.getValue()) {
					CandleStick cs = p.getCodec().treeToValue(node, CandleStick.class);
					candleSticks.add(cs);
				}
			}
		}

		return new OhclPayload(candleSticks, last);
	}

}
