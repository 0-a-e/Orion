package androidx.compose.material3;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Divider.kt */
final class DividerKt$HorizontalDivider$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ float $thickness;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DividerKt$HorizontalDivider$1$1(float f, long j) {
        super(1);
        this.$thickness = f;
        this.$color = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        float r8 = drawScope2.m6550toPx0680j_4(this.$thickness);
        float f = (float) 2;
        DrawScope.CC.m4462drawLineNGM6Ib0$default(drawScope2, this.$color, OffsetKt.Offset(0.0f, drawScope2.m6550toPx0680j_4(this.$thickness) / f), OffsetKt.Offset(Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()), drawScope2.m6550toPx0680j_4(this.$thickness) / f), r8, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }
}
