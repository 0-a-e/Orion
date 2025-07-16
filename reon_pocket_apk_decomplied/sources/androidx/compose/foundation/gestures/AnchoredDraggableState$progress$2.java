package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "T", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$progress$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$progress$2(AnchoredDraggableState<T> anchoredDraggableState) {
        super(0);
        this.this$0 = anchoredDraggableState;
    }

    public final Float invoke() {
        float positionOf = this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue());
        float positionOf2 = this.this$0.getAnchors().positionOf(this.this$0.getClosestValue$foundation_release()) - positionOf;
        float abs = Math.abs(positionOf2);
        float f = 1.0f;
        if (!Float.isNaN(abs) && abs > 1.0E-6f) {
            float requireOffset = (this.this$0.requireOffset() - positionOf) / positionOf2;
            if (requireOffset < 1.0E-6f) {
                f = 0.0f;
            } else if (requireOffset <= 0.999999f) {
                f = requireOffset;
            }
        }
        return Float.valueOf(f);
    }
}
