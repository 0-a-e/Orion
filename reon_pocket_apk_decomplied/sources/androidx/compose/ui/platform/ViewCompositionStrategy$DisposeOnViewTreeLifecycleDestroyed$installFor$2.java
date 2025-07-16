package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewCompositionStrategy.android.kt */
final class ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<Function0<Unit>> $disposer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2(Ref.ObjectRef<Function0<Unit>> objectRef) {
        super(0);
        this.$disposer = objectRef;
    }

    public final void invoke() {
        ((Function0) this.$disposer.element).invoke();
    }
}
