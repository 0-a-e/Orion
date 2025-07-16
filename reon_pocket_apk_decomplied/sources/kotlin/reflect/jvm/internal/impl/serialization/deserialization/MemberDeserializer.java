package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: MemberDeserializer.kt */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;
    /* access modifiers changed from: private */
    public final DeserializationContext c;

    private final int loadOldFlags(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    public MemberDeserializer(DeserializationContext deserializationContext) {
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        this.c = deserializationContext;
        this.annotationDeserializer = new AnnotationDeserializer(deserializationContext.getComponents().getModuleDescriptor(), deserializationContext.getComponents().getNotFoundClasses());
    }

    public final PropertyDescriptor loadProperty(ProtoBuf.Property property) {
        MessageLite messageLite;
        Annotations annotations;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        ProtoBuf.Property property2;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl3;
        KotlinType type;
        ProtoBuf.Property property3 = property;
        Intrinsics.checkNotNullParameter(property3, "proto");
        int flags = property.hasFlags() ? property.getFlags() : loadOldFlags(property.getOldFlags());
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        MessageLite messageLite2 = property3;
        Annotations annotations2 = getAnnotations(messageLite2, flags, AnnotatedCallableKind.PROPERTY);
        Modality modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(flags));
        Boolean bool = Flags.IS_VAR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean booleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), property.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(flags));
        Boolean bool2 = Flags.IS_LATEINIT.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        boolean booleanValue3 = bool3.booleanValue();
        MessageLite messageLite3 = messageLite2;
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        String str = "get(...)";
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, str);
        boolean booleanValue5 = bool5.booleanValue();
        MessageLite messageLite4 = messageLite3;
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, str);
        DeserializedPropertyDescriptor deserializedPropertyDescriptor = r1;
        String str2 = str;
        int i = flags;
        ProtoBuf.Property property4 = property3;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor2 = new DeserializedPropertyDescriptor(containingDeclaration, (PropertyDescriptor) null, annotations2, modality, descriptorVisibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), property, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeserializationContext deserializationContext = this.c;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = deserializedPropertyDescriptor;
        List<ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedPropertyDescriptor3, typeParameterList, (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null);
        int i2 = i;
        Boolean bool7 = Flags.HAS_GETTER.get(i2);
        String str3 = str2;
        Intrinsics.checkNotNullExpressionValue(bool7, str3);
        boolean booleanValue6 = bool7.booleanValue();
        if (!booleanValue6 || !ProtoTypeTableUtilKt.hasReceiver(property)) {
            messageLite = messageLite4;
            annotations = Annotations.Companion.getEMPTY();
        } else {
            messageLite = messageLite4;
            annotations = getReceiverParameterAnnotations(messageLite, AnnotatedCallableKind.PROPERTY_GETTER);
        }
        ProtoBuf.Property property5 = property;
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property5, this.c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property5, this.c.getTypeTable());
        ClassKind classKind = null;
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable = (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor3, type, annotations);
        Iterable contextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(property5, this.c.getTypeTable());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(contextReceiverTypes, 10));
        Iterator it = contextReceiverTypes.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(toContextReceiver((ProtoBuf.Type) next, childContext$default, deserializedPropertyDescriptor3, i3));
            it = it;
            i3 = i4;
        }
        deserializedPropertyDescriptor3.setType(type2, ownTypeParameters, dispatchReceiverParameter, createExtensionReceiverParameterForCallable, (List) arrayList);
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(i2);
        Intrinsics.checkNotNullExpressionValue(bool8, str3);
        int accessorFlags = Flags.getAccessorFlags(bool8.booleanValue(), Flags.VISIBILITY.get(i2), Flags.MODALITY.get(i2), false, false, false);
        if (booleanValue6) {
            int getterFlags = property.hasGetterFlags() ? property.getGetterFlags() : accessorFlags;
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool9, str3);
            boolean booleanValue7 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool10, str3);
            boolean booleanValue8 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool11, str3);
            boolean booleanValue9 = bool11.booleanValue();
            Annotations annotations3 = getAnnotations(messageLite, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue7) {
                propertyGetterDescriptorImpl3 = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor3, annotations3, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(getterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(getterFlags)), !booleanValue7, booleanValue8, booleanValue9, deserializedPropertyDescriptor3.getKind(), (PropertyGetterDescriptor) null, SourceElement.NO_SOURCE);
            } else {
                propertyGetterDescriptorImpl3 = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor3, annotations3);
                Intrinsics.checkNotNull(propertyGetterDescriptorImpl3);
            }
            propertyGetterDescriptorImpl3.initialize(deserializedPropertyDescriptor3.getReturnType());
            propertyGetterDescriptorImpl = propertyGetterDescriptorImpl3;
        } else {
            propertyGetterDescriptorImpl = null;
        }
        Boolean bool12 = Flags.HAS_SETTER.get(i2);
        Intrinsics.checkNotNullExpressionValue(bool12, str3);
        if (bool12.booleanValue()) {
            if (property.hasSetterFlags()) {
                accessorFlags = property.getSetterFlags();
            }
            Boolean bool13 = Flags.IS_NOT_DEFAULT.get(accessorFlags);
            Intrinsics.checkNotNullExpressionValue(bool13, str3);
            boolean booleanValue10 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_EXTERNAL_ACCESSOR.get(accessorFlags);
            Intrinsics.checkNotNullExpressionValue(bool14, str3);
            boolean booleanValue11 = bool14.booleanValue();
            Boolean bool15 = Flags.IS_INLINE_ACCESSOR.get(accessorFlags);
            Intrinsics.checkNotNullExpressionValue(bool15, str3);
            boolean booleanValue12 = bool15.booleanValue();
            Annotations annotations4 = getAnnotations(messageLite, accessorFlags, AnnotatedCallableKind.PROPERTY_SETTER);
            if (booleanValue10) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor3, annotations4, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(accessorFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(accessorFlags)), !booleanValue10, booleanValue11, booleanValue12, deserializedPropertyDescriptor3.getKind(), (PropertySetterDescriptor) null, SourceElement.NO_SOURCE);
                DeserializationContext deserializationContext2 = childContext$default;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl3 = propertySetterDescriptorImpl2;
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                property2 = property5;
                propertySetterDescriptorImpl3.initialize((ValueParameterDescriptor) CollectionsKt.single(DeserializationContext.childContext$default(deserializationContext2, propertySetterDescriptorImpl2, CollectionsKt.emptyList(), (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null).getMemberDeserializer().valueParameters(CollectionsKt.listOf(property.getSetterValueParameter()), messageLite, AnnotatedCallableKind.PROPERTY_SETTER)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl3;
            } else {
                propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
                property2 = property5;
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor3, annotations4, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNull(propertySetterDescriptorImpl);
            }
        } else {
            propertyGetterDescriptorImpl2 = propertyGetterDescriptorImpl;
            property2 = property5;
            propertySetterDescriptorImpl = null;
        }
        Boolean bool16 = Flags.HAS_CONSTANT.get(i2);
        Intrinsics.checkNotNullExpressionValue(bool16, str3);
        if (bool16.booleanValue()) {
            deserializedPropertyDescriptor3.setCompileTimeInitializerFactory(new MemberDeserializer$loadProperty$4(this, property2, deserializedPropertyDescriptor3));
        }
        DeclarationDescriptor containingDeclaration2 = this.c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration2 instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration2 : null;
        if (classDescriptor != null) {
            classKind = classDescriptor.getKind();
        }
        if (classKind == ClassKind.ANNOTATION_CLASS) {
            deserializedPropertyDescriptor3.setCompileTimeInitializerFactory(new MemberDeserializer$loadProperty$5(this, property2, deserializedPropertyDescriptor3));
        }
        PropertyDescriptor propertyDescriptor = deserializedPropertyDescriptor3;
        deserializedPropertyDescriptor3.initialize(propertyGetterDescriptorImpl2, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(property2, false), propertyDescriptor), new FieldDescriptorImpl(getPropertyFieldAnnotations(property2, true), propertyDescriptor));
        return propertyDescriptor;
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends ReceiverParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, List<? extends ValueParameterDescriptor> list3, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function function) {
        Annotations annotations;
        VersionRequirementTable versionRequirementTable;
        KotlinType type;
        ProtoBuf.Function function2 = function;
        Intrinsics.checkNotNullParameter(function2, "proto");
        int flags = function.hasFlags() ? function.getFlags() : loadOldFlags(function.getOldFlags());
        MessageLite messageLite = function2;
        Annotations annotations2 = getAnnotations(messageLite, flags, AnnotatedCallableKind.FUNCTION);
        if (ProtoTypeTableUtilKt.hasReceiver(function)) {
            annotations = getReceiverParameterAnnotations(messageLite, AnnotatedCallableKind.FUNCTION);
        } else {
            annotations = Annotations.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual((Object) DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), function.getName())), (Object) SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.c.getVersionRequirementTable();
        }
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), (SimpleFunctionDescriptor) null, annotations2, NameResolverUtilKt.getName(this.c.getNameResolver(), function.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(flags)), function, this.c.getNameResolver(), this.c.getTypeTable(), versionRequirementTable, this.c.getContainerSource(), (SourceElement) null, 1024, (DefaultConstructorMarker) null);
        DeserializationContext deserializationContext = this.c;
        List<ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null);
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(function2, this.c.getTypeTable());
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable = (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, annotations);
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        Collection arrayList = new ArrayList();
        int i = 0;
        for (Object next : ProtoTypeTableUtilKt.contextReceiverTypes(function2, this.c.getTypeTable())) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReceiverParameterDescriptor contextReceiver = toContextReceiver((ProtoBuf.Type) next, childContext$default, deserializedSimpleFunctionDescriptor, i);
            if (contextReceiver != null) {
                arrayList.add(contextReceiver);
            }
            i = i2;
        }
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(valueParameterList, messageLite, AnnotatedCallableKind.FUNCTION);
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(function2, this.c.getTypeTable()));
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor2 = deserializedSimpleFunctionDescriptor;
        DeserializationContext deserializationContext2 = childContext$default;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor3 = deserializedSimpleFunctionDescriptor;
        int i3 = flags;
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor2, createExtensionReceiverParameterForCallable, dispatchReceiverParameter, (List) arrayList, ownTypeParameters, valueParameters, type2, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(flags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(flags)), MapsKt.emptyMap());
        Boolean bool = Flags.IS_OPERATOR.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        deserializedSimpleFunctionDescriptor3.setOperator(bool.booleanValue());
        Boolean bool2 = Flags.IS_INFIX.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        deserializedSimpleFunctionDescriptor3.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags.IS_EXTERNAL_FUNCTION.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        deserializedSimpleFunctionDescriptor3.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags.IS_INLINE.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        deserializedSimpleFunctionDescriptor3.setInline(bool4.booleanValue());
        Boolean bool5 = Flags.IS_TAILREC.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        deserializedSimpleFunctionDescriptor3.setTailrec(bool5.booleanValue());
        Boolean bool6 = Flags.IS_SUSPEND.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        deserializedSimpleFunctionDescriptor3.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags.IS_EXPECT_FUNCTION.get(i3);
        Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        deserializedSimpleFunctionDescriptor3.setExpect(bool7.booleanValue());
        deserializedSimpleFunctionDescriptor3.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(i3).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(function2, deserializedSimpleFunctionDescriptor3, this.c.getTypeTable(), deserializationContext2.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor3.putInUserDataMap(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor3;
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias typeAlias) {
        ProtoBuf.TypeAlias typeAlias2 = typeAlias;
        Intrinsics.checkNotNullParameter(typeAlias2, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        Iterable<ProtoBuf.Annotation> iterable = annotationList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation annotation : iterable) {
            AnnotationDeserializer annotationDeserializer2 = this.annotationDeserializer;
            Intrinsics.checkNotNull(annotation);
            arrayList.add(annotationDeserializer2.deserializeAnnotation(annotation, this.c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), companion.create((List) arrayList), NameResolverUtilKt.getName(this.c.getNameResolver(), typeAlias.getName()), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(typeAlias.getFlags())), typeAlias, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        List<ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(this.c, deserializedTypeAliasDescriptor, typeParameterList, (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null);
        deserializedTypeAliasDescriptor.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(typeAlias2, this.c.getTypeTable()), false), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(typeAlias2, this.c.getTypeTable()), false));
        return deserializedTypeAliasDescriptor;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor constructor, boolean z) {
        ProtoBuf.Constructor constructor2 = constructor;
        Intrinsics.checkNotNullParameter(constructor2, "proto");
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        MessageLite messageLite = constructor2;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = r1;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, (ConstructorDescriptor) null, getAnnotations(messageLite, constructor.getFlags(), AnnotatedCallableKind.FUNCTION), z, CallableMemberDescriptor.Kind.DECLARATION, constructor, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), (SourceElement) null, 1024, (DefaultConstructorMarker) null);
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.c, deserializedClassConstructorDescriptor, CollectionsKt.emptyList(), (NameResolver) null, (TypeTable) null, (VersionRequirementTable) null, (BinaryVersion) null, 60, (Object) null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        deserializedClassConstructorDescriptor.initialize(memberDeserializer.valueParameters(valueParameterList, messageLite, AnnotatedCallableKind.FUNCTION), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(constructor.getFlags())));
        deserializedClassConstructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        deserializedClassConstructorDescriptor.setExpect(classDescriptor.isExpect());
        deserializedClassConstructorDescriptor.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(constructor.getFlags()).booleanValue());
        return deserializedClassConstructorDescriptor;
    }

    private final Annotations getAnnotations(MessageLite messageLite, int i, AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$getAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final Annotations getPropertyFieldAnnotations(ProtoBuf.Property property, boolean z) {
        if (!Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$getPropertyFieldAnnotations$1(this, z, property));
    }

    private final Annotations getReceiverParameterAnnotations(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$getReceiverParameterAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> r26, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r27, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r28) {
        /*
            r25 = this;
            r7 = r25
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.c
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
            java.lang.String r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r20 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r20 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r20
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r20.getContainingDeclaration()
            java.lang.String r1 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer r21 = r7.asProtoContainer(r0)
            r0 = r26
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            r15 = r1
            java.util.Collection r15 = (java.util.Collection) r15
            java.util.Iterator r22 = r0.iterator()
            r23 = 0
            r11 = r23
        L_0x0038:
            boolean r0 = r22.hasNext()
            if (r0 == 0) goto L_0x0113
            java.lang.Object r0 = r22.next()
            int r24 = r11 + 1
            if (r11 >= 0) goto L_0x0049
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0049:
            r8 = r0
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r8 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r8
            boolean r0 = r8.hasFlags()
            if (r0 == 0) goto L_0x0058
            int r0 = r8.getFlags()
            r9 = r0
            goto L_0x005a
        L_0x0058:
            r9 = r23
        L_0x005a:
            java.lang.String r10 = "get(...)"
            if (r21 == 0) goto L_0x008d
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS
            java.lang.Boolean r0 = r0.get((int) r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x008d
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations r12 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.c
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r13 = r0.getStorageManager()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$valueParameters$1$annotations$1 r14 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$valueParameters$1$annotations$1
            r0 = r14
            r1 = r25
            r2 = r21
            r3 = r27
            r4 = r28
            r5 = r11
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r12.<init>(r13, r14)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r12 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r12
            goto L_0x0094
        L_0x008d:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r0.getEMPTY()
            r12 = r0
        L_0x0094:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r0.getNameResolver()
            int r1 = r8.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r13 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r7.c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r0 = r0.getTypeDeserializer()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r7.c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r8, (kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable) r1)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = r0.type(r1)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.DECLARES_DEFAULT_VALUE
            java.lang.Boolean r0 = r0.get((int) r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
            boolean r0 = r0.booleanValue()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CROSSINLINE
            java.lang.Boolean r1 = r1.get((int) r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r10)
            boolean r16 = r1.booleanValue()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags$BooleanFlagField r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOINLINE
            java.lang.Boolean r1 = r1.get((int) r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r10)
            boolean r17 = r1.booleanValue()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r7.c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.varargElementType(r8, r1)
            if (r1 == 0) goto L_0x00f4
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r7.c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r2 = r2.getTypeDeserializer()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r2.type(r1)
            goto L_0x00f5
        L_0x00f4:
            r1 = 0
        L_0x00f5:
            r18 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r1 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r2 = "NO_SOURCE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r10 = 0
            r8 = r2
            r9 = r20
            r3 = r15
            r15 = r0
            r19 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r3.add(r2)
            r15 = r3
            r11 = r24
            goto L_0x0038
        L_0x0113:
            r3 = r15
            r15 = r3
            java.util.List r15 = (java.util.List) r15
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.List r0 = kotlin.collections.CollectionsKt.toList(r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.valueParameters(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind):java.util.List");
    }

    /* access modifiers changed from: private */
    public final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf.Type type, DeserializationContext deserializationContext, CallableDescriptor callableDescriptor, int i) {
        return DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, deserializationContext.getTypeDeserializer().type(type), (Name) null, Annotations.Companion.getEMPTY(), i);
    }
}
