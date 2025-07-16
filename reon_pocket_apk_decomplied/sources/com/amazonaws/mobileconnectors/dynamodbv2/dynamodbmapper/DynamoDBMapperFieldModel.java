package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

public class DynamoDBMapperFieldModel {
    private final ArgumentMarshaller argumentMarshaller;
    private final String dynamoDBAttributeName;
    private final DynamoDBAttributeType dynamoDBAttributeType;

    public enum DynamoDBAttributeType {
        S,
        N,
        B,
        SS,
        NS,
        BS,
        BOOL,
        NULL,
        L,
        M
    }

    public DynamoDBMapperFieldModel(String str, DynamoDBAttributeType dynamoDBAttributeType2, ArgumentMarshaller argumentMarshaller2) {
        this.dynamoDBAttributeName = str;
        this.dynamoDBAttributeType = dynamoDBAttributeType2;
        this.argumentMarshaller = argumentMarshaller2;
    }

    public String getDynamoDBAttributeName() {
        return this.dynamoDBAttributeName;
    }

    public DynamoDBAttributeType getDynamoDBAttributeType() {
        return this.dynamoDBAttributeType;
    }

    /* access modifiers changed from: package-private */
    public ArgumentMarshaller getArgumentMarshaller() {
        return this.argumentMarshaller;
    }
}
