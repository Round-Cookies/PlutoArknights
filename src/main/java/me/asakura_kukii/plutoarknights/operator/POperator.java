package me.asakura_kukii.plutoarknights.operator;

import me.asakura_kukii.plutoarknights.item.PDeco;
import me.asakura_kukii.plutoarknights.item.PEquipment;
import me.asakura_kukii.siegecore.io.PFile;

import java.io.IOException;
import java.util.HashMap;

public class POperator extends PFile {

    public PDeco headDeco = null;

    public HashMap<String, PDeco> attachmentMap = new HashMap<>();

    public PEquipment equipment = null;

    public float life = 100;

    public float attack = 100;

    public float defence = 128;

    public float magicResistance = 10;

    public void selectOperator() {

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
