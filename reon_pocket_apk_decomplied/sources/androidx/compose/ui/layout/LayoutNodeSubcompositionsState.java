package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0003cdeB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010+\u001a\u00020,2\u001d\u0010-\u001a\u0019\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010.¢\u0006\u0002\b2J!\u00103\u001a\u0002012\u0006\u00104\u001a\u0002012\u000e\b\u0004\u00105\u001a\b\u0012\u0004\u0012\u00020706H\bJ\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0010H\u0002J\b\u0010:\u001a\u000207H\u0002J\u000e\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020\u0010J\b\u0010=\u001a\u000207H\u0002J\u0006\u0010>\u001a\u000207J\u0012\u0010?\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\u0010H\u0002J\u0017\u0010@\u001a\u0002072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020706H\bJ\u0006\u0010A\u001a\u000207J\u0010\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020DH\u0002J\"\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00102\b\b\u0002\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u000207H\u0016J\b\u0010J\u001a\u000207H\u0016J\b\u0010K\u001a\u000207H\u0016J0\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\b\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\bQH\u0002¢\u0006\u0002\u0010RJ(\u0010S\u001a\u00020\u001d2\b\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\bQ¢\u0006\u0002\u0010TJ\u0018\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u0014H\u0002J2\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020\u00032\b\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\bQH\u0002¢\u0006\u0002\u0010XJ.\u0010U\u001a\b\u0012\u0004\u0012\u00020N0M2\b\u0010O\u001a\u0004\u0018\u00010\u00182\u0011\u0010P\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\bQ¢\u0006\u0002\u0010RJB\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010Z2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020\n2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020706¢\u0006\u0002\bQH\u0002¢\u0006\u0002\u0010`J\u0014\u0010a\u001a\u0004\u0018\u00010\u00032\b\u0010O\u001a\u0004\u0018\u00010\u0018H\u0002J\f\u0010b\u001a\u000207*\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R.\u0010\u001e\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00030\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0003`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R.\u0010%\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00030\u0013j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u0003`\u0015X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006f"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "NoIntrinsicsMessage", "", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "", "currentPostLookaheadIndex", "nodeToNodeState", "Ljava/util/HashMap;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "Lkotlin/collections/HashMap;", "postLookaheadComposedSlotIds", "Landroidx/compose/runtime/collection/MutableVector;", "", "postLookaheadMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$PostLookaheadMeasureScopeImpl;", "postLookaheadPrecomposeSlotHandleMap", "", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "precomposeMap", "precomposedCount", "reusableCount", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "slotIdToNode", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "createMeasureResult", "result", "placeChildrenBlock", "Lkotlin/Function0;", "", "createNodeAt", "index", "disposeCurrentNodes", "disposeOrReuseStartingFromIndex", "startIndex", "disposeUnusedSlotsInPostLookahead", "forceRecomposeChildren", "getSlotIdAtIndex", "ignoreRemeasureRequests", "makeSureStateIsConsistent", "markActiveNodesAsReused", "deactivate", "", "move", "from", "to", "count", "onDeactivate", "onRelease", "onReuse", "postLookaheadSubcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "precompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "node", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "subcomposeInto", "Landroidx/compose/runtime/ReusableComposition;", "existing", "container", "reuseContent", "parent", "composable", "(Landroidx/compose/runtime/ReusableComposition;Landroidx/compose/ui/node/LayoutNode;ZLandroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/ReusableComposition;", "takeNodeFromReusables", "resetLayoutState", "NodeState", "PostLookaheadMeasureScopeImpl", "Scope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {
    public static final int $stable = 8;
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    private CompositionContext compositionContext;
    /* access modifiers changed from: private */
    public int currentIndex;
    /* access modifiers changed from: private */
    public int currentPostLookaheadIndex;
    private final HashMap<LayoutNode, NodeState> nodeToNodeState = new HashMap<>();
    /* access modifiers changed from: private */
    public final MutableVector<Object> postLookaheadComposedSlotIds = new MutableVector<>(new Object[16], 0);
    /* access modifiers changed from: private */
    public final PostLookaheadMeasureScopeImpl postLookaheadMeasureScope = new PostLookaheadMeasureScopeImpl();
    private final Map<Object, SubcomposeLayoutState.PrecomposedSlotHandle> postLookaheadPrecomposeSlotHandleMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final HashMap<Object, LayoutNode> precomposeMap = new HashMap<>();
    /* access modifiers changed from: private */
    public int precomposedCount;
    /* access modifiers changed from: private */
    public int reusableCount;
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet((Set) null, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final LayoutNode root;
    /* access modifiers changed from: private */
    public final Scope scope = new Scope();
    /* access modifiers changed from: private */
    public final HashMap<Object, LayoutNode> slotIdToNode = new HashMap<>();
    private SubcomposeSlotReusePolicy slotReusePolicy;

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.root = layoutNode;
        this.slotReusePolicy = subcomposeSlotReusePolicy;
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    public final void setCompositionContext(CompositionContext compositionContext2) {
        this.compositionContext = compositionContext2;
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        if (this.slotReusePolicy != subcomposeSlotReusePolicy) {
            this.slotReusePolicy = subcomposeSlotReusePolicy;
            markActiveNodesAsReused(false);
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, 3, (Object) null);
        }
    }

    public void onReuse() {
        markActiveNodesAsReused(false);
    }

    public void onDeactivate() {
        markActiveNodesAsReused(true);
    }

    public void onRelease() {
        disposeCurrentNodes();
    }

    public final List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui_release = this.root.getLayoutState$ui_release();
        if (layoutState$ui_release == LayoutNode.LayoutState.Measuring || layoutState$ui_release == LayoutNode.LayoutState.LayingOut || layoutState$ui_release == LayoutNode.LayoutState.LookaheadMeasuring || layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
            Map map = this.slotIdToNode;
            Object obj2 = map.get(obj);
            if (obj2 == null) {
                obj2 = this.precomposeMap.remove(obj);
                if (obj2 != null) {
                    int i = this.precomposedCount;
                    if (i > 0) {
                        this.precomposedCount = i - 1;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    obj2 = takeNodeFromReusables(obj);
                    if (obj2 == null) {
                        obj2 = createNodeAt(this.currentIndex);
                    }
                }
                map.put(obj, obj2);
            }
            LayoutNode layoutNode = (LayoutNode) obj2;
            if (CollectionsKt.getOrNull(this.root.getFoldedChildren$ui_release(), this.currentIndex) != layoutNode) {
                int indexOf = this.root.getFoldedChildren$ui_release().indexOf(layoutNode);
                int i2 = this.currentIndex;
                if (indexOf < i2) {
                    throw new IllegalArgumentException(("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
                } else if (i2 != indexOf) {
                    move$default(this, indexOf, i2, 0, 4, (Object) null);
                }
            }
            this.currentIndex++;
            subcompose(layoutNode, obj, function2);
            if (layoutState$ui_release == LayoutNode.LayoutState.Measuring || layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
                return layoutNode.getChildMeasurables$ui_release();
            }
            return layoutNode.getChildLookaheadMeasurables$ui_release();
        }
        throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void subcompose(androidx.compose.ui.node.LayoutNode r9, java.lang.Object r10, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r11) {
        /*
            r8 = this;
            java.util.HashMap<androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState> r0 = r8.nodeToNodeState
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r1 = r0.get(r9)
            if (r1 != 0) goto L_0x001d
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r1 = new androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState
            androidx.compose.ui.layout.ComposableSingletons$SubcomposeLayoutKt r2 = androidx.compose.ui.layout.ComposableSingletons$SubcomposeLayoutKt.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r2.m5263getLambda1$ui_release()
            r6 = 4
            r7 = 0
            r5 = 0
            r2 = r1
            r3 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            r0.put(r9, r1)
        L_0x001d:
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r1 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r1
            androidx.compose.runtime.ReusableComposition r10 = r1.getComposition()
            if (r10 == 0) goto L_0x002a
            boolean r10 = r10.getHasInvalidations()
            goto L_0x002b
        L_0x002a:
            r10 = 1
        L_0x002b:
            kotlin.jvm.functions.Function2 r0 = r1.getContent()
            if (r0 != r11) goto L_0x0039
            if (r10 != 0) goto L_0x0039
            boolean r10 = r1.getForceRecompose()
            if (r10 == 0) goto L_0x0043
        L_0x0039:
            r1.setContent(r11)
            r8.subcompose((androidx.compose.ui.node.LayoutNode) r9, (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r1)
            r9 = 0
            r1.setForceRecompose(r9)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose(androidx.compose.ui.node.LayoutNode, java.lang.Object, kotlin.jvm.functions.Function2):void");
    }

    private final void subcompose(LayoutNode layoutNode, NodeState nodeState) {
        Snapshot makeCurrent;
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            LayoutNode layoutNode2 = this.root;
            layoutNode2.ignoreRemeasureRequests = true;
            Function2<Composer, Integer, Unit> content = nodeState.getContent();
            ReusableComposition composition = nodeState.getComposition();
            CompositionContext compositionContext2 = this.compositionContext;
            if (compositionContext2 != null) {
                nodeState.setComposition(subcomposeInto(composition, layoutNode, nodeState.getForceReuse(), compositionContext2, ComposableLambdaKt.composableLambdaInstance(-1750409193, true, new LayoutNodeSubcompositionsState$subcompose$3$1$1(nodeState, content))));
                nodeState.setForceReuse(false);
                layoutNode2.ignoreRemeasureRequests = false;
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
                return;
            }
            throw new IllegalStateException("parent composition reference not set".toString());
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    private final ReusableComposition subcomposeInto(ReusableComposition reusableComposition, LayoutNode layoutNode, boolean z, CompositionContext compositionContext2, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (reusableComposition == null || reusableComposition.isDisposed()) {
            reusableComposition = Wrapper_androidKt.createSubcomposition(layoutNode, compositionContext2);
        }
        if (!z) {
            reusableComposition.setContent(function2);
        } else {
            reusableComposition.setContentWithReuse(function2);
        }
        return reusableComposition;
    }

    private final Object getSlotIdAtIndex(int i) {
        NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(i));
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    public final void disposeOrReuseStartingFromIndex(int i) {
        Snapshot makeCurrent;
        boolean z = false;
        this.reusableCount = 0;
        int size = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        if (i <= size) {
            this.reusableSlotIdsSet.clear();
            if (i <= size) {
                int i2 = i;
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(i2));
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                boolean z2 = false;
                while (size >= i) {
                    LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(size);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    Intrinsics.checkNotNull(nodeState);
                    NodeState nodeState2 = nodeState;
                    Object slotId = nodeState2.getSlotId();
                    if (this.reusableSlotIdsSet.contains(slotId)) {
                        this.reusableCount++;
                        if (nodeState2.getActive()) {
                            resetLayoutState(layoutNode);
                            nodeState2.setActive(false);
                            z2 = true;
                        }
                    } else {
                        LayoutNode layoutNode2 = this.root;
                        layoutNode2.ignoreRemeasureRequests = true;
                        this.nodeToNodeState.remove(layoutNode);
                        ReusableComposition composition = nodeState2.getComposition();
                        if (composition != null) {
                            composition.dispose();
                        }
                        this.root.removeAt$ui_release(size, 1);
                        layoutNode2.ignoreRemeasureRequests = false;
                    }
                    this.slotIdToNode.remove(slotId);
                    size--;
                }
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
                z = z2;
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
        if (z) {
            Snapshot.Companion.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    private final void markActiveNodesAsReused(boolean z) {
        Snapshot makeCurrent;
        this.precomposedCount = 0;
        this.precomposeMap.clear();
        int size = this.root.getFoldedChildren$ui_release().size();
        if (this.reusableCount != size) {
            this.reusableCount = size;
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                for (int i = 0; i < size; i++) {
                    LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(i);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    if (nodeState != null && nodeState.getActive()) {
                        resetLayoutState(layoutNode);
                        if (z) {
                            ReusableComposition composition = nodeState.getComposition();
                            if (composition != null) {
                                composition.deactivate();
                            }
                            nodeState.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null));
                        } else {
                            nodeState.setActive(false);
                        }
                        nodeState.setSlotId(SubcomposeLayoutKt.ReusedSlotId);
                    }
                }
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
                this.slotIdToNode.clear();
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
        makeSureStateIsConsistent();
    }

    private final void disposeCurrentNodes() {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        for (NodeState composition : this.nodeToNodeState.values()) {
            ReusableComposition composition2 = composition.getComposition();
            if (composition2 != null) {
                composition2.dispose();
            }
        }
        this.root.removeAll$ui_release();
        layoutNode.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        int size = this.root.getFoldedChildren$ui_release().size();
        if (this.nodeToNodeState.size() != size) {
            throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
        } else if ((size - this.reusableCount) - this.precomposedCount < 0) {
            throw new IllegalArgumentException(("Incorrect state. Total children " + size + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
        } else if (this.precomposeMap.size() != this.precomposedCount) {
            throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.size()).toString());
        }
    }

    private final void resetLayoutState(LayoutNode layoutNode) {
        layoutNode.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }
    }

    private final LayoutNode takeNodeFromReusables(Object obj) {
        int i;
        if (this.reusableCount == 0) {
            return null;
        }
        int size = this.root.getFoldedChildren$ui_release().size() - this.precomposedCount;
        int i2 = size - this.reusableCount;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < i2) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(getSlotIdAtIndex(i4), obj)) {
                i = i4;
                break;
            } else {
                i4--;
            }
        }
        if (i == -1) {
            while (true) {
                if (i3 < i2) {
                    i4 = i3;
                    break;
                }
                NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(i3));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (nodeState2.getSlotId() == SubcomposeLayoutKt.ReusedSlotId || this.slotReusePolicy.areCompatible(obj, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(obj);
                    i4 = i3;
                    i = i4;
                } else {
                    i3--;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        if (i4 != i2) {
            move(i4, i2, 1);
        }
        this.reusableCount--;
        LayoutNode layoutNode = this.root.getFoldedChildren$ui_release().get(i2);
        NodeState nodeState3 = this.nodeToNodeState.get(layoutNode);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null));
        nodeState4.setForceReuse(true);
        nodeState4.setForceRecompose(true);
        return layoutNode;
    }

    public final MeasurePolicy createMeasurePolicy(Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        return new LayoutNodeSubcompositionsState$createMeasurePolicy$1(this, function2, this.NoIntrinsicsMessage);
    }

    /* access modifiers changed from: private */
    public final void disposeUnusedSlotsInPostLookahead() {
        CollectionsKt.removeAll(this.postLookaheadPrecomposeSlotHandleMap.entrySet(), new LayoutNodeSubcompositionsState$disposeUnusedSlotsInPostLookahead$1(this));
    }

    private final MeasureResult createMeasureResult(MeasureResult measureResult, Function0<Unit> function0) {
        return new LayoutNodeSubcompositionsState$createMeasureResult$1(measureResult, function0);
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.root.isAttached()) {
            return new LayoutNodeSubcompositionsState$precompose$1();
        }
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(obj)) {
            this.postLookaheadPrecomposeSlotHandleMap.remove(obj);
            Map map = this.precomposeMap;
            Object obj2 = map.get(obj);
            if (obj2 == null) {
                obj2 = takeNodeFromReusables(obj);
                if (obj2 != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(obj2), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                } else {
                    obj2 = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                map.put(obj, obj2);
            }
            subcompose((LayoutNode) obj2, obj, function2);
        }
        return new LayoutNodeSubcompositionsState$precompose$2(this, obj);
    }

    public final void forceRecomposeChildren() {
        if (this.reusableCount != this.root.getFoldedChildren$ui_release().size()) {
            for (Map.Entry value : this.nodeToNodeState.entrySet()) {
                ((NodeState) value.getValue()).setForceRecompose(true);
            }
            if (!this.root.getMeasurePending$ui_release()) {
                LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, 3, (Object) null);
            }
        }
    }

    private final LayoutNode createNodeAt(int i) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, (DefaultConstructorMarker) null);
        LayoutNode layoutNode2 = this.root;
        layoutNode2.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(i, layoutNode);
        layoutNode2.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    private final void ignoreRemeasureRequests(Function0<Unit> function0) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        function0.invoke();
        layoutNode.ignoreRemeasureRequests = false;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0002\u0018\u00002\u00020\u0001B.\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/ReusableComposition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ReusableComposition;)V", "value", "", "active", "getActive", "()Z", "setActive", "(Z)V", "activeState", "Landroidx/compose/runtime/MutableState;", "getActiveState", "()Landroidx/compose/runtime/MutableState;", "setActiveState", "(Landroidx/compose/runtime/MutableState;)V", "getComposition", "()Landroidx/compose/runtime/ReusableComposition;", "setComposition", "(Landroidx/compose/runtime/ReusableComposition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "forceRecompose", "getForceRecompose", "setForceRecompose", "forceReuse", "getForceReuse", "setForceReuse", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private static final class NodeState {
        private MutableState<Boolean> activeState;
        private ReusableComposition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private boolean forceReuse;
        private Object slotId;

        public NodeState(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, ReusableComposition reusableComposition) {
            this.slotId = obj;
            this.content = function2;
            this.composition = reusableComposition;
            this.activeState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NodeState(Object obj, Function2 function2, ReusableComposition reusableComposition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : reusableComposition);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.content = function2;
        }

        public final ReusableComposition getComposition() {
            return this.composition;
        }

        public final void setComposition(ReusableComposition reusableComposition) {
            this.composition = reusableComposition;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final boolean getForceReuse() {
            return this.forceReuse;
        }

        public final void setForceReuse(boolean z) {
            this.forceReuse = z;
        }

        public final MutableState<Boolean> getActiveState() {
            return this.activeState;
        }

        public final void setActiveState(MutableState<Boolean> mutableState) {
            this.activeState = mutableState;
        }

        public final boolean getActive() {
            return this.activeState.getValue().booleanValue();
        }

        public final void setActive(boolean z) {
            this.activeState.setValue(Boolean.valueOf(z));
        }
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JE\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u001b2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0002\b!H\u0016J0\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\b\u0010%\u001a\u0004\u0018\u00010&2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020 0(¢\u0006\u0002\b)H\u0016¢\u0006\u0002\u0010*R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public /* synthetic */ int m5343roundToPxR2X_6o(long j) {
            return Density.CC.m6554$default$roundToPxR2X_6o(this, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public /* synthetic */ int m5344roundToPx0680j_4(float f) {
            return Density.CC.m6555$default$roundToPx0680j_4(this, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public /* synthetic */ float m5345toDpGaN1DYA(long j) {
            return FontScaling.CC.m6725$default$toDpGaN1DYA(this, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public /* synthetic */ float m5346toDpu2uoSUM(float f) {
            return Density.CC.m6556$default$toDpu2uoSUM((Density) this, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public /* synthetic */ float m5347toDpu2uoSUM(int i) {
            return Density.CC.m6557$default$toDpu2uoSUM((Density) this, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public /* synthetic */ long m5348toDpSizekrfVVM(long j) {
            return Density.CC.m6558$default$toDpSizekrfVVM(this, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public /* synthetic */ float m5349toPxR2X_6o(long j) {
            return Density.CC.m6559$default$toPxR2X_6o(this, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public /* synthetic */ float m5350toPx0680j_4(float f) {
            return Density.CC.m6560$default$toPx0680j_4(this, f);
        }

        public /* synthetic */ Rect toRect(DpRect dpRect) {
            return Density.CC.$default$toRect(this, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public /* synthetic */ long m5351toSizeXkaWNTQ(long j) {
            return Density.CC.m6561$default$toSizeXkaWNTQ(this, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public /* synthetic */ long m5352toSp0xMU5do(float f) {
            return FontScaling.CC.m6726$default$toSp0xMU5do(this, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public /* synthetic */ long m5353toSpkPz2Gy4(float f) {
            return Density.CC.m6562$default$toSpkPz2Gy4((Density) this, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public /* synthetic */ long m5354toSpkPz2Gy4(int i) {
            return Density.CC.m6563$default$toSpkPz2Gy4((Density) this, i);
        }

        public Scope() {
        }

        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection2) {
            this.layoutDirection = layoutDirection2;
        }

        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        public boolean isLookingAhead() {
            return LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        public List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
            return LayoutNodeSubcompositionsState.this.subcompose(obj, function2);
        }

        public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            if ((i & ViewCompat.MEASURED_STATE_MASK) == 0 && (-16777216 & i2) == 0) {
                return new LayoutNodeSubcompositionsState$Scope$layout$1(i, i2, map, this, LayoutNodeSubcompositionsState.this, function1);
            }
            throw new IllegalStateException(("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.").toString());
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001dH\u0001J0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u001c0$¢\u0006\u0002\b%H\u0016¢\u0006\u0002\u0010&J\u0017\u0010'\u001a\u00020\u0014*\u00020(H\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0017\u0010'\u001a\u00020\u0014*\u00020+H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020(*\u00020+H\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001a\u0010.\u001a\u00020(*\u00020\u0005H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001a\u0010.\u001a\u00020(*\u00020\u0014H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00103J\u0017\u00104\u001a\u000205*\u000206H\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u0005*\u00020(H\u0001ø\u0001\u0000¢\u0006\u0004\b:\u00102J\u0017\u00109\u001a\u00020\u0005*\u00020+H\u0001ø\u0001\u0000¢\u0006\u0004\b;\u00100J\r\u0010<\u001a\u00020=*\u00020>H\u0001J\u0017\u0010?\u001a\u000206*\u000205H\u0001ø\u0001\u0000¢\u0006\u0004\b@\u00108J\u0017\u0010A\u001a\u00020+*\u00020(H\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010A\u001a\u00020+*\u00020\u0005H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010CJ\u001a\u0010A\u001a\u00020+*\u00020\u0014H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010ER\u0014\u0010\u0004\u001a\u00020\u00058\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$PostLookaheadMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private final class PostLookaheadMeasureScopeImpl implements SubcomposeMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;

        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            return this.$$delegate_0.layout(i, i2, map, function1);
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public int m5331roundToPxR2X_6o(long j) {
            return this.$$delegate_0.m5343roundToPxR2X_6o(j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public int m5332roundToPx0680j_4(float f) {
            return this.$$delegate_0.m5344roundToPx0680j_4(f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public float m5333toDpGaN1DYA(long j) {
            return this.$$delegate_0.m5345toDpGaN1DYA(j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m5334toDpu2uoSUM(float f) {
            return this.$$delegate_0.m5346toDpu2uoSUM(f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m5335toDpu2uoSUM(int i) {
            return this.$$delegate_0.m5347toDpu2uoSUM(i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public long m5336toDpSizekrfVVM(long j) {
            return this.$$delegate_0.m5348toDpSizekrfVVM(j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public float m5337toPxR2X_6o(long j) {
            return this.$$delegate_0.m5349toPxR2X_6o(j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public float m5338toPx0680j_4(float f) {
            return this.$$delegate_0.m5350toPx0680j_4(f);
        }

        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public long m5339toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.m5351toSizeXkaWNTQ(j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public long m5340toSp0xMU5do(float f) {
            return this.$$delegate_0.m5352toSp0xMU5do(f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m5341toSpkPz2Gy4(float f) {
            return this.$$delegate_0.m5353toSpkPz2Gy4(f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m5342toSpkPz2Gy4(int i) {
            return this.$$delegate_0.m5354toSpkPz2Gy4(i);
        }

        public PostLookaheadMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        public List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(obj);
            List<Measurable> childMeasurables$ui_release = layoutNode != null ? layoutNode.getChildMeasurables$ui_release() : null;
            if (childMeasurables$ui_release != null) {
                return childMeasurables$ui_release;
            }
            return LayoutNodeSubcompositionsState.this.postLookaheadSubcompose(obj, function2);
        }
    }

    /* access modifiers changed from: private */
    public final List<Measurable> postLookaheadSubcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (this.postLookaheadComposedSlotIds.getSize() >= this.currentPostLookaheadIndex) {
            int size = this.postLookaheadComposedSlotIds.getSize();
            int i = this.currentPostLookaheadIndex;
            if (size == i) {
                this.postLookaheadComposedSlotIds.add(obj);
            } else {
                this.postLookaheadComposedSlotIds.set(i, obj);
            }
            this.currentPostLookaheadIndex++;
            if (!this.precomposeMap.containsKey(obj)) {
                this.postLookaheadPrecomposeSlotHandleMap.put(obj, precompose(obj, function2));
                if (this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                    this.root.requestLookaheadRelayout$ui_release(true);
                } else {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(this.root, true, false, 2, (Object) null);
                }
            }
            LayoutNode layoutNode = this.precomposeMap.get(obj);
            if (layoutNode != null) {
                List<LayoutNodeLayoutDelegate.MeasurePassDelegate> childDelegates$ui_release = layoutNode.getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
                int size2 = childDelegates$ui_release.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    childDelegates$ui_release.get(i2).markDetachedFromParentLookaheadPass$ui_release();
                }
                if (childDelegates$ui_release != null) {
                    return childDelegates$ui_release;
                }
            }
            return CollectionsKt.emptyList();
        }
        throw new IllegalArgumentException("Error: currentPostLookaheadIndex cannot be greater than the size of thepostLookaheadComposedSlotIds list.".toString());
    }

    /* access modifiers changed from: private */
    public final void move(int i, int i2, int i3) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        this.root.move$ui_release(i, i2, i3);
        layoutNode.ignoreRemeasureRequests = false;
    }
}
