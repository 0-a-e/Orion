package androidx.compose.foundation;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "size", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.android.kt */
final class AndroidEdgeEffectOverscrollEffect$onNewSize$1 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$onNewSize$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        super(1);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m196invokeozmzZPI(((IntSize) obj).m6794unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m196invokeozmzZPI(long j) {
        boolean z = !Size.m3627equalsimpl0(IntSizeKt.m6800toSizeozmzZPI(j), this.this$0.containerSize);
        this.this$0.containerSize = IntSizeKt.m6800toSizeozmzZPI(j);
        if (z) {
            this.this$0.topEffect.setSize(IntSize.m6790getWidthimpl(j), IntSize.m6789getHeightimpl(j));
            this.this$0.bottomEffect.setSize(IntSize.m6790getWidthimpl(j), IntSize.m6789getHeightimpl(j));
            this.this$0.leftEffect.setSize(IntSize.m6789getHeightimpl(j), IntSize.m6790getWidthimpl(j));
            this.this$0.rightEffect.setSize(IntSize.m6789getHeightimpl(j), IntSize.m6790getWidthimpl(j));
            this.this$0.topEffectNegation.setSize(IntSize.m6790getWidthimpl(j), IntSize.m6789getHeightimpl(j));
            this.this$0.bottomEffectNegation.setSize(IntSize.m6790getWidthimpl(j), IntSize.m6789getHeightimpl(j));
            this.this$0.leftEffectNegation.setSize(IntSize.m6789getHeightimpl(j), IntSize.m6790getWidthimpl(j));
            this.this$0.rightEffectNegation.setSize(IntSize.m6789getHeightimpl(j), IntSize.m6790getWidthimpl(j));
        }
        if (z) {
            this.this$0.invalidateOverscroll();
            this.this$0.animateToRelease();
        }
    }
}
