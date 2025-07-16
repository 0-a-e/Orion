package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "delta", "invoke-MK-Hz9U", "(J)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic$dispatchScroll$performScroll$1 extends Lambda implements Function1<Offset, Offset> {
    final /* synthetic */ int $source;
    final /* synthetic */ ScrollScope $this_dispatchScroll;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$dispatchScroll$performScroll$1(ScrollingLogic scrollingLogic, int i, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$source = i;
        this.$this_dispatchScroll = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m3551boximpl(m476invokeMKHz9U(((Offset) obj).m3572unboximpl()));
    }

    /* renamed from: invoke-MK-Hz9U  reason: not valid java name */
    public final long m476invokeMKHz9U(long j) {
        long r0 = this.this$0.nestedScrollDispatcher.m4992dispatchPreScrollOzD1aCk(j, this.$source);
        long r13 = Offset.m3566minusMKHz9U(j, r0);
        ScrollingLogic scrollingLogic = this.this$0;
        float r2 = scrollingLogic.m473toFloatk4lQ0M(scrollingLogic.m469reverseIfNeededMKHz9U(scrollingLogic.m470singleAxisOffsetMKHz9U(r13)));
        ScrollingLogic scrollingLogic2 = this.this$0;
        long r22 = scrollingLogic2.m469reverseIfNeededMKHz9U(scrollingLogic2.m474toOffsettuRUvjQ(this.$this_dispatchScroll.scrollBy(r2)));
        long j2 = r22;
        return Offset.m3567plusMKHz9U(Offset.m3567plusMKHz9U(r0, r22), this.this$0.nestedScrollDispatcher.m4990dispatchPostScrollDzOQY0M(j2, Offset.m3566minusMKHz9U(r13, r22), this.$source));
    }
}
