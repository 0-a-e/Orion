package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateMacResult implements Serializable {
    private String keyId;
    private ByteBuffer mac;
    private String macAlgorithm;

    public ByteBuffer getMac() {
        return this.mac;
    }

    public void setMac(ByteBuffer byteBuffer) {
        this.mac = byteBuffer;
    }

    public GenerateMacResult withMac(ByteBuffer byteBuffer) {
        this.mac = byteBuffer;
        return this;
    }

    public String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public void setMacAlgorithm(String str) {
        this.macAlgorithm = str;
    }

    public GenerateMacResult withMacAlgorithm(String str) {
        this.macAlgorithm = str;
        return this;
    }

    public void setMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
    }

    public GenerateMacResult withMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GenerateMacResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getMac() != null) {
            sb.append("Mac: " + getMac() + ",");
        }
        if (getMacAlgorithm() != null) {
            sb.append("MacAlgorithm: " + getMacAlgorithm() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getMac() == null ? 0 : getMac().hashCode()) + 31) * 31) + (getMacAlgorithm() == null ? 0 : getMacAlgorithm().hashCode())) * 31;
        if (getKeyId() != null) {
            i = getKeyId().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateMacResult)) {
            return false;
        }
        GenerateMacResult generateMacResult = (GenerateMacResult) obj;
        if ((generateMacResult.getMac() == null) ^ (getMac() == null)) {
            return false;
        }
        if (generateMacResult.getMac() != null && !generateMacResult.getMac().equals(getMac())) {
            return false;
        }
        if ((generateMacResult.getMacAlgorithm() == null) ^ (getMacAlgorithm() == null)) {
            return false;
        }
        if (generateMacResult.getMacAlgorithm() != null && !generateMacResult.getMacAlgorithm().equals(getMacAlgorithm())) {
            return false;
        }
        if ((generateMacResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return generateMacResult.getKeyId() == null || generateMacResult.getKeyId().equals(getKeyId());
    }
}
