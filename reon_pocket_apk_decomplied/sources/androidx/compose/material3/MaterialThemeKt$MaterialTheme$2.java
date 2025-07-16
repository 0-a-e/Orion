package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
final class MaterialThemeKt$MaterialTheme$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ColorScheme $colorScheme;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Shapes $shapes;
    final /* synthetic */ Typography $typography;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaterialThemeKt$MaterialTheme$2(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$colorScheme = colorScheme;
        this.$shapes = shapes;
        this.$typography = typography;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        MaterialThemeKt.MaterialTheme(this.$colorScheme, this.$shapes, this.$typography, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
