package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "popupLayout", "Landroidx/compose/ui/window/PopupLayout;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class PopupLayout$Companion$onCommitAffectingPopupPosition$1 extends Lambda implements Function1<PopupLayout, Unit> {
    public static final PopupLayout$Companion$onCommitAffectingPopupPosition$1 INSTANCE = new PopupLayout$Companion$onCommitAffectingPopupPosition$1();

    PopupLayout$Companion$onCommitAffectingPopupPosition$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PopupLayout) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PopupLayout popupLayout) {
        if (popupLayout.isAttachedToWindow()) {
            popupLayout.updatePosition();
        }
    }
}
