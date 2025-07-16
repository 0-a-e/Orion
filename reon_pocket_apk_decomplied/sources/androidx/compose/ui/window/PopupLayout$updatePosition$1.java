package androidx.compose.ui.window;

import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class PopupLayout$updatePosition$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IntRect $parentBounds;
    final /* synthetic */ long $popupContentSize;
    final /* synthetic */ Ref.LongRef $popupPosition;
    final /* synthetic */ long $windowSize;
    final /* synthetic */ PopupLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupLayout$updatePosition$1(Ref.LongRef longRef, PopupLayout popupLayout, IntRect intRect, long j, long j2) {
        super(0);
        this.$popupPosition = longRef;
        this.this$0 = popupLayout;
        this.$parentBounds = intRect;
        this.$windowSize = j;
        this.$popupContentSize = j2;
    }

    public final void invoke() {
        this.$popupPosition.element = this.this$0.getPositionProvider().m6884calculatePositionllwVHH4(this.$parentBounds, this.$windowSize, this.this$0.getParentLayoutDirection(), this.$popupContentSize);
    }
}
