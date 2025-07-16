package androidx.compose.material3;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ List<CustomAccessibilityAction> $customAccessibilityAction;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ CalendarMonth $month;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1(DatePickerFormatter datePickerFormatter, CalendarMonth calendarMonth, List<CustomAccessibilityAction> list, DatePickerColors datePickerColors) {
        super(2);
        this.$dateFormatter = datePickerFormatter;
        this.$month = calendarMonth;
        this.$customAccessibilityAction = list;
        this.$colors = datePickerColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        int i2 = i;
        ComposerKt.sourceInformation(composer2, "C828@35250L15,833@35577L113,825@35088L692:DateRangePicker.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1622100276, i2, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:825)");
            }
            String formatMonthYear = this.$dateFormatter.formatMonthYear(Long.valueOf(this.$month.getStartUtcTimeMillis()), ActualAndroid_androidKt.defaultLocale(composer2, 0));
            if (formatMonthYear == null) {
                formatMonthYear = "-";
            }
            String str = formatMonthYear;
            Modifier r2 = ClickableKt.m248clickableXHw0xAI$default(PaddingKt.padding(Modifier.Companion, DateRangePickerKt.getCalendarMonthSubheadPadding()), false, (String) null, (Role) null, AnonymousClass1.INSTANCE, 7, (Object) null);
            composer2.startReplaceableGroup(413139989);
            ComposerKt.sourceInformation(composer2, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changedInstance = composer2.changedInstance(this.$customAccessibilityAction);
            List<CustomAccessibilityAction> list = this.$customAccessibilityAction;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1$2$1(list);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            TextKt.m2456Text4IGK_g(str, SemanticsModifierKt.semantics$default(r2, false, (Function1) rememberedValue, 1, (Object) null), this.$colors.m1756getSubheadContentColor0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
