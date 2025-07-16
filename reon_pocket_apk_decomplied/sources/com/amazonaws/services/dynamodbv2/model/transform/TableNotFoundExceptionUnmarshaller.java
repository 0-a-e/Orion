package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.dynamodbv2.model.TableNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class TableNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TableNotFoundExceptionUnmarshaller() {
        super(TableNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("TableNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        TableNotFoundException tableNotFoundException = (TableNotFoundException) super.unmarshall(jsonErrorResponse);
        tableNotFoundException.setErrorCode("TableNotFoundException");
        return tableNotFoundException;
    }
}
