package androidx.compose.material3;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.android.kt */
final class Tooltip_androidKt$drawCaretWithPath$4 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ LayoutCoordinates $anchorLayoutCoordinates;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Path $path;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Tooltip_androidKt$drawCaretWithPath$4(LayoutCoordinates layoutCoordinates, Path path, long j) {
        super(1);
        this.$anchorLayoutCoordinates = layoutCoordinates;
        this.$path = path;
        this.$containerColor = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        if (this.$anchorLayoutCoordinates != null) {
            contentDrawScope.drawContent();
            DrawScope.CC.m4466drawPathLG529CI$default(contentDrawScope, this.$path, this.$containerColor, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
    }
}
