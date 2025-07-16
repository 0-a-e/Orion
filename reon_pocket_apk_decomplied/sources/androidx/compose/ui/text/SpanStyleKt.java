package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f\u001a+\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001aÀ\u0001\u0010\u001a\u001a\u00020\b*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u00132\b\u00107\u001a\u0004\u0018\u000108H\u0000ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0018\u0010;\u001a\u0004\u0018\u00010\u0013*\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u0013H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpanStyle.kt */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor = Color.Companion.m3851getTransparent0d7_KjU();
    /* access modifiers changed from: private */
    public static final long DefaultColor = Color.Companion.m3842getBlack0d7_KjU();
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY  reason: not valid java name */
    public static final long m6007lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m6829isUnspecifiedR2X_6o(j) || TextUnitKt.m6829isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m6801boximpl(j), TextUnit.m6801boximpl(j2), f)).m6820unboximpl();
        }
        return TextUnitKt.m6831lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        float f2 = f;
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f2);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f2);
        long r5 = m6007lerpTextUnitInheritableC3pnCVY(spanStyle.m6002getFontSizeXSAIIZE(), spanStyle2.m6002getFontSizeXSAIIZE(), f2);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f2);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m6003getFontStyle4Lr2A7w(), spanStyle2.m6003getFontStyle4Lr2A7w(), f2);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m6004getFontSynthesisZQGJjVo(), spanStyle2.m6004getFontSynthesisZQGJjVo(), f2);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f2);
        long r12 = m6007lerpTextUnitInheritableC3pnCVY(spanStyle.m6005getLetterSpacingXSAIIZE(), spanStyle2.m6005getLetterSpacingXSAIIZE(), f2);
        BaselineShift r1 = spanStyle.m6000getBaselineShift5SSeXJ0();
        float r13 = r1 != null ? r1.m6349unboximpl() : BaselineShift.m6344constructorimpl(0.0f);
        BaselineShift r3 = spanStyle2.m6000getBaselineShift5SSeXJ0();
        float r14 = BaselineShiftKt.m6356lerpjWV1Mfo(r13, r3 != null ? r3.m6349unboximpl() : BaselineShift.m6344constructorimpl(0.0f), f2);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f2);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f2);
        TextGeometricTransform textGeometricTransform3 = lerp3;
        long r18 = ColorKt.m3867lerpjxsXWHM(spanStyle.m5999getBackground0d7_KjU(), spanStyle2.m5999getBackground0d7_KjU(), f2);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f2);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0, 0, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        return new SpanStyle(lerp, r5, lerp2, fontStyle, fontSynthesis, fontFamily, str, r12, BaselineShift.m6343boximpl(r14), textGeometricTransform3, localeList, r18, textDecoration, ShadowKt.lerp(shadow, shadow2, f2), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f2), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f2), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long j;
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(SpanStyleKt$resolveSpanStyleDefaults$1.INSTANCE);
        long r4 = TextUnitKt.m6829isUnspecifiedR2X_6o(spanStyle.m6002getFontSizeXSAIIZE()) ? DefaultFontSize : spanStyle.m6002getFontSizeXSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle r0 = spanStyle.m6003getFontStyle4Lr2A7w();
        FontStyle r7 = FontStyle.m6155boximpl(r0 != null ? r0.m6161unboximpl() : FontStyle.Companion.m6165getNormal_LCdwA());
        FontSynthesis r02 = spanStyle.m6004getFontSynthesisZQGJjVo();
        FontSynthesis r8 = FontSynthesis.m6166boximpl(r02 != null ? r02.m6174unboximpl() : FontSynthesis.Companion.m6175getAllGVVA2EU());
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m6829isUnspecifiedR2X_6o(spanStyle.m6005getLetterSpacingXSAIIZE())) {
            j = DefaultLetterSpacing;
        } else {
            j = spanStyle.m6005getLetterSpacingXSAIIZE();
        }
        long j2 = j;
        BaselineShift r03 = spanStyle.m6000getBaselineShift5SSeXJ0();
        BaselineShift r13 = BaselineShift.m6343boximpl(r03 != null ? r03.m6349unboximpl() : BaselineShift.Companion.m6353getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long r04 = spanStyle.m5999getBackground0d7_KjU();
        if (r04 == Color.Companion.m3852getUnspecified0d7_KjU()) {
            r04 = DefaultBackgroundColor;
        }
        long j3 = r04;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, r4, fontWeight2, r7, r8, fontFamily2, str, j2, r13, textGeometricTransform2, localeList2, j3, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x00f1: MOVE  (r14v6 androidx.compose.ui.text.intl.LocaleList) = (r37v0 androidx.compose.ui.text.intl.LocaleList)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01a1  */
    /* renamed from: fastMerge-dSHsh3o  reason: not valid java name */
    public static final androidx.compose.ui.text.SpanStyle m6006fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle r21, long r22, androidx.compose.ui.graphics.Brush r24, float r25, long r26, androidx.compose.ui.text.font.FontWeight r28, androidx.compose.ui.text.font.FontStyle r29, androidx.compose.ui.text.font.FontSynthesis r30, androidx.compose.ui.text.font.FontFamily r31, java.lang.String r32, long r33, androidx.compose.ui.text.style.BaselineShift r35, androidx.compose.ui.text.style.TextGeometricTransform r36, androidx.compose.ui.text.intl.LocaleList r37, long r38, androidx.compose.ui.text.style.TextDecoration r40, androidx.compose.ui.graphics.Shadow r41, androidx.compose.ui.text.PlatformSpanStyle r42, androidx.compose.ui.graphics.drawscope.DrawStyle r43) {
        /*
            r0 = r21
            r1 = r22
            r3 = r24
            r4 = r25
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r15 = r40
            r0 = r41
            boolean r16 = androidx.compose.ui.unit.TextUnitKt.m6829isUnspecifiedR2X_6o(r26)
            r16 = r16 ^ 1
            if (r16 == 0) goto L_0x003f
            long r13 = r21.m6002getFontSizeXSAIIZE()
            r11 = r26
            boolean r13 = androidx.compose.ui.unit.TextUnit.m6808equalsimpl0(r11, r13)
            if (r13 == 0) goto L_0x0033
            goto L_0x0041
        L_0x0033:
            r0 = r21
            r13 = r36
        L_0x0037:
            r14 = r38
        L_0x0039:
            r11 = r42
        L_0x003b:
            r12 = r43
            goto L_0x014d
        L_0x003f:
            r11 = r26
        L_0x0041:
            if (r3 != 0) goto L_0x005b
            androidx.compose.ui.graphics.Color$Companion r13 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r13.m3852getUnspecified0d7_KjU()
            int r13 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r13 == 0) goto L_0x005b
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r21.getTextForegroundStyle$ui_text_release()
            long r13 = r13.m6481getColor0d7_KjU()
            boolean r13 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r1, r13)
            if (r13 == 0) goto L_0x0033
        L_0x005b:
            if (r6 == 0) goto L_0x0067
            androidx.compose.ui.text.font.FontStyle r13 = r21.m6003getFontStyle4Lr2A7w()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0033
        L_0x0067:
            if (r5 == 0) goto L_0x0073
            androidx.compose.ui.text.font.FontWeight r13 = r21.getFontWeight()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0033
        L_0x0073:
            if (r8 == 0) goto L_0x007b
            androidx.compose.ui.text.font.FontFamily r13 = r21.getFontFamily()
            if (r8 != r13) goto L_0x0033
        L_0x007b:
            boolean r13 = androidx.compose.ui.unit.TextUnitKt.m6829isUnspecifiedR2X_6o(r33)
            r13 = r13 ^ 1
            if (r13 == 0) goto L_0x0090
            long r13 = r21.m6005getLetterSpacingXSAIIZE()
            r11 = r33
            boolean r13 = androidx.compose.ui.unit.TextUnit.m6808equalsimpl0(r11, r13)
            if (r13 == 0) goto L_0x0033
            goto L_0x0092
        L_0x0090:
            r11 = r33
        L_0x0092:
            if (r15 == 0) goto L_0x009e
            androidx.compose.ui.text.style.TextDecoration r13 = r21.getTextDecoration()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0033
        L_0x009e:
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r21.getTextForegroundStyle$ui_text_release()
            androidx.compose.ui.graphics.Brush r13 = r13.getBrush()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0033
            if (r3 == 0) goto L_0x00ba
            androidx.compose.ui.text.style.TextForegroundStyle r13 = r21.getTextForegroundStyle$ui_text_release()
            float r13 = r13.getAlpha()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x0033
        L_0x00ba:
            if (r7 == 0) goto L_0x00c6
            androidx.compose.ui.text.font.FontSynthesis r13 = r21.m6004getFontSynthesisZQGJjVo()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0033
        L_0x00c6:
            if (r9 == 0) goto L_0x00d2
            java.lang.String r13 = r21.getFontFeatureSettings()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0033
        L_0x00d2:
            if (r10 == 0) goto L_0x00de
            androidx.compose.ui.text.style.BaselineShift r13 = r21.m6000getBaselineShift5SSeXJ0()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x0033
        L_0x00de:
            r13 = r36
            if (r13 == 0) goto L_0x00f1
            androidx.compose.ui.text.style.TextGeometricTransform r14 = r21.getTextGeometricTransform()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r14 == 0) goto L_0x00ed
            goto L_0x00f1
        L_0x00ed:
            r0 = r21
            goto L_0x0037
        L_0x00f1:
            r14 = r37
            if (r14 == 0) goto L_0x00ff
            androidx.compose.ui.text.intl.LocaleList r11 = r21.getLocaleList()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x00ed
        L_0x00ff:
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            long r11 = r11.m3852getUnspecified0d7_KjU()
            r14 = r38
            int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x011a
            long r11 = r21.m5999getBackground0d7_KjU()
            boolean r11 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r14, r11)
            if (r11 == 0) goto L_0x0116
            goto L_0x011a
        L_0x0116:
            r0 = r21
            goto L_0x0039
        L_0x011a:
            if (r0 == 0) goto L_0x0126
            androidx.compose.ui.graphics.Shadow r11 = r21.getShadow()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x0116
        L_0x0126:
            r11 = r42
            if (r11 == 0) goto L_0x0139
            androidx.compose.ui.text.PlatformSpanStyle r12 = r21.getPlatformStyle()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r12 == 0) goto L_0x0135
            goto L_0x0139
        L_0x0135:
            r0 = r21
            goto L_0x003b
        L_0x0139:
            r12 = r43
            if (r12 == 0) goto L_0x014a
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = r21.getDrawStyle()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x014a
            r0 = r21
            goto L_0x014d
        L_0x014a:
            r0 = r21
            return r0
        L_0x014d:
            if (r3 == 0) goto L_0x0156
            androidx.compose.ui.text.style.TextForegroundStyle$Companion r1 = androidx.compose.ui.text.style.TextForegroundStyle.Companion
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r1.from(r3, r4)
            goto L_0x015c
        L_0x0156:
            androidx.compose.ui.text.style.TextForegroundStyle$Companion r3 = androidx.compose.ui.text.style.TextForegroundStyle.Companion
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r3.m6482from8_81llA(r1)
        L_0x015c:
            androidx.compose.ui.text.style.TextForegroundStyle r2 = r21.getTextForegroundStyle$ui_text_release()
            androidx.compose.ui.text.style.TextForegroundStyle r1 = r2.merge(r1)
            if (r8 != 0) goto L_0x016b
            androidx.compose.ui.text.font.FontFamily r2 = r21.getFontFamily()
            goto L_0x016c
        L_0x016b:
            r2 = r8
        L_0x016c:
            boolean r3 = androidx.compose.ui.unit.TextUnitKt.m6829isUnspecifiedR2X_6o(r26)
            if (r3 != 0) goto L_0x0175
            r3 = r26
            goto L_0x0179
        L_0x0175:
            long r3 = r21.m6002getFontSizeXSAIIZE()
        L_0x0179:
            if (r5 != 0) goto L_0x017f
            androidx.compose.ui.text.font.FontWeight r5 = r21.getFontWeight()
        L_0x017f:
            if (r6 != 0) goto L_0x0185
            androidx.compose.ui.text.font.FontStyle r6 = r21.m6003getFontStyle4Lr2A7w()
        L_0x0185:
            if (r7 != 0) goto L_0x018b
            androidx.compose.ui.text.font.FontSynthesis r7 = r21.m6004getFontSynthesisZQGJjVo()
        L_0x018b:
            if (r9 != 0) goto L_0x0192
            java.lang.String r8 = r21.getFontFeatureSettings()
            r9 = r8
        L_0x0192:
            boolean r8 = androidx.compose.ui.unit.TextUnitKt.m6829isUnspecifiedR2X_6o(r33)
            if (r8 != 0) goto L_0x019b
            r16 = r33
            goto L_0x019f
        L_0x019b:
            long r16 = r21.m6005getLetterSpacingXSAIIZE()
        L_0x019f:
            if (r10 != 0) goto L_0x01a6
            androidx.compose.ui.text.style.BaselineShift r8 = r21.m6000getBaselineShift5SSeXJ0()
            r10 = r8
        L_0x01a6:
            if (r13 != 0) goto L_0x01ad
            androidx.compose.ui.text.style.TextGeometricTransform r8 = r21.getTextGeometricTransform()
            r13 = r8
        L_0x01ad:
            if (r37 != 0) goto L_0x01b4
            androidx.compose.ui.text.intl.LocaleList r8 = r21.getLocaleList()
            goto L_0x01b6
        L_0x01b4:
            r8 = r37
        L_0x01b6:
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r14.m3852getUnspecified0d7_KjU()
            int r14 = (r38 > r14 ? 1 : (r38 == r14 ? 0 : -1))
            if (r14 == 0) goto L_0x01c3
            r14 = r38
            goto L_0x01c7
        L_0x01c3:
            long r14 = r21.m5999getBackground0d7_KjU()
        L_0x01c7:
            if (r40 != 0) goto L_0x01ce
            androidx.compose.ui.text.style.TextDecoration r18 = r21.getTextDecoration()
            goto L_0x01d0
        L_0x01ce:
            r18 = r40
        L_0x01d0:
            if (r41 != 0) goto L_0x01d7
            androidx.compose.ui.graphics.Shadow r19 = r21.getShadow()
            goto L_0x01d9
        L_0x01d7:
            r19 = r41
        L_0x01d9:
            androidx.compose.ui.text.PlatformSpanStyle r11 = mergePlatformStyle(r0, r11)
            if (r12 != 0) goto L_0x01e4
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = r21.getDrawStyle()
            r12 = r0
        L_0x01e4:
            androidx.compose.ui.text.SpanStyle r0 = new androidx.compose.ui.text.SpanStyle
            r21 = r0
            r20 = 0
            r41 = r20
            r22 = r1
            r23 = r3
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r2
            r29 = r9
            r30 = r16
            r32 = r10
            r33 = r13
            r34 = r8
            r35 = r14
            r37 = r18
            r38 = r19
            r39 = r11
            r40 = r12
            r21.<init>((androidx.compose.ui.text.style.TextForegroundStyle) r22, (long) r23, (androidx.compose.ui.text.font.FontWeight) r25, (androidx.compose.ui.text.font.FontStyle) r26, (androidx.compose.ui.text.font.FontSynthesis) r27, (androidx.compose.ui.text.font.FontFamily) r28, (java.lang.String) r29, (long) r30, (androidx.compose.ui.text.style.BaselineShift) r32, (androidx.compose.ui.text.style.TextGeometricTransform) r33, (androidx.compose.ui.text.intl.LocaleList) r34, (long) r35, (androidx.compose.ui.text.style.TextDecoration) r37, (androidx.compose.ui.graphics.Shadow) r38, (androidx.compose.ui.text.PlatformSpanStyle) r39, (androidx.compose.ui.graphics.drawscope.DrawStyle) r40, (kotlin.jvm.internal.DefaultConstructorMarker) r41)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyleKt.m6006fastMergedSHsh3o(androidx.compose.ui.text.SpanStyle, long, androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, androidx.compose.ui.graphics.drawscope.DrawStyle):androidx.compose.ui.text.SpanStyle");
    }
}
