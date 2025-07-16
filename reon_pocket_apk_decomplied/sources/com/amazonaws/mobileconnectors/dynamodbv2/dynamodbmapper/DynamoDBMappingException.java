package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

public class DynamoDBMappingException extends RuntimeException {
    private static final long serialVersionUID = -4883173289978517967L;

    public DynamoDBMappingException() {
    }

    public DynamoDBMappingException(String str, Throwable th) {
        super(str, th);
    }

    public DynamoDBMappingException(String str) {
        super(str);
    }

    public DynamoDBMappingException(Throwable th) {
        super(th);
    }
}
