package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.android.kt */
final class AndroidOverscroll_androidKt$StretchOverscrollNonClippingLayer$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    public static final AndroidOverscroll_androidKt$StretchOverscrollNonClippingLayer$1 INSTANCE = new AndroidOverscroll_androidKt$StretchOverscrollNonClippingLayer$1();

    AndroidOverscroll_androidKt$StretchOverscrollNonClippingLayer$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m211invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m6532unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m211invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable r10 = measurable.m5368measureBRTryo0(j);
        final int r11 = measureScope.m6545roundToPx0680j_4(Dp.m6614constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * ((float) 2)));
        return MeasureScope.CC.layout$default(measureScope, RangesKt.coerceAtLeast(r10.getMeasuredWidth() - r11, 0), RangesKt.coerceAtLeast(r10.getMeasuredHeight() - r11, 0), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable placeable = r10;
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, ((-r11) / 2) - ((placeable.getWidth() - r10.getMeasuredWidth()) / 2), ((-r11) / 2) - ((r10.getHeight() - r10.getMeasuredHeight()) / 2), 0.0f, (Function1) null, 12, (Object) null);
            }
        }, 4, (Object) null);
    }
}
