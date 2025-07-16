package androidx.compose.ui.platform;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "rn", "Landroidx/compose/ui/platform/DeviceRenderNode;", "matrix", "Landroid/graphics/Matrix;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RenderNodeLayer.android.kt */
final class RenderNodeLayer$Companion$getMatrix$1 extends Lambda implements Function2<DeviceRenderNode, Matrix, Unit> {
    public static final RenderNodeLayer$Companion$getMatrix$1 INSTANCE = new RenderNodeLayer$Companion$getMatrix$1();

    RenderNodeLayer$Companion$getMatrix$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((DeviceRenderNode) obj, (Matrix) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
        deviceRenderNode.getMatrix(matrix);
    }
}
