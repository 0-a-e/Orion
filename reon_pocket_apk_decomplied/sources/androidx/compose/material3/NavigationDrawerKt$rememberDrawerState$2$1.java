package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/DrawerState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$rememberDrawerState$2$1 extends Lambda implements Function0<DrawerState> {
    final /* synthetic */ Function1<DrawerValue, Boolean> $confirmStateChange;
    final /* synthetic */ DrawerValue $initialValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$rememberDrawerState$2$1(DrawerValue drawerValue, Function1<? super DrawerValue, Boolean> function1) {
        super(0);
        this.$initialValue = drawerValue;
        this.$confirmStateChange = function1;
    }

    public final DrawerState invoke() {
        return new DrawerState(this.$initialValue, this.$confirmStateChange);
    }
}
