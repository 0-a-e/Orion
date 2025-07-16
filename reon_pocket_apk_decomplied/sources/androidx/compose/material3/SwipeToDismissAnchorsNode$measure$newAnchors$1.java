package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/DraggableAnchorsConfig;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissAnchorsNode$measure$newAnchors$1 extends Lambda implements Function1<DraggableAnchorsConfig<SwipeToDismissBoxValue>, Unit> {
    final /* synthetic */ float $width;
    final /* synthetic */ SwipeToDismissAnchorsNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissAnchorsNode$measure$newAnchors$1(SwipeToDismissAnchorsNode swipeToDismissAnchorsNode, float f) {
        super(1);
        this.this$0 = swipeToDismissAnchorsNode;
        this.$width = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DraggableAnchorsConfig<SwipeToDismissBoxValue>) (DraggableAnchorsConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DraggableAnchorsConfig<SwipeToDismissBoxValue> draggableAnchorsConfig) {
        draggableAnchorsConfig.at(SwipeToDismissBoxValue.Settled, 0.0f);
        if (this.this$0.getEnableDismissFromStartToEnd()) {
            draggableAnchorsConfig.at(SwipeToDismissBoxValue.StartToEnd, this.$width);
        }
        if (this.this$0.getEnableDismissFromEndToStart()) {
            draggableAnchorsConfig.at(SwipeToDismissBoxValue.EndToStart, -this.$width);
        }
    }
}
