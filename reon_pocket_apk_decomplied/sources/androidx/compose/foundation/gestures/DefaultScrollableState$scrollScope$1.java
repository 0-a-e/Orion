package androidx.compose.foundation.gestures;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"androidx/compose/foundation/gestures/DefaultScrollableState$scrollScope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScrollableState.kt */
public final class DefaultScrollableState$scrollScope$1 implements ScrollScope {
    final /* synthetic */ DefaultScrollableState this$0;

    DefaultScrollableState$scrollScope$1(DefaultScrollableState defaultScrollableState) {
        this.this$0 = defaultScrollableState;
    }

    public float scrollBy(float f) {
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        return this.this$0.getOnDelta().invoke(Float.valueOf(f)).floatValue();
    }
}
