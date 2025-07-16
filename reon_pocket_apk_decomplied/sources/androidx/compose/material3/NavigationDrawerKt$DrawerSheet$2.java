package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$DrawerSheet$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerContainerColor;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ float $drawerTonalElevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$DrawerSheet$2(WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$modifier = modifier;
        this.$drawerShape = shape;
        this.$drawerContainerColor = j;
        this.$drawerContentColor = j2;
        this.$drawerTonalElevation = f;
        this.$content = function3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavigationDrawerKt.m2010DrawerSheetvywBR7E(this.$windowInsets, this.$modifier, this.$drawerShape, this.$drawerContainerColor, this.$drawerContentColor, this.$drawerTonalElevation, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
