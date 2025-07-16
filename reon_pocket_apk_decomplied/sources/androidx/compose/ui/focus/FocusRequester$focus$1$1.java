package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/focus/FocusTargetNode;", "invoke", "(Landroidx/compose/ui/focus/FocusTargetNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRequester.kt */
final class FocusRequester$focus$1$1 extends Lambda implements Function1<FocusTargetNode, Boolean> {
    public static final FocusRequester$focus$1$1 INSTANCE = new FocusRequester$focus$1$1();

    FocusRequester$focus$1$1() {
        super(1);
    }

    public final Boolean invoke(FocusTargetNode focusTargetNode) {
        return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetNode));
    }
}
