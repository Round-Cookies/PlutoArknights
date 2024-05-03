package me.asakura_kukii.plutoarknights.attachment;

import org.bukkit.util.Transformation;
import me.asakura_kukii.siegecore.util.math.PQuaternion;
import me.asakura_kukii.siegecore.util.math.PVector;

public class PTransformation implements Cloneable {

    public PTransformation() {}

    public PTransformation(PVector vector, PQuaternion quaternion, PVector scale) {
        this.vector = vector;
        this.quaternion = quaternion;
        this.scale = scale;
    }

    public PTransformation(float vx, float vy, float vz, float qx, float qy, float qz, float qw, float sx, float sy, float sz) {
        this.vector = new PVector(vx, vy, vz);
        this.quaternion = new PQuaternion(qx, qy, qz, qw);
        this.scale = new PVector(sx, sy, sz);
    }

    public PVector vector = new PVector();

    public PQuaternion quaternion = new PQuaternion();

    public PVector scale = new PVector();

    public PTransformation mul(PTransformation pT) {
        PTransformation result = this.clone();
        result.vector = (PVector) result.vector.add(pT.vector);
        result.quaternion = (PQuaternion) result.quaternion.premul(pT.quaternion);
        result.scale = (PVector) result.scale.mul(pT.scale);
        return result;
    }

    public Transformation toTransformation() {
        return new org.bukkit.util.Transformation(
                this.vector,
                this.quaternion,
                this.scale,
                new PQuaternion()
        );
    }

    public PTransformation clone() {
        try {
            PTransformation pT = (PTransformation) super.clone();
            pT.vector = this.vector.clone();
            pT.quaternion = this.quaternion.clone();
            pT.scale = this.scale.clone();
            return pT;
        } catch (Exception ignored) {
            return null;
        }
    }

}
