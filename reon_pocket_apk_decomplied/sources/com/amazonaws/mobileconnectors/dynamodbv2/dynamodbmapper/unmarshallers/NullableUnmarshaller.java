package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.text.ParseException;

public class NullableUnmarshaller implements ArgumentUnmarshaller {
    private final ArgumentUnmarshaller wrapped;

    public NullableUnmarshaller(ArgumentUnmarshaller argumentUnmarshaller) {
        if (argumentUnmarshaller != null) {
            this.wrapped = argumentUnmarshaller;
            return;
        }
        throw new NullPointerException("wrapped");
    }

    public void typeCheck(AttributeValue attributeValue, Method method) {
        if (attributeValue.isNULL() == null) {
            this.wrapped.typeCheck(attributeValue, method);
        }
    }

    public Object unmarshall(AttributeValue attributeValue) throws ParseException {
        if (attributeValue.isNULL() != null) {
            return null;
        }
        return this.wrapped.unmarshall(attributeValue);
    }
}
