package androidx.compose.material3;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ Function0<Float> $coercedProgress;
    final /* synthetic */ long $color;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$2$1(Function0<Float> function0, long j, Stroke stroke, long j2) {
        super(1);
        this.$coercedProgress = function0;
        this.$trackColor = j;
        this.$stroke = stroke;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        float floatValue = this.$coercedProgress.invoke().floatValue() * 360.0f;
        ProgressIndicatorKt.m2076drawCircularIndicatorTrackbw27NRU(drawScope, this.$trackColor, this.$stroke);
        ProgressIndicatorKt.m2077drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, this.$color, this.$stroke);
    }
}
