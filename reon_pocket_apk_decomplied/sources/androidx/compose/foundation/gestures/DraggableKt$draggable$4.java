package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$draggable$4 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ boolean $startDragImmediately;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$4(boolean z) {
        super(0);
        this.$startDragImmediately = z;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.$startDragImmediately);
    }
}
