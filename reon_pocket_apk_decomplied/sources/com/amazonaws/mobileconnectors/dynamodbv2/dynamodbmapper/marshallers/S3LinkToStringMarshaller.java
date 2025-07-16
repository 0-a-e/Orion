package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.S3Link;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public final class S3LinkToStringMarshaller implements ArgumentMarshaller.StringAttributeMarshaller {
    private static final S3LinkToStringMarshaller INSTANCE = new S3LinkToStringMarshaller();

    public static S3LinkToStringMarshaller instance() {
        return INSTANCE;
    }

    private S3LinkToStringMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        S3Link s3Link = (S3Link) obj;
        if (s3Link.getBucketName() == null || s3Link.getKey() == null) {
            return null;
        }
        return new AttributeValue().withS(s3Link.toJson());
    }
}
