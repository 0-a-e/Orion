package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class ScrollKt$scroll$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ FlingBehavior $flingBehavior$inlined;
    final /* synthetic */ boolean $isScrollable$inlined;
    final /* synthetic */ boolean $isVertical$inlined;
    final /* synthetic */ boolean $reverseScrolling$inlined;
    final /* synthetic */ ScrollState $state$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollKt$scroll$$inlined$debugInspectorInfo$1(ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, boolean z3) {
        super(1);
        this.$state$inlined = scrollState;
        this.$reverseScrolling$inlined = z;
        this.$flingBehavior$inlined = flingBehavior;
        this.$isScrollable$inlined = z2;
        this.$isVertical$inlined = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("scroll");
        inspectorInfo.getProperties().set("state", this.$state$inlined);
        inspectorInfo.getProperties().set("reverseScrolling", Boolean.valueOf(this.$reverseScrolling$inlined));
        inspectorInfo.getProperties().set("flingBehavior", this.$flingBehavior$inlined);
        inspectorInfo.getProperties().set("isScrollable", Boolean.valueOf(this.$isScrollable$inlined));
        inspectorInfo.getProperties().set("isVertical", Boolean.valueOf(this.$isVertical$inlined));
    }
}
