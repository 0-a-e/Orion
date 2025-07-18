package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* compiled from: JavaVisibilities.kt */
public final class JavaVisibilities {
    public static final JavaVisibilities INSTANCE = new JavaVisibilities();

    /* compiled from: JavaVisibilities.kt */
    public static final class PackageVisibility extends Visibility {
        public static final PackageVisibility INSTANCE = new PackageVisibility();

        private PackageVisibility() {
            super("package", false);
        }

        public Integer compareTo(Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (this == visibility) {
                return 0;
            }
            if (Visibilities.INSTANCE.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }

        public String getInternalDisplayName() {
            return "public/*package*/";
        }
    }

    private JavaVisibilities() {
    }

    /* compiled from: JavaVisibilities.kt */
    public static final class ProtectedStaticVisibility extends Visibility {
        public static final ProtectedStaticVisibility INSTANCE = new ProtectedStaticVisibility();

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }

        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }
    }

    /* compiled from: JavaVisibilities.kt */
    public static final class ProtectedAndPackage extends Visibility {
        public static final ProtectedAndPackage INSTANCE = new ProtectedAndPackage();

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        public Integer compareTo(Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (Intrinsics.areEqual((Object) this, (Object) visibility)) {
                return 0;
            }
            if (visibility == Visibilities.Internal.INSTANCE) {
                return null;
            }
            return Integer.valueOf(Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1);
        }

        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }

        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }
    }
}
