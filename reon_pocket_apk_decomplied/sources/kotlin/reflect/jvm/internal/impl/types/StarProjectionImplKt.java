package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImplKt {
    private static final KotlinType buildStarProjectionTypeByTypeParameters(List<? extends TypeConstructor> list, List<? extends KotlinType> list2, KotlinBuiltIns kotlinBuiltIns) {
        KotlinType substitute = TypeSubstitutor.create((TypeSubstitution) new StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1(list)).substitute((KotlinType) CollectionsKt.first(list2), Variance.OUT_VARIANCE);
        if (substitute == null) {
            substitute = kotlinBuiltIns.getDefaultBound();
        }
        Intrinsics.checkNotNull(substitute);
        return substitute;
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        DeclarationDescriptor containingDeclaration = typeParameterDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        if (containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) {
            List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) containingDeclaration).getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            Iterable<TypeParameterDescriptor> iterable = parameters;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor typeConstructor : iterable) {
                TypeConstructor typeConstructor2 = typeConstructor.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
                arrayList.add(typeConstructor2);
            }
            List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            return buildStarProjectionTypeByTypeParameters((List) arrayList, upperBounds, DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor));
        } else if (containingDeclaration instanceof FunctionDescriptor) {
            List<TypeParameterDescriptor> typeParameters = ((FunctionDescriptor) containingDeclaration).getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            Iterable<TypeParameterDescriptor> iterable2 = typeParameters;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (TypeParameterDescriptor typeConstructor3 : iterable2) {
                TypeConstructor typeConstructor4 = typeConstructor3.getTypeConstructor();
                Intrinsics.checkNotNullExpressionValue(typeConstructor4, "getTypeConstructor(...)");
                arrayList2.add(typeConstructor4);
            }
            List<KotlinType> upperBounds2 = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds2, "getUpperBounds(...)");
            return buildStarProjectionTypeByTypeParameters((List) arrayList2, upperBounds2, DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor));
        } else {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
    }
}
