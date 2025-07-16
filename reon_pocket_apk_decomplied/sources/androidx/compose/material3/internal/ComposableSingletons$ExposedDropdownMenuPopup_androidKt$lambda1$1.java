package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopup_androidKt$lambda-1$1  reason: invalid class name */
/* compiled from: ExposedDropdownMenuPopup.android.kt */
final class ComposableSingletons$ExposedDropdownMenuPopup_androidKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ExposedDropdownMenuPopup_androidKt$lambda1$1 INSTANCE = new ComposableSingletons$ExposedDropdownMenuPopup_androidKt$lambda1$1();

    ComposableSingletons$ExposedDropdownMenuPopup_androidKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ExposedDropdownMenuPopup.android.kt#mqatfk");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1952521318, i, -1, "androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopup_androidKt.lambda-1.<anonymous> (ExposedDropdownMenuPopup.android.kt:263)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
