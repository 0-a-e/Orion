package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.S3ClientCache;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.S3Link;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public class S3LinkUnmarshaller extends SUnmarshaller {
    private static final S3LinkUnmarshaller INSTANCE = new S3LinkUnmarshaller();
    private final S3ClientCache clientCache;

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static S3LinkUnmarshaller instance() {
        return INSTANCE;
    }

    private S3LinkUnmarshaller() {
        this((S3ClientCache) null);
    }

    public S3LinkUnmarshaller(S3ClientCache s3ClientCache) {
        this.clientCache = s3ClientCache;
    }

    public Object unmarshall(AttributeValue attributeValue) {
        S3ClientCache s3ClientCache = this.clientCache;
        if (s3ClientCache != null) {
            return S3Link.fromJson(s3ClientCache, attributeValue.getS());
        }
        throw new IllegalStateException("Mapper must be constructed with S3 AWS Credentials to load S3Link");
    }
}
