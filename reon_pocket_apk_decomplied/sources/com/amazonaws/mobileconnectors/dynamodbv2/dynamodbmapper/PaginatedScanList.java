package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.List;

public class PaginatedScanList<T> extends PaginatedList<T> {
    private final DynamoDBMapperConfig config;
    private final ScanRequest scanRequest;
    private ScanResult scanResult;

    public PaginatedScanList(DynamoDBMapper dynamoDBMapper, Class<T> cls, AmazonDynamoDB amazonDynamoDB, ScanRequest scanRequest2, ScanResult scanResult2, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy, DynamoDBMapperConfig dynamoDBMapperConfig) {
        super(dynamoDBMapper, cls, amazonDynamoDB, paginationLoadingStrategy);
        this.scanRequest = scanRequest2;
        this.scanResult = scanResult2;
        this.config = dynamoDBMapperConfig;
        this.allResults.addAll(dynamoDBMapper.marshallIntoObjects(dynamoDBMapper.toParameters(scanResult2.getItems(), cls, scanRequest2.getTableName(), dynamoDBMapperConfig)));
        if (paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING) {
            loadAllResults();
        }
    }

    /* access modifiers changed from: protected */
    public boolean atEndOfResults() {
        return this.scanResult.getLastEvaluatedKey() == null;
    }

    /* access modifiers changed from: protected */
    public synchronized List<T> fetchNextPage() {
        this.scanRequest.setExclusiveStartKey(this.scanResult.getLastEvaluatedKey());
        this.scanResult = this.dynamo.scan((ScanRequest) DynamoDBMapper.applyUserAgent(this.scanRequest));
        return this.mapper.marshallIntoObjects(this.mapper.toParameters(this.scanResult.getItems(), this.clazz, this.scanRequest.getTableName(), this.config));
    }
}
