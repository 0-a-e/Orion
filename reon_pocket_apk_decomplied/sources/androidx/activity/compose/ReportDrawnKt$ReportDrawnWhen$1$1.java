package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportDrawn.kt */
final class ReportDrawnKt$ReportDrawnWhen$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ FullyDrawnReporter $fullyDrawnReporter;
    final /* synthetic */ Function0<Boolean> $predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawnWhen$1$1(FullyDrawnReporter fullyDrawnReporter, Function0<Boolean> function0) {
        super(1);
        this.$fullyDrawnReporter = fullyDrawnReporter;
        this.$predicate = function0;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        if (this.$fullyDrawnReporter.isFullyDrawnReported()) {
            return new ReportDrawnKt$ReportDrawnWhen$1$1$invoke$$inlined$onDispose$1();
        }
        return new ReportDrawnKt$ReportDrawnWhen$1$1$invoke$$inlined$onDispose$2(new ReportDrawnComposition(this.$fullyDrawnReporter, this.$predicate));
    }
}
