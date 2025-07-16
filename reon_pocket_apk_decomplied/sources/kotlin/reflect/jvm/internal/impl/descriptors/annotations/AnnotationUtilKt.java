package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;

/* compiled from: annotationUtil.kt */
public final class AnnotationUtilKt {
    private static final Name DEPRECATED_LEVEL_NAME;
    private static final Name DEPRECATED_MESSAGE_NAME;
    private static final Name DEPRECATED_REPLACE_WITH_NAME;
    private static final Name REPLACE_WITH_EXPRESSION_NAME;
    private static final Name REPLACE_WITH_IMPORTS_NAME;

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3, z);
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "replaceWith");
        Intrinsics.checkNotNullParameter(str3, FirebaseAnalytics.Param.LEVEL);
        KotlinBuiltIns kotlinBuiltIns2 = kotlinBuiltIns;
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns2, StandardNames.FqNames.replaceWith, MapsKt.mapOf(TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new StringValue(str2)), TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new ArrayValue(CollectionsKt.emptyList(), new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(kotlinBuiltIns)))), false, 8, (DefaultConstructorMarker) null);
        FqName fqName = StandardNames.FqNames.deprecated;
        Name name = DEPRECATED_LEVEL_NAME;
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.deprecationLevel);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(...)");
        Name identifier = Name.identifier(str3);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt.mapOf(TuplesKt.to(DEPRECATED_MESSAGE_NAME, new StringValue(str)), TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(builtInAnnotationDescriptor)), TuplesKt.to(name, new EnumValue(classId, identifier))), z);
    }

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        DEPRECATED_MESSAGE_NAME = identifier;
        Name identifier2 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
        DEPRECATED_REPLACE_WITH_NAME = identifier2;
        Name identifier3 = Name.identifier(FirebaseAnalytics.Param.LEVEL);
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(...)");
        DEPRECATED_LEVEL_NAME = identifier3;
        Name identifier4 = Name.identifier("expression");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(...)");
        REPLACE_WITH_EXPRESSION_NAME = identifier4;
        Name identifier5 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(...)");
        REPLACE_WITH_IMPORTS_NAME = identifier5;
    }
}
