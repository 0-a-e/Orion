package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/material3/SliderRange;", "invoke-If1S1O4", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$10$1 extends Lambda implements Function1<SliderRange, Unit> {
    final /* synthetic */ Function1<ClosedFloatingPointRange<Float>, Unit> $onValueChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$10$1(Function1<? super ClosedFloatingPointRange<Float>, Unit> function1) {
        super(1);
        this.$onValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2199invokeIf1S1O4(((SliderRange) obj).m2212unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-If1S1O4  reason: not valid java name */
    public final void m2199invokeIf1S1O4(long j) {
        this.$onValueChange.invoke(RangesKt.rangeTo(SliderRange.m2209getStartimpl(j), SliderRange.m2208getEndInclusiveimpl(j)));
    }
}
