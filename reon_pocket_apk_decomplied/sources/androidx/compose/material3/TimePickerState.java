package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 d2\u00020\u0001:\u0001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010G\u001a\u00020HH@¢\u0006\u0004\bI\u0010JJ\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0015\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ%\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0013H\u0000¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u0013H\u0002J0\u0010U\u001a\u00020H2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0006H@¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020H2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020H2\u0006\u00101\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020HH@¢\u0006\u0002\u0010JJ\"\u0010^\u001a\u00020H2\u0006\u0010L\u001a\u00020\u00132\b\b\u0002\u0010_\u001a\u00020\u0006H@¢\u0006\u0004\b`\u0010aJ\f\u0010b\u001a\u00020\u0003*\u00020\u0013H\u0002J\f\u0010c\u001a\u00020\u0003*\u00020\u0013H\u0002R1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8@@@X\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0011\u0010#\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b%\u0010$R+\u0010(\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b)\u0010$\"\u0004\b*\u0010+R+\u0010-\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010$\"\u0004\b/\u0010+R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0019R+\u00103\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0002¢\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R1\u0010:\u001a\u0002092\u0006\u0010\b\u001a\u0002098@@@X\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b>\u0010\u0010\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010=R!\u0010?\u001a\u00020@8@X\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bB\u0010'\u001a\u0004\bA\u0010\fR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030D8@X\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac$material3_release", "()J", "setCenter--gyyYBs$material3_release", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getCurrentAngle$material3_release", "()Landroidx/compose/animation/core/Animatable;", "hour", "getHour", "()I", "hourAngle", "getHourAngle$material3_release", "()F", "setHourAngle$material3_release", "(F)V", "hourAngle$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hourForDisplay", "getHourForDisplay$material3_release", "is24hour", "()Z", "isAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/State;", "isAfternoonToggle", "isAfternoonToggle$material3_release", "setAfternoonToggle$material3_release", "(Z)V", "isAfternoonToggle$delegate", "isInnerCircle", "isInnerCircle$material3_release", "setInnerCircle$material3_release", "isInnerCircle$delegate", "minute", "getMinute", "minuteAngle", "getMinuteAngle$material3_release", "setMinuteAngle$material3_release", "minuteAngle$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/material3/Selection;", "selection", "getSelection-JiIwxys$material3_release", "setSelection-iHAOin8$material3_release", "(I)V", "selection$delegate", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos-RKDOV3M$material3_release", "selectorPos$delegate", "values", "", "getValues$material3_release", "()Ljava/util/List;", "animateToCurrent", "", "animateToCurrent$material3_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelected", "value", "isSelected$material3_release", "moveSelector", "x", "y", "maxDist", "moveSelector$material3_release", "offsetHour", "angle", "onTap", "autoSwitchToMinute", "onTap$material3_release", "(FFFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHour", "setHour$material3_release", "setMinute", "setMinute$material3_release", "settle", "update", "fromTap", "update$material3_release", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHour", "toMinute", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePickerState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableState center$delegate;
    private final Animatable<Float, AnimationVector1D> currentAngle;
    private final MutableFloatState hourAngle$delegate;
    private final boolean is24hour;
    private final State isAfternoon$delegate;
    private final MutableState isAfternoonToggle$delegate;
    private final MutableState isInnerCircle$delegate;
    private final MutableFloatState minuteAngle$delegate;
    private final MutatorMutex mutex;
    private final MutableState selection$delegate;
    private final State selectorPos$delegate;

    /* access modifiers changed from: private */
    public final float offsetHour(float f) {
        float f2 = f + 1.5707964f;
        return f2 < 0.0f ? f2 + 6.2831855f : f2;
    }

    public TimePickerState(int i, int i2, boolean z) {
        if (i < 0 || i >= 24) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        } else if (i2 < 0 || i2 >= 60) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        } else {
            this.is24hour = z;
            this.selectorPos$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new TimePickerState$selectorPos$2(this, z));
            this.center$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m6739boximpl(IntOffset.Companion.m6758getZeronOccac()), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.selection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m2161boximpl(Selection.Companion.m2168getHourJiIwxys()), (SnapshotMutationPolicy) null, 2, (Object) null);
            boolean z2 = true;
            this.isAfternoonToggle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12 && !z), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.isInnerCircle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i < 12 ? false : z2), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.hourAngle$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf((((float) (i % 12)) * 0.5235988f) - 1.5707964f);
            this.minuteAngle$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf((((float) i2) * 0.10471976f) - 1.5707964f);
            this.mutex = new MutatorMutex();
            this.isAfternoon$delegate = SnapshotStateKt.derivedStateOf(new TimePickerState$isAfternoon$2(this));
            this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, (Object) null);
        }
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    public final boolean is24hour() {
        return this.is24hour;
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    /* renamed from: getSelectorPos-RKDOV3M$material3_release  reason: not valid java name */
    public final long m2508getSelectorPosRKDOV3M$material3_release() {
        return ((DpOffset) this.selectorPos$delegate.getValue()).m6683unboximpl();
    }

    /* renamed from: getCenter-nOcc-ac$material3_release  reason: not valid java name */
    public final long m2506getCenternOccac$material3_release() {
        return ((IntOffset) this.center$delegate.getValue()).m6757unboximpl();
    }

    /* renamed from: setCenter--gyyYBs$material3_release  reason: not valid java name */
    public final void m2509setCentergyyYBs$material3_release(long j) {
        this.center$delegate.setValue(IntOffset.m6739boximpl(j));
    }

    public final List<Integer> getValues$material3_release() {
        return Selection.m2164equalsimpl0(m2507getSelectionJiIwxys$material3_release(), Selection.Companion.m2169getMinuteJiIwxys()) ? TimePickerKt.Minutes : TimePickerKt.Hours;
    }

    /* renamed from: getSelection-JiIwxys$material3_release  reason: not valid java name */
    public final int m2507getSelectionJiIwxys$material3_release() {
        return ((Selection) this.selection$delegate.getValue()).m2167unboximpl();
    }

    /* renamed from: setSelection-iHAOin8$material3_release  reason: not valid java name */
    public final void m2510setSelectioniHAOin8$material3_release(int i) {
        this.selection$delegate.setValue(Selection.m2161boximpl(i));
    }

    public final boolean isAfternoonToggle$material3_release() {
        return ((Boolean) this.isAfternoonToggle$delegate.getValue()).booleanValue();
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        this.isAfternoonToggle$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isInnerCircle$material3_release() {
        return ((Boolean) this.isInnerCircle$delegate.getValue()).booleanValue();
    }

    public final void setInnerCircle$material3_release(boolean z) {
        this.isInnerCircle$delegate.setValue(Boolean.valueOf(z));
    }

    public final float getHourAngle$material3_release() {
        return this.hourAngle$delegate.getFloatValue();
    }

    public final void setHourAngle$material3_release(float f) {
        this.hourAngle$delegate.setFloatValue(f);
    }

    public final float getMinuteAngle$material3_release() {
        return this.minuteAngle$delegate.getFloatValue();
    }

    public final void setMinuteAngle$material3_release(float f) {
        this.minuteAngle$delegate.setFloatValue(f);
    }

    private final boolean isAfternoon() {
        return ((Boolean) this.isAfternoon$delegate.getValue()).booleanValue();
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    public final void setMinute$material3_release(int i) {
        setMinuteAngle$material3_release((((float) i) * 0.10471976f) - 1.5707964f);
    }

    public final void setHour$material3_release(int i) {
        setInnerCircle$material3_release(i >= 12);
        setHourAngle$material3_release((((float) (i % 12)) * 0.5235988f) - 1.5707964f);
    }

    public final void moveSelector$material3_release(float f, float f2, float f3) {
        if (Selection.m2164equalsimpl0(m2507getSelectionJiIwxys$material3_release(), Selection.Companion.m2168getHourJiIwxys()) && this.is24hour) {
            setInnerCircle$material3_release(TimePickerKt.dist(f, f2, IntOffset.m6748getXimpl(m2506getCenternOccac$material3_release()), IntOffset.m6749getYimpl(m2506getCenternOccac$material3_release())) < f3);
        }
    }

    public final boolean isSelected$material3_release(int i) {
        if (!Selection.m2164equalsimpl0(m2507getSelectionJiIwxys$material3_release(), Selection.Companion.m2169getMinuteJiIwxys())) {
            if (getHour() == i + (isAfternoon() ? 12 : 0)) {
                return true;
            }
        } else if (i == getMinute()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, continuation);
    }

    public final Object update$material3_release(float f, boolean z, Continuation<? super Unit> continuation) {
        Object mutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, f, z, (Continuation<? super TimePickerState$update$2>) null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateToCurrent$material3_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.compose.material3.TimePickerState$animateToCurrent$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = (androidx.compose.material3.TimePickerState$animateToCurrent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = new androidx.compose.material3.TimePickerState$animateToCurrent$1
            r0.<init>(r10, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0041
            if (r1 == r3) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00be
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0037:
            float r1 = r6.F$0
            java.lang.Object r3 = r6.L$0
            androidx.compose.material3.TimePickerState r3 = (androidx.compose.material3.TimePickerState) r3
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0096
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r11)
            int r11 = r10.m2507getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r1 = androidx.compose.material3.Selection.Companion
            int r1 = r1.m2168getHourJiIwxys()
            boolean r11 = androidx.compose.material3.Selection.m2164equalsimpl0(r11, r1)
            if (r11 == 0) goto L_0x0061
            float r11 = r10.getMinuteAngle$material3_release()
            float r1 = r10.getHourAngle$material3_release()
            kotlin.Pair r11 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r11, r1)
            goto L_0x006d
        L_0x0061:
            float r11 = r10.getHourAngle$material3_release()
            float r1 = r10.getMinuteAngle$material3_release()
            kotlin.Pair r11 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r11, r1)
        L_0x006d:
            java.lang.Object r1 = r11.component1()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Object r11 = r11.component2()
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r10.currentAngle
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r6.L$0 = r10
            r6.F$0 = r11
            r6.label = r3
            java.lang.Object r1 = r4.snapTo(r1, r6)
            if (r1 != r0) goto L_0x0094
            return r0
        L_0x0094:
            r3 = r10
            r1 = r11
        L_0x0096:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r11 = r3.currentAngle
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r1 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r1, r7, r4, r7)
            r4 = r1
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r6.L$0 = r7
            r6.label = r2
            r5 = 0
            r8 = 12
            r9 = 0
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r8
            r8 = r9
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L_0x00be
            return r0
        L_0x00be:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.animateToCurrent$material3_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int hourForDisplay(int i) {
        if (this.is24hour) {
            return i % 24;
        }
        if (i % 12 == 0) {
            return 12;
        }
        return isAfternoon() ? i - 12 : i;
    }

    /* access modifiers changed from: private */
    public final int toHour(float f) {
        return ((int) ((((double) f) + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    /* access modifiers changed from: private */
    public final int toMinute(float f) {
        return ((int) ((((double) f) + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0097 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object settle(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.compose.material3.TimePickerState$settle$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.material3.TimePickerState$settle$1 r0 = (androidx.compose.material3.TimePickerState$settle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.TimePickerState$settle$1 r0 = new androidx.compose.material3.TimePickerState$settle$1
            r0.<init>(r10, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r3) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0098
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0037:
            java.lang.Object r1 = r6.L$1
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r3 = r6.L$0
            androidx.compose.material3.TimePickerState r3 = (androidx.compose.material3.TimePickerState) r3
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006e
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r11 = r10.currentAngle
            java.lang.Object r11 = r11.getValue()
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            float r1 = r10.getMinuteAngle$material3_release()
            kotlin.Pair r1 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r11, r1)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r11 = r10.currentAngle
            java.lang.Object r4 = r1.getFirst()
            r6.L$0 = r10
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r11 = r11.snapTo(r4, r6)
            if (r11 != r0) goto L_0x006d
            return r0
        L_0x006d:
            r3 = r10
        L_0x006e:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r11 = r3.currentAngle
            java.lang.Object r3 = r1.getSecond()
            r1 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r1, r7, r4, r7)
            r4 = r1
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r6.L$0 = r7
            r6.L$1 = r7
            r6.label = r2
            r5 = 0
            r8 = 12
            r9 = 0
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r8
            r8 = r9
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L_0x0098
            return r0
        L_0x0098:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.settle(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0100 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onTap$material3_release(float r11, float r12, float r13, boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof androidx.compose.material3.TimePickerState$onTap$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.material3.TimePickerState$onTap$1 r0 = (androidx.compose.material3.TimePickerState$onTap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.TimePickerState$onTap$1 r0 = new androidx.compose.material3.TimePickerState$onTap$1
            r0.<init>(r10, r15)
        L_0x0019:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0064
            if (r1 == r5) goto L_0x0050
            if (r1 == r4) goto L_0x0043
            if (r1 == r3) goto L_0x003e
            if (r1 != r2) goto L_0x0036
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x010f
        L_0x0036:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0101
        L_0x0043:
            java.lang.Object r11 = r6.L$1
            kotlin.Pair r11 = (kotlin.Pair) r11
            java.lang.Object r12 = r6.L$0
            androidx.compose.material3.TimePickerState r12 = (androidx.compose.material3.TimePickerState) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00de
        L_0x0050:
            boolean r14 = r6.Z$0
            float r13 = r6.F$2
            float r12 = r6.F$1
            float r11 = r6.F$0
            java.lang.Object r1 = r6.L$0
            androidx.compose.material3.TimePickerState r1 = (androidx.compose.material3.TimePickerState) r1
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r1
            goto L_0x0098
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r15)
            long r8 = r10.m2506getCenternOccac$material3_release()
            int r15 = androidx.compose.ui.unit.IntOffset.m6749getYimpl(r8)
            float r15 = (float) r15
            float r15 = r12 - r15
            long r8 = r10.m2506getCenternOccac$material3_release()
            int r1 = androidx.compose.ui.unit.IntOffset.m6748getXimpl(r8)
            float r1 = (float) r1
            float r1 = r11 - r1
            float r15 = androidx.compose.material3.TimePickerKt.atan(r15, r1)
            r6.L$0 = r10
            r6.F$0 = r11
            r6.F$1 = r12
            r6.F$2 = r13
            r6.Z$0 = r14
            r6.label = r5
            java.lang.Object r15 = r10.update$material3_release(r15, r5, r6)
            if (r15 != r0) goto L_0x0094
            return r0
        L_0x0094:
            r15 = r14
            r14 = r13
            r13 = r12
            r12 = r10
        L_0x0098:
            r12.moveSelector$material3_release(r11, r13, r14)
            int r11 = r12.m2507getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r13 = androidx.compose.material3.Selection.Companion
            int r13 = r13.m2168getHourJiIwxys()
            boolean r11 = androidx.compose.material3.Selection.m2164equalsimpl0(r11, r13)
            if (r11 == 0) goto L_0x0104
            if (r15 == 0) goto L_0x00b7
            androidx.compose.material3.Selection$Companion r11 = androidx.compose.material3.Selection.Companion
            int r11 = r11.m2169getMinuteJiIwxys()
            r12.m2510setSelectioniHAOin8$material3_release(r11)
            goto L_0x0101
        L_0x00b7:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r11 = r12.currentAngle
            java.lang.Object r11 = r11.getValue()
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            float r13 = r12.getHourAngle$material3_release()
            kotlin.Pair r11 = androidx.compose.material3.TimePickerKt.valuesForAnimation(r11, r13)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r13 = r12.currentAngle
            java.lang.Object r14 = r11.getFirst()
            r6.L$0 = r12
            r6.L$1 = r11
            r6.label = r4
            java.lang.Object r13 = r13.snapTo(r14, r6)
            if (r13 != r0) goto L_0x00de
            return r0
        L_0x00de:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r12.currentAngle
            java.lang.Object r2 = r11.getSecond()
            r11 = 0
            r12 = 6
            r13 = 200(0xc8, float:2.8E-43)
            androidx.compose.animation.core.TweenSpec r11 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r13, r11, r7, r12, r7)
            androidx.compose.animation.core.AnimationSpec r11 = (androidx.compose.animation.core.AnimationSpec) r11
            r6.L$0 = r7
            r6.L$1 = r7
            r6.label = r3
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            r3 = r11
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L_0x0101
            return r0
        L_0x0101:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0104:
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r11 = r12.settle(r6)
            if (r11 != r0) goto L_0x010f
            return r0
        L_0x010f:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.onTap$material3_release(float, float, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TimePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(TimePickerState$Companion$Saver$1.INSTANCE, TimePickerState$Companion$Saver$2.INSTANCE);
        }
    }
}
