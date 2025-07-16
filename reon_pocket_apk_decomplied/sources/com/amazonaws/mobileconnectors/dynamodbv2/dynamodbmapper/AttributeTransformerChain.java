package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.AttributeTransformer;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AttributeTransformerChain implements AttributeTransformer {
    private final List<AttributeTransformer> transformers;

    public AttributeTransformerChain(AttributeTransformer... attributeTransformerArr) {
        this((List<AttributeTransformer>) Arrays.asList(attributeTransformerArr));
    }

    public AttributeTransformerChain(List<AttributeTransformer> list) {
        this.transformers = Collections.unmodifiableList(new ArrayList(list));
    }

    public List<AttributeTransformer> getTransformers() {
        return this.transformers;
    }

    public Map<String, AttributeValue> transform(AttributeTransformer.Parameters<?> parameters) {
        ProxyParameters proxyParameters = new ProxyParameters(parameters);
        for (int i = 0; i < this.transformers.size(); i++) {
            proxyParameters.setAttributeValues(this.transformers.get(i).transform(proxyParameters));
        }
        return proxyParameters.getAttributeValues();
    }

    public Map<String, AttributeValue> untransform(AttributeTransformer.Parameters<?> parameters) {
        ProxyParameters proxyParameters = new ProxyParameters(parameters);
        for (int size = this.transformers.size() - 1; size >= 0; size--) {
            proxyParameters.setAttributeValues(this.transformers.get(size).untransform(proxyParameters));
        }
        return proxyParameters.getAttributeValues();
    }

    public String toString() {
        return this.transformers.toString();
    }

    private static class ProxyParameters<T> implements AttributeTransformer.Parameters<T> {
        private final AttributeTransformer.Parameters<T> delegate;
        private Map<String, AttributeValue> values;

        public ProxyParameters(AttributeTransformer.Parameters<T> parameters) {
            this.delegate = parameters;
            this.values = parameters.getAttributeValues();
        }

        public Map<String, AttributeValue> getAttributeValues() {
            return this.values;
        }

        public void setAttributeValues(Map<String, AttributeValue> map) {
            this.values = Collections.unmodifiableMap(map);
        }

        public boolean isPartialUpdate() {
            return this.delegate.isPartialUpdate();
        }

        public Class<T> getModelClass() {
            return this.delegate.getModelClass();
        }

        public DynamoDBMapperConfig getMapperConfig() {
            return this.delegate.getMapperConfig();
        }

        public String getTableName() {
            return this.delegate.getTableName();
        }

        public String getHashKeyName() {
            return this.delegate.getHashKeyName();
        }

        public String getRangeKeyName() {
            return this.delegate.getRangeKeyName();
        }
    }
}
