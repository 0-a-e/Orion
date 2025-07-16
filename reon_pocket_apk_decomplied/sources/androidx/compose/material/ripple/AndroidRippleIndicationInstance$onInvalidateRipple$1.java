package androidx.compose.material.ripple;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Ripple.android.kt */
final class AndroidRippleIndicationInstance$onInvalidateRipple$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidRippleIndicationInstance this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidRippleIndicationInstance$onInvalidateRipple$1(AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        super(0);
        this.this$0 = androidRippleIndicationInstance;
    }

    public final void invoke() {
        AndroidRippleIndicationInstance androidRippleIndicationInstance = this.this$0;
        androidRippleIndicationInstance.setInvalidateTick(!androidRippleIndicationInstance.getInvalidateTick());
    }
}
