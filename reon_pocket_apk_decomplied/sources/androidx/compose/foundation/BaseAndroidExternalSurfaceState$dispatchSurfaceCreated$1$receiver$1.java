package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003JP\u0010\b\u001a\u00020\t*\u00020\n2A\u0010\b\u001a=\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\u0011H\u0001J&\u0010\u0012\u001a\u00020\t*\u00020\n2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0011H\u0001R\u0012\u0010\u0004\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"androidx/compose/foundation/BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroidx/compose/foundation/SurfaceScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "onChanged", "", "Landroid/view/Surface;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "width", "height", "Lkotlin/ExtensionFunctionType;", "onDestroyed", "Lkotlin/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidExternalSurface.android.kt */
public final class BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 implements SurfaceCoroutineScope, SurfaceScope, CoroutineScope {
    private final /* synthetic */ BaseAndroidExternalSurfaceState $$delegate_0;
    private final /* synthetic */ CoroutineScope $$delegate_1;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_1.getCoroutineContext();
    }

    public void onChanged(Surface surface, Function3<? super Surface, ? super Integer, ? super Integer, Unit> function3) {
        this.$$delegate_0.onChanged(surface, function3);
    }

    public void onDestroyed(Surface surface, Function1<? super Surface, Unit> function1) {
        this.$$delegate_0.onDestroyed(surface, function1);
    }

    BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1(BaseAndroidExternalSurfaceState baseAndroidExternalSurfaceState, CoroutineScope coroutineScope) {
        this.$$delegate_0 = baseAndroidExternalSurfaceState;
        this.$$delegate_1 = coroutineScope;
    }
}
