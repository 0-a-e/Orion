package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$YearPickerMenuButton$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $expanded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$YearPickerMenuButton$1(Function2<? super Composer, ? super Integer, Unit> function2, boolean z) {
        super(3);
        this.$content = function2;
        this.$expanded = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        String str;
        ComposerKt.sourceInformation(composer, "C2202@94766L9,2203@94784L49,2204@94842L329:DatePicker.kt#uh7d8r");
        if ((i & 17) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1899012021, i, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:2202)");
            }
            this.$content.invoke(composer, 0);
            SpacerKt.Spacer(SizeKt.m742size3ABfNKs(Modifier.Companion, ButtonDefaults.INSTANCE.m1559getIconSpacingD9Ej5fM()), composer, 6);
            ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
            if (this.$expanded) {
                composer.startReplaceableGroup(1071201785);
                ComposerKt.sourceInformation(composer, "2207@94953L49");
                Strings.Companion companion = Strings.Companion;
                str = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_picker_switch_to_day_selection), composer, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1071201872);
                ComposerKt.sourceInformation(composer, "2209@95040L50");
                Strings.Companion companion2 = Strings.Companion;
                str = Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_picker_switch_to_year_selection), composer, 0);
                composer.endReplaceableGroup();
            }
            IconKt.m1903Iconww6aTOc(arrowDropDown, str, RotateKt.rotate(Modifier.Companion, this.$expanded ? 180.0f : 0.0f), 0, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
