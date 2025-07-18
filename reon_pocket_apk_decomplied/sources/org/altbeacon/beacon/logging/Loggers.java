package org.altbeacon.beacon.logging;

public final class Loggers {
    private static final ApiTrackingLogger API_TRACKING_ANDROID_LOGGER = new ApiTrackingLogger();
    private static final Logger EMPTY_LOGGER = new EmptyLogger();
    private static final Logger INFO_ANDROID_LOGGER = new InfoAndroidLogger();
    private static final Logger VERBOSE_ANDROID_LOGGER = new VerboseAndroidLogger();
    private static final Logger WARNING_ANDROID_LOGGER = new WarningAndroidLogger();

    public static Logger empty() {
        return EMPTY_LOGGER;
    }

    public static Logger verboseLogger() {
        return VERBOSE_ANDROID_LOGGER;
    }

    public static Logger infoLogger() {
        return INFO_ANDROID_LOGGER;
    }

    public static Logger warningLogger() {
        return WARNING_ANDROID_LOGGER;
    }

    public static ApiTrackingLogger apiTrackingLogger() {
        return API_TRACKING_ANDROID_LOGGER;
    }

    private Loggers() {
    }
}
