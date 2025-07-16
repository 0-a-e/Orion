package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "x", "invoke", "(D)Ljava/lang/Double;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Rgb.kt */
final class Rgb$eotf$1 extends Lambda implements Function1<Double, Double> {
    final /* synthetic */ Rgb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Rgb$eotf$1(Rgb rgb) {
        super(1);
        this.this$0 = rgb;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }

    public final Double invoke(double d) {
        return Double.valueOf(this.this$0.getEotfOrig$ui_graphics_release().invoke(RangesKt.coerceIn(d, (double) this.this$0.min, (double) this.this$0.max)));
    }
}
