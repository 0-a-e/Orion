package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import com.amazonaws.util.URIBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AmazonHttpClient {
    private static final String HEADER_SDK_RETRY_INFO = "aws-sdk-retry";
    private static final String HEADER_SDK_TRANSACTION_ID = "aws-sdk-invocation-id";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final int HTTP_STATUS_MULTIPLE_CHOICES = 300;
    private static final int HTTP_STATUS_OK = 200;
    private static final int HTTP_STATUS_REQ_TOO_LONG = 413;
    private static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    private static final int HTTP_STATUS_TEMP_REDIRECT = 307;
    private static final Log REQUEST_LOG = LogFactory.getLog("com.amazonaws.request");
    private static final long TIME_MILLISEC = 1000;
    static final Log log = LogFactory.getLog((Class<?>) AmazonHttpClient.class);
    final ClientConfiguration config;
    final HttpClient httpClient;
    private final HttpRequestFactory requestFactory;
    private final RequestMetricCollector requestMetricCollector;

    @Deprecated
    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, (HttpClient) new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector2) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector2);
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient2) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient2;
        this.requestMetricCollector = null;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient2, RequestMetricCollector requestMetricCollector2) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient2;
        this.requestMetricCollector = requestMetricCollector2;
    }

    public <T> Response<T> execute(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) {
        Response<T> response;
        if (request.getHostPrefix() != null) {
            try {
                URI endpoint = request.getEndpoint();
                request.setEndpoint(URIBuilder.builder(endpoint).host(request.getHostPrefix() + endpoint.getHost()).build());
            } catch (URISyntaxException e) {
                Log log2 = log;
                if (log2.isDebugEnabled()) {
                    log2.debug("Failed to prepend host prefix: " + e.getMessage(), e);
                }
            }
        }
        if (executionContext != null) {
            List<RequestHandler2> requestHandler2s = requestHandler2s(request, executionContext);
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            try {
                response = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
                try {
                    afterResponse(request, requestHandler2s, response, awsRequestMetrics.getTimingInfo().endTiming());
                    return response;
                } catch (AmazonClientException e2) {
                    e = e2;
                    afterError(request, response, requestHandler2s, e);
                    throw e;
                }
            } catch (AmazonClientException e3) {
                e = e3;
                response = null;
                afterError(request, response, requestHandler2s, e);
                throw e;
            }
        } else {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
    }

    /* access modifiers changed from: package-private */
    public void afterError(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        for (RequestHandler2 afterError : list) {
            afterError.afterError(request, response, amazonClientException);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void afterResponse(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        for (RequestHandler2 afterResponse : list) {
            afterResponse.afterResponse(request, response);
        }
    }

    /* access modifiers changed from: package-private */
    public List<RequestHandler2> requestHandler2s(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
        if (requestHandler2s == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 next : requestHandler2s) {
            if (next instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) next).setCredentials(executionContext.getCredentials());
            }
            next.beforeRequest(request);
        }
        return requestHandler2s;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01de, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e1, code lost:
        r2 = r0;
        r9 = "Cannot close the response content.";
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01e6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01e7, code lost:
        r9 = "Cannot close the response content.";
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01eb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01ec, code lost:
        r9 = "Cannot close the response content.";
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x035f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0360, code lost:
        r9 = "Cannot close the response content.";
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0366, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0367, code lost:
        r9 = "Cannot close the response content.";
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x036c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x036d, code lost:
        r9 = "Cannot close the response content.";
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0372, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0373, code lost:
        r21 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0396, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0397, code lost:
        r21 = r1;
        r9 = "Cannot close the response content.";
        r24 = r5;
        r25 = r6;
        r23 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x03a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x03a5, code lost:
        r21 = r1;
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x03ac, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x03ad, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x03b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x03b6, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x03bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x03bd, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        r1.debug("Unable to execute HTTP request: " + r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x045d, code lost:
        resetRequestAfterError(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0468, code lost:
        if (r20.getRawContent() != null) goto L_0x046a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x046a, code lost:
        r20.getRawContent().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0472, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0473, code lost:
        log.warn(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0478, code lost:
        r1 = r19;
        r6 = r20;
        r2 = r21;
        r4 = r24;
        r5 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:?, code lost:
        throw r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r10.endEvent((com.amazonaws.metrics.MetricType) com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ec, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ee, code lost:
        r2 = r0;
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f3, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f7, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fb, code lost:
        r9 = "Cannot close the response content.";
        r25 = r5;
        r23 = r11;
        r21 = r20;
        r20 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012f, code lost:
        r2 = r0;
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0133, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0134, code lost:
        r21 = r1;
        r9 = "Cannot close the response content.";
        r25 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014e, code lost:
        r4 = r0;
        r10.endEvent((com.amazonaws.metrics.MetricType) com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0154, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01e0 A[ExcHandler: all (r0v100 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:79:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01e6 A[ExcHandler: Error (e java.lang.Error), Splitter:B:79:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01eb A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:79:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x035f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:76:0x0188] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0366 A[ExcHandler: Error (e java.lang.Error), Splitter:B:76:0x0188] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x036c A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:76:0x0188] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03ac A[ExcHandler: all (th java.lang.Throwable), Splitter:B:44:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03b5 A[ExcHandler: Error (e java.lang.Error), Splitter:B:44:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03bc A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:44:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0403 A[SYNTHETIC, Splitter:B:245:0x0403] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x045d A[Catch:{ all -> 0x048a }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0489 A[EDGE_INSN: B:260:0x0489->B:261:? ?: BREAK  , SYNTHETIC, Splitter:B:260:0x0489] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0497 A[Catch:{ IOException -> 0x049f }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ed A[ExcHandler: all (r0v122 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:17:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f2 A[ExcHandler: Error (e java.lang.Error), Splitter:B:17:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f6 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:17:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012e A[ExcHandler: all (r0v115 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:47:0x0125] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.amazonaws.Response<T> executeHelper(com.amazonaws.Request<?> r27, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r28, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r29, com.amazonaws.http.ExecutionContext r30) {
        /*
            r26 = this;
            r7 = r26
            r8 = r27
            r9 = r30
            com.amazonaws.util.AWSRequestMetrics r10 = r30.getAwsRequestMetrics()
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.ServiceName
            java.lang.String r1 = r27.getServiceName()
            r10.addProperty((com.amazonaws.metrics.MetricType) r0, (java.lang.Object) r1)
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.ServiceEndpoint
            java.net.URI r1 = r27.getEndpoint()
            r10.addProperty((com.amazonaws.metrics.MetricType) r0, (java.lang.Object) r1)
            r26.setUserAgent(r27)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "aws-sdk-invocation-id"
            r8.addHeader(r1, r0)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            java.util.Map r0 = r27.getParameters()
            r11.<init>(r0)
            java.util.HashMap r12 = new java.util.HashMap
            java.util.Map r0 = r27.getHeaders()
            r12.<init>(r0)
            java.io.InputStream r13 = r27.getContent()
            if (r13 == 0) goto L_0x004e
            boolean r0 = r13.markSupported()
            if (r0 == 0) goto L_0x004e
            r0 = -1
            r13.mark(r0)
        L_0x004e:
            com.amazonaws.auth.AWSCredentials r14 = r30.getCredentials()
            r0 = 0
            r1 = 0
            r2 = r1
            r4 = 0
            r5 = 0
            r6 = 0
            r16 = 0
            r17 = 0
            r1 = r0
        L_0x005e:
            int r15 = r0 + 1
            r19 = r1
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.RequestCount
            r20 = r2
            long r2 = (long) r15
            r10.setCounter((com.amazonaws.metrics.MetricType) r1, (long) r2)
            r1 = 1
            if (r15 <= r1) goto L_0x0076
            r8.setParameters(r11)
            r8.setHeaders(r12)
            r8.setContent(r13)
        L_0x0076:
            if (r16 == 0) goto L_0x00ae
            java.net.URI r2 = r27.getEndpoint()
            if (r2 != 0) goto L_0x00ae
            java.lang.String r2 = r27.getResourcePath()
            if (r2 != 0) goto L_0x00ae
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r16.getScheme()
            r2.append(r3)
            java.lang.String r3 = "://"
            r2.append(r3)
            java.lang.String r3 = r16.getAuthority()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.net.URI r2 = java.net.URI.create(r2)
            r8.setEndpoint(r2)
            java.lang.String r2 = r16.getPath()
            r8.setResourcePath(r2)
        L_0x00ae:
            java.lang.String r3 = "Cannot close the response content."
            if (r15 <= r1) goto L_0x0106
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime     // Catch:{ IOException -> 0x00fa, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            r10.startEvent((com.amazonaws.metrics.MetricType) r1)     // Catch:{ IOException -> 0x00fa, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            com.amazonaws.AmazonWebServiceRequest r1 = r27.getOriginalRequest()     // Catch:{ all -> 0x00e6 }
            com.amazonaws.ClientConfiguration r2 = r7.config     // Catch:{ all -> 0x00e6 }
            com.amazonaws.retry.RetryPolicy r2 = r2.getRetryPolicy()     // Catch:{ all -> 0x00e6 }
            long r1 = r7.pauseBeforeNextRetry(r1, r4, r15, r2)     // Catch:{ all -> 0x00e6 }
            com.amazonaws.util.AWSRequestMetrics$Field r4 = com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            r10.endEvent((com.amazonaws.metrics.MetricType) r4)     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            java.io.InputStream r4 = r27.getContent()     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            if (r4 == 0) goto L_0x0108
            boolean r20 = r4.markSupported()     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            if (r20 == 0) goto L_0x0108
            r4.reset()     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            goto L_0x0108
        L_0x00da:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r25 = r5
            r20 = r6
        L_0x00e2:
            r23 = r11
            goto L_0x03f9
        L_0x00e6:
            r0 = move-exception
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime     // Catch:{ IOException -> 0x00fa, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            r10.endEvent((com.amazonaws.metrics.MetricType) r1)     // Catch:{ IOException -> 0x00fa, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
            throw r0     // Catch:{ IOException -> 0x00fa, RuntimeException -> 0x00f6, Error -> 0x00f2, all -> 0x00ed }
        L_0x00ed:
            r0 = move-exception
            r2 = r0
            r9 = r3
            goto L_0x03cd
        L_0x00f2:
            r0 = move-exception
            r9 = r3
            goto L_0x03d5
        L_0x00f6:
            r0 = move-exception
            r9 = r3
            goto L_0x03e2
        L_0x00fa:
            r0 = move-exception
            r9 = r3
            r25 = r5
            r23 = r11
            r21 = r20
            r20 = r6
            goto L_0x03f9
        L_0x0106:
            r1 = r20
        L_0x0108:
            java.lang.String r4 = "aws-sdk-retry"
            r20 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03c3, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            r6.<init>()     // Catch:{ IOException -> 0x03c3, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            r6.append(r0)     // Catch:{ IOException -> 0x03c3, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            java.lang.String r0 = "/"
            r6.append(r0)     // Catch:{ IOException -> 0x03c3, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            r6.append(r1)     // Catch:{ IOException -> 0x03c3, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            java.lang.String r0 = r6.toString()     // Catch:{ IOException -> 0x03c3, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            r8.addHeader(r4, r0)     // Catch:{ IOException -> 0x03c3, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            if (r5 != 0) goto L_0x013a
            java.net.URI r0 = r27.getEndpoint()     // Catch:{ IOException -> 0x0133, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            com.amazonaws.auth.Signer r5 = r9.getSignerByURI(r0)     // Catch:{ IOException -> 0x0133, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            goto L_0x013a
        L_0x012e:
            r0 = move-exception
            r2 = r0
            r9 = r3
            goto L_0x03af
        L_0x0133:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r25 = r5
            goto L_0x00e2
        L_0x013a:
            r6 = r5
            if (r6 == 0) goto L_0x0155
            if (r14 == 0) goto L_0x0155
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            r10.startEvent((com.amazonaws.metrics.MetricType) r0)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            r6.sign(r8, r14)     // Catch:{ all -> 0x014d }
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            r10.endEvent((com.amazonaws.metrics.MetricType) r0)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            goto L_0x0155
        L_0x014d:
            r0 = move-exception
            r4 = r0
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            r10.endEvent((com.amazonaws.metrics.MetricType) r0)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            throw r4     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
        L_0x0155:
            com.amazonaws.logging.Log r0 = REQUEST_LOG     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            boolean r4 = r0.isDebugEnabled()     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            if (r4 == 0) goto L_0x0175
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            r4.<init>()     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            java.lang.String r5 = "Sending Request: "
            r4.append(r5)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            java.lang.String r5 = r27.toString()     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            r4.append(r5)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
            r0.debug(r4)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x012e }
        L_0x0175:
            com.amazonaws.http.HttpRequestFactory r0 = r7.requestFactory     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            com.amazonaws.ClientConfiguration r4 = r7.config     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            com.amazonaws.http.HttpRequest r5 = r0.createHttpRequest(r8, r4, r9)     // Catch:{ IOException -> 0x03a4, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.HttpRequestTime     // Catch:{ IOException -> 0x0396, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            r10.startEvent((com.amazonaws.metrics.MetricType) r0)     // Catch:{ IOException -> 0x0396, RuntimeException -> 0x03bc, Error -> 0x03b5, all -> 0x03ac }
            com.amazonaws.http.HttpClient r0 = r7.httpClient     // Catch:{ all -> 0x0380 }
            com.amazonaws.http.HttpResponse r4 = r0.execute(r5)     // Catch:{ all -> 0x0380 }
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.HttpRequestTime     // Catch:{ IOException -> 0x0372, RuntimeException -> 0x036c, Error -> 0x0366, all -> 0x035f }
            r10.endEvent((com.amazonaws.metrics.MetricType) r0)     // Catch:{ IOException -> 0x0372, RuntimeException -> 0x036c, Error -> 0x0366, all -> 0x035f }
            boolean r0 = r7.isRequestSuccessful(r4)     // Catch:{ IOException -> 0x0372, RuntimeException -> 0x036c, Error -> 0x0366, all -> 0x035f }
            if (r0 == 0) goto L_0x01fa
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode     // Catch:{ IOException -> 0x01f0, RuntimeException -> 0x01eb, Error -> 0x01e6, all -> 0x01e0 }
            int r17 = r4.getStatusCode()     // Catch:{ IOException -> 0x01f0, RuntimeException -> 0x01eb, Error -> 0x01e6, all -> 0x01e0 }
            r21 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)     // Catch:{ IOException -> 0x01de, RuntimeException -> 0x01eb, Error -> 0x01e6, all -> 0x01e0 }
            r10.addProperty((com.amazonaws.metrics.MetricType) r0, (java.lang.Object) r1)     // Catch:{ IOException -> 0x01de, RuntimeException -> 0x01eb, Error -> 0x01e6, all -> 0x01e0 }
            boolean r1 = r28.needsConnectionLeftOpen()     // Catch:{ IOException -> 0x01de, RuntimeException -> 0x01eb, Error -> 0x01e6, all -> 0x01e0 }
            r2 = r28
            java.lang.Object r0 = r7.handleResponse(r8, r2, r4, r9)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x01d5, Error -> 0x01d0, all -> 0x01ca }
            com.amazonaws.Response r2 = new com.amazonaws.Response     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x01d5, Error -> 0x01d0, all -> 0x01ca }
            r2.<init>(r0, r4)     // Catch:{ IOException -> 0x01da, RuntimeException -> 0x01d5, Error -> 0x01d0, all -> 0x01ca }
            if (r1 != 0) goto L_0x01c9
            if (r4 == 0) goto L_0x01c9
            java.io.InputStream r0 = r4.getRawContent()     // Catch:{ IOException -> 0x01c3 }
            if (r0 == 0) goto L_0x01c9
            java.io.InputStream r0 = r4.getRawContent()     // Catch:{ IOException -> 0x01c3 }
            r0.close()     // Catch:{ IOException -> 0x01c3 }
            goto L_0x01c9
        L_0x01c3:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = log
            r1.warn(r3, r0)
        L_0x01c9:
            return r2
        L_0x01ca:
            r0 = move-exception
            r2 = r0
            r9 = r3
            r6 = r4
            goto L_0x048d
        L_0x01d0:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x03d7
        L_0x01d5:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x03e4
        L_0x01da:
            r0 = move-exception
            r19 = r1
            goto L_0x01f3
        L_0x01de:
            r0 = move-exception
            goto L_0x01f3
        L_0x01e0:
            r0 = move-exception
            r2 = r0
            r9 = r3
            r6 = r4
            goto L_0x03cd
        L_0x01e6:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x03d5
        L_0x01eb:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x03e2
        L_0x01f0:
            r0 = move-exception
            r21 = r1
        L_0x01f3:
            r9 = r3
            r20 = r4
            r17 = r5
            goto L_0x03a8
        L_0x01fa:
            r21 = r1
            boolean r0 = isTemporaryRedirect(r4)     // Catch:{ IOException -> 0x035d, RuntimeException -> 0x036c, Error -> 0x0366, all -> 0x035f }
            if (r0 == 0) goto L_0x028b
            java.util.Map r0 = r4.getHeaders()     // Catch:{ IOException -> 0x027e, RuntimeException -> 0x0274, Error -> 0x026a, all -> 0x025f }
            java.lang.String r1 = "Location"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ IOException -> 0x027e, RuntimeException -> 0x0274, Error -> 0x026a, all -> 0x025f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x027e, RuntimeException -> 0x0274, Error -> 0x026a, all -> 0x025f }
            com.amazonaws.logging.Log r1 = log     // Catch:{ IOException -> 0x027e, RuntimeException -> 0x0274, Error -> 0x026a, all -> 0x025f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x027e, RuntimeException -> 0x0274, Error -> 0x026a, all -> 0x025f }
            r2.<init>()     // Catch:{ IOException -> 0x027e, RuntimeException -> 0x0274, Error -> 0x026a, all -> 0x025f }
            r23 = r3
            java.lang.String r3 = "Redirecting to: "
            r2.append(r3)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r2.append(r0)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r1.debug(r2)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            java.net.URI r16 = java.net.URI.create(r0)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r1 = 0
            r8.setEndpoint(r1)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r8.setResourcePath(r1)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            int r2 = r4.getStatusCode()     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r10.addProperty((com.amazonaws.metrics.MetricType) r1, (java.lang.Object) r2)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.RedirectLocation     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r10.addProperty((com.amazonaws.metrics.MetricType) r1, (java.lang.Object) r0)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r1 = 0
            r10.addProperty((com.amazonaws.metrics.MetricType) r0, (java.lang.Object) r1)     // Catch:{ IOException -> 0x025d, RuntimeException -> 0x025b, Error -> 0x0259, all -> 0x0257 }
            r24 = r5
            r25 = r6
            r1 = r19
            r9 = r23
            r2 = 0
            r23 = r11
            r11 = r4
            goto L_0x02ee
        L_0x0257:
            r0 = move-exception
            goto L_0x0262
        L_0x0259:
            r0 = move-exception
            goto L_0x026d
        L_0x025b:
            r0 = move-exception
            goto L_0x0277
        L_0x025d:
            r0 = move-exception
            goto L_0x0281
        L_0x025f:
            r0 = move-exception
            r23 = r3
        L_0x0262:
            r2 = r0
            r6 = r4
            r1 = r19
            r9 = r23
            goto L_0x048d
        L_0x026a:
            r0 = move-exception
            r23 = r3
        L_0x026d:
            r6 = r4
            r1 = r19
            r9 = r23
            goto L_0x03d7
        L_0x0274:
            r0 = move-exception
            r23 = r3
        L_0x0277:
            r6 = r4
            r1 = r19
            r9 = r23
            goto L_0x03e4
        L_0x027e:
            r0 = move-exception
            r23 = r3
        L_0x0281:
            r20 = r4
            r17 = r5
            r25 = r6
            r9 = r23
            goto L_0x00e2
        L_0x028b:
            r23 = r3
            boolean r17 = r29.needsConnectionLeftOpen()     // Catch:{ IOException -> 0x0355, RuntimeException -> 0x0350, Error -> 0x034b, all -> 0x0346 }
            r3 = r29
            com.amazonaws.AmazonServiceException r0 = r7.handleErrorResponse(r8, r3, r4)     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            java.lang.String r2 = r0.getRequestId()     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            r10.addProperty((com.amazonaws.metrics.MetricType) r1, (java.lang.Object) r2)     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.AWSErrorCode     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            java.lang.String r2 = r0.getErrorCode()     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            r10.addProperty((com.amazonaws.metrics.MetricType) r1, (java.lang.Object) r2)     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            int r2 = r0.getStatusCode()     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            r10.addProperty((com.amazonaws.metrics.MetricType) r1, (java.lang.Object) r2)     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            com.amazonaws.AmazonWebServiceRequest r2 = r27.getOriginalRequest()     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            java.io.InputStream r19 = r5.getContent()     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            com.amazonaws.ClientConfiguration r1 = r7.config     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            com.amazonaws.retry.RetryPolicy r20 = r1.getRetryPolicy()     // Catch:{ IOException -> 0x0336, RuntimeException -> 0x032d, Error -> 0x0324, all -> 0x031a }
            r1 = r26
            r9 = r23
            r3 = r19
            r23 = r11
            r11 = r4
            r4 = r0
            r24 = r5
            r5 = r15
            r25 = r6
            r6 = r20
            boolean r1 = r1.shouldRetry(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x0318, RuntimeException -> 0x0316, Error -> 0x0314, all -> 0x0312 }
            if (r1 == 0) goto L_0x0311
            boolean r1 = com.amazonaws.retry.RetryUtils.isClockSkewError(r0)     // Catch:{ IOException -> 0x0318, RuntimeException -> 0x0316, Error -> 0x0314, all -> 0x0312 }
            if (r1 == 0) goto L_0x02e8
            long r1 = r7.parseClockSkewOffset(r11, r0)     // Catch:{ IOException -> 0x0318, RuntimeException -> 0x0316, Error -> 0x0314, all -> 0x0312 }
            com.amazonaws.SDKGlobalConfiguration.setGlobalTimeOffset((long) r1)     // Catch:{ IOException -> 0x0318, RuntimeException -> 0x0316, Error -> 0x0314, all -> 0x0312 }
        L_0x02e8:
            r7.resetRequestAfterError(r8, r0)     // Catch:{ IOException -> 0x0318, RuntimeException -> 0x0316, Error -> 0x0314, all -> 0x0312 }
            r2 = r0
            r1 = r17
        L_0x02ee:
            if (r1 != 0) goto L_0x0306
            if (r11 == 0) goto L_0x0306
            java.io.InputStream r0 = r11.getRawContent()     // Catch:{ IOException -> 0x0300 }
            if (r0 == 0) goto L_0x0306
            java.io.InputStream r0 = r11.getRawContent()     // Catch:{ IOException -> 0x0300 }
            r0.close()     // Catch:{ IOException -> 0x0300 }
            goto L_0x0306
        L_0x0300:
            r0 = move-exception
            com.amazonaws.logging.Log r3 = log
            r3.warn(r9, r0)
        L_0x0306:
            r4 = r2
            r6 = r11
            r2 = r21
            r17 = r24
            r5 = r25
            r11 = 0
            goto L_0x0482
        L_0x0311:
            throw r0     // Catch:{ IOException -> 0x0318, RuntimeException -> 0x0316, Error -> 0x0314, all -> 0x0312 }
        L_0x0312:
            r0 = move-exception
            goto L_0x031e
        L_0x0314:
            r0 = move-exception
            goto L_0x0328
        L_0x0316:
            r0 = move-exception
            goto L_0x0331
        L_0x0318:
            r0 = move-exception
            goto L_0x0340
        L_0x031a:
            r0 = move-exception
            r11 = r4
            r9 = r23
        L_0x031e:
            r2 = r0
            r6 = r11
            r1 = r17
            goto L_0x048d
        L_0x0324:
            r0 = move-exception
            r11 = r4
            r9 = r23
        L_0x0328:
            r6 = r11
            r1 = r17
            goto L_0x03d7
        L_0x032d:
            r0 = move-exception
            r11 = r4
            r9 = r23
        L_0x0331:
            r6 = r11
            r1 = r17
            goto L_0x03e4
        L_0x0336:
            r0 = move-exception
            r24 = r5
            r25 = r6
            r9 = r23
            r23 = r11
            r11 = r4
        L_0x0340:
            r20 = r11
            r19 = r17
            goto L_0x03a0
        L_0x0346:
            r0 = move-exception
            r11 = r4
            r9 = r23
            goto L_0x0362
        L_0x034b:
            r0 = move-exception
            r11 = r4
            r9 = r23
            goto L_0x0369
        L_0x0350:
            r0 = move-exception
            r11 = r4
            r9 = r23
            goto L_0x036f
        L_0x0355:
            r0 = move-exception
            r24 = r5
            r25 = r6
            r9 = r23
            goto L_0x037a
        L_0x035d:
            r0 = move-exception
            goto L_0x0375
        L_0x035f:
            r0 = move-exception
            r9 = r3
            r11 = r4
        L_0x0362:
            r2 = r0
            r6 = r11
            goto L_0x03cd
        L_0x0366:
            r0 = move-exception
            r9 = r3
            r11 = r4
        L_0x0369:
            r6 = r11
            goto L_0x03d5
        L_0x036c:
            r0 = move-exception
            r9 = r3
            r11 = r4
        L_0x036f:
            r6 = r11
            goto L_0x03e2
        L_0x0372:
            r0 = move-exception
            r21 = r1
        L_0x0375:
            r9 = r3
            r24 = r5
            r25 = r6
        L_0x037a:
            r23 = r11
            r11 = r4
            r20 = r11
            goto L_0x03a0
        L_0x0380:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r24 = r5
            r25 = r6
            r23 = r11
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.HttpRequestTime     // Catch:{ IOException -> 0x0394, RuntimeException -> 0x0392, Error -> 0x0390 }
            r10.endEvent((com.amazonaws.metrics.MetricType) r1)     // Catch:{ IOException -> 0x0394, RuntimeException -> 0x0392, Error -> 0x0390 }
            throw r0     // Catch:{ IOException -> 0x0394, RuntimeException -> 0x0392, Error -> 0x0390 }
        L_0x0390:
            r0 = move-exception
            goto L_0x03b7
        L_0x0392:
            r0 = move-exception
            goto L_0x03be
        L_0x0394:
            r0 = move-exception
            goto L_0x03a0
        L_0x0396:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r24 = r5
            r25 = r6
            r23 = r11
        L_0x03a0:
            r17 = r24
            goto L_0x03f9
        L_0x03a4:
            r0 = move-exception
            r21 = r1
            r9 = r3
        L_0x03a8:
            r25 = r6
            goto L_0x00e2
        L_0x03ac:
            r0 = move-exception
            r9 = r3
        L_0x03ae:
            r2 = r0
        L_0x03af:
            r1 = r19
            r6 = r20
            goto L_0x048d
        L_0x03b5:
            r0 = move-exception
            r9 = r3
        L_0x03b7:
            r1 = r19
            r6 = r20
            goto L_0x03d7
        L_0x03bc:
            r0 = move-exception
            r9 = r3
        L_0x03be:
            r1 = r19
            r6 = r20
            goto L_0x03e4
        L_0x03c3:
            r0 = move-exception
            r21 = r1
            r9 = r3
            goto L_0x03f5
        L_0x03c8:
            r0 = move-exception
            r9 = r3
            r20 = r6
            r2 = r0
        L_0x03cd:
            r1 = r19
            goto L_0x048d
        L_0x03d1:
            r0 = move-exception
            r9 = r3
            r20 = r6
        L_0x03d5:
            r1 = r19
        L_0x03d7:
            java.lang.Throwable r0 = r7.handleUnexpectedFailure(r0, r10)     // Catch:{ all -> 0x03eb }
            java.lang.Error r0 = (java.lang.Error) r0     // Catch:{ all -> 0x03eb }
            throw r0     // Catch:{ all -> 0x03eb }
        L_0x03de:
            r0 = move-exception
            r9 = r3
            r20 = r6
        L_0x03e2:
            r1 = r19
        L_0x03e4:
            java.lang.Throwable r0 = r7.handleUnexpectedFailure(r0, r10)     // Catch:{ all -> 0x03eb }
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch:{ all -> 0x03eb }
            throw r0     // Catch:{ all -> 0x03eb }
        L_0x03eb:
            r0 = move-exception
            r2 = r0
            goto L_0x048d
        L_0x03ef:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r20 = r6
        L_0x03f5:
            r23 = r11
            r25 = r5
        L_0x03f9:
            com.amazonaws.logging.Log r1 = log     // Catch:{ all -> 0x048a }
            boolean r2 = r1.isDebugEnabled()     // Catch:{ all -> 0x048a }
            java.lang.String r3 = "Unable to execute HTTP request: "
            if (r2 == 0) goto L_0x0419
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x048a }
            r2.<init>()     // Catch:{ all -> 0x048a }
            r2.append(r3)     // Catch:{ all -> 0x048a }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x048a }
            r2.append(r4)     // Catch:{ all -> 0x048a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x048a }
            r1.debug(r2, r0)     // Catch:{ all -> 0x048a }
        L_0x0419:
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.Exception     // Catch:{ all -> 0x048a }
            r10.incrementCounter((com.amazonaws.metrics.MetricType) r1)     // Catch:{ all -> 0x048a }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.Exception     // Catch:{ all -> 0x048a }
            r10.addProperty((com.amazonaws.metrics.MetricType) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x048a }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID     // Catch:{ all -> 0x048a }
            r11 = 0
            r10.addProperty((com.amazonaws.metrics.MetricType) r1, (java.lang.Object) r11)     // Catch:{ all -> 0x048a }
            com.amazonaws.AmazonClientException r6 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x048a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x048a }
            r1.<init>()     // Catch:{ all -> 0x048a }
            r1.append(r3)     // Catch:{ all -> 0x048a }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x048a }
            r1.append(r2)     // Catch:{ all -> 0x048a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x048a }
            r6.<init>(r1, r0)     // Catch:{ all -> 0x048a }
            com.amazonaws.AmazonWebServiceRequest r2 = r27.getOriginalRequest()     // Catch:{ all -> 0x048a }
            java.io.InputStream r3 = r17.getContent()     // Catch:{ all -> 0x048a }
            com.amazonaws.ClientConfiguration r1 = r7.config     // Catch:{ all -> 0x048a }
            com.amazonaws.retry.RetryPolicy r18 = r1.getRetryPolicy()     // Catch:{ all -> 0x048a }
            r1 = r26
            r4 = r6
            r5 = r15
            r24 = r6
            r6 = r18
            boolean r1 = r1.shouldRetry(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x048a }
            if (r1 == 0) goto L_0x0489
            r7.resetRequestAfterError(r8, r0)     // Catch:{ all -> 0x048a }
            if (r19 != 0) goto L_0x0478
            if (r20 == 0) goto L_0x0478
            java.io.InputStream r0 = r20.getRawContent()     // Catch:{ IOException -> 0x0472 }
            if (r0 == 0) goto L_0x0478
            java.io.InputStream r0 = r20.getRawContent()     // Catch:{ IOException -> 0x0472 }
            r0.close()     // Catch:{ IOException -> 0x0472 }
            goto L_0x0478
        L_0x0472:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = log
            r1.warn(r9, r0)
        L_0x0478:
            r1 = r19
            r6 = r20
            r2 = r21
            r4 = r24
            r5 = r25
        L_0x0482:
            r9 = r30
            r0 = r15
            r11 = r23
            goto L_0x005e
        L_0x0489:
            throw r24     // Catch:{ all -> 0x048a }
        L_0x048a:
            r0 = move-exception
            goto L_0x03ae
        L_0x048d:
            if (r1 != 0) goto L_0x04a5
            if (r6 == 0) goto L_0x04a5
            java.io.InputStream r0 = r6.getRawContent()     // Catch:{ IOException -> 0x049f }
            if (r0 == 0) goto L_0x04a5
            java.io.InputStream r0 = r6.getRawContent()     // Catch:{ IOException -> 0x049f }
            r0.close()     // Catch:{ IOException -> 0x049f }
            goto L_0x04a5
        L_0x049f:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = log
            r1.warn(r9, r0)
        L_0x04a5:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.executeHelper(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    private <T extends Throwable> T handleUnexpectedFailure(T t, AWSRequestMetrics aWSRequestMetrics) {
        aWSRequestMetrics.incrementCounter((MetricType) AWSRequestMetrics.Field.Exception);
        aWSRequestMetrics.addProperty((MetricType) AWSRequestMetrics.Field.Exception, (Object) t);
        return t;
    }

    /* access modifiers changed from: package-private */
    public void resetRequestAfterError(Request<?> request, Exception exc) {
        if (request.getContent() != null) {
            if (request.getContent().markSupported()) {
                try {
                    request.getContent().reset();
                } catch (IOException unused) {
                    throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
                }
            } else {
                throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setUserAgent(Request<?> request) {
        RequestClientOptions requestClientOptions;
        String clientMarker;
        String str = ClientConfiguration.DEFAULT_USER_AGENT;
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (!(originalRequest == null || (requestClientOptions = originalRequest.getRequestClientOptions()) == null || (clientMarker = requestClientOptions.getClientMarker(RequestClientOptions.Marker.USER_AGENT)) == null)) {
            str = createUserAgentString(str, clientMarker);
        }
        if (!ClientConfiguration.DEFAULT_USER_AGENT.equals(this.config.getUserAgent())) {
            str = createUserAgentString(str, this.config.getUserAgent());
        }
        if (this.config.getUserAgentOverride() != null) {
            str = this.config.getUserAgentOverride();
        }
        request.addHeader("User-Agent", str);
    }

    static String createUserAgentString(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    public void shutdown() {
        this.httpClient.shutdown();
    }

    private boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        int maxErrorRetry = this.config.getMaxErrorRetry();
        if (maxErrorRetry < 0 || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
            maxErrorRetry = retryPolicy.getMaxErrorRetry();
        }
        if (i2 >= maxErrorRetry) {
            return false;
        }
        if (inputStream == null || inputStream.markSupported()) {
            return retryPolicy.getRetryCondition().shouldRetry(amazonWebServiceRequest, amazonClientException, i2);
        }
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Content not repeatable");
        }
        return false;
    }

    private static boolean isTemporaryRedirect(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        String str = httpResponse.getHeaders().get(HttpHeader.LOCATION);
        return statusCode == HTTP_STATUS_TEMP_REDIRECT && str != null && !str.isEmpty();
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    /* access modifiers changed from: package-private */
    public <T> T handleResponse(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        AWSRequestMetrics awsRequestMetrics;
        try {
            awsRequestMetrics = executionContext.getAwsRequestMetrics();
            awsRequestMetrics.startEvent((MetricType) AWSRequestMetrics.Field.ResponseProcessingTime);
            AmazonWebServiceResponse handle = httpResponseHandler.handle(httpResponse);
            awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ResponseProcessingTime);
            if (handle != null) {
                Log log2 = REQUEST_LOG;
                if (log2.isDebugEnabled()) {
                    log2.debug("Received successful response: " + httpResponse.getStatusCode() + ", AWS Request ID: " + handle.getRequestId());
                }
                awsRequestMetrics.addProperty((MetricType) AWSRequestMetrics.Field.AWSRequestID, (Object) handle.getRequestId());
                return handle.getResult();
            }
            throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText());
        } catch (CRC32MismatchException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new AmazonClientException("Unable to unmarshall response (" + e3.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText(), e3);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent((MetricType) AWSRequestMetrics.Field.ResponseProcessingTime);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public AmazonServiceException handleErrorResponse(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int statusCode = httpResponse.getStatusCode();
        try {
            amazonServiceException = httpResponseHandler.handle(httpResponse);
            Log log2 = REQUEST_LOG;
            log2.debug("Received error response: " + amazonServiceException.toString());
        } catch (Exception e) {
            if (statusCode == HTTP_STATUS_REQ_TOO_LONG) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(HTTP_STATUS_REQ_TOO_LONG);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (statusCode == HTTP_STATUS_SERVICE_UNAVAILABLE && "Service Unavailable".equalsIgnoreCase(httpResponse.getStatusText())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(HTTP_STATUS_SERVICE_UNAVAILABLE);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw new AmazonClientException("Unable to unmarshall error response (" + e.getMessage() + "). Response Code: " + statusCode + ", Response Text: " + httpResponse.getStatusText() + ", Response Headers: " + httpResponse.getHeaders(), e);
            }
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    private long pauseBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 2;
        long delayBeforeNextRetry = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(amazonWebServiceRequest, amazonClientException, i2);
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Retriable error detected, will retry in " + delayBeforeNextRetry + "ms, attempt number: " + i2);
        }
        try {
            Thread.sleep(delayBeforeNextRetry);
            return delayBeforeNextRetry;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e.getMessage(), e);
        }
    }

    private String getServerDateFromException(String str) {
        int i;
        int indexOf = str.indexOf("(");
        if (str.contains(" + 15")) {
            i = str.indexOf(" + 15");
        } else {
            i = str.indexOf(" - 15");
        }
        return str.substring(indexOf + 1, i);
    }

    /* access modifiers changed from: package-private */
    public long parseClockSkewOffset(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date date;
        Date date2 = new Date();
        String str = httpResponse.getHeaders().get("Date");
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    try {
                        date = DateUtils.parseRFC822Date(str);
                        return (date2.getTime() - date.getTime()) / 1000;
                    } catch (RuntimeException e) {
                        e = e;
                        log.warn("Unable to parse clock skew offset from response: " + str, e);
                        return 0;
                    }
                }
            } catch (RuntimeException e2) {
                e = e2;
                str = null;
                log.warn("Unable to parse clock skew offset from response: " + str, e);
                return 0;
            }
        }
        str = getServerDateFromException(amazonServiceException.getMessage());
        date = DateUtils.parseCompressedISO8601Date(str);
        return (date2.getTime() - date.getTime()) / 1000;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }
}
