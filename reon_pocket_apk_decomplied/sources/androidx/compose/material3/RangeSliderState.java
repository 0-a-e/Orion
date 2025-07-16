package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0014\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\fJ\u001d\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020+2\u0006\u0010a\u001a\u00020\u0003H\u0000¢\u0006\u0002\bbJ \u0010c\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u0003H\u0002J*\u0010e\u001a\u00020>2\u0006\u00109\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010a\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020\tH\u0000¢\u0006\u0002\biR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R+\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000fR\u0014\u0010\"\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R+\u0010%\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R+\u0010.\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020+8@@@X\u0002¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b/\u00100\"\u0004\b1\u00102R+\u00105\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0017\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R+\u00109\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0017\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R(\u0010=\u001a\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\t\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010-\"\u0004\b@\u0010AR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR+\u0010D\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\bG\u0010\u0017\u001a\u0004\bE\u0010\u000f\"\u0004\bF\u0010\u0011R+\u0010H\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0017\u001a\u0004\bI\u0010\u000f\"\u0004\bJ\u0010\u0011R\u0014\u0010L\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010$R+\u0010N\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\bQ\u0010\u0017\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bR\u0010$R\u0014\u0010S\u001a\u00020TX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR+\u0010W\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\bX\u0010$\"\u0004\bY\u0010ZR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"Landroidx/compose/material3/RangeSliderState;", "", "activeRangeStart", "", "activeRangeEnd", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "newVal", "getActiveRangeEnd", "()F", "setActiveRangeEnd", "(F)V", "<set-?>", "activeRangeEndState", "getActiveRangeEndState", "setActiveRangeEndState", "activeRangeEndState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getActiveRangeStart", "setActiveRangeStart", "activeRangeStartState", "getActiveRangeStartState", "setActiveRangeStartState", "activeRangeStartState$delegate", "coercedActiveRangeEndAsFraction", "getCoercedActiveRangeEndAsFraction$material3_release", "coercedActiveRangeStartAsFraction", "getCoercedActiveRangeStartAsFraction$material3_release", "endSteps", "getEndSteps$material3_release", "()I", "endThumbWidth", "getEndThumbWidth$material3_release", "setEndThumbWidth$material3_release", "endThumbWidth$delegate", "gestureEndAction", "Lkotlin/Function1;", "", "getGestureEndAction$material3_release", "()Lkotlin/jvm/functions/Function1;", "isRtl", "isRtl$material3_release", "()Z", "setRtl$material3_release", "(Z)V", "isRtl$delegate", "Landroidx/compose/runtime/MutableState;", "maxPx", "getMaxPx", "setMaxPx", "maxPx$delegate", "minPx", "getMinPx", "setMinPx", "minPx$delegate", "onValueChange", "Landroidx/compose/material3/SliderRange;", "getOnValueChange$material3_release", "setOnValueChange$material3_release", "(Lkotlin/jvm/functions/Function1;)V", "getOnValueChangeFinished", "()Lkotlin/jvm/functions/Function0;", "rawOffsetEnd", "getRawOffsetEnd$material3_release", "setRawOffsetEnd$material3_release", "rawOffsetEnd$delegate", "rawOffsetStart", "getRawOffsetStart$material3_release", "setRawOffsetStart$material3_release", "rawOffsetStart$delegate", "startSteps", "getStartSteps$material3_release", "startThumbWidth", "getStartThumbWidth$material3_release", "setStartThumbWidth$material3_release", "startThumbWidth$delegate", "getSteps", "tickFractions", "", "getTickFractions$material3_release", "()[F", "totalWidth", "getTotalWidth$material3_release", "setTotalWidth$material3_release", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "onDrag", "isStart", "offset", "onDrag$material3_release", "scaleToOffset", "userValue", "scaleToUserValue", "scaleToUserValue-owVgs5E", "(FFJ)J", "updateMinMaxPx", "updateMinMaxPx$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class RangeSliderState {
    public static final int $stable = 0;
    private final MutableFloatState activeRangeEndState$delegate;
    private final MutableFloatState activeRangeStartState$delegate;
    private final MutableFloatState endThumbWidth$delegate;
    private final Function1<Boolean, Unit> gestureEndAction;
    private final MutableState isRtl$delegate;
    private final MutableFloatState maxPx$delegate;
    private final MutableFloatState minPx$delegate;
    private Function1<? super SliderRange, Unit> onValueChange;
    private final Function0<Unit> onValueChangeFinished;
    private final MutableFloatState rawOffsetEnd$delegate;
    private final MutableFloatState rawOffsetStart$delegate;
    private final MutableFloatState startThumbWidth$delegate;
    private final int steps;
    private final float[] tickFractions;
    private final MutableIntState totalWidth$delegate;
    private final ClosedFloatingPointRange<Float> valueRange;

    public RangeSliderState() {
        this(0.0f, 0.0f, 0, (Function0) null, (ClosedFloatingPointRange) null, 31, (DefaultConstructorMarker) null);
    }

    public RangeSliderState(float f, float f2, int i, Function0<Unit> function0, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        this.steps = i;
        this.onValueChangeFinished = function0;
        this.valueRange = closedFloatingPointRange;
        this.activeRangeStartState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.activeRangeEndState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
        this.tickFractions = SliderKt.stepsToTickFractions(i);
        this.startThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.endThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.rawOffsetStart$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.rawOffsetEnd$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.isRtl$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.gestureEndAction = new RangeSliderState$gestureEndAction$1(this);
        this.maxPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.minPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    }

    public final int getSteps() {
        return this.steps;
    }

    public final Function0<Unit> getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RangeSliderState(float r6, float r7, int r8, kotlin.jvm.functions.Function0 r9, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r5 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r6
        L_0x0008:
            r6 = r11 & 2
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x0010
            r2 = r1
            goto L_0x0011
        L_0x0010:
            r2 = r7
        L_0x0011:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0016
            r8 = 0
        L_0x0016:
            r3 = r8
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001c
            r9 = 0
        L_0x001c:
            r4 = r9
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0025
            kotlin.ranges.ClosedFloatingPointRange r10 = kotlin.ranges.RangesKt.rangeTo((float) r0, (float) r1)
        L_0x0025:
            r11 = r10
            r6 = r5
            r7 = r12
            r8 = r2
            r9 = r3
            r10 = r4
            r6.<init>(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.RangeSliderState.<init>(float, float, int, kotlin.jvm.functions.Function0, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ClosedFloatingPointRange<Float> getValueRange() {
        return this.valueRange;
    }

    private final float getActiveRangeStartState() {
        return this.activeRangeStartState$delegate.getFloatValue();
    }

    private final void setActiveRangeStartState(float f) {
        this.activeRangeStartState$delegate.setFloatValue(f);
    }

    private final float getActiveRangeEndState() {
        return this.activeRangeEndState$delegate.getFloatValue();
    }

    private final void setActiveRangeEndState(float f) {
        this.activeRangeEndState$delegate.setFloatValue(f);
    }

    public final void setActiveRangeStart(float f) {
        setActiveRangeStartState(SliderKt.snapValueToTick(RangesKt.coerceIn(f, this.valueRange.getStart().floatValue(), getActiveRangeEnd()), this.tickFractions, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    public final float getActiveRangeStart() {
        return getActiveRangeStartState();
    }

    public final void setActiveRangeEnd(float f) {
        setActiveRangeEndState(SliderKt.snapValueToTick(RangesKt.coerceIn(f, getActiveRangeStart(), this.valueRange.getEndInclusive().floatValue()), this.tickFractions, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    public final float getActiveRangeEnd() {
        return getActiveRangeEndState();
    }

    public final Function1<SliderRange, Unit> getOnValueChange$material3_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$material3_release(Function1<? super SliderRange, Unit> function1) {
        this.onValueChange = function1;
    }

    public final float[] getTickFractions$material3_release() {
        return this.tickFractions;
    }

    public final float getStartThumbWidth$material3_release() {
        return this.startThumbWidth$delegate.getFloatValue();
    }

    public final void setStartThumbWidth$material3_release(float f) {
        this.startThumbWidth$delegate.setFloatValue(f);
    }

    public final float getEndThumbWidth$material3_release() {
        return this.endThumbWidth$delegate.getFloatValue();
    }

    public final void setEndThumbWidth$material3_release(float f) {
        this.endThumbWidth$delegate.setFloatValue(f);
    }

    public final int getTotalWidth$material3_release() {
        return this.totalWidth$delegate.getIntValue();
    }

    public final void setTotalWidth$material3_release(int i) {
        this.totalWidth$delegate.setIntValue(i);
    }

    public final float getRawOffsetStart$material3_release() {
        return this.rawOffsetStart$delegate.getFloatValue();
    }

    public final void setRawOffsetStart$material3_release(float f) {
        this.rawOffsetStart$delegate.setFloatValue(f);
    }

    public final float getRawOffsetEnd$material3_release() {
        return this.rawOffsetEnd$delegate.getFloatValue();
    }

    public final void setRawOffsetEnd$material3_release(float f) {
        this.rawOffsetEnd$delegate.setFloatValue(f);
    }

    public final boolean isRtl$material3_release() {
        return ((Boolean) this.isRtl$delegate.getValue()).booleanValue();
    }

    public final void setRtl$material3_release(boolean z) {
        this.isRtl$delegate.setValue(Boolean.valueOf(z));
    }

    public final Function1<Boolean, Unit> getGestureEndAction$material3_release() {
        return this.gestureEndAction;
    }

    private final float getMaxPx() {
        return this.maxPx$delegate.getFloatValue();
    }

    private final void setMaxPx(float f) {
        this.maxPx$delegate.setFloatValue(f);
    }

    private final float getMinPx() {
        return this.minPx$delegate.getFloatValue();
    }

    private final void setMinPx(float f) {
        this.minPx$delegate.setFloatValue(f);
    }

    public final void onDrag$material3_release(boolean z, float f) {
        long j;
        if (z) {
            setRawOffsetStart$material3_release(getRawOffsetStart$material3_release() + f);
            setRawOffsetEnd$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
            float rawOffsetEnd$material3_release = getRawOffsetEnd$material3_release();
            j = SliderKt.SliderRange(SliderKt.snapValueToTick(RangesKt.coerceIn(getRawOffsetStart$material3_release(), getMinPx(), rawOffsetEnd$material3_release), this.tickFractions, getMinPx(), getMaxPx()), rawOffsetEnd$material3_release);
        } else {
            setRawOffsetEnd$material3_release(getRawOffsetEnd$material3_release() + f);
            setRawOffsetStart$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
            float rawOffsetStart$material3_release = getRawOffsetStart$material3_release();
            j = SliderKt.SliderRange(rawOffsetStart$material3_release, SliderKt.snapValueToTick(RangesKt.coerceIn(getRawOffsetEnd$material3_release(), rawOffsetStart$material3_release, getMaxPx()), this.tickFractions, getMinPx(), getMaxPx()));
        }
        long r4 = m2090scaleToUserValueowVgs5E(getMinPx(), getMaxPx(), j);
        if (!SliderRange.m2207equalsimpl0(r4, SliderKt.SliderRange(getActiveRangeStart(), getActiveRangeEnd()))) {
            Function1<? super SliderRange, Unit> function1 = this.onValueChange;
            if (function1 == null) {
                setActiveRangeStart(SliderRange.m2209getStartimpl(r4));
                setActiveRangeEnd(SliderRange.m2208getEndInclusiveimpl(r4));
            } else if (function1 != null) {
                function1.invoke(SliderRange.m2204boximpl(r4));
            }
        }
    }

    public final float getCoercedActiveRangeStartAsFraction$material3_release() {
        return SliderKt.calcFraction(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), getActiveRangeStart());
    }

    public final float getCoercedActiveRangeEndAsFraction$material3_release() {
        return SliderKt.calcFraction(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), getActiveRangeEnd());
    }

    public final int getStartSteps$material3_release() {
        return (int) ((float) Math.floor((double) (((float) this.steps) * getCoercedActiveRangeEndAsFraction$material3_release())));
    }

    public final int getEndSteps$material3_release() {
        return (int) ((float) Math.floor((double) (((float) this.steps) * (1.0f - getCoercedActiveRangeStartAsFraction$material3_release()))));
    }

    /* renamed from: scaleToUserValue-owVgs5E  reason: not valid java name */
    private final long m2090scaleToUserValueowVgs5E(float f, float f2, long j) {
        return SliderKt.m2198scaleziovWd0(f, f2, j, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue());
    }

    private final float scaleToOffset(float f, float f2, float f3) {
        return SliderKt.scale(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), f3, f, f2);
    }

    public final void updateMinMaxPx$material3_release() {
        float f = (float) 2;
        float max = Math.max(((float) getTotalWidth$material3_release()) - (getEndThumbWidth$material3_release() / f), 0.0f);
        float min = Math.min(getStartThumbWidth$material3_release() / f, max);
        if (getMinPx() != min || getMaxPx() != max) {
            setMinPx(min);
            setMaxPx(max);
            setRawOffsetStart$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
            setRawOffsetEnd$material3_release(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
        }
    }
}
