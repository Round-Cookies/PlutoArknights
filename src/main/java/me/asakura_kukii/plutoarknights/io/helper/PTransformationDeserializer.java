package me.asakura_kukii.plutoarknights.io.helper;

import me.asakura_kukii.lib.jackson.core.JsonParser;
import me.asakura_kukii.lib.jackson.core.JsonToken;
import me.asakura_kukii.lib.jackson.databind.DeserializationContext;
import me.asakura_kukii.lib.jackson.databind.JsonDeserializer;
import me.asakura_kukii.plutoarknights.attachment.PTransformation;
import me.asakura_kukii.siegecore.util.math.PVector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PTransformationDeserializer extends JsonDeserializer<PTransformation> {

    @Override
    public PTransformation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        List<Double> valueList = new ArrayList<>();
        if (jsonParser.currentToken() == JsonToken.START_ARRAY) {
            jsonParser.nextToken();
            while (jsonParser.currentToken() != JsonToken.END_ARRAY) {
                valueList.add(jsonParser.getDoubleValue());
                jsonParser.nextToken();
            }
        }
        if (valueList.size() != 10) throw new IOException("Could not resolve PTransformation [" + jsonParser.getText() + "]");
        return new PTransformation(
                valueList.get(0).floatValue(),
                valueList.get(1).floatValue(),
                valueList.get(2).floatValue(),
                valueList.get(3).floatValue(),
                valueList.get(4).floatValue(),
                valueList.get(5).floatValue(),
                valueList.get(6).floatValue(),
                valueList.get(7).floatValue(),
                valueList.get(8).floatValue(),
                valueList.get(9).floatValue()
        );
    }
}