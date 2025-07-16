package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$focusOwner$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$focusOwner$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function0<Unit>) (Function0) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Function0<Unit> function0) {
        this.this$0.registerOnEndApplyChangesListener(function0);
    }
}
