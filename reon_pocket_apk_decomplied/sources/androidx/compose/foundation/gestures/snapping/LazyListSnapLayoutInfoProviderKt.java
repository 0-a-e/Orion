package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0010\u0013\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0014"}, d2 = {"singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "positionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "calculateFinalSnappingItem", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "Landroidx/compose/ui/unit/Density;", "velocity", "", "(Landroidx/compose/ui/unit/Density;F)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListSnapLayoutInfoProvider.kt */
public final class LazyListSnapLayoutInfoProviderKt {
    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyListState lazyListState, SnapPositionInLayout snapPositionInLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            snapPositionInLayout = SnapPositionInLayout.Companion.getCenterToCenter();
        }
        return SnapLayoutInfoProvider(lazyListState, snapPositionInLayout);
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(LazyListState lazyListState, SnapPositionInLayout snapPositionInLayout) {
        return new LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(lazyListState, snapPositionInLayout);
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyListState lazyListState, Composer composer, int i) {
        composer.startReplaceableGroup(1148456277);
        ComposerKt.sourceInformation(composer, "C(rememberSnapFlingBehavior)126@5074L65,127@5151L41:LazyListSnapLayoutInfoProvider.kt#ppz6w6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1148456277, i, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:125)");
        }
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) lazyListState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapLayoutInfoProvider$default(lazyListState, (SnapPositionInLayout) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SnapFlingBehavior rememberSnapFlingBehavior = SnapFlingBehaviorKt.rememberSnapFlingBehavior((SnapLayoutInfoProvider) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberSnapFlingBehavior;
    }

    public static final int getSingleAxisViewportSize(LazyListLayoutInfo lazyListLayoutInfo) {
        return lazyListLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m6789getHeightimpl(lazyListLayoutInfo.m806getViewportSizeYbymL2g()) : IntSize.m6790getWidthimpl(lazyListLayoutInfo.m806getViewportSizeYbymL2g());
    }

    public static final int calculateFinalSnappingItem(Density density, float f) {
        if (Math.abs(f) < density.m6550toPx0680j_4(SnapFlingBehaviorKt.getMinFlingVelocityDp())) {
            return FinalSnappingItem.Companion.m498getClosestItembbeMdSM();
        }
        return f > 0.0f ? FinalSnappingItem.Companion.m499getNextItembbeMdSM() : FinalSnappingItem.Companion.m500getPreviousItembbeMdSM();
    }
}
