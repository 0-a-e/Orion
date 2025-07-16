package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DescribeEndpointsResultJsonUnmarshaller implements Unmarshaller<DescribeEndpointsResult, JsonUnmarshallerContext> {
    private static DescribeEndpointsResultJsonUnmarshaller instance;

    public DescribeEndpointsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeEndpointsResult describeEndpointsResult = new DescribeEndpointsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Endpoints")) {
                describeEndpointsResult.setEndpoints(new ListUnmarshaller(EndpointJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeEndpointsResult;
    }

    public static DescribeEndpointsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeEndpointsResultJsonUnmarshaller();
        }
        return instance;
    }
}
