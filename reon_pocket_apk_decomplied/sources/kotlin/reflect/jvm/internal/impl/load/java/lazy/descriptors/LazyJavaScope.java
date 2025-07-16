package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: LazyJavaScope.kt */
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
    private final LazyJavaResolverContext c;
    private final NotNullLazyValue classNamesLazy$delegate;
    /* access modifiers changed from: private */
    public final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    /* access modifiers changed from: private */
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final LazyJavaScope mainScope;
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    private final NotNullLazyValue propertyNamesLazy$delegate;

    /* access modifiers changed from: protected */
    public abstract Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public abstract Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* access modifiers changed from: protected */
    public abstract DeclaredMemberIndex computeMemberIndex();

    /* access modifiers changed from: protected */
    public abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name);

    /* access modifiers changed from: protected */
    public abstract void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection);

    /* access modifiers changed from: protected */
    public abstract Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    /* access modifiers changed from: protected */
    public abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    /* access modifiers changed from: protected */
    public abstract DeclarationDescriptor getOwnerDescriptor();

    /* access modifiers changed from: protected */
    public boolean isVisibleAsFunction(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract MethodSignatureData resolveMethodSignature(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, (i & 2) != 0 ? null : lazyJavaScope);
    }

    /* access modifiers changed from: protected */
    public final LazyJavaResolverContext getC() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    public LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        this.c = lazyJavaResolverContext;
        this.mainScope = lazyJavaScope;
        this.allDescriptors = lazyJavaResolverContext.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), CollectionsKt.emptyList());
        this.declaredMemberIndex = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
        this.declaredFunctions = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
        this.declaredField = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
        this.functions = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new LazyJavaScope$functions$1(this));
        this.functionNamesLazy$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
        this.propertyNamesLazy$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));
        this.classNamesLazy$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
        this.properties = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new LazyJavaScope$properties$1(this));
    }

    /* access modifiers changed from: protected */
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    /* access modifiers changed from: protected */
    public final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    /* access modifiers changed from: private */
    public final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> set) {
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : set) {
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) next, false, false, 2, (Object) null);
            Object obj = linkedHashMap.get(computeJvmDescriptor$default);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(computeJvmDescriptor$default, obj);
            }
            ((List) obj).add(next);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collection = list;
                Collection selectMostSpecificInEachOverridableGroup = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(collection, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
                set.removeAll(collection);
                set.addAll(selectMostSpecificInEachOverridableGroup);
            }
        }
    }

    /* compiled from: LazyJavaScope.kt */
    protected static final class MethodSignatureData {
        private final List<String> errors;
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodSignatureData)) {
                return false;
            }
            MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
            return Intrinsics.areEqual((Object) this.returnType, (Object) methodSignatureData.returnType) && Intrinsics.areEqual((Object) this.receiverType, (Object) methodSignatureData.receiverType) && Intrinsics.areEqual((Object) this.valueParameters, (Object) methodSignatureData.valueParameters) && Intrinsics.areEqual((Object) this.typeParameters, (Object) methodSignatureData.typeParameters) && this.hasStableParameterNames == methodSignatureData.hasStableParameterNames && Intrinsics.areEqual((Object) this.errors, (Object) methodSignatureData.errors);
        }

        public int hashCode() {
            int hashCode = this.returnType.hashCode() * 31;
            KotlinType kotlinType = this.receiverType;
            return ((((((((hashCode + (kotlinType == null ? 0 : kotlinType.hashCode())) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.hasStableParameterNames)) * 31) + this.errors.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ')';
        }

        public MethodSignatureData(KotlinType kotlinType, KotlinType kotlinType2, List<? extends ValueParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, boolean z, List<String> list3) {
            Intrinsics.checkNotNullParameter(kotlinType, "returnType");
            Intrinsics.checkNotNullParameter(list, "valueParameters");
            Intrinsics.checkNotNullParameter(list2, "typeParameters");
            Intrinsics.checkNotNullParameter(list3, "errors");
            this.returnType = kotlinType;
            this.receiverType = kotlinType2;
            this.valueParameters = list;
            this.typeParameters = list2;
            this.hasStableParameterNames = z;
            this.errors = list3;
        }

        public final KotlinType getReturnType() {
            return this.returnType;
        }

        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public final List<String> getErrors() {
            return this.errors;
        }
    }

    /* access modifiers changed from: protected */
    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod javaMethod) {
        Map<K, V> map;
        JavaMethod javaMethod2 = javaMethod;
        Intrinsics.checkNotNullParameter(javaMethod2, FirebaseAnalytics.Param.METHOD);
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.c, javaMethod2), javaMethod.getName(), this.c.getComponents().getSourceElementFactory().source(javaMethod2), ((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).findRecordComponentByName(javaMethod.getName()) != null && javaMethod.getValueParameters().isEmpty());
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(...)");
        LazyJavaResolverContext childForMethod$default = ContextKt.childForMethod$default(this.c, createJavaMethod, javaMethod2, 0, 4, (Object) null);
        Iterable<JavaTypeParameter> typeParameters = javaMethod.getTypeParameters();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter resolveTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter2 = childForMethod$default.getTypeParameterResolver().resolveTypeParameter(resolveTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter2);
            arrayList.add(resolveTypeParameter2);
        }
        ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod$default, createJavaMethod, javaMethod.getValueParameters());
        MethodSignatureData resolveMethodSignature = resolveMethodSignature(javaMethod2, (List) arrayList, computeMethodReturnType(javaMethod2, childForMethod$default), resolveValueParameters.getDescriptors());
        KotlinType receiverType = resolveMethodSignature.getReceiverType();
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable = receiverType != null ? DescriptorFactory.createExtensionReceiverParameterForCallable(createJavaMethod, receiverType, Annotations.Companion.getEMPTY()) : null;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List emptyList = CollectionsKt.emptyList();
        List<TypeParameterDescriptor> typeParameters2 = resolveMethodSignature.getTypeParameters();
        List<ValueParameterDescriptor> valueParameters = resolveMethodSignature.getValueParameters();
        KotlinType returnType = resolveMethodSignature.getReturnType();
        Modality convertFromFlags = Modality.Companion.convertFromFlags(false, javaMethod.isAbstract(), !javaMethod.isFinal());
        DescriptorVisibility descriptorVisibility = UtilsKt.toDescriptorVisibility(javaMethod.getVisibility());
        if (resolveMethodSignature.getReceiverType() != null) {
            map = MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first(resolveValueParameters.getDescriptors())));
        } else {
            map = MapsKt.emptyMap();
        }
        createJavaMethod.initialize(createExtensionReceiverParameterForCallable, dispatchReceiverParameter, emptyList, typeParameters2, valueParameters, returnType, convertFromFlags, descriptorVisibility, map);
        createJavaMethod.setParameterNamesStatus(resolveMethodSignature.getHasStableParameterNames(), resolveValueParameters.getHasSynthesizedNames());
        if (!resolveMethodSignature.getErrors().isEmpty()) {
            childForMethod$default.getComponents().getSignaturePropagator().reportSignatureErrors(createJavaMethod, resolveMethodSignature.getErrors());
        }
        return createJavaMethod;
    }

    /* access modifiers changed from: protected */
    public final KotlinType computeMethodReturnType(JavaMethod javaMethod, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(javaMethod, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        return lazyJavaResolverContext.getTypeResolver().transformJavaType(javaMethod.getReturnType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, javaMethod.getContainingClass().isAnnotationType(), false, (TypeParameterDescriptor) null, 6, (Object) null));
    }

    /* compiled from: LazyJavaScope.kt */
    protected static final class ResolvedValueParameters {
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "descriptors");
            this.descriptors = list;
            this.hasSynthesizedNames = z;
        }

        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    /* JADX WARNING: type inference failed for: r8v8, types: [kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r21, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r22, java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> r23) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "jValueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.lang.Iterable r3 = kotlin.collections.CollectionsKt.withIndex(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
            r5 = 0
        L_0x002e:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0136
            java.lang.Object r6 = r3.next()
            kotlin.collections.IndexedValue r6 = (kotlin.collections.IndexedValue) r6
            int r10 = r6.component1()
            java.lang.Object r6 = r6.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter r6 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) r6
            r7 = r6
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r7 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r7
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11 = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(r0, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeUsage r12 = kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON
            r16 = 7
            r17 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r7 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(r12, r13, r14, r15, r16, r17)
            boolean r8 = r6.isVararg()
            r9 = 0
            r12 = 1
            if (r8 == 0) goto L_0x009a
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r8 = r6.getType()
            boolean r13 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
            if (r13 == 0) goto L_0x006b
            r9 = r8
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) r9
        L_0x006b:
            if (r9 == 0) goto L_0x0086
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r8 = r21.getTypeResolver()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r8.transformArrayType(r9, r7, r12)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r8 = r21.getModule()
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = r8.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getArrayElementType(r7)
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            goto L_0x00aa
        L_0x0086:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Vararg parameter should be an array: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009a:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r8 = r21.getTypeResolver()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r13 = r6.getType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r8.transformJavaType(r13, r7)
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r9)
        L_0x00aa:
            java.lang.Object r8 = r7.component1()
            r13 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r13
            java.lang.Object r7 = r7.component2()
            r17 = r7
            kotlin.reflect.jvm.internal.impl.types.KotlinType r17 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r17
            kotlin.reflect.jvm.internal.impl.name.Name r7 = r22.getName()
            java.lang.String r7 = r7.asString()
            java.lang.String r8 = "equals"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00e8
            int r7 = r23.size()
            if (r7 != r12) goto L_0x00e8
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r7 = r21.getModule()
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r7 = r7.getBuiltIns()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r7 = r7.getNullableAnyType()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r7 == 0) goto L_0x00e8
            java.lang.String r7 = "other"
            kotlin.reflect.jvm.internal.impl.name.Name r7 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r7)
            goto L_0x0108
        L_0x00e8:
            kotlin.reflect.jvm.internal.impl.name.Name r7 = r6.getName()
            if (r7 != 0) goto L_0x00ef
            r5 = r12
        L_0x00ef:
            if (r7 != 0) goto L_0x0108
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "p"
            r7.<init>(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            kotlin.reflect.jvm.internal.impl.name.Name r7 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r7)
            java.lang.String r8 = "identifier(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
        L_0x0108:
            r12 = r7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r15 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r8 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r8
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r7 = r21.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r7 = r7.getSourceElementFactory()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r6 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement) r6
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r6 = r7.source(r6)
            r18 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r18 = (kotlin.reflect.jvm.internal.impl.descriptors.SourceElement) r18
            r9 = 0
            r14 = 0
            r6 = 0
            r16 = 0
            r7 = r15
            r19 = r15
            r15 = r6
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r6 = r19
            r4.add(r6)
            goto L_0x002e
        L_0x0136:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r0 = kotlin.collections.CollectionsKt.toList(r4)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters
            r1.<init>(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.util.List):kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters");
    }

    static {
        Class<LazyJavaScope> cls = LazyJavaScope.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set) StorageKt.getValue(this.propertyNamesLazy$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final Set<Name> getClassNamesLazy() {
        return (Set) StorageKt.getValue(this.classNamesLazy$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        if (!getFunctionNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.functions.invoke(name);
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor resolveProperty(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField r10) {
        /*
            r9 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r1 = r9.createPropertyDescriptor(r10)
            r0.element = r1
            T r1 = r0.element
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r1 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) r1
            r2 = 0
            r1.initialize(r2, r2, r2, r2)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r9.getPropertyType(r10)
            T r1 = r0.element
            r3 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r3 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) r3
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r6 = r9.getDispatchReceiverParameter()
            r7 = 0
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            r3.setType(r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r9.getOwnerDescriptor()
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x0037
            r2 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
        L_0x0037:
            if (r2 == 0) goto L_0x004d
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r9.c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r3 = r1.getComponents()
            kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider r3 = r3.getSyntheticPartsProvider()
            T r4 = r0.element
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r4 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) r4
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r1 = r3.modifyField(r1, r2, r4)
            r0.element = r1
        L_0x004d:
            T r1 = r0.element
            kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor) r1
            T r2 = r0.element
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r2 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.shouldRecordInitializerForProperty(r1, r2)
            if (r1 == 0) goto L_0x006d
            T r1 = r0.element
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r1 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) r1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$2 r2 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$2
            r2.<init>(r9, r10, r0)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r1.setCompileTimeInitializerFactory(r2)
        L_0x006d:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r9.c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r1 = r1.getJavaResolverCache()
            T r2 = r0.element
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r2
            r1.recordField(r10, r2)
            T r10 = r0.element
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.resolveProperty(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField):kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor");
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField javaField) {
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.c, javaField), Modality.FINAL, UtilsKt.toDescriptorVisibility(javaField.getVisibility()), !javaField.isFinal(), javaField.getName(), this.c.getComponents().getSourceElementFactory().source(javaField), isFinalStatic(javaField));
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    private final boolean isFinalStatic(JavaField javaField) {
        return javaField.isFinal() && javaField.isStatic();
    }

    private final KotlinType getPropertyType(JavaField javaField) {
        KotlinType transformJavaType = this.c.getTypeResolver().transformJavaType(javaField.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, (TypeParameterDescriptor) null, 7, (Object) null));
        if ((!KotlinBuiltIns.isPrimitiveType(transformJavaType) && !KotlinBuiltIns.isString(transformJavaType)) || !isFinalStatic(javaField) || !javaField.getHasConstantNotNullInitializer()) {
            return transformJavaType;
        }
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(transformJavaType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(...)");
        return makeNotNullable;
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        if (!getVariableNames().contains(name)) {
            return CollectionsKt.emptyList();
        }
        return this.properties.invoke(name);
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.allDescriptors.invoke();
    }

    /* access modifiers changed from: protected */
    public final List<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name next : computeClassNames(descriptorKindFilter, function1)) {
                if (function1.invoke(next).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(linkedHashSet, getContributedClassifier(next, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name next2 : computeFunctionNames(descriptorKindFilter, function1)) {
                if (function1.invoke(next2).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(next2, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name next3 : computePropertyNames(descriptorKindFilter, function1)) {
                if (function1.invoke(next3).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(next3, noLookupLocation));
                }
            }
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }
}
