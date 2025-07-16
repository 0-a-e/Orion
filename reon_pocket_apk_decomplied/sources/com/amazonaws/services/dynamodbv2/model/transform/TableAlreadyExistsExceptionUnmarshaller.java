package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.TableAlreadyExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class TableAlreadyExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TableAlreadyExistsExceptionUnmarshaller() {
        super(TableAlreadyExistsException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("TableAlreadyExistsException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        TableAlreadyExistsException tableAlreadyExistsException = (TableAlreadyExistsException) super.unmarshall(jsonErrorResponse);
        tableAlreadyExistsException.setErrorCode("TableAlreadyExistsException");
        return tableAlreadyExistsException;
    }
}
