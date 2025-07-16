package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderKt$drawRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $rectTopLeft;
    final /* synthetic */ long $size;
    final /* synthetic */ DrawStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderKt$drawRectBorder$1(Brush brush, long j, long j2, DrawStyle drawStyle) {
        super(1);
        this.$brush = brush;
        this.$rectTopLeft = j;
        this.$size = j2;
        this.$style = drawStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.CC.m4469drawRectAsUm42w$default(contentDrawScope, this.$brush, this.$rectTopLeft, this.$size, 0.0f, this.$style, (ColorFilter) null, 0, LocationRequestCompat.QUALITY_LOW_POWER, (Object) null);
    }
}
