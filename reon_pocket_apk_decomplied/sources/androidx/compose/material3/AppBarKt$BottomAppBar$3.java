package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
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
/* compiled from: AppBar.kt */
final class AppBarKt$BottomAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $actions;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ BottomAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ float $tonalElevation;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$BottomAppBar$3(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, int i, int i2) {
        super(2);
        this.$actions = function3;
        this.$modifier = modifier;
        this.$floatingActionButton = function2;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$tonalElevation = f;
        this.$contentPadding = paddingValues;
        this.$windowInsets = windowInsets;
        this.$scrollBehavior = bottomAppBarScrollBehavior;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AppBarKt.m1514BottomAppBarqhFBPw4(this.$actions, this.$modifier, this.$floatingActionButton, this.$containerColor, this.$contentColor, this.$tonalElevation, this.$contentPadding, this.$windowInsets, this.$scrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
