package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$4$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Float> $baseRotation;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Integer> $currentRotation;
    final /* synthetic */ State<Float> $endAngle;
    final /* synthetic */ State<Float> $startAngle;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$4$1(long j, Stroke stroke, State<Integer> state, State<Float> state2, State<Float> state3, State<Float> state4, float f, long j2) {
        super(1);
        this.$trackColor = j;
        this.$stroke = stroke;
        this.$currentRotation = state;
        this.$endAngle = state2;
        this.$startAngle = state3;
        this.$baseRotation = state4;
        this.$strokeWidth = f;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        ProgressIndicatorKt.m2076drawCircularIndicatorTrackbw27NRU(drawScope, this.$trackColor, this.$stroke);
        DrawScope drawScope2 = drawScope;
        ProgressIndicatorKt.m2078drawIndeterminateCircularIndicatorhrjfTZI(drawScope2, this.$startAngle.getValue().floatValue() + (((this.$currentRotation.getValue().floatValue() * 216.0f) % 360.0f) - 0.049804688f) + this.$baseRotation.getValue().floatValue(), this.$strokeWidth, Math.abs(this.$endAngle.getValue().floatValue() - this.$startAngle.getValue().floatValue()), this.$color, this.$stroke);
    }
}
