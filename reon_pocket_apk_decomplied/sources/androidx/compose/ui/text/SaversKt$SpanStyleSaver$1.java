package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/SpanStyle;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$SpanStyleSaver$1 extends Lambda implements Function2<SaverScope, SpanStyle, Object> {
    public static final SaversKt$SpanStyleSaver$1 INSTANCE = new SaversKt$SpanStyleSaver$1();

    SaversKt$SpanStyleSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope saverScope, SpanStyle spanStyle) {
        SaverScope saverScope2 = saverScope;
        return CollectionsKt.arrayListOf(SaversKt.save(Color.m3806boximpl(spanStyle.m6001getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), saverScope2), SaversKt.save(TextUnit.m6801boximpl(spanStyle.m6002getFontSizeXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope2), SaversKt.save(spanStyle.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), saverScope2), SaversKt.save(spanStyle.m6003getFontStyle4Lr2A7w()), SaversKt.save(spanStyle.m6004getFontSynthesisZQGJjVo()), SaversKt.save(-1), SaversKt.save(spanStyle.getFontFeatureSettings()), SaversKt.save(TextUnit.m6801boximpl(spanStyle.m6005getLetterSpacingXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope2), SaversKt.save(spanStyle.m6000getBaselineShift5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), saverScope2), SaversKt.save(spanStyle.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), saverScope2), SaversKt.save(spanStyle.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), saverScope2), SaversKt.save(Color.m3806boximpl(spanStyle.m5999getBackground0d7_KjU()), SaversKt.getSaver(Color.Companion), saverScope2), SaversKt.save(spanStyle.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), saverScope2), SaversKt.save(spanStyle.getShadow(), SaversKt.getSaver(Shadow.Companion), saverScope2));
    }
}
