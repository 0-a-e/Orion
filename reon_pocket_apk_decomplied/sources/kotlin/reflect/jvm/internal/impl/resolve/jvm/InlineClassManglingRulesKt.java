package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: inlineClassManglingRules.kt */
public final class InlineClassManglingRulesKt {
    public static final boolean shouldHideConstructorDueToValueClassTypeValueParameters(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        ClassConstructorDescriptor classConstructorDescriptor = callableMemberDescriptor instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) callableMemberDescriptor : null;
        if (classConstructorDescriptor == null || DescriptorVisibilities.isPrivate(classConstructorDescriptor.getVisibility())) {
            return false;
        }
        ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
        if (InlineClassesUtilsKt.isValueClass(constructedClass) || DescriptorUtils.isSealedClass(classConstructorDescriptor.getConstructedClass())) {
            return false;
        }
        List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        Iterable<ValueParameterDescriptor> iterable = valueParameters;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (ValueParameterDescriptor type : iterable) {
            KotlinType type2 = type.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            if (requiresFunctionNameManglingInParameterTypes(type2)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isValueClassThatRequiresMangling(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return InlineClassesUtilsKt.isValueClass(declarationDescriptor) && !isDontMangleClass((ClassDescriptor) declarationDescriptor);
    }

    public static final boolean isValueClassThatRequiresMangling(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return false;
        }
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        return (InlineClassesUtilsKt.isInlineClass(declarationDescriptor2) && isValueClassThatRequiresMangling(declarationDescriptor2)) || InlineClassesUtilsKt.needsMfvcFlattening(kotlinType);
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType kotlinType) {
        return isValueClassThatRequiresMangling(kotlinType) || isTypeParameterWithUpperBoundThatRequiresMangling(kotlinType, true);
    }

    private static final boolean isDontMangleClass(ClassDescriptor classDescriptor) {
        return Intrinsics.areEqual((Object) DescriptorUtilsKt.getFqNameSafe(classDescriptor), (Object) StandardNames.RESULT_FQ_NAME);
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType kotlinType, boolean z) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return false;
        }
        if ((z || !InlineClassesUtilsKt.isMultiFieldValueClass(typeParameterDescriptor)) && requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(typeParameterDescriptor))) {
            return true;
        }
        return false;
    }
}
