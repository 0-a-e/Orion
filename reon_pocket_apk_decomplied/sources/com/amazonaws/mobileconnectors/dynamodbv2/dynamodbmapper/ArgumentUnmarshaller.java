package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.text.ParseException;

public interface ArgumentUnmarshaller {
    void typeCheck(AttributeValue attributeValue, Method method);

    Object unmarshall(AttributeValue attributeValue) throws ParseException;
}
