package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.BackupInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class BackupInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public BackupInUseExceptionUnmarshaller() {
        super(BackupInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("BackupInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        BackupInUseException backupInUseException = (BackupInUseException) super.unmarshall(jsonErrorResponse);
        backupInUseException.setErrorCode("BackupInUseException");
        return backupInUseException;
    }
}
