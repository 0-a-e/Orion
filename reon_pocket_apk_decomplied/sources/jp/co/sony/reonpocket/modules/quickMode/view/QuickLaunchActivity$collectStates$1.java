package jp.co.sony.reonpocket.modules.quickMode.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.modules.quickMode.view.QuickLaunchActivity$collectStates$1", f = "QuickLaunchActivity.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: QuickLaunchActivity.kt */
final class QuickLaunchActivity$collectStates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QuickLaunchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickLaunchActivity$collectStates$1(QuickLaunchActivity quickLaunchActivity, Continuation<? super QuickLaunchActivity$collectStates$1> continuation) {
        super(2, continuation);
        this.this$0 = quickLaunchActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuickLaunchActivity$collectStates$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QuickLaunchActivity$collectStates$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "jp.co.sony.reonpocket.modules.quickMode.view.QuickLaunchActivity$collectStates$1$1", f = "QuickLaunchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: jp.co.sony.reonpocket.modules.quickMode.view.QuickLaunchActivity$collectStates$1$1  reason: invalid class name */
    /* compiled from: QuickLaunchActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(quickLaunchActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final QuickLaunchActivity quickLaunchActivity = quickLaunchActivity;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Lifecycle.State state = Lifecycle.State.STARTED;
                                final QuickLaunchActivity quickLaunchActivity = this.this$0;
                                this.label = 1;
                                if (RepeatOnLifecycleKt.repeatOnLifecycle((LifecycleOwner) this.this$0, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Continuation<? super Unit>) this) == coroutine_suspended) {
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
