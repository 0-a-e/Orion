package androidx.compose.material3;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeftKt;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-3$1  reason: invalid class name */
/* compiled from: DatePicker.kt */
final class ComposableSingletons$DatePickerKt$lambda3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DatePickerKt$lambda3$1 INSTANCE = new ComposableSingletons$DatePickerKt$lambda3$1();

    ComposableSingletons$DatePickerKt$lambda3$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2171@93794L50,2169@93666L204:DatePicker.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1233169686, i, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-3.<anonymous> (DatePicker.kt:2169)");
            }
            ImageVector keyboardArrowLeft = KeyboardArrowLeftKt.getKeyboardArrowLeft(Icons.AutoMirrored.Filled.INSTANCE);
            Strings.Companion companion = Strings.Companion;
            IconKt.m1903Iconww6aTOc(keyboardArrowLeft, Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_picker_switch_to_previous_month), composer, 0), (Modifier) null, 0, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
