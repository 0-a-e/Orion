package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoxWithConstraints.kt */
final class BoxWithConstraintsKt$BoxWithConstraints$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ Function3<BoxWithConstraintsScope, Composer, Integer, Unit> $content;
    final /* synthetic */ MeasurePolicy $measurePolicy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxWithConstraintsKt$BoxWithConstraints$1$1(MeasurePolicy measurePolicy, Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$measurePolicy = measurePolicy;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m586invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m586invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        return this.$measurePolicy.m5369measure3p2s80s(subcomposeMeasureScope, subcomposeMeasureScope.subcompose(Unit.INSTANCE, ComposableLambdaKt.composableLambdaInstance(-1945019079, true, new BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(this.$content, new BoxWithConstraintsScopeImpl(subcomposeMeasureScope, j, (DefaultConstructorMarker) null)))), j);
    }
}
