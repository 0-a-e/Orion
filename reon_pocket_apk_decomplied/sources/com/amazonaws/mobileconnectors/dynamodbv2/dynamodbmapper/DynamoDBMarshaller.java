package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

public interface DynamoDBMarshaller<T> {
    String marshall(T t);

    T unmarshall(Class<T> cls, String str);
}
