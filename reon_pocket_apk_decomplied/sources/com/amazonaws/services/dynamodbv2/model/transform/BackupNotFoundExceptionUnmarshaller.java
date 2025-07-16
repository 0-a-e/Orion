package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.BackupNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class BackupNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public BackupNotFoundExceptionUnmarshaller() {
        super(BackupNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("BackupNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        BackupNotFoundException backupNotFoundException = (BackupNotFoundException) super.unmarshall(jsonErrorResponse);
        backupNotFoundException.setErrorCode("BackupNotFoundException");
        return backupNotFoundException;
    }
}
