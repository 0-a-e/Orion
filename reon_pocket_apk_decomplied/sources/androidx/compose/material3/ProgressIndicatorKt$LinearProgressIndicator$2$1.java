package androidx.compose.material3;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ Function0<Float> $coercedProgress;
    final /* synthetic */ long $color;
    final /* synthetic */ int $strokeCap;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$2$1(long j, int i, Function0<Float> function0, long j2) {
        super(1);
        this.$trackColor = j;
        this.$strokeCap = i;
        this.$coercedProgress = function0;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        float r7 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc());
        ProgressIndicatorKt.m2080drawLinearIndicatorTrackAZGd3zU(drawScope, this.$trackColor, r7, this.$strokeCap);
        ProgressIndicatorKt.m2079drawLinearIndicatorqYKTg0g(drawScope, 0.0f, this.$coercedProgress.invoke().floatValue(), this.$color, r7, this.$strokeCap);
    }
}
