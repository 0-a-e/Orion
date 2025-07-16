package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$4$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ State<Float> $firstLineHead;
    final /* synthetic */ State<Float> $firstLineTail;
    final /* synthetic */ State<Float> $secondLineHead;
    final /* synthetic */ State<Float> $secondLineTail;
    final /* synthetic */ int $strokeCap;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$4$1(long j, int i, State<Float> state, State<Float> state2, long j2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$trackColor = j;
        this.$strokeCap = i;
        this.$firstLineHead = state;
        this.$firstLineTail = state2;
        this.$color = j2;
        this.$secondLineHead = state3;
        this.$secondLineTail = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        float r0 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc());
        ProgressIndicatorKt.m2080drawLinearIndicatorTrackAZGd3zU(drawScope, this.$trackColor, r0, this.$strokeCap);
        if (this.$firstLineHead.getValue().floatValue() - this.$firstLineTail.getValue().floatValue() > 0.0f) {
            ProgressIndicatorKt.m2079drawLinearIndicatorqYKTg0g(drawScope, this.$firstLineHead.getValue().floatValue(), this.$firstLineTail.getValue().floatValue(), this.$color, r0, this.$strokeCap);
        }
        if (this.$secondLineHead.getValue().floatValue() - this.$secondLineTail.getValue().floatValue() > 0.0f) {
            ProgressIndicatorKt.m2079drawLinearIndicatorqYKTg0g(drawScope, this.$secondLineHead.getValue().floatValue(), this.$secondLineTail.getValue().floatValue(), this.$color, r0, this.$strokeCap);
        }
    }
}
