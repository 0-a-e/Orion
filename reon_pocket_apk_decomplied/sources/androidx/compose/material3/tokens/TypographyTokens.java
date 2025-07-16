package androidx.compose.material3.tokens;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TypographyTokens.kt */
public final class TypographyTokens {
    public static final int $stable = 0;
    private static final TextStyle BodyLarge;
    private static final TextStyle BodyMedium;
    private static final TextStyle BodySmall;
    private static final TextStyle DisplayLarge;
    private static final TextStyle DisplayMedium;
    private static final TextStyle DisplaySmall;
    private static final TextStyle HeadlineLarge;
    private static final TextStyle HeadlineMedium;
    private static final TextStyle HeadlineSmall;
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    private static final TextStyle LabelLarge;
    private static final TextStyle LabelMedium;
    private static final TextStyle LabelSmall;
    private static final TextStyle TitleLarge;
    private static final TextStyle TitleMedium;
    private static final TextStyle TitleSmall;

    private TypographyTokens() {
    }

    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    static {
        TextStyle defaultTextStyle = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyLargeFont = TypeScaleTokens.INSTANCE.getBodyLargeFont();
        FontWeight bodyLargeWeight = TypeScaleTokens.INSTANCE.getBodyLargeWeight();
        FontFamily fontFamily = bodyLargeFont;
        BodyLarge = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle, 0, TypeScaleTokens.INSTANCE.m3212getBodyLargeSizeXSAIIZE(), bodyLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TypeScaleTokens.INSTANCE.m3213getBodyLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3211getBodyLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle2 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyMediumFont = TypeScaleTokens.INSTANCE.getBodyMediumFont();
        FontWeight bodyMediumWeight = TypeScaleTokens.INSTANCE.getBodyMediumWeight();
        FontFamily fontFamily2 = bodyMediumFont;
        BodyMedium = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle2, 0, TypeScaleTokens.INSTANCE.m3215getBodyMediumSizeXSAIIZE(), bodyMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, TypeScaleTokens.INSTANCE.m3216getBodyMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3214getBodyMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle3 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodySmallFont = TypeScaleTokens.INSTANCE.getBodySmallFont();
        FontWeight bodySmallWeight = TypeScaleTokens.INSTANCE.getBodySmallWeight();
        FontFamily fontFamily3 = bodySmallFont;
        BodySmall = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle3, 0, TypeScaleTokens.INSTANCE.m3218getBodySmallSizeXSAIIZE(), bodySmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily3, (String) null, TypeScaleTokens.INSTANCE.m3219getBodySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3217getBodySmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle4 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayLargeFont = TypeScaleTokens.INSTANCE.getDisplayLargeFont();
        FontWeight displayLargeWeight = TypeScaleTokens.INSTANCE.getDisplayLargeWeight();
        FontFamily fontFamily4 = displayLargeFont;
        DisplayLarge = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle4, 0, TypeScaleTokens.INSTANCE.m3221getDisplayLargeSizeXSAIIZE(), displayLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily4, (String) null, TypeScaleTokens.INSTANCE.m3222getDisplayLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3220getDisplayLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle5 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayMediumFont = TypeScaleTokens.INSTANCE.getDisplayMediumFont();
        FontWeight displayMediumWeight = TypeScaleTokens.INSTANCE.getDisplayMediumWeight();
        FontFamily fontFamily5 = displayMediumFont;
        DisplayMedium = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle5, 0, TypeScaleTokens.INSTANCE.m3224getDisplayMediumSizeXSAIIZE(), displayMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily5, (String) null, TypeScaleTokens.INSTANCE.m3225getDisplayMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3223getDisplayMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle6 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displaySmallFont = TypeScaleTokens.INSTANCE.getDisplaySmallFont();
        FontWeight displaySmallWeight = TypeScaleTokens.INSTANCE.getDisplaySmallWeight();
        FontFamily fontFamily6 = displaySmallFont;
        DisplaySmall = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle6, 0, TypeScaleTokens.INSTANCE.m3227getDisplaySmallSizeXSAIIZE(), displaySmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily6, (String) null, TypeScaleTokens.INSTANCE.m3228getDisplaySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3226getDisplaySmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle7 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineLargeFont = TypeScaleTokens.INSTANCE.getHeadlineLargeFont();
        FontWeight headlineLargeWeight = TypeScaleTokens.INSTANCE.getHeadlineLargeWeight();
        FontFamily fontFamily7 = headlineLargeFont;
        HeadlineLarge = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle7, 0, TypeScaleTokens.INSTANCE.m3230getHeadlineLargeSizeXSAIIZE(), headlineLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily7, (String) null, TypeScaleTokens.INSTANCE.m3231getHeadlineLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3229getHeadlineLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle8 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineMediumFont = TypeScaleTokens.INSTANCE.getHeadlineMediumFont();
        FontWeight headlineMediumWeight = TypeScaleTokens.INSTANCE.getHeadlineMediumWeight();
        FontFamily fontFamily8 = headlineMediumFont;
        HeadlineMedium = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle8, 0, TypeScaleTokens.INSTANCE.m3233getHeadlineMediumSizeXSAIIZE(), headlineMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily8, (String) null, TypeScaleTokens.INSTANCE.m3234getHeadlineMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3232getHeadlineMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle9 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineSmallFont = TypeScaleTokens.INSTANCE.getHeadlineSmallFont();
        FontWeight headlineSmallWeight = TypeScaleTokens.INSTANCE.getHeadlineSmallWeight();
        FontFamily fontFamily9 = headlineSmallFont;
        HeadlineSmall = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle9, 0, TypeScaleTokens.INSTANCE.m3236getHeadlineSmallSizeXSAIIZE(), headlineSmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily9, (String) null, TypeScaleTokens.INSTANCE.m3237getHeadlineSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3235getHeadlineSmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle10 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelLargeFont = TypeScaleTokens.INSTANCE.getLabelLargeFont();
        FontWeight labelLargeWeight = TypeScaleTokens.INSTANCE.getLabelLargeWeight();
        FontFamily fontFamily10 = labelLargeFont;
        LabelLarge = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle10, 0, TypeScaleTokens.INSTANCE.m3239getLabelLargeSizeXSAIIZE(), labelLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily10, (String) null, TypeScaleTokens.INSTANCE.m3240getLabelLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3238getLabelLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle11 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelMediumFont = TypeScaleTokens.INSTANCE.getLabelMediumFont();
        FontWeight labelMediumWeight = TypeScaleTokens.INSTANCE.getLabelMediumWeight();
        FontFamily fontFamily11 = labelMediumFont;
        LabelMedium = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle11, 0, TypeScaleTokens.INSTANCE.m3242getLabelMediumSizeXSAIIZE(), labelMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily11, (String) null, TypeScaleTokens.INSTANCE.m3243getLabelMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3241getLabelMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle12 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelSmallFont = TypeScaleTokens.INSTANCE.getLabelSmallFont();
        FontWeight labelSmallWeight = TypeScaleTokens.INSTANCE.getLabelSmallWeight();
        FontFamily fontFamily12 = labelSmallFont;
        LabelSmall = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle12, 0, TypeScaleTokens.INSTANCE.m3245getLabelSmallSizeXSAIIZE(), labelSmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily12, (String) null, TypeScaleTokens.INSTANCE.m3246getLabelSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3244getLabelSmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle13 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleLargeFont = TypeScaleTokens.INSTANCE.getTitleLargeFont();
        FontWeight titleLargeWeight = TypeScaleTokens.INSTANCE.getTitleLargeWeight();
        FontFamily fontFamily13 = titleLargeFont;
        TitleLarge = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle13, 0, TypeScaleTokens.INSTANCE.m3248getTitleLargeSizeXSAIIZE(), titleLargeWeight, (FontStyle) null, (FontSynthesis) null, fontFamily13, (String) null, TypeScaleTokens.INSTANCE.m3249getTitleLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3247getTitleLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle14 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleMediumFont = TypeScaleTokens.INSTANCE.getTitleMediumFont();
        FontWeight titleMediumWeight = TypeScaleTokens.INSTANCE.getTitleMediumWeight();
        FontFamily fontFamily14 = titleMediumFont;
        TitleMedium = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle14, 0, TypeScaleTokens.INSTANCE.m3251getTitleMediumSizeXSAIIZE(), titleMediumWeight, (FontStyle) null, (FontSynthesis) null, fontFamily14, (String) null, TypeScaleTokens.INSTANCE.m3252getTitleMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3250getTitleMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle15 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleSmallFont = TypeScaleTokens.INSTANCE.getTitleSmallFont();
        FontWeight titleSmallWeight = TypeScaleTokens.INSTANCE.getTitleSmallWeight();
        FontFamily fontFamily15 = titleSmallFont;
        TitleSmall = TextStyle.m6055copyp1EtxEg$default(defaultTextStyle15, 0, TypeScaleTokens.INSTANCE.m3254getTitleSmallSizeXSAIIZE(), titleSmallWeight, (FontStyle) null, (FontSynthesis) null, fontFamily15, (String) null, TypeScaleTokens.INSTANCE.m3255getTitleSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3253getTitleSmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
    }

    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
