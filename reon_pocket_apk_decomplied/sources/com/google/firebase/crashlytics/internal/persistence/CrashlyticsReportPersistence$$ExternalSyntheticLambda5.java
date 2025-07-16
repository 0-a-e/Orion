package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FileFilter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CrashlyticsReportPersistence$$ExternalSyntheticLambda5 implements FileFilter {
    public final /* synthetic */ String f$0;

    public /* synthetic */ CrashlyticsReportPersistence$$ExternalSyntheticLambda5(String str) {
        this.f$0 = str;
    }

    public final boolean accept(File file) {
        return CrashlyticsReportPersistence.lambda$capAndGetOpenSessions$3(this.f$0, file);
    }
}
