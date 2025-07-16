package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeParameterUpperBoundEraser.kt */
public final class TypeParameterUpperBoundEraser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final TypeParameterErasureOptions options;
    private final ErasureProjectionComputer projectionComputer;
    private final LockBasedStorageManager storage;

    public TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions) {
        Intrinsics.checkNotNullParameter(erasureProjectionComputer, "projectionComputer");
        Intrinsics.checkNotNullParameter(typeParameterErasureOptions, "options");
        this.projectionComputer = erasureProjectionComputer;
        this.options = typeParameterErasureOptions;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$erroneousErasedBound$2(this));
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new TypeParameterUpperBoundEraser$getErasedUpperBound$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "createMemoizedFunction(...)");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeParameterUpperBoundEraser(ErasureProjectionComputer erasureProjectionComputer, TypeParameterErasureOptions typeParameterErasureOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(erasureProjectionComputer, (i & 2) != 0 ? new TypeParameterErasureOptions(false, false) : typeParameterErasureOptions);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    private static final class DataToEraseUpperBound {
        private final ErasureTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + ')';
        }

        public DataToEraseUpperBound(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
            Intrinsics.checkNotNullParameter(erasureTypeAttributes, "typeAttr");
            this.typeParameter = typeParameterDescriptor;
            this.typeAttr = erasureTypeAttributes;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DataToEraseUpperBound)) {
                return false;
            }
            DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
            if (!Intrinsics.areEqual((Object) dataToEraseUpperBound.typeParameter, (Object) this.typeParameter) || !Intrinsics.areEqual((Object) dataToEraseUpperBound.typeAttr, (Object) this.typeAttr)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.typeParameter.hashCode();
            return hashCode + (hashCode * 31) + this.typeAttr.hashCode();
        }
    }

    public final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(erasureTypeAttributes, "typeAttr");
        KotlinType invoke = this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameterDescriptor, erasureTypeAttributes));
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType getDefaultType(kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes r1) {
        /*
            r0 = this;
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getDefaultType()
            if (r1 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r1)
            if (r1 != 0) goto L_0x0014
        L_0x000e:
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r1 = r0.getErroneousErasedBound()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.getDefaultType(kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    /* access modifiers changed from: private */
    public final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, ErasureTypeAttributes erasureTypeAttributes) {
        TypeProjection typeProjection;
        Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(erasureTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        Iterable<TypeParameterDescriptor> extractTypeParametersFromUpperBounds = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(extractTypeParametersFromUpperBounds, 10)), 16));
        for (TypeParameterDescriptor typeParameterDescriptor2 : extractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                typeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor2, erasureTypeAttributes, this, getErasedUpperBound(typeParameterDescriptor2, erasureTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor)));
            } else {
                typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor2, erasureTypeAttributes);
                Intrinsics.checkNotNullExpressionValue(typeProjection, "makeStarProjection(...)");
            }
            Pair pair = TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), typeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        TypeSubstitutor create = TypeSubstitutor.create((TypeSubstitution) TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        Set<KotlinType> substituteErasedUpperBounds = substituteErasedUpperBounds(create, upperBounds, erasureTypeAttributes);
        if (!(!substituteErasedUpperBounds.isEmpty())) {
            return getDefaultType(erasureTypeAttributes);
        }
        if (this.options.getIntersectUpperBounds()) {
            Iterable<KotlinType> list = CollectionsKt.toList(substituteErasedUpperBounds);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (KotlinType unwrap : list) {
                arrayList.add(unwrap.unwrap());
            }
            return IntersectionTypeKt.intersectTypes((List) arrayList);
        } else if (substituteErasedUpperBounds.size() == 1) {
            return (KotlinType) CollectionsKt.single(substituteErasedUpperBounds);
        } else {
            throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
        }
    }

    private final Set<KotlinType> substituteErasedUpperBounds(TypeSubstitutor typeSubstitutor, List<? extends KotlinType> list, ErasureTypeAttributes erasureTypeAttributes) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (KotlinType kotlinType : list) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                createSetBuilder.add(Companion.replaceArgumentsOfUpperBound(kotlinType, typeSubstitutor, erasureTypeAttributes.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
            } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
                Set<TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
                if (visitedTypeParameters == null || !visitedTypeParameters.contains(declarationDescriptor)) {
                    List<KotlinType> upperBounds = ((TypeParameterDescriptor) declarationDescriptor).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                    createSetBuilder.addAll(substituteErasedUpperBounds(typeSubstitutor, upperBounds, erasureTypeAttributes));
                } else {
                    createSetBuilder.add(getDefaultType(erasureTypeAttributes));
                }
            }
            if (!this.options.getIntersectUpperBounds()) {
                break;
            }
        }
        return SetsKt.build(createSetBuilder);
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KotlinType replaceArgumentsOfUpperBound(KotlinType kotlinType, TypeSubstitutor typeSubstitutor, Set<? extends TypeParameterDescriptor> set, boolean z) {
            UnwrappedType unwrappedType;
            KotlinType type;
            KotlinType type2;
            KotlinType type3;
            TypeSubstitutor typeSubstitutor2 = typeSubstitutor;
            Set<? extends TypeParameterDescriptor> set2 = set;
            Intrinsics.checkNotNullParameter(kotlinType, "<this>");
            Intrinsics.checkNotNullParameter(typeSubstitutor2, "substitutor");
            UnwrappedType unwrap = kotlinType.unwrap();
            if (unwrap instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrap;
                SimpleType lowerBound = flexibleType.getLowerBound();
                if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                    List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                    Iterable<TypeParameterDescriptor> iterable = parameters;
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
                        TypeProjection typeProjection = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor.getIndex());
                        if (!(!z || typeProjection == null || (type3 = typeProjection.getType()) == null)) {
                            Intrinsics.checkNotNull(type3);
                            if (!TypeUtilsKt.containsTypeParameter(type3)) {
                                arrayList.add(typeProjection);
                            }
                        }
                        boolean z2 = set2 != null && set2.contains(typeParameterDescriptor);
                        if (typeProjection != null && !z2) {
                            TypeSubstitution substitution = typeSubstitutor.getSubstitution();
                            KotlinType type4 = typeProjection.getType();
                            Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                            if (substitution.get(type4) != null) {
                                arrayList.add(typeProjection);
                            }
                        }
                        typeProjection = new StarProjectionImpl(typeParameterDescriptor);
                        arrayList.add(typeProjection);
                    }
                    lowerBound = TypeSubstitutionKt.replace$default(lowerBound, (List) arrayList, (TypeAttributes) null, 2, (Object) null);
                }
                SimpleType upperBound = flexibleType.getUpperBound();
                if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                    List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters2, "getParameters(...)");
                    Iterable<TypeParameterDescriptor> iterable2 = parameters2;
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor2 : iterable2) {
                        TypeProjection typeProjection2 = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor2.getIndex());
                        if (!(!z || typeProjection2 == null || (type2 = typeProjection2.getType()) == null)) {
                            Intrinsics.checkNotNull(type2);
                            if (!TypeUtilsKt.containsTypeParameter(type2)) {
                                arrayList2.add(typeProjection2);
                            }
                        }
                        boolean z3 = set2 != null && set2.contains(typeParameterDescriptor2);
                        if (typeProjection2 != null && !z3) {
                            TypeSubstitution substitution2 = typeSubstitutor.getSubstitution();
                            KotlinType type5 = typeProjection2.getType();
                            Intrinsics.checkNotNullExpressionValue(type5, "getType(...)");
                            if (substitution2.get(type5) != null) {
                                arrayList2.add(typeProjection2);
                            }
                        }
                        typeProjection2 = new StarProjectionImpl(typeParameterDescriptor2);
                        arrayList2.add(typeProjection2);
                    }
                    upperBound = TypeSubstitutionKt.replace$default(upperBound, (List) arrayList2, (TypeAttributes) null, 2, (Object) null);
                }
                unwrappedType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
            } else if (unwrap instanceof SimpleType) {
                SimpleType simpleType = (SimpleType) unwrap;
                if (!simpleType.getConstructor().getParameters().isEmpty() && simpleType.getConstructor().getDeclarationDescriptor() != null) {
                    List<TypeParameterDescriptor> parameters3 = simpleType.getConstructor().getParameters();
                    Intrinsics.checkNotNullExpressionValue(parameters3, "getParameters(...)");
                    Iterable<TypeParameterDescriptor> iterable3 = parameters3;
                    Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor3 : iterable3) {
                        TypeProjection typeProjection3 = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor3.getIndex());
                        if (!(!z || typeProjection3 == null || (type = typeProjection3.getType()) == null)) {
                            Intrinsics.checkNotNull(type);
                            if (!TypeUtilsKt.containsTypeParameter(type)) {
                                arrayList3.add(typeProjection3);
                            }
                        }
                        boolean z4 = set2 != null && set2.contains(typeParameterDescriptor3);
                        if (typeProjection3 != null && !z4) {
                            TypeSubstitution substitution3 = typeSubstitutor.getSubstitution();
                            KotlinType type6 = typeProjection3.getType();
                            Intrinsics.checkNotNullExpressionValue(type6, "getType(...)");
                            if (substitution3.get(type6) != null) {
                                arrayList3.add(typeProjection3);
                            }
                        }
                        typeProjection3 = new StarProjectionImpl(typeParameterDescriptor3);
                        arrayList3.add(typeProjection3);
                    }
                    simpleType = TypeSubstitutionKt.replace$default(simpleType, (List) arrayList3, (TypeAttributes) null, 2, (Object) null);
                }
                unwrappedType = simpleType;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            KotlinType safeSubstitute = typeSubstitutor2.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap), Variance.OUT_VARIANCE);
            Intrinsics.checkNotNullExpressionValue(safeSubstitute, "safeSubstitute(...)");
            return safeSubstitute;
        }
    }
}
