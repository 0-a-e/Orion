package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class AbstractClickablePointerInputNode$delayPressInteraction$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ AbstractClickablePointerInputNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractClickablePointerInputNode$delayPressInteraction$1(AbstractClickablePointerInputNode abstractClickablePointerInputNode) {
        super(0);
        this.this$0 = abstractClickablePointerInputNode;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(((Boolean) this.this$0.getCurrent(ScrollableKt.getModifierLocalScrollableContainer())).booleanValue() || Clickable_androidKt.isComposeRootInScrollableContainer(this.this$0));
    }
}
