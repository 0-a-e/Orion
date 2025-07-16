package androidx.activity.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportDrawn.kt */
final class ReportDrawnComposition$observeReporter$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Boolean> $predicate;
    final /* synthetic */ Ref.BooleanRef $reporterPassed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportDrawnComposition$observeReporter$1(Ref.BooleanRef booleanRef, Function0<Boolean> function0) {
        super(0);
        this.$reporterPassed = booleanRef;
        this.$predicate = function0;
    }

    public final void invoke() {
        this.$reporterPassed.element = this.$predicate.invoke().booleanValue();
    }
}
