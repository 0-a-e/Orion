package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashMap;
import java.util.Map;

public class MapToMapMarshaller implements ArgumentMarshaller.MapAttributeMarshaller {
    private static final MapToMapMarshaller INSTANCE = new MapToMapMarshaller();
    private final ArgumentMarshaller memberMarshaller;

    public static MapToMapMarshaller instance() {
        return INSTANCE;
    }

    private MapToMapMarshaller() {
        this.memberMarshaller = null;
    }

    public MapToMapMarshaller(ArgumentMarshaller argumentMarshaller) {
        if (argumentMarshaller != null) {
            this.memberMarshaller = argumentMarshaller;
            return;
        }
        throw new NullPointerException("memberMarshaller");
    }

    public AttributeValue marshall(Object obj) {
        AttributeValue attributeValue;
        if (this.memberMarshaller != null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (entry.getValue() == null) {
                    attributeValue = new AttributeValue().withNULL(true);
                } else {
                    attributeValue = this.memberMarshaller.marshall(entry.getValue());
                }
                hashMap.put(entry.getKey(), attributeValue);
            }
            AttributeValue attributeValue2 = new AttributeValue();
            attributeValue2.setM(hashMap);
            return attributeValue2;
        }
        throw new IllegalStateException("No member marshaller configured!");
    }

    public ArgumentMarshaller getMemberMarshaller() {
        return this.memberMarshaller;
    }
}
