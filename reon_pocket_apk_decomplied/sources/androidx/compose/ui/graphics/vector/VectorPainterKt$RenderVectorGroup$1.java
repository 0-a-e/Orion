package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainterKt$RenderVectorGroup$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Map<String, VectorConfig> $configs;
    final /* synthetic */ VectorNode $vectorNode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainterKt$RenderVectorGroup$1(VectorNode vectorNode, Map<String, ? extends VectorConfig> map) {
        super(2);
        this.$vectorNode = vectorNode;
        this.$configs = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C510@19038L56:VectorPainter.kt#huu6hf");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1450046638, i, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:510)");
            }
            VectorPainterKt.RenderVectorGroup((VectorGroup) this.$vectorNode, this.$configs, composer, 64, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
