package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRail$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $header;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRail$2(Modifier modifier, long j, long j2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$header = function3;
        this.$windowInsets = windowInsets;
        this.$content = function32;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationRailKt.m2032NavigationRailqi6gXK8(this.$modifier, this.$containerColor, this.$contentColor, this.$header, this.$windowInsets, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
