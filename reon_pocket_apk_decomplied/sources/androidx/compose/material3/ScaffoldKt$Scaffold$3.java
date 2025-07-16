package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
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
/* compiled from: Scaffold.kt */
final class ScaffoldKt$Scaffold$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$Scaffold$3(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, int i, long j, long j2, WindowInsets windowInsets, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$topBar = function2;
        this.$bottomBar = function22;
        this.$snackbarHost = function23;
        this.$floatingActionButton = function24;
        this.$floatingActionButtonPosition = i;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$contentWindowInsets = windowInsets;
        this.$content = function3;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ScaffoldKt.m2098ScaffoldTvnljyQ(this.$modifier, this.$topBar, this.$bottomBar, this.$snackbarHost, this.$floatingActionButton, this.$floatingActionButtonPosition, this.$containerColor, this.$contentColor, this.$contentWindowInsets, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
