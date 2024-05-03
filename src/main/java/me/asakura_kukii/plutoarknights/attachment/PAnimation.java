package me.asakura_kukii.plutoarknights.attachment;

import me.asakura_kukii.siegecore.io.PFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PAnimation extends PFile {

    public boolean flagLoop = false;

    public List<PSequence> sequenceList = new ArrayList<>();

    public transient int frameCount = 0;

    public HashMap<String, PTransformation> getTargetFrameMap(int frameIndex) {
        HashMap<String, PTransformation> targetFrameMap = new HashMap<>();
        for (PSequence pS : sequenceList) {
            targetFrameMap.put(pS.targetId, pS.get(frameIndex));
        }
        return targetFrameMap;
    }

    @Override
    public void finalizeDeserialization() throws IOException {
        for (PSequence pS : sequenceList) {
            if (pS.getFrameCount() > frameCount) this.frameCount = pS.getFrameCount();
        }
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
