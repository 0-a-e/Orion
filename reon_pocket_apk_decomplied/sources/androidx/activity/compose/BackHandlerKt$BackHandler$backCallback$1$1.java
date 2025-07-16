package androidx.activity.compose;

import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/activity/compose/BackHandlerKt$BackHandler$backCallback$1$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackHandler.kt */
public final class BackHandlerKt$BackHandler$backCallback$1$1 extends OnBackPressedCallback {
    final /* synthetic */ State<Function0<Unit>> $currentOnBack$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackHandlerKt$BackHandler$backCallback$1$1(boolean z, State<? extends Function0<Unit>> state) {
        super(z);
        this.$currentOnBack$delegate = state;
    }

    public void handleOnBackPressed() {
        BackHandlerKt.BackHandler$lambda$0(this.$currentOnBack$delegate).invoke();
    }
}
