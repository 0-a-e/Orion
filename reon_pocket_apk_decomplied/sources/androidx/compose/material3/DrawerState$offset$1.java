package androidx.compose.material3;

import androidx.compose.runtime.State;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/compose/material3/DrawerState$offset$1", "Landroidx/compose/runtime/State;", "", "value", "getValue", "()Ljava/lang/Float;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class DrawerState$offset$1 implements State<Float> {
    final /* synthetic */ DrawerState this$0;

    DrawerState$offset$1(DrawerState drawerState) {
        this.this$0 = drawerState;
    }

    public Float getValue() {
        return Float.valueOf(this.this$0.getAnchoredDraggableState$material3_release().getOffset());
    }
}
