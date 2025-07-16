package com.amazonaws.services.dynamodbv2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazonaws.services.dynamodbv2.model.CreateBackupRequest;
import com.amazonaws.services.dynamodbv2.model.CreateBackupResult;
import com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteBackupResult;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeBackupResult;
import com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.ListBackupsRequest;
import com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest;
import com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult;
import com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest;
import com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.TagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.UntagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonDynamoDBAsyncClient extends AmazonDynamoDBClient implements AmazonDynamoDBAsync {
    private static final int DEFAULT_THREAD_POOL_SIZE = 10;
    private ExecutorService executorService;

    @Deprecated
    public AmazonDynamoDBAsyncClient() {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain());
    }

    @Deprecated
    public AmazonDynamoDBAsyncClient(ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newFixedThreadPool(10));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService2) {
        super(aWSCredentials);
        this.executorService = executorService2;
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService2) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService2;
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newFixedThreadPool(10));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService2) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService2);
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService2) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService2;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }

    public Future<BatchGetItemResult> batchGetItemAsync(final BatchGetItemRequest batchGetItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchGetItemResult>() {
            public BatchGetItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.batchGetItem(batchGetItemRequest);
            }
        });
    }

    public Future<BatchGetItemResult> batchGetItemAsync(final BatchGetItemRequest batchGetItemRequest, final AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchGetItemResult>() {
            public BatchGetItemResult call() throws Exception {
                try {
                    BatchGetItemResult batchGetItem = AmazonDynamoDBAsyncClient.this.batchGetItem(batchGetItemRequest);
                    asyncHandler.onSuccess(batchGetItemRequest, batchGetItem);
                    return batchGetItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<BatchWriteItemResult> batchWriteItemAsync(final BatchWriteItemRequest batchWriteItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchWriteItemResult>() {
            public BatchWriteItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.batchWriteItem(batchWriteItemRequest);
            }
        });
    }

    public Future<BatchWriteItemResult> batchWriteItemAsync(final BatchWriteItemRequest batchWriteItemRequest, final AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<BatchWriteItemResult>() {
            public BatchWriteItemResult call() throws Exception {
                try {
                    BatchWriteItemResult batchWriteItem = AmazonDynamoDBAsyncClient.this.batchWriteItem(batchWriteItemRequest);
                    asyncHandler.onSuccess(batchWriteItemRequest, batchWriteItem);
                    return batchWriteItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<CreateBackupResult> createBackupAsync(final CreateBackupRequest createBackupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateBackupResult>() {
            public CreateBackupResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.createBackup(createBackupRequest);
            }
        });
    }

    public Future<CreateBackupResult> createBackupAsync(final CreateBackupRequest createBackupRequest, final AsyncHandler<CreateBackupRequest, CreateBackupResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateBackupResult>() {
            public CreateBackupResult call() throws Exception {
                try {
                    CreateBackupResult createBackup = AmazonDynamoDBAsyncClient.this.createBackup(createBackupRequest);
                    asyncHandler.onSuccess(createBackupRequest, createBackup);
                    return createBackup;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<CreateGlobalTableResult> createGlobalTableAsync(final CreateGlobalTableRequest createGlobalTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateGlobalTableResult>() {
            public CreateGlobalTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.createGlobalTable(createGlobalTableRequest);
            }
        });
    }

    public Future<CreateGlobalTableResult> createGlobalTableAsync(final CreateGlobalTableRequest createGlobalTableRequest, final AsyncHandler<CreateGlobalTableRequest, CreateGlobalTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateGlobalTableResult>() {
            public CreateGlobalTableResult call() throws Exception {
                try {
                    CreateGlobalTableResult createGlobalTable = AmazonDynamoDBAsyncClient.this.createGlobalTable(createGlobalTableRequest);
                    asyncHandler.onSuccess(createGlobalTableRequest, createGlobalTable);
                    return createGlobalTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<CreateTableResult> createTableAsync(final CreateTableRequest createTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateTableResult>() {
            public CreateTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.createTable(createTableRequest);
            }
        });
    }

    public Future<CreateTableResult> createTableAsync(final CreateTableRequest createTableRequest, final AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<CreateTableResult>() {
            public CreateTableResult call() throws Exception {
                try {
                    CreateTableResult createTable = AmazonDynamoDBAsyncClient.this.createTable(createTableRequest);
                    asyncHandler.onSuccess(createTableRequest, createTable);
                    return createTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DeleteBackupResult> deleteBackupAsync(final DeleteBackupRequest deleteBackupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteBackupResult>() {
            public DeleteBackupResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.deleteBackup(deleteBackupRequest);
            }
        });
    }

    public Future<DeleteBackupResult> deleteBackupAsync(final DeleteBackupRequest deleteBackupRequest, final AsyncHandler<DeleteBackupRequest, DeleteBackupResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteBackupResult>() {
            public DeleteBackupResult call() throws Exception {
                try {
                    DeleteBackupResult deleteBackup = AmazonDynamoDBAsyncClient.this.deleteBackup(deleteBackupRequest);
                    asyncHandler.onSuccess(deleteBackupRequest, deleteBackup);
                    return deleteBackup;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DeleteItemResult> deleteItemAsync(final DeleteItemRequest deleteItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteItemResult>() {
            public DeleteItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.deleteItem(deleteItemRequest);
            }
        });
    }

    public Future<DeleteItemResult> deleteItemAsync(final DeleteItemRequest deleteItemRequest, final AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteItemResult>() {
            public DeleteItemResult call() throws Exception {
                try {
                    DeleteItemResult deleteItem = AmazonDynamoDBAsyncClient.this.deleteItem(deleteItemRequest);
                    asyncHandler.onSuccess(deleteItemRequest, deleteItem);
                    return deleteItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DeleteTableResult> deleteTableAsync(final DeleteTableRequest deleteTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteTableResult>() {
            public DeleteTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.deleteTable(deleteTableRequest);
            }
        });
    }

    public Future<DeleteTableResult> deleteTableAsync(final DeleteTableRequest deleteTableRequest, final AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DeleteTableResult>() {
            public DeleteTableResult call() throws Exception {
                try {
                    DeleteTableResult deleteTable = AmazonDynamoDBAsyncClient.this.deleteTable(deleteTableRequest);
                    asyncHandler.onSuccess(deleteTableRequest, deleteTable);
                    return deleteTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeBackupResult> describeBackupAsync(final DescribeBackupRequest describeBackupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeBackupResult>() {
            public DescribeBackupResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeBackup(describeBackupRequest);
            }
        });
    }

    public Future<DescribeBackupResult> describeBackupAsync(final DescribeBackupRequest describeBackupRequest, final AsyncHandler<DescribeBackupRequest, DescribeBackupResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeBackupResult>() {
            public DescribeBackupResult call() throws Exception {
                try {
                    DescribeBackupResult describeBackup = AmazonDynamoDBAsyncClient.this.describeBackup(describeBackupRequest);
                    asyncHandler.onSuccess(describeBackupRequest, describeBackup);
                    return describeBackup;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(final DescribeContinuousBackupsRequest describeContinuousBackupsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeContinuousBackupsResult>() {
            public DescribeContinuousBackupsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeContinuousBackups(describeContinuousBackupsRequest);
            }
        });
    }

    public Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(final DescribeContinuousBackupsRequest describeContinuousBackupsRequest, final AsyncHandler<DescribeContinuousBackupsRequest, DescribeContinuousBackupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeContinuousBackupsResult>() {
            public DescribeContinuousBackupsResult call() throws Exception {
                try {
                    DescribeContinuousBackupsResult describeContinuousBackups = AmazonDynamoDBAsyncClient.this.describeContinuousBackups(describeContinuousBackupsRequest);
                    asyncHandler.onSuccess(describeContinuousBackupsRequest, describeContinuousBackups);
                    return describeContinuousBackups;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeEndpointsResult> describeEndpointsAsync(final DescribeEndpointsRequest describeEndpointsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeEndpointsResult>() {
            public DescribeEndpointsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeEndpoints(describeEndpointsRequest);
            }
        });
    }

    public Future<DescribeEndpointsResult> describeEndpointsAsync(final DescribeEndpointsRequest describeEndpointsRequest, final AsyncHandler<DescribeEndpointsRequest, DescribeEndpointsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeEndpointsResult>() {
            public DescribeEndpointsResult call() throws Exception {
                try {
                    DescribeEndpointsResult describeEndpoints = AmazonDynamoDBAsyncClient.this.describeEndpoints(describeEndpointsRequest);
                    asyncHandler.onSuccess(describeEndpointsRequest, describeEndpoints);
                    return describeEndpoints;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeGlobalTableResult> describeGlobalTableAsync(final DescribeGlobalTableRequest describeGlobalTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeGlobalTableResult>() {
            public DescribeGlobalTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeGlobalTable(describeGlobalTableRequest);
            }
        });
    }

    public Future<DescribeGlobalTableResult> describeGlobalTableAsync(final DescribeGlobalTableRequest describeGlobalTableRequest, final AsyncHandler<DescribeGlobalTableRequest, DescribeGlobalTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeGlobalTableResult>() {
            public DescribeGlobalTableResult call() throws Exception {
                try {
                    DescribeGlobalTableResult describeGlobalTable = AmazonDynamoDBAsyncClient.this.describeGlobalTable(describeGlobalTableRequest);
                    asyncHandler.onSuccess(describeGlobalTableRequest, describeGlobalTable);
                    return describeGlobalTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(final DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeGlobalTableSettingsResult>() {
            public DescribeGlobalTableSettingsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeGlobalTableSettings(describeGlobalTableSettingsRequest);
            }
        });
    }

    public Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(final DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest, final AsyncHandler<DescribeGlobalTableSettingsRequest, DescribeGlobalTableSettingsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeGlobalTableSettingsResult>() {
            public DescribeGlobalTableSettingsResult call() throws Exception {
                try {
                    DescribeGlobalTableSettingsResult describeGlobalTableSettings = AmazonDynamoDBAsyncClient.this.describeGlobalTableSettings(describeGlobalTableSettingsRequest);
                    asyncHandler.onSuccess(describeGlobalTableSettingsRequest, describeGlobalTableSettings);
                    return describeGlobalTableSettings;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeLimitsResult> describeLimitsAsync(final DescribeLimitsRequest describeLimitsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeLimitsResult>() {
            public DescribeLimitsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeLimits(describeLimitsRequest);
            }
        });
    }

    public Future<DescribeLimitsResult> describeLimitsAsync(final DescribeLimitsRequest describeLimitsRequest, final AsyncHandler<DescribeLimitsRequest, DescribeLimitsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeLimitsResult>() {
            public DescribeLimitsResult call() throws Exception {
                try {
                    DescribeLimitsResult describeLimits = AmazonDynamoDBAsyncClient.this.describeLimits(describeLimitsRequest);
                    asyncHandler.onSuccess(describeLimitsRequest, describeLimits);
                    return describeLimits;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeTableResult> describeTableAsync(final DescribeTableRequest describeTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeTableResult>() {
            public DescribeTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeTable(describeTableRequest);
            }
        });
    }

    public Future<DescribeTableResult> describeTableAsync(final DescribeTableRequest describeTableRequest, final AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeTableResult>() {
            public DescribeTableResult call() throws Exception {
                try {
                    DescribeTableResult describeTable = AmazonDynamoDBAsyncClient.this.describeTable(describeTableRequest);
                    asyncHandler.onSuccess(describeTableRequest, describeTable);
                    return describeTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(final DescribeTimeToLiveRequest describeTimeToLiveRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeTimeToLiveResult>() {
            public DescribeTimeToLiveResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.describeTimeToLive(describeTimeToLiveRequest);
            }
        });
    }

    public Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(final DescribeTimeToLiveRequest describeTimeToLiveRequest, final AsyncHandler<DescribeTimeToLiveRequest, DescribeTimeToLiveResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<DescribeTimeToLiveResult>() {
            public DescribeTimeToLiveResult call() throws Exception {
                try {
                    DescribeTimeToLiveResult describeTimeToLive = AmazonDynamoDBAsyncClient.this.describeTimeToLive(describeTimeToLiveRequest);
                    asyncHandler.onSuccess(describeTimeToLiveRequest, describeTimeToLive);
                    return describeTimeToLive;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<GetItemResult> getItemAsync(final GetItemRequest getItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<GetItemResult>() {
            public GetItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.getItem(getItemRequest);
            }
        });
    }

    public Future<GetItemResult> getItemAsync(final GetItemRequest getItemRequest, final AsyncHandler<GetItemRequest, GetItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<GetItemResult>() {
            public GetItemResult call() throws Exception {
                try {
                    GetItemResult item = AmazonDynamoDBAsyncClient.this.getItem(getItemRequest);
                    asyncHandler.onSuccess(getItemRequest, item);
                    return item;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<ListBackupsResult> listBackupsAsync(final ListBackupsRequest listBackupsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListBackupsResult>() {
            public ListBackupsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.listBackups(listBackupsRequest);
            }
        });
    }

    public Future<ListBackupsResult> listBackupsAsync(final ListBackupsRequest listBackupsRequest, final AsyncHandler<ListBackupsRequest, ListBackupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListBackupsResult>() {
            public ListBackupsResult call() throws Exception {
                try {
                    ListBackupsResult listBackups = AmazonDynamoDBAsyncClient.this.listBackups(listBackupsRequest);
                    asyncHandler.onSuccess(listBackupsRequest, listBackups);
                    return listBackups;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<ListGlobalTablesResult> listGlobalTablesAsync(final ListGlobalTablesRequest listGlobalTablesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListGlobalTablesResult>() {
            public ListGlobalTablesResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.listGlobalTables(listGlobalTablesRequest);
            }
        });
    }

    public Future<ListGlobalTablesResult> listGlobalTablesAsync(final ListGlobalTablesRequest listGlobalTablesRequest, final AsyncHandler<ListGlobalTablesRequest, ListGlobalTablesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListGlobalTablesResult>() {
            public ListGlobalTablesResult call() throws Exception {
                try {
                    ListGlobalTablesResult listGlobalTables = AmazonDynamoDBAsyncClient.this.listGlobalTables(listGlobalTablesRequest);
                    asyncHandler.onSuccess(listGlobalTablesRequest, listGlobalTables);
                    return listGlobalTables;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<ListTablesResult> listTablesAsync(final ListTablesRequest listTablesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListTablesResult>() {
            public ListTablesResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.listTables(listTablesRequest);
            }
        });
    }

    public Future<ListTablesResult> listTablesAsync(final ListTablesRequest listTablesRequest, final AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListTablesResult>() {
            public ListTablesResult call() throws Exception {
                try {
                    ListTablesResult listTables = AmazonDynamoDBAsyncClient.this.listTables(listTablesRequest);
                    asyncHandler.onSuccess(listTablesRequest, listTables);
                    return listTables;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<ListTagsOfResourceResult> listTagsOfResourceAsync(final ListTagsOfResourceRequest listTagsOfResourceRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListTagsOfResourceResult>() {
            public ListTagsOfResourceResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.listTagsOfResource(listTagsOfResourceRequest);
            }
        });
    }

    public Future<ListTagsOfResourceResult> listTagsOfResourceAsync(final ListTagsOfResourceRequest listTagsOfResourceRequest, final AsyncHandler<ListTagsOfResourceRequest, ListTagsOfResourceResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ListTagsOfResourceResult>() {
            public ListTagsOfResourceResult call() throws Exception {
                try {
                    ListTagsOfResourceResult listTagsOfResource = AmazonDynamoDBAsyncClient.this.listTagsOfResource(listTagsOfResourceRequest);
                    asyncHandler.onSuccess(listTagsOfResourceRequest, listTagsOfResource);
                    return listTagsOfResource;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<PutItemResult> putItemAsync(final PutItemRequest putItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<PutItemResult>() {
            public PutItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.putItem(putItemRequest);
            }
        });
    }

    public Future<PutItemResult> putItemAsync(final PutItemRequest putItemRequest, final AsyncHandler<PutItemRequest, PutItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<PutItemResult>() {
            public PutItemResult call() throws Exception {
                try {
                    PutItemResult putItem = AmazonDynamoDBAsyncClient.this.putItem(putItemRequest);
                    asyncHandler.onSuccess(putItemRequest, putItem);
                    return putItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<QueryResult> queryAsync(final QueryRequest queryRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<QueryResult>() {
            public QueryResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.query(queryRequest);
            }
        });
    }

    public Future<QueryResult> queryAsync(final QueryRequest queryRequest, final AsyncHandler<QueryRequest, QueryResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<QueryResult>() {
            public QueryResult call() throws Exception {
                try {
                    QueryResult query = AmazonDynamoDBAsyncClient.this.query(queryRequest);
                    asyncHandler.onSuccess(queryRequest, query);
                    return query;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(final RestoreTableFromBackupRequest restoreTableFromBackupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<RestoreTableFromBackupResult>() {
            public RestoreTableFromBackupResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.restoreTableFromBackup(restoreTableFromBackupRequest);
            }
        });
    }

    public Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(final RestoreTableFromBackupRequest restoreTableFromBackupRequest, final AsyncHandler<RestoreTableFromBackupRequest, RestoreTableFromBackupResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<RestoreTableFromBackupResult>() {
            public RestoreTableFromBackupResult call() throws Exception {
                try {
                    RestoreTableFromBackupResult restoreTableFromBackup = AmazonDynamoDBAsyncClient.this.restoreTableFromBackup(restoreTableFromBackupRequest);
                    asyncHandler.onSuccess(restoreTableFromBackupRequest, restoreTableFromBackup);
                    return restoreTableFromBackup;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(final RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<RestoreTableToPointInTimeResult>() {
            public RestoreTableToPointInTimeResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.restoreTableToPointInTime(restoreTableToPointInTimeRequest);
            }
        });
    }

    public Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(final RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest, final AsyncHandler<RestoreTableToPointInTimeRequest, RestoreTableToPointInTimeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<RestoreTableToPointInTimeResult>() {
            public RestoreTableToPointInTimeResult call() throws Exception {
                try {
                    RestoreTableToPointInTimeResult restoreTableToPointInTime = AmazonDynamoDBAsyncClient.this.restoreTableToPointInTime(restoreTableToPointInTimeRequest);
                    asyncHandler.onSuccess(restoreTableToPointInTimeRequest, restoreTableToPointInTime);
                    return restoreTableToPointInTime;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<ScanResult> scanAsync(final ScanRequest scanRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ScanResult>() {
            public ScanResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.scan(scanRequest);
            }
        });
    }

    public Future<ScanResult> scanAsync(final ScanRequest scanRequest, final AsyncHandler<ScanRequest, ScanResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<ScanResult>() {
            public ScanResult call() throws Exception {
                try {
                    ScanResult scan = AmazonDynamoDBAsyncClient.this.scan(scanRequest);
                    asyncHandler.onSuccess(scanRequest, scan);
                    return scan;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<Void> tagResourceAsync(final TagResourceRequest tagResourceRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                AmazonDynamoDBAsyncClient.this.tagResource(tagResourceRequest);
                return null;
            }
        });
    }

    public Future<Void> tagResourceAsync(final TagResourceRequest tagResourceRequest, final AsyncHandler<TagResourceRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                try {
                    AmazonDynamoDBAsyncClient.this.tagResource(tagResourceRequest);
                    asyncHandler.onSuccess(tagResourceRequest, null);
                    return null;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<Void> untagResourceAsync(final UntagResourceRequest untagResourceRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                AmazonDynamoDBAsyncClient.this.untagResource(untagResourceRequest);
                return null;
            }
        });
    }

    public Future<Void> untagResourceAsync(final UntagResourceRequest untagResourceRequest, final AsyncHandler<UntagResourceRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                try {
                    AmazonDynamoDBAsyncClient.this.untagResource(untagResourceRequest);
                    asyncHandler.onSuccess(untagResourceRequest, null);
                    return null;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(final UpdateContinuousBackupsRequest updateContinuousBackupsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateContinuousBackupsResult>() {
            public UpdateContinuousBackupsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateContinuousBackups(updateContinuousBackupsRequest);
            }
        });
    }

    public Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(final UpdateContinuousBackupsRequest updateContinuousBackupsRequest, final AsyncHandler<UpdateContinuousBackupsRequest, UpdateContinuousBackupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateContinuousBackupsResult>() {
            public UpdateContinuousBackupsResult call() throws Exception {
                try {
                    UpdateContinuousBackupsResult updateContinuousBackups = AmazonDynamoDBAsyncClient.this.updateContinuousBackups(updateContinuousBackupsRequest);
                    asyncHandler.onSuccess(updateContinuousBackupsRequest, updateContinuousBackups);
                    return updateContinuousBackups;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<UpdateGlobalTableResult> updateGlobalTableAsync(final UpdateGlobalTableRequest updateGlobalTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateGlobalTableResult>() {
            public UpdateGlobalTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateGlobalTable(updateGlobalTableRequest);
            }
        });
    }

    public Future<UpdateGlobalTableResult> updateGlobalTableAsync(final UpdateGlobalTableRequest updateGlobalTableRequest, final AsyncHandler<UpdateGlobalTableRequest, UpdateGlobalTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateGlobalTableResult>() {
            public UpdateGlobalTableResult call() throws Exception {
                try {
                    UpdateGlobalTableResult updateGlobalTable = AmazonDynamoDBAsyncClient.this.updateGlobalTable(updateGlobalTableRequest);
                    asyncHandler.onSuccess(updateGlobalTableRequest, updateGlobalTable);
                    return updateGlobalTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(final UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateGlobalTableSettingsResult>() {
            public UpdateGlobalTableSettingsResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateGlobalTableSettings(updateGlobalTableSettingsRequest);
            }
        });
    }

    public Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(final UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest, final AsyncHandler<UpdateGlobalTableSettingsRequest, UpdateGlobalTableSettingsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateGlobalTableSettingsResult>() {
            public UpdateGlobalTableSettingsResult call() throws Exception {
                try {
                    UpdateGlobalTableSettingsResult updateGlobalTableSettings = AmazonDynamoDBAsyncClient.this.updateGlobalTableSettings(updateGlobalTableSettingsRequest);
                    asyncHandler.onSuccess(updateGlobalTableSettingsRequest, updateGlobalTableSettings);
                    return updateGlobalTableSettings;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<UpdateItemResult> updateItemAsync(final UpdateItemRequest updateItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateItemResult>() {
            public UpdateItemResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateItem(updateItemRequest);
            }
        });
    }

    public Future<UpdateItemResult> updateItemAsync(final UpdateItemRequest updateItemRequest, final AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateItemResult>() {
            public UpdateItemResult call() throws Exception {
                try {
                    UpdateItemResult updateItem = AmazonDynamoDBAsyncClient.this.updateItem(updateItemRequest);
                    asyncHandler.onSuccess(updateItemRequest, updateItem);
                    return updateItem;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<UpdateTableResult> updateTableAsync(final UpdateTableRequest updateTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateTableResult>() {
            public UpdateTableResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateTable(updateTableRequest);
            }
        });
    }

    public Future<UpdateTableResult> updateTableAsync(final UpdateTableRequest updateTableRequest, final AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateTableResult>() {
            public UpdateTableResult call() throws Exception {
                try {
                    UpdateTableResult updateTable = AmazonDynamoDBAsyncClient.this.updateTable(updateTableRequest);
                    asyncHandler.onSuccess(updateTableRequest, updateTable);
                    return updateTable;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }

    public Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(final UpdateTimeToLiveRequest updateTimeToLiveRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateTimeToLiveResult>() {
            public UpdateTimeToLiveResult call() throws Exception {
                return AmazonDynamoDBAsyncClient.this.updateTimeToLive(updateTimeToLiveRequest);
            }
        });
    }

    public Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(final UpdateTimeToLiveRequest updateTimeToLiveRequest, final AsyncHandler<UpdateTimeToLiveRequest, UpdateTimeToLiveResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new Callable<UpdateTimeToLiveResult>() {
            public UpdateTimeToLiveResult call() throws Exception {
                try {
                    UpdateTimeToLiveResult updateTimeToLive = AmazonDynamoDBAsyncClient.this.updateTimeToLive(updateTimeToLiveRequest);
                    asyncHandler.onSuccess(updateTimeToLiveRequest, updateTimeToLive);
                    return updateTimeToLive;
                } catch (Exception e) {
                    asyncHandler.onError(e);
                    throw e;
                }
            }
        });
    }
}
