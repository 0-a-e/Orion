package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.text.Typography;

/* compiled from: RawSubstitution.kt */
public final class RawSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final JavaTypeAttributes lowerTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, (TypeParameterDescriptor) null, 5, (Object) null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    private static final JavaTypeAttributes upperTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, (TypeParameterDescriptor) null, 5, (Object) null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public RawSubstitution() {
        this((TypeParameterUpperBoundEraser) null, 1, (DefaultConstructorMarker) null);
    }

    public boolean isEmpty() {
        return false;
    }

    public RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser2) {
        RawProjectionComputer rawProjectionComputer = new RawProjectionComputer();
        this.projectionComputer = rawProjectionComputer;
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser2 == null ? new TypeParameterUpperBoundEraser(rawProjectionComputer, (TypeParameterErasureOptions) null, 2, (DefaultConstructorMarker) null) : typeParameterUpperBoundEraser2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeParameterUpperBoundEraser2);
    }

    public TypeProjectionImpl get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, TransferTable.COLUMN_KEY);
        return new TypeProjectionImpl(eraseType$default(this, kotlinType, (JavaTypeAttributes) null, 2, (Object) null));
    }

    static /* synthetic */ KotlinType eraseType$default(RawSubstitution rawSubstitution, KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes, int i, Object obj) {
        if ((i & 2) != 0) {
            javaTypeAttributes = new JavaTypeAttributes(TypeUsage.COMMON, (JavaTypeFlexibility) null, false, false, (Set) null, (SimpleType) null, 62, (DefaultConstructorMarker) null);
        }
        return rawSubstitution.eraseType(kotlinType, javaTypeAttributes);
    }

    private final KotlinType eraseType(KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes) {
        UnwrappedType unwrappedType;
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((TypeParameterDescriptor) declarationDescriptor, javaTypeAttributes.markIsRaw(true)), javaTypeAttributes);
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor declarationDescriptor2 = FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor2 instanceof ClassDescriptor) {
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor, lowerTypeAttr);
                SimpleType component1 = eraseInflexibleBasedOnClassDescriptor.component1();
                boolean booleanValue = eraseInflexibleBasedOnClassDescriptor.component2().booleanValue();
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor2, upperTypeAttr);
                SimpleType component12 = eraseInflexibleBasedOnClassDescriptor2.component1();
                boolean booleanValue2 = eraseInflexibleBasedOnClassDescriptor2.component2().booleanValue();
                if (booleanValue || booleanValue2) {
                    unwrappedType = new RawTypeImpl(component1, component12);
                } else {
                    unwrappedType = KotlinTypeFactory.flexibleType(component1, component12);
                }
                return unwrappedType;
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + Typography.quote).toString());
        }
        throw new IllegalStateException(("Unexpected declaration kind: " + declarationDescriptor).toString());
    }

    /* access modifiers changed from: private */
    public final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(SimpleType simpleType, ClassDescriptor classDescriptor, JavaTypeAttributes javaTypeAttributes) {
        SimpleType simpleType2 = simpleType;
        ClassDescriptor classDescriptor2 = classDescriptor;
        JavaTypeAttributes javaTypeAttributes2 = javaTypeAttributes;
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(simpleType2, false);
        }
        KotlinType kotlinType = simpleType2;
        if (KotlinBuiltIns.isArray(kotlinType)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(simpleType.getAttributes(), simpleType.getConstructor(), CollectionsKt.listOf(new TypeProjectionImpl(projectionKind, eraseType(type, javaTypeAttributes2))), simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null), false);
        } else if (KotlinTypeKt.isError(kotlinType)) {
            return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, simpleType.getConstructor().toString()), false);
        } else {
            MemberScope memberScope = classDescriptor2.getMemberScope(this);
            Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
            TypeAttributes attributes = simpleType.getAttributes();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
            List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            Iterable<TypeParameterDescriptor> iterable = parameters;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
                Intrinsics.checkNotNull(typeParameterDescriptor);
                arrayList.add(ErasureProjectionComputer.computeProjection$default(this.projectionComputer, typeParameterDescriptor, javaTypeAttributes2, this.typeParameterUpperBoundEraser, (KotlinType) null, 8, (Object) null));
            }
            return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor, (List) arrayList, simpleType.isMarkedNullable(), memberScope, new RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(classDescriptor2, this, simpleType2, javaTypeAttributes2)), true);
        }
    }

    /* compiled from: RawSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
