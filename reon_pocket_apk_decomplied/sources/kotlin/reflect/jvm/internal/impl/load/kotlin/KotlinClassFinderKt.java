package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: KotlinClassFinder.kt */
public final class KotlinClassFinderKt {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, ClassId classId, JvmMetadataVersion jvmMetadataVersion) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "jvmMetadataVersion");
        KotlinClassFinder.Result findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(classId, jvmMetadataVersion);
        if (findKotlinClassOrContent != null) {
            return findKotlinClassOrContent.toKotlinJvmBinaryClass();
        }
        return null;
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, JavaClass javaClass, JvmMetadataVersion jvmMetadataVersion) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "jvmMetadataVersion");
        KotlinClassFinder.Result findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(javaClass, jvmMetadataVersion);
        if (findKotlinClassOrContent != null) {
            return findKotlinClassOrContent.toKotlinJvmBinaryClass();
        }
        return null;
    }
}
