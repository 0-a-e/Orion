package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public interface ArgumentMarshaller {

    public interface BinaryAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface BinarySetAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface BooleanAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface ListAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface MapAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface NumberAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface NumberSetAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface StringAttributeMarshaller extends ArgumentMarshaller {
    }

    public interface StringSetAttributeMarshaller extends ArgumentMarshaller {
    }

    AttributeValue marshall(Object obj);
}
