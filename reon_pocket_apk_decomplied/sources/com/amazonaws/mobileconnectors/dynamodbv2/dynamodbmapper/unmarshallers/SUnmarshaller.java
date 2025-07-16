package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

abstract class SUnmarshaller implements ArgumentUnmarshaller {
    SUnmarshaller() {
    }

    public void typeCheck(AttributeValue attributeValue, Method method) {
        if (attributeValue.getS() == null) {
            throw new DynamoDBMappingException("Expected S in value " + attributeValue + " when invoking " + method);
        }
    }
}
