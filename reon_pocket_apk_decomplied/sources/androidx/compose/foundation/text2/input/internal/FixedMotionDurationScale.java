package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/FixedMotionDurationScale;", "Landroidx/compose/ui/MotionDurationScale;", "()V", "scaleFactor", "", "getScaleFactor", "()F", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCoreModifier.kt */
final class FixedMotionDurationScale implements MotionDurationScale {
    public static final FixedMotionDurationScale INSTANCE = new FixedMotionDurationScale();

    public /* synthetic */ CoroutineContext.Key getKey() {
        return MotionDurationScale.CC.$default$getKey(this);
    }

    public float getScaleFactor() {
        return 1.0f;
    }

    private FixedMotionDurationScale() {
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
