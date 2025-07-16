package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class UserContextDataTypeJsonUnmarshaller implements Unmarshaller<UserContextDataType, JsonUnmarshallerContext> {
    private static UserContextDataTypeJsonUnmarshaller instance;

    UserContextDataTypeJsonUnmarshaller() {
    }

    public UserContextDataType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        UserContextDataType userContextDataType = new UserContextDataType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IpAddress")) {
                userContextDataType.setIpAddress(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("EncodedData")) {
                userContextDataType.setEncodedData(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return userContextDataType;
    }

    public static UserContextDataTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UserContextDataTypeJsonUnmarshaller();
        }
        return instance;
    }
}
