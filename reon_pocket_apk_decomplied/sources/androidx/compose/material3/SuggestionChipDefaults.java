package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014JN\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJN\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'J0\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00162\b\b\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.J8\u0010(\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00162\b\b\u0002\u0010,\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014JN\u00104\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJN\u00106\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b7\u0010'R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/material3/SuggestionChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultElevatedSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedSuggestionChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledIconContentColor", "elevatedSuggestionChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedSuggestionChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "suggestionChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "disabledBorderColor", "borderWidth", "suggestionChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "suggestionChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "suggestionChipColors", "suggestionChipColors-5tl4gsc", "suggestionChipElevation", "suggestionChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class SuggestionChipDefaults {
    public static final int $stable = 0;
    private static final float Height = SuggestionChipTokens.INSTANCE.m3146getContainerHeightD9Ej5fM();
    public static final SuggestionChipDefaults INSTANCE = new SuggestionChipDefaults();
    private static final float IconSize = SuggestionChipTokens.INSTANCE.m3155getLeadingIconSizeD9Ej5fM();

    private SuggestionChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m2297getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2298getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ChipColors suggestionChipColors(Composer composer, int i) {
        composer.startReplaceableGroup(1918570697);
        ComposerKt.sourceInformation(composer, "C(suggestionChipColors)1649@83085L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1918570697, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1649)");
        }
        ChipColors defaultSuggestionChipColors = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSuggestionChipColors;
    }

    /* renamed from: suggestionChipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m2301suggestionChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1882647883);
        ComposerKt.sourceInformation(composer2, "C(suggestionChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color)1670@84154L11:Chip.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r15 = (i2 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r17 = (i2 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1882647883, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1670)");
        }
        ChipColors r1 = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1607copyFD3wquc(r5, r7, r9, Color.Companion.m3852getUnspecified0d7_KjU(), r13, r15, r17, Color.Companion.m3852getUnspecified0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    /* renamed from: suggestionChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m2302suggestionChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1929994057);
        ComposerKt.sourceInformation(composer2, "C(suggestionChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? SuggestionChipTokens.INSTANCE.m3153getFlatContainerElevationD9Ej5fM() : f;
        float f7 = (i2 & 2) != 0 ? r4 : f2;
        float f8 = (i2 & 4) != 0 ? r4 : f3;
        float f9 = (i2 & 8) != 0 ? r4 : f4;
        float r8 = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m3147getDraggedContainerElevationD9Ej5fM() : f5;
        float f10 = (i2 & 32) != 0 ? r4 : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1929994057, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1700)");
        }
        ChipElevation chipElevation = new ChipElevation(r4, f7, f8, f9, r8, f10, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* renamed from: suggestionChipBorder-h1eT-Ww  reason: not valid java name */
    public final BorderStroke m2300suggestionChipBorderh1eTWw(boolean z, long j, long j2, float f, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-637354809);
        ComposerKt.sourceInformation(composer2, "C(suggestionChipBorder)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1720@86462L5,1721@86552L5:Chip.kt#uh7d8r");
        long value = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer2, 6) : j;
        long r2 = (i2 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        float r6 = (i2 & 8) != 0 ? SuggestionChipTokens.INSTANCE.m3154getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-637354809, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1724)");
        }
        if (!z) {
            value = r2;
        }
        BorderStroke r1 = BorderStrokeKt.m241BorderStrokecXLIe8U(r6, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the suggestChipBorder functions instead", replaceWith = @ReplaceWith(expression = "suggestionChipBorder(enabled, borderColor, disabledBorderColor, borderWidth)", imports = {}))
    /* renamed from: suggestionChipBorder-d_3_b6Q  reason: not valid java name */
    public final ChipBorder m2299suggestionChipBorderd_3_b6Q(long j, long j2, float f, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(439283919);
        ComposerKt.sourceInformation(composer2, "C(suggestionChipBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1742@87563L5,1743@87653L5:Chip.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer2, 6) : j;
        long r9 = (i2 & 2) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        float r11 = (i2 & 4) != 0 ? SuggestionChipTokens.INSTANCE.m3154getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(439283919, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1746)");
        }
        ChipBorder chipBorder = new ChipBorder(value, r9, r11, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipBorder;
    }

    public final ChipColors elevatedSuggestionChipColors(Composer composer, int i) {
        composer.startReplaceableGroup(1671233087);
        ComposerKt.sourceInformation(composer, "C(elevatedSuggestionChipColors)1758@88191L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1671233087, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1758)");
        }
        ChipColors defaultElevatedSuggestionChipColors$material3_release = getDefaultElevatedSuggestionChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultElevatedSuggestionChipColors$material3_release;
    }

    /* renamed from: elevatedSuggestionChipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m2295elevatedSuggestionChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1269423125);
        ComposerKt.sourceInformation(composer2, "C(elevatedSuggestionChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color)1779@89281L11:Chip.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r13 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r15 = (i2 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r17 = (i2 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1269423125, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1779)");
        }
        ChipColors r1 = getDefaultElevatedSuggestionChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1607copyFD3wquc(r5, r7, r9, Color.Companion.m3852getUnspecified0d7_KjU(), r13, r15, r17, Color.Companion.m3852getUnspecified0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ChipColors defaultElevatedSuggestionChipColorsCached$material3_release = colorScheme.getDefaultElevatedSuggestionChipColorsCached$material3_release();
        if (defaultElevatedSuggestionChipColorsCached$material3_release != null) {
            return defaultElevatedSuggestionChipColorsCached$material3_release;
        }
        ChipColors chipColors = new ChipColors(ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getElevatedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.Companion.m3852getUnspecified0d7_KjU(), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getDisabledIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.m3852getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultElevatedSuggestionChipColorsCached$material3_release(chipColors);
        return chipColors;
    }

    /* renamed from: elevatedSuggestionChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m2296elevatedSuggestionChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1118088467);
        ComposerKt.sourceInformation(composer2, "C(elevatedSuggestionChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? SuggestionChipTokens.INSTANCE.m3148getElevatedContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? SuggestionChipTokens.INSTANCE.m3152getElevatedPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? SuggestionChipTokens.INSTANCE.m3150getElevatedFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? SuggestionChipTokens.INSTANCE.m3151getElevatedHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m3147getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? SuggestionChipTokens.INSTANCE.m3149getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1118088467, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1831)");
        }
        ChipElevation chipElevation = new ChipElevation(r4, r5, r6, r7, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(641188183);
        ComposerKt.sourceInformation(composer, "C1841@92627L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(641188183, i, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1841)");
        }
        Shape value = ShapesKt.getValue(SuggestionChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }
}
