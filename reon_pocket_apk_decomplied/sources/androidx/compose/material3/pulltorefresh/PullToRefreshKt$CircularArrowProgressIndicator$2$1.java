package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$CircularArrowProgressIndicator$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Float> $alphaState;
    final /* synthetic */ long $color;
    final /* synthetic */ Path $path;
    final /* synthetic */ Function0<Float> $progress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$CircularArrowProgressIndicator$2$1(Function0<Float> function0, State<Float> state, long j, Path path) {
        super(1);
        this.$progress = function0;
        this.$alphaState = state;
        this.$color = j;
        this.$path = path;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        ArrowValues access$ArrowValues = PullToRefreshKt.ArrowValues(this.$progress.invoke().floatValue());
        float floatValue = this.$alphaState.getValue().floatValue();
        float rotation = access$ArrowValues.getRotation();
        long j = this.$color;
        Path path = this.$path;
        long r2 = drawScope.m4433getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r6 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4526rotateUv8p0NA(rotation, r2);
        Rect r15 = RectKt.m3601Rect3MmeM6k(SizeKt.m3641getCenteruvyYCjk(drawScope.m4434getSizeNHjbRc()), drawScope2.m6550toPx0680j_4(PullToRefreshKt.ArcRadius) + (drawScope2.m6550toPx0680j_4(PullToRefreshKt.StrokeWidth) / 2.0f));
        DrawScope drawScope3 = drawScope;
        PullToRefreshKt.m2639drawCircularIndicatorKzyDr3Q(drawScope3, j, floatValue, access$ArrowValues, r15, PullToRefreshKt.StrokeWidth);
        PullToRefreshKt.m2638drawArrowuDrxG_w(drawScope3, path, r15, j, floatValue, access$ArrowValues, PullToRefreshKt.StrokeWidth);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r6);
    }
}
