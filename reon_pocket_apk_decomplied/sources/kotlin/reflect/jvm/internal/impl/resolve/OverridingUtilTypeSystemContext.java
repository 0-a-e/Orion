package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerStateKt;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: OverridingUtilTypeSystemContext.kt */
public final class OverridingUtilTypeSystemContext implements ClassicTypeSystemContext {
    /* access modifiers changed from: private */
    public final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final Map<TypeConstructor, TypeConstructor> matchingTypeConstructors;

    public List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "<this>");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "constructor");
        return null;
    }

    public OverridingUtilTypeSystemContext(Map<TypeConstructor, ? extends TypeConstructor> map, KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, KotlinTypeRefiner kotlinTypeRefiner2, KotlinTypePreparator kotlinTypePreparator2, Function2<? super KotlinType, ? super KotlinType, Boolean> function2) {
        Intrinsics.checkNotNullParameter(typeConstructorEquality, "equalityAxioms");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator2, "kotlinTypePreparator");
        this.matchingTypeConstructors = map;
        this.equalityAxioms = typeConstructorEquality;
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
        this.kotlinTypePreparator = kotlinTypePreparator2;
        this.customSubtype = function2;
    }

    public int argumentsCount(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, kotlinTypeMarker);
    }

    public TypeArgumentListMarker asArgumentList(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, simpleTypeMarker);
    }

    public CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, simpleTypeMarker);
    }

    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, simpleTypeMarker);
    }

    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, flexibleTypeMarker);
    }

    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker asSimpleType(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, kotlinTypeMarker);
    }

    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker captureFromArguments(SimpleTypeMarker simpleTypeMarker, CaptureStatus captureStatus) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, simpleTypeMarker, captureStatus);
    }

    public CaptureStatus captureStatus(CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, capturedTypeMarker);
    }

    public KotlinTypeMarker createFlexibleType(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, simpleTypeMarker, simpleTypeMarker2);
    }

    public TypeArgumentMarker getArgument(KotlinTypeMarker kotlinTypeMarker, int i) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, kotlinTypeMarker, i);
    }

    public List<TypeArgumentMarker> getArguments(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, kotlinTypeMarker);
    }

    public FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, typeConstructorMarker);
    }

    public TypeParameterMarker getParameter(TypeConstructorMarker typeConstructorMarker, int i) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, typeConstructorMarker, i);
    }

    public List<TypeParameterMarker> getParameters(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, typeConstructorMarker);
    }

    public PrimitiveType getPrimitiveArrayType(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, typeConstructorMarker);
    }

    public PrimitiveType getPrimitiveType(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, typeConstructorMarker);
    }

    public KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, typeParameterMarker);
    }

    public KotlinTypeMarker getType(TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, typeArgumentMarker);
    }

    public TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, typeVariableTypeConstructorMarker);
    }

    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, typeConstructorMarker);
    }

    public KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, kotlinTypeMarker);
    }

    public List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, typeParameterMarker);
    }

    public TypeVariance getVariance(TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeArgumentMarker);
    }

    public TypeVariance getVariance(TypeParameterMarker typeParameterMarker) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeParameterMarker);
    }

    public boolean hasAnnotation(KotlinTypeMarker kotlinTypeMarker, FqName fqName) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, kotlinTypeMarker, fqName);
    }

    public boolean hasRecursiveBounds(TypeParameterMarker typeParameterMarker, TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, typeParameterMarker, typeConstructorMarker);
    }

    public boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, simpleTypeMarker, simpleTypeMarker2);
    }

    public KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> list) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, list);
    }

    public boolean isAnyConstructor(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, typeConstructorMarker);
    }

    public boolean isClassTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isCommonFinalClassConstructor(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, typeConstructorMarker);
    }

    public boolean isDenotable(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, typeConstructorMarker);
    }

    public boolean isError(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, kotlinTypeMarker);
    }

    public boolean isInlineClass(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, typeConstructorMarker);
    }

    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isIntersection(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, typeConstructorMarker);
    }

    public boolean isMarkedNullable(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, simpleTypeMarker);
    }

    public boolean isNotNullTypeParameter(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, kotlinTypeMarker);
    }

    public boolean isNothingConstructor(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, typeConstructorMarker);
    }

    public boolean isNullableType(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, kotlinTypeMarker);
    }

    public boolean isOldCapturedType(CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, capturedTypeMarker);
    }

    public boolean isPrimitiveType(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, simpleTypeMarker);
    }

    public boolean isProjectionNotNull(CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, capturedTypeMarker);
    }

    public boolean isRawType(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isRawType(this, kotlinTypeMarker);
    }

    public boolean isSingleClassifierType(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, simpleTypeMarker);
    }

    public boolean isStarProjection(TypeArgumentMarker typeArgumentMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, typeArgumentMarker);
    }

    public boolean isStubType(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, simpleTypeMarker);
    }

    public boolean isStubTypeForBuilderInference(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, simpleTypeMarker);
    }

    public boolean isTypeVariableType(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, kotlinTypeMarker);
    }

    public boolean isUnderKotlinPackage(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, typeConstructorMarker);
    }

    public SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, flexibleTypeMarker);
    }

    public KotlinTypeMarker lowerType(CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, capturedTypeMarker);
    }

    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker original(DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, definitelyNotNullTypeMarker);
    }

    public int parametersCount(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, typeConstructorMarker);
    }

    public Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, simpleTypeMarker);
    }

    public TypeArgumentMarker projection(CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, capturedTypeConstructorMarker);
    }

    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, simpleTypeMarker);
    }

    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker typeConstructorMarker) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, typeConstructorMarker);
    }

    public CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker capturedTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, capturedTypeMarker);
    }

    public TypeConstructorMarker typeConstructor(SimpleTypeMarker simpleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, simpleTypeMarker);
    }

    public SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, flexibleTypeMarker);
    }

    public KotlinTypeMarker withNullability(KotlinTypeMarker kotlinTypeMarker, boolean z) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext) this, kotlinTypeMarker, z);
    }

    public SimpleTypeMarker withNullability(SimpleTypeMarker simpleTypeMarker, boolean z) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability((ClassicTypeSystemContext) this, simpleTypeMarker, z);
    }

    public boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "c1");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "c2");
        if (!(typeConstructorMarker instanceof TypeConstructor)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (typeConstructorMarker2 instanceof TypeConstructor) {
            return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, typeConstructorMarker, typeConstructorMarker2) || areEqualTypeConstructorsByAxioms((TypeConstructor) typeConstructorMarker, (TypeConstructor) typeConstructorMarker2);
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public TypeCheckerState newTypeCheckerState(boolean z, boolean z2) {
        if (this.customSubtype == null) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState(z, z2, this, this.kotlinTypePreparator, this.kotlinTypeRefiner);
        }
        return new OverridingUtilTypeSystemContext$newTypeCheckerState$1(z, z2, this, this.kotlinTypePreparator, this.kotlinTypeRefiner);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = withNullability(r0, true);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker makeNullable(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3) {
        /*
            r2 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r2.asSimpleType(r3)
            if (r0 == 0) goto L_0x0015
            r1 = 1
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0, (boolean) r1)
            if (r0 == 0) goto L_0x0015
            r3 = r0
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilTypeSystemContext.makeNullable(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker):kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker");
    }

    private final boolean areEqualTypeConstructorsByAxioms(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        if (this.equalityAxioms.equals(typeConstructor, typeConstructor2)) {
            return true;
        }
        Map<TypeConstructor, TypeConstructor> map = this.matchingTypeConstructors;
        if (map == null) {
            return false;
        }
        TypeConstructor typeConstructor3 = map.get(typeConstructor);
        TypeConstructor typeConstructor4 = this.matchingTypeConstructors.get(typeConstructor2);
        if (typeConstructor3 != null && Intrinsics.areEqual((Object) typeConstructor3, (Object) typeConstructor2)) {
            return true;
        }
        if (typeConstructor4 == null || !Intrinsics.areEqual((Object) typeConstructor4, (Object) typeConstructor)) {
            return false;
        }
        return true;
    }

    public boolean isCapturedType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        SimpleTypeMarker asSimpleType = asSimpleType(kotlinTypeMarker);
        return (asSimpleType != null ? asCapturedType(asSimpleType) : null) != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = original(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker originalIfDefinitelyNotNullable(kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r2) {
        /*
            r1 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker r0 = r1.asDefinitelyNotNullType(r2)
            if (r0 == 0) goto L_0x0013
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r1.original(r0)
            if (r0 != 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r2 = r0
        L_0x0013:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilTypeSystemContext.originalIfDefinitelyNotNullable(kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker");
    }

    public boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return (kotlinTypeMarker instanceof SimpleTypeMarker) && isMarkedNullable((SimpleTypeMarker) kotlinTypeMarker);
    }

    public TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker simpleTypeMarker, int i) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "<this>");
        if (i < 0 || i >= argumentsCount(simpleTypeMarker)) {
            return null;
        }
        return getArgument(simpleTypeMarker, i);
    }

    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        SimpleTypeMarker lowerBound;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        FlexibleTypeMarker asFlexibleType = asFlexibleType(kotlinTypeMarker);
        if (asFlexibleType != null && (lowerBound = lowerBound(asFlexibleType)) != null) {
            return lowerBound;
        }
        SimpleTypeMarker asSimpleType = asSimpleType(kotlinTypeMarker);
        Intrinsics.checkNotNull(asSimpleType);
        return asSimpleType;
    }

    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        SimpleTypeMarker upperBound;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        FlexibleTypeMarker asFlexibleType = asFlexibleType(kotlinTypeMarker);
        if (asFlexibleType != null && (upperBound = upperBound(asFlexibleType)) != null) {
            return upperBound;
        }
        SimpleTypeMarker asSimpleType = asSimpleType(kotlinTypeMarker);
        Intrinsics.checkNotNull(asSimpleType);
        return asSimpleType;
    }

    public boolean isDynamic(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        FlexibleTypeMarker asFlexibleType = asFlexibleType(kotlinTypeMarker);
        return (asFlexibleType != null ? asDynamicType(asFlexibleType) : null) != null;
    }

    public boolean isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        SimpleTypeMarker asSimpleType = asSimpleType(kotlinTypeMarker);
        return (asSimpleType != null ? asDefinitelyNotNullType(asSimpleType) : null) != null;
    }

    public boolean hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return isMarkedNullable(lowerBoundIfFlexible(kotlinTypeMarker)) != isMarkedNullable(upperBoundIfFlexible(kotlinTypeMarker));
    }

    public TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        SimpleTypeMarker asSimpleType = asSimpleType(kotlinTypeMarker);
        if (asSimpleType == null) {
            asSimpleType = lowerBoundIfFlexible(kotlinTypeMarker);
        }
        return typeConstructor(asSimpleType);
    }

    public boolean isNothing(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return isNothingConstructor(typeConstructor(kotlinTypeMarker)) && !isNullableType(kotlinTypeMarker);
    }

    public boolean isClassType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "<this>");
        return isClassTypeConstructor(typeConstructor(simpleTypeMarker));
    }

    public boolean isIntegerLiteralType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "<this>");
        return isIntegerLiteralTypeConstructor(typeConstructor(simpleTypeMarker));
    }

    public TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        Intrinsics.checkNotNullParameter(typeArgumentListMarker, "<this>");
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            return getArgument((KotlinTypeMarker) typeArgumentListMarker, i);
        }
        if (typeArgumentListMarker instanceof ArgumentList) {
            Object obj = ((ArgumentList) typeArgumentListMarker).get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            return (TypeArgumentMarker) obj;
        }
        throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
    }

    public int size(TypeArgumentListMarker typeArgumentListMarker) {
        Intrinsics.checkNotNullParameter(typeArgumentListMarker, "<this>");
        if (typeArgumentListMarker instanceof SimpleTypeMarker) {
            return argumentsCount((KotlinTypeMarker) typeArgumentListMarker);
        }
        if (typeArgumentListMarker instanceof ArgumentList) {
            return ((ArgumentList) typeArgumentListMarker).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
    }
}
