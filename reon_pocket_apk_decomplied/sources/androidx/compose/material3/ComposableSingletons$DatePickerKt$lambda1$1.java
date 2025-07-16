package androidx.compose.material3;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.EditKt;
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
/* renamed from: androidx.compose.material3.ComposableSingletons$DatePickerKt$lambda-1$1  reason: invalid class name */
/* compiled from: DatePicker.kt */
final class ComposableSingletons$DatePickerKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DatePickerKt$lambda1$1 INSTANCE = new ComposableSingletons$DatePickerKt$lambda1$1();

    ComposableSingletons$DatePickerKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1359@60842L46,1357@60750L152:DatePicker.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1244569435, i, -1, "androidx.compose.material3.ComposableSingletons$DatePickerKt.lambda-1.<anonymous> (DatePicker.kt:1357)");
            }
            ImageVector edit = EditKt.getEdit(Icons.Filled.INSTANCE);
            Strings.Companion companion = Strings.Companion;
            IconKt.m1903Iconww6aTOc(edit, Strings_androidKt.m2293getStringNWtq28(Strings.m2224constructorimpl(R.string.m3c_date_picker_switch_to_input_mode), composer, 0), (Modifier) null, 0, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
