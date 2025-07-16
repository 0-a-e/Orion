package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aF\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00112\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\u0014H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0002\u001a*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\f\u0010\u001d\u001a\u00020\u0001*\u00020\u001eH\u0002\u001a\u0016\u0010\u001f\u001a\u00020\u0002*\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0002H\u0002\u001a.\u0010!\u001a\u00020\u000e*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020\u000e*\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0002\b,\u001a.\u0010-\u001a\u00020\u000e*\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a.\u00101\u001a\u00020\u000e*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b2\u0010(\u001a&\u00103\u001a\u00020\u000e*\u00020\"2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001aP\u00106\u001a\u00020\u000e*\u00020\"2\u0006\u00107\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00112&\u00108\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>09H\u0002\u001a&\u0010?\u001a\u00020\u000e*\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a6\u0010B\u001a\u00020\u000e*\u00020\"2\u0006\u0010C\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a&\u0010F\u001a\u00020\u000e*\u00020\"2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a.\u0010I\u001a\u00020\u000e*\u00020\"2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a6\u0010I\u001a\u00020\u000e*\u00020\"2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010L\u001a\u00020MH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a&\u0010P\u001a\u00020\u000e*\u00020\"2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a&\u0010S\u001a\u00020\u000e*\u00020\"2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002\u001a$\u0010V\u001a\u00020\u000e*\u00020\"2\u0006\u0010W\u001a\u00020X2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a\"\u0010Y\u001a\u00020\u000e*\u00020\"2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002\u001aX\u0010[\u001a\u00020\u000e*\u00020\"2\u0006\u00107\u001a\u00020\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\n2&\u00108\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>09H\u0000\u001a&\u0010\\\u001a\u00020\u000e*\u00020\"2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a&\u0010_\u001a\u00020\u000e*\u00020\"2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006b"}, d2 = {"needsLetterSpacingSpan", "", "Landroidx/compose/ui/text/SpanStyle;", "getNeedsLetterSpacingSpan", "(Landroidx/compose/ui/text/SpanStyle;)Z", "createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", "", "contextFontSpanStyle", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", "", "isNonLinearFontScalingActive", "resolveLineHeightInPx", "", "lineHeight", "contextFontSize", "resolveLineHeightInPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "hasFontAttributes", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "setColor", "setColor-RPmYEkk", "setDrawStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setFontAttributes", "contextTextStyle", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", "", "setSpanStyle", "spanStyleRange", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpannableExtensions.android.kt */
public final class SpannableExtensions_androidKt {
    public static final void setSpan(Spannable spannable, Object obj, int i, int i2) {
        spannable.setSpan(obj, i, i2, 33);
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f, Density density) {
        float f2;
        if (textIndent == null) {
            return;
        }
        if ((!TextUnit.m6808equalsimpl0(textIndent.m6486getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) || !TextUnit.m6808equalsimpl0(textIndent.m6487getRestLineXSAIIZE(), TextUnitKt.getSp(0))) && !TextUnitKt.m6829isUnspecifiedR2X_6o(textIndent.m6486getFirstLineXSAIIZE()) && !TextUnitKt.m6829isUnspecifiedR2X_6o(textIndent.m6487getRestLineXSAIIZE())) {
            long r0 = TextUnit.m6810getTypeUIouoOA(textIndent.m6486getFirstLineXSAIIZE());
            float f3 = 0.0f;
            if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6844getSpUIouoOA())) {
                f2 = density.m6549toPxR2X_6o(textIndent.m6486getFirstLineXSAIIZE());
            } else {
                f2 = TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6843getEmUIouoOA()) ? TextUnit.m6811getValueimpl(textIndent.m6486getFirstLineXSAIIZE()) * f : 0.0f;
            }
            long r5 = TextUnit.m6810getTypeUIouoOA(textIndent.m6487getRestLineXSAIIZE());
            if (TextUnitType.m6839equalsimpl0(r5, TextUnitType.Companion.m6844getSpUIouoOA())) {
                f3 = density.m6549toPxR2X_6o(textIndent.m6487getRestLineXSAIIZE());
            } else if (TextUnitType.m6839equalsimpl0(r5, TextUnitType.Companion.m6843getEmUIouoOA())) {
                f3 = TextUnit.m6811getValueimpl(textIndent.m6487getRestLineXSAIIZE()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) ((float) Math.ceil((double) f2)), (int) ((float) Math.ceil((double) f3))), 0, spannable.length());
        }
    }

    /* renamed from: setLineHeight-KmRG4DE  reason: not valid java name */
    public static final void m6336setLineHeightKmRG4DE(Spannable spannable, long j, float f, Density density, LineHeightStyle lineHeightStyle) {
        float r1 = m6331resolveLineHeightInPxo2QH7mI(j, f, density);
        if (!Float.isNaN(r1)) {
            CharSequence charSequence = spannable;
            setSpan(spannable, new LineHeightStyleSpan(r1, 0, (charSequence.length() == 0 || StringsKt.last(charSequence) == 10) ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m6445isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m6428getTrimEVpEnUU()), LineHeightStyle.Trim.m6446isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m6428getTrimEVpEnUU()), lineHeightStyle.m6427getAlignmentPIaL0Z0()), 0, spannable.length());
        }
    }

    /* renamed from: setLineHeight-r9BaKPg  reason: not valid java name */
    public static final void m6337setLineHeightr9BaKPg(Spannable spannable, long j, float f, Density density) {
        float r1 = m6331resolveLineHeightInPxo2QH7mI(j, f, density);
        if (!Float.isNaN(r1)) {
            setSpan(spannable, new LineHeightSpan(r1), 0, spannable.length());
        }
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI  reason: not valid java name */
    private static final float m6331resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        float f2;
        long r0 = TextUnit.m6810getTypeUIouoOA(j);
        if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6844getSpUIouoOA())) {
            if (!isNonLinearFontScalingActive(density)) {
                return density.m6549toPxR2X_6o(j);
            }
            f2 = TextUnit.m6811getValueimpl(j) / TextUnit.m6811getValueimpl(density.m6552toSpkPz2Gy4(f));
        } else if (!TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6843getEmUIouoOA())) {
            return Float.NaN;
        } else {
            f2 = TextUnit.m6811getValueimpl(j);
        }
        return f2 * f;
    }

    private static final boolean isNonLinearFontScalingActive(Density density) {
        return ((double) density.getFontScale()) > 1.05d;
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        MetricAffectingSpan r0;
        setFontAttributes(spannable, textStyle, list, function4);
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range range = list.get(i);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density);
                if (getNeedsLetterSpacingSpan((SpanStyle) range.getItem())) {
                    z = true;
                }
            }
        }
        if (z) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range range2 = list.get(i2);
                int start2 = range2.getStart();
                int end2 = range2.getEnd();
                SpanStyle spanStyle = (SpanStyle) range2.getItem();
                if (start2 >= 0 && start2 < spannable.length() && end2 > start2 && end2 <= spannable.length() && (r0 = m6330createLetterSpacingSpaneAf_CNQ(spanStyle.m6005getLetterSpacingXSAIIZE(), density)) != null) {
                    setSpan(spannable, r0, start2, end2);
                }
            }
        }
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m6333setBaselineShift0ocSgnM(spannable, item.m6000getBaselineShift5SSeXJ0(), start, end);
        m6334setColorRPmYEkk(spannable, item.m6001getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m6335setFontSizeKmRG4DE(spannable, item.m6002getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m6332setBackgroundRPmYEkk(spannable, item.m5999getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        setDrawStyle(spannable, item.getDrawStyle(), start, end);
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List<AnnotatedString.Range<SpanStyle>> list, Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        if (list.size() > 1) {
            int size = list.size();
            int i = size * 2;
            Integer[] numArr = new Integer[i];
            for (int i2 = 0; i2 < i; i2++) {
                numArr[i2] = 0;
            }
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AnnotatedString.Range range = list.get(i3);
                numArr[i3] = Integer.valueOf(range.getStart());
                numArr[i3 + size] = Integer.valueOf(range.getEnd());
            }
            ArraysKt.sort((T[]) (Comparable[]) numArr);
            int intValue = ((Number) ArraysKt.first((T[]) numArr)).intValue();
            for (int i4 = 0; i4 < i; i4++) {
                Integer num = numArr[i4];
                int intValue2 = num.intValue();
                if (intValue2 != intValue) {
                    int size3 = list.size();
                    SpanStyle spanStyle2 = spanStyle;
                    for (int i5 = 0; i5 < size3; i5++) {
                        AnnotatedString.Range range2 = list.get(i5);
                        if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(intValue, intValue2, range2.getStart(), range2.getEnd())) {
                            spanStyle2 = merge(spanStyle2, (SpanStyle) range2.getItem());
                        }
                    }
                    if (spanStyle2 != null) {
                        function3.invoke(spanStyle2, Integer.valueOf(intValue), num);
                    }
                    intValue = intValue2;
                }
            }
        } else if (!list.isEmpty()) {
            function3.invoke(merge(spanStyle, (SpanStyle) list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
        }
    }

    /* renamed from: createLetterSpacingSpan-eAf_CNQ  reason: not valid java name */
    private static final MetricAffectingSpan m6330createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long r0 = TextUnit.m6810getTypeUIouoOA(j);
        if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6844getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.m6549toPxR2X_6o(j));
        }
        if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6843getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m6811getValueimpl(j));
        }
        return null;
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle spanStyle) {
        return TextUnitType.m6839equalsimpl0(TextUnit.m6810getTypeUIouoOA(spanStyle.m6005getLetterSpacingXSAIIZE()), TextUnitType.Companion.m6844getSpUIouoOA()) || TextUnitType.m6839equalsimpl0(TextUnit.m6810getTypeUIouoOA(spanStyle.m6005getLetterSpacingXSAIIZE()), TextUnitType.Companion.m6843getEmUIouoOA());
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m3870toArgb8_81llA(shadow.m4199getColor0d7_KjU()), Offset.m3562getXimpl(shadow.m4200getOffsetF1C5BW0()), Offset.m3563getYimpl(shadow.m4200getOffsetF1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i2) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i2);
        }
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        Object obj;
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                obj = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                obj = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0)));
            }
            setSpan(spannable, obj, i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* renamed from: setFontSize-KmRG4DE  reason: not valid java name */
    public static final void m6335setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int i, int i2) {
        long r0 = TextUnit.m6810getTypeUIouoOA(j);
        if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6844getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt.roundToInt(density.m6549toPxR2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6843getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m6811getValueimpl(j)), i, i2);
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i, int i2) {
        if (textDecoration != null) {
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(TextDecoration.Companion.getUnderline()), textDecoration.contains(TextDecoration.Companion.getLineThrough())), i, i2);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM  reason: not valid java name */
    private static final void m6333setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m6349unboximpl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush == null) {
            return;
        }
        if (brush instanceof SolidColor) {
            m6334setColorRPmYEkk(spannable, ((SolidColor) brush).m4212getValue0d7_KjU(), i, i2);
        } else if (brush instanceof ShaderBrush) {
            setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m6075getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        SpanStyle spanStyle;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            AnnotatedString.Range range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle) range2.getItem()) || ((SpanStyle) range2.getItem()).m6004getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
        }
        List list2 = arrayList;
        if (hasFontAttributes(textStyle)) {
            spanStyle = new SpanStyle(0, 0, textStyle.getFontWeight(), textStyle.m6074getFontStyle4Lr2A7w(), textStyle.m6075getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65475, (DefaultConstructorMarker) null);
        } else {
            spanStyle = null;
        }
        flattenFontStylesAndApply(spanStyle, list2, new SpannableExtensions_androidKt$setFontAttributes$1(spannable, function4));
    }

    /* renamed from: setBackground-RPmYEkk  reason: not valid java name */
    public static final void m6332setBackgroundRPmYEkk(Spannable spannable, long j, int i, int i2) {
        if (j != Color.Companion.m3852getUnspecified0d7_KjU()) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m3870toArgb8_81llA(j)), i, i2);
        }
    }

    /* renamed from: setColor-RPmYEkk  reason: not valid java name */
    public static final void m6334setColorRPmYEkk(Spannable spannable, long j, int i, int i2) {
        if (j != Color.Companion.m3852getUnspecified0d7_KjU()) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m3870toArgb8_81llA(j)), i, i2);
        }
    }
}
