package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class DescribeContinuousBackupsResult implements Serializable {
    private ContinuousBackupsDescription continuousBackupsDescription;

    public ContinuousBackupsDescription getContinuousBackupsDescription() {
        return this.continuousBackupsDescription;
    }

    public void setContinuousBackupsDescription(ContinuousBackupsDescription continuousBackupsDescription2) {
        this.continuousBackupsDescription = continuousBackupsDescription2;
    }

    public DescribeContinuousBackupsResult withContinuousBackupsDescription(ContinuousBackupsDescription continuousBackupsDescription2) {
        this.continuousBackupsDescription = continuousBackupsDescription2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getContinuousBackupsDescription() != null) {
            sb.append("ContinuousBackupsDescription: " + getContinuousBackupsDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        if (getContinuousBackupsDescription() == null) {
            i = 0;
        } else {
            i = getContinuousBackupsDescription().hashCode();
        }
        return 31 + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeContinuousBackupsResult)) {
            return false;
        }
        DescribeContinuousBackupsResult describeContinuousBackupsResult = (DescribeContinuousBackupsResult) obj;
        if ((describeContinuousBackupsResult.getContinuousBackupsDescription() == null) ^ (getContinuousBackupsDescription() == null)) {
            return false;
        }
        return describeContinuousBackupsResult.getContinuousBackupsDescription() == null || describeContinuousBackupsResult.getContinuousBackupsDescription().equals(getContinuousBackupsDescription());
    }
}
