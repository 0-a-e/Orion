package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0017J\f\u0010\u000e\u001a\u00020\u0004*\u00020\u0004H\u0017J\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/RowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "weight", "", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Row.kt */
public final class RowScopeInstance implements RowScope {
    public static final int $stable = 0;
    public static final RowScopeInstance INSTANCE = new RowScopeInstance();

    private RowScopeInstance() {
    }

    public Modifier weight(Modifier modifier, float f, boolean z) {
        if (((double) f) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return modifier.then(new LayoutWeightElement(RangesKt.coerceAtMost(f, Float.MAX_VALUE), z));
        }
        throw new IllegalArgumentException(("invalid weight " + f + "; must be greater than zero").toString());
    }

    public Modifier align(Modifier modifier, Alignment.Vertical vertical) {
        return modifier.then(new VerticalAlignElement(vertical));
    }

    public Modifier alignBy(Modifier modifier, HorizontalAlignmentLine horizontalAlignmentLine) {
        return modifier.then(new WithAlignmentLineElement(horizontalAlignmentLine));
    }

    public Modifier alignByBaseline(Modifier modifier) {
        return alignBy(modifier, AlignmentLineKt.getFirstBaseline());
    }

    public Modifier alignBy(Modifier modifier, Function1<? super Measured, Integer> function1) {
        return modifier.then(new WithAlignmentLineBlockElement(function1));
    }
}
