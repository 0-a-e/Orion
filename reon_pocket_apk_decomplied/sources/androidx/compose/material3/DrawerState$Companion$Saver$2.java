package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material3/DrawerState;", "it", "Landroidx/compose/material3/DrawerValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class DrawerState$Companion$Saver$2 extends Lambda implements Function1<DrawerValue, DrawerState> {
    final /* synthetic */ Function1<DrawerValue, Boolean> $confirmStateChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerState$Companion$Saver$2(Function1<? super DrawerValue, Boolean> function1) {
        super(1);
        this.$confirmStateChange = function1;
    }

    public final DrawerState invoke(DrawerValue drawerValue) {
        return new DrawerState(drawerValue, this.$confirmStateChange);
    }
}
