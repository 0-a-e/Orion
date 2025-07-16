package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "paragraphInfo", "Landroidx/compose/ui/text/ParagraphInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiParagraph.kt */
final class MultiParagraph$getPathForRange$2 extends Lambda implements Function1<ParagraphInfo, Unit> {
    final /* synthetic */ int $end;
    final /* synthetic */ Path $path;
    final /* synthetic */ int $start;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiParagraph$getPathForRange$2(Path path, int i, int i2) {
        super(1);
        this.$path = path;
        this.$start = i;
        this.$end = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ParagraphInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ParagraphInfo paragraphInfo) {
        Path.CC.m4116addPathUv8p0NA$default(this.$path, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(this.$start), paragraphInfo.toLocalIndex(this.$end))), 0, 2, (Object) null);
    }
}
