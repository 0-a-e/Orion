package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016JP\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/platform/AndroidTextToolbar;", "Landroidx/compose/ui/platform/TextToolbar;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "actionMode", "Landroid/view/ActionMode;", "<set-?>", "Landroidx/compose/ui/platform/TextToolbarStatus;", "status", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "textActionModeCallback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextToolbar.android.kt */
public final class AndroidTextToolbar implements TextToolbar {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public ActionMode actionMode;
    private TextToolbarStatus status = TextToolbarStatus.Hidden;
    private final TextActionModeCallback textActionModeCallback = new TextActionModeCallback(new AndroidTextToolbar$textActionModeCallback$1(this), (Rect) null, (Function0) null, (Function0) null, (Function0) null, (Function0) null, 62, (DefaultConstructorMarker) null);
    private final View view;

    public AndroidTextToolbar(View view2) {
        this.view = view2;
    }

    public TextToolbarStatus getStatus() {
        return this.status;
    }

    public void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
        this.textActionModeCallback.setRect(rect);
        this.textActionModeCallback.setOnCopyRequested(function0);
        this.textActionModeCallback.setOnCutRequested(function03);
        this.textActionModeCallback.setOnPasteRequested(function02);
        this.textActionModeCallback.setOnSelectAllRequested(function04);
        ActionMode actionMode2 = this.actionMode;
        if (actionMode2 == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1);
        } else if (actionMode2 != null) {
            actionMode2.invalidate();
        }
    }

    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode2 = this.actionMode;
        if (actionMode2 != null) {
            actionMode2.finish();
        }
        this.actionMode = null;
    }
}
