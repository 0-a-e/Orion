package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bi\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J(\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010'J\u001a\u0010(\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010)\u001a\u00020\u0004J\u001a\u0010*\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b,R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0010R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0010R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "", "onActionModeDestroy", "Lkotlin/Function0;", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnActionModeDestroy", "()Lkotlin/jvm/functions/Function0;", "getOnCopyRequested", "setOnCopyRequested", "(Lkotlin/jvm/functions/Function0;)V", "getOnCutRequested", "setOnCutRequested", "getOnPasteRequested", "setOnPasteRequested", "getOnSelectAllRequested", "setOnSelectAllRequested", "getRect", "()Landroidx/compose/ui/geometry/Rect;", "setRect", "(Landroidx/compose/ui/geometry/Rect;)V", "addMenuItem", "menu", "Landroid/view/Menu;", "item", "Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "addMenuItem$ui_release", "addOrRemoveMenuItem", "callback", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "Landroid/view/MenuItem;", "onCreateActionMode", "onDestroyActionMode", "onPrepareActionMode", "updateMenuItems", "updateMenuItems$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextActionModeCallback.android.kt */
public final class TextActionModeCallback {
    public static final int $stable = 8;
    private final Function0<Unit> onActionModeDestroy;
    private Function0<Unit> onCopyRequested;
    private Function0<Unit> onCutRequested;
    private Function0<Unit> onPasteRequested;
    private Function0<Unit> onSelectAllRequested;
    private Rect rect;

    public TextActionModeCallback() {
        this((Function0) null, (Rect) null, (Function0) null, (Function0) null, (Function0) null, (Function0) null, 63, (DefaultConstructorMarker) null);
    }

    public TextActionModeCallback(Function0<Unit> function0, Rect rect2, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
        this.onActionModeDestroy = function0;
        this.rect = rect2;
        this.onCopyRequested = function02;
        this.onPasteRequested = function03;
        this.onCutRequested = function04;
        this.onSelectAllRequested = function05;
    }

    public final Function0<Unit> getOnActionModeDestroy() {
        return this.onActionModeDestroy;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextActionModeCallback(kotlin.jvm.functions.Function0 r6, androidx.compose.ui.geometry.Rect r7, kotlin.jvm.functions.Function0 r8, kotlin.jvm.functions.Function0 r9, kotlin.jvm.functions.Function0 r10, kotlin.jvm.functions.Function0 r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x0012
            androidx.compose.ui.geometry.Rect$Companion r6 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r7 = r6.getZero()
        L_0x0012:
            r1 = r7
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0019
            r2 = r0
            goto L_0x001a
        L_0x0019:
            r2 = r8
        L_0x001a:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x0020
            r3 = r0
            goto L_0x0021
        L_0x0020:
            r3 = r9
        L_0x0021:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0027
            r4 = r0
            goto L_0x0028
        L_0x0027:
            r4 = r10
        L_0x0028:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002e
            r12 = r0
            goto L_0x002f
        L_0x002e:
            r12 = r11
        L_0x002f:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback.<init>(kotlin.jvm.functions.Function0, androidx.compose.ui.geometry.Rect, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final void setRect(Rect rect2) {
        this.rect = rect2;
    }

    public final Function0<Unit> getOnCopyRequested() {
        return this.onCopyRequested;
    }

    public final void setOnCopyRequested(Function0<Unit> function0) {
        this.onCopyRequested = function0;
    }

    public final Function0<Unit> getOnPasteRequested() {
        return this.onPasteRequested;
    }

    public final void setOnPasteRequested(Function0<Unit> function0) {
        this.onPasteRequested = function0;
    }

    public final Function0<Unit> getOnCutRequested() {
        return this.onCutRequested;
    }

    public final void setOnCutRequested(Function0<Unit> function0) {
        this.onCutRequested = function0;
    }

    public final Function0<Unit> getOnSelectAllRequested() {
        return this.onSelectAllRequested;
    }

    public final void setOnSelectAllRequested(Function0<Unit> function0) {
        this.onSelectAllRequested = function0;
    }

    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null menu".toString());
        } else if (actionMode != null) {
            if (this.onCopyRequested != null) {
                addMenuItem$ui_release(menu, MenuItemOption.Copy);
            }
            if (this.onPasteRequested != null) {
                addMenuItem$ui_release(menu, MenuItemOption.Paste);
            }
            if (this.onCutRequested != null) {
                addMenuItem$ui_release(menu, MenuItemOption.Cut);
            }
            if (this.onSelectAllRequested == null) {
                return true;
            }
            addMenuItem$ui_release(menu, MenuItemOption.SelectAll);
            return true;
        } else {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null mode".toString());
        }
    }

    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        if (actionMode == null || menu == null) {
            return false;
        }
        updateMenuItems$ui_release(menu);
        return true;
    }

    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        Intrinsics.checkNotNull(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            Function0<Unit> function0 = this.onCopyRequested;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (itemId == MenuItemOption.Paste.getId()) {
            Function0<Unit> function02 = this.onPasteRequested;
            if (function02 != null) {
                function02.invoke();
            }
        } else if (itemId == MenuItemOption.Cut.getId()) {
            Function0<Unit> function03 = this.onCutRequested;
            if (function03 != null) {
                function03.invoke();
            }
        } else if (itemId != MenuItemOption.SelectAll.getId()) {
            return false;
        } else {
            Function0<Unit> function04 = this.onSelectAllRequested;
            if (function04 != null) {
                function04.invoke();
            }
        }
        if (actionMode == null) {
            return true;
        }
        actionMode.finish();
        return true;
    }

    public final void onDestroyActionMode() {
        Function0<Unit> function0 = this.onActionModeDestroy;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void updateMenuItems$ui_release(Menu menu) {
        addOrRemoveMenuItem(menu, MenuItemOption.Copy, this.onCopyRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Paste, this.onPasteRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Cut, this.onCutRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.SelectAll, this.onSelectAllRequested);
    }

    public final void addMenuItem$ui_release(Menu menu, MenuItemOption menuItemOption) {
        menu.add(0, menuItemOption.getId(), menuItemOption.getOrder(), menuItemOption.getTitleResource()).setShowAsAction(1);
    }

    private final void addOrRemoveMenuItem(Menu menu, MenuItemOption menuItemOption, Function0<Unit> function0) {
        if (function0 != null && menu.findItem(menuItemOption.getId()) == null) {
            addMenuItem$ui_release(menu, menuItemOption);
        } else if (function0 == null && menu.findItem(menuItemOption.getId()) != null) {
            menu.removeItem(menuItemOption.getId());
        }
    }
}
