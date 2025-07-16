package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u001a\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001a\u0010(\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u000208H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u001aH\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\u001a\u0010:\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010'J\u001a\u0010<\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u00103J\u000e\u0010>\u001a\u0004\u0018\u00010?*\u00020@H\u0002JY\u0010A\u001a\u00020\u0005\"\n\b\u0000\u0010B\u0018\u0001*\u00020@*\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HB0D2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u00020\u00050\u0003H\bø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "clearFocus", "force", "", "refreshFocusEvents", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "dispatchKeyEvent-ZmokQxo", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getFocusRect", "Landroidx/compose/ui/geometry/Rect;", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseAncestors", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "traverseAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private final FocusInvalidationManager focusInvalidationManager;
    private final FocusTransactionManager focusTransactionManager;
    private MutableLongSet keysCurrentlyDown;
    public LayoutDirection layoutDirection;
    private final Modifier modifier;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusOwnerImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        static {
            /*
                androidx.compose.ui.focus.CustomDestinationResult[] r0 = androidx.compose.ui.focus.CustomDestinationResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.compose.ui.focus.CustomDestinationResult r2 = androidx.compose.ui.focus.CustomDestinationResult.Redirected     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.compose.ui.focus.CustomDestinationResult r3 = androidx.compose.ui.focus.CustomDestinationResult.Cancelled     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                androidx.compose.ui.focus.CustomDestinationResult r4 = androidx.compose.ui.focus.CustomDestinationResult.RedirectCancelled     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                androidx.compose.ui.focus.CustomDestinationResult r5 = androidx.compose.ui.focus.CustomDestinationResult.None     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                androidx.compose.ui.focus.FocusStateImpl[] r0 = androidx.compose.ui.focus.FocusStateImpl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.FocusStateImpl r5 = androidx.compose.ui.focus.FocusStateImpl.Active     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Captured     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.WhenMappings.<clinit>():void");
        }
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1) {
        this.focusInvalidationManager = new FocusInvalidationManager(function1);
        this.focusTransactionManager = new FocusTransactionManager();
        this.modifier = new FocusOwnerImpl$modifier$1(this);
    }

    public final FocusTargetNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection2 = this.layoutDirection;
        if (layoutDirection2 != null) {
            return layoutDirection2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection2) {
        this.layoutDirection = layoutDirection2;
    }

    public void takeFocus() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusState(FocusStateImpl.Active);
        }
    }

    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    public void clearFocus(boolean z) {
        clearFocus(z, true);
    }

    public void clearFocus(boolean z, boolean z2) {
        FocusStateImpl focusStateImpl;
        FocusTransactionManager focusTransactionManager2 = getFocusTransactionManager();
        try {
            if (focusTransactionManager2.ongoingTransaction) {
                focusTransactionManager2.cancelTransaction();
            }
            focusTransactionManager2.beginTransaction();
            if (!z) {
                int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m3510performCustomClearFocusMxy_nc0(this.rootFocusNode, FocusDirection.Companion.m3487getExitdhqQ8s()).ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
            }
            FocusStateImpl focusState = this.rootFocusNode.getFocusState();
            if (FocusTransactionsKt.clearFocus(this.rootFocusNode, z, z2)) {
                FocusTargetNode focusTargetNode = this.rootFocusNode;
                int i2 = WhenMappings.$EnumSwitchMapping$1[focusState.ordinal()];
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    focusStateImpl = FocusStateImpl.Active;
                } else if (i2 == 4) {
                    focusStateImpl = FocusStateImpl.Inactive;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                focusTargetNode.setFocusState(focusStateImpl);
            }
            Unit unit = Unit.INSTANCE;
            focusTransactionManager2.commitTransaction();
        } finally {
            focusTransactionManager2.commitTransaction();
        }
    }

    /* renamed from: moveFocus-3ESFkO8  reason: not valid java name */
    public boolean m3501moveFocus3ESFkO8(int i) {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            return false;
        }
        FocusRequester r2 = FocusTraversalKt.m3514customFocusSearchOMvw8(findActiveFocusNode, i, getLayoutDirection());
        if (r2 == FocusRequester.Companion.getDefault()) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            boolean r0 = FocusTraversalKt.m3515focusSearchsMXa3k8(this.rootFocusNode, i, getLayoutDirection(), new FocusOwnerImpl$moveFocus$foundNextItem$1(findActiveFocusNode, this, i, booleanRef));
            if (booleanRef.element) {
                return false;
            }
            if (r0 || m3498wrapAroundFocus3ESFkO8(i)) {
                return true;
            }
            return false;
        } else if (r2 == FocusRequester.Companion.getCancel() || !r2.focus$ui_release()) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00af, code lost:
        r8 = r0.getNodes$ui_release();
     */
    /* renamed from: dispatchKeyEvent-ZmokQxo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3500dispatchKeyEventZmokQxo(android.view.KeyEvent r15) {
        /*
            r14 = this;
            boolean r0 = r14.m3497validateKeyEventZmokQxo(r15)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            androidx.compose.ui.focus.FocusTargetNode r0 = r14.rootFocusNode
            androidx.compose.ui.focus.FocusTargetNode r0 = androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(r0)
            if (r0 == 0) goto L_0x0274
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            androidx.compose.ui.Modifier$Node r2 = r14.lastLocalKeyInputNode(r0)
            java.lang.String r3 = "visitAncestors called on an unattached node"
            r4 = 8192(0x2000, float:1.14794E-41)
            r5 = 16
            r6 = 0
            r7 = 1
            if (r2 != 0) goto L_0x00d3
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r4)
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x00c9
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x003b:
            if (r0 == 0) goto L_0x00bd
            androidx.compose.ui.node.NodeChain r9 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r2
            if (r9 == 0) goto L_0x00a9
        L_0x004c:
            if (r8 == 0) goto L_0x00a9
            int r9 = r8.getKindSet$ui_release()
            r9 = r9 & r2
            if (r9 == 0) goto L_0x00a4
            r10 = r6
            r9 = r8
        L_0x0057:
            if (r9 == 0) goto L_0x00a4
            boolean r11 = r9 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r11 == 0) goto L_0x005f
            goto L_0x00be
        L_0x005f:
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x009f
            boolean r11 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x009f
            r11 = r9
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r1
        L_0x0072:
            if (r11 == 0) goto L_0x009c
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r2
            if (r13 == 0) goto L_0x0097
            int r12 = r12 + 1
            if (r12 != r7) goto L_0x0081
            r9 = r11
            goto L_0x0097
        L_0x0081:
            if (r10 != 0) goto L_0x008a
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r5]
            r10.<init>(r13, r1)
        L_0x008a:
            if (r9 == 0) goto L_0x0092
            if (r10 == 0) goto L_0x0091
            r10.add(r9)
        L_0x0091:
            r9 = r6
        L_0x0092:
            if (r10 == 0) goto L_0x0097
            r10.add(r11)
        L_0x0097:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0072
        L_0x009c:
            if (r12 != r7) goto L_0x009f
            goto L_0x0057
        L_0x009f:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x0057
        L_0x00a4:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x004c
        L_0x00a9:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00ba
            androidx.compose.ui.node.NodeChain r8 = r0.getNodes$ui_release()
            if (r8 == 0) goto L_0x00ba
            androidx.compose.ui.Modifier$Node r8 = r8.getTail$ui_release()
            goto L_0x003b
        L_0x00ba:
            r8 = r6
            goto L_0x003b
        L_0x00bd:
            r9 = r6
        L_0x00be:
            androidx.compose.ui.input.key.KeyInputModifierNode r9 = (androidx.compose.ui.input.key.KeyInputModifierNode) r9
            if (r9 == 0) goto L_0x00c7
            androidx.compose.ui.Modifier$Node r2 = r9.getNode()
            goto L_0x00d3
        L_0x00c7:
            r2 = r6
            goto L_0x00d3
        L_0x00c9:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r3.toString()
            r15.<init>(r0)
            throw r15
        L_0x00d3:
            if (r2 == 0) goto L_0x0273
            androidx.compose.ui.node.DelegatableNode r2 = (androidx.compose.ui.node.DelegatableNode) r2
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r4)
            androidx.compose.ui.Modifier$Node r4 = r2.getNode()
            boolean r4 = r4.isAttached()
            if (r4 == 0) goto L_0x0269
            androidx.compose.ui.Modifier$Node r3 = r2.getNode()
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r4 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r2)
            r8 = r6
        L_0x00f2:
            if (r4 == 0) goto L_0x0180
            androidx.compose.ui.node.NodeChain r9 = r4.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x016b
        L_0x0103:
            if (r3 == 0) goto L_0x016b
            int r9 = r3.getKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x0166
            r9 = r3
            r10 = r6
        L_0x010e:
            if (r9 == 0) goto L_0x0166
            boolean r11 = r9 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r11 == 0) goto L_0x0121
            if (r8 != 0) goto L_0x011d
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
        L_0x011d:
            r8.add(r9)
            goto L_0x0161
        L_0x0121:
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x0161
            boolean r11 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x0161
            r11 = r9
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r1
        L_0x0134:
            if (r11 == 0) goto L_0x015e
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r0
            if (r13 == 0) goto L_0x0159
            int r12 = r12 + 1
            if (r12 != r7) goto L_0x0143
            r9 = r11
            goto L_0x0159
        L_0x0143:
            if (r10 != 0) goto L_0x014c
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r5]
            r10.<init>(r13, r1)
        L_0x014c:
            if (r9 == 0) goto L_0x0154
            if (r10 == 0) goto L_0x0153
            r10.add(r9)
        L_0x0153:
            r9 = r6
        L_0x0154:
            if (r10 == 0) goto L_0x0159
            r10.add(r11)
        L_0x0159:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0134
        L_0x015e:
            if (r12 != r7) goto L_0x0161
            goto L_0x010e
        L_0x0161:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x010e
        L_0x0166:
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            goto L_0x0103
        L_0x016b:
            androidx.compose.ui.node.LayoutNode r4 = r4.getParent$ui_release()
            if (r4 == 0) goto L_0x017d
            androidx.compose.ui.node.NodeChain r3 = r4.getNodes$ui_release()
            if (r3 == 0) goto L_0x017d
            androidx.compose.ui.Modifier$Node r3 = r3.getTail$ui_release()
            goto L_0x00f2
        L_0x017d:
            r3 = r6
            goto L_0x00f2
        L_0x0180:
            if (r8 == 0) goto L_0x019e
            int r3 = r8.size()
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x019e
        L_0x018a:
            int r4 = r3 + -1
            java.lang.Object r3 = r8.get(r3)
            androidx.compose.ui.input.key.KeyInputModifierNode r3 = (androidx.compose.ui.input.key.KeyInputModifierNode) r3
            boolean r3 = r3.m4965onPreKeyEventZmokQxo(r15)
            if (r3 == 0) goto L_0x0199
            return r7
        L_0x0199:
            if (r4 >= 0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r3 = r4
            goto L_0x018a
        L_0x019e:
            androidx.compose.ui.Modifier$Node r3 = r2.getNode()
            r4 = r6
        L_0x01a3:
            if (r3 == 0) goto L_0x01f7
            boolean r9 = r3 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r9 == 0) goto L_0x01b2
            androidx.compose.ui.input.key.KeyInputModifierNode r3 = (androidx.compose.ui.input.key.KeyInputModifierNode) r3
            boolean r3 = r3.m4965onPreKeyEventZmokQxo(r15)
            if (r3 == 0) goto L_0x01f2
            return r7
        L_0x01b2:
            int r9 = r3.getKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x01f2
            boolean r9 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r9 == 0) goto L_0x01f2
            r9 = r3
            androidx.compose.ui.node.DelegatingNode r9 = (androidx.compose.ui.node.DelegatingNode) r9
            androidx.compose.ui.Modifier$Node r9 = r9.getDelegate$ui_release()
            r10 = r1
        L_0x01c5:
            if (r9 == 0) goto L_0x01ef
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x01ea
            int r10 = r10 + 1
            if (r10 != r7) goto L_0x01d4
            r3 = r9
            goto L_0x01ea
        L_0x01d4:
            if (r4 != 0) goto L_0x01dd
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r5]
            r4.<init>(r11, r1)
        L_0x01dd:
            if (r3 == 0) goto L_0x01e5
            if (r4 == 0) goto L_0x01e4
            r4.add(r3)
        L_0x01e4:
            r3 = r6
        L_0x01e5:
            if (r4 == 0) goto L_0x01ea
            r4.add(r9)
        L_0x01ea:
            androidx.compose.ui.Modifier$Node r9 = r9.getChild$ui_release()
            goto L_0x01c5
        L_0x01ef:
            if (r10 != r7) goto L_0x01f2
            goto L_0x01a3
        L_0x01f2:
            androidx.compose.ui.Modifier$Node r3 = androidx.compose.ui.node.DelegatableNodeKt.pop(r4)
            goto L_0x01a3
        L_0x01f7:
            androidx.compose.ui.Modifier$Node r2 = r2.getNode()
            r3 = r6
        L_0x01fc:
            if (r2 == 0) goto L_0x0250
            boolean r4 = r2 instanceof androidx.compose.ui.input.key.KeyInputModifierNode
            if (r4 == 0) goto L_0x020b
            androidx.compose.ui.input.key.KeyInputModifierNode r2 = (androidx.compose.ui.input.key.KeyInputModifierNode) r2
            boolean r2 = r2.m4964onKeyEventZmokQxo(r15)
            if (r2 == 0) goto L_0x024b
            return r7
        L_0x020b:
            int r4 = r2.getKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto L_0x024b
            boolean r4 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r4 == 0) goto L_0x024b
            r4 = r2
            androidx.compose.ui.node.DelegatingNode r4 = (androidx.compose.ui.node.DelegatingNode) r4
            androidx.compose.ui.Modifier$Node r4 = r4.getDelegate$ui_release()
            r9 = r1
        L_0x021e:
            if (r4 == 0) goto L_0x0248
            int r10 = r4.getKindSet$ui_release()
            r10 = r10 & r0
            if (r10 == 0) goto L_0x0243
            int r9 = r9 + 1
            if (r9 != r7) goto L_0x022d
            r2 = r4
            goto L_0x0243
        L_0x022d:
            if (r3 != 0) goto L_0x0236
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r5]
            r3.<init>(r10, r1)
        L_0x0236:
            if (r2 == 0) goto L_0x023e
            if (r3 == 0) goto L_0x023d
            r3.add(r2)
        L_0x023d:
            r2 = r6
        L_0x023e:
            if (r3 == 0) goto L_0x0243
            r3.add(r4)
        L_0x0243:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L_0x021e
        L_0x0248:
            if (r9 != r7) goto L_0x024b
            goto L_0x01fc
        L_0x024b:
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.pop(r3)
            goto L_0x01fc
        L_0x0250:
            if (r8 == 0) goto L_0x0273
            int r0 = r8.size()
            r2 = r1
        L_0x0257:
            if (r2 >= r0) goto L_0x0273
            java.lang.Object r3 = r8.get(r2)
            androidx.compose.ui.input.key.KeyInputModifierNode r3 = (androidx.compose.ui.input.key.KeyInputModifierNode) r3
            boolean r3 = r3.m4964onKeyEventZmokQxo(r15)
            if (r3 == 0) goto L_0x0266
            return r7
        L_0x0266:
            int r2 = r2 + 1
            goto L_0x0257
        L_0x0269:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r3.toString()
            r15.<init>(r0)
            throw r15
        L_0x0273:
            return r1
        L_0x0274:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "Event can't be processed because we do not have an active focus target."
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m3500dispatchKeyEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a2, code lost:
        r8 = r0.getNodes$ui_release();
     */
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3499dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent r15) {
        /*
            r14 = this;
            androidx.compose.ui.focus.FocusTargetNode r0 = r14.rootFocusNode
            androidx.compose.ui.focus.FocusTargetNode r0 = androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(r0)
            java.lang.String r1 = "visitAncestors called on an unattached node"
            r2 = 131072(0x20000, float:1.83671E-40)
            r3 = 16
            r4 = 0
            r5 = 0
            r6 = 1
            if (r0 == 0) goto L_0x00be
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            int r7 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x002e:
            if (r0 == 0) goto L_0x00b0
            androidx.compose.ui.node.NodeChain r9 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x009c
        L_0x003f:
            if (r8 == 0) goto L_0x009c
            int r9 = r8.getKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x0097
            r10 = r5
            r9 = r8
        L_0x004a:
            if (r9 == 0) goto L_0x0097
            boolean r11 = r9 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r11 == 0) goto L_0x0052
            goto L_0x00b1
        L_0x0052:
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r7
            if (r11 == 0) goto L_0x0092
            boolean r11 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x0092
            r11 = r9
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0065:
            if (r11 == 0) goto L_0x008f
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r7
            if (r13 == 0) goto L_0x008a
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x0074
            r9 = r11
            goto L_0x008a
        L_0x0074:
            if (r10 != 0) goto L_0x007d
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x007d:
            if (r9 == 0) goto L_0x0085
            if (r10 == 0) goto L_0x0084
            r10.add(r9)
        L_0x0084:
            r9 = r5
        L_0x0085:
            if (r10 == 0) goto L_0x008a
            r10.add(r11)
        L_0x008a:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0065
        L_0x008f:
            if (r12 != r6) goto L_0x0092
            goto L_0x004a
        L_0x0092:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x004a
        L_0x0097:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x003f
        L_0x009c:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00ad
            androidx.compose.ui.node.NodeChain r8 = r0.getNodes$ui_release()
            if (r8 == 0) goto L_0x00ad
            androidx.compose.ui.Modifier$Node r8 = r8.getTail$ui_release()
            goto L_0x002e
        L_0x00ad:
            r8 = r5
            goto L_0x002e
        L_0x00b0:
            r9 = r5
        L_0x00b1:
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r9 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r9
            goto L_0x00bf
        L_0x00b4:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x00be:
            r9 = r5
        L_0x00bf:
            if (r9 == 0) goto L_0x025f
            androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.ui.node.DelegatableNode) r9
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r2 = r9.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x0255
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r9)
            r7 = r5
        L_0x00de:
            if (r2 == 0) goto L_0x016c
            androidx.compose.ui.node.NodeChain r8 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r8 = r8.getHead$ui_release()
            int r8 = r8.getAggregateChildKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0157
        L_0x00ef:
            if (r1 == 0) goto L_0x0157
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0152
            r8 = r1
            r10 = r5
        L_0x00fa:
            if (r8 == 0) goto L_0x0152
            boolean r11 = r8 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r11 == 0) goto L_0x010d
            if (r7 != 0) goto L_0x0109
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
        L_0x0109:
            r7.add(r8)
            goto L_0x014d
        L_0x010d:
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x014d
            boolean r11 = r8 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x014d
            r11 = r8
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0120:
            if (r11 == 0) goto L_0x014a
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r0
            if (r13 == 0) goto L_0x0145
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x012f
            r8 = r11
            goto L_0x0145
        L_0x012f:
            if (r10 != 0) goto L_0x0138
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x0138:
            if (r8 == 0) goto L_0x0140
            if (r10 == 0) goto L_0x013f
            r10.add(r8)
        L_0x013f:
            r8 = r5
        L_0x0140:
            if (r10 == 0) goto L_0x0145
            r10.add(r11)
        L_0x0145:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0120
        L_0x014a:
            if (r12 != r6) goto L_0x014d
            goto L_0x00fa
        L_0x014d:
            androidx.compose.ui.Modifier$Node r8 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x00fa
        L_0x0152:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x00ef
        L_0x0157:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x0169
            androidx.compose.ui.node.NodeChain r1 = r2.getNodes$ui_release()
            if (r1 == 0) goto L_0x0169
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x00de
        L_0x0169:
            r1 = r5
            goto L_0x00de
        L_0x016c:
            if (r7 == 0) goto L_0x018a
            int r1 = r7.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x018a
        L_0x0176:
            int r2 = r1 + -1
            java.lang.Object r1 = r7.get(r1)
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r1 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r1
            boolean r1 = r1.m4970onPreInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r1 == 0) goto L_0x0185
            return r6
        L_0x0185:
            if (r2 >= 0) goto L_0x0188
            goto L_0x018a
        L_0x0188:
            r1 = r2
            goto L_0x0176
        L_0x018a:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x018f:
            if (r1 == 0) goto L_0x01e3
            boolean r8 = r1 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r8 == 0) goto L_0x019e
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r1 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r1
            boolean r1 = r1.m4970onPreInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r1 == 0) goto L_0x01de
            return r6
        L_0x019e:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x01de
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x01de
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r10 = r4
        L_0x01b1:
            if (r8 == 0) goto L_0x01db
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x01d6
            int r10 = r10 + 1
            if (r10 != r6) goto L_0x01c0
            r1 = r8
            goto L_0x01d6
        L_0x01c0:
            if (r2 != 0) goto L_0x01c9
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r11, r4)
        L_0x01c9:
            if (r1 == 0) goto L_0x01d1
            if (r2 == 0) goto L_0x01d0
            r2.add(r1)
        L_0x01d0:
            r1 = r5
        L_0x01d1:
            if (r2 == 0) goto L_0x01d6
            r2.add(r8)
        L_0x01d6:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x01b1
        L_0x01db:
            if (r10 != r6) goto L_0x01de
            goto L_0x018f
        L_0x01de:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x018f
        L_0x01e3:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x01e8:
            if (r1 == 0) goto L_0x023c
            boolean r8 = r1 instanceof androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
            if (r8 == 0) goto L_0x01f7
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r1 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r1
            boolean r1 = r1.m4969onInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r1 == 0) goto L_0x0237
            return r6
        L_0x01f7:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0237
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x0237
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r4
        L_0x020a:
            if (r8 == 0) goto L_0x0234
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r0
            if (r10 == 0) goto L_0x022f
            int r9 = r9 + 1
            if (r9 != r6) goto L_0x0219
            r1 = r8
            goto L_0x022f
        L_0x0219:
            if (r2 != 0) goto L_0x0222
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r10, r4)
        L_0x0222:
            if (r1 == 0) goto L_0x022a
            if (r2 == 0) goto L_0x0229
            r2.add(r1)
        L_0x0229:
            r1 = r5
        L_0x022a:
            if (r2 == 0) goto L_0x022f
            r2.add(r8)
        L_0x022f:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x020a
        L_0x0234:
            if (r9 != r6) goto L_0x0237
            goto L_0x01e8
        L_0x0237:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x01e8
        L_0x023c:
            if (r7 == 0) goto L_0x025f
            int r0 = r7.size()
            r1 = r4
        L_0x0243:
            if (r1 >= r0) goto L_0x025f
            java.lang.Object r2 = r7.get(r1)
            androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode r2 = (androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r2
            boolean r2 = r2.m4969onInterceptKeyBeforeSoftKeyboardZmokQxo(r15)
            if (r2 == 0) goto L_0x0252
            return r6
        L_0x0252:
            int r1 = r1 + 1
            goto L_0x0243
        L_0x0255:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x025f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m3499dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a2, code lost:
        r8 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent r15) {
        /*
            r14 = this;
            androidx.compose.ui.focus.FocusTargetNode r0 = r14.rootFocusNode
            androidx.compose.ui.focus.FocusTargetNode r0 = androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(r0)
            java.lang.String r1 = "visitAncestors called on an unattached node"
            r2 = 16384(0x4000, float:2.2959E-41)
            r3 = 16
            r4 = 0
            r5 = 0
            r6 = 1
            if (r0 == 0) goto L_0x00be
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            int r7 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            boolean r8 = r8.isAttached()
            if (r8 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Node r8 = r0.getNode()
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x002e:
            if (r0 == 0) goto L_0x00b0
            androidx.compose.ui.node.NodeChain r9 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x009c
        L_0x003f:
            if (r8 == 0) goto L_0x009c
            int r9 = r8.getKindSet$ui_release()
            r9 = r9 & r7
            if (r9 == 0) goto L_0x0097
            r10 = r5
            r9 = r8
        L_0x004a:
            if (r9 == 0) goto L_0x0097
            boolean r11 = r9 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r11 == 0) goto L_0x0052
            goto L_0x00b1
        L_0x0052:
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r7
            if (r11 == 0) goto L_0x0092
            boolean r11 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x0092
            r11 = r9
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0065:
            if (r11 == 0) goto L_0x008f
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r7
            if (r13 == 0) goto L_0x008a
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x0074
            r9 = r11
            goto L_0x008a
        L_0x0074:
            if (r10 != 0) goto L_0x007d
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x007d:
            if (r9 == 0) goto L_0x0085
            if (r10 == 0) goto L_0x0084
            r10.add(r9)
        L_0x0084:
            r9 = r5
        L_0x0085:
            if (r10 == 0) goto L_0x008a
            r10.add(r11)
        L_0x008a:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0065
        L_0x008f:
            if (r12 != r6) goto L_0x0092
            goto L_0x004a
        L_0x0092:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x004a
        L_0x0097:
            androidx.compose.ui.Modifier$Node r8 = r8.getParent$ui_release()
            goto L_0x003f
        L_0x009c:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00ad
            androidx.compose.ui.node.NodeChain r8 = r0.getNodes$ui_release()
            if (r8 == 0) goto L_0x00ad
            androidx.compose.ui.Modifier$Node r8 = r8.getTail$ui_release()
            goto L_0x002e
        L_0x00ad:
            r8 = r5
            goto L_0x002e
        L_0x00b0:
            r9 = r5
        L_0x00b1:
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r9 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r9
            goto L_0x00bf
        L_0x00b4:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x00be:
            r9 = r5
        L_0x00bf:
            if (r9 == 0) goto L_0x025f
            androidx.compose.ui.node.DelegatableNode r9 = (androidx.compose.ui.node.DelegatableNode) r9
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r2 = r9.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x0255
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r9)
            r7 = r5
        L_0x00de:
            if (r2 == 0) goto L_0x016c
            androidx.compose.ui.node.NodeChain r8 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r8 = r8.getHead$ui_release()
            int r8 = r8.getAggregateChildKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0157
        L_0x00ef:
            if (r1 == 0) goto L_0x0157
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0152
            r8 = r1
            r10 = r5
        L_0x00fa:
            if (r8 == 0) goto L_0x0152
            boolean r11 = r8 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r11 == 0) goto L_0x010d
            if (r7 != 0) goto L_0x0109
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
        L_0x0109:
            r7.add(r8)
            goto L_0x014d
        L_0x010d:
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x014d
            boolean r11 = r8 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x014d
            r11 = r8
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r4
        L_0x0120:
            if (r11 == 0) goto L_0x014a
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r0
            if (r13 == 0) goto L_0x0145
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x012f
            r8 = r11
            goto L_0x0145
        L_0x012f:
            if (r10 != 0) goto L_0x0138
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r3]
            r10.<init>(r13, r4)
        L_0x0138:
            if (r8 == 0) goto L_0x0140
            if (r10 == 0) goto L_0x013f
            r10.add(r8)
        L_0x013f:
            r8 = r5
        L_0x0140:
            if (r10 == 0) goto L_0x0145
            r10.add(r11)
        L_0x0145:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x0120
        L_0x014a:
            if (r12 != r6) goto L_0x014d
            goto L_0x00fa
        L_0x014d:
            androidx.compose.ui.Modifier$Node r8 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x00fa
        L_0x0152:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x00ef
        L_0x0157:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x0169
            androidx.compose.ui.node.NodeChain r1 = r2.getNodes$ui_release()
            if (r1 == 0) goto L_0x0169
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x00de
        L_0x0169:
            r1 = r5
            goto L_0x00de
        L_0x016c:
            if (r7 == 0) goto L_0x018a
            int r1 = r7.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x018a
        L_0x0176:
            int r2 = r1 + -1
            java.lang.Object r1 = r7.get(r1)
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r1 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r1
            boolean r1 = r1.onPreRotaryScrollEvent(r15)
            if (r1 == 0) goto L_0x0185
            return r6
        L_0x0185:
            if (r2 >= 0) goto L_0x0188
            goto L_0x018a
        L_0x0188:
            r1 = r2
            goto L_0x0176
        L_0x018a:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x018f:
            if (r1 == 0) goto L_0x01e3
            boolean r8 = r1 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r8 == 0) goto L_0x019e
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r1 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r1
            boolean r1 = r1.onPreRotaryScrollEvent(r15)
            if (r1 == 0) goto L_0x01de
            return r6
        L_0x019e:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x01de
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x01de
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r10 = r4
        L_0x01b1:
            if (r8 == 0) goto L_0x01db
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r0
            if (r11 == 0) goto L_0x01d6
            int r10 = r10 + 1
            if (r10 != r6) goto L_0x01c0
            r1 = r8
            goto L_0x01d6
        L_0x01c0:
            if (r2 != 0) goto L_0x01c9
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r11, r4)
        L_0x01c9:
            if (r1 == 0) goto L_0x01d1
            if (r2 == 0) goto L_0x01d0
            r2.add(r1)
        L_0x01d0:
            r1 = r5
        L_0x01d1:
            if (r2 == 0) goto L_0x01d6
            r2.add(r8)
        L_0x01d6:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x01b1
        L_0x01db:
            if (r10 != r6) goto L_0x01de
            goto L_0x018f
        L_0x01de:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x018f
        L_0x01e3:
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            r2 = r5
        L_0x01e8:
            if (r1 == 0) goto L_0x023c
            boolean r8 = r1 instanceof androidx.compose.ui.input.rotary.RotaryInputModifierNode
            if (r8 == 0) goto L_0x01f7
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r1 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r1
            boolean r1 = r1.onRotaryScrollEvent(r15)
            if (r1 == 0) goto L_0x0237
            return r6
        L_0x01f7:
            int r8 = r1.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x0237
            boolean r8 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x0237
            r8 = r1
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r4
        L_0x020a:
            if (r8 == 0) goto L_0x0234
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r0
            if (r10 == 0) goto L_0x022f
            int r9 = r9 + 1
            if (r9 != r6) goto L_0x0219
            r1 = r8
            goto L_0x022f
        L_0x0219:
            if (r2 != 0) goto L_0x0222
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r2.<init>(r10, r4)
        L_0x0222:
            if (r1 == 0) goto L_0x022a
            if (r2 == 0) goto L_0x0229
            r2.add(r1)
        L_0x0229:
            r1 = r5
        L_0x022a:
            if (r2 == 0) goto L_0x022f
            r2.add(r8)
        L_0x022f:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x020a
        L_0x0234:
            if (r9 != r6) goto L_0x0237
            goto L_0x01e8
        L_0x0237:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x01e8
        L_0x023c:
            if (r7 == 0) goto L_0x025f
            int r0 = r7.size()
            r1 = r4
        L_0x0243:
            if (r1 >= r0) goto L_0x025f
            java.lang.Object r2 = r7.get(r1)
            androidx.compose.ui.input.rotary.RotaryInputModifierNode r2 = (androidx.compose.ui.input.rotary.RotaryInputModifierNode) r2
            boolean r2 = r2.onRotaryScrollEvent(r15)
            if (r2 == 0) goto L_0x0252
            return r6
        L_0x0252:
            int r1 = r1 + 1
            goto L_0x0243
        L_0x0255:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x025f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent):boolean");
    }

    public void scheduleInvalidation(FocusTargetNode focusTargetNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusTargetNode);
    }

    public void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusEventModifierNode);
    }

    public void scheduleInvalidation(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusPropertiesModifierNode);
    }

    public Rect getFocusRect() {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    /* renamed from: wrapAroundFocus-3ESFkO8  reason: not valid java name */
    private final boolean m3498wrapAroundFocus3ESFkO8(int i) {
        if (this.rootFocusNode.getFocusState().getHasFocus() && !this.rootFocusNode.getFocusState().isFocused()) {
            if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3489getNextdhqQ8s()) ? true : FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3490getPreviousdhqQ8s())) {
                clearFocus(false);
                if (!this.rootFocusNode.getFocusState().isFocused()) {
                    return false;
                }
                return m3501moveFocus3ESFkO8(i);
            }
        }
        return false;
    }

    /* renamed from: validateKeyEvent-ZmokQxo  reason: not valid java name */
    private final boolean m3497validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long r0 = KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent);
        int r5 = KeyEvent_androidKt.m4958getTypeZmokQxo(keyEvent);
        if (KeyEventType.m4950equalsimpl0(r5, KeyEventType.Companion.m4954getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(r0);
        } else if (KeyEventType.m4950equalsimpl0(r5, KeyEventType.Companion.m4955getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(r0)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(r0);
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        r2 = r3.getNodes$ui_release();
     */
    /* renamed from: traverseAncestors-Y-YKmho  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final /* synthetic */ <T extends androidx.compose.ui.node.DelegatableNode> void m3496traverseAncestorsYYKmho(androidx.compose.ui.node.DelegatableNode r17, int r18, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r19, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r20) {
        /*
            r16 = this;
            r0 = r19
            r1 = r20
            androidx.compose.ui.Modifier$Node r2 = r17.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x01e7
            androidx.compose.ui.Modifier$Node r2 = r17.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r3 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r17)
            r4 = 0
            r5 = r4
        L_0x001c:
            r6 = 16
            java.lang.String r7 = "T"
            r8 = 3
            r9 = 0
            r10 = 1
            if (r3 == 0) goto L_0x00d7
            androidx.compose.ui.node.NodeChain r11 = r3.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r11 = r11.getHead$ui_release()
            int r11 = r11.getAggregateChildKindSet$ui_release()
            r11 = r11 & r18
            if (r11 == 0) goto L_0x00c2
        L_0x0035:
            if (r2 == 0) goto L_0x00c2
            int r11 = r2.getKindSet$ui_release()
            r11 = r11 & r18
            if (r11 == 0) goto L_0x00bc
            r11 = r2
            androidx.compose.ui.Modifier$Node r11 = (androidx.compose.ui.Modifier.Node) r11
            r11 = r2
            r12 = r4
        L_0x0044:
            if (r11 == 0) goto L_0x00bc
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r8, r7)
            boolean r13 = r11 instanceof java.lang.Object
            if (r13 == 0) goto L_0x005d
            if (r5 != 0) goto L_0x0056
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
        L_0x0056:
            r13 = r5
            java.util.List r13 = (java.util.List) r13
            r5.add(r11)
            goto L_0x00b4
        L_0x005d:
            r13 = r11
            androidx.compose.ui.Modifier$Node r13 = (androidx.compose.ui.Modifier.Node) r13
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r18
            if (r13 == 0) goto L_0x00b4
            boolean r13 = r11 instanceof androidx.compose.ui.node.DelegatingNode
            if (r13 == 0) goto L_0x00b4
            r13 = r11
            androidx.compose.ui.node.DelegatingNode r13 = (androidx.compose.ui.node.DelegatingNode) r13
            androidx.compose.ui.Modifier$Node r13 = r13.getDelegate$ui_release()
            r14 = r9
        L_0x0074:
            if (r13 == 0) goto L_0x00b1
            r15 = r13
            androidx.compose.ui.Modifier$Node r15 = (androidx.compose.ui.Modifier.Node) r15
            int r15 = r13.getKindSet$ui_release()
            r15 = r15 & r18
            if (r15 == 0) goto L_0x00ac
            int r14 = r14 + 1
            if (r14 != r10) goto L_0x0087
            r11 = r13
            goto L_0x00ac
        L_0x0087:
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
            if (r12 != 0) goto L_0x0096
            androidx.compose.runtime.collection.MutableVector r12 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r15 = new androidx.compose.ui.Modifier.Node[r6]
            r12.<init>(r15, r9)
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
        L_0x0096:
            r15 = r11
            androidx.compose.ui.Modifier$Node r15 = (androidx.compose.ui.Modifier.Node) r15
            if (r11 == 0) goto L_0x00a4
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
            if (r12 == 0) goto L_0x00a3
            r12.add(r11)
        L_0x00a3:
            r11 = r4
        L_0x00a4:
            r15 = r12
            androidx.compose.runtime.collection.MutableVector r15 = (androidx.compose.runtime.collection.MutableVector) r15
            if (r12 == 0) goto L_0x00ac
            r12.add(r13)
        L_0x00ac:
            androidx.compose.ui.Modifier$Node r13 = r13.getChild$ui_release()
            goto L_0x0074
        L_0x00b1:
            if (r14 != r10) goto L_0x00b4
            goto L_0x0044
        L_0x00b4:
            r11 = r12
            androidx.compose.runtime.collection.MutableVector r11 = (androidx.compose.runtime.collection.MutableVector) r11
            androidx.compose.ui.Modifier$Node r11 = androidx.compose.ui.node.DelegatableNodeKt.pop(r12)
            goto L_0x0044
        L_0x00bc:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x0035
        L_0x00c2:
            androidx.compose.ui.node.LayoutNode r3 = r3.getParent$ui_release()
            if (r3 == 0) goto L_0x00d4
            androidx.compose.ui.node.NodeChain r2 = r3.getNodes$ui_release()
            if (r2 == 0) goto L_0x00d4
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x001c
        L_0x00d4:
            r2 = r4
            goto L_0x001c
        L_0x00d7:
            r2 = r5
            java.util.List r2 = (java.util.List) r2
            if (r5 == 0) goto L_0x00f2
            int r2 = r5.size()
            int r2 = r2 + -1
            if (r2 < 0) goto L_0x00f2
        L_0x00e4:
            int r3 = r2 + -1
            java.lang.Object r2 = r5.get(r2)
            r0.invoke(r2)
            if (r3 >= 0) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r2 = r3
            goto L_0x00e4
        L_0x00f2:
            androidx.compose.ui.Modifier$Node r2 = r17.getNode()
            r3 = r4
        L_0x00f7:
            if (r2 == 0) goto L_0x0163
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r8, r7)
            boolean r11 = r2 instanceof java.lang.Object
            if (r11 == 0) goto L_0x0104
            r0.invoke(r2)
            goto L_0x015b
        L_0x0104:
            r11 = r2
            androidx.compose.ui.Modifier$Node r11 = (androidx.compose.ui.Modifier.Node) r11
            int r11 = r2.getKindSet$ui_release()
            r11 = r11 & r18
            if (r11 == 0) goto L_0x015b
            boolean r11 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x015b
            r11 = r2
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r9
        L_0x011b:
            if (r11 == 0) goto L_0x0158
            r13 = r11
            androidx.compose.ui.Modifier$Node r13 = (androidx.compose.ui.Modifier.Node) r13
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r18
            if (r13 == 0) goto L_0x0153
            int r12 = r12 + 1
            if (r12 != r10) goto L_0x012e
            r2 = r11
            goto L_0x0153
        L_0x012e:
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
            if (r3 != 0) goto L_0x013d
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r6]
            r3.<init>(r13, r9)
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
        L_0x013d:
            r13 = r2
            androidx.compose.ui.Modifier$Node r13 = (androidx.compose.ui.Modifier.Node) r13
            if (r2 == 0) goto L_0x014b
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
            if (r3 == 0) goto L_0x014a
            r3.add(r2)
        L_0x014a:
            r2 = r4
        L_0x014b:
            r13 = r3
            androidx.compose.runtime.collection.MutableVector r13 = (androidx.compose.runtime.collection.MutableVector) r13
            if (r3 == 0) goto L_0x0153
            r3.add(r11)
        L_0x0153:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x011b
        L_0x0158:
            if (r12 != r10) goto L_0x015b
            goto L_0x00f7
        L_0x015b:
            r2 = r3
            androidx.compose.runtime.collection.MutableVector r2 = (androidx.compose.runtime.collection.MutableVector) r2
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.pop(r3)
            goto L_0x00f7
        L_0x0163:
            androidx.compose.ui.Modifier$Node r0 = r17.getNode()
            r2 = r4
        L_0x0168:
            if (r0 == 0) goto L_0x01d4
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r8, r7)
            boolean r3 = r0 instanceof java.lang.Object
            if (r3 == 0) goto L_0x0175
            r1.invoke(r0)
            goto L_0x01cc
        L_0x0175:
            r3 = r0
            androidx.compose.ui.Modifier$Node r3 = (androidx.compose.ui.Modifier.Node) r3
            int r3 = r0.getKindSet$ui_release()
            r3 = r3 & r18
            if (r3 == 0) goto L_0x01cc
            boolean r3 = r0 instanceof androidx.compose.ui.node.DelegatingNode
            if (r3 == 0) goto L_0x01cc
            r3 = r0
            androidx.compose.ui.node.DelegatingNode r3 = (androidx.compose.ui.node.DelegatingNode) r3
            androidx.compose.ui.Modifier$Node r3 = r3.getDelegate$ui_release()
            r11 = r9
        L_0x018c:
            if (r3 == 0) goto L_0x01c9
            r12 = r3
            androidx.compose.ui.Modifier$Node r12 = (androidx.compose.ui.Modifier.Node) r12
            int r12 = r3.getKindSet$ui_release()
            r12 = r12 & r18
            if (r12 == 0) goto L_0x01c4
            int r11 = r11 + 1
            if (r11 != r10) goto L_0x019f
            r0 = r3
            goto L_0x01c4
        L_0x019f:
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
            if (r2 != 0) goto L_0x01ae
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r12 = new androidx.compose.ui.Modifier.Node[r6]
            r2.<init>(r12, r9)
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
        L_0x01ae:
            r12 = r0
            androidx.compose.ui.Modifier$Node r12 = (androidx.compose.ui.Modifier.Node) r12
            if (r0 == 0) goto L_0x01bc
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
            if (r2 == 0) goto L_0x01bb
            r2.add(r0)
        L_0x01bb:
            r0 = r4
        L_0x01bc:
            r12 = r2
            androidx.compose.runtime.collection.MutableVector r12 = (androidx.compose.runtime.collection.MutableVector) r12
            if (r2 == 0) goto L_0x01c4
            r2.add(r3)
        L_0x01c4:
            androidx.compose.ui.Modifier$Node r3 = r3.getChild$ui_release()
            goto L_0x018c
        L_0x01c9:
            if (r11 != r10) goto L_0x01cc
            goto L_0x0168
        L_0x01cc:
            r0 = r2
            androidx.compose.runtime.collection.MutableVector r0 = (androidx.compose.runtime.collection.MutableVector) r0
            androidx.compose.ui.Modifier$Node r0 = androidx.compose.ui.node.DelegatableNodeKt.pop(r2)
            goto L_0x0168
        L_0x01d4:
            if (r5 == 0) goto L_0x01e6
            int r0 = r5.size()
        L_0x01da:
            if (r9 >= r0) goto L_0x01e6
            java.lang.Object r2 = r5.get(r9)
            r1.invoke(r2)
            int r9 = r9 + 1
            goto L_0x01da
        L_0x01e6:
            return
        L_0x01e7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitAncestors called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m3496traverseAncestorsYYKmho(androidx.compose.ui.node.DelegatableNode, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int r1 = NodeKind.m5647constructorimpl(1024) | NodeKind.m5647constructorimpl(8192);
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = delegatableNode.getNode();
            Modifier.Node node2 = null;
            if ((node.getAggregateChildKindSet$ui_release() & r1) != 0) {
                for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                    if ((child$ui_release.getKindSet$ui_release() & r1) != 0) {
                        if ((NodeKind.m5647constructorimpl(1024) & child$ui_release.getKindSet$ui_release()) != 0) {
                            return node2;
                        }
                        node2 = child$ui_release;
                    }
                }
            }
            return node2;
        }
        throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
    }
}
