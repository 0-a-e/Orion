package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Region;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class S3ClientCache {
    private final ConcurrentMap<Region, AmazonS3Client> clientsByRegion = new ConcurrentHashMap();
    private final AWSCredentialsProvider credentialProvider;

    S3ClientCache(AWSCredentialsProvider aWSCredentialsProvider) {
        this.credentialProvider = aWSCredentialsProvider;
    }

    public void useClient(AmazonS3Client amazonS3Client) {
        this.clientsByRegion.put(amazonS3Client.getRegion(), amazonS3Client);
    }

    public AmazonS3Client getClient(Region region) {
        if (region != null) {
            AmazonS3Client amazonS3Client = (AmazonS3Client) this.clientsByRegion.get(region);
            if (amazonS3Client != null) {
                return amazonS3Client;
            }
            AmazonS3Client amazonS3Client2 = new AmazonS3Client(this.credentialProvider, region.toAWSRegion());
            amazonS3Client2.setRegion(region.toAWSRegion());
            AmazonS3Client putIfAbsent = this.clientsByRegion.putIfAbsent(region, amazonS3Client2);
            return putIfAbsent == null ? amazonS3Client2 : putIfAbsent;
        }
        throw new IllegalArgumentException("S3 region must be specified");
    }
}
