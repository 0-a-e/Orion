package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportDrawn.kt */
final class ReportDrawnKt$ReportDrawnAfter$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawnAfter$2(Function1<? super Continuation<? super Unit>, ? extends Object> function1, int i) {
        super(2);
        this.$block = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ReportDrawnKt.ReportDrawnAfter(this.$block, composer, this.$$changed | 1);
    }
}
