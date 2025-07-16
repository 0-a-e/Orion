package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a \u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u001a/\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0002\u001a(\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0002\u001a\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\u0002H\u0000\u001a6\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0014\"\n\b\u0000\u0010\u001b*\u0004\u0018\u00010\u001c*\b\u0012\u0004\u0012\u0002H\u001b0\u00142\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0010H\u0000\u001a\u0018\u0010\u001d\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u001f\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0000\u001a\f\u0010 \u001a\u00020\u0010*\u00020\u0002H\u0002\u001a\u0014\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e*\u0004\u0018\u00010\"H\u0000\u001a\u0012\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e*\u00020\u0001H\u0002\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006&"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "getMfvcUnboxMethods", "", "Ljava/lang/reflect/Method;", "type", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "getValueClassUnboxMethods", "descriptor", "makeKotlinParameterTypes", "isSpecificClass", "Lkotlin/Function1;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "", "Lkotlin/ExtensionFunctionType;", "checkParametersSize", "", "Lkotlin/reflect/jvm/internal/calls/Caller;", "expectedArgsSize", "", "isDefault", "coerceToExpectedReceiverType", "", "createValueClassAwareCallerIfNeeded", "M", "Ljava/lang/reflect/Member;", "getBoxMethod", "Ljava/lang/Class;", "getInlineClassUnboxMethod", "hasValueClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "toJvmDescriptor", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: ValueClassAwareCaller.kt */
public final class ValueClassAwareCallerKt {
    public static final String toJvmDescriptor(ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "<this>");
        ClassId classId = DescriptorUtilsKt.getClassId(classifierDescriptor);
        Intrinsics.checkNotNull(classId);
        String asString = classId.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return ClassMapperLite.mapClass(asString);
    }

    /* access modifiers changed from: private */
    public static final List<Method> getValueClassUnboxMethods(SimpleType simpleType, CallableMemberDescriptor callableMemberDescriptor) {
        Method inlineClassUnboxMethod;
        List<Method> mfvcUnboxMethods = getMfvcUnboxMethods(simpleType);
        if (mfvcUnboxMethods != null) {
            return mfvcUnboxMethods;
        }
        Class<?> inlineClass = toInlineClass((KotlinType) simpleType);
        if (inlineClass == null || (inlineClassUnboxMethod = getInlineClassUnboxMethod(inlineClass, callableMemberDescriptor)) == null) {
            return null;
        }
        return CollectionsKt.listOf(inlineClassUnboxMethod);
    }

    private static final List<String> getMfvcUnboxMethods$getUnboxMethodNameSuffixes(SimpleType simpleType) {
        List list;
        if (!InlineClassesUtilsKt.needsMfvcFlattening(simpleType)) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = simpleType.getConstructor().getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        MultiFieldValueClassRepresentation<SimpleType> multiFieldValueClassRepresentation = DescriptorUtilsKt.getMultiFieldValueClassRepresentation((ClassDescriptor) declarationDescriptor);
        Intrinsics.checkNotNull(multiFieldValueClassRepresentation);
        Collection arrayList = new ArrayList();
        for (Pair pair : multiFieldValueClassRepresentation.getUnderlyingPropertyNamesToTypes()) {
            Name name = (Name) pair.component1();
            List<String> mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes((SimpleType) pair.component2());
            if (mfvcUnboxMethods$getUnboxMethodNameSuffixes != null) {
                Iterable<String> iterable = mfvcUnboxMethods$getUnboxMethodNameSuffixes;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (String str : iterable) {
                    arrayList2.add(name.getIdentifier() + '-' + str);
                }
                list = (List) arrayList2;
            } else {
                list = CollectionsKt.listOf(name.getIdentifier());
            }
            CollectionsKt.addAll(arrayList, list);
        }
        return (List) arrayList;
    }

    public static final List<Method> getMfvcUnboxMethods(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, TransferTable.COLUMN_TYPE);
        List<String> mfvcUnboxMethods$getUnboxMethodNameSuffixes = getMfvcUnboxMethods$getUnboxMethodNameSuffixes(TypeSubstitutionKt.asSimpleType(simpleType));
        if (mfvcUnboxMethods$getUnboxMethodNameSuffixes == null) {
            return null;
        }
        Iterable<String> iterable = mfvcUnboxMethods$getUnboxMethodNameSuffixes;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String str : iterable) {
            arrayList.add("unbox-impl-" + str);
        }
        ClassifierDescriptor declarationDescriptor = simpleType.getConstructor().getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
        Intrinsics.checkNotNull(javaClass);
        Iterable<String> iterable2 = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (String declaredMethod : iterable2) {
            arrayList2.add(javaClass.getDeclaredMethod(declaredMethod, (Class[]) null));
        }
        return (List) arrayList2;
    }

    /* access modifiers changed from: private */
    public static final void checkParametersSize(Caller<?> caller, int i, CallableMemberDescriptor callableMemberDescriptor, boolean z) {
        if (CallerKt.getArity(caller) != i) {
            throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(caller) + " != " + i + "\nCalling: " + callableMemberDescriptor + "\nParameter types: " + caller.getParameterTypes() + ")\nDefault: " + z);
        }
    }

    /* access modifiers changed from: private */
    public static final List<KotlinType> makeKotlinParameterTypes(CallableMemberDescriptor callableMemberDescriptor, Function1<? super ClassDescriptor, Boolean> function1) {
        ArrayList arrayList = new ArrayList();
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        KotlinType type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
        if (type != null) {
            arrayList.add(type);
        } else if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            ClassDescriptor constructedClass = ((ConstructorDescriptor) callableMemberDescriptor).getConstructedClass();
            Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
            if (constructedClass.isInner()) {
                DeclarationDescriptor containingDeclaration = constructedClass.getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                arrayList.add(((ClassDescriptor) containingDeclaration).getDefaultType());
            }
        } else {
            DeclarationDescriptor containingDeclaration2 = callableMemberDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
            if ((containingDeclaration2 instanceof ClassDescriptor) && function1.invoke(containingDeclaration2).booleanValue()) {
                arrayList.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
            }
        }
        List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        for (ValueParameterDescriptor type2 : valueParameters) {
            arrayList.add(type2.getType());
        }
        Collection collection = arrayList;
        return arrayList;
    }

    public static /* synthetic */ Caller createValueClassAwareCallerIfNeeded$default(Caller caller, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return createValueClassAwareCallerIfNeeded(caller, callableMemberDescriptor, z);
    }

    public static final <M extends Member> Caller<M> createValueClassAwareCallerIfNeeded(Caller<? extends M> caller, CallableMemberDescriptor callableMemberDescriptor, boolean z) {
        Intrinsics.checkNotNullParameter(caller, "<this>");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        if (!InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(callableMemberDescriptor)) {
            List<ReceiverParameterDescriptor> contextReceiverParameters = callableMemberDescriptor.getContextReceiverParameters();
            Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
            Iterable iterable = contextReceiverParameters;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    KotlinType type = ((ReceiverParameterDescriptor) it.next()).getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    if (InlineClassesUtilsKt.isValueClassType(type)) {
                        break;
                    }
                }
            }
            List<ValueParameterDescriptor> valueParameters = callableMemberDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            Iterable iterable2 = valueParameters;
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                Iterator it2 = iterable2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    KotlinType type2 = ((ValueParameterDescriptor) it2.next()).getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    if (InlineClassesUtilsKt.isValueClassType(type2)) {
                        break;
                    }
                }
            }
            KotlinType returnType = callableMemberDescriptor.getReturnType();
            if ((returnType == null || !InlineClassesUtilsKt.isInlineClassType(returnType)) && !hasValueClassReceiver(callableMemberDescriptor)) {
                return caller;
            }
        }
        return new ValueClassAwareCaller<>(callableMemberDescriptor, caller, z);
    }

    private static final boolean hasValueClassReceiver(CallableMemberDescriptor callableMemberDescriptor) {
        KotlinType expectedReceiverType = getExpectedReceiverType(callableMemberDescriptor);
        return expectedReceiverType != null && InlineClassesUtilsKt.isValueClassType(expectedReceiverType);
    }

    public static final Method getInlineClassUnboxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", (Class[]) null);
            Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    /* access modifiers changed from: private */
    public static final Method getBoxMethod(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) {
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", new Class[]{getInlineClassUnboxMethod(cls, callableMemberDescriptor).getReturnType()});
            Intrinsics.checkNotNull(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    /* access modifiers changed from: private */
    public static final Class<?> toInlineClass(KotlinType kotlinType) {
        Class<?> inlineClass = toInlineClass((DeclarationDescriptor) kotlinType.getConstructor().getDeclarationDescriptor());
        if (inlineClass == null) {
            return null;
        }
        if (!TypeUtils.isNullableType(kotlinType)) {
            return inlineClass;
        }
        KotlinType unsubstitutedUnderlyingType = InlineClassesUtilsKt.unsubstitutedUnderlyingType(kotlinType);
        if (unsubstitutedUnderlyingType != null && !TypeUtils.isNullableType(unsubstitutedUnderlyingType) && !KotlinBuiltIns.isPrimitiveType(unsubstitutedUnderlyingType)) {
            return inlineClass;
        }
        return null;
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !InlineClassesUtilsKt.isInlineClass(declarationDescriptor)) {
            return null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        if (javaClass != null) {
            return javaClass;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + classDescriptor.getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) declarationDescriptor) + ')');
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor callableMemberDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        ReceiverParameterDescriptor dispatchReceiverParameter = callableMemberDescriptor.getDispatchReceiverParameter();
        if (extensionReceiverParameter != null) {
            return extensionReceiverParameter.getType();
        }
        SimpleType simpleType = null;
        if (dispatchReceiverParameter == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof ConstructorDescriptor) {
            return dispatchReceiverParameter.getType();
        }
        DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            simpleType = classDescriptor.getDefaultType();
        }
        return simpleType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r2 = getInlineClassUnboxMethod((r0 = toInlineClass((r0 = getExpectedReceiverType(r2)))), r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object coerceToExpectedReceiverType(java.lang.Object r1, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r2) {
        /*
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
            if (r0 == 0) goto L_0x0013
            r0 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor) r0
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(r0)
            if (r0 == 0) goto L_0x0013
            return r1
        L_0x0013:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = getExpectedReceiverType(r2)
            if (r0 == 0) goto L_0x002b
            java.lang.Class r0 = toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r0)
            if (r0 == 0) goto L_0x002b
            java.lang.reflect.Method r2 = getInlineClassUnboxMethod(r0, r2)
            if (r2 != 0) goto L_0x0026
            goto L_0x002b
        L_0x0026:
            r0 = 0
            java.lang.Object r1 = r2.invoke(r1, r0)
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.coerceToExpectedReceiverType(java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor):java.lang.Object");
    }
}
