package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a$\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAccessibilitySpannableString.android.kt */
public final class AndroidAccessibilitySpannableString_androidKt {
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString annotatedString, Density density, FontFamily.Resolver resolver, URLSpanCache uRLSpanCache) {
        AnnotatedString annotatedString2 = annotatedString;
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range range = spanStylesOrNull$ui_text_release.get(i);
                setSpanStyle(spannableString, SpanStyle.m5992copyGSF8kmg$default((SpanStyle) range.component1(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65503, (Object) null), range.component2(), range.component3(), density, resolver);
            }
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString2.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AnnotatedString.Range range2 = ttsAnnotations.get(i2);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan((TtsAnnotation) range2.component1()), range2.component2(), range2.component3(), 33);
        }
        List<AnnotatedString.Range<UrlAnnotation>> urlAnnotations = annotatedString2.getUrlAnnotations(0, annotatedString.length());
        int size3 = urlAnnotations.size();
        for (int i3 = 0; i3 < size3; i3++) {
            AnnotatedString.Range range3 = urlAnnotations.get(i3);
            spannableString.setSpan(uRLSpanCache.toURLSpan((UrlAnnotation) range3.component1()), range3.component2(), range3.component3(), 33);
        }
        return spannableString;
    }

    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i, int i2, Density density, FontFamily.Resolver resolver) {
        SpannableString spannableString2 = spannableString;
        int i3 = i;
        int i4 = i2;
        Spannable spannable = spannableString2;
        SpannableExtensions_androidKt.m6334setColorRPmYEkk(spannable, spanStyle.m6001getColor0d7_KjU(), i3, i4);
        SpannableExtensions_androidKt.m6335setFontSizeKmRG4DE(spannable, spanStyle.m6002getFontSizeXSAIIZE(), density, i, i2);
        if (!(spanStyle.getFontWeight() == null && spanStyle.m6003getFontStyle4Lr2A7w() == null)) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r3 = spanStyle.m6003getFontStyle4Lr2A7w();
            spannableString2.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m6107getAndroidTypefaceStyleFO1MlWM(fontWeight, r3 != null ? r3.m6161unboximpl() : FontStyle.Companion.m6165getNormal_LCdwA())), i3, i4, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString2.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i3, i4, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis r1 = spanStyle.m6004getFontSynthesisZQGJjVo();
                Object value = FontFamily.Resolver.CC.m6132resolveDPcqOEQ$default(resolver, fontFamily, (FontWeight) null, 0, r1 != null ? r1.m6174unboximpl() : FontSynthesis.Companion.m6175getAllGVVA2EU(), 6, (Object) null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString2.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), i3, i4, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getUnderline())) {
                spannableString2.setSpan(new UnderlineSpan(), i3, i4, 33);
            }
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getLineThrough())) {
                spannableString2.setSpan(new StrikethroughSpan(), i3, i4, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString2.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i3, i4, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannable, spanStyle.getLocaleList(), i3, i4);
        SpannableExtensions_androidKt.m6332setBackgroundRPmYEkk(spannable, spanStyle.m5999getBackground0d7_KjU(), i3, i4);
    }
}
