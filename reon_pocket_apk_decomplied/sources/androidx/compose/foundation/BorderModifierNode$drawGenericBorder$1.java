package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderModifierNode$drawGenericBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ Outline.Generic $outline;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderModifierNode$drawGenericBorder$1(Outline.Generic generic, Brush brush) {
        super(1);
        this.$outline = generic;
        this.$brush = brush;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.CC.m4465drawPathGBMwjPU$default(contentDrawScope, this.$outline.getPath(), this.$brush, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
    }
}
