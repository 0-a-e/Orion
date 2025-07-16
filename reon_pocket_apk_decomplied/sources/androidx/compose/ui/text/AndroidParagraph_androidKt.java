package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\n\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph_androidKt {
    /* access modifiers changed from: private */
    /* renamed from: toLayoutAlign-aXe7zB0  reason: not valid java name */
    public static final int m5894toLayoutAlignaXe7zB0(int i) {
        if (TextAlign.m6456equalsimpl0(i, TextAlign.Companion.m6463getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m6456equalsimpl0(i, TextAlign.Companion.m6464getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m6456equalsimpl0(i, TextAlign.Companion.m6460getCentere0LSkKk())) {
            return 2;
        }
        if (!TextAlign.m6456equalsimpl0(i, TextAlign.Companion.m6465getStarte0LSkKk()) && TextAlign.m6456equalsimpl0(i, TextAlign.Companion.m6461getEnde0LSkKk())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency--3fSNIE  reason: not valid java name */
    public static final int m5896toLayoutHyphenationFrequency3fSNIE(int i) {
        if (Hyphens.m6366equalsimpl0(i, Hyphens.Companion.m6370getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m6366equalsimpl0(i, Hyphens.Companion.m6371getNonevmbZdU8());
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-xImikfE  reason: not valid java name */
    public static final int m5895toLayoutBreakStrategyxImikfE(int i) {
        if (LineBreak.Strategy.m6397equalsimpl0(i, LineBreak.Strategy.Companion.m6403getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m6397equalsimpl0(i, LineBreak.Strategy.Companion.m6402getHighQualityfcGXIks())) {
            return 1;
        }
        if (LineBreak.Strategy.m6397equalsimpl0(i, LineBreak.Strategy.Companion.m6401getBalancedfcGXIks())) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-hpcqdu8  reason: not valid java name */
    public static final int m5897toLayoutLineBreakStylehpcqdu8(int i) {
        if (LineBreak.Strictness.m6408equalsimpl0(i, LineBreak.Strictness.Companion.m6412getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m6408equalsimpl0(i, LineBreak.Strictness.Companion.m6413getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m6408equalsimpl0(i, LineBreak.Strictness.Companion.m6414getNormalusljTpc())) {
            return 2;
        }
        if (LineBreak.Strictness.m6408equalsimpl0(i, LineBreak.Strictness.Companion.m6415getStrictusljTpc())) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-wPN0Rpw  reason: not valid java name */
    public static final int m5898toLayoutLineBreakWordStylewPN0Rpw(int i) {
        if (!LineBreak.WordBreak.m6420equalsimpl0(i, LineBreak.WordBreak.Companion.m6424getDefaultjp8hJ3c()) && LineBreak.WordBreak.m6420equalsimpl0(i, LineBreak.WordBreak.Companion.m6425getPhrasejp8hJ3c())) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > ((float) i)) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m6808equalsimpl0(textStyle.m6078getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m6808equalsimpl0(textStyle.m6078getLetterSpacingXSAIIZE(), TextUnit.Companion.m6822getUnspecifiedXSAIIZE()) || TextAlign.m6456equalsimpl0(textStyle.m6083getTextAligne0LSkKk(), TextAlign.Companion.m6466getUnspecifiede0LSkKk()) || TextAlign.m6456equalsimpl0(textStyle.m6083getTextAligne0LSkKk(), TextAlign.Companion.m6465getStarte0LSkKk()) || TextAlign.m6456equalsimpl0(textStyle.m6083getTextAligne0LSkKk(), TextAlign.Companion.m6462getJustifye0LSkKk())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }
}
