package com.amazonaws.services.s3;

import com.amazonaws.ResponseMetadata;
import java.util.Map;

public class S3ResponseMetadata extends ResponseMetadata {
    public static final String CLOUD_FRONT_ID = "CLOUD_FRONT_ID";
    public static final String HOST_ID = "HOST_ID";

    public S3ResponseMetadata(Map<String, String> map) {
        super(map);
    }

    public S3ResponseMetadata(ResponseMetadata responseMetadata) {
        super(responseMetadata);
    }

    public String getHostId() {
        return (String) this.metadata.get(HOST_ID);
    }

    public String getCloudFrontId() {
        return (String) this.metadata.get(CLOUD_FRONT_ID);
    }
}
