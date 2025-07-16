package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", i = {0}, l = {394}, m = "invokeSuspend", n = {"durationScaleJob"}, s = {"L$0"})
/* compiled from: WindowRecomposer.android.kt */
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.L$0 = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r11.L$0
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0014 }
            goto L_0x006d
        L_0x0014:
            r12 = move-exception
            goto L_0x0089
        L_0x0017:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r4 = r12
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.platform.MotionDurationScaleImpl> r12 = r11.$systemDurationScaleSettingConsumer     // Catch:{ all -> 0x0087 }
            T r12 = r12.element     // Catch:{ all -> 0x0087 }
            androidx.compose.ui.platform.MotionDurationScaleImpl r12 = (androidx.compose.ui.platform.MotionDurationScaleImpl) r12     // Catch:{ all -> 0x0087 }
            if (r12 == 0) goto L_0x005b
            android.view.View r1 = r11.$this_createLifecycleAwareWindowRecomposer     // Catch:{ all -> 0x0087 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0087 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0087 }
            kotlinx.coroutines.flow.StateFlow r1 = androidx.compose.ui.platform.WindowRecomposer_androidKt.getAnimationScaleFlowFor(r1)     // Catch:{ all -> 0x0087 }
            java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x0087 }
            java.lang.Number r5 = (java.lang.Number) r5     // Catch:{ all -> 0x0087 }
            float r5 = r5.floatValue()     // Catch:{ all -> 0x0087 }
            r12.setScaleFactor(r5)     // Catch:{ all -> 0x0087 }
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 r5 = new androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1     // Catch:{ all -> 0x0087 }
            r5.<init>(r1, r12, r3)     // Catch:{ all -> 0x0087 }
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ all -> 0x0087 }
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.Job r12 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0087 }
            goto L_0x005c
        L_0x005b:
            r12 = r3
        L_0x005c:
            androidx.compose.runtime.Recomposer r1 = r11.$recomposer     // Catch:{ all -> 0x0082 }
            r4 = r11
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ all -> 0x0082 }
            r11.L$0 = r12     // Catch:{ all -> 0x0082 }
            r11.label = r2     // Catch:{ all -> 0x0082 }
            java.lang.Object r1 = r1.runRecomposeAndApplyChanges(r4)     // Catch:{ all -> 0x0082 }
            if (r1 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r0 = r12
        L_0x006d:
            if (r0 == 0) goto L_0x0072
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x0072:
            androidx.lifecycle.LifecycleOwner r12 = r11.$source
            androidx.lifecycle.Lifecycle r12 = r12.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r0 = r11.$self
            androidx.lifecycle.LifecycleObserver r0 = (androidx.lifecycle.LifecycleObserver) r0
            r12.removeObserver(r0)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0082:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x0089
        L_0x0087:
            r12 = move-exception
            r0 = r3
        L_0x0089:
            if (r0 == 0) goto L_0x008e
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x008e:
            androidx.lifecycle.LifecycleOwner r0 = r11.$source
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 r1 = r11.$self
            androidx.lifecycle.LifecycleObserver r1 = (androidx.lifecycle.LifecycleObserver) r1
            r0.removeObserver(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
