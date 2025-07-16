package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
final class MenuKt$DropdownMenuContent$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ State<Float> $scale$delegate;
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuContent$1$1(MutableState<TransformOrigin> mutableState, State<Float> state, State<Float> state2) {
        super(1);
        this.$transformOriginState = mutableState;
        this.$scale$delegate = state;
        this.$alpha$delegate = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setScaleX(MenuKt.DropdownMenuContent$lambda$1(this.$scale$delegate));
        graphicsLayerScope.setScaleY(MenuKt.DropdownMenuContent$lambda$1(this.$scale$delegate));
        graphicsLayerScope.setAlpha(MenuKt.DropdownMenuContent$lambda$3(this.$alpha$delegate));
        graphicsLayerScope.m3991setTransformOrigin__ExYCQ(this.$transformOriginState.getValue().m4268unboximpl());
    }
}
