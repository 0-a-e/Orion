package androidx.compose.foundation;

import android.view.View;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Magnifier.android.kt */
final class MagnifierNode$onObservedReadsChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MagnifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierNode$onObservedReadsChanged$1(MagnifierNode magnifierNode) {
        super(0);
        this.this$0 = magnifierNode;
    }

    public final void invoke() {
        View access$getView$p = this.this$0.view;
        View view = (View) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, AndroidCompositionLocals_androidKt.getLocalView());
        this.this$0.view = view;
        Density access$getDensity$p = this.this$0.density;
        Density density = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalDensity());
        this.this$0.density = density;
        if (this.this$0.magnifier == null || !Intrinsics.areEqual((Object) view, (Object) access$getView$p) || !Intrinsics.areEqual((Object) density, (Object) access$getDensity$p)) {
            this.this$0.recreateMagnifier();
        }
        this.this$0.updateMagnifier();
    }
}
