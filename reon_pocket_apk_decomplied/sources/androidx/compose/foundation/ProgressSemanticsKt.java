package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"progressSemantics", "Landroidx/compose/ui/Modifier;", "value", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressSemantics.kt */
public final class ProgressSemanticsKt {
    public static /* synthetic */ Modifier progressSemantics$default(Modifier modifier, float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return progressSemantics(modifier, f, closedFloatingPointRange, i);
    }

    public static final Modifier progressSemantics(Modifier modifier, float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i) {
        return SemanticsModifierKt.semantics(modifier, true, new ProgressSemanticsKt$progressSemantics$1(f, closedFloatingPointRange, i));
    }

    public static final Modifier progressSemantics(Modifier modifier) {
        return SemanticsModifierKt.semantics(modifier, true, ProgressSemanticsKt$progressSemantics$2.INSTANCE);
    }
}
