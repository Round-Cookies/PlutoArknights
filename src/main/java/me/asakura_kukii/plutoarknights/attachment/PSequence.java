package me.asakura_kukii.plutoarknights.attachment;

import java.util.ArrayList;
import java.util.List;

public class PSequence {

    public String targetId = "";

    public List<PTransformation> transformationList = new ArrayList<>();

    public int getFrameCount() {
        return this.transformationList.size();
    }

    public PTransformation get(int frameIndex) {
        if (this.transformationList.size() <= frameIndex) return null;
        return this.transformationList.get(frameIndex);
    }
}
