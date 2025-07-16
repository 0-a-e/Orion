package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001!\u001a\u0012\u0010#\u001a\u00020$*\u00020%H@¢\u0006\u0002\u0010&\u001a\\\u0010'\u001a\u00020(*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\b\b\u0002\u00104\u001a\u000205H\u0007\u001aH\u0010'\u001a\u00020(*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"F\u0010\u0012\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0013¢\u0006\u0002\b\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001d\"\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"¨\u00066"}, d2 = {"CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "DefaultScrollMotionDurationScaleFactor", "", "ModifierLocalScrollableContainer", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getModifierLocalScrollableContainer", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "NoOpFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "getNoOpFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "NoOpOnDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "UnityDensity", "androidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1", "Landroidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1;", "awaitScrollEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "reverseDirection", "flingBehavior", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollableKt {
    /* access modifiers changed from: private */
    public static final Function1<PointerInputChange, Boolean> CanDragCalculation = ScrollableKt$CanDragCalculation$1.INSTANCE;
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new ScrollableKt$DefaultScrollMotionDurationScale$1();
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final ProvidableModifierLocal<Boolean> ModifierLocalScrollableContainer = ModifierLocalKt.modifierLocalOf(ScrollableKt$ModifierLocalScrollableContainer$1.INSTANCE);
    private static final FlingBehavior NoOpFlingBehavior = new ScrollableKt$NoOpFlingBehavior$1();
    /* access modifiers changed from: private */
    public static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted = new ScrollableKt$NoOpOnDragStarted$1((Continuation<? super ScrollableKt$NoOpOnDragStarted$1>) null);
    /* access modifiers changed from: private */
    public static final ScrollScope NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();
    /* access modifiers changed from: private */
    public static final ScrollableKt$UnityDensity$1 UnityDensity = new ScrollableKt$UnityDensity$1();

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        return scrollable(modifier, scrollableState, orientation, z3, z2, (i & 16) != 0 ? null : flingBehavior, (i & 32) != 0 ? null : mutableInteractionSource);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        return scrollable$default(modifier, scrollableState, orientation, (OverscrollEffect) null, z, z2, flingBehavior, mutableInteractionSource, (BringIntoViewSpec) null, 128, (Object) null);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, int i, Object obj) {
        int i2 = i;
        return scrollable(modifier, scrollableState, orientation, overscrollEffect, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? null : flingBehavior, (i2 & 64) != 0 ? null : mutableInteractionSource, (i2 & 128) != 0 ? ScrollableDefaults.INSTANCE.bringIntoViewSpec() : bringIntoViewSpec);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        Modifier modifier2 = modifier;
        return modifier.then(new ScrollableElement(scrollableState, orientation, overscrollEffect, z, z2, flingBehavior, mutableInteractionSource, bringIntoViewSpec));
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    public static final java.lang.Object awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x0039:
            r0.L$0 = r5
            r0.label = r3
            r6 = 0
            java.lang.Object r6 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r5, r6, r0, r3, r6)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            androidx.compose.ui.input.pointer.PointerEvent r6 = (androidx.compose.ui.input.pointer.PointerEvent) r6
            int r2 = r6.m5054getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r4 = r4.m5070getScroll7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m5061equalsimpl0(r2, r4)
            if (r2 == 0) goto L_0x0039
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ProvidableModifierLocal<Boolean> getModifierLocalScrollableContainer() {
        return ModifierLocalScrollableContainer;
    }

    public static final FlingBehavior getNoOpFlingBehavior() {
        return NoOpFlingBehavior;
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }
}
