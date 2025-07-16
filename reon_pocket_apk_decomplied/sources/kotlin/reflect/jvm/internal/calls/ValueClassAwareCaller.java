package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002%&B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006'"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "oldCaller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "caller", "data", "Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "hasMfvcParameters", "member", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "slices", "", "Lkotlin/ranges/IntRange;", "[Lkotlin/ranges/IntRange;", "call", "", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "getRealSlicesOfParameters", "index", "", "BoxUnboxData", "MultiFieldValueClassPrimaryConstructorCaller", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ValueClassAwareCaller.kt */
public final class ValueClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean hasMfvcParameters;
    private final boolean isDefault;
    private final M member;
    private final IntRange[] slices;

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e5, code lost:
        if ((r3 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0107;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ValueClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r11, kotlin.reflect.jvm.internal.calls.Caller<? extends M> r12, boolean r13) {
        /*
            r10 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "oldCaller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r10.<init>()
            r10.isDefault = r13
            boolean r13 = r12 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            r0 = 0
            r1 = 0
            if (r13 == 0) goto L_0x0082
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r13 = r11.getExtensionReceiverParameter()
            if (r13 != 0) goto L_0x001f
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r13 = r11.getDispatchReceiverParameter()
        L_0x001f:
            if (r13 == 0) goto L_0x0026
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = r13.getType()
            goto L_0x0027
        L_0x0026:
            r13 = r0
        L_0x0027:
            if (r13 == 0) goto L_0x0082
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.needsMfvcFlattening(r13)
            if (r2 == 0) goto L_0x0082
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(r13)
            java.util.List r13 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getMfvcUnboxMethods(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r3)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r13 = r13.iterator()
        L_0x004d:
            boolean r3 = r13.hasNext()
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r13.next()
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            r4 = r12
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStatic r4 = (kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic) r4
            java.lang.Object r4 = r4.getBoundReceiver$kotlin_reflection()
            java.lang.Object r3 = r3.invoke(r4, r0)
            r2.add(r3)
            goto L_0x004d
        L_0x0068:
            java.util.List r2 = (java.util.List) r2
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.Object[] r13 = r2.toArray(r13)
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStaticMultiFieldValueClass r2 = new kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStaticMultiFieldValueClass
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStatic r12 = (kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic) r12
            java.lang.reflect.Member r12 = r12.getMember()
            java.lang.reflect.Method r12 = (java.lang.reflect.Method) r12
            r2.<init>(r12, r13)
            r12 = r2
            kotlin.reflect.jvm.internal.calls.Caller r12 = (kotlin.reflect.jvm.internal.calls.Caller) r12
        L_0x0082:
            r10.caller = r12
            java.lang.reflect.Member r12 = r12.getMember()
            r10.member = r12
            r12 = r10
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller r12 = (kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller) r12
            kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = r11.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            boolean r13 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            r2 = 1
            if (r13 == 0) goto L_0x00af
            r3 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3
            boolean r3 = r3.isSuspend()
            if (r3 == 0) goto L_0x00af
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.substitutedUnderlyingType(r12)
            if (r3 == 0) goto L_0x00af
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(r3)
            if (r3 != r2) goto L_0x00af
            goto L_0x00ba
        L_0x00af:
            java.lang.Class r12 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r12)
            if (r12 == 0) goto L_0x00ba
            java.lang.reflect.Method r12 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getBoxMethod(r12, r11)
            goto L_0x00bb
        L_0x00ba:
            r12 = r0
        L_0x00bb:
            r3 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r3
            boolean r3 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(r3)
            if (r3 == 0) goto L_0x00d3
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$BoxUnboxData r11 = new kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$BoxUnboxData
            kotlin.ranges.IntRange$Companion r13 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r13 = r13.getEMPTY()
            java.util.List[] r0 = new java.util.List[r1]
            r11.<init>(r13, r0, r12)
            goto L_0x01b0
        L_0x00d3:
            kotlin.reflect.jvm.internal.calls.Caller<M> r3 = r10.caller
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            r5 = -1
            if (r4 != 0) goto L_0x0107
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass
            if (r4 == 0) goto L_0x00df
            goto L_0x0107
        L_0x00df:
            boolean r4 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r4 == 0) goto L_0x00e8
            boolean r3 = r3 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r3 == 0) goto L_0x0106
            goto L_0x0107
        L_0x00e8:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r3 = r11.getDispatchReceiverParameter()
            if (r3 == 0) goto L_0x0106
            kotlin.reflect.jvm.internal.calls.Caller<M> r3 = r10.caller
            boolean r3 = r3 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r3 != 0) goto L_0x0106
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r11.getContainingDeclaration()
            java.lang.String r4 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r3 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(r3)
            if (r3 == 0) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r5 = r2
            goto L_0x0107
        L_0x0106:
            r5 = r1
        L_0x0107:
            kotlin.reflect.jvm.internal.calls.Caller<M> r3 = r10.caller
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass
            if (r4 == 0) goto L_0x0115
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStaticMultiFieldValueClass r3 = (kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass) r3
            int r3 = r3.getReceiverComponentsCount()
            int r3 = -r3
            goto L_0x0116
        L_0x0115:
            r3 = r5
        L_0x0116:
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$data$1$kotlinParameterTypes$1 r4 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$data$1$kotlinParameterTypes$1.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.util.List r4 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.makeKotlinParameterTypes(r11, r4)
            boolean r6 = r10.isDefault
            if (r6 == 0) goto L_0x0142
            r6 = r4
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = r1
        L_0x012a:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x013c
            java.lang.Object r8 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            int r8 = data$lambda$3$typeSize(r8)
            int r7 = r7 + r8
            goto L_0x012a
        L_0x013c:
            int r7 = r7 + 31
            int r7 = r7 / 32
            int r7 = r7 + r2
            goto L_0x0143
        L_0x0142:
            r7 = r1
        L_0x0143:
            if (r13 == 0) goto L_0x0150
            r13 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r13
            boolean r13 = r13.isSuspend()
            if (r13 == 0) goto L_0x0150
            r13 = r2
            goto L_0x0151
        L_0x0150:
            r13 = r1
        L_0x0151:
            int r7 = r7 + r13
            r13 = r4
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
            r6 = r1
        L_0x015a:
            boolean r8 = r13.hasNext()
            if (r8 == 0) goto L_0x016c
            java.lang.Object r8 = r13.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            int r8 = data$lambda$3$typeSize(r8)
            int r6 = r6 + r8
            goto L_0x015a
        L_0x016c:
            int r6 = r6 + r3
            int r6 = r6 + r7
            r13 = r10
            kotlin.reflect.jvm.internal.calls.Caller r13 = (kotlin.reflect.jvm.internal.calls.Caller) r13
            boolean r3 = r10.isDefault
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.checkParametersSize(r13, r6, r11, r3)
            int r13 = java.lang.Math.max(r5, r1)
            int r3 = r4.size()
            int r3 = r3 + r5
            kotlin.ranges.IntRange r13 = kotlin.ranges.RangesKt.until((int) r13, (int) r3)
            java.util.List[] r3 = new java.util.List[r6]
            r7 = r1
        L_0x0186:
            if (r7 >= r6) goto L_0x01ab
            int r8 = r13.getFirst()
            int r9 = r13.getLast()
            if (r7 > r9) goto L_0x01a5
            if (r8 > r7) goto L_0x01a5
            int r8 = r7 - r5
            java.lang.Object r8 = r4.get(r8)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(r8)
            java.util.List r8 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getValueClassUnboxMethods(r8, r11)
            goto L_0x01a6
        L_0x01a5:
            r8 = r0
        L_0x01a6:
            r3[r7] = r8
            int r7 = r7 + 1
            goto L_0x0186
        L_0x01ab:
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$BoxUnboxData r11 = new kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$BoxUnboxData
            r11.<init>(r13, r3, r12)
        L_0x01b0:
            r10.data = r11
            java.util.List r12 = kotlin.collections.CollectionsKt.createListBuilder()
            kotlin.reflect.jvm.internal.calls.Caller<M> r13 = r10.caller
            boolean r0 = r13 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass
            if (r0 == 0) goto L_0x01c4
            kotlin.reflect.jvm.internal.calls.CallerImpl$Method$BoundStaticMultiFieldValueClass r13 = (kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass) r13
            java.lang.Object[] r13 = r13.getBoundReceiverComponents$kotlin_reflection()
            int r13 = r13.length
            goto L_0x01cb
        L_0x01c4:
            boolean r13 = r13 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            if (r13 == 0) goto L_0x01ca
            r13 = r2
            goto L_0x01cb
        L_0x01ca:
            r13 = r1
        L_0x01cb:
            if (r13 <= 0) goto L_0x01d4
            kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.until((int) r1, (int) r13)
            r12.add(r0)
        L_0x01d4:
            java.util.List[] r11 = r11.getUnboxParameters()
            int r0 = r11.length
            r3 = r1
        L_0x01da:
            if (r3 >= r0) goto L_0x01f2
            r4 = r11[r3]
            if (r4 == 0) goto L_0x01e5
            int r4 = r4.size()
            goto L_0x01e6
        L_0x01e5:
            r4 = r2
        L_0x01e6:
            int r4 = r4 + r13
            kotlin.ranges.IntRange r13 = kotlin.ranges.RangesKt.until((int) r13, (int) r4)
            r12.add(r13)
            int r3 = r3 + 1
            r13 = r4
            goto L_0x01da
        L_0x01f2:
            java.util.List r11 = kotlin.collections.CollectionsKt.build(r12)
            java.util.Collection r11 = (java.util.Collection) r11
            kotlin.ranges.IntRange[] r12 = new kotlin.ranges.IntRange[r1]
            java.lang.Object[] r11 = r11.toArray(r12)
            kotlin.ranges.IntRange[] r11 = (kotlin.ranges.IntRange[]) r11
            r10.slices = r11
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$BoxUnboxData r11 = r10.data
            kotlin.ranges.IntRange r11 = r11.getArgumentRange()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            boolean r12 = r11 instanceof java.util.Collection
            if (r12 == 0) goto L_0x0218
            r12 = r11
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0218
            goto L_0x023b
        L_0x0218:
            java.util.Iterator r11 = r11.iterator()
        L_0x021c:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x023b
            r12 = r11
            kotlin.collections.IntIterator r12 = (kotlin.collections.IntIterator) r12
            int r12 = r12.nextInt()
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$BoxUnboxData r13 = r10.data
            java.util.List[] r13 = r13.getUnboxParameters()
            r12 = r13[r12]
            if (r12 != 0) goto L_0x0234
            goto L_0x021c
        L_0x0234:
            int r12 = r12.size()
            if (r12 <= r2) goto L_0x021c
            r1 = r2
        L_0x023b:
            r10.hasMfvcParameters = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    public M getMember() {
        return this.member;
    }

    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unboxParameters", "", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/util/List;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnboxParameters", "()[Ljava/util/List;", "[Ljava/util/List;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ValueClassAwareCaller.kt */
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final List<Method>[] unboxParameters;

        public BoxUnboxData(IntRange intRange, List<Method>[] listArr, Method method) {
            Intrinsics.checkNotNullParameter(intRange, "argumentRange");
            Intrinsics.checkNotNullParameter(listArr, "unboxParameters");
            this.argumentRange = intRange;
            this.unboxParameters = listArr;
            this.box = method;
        }

        public final IntRange getArgumentRange() {
            return this.argumentRange;
        }

        public final Method getBox() {
            return this.box;
        }

        public final List<Method>[] getUnboxParameters() {
            return this.unboxParameters;
        }
    }

    private static final int data$lambda$3$typeSize(KotlinType kotlinType) {
        List<Method> mfvcUnboxMethods = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType(kotlinType));
        if (mfvcUnboxMethods != null) {
            return mfvcUnboxMethods.size();
        }
        return 1;
    }

    public final IntRange getRealSlicesOfParameters(int i) {
        IntRange intRange;
        if (i >= 0) {
            IntRange[] intRangeArr = this.slices;
            if (i < intRangeArr.length) {
                return intRangeArr[i];
            }
        }
        IntRange[] intRangeArr2 = this.slices;
        if (intRangeArr2.length == 0) {
            intRange = new IntRange(i, i);
        } else {
            int length = (i - intRangeArr2.length) + ((IntRange) ArraysKt.last((T[]) intRangeArr2)).getLast() + 1;
            intRange = new IntRange(length, length);
        }
        return intRange;
    }

    public Object call(Object[] objArr) {
        Object invoke;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(objArr, "args");
        IntRange argumentRange = this.data.getArgumentRange();
        List[] unboxParameters = this.data.getUnboxParameters();
        Method box = this.data.getBox();
        if (!argumentRange.isEmpty()) {
            if (this.hasMfvcParameters) {
                List createListBuilder = CollectionsKt.createListBuilder(objArr.length);
                int first = argumentRange.getFirst();
                for (int i = 0; i < first; i++) {
                    createListBuilder.add(objArr[i]);
                }
                int first2 = argumentRange.getFirst();
                int last = argumentRange.getLast();
                if (first2 <= last) {
                    while (true) {
                        List<Method> list = unboxParameters[first2];
                        Object obj3 = objArr[first2];
                        if (list != null) {
                            for (Method method : list) {
                                Collection collection = createListBuilder;
                                if (obj3 != null) {
                                    obj2 = method.invoke(obj3, (Object[]) null);
                                } else {
                                    Class<?> returnType = method.getReturnType();
                                    Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
                                    obj2 = UtilKt.defaultPrimitiveValue(returnType);
                                }
                                collection.add(obj2);
                            }
                            Collection collection2 = createListBuilder;
                        } else {
                            createListBuilder.add(obj3);
                        }
                        if (first2 == last) {
                            break;
                        }
                        first2++;
                    }
                }
                int last2 = argumentRange.getLast() + 1;
                int lastIndex = ArraysKt.getLastIndex((T[]) objArr);
                if (last2 <= lastIndex) {
                    while (true) {
                        createListBuilder.add(objArr[last2]);
                        if (last2 == lastIndex) {
                            break;
                        }
                        last2++;
                    }
                }
                objArr = CollectionsKt.build(createListBuilder).toArray(new Object[0]);
            } else {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int first3 = argumentRange.getFirst();
                    if (i2 > argumentRange.getLast() || first3 > i2) {
                        obj = objArr[i2];
                    } else {
                        List list2 = unboxParameters[i2];
                        Method method2 = list2 != null ? (Method) CollectionsKt.single(list2) : null;
                        obj = objArr[i2];
                        if (method2 != null) {
                            if (obj != null) {
                                obj = method2.invoke(obj, (Object[]) null);
                            } else {
                                Class<?> returnType2 = method2.getReturnType();
                                Intrinsics.checkNotNullExpressionValue(returnType2, "getReturnType(...)");
                                obj = UtilKt.defaultPrimitiveValue(returnType2);
                            }
                        }
                    }
                    objArr2[i2] = obj;
                }
                objArr = objArr2;
            }
        }
        Object call = this.caller.call(objArr);
        return (call == IntrinsicsKt.getCOROUTINE_SUSPENDED() || box == null || (invoke = box.invoke((Object) null, new Object[]{call})) == null) ? call : invoke;
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0016¢\u0006\u0002\u0010\"R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$MultiFieldValueClassPrimaryConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "constructorDesc", "", "originalParameters", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/util/List;)V", "boxMethod", "Ljava/lang/reflect/Method;", "constructorImpl", "member", "getMember", "()Ljava/lang/Void;", "originalParametersGroups", "Ljava/lang/Class;", "getOriginalParametersGroups", "()Ljava/util/List;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "parameterUnboxMethods", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ValueClassAwareCaller.kt */
    public static final class MultiFieldValueClassPrimaryConstructorCaller implements Caller {
        private final Method boxMethod;
        private final Method constructorImpl;
        private final List<List<Class<?>>> originalParametersGroups;
        private final List<Type> parameterTypes;
        private final List<List<Method>> parameterUnboxMethods;

        public Void getMember() {
            return null;
        }

        public MultiFieldValueClassPrimaryConstructorCaller(FunctionDescriptor functionDescriptor, KDeclarationContainerImpl kDeclarationContainerImpl, String str, List<? extends ParameterDescriptor> list) {
            List<?> list2;
            Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
            Intrinsics.checkNotNullParameter(str, "constructorDesc");
            Intrinsics.checkNotNullParameter(list, "originalParameters");
            Method findMethodBySignature = kDeclarationContainerImpl.findMethodBySignature("constructor-impl", str);
            Intrinsics.checkNotNull(findMethodBySignature);
            this.constructorImpl = findMethodBySignature;
            Method findMethodBySignature2 = kDeclarationContainerImpl.findMethodBySignature("box-impl", StringsKt.removeSuffix(str, (CharSequence) "V") + ReflectClassUtilKt.getDesc(kDeclarationContainerImpl.getJClass()));
            Intrinsics.checkNotNull(findMethodBySignature2);
            this.boxMethod = findMethodBySignature2;
            Iterable<ParameterDescriptor> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ParameterDescriptor type : iterable) {
                KotlinType type2 = type.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                arrayList.add(ValueClassAwareCallerKt.getValueClassUnboxMethods(TypeSubstitutionKt.asSimpleType(type2), functionDescriptor));
            }
            this.parameterUnboxMethods = (List) arrayList;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            int i = 0;
            for (Object next : iterable) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ClassifierDescriptor declarationDescriptor = ((ParameterDescriptor) next).getType().getConstructor().getDeclarationDescriptor();
                Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                List list3 = this.parameterUnboxMethods.get(i);
                if (list3 != null) {
                    Iterable<Method> iterable2 = list3;
                    Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                    for (Method returnType : iterable2) {
                        arrayList3.add(returnType.getReturnType());
                    }
                    list2 = (List) arrayList3;
                } else {
                    Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
                    Intrinsics.checkNotNull(javaClass);
                    list2 = CollectionsKt.listOf(javaClass);
                }
                arrayList2.add(list2);
                i = i2;
            }
            List<List<Class<?>>> list4 = (List) arrayList2;
            this.originalParametersGroups = list4;
            this.parameterTypes = CollectionsKt.flatten(list4);
        }

        public Type getReturnType() {
            Class<?> returnType = this.boxMethod.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
            return returnType;
        }

        public final List<List<Class<?>>> getOriginalParametersGroups() {
            return this.originalParametersGroups;
        }

        public List<Type> getParameterTypes() {
            return this.parameterTypes;
        }

        public Object call(Object[] objArr) {
            List list;
            Intrinsics.checkNotNullParameter(objArr, "args");
            Collection arrayList = new ArrayList();
            for (Pair pair : ArraysKt.zip((T[]) objArr, this.parameterUnboxMethods)) {
                Object component1 = pair.component1();
                List list2 = (List) pair.component2();
                if (list2 != null) {
                    Iterable<Method> iterable = list2;
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (Method invoke : iterable) {
                        arrayList2.add(invoke.invoke(component1, (Object[]) null));
                    }
                    list = (List) arrayList2;
                } else {
                    list = CollectionsKt.listOf(component1);
                }
                CollectionsKt.addAll(arrayList, list);
            }
            Object[] array = ((List) arrayList).toArray(new Object[0]);
            this.constructorImpl.invoke((Object) null, Arrays.copyOf(array, array.length));
            return this.boxMethod.invoke((Object) null, Arrays.copyOf(array, array.length));
        }
    }
}
