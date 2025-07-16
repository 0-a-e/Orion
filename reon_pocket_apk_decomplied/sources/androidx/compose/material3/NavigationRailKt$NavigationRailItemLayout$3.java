package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRailItemLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ Function0<Float> $animationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $indicatorRipple;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRailItemLayout$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, Function0<Float> function0, int i) {
        super(2);
        this.$indicatorRipple = function2;
        this.$indicator = function22;
        this.$icon = function23;
        this.$label = function24;
        this.$alwaysShowLabel = z;
        this.$animationProgress = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationRailKt.NavigationRailItemLayout(this.$indicatorRipple, this.$indicator, this.$icon, this.$label, this.$alwaysShowLabel, this.$animationProgress, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
