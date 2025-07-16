package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

abstract class SSUnmarshaller implements ArgumentUnmarshaller {
    SSUnmarshaller() {
    }

    public void typeCheck(AttributeValue attributeValue, Method method) {
        if (attributeValue.getSS() == null) {
            throw new DynamoDBMappingException("Expected SS in value " + attributeValue + " when invoking " + method);
        }
    }
}
