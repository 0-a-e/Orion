package androidx.compose.foundation.lazy.layout;

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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "index", "", "invoke", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Function0<LazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1(Function0<? extends LazyLayoutItemProvider> function0, CoroutineScope coroutineScope, LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(1);
        this.$itemProviderLambda = function0;
        this.$coroutineScope = coroutineScope;
        this.$state = lazyLayoutSemanticState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Boolean invoke(final int i) {
        LazyLayoutItemProvider invoke = this.$itemProviderLambda.invoke();
        if (i < 0 || i >= invoke.getItemCount()) {
            throw new IllegalArgumentException(("Can't scroll to index " + i + ", it is out of bounds [0, " + invoke.getItemCount() + ')').toString());
        }
        CoroutineScope coroutineScope = this.$coroutineScope;
        final LazyLayoutSemanticState lazyLayoutSemanticState = this.$state;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 3, (Object) null);
        return true;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2", f = "LazyLayoutSemantics.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2  reason: invalid class name */
    /* compiled from: LazyLayoutSemantics.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(lazyLayoutSemanticState, i, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (lazyLayoutSemanticState.scrollToItem(i, this) == coroutine_suspended) {
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
}
