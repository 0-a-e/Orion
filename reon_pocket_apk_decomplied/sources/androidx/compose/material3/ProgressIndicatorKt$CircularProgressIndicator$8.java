package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$8 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $progress;
    final /* synthetic */ float $strokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$8(float f, Modifier modifier, long j, float f2, int i, int i2) {
        super(2);
        this.$progress = f;
        this.$modifier = modifier;
        this.$color = j;
        this.$strokeWidth = f2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ProgressIndicatorKt.m2063CircularProgressIndicatorMBs18nI(this.$progress, this.$modifier, this.$color, this.$strokeWidth, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
