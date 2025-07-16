package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 82\u00020\u0001:\u00018B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H@¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u0005J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200ø\u0001\u0000¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020+H\u0016J\u0016\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H@¢\u0006\u0002\u0010-J\b\u00107\u001a\u00020+H\u0016R+\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R+\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058@@@X\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u0014\u0010&\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0013R\u0014\u0010(\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0013\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "initialRefreshing", "", "positionalThreshold", "", "enabled", "Lkotlin/Function0;", "(ZFLkotlin/jvm/functions/Function0;)V", "<set-?>", "_refreshing", "get_refreshing", "()Z", "set_refreshing", "(Z)V", "_refreshing$delegate", "Landroidx/compose/runtime/MutableState;", "_verticalOffset", "get_verticalOffset", "()F", "set_verticalOffset", "(F)V", "_verticalOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "adjustedDistancePulled", "getAdjustedDistancePulled", "distancePulled", "getDistancePulled$material3_release", "setDistancePulled$material3_release", "distancePulled$delegate", "isRefreshing", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setNestedScrollConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getPositionalThreshold", "progress", "getProgress", "verticalOffset", "getVerticalOffset", "animateTo", "", "offset", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateVerticalOffset", "consumeAvailableOffset", "Landroidx/compose/ui/geometry/Offset;", "available", "consumeAvailableOffset-MK-Hz9U", "(J)J", "endRefresh", "onRelease", "velocity", "startRefresh", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
public final class PullToRefreshStateImpl implements PullToRefreshState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableState _refreshing$delegate;
    private final MutableFloatState _verticalOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    private final MutableFloatState distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    private NestedScrollConnection nestedScrollConnection;
    private final float positionalThreshold;

    public PullToRefreshStateImpl(boolean z, float f, Function0<Boolean> function0) {
        this.positionalThreshold = f;
        this.nestedScrollConnection = new PullToRefreshStateImpl$nestedScrollConnection$1(function0, this);
        this._refreshing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public float getPositionalThreshold() {
        return this.positionalThreshold;
    }

    public float getProgress() {
        return getAdjustedDistancePulled() / getPositionalThreshold();
    }

    public float getVerticalOffset() {
        return get_verticalOffset();
    }

    public boolean isRefreshing() {
        return get_refreshing();
    }

    public void startRefresh() {
        set_refreshing(true);
        set_verticalOffset(getPositionalThreshold());
    }

    public void endRefresh() {
        set_verticalOffset(0.0f);
        set_refreshing(false);
    }

    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    public void setNestedScrollConnection(NestedScrollConnection nestedScrollConnection2) {
        this.nestedScrollConnection = nestedScrollConnection2;
    }

    /* renamed from: consumeAvailableOffset-MK-Hz9U  reason: not valid java name */
    public final long m2641consumeAvailableOffsetMKHz9U(long j) {
        float f;
        if (isRefreshing()) {
            f = 0.0f;
        } else {
            float coerceAtLeast = RangesKt.coerceAtLeast(getDistancePulled$material3_release() + Offset.m3563getYimpl(j), 0.0f);
            f = coerceAtLeast - getDistancePulled$material3_release();
            setDistancePulled$material3_release(coerceAtLeast);
            set_verticalOffset(calculateVerticalOffset());
        }
        return OffsetKt.Offset(0.0f, f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onRelease(float r6, kotlin.coroutines.Continuation<? super java.lang.Float> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$onRelease$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$onRelease$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$onRelease$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$onRelease$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$onRelease$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            float r6 = r0.F$0
            java.lang.Object r0 = r0.L$0
            androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0065
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r5.isRefreshing()
            if (r7 == 0) goto L_0x0047
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            return r6
        L_0x0047:
            float r7 = r5.getAdjustedDistancePulled()
            float r2 = r5.getPositionalThreshold()
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0058
            r5.startRefresh()
        L_0x0056:
            r0 = r5
            goto L_0x0065
        L_0x0058:
            r0.L$0 = r5
            r0.F$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.animateTo(r4, r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0065:
            float r7 = r0.getDistancePulled$material3_release()
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x006f
        L_0x006d:
            r6 = r4
            goto L_0x0074
        L_0x006f:
            int r7 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0074
            goto L_0x006d
        L_0x0074:
            r0.setDistancePulled$material3_release(r4)
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl.onRelease(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object animateTo(float f, Continuation<? super Unit> continuation) {
        Object animate$default = SuspendAnimationKt.animate$default(get_verticalOffset(), f, 0.0f, (AnimationSpec) null, new PullToRefreshStateImpl$animateTo$2(this), continuation, 12, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public final float calculateVerticalOffset() {
        if (getAdjustedDistancePulled() <= getPositionalThreshold()) {
            return getAdjustedDistancePulled();
        }
        float coerceIn = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        return getPositionalThreshold() + (getPositionalThreshold() * (coerceIn - (((float) Math.pow((double) coerceIn, (double) 2)) / ((float) 4))));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "", "positionalThreshold", "", "enabled", "Lkotlin/Function0;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PullToRefresh.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<PullToRefreshState, Boolean> Saver(float f, Function0<Boolean> function0) {
            return SaverKt.Saver(PullToRefreshStateImpl$Companion$Saver$1.INSTANCE, new PullToRefreshStateImpl$Companion$Saver$2(f, function0));
        }
    }

    public final float getDistancePulled$material3_release() {
        return this.distancePulled$delegate.getFloatValue();
    }

    public final void setDistancePulled$material3_release(float f) {
        this.distancePulled$delegate.setFloatValue(f);
    }

    private final float getAdjustedDistancePulled() {
        return getDistancePulled$material3_release() * 0.5f;
    }

    private final float get_verticalOffset() {
        return this._verticalOffset$delegate.getFloatValue();
    }

    /* access modifiers changed from: private */
    public final void set_verticalOffset(float f) {
        this._verticalOffset$delegate.setFloatValue(f);
    }

    private final boolean get_refreshing() {
        return ((Boolean) this._refreshing$delegate.getValue()).booleanValue();
    }

    private final void set_refreshing(boolean z) {
        this._refreshing$delegate.setValue(Boolean.valueOf(z));
    }
}
