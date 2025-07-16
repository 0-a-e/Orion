package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "T", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ Transition<T> $transition;
    final /* synthetic */ Function1<T, Boolean> $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1(Function1<? super T, Boolean> function1, Transition<T> transition) {
        super(3);
        this.$visible = function1;
        this.$transition = transition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m68invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m6532unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m68invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2;
        final Placeable r9 = measurable.m5368measureBRTryo0(j);
        if (!measureScope.isLookingAhead() || this.$visible.invoke(this.$transition.getTargetState()).booleanValue()) {
            j2 = IntSizeKt.IntSize(r9.getWidth(), r9.getHeight());
        } else {
            j2 = IntSize.Companion.m6795getZeroYbymL2g();
        }
        return MeasureScope.CC.layout$default(measureScope, IntSize.m6790getWidthimpl(j2), IntSize.m6789getHeightimpl(j2), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, r9, 0, 0, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
