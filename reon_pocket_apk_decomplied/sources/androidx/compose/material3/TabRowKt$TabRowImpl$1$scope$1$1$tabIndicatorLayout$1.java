package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$TabRowImpl$1$scope$1$1$tabIndicatorLayout$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ Function4<MeasureScope, Measurable, Constraints, List<TabPosition>, MeasureResult> $measure;
    final /* synthetic */ TabRowKt$TabRowImpl$1$scope$1$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$TabRowImpl$1$scope$1$1$tabIndicatorLayout$1(Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super List<TabPosition>, ? extends MeasureResult> function4, TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1) {
        super(3);
        this.$measure = function4;
        this.this$0 = tabRowKt$TabRowImpl$1$scope$1$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m2369invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m6532unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m2369invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return this.$measure.invoke(measureScope, measurable, Constraints.m6514boximpl(j), this.this$0.getTabPositions().getValue());
    }
}
