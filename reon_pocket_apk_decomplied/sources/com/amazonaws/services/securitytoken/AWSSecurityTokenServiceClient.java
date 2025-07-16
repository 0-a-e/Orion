package com.amazonaws.services.securitytoken;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazonaws.services.securitytoken.model.transform.ExpiredTokenExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.IDPCommunicationErrorExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.IDPRejectedClaimExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.InvalidAuthorizationMessageExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.InvalidIdentityTokenExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.PackedPolicyTooLargeExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.RegionDisabledExceptionUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class AWSSecurityTokenServiceClient extends AmazonWebServiceClient implements AWSSecurityTokenService {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AWSSecurityTokenServiceClient() {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AWSSecurityTokenServiceClient(ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AWSSecurityTokenServiceClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AWSSecurityTokenServiceClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this((AWSCredentialsProvider) new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new ExpiredTokenExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new IDPCommunicationErrorExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new IDPRejectedClaimExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidAuthorizationMessageExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidIdentityTokenExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new MalformedPolicyDocumentExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new PackedPolicyTooLargeExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new RegionDisabledExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("sts.amazonaws.com");
        this.endpointPrefix = ServiceAbbreviations.STS;
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/securitytoken/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/securitytoken/request.handler2s"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.AssumeRoleResult assumeRole(com.amazonaws.services.securitytoken.model.AssumeRoleRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.AssumeRoleRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.AssumeRoleRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.AssumeRoleRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.AssumeRoleResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.AssumeRoleResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.AssumeRoleResult r0 = (com.amazonaws.services.securitytoken.model.AssumeRoleResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.assumeRole(com.amazonaws.services.securitytoken.model.AssumeRoleRequest):com.amazonaws.services.securitytoken.model.AssumeRoleResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult assumeRoleWithSAML(com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult r0 = (com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.assumeRoleWithSAML(com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest):com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentity(com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult r0 = (com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.assumeRoleWithWebIdentity(com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest):com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult decodeAuthorizationMessage(com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult r0 = (com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.decodeAuthorizationMessage(com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest):com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult getAccessKeyInfo(com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult r0 = (com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.getAccessKeyInfo(com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest):com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.GetCallerIdentityResult getCallerIdentity(com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.GetCallerIdentityResult r0 = (com.amazonaws.services.securitytoken.model.GetCallerIdentityResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.getCallerIdentity(com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest):com.amazonaws.services.securitytoken.model.GetCallerIdentityResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.GetFederationTokenResult getFederationToken(com.amazonaws.services.securitytoken.model.GetFederationTokenRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.GetFederationTokenRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetFederationTokenRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.GetFederationTokenRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.GetFederationTokenResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetFederationTokenResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.GetFederationTokenResult r0 = (com.amazonaws.services.securitytoken.model.GetFederationTokenResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.getFederationToken(com.amazonaws.services.securitytoken.model.GetFederationTokenRequest):com.amazonaws.services.securitytoken.model.GetFederationTokenResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.amazonaws.Request} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.amazonaws.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.amazonaws.Request} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.services.securitytoken.model.GetSessionTokenResult getSessionToken(com.amazonaws.services.securitytoken.model.GetSessionTokenRequest r6) throws com.amazonaws.AmazonServiceException, com.amazonaws.AmazonClientException {
        /*
            r5 = this;
            com.amazonaws.http.ExecutionContext r0 = r5.createExecutionContext((com.amazonaws.AmazonWebServiceRequest) r6)
            com.amazonaws.util.AWSRequestMetrics r1 = r0.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r2 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.startEvent((com.amazonaws.metrics.MetricType) r2)
            r2 = 0
            com.amazonaws.services.securitytoken.model.transform.GetSessionTokenRequestMarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetSessionTokenRequestMarshaller     // Catch:{ all -> 0x0037 }
            r3.<init>()     // Catch:{ all -> 0x0037 }
            com.amazonaws.Request r6 = r3.marshall((com.amazonaws.services.securitytoken.model.GetSessionTokenRequest) r6)     // Catch:{ all -> 0x0037 }
            r6.setAWSRequestMetrics(r1)     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.transform.GetSessionTokenResultStaxUnmarshaller r3 = new com.amazonaws.services.securitytoken.model.transform.GetSessionTokenResultStaxUnmarshaller     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            com.amazonaws.Response r2 = r5.invoke(r6, r3, r0)     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r2.getAwsResponse()     // Catch:{ all -> 0x0032 }
            com.amazonaws.services.securitytoken.model.GetSessionTokenResult r0 = (com.amazonaws.services.securitytoken.model.GetSessionTokenResult) r0     // Catch:{ all -> 0x0032 }
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r6, r2)
            return r0
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0039
        L_0x0037:
            r0 = move-exception
            r6 = r2
        L_0x0039:
            com.amazonaws.util.AWSRequestMetrics$Field r3 = com.amazonaws.util.AWSRequestMetrics.Field.ClientExecuteTime
            r1.endEvent((com.amazonaws.metrics.MetricType) r3)
            r5.endClientExecution(r1, r2, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient.getSessionToken(com.amazonaws.services.securitytoken.model.GetSessionTokenRequest):com.amazonaws.services.securitytoken.model.GetSessionTokenResult");
    }

    public GetSessionTokenResult getSessionToken() throws AmazonServiceException, AmazonClientException {
        return getSessionToken(new GetSessionTokenRequest());
    }

    public GetCallerIdentityResult getCallerIdentity() throws AmazonServiceException, AmazonClientException {
        return getCallerIdentity(new GetCallerIdentityRequest());
    }

    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, Unmarshaller<X, StaxUnmarshallerContext> unmarshaller, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }
        executionContext.setCredentials(credentials);
        return this.client.execute(request, new StaxResponseHandler(unmarshaller), new DefaultErrorResponseHandler(this.exceptionUnmarshallers), executionContext);
    }
}
