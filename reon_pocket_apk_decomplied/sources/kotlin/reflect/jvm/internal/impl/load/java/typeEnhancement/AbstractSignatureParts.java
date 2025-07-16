package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: AbstractSignatureParts.kt */
public abstract class AbstractSignatureParts<TAnnotation> {
    public abstract boolean forceWarning(TAnnotation tannotation, KotlinTypeMarker kotlinTypeMarker);

    public abstract AbstractAnnotationTypeQualifierResolver<TAnnotation> getAnnotationTypeQualifierResolver();

    public abstract Iterable<TAnnotation> getAnnotations(KotlinTypeMarker kotlinTypeMarker);

    public abstract Iterable<TAnnotation> getContainerAnnotations();

    public abstract AnnotationQualifierApplicabilityType getContainerApplicabilityType();

    public abstract JavaTypeQualifiersByElementType getContainerDefaultTypeQualifiers();

    public abstract boolean getContainerIsVarargParameter();

    public abstract boolean getEnableImprovementsInStrictMode();

    public abstract KotlinTypeMarker getEnhancedForWarnings(KotlinTypeMarker kotlinTypeMarker);

    public boolean getForceOnlyHeadTypeConstructor() {
        return false;
    }

    public abstract FqNameUnsafe getFqNameUnsafe(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean getSkipRawTypeArguments();

    public abstract TypeSystemContext getTypeSystem();

    public abstract boolean isArrayOrPrimitiveArray(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isCovariant();

    public abstract boolean isEqual(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2);

    public abstract boolean isFromJava(TypeParameterMarker typeParameterMarker);

    public boolean isNotNullTypeParameterCompat(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return false;
    }

    private final NullabilityQualifier getNullabilityQualifier(KotlinTypeMarker kotlinTypeMarker) {
        TypeSystemContext typeSystem = getTypeSystem();
        if (typeSystem.isMarkedNullable(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NULLABLE;
        }
        if (!typeSystem.isMarkedNullable(typeSystem.upperBoundIfFlexible(kotlinTypeMarker))) {
            return NullabilityQualifier.NOT_NULL;
        }
        return null;
    }

    private final JavaTypeQualifiers extractQualifiers(KotlinTypeMarker kotlinTypeMarker) {
        NullabilityQualifier nullabilityQualifier;
        NullabilityQualifier nullabilityQualifier2 = getNullabilityQualifier(kotlinTypeMarker);
        MutabilityQualifier mutabilityQualifier = null;
        if (nullabilityQualifier2 == null) {
            KotlinTypeMarker enhancedForWarnings = getEnhancedForWarnings(kotlinTypeMarker);
            nullabilityQualifier = enhancedForWarnings != null ? getNullabilityQualifier(enhancedForWarnings) : null;
        } else {
            nullabilityQualifier = nullabilityQualifier2;
        }
        TypeSystemContext typeSystem = getTypeSystem();
        if (JavaToKotlinClassMap.INSTANCE.isReadOnly(getFqNameUnsafe(typeSystem.lowerBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.READ_ONLY;
        } else if (JavaToKotlinClassMap.INSTANCE.isMutable(getFqNameUnsafe(typeSystem.upperBoundIfFlexible(kotlinTypeMarker)))) {
            mutabilityQualifier = MutabilityQualifier.MUTABLE;
        }
        boolean z = false;
        boolean z2 = getTypeSystem().isDefinitelyNotNullType(kotlinTypeMarker) || isNotNullTypeParameterCompat(kotlinTypeMarker);
        if (nullabilityQualifier != nullabilityQualifier2) {
            z = true;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z2, z);
    }

    private final JavaTypeQualifiers extractQualifiersFromAnnotations(TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        Iterable iterable;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2;
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus3;
        KotlinTypeMarker type;
        TypeConstructorMarker typeConstructor;
        NullabilityQualifier nullabilityQualifier = null;
        if (typeAndDefaultQualifiers.getType() == null) {
            TypeSystemContext typeSystem = getTypeSystem();
            TypeParameterMarker typeParameterForArgument = typeAndDefaultQualifiers.getTypeParameterForArgument();
            if ((typeParameterForArgument != null ? typeSystem.getVariance(typeParameterForArgument) : null) == TypeVariance.IN) {
                return JavaTypeQualifiers.Companion.getNONE();
            }
        }
        boolean z = false;
        boolean z2 = typeAndDefaultQualifiers.getTypeParameterForArgument() == null;
        KotlinTypeMarker type2 = typeAndDefaultQualifiers.getType();
        if (type2 == null || (iterable = getAnnotations(type2)) == null) {
            iterable = CollectionsKt.emptyList();
        }
        TypeSystemContext typeSystem2 = getTypeSystem();
        KotlinTypeMarker type3 = typeAndDefaultQualifiers.getType();
        TypeParameterMarker typeParameterClassifier = (type3 == null || (typeConstructor = typeSystem2.typeConstructor(type3)) == null) ? null : typeSystem2.getTypeParameterClassifier(typeConstructor);
        boolean z3 = getContainerApplicabilityType() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        if (z2) {
            if (z3 || !getEnableImprovementsInStrictMode() || (type = typeAndDefaultQualifiers.getType()) == null || !isArrayOrPrimitiveArray(type)) {
                iterable = CollectionsKt.plus(getContainerAnnotations(), iterable);
            } else {
                Iterable containerAnnotations = getContainerAnnotations();
                Collection arrayList = new ArrayList();
                for (Object next : containerAnnotations) {
                    if (!getAnnotationTypeQualifierResolver().isTypeUseAnnotation(next)) {
                        arrayList.add(next);
                    }
                }
                iterable = CollectionsKt.plus((List) arrayList, iterable);
            }
        }
        MutabilityQualifier extractMutability = getAnnotationTypeQualifierResolver().extractMutability(iterable);
        NullabilityQualifierWithMigrationStatus extractNullability = getAnnotationTypeQualifierResolver().extractNullability(iterable, new AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1(this, typeAndDefaultQualifiers));
        if (extractNullability != null) {
            NullabilityQualifier qualifier = extractNullability.getQualifier();
            if (extractNullability.getQualifier() == NullabilityQualifier.NOT_NULL && typeParameterClassifier != null) {
                z = true;
            }
            return new JavaTypeQualifiers(qualifier, extractMutability, z, extractNullability.isForWarningOnly());
        }
        if (z2 || z3) {
            annotationQualifierApplicabilityType = getContainerApplicabilityType();
        } else {
            annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
        }
        JavaTypeQualifiersByElementType defaultQualifiers = typeAndDefaultQualifiers.getDefaultQualifiers();
        JavaDefaultQualifiers javaDefaultQualifiers = defaultQualifiers != null ? defaultQualifiers.get(annotationQualifierApplicabilityType) : null;
        if (typeParameterClassifier != null) {
            nullabilityQualifierWithMigrationStatus = getBoundsNullability(typeParameterClassifier);
        } else {
            nullabilityQualifierWithMigrationStatus = null;
        }
        if (nullabilityQualifierWithMigrationStatus == null || (nullabilityQualifierWithMigrationStatus2 = NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, NullabilityQualifier.NOT_NULL, false, 2, (Object) null)) == null) {
            nullabilityQualifierWithMigrationStatus2 = javaDefaultQualifiers != null ? javaDefaultQualifiers.getNullabilityQualifier() : null;
        }
        boolean z4 = (nullabilityQualifierWithMigrationStatus != null ? nullabilityQualifierWithMigrationStatus.getQualifier() : null) == NullabilityQualifier.NOT_NULL || !(typeParameterClassifier == null || javaDefaultQualifiers == null || !javaDefaultQualifiers.getDefinitelyNotNull());
        TypeParameterMarker typeParameterForArgument2 = typeAndDefaultQualifiers.getTypeParameterForArgument();
        if (typeParameterForArgument2 == null || (nullabilityQualifierWithMigrationStatus3 = getBoundsNullability(typeParameterForArgument2)) == null) {
            nullabilityQualifierWithMigrationStatus3 = null;
        } else if (nullabilityQualifierWithMigrationStatus3.getQualifier() == NullabilityQualifier.NULLABLE) {
            nullabilityQualifierWithMigrationStatus3 = NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus3, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, (Object) null);
        }
        NullabilityQualifierWithMigrationStatus mostSpecific = mostSpecific(nullabilityQualifierWithMigrationStatus3, nullabilityQualifierWithMigrationStatus2);
        if (mostSpecific != null) {
            nullabilityQualifier = mostSpecific.getQualifier();
        }
        if (mostSpecific != null && mostSpecific.isForWarningOnly()) {
            z = true;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, extractMutability, z4, z);
    }

    private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
        if (nullabilityQualifierWithMigrationStatus == null) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (nullabilityQualifierWithMigrationStatus2 == null) {
            return nullabilityQualifierWithMigrationStatus;
        }
        if (nullabilityQualifierWithMigrationStatus.isForWarningOnly() && !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return nullabilityQualifierWithMigrationStatus2;
        }
        if (nullabilityQualifierWithMigrationStatus.isForWarningOnly() || !nullabilityQualifierWithMigrationStatus2.isForWarningOnly()) {
            return (nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) >= 0 && nullabilityQualifierWithMigrationStatus.getQualifier().compareTo(nullabilityQualifierWithMigrationStatus2.getQualifier()) > 0) ? nullabilityQualifierWithMigrationStatus : nullabilityQualifierWithMigrationStatus2;
        }
        return nullabilityQualifierWithMigrationStatus;
    }

    private final NullabilityQualifierWithMigrationStatus getBoundsNullability(TypeParameterMarker typeParameterMarker) {
        List<KotlinTypeMarker> list;
        NullabilityQualifier nullabilityQualifier;
        TypeSystemContext typeSystem = getTypeSystem();
        if (!isFromJava(typeParameterMarker)) {
            return null;
        }
        List<KotlinTypeMarker> upperBounds = typeSystem.getUpperBounds(typeParameterMarker);
        Iterable<KotlinTypeMarker> iterable = upperBounds;
        boolean z = iterable instanceof Collection;
        if (!z || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!typeSystem.isError((KotlinTypeMarker) it.next())) {
                    if (!z || !((Collection) iterable).isEmpty()) {
                        Iterator it2 = iterable.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (getNullabilityQualifier((KotlinTypeMarker) it2.next()) != null) {
                                    list = upperBounds;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (!z || !((Collection) iterable).isEmpty()) {
                        for (KotlinTypeMarker enhancedForWarnings : iterable) {
                            if (getEnhancedForWarnings(enhancedForWarnings) != null) {
                                Collection arrayList = new ArrayList();
                                for (KotlinTypeMarker enhancedForWarnings2 : iterable) {
                                    KotlinTypeMarker enhancedForWarnings3 = getEnhancedForWarnings(enhancedForWarnings2);
                                    if (enhancedForWarnings3 != null) {
                                        arrayList.add(enhancedForWarnings3);
                                    }
                                }
                                list = (List) arrayList;
                                Iterable iterable2 = list;
                                if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                                    Iterator it3 = iterable2.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!typeSystem.isNullableType((KotlinTypeMarker) it3.next())) {
                                                nullabilityQualifier = NullabilityQualifier.NOT_NULL;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                nullabilityQualifier = NullabilityQualifier.NULLABLE;
                                return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, list != upperBounds);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
        r8 = r8.getType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> computeIndexedQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r10, java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> r11, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "overrides"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.List r0 = r9.toIndexed(r10)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r11.iterator()
        L_0x001f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            java.util.List r3 = r9.toIndexed(r3)
            r1.add(r3)
            goto L_0x001f
        L_0x0033:
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r9.getForceOnlyHeadTypeConstructor()
            r3 = 1
            if (r2 != 0) goto L_0x006d
            boolean r2 = r9.isCovariant()
            if (r2 == 0) goto L_0x0068
            boolean r2 = r11 instanceof java.util.Collection
            if (r2 == 0) goto L_0x0050
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0050
            goto L_0x0068
        L_0x0050:
            java.util.Iterator r11 = r11.iterator()
        L_0x0054:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x0068
            java.lang.Object r2 = r11.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r2 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r2
            boolean r2 = r9.isEqual(r10, r2)
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x0054
            goto L_0x006d
        L_0x0068:
            int r10 = r0.size()
            goto L_0x006e
        L_0x006d:
            r10 = r3
        L_0x006e:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[r10]
            r2 = 0
            r4 = r2
        L_0x0072:
            if (r4 >= r10) goto L_0x00d5
            java.lang.Object r5 = r0.get(r4)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) r5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = r9.extractQualifiersFromAnnotations(r5)
            r6 = r1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x008c:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00b2
            java.lang.Object r8 = r6.next()
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r8, r4)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$TypeAndDefaultQualifiers r8 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.TypeAndDefaultQualifiers) r8
            if (r8 == 0) goto L_0x00ab
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r8 = r8.getType()
            if (r8 == 0) goto L_0x00ab
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r8 = r9.extractQualifiers(r8)
            goto L_0x00ac
        L_0x00ab:
            r8 = 0
        L_0x00ac:
            if (r8 == 0) goto L_0x008c
            r7.add(r8)
            goto L_0x008c
        L_0x00b2:
            java.util.List r7 = (java.util.List) r7
            java.util.Collection r7 = (java.util.Collection) r7
            if (r4 != 0) goto L_0x00c0
            boolean r6 = r9.isCovariant()
            if (r6 == 0) goto L_0x00c0
            r6 = r3
            goto L_0x00c1
        L_0x00c0:
            r6 = r2
        L_0x00c1:
            if (r4 != 0) goto L_0x00cb
            boolean r8 = r9.getContainerIsVarargParameter()
            if (r8 == 0) goto L_0x00cb
            r8 = r3
            goto L_0x00cc
        L_0x00cb:
            r8 = r2
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.computeQualifiersForOverride(r5, r7, r6, r8, r13)
            r11[r4] = r5
            int r4 = r4 + 1
            goto L_0x0072
        L_0x00d5:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1 r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts$computeIndexedQualifiers$1
            r10.<init>(r12, r11)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts.computeIndexedQualifiers(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, java.lang.Iterable, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo, boolean):kotlin.jvm.functions.Function1");
    }

    private final <T> void flattenTree(T t, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t);
        Iterable<Object> iterable = (Iterable) function1.invoke(t);
        if (iterable != null) {
            for (Object flattenTree : iterable) {
                flattenTree(flattenTree, list, function1);
            }
        }
    }

    private final <T> List<T> flattenTree(T t, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        List<T> arrayList = new ArrayList<>(1);
        flattenTree(t, arrayList, function1);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final JavaTypeQualifiersByElementType extractAndMergeDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType) {
        return getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(javaTypeQualifiersByElementType, getAnnotations(kotlinTypeMarker));
    }

    private final List<TypeAndDefaultQualifiers> toIndexed(KotlinTypeMarker kotlinTypeMarker) {
        return flattenTree(new TypeAndDefaultQualifiers(kotlinTypeMarker, extractAndMergeDefaultQualifiers(kotlinTypeMarker, getContainerDefaultTypeQualifiers()), (TypeParameterMarker) null), new AbstractSignatureParts$toIndexed$1$1(this, getTypeSystem()));
    }

    /* compiled from: AbstractSignatureParts.kt */
    private static final class TypeAndDefaultQualifiers {
        private final JavaTypeQualifiersByElementType defaultQualifiers;
        private final KotlinTypeMarker type;
        private final TypeParameterMarker typeParameterForArgument;

        public TypeAndDefaultQualifiers(KotlinTypeMarker kotlinTypeMarker, JavaTypeQualifiersByElementType javaTypeQualifiersByElementType, TypeParameterMarker typeParameterMarker) {
            this.type = kotlinTypeMarker;
            this.defaultQualifiers = javaTypeQualifiersByElementType;
            this.typeParameterForArgument = typeParameterMarker;
        }

        public final KotlinTypeMarker getType() {
            return this.type;
        }

        public final JavaTypeQualifiersByElementType getDefaultQualifiers() {
            return this.defaultQualifiers;
        }

        public final TypeParameterMarker getTypeParameterForArgument() {
            return this.typeParameterForArgument;
        }
    }
}
