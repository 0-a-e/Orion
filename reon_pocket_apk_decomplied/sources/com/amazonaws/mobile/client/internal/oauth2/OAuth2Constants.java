package com.amazonaws.mobile.client.internal.oauth2;

import com.google.firebase.messaging.Constants;

/* compiled from: OAuth2Client */
class OAuth2Constants {
    public static final String GRANT_TYPE = "grant_type";
    public static final String SCOPES = "scopes";

    OAuth2Constants() {
    }

    /* compiled from: OAuth2Client */
    enum TokenResponseFields {
        ACCESS_TOKEN("access_token"),
        ID_TOKEN("id_token"),
        REFRESH_TOKEN("refresh_token"),
        TOKEN_TYPE("token_type"),
        EXPIRES_IN("expires_in"),
        SCOPES(OAuth2Constants.SCOPES),
        ERROR(Constants.IPC_BUNDLE_KEY_SEND_ERROR),
        ERROR_DESCRIPTION("error_description"),
        ERROR_URI("error_uri");
        
        private final String value;

        private TokenResponseFields(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    /* compiled from: OAuth2Client */
    enum TokenRequestFields {
        ACCESS_TOKEN("access_token"),
        ID_TOKEN("id_token");
        
        private final String value;

        private TokenRequestFields(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    /* compiled from: OAuth2Client */
    enum GrantTypes {
        AUTHORIZATION_CODE("authorization_code"),
        REFRESH_TOKEN("refresh_token");
        
        private final String value;

        private GrantTypes(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }
}
