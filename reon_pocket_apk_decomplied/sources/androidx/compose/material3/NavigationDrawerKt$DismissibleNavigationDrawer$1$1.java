package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$DismissibleNavigationDrawer$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Density $density;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ float $minValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$DismissibleNavigationDrawer$1$1(DrawerState drawerState, Density density, float f, float f2) {
        super(0);
        this.$drawerState = drawerState;
        this.$density = density;
        this.$minValue = f;
        this.$maxValue = f2;
    }

    public final void invoke() {
        this.$drawerState.setDensity$material3_release(this.$density);
        AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = this.$drawerState.getAnchoredDraggableState$material3_release();
        final float f = this.$minValue;
        final float f2 = this.$maxValue;
        AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DraggableAnchorsConfig<DrawerValue>) (DraggableAnchorsConfig) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                draggableAnchorsConfig.at(DrawerValue.Closed, f);
                draggableAnchorsConfig.at(DrawerValue.Open, f2);
            }
        }), (Object) null, 2, (Object) null);
    }
}
