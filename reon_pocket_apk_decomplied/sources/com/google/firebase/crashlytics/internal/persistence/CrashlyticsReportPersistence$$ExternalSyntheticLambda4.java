package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CrashlyticsReportPersistence$$ExternalSyntheticLambda4 implements FilenameFilter {
    public final /* synthetic */ String f$0;

    public /* synthetic */ CrashlyticsReportPersistence$$ExternalSyntheticLambda4(String str) {
        this.f$0 = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.f$0);
    }
}
