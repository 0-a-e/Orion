package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J6\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/NoOpOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "()V", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "isInProgress", "", "()Z", "applyToFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "Landroidx/compose/ui/geometry/Offset;", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Overscroll.kt */
public final class NoOpOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    public static final NoOpOverscrollEffect INSTANCE = new NoOpOverscrollEffect();

    public boolean isInProgress() {
        return false;
    }

    private NoOpOverscrollEffect() {
    }

    /* renamed from: applyToScroll-Rhakbz0  reason: not valid java name */
    public long m310applyToScrollRhakbz0(long j, int i, Function1<? super Offset, Offset> function1) {
        return function1.invoke(Offset.m3551boximpl(j)).m3572unboximpl();
    }

    /* renamed from: applyToFling-BMRW4eQ  reason: not valid java name */
    public Object m309applyToFlingBMRW4eQ(long j, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object invoke = function2.invoke(Velocity.m6846boximpl(j), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    public Modifier getEffectModifier() {
        return Modifier.Companion;
    }
}
