package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportDrawn.kt */
final class ReportDrawnKt$ReportDrawn$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawn$2(int i) {
        super(2);
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ReportDrawnKt.ReportDrawn(composer, this.$$changed | 1);
    }
}
