package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingKt$absolutePadding$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $bottom;
    final /* synthetic */ float $left;
    final /* synthetic */ float $right;
    final /* synthetic */ float $top;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaddingKt$absolutePadding$1(float f, float f2, float f3, float f4) {
        super(1);
        this.$left = f;
        this.$top = f2;
        this.$right = f3;
        this.$bottom = f4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set("left", Dp.m6612boximpl(this.$left));
        inspectorInfo.getProperties().set("top", Dp.m6612boximpl(this.$top));
        inspectorInfo.getProperties().set("right", Dp.m6612boximpl(this.$right));
        inspectorInfo.getProperties().set("bottom", Dp.m6612boximpl(this.$bottom));
    }
}
