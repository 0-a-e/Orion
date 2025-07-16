package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1", f = "AndroidExternalSurface.android.kt", i = {0}, l = {132, 137}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: AndroidExternalSurface.android.kt */
final class BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ Surface $surface;
    final /* synthetic */ int $width;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseAndroidExternalSurfaceState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1(BaseAndroidExternalSurfaceState baseAndroidExternalSurfaceState, Surface surface, int i, int i2, Continuation<? super BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = baseAndroidExternalSurfaceState;
        this.$surface = surface;
        this.$width = i;
        this.$height = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1 baseAndroidExternalSurfaceState$dispatchSurfaceCreated$1 = new BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1(this.this$0, this.$surface, this.$width, this.$height, continuation);
        baseAndroidExternalSurfaceState$dispatchSurfaceCreated$1.L$0 = obj;
        return baseAndroidExternalSurfaceState$dispatchSurfaceCreated$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006a
        L_0x0012:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001a:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0040
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = r9.this$0
            kotlinx.coroutines.Job r10 = r10.job
            if (r10 == 0) goto L_0x0040
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.JobKt.cancelAndJoin(r10, r4)
            if (r10 != r0) goto L_0x0040
            return r0
        L_0x0040:
            androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 r4 = new androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1
            androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = r9.this$0
            r4.<init>(r10, r1)
            androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = r9.this$0
            kotlin.jvm.functions.Function5 r3 = r10.onSurface
            if (r3 == 0) goto L_0x006a
            android.view.Surface r5 = r9.$surface
            int r10 = r9.$width
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            int r10 = r9.$height
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            r10 = 0
            r9.L$0 = r10
            r9.label = r2
            r8 = r9
            java.lang.Object r10 = r3.invoke(r4, r5, r6, r7, r8)
            if (r10 != r0) goto L_0x006a
            return r0
        L_0x006a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
