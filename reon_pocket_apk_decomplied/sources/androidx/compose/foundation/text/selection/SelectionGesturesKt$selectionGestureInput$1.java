package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1", f = "SelectionGestures.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SelectionGestures.kt */
final class SelectionGesturesKt$selectionGestureInput$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
    final /* synthetic */ TextDragObserver $textDragObserver;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionGesturesKt$selectionGestureInput$1(MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super SelectionGesturesKt$selectionGestureInput$1> continuation) {
        super(2, continuation);
        this.$mouseSelectionObserver = mouseSelectionObserver;
        this.$textDragObserver = textDragObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionGesturesKt$selectionGestureInput$1 selectionGesturesKt$selectionGestureInput$1 = new SelectionGesturesKt$selectionGestureInput$1(this.$mouseSelectionObserver, this.$textDragObserver, continuation);
        selectionGesturesKt$selectionGestureInput$1.L$0 = obj;
        return selectionGesturesKt$selectionGestureInput$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((SelectionGesturesKt$selectionGestureInput$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final ClicksCounter clicksCounter = new ClicksCounter(pointerInputScope.getViewConfiguration());
            final MouseSelectionObserver mouseSelectionObserver = this.$mouseSelectionObserver;
            final TextDragObserver textDragObserver = this.$textDragObserver;
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", f = "SelectionGestures.kt", i = {0}, l = {100, 106, 108}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1  reason: invalid class name */
    /* compiled from: SelectionGestures.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(mouseSelectionObserver, clicksCounter, textDragObserver, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0027
                if (r1 == r4) goto L_0x001f
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001a:
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x0094
            L_0x001f:
                java.lang.Object r1 = r10.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x003d
            L_0x0027:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.L$0
                r1 = r11
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                r10.L$0 = r1
                r10.label = r4
                java.lang.Object r11 = androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(r1, r11)
                if (r11 != r0) goto L_0x003d
                return r0
            L_0x003d:
                androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                boolean r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r11)
                r6 = 0
                if (r5 == 0) goto L_0x007e
                int r5 = r11.m5052getButtonsry648PA()
                boolean r5 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m5085isPrimaryPressedaHzCxE(r5)
                if (r5 == 0) goto L_0x007e
                java.util.List r5 = r11.getChanges()
                int r7 = r5.size()
                r8 = 0
            L_0x0059:
                if (r8 >= r7) goto L_0x006c
                java.lang.Object r9 = r5.get(r8)
                androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                boolean r9 = r9.isConsumed()
                r9 = r9 ^ r4
                if (r9 != 0) goto L_0x0069
                goto L_0x007e
            L_0x0069:
                int r8 = r8 + 1
                goto L_0x0059
            L_0x006c:
                androidx.compose.foundation.text.selection.MouseSelectionObserver r2 = r4
                androidx.compose.foundation.text.selection.ClicksCounter r4 = r1
                r5 = r10
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r10.L$0 = r6
                r10.label = r3
                java.lang.Object r11 = androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(r1, r2, r4, r11, r5)
                if (r11 != r0) goto L_0x0094
                return r0
            L_0x007e:
                boolean r3 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r11)
                if (r3 != 0) goto L_0x0094
                androidx.compose.foundation.text.TextDragObserver r3 = r5
                r4 = r10
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r10.L$0 = r6
                r10.label = r2
                java.lang.Object r11 = androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection(r1, r3, r11, r4)
                if (r11 != r0) goto L_0x0094
                return r0
            L_0x0094:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
