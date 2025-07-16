package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListTagsOfResourceResultJsonUnmarshaller implements Unmarshaller<ListTagsOfResourceResult, JsonUnmarshallerContext> {
    private static ListTagsOfResourceResultJsonUnmarshaller instance;

    public ListTagsOfResourceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListTagsOfResourceResult listTagsOfResourceResult = new ListTagsOfResourceResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Tags")) {
                listTagsOfResourceResult.setTags(new ListUnmarshaller(TagJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextToken")) {
                listTagsOfResourceResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listTagsOfResourceResult;
    }

    public static ListTagsOfResourceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListTagsOfResourceResultJsonUnmarshaller();
        }
        return instance;
    }
}
