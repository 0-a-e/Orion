package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver {
    private final LazyJavaResolverContext c;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterResolver typeParameterResolver;
    /* access modifiers changed from: private */
    public final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public JavaTypeResolver(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver2) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(typeParameterResolver2, "typeParameterResolver");
        this.c = lazyJavaResolverContext;
        this.typeParameterResolver = typeParameterResolver2;
        RawProjectionComputer rawProjectionComputer = new RawProjectionComputer();
        this.projectionComputer = rawProjectionComputer;
        this.typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(rawProjectionComputer, (TypeParameterErasureOptions) null, 2, (DefaultConstructorMarker) null);
    }

    public final KotlinType transformJavaType(JavaType javaType, JavaTypeAttributes javaTypeAttributes) {
        KotlinType transformJavaType;
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                simpleType = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                simpleType = this.c.getModule().getBuiltIns().getUnitType();
            }
            Intrinsics.checkNotNull(simpleType);
            return simpleType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, javaTypeAttributes);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, javaTypeAttributes, false, 4, (Object) null);
            } else if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                if (bound != null && (transformJavaType = transformJavaType(bound, javaTypeAttributes)) != null) {
                    return transformJavaType;
                }
                SimpleType defaultBound = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound, "getDefaultBound(...)");
                return defaultBound;
            } else if (javaType == null) {
                SimpleType defaultBound2 = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound2, "getDefaultBound(...)");
                return defaultBound2;
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + javaType);
            }
        }
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    public final KotlinType transformArrayType(JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z) {
        Intrinsics.checkNotNullParameter(javaArrayType, "arrayType");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        JavaType componentType = javaArrayType.getComponentType();
        PrimitiveType primitiveType = null;
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        if (javaPrimitiveType != null) {
            primitiveType = javaPrimitiveType.getType();
        }
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.c, javaArrayType, true);
        if (primitiveType != null) {
            SimpleType primitiveArrayKotlinType = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
            Intrinsics.checkNotNull(primitiveArrayKotlinType);
            KotlinType replaceAnnotations = TypeUtilsKt.replaceAnnotations(primitiveArrayKotlinType, new CompositeAnnotations(primitiveArrayKotlinType.getAnnotations(), lazyJavaAnnotations));
            Intrinsics.checkNotNull(replaceAnnotations, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            SimpleType simpleType = (SimpleType) replaceAnnotations;
            if (javaTypeAttributes.isForAnnotationParameter()) {
                return simpleType;
            }
            return KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, javaTypeAttributes.isForAnnotationParameter(), false, (TypeParameterDescriptor) null, 6, (Object) null));
        if (javaTypeAttributes.isForAnnotationParameter()) {
            SimpleType arrayType = this.c.getModule().getBuiltIns().getArrayType(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, transformJavaType, lazyJavaAnnotations);
            Intrinsics.checkNotNullExpressionValue(arrayType, "getArrayType(...)");
            return arrayType;
        }
        Annotations annotations = lazyJavaAnnotations;
        SimpleType arrayType2 = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType, annotations);
        Intrinsics.checkNotNullExpressionValue(arrayType2, "getArrayType(...)");
        return KotlinTypeFactory.flexibleType(arrayType2, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType, annotations).makeNullableAsSpecified(true));
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, javaClassifierType.getPresentableText());
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z = !javaTypeAttributes.isForAnnotationParameter() && javaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE;
        boolean isRaw = javaClassifierType.isRaw();
        if (isRaw || z) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), (SimpleType) null);
            if (computeSimpleJavaClassifierType == null) {
                return transformJavaClassifierType$errorType(javaClassifierType);
            }
            SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType);
            if (computeSimpleJavaClassifierType2 == null) {
                return transformJavaClassifierType$errorType(javaClassifierType);
            }
            if (isRaw) {
                return new RawTypeImpl(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
            }
            return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
        }
        SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, (SimpleType) null);
        return computeSimpleJavaClassifierType3 != null ? computeSimpleJavaClassifierType3 : transformJavaClassifierType$errorType(javaClassifierType);
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        TypeAttributes typeAttributes;
        if (simpleType == null || (typeAttributes = simpleType.getAttributes()) == null) {
            typeAttributes = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, javaClassifierType, false, 4, (DefaultConstructorMarker) null));
        }
        TypeAttributes typeAttributes2 = typeAttributes;
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        TypeConstructor typeConstructor = null;
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (simpleType != null) {
            typeConstructor = simpleType.getConstructor();
        }
        if (!Intrinsics.areEqual((Object) typeConstructor, (Object) computeTypeConstructor) || javaClassifierType.isRaw() || !isNullable) {
            return KotlinTypeFactory.simpleType$default(typeAttributes2, computeTypeConstructor, (List) computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor), isNullable, (KotlinTypeRefiner) null, 16, (Object) null);
        }
        return simpleType.makeNullableAsSpecified(true);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            FqName fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
                if (mapKotlinClass == null) {
                    mapKotlinClass = this.c.getComponents().getModuleClassResolver().resolveClass(javaClass);
                }
                if (mapKotlinClass == null || (typeConstructor = mapKotlinClass.getTypeConstructor()) == null) {
                    return createNotFoundClass(javaClassifierType);
                }
                return typeConstructor;
            }
            throw new AssertionError("Class type should have a FQ name: " + classifier);
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter != null) {
                return resolveTypeParameter.getTypeConstructor();
            }
            return null;
        } else {
            throw new IllegalStateException("Unknown classifier kind: " + classifier);
        }
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(...)");
        TypeConstructor typeConstructor = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return typeConstructor;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && Intrinsics.areEqual((Object) fqName, (Object) JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME)) {
            return this.c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.c.getModule().getBuiltIns(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            return null;
        }
        return (!javaToKotlinClassMapper.isReadOnly(mapJavaToKotlin$default) || !(javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) ? mapJavaToKotlin$default : javaToKotlinClassMapper.convertReadOnlyToMutable(mapJavaToKotlin$default);
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Variance variance;
        if (!JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull(javaClassifierType.getTypeArguments()))) {
            return false;
        }
        List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull(parameters);
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null || variance == Variance.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    private final List<TypeProjection> computeRawTypeArguments(JavaClassifierType javaClassifierType, List<? extends TypeParameterDescriptor> list, TypeConstructor typeConstructor, JavaTypeAttributes javaTypeAttributes) {
        TypeProjection typeProjection;
        Iterable<TypeParameterDescriptor> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, (TypeConstructor) null, javaTypeAttributes.getVisitedTypeParameters())) {
                typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            } else {
                typeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor, javaTypeAttributes.markIsRaw(javaClassifierType.isRaw()), this.typeParameterUpperBoundEraser, new LazyWrappedType(this.c.getStorageManager(), new JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(this, typeParameterDescriptor, javaTypeAttributes, typeConstructor, javaClassifierType)));
            }
            arrayList.add(typeProjection);
        }
        return (List) arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if ((!r0.isEmpty()) != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r9, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r10, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r11) {
        /*
            r8 = this;
            boolean r0 = r9.isRaw()
            java.lang.String r1 = "getParameters(...)"
            r2 = 1
            if (r0 != 0) goto L_0x0025
            java.util.List r0 = r9.getTypeArguments()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0024
            java.util.List r0 = r11.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            java.util.List r0 = r11.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r2 == 0) goto L_0x0033
            java.util.List r9 = r8.computeRawTypeArguments(r9, r0, r11, r10)
            return r9
        L_0x0033:
            int r10 = r0.size()
            java.util.List r11 = r9.getTypeArguments()
            int r11 = r11.size()
            r1 = 10
            if (r10 == r11) goto L_0x008b
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r1)
            r9.<init>(r10)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r10 = r0.iterator()
        L_0x0054:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0082
            java.lang.Object r11 = r10.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r11 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r11
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER
            kotlin.reflect.jvm.internal.impl.name.Name r11 = r11.getName()
            java.lang.String r11 = r11.asString()
            java.lang.String r2 = "asString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            java.lang.String[] r11 = new java.lang.String[]{r11}
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r11 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(r1, r11)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11
            r0.<init>(r11)
            r9.add(r0)
            goto L_0x0054
        L_0x0082:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.List r9 = kotlin.collections.CollectionsKt.toList(r9)
            return r9
        L_0x008b:
            java.util.List r9 = r9.getTypeArguments()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Iterable r9 = kotlin.collections.CollectionsKt.withIndex(r9)
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r1)
            r10.<init>(r11)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x00a4:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00d9
            java.lang.Object r11 = r9.next()
            kotlin.collections.IndexedValue r11 = (kotlin.collections.IndexedValue) r11
            int r1 = r11.component1()
            java.lang.Object r11 = r11.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r11
            r0.size()
            java.lang.Object r1 = r0.get(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r1
            kotlin.reflect.jvm.internal.impl.types.TypeUsage r2 = kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON
            r6 = 7
            r7 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r2 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r11 = r8.transformToTypeProjection(r11, r2, r1)
            r10.add(r11)
            goto L_0x00a4
        L_0x00d9:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.List r9 = kotlin.collections.CollectionsKt.toList(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        TypeProjection typeProjection;
        if (!(javaType instanceof JavaWildcardType)) {
            return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
        }
        JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
        JavaType bound = javaWildcardType.getBound();
        Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        if (bound == null || isConflictingArgumentFor(variance, typeParameterDescriptor)) {
            typeProjection = TypeUtils.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        } else {
            AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard = UtilsKt.extractNullabilityAnnotationOnBoundedWildcard(this.c, javaWildcardType);
            KotlinType transformJavaType = transformJavaType(bound, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, (TypeParameterDescriptor) null, 7, (Object) null));
            if (extractNullabilityAnnotationOnBoundedWildcard != null) {
                transformJavaType = TypeUtilsKt.replaceAnnotations(transformJavaType, Annotations.Companion.create(CollectionsKt.plus(transformJavaType.getAnnotations(), extractNullabilityAnnotationOnBoundedWildcard)));
            }
            typeProjection = TypeUtilsKt.createProjection(transformJavaType, variance, typeParameterDescriptor);
        }
        Intrinsics.checkNotNull(typeProjection);
        return typeProjection;
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) {
            return false;
        }
        return true;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        if (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }
}
