package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* compiled from: DeserializationConfiguration.kt */
public interface DeserializationConfiguration {
    boolean getAllowUnstableDependencies();

    BinaryVersion getBinaryVersion();

    boolean getPreserveDeclarationsOrdering();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();

    /* compiled from: DeserializationConfiguration.kt */
    public static final class Default implements DeserializationConfiguration {
        public static final Default INSTANCE = new Default();

        public boolean getAllowUnstableDependencies() {
            return false;
        }

        public BinaryVersion getBinaryVersion() {
            return null;
        }

        public boolean getPreserveDeclarationsOrdering() {
            return false;
        }

        public boolean getReportErrorsOnPreReleaseDependencies() {
            return false;
        }

        public boolean getSkipMetadataVersionCheck() {
            return false;
        }

        public boolean getSkipPrereleaseCheck() {
            return false;
        }

        public boolean getTypeAliasesAllowed() {
            return true;
        }

        private Default() {
        }
    }
}
