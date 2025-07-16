package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$ScaffoldLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayout$1(int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, int i2) {
        super(2);
        this.$fabPosition = i;
        this.$topBar = function2;
        this.$content = function3;
        this.$snackbar = function22;
        this.$fab = function23;
        this.$contentWindowInsets = windowInsets;
        this.$bottomBar = function24;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ScaffoldKt.m2099ScaffoldLayoutFMILGgc(this.$fabPosition, this.$topBar, this.$content, this.$snackbar, this.$fab, this.$contentWindowInsets, this.$bottomBar, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
