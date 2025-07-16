package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/focus/FocusRequester;", "it", "Landroidx/compose/ui/focus/FocusDirection;", "invoke-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRestorer.kt */
final class FocusRestorerNode$onEnter$1 extends Lambda implements Function1<FocusDirection, FocusRequester> {
    final /* synthetic */ FocusRestorerNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusRestorerNode$onEnter$1(FocusRestorerNode focusRestorerNode) {
        super(1);
        this.this$0 = focusRestorerNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m3506invoke3ESFkO8(((FocusDirection) obj).m3482unboximpl());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        r1 = r1.invoke();
     */
    /* renamed from: invoke-3ESFkO8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.focus.FocusRequester m3506invoke3ESFkO8(int r1) {
        /*
            r0 = this;
            androidx.compose.ui.focus.FocusRestorerNode r1 = r0.this$0
            androidx.compose.ui.focus.FocusRequesterModifierNode r1 = (androidx.compose.ui.focus.FocusRequesterModifierNode) r1
            boolean r1 = androidx.compose.ui.focus.FocusRequesterModifierNodeKt.restoreFocusedChild(r1)
            if (r1 == 0) goto L_0x0011
            androidx.compose.ui.focus.FocusRequester$Companion r1 = androidx.compose.ui.focus.FocusRequester.Companion
            androidx.compose.ui.focus.FocusRequester r1 = r1.getCancel()
            goto L_0x0027
        L_0x0011:
            androidx.compose.ui.focus.FocusRestorerNode r1 = r0.this$0
            kotlin.jvm.functions.Function0 r1 = r1.getOnRestoreFailed()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r1.invoke()
            androidx.compose.ui.focus.FocusRequester r1 = (androidx.compose.ui.focus.FocusRequester) r1
            if (r1 != 0) goto L_0x0027
        L_0x0021:
            androidx.compose.ui.focus.FocusRequester$Companion r1 = androidx.compose.ui.focus.FocusRequester.Companion
            androidx.compose.ui.focus.FocusRequester r1 = r1.getDefault()
        L_0x0027:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRestorerNode$onEnter$1.m3506invoke3ESFkO8(int):androidx.compose.ui.focus.FocusRequester");
    }
}
