package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.List;

public class PaginatedQueryList<T> extends PaginatedList<T> {
    private final DynamoDBMapperConfig config;
    private final QueryRequest queryRequest;
    private QueryResult queryResult;

    public PaginatedQueryList(DynamoDBMapper dynamoDBMapper, Class<T> cls, AmazonDynamoDB amazonDynamoDB, QueryRequest queryRequest2, QueryResult queryResult2, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy, DynamoDBMapperConfig dynamoDBMapperConfig) {
        super(dynamoDBMapper, cls, amazonDynamoDB, paginationLoadingStrategy);
        this.queryRequest = queryRequest2;
        this.queryResult = queryResult2;
        this.config = dynamoDBMapperConfig;
        this.allResults.addAll(dynamoDBMapper.marshallIntoObjects(dynamoDBMapper.toParameters(queryResult2.getItems(), cls, queryRequest2.getTableName(), dynamoDBMapperConfig)));
        if (paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING) {
            loadAllResults();
        }
    }

    /* access modifiers changed from: protected */
    public boolean atEndOfResults() {
        return this.queryResult.getLastEvaluatedKey() == null;
    }

    /* access modifiers changed from: protected */
    public synchronized List<T> fetchNextPage() {
        this.queryRequest.setExclusiveStartKey(this.queryResult.getLastEvaluatedKey());
        this.queryResult = this.dynamo.query((QueryRequest) DynamoDBMapper.applyUserAgent(this.queryRequest));
        return this.mapper.marshallIntoObjects(this.mapper.toParameters(this.queryResult.getItems(), this.clazz, this.queryRequest.getTableName(), this.config));
    }
}
