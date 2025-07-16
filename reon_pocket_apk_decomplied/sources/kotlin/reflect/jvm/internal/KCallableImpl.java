package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u0010<\u001a\u00028\u00002\u0016\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010>J#\u0010?\u001a\u00028\u00002\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0@H\u0002¢\u0006\u0002\u0010AJ#\u0010B\u001a\u00028\u00002\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0@H\u0016¢\u0006\u0002\u0010AJ3\u0010C\u001a\u00028\u00002\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0@2\f\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010EH\u0000¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u000202H\u0002J\n\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0015\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010MJ\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000fH\u0002R,\u0010\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b \t*\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R>\u0010\r\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u000f \t*\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00100\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00120\u00120\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0014 \t*\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b0\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(R\u0014\u0010)\u001a\u00020'8DX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010(R\u0012\u0010*\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0017R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020'00X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0002028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0017R\u0016\u00108\u001a\u0004\u0018\u0001098VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_absentArguments", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_annotations", "", "", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "Lkotlin/collections/ArrayList;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "parametersNeedMFVCFlattening", "Lkotlin/Lazy;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "getAbsentArguments", "()[Ljava/lang/Object;", "getParameterTypeSize", "", "parameter", "kotlin-reflection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: KCallableImpl.kt */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;
    /* access modifiers changed from: private */
    public final Lazy<Boolean> parametersNeedMFVCFlattening = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KCallableImpl$parametersNeedMFVCFlattening$1(this));

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new KCallableImpl$_annotations$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft(...)");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new KCallableImpl$_parameters$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "lazySoft(...)");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new KCallableImpl$_returnType$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "lazySoft(...)");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new KCallableImpl$_typeParameters$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "lazySoft(...)");
        this._typeParameters = lazySoft4;
        ReflectProperties.LazySoftVal<Object[]> lazySoft5 = ReflectProperties.lazySoft(new KCallableImpl$_absentArguments$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft5, "lazySoft(...)");
        this._absentArguments = lazySoft5;
    }

    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    public KType getReturnType() {
        KTypeImpl invoke = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }

    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        return UtilKt.toKVisibility(visibility);
    }

    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    /* access modifiers changed from: protected */
    public final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual((Object) getName(), (Object) "<init>") && getContainer().getJClass().isAnnotation();
    }

    public R call(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        try {
            return getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    public R callBy(Map<KParameter, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "args");
        return isAnnotationConstructor() ? callAnnotationConstructor(map) : callDefaultMethod$kotlin_reflection(map, (Continuation<?>) null);
    }

    private final Object[] getAbsentArguments() {
        return (Object[]) this._absentArguments.invoke().clone();
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> map, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(map, "args");
        List<KParameter> parameters = getParameters();
        boolean z = false;
        if (parameters.isEmpty()) {
            try {
                return getCaller().call(isSuspend() ? new Continuation[]{continuation} : new Continuation[0]);
            } catch (IllegalAccessException e) {
                throw new IllegalCallableAccessException(e);
            }
        } else {
            int size = parameters.size() + (isSuspend() ? 1 : 0);
            Object[] absentArguments = getAbsentArguments();
            if (isSuspend()) {
                absentArguments[parameters.size()] = continuation;
            }
            boolean booleanValue = this.parametersNeedMFVCFlattening.getValue().booleanValue();
            int i = 0;
            for (KParameter next : parameters) {
                int parameterTypeSize = booleanValue ? getParameterTypeSize(next) : 1;
                if (map.containsKey(next)) {
                    absentArguments[next.getIndex()] = map.get(next);
                } else if (next.isOptional()) {
                    if (booleanValue) {
                        int i2 = i + parameterTypeSize;
                        for (int i3 = i; i3 < i2; i3++) {
                            int i4 = (i3 / 32) + size;
                            Object obj = absentArguments[i4];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            absentArguments[i4] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i3 % 32)));
                        }
                    } else {
                        int i5 = (i / 32) + size;
                        Object obj2 = absentArguments[i5];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        absentArguments[i5] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (i % 32)));
                    }
                    z = true;
                } else if (!next.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                if (next.getKind() == KParameter.Kind.VALUE) {
                    i += parameterTypeSize;
                }
            }
            if (!z) {
                try {
                    Caller<?> caller = getCaller();
                    Object[] copyOf = Arrays.copyOf(absentArguments, size);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                    return caller.call(copyOf);
                } catch (IllegalAccessException e2) {
                    throw new IllegalCallableAccessException(e2);
                }
            } else {
                Caller<?> defaultCaller = getDefaultCaller();
                if (defaultCaller != null) {
                    try {
                        return defaultCaller.call(absentArguments);
                    } catch (IllegalAccessException e3) {
                        throw new IllegalCallableAccessException(e3);
                    }
                } else {
                    throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final int getParameterTypeSize(KParameter kParameter) {
        if (!this.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before".toString());
        } else if (!UtilKt.getNeedsMultiFieldValueClassFlattening(kParameter.getType())) {
            return 1;
        } else {
            KType type = kParameter.getType();
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            List<Method> mfvcUnboxMethods = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType(((KTypeImpl) type).getType()));
            Intrinsics.checkNotNull(mfvcUnboxMethods);
            return mfvcUnboxMethods.size();
        }
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> map) {
        Object obj;
        Iterable<KParameter> parameters = getParameters();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                obj = map.get(kParameter);
                if (obj == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                obj = null;
            } else if (kParameter.isVararg()) {
                obj = defaultEmptyArray(kParameter.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            arrayList.add(obj);
        }
        List list = (List) arrayList;
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller != null) {
            try {
                return defaultCaller.call(list.toArray(new Object[0]));
            } catch (IllegalAccessException e) {
                throw new IllegalCallableAccessException(e);
            }
        } else {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
        }
    }

    /* access modifiers changed from: private */
    public final Object defaultEmptyArray(KType kType) {
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object newInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "run(...)");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    /* access modifiers changed from: private */
    public final Type extractContinuationArgument() {
        Type[] lowerBounds;
        if (!isSuspend()) {
            return null;
        }
        Object lastOrNull = CollectionsKt.lastOrNull(getCaller().getParameterTypes());
        ParameterizedType parameterizedType = lastOrNull instanceof ParameterizedType ? (ParameterizedType) lastOrNull : null;
        if (!Intrinsics.areEqual((Object) parameterizedType != null ? parameterizedType.getRawType() : null, (Object) Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
        Object single = ArraysKt.single((T[]) (Object[]) actualTypeArguments);
        WildcardType wildcardType = single instanceof WildcardType ? (WildcardType) single : null;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) ArraysKt.first((T[]) lowerBounds);
    }
}
