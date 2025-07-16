package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00105\u001a\u00020+H\u0002J?\u00106\u001a\u00020+2\u0006\u00107\u001a\u0002082\"\u00109\u001a\u001e\b\u0001\u0012\u0004\u0012\u000208\u0012\n\u0012\b\u0012\u0004\u0012\u0002080;\u0012\u0006\u0012\u0004\u0018\u00010<0:H@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J6\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020B2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0)H\u0016ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\b\u0010F\u001a\u00020+H\u0002J\"\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\"\u0010M\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010LJ\"\u0010O\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010LJ\"\u0010Q\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010LJ\u001a\u0010S\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u001eH\u0002J \u0010W\u001a\u00020\u001e*\u00020X2\u0006\u0010Y\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002J \u0010]\u001a\u00020\u001e*\u00020X2\u0006\u0010^\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002J\n\u0010_\u001a\u00020+*\u00020XJ \u0010`\u001a\u00020\u001e*\u00020X2\u0006\u0010a\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002J \u0010b\u001a\u00020\u001e*\u00020X2\u0006\u0010c\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00020\u000fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u0004\u0018\u00010-X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u0004\u0018\u00010/X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "consumeCount", "", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "<set-?>", "invalidateCount", "getInvalidateCount", "()I", "setInvalidateCount", "(I)V", "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.android.kt */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private final List<EdgeEffect> allEffects;
    /* access modifiers changed from: private */
    public final EdgeEffect bottomEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect bottomEffectNegation;
    private int consumeCount;
    /* access modifiers changed from: private */
    public long containerSize;
    private final Modifier effectModifier;
    private final MutableIntState invalidateCount$delegate;
    private boolean invalidationEnabled;
    /* access modifiers changed from: private */
    public final EdgeEffect leftEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    /* access modifiers changed from: private */
    public PointerId pointerId;
    /* access modifiers changed from: private */
    public Offset pointerPosition;
    /* access modifiers changed from: private */
    public final EdgeEffect rightEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    /* access modifiers changed from: private */
    public final EdgeEffect topEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        this.overscrollConfig = overscrollConfiguration;
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.topEffect = create;
        EdgeEffect create2 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffect = create2;
        EdgeEffect create3 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffect = create3;
        EdgeEffect create4 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffect = create4;
        List<EdgeEffect> listOf = CollectionsKt.listOf(create3, create, create4, create2);
        this.allEffects = listOf;
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        int size = listOf.size();
        for (int i = 0; i < size; i++) {
            listOf.get(i).setColor(ColorKt.m3870toArgb8_81llA(this.overscrollConfig.m311getGlowColor0d7_KjU()));
        }
        this.consumeCount = -1;
        this.invalidateCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m3640getZeroNHjbRc();
        Function1<IntSize, Unit> androidEdgeEffectOverscrollEffect$onNewSize$1 = new AndroidEdgeEffectOverscrollEffect$onNewSize$1(this);
        this.onNewSize = androidEdgeEffectOverscrollEffect$onNewSize$1;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.then(AndroidOverscroll_androidKt.StretchOverscrollNonClippingLayer), (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, (Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1>) null)), androidEdgeEffectOverscrollEffect$onNewSize$1).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1(this) : InspectableValueKt.getNoInspectorInfo()));
    }

    private final int getInvalidateCount() {
        return this.invalidateCount$delegate.getIntValue();
    }

    private final void setInvalidateCount(int i) {
        this.invalidateCount$delegate.setIntValue(i);
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0136  */
    /* renamed from: applyToScroll-Rhakbz0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m195applyToScrollRhakbz0(long r18, int r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset> r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r21
            long r4 = r0.containerSize
            boolean r4 = androidx.compose.ui.geometry.Size.m3633isEmptyimpl(r4)
            if (r4 == 0) goto L_0x001d
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m3551boximpl(r18)
            java.lang.Object r1 = r3.invoke(r1)
            androidx.compose.ui.geometry.Offset r1 = (androidx.compose.ui.geometry.Offset) r1
            long r1 = r1.m3572unboximpl()
            return r1
        L_0x001d:
            boolean r4 = r0.scrollCycleInProgress
            r5 = 1
            if (r4 != 0) goto L_0x0027
            r17.stopOverscrollAnimation()
            r0.scrollCycleInProgress = r5
        L_0x0027:
            androidx.compose.ui.geometry.Offset r4 = r0.pointerPosition
            if (r4 == 0) goto L_0x0030
            long r6 = r4.m3572unboximpl()
            goto L_0x0036
        L_0x0030:
            long r6 = r0.containerSize
            long r6 = androidx.compose.ui.geometry.SizeKt.m3641getCenteruvyYCjk(r6)
        L_0x0036:
            float r4 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r18)
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0041
        L_0x003f:
            r4 = r8
            goto L_0x0085
        L_0x0041:
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r9 = r0.topEffect
            float r4 = r4.getDistanceCompat(r9)
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0070
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r9 = r0.bottomEffect
            float r4 = r4.getDistanceCompat(r9)
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x005a
            goto L_0x003f
        L_0x005a:
            float r4 = r0.m189pullBottom0a9Yr6o(r1, r6)
            androidx.compose.foundation.EdgeEffectCompat r9 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r10 = r0.bottomEffect
            float r9 = r9.getDistanceCompat(r10)
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x0085
            android.widget.EdgeEffect r9 = r0.bottomEffect
            r9.onRelease()
            goto L_0x0085
        L_0x0070:
            float r4 = r0.m192pullTop0a9Yr6o(r1, r6)
            androidx.compose.foundation.EdgeEffectCompat r9 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r10 = r0.topEffect
            float r9 = r9.getDistanceCompat(r10)
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x0085
            android.widget.EdgeEffect r9 = r0.topEffect
            r9.onRelease()
        L_0x0085:
            float r9 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r18)
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x008e
            goto L_0x00d3
        L_0x008e:
            androidx.compose.foundation.EdgeEffectCompat r9 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r10 = r0.leftEffect
            float r9 = r9.getDistanceCompat(r10)
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x00bd
            androidx.compose.foundation.EdgeEffectCompat r9 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r10 = r0.rightEffect
            float r9 = r9.getDistanceCompat(r10)
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x00a7
            goto L_0x00d3
        L_0x00a7:
            float r9 = r0.m191pullRight0a9Yr6o(r1, r6)
            androidx.compose.foundation.EdgeEffectCompat r10 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r11 = r0.rightEffect
            float r10 = r10.getDistanceCompat(r11)
            int r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00d2
            android.widget.EdgeEffect r8 = r0.rightEffect
            r8.onRelease()
            goto L_0x00d2
        L_0x00bd:
            float r9 = r0.m190pullLeft0a9Yr6o(r1, r6)
            androidx.compose.foundation.EdgeEffectCompat r10 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r11 = r0.leftEffect
            float r10 = r10.getDistanceCompat(r11)
            int r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00d2
            android.widget.EdgeEffect r8 = r0.leftEffect
            r8.onRelease()
        L_0x00d2:
            r8 = r9
        L_0x00d3:
            long r8 = androidx.compose.ui.geometry.OffsetKt.Offset(r8, r4)
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.Companion
            long r10 = r4.m3578getZeroF1C5BW0()
            boolean r4 = androidx.compose.ui.geometry.Offset.m3559equalsimpl0(r8, r10)
            if (r4 != 0) goto L_0x00e6
            r17.invalidateOverscroll()
        L_0x00e6:
            long r10 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r1, r8)
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3551boximpl(r10)
            java.lang.Object r3 = r3.invoke(r4)
            androidx.compose.ui.geometry.Offset r3 = (androidx.compose.ui.geometry.Offset) r3
            long r3 = r3.m3572unboximpl()
            long r10 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r10, r3)
            androidx.compose.ui.input.nestedscroll.NestedScrollSource$Companion r12 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion
            int r12 = r12.m5005getDragWNlRxjI()
            r13 = r20
            boolean r12 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.m5000equalsimpl0(r13, r12)
            r13 = 0
            if (r12 == 0) goto L_0x014a
            float r12 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r10)
            r14 = 1056964608(0x3f000000, float:0.5)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            r15 = -1090519040(0xffffffffbf000000, float:-0.5)
            if (r12 <= 0) goto L_0x011c
            r0.m190pullLeft0a9Yr6o(r10, r6)
        L_0x011a:
            r12 = r5
            goto L_0x0129
        L_0x011c:
            float r12 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r10)
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 >= 0) goto L_0x0128
            r0.m191pullRight0a9Yr6o(r10, r6)
            goto L_0x011a
        L_0x0128:
            r12 = r13
        L_0x0129:
            float r16 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r10)
            int r14 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r14 <= 0) goto L_0x0136
            r0.m192pullTop0a9Yr6o(r10, r6)
        L_0x0134:
            r6 = r5
            goto L_0x0143
        L_0x0136:
            float r14 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r10)
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 >= 0) goto L_0x0142
            r0.m189pullBottom0a9Yr6o(r10, r6)
            goto L_0x0134
        L_0x0142:
            r6 = r13
        L_0x0143:
            if (r12 != 0) goto L_0x0149
            if (r6 == 0) goto L_0x0148
            goto L_0x0149
        L_0x0148:
            r5 = r13
        L_0x0149:
            r13 = r5
        L_0x014a:
            boolean r1 = r17.m193releaseOppositeOverscrollk4lQ0M(r18)
            if (r1 != 0) goto L_0x0152
            if (r13 == 0) goto L_0x0155
        L_0x0152:
            r17.invalidateOverscroll()
        L_0x0155:
            long r1 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r8, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m195applyToScrollRhakbz0(long, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: applyToFling-BMRW4eQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m194applyToFlingBMRW4eQ(long r11, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity>, ? extends java.lang.Object> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1 r0 = (androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1 r0 = new androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$applyToFling$1
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$0
            androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r13 = (androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x012d
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0059
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r14)
            long r6 = r10.containerSize
            boolean r14 = androidx.compose.ui.geometry.Size.m3633isEmptyimpl(r6)
            if (r14 == 0) goto L_0x005c
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m6846boximpl(r11)
            r0.label = r4
            java.lang.Object r11 = r13.invoke(r11, r0)
            if (r11 != r1) goto L_0x0059
            return r1
        L_0x0059:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x005c:
            float r14 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0085
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r2 = r10.leftEffect
            float r14 = r14.getDistanceCompat(r2)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 != 0) goto L_0x0071
            goto L_0x0085
        L_0x0071:
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r2 = r10.leftEffect
            float r4 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            r14.onAbsorbCompat(r2, r4)
            float r14 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            goto L_0x00b0
        L_0x0085:
            float r14 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x00af
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r2 = r10.rightEffect
            float r14 = r14.getDistanceCompat(r2)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 != 0) goto L_0x009a
            goto L_0x00af
        L_0x009a:
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r2 = r10.rightEffect
            float r4 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            int r4 = -r4
            r14.onAbsorbCompat(r2, r4)
            float r14 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            goto L_0x00b0
        L_0x00af:
            r14 = r5
        L_0x00b0:
            float r2 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d9
            androidx.compose.foundation.EdgeEffectCompat r2 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r10.topEffect
            float r2 = r2.getDistanceCompat(r4)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00c5
            goto L_0x00d9
        L_0x00c5:
            androidx.compose.foundation.EdgeEffectCompat r2 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r10.topEffect
            float r6 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r6 = kotlin.math.MathKt.roundToInt((float) r6)
            r2.onAbsorbCompat(r4, r6)
            float r2 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            goto L_0x0104
        L_0x00d9:
            float r2 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0103
            androidx.compose.foundation.EdgeEffectCompat r2 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r10.bottomEffect
            float r2 = r2.getDistanceCompat(r4)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00ee
            goto L_0x0103
        L_0x00ee:
            androidx.compose.foundation.EdgeEffectCompat r2 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r10.bottomEffect
            float r6 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r6 = kotlin.math.MathKt.roundToInt((float) r6)
            int r6 = -r6
            r2.onAbsorbCompat(r4, r6)
            float r2 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            goto L_0x0104
        L_0x0103:
            r2 = r5
        L_0x0104:
            long r6 = androidx.compose.ui.unit.VelocityKt.Velocity(r14, r2)
            androidx.compose.ui.unit.Velocity$Companion r14 = androidx.compose.ui.unit.Velocity.Companion
            long r8 = r14.m6866getZero9UxMQ8M()
            boolean r14 = androidx.compose.ui.unit.Velocity.m6854equalsimpl0(r6, r8)
            if (r14 != 0) goto L_0x0117
            r10.invalidateOverscroll()
        L_0x0117:
            long r11 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r11, r6)
            androidx.compose.ui.unit.Velocity r14 = androidx.compose.ui.unit.Velocity.m6846boximpl(r11)
            r0.L$0 = r10
            r0.J$0 = r11
            r0.label = r3
            java.lang.Object r14 = r13.invoke(r14, r0)
            if (r14 != r1) goto L_0x012c
            return r1
        L_0x012c:
            r13 = r10
        L_0x012d:
            androidx.compose.ui.unit.Velocity r14 = (androidx.compose.ui.unit.Velocity) r14
            long r0 = r14.m6864unboximpl()
            long r11 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r11, r0)
            r14 = 0
            r13.scrollCycleInProgress = r14
            float r14 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0152
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r0 = r13.leftEffect
            float r1 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            r14.onAbsorbCompat(r0, r1)
            goto L_0x016a
        L_0x0152:
            float r14 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x016a
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r0 = r13.rightEffect
            float r1 = androidx.compose.ui.unit.Velocity.m6855getXimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            int r1 = -r1
            r14.onAbsorbCompat(r0, r1)
        L_0x016a:
            float r14 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0182
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r0 = r13.topEffect
            float r1 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            r14.onAbsorbCompat(r0, r1)
            goto L_0x019a
        L_0x0182:
            float r14 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 >= 0) goto L_0x019a
            androidx.compose.foundation.EdgeEffectCompat r14 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r0 = r13.bottomEffect
            float r1 = androidx.compose.ui.unit.Velocity.m6856getYimpl(r11)
            int r1 = kotlin.math.MathKt.roundToInt((float) r1)
            int r1 = -r1
            r14.onAbsorbCompat(r0, r1)
        L_0x019a:
            androidx.compose.ui.unit.Velocity$Companion r14 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r14.m6866getZero9UxMQ8M()
            boolean r11 = androidx.compose.ui.unit.Velocity.m6854equalsimpl0(r11, r0)
            if (r11 != 0) goto L_0x01a9
            r13.invalidateOverscroll()
        L_0x01a9:
            r13.animateToRelease()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m194applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        long r0 = SizeKt.m3641getCenteruvyYCjk(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
            z = false;
        } else {
            m190pullLeft0a9Yr6o(Offset.Companion.m3578getZeroF1C5BW0(), r0);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) != 0.0f) {
            m191pullRight0a9Yr6o(Offset.Companion.m3578getZeroF1C5BW0(), r0);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
            m192pullTop0a9Yr6o(Offset.Companion.m3578getZeroF1C5BW0(), r0);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
            return z;
        }
        m189pullBottom0a9Yr6o(Offset.Companion.m3578getZeroF1C5BW0(), r0);
        return true;
    }

    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void drawOverscroll(DrawScope drawScope) {
        boolean z;
        if (!Size.m3633isEmptyimpl(this.containerSize)) {
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            this.consumeCount = getInvalidateCount();
            android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) != 0.0f) {
                drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
                this.leftEffectNegation.finish();
            }
            boolean z2 = false;
            if (!this.leftEffect.isFinished()) {
                z = drawLeft(drawScope, this.leftEffect, nativeCanvas);
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
            } else {
                z = false;
            }
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) != 0.0f) {
                drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
                this.topEffectNegation.finish();
            }
            if (!this.topEffect.isFinished()) {
                z = drawTop(drawScope, this.topEffect, nativeCanvas) || z;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
            }
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) != 0.0f) {
                drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
                this.rightEffectNegation.finish();
            }
            if (!this.rightEffect.isFinished()) {
                z = drawRight(drawScope, this.rightEffect, nativeCanvas) || z;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
            }
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) != 0.0f) {
                drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
                this.bottomEffectNegation.finish();
            }
            if (!this.bottomEffect.isFinished()) {
                if (drawBottom(drawScope, this.bottomEffect, nativeCanvas) || z) {
                    z2 = true;
                }
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
                z = z2;
            }
            if (z) {
                invalidateOverscroll();
            }
        }
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m3628getHeightimpl(this.containerSize), drawScope.m6550toPx0680j_4(this.overscrollConfig.getDrawPadding().m685calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.translate(0.0f, drawScope.m6550toPx0680j_4(this.overscrollConfig.getDrawPadding().m687calculateTopPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt.roundToInt(Size.m3631getWidthimpl(this.containerSize));
        float r2 = this.overscrollConfig.getDrawPadding().m686calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-((float) roundToInt)) + drawScope.m6550toPx0680j_4(r2));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m3631getWidthimpl(this.containerSize), (-Size.m3628getHeightimpl(this.containerSize)) + drawScope.m6550toPx0680j_4(this.overscrollConfig.getDrawPadding().m684calculateBottomPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    /* access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled && this.consumeCount == getInvalidateCount()) {
            setInvalidateCount(getInvalidateCount() + 1);
        }
    }

    /* access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EdgeEffect edgeEffect = list.get(i);
            edgeEffect.onRelease();
            z = edgeEffect.isFinished() || z;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M  reason: not valid java name */
    private final boolean m193releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        boolean z2 = false;
        if (this.leftEffect.isFinished() || Offset.m3562getXimpl(j) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m3562getXimpl(j));
            z = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m3562getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m3562getXimpl(j));
            z = z || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m3563getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m3563getYimpl(j));
            z = z || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m3563getYimpl(j) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m3563getYimpl(j));
        if (z || this.bottomEffect.isFinished()) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: pullTop-0a9Yr6o  reason: not valid java name */
    private final float m192pullTop0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m3563getYimpl(j) / Size.m3628getHeightimpl(this.containerSize), Offset.m3562getXimpl(j2) / Size.m3631getWidthimpl(this.containerSize)) * Size.m3628getHeightimpl(this.containerSize) : Offset.m3563getYimpl(j);
    }

    /* renamed from: pullBottom-0a9Yr6o  reason: not valid java name */
    private final float m189pullBottom0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m3563getYimpl(j) / Size.m3628getHeightimpl(this.containerSize)), ((float) 1) - (Offset.m3562getXimpl(j2) / Size.m3631getWidthimpl(this.containerSize)))) * Size.m3628getHeightimpl(this.containerSize) : Offset.m3563getYimpl(j);
    }

    /* renamed from: pullLeft-0a9Yr6o  reason: not valid java name */
    private final float m190pullLeft0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m3562getXimpl(j) / Size.m3631getWidthimpl(this.containerSize), ((float) 1) - (Offset.m3563getYimpl(j2) / Size.m3628getHeightimpl(this.containerSize))) * Size.m3631getWidthimpl(this.containerSize) : Offset.m3562getXimpl(j);
    }

    /* renamed from: pullRight-0a9Yr6o  reason: not valid java name */
    private final float m191pullRight0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m3562getXimpl(j) / Size.m3631getWidthimpl(this.containerSize)), Offset.m3563getYimpl(j2) / Size.m3628getHeightimpl(this.containerSize))) * Size.m3631getWidthimpl(this.containerSize) : Offset.m3562getXimpl(j);
    }
}
