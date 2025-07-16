package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1", f = "ClickableText.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClickableText.kt */
final class ClickableTextKt$ClickableText$pointerInputModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<Integer, Unit> $onClick;
    final /* synthetic */ Function1<Integer, Unit> $onHover;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableTextKt$ClickableText$pointerInputModifier$1(CoroutineScope coroutineScope, Function1<? super Integer, Unit> function1, MutableState<TextLayoutResult> mutableState, Function1<? super Integer, Unit> function12, Continuation<? super ClickableTextKt$ClickableText$pointerInputModifier$1> continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$onHover = function1;
        this.$layoutResult = mutableState;
        this.$onClick = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$1 = new ClickableTextKt$ClickableText$pointerInputModifier$1(this.$coroutineScope, this.$onHover, this.$layoutResult, this.$onClick, continuation);
        clickableTextKt$ClickableText$pointerInputModifier$1.L$0 = obj;
        return clickableTextKt$ClickableText$pointerInputModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClickableTextKt$ClickableText$pointerInputModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1", f = "ClickableText.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1  reason: invalid class name */
    /* compiled from: ClickableText.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(pointerInputScope, function1, mutableState, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                PointerInputScope pointerInputScope = pointerInputScope;
                PointerEventPass pointerEventPass = PointerEventPass.Main;
                final Function1<Integer, Unit> function1 = function1;
                final MutableState<TextLayoutResult> mutableState = mutableState;
                this.label = 1;
                if (PointerMoveDetectorKt.detectMoves(pointerInputScope, pointerEventPass, new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m1055invokek4lQ0M(((Offset) obj).m3572unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m1055invokek4lQ0M(long j) {
                        T access$ClickableText_03UYbkw$getOffset = ClickableTextKt.ClickableText_03UYbkw$getOffset(mutableState, j);
                        if (!Intrinsics.areEqual((Object) objectRef.element, (Object) access$ClickableText_03UYbkw$getOffset)) {
                            objectRef.element = access$ClickableText_03UYbkw$getOffset;
                            function1.invoke(access$ClickableText_03UYbkw$getOffset);
                        }
                    }
                }, this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            CoroutineScope coroutineScope = this.$coroutineScope;
            final Function1<Integer, Unit> function1 = this.$onHover;
            final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            final Function1<Integer, Unit> function12 = this.$onClick;
            final MutableState<TextLayoutResult> mutableState2 = this.$layoutResult;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, (Function1) null, (Function1) null, (Function3) null, new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m1056invokek4lQ0M(((Offset) obj).m3572unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m1056invokek4lQ0M(long j) {
                    Integer access$ClickableText_03UYbkw$getOffset = ClickableTextKt.ClickableText_03UYbkw$getOffset(mutableState2, j);
                    if (access$ClickableText_03UYbkw$getOffset != null) {
                        function12.invoke(access$ClickableText_03UYbkw$getOffset);
                    }
                }
            }, this, 7, (Object) null) == coroutine_suspended) {
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
