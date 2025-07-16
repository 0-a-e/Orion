package com.google.firebase.crashlytics.internal.settings.model;

public class FeaturesSettingsData {
    public final boolean collectAnrs;
    public final boolean collectReports;

    public FeaturesSettingsData(boolean z, boolean z2) {
        this.collectReports = z;
        this.collectAnrs = z2;
    }
}
