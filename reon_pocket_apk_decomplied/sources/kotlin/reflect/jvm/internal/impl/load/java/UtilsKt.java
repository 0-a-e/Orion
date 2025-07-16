package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: utils.kt */
public final class UtilsKt {
    public static final DescriptorVisibility toDescriptorVisibility(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "<this>");
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility(visibility);
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(...)");
        return descriptorVisibility;
    }

    public static final boolean isJspecifyEnabledInStrictMode(JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.STRICT;
    }

    public static final boolean hasErasedValueParameters(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "memberDescriptor");
        return (callableMemberDescriptor instanceof FunctionDescriptor) && Intrinsics.areEqual(callableMemberDescriptor.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), (Object) true);
    }

    public static final AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard(LazyJavaResolverContext lazyJavaResolverContext, JavaWildcardType javaWildcardType) {
        Object obj;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaWildcardType, "wildcardType");
        if (javaWildcardType.getBound() != null) {
            Iterator it = new LazyJavaAnnotations(lazyJavaResolverContext, javaWildcardType, false, 4, (DefaultConstructorMarker) null).iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) obj;
                FqName[] rxjava3_annotations = JavaNullabilityAnnotationSettingsKt.getRXJAVA3_ANNOTATIONS();
                int length = rxjava3_annotations.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (Intrinsics.areEqual((Object) annotationDescriptor.getFqName(), (Object) rxjava3_annotations[i])) {
                            break loop0;
                        }
                        i++;
                    }
                }
            }
            return (AnnotationDescriptor) obj;
        }
        throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported".toString());
    }
}
