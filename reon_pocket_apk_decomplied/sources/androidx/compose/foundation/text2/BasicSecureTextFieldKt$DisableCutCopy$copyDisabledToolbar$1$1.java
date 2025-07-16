package androidx.compose.foundation.text2;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0001JP\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"androidx/compose/foundation/text2/BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1", "Landroidx/compose/ui/platform/TextToolbar;", "status", "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
public final class BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1 implements TextToolbar {
    private final /* synthetic */ TextToolbar $$delegate_0;
    final /* synthetic */ TextToolbar $currentToolbar;

    public TextToolbarStatus getStatus() {
        return this.$$delegate_0.getStatus();
    }

    public void hide() {
        this.$$delegate_0.hide();
    }

    BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1(TextToolbar textToolbar) {
        this.$currentToolbar = textToolbar;
        this.$$delegate_0 = textToolbar;
    }

    public void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
        this.$currentToolbar.showMenu(rect, (Function0<Unit>) null, function02, (Function0<Unit>) null, function04);
    }
}
