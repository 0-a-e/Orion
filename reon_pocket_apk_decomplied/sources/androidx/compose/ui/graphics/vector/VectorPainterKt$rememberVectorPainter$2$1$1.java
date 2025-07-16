package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainterKt$rememberVectorPainter$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function4<Float, Float, Composer, Integer, Unit> $content;
    final /* synthetic */ long $viewport;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainterKt$rememberVectorPainter$2$1$1(Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, long j) {
        super(2);
        this.$content = function4;
        this.$viewport = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C154@6541L40:VectorPainter.kt#huu6hf");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-824421385, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous>.<anonymous>.<anonymous> (VectorPainter.kt:154)");
            }
            this.$content.invoke(Float.valueOf(Size.m3631getWidthimpl(this.$viewport)), Float.valueOf(Size.m3628getHeightimpl(this.$viewport)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
