package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ MutableIntState $anchorWidth$delegate;
    final /* synthetic */ boolean $matchTextFieldWidth;
    final /* synthetic */ MutableIntState $menuMaxHeight$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1(boolean z, MutableIntState mutableIntState, MutableIntState mutableIntState2) {
        super(3);
        this.$matchTextFieldWidth = z;
        this.$anchorWidth$delegate = mutableIntState;
        this.$menuMaxHeight$delegate = mutableIntState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m1853invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m6532unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m1853invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int r0 = ConstraintsKt.m6540constrainWidthK40F9xA(j, ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(this.$anchorWidth$delegate));
        int r7 = ConstraintsKt.m6539constrainHeightK40F9xA(j, ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(this.$menuMaxHeight$delegate));
        int r4 = this.$matchTextFieldWidth ? r0 : Constraints.m6528getMinWidthimpl(j);
        if (!this.$matchTextFieldWidth) {
            r0 = Constraints.m6526getMaxWidthimpl(j);
        }
        final Placeable r12 = measurable.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, r4, r0, 0, r7, 4, (Object) null));
        return MeasureScope.CC.layout$default(measureScope, r12.getWidth(), r12.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, r12, 0, 0, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
