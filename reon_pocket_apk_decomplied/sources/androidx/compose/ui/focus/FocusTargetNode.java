package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00013B\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ/\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e0$H\bø\u0001\u0000¢\u0006\u0004\b&\u0010'J/\u0010(\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e0$H\bø\u0001\u0000¢\u0006\u0004\b)\u0010'J\r\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b,J\r\u0010-\u001a\u00020\u001eH\u0000¢\u0006\u0002\b.J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\r\u00101\u001a\u00020\u001eH\u0000¢\u0006\u0002\b2R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8V@VX\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "focusState", "getFocusState$annotations", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "isProcessingCustomEnter", "", "isProcessingCustomExit", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "()I", "setPreviouslyFocusedChildHash", "(I)V", "commitFocusState", "", "commitFocusState$ui_release", "fetchCustomEnter", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusRequester;", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "invalidateFocus", "invalidateFocus$ui_release", "onObservedReadsChanged", "onReset", "scheduleInvalidationForFocusEvents", "scheduleInvalidationForFocusEvents$ui_release", "FocusTargetElement", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTargetNode.kt */
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private FocusStateImpl committedFocusState = FocusStateImpl.Inactive;
    /* access modifiers changed from: private */
    public boolean isProcessingCustomEnter;
    /* access modifiers changed from: private */
    public boolean isProcessingCustomExit;
    private int previouslyFocusedChildHash;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTargetNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.ui.focus.FocusStateImpl[] r0 = androidx.compose.ui.focus.FocusStateImpl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Active     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Captured     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTargetNode.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void getFocusState$annotations() {
    }

    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    public /* synthetic */ ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNode.CC.$default$getProvidedValues(this);
    }

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getUncommittedFocusState(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.focus.FocusStateImpl getFocusState() {
        /*
            r1 = this;
            androidx.compose.ui.focus.FocusTransactionManager r0 = androidx.compose.ui.focus.FocusTargetNodeKt.getFocusTransactionManager(r1)
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.focus.FocusStateImpl r0 = r0.getUncommittedFocusState(r1)
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            androidx.compose.ui.focus.FocusStateImpl r0 = r1.committedFocusState
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTargetNode.getFocusState():androidx.compose.ui.focus.FocusStateImpl");
    }

    public void setFocusState(FocusStateImpl focusStateImpl) {
        FocusTargetNodeKt.requireTransactionManager(this).setUncommittedFocusState(this, focusStateImpl);
    }

    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    public final void setPreviouslyFocusedChildHash(int i) {
        this.previouslyFocusedChildHash = i;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    public void onObservedReadsChanged() {
        FocusStateImpl focusState = getFocusState();
        invalidateFocus$ui_release();
        if (focusState != getFocusState()) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    public void onReset() {
        int i = WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
        } else if (i == 3) {
            scheduleInvalidationForFocusEvents$ui_release();
            FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
            try {
                if (requireTransactionManager.ongoingTransaction) {
                    requireTransactionManager.cancelTransaction();
                }
                requireTransactionManager.beginTransaction();
                setFocusState(FocusStateImpl.Inactive);
                Unit unit = Unit.INSTANCE;
            } finally {
                requireTransactionManager.commitTransaction();
            }
        } else if (i == 4) {
            scheduleInvalidationForFocusEvents$ui_release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00be, code lost:
        r6 = r1.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.focus.FocusProperties fetchFocusProperties$ui_release() {
        /*
            r15 = this;
            androidx.compose.ui.focus.FocusPropertiesImpl r0 = new androidx.compose.ui.focus.FocusPropertiesImpl
            r0.<init>()
            r1 = r15
            androidx.compose.ui.node.DelegatableNode r1 = (androidx.compose.ui.node.DelegatableNode) r1
            r2 = 2048(0x800, float:2.87E-42)
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            r3 = 1024(0x400, float:1.435E-42)
            int r3 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r3)
            androidx.compose.ui.Modifier$Node r4 = r1.getNode()
            r5 = r2 | r3
            androidx.compose.ui.Modifier$Node r6 = r1.getNode()
            boolean r6 = r6.isAttached()
            if (r6 == 0) goto L_0x00d0
            androidx.compose.ui.Modifier$Node r6 = r1.getNode()
            androidx.compose.ui.node.LayoutNode r1 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r1)
        L_0x002c:
            if (r1 == 0) goto L_0x00cd
            androidx.compose.ui.node.NodeChain r7 = r1.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r7 = r7.getHead$ui_release()
            int r7 = r7.getAggregateChildKindSet$ui_release()
            r7 = r7 & r5
            r8 = 0
            if (r7 == 0) goto L_0x00b8
        L_0x003e:
            if (r6 == 0) goto L_0x00b8
            int r7 = r6.getKindSet$ui_release()
            r7 = r7 & r5
            if (r7 == 0) goto L_0x00b3
            if (r6 == r4) goto L_0x0052
            int r7 = r6.getKindSet$ui_release()
            r7 = r7 & r3
            if (r7 == 0) goto L_0x0052
            goto L_0x00cd
        L_0x0052:
            int r7 = r6.getKindSet$ui_release()
            r7 = r7 & r2
            if (r7 == 0) goto L_0x00b3
            r7 = r6
            r9 = r8
        L_0x005b:
            if (r7 == 0) goto L_0x00b3
            boolean r10 = r7 instanceof androidx.compose.ui.focus.FocusPropertiesModifierNode
            if (r10 == 0) goto L_0x006a
            androidx.compose.ui.focus.FocusPropertiesModifierNode r7 = (androidx.compose.ui.focus.FocusPropertiesModifierNode) r7
            r10 = r0
            androidx.compose.ui.focus.FocusProperties r10 = (androidx.compose.ui.focus.FocusProperties) r10
            r7.applyFocusProperties(r10)
            goto L_0x00ae
        L_0x006a:
            int r10 = r7.getKindSet$ui_release()
            r10 = r10 & r2
            if (r10 == 0) goto L_0x00ae
            boolean r10 = r7 instanceof androidx.compose.ui.node.DelegatingNode
            if (r10 == 0) goto L_0x00ae
            r10 = r7
            androidx.compose.ui.node.DelegatingNode r10 = (androidx.compose.ui.node.DelegatingNode) r10
            androidx.compose.ui.Modifier$Node r10 = r10.getDelegate$ui_release()
            r11 = 0
            r12 = r11
        L_0x007e:
            r13 = 1
            if (r10 == 0) goto L_0x00ab
            int r14 = r10.getKindSet$ui_release()
            r14 = r14 & r2
            if (r14 == 0) goto L_0x00a6
            int r12 = r12 + 1
            if (r12 != r13) goto L_0x008e
            r7 = r10
            goto L_0x00a6
        L_0x008e:
            if (r9 != 0) goto L_0x0099
            androidx.compose.runtime.collection.MutableVector r9 = new androidx.compose.runtime.collection.MutableVector
            r13 = 16
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r13]
            r9.<init>(r13, r11)
        L_0x0099:
            if (r7 == 0) goto L_0x00a1
            if (r9 == 0) goto L_0x00a0
            r9.add(r7)
        L_0x00a0:
            r7 = r8
        L_0x00a1:
            if (r9 == 0) goto L_0x00a6
            r9.add(r10)
        L_0x00a6:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild$ui_release()
            goto L_0x007e
        L_0x00ab:
            if (r12 != r13) goto L_0x00ae
            goto L_0x005b
        L_0x00ae:
            androidx.compose.ui.Modifier$Node r7 = androidx.compose.ui.node.DelegatableNodeKt.pop(r9)
            goto L_0x005b
        L_0x00b3:
            androidx.compose.ui.Modifier$Node r6 = r6.getParent$ui_release()
            goto L_0x003e
        L_0x00b8:
            androidx.compose.ui.node.LayoutNode r1 = r1.getParent$ui_release()
            if (r1 == 0) goto L_0x00ca
            androidx.compose.ui.node.NodeChain r6 = r1.getNodes$ui_release()
            if (r6 == 0) goto L_0x00ca
            androidx.compose.ui.Modifier$Node r6 = r6.getTail$ui_release()
            goto L_0x002c
        L_0x00ca:
            r6 = r8
            goto L_0x002c
        L_0x00cd:
            androidx.compose.ui.focus.FocusProperties r0 = (androidx.compose.ui.focus.FocusProperties) r0
            return r0
        L_0x00d0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitAncestors called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTargetNode.fetchFocusProperties$ui_release():androidx.compose.ui.focus.FocusProperties");
    }

    /* renamed from: fetchCustomEnter-aToIllA$ui_release  reason: not valid java name */
    public final void m3508fetchCustomEnteraToIllA$ui_release(int i, Function1<? super FocusRequester, Unit> function1) {
        if (!this.isProcessingCustomEnter) {
            this.isProcessingCustomEnter = true;
            try {
                FocusRequester invoke = fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m3476boximpl(i));
                if (invoke != FocusRequester.Companion.getDefault()) {
                    function1.invoke(invoke);
                }
            } finally {
                InlineMarker.finallyStart(1);
                this.isProcessingCustomEnter = false;
                InlineMarker.finallyEnd(1);
            }
        }
    }

    /* renamed from: fetchCustomExit-aToIllA$ui_release  reason: not valid java name */
    public final void m3509fetchCustomExitaToIllA$ui_release(int i, Function1<? super FocusRequester, Unit> function1) {
        if (!this.isProcessingCustomExit) {
            this.isProcessingCustomExit = true;
            try {
                FocusRequester invoke = fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m3476boximpl(i));
                if (invoke != FocusRequester.Companion.getDefault()) {
                    function1.invoke(invoke);
                }
            } finally {
                InlineMarker.finallyStart(1);
                this.isProcessingCustomExit = false;
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final void commitFocusState$ui_release() {
        FocusStateImpl uncommittedFocusState = FocusTargetNodeKt.requireTransactionManager(this).getUncommittedFocusState(this);
        if (uncommittedFocusState != null) {
            this.committedFocusState = uncommittedFocusState;
            return;
        }
        throw new IllegalStateException("committing a node that was not updated in the current transaction".toString());
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        int i = WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ObserverModifierNodeKt.observeReads(this, new FocusTargetNode$invalidateFocus$1(objectRef, this));
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                focusProperties = null;
            } else {
                focusProperties = (FocusProperties) objectRef.element;
            }
            if (!focusProperties.getCanFocus()) {
                DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0114, code lost:
        r8 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void scheduleInvalidationForFocusEvents$ui_release() {
        /*
            r15 = this;
            androidx.compose.ui.Modifier$Node r0 = r15.getNode()
            r1 = 4096(0x1000, float:5.74E-42)
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            r3 = 0
            r4 = r3
        L_0x000c:
            r5 = 16
            r6 = 0
            r7 = 1
            if (r0 == 0) goto L_0x0061
            boolean r8 = r0 instanceof androidx.compose.ui.focus.FocusEventModifierNode
            if (r8 == 0) goto L_0x001c
            androidx.compose.ui.focus.FocusEventModifierNode r0 = (androidx.compose.ui.focus.FocusEventModifierNode) r0
            androidx.compose.ui.focus.FocusEventModifierNodeKt.invalidateFocusEvent(r0)
            goto L_0x005c
        L_0x001c:
            int r8 = r0.getKindSet$ui_release()
            r8 = r8 & r2
            if (r8 == 0) goto L_0x005c
            boolean r8 = r0 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x005c
            r8 = r0
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r6
        L_0x002f:
            if (r8 == 0) goto L_0x0059
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r2
            if (r10 == 0) goto L_0x0054
            int r9 = r9 + 1
            if (r9 != r7) goto L_0x003e
            r0 = r8
            goto L_0x0054
        L_0x003e:
            if (r4 != 0) goto L_0x0047
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r5]
            r4.<init>(r10, r6)
        L_0x0047:
            if (r0 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x004e
            r4.add(r0)
        L_0x004e:
            r0 = r3
        L_0x004f:
            if (r4 == 0) goto L_0x0054
            r4.add(r8)
        L_0x0054:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x002f
        L_0x0059:
            if (r9 != r7) goto L_0x005c
            goto L_0x000c
        L_0x005c:
            androidx.compose.ui.Modifier$Node r0 = androidx.compose.ui.node.DelegatableNodeKt.pop(r4)
            goto L_0x000c
        L_0x0061:
            r0 = r15
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            r4 = 1024(0x400, float:1.435E-42)
            int r8 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r4)
            r2 = r2 | r8
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x0124
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x0085:
            if (r0 == 0) goto L_0x0123
            androidx.compose.ui.node.NodeChain r9 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r2
            if (r9 == 0) goto L_0x010e
        L_0x0096:
            if (r8 == 0) goto L_0x010e
            int r9 = r8.getKindSet$ui_release()
            r9 = r9 & r2
            if (r9 == 0) goto L_0x0109
            int r9 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r4)
            int r10 = r8.getKindSet$ui_release()
            r9 = r9 & r10
            if (r9 == 0) goto L_0x00ac
            goto L_0x0109
        L_0x00ac:
            boolean r9 = r8.isAttached()
            if (r9 == 0) goto L_0x0109
            int r9 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            r11 = r3
            r10 = r8
        L_0x00b8:
            if (r10 == 0) goto L_0x0109
            boolean r12 = r10 instanceof androidx.compose.ui.focus.FocusEventModifierNode
            if (r12 == 0) goto L_0x00c4
            androidx.compose.ui.focus.FocusEventModifierNode r10 = (androidx.compose.ui.focus.FocusEventModifierNode) r10
            androidx.compose.ui.focus.FocusEventModifierNodeKt.invalidateFocusEvent(r10)
            goto L_0x0104
        L_0x00c4:
            int r12 = r10.getKindSet$ui_release()
            r12 = r12 & r9
            if (r12 == 0) goto L_0x0104
            boolean r12 = r10 instanceof androidx.compose.ui.node.DelegatingNode
            if (r12 == 0) goto L_0x0104
            r12 = r10
            androidx.compose.ui.node.DelegatingNode r12 = (androidx.compose.ui.node.DelegatingNode) r12
            androidx.compose.ui.Modifier$Node r12 = r12.getDelegate$ui_release()
            r13 = r6
        L_0x00d7:
            if (r12 == 0) goto L_0x0101
            int r14 = r12.getKindSet$ui_release()
            r14 = r14 & r9
            if (r14 == 0) goto L_0x00fc
            int r13 = r13 + 1
            if (r13 != r7) goto L_0x00e6
            r10 = r12
            goto L_0x00fc
        L_0x00e6:
            if (r11 != 0) goto L_0x00ef
            androidx.compose.runtime.collection.MutableVector r11 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r14 = new androidx.compose.ui.Modifier.Node[r5]
            r11.<init>(r14, r6)
        L_0x00ef:
            if (r10 == 0) goto L_0x00f7
            if (r11 == 0) goto L_0x00f6
            r11.add(r10)
        L_0x00f6:
            r10 = r3
        L_0x00f7:
            if (r11 == 0) goto L_0x00fc
            r11.add(r12)
        L_0x00fc:
            androidx.compose.ui.Modifier$Node r12 = r12.getChild$ui_release()
            goto L_0x00d7
        L_0x0101:
            if (r13 != r7) goto L_0x0104
            goto L_0x00b8
        L_0x0104:
            androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.pop(r11)
            goto L_0x00b8
        L_0x0109:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x0096
        L_0x010e:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x0120
            androidx.compose.ui.node.NodeChain r8 = r0.getNodes$ui_release()
            if (r8 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Node r8 = r8.getTail$ui_release()
            goto L_0x0085
        L_0x0120:
            r8 = r3
            goto L_0x0085
        L_0x0123:
            return
        L_0x0124:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitAncestors called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTargetNode.scheduleInvalidationForFocusEvents$ui_release():void");
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTargetNode.kt */
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final int $stable = 0;
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        public boolean equals(Object obj) {
            return obj == this;
        }

        public int hashCode() {
            return 1739042953;
        }

        public void update(FocusTargetNode focusTargetNode) {
        }

        private FocusTargetElement() {
        }

        public FocusTargetNode create() {
            return new FocusTargetNode();
        }

        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("focusTarget");
        }
    }
}
