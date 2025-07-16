package androidx.compose.material3;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
final class RadioButtonKt$RadioButton$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Dp> $dotRadius;
    final /* synthetic */ State<Color> $radioColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RadioButtonKt$RadioButton$2$1(State<Color> state, State<Dp> state2) {
        super(1);
        this.$radioColor = state;
        this.$dotRadius = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        float r3 = drawScope2.m6550toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
        long r10 = this.$radioColor.getValue().m3826unboximpl();
        float f = (float) 2;
        float f2 = r3 / f;
        float r12 = drawScope2.m6550toPx0680j_4(Dp.m6614constructorimpl(RadioButtonTokens.INSTANCE.m3113getIconSizeD9Ej5fM() / f)) - f2;
        DrawScope.CC.m4457drawCircleVaOC9Bg$default(drawScope, r10, r12, 0, 0.0f, new Stroke(r3, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (Object) null);
        if (Dp.m6613compareTo0680j_4(this.$dotRadius.getValue().m6628unboximpl(), Dp.m6614constructorimpl((float) 0)) > 0) {
            DrawScope.CC.m4457drawCircleVaOC9Bg$default(drawScope, this.$radioColor.getValue().m3826unboximpl(), drawScope2.m6550toPx0680j_4(this.$dotRadius.getValue().m6628unboximpl()) - f2, 0, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (Object) null);
        }
    }
}
