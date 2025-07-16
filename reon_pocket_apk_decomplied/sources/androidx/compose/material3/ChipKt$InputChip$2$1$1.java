package androidx.compose.material3;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$InputChip$2$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ float $avatarOpacity;
    final /* synthetic */ Shape $avatarShape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$InputChip$2$1$1(float f, Shape shape) {
        super(1);
        this.$avatarOpacity = f;
        this.$avatarShape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(this.$avatarOpacity);
        graphicsLayerScope.setShape(this.$avatarShape);
        graphicsLayerScope.setClip(true);
    }
}
