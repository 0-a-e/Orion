package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.material3.ComposableSingletons$TabRowKt$lambda-4$1  reason: invalid class name */
/* compiled from: TabRow.kt */
final class ComposableSingletons$TabRowKt$lambda4$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$TabRowKt$lambda4$1 INSTANCE = new ComposableSingletons$TabRowKt$lambda4$1();

    ComposableSingletons$TabRowKt$lambda4$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C691@30128L19:TabRow.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-764008582, i, -1, "androidx.compose.material3.ComposableSingletons$TabRowKt.lambda-4.<anonymous> (TabRow.kt:691)");
            }
            DividerKt.m1817HorizontalDivider9IZ8Weo((Modifier) null, 0.0f, 0, composer, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
