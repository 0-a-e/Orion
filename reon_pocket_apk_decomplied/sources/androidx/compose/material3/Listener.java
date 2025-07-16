package androidx.compose.material3;

import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bR+\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/Listener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "Landroidx/compose/runtime/State;", "", "()V", "<set-?>", "accessibilityEnabled", "getAccessibilityEnabled", "()Z", "setAccessibilityEnabled", "(Z)V", "accessibilityEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "touchExplorationEnabled", "getTouchExplorationEnabled", "setTouchExplorationEnabled", "touchExplorationEnabled$delegate", "value", "getValue", "()Ljava/lang/Boolean;", "onAccessibilityStateChanged", "", "it", "onTouchExplorationStateChanged", "register", "am", "Landroid/view/accessibility/AccessibilityManager;", "unregister", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener, State<Boolean> {
    private final MutableState accessibilityEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState touchExplorationEnabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);

    private final boolean getAccessibilityEnabled() {
        return ((Boolean) this.accessibilityEnabled$delegate.getValue()).booleanValue();
    }

    private final void setAccessibilityEnabled(boolean z) {
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    private final boolean getTouchExplorationEnabled() {
        return ((Boolean) this.touchExplorationEnabled$delegate.getValue()).booleanValue();
    }

    private final void setTouchExplorationEnabled(boolean z) {
        this.touchExplorationEnabled$delegate.setValue(Boolean.valueOf(z));
    }

    public Boolean getValue() {
        return Boolean.valueOf(getAccessibilityEnabled() && getTouchExplorationEnabled());
    }

    public void onAccessibilityStateChanged(boolean z) {
        setAccessibilityEnabled(z);
    }

    public void onTouchExplorationStateChanged(boolean z) {
        setTouchExplorationEnabled(z);
    }

    public final void register(AccessibilityManager accessibilityManager) {
        setAccessibilityEnabled(accessibilityManager.isEnabled());
        setTouchExplorationEnabled(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(this);
        accessibilityManager.addAccessibilityStateChangeListener(this);
    }

    public final void unregister(AccessibilityManager accessibilityManager) {
        accessibilityManager.removeTouchExplorationStateChangeListener(this);
        accessibilityManager.removeAccessibilityStateChangeListener(this);
    }
}
