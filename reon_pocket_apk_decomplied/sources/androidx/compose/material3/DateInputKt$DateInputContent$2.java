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
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $labelText;
    final /* synthetic */ String $pattern;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputContent$2(String str, String str2) {
        super(2);
        this.$labelText = str;
        this.$pattern = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C86@3631L47,84@3552L127:DateInput.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1819015125, i2, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:84)");
            }
            String str = this.$labelText;
            Modifier modifier = Modifier.Companion;
            composer2.startReplaceableGroup(-694340528);
            ComposerKt.sourceInformation(composer2, "CC(remember):DateInput.kt#9igjgp");
            boolean changed = composer2.changed((Object) this.$labelText) | composer2.changed((Object) this.$pattern);
            String str2 = this.$labelText;
            String str3 = this.$pattern;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateInputKt$DateInputContent$2$1$1(str2, str3);
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
