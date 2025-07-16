package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%H&J\"\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u001a\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010/\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0002JE\u00103\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J(\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\u0006\u0012\u0002\b\u00030\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.H\u0002J=\u0010:\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: KDeclarationContainerImpl.kt */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    /* access modifiers changed from: private */
    public static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int i);

    public abstract Collection<PropertyDescriptor> getProperties(Name name);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: KDeclarationContainerImpl.kt */
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        private final ReflectProperties.LazySoftVal moduleData$delegate;

        public Data() {
            this.moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$moduleData$2(KDeclarationContainerImpl.this));
        }

        public final RuntimeModuleData getModuleData() {
            Object value = this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (RuntimeModuleData) value;
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1 r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            r0.<init>(r7)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope r8 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope) r8
            r1 = 3
            r2 = 0
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, r2, r2, r1, r2)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r8 = r8.iterator()
        L_0x0024:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L_0x0055
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x0055
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L_0x0055
            r4 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor) r4
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = r3.accept(r4, r5)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L_0x0056
        L_0x0055:
            r3 = r2
        L_0x0056:
            if (r3 == 0) goto L_0x0024
            r1.add(r3)
            goto L_0x0024
        L_0x005c:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r8 = kotlin.collections.CollectionsKt.toList(r1)
            java.util.Collection r8 = (java.util.Collection) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: KDeclarationContainerImpl.kt */
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        static {
            MemberBelonginess[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }

        public final boolean accept(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics.checkNotNullParameter(callableMemberDescriptor, "member");
            return callableMemberDescriptor.getKind().isReal() == (this == DECLARED);
        }
    }

    public final PropertyDescriptor findPropertyDescriptor(String str, String str2) {
        String str3;
        String str4 = str;
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "signature");
        MatchResult matchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(str5);
        if (matchEntire != null) {
            String str6 = matchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str6));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + str6 + " not found in " + getJClass());
        }
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        Collection arrayList = new ArrayList();
        for (Object next : getProperties(identifier)) {
            if (Intrinsics.areEqual((Object) RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) next).asString(), (Object) str5)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (list.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + str4 + "' (JVM signature: " + str5 + ") not resolved in " + this);
        } else if (list.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.single(list);
        } else {
            Map linkedHashMap = new LinkedHashMap();
            for (Object next2 : list) {
                DescriptorVisibility visibility = ((PropertyDescriptor) next2).getVisibility();
                Object obj = linkedHashMap.get(visibility);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(visibility, obj);
                }
                ((List) obj).add(next2);
            }
            Collection values = MapsKt.toSortedMap(linkedHashMap, new KDeclarationContainerImpl$$Lambda$0(KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2.INSTANCE)).values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            List list2 = (List) CollectionsKt.last(values);
            if (list2.size() == 1) {
                Intrinsics.checkNotNull(list2);
                return (PropertyDescriptor) CollectionsKt.first(list2);
            }
            Name identifier2 = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
            String joinToString$default = CollectionsKt.joinToString$default(getProperties(identifier2), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, (Object) null);
            StringBuilder sb = new StringBuilder("Property '");
            sb.append(str4);
            sb.append("' (JVM signature: ");
            sb.append(str5);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            if (joinToString$default.length() == 0) {
                str3 = " no members found";
            } else {
                str3 = "\n" + joinToString$default;
            }
            sb.append(str3);
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$3(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x002c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor findFunctionDescriptor(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "signature"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "<init>"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00cf
            java.util.Collection r0 = r13.getConstructorDescriptors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toList(r0)
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x002c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00cc
            java.lang.Object r3 = r1.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r4
            boolean r5 = r4.isPrimary()
            if (r5 == 0) goto L_0x00b5
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r5 = r4.getContainingDeclaration()
            java.lang.String r6 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r5
            boolean r5 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isMultiFieldValueClass(r5)
            if (r5 == 0) goto L_0x00b5
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r5 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            r7 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r7
            kotlin.reflect.jvm.internal.JvmFunctionSignature r5 = r5.mapSignature(r7)
            java.lang.String r5 = r5.asString()
            java.lang.String r7 = "constructor-impl"
            r8 = 0
            r9 = 2
            r10 = 0
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r5, r7, r8, r9, r10)
            if (r7 == 0) goto L_0x0095
            java.lang.String r7 = ")V"
            boolean r7 = kotlin.text.StringsKt.endsWith$default(r5, r7, r8, r9, r10)
            if (r7 == 0) goto L_0x0095
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "V"
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r5 = kotlin.text.StringsKt.removeSuffix((java.lang.String) r5, (java.lang.CharSequence) r8)
            r7.append(r5)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r4 = r4.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r4
            java.lang.String r4 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.toJvmDescriptor(r4)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            goto L_0x00c1
        L_0x0095:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "Invalid signature of "
            r14.<init>(r15)
            r14.append(r4)
            java.lang.String r15 = ": "
            r14.append(r15)
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r14 = r14.toString()
            r15.<init>(r14)
            throw r15
        L_0x00b5:
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r5 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            kotlin.reflect.jvm.internal.JvmFunctionSignature r4 = r5.mapSignature(r4)
            java.lang.String r4 = r4.asString()
        L_0x00c1:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r15)
            if (r4 == 0) goto L_0x002c
            r2.add(r3)
            goto L_0x002c
        L_0x00cc:
            java.util.List r2 = (java.util.List) r2
            goto L_0x010d
        L_0x00cf:
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r14)
            java.lang.String r1 = "identifier(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = r13.getFunctions(r0)
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x00ea:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x010b
            java.lang.Object r3 = r1.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r5 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.JvmFunctionSignature r4 = r5.mapSignature(r4)
            java.lang.String r4 = r4.asString()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r15)
            if (r4 == 0) goto L_0x00ea
            r2.add(r3)
            goto L_0x00ea
        L_0x010b:
            java.util.List r2 = (java.util.List) r2
        L_0x010d:
            int r1 = r2.size()
            r3 = 1
            if (r1 == r3) goto L_0x0170
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.String r0 = "\n"
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1 r1 = kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE
            r10 = r1
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r11 = 30
            r12 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r1 = kotlin.collections.CollectionsKt.joinToString$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r2 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Function '"
            r3.<init>(r4)
            r3.append(r14)
            java.lang.String r14 = "' (JVM signature: "
            r3.append(r14)
            r3.append(r15)
            java.lang.String r14 = ") not resolved in "
            r3.append(r14)
            r3.append(r13)
            r14 = 58
            r3.append(r14)
            r14 = r1
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r14 = r14.length()
            if (r14 != 0) goto L_0x0159
            java.lang.String r14 = " no members found"
            goto L_0x0165
        L_0x0159:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r0)
            r14.append(r1)
            java.lang.String r14 = r14.toString()
        L_0x0165:
            r3.append(r14)
            java.lang.String r14 = r3.toString()
            r2.<init>(r14)
            throw r2
        L_0x0170:
            java.lang.Object r14 = kotlin.collections.CollectionsKt.single(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r14 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r14
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findFunctionDescriptor(java.lang.String, java.lang.String):kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor");
    }

    private final Method lookupMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Method lookupMethod;
        if (z) {
            clsArr[0] = cls;
        }
        Method tryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (tryGetMethod != null) {
            return tryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (lookupMethod = lookupMethod(superclass, str, clsArr, cls2, z)) != null) {
            return lookupMethod;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
        for (Class<?> cls3 : interfaces) {
            Intrinsics.checkNotNull(cls3);
            Method lookupMethod2 = lookupMethod(cls3, str, clsArr, cls2, z);
            if (lookupMethod2 != null) {
                return lookupMethod2;
            }
            if (z) {
                Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls");
                if (tryLoadClass != null) {
                    clsArr[0] = cls3;
                    Method tryGetMethod2 = tryGetMethod(tryLoadClass, str, clsArr, cls2);
                    if (tryGetMethod2 != null) {
                        return tryGetMethod2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Method tryGetMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        Method method;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (Intrinsics.areEqual((Object) declaredMethod.getReturnType(), (Object) cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            Object[] objArr = (Object[]) declaredMethods;
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = objArr[i];
                Method method2 = (Method) method;
                if (Intrinsics.areEqual((Object) method2.getName(), (Object) str) && Intrinsics.areEqual((Object) method2.getReturnType(), (Object) cls2) && Arrays.equals(method2.getParameterTypes(), clsArr)) {
                    break;
                }
                i++;
            }
            return method;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method findMethodBySignature(String str, String str2) {
        Method lookupMethod;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        if (Intrinsics.areEqual((Object) str, (Object) "<init>")) {
            return null;
        }
        Class[] clsArr = (Class[]) loadParameterTypes(str2).toArray(new Class[0]);
        Class<?> loadReturnType = loadReturnType(str2);
        Method lookupMethod2 = lookupMethod(getMethodOwner(), str, clsArr, loadReturnType, false);
        if (lookupMethod2 != null) {
            return lookupMethod2;
        }
        if (!getMethodOwner().isInterface() || (lookupMethod = lookupMethod(Object.class, str, clsArr, loadReturnType, false)) == null) {
            return null;
        }
        return lookupMethod;
    }

    public final Method findDefaultMethod(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        if (Intrinsics.areEqual((Object) str, (Object) "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        addParametersAndMasks(arrayList, str2, false);
        Class<?> methodOwner = getMethodOwner();
        return lookupMethod(methodOwner, str + "$default", (Class[]) arrayList.toArray(new Class[0]), loadReturnType(str2), z);
    }

    public final Constructor<?> findConstructorBySignature(String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(str));
    }

    public final Constructor<?> findDefaultConstructor(String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        Class<?> jClass = getJClass();
        List arrayList = new ArrayList();
        addParametersAndMasks(arrayList, str, true);
        Unit unit = Unit.INSTANCE;
        return tryGetConstructor(jClass, arrayList);
    }

    private final void addParametersAndMasks(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> loadParameterTypes = loadParameterTypes(str);
        list.addAll(loadParameterTypes);
        int size = (loadParameterTypes.size() + 31) / 32;
        for (int i = 0; i < size; i++) {
            Class cls = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(cls, "TYPE");
            list.add(cls);
        }
        if (z) {
            Class<?> cls2 = DEFAULT_CONSTRUCTOR_MARKER;
            list.remove(cls2);
            Intrinsics.checkNotNullExpressionValue(cls2, "DEFAULT_CONSTRUCTOR_MARKER");
            list.add(cls2);
            return;
        }
        list.add(Object.class);
    }

    private final List<Class<?>> loadParameterTypes(String str) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            int i3 = i2;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char charAt = str.charAt(i3);
            if (StringsKt.contains$default((CharSequence) "VZCBSIFJD", charAt, false, 2, (Object) null)) {
                i = i3 + 1;
            } else if (charAt == 'L') {
                i = StringsKt.indexOf$default((CharSequence) str, ';', i2, false, 4, (Object) null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(parseType(str, i2, i));
            i2 = i;
        }
        return arrayList;
    }

    private final Class<?> parseType(String str, int i, int i2) {
        char charAt = str.charAt(i);
        if (charAt == 'L') {
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
            String substring = str.substring(i + 1, i2 - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Class<?> loadClass = safeClassLoader.loadClass(StringsKt.replace$default(substring, '/', '.', false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(loadClass, "loadClass(...)");
            return loadClass;
        } else if (charAt == '[') {
            return UtilKt.createArrayType(parseType(str, i + 1, i2));
        } else {
            if (charAt == 'V') {
                Class<?> cls = Void.TYPE;
                Intrinsics.checkNotNullExpressionValue(cls, "TYPE");
                return cls;
            } else if (charAt == 'Z') {
                return Boolean.TYPE;
            } else {
                if (charAt == 'C') {
                    return Character.TYPE;
                }
                if (charAt == 'B') {
                    return Byte.TYPE;
                }
                if (charAt == 'S') {
                    return Short.TYPE;
                }
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'F') {
                    return Float.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'D') {
                    return Double.TYPE;
                }
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
        }
    }

    private final Class<?> loadReturnType(String str) {
        return parseType(str, StringsKt.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: KDeclarationContainerImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }
}
