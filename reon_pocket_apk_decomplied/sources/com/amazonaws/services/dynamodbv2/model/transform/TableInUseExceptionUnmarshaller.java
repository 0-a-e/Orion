package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.TableInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class TableInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TableInUseExceptionUnmarshaller() {
        super(TableInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("TableInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        TableInUseException tableInUseException = (TableInUseException) super.unmarshall(jsonErrorResponse);
        tableInUseException.setErrorCode("TableInUseException");
        return tableInUseException;
    }
}
