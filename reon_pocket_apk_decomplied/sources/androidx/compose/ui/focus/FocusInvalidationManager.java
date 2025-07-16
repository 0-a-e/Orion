package androidx.compose.ui.focus;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\rJ%\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0010\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusEventNodes", "", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Ljava/util/Set;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusInvalidationManager.kt */
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public Set<FocusEventModifierNode> focusEventNodes = new LinkedHashSet();
    /* access modifiers changed from: private */
    public Set<FocusPropertiesModifierNode> focusPropertiesNodes = new LinkedHashSet();
    /* access modifiers changed from: private */
    public Set<FocusTargetNode> focusTargetNodes = new LinkedHashSet();
    private final Function0<Unit> invalidateNodes = new FocusInvalidationManager$invalidateNodes$1(this);
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;

    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1) {
        this.onRequestApplyChangesListener = function1;
    }

    public final void scheduleInvalidation(FocusTargetNode focusTargetNode) {
        scheduleInvalidation(this.focusTargetNodes, focusTargetNode);
    }

    public final void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode) {
        scheduleInvalidation(this.focusEventNodes, focusEventModifierNode);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        scheduleInvalidation(this.focusPropertiesNodes, focusPropertiesModifierNode);
    }

    private final <T> void scheduleInvalidation(Set<T> set, T t) {
        if (set.add(t) && this.focusTargetNodes.size() + this.focusEventNodes.size() + this.focusPropertiesNodes.size() == 1) {
            this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
        }
    }
}
