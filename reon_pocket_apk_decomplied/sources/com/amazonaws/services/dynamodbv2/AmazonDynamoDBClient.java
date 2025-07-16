package com.amazonaws.services.dynamodbv2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.MetricType;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.TagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.UntagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.services.dynamodbv2.model.transform.BackupInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BackupNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ConditionalCheckFailedExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ContinuousBackupsUnavailableExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GlobalTableAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GlobalTableNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.IndexNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.InternalServerErrorExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.InvalidRestoreTimeExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionSizeLimitExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoveryUnavailableExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ReplicaAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ReplicaNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ResourceInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TableAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TableInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TableNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TagResourceRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UntagResourceRequestMarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AmazonDynamoDBClient extends AmazonWebServiceClient implements AmazonDynamoDB {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    @Deprecated
    public AmazonDynamoDBClient() {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AmazonDynamoDBClient(ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new BackupInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new BackupNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ConditionalCheckFailedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ContinuousBackupsUnavailableExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new GlobalTableAlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new GlobalTableNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new IndexNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InternalServerErrorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidRestoreTimeExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ItemCollectionSizeLimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new PointInTimeRecoveryUnavailableExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ProvisionedThroughputExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ReplicaAlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ReplicaNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TableAlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TableInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TableNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("dynamodb.us-east-1.amazonaws.com");
        this.endpointPrefix = ServiceAbbreviations.Dynamodb;
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/dynamodbv2/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/dynamodbv2/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        ClientConfiguration clientConfiguration2 = new ClientConfiguration(clientConfiguration);
        if (clientConfiguration2.getRetryPolicy() == PredefinedRetryPolicies.DEFAULT) {
            clientConfiguration2.setRetryPolicy(PredefinedRetryPolicies.DYNAMODB_DEFAULT);
        }
        return clientConfiguration2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.BatchGetItemResult batchGetItem(com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.BatchGetItemResult r0 = (com.amazonaws.services.dynamodbv2.model.BatchGetItemResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.batchGetItem(com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest):com.amazonaws.services.dynamodbv2.model.BatchGetItemResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult batchWriteItem(com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult r0 = (com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.batchWriteItem(com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest):com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.CreateBackupResult createBackup(com.amazonaws.services.dynamodbv2.model.CreateBackupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.CreateBackupRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.CreateBackupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.CreateBackupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.CreateBackupResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.CreateBackupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.CreateBackupResult r0 = (com.amazonaws.services.dynamodbv2.model.CreateBackupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.createBackup(com.amazonaws.services.dynamodbv2.model.CreateBackupRequest):com.amazonaws.services.dynamodbv2.model.CreateBackupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult createGlobalTable(com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult r0 = (com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.createGlobalTable(com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest):com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.CreateTableResult createTable(com.amazonaws.services.dynamodbv2.model.CreateTableRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.CreateTableRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.CreateTableRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.CreateTableRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.CreateTableResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.CreateTableResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.CreateTableResult r0 = (com.amazonaws.services.dynamodbv2.model.CreateTableResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.createTable(com.amazonaws.services.dynamodbv2.model.CreateTableRequest):com.amazonaws.services.dynamodbv2.model.CreateTableResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DeleteBackupResult deleteBackup(com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DeleteBackupResult r0 = (com.amazonaws.services.dynamodbv2.model.DeleteBackupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.deleteBackup(com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest):com.amazonaws.services.dynamodbv2.model.DeleteBackupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DeleteItemResult deleteItem(com.amazonaws.services.dynamodbv2.model.DeleteItemRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DeleteItemRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DeleteItemRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DeleteItemRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DeleteItemResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DeleteItemResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DeleteItemResult r0 = (com.amazonaws.services.dynamodbv2.model.DeleteItemResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.deleteItem(com.amazonaws.services.dynamodbv2.model.DeleteItemRequest):com.amazonaws.services.dynamodbv2.model.DeleteItemResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DeleteTableResult deleteTable(com.amazonaws.services.dynamodbv2.model.DeleteTableRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DeleteTableRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DeleteTableRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DeleteTableRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DeleteTableResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DeleteTableResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DeleteTableResult r0 = (com.amazonaws.services.dynamodbv2.model.DeleteTableResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.deleteTable(com.amazonaws.services.dynamodbv2.model.DeleteTableRequest):com.amazonaws.services.dynamodbv2.model.DeleteTableResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeBackupResult describeBackup(com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeBackupResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeBackupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeBackup(com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest):com.amazonaws.services.dynamodbv2.model.DescribeBackupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult describeContinuousBackups(com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeContinuousBackups(com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest):com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult describeEndpoints(com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeEndpoints(com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest):com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult describeGlobalTable(com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeGlobalTable(com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest):com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult describeGlobalTableSettings(com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeGlobalTableSettings(com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest):com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult describeLimits(com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeLimits(com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest):com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeTableResult describeTable(com.amazonaws.services.dynamodbv2.model.DescribeTableRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeTableRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeTableRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeTableRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeTableResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeTableResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeTableResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeTableResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeTable(com.amazonaws.services.dynamodbv2.model.DescribeTableRequest):com.amazonaws.services.dynamodbv2.model.DescribeTableResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult describeTimeToLive(com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult r0 = (com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.describeTimeToLive(com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest):com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.GetItemResult getItem(com.amazonaws.services.dynamodbv2.model.GetItemRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.GetItemRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.GetItemRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.GetItemRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.GetItemResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.GetItemResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.GetItemResult r0 = (com.amazonaws.services.dynamodbv2.model.GetItemResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.getItem(com.amazonaws.services.dynamodbv2.model.GetItemRequest):com.amazonaws.services.dynamodbv2.model.GetItemResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.ListBackupsResult listBackups(com.amazonaws.services.dynamodbv2.model.ListBackupsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.ListBackupsRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListBackupsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.ListBackupsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.ListBackupsResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListBackupsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.ListBackupsResult r0 = (com.amazonaws.services.dynamodbv2.model.ListBackupsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.listBackups(com.amazonaws.services.dynamodbv2.model.ListBackupsRequest):com.amazonaws.services.dynamodbv2.model.ListBackupsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult listGlobalTables(com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult r0 = (com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.listGlobalTables(com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest):com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.ListTablesResult listTables(com.amazonaws.services.dynamodbv2.model.ListTablesRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.ListTablesRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListTablesRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.ListTablesRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.ListTablesResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListTablesResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.ListTablesResult r0 = (com.amazonaws.services.dynamodbv2.model.ListTablesResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.listTables(com.amazonaws.services.dynamodbv2.model.ListTablesRequest):com.amazonaws.services.dynamodbv2.model.ListTablesResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult listTagsOfResource(com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult r0 = (com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.listTagsOfResource(com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest):com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.PutItemResult putItem(com.amazonaws.services.dynamodbv2.model.PutItemRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.PutItemRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.PutItemRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.PutItemRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.PutItemResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.PutItemResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.PutItemResult r0 = (com.amazonaws.services.dynamodbv2.model.PutItemResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.putItem(com.amazonaws.services.dynamodbv2.model.PutItemRequest):com.amazonaws.services.dynamodbv2.model.PutItemResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.QueryResult query(com.amazonaws.services.dynamodbv2.model.QueryRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.QueryRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.QueryRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.QueryRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.QueryResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.QueryResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.QueryResult r0 = (com.amazonaws.services.dynamodbv2.model.QueryResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.query(com.amazonaws.services.dynamodbv2.model.QueryRequest):com.amazonaws.services.dynamodbv2.model.QueryResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult restoreTableFromBackup(com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult r0 = (com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.restoreTableFromBackup(com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest):com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult restoreTableToPointInTime(com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult r0 = (com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.restoreTableToPointInTime(com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest):com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.ScanResult scan(com.amazonaws.services.dynamodbv2.model.ScanRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.ScanRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ScanRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.ScanRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.ScanResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.ScanResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.ScanResult r0 = (com.amazonaws.services.dynamodbv2.model.ScanResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.scan(com.amazonaws.services.dynamodbv2.model.ScanRequest):com.amazonaws.services.dynamodbv2.model.ScanResult");
    }

    public void tagResource(TagResourceRequest tagResourceRequest) throws AmazonServiceException, AmazonClientException {
        Request<TagResourceRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) tagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new TagResourceRequestMarshaller().marshall(tagResourceRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    public void untagResource(UntagResourceRequest untagResourceRequest) throws AmazonServiceException, AmazonClientException {
        Request<UntagResourceRequest> request;
        ExecutionContext createExecutionContext = createExecutionContext((AmazonWebServiceRequest) untagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
            try {
                request = new UntagResourceRequestMarshaller().marshall(untagResourceRequest);
                try {
                    request.setAWSRequestMetrics(awsRequestMetrics);
                } catch (Throwable th) {
                    th = th;
                    awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                request = null;
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            try {
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.RequestMarshallTime);
                invoke(request, new JsonResponseHandler((Unmarshaller) null), createExecutionContext);
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            request = null;
            awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, (Response<?>) null, true);
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult updateContinuousBackups(com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult r0 = (com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.updateContinuousBackups(com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest):com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult updateGlobalTable(com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult r0 = (com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.updateGlobalTable(com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest):com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult updateGlobalTableSettings(com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult r0 = (com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.updateGlobalTableSettings(com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest):com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.UpdateItemResult updateItem(com.amazonaws.services.dynamodbv2.model.UpdateItemRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateItemRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateItemRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.UpdateItemRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateItemResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateItemResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.UpdateItemResult r0 = (com.amazonaws.services.dynamodbv2.model.UpdateItemResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.updateItem(com.amazonaws.services.dynamodbv2.model.UpdateItemRequest):com.amazonaws.services.dynamodbv2.model.UpdateItemResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.UpdateTableResult updateTable(com.amazonaws.services.dynamodbv2.model.UpdateTableRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateTableRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateTableRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.UpdateTableRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateTableResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateTableResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.UpdateTableResult r0 = (com.amazonaws.services.dynamodbv2.model.UpdateTableResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.updateTable(com.amazonaws.services.dynamodbv2.model.UpdateTableRequest):com.amazonaws.services.dynamodbv2.model.UpdateTableResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult updateTimeToLive(com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest r8) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r7 = this;
            com.amazonaws.http.ExecutionContext r0 = r7.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r8)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 1
            r3 = 0
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x0051 }
            r1.startEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x0051 }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveRequestMarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveRequestMarshaller     // Catch:{ all -> 0x0044 }
            r4.<init>()     // Catch:{ all -> 0x0044 }
            com.amazonaws.Request r8 = r4.marshall((com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest) r8)     // Catch:{ all -> 0x0044 }
            r8.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0042 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveResultJsonUnmarshaller r4 = new com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveResultJsonUnmarshaller     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            com.amazonaws.http.JsonResponseHandler r5 = new com.amazonaws.http.JsonResponseHandler     // Catch:{ all -> 0x004c }
            r5.<init>(r4)     // Catch:{ all -> 0x004c }
            com.amazonaws.Response r3 = r7.invoke(r8, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r3.getAwsResponse()     // Catch:{ all -> 0x004c }
            com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult r0 = (com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult) r0     // Catch:{ all -> 0x004c }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r8, r3, r2)
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r8 = r3
        L_0x0046:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RequestMarshallTime     // Catch:{ all -> 0x004c }
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ all -> 0x004c }
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0053
        L_0x0051:
            r0 = move-exception
            r8 = r3
        L_0x0053:
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r4)
            r7.endClientExecution(r1, r3, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient.updateTimeToLive(com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest):com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult");
    }

    public PutItemResult putItem(String str, Map<String, AttributeValue> map) throws AmazonServiceException, AmazonClientException {
        PutItemRequest putItemRequest = new PutItemRequest();
        putItemRequest.setTableName(str);
        putItemRequest.setItem(map);
        return putItem(putItemRequest);
    }

    public PutItemResult putItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonServiceException, AmazonClientException {
        PutItemRequest putItemRequest = new PutItemRequest();
        putItemRequest.setTableName(str);
        putItemRequest.setItem(map);
        putItemRequest.setReturnValues(str2);
        return putItem(putItemRequest);
    }

    public UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2) throws AmazonServiceException, AmazonClientException {
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTableName(str);
        updateItemRequest.setKey(map);
        updateItemRequest.setAttributeUpdates(map2);
        return updateItem(updateItemRequest);
    }

    public UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2, String str2) throws AmazonServiceException, AmazonClientException {
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTableName(str);
        updateItemRequest.setKey(map);
        updateItemRequest.setAttributeUpdates(map2);
        updateItemRequest.setReturnValues(str2);
        return updateItem(updateItemRequest);
    }

    public DescribeTableResult describeTable(String str) throws AmazonServiceException, AmazonClientException {
        DescribeTableRequest describeTableRequest = new DescribeTableRequest();
        describeTableRequest.setTableName(str);
        return describeTable(describeTableRequest);
    }

    public ScanResult scan(String str, List<String> list) throws AmazonServiceException, AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setAttributesToGet(list);
        return scan(scanRequest);
    }

    public ScanResult scan(String str, Map<String, Condition> map) throws AmazonServiceException, AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setScanFilter(map);
        return scan(scanRequest);
    }

    public ScanResult scan(String str, List<String> list, Map<String, Condition> map) throws AmazonServiceException, AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setAttributesToGet(list);
        scanRequest.setScanFilter(map);
        return scan(scanRequest);
    }

    public DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map) throws AmazonServiceException, AmazonClientException {
        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setTableName(str);
        deleteItemRequest.setKey(map);
        return deleteItem(deleteItemRequest);
    }

    public DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonServiceException, AmazonClientException {
        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setTableName(str);
        deleteItemRequest.setKey(map);
        deleteItemRequest.setReturnValues(str2);
        return deleteItem(deleteItemRequest);
    }

    public DeleteTableResult deleteTable(String str) throws AmazonServiceException, AmazonClientException {
        DeleteTableRequest deleteTableRequest = new DeleteTableRequest();
        deleteTableRequest.setTableName(str);
        return deleteTable(deleteTableRequest);
    }

    public CreateTableResult createTable(List<AttributeDefinition> list, String str, List<KeySchemaElement> list2, ProvisionedThroughput provisionedThroughput) throws AmazonServiceException, AmazonClientException {
        CreateTableRequest createTableRequest = new CreateTableRequest();
        createTableRequest.setAttributeDefinitions(list);
        createTableRequest.setTableName(str);
        createTableRequest.setKeySchema(list2);
        createTableRequest.setProvisionedThroughput(provisionedThroughput);
        return createTable(createTableRequest);
    }

    public GetItemResult getItem(String str, Map<String, AttributeValue> map) throws AmazonServiceException, AmazonClientException {
        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setTableName(str);
        getItemRequest.setKey(map);
        return getItem(getItemRequest);
    }

    public GetItemResult getItem(String str, Map<String, AttributeValue> map, Boolean bool) throws AmazonServiceException, AmazonClientException {
        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setTableName(str);
        getItemRequest.setKey(map);
        getItemRequest.setConsistentRead(bool);
        return getItem(getItemRequest);
    }

    public ListTablesResult listTables() throws AmazonServiceException, AmazonClientException {
        return listTables(new ListTablesRequest());
    }

    public ListTablesResult listTables(String str) throws AmazonServiceException, AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setExclusiveStartTableName(str);
        return listTables(listTablesRequest);
    }

    public ListTablesResult listTables(String str, Integer num) throws AmazonServiceException, AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setExclusiveStartTableName(str);
        listTablesRequest.setLimit(num);
        return listTables(listTablesRequest);
    }

    public ListTablesResult listTables(Integer num) throws AmazonServiceException, AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setLimit(num);
        return listTables(listTablesRequest);
    }

    public UpdateTableResult updateTable(String str, ProvisionedThroughput provisionedThroughput) throws AmazonServiceException, AmazonClientException {
        UpdateTableRequest updateTableRequest = new UpdateTableRequest();
        updateTableRequest.setTableName(str);
        updateTableRequest.setProvisionedThroughput(provisionedThroughput);
        return updateTable(updateTableRequest);
    }

    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map, String str) throws AmazonServiceException, AmazonClientException {
        BatchGetItemRequest batchGetItemRequest = new BatchGetItemRequest();
        batchGetItemRequest.setRequestItems(map);
        batchGetItemRequest.setReturnConsumedCapacity(str);
        return batchGetItem(batchGetItemRequest);
    }

    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map) throws AmazonServiceException, AmazonClientException {
        BatchGetItemRequest batchGetItemRequest = new BatchGetItemRequest();
        batchGetItemRequest.setRequestItems(map);
        return batchGetItem(batchGetItemRequest);
    }

    public BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> map) throws AmazonServiceException, AmazonClientException {
        BatchWriteItemRequest batchWriteItemRequest = new BatchWriteItemRequest();
        batchWriteItemRequest.setRequestItems(map);
        return batchWriteItem(batchWriteItemRequest);
    }

    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    /* JADX INFO: finally extract failed */
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent((MetricType) AWSRequestMetrics.Field.CredentialsRequestTime);
        try {
            AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
            awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.CredentialsRequestTime);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (!(originalRequest == null || originalRequest.getRequestCredentials() == null)) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.jsonErrorUnmarshallers), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }
}
