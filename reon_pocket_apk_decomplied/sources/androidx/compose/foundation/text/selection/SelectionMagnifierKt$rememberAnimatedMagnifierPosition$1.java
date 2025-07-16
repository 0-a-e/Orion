package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1", f = "SelectionMagnifier.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SelectionMagnifier.kt */
final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Offset, AnimationVector2D> $animatable;
    final /* synthetic */ State<Offset> $targetValue$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(State<Offset> state, Animatable<Offset, AnimationVector2D> animatable, Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1> continuation) {
        super(2, continuation);
        this.$targetValue$delegate = state;
        this.$animatable = animatable;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 selectionMagnifierKt$rememberAnimatedMagnifierPosition$1 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(this.$targetValue$delegate, this.$animatable, continuation);
        selectionMagnifierKt$rememberAnimatedMagnifierPosition$1.L$0 = obj;
        return selectionMagnifierKt$rememberAnimatedMagnifierPosition$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final State<Offset> state = this.$targetValue$delegate;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Offset>() {
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.m3551boximpl(m1244invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0  reason: not valid java name */
                public final long m1244invokeF1C5BW0() {
                    return SelectionMagnifierKt.rememberAnimatedMagnifierPosition$lambda$1(state);
                }
            });
            final Animatable<Offset, AnimationVector2D> animatable = this.$animatable;
            this.label = 1;
            if (snapshotFlow.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return m1245emit3MmeM6k(((Offset) obj).m3572unboximpl(), continuation);
                }

                /* renamed from: emit-3MmeM6k  reason: not valid java name */
                public final Object m1245emit3MmeM6k(final long j, Continuation<? super Unit> continuation) {
                    if (!OffsetKt.m3581isSpecifiedk4lQ0M(animatable.getValue().m3572unboximpl()) || !OffsetKt.m3581isSpecifiedk4lQ0M(j) || Offset.m3563getYimpl(animatable.getValue().m3572unboximpl()) == Offset.m3563getYimpl(j)) {
                        Object snapTo = animatable.snapTo(Offset.m3551boximpl(j), continuation);
                        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
                    }
                    CoroutineScope coroutineScope = coroutineScope;
                    final Animatable<Offset, AnimationVector2D> animatable = animatable;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                    return Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$1", f = "SelectionMagnifier.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$1  reason: invalid class name */
                /* compiled from: SelectionMagnifier.kt */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(animatable, j, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Animatable<Offset, AnimationVector2D> animatable = animatable;
                            Offset r10 = Offset.m3551boximpl(j);
                            this.label = 1;
                            if (Animatable.animateTo$default(animatable, r10, SelectionMagnifierKt.getMagnifierSpringSpec(), (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
