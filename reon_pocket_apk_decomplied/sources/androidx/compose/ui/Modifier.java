package androidx.compose.ui;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J5\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "Companion", "Element", "Node", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Modifier.kt */
public interface Modifier {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean all(Function1<? super Element, Boolean> function1);

    boolean any(Function1<? super Element, Boolean> function1);

    <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2);

    <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2);

    Modifier then(Modifier modifier);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Modifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static Modifier then(Modifier modifier, Modifier modifier2) {
            return CC.$default$then(modifier, modifier2);
        }
    }

    /* renamed from: androidx.compose.ui.Modifier$-CC  reason: invalid class name */
    /* compiled from: Modifier.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = Modifier.Companion;
        }

        public static Modifier $default$then(Modifier _this, Modifier modifier) {
            return modifier == Modifier.Companion ? _this : new CombinedModifier(_this, modifier);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "all", "", "predicate", "Lkotlin/Function1;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Modifier.kt */
    public interface Element extends Modifier {
        boolean all(Function1<? super Element, Boolean> function1);

        boolean any(Function1<? super Element, Boolean> function1);

        <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2);

        <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2);

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Modifier.kt */
        public static final class DefaultImpls {
            @Deprecated
            public static Modifier then(Element element, Modifier modifier) {
                return CC.$default$then(element, modifier);
            }

            @Deprecated
            public static <R> R foldIn(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                return CC.$default$foldIn(element, r, function2);
            }

            @Deprecated
            public static <R> R foldOut(Element element, R r, Function2<? super Element, ? super R, ? extends R> function2) {
                return CC.$default$foldOut(element, r, function2);
            }

            @Deprecated
            public static boolean any(Element element, Function1<? super Element, Boolean> function1) {
                return CC.$default$any(element, function1);
            }

            @Deprecated
            public static boolean all(Element element, Function1<? super Element, Boolean> function1) {
                return CC.$default$all(element, function1);
            }
        }

        /* renamed from: androidx.compose.ui.Modifier$Element$-CC  reason: invalid class name */
        /* compiled from: Modifier.kt */
        public final /* synthetic */ class CC {
            public static Object $default$foldIn(Element _this, Object obj, Function2 function2) {
                return function2.invoke(obj, _this);
            }

            public static Object $default$foldOut(Element _this, Object obj, Function2 function2) {
                return function2.invoke(_this, obj);
            }

            public static boolean $default$any(Element _this, Function1 function1) {
                return ((Boolean) function1.invoke(_this)).booleanValue();
            }

            public static boolean $default$all(Element _this, Function1 function1) {
                return ((Boolean) function1.invoke(_this)).booleanValue();
            }
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u00106\u001a\u00020\u00182\n\u00107\u001a\u0006\u0012\u0002\b\u000308H\bø\u0001\u0000¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020<H\u0010¢\u0006\u0002\b=J\r\u0010>\u001a\u00020<H\u0010¢\u0006\u0002\b?J\b\u0010@\u001a\u00020<H\u0016J\b\u0010A\u001a\u00020<H\u0016J\b\u0010B\u001a\u00020<H\u0016J\r\u0010C\u001a\u00020<H\u0010¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020<H\u0010¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020<H\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\u0000H\u0000¢\u0006\u0002\bKJ\u0016\u0010L\u001a\u00020<2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020<0NH\u0007J\u0017\u0010O\u001a\u00020<2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0010¢\u0006\u0002\bPR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u000bR\u000e\u0010$\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\u0010\u0010/\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u00188VX\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0002\u001a\u0004\b2\u0010\u001aR\u001a\u00103\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001c\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q"}, d2 = {"Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "()V", "aggregateChildKindSet", "", "getAggregateChildKindSet$ui_release", "()I", "setAggregateChildKindSet$ui_release", "(I)V", "child", "getChild$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setChild$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "<set-?>", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "getCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "insertedNodeAwaitingAttachForInvalidation", "", "getInsertedNodeAwaitingAttachForInvalidation$ui_release", "()Z", "setInsertedNodeAwaitingAttachForInvalidation$ui_release", "(Z)V", "isAttached", "kindSet", "getKindSet$ui_release", "setKindSet$ui_release", "node", "getNode$annotations", "getNode", "onAttachRunExpected", "onDetachRunExpected", "ownerScope", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "getOwnerScope$ui_release", "()Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "setOwnerScope$ui_release", "(Landroidx/compose/ui/node/ObserverNodeOwnerScope;)V", "parent", "getParent$ui_release", "setParent$ui_release", "scope", "shouldAutoInvalidate", "getShouldAutoInvalidate$annotations", "getShouldAutoInvalidate", "updatedNodeAwaitingAttachForInvalidation", "getUpdatedNodeAwaitingAttachForInvalidation$ui_release", "setUpdatedNodeAwaitingAttachForInvalidation$ui_release", "isKind", "kind", "Landroidx/compose/ui/node/NodeKind;", "isKind-H91voCI$ui_release", "(I)Z", "markAsAttached", "", "markAsAttached$ui_release", "markAsDetached", "markAsDetached$ui_release", "onAttach", "onDetach", "onReset", "reset", "reset$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "sideEffect", "effect", "Lkotlin/Function0;", "updateCoordinator", "updateCoordinator$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Modifier.kt */
    public static abstract class Node implements DelegatableNode {
        public static final int $stable = 8;
        private int aggregateChildKindSet = -1;
        private Node child;
        private NodeCoordinator coordinator;
        private boolean insertedNodeAwaitingAttachForInvalidation;
        private boolean isAttached;
        private int kindSet;
        private Node node = this;
        private boolean onAttachRunExpected;
        private boolean onDetachRunExpected;
        private ObserverNodeOwnerScope ownerScope;
        private Node parent;
        private CoroutineScope scope;
        private boolean updatedNodeAwaitingAttachForInvalidation;

        public static /* synthetic */ void getNode$annotations() {
        }

        public static /* synthetic */ void getShouldAutoInvalidate$annotations() {
        }

        public boolean getShouldAutoInvalidate() {
            return true;
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public void onReset() {
        }

        public final Node getNode() {
            return this.node;
        }

        public final CoroutineScope getCoroutineScope() {
            CoroutineScope coroutineScope = this.scope;
            if (coroutineScope != null) {
                return coroutineScope;
            }
            DelegatableNode delegatableNode = this;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(DelegatableNodeKt.requireOwner(delegatableNode).getCoroutineContext().plus(JobKt.Job((Job) DelegatableNodeKt.requireOwner(delegatableNode).getCoroutineContext().get(Job.Key))));
            this.scope = CoroutineScope;
            return CoroutineScope;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        public final void setKindSet$ui_release(int i) {
            this.kindSet = i;
        }

        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        public final void setAggregateChildKindSet$ui_release(int i) {
            this.aggregateChildKindSet = i;
        }

        public final Node getParent$ui_release() {
            return this.parent;
        }

        public final void setParent$ui_release(Node node2) {
            this.parent = node2;
        }

        public final Node getChild$ui_release() {
            return this.child;
        }

        public final void setChild$ui_release(Node node2) {
            this.child = node2;
        }

        public final ObserverNodeOwnerScope getOwnerScope$ui_release() {
            return this.ownerScope;
        }

        public final void setOwnerScope$ui_release(ObserverNodeOwnerScope observerNodeOwnerScope) {
            this.ownerScope = observerNodeOwnerScope;
        }

        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.insertedNodeAwaitingAttachForInvalidation;
        }

        public final void setInsertedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
            this.insertedNodeAwaitingAttachForInvalidation = z;
        }

        public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.updatedNodeAwaitingAttachForInvalidation;
        }

        public final void setUpdatedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
            this.updatedNodeAwaitingAttachForInvalidation = z;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }

        /* renamed from: isKind-H91voCI$ui_release  reason: not valid java name */
        public final boolean m3420isKindH91voCI$ui_release(int i) {
            return (i & getKindSet$ui_release()) != 0;
        }

        public void markAsAttached$ui_release() {
            if (!(!this.isAttached)) {
                throw new IllegalStateException("node attached multiple times".toString());
            } else if (this.coordinator != null) {
                this.isAttached = true;
                this.onAttachRunExpected = true;
            } else {
                throw new IllegalStateException("attach invoked on a node without a coordinator".toString());
            }
        }

        public void runAttachLifecycle$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Must run markAsAttached() prior to runAttachLifecycle".toString());
            } else if (this.onAttachRunExpected) {
                this.onAttachRunExpected = false;
                onAttach();
                this.onDetachRunExpected = true;
            } else {
                throw new IllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()".toString());
            }
        }

        public void runDetachLifecycle$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("node detached multiple times".toString());
            } else if (this.coordinator == null) {
                throw new IllegalStateException("detach invoked on a node without a coordinator".toString());
            } else if (this.onDetachRunExpected) {
                this.onDetachRunExpected = false;
                onDetach();
            } else {
                throw new IllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()".toString());
            }
        }

        public void markAsDetached$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Cannot detach a node that is not attached".toString());
            } else if (!(!this.onAttachRunExpected)) {
                throw new IllegalStateException("Must run runAttachLifecycle() before markAsDetached()".toString());
            } else if (!this.onDetachRunExpected) {
                this.isAttached = false;
                CoroutineScope coroutineScope = this.scope;
                if (coroutineScope != null) {
                    CoroutineScopeKt.cancel(coroutineScope, new ModifierNodeDetachedCancellationException());
                    this.scope = null;
                }
            } else {
                throw new IllegalStateException("Must run runDetachLifecycle() before markAsDetached()".toString());
            }
        }

        public void reset$ui_release() {
            if (this.isAttached) {
                onReset();
                return;
            }
            throw new IllegalStateException("reset() called on an unattached node".toString());
        }

        public final void sideEffect(Function0<Unit> function0) {
            DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(function0);
        }

        public final void setAsDelegateTo$ui_release(Node node2) {
            this.node = node2;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "()V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Modifier.kt */
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public boolean all(Function1<? super Element, Boolean> function1) {
            return true;
        }

        public boolean any(Function1<? super Element, Boolean> function1) {
            return false;
        }

        public <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2) {
            return r;
        }

        public <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2) {
            return r;
        }

        public Modifier then(Modifier modifier) {
            return modifier;
        }

        private Companion() {
        }

        public String toString() {
            return "Modifier";
        }
    }
}
