package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CrashlyticsReportJsonTransform$$ExternalSyntheticLambda1 implements CrashlyticsReportJsonTransform.ObjectParser {
    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
    }
}
