package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainterKt$RenderVectorGroup$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Map<String, VectorConfig> $configs;
    final /* synthetic */ VectorGroup $group;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainterKt$RenderVectorGroup$2(VectorGroup vectorGroup, Map<String, ? extends VectorConfig> map, int i, int i2) {
        super(2);
        this.$group = vectorGroup;
        this.$configs = map;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        VectorPainterKt.RenderVectorGroup(this.$group, this.$configs, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
