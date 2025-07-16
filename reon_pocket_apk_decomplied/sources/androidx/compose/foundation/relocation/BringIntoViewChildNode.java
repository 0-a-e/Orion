package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8D@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewChildNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "()V", "defaultParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "localParent", "getLocalParent", "()Landroidx/compose/foundation/relocation/BringIntoViewParent;", "parent", "getParent", "onPlaced", "", "coordinates", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoView.kt */
public abstract class BringIntoViewChildNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutAwareModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private final BringIntoViewParent defaultParent = BringIntoViewResponder_androidKt.defaultBringIntoViewParent(this);
    private LayoutCoordinates layoutCoordinates;

    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    public /* synthetic */ ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNode.CC.$default$getProvidedValues(this);
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public /* synthetic */ void m999onRemeasuredozmzZPI(long j) {
        LayoutAwareModifierNode.CC.m5494$default$onRemeasuredozmzZPI(this, j);
    }

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    private final BringIntoViewParent getLocalParent() {
        return (BringIntoViewParent) getCurrent(BringIntoViewKt.getModifierLocalBringIntoViewParent());
    }

    /* access modifiers changed from: protected */
    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return layoutCoordinates2;
    }

    /* access modifiers changed from: protected */
    public final BringIntoViewParent getParent() {
        BringIntoViewParent localParent = getLocalParent();
        return localParent == null ? this.defaultParent : localParent;
    }

    public void onPlaced(LayoutCoordinates layoutCoordinates2) {
        this.layoutCoordinates = layoutCoordinates2;
    }
}
