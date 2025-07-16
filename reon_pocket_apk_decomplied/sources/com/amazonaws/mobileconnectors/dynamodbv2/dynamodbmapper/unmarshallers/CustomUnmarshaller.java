package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public class CustomUnmarshaller extends SUnmarshaller {
    private final Class<?> targetClass;
    private final Class<? extends DynamoDBMarshaller<?>> unmarshallerClass;

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public CustomUnmarshaller(Class<?> cls, Class<? extends DynamoDBMarshaller<?>> cls2) {
        this.targetClass = cls;
        this.unmarshallerClass = cls2;
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return createUnmarshaller(this.unmarshallerClass).unmarshall(this.targetClass, attributeValue.getS());
    }

    private static DynamoDBMarshaller createUnmarshaller(Class<?> cls) {
        try {
            return (DynamoDBMarshaller) cls.newInstance();
        } catch (InstantiationException e) {
            throw new DynamoDBMappingException("Failed to instantiate custom marshaler for class " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new DynamoDBMappingException("Failed to instantiate custom marshaler for class " + cls, e2);
        }
    }
}
