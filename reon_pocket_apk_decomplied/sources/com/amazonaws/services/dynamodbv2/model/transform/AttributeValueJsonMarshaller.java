package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.json.AwsJsonWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

class AttributeValueJsonMarshaller {
    private static AttributeValueJsonMarshaller instance;

    AttributeValueJsonMarshaller() {
    }

    public void marshall(AttributeValue attributeValue, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (attributeValue.getS() != null) {
            String s = attributeValue.getS();
            awsJsonWriter.name("S");
            awsJsonWriter.value(s);
        }
        if (attributeValue.getN() != null) {
            String n = attributeValue.getN();
            awsJsonWriter.name("N");
            awsJsonWriter.value(n);
        }
        if (attributeValue.getB() != null) {
            ByteBuffer b = attributeValue.getB();
            awsJsonWriter.name("B");
            awsJsonWriter.value(b);
        }
        if (attributeValue.getSS() != null) {
            List<String> ss = attributeValue.getSS();
            awsJsonWriter.name("SS");
            awsJsonWriter.beginArray();
            for (String next : ss) {
                if (next != null) {
                    awsJsonWriter.value(next);
                }
            }
            awsJsonWriter.endArray();
        }
        if (attributeValue.getNS() != null) {
            List<String> ns = attributeValue.getNS();
            awsJsonWriter.name("NS");
            awsJsonWriter.beginArray();
            for (String next2 : ns) {
                if (next2 != null) {
                    awsJsonWriter.value(next2);
                }
            }
            awsJsonWriter.endArray();
        }
        if (attributeValue.getBS() != null) {
            List<ByteBuffer> bs = attributeValue.getBS();
            awsJsonWriter.name("BS");
            awsJsonWriter.beginArray();
            for (ByteBuffer next3 : bs) {
                if (next3 != null) {
                    awsJsonWriter.value(next3);
                }
            }
            awsJsonWriter.endArray();
        }
        if (attributeValue.getM() != null) {
            Map<String, AttributeValue> m = attributeValue.getM();
            awsJsonWriter.name("M");
            awsJsonWriter.beginObject();
            for (Map.Entry next4 : m.entrySet()) {
                AttributeValue attributeValue2 = (AttributeValue) next4.getValue();
                if (attributeValue2 != null) {
                    awsJsonWriter.name((String) next4.getKey());
                    getInstance().marshall(attributeValue2, awsJsonWriter);
                }
            }
            awsJsonWriter.endObject();
        }
        if (attributeValue.getL() != null) {
            List<AttributeValue> l = attributeValue.getL();
            awsJsonWriter.name("L");
            awsJsonWriter.beginArray();
            for (AttributeValue next5 : l) {
                if (next5 != null) {
                    getInstance().marshall(next5, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (attributeValue.getNULL() != null) {
            Boolean bool = attributeValue.getNULL();
            awsJsonWriter.name("NULL");
            awsJsonWriter.value(bool.booleanValue());
        }
        if (attributeValue.getBOOL() != null) {
            Boolean bool2 = attributeValue.getBOOL();
            awsJsonWriter.name("BOOL");
            awsJsonWriter.value(bool2.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static AttributeValueJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeValueJsonMarshaller();
        }
        return instance;
    }
}
