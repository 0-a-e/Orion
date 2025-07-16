package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpannableExtensions.android.kt */
final class SpannableExtensions_androidKt$setFontAttributes$1 extends Lambda implements Function3<SpanStyle, Integer, Integer, Unit> {
    final /* synthetic */ Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> $resolveTypeface;
    final /* synthetic */ Spannable $this_setFontAttributes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpannableExtensions_androidKt$setFontAttributes$1(Spannable spannable, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        super(3);
        this.$this_setFontAttributes = spannable;
        this.$resolveTypeface = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SpanStyle) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SpanStyle spanStyle, int i, int i2) {
        Spannable spannable = this.$this_setFontAttributes;
        Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function4 = this.$resolveTypeface;
        FontFamily fontFamily = spanStyle.getFontFamily();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontStyle r5 = spanStyle.m6003getFontStyle4Lr2A7w();
        FontStyle r52 = FontStyle.m6155boximpl(r5 != null ? r5.m6161unboximpl() : FontStyle.Companion.m6165getNormal_LCdwA());
        FontSynthesis r7 = spanStyle.m6004getFontSynthesisZQGJjVo();
        spannable.setSpan(new TypefaceSpan(function4.invoke(fontFamily, fontWeight, r52, FontSynthesis.m6166boximpl(r7 != null ? r7.m6174unboximpl() : FontSynthesis.Companion.m6175getAllGVVA2EU()))), i, i2, 33);
    }
}
