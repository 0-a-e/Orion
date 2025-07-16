package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J#\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J*\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\"\u0010-\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u001cH\u0002J\u0012\u00101\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\u001f\u00104\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b5R\u001a\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "parentConnection", "getParentConnection", "parentModifierLocal", "getParentModifierLocal", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "resolvedDispatcher", "onAttach", "", "onDetach", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "resetDispatcherFields", "updateDispatcher", "newDispatcher", "updateDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollNode.kt */
public final class NestedScrollNode extends Modifier.Node implements ModifierLocalModifierNode, NestedScrollConnection, DelegatableNode {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private final ModifierLocalMap providedValues;
    private NestedScrollDispatcher resolvedDispatcher;

    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(NestedScrollNodeKt.getModifierLocalNestedScroll(), this));
    }

    private final NestedScrollNode getParentModifierLocal() {
        if (isAttached()) {
            return (NestedScrollNode) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (isAttached()) {
            return (NestedScrollConnection) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    /* access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope coroutineScope;
        NestedScrollNode parentModifierLocal = getParentModifierLocal();
        if ((parentModifierLocal != null && (coroutineScope = parentModifierLocal.getNestedCoroutineScope()) != null) || (coroutineScope = this.resolvedDispatcher.getScope$ui_release()) != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m4996onPreScrollOzD1aCk(long j, int i) {
        NestedScrollConnection parentConnection = getParentConnection();
        long r0 = parentConnection != null ? parentConnection.m4974onPreScrollOzD1aCk(j, i) : Offset.Companion.m3578getZeroF1C5BW0();
        return Offset.m3567plusMKHz9U(r0, this.connection.m4974onPreScrollOzD1aCk(Offset.m3566minusMKHz9U(j, r0), i));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m4994onPostScrollDzOQY0M(long j, long j2, int i) {
        long j3;
        long r0 = this.connection.m4972onPostScrollDzOQY0M(j, j2, i);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            j3 = parentConnection.m4972onPostScrollDzOQY0M(Offset.m3567plusMKHz9U(j, r0), Offset.m3566minusMKHz9U(j2, r0), i);
        } else {
            j3 = Offset.Companion.m3578getZeroF1C5BW0();
        }
        return Offset.m3567plusMKHz9U(r0, j3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4995onPreFlingQWom1Mo(long r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r8, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            long r9 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007d
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            long r9 = r0.J$0
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0058
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r8.getParentConnection()
            if (r11 == 0) goto L_0x005f
            r0.L$0 = r8
            r0.J$0 = r9
            r0.label = r4
            java.lang.Object r11 = r11.m4973onPreFlingQWom1Mo(r9, r0)
            if (r11 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r2 = r8
        L_0x0058:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r4 = r11.m6864unboximpl()
            goto L_0x0066
        L_0x005f:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r11.m6866getZero9UxMQ8M()
            r2 = r8
        L_0x0066:
            r6 = r9
            r9 = r4
            r4 = r6
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r2.connection
            long r4 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r4, r9)
            r2 = 0
            r0.L$0 = r2
            r0.J$0 = r9
            r0.label = r3
            java.lang.Object r11 = r11.m4973onPreFlingQWom1Mo(r4, r0)
            if (r11 != r1) goto L_0x007d
            return r1
        L_0x007d:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r0 = r11.m6864unboximpl()
            long r9 = androidx.compose.ui.unit.Velocity.m6859plusAH228Gc(r9, r0)
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m6846boximpl(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.m4995onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4993onPostFlingRZ2iAVY(long r16, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r20
            boolean r2 = r1 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001c
        L_0x0017:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r2 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            r2.<init>(r15, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r10 = 2
            r4 = 1
            if (r3 == 0) goto L_0x0048
            if (r3 == r4) goto L_0x003a
            if (r3 != r10) goto L_0x0032
            long r2 = r2.J$0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x008d
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            long r3 = r2.J$1
            long r5 = r2.J$0
            java.lang.Object r7 = r2.L$0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r7 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r11 = r5
            goto L_0x0066
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r1)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r0.connection
            r2.L$0 = r0
            r11 = r16
            r2.J$0 = r11
            r13 = r18
            r2.J$1 = r13
            r2.label = r4
            r4 = r16
            r6 = r18
            r8 = r2
            java.lang.Object r1 = r3.m4971onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L_0x0065
            return r9
        L_0x0065:
            r7 = r0
        L_0x0066:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.m6864unboximpl()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r7.getParentConnection()
            if (r3 == 0) goto L_0x0095
            long r6 = androidx.compose.ui.unit.Velocity.m6859plusAH228Gc(r11, r4)
            long r11 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r13, r4)
            r1 = 0
            r2.L$0 = r1
            r2.J$0 = r4
            r2.label = r10
            r13 = r4
            r4 = r6
            r6 = r11
            r8 = r2
            java.lang.Object r1 = r3.m4971onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L_0x008c
            return r9
        L_0x008c:
            r2 = r13
        L_0x008d:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.m6864unboximpl()
            r13 = r2
            goto L_0x009c
        L_0x0095:
            r13 = r4
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r1.m6866getZero9UxMQ8M()
        L_0x009c:
            long r1 = androidx.compose.ui.unit.Velocity.m6859plusAH228Gc(r13, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6846boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.m4993onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateDispatcher(NestedScrollDispatcher nestedScrollDispatcher) {
        resetDispatcherFields();
        if (nestedScrollDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual((Object) nestedScrollDispatcher, (Object) this.resolvedDispatcher)) {
            this.resolvedDispatcher = nestedScrollDispatcher;
        }
        if (isAttached()) {
            updateDispatcherFields();
        }
    }

    public void onAttach() {
        updateDispatcherFields();
    }

    public void onDetach() {
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setModifierLocalNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new NestedScrollNode$updateDispatcherFields$1(this));
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getModifierLocalNode$ui_release() == this) {
            this.resolvedDispatcher.setModifierLocalNode$ui_release((ModifierLocalModifierNode) null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        updateDispatcher(nestedScrollDispatcher);
    }
}
