package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.Map;

public interface ItemConverter {
    AttributeValue convert(Method method, Object obj);

    Map<String, AttributeValue> convert(Object obj);

    DynamoDBMapperFieldModel getFieldModel(Method method);

    <T> T unconvert(Class<T> cls, Map<String, AttributeValue> map);

    Object unconvert(Method method, Method method2, AttributeValue attributeValue);
}
