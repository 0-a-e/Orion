package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public final class ListUnmarshaller extends LUnmarshaller {
    private static final ListUnmarshaller INSTANCE = new ListUnmarshaller();
    private final ArgumentUnmarshaller memberUnmarshaller;

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ListUnmarshaller instance() {
        return INSTANCE;
    }

    private ListUnmarshaller() {
        this.memberUnmarshaller = null;
    }

    public ListUnmarshaller(ArgumentUnmarshaller argumentUnmarshaller) {
        if (argumentUnmarshaller != null) {
            this.memberUnmarshaller = argumentUnmarshaller;
            return;
        }
        throw new NullPointerException("memberUnmarshaller");
    }

    public Object unmarshall(AttributeValue attributeValue) throws ParseException {
        List<AttributeValue> l = attributeValue.getL();
        ArrayList arrayList = new ArrayList(l.size());
        for (AttributeValue next : l) {
            this.memberUnmarshaller.typeCheck(next, (Method) null);
            arrayList.add(this.memberUnmarshaller.unmarshall(next));
        }
        return arrayList;
    }
}
