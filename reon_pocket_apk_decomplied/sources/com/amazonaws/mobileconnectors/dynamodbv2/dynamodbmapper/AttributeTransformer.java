package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

public interface AttributeTransformer {

    public interface Parameters<T> {
        Map<String, AttributeValue> getAttributeValues();

        String getHashKeyName();

        DynamoDBMapperConfig getMapperConfig();

        Class<T> getModelClass();

        String getRangeKeyName();

        String getTableName();

        boolean isPartialUpdate();
    }

    Map<String, AttributeValue> transform(Parameters<?> parameters);

    Map<String, AttributeValue> untransform(Parameters<?> parameters);
}
