package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMappingException;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class CustomMarshaller implements ArgumentMarshaller.StringAttributeMarshaller {
    private final Class<? extends DynamoDBMarshaller<?>> marshallerClass;

    public CustomMarshaller(Class<? extends DynamoDBMarshaller<?>> cls) {
        this.marshallerClass = cls;
    }

    public AttributeValue marshall(Object obj) {
        String marshall = createMarshaller(this.marshallerClass).marshall(obj);
        if (marshall == null) {
            return null;
        }
        return new AttributeValue(marshall);
    }

    private static DynamoDBMarshaller<Object> createMarshaller(Class<?> cls) {
        try {
            return (DynamoDBMarshaller) cls.newInstance();
        } catch (InstantiationException e) {
            throw new DynamoDBMappingException("Failed to instantiate custom marshaler for class " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new DynamoDBMappingException("Failed to instantiate custom marshaler for class " + cls, e2);
        }
    }
}
