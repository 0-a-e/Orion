package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\u0000H\u0002J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J*\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "cursorInBoundsOfNode", "value", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "setIcon", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "getOverrideDescendants", "()Z", "setOverrideDescendants", "(Z)V", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "displayDefaultIcon", "", "displayIcon", "displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon", "displayIconFromCurrentNodeOrDescendantsWithCursorInBounds", "displayIconIfDescendantsDoNotHavePriority", "findDescendantNodeWithCursorInBounds", "findOverridingAncestorNode", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerIcon.kt */
public final class PointerHoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public boolean cursorInBoundsOfNode;
    private PointerIcon icon;
    private boolean overrideDescendants;
    private final String traverseKey;

    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public void onCancelPointerInput() {
    }

    public /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    public /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PointerHoverIconModifierNode(PointerIcon pointerIcon, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pointerIcon, (i & 2) != 0 ? false : z);
    }

    public PointerHoverIconModifierNode(PointerIcon pointerIcon, boolean z) {
        this.traverseKey = "androidx.compose.ui.input.pointer.PointerHoverIcon";
        this.icon = pointerIcon;
        this.overrideDescendants = z;
    }

    public String getTraverseKey() {
        return this.traverseKey;
    }

    public final PointerIcon getIcon() {
        return this.icon;
    }

    public final void setIcon(PointerIcon pointerIcon) {
        if (!Intrinsics.areEqual((Object) this.icon, (Object) pointerIcon)) {
            this.icon = pointerIcon;
            if (this.cursorInBoundsOfNode) {
                displayIconIfDescendantsDoNotHavePriority();
            }
        }
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    public final void setOverrideDescendants(boolean z) {
        if (this.overrideDescendants != z) {
            this.overrideDescendants = z;
            if (z) {
                if (this.cursorInBoundsOfNode) {
                    displayIcon();
                }
            } else if (this.cursorInBoundsOfNode) {
                displayIconFromCurrentNodeOrDescendantsWithCursorInBounds();
            }
        }
    }

    private final PointerIconService getPointerIconService() {
        return (PointerIconService) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalPointerIconService());
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m5091onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        if (pointerEventPass != PointerEventPass.Main) {
            return;
        }
        if (PointerEventType.m5061equalsimpl0(pointerEvent.m5054getType7fucELk(), PointerEventType.Companion.m5065getEnter7fucELk())) {
            this.cursorInBoundsOfNode = true;
            displayIconIfDescendantsDoNotHavePriority();
        } else if (PointerEventType.m5061equalsimpl0(pointerEvent.m5054getType7fucELk(), PointerEventType.Companion.m5066getExit7fucELk())) {
            this.cursorInBoundsOfNode = false;
            displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon();
        }
    }

    public void onDetach() {
        this.cursorInBoundsOfNode = false;
        displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon();
        super.onDetach();
    }

    private final void displayIcon() {
        PointerIcon pointerIcon;
        PointerHoverIconModifierNode findOverridingAncestorNode = findOverridingAncestorNode();
        if (findOverridingAncestorNode == null || (pointerIcon = findOverridingAncestorNode.icon) == null) {
            pointerIcon = this.icon;
        }
        PointerIconService pointerIconService = getPointerIconService();
        if (pointerIconService != null) {
            pointerIconService.setIcon(pointerIcon);
        }
    }

    private final void displayDefaultIcon() {
        PointerIconService pointerIconService = getPointerIconService();
        if (pointerIconService != null) {
            pointerIconService.setIcon((PointerIcon) null);
        }
    }

    private final void displayIconIfDescendantsDoNotHavePriority() {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (!this.overrideDescendants) {
            TraversableNodeKt.traverseDescendants(this, new PointerHoverIconModifierNode$displayIconIfDescendantsDoNotHavePriority$1(booleanRef));
        }
        if (booleanRef.element) {
            displayIcon();
        }
    }

    private final PointerHoverIconModifierNode findDescendantNodeWithCursorInBounds() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TraversableNodeKt.traverseDescendants(this, new PointerHoverIconModifierNode$findDescendantNodeWithCursorInBounds$1(objectRef));
        return (PointerHoverIconModifierNode) objectRef.element;
    }

    private final void displayIconFromCurrentNodeOrDescendantsWithCursorInBounds() {
        PointerHoverIconModifierNode pointerHoverIconModifierNode;
        if (this.cursorInBoundsOfNode) {
            if (this.overrideDescendants || (pointerHoverIconModifierNode = findDescendantNodeWithCursorInBounds()) == null) {
                pointerHoverIconModifierNode = this;
            }
            PointerHoverIconModifierNode pointerHoverIconModifierNode2 = pointerHoverIconModifierNode;
            pointerHoverIconModifierNode.displayIcon();
        }
    }

    private final PointerHoverIconModifierNode findOverridingAncestorNode() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new PointerHoverIconModifierNode$findOverridingAncestorNode$1(objectRef));
        return (PointerHoverIconModifierNode) objectRef.element;
    }

    private final void displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon() {
        Unit unit;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new PointerHoverIconModifierNode$displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon$1(objectRef));
        PointerHoverIconModifierNode pointerHoverIconModifierNode = (PointerHoverIconModifierNode) objectRef.element;
        if (pointerHoverIconModifierNode != null) {
            pointerHoverIconModifierNode.displayIcon();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            displayDefaultIcon();
        }
    }
}
