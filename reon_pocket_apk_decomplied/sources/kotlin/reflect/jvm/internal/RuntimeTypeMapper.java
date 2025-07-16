package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RuntimeTypeMapper.kt */
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = new RuntimeTypeMapper();
    private static final ClassId JAVA_LANG_VOID;

    private RuntimeTypeMapper() {
    }

    static {
        ClassId classId = ClassId.topLevel(new FqName("java.lang.Void"));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(...)");
        JAVA_LANG_VOID = classId;
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.JvmFunctionSignature mapSignature(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r9) {
        /*
            r8 = this;
            java.lang.String r0 = "possiblySubstitutedFunction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverride(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = r0.getOriginal()
            java.lang.String r1 = "getOriginal(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor
            r2 = 0
            if (r1 == 0) goto L_0x0149
            r1 = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor r1 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor) r1
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = r1.getProto()
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function
            if (r4 == 0) goto L_0x0042
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE
            r5 = r3
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r5
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r6 = r1.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r7 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r4 = r4.getJvmMethodSignature(r5, r6, r7)
            if (r4 == 0) goto L_0x0042
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r9 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction
            r9.<init>(r4)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
            return r9
        L_0x0042:
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor
            if (r4 == 0) goto L_0x0142
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r3
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r5 = r1.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r1 = r4.getJvmConstructorSignature(r3, r5, r1)
            if (r1 == 0) goto L_0x0142
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r9.getContainingDeclaration()
            java.lang.String r3 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r0)
            if (r0 == 0) goto L_0x0070
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r9 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction
            r9.<init>(r1)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
            goto L_0x0141
        L_0x0070:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isMultiFieldValueClass(r0)
            if (r0 == 0) goto L_0x013a
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r9
            boolean r0 = r9.isPrimary()
            java.lang.String r3 = ")V"
            java.lang.String r4 = "constructor-impl"
            java.lang.String r5 = "Invalid signature: "
            r6 = 2
            r7 = 0
            if (r0 == 0) goto L_0x00b8
            java.lang.String r9 = r1.getName()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)
            if (r9 == 0) goto L_0x00a2
            java.lang.String r9 = r1.getDesc()
            boolean r9 = kotlin.text.StringsKt.endsWith$default(r9, r3, r7, r6, r2)
            if (r9 == 0) goto L_0x00a2
            goto L_0x0106
        L_0x00a2:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r5)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x00b8:
            java.lang.String r0 = r1.getName()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0124
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9 = r9.getConstructedClass()
            java.lang.String r0 = "getConstructedClass(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r9
            java.lang.String r9 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.toJvmDescriptor(r9)
            java.lang.String r0 = r1.getDesc()
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r0, r3, r7, r6, r2)
            if (r0 == 0) goto L_0x00fc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r1.getDesc()
            java.lang.String r4 = "V"
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r3 = kotlin.text.StringsKt.removeSuffix((java.lang.String) r3, (java.lang.CharSequence) r4)
            r0.append(r3)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r0 = 1
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Method r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method.copy$default(r1, r2, r9, r0, r2)
            goto L_0x0106
        L_0x00fc:
            java.lang.String r0 = r1.getDesc()
            boolean r9 = kotlin.text.StringsKt.endsWith$default(r0, r9, r7, r6, r2)
            if (r9 == 0) goto L_0x010e
        L_0x0106:
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r9 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction
            r9.<init>(r1)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
            goto L_0x0141
        L_0x010e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r5)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x0124:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r5)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x013a:
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinConstructor r9 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinConstructor
            r9.<init>(r1)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
        L_0x0141:
            return r9
        L_0x0142:
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r9 = r8.mapJvmFunctionSignature(r0)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
            return r9
        L_0x0149:
            boolean r9 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor
            if (r9 == 0) goto L_0x018f
            r9 = r0
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor r9 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = r9.getSource()
            boolean r1 = r9 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r1 == 0) goto L_0x015b
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r9 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r9
            goto L_0x015c
        L_0x015b:
            r9 = r2
        L_0x015c:
            if (r9 == 0) goto L_0x0163
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r9 = r9.getJavaElement()
            goto L_0x0164
        L_0x0163:
            r9 = r2
        L_0x0164:
            boolean r1 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r1 == 0) goto L_0x016b
            r2 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r2 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r2
        L_0x016b:
            if (r2 == 0) goto L_0x017b
            java.lang.reflect.Method r9 = r2.getMember()
            if (r9 == 0) goto L_0x017b
            kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaMethod r0 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaMethod
            r0.<init>(r9)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r0 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r0
            return r0
        L_0x017b:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r9 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Incorrect resolution sequence for Java method "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        L_0x018f:
            boolean r9 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor
            r1 = 41
            java.lang.String r3 = " ("
            if (r9 == 0) goto L_0x01f5
            r9 = r0
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor r9 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = r9.getSource()
            boolean r4 = r9 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r4 == 0) goto L_0x01a5
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r9 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r9
            goto L_0x01a6
        L_0x01a5:
            r9 = r2
        L_0x01a6:
            if (r9 == 0) goto L_0x01ac
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r2 = r9.getJavaElement()
        L_0x01ac:
            boolean r9 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor
            if (r9 == 0) goto L_0x01be
            kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaConstructor r9 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$JavaConstructor
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor) r2
            java.lang.reflect.Constructor r0 = r2.getMember()
            r9.<init>(r0)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
            goto L_0x01d7
        L_0x01be:
            boolean r9 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass
            if (r9 == 0) goto L_0x01d8
            r9 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r9 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass) r9
            boolean r4 = r9.isAnnotationType()
            if (r4 == 0) goto L_0x01d8
            kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor r0 = new kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor
            java.lang.Class r9 = r9.getElement()
            r0.<init>(r9)
            r9 = r0
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
        L_0x01d7:
            return r9
        L_0x01d8:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r9 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Incorrect resolution sequence for Java constructor "
            r4.<init>(r5)
            r4.append(r0)
            r4.append(r3)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            r9.<init>(r0)
            throw r9
        L_0x01f5:
            boolean r9 = r8.isKnownBuiltInFunction(r0)
            if (r9 == 0) goto L_0x0202
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r9 = r8.mapJvmFunctionSignature(r0)
            kotlin.reflect.jvm.internal.JvmFunctionSignature r9 = (kotlin.reflect.jvm.internal.JvmFunctionSignature) r9
            return r9
        L_0x0202:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r9 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown origin of "
            r2.<init>(r4)
            r2.append(r0)
            r2.append(r3)
            java.lang.Class r0 = r0.getClass()
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapSignature(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):kotlin.reflect.jvm.internal.JvmFunctionSignature");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.reflect.Method} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.JvmPropertySignature mapPropertySignature(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r8) {
        /*
            r7 = this;
            java.lang.String r0 = "possiblyOverriddenProperty"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r8
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r8 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverride(r8)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r8
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = r8.getOriginal()
            java.lang.String r8 = "getOriginal(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
            boolean r8 = r1 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor
            r0 = 0
            if (r8 == 0) goto L_0x0045
            r8 = r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r8 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) r8
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r2 = r8.getProto()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage r3 = (kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage) r3
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature
            java.lang.String r5 = "propertySignature"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Object r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(r3, r4)
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r3
            if (r3 == 0) goto L_0x00d0
            kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty r6 = new kotlin.reflect.jvm.internal.JvmPropertySignature$KotlinProperty
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r8.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r5 = r8.getTypeTable()
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.reflect.jvm.internal.JvmPropertySignature r6 = (kotlin.reflect.jvm.internal.JvmPropertySignature) r6
            return r6
        L_0x0045:
            boolean r8 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
            if (r8 == 0) goto L_0x00d0
            r8 = r1
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r8 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) r8
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r8 = r8.getSource()
            boolean r2 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r2 == 0) goto L_0x0057
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r8 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r8
            goto L_0x0058
        L_0x0057:
            r8 = r0
        L_0x0058:
            if (r8 == 0) goto L_0x005f
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r8 = r8.getJavaElement()
            goto L_0x0060
        L_0x005f:
            r8 = r0
        L_0x0060:
            boolean r2 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField
            if (r2 == 0) goto L_0x0072
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField r0 = new kotlin.reflect.jvm.internal.JvmPropertySignature$JavaField
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField r8 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField) r8
            java.lang.reflect.Field r8 = r8.getMember()
            r0.<init>(r8)
            kotlin.reflect.jvm.internal.JvmPropertySignature r0 = (kotlin.reflect.jvm.internal.JvmPropertySignature) r0
            goto L_0x00ae
        L_0x0072:
            boolean r2 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r2 == 0) goto L_0x00af
            kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty r2 = new kotlin.reflect.jvm.internal.JvmPropertySignature$JavaMethodProperty
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r8 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r8
            java.lang.reflect.Method r8 = r8.getMember()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor r1 = r1.getSetter()
            if (r1 == 0) goto L_0x0089
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r1 = r1.getSource()
            goto L_0x008a
        L_0x0089:
            r1 = r0
        L_0x008a:
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
            if (r3 == 0) goto L_0x0091
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r1 = (kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement) r1
            goto L_0x0092
        L_0x0091:
            r1 = r0
        L_0x0092:
            if (r1 == 0) goto L_0x0099
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r1 = r1.getJavaElement()
            goto L_0x009a
        L_0x0099:
            r1 = r0
        L_0x009a:
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod
            if (r3 == 0) goto L_0x00a1
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod r1 = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod) r1
            goto L_0x00a2
        L_0x00a1:
            r1 = r0
        L_0x00a2:
            if (r1 == 0) goto L_0x00a8
            java.lang.reflect.Method r0 = r1.getMember()
        L_0x00a8:
            r2.<init>(r8, r0)
            r0 = r2
            kotlin.reflect.jvm.internal.JvmPropertySignature r0 = (kotlin.reflect.jvm.internal.JvmPropertySignature) r0
        L_0x00ae:
            return r0
        L_0x00af:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r0 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Incorrect resolution sequence for Java field "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = " (source = "
            r2.append(r1)
            r2.append(r8)
            r8 = 41
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r0.<init>(r8)
            throw r0
        L_0x00d0:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor r8 = r1.getGetter()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r8
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r8 = r7.mapJvmFunctionSignature(r8)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor r1 = r1.getSetter()
            if (r1 == 0) goto L_0x00e9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r1
            kotlin.reflect.jvm.internal.JvmFunctionSignature$KotlinFunction r0 = r7.mapJvmFunctionSignature(r1)
        L_0x00e9:
            kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty r1 = new kotlin.reflect.jvm.internal.JvmPropertySignature$MappedKotlinProperty
            r1.<init>(r8, r0)
            kotlin.reflect.jvm.internal.JvmPropertySignature r1 = (kotlin.reflect.jvm.internal.JvmPropertySignature) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.RuntimeTypeMapper.mapPropertySignature(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor):kotlin.reflect.jvm.internal.JvmPropertySignature");
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor functionDescriptor) {
        if (DescriptorFactory.isEnumValueOfMethod(functionDescriptor) || DescriptorFactory.isEnumValuesMethod(functionDescriptor)) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) functionDescriptor.getName(), (Object) CloneableClassScope.Companion.getCLONE_NAME()) || !functionDescriptor.getValueParameters().isEmpty()) {
            return false;
        }
        return true;
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor functionDescriptor) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(functionDescriptor), MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 1, (Object) null)));
    }

    private final String mapName(CallableMemberDescriptor callableMemberDescriptor) {
        String jvmMethodNameIfSpecial = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(callableMemberDescriptor);
        if (jvmMethodNameIfSpecial != null) {
            return jvmMethodNameIfSpecial;
        }
        if (callableMemberDescriptor instanceof PropertyGetterDescriptor) {
            String asString = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return JvmAbi.getterName(asString);
        } else if (callableMemberDescriptor instanceof PropertySetterDescriptor) {
            String asString2 = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
            return JvmAbi.setterName(asString2);
        } else {
            String asString3 = callableMemberDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString3, "asString(...)");
            return asString3;
        }
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            PrimitiveType primitiveType = getPrimitiveType(componentType);
            if (primitiveType != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType.getArrayTypeName());
            }
            ClassId classId = ClassId.topLevel(StandardNames.FqNames.array.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(...)");
            return classId;
        } else if (Intrinsics.areEqual((Object) cls, (Object) Void.TYPE)) {
            return JAVA_LANG_VOID;
        } else {
            PrimitiveType primitiveType2 = getPrimitiveType(cls);
            if (primitiveType2 != null) {
                return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, primitiveType2.getTypeName());
            }
            ClassId classId2 = ReflectClassUtilKt.getClassId(cls);
            if (!classId2.isLocal()) {
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                FqName asSingleFqName = classId2.asSingleFqName();
                Intrinsics.checkNotNullExpressionValue(asSingleFqName, "asSingleFqName(...)");
                ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
                if (mapJavaToKotlin != null) {
                    return mapJavaToKotlin;
                }
            }
            return classId2;
        }
    }

    private final PrimitiveType getPrimitiveType(Class<?> cls) {
        if (cls.isPrimitive()) {
            return JvmPrimitiveType.get(cls.getSimpleName()).getPrimitiveType();
        }
        return null;
    }
}
