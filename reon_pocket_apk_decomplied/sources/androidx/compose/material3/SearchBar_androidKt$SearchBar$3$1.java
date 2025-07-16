package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBar$3$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ State<Float> $animationProgress;
    final /* synthetic */ State<Dp> $topPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBar$3$1(State<Dp> state, State<Float> state2) {
        super(3);
        this.$topPadding = state;
        this.$animationProgress = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m2118invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m6532unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m2118invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final int r2 = measureScope.m6545roundToPx0680j_4(DpKt.m6657lerpMdfbLM(this.$topPadding.getValue().m6628unboximpl(), Dp.m6614constructorimpl((float) 0), this.$animationProgress.getValue().floatValue()));
        int coerceAtMost = RangesKt.coerceAtMost(Math.max(Constraints.m6528getMinWidthimpl(j), measureScope.m6545roundToPx0680j_4(SearchBar_androidKt.getSearchBarMinWidth())), Math.min(Constraints.m6526getMaxWidthimpl(j), measureScope.m6545roundToPx0680j_4(SearchBar_androidKt.SearchBarMaxWidth)));
        int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.m6527getMinHeightimpl(j), measureScope.m6545roundToPx0680j_4(SearchBarDefaults.INSTANCE.m2111getInputFieldHeightD9Ej5fM())), Constraints.m6525getMaxHeightimpl(j));
        int r5 = Constraints.m6526getMaxWidthimpl(j);
        int r6 = Constraints.m6525getMaxHeightimpl(j);
        int lerp = MathHelpersKt.lerp(coerceAtMost, r5, this.$animationProgress.getValue().floatValue());
        int lerp2 = MathHelpersKt.lerp(coerceAtMost2, r6, this.$animationProgress.getValue().floatValue()) + r2;
        Measurable measurable2 = measurable;
        final Placeable r52 = measurable.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(Constraints.Companion.m6534fixedJhjzzOo(lerp, lerp2), 0, -r2, 1, (Object) null));
        return MeasureScope.CC.layout$default(measureScope, lerp, lerp2, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, r52, 0, r2, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
