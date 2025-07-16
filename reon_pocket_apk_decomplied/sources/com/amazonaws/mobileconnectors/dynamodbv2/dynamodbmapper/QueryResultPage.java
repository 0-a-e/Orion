package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.List;
import java.util.Map;

public class QueryResultPage<T> {
    private Map<String, AttributeValue> lastEvaluatedKey;
    private List<T> results;

    public List<T> getResults() {
        return this.results;
    }

    public void setResults(List<T> list) {
        this.results = list;
    }

    public Map<String, AttributeValue> getLastEvaluatedKey() {
        return this.lastEvaluatedKey;
    }

    public void setLastEvaluatedKey(Map<String, AttributeValue> map) {
        this.lastEvaluatedKey = map;
    }
}
