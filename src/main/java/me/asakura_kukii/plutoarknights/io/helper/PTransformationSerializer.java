package me.asakura_kukii.plutoarknights.io.helper;

import me.asakura_kukii.lib.jackson.core.JsonGenerator;
import me.asakura_kukii.lib.jackson.databind.JsonSerializer;
import me.asakura_kukii.lib.jackson.databind.SerializerProvider;
import me.asakura_kukii.plutoarknights.attachment.PTransformation;
import me.asakura_kukii.siegecore.util.math.PVector;

import java.io.IOException;

public class PTransformationSerializer extends JsonSerializer<PTransformation> {
    @Override
    public void serialize(PTransformation pTransformation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (pTransformation == null) {
            jsonGenerator.writeArray(new double[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, 0, 10);
        } else {
            jsonGenerator.writeArray(new double[]{
                    pTransformation.vector.x,
                    pTransformation.vector.y,
                    pTransformation.vector.z,
                    pTransformation.quaternion.x,
                    pTransformation.quaternion.y,
                    pTransformation.quaternion.z,
                    pTransformation.quaternion.w,
                    pTransformation.scale.x,
                    pTransformation.scale.y,
                    pTransformation.scale.z,
            }, 0, 3);
        }
    }
}