package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.SnapshotStateKt;
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
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1", f = "AndroidTextFieldMagnifier.android.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidTextFieldMagnifier.android.kt */
final class TextFieldMagnifierNodeImpl28$restartAnimationJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldMagnifierNodeImpl28 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierNodeImpl28$restartAnimationJob$1(TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28, Continuation<? super TextFieldMagnifierNodeImpl28$restartAnimationJob$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldMagnifierNodeImpl28;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TextFieldMagnifierNodeImpl28$restartAnimationJob$1 textFieldMagnifierNodeImpl28$restartAnimationJob$1 = new TextFieldMagnifierNodeImpl28$restartAnimationJob$1(this.this$0, continuation);
        textFieldMagnifierNodeImpl28$restartAnimationJob$1.L$0 = obj;
        return textFieldMagnifierNodeImpl28$restartAnimationJob$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldMagnifierNodeImpl28$restartAnimationJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = this.this$0;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Offset>() {
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.m3551boximpl(m1447invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0  reason: not valid java name */
                public final long m1447invokeF1C5BW0() {
                    return TextFieldMagnifierKt.m1440calculateSelectionMagnifierCenterAndroidhUlJWOE(textFieldMagnifierNodeImpl28.textFieldState, textFieldMagnifierNodeImpl28.textFieldSelectionState, textFieldMagnifierNodeImpl28.textLayoutState, textFieldMagnifierNodeImpl28.m1443getMagnifierSizeYbymL2g());
                }
            });
            final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl282 = this.this$0;
            this.label = 1;
            if (snapshotFlow.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return m1448emit3MmeM6k(((Offset) obj).m3572unboximpl(), continuation);
                }

                /* renamed from: emit-3MmeM6k  reason: not valid java name */
                public final Object m1448emit3MmeM6k(final long j, Continuation<? super Unit> continuation) {
                    if (!OffsetKt.m3581isSpecifiedk4lQ0M(((Offset) textFieldMagnifierNodeImpl282.animatable.getValue()).m3572unboximpl()) || !OffsetKt.m3581isSpecifiedk4lQ0M(j) || Offset.m3563getYimpl(((Offset) textFieldMagnifierNodeImpl282.animatable.getValue()).m3572unboximpl()) == Offset.m3563getYimpl(j)) {
                        Object snapTo = textFieldMagnifierNodeImpl282.animatable.snapTo(Offset.m3551boximpl(j), continuation);
                        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
                    }
                    CoroutineScope coroutineScope = coroutineScope;
                    final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = textFieldMagnifierNodeImpl282;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                    return Unit.INSTANCE;
                }

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1", f = "AndroidTextFieldMagnifier.android.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1  reason: invalid class name */
                /* compiled from: AndroidTextFieldMagnifier.android.kt */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(textFieldMagnifierNodeImpl28, j, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (Animatable.animateTo$default(textFieldMagnifierNodeImpl28.animatable, Offset.m3551boximpl(j), SelectionMagnifierKt.getMagnifierSpringSpec(), (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
