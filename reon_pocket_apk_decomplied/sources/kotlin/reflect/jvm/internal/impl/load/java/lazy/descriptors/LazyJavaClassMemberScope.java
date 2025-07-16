package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    /* access modifiers changed from: private */
    public final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    /* access modifiers changed from: private */
    public final NotNullLazyValue<Set<Name>> generatedNestedClassNames;
    /* access modifiers changed from: private */
    public final JavaClass jClass;
    /* access modifiers changed from: private */
    public final NotNullLazyValue<Set<Name>> nestedClassIndex;
    private final MemoizedFunctionToNullable<Name, ClassDescriptor> nestedClasses;
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, classDescriptor, javaClass, z, (i & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    /* access modifiers changed from: protected */
    public ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(lazyJavaResolverContext, lazyJavaClassMemberScope);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        this.ownerDescriptor = classDescriptor;
        this.jClass = javaClass;
        this.skipRefinement = z;
        this.constructors = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$constructors$1(this, lazyJavaResolverContext));
        this.nestedClassIndex = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.generatedNestedClassNames = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$generatedNestedClassNames$1(lazyJavaResolverContext, this));
        this.enumEntryIndex = lazyJavaResolverContext.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.nestedClasses = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$nestedClasses$1(this, lazyJavaResolverContext));
    }

    /* access modifiers changed from: protected */
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaClassMemberScope$computeMemberIndex$1.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public LinkedHashSet<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
        Collection linkedHashSet = new LinkedHashSet();
        for (KotlinType memberScope : supertypes) {
            CollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getFunctionNames());
        }
        LinkedHashSet<Name> linkedHashSet2 = (LinkedHashSet) linkedHashSet;
        linkedHashSet2.addAll(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getMethodNames());
        linkedHashSet2.addAll(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getRecordComponentNames());
        linkedHashSet2.addAll(computeClassNames(descriptorKindFilter, function1));
        linkedHashSet2.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(getC(), getOwnerDescriptor()));
        return linkedHashSet2;
    }

    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor ownerDescriptor2 = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor2, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(...)");
        List<ValueParameterDescriptor> createRecordConstructorParameters = createRecordConstructorParameters(createJavaConstructor);
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(createRecordConstructorParameters, getConstructorVisibility(ownerDescriptor2));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setReturnType(ownerDescriptor2.getDefaultType());
        return createJavaConstructor;
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        Collection<JavaRecordComponent> recordComponents = this.jClass.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, (TypeParameterDescriptor) null, 6, (Object) null);
        Iterator<JavaRecordComponent> it = recordComponents.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return arrayList;
            }
            i = i2 + 1;
            JavaRecordComponent next = it.next();
            KotlinType transformJavaType = getC().getTypeResolver().transformJavaType(next.getType(), attributes$default);
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = r5;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl2 = new ValueParameterDescriptorImpl(classConstructorDescriptorImpl, (ValueParameterDescriptor) null, i2, Annotations.Companion.getEMPTY(), next.getName(), transformJavaType, false, false, false, next.isVararg() ? getC().getComponents().getModule().getBuiltIns().getArrayElementType(transformJavaType) : null, getC().getComponents().getSourceElementFactory().source(next));
            arrayList.add(valueParameterDescriptorImpl);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isVisibleAsFunction(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.jClass.isAnnotationType()) {
            return false;
        }
        return isVisibleAsFunctionInCurrentClass(javaMethodDescriptor);
    }

    private final boolean isVisibleAsFunctionInCurrentClass(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterable<Name> propertyNamesCandidatesByAccessorName = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(name);
        if (!(propertyNamesCandidatesByAccessorName instanceof Collection) || !((Collection) propertyNamesCandidatesByAccessorName).isEmpty()) {
            for (Name propertiesFromSupertypes : propertyNamesCandidatesByAccessorName) {
                Iterable<PropertyDescriptor> propertiesFromSupertypes2 = getPropertiesFromSupertypes(propertiesFromSupertypes);
                if (!(propertiesFromSupertypes2 instanceof Collection) || !((Collection) propertiesFromSupertypes2).isEmpty()) {
                    for (PropertyDescriptor propertyDescriptor : propertiesFromSupertypes2) {
                        if (doesClassOverridesProperty(propertyDescriptor, new LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(simpleFunctionDescriptor, this))) {
                            if (!propertyDescriptor.isVar()) {
                                String asString = simpleFunctionDescriptor.getName().asString();
                                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                                if (!JvmAbi.isSetterName(asString)) {
                                }
                            }
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        if (doesOverrideRenamedBuiltins(simpleFunctionDescriptor) || shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(simpleFunctionDescriptor) || doesOverrideSuspendFunction(simpleFunctionDescriptor)) {
            return false;
        }
        return true;
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return false;
        }
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        Collection arrayList = new ArrayList();
        for (SimpleFunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava : getFunctionsFromSupertypes(name2)) {
            FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava2 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(overriddenBuiltinFunctionWithErasedValueParametersInJava);
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava2 != null) {
                arrayList.add(overriddenBuiltinFunctionWithErasedValueParametersInJava2);
            }
        }
        Iterable<FunctionDescriptor> iterable = (List) arrayList;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (FunctionDescriptor hasSameJvmDescriptorButDoesNotOverride : iterable) {
            if (hasSameJvmDescriptorButDoesNotOverride(simpleFunctionDescriptor, hasSameJvmDescriptorButDoesNotOverride)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name name) {
        Iterable<JavaMethod> findMethodsByName = ((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).findMethodsByName(name);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(findMethodsByName, 10));
        for (JavaMethod resolveMethodToFunctionDescriptor : findMethodsByName) {
            arrayList.add(resolveMethodToFunctionDescriptor(resolveMethodToFunctionDescriptor));
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name name) {
        Collection arrayList = new ArrayList();
        for (Object next : getFunctionsFromSupertypes(name)) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) next;
            if (!SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(simpleFunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) == null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Name builtinFunctionNamesByJvmName = companion.getBuiltinFunctionNamesByJvmName(name);
        if (builtinFunctionNamesByJvmName == null) {
            return false;
        }
        Collection arrayList = new ArrayList();
        for (Object next : getFunctionsFromSupertypes(builtinFunctionNamesByJvmName)) {
            if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) next)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (list.isEmpty()) {
            return false;
        }
        SimpleFunctionDescriptor createRenamedCopy = createRenamedCopy(simpleFunctionDescriptor, builtinFunctionNamesByJvmName);
        Iterable<SimpleFunctionDescriptor> iterable = list;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (SimpleFunctionDescriptor doesOverrideRenamedDescriptor : iterable) {
            if (doesOverrideRenamedDescriptor(doesOverrideRenamedDescriptor, createRenamedCopy)) {
                return true;
            }
        }
        return false;
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        SimpleFunctionDescriptor createSuspendView = createSuspendView(simpleFunctionDescriptor);
        if (createSuspendView == null) {
            return false;
        }
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterable<SimpleFunctionDescriptor> functionsFromSupertypes = getFunctionsFromSupertypes(name);
        if ((functionsFromSupertypes instanceof Collection) && ((Collection) functionsFromSupertypes).isEmpty()) {
            return false;
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : functionsFromSupertypes) {
            if (simpleFunctionDescriptor2.isSuspend() && doesOverride(createSuspendView, simpleFunctionDescriptor2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor createSuspendView(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = 0
            if (r0 == 0) goto L_0x0080
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.getDeclarationDescriptor()
            if (r3 == 0) goto L_0x0037
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r3)
            if (r3 == 0) goto L_0x0037
            boolean r4 = r3.isSafe()
            if (r4 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r3 = r2
        L_0x0030:
            if (r3 == 0) goto L_0x0037
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = r3.toSafe()
            goto L_0x0038
        L_0x0037:
            r3 = r2
        L_0x0038:
            kotlin.reflect.jvm.internal.impl.name.FqName r4 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.CONTINUATION_INTERFACE_FQ_NAME
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r0 = r2
        L_0x0042:
            if (r0 != 0) goto L_0x0045
            goto L_0x0080
        L_0x0045:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r2 = r6.newCopyBuilder()
            java.util.List r6 = r6.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r1 = 1
            java.util.List r6 = kotlin.collections.CollectionsKt.dropLast(r6, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r2.setValueParameters(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            java.util.List r0 = r0.getArguments()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r6.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            r0 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl r0 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl) r0
            if (r0 != 0) goto L_0x007c
            goto L_0x007f
        L_0x007c:
            r0.setSuspend(r1)
        L_0x007f:
            return r6
        L_0x0080:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.createSuspendView(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor");
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor simpleFunctionDescriptor, Name name) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setName(name);
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        Object build = newCopyBuilder.build();
        Intrinsics.checkNotNull(build);
        return (SimpleFunctionDescriptor) build;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics.checkNotNull(functionDescriptor);
        return doesOverride(functionDescriptor, simpleFunctionDescriptor);
    }

    private final boolean doesOverride(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
        if (result != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE || JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor)) {
            return false;
        }
        return true;
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        String str = null;
        PropertyGetterDescriptor propertyGetterDescriptor = getter != null ? (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter) : null;
        if (propertyGetterDescriptor != null) {
            str = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor);
        }
        if (str != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), propertyGetterDescriptor)) {
            return findGetterByName(propertyDescriptor, str, function1);
        }
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return findGetterByName(propertyDescriptor, JvmAbi.getterName(asString), function1);
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        Name identifier = Name.identifier(JvmAbi.setterName(asString));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) CollectionsKt.single(valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        SimpleFunctionDescriptor findSetterOverride = findSetterOverride(propertyDescriptor, function1);
        if (findGetterOverride == null) {
            return false;
        }
        if (!propertyDescriptor.isVar()) {
            return true;
        }
        if (findSetterOverride == null || findSetterOverride.getModality() != findGetterOverride.getModality()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeNonDeclaredFunctions(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r10, kotlin.reflect.jvm.internal.impl.name.Name r11) {
        /*
            r9 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.Set r6 = r9.getFunctionsFromSupertypes(r11)
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$Companion r0 = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion
            boolean r0 = r0.getSameAsRenamedInJvmBuiltin(r11)
            if (r0 != 0) goto L_0x0071
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            boolean r0 = r0.getSameAsBuiltinMethodWithErasedValueParameters(r11)
            if (r0 != 0) goto L_0x0071
            r0 = r6
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x002f
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            java.util.Iterator r1 = r0.iterator()
        L_0x0033:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            boolean r2 = r2.isSuspend()
            if (r2 == 0) goto L_0x0033
            goto L_0x0071
        L_0x0046:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0051:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0068
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            boolean r3 = r9.isVisibleAsFunctionInCurrentClass(r3)
            if (r3 == 0) goto L_0x0051
            r1.add(r2)
            goto L_0x0051
        L_0x0068:
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            r0 = 0
            r9.addFunctionFromSupertypes(r10, r11, r1, r0)
            return
        L_0x0071:
            kotlin.reflect.jvm.internal.impl.utils.SmartSet$Companion r0 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion
            kotlin.reflect.jvm.internal.impl.utils.SmartSet r7 = r0.create()
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = r9.getOwnerDescriptor()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter.DO_NOTHING
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r9.getC()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r0.getComponents()
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r0 = r0.getKotlinTypeChecker()
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil r5 = r0.getOverridingUtil()
            r0 = r11
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r0, r1, r2, r3, r4, r5)
            java.lang.String r0 = "resolveOverridesForNonStaticMembers(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$3 r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$3
            r0.<init>(r9)
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r0 = r9
            r1 = r11
            r2 = r10
            r3 = r8
            r4 = r10
            r0.addOverriddenSpecialMethods(r1, r2, r3, r4, r5)
            r4 = r7
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$4 r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$4
            r0.<init>(r9)
            r5 = r0
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r0 = r9
            r0.addOverriddenSpecialMethods(r1, r2, r3, r4, r5)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r6.iterator()
        L_0x00cd:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00e4
            java.lang.Object r2 = r1.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            boolean r3 = r9.isVisibleAsFunctionInCurrentClass(r3)
            if (r3 == 0) goto L_0x00cd
            r0.add(r2)
            goto L_0x00cd
        L_0x00e4:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r0 = kotlin.collections.CollectionsKt.plus(r0, r7)
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 1
            r9.addFunctionFromSupertypes(r10, r11, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeNonDeclaredFunctions(java.util.Collection, kotlin.reflect.jvm.internal.impl.name.Name):void");
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z) {
        Collection<D> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
        if (!z) {
            collection.addAll(resolveOverridesForNonStaticMembers);
            return;
        }
        Iterable<SimpleFunctionDescriptor> iterable = resolveOverridesForNonStaticMembers;
        List<T> plus = CollectionsKt.plus(collection, iterable);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : iterable) {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(simpleFunctionDescriptor);
            if (simpleFunctionDescriptor2 == null) {
                Intrinsics.checkNotNull(simpleFunctionDescriptor);
            } else {
                Intrinsics.checkNotNull(simpleFunctionDescriptor);
                simpleFunctionDescriptor = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(simpleFunctionDescriptor, simpleFunctionDescriptor2, plus);
            }
            arrayList.add(simpleFunctionDescriptor);
        }
        collection.addAll((List) arrayList);
    }

    private final void addOverriddenSpecialMethods(Name name, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltinWithDifferentJvmName(simpleFunctionDescriptor, function1, name, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForBuiltInWithErasedValueParametersInJava(simpleFunctionDescriptor, function1, collection));
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, obtainOverrideForSuspend(simpleFunctionDescriptor, function1));
        }
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded;
        FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor);
        if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null || (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(overriddenBuiltinFunctionWithErasedValueParametersInJava, function1)) == null) {
            return null;
        }
        if (!isVisibleAsFunctionInCurrentClass(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded)) {
            createOverrideForBuiltinFunctionWithErasedParameterIfNeeded = null;
        }
        if (createOverrideForBuiltinFunctionWithErasedParameterIfNeeded != null) {
            return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createOverrideForBuiltinFunctionWithErasedParameterIfNeeded, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Name name, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor);
        if (simpleFunctionDescriptor2 == null) {
            return null;
        }
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(simpleFunctionDescriptor2);
        Intrinsics.checkNotNull(jvmMethodNameIfSpecial);
        Name identifier = Name.identifier(jvmMethodNameIfSpecial);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        for (SimpleFunctionDescriptor createRenamedCopy : (Collection) function1.invoke(identifier)) {
            SimpleFunctionDescriptor createRenamedCopy2 = createRenamedCopy(createRenamedCopy, name);
            if (doesOverrideRenamedDescriptor(simpleFunctionDescriptor2, createRenamedCopy2)) {
                return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(createRenamedCopy2, simpleFunctionDescriptor2, collection);
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (!simpleFunctionDescriptor.isSuspend()) {
            return null;
        }
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        for (SimpleFunctionDescriptor createSuspendView : (Iterable) function1.invoke(name)) {
            SimpleFunctionDescriptor createSuspendView2 = createSuspendView(createSuspendView);
            if (createSuspendView2 == null || !doesOverride(createSuspendView2, simpleFunctionDescriptor)) {
                createSuspendView2 = null;
                continue;
            }
            if (createSuspendView2 != null) {
                return createSuspendView2;
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        Iterable<SimpleFunctionDescriptor> iterable = collection;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return simpleFunctionDescriptor;
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : iterable) {
            if (!Intrinsics.areEqual((Object) simpleFunctionDescriptor, (Object) simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && doesOverride(simpleFunctionDescriptor2, callableDescriptor)) {
                Object build = simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
                Intrinsics.checkNotNull(build);
                return (SimpleFunctionDescriptor) build;
            }
        }
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor functionDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Object obj;
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Iterator it = ((Iterable) function1.invoke(name)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor) obj, functionDescriptor)) {
                break;
            }
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        Iterable<ValueParameterDescriptor> iterable = valueParameters;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ValueParameterDescriptor type : iterable) {
            arrayList.add(type.getType());
        }
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        newCopyBuilder.setValueParameters(UtilKt.copyValueParameters((List) arrayList, valueParameters2, functionDescriptor));
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        newCopyBuilder.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, true);
        return (SimpleFunctionDescriptor) newCopyBuilder.build();
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name name) {
        Collection linkedHashSet = new LinkedHashSet();
        for (KotlinType memberScope : computeSupertypes()) {
            CollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return (Set) linkedHashSet;
    }

    /* access modifiers changed from: protected */
    public void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.jClass.isRecord() && ((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).findRecordComponentByName(name) != null) {
            Iterable iterable = collection;
            if (!((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            JavaRecordComponent findRecordComponentByName = ((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).findRecordComponentByName(name);
            Intrinsics.checkNotNull(findRecordComponentByName);
            collection.add(resolveRecordComponentToFunctionDescriptor(findRecordComponentByName));
        }
        getC().getComponents().getSyntheticPartsProvider().generateMethods(getC(), getOwnerDescriptor(), name, collection);
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent javaRecordComponent) {
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaRecordComponent), javaRecordComponent.getName(), getC().getComponents().getSourceElementFactory().source(javaRecordComponent), true);
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(...)");
        JavaMethodDescriptor javaMethodDescriptor = createJavaMethod;
        javaMethodDescriptor.initialize((ReceiverParameterDescriptor) null, getDispatchReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), getC().getTypeResolver().transformJavaType(javaRecordComponent.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, (TypeParameterDescriptor) null, 6, (Object) null)), Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, (Map<? extends CallableDescriptor.UserDataKey<?>, ?>) null);
        createJavaMethod.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(javaRecordComponent, createJavaMethod);
        return createJavaMethod;
    }

    /* access modifiers changed from: protected */
    public void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        if (this.jClass.isAnnotationType()) {
            computeAnnotationProperties(name, collection);
        }
        Set<PropertyDescriptor> propertiesFromSupertypes = getPropertiesFromSupertypes(name);
        if (!propertiesFromSupertypes.isEmpty()) {
            SmartSet create = SmartSet.Companion.create();
            SmartSet create2 = SmartSet.Companion.create();
            addPropertyOverrideByMethod(propertiesFromSupertypes, collection, create, new LazyJavaClassMemberScope$computeNonDeclaredProperties$1(this));
            addPropertyOverrideByMethod(SetsKt.minus(propertiesFromSupertypes, create), create2, (Set<PropertyDescriptor>) null, new LazyJavaClassMemberScope$computeNonDeclaredProperties$2(this));
            Collection<D> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, SetsKt.plus(propertiesFromSupertypes, create2), collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(...)");
            collection.addAll(resolveOverridesForNonStaticMembers);
        }
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (PropertyDescriptor propertyDescriptor : set) {
            JavaPropertyDescriptor createPropertyDescriptorByMethods = createPropertyDescriptorByMethods(propertyDescriptor, function1);
            if (createPropertyDescriptorByMethods != null) {
                collection.add(createPropertyDescriptorByMethods);
                if (set2 != null) {
                    set2.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    private final void computeAnnotationProperties(Name name, Collection<PropertyDescriptor> collection) {
        JavaMethod javaMethod = (JavaMethod) CollectionsKt.singleOrNull(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).findMethodsByName(name));
        if (javaMethod != null) {
            collection.add(createPropertyDescriptorWithDefaultGetter$default(this, javaMethod, (KotlinType) null, Modality.FINAL, 2, (Object) null));
        }
    }

    static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, KotlinType kotlinType, Modality modality, int i, Object obj) {
        if ((i & 2) != 0) {
            kotlinType = null;
        }
        return lazyJavaClassMemberScope.createPropertyDescriptorWithDefaultGetter(javaMethod, kotlinType, modality);
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod javaMethod, KotlinType kotlinType, Modality modality) {
        KotlinType kotlinType2;
        JavaMethod javaMethod2 = javaMethod;
        JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaMethod2), modality, UtilsKt.toDescriptorVisibility(javaMethod.getVisibility()), false, javaMethod.getName(), getC().getComponents().getSourceElementFactory().source(javaMethod2), false);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        PropertyGetterDescriptorImpl createDefaultGetter = DescriptorFactory.createDefaultGetter(create, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(createDefaultGetter, "createDefaultGetter(...)");
        create.initialize(createDefaultGetter, (PropertySetterDescriptor) null);
        if (kotlinType == null) {
            kotlinType2 = computeMethodReturnType(javaMethod2, ContextKt.childForMethod$default(getC(), create, javaMethod2, 0, 4, (Object) null));
        } else {
            kotlinType2 = kotlinType;
        }
        create.setType(kotlinType2, CollectionsKt.emptyList(), getDispatchReceiverParameter(), (ReceiverParameterDescriptor) null, CollectionsKt.emptyList());
        createDefaultGetter.initialize(kotlinType2);
        return create;
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = null;
        if (!doesClassOverridesProperty(propertyDescriptor, function1)) {
            return null;
        }
        SimpleFunctionDescriptor findGetterOverride = findGetterOverride(propertyDescriptor, function1);
        Intrinsics.checkNotNull(findGetterOverride);
        if (propertyDescriptor.isVar()) {
            simpleFunctionDescriptor = findSetterOverride(propertyDescriptor, function1);
            Intrinsics.checkNotNull(simpleFunctionDescriptor);
        } else {
            simpleFunctionDescriptor = null;
        }
        if (simpleFunctionDescriptor != null) {
            simpleFunctionDescriptor.getModality();
            findGetterOverride.getModality();
        }
        JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), findGetterOverride, simpleFunctionDescriptor, propertyDescriptor);
        KotlinType returnType = findGetterOverride.getReturnType();
        Intrinsics.checkNotNull(returnType);
        javaForKotlinOverridePropertyDescriptor.setType(returnType, CollectionsKt.emptyList(), getDispatchReceiverParameter(), (ReceiverParameterDescriptor) null, CollectionsKt.emptyList());
        PropertyDescriptor propertyDescriptor2 = javaForKotlinOverridePropertyDescriptor;
        PropertyGetterDescriptorImpl createGetter = DescriptorFactory.createGetter(propertyDescriptor2, findGetterOverride.getAnnotations(), false, false, false, findGetterOverride.getSource());
        createGetter.setInitialSignatureDescriptor(findGetterOverride);
        createGetter.initialize(javaForKotlinOverridePropertyDescriptor.getType());
        Intrinsics.checkNotNullExpressionValue(createGetter, "apply(...)");
        if (simpleFunctionDescriptor != null) {
            List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt.firstOrNull(valueParameters);
            if (valueParameterDescriptor != null) {
                propertySetterDescriptorImpl = DescriptorFactory.createSetter(propertyDescriptor2, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(simpleFunctionDescriptor);
            } else {
                throw new AssertionError("No parameter found for " + simpleFunctionDescriptor);
            }
        }
        javaForKotlinOverridePropertyDescriptor.initialize(createGetter, propertySetterDescriptorImpl);
        return javaForKotlinOverridePropertyDescriptor;
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name name) {
        Collection arrayList = new ArrayList();
        for (KotlinType memberScope : computeSupertypes()) {
            Iterable<PropertyDescriptor> contributedVariables = memberScope.getMemberScope().getContributedVariables(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(contributedVariables, 10));
            for (PropertyDescriptor add : contributedVariables) {
                arrayList2.add(add);
            }
            CollectionsKt.addAll(arrayList, (List) arrayList2);
        }
        return CollectionsKt.toSet((List) arrayList);
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (!this.skipRefinement) {
            return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
        }
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
        return supertypes;
    }

    /* access modifiers changed from: protected */
    public LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.checkNotNullParameter(javaMethod, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics.checkNotNullParameter(list2, "valueParameters");
        SignaturePropagator.PropagatedSignature resolvePropagatedSignature = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(javaMethod, getOwnerDescriptor(), kotlinType, (KotlinType) null, list2, list);
        Intrinsics.checkNotNullExpressionValue(resolvePropagatedSignature, "resolvePropagatedSignature(...)");
        KotlinType returnType = resolvePropagatedSignature.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        KotlinType receiverType = resolvePropagatedSignature.getReceiverType();
        List<ValueParameterDescriptor> valueParameters = resolvePropagatedSignature.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        List<TypeParameterDescriptor> typeParameters = resolvePropagatedSignature.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        boolean hasStableParameterNames = resolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = resolvePropagatedSignature.getErrors();
        Intrinsics.checkNotNullExpressionValue(errors, "getErrors(...)");
        return new LazyJavaScope.MethodSignatureData(returnType, receiverType, valueParameters, typeParameters, hasStableParameterNames, errors);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, (Object) null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        if (!Intrinsics.areEqual((Object) computeJvmDescriptor$default, (Object) MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, (Object) null)) || doesOverride(simpleFunctionDescriptor, functionDescriptor)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor javaConstructor) {
        ClassDescriptor ownerDescriptor2 = getOwnerDescriptor();
        JavaElement javaElement = javaConstructor;
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor2, LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaConstructor), false, getC().getComponents().getSourceElementFactory().source(javaElement));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(...)");
        LazyJavaResolverContext childForMethod = ContextKt.childForMethod(getC(), createJavaConstructor, javaConstructor, ownerDescriptor2.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod, createJavaConstructor, javaConstructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = ownerDescriptor2.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        Collection collection = declaredTypeParameters;
        Iterable<JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter resolveTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter2 = childForMethod.getTypeParameterResolver().resolveTypeParameter(resolveTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter2);
            arrayList.add(resolveTypeParameter2);
        }
        createJavaConstructor.initialize(resolveValueParameters.getDescriptors(), UtilsKt.toDescriptorVisibility(javaConstructor.getVisibility()), CollectionsKt.plus(collection, (List) arrayList));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setHasSynthesizedParameterNames(resolveValueParameters.getHasSynthesizedNames());
        createJavaConstructor.setReturnType(ownerDescriptor2.getDefaultType());
        childForMethod.getComponents().getJavaResolverCache().recordConstructor(javaElement, createJavaConstructor);
        return createJavaConstructor;
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor createDefaultConstructor() {
        List<ValueParameterDescriptor> list;
        boolean isAnnotationType = this.jClass.isAnnotationType();
        if ((this.jClass.isInterface() || !this.jClass.hasDefaultConstructor()) && !isAnnotationType) {
            return null;
        }
        ClassDescriptor ownerDescriptor2 = getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor2, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(...)");
        if (isAnnotationType) {
            list = createAnnotationConstructorParameters(createJavaConstructor);
        } else {
            list = Collections.emptyList();
        }
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(list, getConstructorVisibility(ownerDescriptor2));
        createJavaConstructor.setHasStableParameterNames(true);
        createJavaConstructor.setReturnType(ownerDescriptor2.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, createJavaConstructor);
        return createJavaConstructor;
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor classDescriptor) {
        DescriptorVisibility visibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        if (!Intrinsics.areEqual((Object) visibility, (Object) JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            return visibility;
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PROTECTED_AND_PACKAGE");
        return descriptorVisibility;
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl classConstructorDescriptorImpl) {
        Pair pair;
        Collection<JavaMethod> methods = this.jClass.getMethods();
        ArrayList arrayList = new ArrayList(methods.size());
        JavaTypeAttributes attributes$default = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, (TypeParameterDescriptor) null, 6, (Object) null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object next : methods) {
            if (Intrinsics.areEqual((Object) ((JavaMethod) next).getName(), (Object) JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                arrayList2.add(next);
            } else {
                arrayList3.add(next);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<JavaMethod> list2 = (List) pair2.component2();
        list.size();
        JavaMethod javaMethod = (JavaMethod) CollectionsKt.firstOrNull(list);
        int i = 1;
        if (javaMethod != null) {
            JavaType returnType = javaMethod.getReturnType();
            if (returnType instanceof JavaArrayType) {
                JavaArrayType javaArrayType = (JavaArrayType) returnType;
                pair = new Pair(getC().getTypeResolver().transformArrayType(javaArrayType, attributes$default, true), getC().getTypeResolver().transformJavaType(javaArrayType.getComponentType(), attributes$default));
            } else {
                pair = new Pair(getC().getTypeResolver().transformJavaType(returnType, attributes$default), null);
            }
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, 0, javaMethod, (KotlinType) pair.component1(), (KotlinType) pair.component2());
        }
        int i2 = 0;
        if (javaMethod == null) {
            i = 0;
        }
        for (JavaMethod javaMethod2 : list2) {
            int i3 = i2 + 1;
            int i4 = i2 + i;
            addAnnotationValueParameter(arrayList, classConstructorDescriptorImpl, i4, javaMethod2, getC().getTypeResolver().transformJavaType(javaMethod2.getReturnType(), attributes$default), (KotlinType) null);
            i2 = i3;
        }
        return arrayList;
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i, JavaMethod javaMethod, KotlinType kotlinType, KotlinType kotlinType2) {
        CallableDescriptor callableDescriptor = constructorDescriptor;
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name = javaMethod.getName();
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(...)");
        List<ValueParameterDescriptor> list2 = list;
        list.add(new ValueParameterDescriptorImpl(callableDescriptor, (ValueParameterDescriptor) null, i, empty, name, makeNotNullable, javaMethod.getHasAnnotationParameterDefaultValue(), false, false, kotlinType2 != null ? TypeUtils.makeNotNullable(kotlinType2) : null, getC().getComponents().getSourceElementFactory().source(javaMethod)));
    }

    /* access modifiers changed from: protected */
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r3 = (r3 = r3.nestedClasses).invoke(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name r2, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "location"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r1.recordLookup(r2, r3)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope r3 = r1.getMainScope()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r3 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope) r3
            if (r3 == 0) goto L_0x0024
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r3 = r3.nestedClasses
            if (r3 == 0) goto L_0x0024
            java.lang.Object r3 = r3.invoke(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            if (r3 == 0) goto L_0x0024
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r3
            goto L_0x002d
        L_0x0024:
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r3 = r1.nestedClasses
            java.lang.Object r2 = r3.invoke(r2)
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r3
        L_0x002d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation):kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor");
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        recordLookup(name, lookupLocation);
        return super.getContributedFunctions(name, lookupLocation);
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        recordLookup(name, lookupLocation);
        return super.getContributedVariables(name, lookupLocation);
    }

    /* access modifiers changed from: protected */
    public Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return SetsKt.plus((Set) this.nestedClassIndex.invoke(), ((Map) this.enumEntryIndex.invoke()).keySet());
    }

    /* access modifiers changed from: protected */
    public Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        if (this.jClass.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getFieldNames());
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
        for (KotlinType memberScope : supertypes) {
            CollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, getOwnerDescriptor(), name);
    }

    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }
}
