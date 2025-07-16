package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007\u001a!\u0010\n\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001aÃ\u0001\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00102>\b\u0002\u0010\u0014\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0015¢\u0006\u0002\b\u001c2>\b\u0002\u0010\u001d\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0015¢\u0006\u0002\b\u001c2\b\b\u0002\u0010 \u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010!\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\""}, d2 = {"NoOpDrag2DScope", "Landroidx/compose/foundation/gestures/Drag2DScope;", "getNoOpDrag2DScope$annotations", "()V", "Draggable2DState", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "rememberDraggable2DState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/Draggable2DState;", "draggable2D", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable2D.kt */
public final class Draggable2DKt {
    /* access modifiers changed from: private */
    public static final Drag2DScope NoOpDrag2DScope = new Draggable2DKt$NoOpDrag2DScope$1();

    private static /* synthetic */ void getNoOpDrag2DScope$annotations() {
    }

    public static final Draggable2DState Draggable2DState(Function1<? super Offset, Unit> function1) {
        return new DefaultDraggable2DState(function1);
    }

    public static final Draggable2DState rememberDraggable2DState(Function1<? super Offset, Unit> function1, Composer composer, int i) {
        composer.startReplaceableGroup(-1150277615);
        ComposerKt.sourceInformation(composer, "C(rememberDraggable2DState)119@4839L29,120@4880L63:Draggable2D.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1150277615, i, -1, "androidx.compose.foundation.gestures.rememberDraggable2DState (Draggable2D.kt:118)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = Draggable2DState(new Draggable2DKt$rememberDraggable2DState$1$1(rememberUpdatedState));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Draggable2DState draggable2DState = (Draggable2DState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return draggable2DState;
    }

    public static /* synthetic */ Modifier draggable2D$default(Modifier modifier, Draggable2DState draggable2DState, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3 function3, Function3 function32, boolean z3, int i, Object obj) {
        boolean z4 = (i & 2) != 0 ? true : z;
        MutableInteractionSource mutableInteractionSource2 = (i & 4) != 0 ? null : mutableInteractionSource;
        boolean z5 = false;
        boolean z6 = (i & 8) != 0 ? false : z2;
        Function3 draggable2DKt$draggable2D$1 = (i & 16) != 0 ? new Draggable2DKt$draggable2D$1((Continuation<? super Draggable2DKt$draggable2D$1>) null) : function3;
        Function3 draggable2DKt$draggable2D$2 = (i & 32) != 0 ? new Draggable2DKt$draggable2D$2((Continuation<? super Draggable2DKt$draggable2D$2>) null) : function32;
        if ((i & 64) == 0) {
            z5 = z3;
        }
        return draggable2D(modifier, draggable2DState, z4, mutableInteractionSource2, z6, draggable2DKt$draggable2D$1, draggable2DKt$draggable2D$2, z5);
    }

    public static final Modifier draggable2D(Modifier modifier, Draggable2DState draggable2DState, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z3) {
        boolean z4 = z2;
        Modifier modifier2 = modifier;
        return modifier.then(new Draggable2DElement(draggable2DState, Draggable2DKt$draggable2D$3.INSTANCE, z, mutableInteractionSource, new Draggable2DKt$draggable2D$4(z2), function3, function32, z3));
    }
}
