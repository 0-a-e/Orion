package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$PrimaryTabRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<TabIndicatorScope, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$PrimaryTabRow$2(int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i2, int i3) {
        super(2);
        this.$selectedTabIndex = i;
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$indicator = function3;
        this.$divider = function2;
        this.$tabs = function22;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TabRowKt.m2356PrimaryTabRowpAZo6Ak(this.$selectedTabIndex, this.$modifier, this.$containerColor, this.$contentColor, this.$indicator, this.$divider, this.$tabs, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
