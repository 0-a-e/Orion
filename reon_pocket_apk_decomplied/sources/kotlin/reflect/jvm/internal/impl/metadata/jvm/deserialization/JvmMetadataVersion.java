package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* compiled from: JvmMetadataVersion.kt */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final JvmMetadataVersion INSTANCE;
    public static final JvmMetadataVersion INSTANCE_NEXT;
    public static final JvmMetadataVersion INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    private final boolean isStrictSemantics;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        Intrinsics.checkNotNullParameter(iArr, "versionArray");
        this.isStrictSemantics = z;
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int... iArr) {
        this(iArr, false);
        Intrinsics.checkNotNullParameter(iArr, "numbers");
    }

    public final JvmMetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean z) {
        JvmMetadataVersion jvmMetadataVersion = z ? INSTANCE : INSTANCE_NEXT;
        return jvmMetadataVersion.newerThan(this) ? jvmMetadataVersion : this;
    }

    public final boolean isCompatible(JvmMetadataVersion jvmMetadataVersion) {
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "metadataVersionFromLanguageVersion");
        if (getMajor() == 2 && getMinor() == 0) {
            JvmMetadataVersion jvmMetadataVersion2 = INSTANCE;
            if (jvmMetadataVersion2.getMajor() == 1 && jvmMetadataVersion2.getMinor() == 8) {
                return true;
            }
        }
        return isCompatibleInternal(jvmMetadataVersion.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics));
    }

    private final boolean isCompatibleInternal(JvmMetadataVersion jvmMetadataVersion) {
        if ((getMajor() == 1 && getMinor() == 0) || getMajor() == 0) {
            return false;
        }
        return !newerThan(jvmMetadataVersion);
    }

    public final JvmMetadataVersion next() {
        if (getMajor() == 1 && getMinor() == 9) {
            return new JvmMetadataVersion(2, 0, 0);
        }
        return new JvmMetadataVersion(getMajor(), getMinor() + 1, 0);
    }

    private final boolean newerThan(JvmMetadataVersion jvmMetadataVersion) {
        if (getMajor() > jvmMetadataVersion.getMajor()) {
            return true;
        }
        if (getMajor() >= jvmMetadataVersion.getMajor() && getMinor() > jvmMetadataVersion.getMinor()) {
            return true;
        }
        return false;
    }

    /* compiled from: JvmMetadataVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(1, 9, 0);
        INSTANCE = jvmMetadataVersion;
        INSTANCE_NEXT = jvmMetadataVersion.next();
    }
}
