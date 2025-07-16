package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformedTextFieldState.kt */
final class TransformedTextFieldState$collectImeNotifications$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ TextFieldState.NotifyImeListener $notifyImeListener;
    final /* synthetic */ TransformedTextFieldState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformedTextFieldState$collectImeNotifications$2$1(TransformedTextFieldState transformedTextFieldState, TextFieldState.NotifyImeListener notifyImeListener) {
        super(1);
        this.this$0 = transformedTextFieldState;
        this.$notifyImeListener = notifyImeListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.this$0.textFieldState.removeNotifyImeListener$foundation_release(this.$notifyImeListener);
    }
}
