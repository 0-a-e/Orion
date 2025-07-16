package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u000bJC\u0010\u0011\u001a\u00020\t28\b\u0004\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0013H\bJ\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "", "extraAssertions", "", "(Z)V", "lookaheadSet", "Landroidx/compose/ui/node/DepthSortedSet;", "set", "add", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "affectsLookahead", "contains", "isEmpty", "isNotEmpty", "pop", "popEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "remove", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DepthSortedSet.kt */
public final class DepthSortedSetsForDifferentPasses {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final DepthSortedSet lookaheadSet;
    /* access modifiers changed from: private */
    public final DepthSortedSet set;

    public DepthSortedSetsForDifferentPasses(boolean z) {
        this.lookaheadSet = new DepthSortedSet(z);
        this.set = new DepthSortedSet(z);
    }

    public final boolean contains(LayoutNode layoutNode, boolean z) {
        boolean contains = this.lookaheadSet.contains(layoutNode);
        if (z) {
            return contains;
        }
        return contains || this.set.contains(layoutNode);
    }

    public final boolean contains(LayoutNode layoutNode) {
        return this.lookaheadSet.contains(layoutNode) || this.set.contains(layoutNode);
    }

    public final void add(LayoutNode layoutNode, boolean z) {
        if (z) {
            this.lookaheadSet.add(layoutNode);
        } else if (!this.lookaheadSet.contains(layoutNode)) {
            this.set.add(layoutNode);
        }
    }

    public final boolean remove(LayoutNode layoutNode, boolean z) {
        if (z) {
            return this.lookaheadSet.remove(layoutNode);
        }
        return this.set.remove(layoutNode);
    }

    public final boolean remove(LayoutNode layoutNode) {
        return this.set.remove(layoutNode) || this.lookaheadSet.remove(layoutNode);
    }

    public final LayoutNode pop() {
        if (!this.lookaheadSet.isEmpty()) {
            return this.lookaheadSet.pop();
        }
        return this.set.pop();
    }

    public final void popEach(Function2<? super LayoutNode, ? super Boolean, Unit> function2) {
        while (isNotEmpty()) {
            boolean z = !this.lookaheadSet.isEmpty();
            function2.invoke((z ? this.lookaheadSet : this.set).pop(), Boolean.valueOf(z));
        }
    }

    public final boolean isEmpty() {
        return this.set.isEmpty() && this.lookaheadSet.isEmpty();
    }

    public final boolean isEmpty(boolean z) {
        return (z ? this.lookaheadSet : this.set).isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }
}
