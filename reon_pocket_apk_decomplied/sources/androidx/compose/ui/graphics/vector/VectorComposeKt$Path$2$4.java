package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/vector/PathComponent;", "it", "Landroidx/compose/ui/graphics/Brush;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Path$2$4 extends Lambda implements Function2<PathComponent, Brush, Unit> {
    public static final VectorComposeKt$Path$2$4 INSTANCE = new VectorComposeKt$Path$2$4();

    VectorComposeKt$Path$2$4() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PathComponent) obj, (Brush) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(PathComponent pathComponent, Brush brush) {
        pathComponent.setFill(brush);
    }
}
