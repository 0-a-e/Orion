package androidx.compose.foundation.gestures;

import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/gestures/ScrollableKt$DefaultScrollMotionDurationScale$1", "Landroidx/compose/ui/MotionDurationScale;", "scaleFactor", "", "getScaleFactor", "()F", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollableKt$DefaultScrollMotionDurationScale$1 implements MotionDurationScale {
    public /* synthetic */ CoroutineContext.Key getKey() {
        return MotionDurationScale.CC.$default$getKey(this);
    }

    public float getScaleFactor() {
        return 1.0f;
    }

    ScrollableKt$DefaultScrollMotionDurationScale$1() {
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return MotionDurationScale.DefaultImpls.fold(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MotionDurationScale.DefaultImpls.get(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MotionDurationScale.DefaultImpls.minusKey(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
    }
}
