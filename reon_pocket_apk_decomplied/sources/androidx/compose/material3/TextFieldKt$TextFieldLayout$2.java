package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$TextFieldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ float $animationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $container;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supporting;
    final /* synthetic */ Function2<Composer, Integer, Unit> $textField;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$TextFieldLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z, float f, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$textField = function2;
        this.$label = function22;
        this.$placeholder = function3;
        this.$leading = function23;
        this.$trailing = function24;
        this.$prefix = function25;
        this.$suffix = function26;
        this.$singleLine = z;
        this.$animationProgress = f;
        this.$container = function27;
        this.$supporting = function28;
        this.$paddingValues = paddingValues;
        this.$$changed = i;
        this.$$changed1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextFieldKt.TextFieldLayout(this.$modifier, this.$textField, this.$label, this.$placeholder, this.$leading, this.$trailing, this.$prefix, this.$suffix, this.$singleLine, this.$animationProgress, this.$container, this.$supporting, this.$paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
    }
}
