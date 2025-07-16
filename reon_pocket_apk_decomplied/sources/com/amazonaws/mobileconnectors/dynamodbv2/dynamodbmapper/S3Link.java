package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.JsonUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

public class S3Link {
    private static final Log LOGGER = LogFactory.getLog((Class<?>) S3Link.class);
    private static final int TEN_MB = 10240;
    private final ID id;
    private final S3ClientCache s3cc;

    S3Link(S3ClientCache s3ClientCache, String str, String str2) {
        this(s3ClientCache, new ID(str, str2));
    }

    S3Link(S3ClientCache s3ClientCache, Region region, String str, String str2) {
        this(s3ClientCache, new ID(region, str, str2));
    }

    private S3Link(S3ClientCache s3ClientCache, ID id2) {
        this.s3cc = s3ClientCache;
        this.id = id2;
        if (s3ClientCache == null) {
            throw new IllegalArgumentException("S3ClientCache must be configured for use with S3Link");
        } else if (id2 == null || id2.getBucket() == null || id2.getKey() == null) {
            throw new IllegalArgumentException("Bucket and key must be specified for S3Link");
        }
    }

    public String getKey() {
        return this.id.getKey();
    }

    public String getBucketName() {
        return this.id.getBucket();
    }

    public Region getS3Region() {
        return Region.fromValue(this.id.getRegionId());
    }

    public String toJson() {
        try {
            return this.id.toJson();
        } catch (IOException e) {
            throw new AmazonClientException("Unable to serialize to Json.", e);
        }
    }

    public static S3Link fromJson(S3ClientCache s3ClientCache, String str) {
        try {
            return new S3Link(s3ClientCache, ID.fromJson(str));
        } catch (IOException e) {
            throw new AmazonClientException("Unable to parse Json string.", e);
        }
    }

    public AmazonS3Client getAmazonS3Client() {
        return this.s3cc.getClient(getS3Region());
    }

    public PutObjectResult uploadFrom(File file) {
        return uploadFrom(file, (RequestMetricCollector) null);
    }

    public PutObjectResult uploadFrom(File file, RequestMetricCollector requestMetricCollector) {
        return getAmazonS3Client().putObject((PutObjectRequest) new PutObjectRequest(getBucketName(), getKey(), file).withRequestMetricCollector(requestMetricCollector));
    }

    public PutObjectResult uploadFrom(byte[] bArr) {
        return uploadFrom(bArr, (RequestMetricCollector) null);
    }

    public PutObjectResult uploadFrom(byte[] bArr, RequestMetricCollector requestMetricCollector) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength((long) bArr.length);
        return getAmazonS3Client().putObject((PutObjectRequest) new PutObjectRequest(getBucketName(), getKey(), new ByteArrayInputStream(bArr), objectMetadata).withRequestMetricCollector(requestMetricCollector));
    }

    public void setAcl(CannedAccessControlList cannedAccessControlList) {
        setAcl(cannedAccessControlList, (RequestMetricCollector) null);
    }

    public void setAcl(CannedAccessControlList cannedAccessControlList, RequestMetricCollector requestMetricCollector) {
        getAmazonS3Client().setObjectAcl(getBucketName(), getKey(), (String) null, cannedAccessControlList, requestMetricCollector);
    }

    public void setAcl(AccessControlList accessControlList) {
        setAcl(accessControlList, (RequestMetricCollector) null);
    }

    public void setAcl(AccessControlList accessControlList, RequestMetricCollector requestMetricCollector) {
        getAmazonS3Client().setObjectAcl(getBucketName(), getKey(), (String) null, accessControlList, requestMetricCollector);
    }

    public URL getUrl() {
        return getAmazonS3Client().getUrl(getBucketName(), getKey());
    }

    public ObjectMetadata downloadTo(File file) {
        return downloadTo(file, (RequestMetricCollector) null);
    }

    public ObjectMetadata downloadTo(File file, RequestMetricCollector requestMetricCollector) {
        return getAmazonS3Client().getObject((GetObjectRequest) new GetObjectRequest(getBucketName(), getKey()).withRequestMetricCollector(requestMetricCollector), file);
    }

    public ObjectMetadata downloadTo(OutputStream outputStream) {
        return downloadTo(outputStream, (RequestMetricCollector) null);
    }

    public ObjectMetadata downloadTo(OutputStream outputStream, RequestMetricCollector requestMetricCollector) {
        S3Object object = getAmazonS3Client().getObject((GetObjectRequest) new GetObjectRequest(getBucketName(), getKey()).withRequestMetricCollector(requestMetricCollector));
        S3ObjectInputStream objectContent = object.getObjectContent();
        try {
            byte[] bArr = new byte[10240];
            while (true) {
                int read = objectContent.read(bArr);
                if (read > -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        LOGGER.warn("could not close the object content", e);
                    }
                }
            }
            objectContent.close();
            return object.getObjectMetadata();
        } catch (IOException e2) {
            objectContent.abort();
            throw new AmazonClientException("Unable to transfer content from Amazon S3 to the output stream", e2);
        } catch (Throwable th) {
            try {
                objectContent.close();
            } catch (IOException e3) {
                LOGGER.warn("could not close the object content", e3);
            }
            throw th;
        }
    }

    static class ID {
        private final String bucket;
        private final String key;
        private String regionId;

        ID(String str, String str2) {
            this((Region) null, str, str2);
        }

        ID(Region region, String str, String str2) {
            if (region != null) {
                this.regionId = region.getFirstRegionId();
            } else if (BucketNameUtils.isDNSBucketName(str)) {
                this.regionId = Region.US_Standard.getFirstRegionId();
            } else {
                throw new IllegalArgumentException("Region must be specified for bucket that cannot be addressed using virtual host style");
            }
            this.bucket = str;
            this.key = str2;
        }

        public String getRegionId() {
            return this.regionId;
        }

        public String getBucket() {
            return this.bucket;
        }

        public String getKey() {
            return this.key;
        }

        /* access modifiers changed from: package-private */
        public String toJson() throws IOException {
            StringWriter stringWriter = new StringWriter();
            JsonUtils.getJsonWriter(stringWriter).beginObject().name("s3").beginObject().name("bucket").value(this.bucket).name(TransferTable.COLUMN_KEY).value(this.key).name("region").value(this.regionId).endObject().endObject().close();
            return stringWriter.toString();
        }

        static ID fromJson(String str) throws IOException {
            AwsJsonReader jsonReader = JsonUtils.getJsonReader(new StringReader(str));
            jsonReader.beginObject();
            jsonReader.nextName();
            jsonReader.beginObject();
            Region region = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("bucket".equals(nextName)) {
                    str3 = jsonReader.nextString();
                } else if (TransferTable.COLUMN_KEY.equals(nextName)) {
                    str4 = jsonReader.nextString();
                } else if ("region".equals(nextName)) {
                    str2 = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.endObject();
            if (str2 != null) {
                region = Region.fromValue(str2);
            }
            return new ID(region, str3, str4);
        }
    }
}
