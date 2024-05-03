package me.asakura_kukii.plutoarknights.player;

import me.asakura_kukii.plutoarknights.attachment.PTransformation;
import me.asakura_kukii.plutoarknights.operator.POperator;
import me.asakura_kukii.siegecore.player.PAbstractPlayer;
import me.asakura_kukii.siegecore.util.math.PVector;

import java.io.IOException;

public class PArknightsPlayer extends PAbstractPlayer {

    public POperator pO = null;

    public PTransformation getPTransformation() {
        return new PTransformation(this.getLocation(), this.getRotation(), new PVector(1, 1, 1));
    }

    @Override
    public void finalizeDeserialization() throws IOException {

    }

    @Override
    public void defaultValue() {

    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }
}
