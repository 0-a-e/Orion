package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ItemCollectionMetrics;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;
import java.util.Map;

class ItemCollectionMetricsJsonMarshaller {
    private static ItemCollectionMetricsJsonMarshaller instance;

    ItemCollectionMetricsJsonMarshaller() {
    }

    public void marshall(ItemCollectionMetrics itemCollectionMetrics, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (itemCollectionMetrics.getItemCollectionKey() != null) {
            Map<String, AttributeValue> itemCollectionKey = itemCollectionMetrics.getItemCollectionKey();
            awsJsonWriter.name("ItemCollectionKey");
            awsJsonWriter.beginObject();
            for (Map.Entry next : itemCollectionKey.entrySet()) {
                AttributeValue attributeValue = (AttributeValue) next.getValue();
                if (attributeValue != null) {
                    awsJsonWriter.name((String) next.getKey());
                    AttributeValueJsonMarshaller.getInstance().marshall(attributeValue, awsJsonWriter);
                }
            }
            awsJsonWriter.endObject();
        }
        if (itemCollectionMetrics.getSizeEstimateRangeGB() != null) {
            List<Double> sizeEstimateRangeGB = itemCollectionMetrics.getSizeEstimateRangeGB();
            awsJsonWriter.name("SizeEstimateRangeGB");
            awsJsonWriter.beginArray();
            for (Double next2 : sizeEstimateRangeGB) {
                if (next2 != null) {
                    awsJsonWriter.value((Number) next2);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static ItemCollectionMetricsJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ItemCollectionMetricsJsonMarshaller();
        }
        return instance;
    }
}
