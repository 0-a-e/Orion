package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserAttributeUpdateSettingsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class UserAttributeUpdateSettingsTypeJsonUnmarshaller implements Unmarshaller<UserAttributeUpdateSettingsType, JsonUnmarshallerContext> {
    private static UserAttributeUpdateSettingsTypeJsonUnmarshaller instance;

    UserAttributeUpdateSettingsTypeJsonUnmarshaller() {
    }

    public UserAttributeUpdateSettingsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        UserAttributeUpdateSettingsType userAttributeUpdateSettingsType = new UserAttributeUpdateSettingsType();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("AttributesRequireVerificationBeforeUpdate")) {
                userAttributeUpdateSettingsType.setAttributesRequireVerificationBeforeUpdate(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return userAttributeUpdateSettingsType;
    }

    public static UserAttributeUpdateSettingsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UserAttributeUpdateSettingsTypeJsonUnmarshaller();
        }
        return instance;
    }
}
