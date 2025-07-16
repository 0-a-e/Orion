package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
final class SegmentedButtonKt$SegmentedButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $checked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SegmentedButtonKt$SegmentedButton$2(boolean z) {
        super(2);
        this.$checked = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C139@7061L13:SegmentedButton.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(970447394, i, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:139)");
            }
            SegmentedButtonDefaults.INSTANCE.Icon(this.$checked, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
