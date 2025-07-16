package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class BooleanUnmarshaller implements ArgumentUnmarshaller {
    private static final BooleanUnmarshaller INSTANCE = new BooleanUnmarshaller();

    public static BooleanUnmarshaller instance() {
        return INSTANCE;
    }

    private BooleanUnmarshaller() {
    }

    public void typeCheck(AttributeValue attributeValue, Method method) {
        if (attributeValue.getN() == null && attributeValue.getBOOL() == null) {
            throw new DynamoDBMappingException("Expected either N or BOOL in value " + attributeValue + " when invoking " + method);
        }
    }

    public Object unmarshall(AttributeValue attributeValue) {
        if (attributeValue.getBOOL() != null) {
            return attributeValue.getBOOL();
        }
        if ("1".equals(attributeValue.getN())) {
            return Boolean.TRUE;
        }
        if ("0".equals(attributeValue.getN())) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException("Expected '1', '0', or BOOL value for boolean value, was " + attributeValue);
    }
}
