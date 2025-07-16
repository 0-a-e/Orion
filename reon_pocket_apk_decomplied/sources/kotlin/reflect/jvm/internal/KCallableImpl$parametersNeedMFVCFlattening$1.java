package kotlin.reflect.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "R", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$parametersNeedMFVCFlattening$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ KCallableImpl<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KCallableImpl$parametersNeedMFVCFlattening$1(KCallableImpl<? extends R> kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    public final Boolean invoke() {
        Iterable parameters = this.this$0.getParameters();
        boolean z = false;
        if (!(parameters instanceof Collection) || !((Collection) parameters).isEmpty()) {
            Iterator it = parameters.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (UtilKt.getNeedsMultiFieldValueClassFlattening(((KParameter) it.next()).getType())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
