package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPaintExtensions.android.kt */
public final class TextPaintExtensions_androidKt {
    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, Density density, boolean z) {
        Locale locale;
        long r0 = TextUnit.m6810getTypeUIouoOA(spanStyle.m6002getFontSizeXSAIIZE());
        if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6844getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.m6549toPxR2X_6o(spanStyle.m6002getFontSizeXSAIIZE()));
        } else if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6843getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m6811getValueimpl(spanStyle.m6002getFontSizeXSAIIZE()));
        }
        if (hasFontAttributes(spanStyle)) {
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r2 = spanStyle.m6003getFontStyle4Lr2A7w();
            FontStyle r22 = FontStyle.m6155boximpl(r2 != null ? r2.m6161unboximpl() : FontStyle.Companion.m6165getNormal_LCdwA());
            FontSynthesis r3 = spanStyle.m6004getFontSynthesisZQGJjVo();
            androidTextPaint.setTypeface((Typeface) function4.invoke(fontFamily, fontWeight, r22, FontSynthesis.m6166boximpl(r3 != null ? r3.m6174unboximpl() : FontSynthesis.Companion.m6175getAllGVVA2EU())));
        }
        if (spanStyle.getLocaleList() != null && !Intrinsics.areEqual((Object) spanStyle.getLocaleList(), (Object) LocaleList.Companion.getCurrent())) {
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, spanStyle.getLocaleList());
            } else {
                if (spanStyle.getLocaleList().isEmpty()) {
                    locale = Locale.Companion.getCurrent();
                } else {
                    locale = spanStyle.getLocaleList().get(0);
                }
                androidTextPaint.setTextLocale(LocaleExtensions_androidKt.toJavaLocale(locale));
            }
        }
        if (spanStyle.getFontFeatureSettings() != null && !Intrinsics.areEqual((Object) spanStyle.getFontFeatureSettings(), (Object) "")) {
            androidTextPaint.setFontFeatureSettings(spanStyle.getFontFeatureSettings());
        }
        if (spanStyle.getTextGeometricTransform() != null && !Intrinsics.areEqual((Object) spanStyle.getTextGeometricTransform(), (Object) TextGeometricTransform.Companion.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * spanStyle.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + spanStyle.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m6322setColor8_81llA(spanStyle.m6001getColor0d7_KjU());
        androidTextPaint.m6321setBrush12SF9DM(spanStyle.getBrush(), Size.Companion.m3639getUnspecifiedNHjbRc(), spanStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle.getShadow());
        androidTextPaint.setTextDecoration(spanStyle.getTextDecoration());
        androidTextPaint.setDrawStyle(spanStyle.getDrawStyle());
        if (TextUnitType.m6839equalsimpl0(TextUnit.m6810getTypeUIouoOA(spanStyle.m6005getLetterSpacingXSAIIZE()), TextUnitType.Companion.m6844getSpUIouoOA()) && TextUnit.m6811getValueimpl(spanStyle.m6005getLetterSpacingXSAIIZE()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float r9 = density.m6549toPxR2X_6o(spanStyle.m6005getLetterSpacingXSAIIZE());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(r9 / textSize);
            }
        } else if (TextUnitType.m6839equalsimpl0(TextUnit.m6810getTypeUIouoOA(spanStyle.m6005getLetterSpacingXSAIIZE()), TextUnitType.Companion.m6843getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m6811getValueimpl(spanStyle.m6005getLetterSpacingXSAIIZE()));
        }
        return m6338generateFallbackSpanStyle62GTOB8(spanStyle.m6005getLetterSpacingXSAIIZE(), z, spanStyle.m5999getBackground0d7_KjU(), spanStyle.m6000getBaselineShift5SSeXJ0());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        if (androidx.compose.ui.text.style.BaselineShift.m6346equalsimpl0(r36.m6349unboximpl(), androidx.compose.ui.text.style.BaselineShift.Companion.m6353getNoney9eOQZs()) == false) goto L_0x0052;
     */
    /* renamed from: generateFallbackSpanStyle-62GTOB8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.text.SpanStyle m6338generateFallbackSpanStyle62GTOB8(long r31, boolean r33, long r34, androidx.compose.ui.text.style.BaselineShift r36) {
        /*
            r0 = r34
            r2 = 1
            r3 = 0
            if (r33 == 0) goto L_0x0022
            long r4 = androidx.compose.ui.unit.TextUnit.m6810getTypeUIouoOA(r31)
            androidx.compose.ui.unit.TextUnitType$Companion r6 = androidx.compose.ui.unit.TextUnitType.Companion
            long r6 = r6.m6844getSpUIouoOA()
            boolean r4 = androidx.compose.ui.unit.TextUnitType.m6839equalsimpl0(r4, r6)
            if (r4 == 0) goto L_0x0022
            float r4 = androidx.compose.ui.unit.TextUnit.m6811getValueimpl(r31)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r4 = r2
            goto L_0x0023
        L_0x0022:
            r4 = r3
        L_0x0023:
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r5.m3852getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r0, r5)
            if (r5 != 0) goto L_0x003d
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r5.m3851getTransparent0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r0, r5)
            if (r5 != 0) goto L_0x003d
            r5 = r2
            goto L_0x003e
        L_0x003d:
            r5 = r3
        L_0x003e:
            if (r36 == 0) goto L_0x0051
            androidx.compose.ui.text.style.BaselineShift$Companion r6 = androidx.compose.ui.text.style.BaselineShift.Companion
            float r6 = r6.m6353getNoney9eOQZs()
            float r7 = r36.m6349unboximpl()
            boolean r6 = androidx.compose.ui.text.style.BaselineShift.m6346equalsimpl0(r7, r6)
            if (r6 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r2 = r3
        L_0x0052:
            r3 = 0
            if (r4 != 0) goto L_0x005a
            if (r5 != 0) goto L_0x005a
            if (r2 != 0) goto L_0x005a
            goto L_0x009b
        L_0x005a:
            if (r4 == 0) goto L_0x005f
            r18 = r31
            goto L_0x0067
        L_0x005f:
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r6 = r4.m6822getUnspecifiedXSAIIZE()
            r18 = r6
        L_0x0067:
            if (r5 == 0) goto L_0x006a
            goto L_0x0070
        L_0x006a:
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r0 = r0.m3852getUnspecified0d7_KjU()
        L_0x0070:
            r23 = r0
            if (r2 == 0) goto L_0x0077
            r20 = r36
            goto L_0x0079
        L_0x0077:
            r20 = r3
        L_0x0079:
            androidx.compose.ui.text.SpanStyle r3 = new androidx.compose.ui.text.SpanStyle
            r8 = r3
            r29 = 63103(0xf67f, float:8.8426E-41)
            r30 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r8.<init>((long) r9, (long) r11, (androidx.compose.ui.text.font.FontWeight) r13, (androidx.compose.ui.text.font.FontStyle) r14, (androidx.compose.ui.text.font.FontSynthesis) r15, (androidx.compose.ui.text.font.FontFamily) r16, (java.lang.String) r17, (long) r18, (androidx.compose.ui.text.style.BaselineShift) r20, (androidx.compose.ui.text.style.TextGeometricTransform) r21, (androidx.compose.ui.text.intl.LocaleList) r22, (long) r23, (androidx.compose.ui.text.style.TextDecoration) r25, (androidx.compose.ui.graphics.Shadow) r26, (androidx.compose.ui.text.PlatformSpanStyle) r27, (androidx.compose.ui.graphics.drawscope.DrawStyle) r28, (int) r29, (kotlin.jvm.internal.DefaultConstructorMarker) r30)
        L_0x009b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.m6338generateFallbackSpanStyle62GTOB8(long, boolean, long, androidx.compose.ui.text.style.BaselineShift):androidx.compose.ui.text.SpanStyle");
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        int i;
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        if (textMotion.getSubpixelTextPositioning$ui_text_release()) {
            i = androidTextPaint.getFlags() | 128;
        } else {
            i = androidTextPaint.getFlags() & -129;
        }
        androidTextPaint.setFlags(i);
        int r3 = textMotion.m6490getLinearity4e0Vf04$ui_text_release();
        if (TextMotion.Linearity.m6494equalsimpl0(r3, TextMotion.Linearity.Companion.m6499getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m6494equalsimpl0(r3, TextMotion.Linearity.Companion.m6498getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (TextMotion.Linearity.m6494equalsimpl0(r3, TextMotion.Linearity.Companion.m6500getNone4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        return (spanStyle.getFontFamily() == null && spanStyle.m6003getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
