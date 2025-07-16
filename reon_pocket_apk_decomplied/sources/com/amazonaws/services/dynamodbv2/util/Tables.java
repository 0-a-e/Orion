package com.amazonaws.services.dynamodbv2.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.model.TableStatus;

public class Tables {
    private static final int DEFAULT_WAIT_INTERVAL = 20000;
    private static final int DEFAULT_WAIT_TIMEOUT = 600000;

    public static boolean doesTableExist(AmazonDynamoDB amazonDynamoDB, String str) {
        try {
            return TableStatus.ACTIVE.toString().equals(amazonDynamoDB.describeTable(new DescribeTableRequest(str)).getTable().getTableStatus());
        } catch (ResourceNotFoundException unused) {
            return false;
        }
    }

    public static void waitForTableToBecomeActive(AmazonDynamoDB amazonDynamoDB, String str) {
        waitForTableToBecomeActive(amazonDynamoDB, str, DEFAULT_WAIT_TIMEOUT, 20000);
    }

    public static void waitForTableToBecomeActive(AmazonDynamoDB amazonDynamoDB, String str, int i, int i2) {
        if (i < 0) {
            throw new AmazonClientException("Timeout must be >= 0");
        } else if (i2 <= 0 || i2 >= i) {
            throw new AmazonClientException("Interval must be > 0 and < timeout");
        } else {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i);
            while (System.currentTimeMillis() < currentTimeMillis) {
                try {
                    TableDescription table = amazonDynamoDB.describeTable(new DescribeTableRequest(str)).getTable();
                    if (table != null && table.getTableStatus().equals(TableStatus.ACTIVE.toString())) {
                        return;
                    }
                } catch (ResourceNotFoundException unused) {
                }
                try {
                    Thread.sleep((long) i2);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                    throw new AmazonClientException("Interrupted while waiting for table to become active", e);
                }
            }
            throw new AmazonClientException("Table " + str + " never became active");
        }
    }
}
