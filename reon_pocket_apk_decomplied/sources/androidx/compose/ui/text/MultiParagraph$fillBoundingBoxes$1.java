package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "paragraphInfo", "Landroidx/compose/ui/text/ParagraphInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiParagraph.kt */
final class MultiParagraph$fillBoundingBoxes$1 extends Lambda implements Function1<ParagraphInfo, Unit> {
    final /* synthetic */ float[] $array;
    final /* synthetic */ Ref.IntRef $currentArrayStart;
    final /* synthetic */ Ref.FloatRef $currentHeight;
    final /* synthetic */ long $range;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiParagraph$fillBoundingBoxes$1(long j, float[] fArr, Ref.IntRef intRef, Ref.FloatRef floatRef) {
        super(1);
        this.$range = j;
        this.$array = fArr;
        this.$currentArrayStart = intRef;
        this.$currentHeight = floatRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ParagraphInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ParagraphInfo paragraphInfo) {
        long j = this.$range;
        float[] fArr = this.$array;
        Ref.IntRef intRef = this.$currentArrayStart;
        Ref.FloatRef floatRef = this.$currentHeight;
        long TextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(paragraphInfo.getStartIndex() > TextRange.m6040getMinimpl(j) ? paragraphInfo.getStartIndex() : TextRange.m6040getMinimpl(j)), paragraphInfo.toLocalIndex(paragraphInfo.getEndIndex() < TextRange.m6039getMaximpl(j) ? paragraphInfo.getEndIndex() : TextRange.m6039getMaximpl(j)));
        paragraphInfo.getParagraph().m5919fillBoundingBoxes8ffj60Q(TextRange, fArr, intRef.element);
        int r5 = intRef.element + (TextRange.m6038getLengthimpl(TextRange) * 4);
        for (int i = intRef.element; i < r5; i += 4) {
            int i2 = i + 1;
            fArr[i2] = fArr[i2] + floatRef.element;
            int i3 = i + 3;
            fArr[i3] = fArr[i3] + floatRef.element;
        }
        intRef.element = r5;
        floatRef.element += paragraphInfo.getParagraph().getHeight();
    }
}
