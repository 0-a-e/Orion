package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u0003H\u0016J?\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020P2'\u0010Q\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0S\u0012\u0006\u0012\u0004\u0018\u00010T0R¢\u0006\u0002\bUH@¢\u0006\u0002\u0010VJ\u001a\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020YH\u0000ø\u0001\u0000¢\u0006\u0004\bZ\u0010[J \u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u0003H\u0002J \u0010`\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u0003H\u0002J\u001d\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u0005H\u0000¢\u0006\u0002\beR\u0014\u0010\f\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158@@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013R+\u0010'\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010*R+\u0010-\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b0\u0010,\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010*R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R+\u00105\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b8\u0010,\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010*R\u0014\u00109\u001a\u00020:X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R+\u0010=\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b>\u00104\"\u0004\b?\u0010@R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010*R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR+\u0010H\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\bK\u0010,\u001a\u0004\bI\u0010\u000e\"\u0004\bJ\u0010*\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"Landroidx/compose/material3/SliderState;", "Landroidx/compose/foundation/gestures/DraggableState;", "value", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "coercedValueAsFraction", "getCoercedValueAsFraction$material3_release", "()F", "dragScope", "Landroidx/compose/foundation/gestures/DragScope;", "gestureEndAction", "getGestureEndAction$material3_release", "()Lkotlin/jvm/functions/Function0;", "<set-?>", "", "isDragging", "isDragging$material3_release", "()Z", "setDragging", "(Z)V", "isDragging$delegate", "Landroidx/compose/runtime/MutableState;", "isRtl", "isRtl$material3_release", "setRtl$material3_release", "onValueChange", "Lkotlin/Function1;", "getOnValueChange$material3_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$material3_release", "(Lkotlin/jvm/functions/Function1;)V", "getOnValueChangeFinished", "pressOffset", "getPressOffset", "setPressOffset", "(F)V", "pressOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "rawOffset", "getRawOffset", "setRawOffset", "rawOffset$delegate", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "getSteps", "()I", "thumbWidth", "getThumbWidth", "setThumbWidth", "thumbWidth$delegate", "tickFractions", "", "getTickFractions$material3_release", "()[F", "totalWidth", "getTotalWidth", "setTotalWidth", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "newVal", "getValue", "setValue", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "valueState", "getValueState", "setValueState", "valueState$delegate", "dispatchRawDelta", "delta", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPress", "pos", "Landroidx/compose/ui/geometry/Offset;", "onPress-k-4lQ0M$material3_release", "(J)V", "scaleToOffset", "minPx", "maxPx", "userValue", "scaleToUserValue", "offset", "updateDimensions", "newThumbWidth", "newTotalWidth", "updateDimensions$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderState implements DraggableState {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final DragScope dragScope;
    private final Function0<Unit> gestureEndAction;
    private final MutableState isDragging$delegate;
    private boolean isRtl;
    private Function1<? super Float, Unit> onValueChange;
    private final Function0<Unit> onValueChangeFinished;
    private final MutableFloatState pressOffset$delegate;
    private final MutableFloatState rawOffset$delegate;
    /* access modifiers changed from: private */
    public final MutatorMutex scrollMutex;
    private final int steps;
    private final MutableFloatState thumbWidth$delegate;
    private final float[] tickFractions;
    private final MutableIntState totalWidth$delegate;
    private final ClosedFloatingPointRange<Float> valueRange;
    private final MutableFloatState valueState$delegate;

    public SliderState() {
        this(0.0f, 0, (Function0) null, (ClosedFloatingPointRange) null, 15, (DefaultConstructorMarker) null);
    }

    public SliderState(float f, int i, Function0<Unit> function0, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        this.steps = i;
        this.onValueChangeFinished = function0;
        this.valueRange = closedFloatingPointRange;
        this.valueState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.tickFractions = SliderKt.stepsToTickFractions(i);
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.thumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.isDragging$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.gestureEndAction = new SliderState$gestureEndAction$1(this);
        this.rawOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(scaleToOffset(0.0f, 0.0f, f));
        this.pressOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragScope = new SliderState$dragScope$1(this);
        this.scrollMutex = new MutatorMutex();
    }

    public final int getSteps() {
        return this.steps;
    }

    public final Function0<Unit> getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SliderState(float f, int i, Function0 function0, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : function0, (i2 & 8) != 0 ? RangesKt.rangeTo(0.0f, 1.0f) : closedFloatingPointRange);
    }

    public final ClosedFloatingPointRange<Float> getValueRange() {
        return this.valueRange;
    }

    private final float getValueState() {
        return this.valueState$delegate.getFloatValue();
    }

    private final void setValueState(float f) {
        this.valueState$delegate.setFloatValue(f);
    }

    public final void setValue(float f) {
        setValueState(SliderKt.snapValueToTick(RangesKt.coerceIn(f, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()), this.tickFractions, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    public final float getValue() {
        return getValueState();
    }

    public Object drag(MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new SliderState$drag$2(this, mutatePriority, function2, (Continuation<? super SliderState$drag$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public void dispatchRawDelta(float f) {
        float f2 = (float) 2;
        float max = Math.max(((float) getTotalWidth()) - (getThumbWidth() / f2), 0.0f);
        float min = Math.min(getThumbWidth() / f2, max);
        setRawOffset(getRawOffset() + f + getPressOffset());
        setPressOffset(0.0f);
        float scaleToUserValue = scaleToUserValue(min, max, SliderKt.snapValueToTick(getRawOffset(), this.tickFractions, min, max));
        if (scaleToUserValue != getValue()) {
            Function1<? super Float, Unit> function1 = this.onValueChange;
            if (function1 == null) {
                setValue(scaleToUserValue);
            } else if (function1 != null) {
                function1.invoke(Float.valueOf(scaleToUserValue));
            }
        }
    }

    public final Function1<Float, Unit> getOnValueChange$material3_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$material3_release(Function1<? super Float, Unit> function1) {
        this.onValueChange = function1;
    }

    public final float[] getTickFractions$material3_release() {
        return this.tickFractions;
    }

    private final int getTotalWidth() {
        return this.totalWidth$delegate.getIntValue();
    }

    private final void setTotalWidth(int i) {
        this.totalWidth$delegate.setIntValue(i);
    }

    public final boolean isRtl$material3_release() {
        return this.isRtl;
    }

    public final void setRtl$material3_release(boolean z) {
        this.isRtl = z;
    }

    private final float getThumbWidth() {
        return this.thumbWidth$delegate.getFloatValue();
    }

    private final void setThumbWidth(float f) {
        this.thumbWidth$delegate.setFloatValue(f);
    }

    public final float getCoercedValueAsFraction$material3_release() {
        return SliderKt.calcFraction(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), RangesKt.coerceIn(getValue(), this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    /* access modifiers changed from: private */
    public final void setDragging(boolean z) {
        this.isDragging$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isDragging$material3_release() {
        return ((Boolean) this.isDragging$delegate.getValue()).booleanValue();
    }

    public final void updateDimensions$material3_release(float f, int i) {
        setThumbWidth(f);
        setTotalWidth(i);
    }

    public final Function0<Unit> getGestureEndAction$material3_release() {
        return this.gestureEndAction;
    }

    /* renamed from: onPress-k-4lQ0M$material3_release  reason: not valid java name */
    public final void m2215onPressk4lQ0M$material3_release(long j) {
        setPressOffset((this.isRtl ? ((float) getTotalWidth()) - Offset.m3562getXimpl(j) : Offset.m3562getXimpl(j)) - getRawOffset());
    }

    private final float getRawOffset() {
        return this.rawOffset$delegate.getFloatValue();
    }

    private final void setRawOffset(float f) {
        this.rawOffset$delegate.setFloatValue(f);
    }

    private final float getPressOffset() {
        return this.pressOffset$delegate.getFloatValue();
    }

    private final void setPressOffset(float f) {
        this.pressOffset$delegate.setFloatValue(f);
    }

    private final float scaleToUserValue(float f, float f2, float f3) {
        return SliderKt.scale(f, f2, f3, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue());
    }

    private final float scaleToOffset(float f, float f2, float f3) {
        return SliderKt.scale(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), f3, f, f2);
    }
}
