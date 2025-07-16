package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$Scrim$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ long $color;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$Scrim$1$1(long j, State<Float> state) {
        super(1);
        this.$color = j;
        this.$alpha$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope, this.$color, 0, 0, ModalBottomSheet_androidKt.Scrim_3J_VO9M$lambda$5(this.$alpha$delegate), (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
    }
}
