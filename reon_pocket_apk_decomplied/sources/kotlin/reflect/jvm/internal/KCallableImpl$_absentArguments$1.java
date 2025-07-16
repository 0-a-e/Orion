package kotlin.reflect.jvm.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.ReflectJvmMapping;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u0003*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "R", "invoke", "()[Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$_absentArguments$1 extends Lambda implements Function0<Object[]> {
    final /* synthetic */ KCallableImpl<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KCallableImpl$_absentArguments$1(KCallableImpl<? extends R> kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    public final Object[] invoke() {
        int i;
        List<KParameter> parameters = this.this$0.getParameters();
        int size = parameters.size() + (this.this$0.isSuspend() ? 1 : 0);
        if (((Boolean) this.this$0.parametersNeedMFVCFlattening.getValue()).booleanValue()) {
            KCallableImpl<R> kCallableImpl = this.this$0;
            i = 0;
            for (KParameter kParameter : parameters) {
                i += kParameter.getKind() == KParameter.Kind.VALUE ? kCallableImpl.getParameterTypeSize(kParameter) : 0;
            }
        } else {
            Iterable<KParameter> iterable = parameters;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                i = 0;
                for (KParameter kind : iterable) {
                    if (kind.getKind() == KParameter.Kind.VALUE && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i = 0;
            }
        }
        int i2 = (i + 31) / 32;
        Object[] objArr = new Object[(size + i2 + 1)];
        KCallableImpl<R> kCallableImpl2 = this.this$0;
        for (KParameter kParameter2 : parameters) {
            if (kParameter2.isOptional() && !UtilKt.isInlineClassType(kParameter2.getType())) {
                objArr[kParameter2.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(kParameter2.getType()));
            } else if (kParameter2.isVararg()) {
                objArr[kParameter2.getIndex()] = kCallableImpl2.defaultEmptyArray(kParameter2.getType());
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[size + i3] = 0;
        }
        return objArr;
    }
}
