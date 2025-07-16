package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TwoRowsTopAppBar$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $actions;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ float $maxHeight;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ float $pinnedHeight;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ Function2<Composer, Integer, Unit> $smallTitle;
    final /* synthetic */ TextStyle $smallTitleTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ float $titleBottomPadding;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$4(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f, Function2<? super Composer, ? super Integer, Unit> function22, TextStyle textStyle2, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, float f2, float f3, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$title = function2;
        this.$titleTextStyle = textStyle;
        this.$titleBottomPadding = f;
        this.$smallTitle = function22;
        this.$smallTitleTextStyle = textStyle2;
        this.$navigationIcon = function23;
        this.$actions = function3;
        this.$windowInsets = windowInsets;
        this.$colors = topAppBarColors;
        this.$maxHeight = f2;
        this.$pinnedHeight = f3;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Modifier modifier = this.$modifier;
        Function2<Composer, Integer, Unit> function2 = this.$title;
        TextStyle textStyle = this.$titleTextStyle;
        float f = this.$titleBottomPadding;
        Function2<Composer, Integer, Unit> function22 = this.$smallTitle;
        TextStyle textStyle2 = this.$smallTitleTextStyle;
        Function2<Composer, Integer, Unit> function23 = this.$navigationIcon;
        Function3<RowScope, Composer, Integer, Unit> function3 = this.$actions;
        WindowInsets windowInsets = this.$windowInsets;
        TopAppBarColors topAppBarColors = this.$colors;
        float f2 = this.$maxHeight;
        float f3 = this.$pinnedHeight;
        TopAppBarScrollBehavior topAppBarScrollBehavior = this.$scrollBehavior;
        Modifier modifier2 = modifier;
        AppBarKt.m1516TwoRowsTopAppBartjU4iQQ(modifier2, function2, textStyle, f, function22, textStyle2, function23, function3, windowInsets, topAppBarColors, f2, f3, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
