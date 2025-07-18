package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

public class ExecutionContext {
    private final AmazonWebServiceClient awsClient;
    private final AWSRequestMetrics awsRequestMetrics;
    private String contextUserAgent;
    private AWSCredentials credentials;
    private final List<RequestHandler2> requestHandler2s;

    public void setSigner(Signer signer) {
    }

    @Deprecated
    public ExecutionContext(boolean z) {
        this((List<RequestHandler2>) null, z, (AmazonWebServiceClient) null);
    }

    public ExecutionContext() {
        this((List<RequestHandler2>) null, false, (AmazonWebServiceClient) null);
    }

    public ExecutionContext(List<RequestHandler2> list, boolean z, AmazonWebServiceClient amazonWebServiceClient) {
        this.requestHandler2s = list;
        this.awsRequestMetrics = z ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics();
        this.awsClient = amazonWebServiceClient;
    }

    public String getContextUserAgent() {
        return this.contextUserAgent;
    }

    public void setContextUserAgent(String str) {
        this.contextUserAgent = str;
    }

    public List<RequestHandler2> getRequestHandler2s() {
        return this.requestHandler2s;
    }

    @Deprecated
    public AWSRequestMetrics getAwsRequestMetrics() {
        return this.awsRequestMetrics;
    }

    public Signer getSignerByURI(URI uri) {
        AmazonWebServiceClient amazonWebServiceClient = this.awsClient;
        if (amazonWebServiceClient == null) {
            return null;
        }
        return amazonWebServiceClient.getSignerByURI(uri);
    }

    public AWSCredentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(AWSCredentials aWSCredentials) {
        this.credentials = aWSCredentials;
    }
}
