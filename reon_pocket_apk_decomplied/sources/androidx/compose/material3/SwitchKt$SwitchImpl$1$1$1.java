package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/Density;", "invoke-Bjo55l4", "(Landroidx/compose/ui/unit/Density;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$SwitchImpl$1$1$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ float $thumbOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$SwitchImpl$1$1$1(float f) {
        super(1);
        this.$thumbOffset = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m6739boximpl(m2339invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m2339invokeBjo55l4(Density density) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(this.$thumbOffset), 0);
    }
}
