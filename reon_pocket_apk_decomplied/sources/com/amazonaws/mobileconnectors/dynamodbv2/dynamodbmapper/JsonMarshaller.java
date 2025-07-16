package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.google.gson.Gson;

public class JsonMarshaller<T> implements DynamoDBMarshaller<T> {
    private static Gson gson = new Gson();

    public String marshall(T t) {
        return gson.toJson((Object) t);
    }

    public T unmarshall(Class<T> cls, String str) {
        try {
            return gson.fromJson(str, cls);
        } catch (Exception e) {
            throw new RuntimeException("Unable to unmarshall the string " + str + "into " + cls, e);
        }
    }
}
