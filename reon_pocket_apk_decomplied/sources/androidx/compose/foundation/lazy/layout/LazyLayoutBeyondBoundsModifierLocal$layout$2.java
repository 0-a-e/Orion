package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$layout$2", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "hasMoreContent", "", "getHasMoreContent", "()Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
public final class LazyLayoutBeyondBoundsModifierLocal$layout$2 implements BeyondBoundsLayout.BeyondBoundsScope {
    final /* synthetic */ int $direction;
    final /* synthetic */ Ref.ObjectRef<LazyLayoutBeyondBoundsInfo.Interval> $interval;
    final /* synthetic */ LazyLayoutBeyondBoundsModifierLocal this$0;

    LazyLayoutBeyondBoundsModifierLocal$layout$2(LazyLayoutBeyondBoundsModifierLocal lazyLayoutBeyondBoundsModifierLocal, Ref.ObjectRef<LazyLayoutBeyondBoundsInfo.Interval> objectRef, int i) {
        this.this$0 = lazyLayoutBeyondBoundsModifierLocal;
        this.$interval = objectRef;
        this.$direction = i;
    }

    public boolean getHasMoreContent() {
        return this.this$0.m864hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) this.$interval.element, this.$direction);
    }
}
