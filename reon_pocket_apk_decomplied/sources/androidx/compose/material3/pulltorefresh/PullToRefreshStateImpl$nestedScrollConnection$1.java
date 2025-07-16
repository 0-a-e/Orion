package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/material3/pulltorefresh/PullToRefreshStateImpl$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
public final class PullToRefreshStateImpl$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ Function0<Boolean> $enabled;
    final /* synthetic */ PullToRefreshStateImpl this$0;

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m2642onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        return NestedScrollConnection.CC.m4975$default$onPostFlingRZ2iAVY(this, j, j2, continuation);
    }

    PullToRefreshStateImpl$nestedScrollConnection$1(Function0<Boolean> function0, PullToRefreshStateImpl pullToRefreshStateImpl) {
        this.$enabled = function0;
        this.this$0 = pullToRefreshStateImpl;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m2645onPreScrollOzD1aCk(long j, int i) {
        if (!this.$enabled.invoke().booleanValue()) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        if (!NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5005getDragWNlRxjI()) || Offset.m3563getYimpl(j) >= 0.0f) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        return this.this$0.m2641consumeAvailableOffsetMKHz9U(j);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2643onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!this.$enabled.invoke().booleanValue()) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        if (!NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5005getDragWNlRxjI()) || Offset.m3563getYimpl(j2) <= 0.0f) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        return this.this$0.m2641consumeAvailableOffsetMKHz9U(j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2644onPreFlingQWom1Mo(long r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            float r5 = r0.F$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004a
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl r7 = r4.this$0
            float r5 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r5)
            r6 = 0
            r0.F$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.onRelease(r5, r0)
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r5 = r6
        L_0x004a:
            java.lang.Number r7 = (java.lang.Number) r7
            float r6 = r7.floatValue()
            long r5 = androidx.compose.ui.unit.VelocityKt.Velocity(r5, r6)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m6846boximpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1.m2644onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
