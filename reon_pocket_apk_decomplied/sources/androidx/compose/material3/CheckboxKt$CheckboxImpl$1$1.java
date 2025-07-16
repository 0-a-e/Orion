package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
final class CheckboxKt$CheckboxImpl$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $borderColor;
    final /* synthetic */ State<Color> $boxColor;
    final /* synthetic */ CheckDrawingCache $checkCache;
    final /* synthetic */ State<Float> $checkCenterGravitationShiftFraction;
    final /* synthetic */ State<Color> $checkColor;
    final /* synthetic */ State<Float> $checkDrawFraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckboxKt$CheckboxImpl$1$1(State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5, CheckDrawingCache checkDrawingCache) {
        super(1);
        this.$boxColor = state;
        this.$borderColor = state2;
        this.$checkColor = state3;
        this.$checkDrawFraction = state4;
        this.$checkCenterGravitationShiftFraction = state5;
        this.$checkCache = checkDrawingCache;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        float floor = (float) Math.floor((double) drawScope.m6550toPx0680j_4(CheckboxKt.StrokeWidth));
        DrawScope drawScope2 = drawScope;
        CheckboxKt.m1603drawBox1wkBAMs(drawScope2, this.$boxColor.getValue().m3826unboximpl(), this.$borderColor.getValue().m3826unboximpl(), drawScope.m6550toPx0680j_4(CheckboxKt.RadiusSize), floor);
        CheckboxKt.m1604drawCheck3IgeMak(drawScope2, this.$checkColor.getValue().m3826unboximpl(), this.$checkDrawFraction.getValue().floatValue(), this.$checkCenterGravitationShiftFraction.getValue().floatValue(), floor, this.$checkCache);
    }
}
