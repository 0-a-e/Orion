package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.List;

public class ListToListMarshaller implements ArgumentMarshaller.ListAttributeMarshaller {
    private static final ListToListMarshaller INSTANCE = new ListToListMarshaller();
    private final ArgumentMarshaller memberMarshaller;

    public static ListToListMarshaller instance() {
        return INSTANCE;
    }

    private ListToListMarshaller() {
        this((ArgumentMarshaller) null);
    }

    public ListToListMarshaller(ArgumentMarshaller argumentMarshaller) {
        this.memberMarshaller = argumentMarshaller;
    }

    public AttributeValue marshall(Object obj) {
        AttributeValue attributeValue;
        if (this.memberMarshaller != null) {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (Object next : list) {
                if (next == null) {
                    attributeValue = new AttributeValue().withNULL(true);
                } else {
                    attributeValue = this.memberMarshaller.marshall(next);
                }
                arrayList.add(attributeValue);
            }
            AttributeValue attributeValue2 = new AttributeValue();
            attributeValue2.setL(arrayList);
            return attributeValue2;
        }
        throw new IllegalStateException("No member marshaller configured!");
    }

    public ArgumentMarshaller getMemberMarshaller() {
        return this.memberMarshaller;
    }
}
