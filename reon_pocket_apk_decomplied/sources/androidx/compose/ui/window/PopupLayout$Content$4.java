package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class PopupLayout$Content$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ PopupLayout $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupLayout$Content$4(PopupLayout popupLayout, int i) {
        super(2);
        this.$tmp0_rcvr = popupLayout;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.Content(composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
