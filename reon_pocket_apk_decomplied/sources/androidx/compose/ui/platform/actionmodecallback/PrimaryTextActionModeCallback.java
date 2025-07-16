package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/PrimaryTextActionModeCallback;", "Landroid/view/ActionMode$Callback;", "callback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "(Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;)V", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onPrepareActionMode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PrimaryTextActionModeCallback.android.kt */
public final class PrimaryTextActionModeCallback implements ActionMode.Callback {
    public static final int $stable = 8;
    private final TextActionModeCallback callback;

    public PrimaryTextActionModeCallback(TextActionModeCallback textActionModeCallback) {
        this.callback = textActionModeCallback;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.callback.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.callback.onCreateActionMode(actionMode, menu);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.callback.onPrepareActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.callback.onDestroyActionMode();
    }
}
