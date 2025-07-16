package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
final class DateRangeInputKt$DateRangeInputContent$2$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $pattern;
    final /* synthetic */ String $startRangeText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangeInputKt$DateRangeInputContent$2$2(String str, String str2) {
        super(2);
        this.$startRangeText = str;
        this.$pattern = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C78@3326L96,77@3255L168:DateRangeInput.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(801434508, i2, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:77)");
            }
            String str = this.$startRangeText;
            Modifier modifier = Modifier.Companion;
            composer2.startReplaceableGroup(-2126787323);
            ComposerKt.sourceInformation(composer2, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean changed = composer2.changed((Object) this.$startRangeText) | composer2.changed((Object) this.$pattern);
            String str2 = this.$startRangeText;
            String str3 = this.$pattern;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateRangeInputKt$DateRangeInputContent$2$2$1$1(str2, str3);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            TextKt.m2456Text4IGK_g(str, SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, (Object) null), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
