package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\rJ\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR=\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u0018X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "setDragAndDropSourceHandler", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getDrawDragDecoration", "()Lkotlin/jvm/functions/Function1;", "setDrawDragDecoration", "(Lkotlin/jvm/functions/Function1;)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropSource.kt */
public final class DragAndDropSourceNode extends DelegatingNode implements LayoutAwareModifierNode {
    public static final int $stable = 8;
    private Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> dragAndDropSourceHandler;
    private Function1<? super DrawScope, Unit> drawDragDecoration;
    private long size = IntSize.Companion.m6795getZeroYbymL2g();

    public /* synthetic */ void onPlaced(LayoutCoordinates layoutCoordinates) {
        LayoutAwareModifierNode.CC.$default$onPlaced(this, layoutCoordinates);
    }

    public final Function1<DrawScope, Unit> getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    public final void setDrawDragDecoration(Function1<? super DrawScope, Unit> function1) {
        this.drawDragDecoration = function1;
    }

    public final Function2<DragAndDropSourceScope, Continuation<? super Unit>, Object> getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final void setDragAndDropSourceHandler(Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.dragAndDropSourceHandler = function2;
    }

    public DragAndDropSourceNode(Function1<? super DrawScope, Unit> function1, Function2<? super DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.drawDragDecoration = function1;
        this.dragAndDropSourceHandler = function2;
        final DragAndDropModifierNode dragAndDropModifierNode = (DragAndDropModifierNode) delegate(DragAndDropNodeKt.DragAndDropModifierNode());
        delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null)));
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceNode$1", f = "DragAndDropSource.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceNode$1  reason: invalid class name */
    /* compiled from: DragAndDropSource.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DragAndDropSourceNode this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, dragAndDropModifierNode, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                Function2<DragAndDropSourceScope, Continuation<? super Unit>, Object> dragAndDropSourceHandler = this.this$0.getDragAndDropSourceHandler();
                final DragAndDropModifierNode dragAndDropModifierNode = dragAndDropModifierNode;
                final DragAndDropSourceNode dragAndDropSourceNode = this.this$0;
                AnonymousClass1 r3 = new Object() {
                    public <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
                        return pointerInputScope.awaitPointerEventScope(function2, continuation);
                    }

                    public float getDensity() {
                        return pointerInputScope.getDensity();
                    }

                    /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
                    public long m326getExtendedTouchPaddingNHjbRc() {
                        return pointerInputScope.m5138getExtendedTouchPaddingNHjbRc();
                    }

                    public float getFontScale() {
                        return pointerInputScope.getFontScale();
                    }

                    public boolean getInterceptOutOfBoundsChildEvents() {
                        return pointerInputScope.getInterceptOutOfBoundsChildEvents();
                    }

                    /* renamed from: getSize-YbymL2g  reason: not valid java name */
                    public long m327getSizeYbymL2g() {
                        return pointerInputScope.m5139getSizeYbymL2g();
                    }

                    public ViewConfiguration getViewConfiguration() {
                        return pointerInputScope.getViewConfiguration();
                    }

                    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
                    public int m328roundToPxR2X_6o(long j) {
                        return pointerInputScope.m6544roundToPxR2X_6o(j);
                    }

                    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
                    public int m329roundToPx0680j_4(float f) {
                        return pointerInputScope.m6545roundToPx0680j_4(f);
                    }

                    public void setInterceptOutOfBoundsChildEvents(boolean z) {
                        pointerInputScope.setInterceptOutOfBoundsChildEvents(z);
                    }

                    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
                    public float m330toDpGaN1DYA(long j) {
                        return pointerInputScope.m6723toDpGaN1DYA(j);
                    }

                    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
                    public float m331toDpu2uoSUM(float f) {
                        return pointerInputScope.m6546toDpu2uoSUM(f);
                    }

                    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
                    public float m332toDpu2uoSUM(int i) {
                        return pointerInputScope.m6547toDpu2uoSUM(i);
                    }

                    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
                    public long m333toDpSizekrfVVM(long j) {
                        return pointerInputScope.m6548toDpSizekrfVVM(j);
                    }

                    /* renamed from: toPx--R2X_6o  reason: not valid java name */
                    public float m334toPxR2X_6o(long j) {
                        return pointerInputScope.m6549toPxR2X_6o(j);
                    }

                    /* renamed from: toPx-0680j_4  reason: not valid java name */
                    public float m335toPx0680j_4(float f) {
                        return pointerInputScope.m6550toPx0680j_4(f);
                    }

                    public Rect toRect(DpRect dpRect) {
                        return pointerInputScope.toRect(dpRect);
                    }

                    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
                    public long m336toSizeXkaWNTQ(long j) {
                        return pointerInputScope.m6551toSizeXkaWNTQ(j);
                    }

                    /* renamed from: toSp-0xMU5do  reason: not valid java name */
                    public long m337toSp0xMU5do(float f) {
                        return pointerInputScope.m6724toSp0xMU5do(f);
                    }

                    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
                    public long m338toSpkPz2Gy4(float f) {
                        return pointerInputScope.m6552toSpkPz2Gy4(f);
                    }

                    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
                    public long m339toSpkPz2Gy4(int i) {
                        return pointerInputScope.m6553toSpkPz2Gy4(i);
                    }

                    public void startTransfer(DragAndDropTransferData dragAndDropTransferData) {
                        dragAndDropModifierNode.m3433drag12SF9DM(dragAndDropTransferData, IntSizeKt.m6800toSizeozmzZPI(m327getSizeYbymL2g()), dragAndDropSourceNode.getDrawDragDecoration());
                    }
                };
                this.label = 1;
                if (dragAndDropSourceHandler.invoke(r3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m325onRemeasuredozmzZPI(long j) {
        this.size = j;
    }
}
