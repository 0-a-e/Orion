package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/MotionDurationScaleImpl;", "Landroidx/compose/ui/MotionDurationScale;", "()V", "<set-?>", "", "scaleFactor", "getScaleFactor", "()F", "setScaleFactor", "(F)V", "scaleFactor$delegate", "Landroidx/compose/runtime/MutableFloatState;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
final class MotionDurationScaleImpl implements MotionDurationScale {
    private final MutableFloatState scaleFactor$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);

    public /* synthetic */ CoroutineContext.Key getKey() {
        return MotionDurationScale.CC.$default$getKey(this);
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

    public float getScaleFactor() {
        return this.scaleFactor$delegate.getFloatValue();
    }

    public void setScaleFactor(float f) {
        this.scaleFactor$delegate.setFloatValue(f);
    }
}
