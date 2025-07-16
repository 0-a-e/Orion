package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
final class SegmentedButtonDefaults$Icon$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $active;
    final /* synthetic */ Function2<Composer, Integer, Unit> $activeContent;
    final /* synthetic */ Function2<Composer, Integer, Unit> $inactiveContent;
    final /* synthetic */ SegmentedButtonDefaults $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SegmentedButtonDefaults$Icon$3(SegmentedButtonDefaults segmentedButtonDefaults, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, int i2) {
        super(2);
        this.$tmp0_rcvr = segmentedButtonDefaults;
        this.$active = z;
        this.$activeContent = function2;
        this.$inactiveContent = function22;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.Icon(this.$active, this.$activeContent, this.$inactiveContent, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
