package androidx.compose.material3;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$Scrim$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ Function0<Float> $fraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$Scrim$1$1(long j, Function0<Float> function0) {
        super(1);
        this.$color = j;
        this.$fraction = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope, this.$color, 0, 0, this.$fraction.invoke().floatValue(), (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
    }
}
