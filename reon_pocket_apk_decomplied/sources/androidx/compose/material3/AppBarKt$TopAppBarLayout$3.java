package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TopAppBarLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ long $actionIconContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $actions;
    final /* synthetic */ float $heightPx;
    final /* synthetic */ boolean $hideTitleSemantics;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ long $navigationIconContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ float $titleAlpha;
    final /* synthetic */ int $titleBottomPadding;
    final /* synthetic */ long $titleContentColor;
    final /* synthetic */ Arrangement.Horizontal $titleHorizontalArrangement;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ Arrangement.Vertical $titleVerticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TopAppBarLayout$3(Modifier modifier, float f, long j, long j2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$heightPx = f;
        this.$navigationIconContentColor = j;
        this.$titleContentColor = j2;
        this.$actionIconContentColor = j3;
        this.$title = function2;
        this.$titleTextStyle = textStyle;
        this.$titleAlpha = f2;
        this.$titleVerticalArrangement = vertical;
        this.$titleHorizontalArrangement = horizontal;
        this.$titleBottomPadding = i;
        this.$hideTitleSemantics = z;
        this.$navigationIcon = function22;
        this.$actions = function23;
        this.$$changed = i2;
        this.$$changed1 = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Modifier modifier = this.$modifier;
        Modifier modifier2 = modifier;
        AppBarKt.m1515TopAppBarLayoutkXwM9vE(modifier2, this.$heightPx, this.$navigationIconContentColor, this.$titleContentColor, this.$actionIconContentColor, this.$title, this.$titleTextStyle, this.$titleAlpha, this.$titleVerticalArrangement, this.$titleHorizontalArrangement, this.$titleBottomPadding, this.$hideTitleSemantics, this.$navigationIcon, this.$actions, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
    }
}
