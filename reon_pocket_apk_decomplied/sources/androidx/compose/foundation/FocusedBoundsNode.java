package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "()V", "isFocused", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "observer", "Lkotlin/Function1;", "", "getObserver", "()Lkotlin/jvm/functions/Function1;", "notifyObserverWhenAttached", "onGloballyPositioned", "coordinates", "setFocus", "focused", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusedBounds.kt */
public final class FocusedBoundsNode extends Modifier.Node implements ModifierLocalModifierNode, GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private boolean isFocused;
    private LayoutCoordinates layoutCoordinates;

    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    public /* synthetic */ ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNode.CC.$default$getProvidedValues(this);
    }

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    private final Function1<LayoutCoordinates, Unit> getObserver() {
        if (isAttached()) {
            return (Function1) getCurrent(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver());
        }
        return null;
    }

    public final void setFocus(boolean z) {
        if (z != this.isFocused) {
            if (!z) {
                Function1<LayoutCoordinates, Unit> observer = getObserver();
                if (observer != null) {
                    observer.invoke(null);
                }
            } else {
                notifyObserverWhenAttached();
            }
            this.isFocused = z;
        }
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates2) {
        this.layoutCoordinates = layoutCoordinates2;
        if (this.isFocused) {
            if (layoutCoordinates2.isAttached()) {
                notifyObserverWhenAttached();
                return;
            }
            Function1<LayoutCoordinates, Unit> observer = getObserver();
            if (observer != null) {
                observer.invoke(null);
            }
        }
    }

    private final void notifyObserverWhenAttached() {
        Function1<LayoutCoordinates, Unit> observer;
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        if (layoutCoordinates2 != null) {
            Intrinsics.checkNotNull(layoutCoordinates2);
            if (layoutCoordinates2.isAttached() && (observer = getObserver()) != null) {
                observer.invoke(this.layoutCoordinates);
            }
        }
    }
}
