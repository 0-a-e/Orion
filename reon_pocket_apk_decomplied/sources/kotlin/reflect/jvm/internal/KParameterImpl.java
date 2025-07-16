package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00013B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ!\u0010)\u001a\u00020*2\u0012\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0,\"\u00020*H\u0002¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00064"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "compoundType", "Ljava/lang/reflect/Type;", "types", "", "([Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", "equals", "other", "", "hashCode", "toString", "CompoundTypeImpl", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: KParameterImpl.kt */
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final ReflectProperties.LazySoftVal annotations$delegate = ReflectProperties.lazySoft(new KParameterImpl$annotations$2(this));
    private final KCallableImpl<?> callable;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final int index;
    private final KParameter.Kind kind;

    public KParameterImpl(KCallableImpl<?> kCallableImpl, int i, KParameter.Kind kind2, Function0<? extends ParameterDescriptor> function0) {
        Intrinsics.checkNotNullParameter(kCallableImpl, "callable");
        Intrinsics.checkNotNullParameter(kind2, "kind");
        Intrinsics.checkNotNullParameter(function0, "computeDescriptor");
        this.callable = kCallableImpl;
        this.index = i;
        this.kind = kind2;
        this.descriptor$delegate = ReflectProperties.lazySoft(function0);
    }

    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    public int getIndex() {
        return this.index;
    }

    public KParameter.Kind getKind() {
        return this.kind;
    }

    static {
        Class<KParameterImpl> cls = KParameterImpl.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    /* access modifiers changed from: private */
    public final ParameterDescriptor getDescriptor() {
        Object value = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ParameterDescriptor) value;
    }

    public List<Annotation> getAnnotations() {
        Object value = this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (List) value;
    }

    public String getName() {
        ParameterDescriptor descriptor = getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    /* access modifiers changed from: private */
    public final Type compoundType(Type... typeArr) {
        int length = typeArr.length;
        if (length == 0) {
            throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
        } else if (length != 1) {
            return new CompoundTypeImpl(typeArr);
        } else {
            return (Type) ArraysKt.single((T[]) typeArr);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl$CompoundTypeImpl;", "Ljava/lang/reflect/Type;", "types", "", "([Ljava/lang/reflect/Type;)V", "hashCode", "", "getTypes", "()[Ljava/lang/reflect/Type;", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getTypeName", "", "toString", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: KParameterImpl.kt */
    private static final class CompoundTypeImpl implements Type {
        private final int hashCode;
        private final Type[] types;

        public CompoundTypeImpl(Type[] typeArr) {
            Intrinsics.checkNotNullParameter(typeArr, "types");
            this.types = typeArr;
            this.hashCode = Arrays.hashCode(typeArr);
        }

        public String getTypeName() {
            return ArraysKt.joinToString$default((Object[]) this.types, (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        }

        public boolean equals(Object obj) {
            return (obj instanceof CompoundTypeImpl) && Arrays.equals(this.types, ((CompoundTypeImpl) obj).types);
        }

        public int hashCode() {
            return this.hashCode;
        }

        public String toString() {
            return getTypeName();
        }
    }

    public KType getType() {
        KotlinType type = getDescriptor().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return new KTypeImpl(type, new KParameterImpl$type$1(this));
    }

    public boolean isOptional() {
        ParameterDescriptor descriptor = getDescriptor();
        ValueParameterDescriptor valueParameterDescriptor = descriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) descriptor : null;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    public boolean isVararg() {
        ParameterDescriptor descriptor = getDescriptor();
        return (descriptor instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) descriptor).getVarargElementType() != null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            return Intrinsics.areEqual((Object) this.callable, (Object) kParameterImpl.callable) && getIndex() == kParameterImpl.getIndex();
        }
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + getIndex();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
