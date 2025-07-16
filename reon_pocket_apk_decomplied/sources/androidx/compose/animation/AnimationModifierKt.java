package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aV\u0010\t\u001a\u00020\n*\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"InvalidSize", "Landroidx/compose/ui/unit/IntSize;", "getInvalidSize", "()J", "J", "isValid", "", "isValid-ozmzZPI", "(J)Z", "animateContentSize", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "initialValue", "targetValue", "", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationModifier.kt */
public final class AnimationModifierKt {
    private static final long InvalidSize = IntSizeKt.IntSize(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public static /* synthetic */ Modifier animateContentSize$default(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        return animateContentSize(modifier, finiteAnimationSpec, function2);
    }

    public static final Modifier animateContentSize(Modifier modifier, FiniteAnimationSpec<IntSize> finiteAnimationSpec, Function2<? super IntSize, ? super IntSize, Unit> function2) {
        return ClipKt.clipToBounds(modifier).then(new SizeAnimationModifierElement(finiteAnimationSpec, function2));
    }

    public static final long getInvalidSize() {
        return InvalidSize;
    }

    /* renamed from: isValid-ozmzZPI  reason: not valid java name */
    public static final boolean m69isValidozmzZPI(long j) {
        return !IntSize.m6788equalsimpl0(j, InvalidSize);
    }
}
