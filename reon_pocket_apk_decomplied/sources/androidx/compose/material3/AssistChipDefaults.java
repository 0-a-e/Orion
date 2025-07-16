package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010#Jb\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u00182\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00182\b\b\u0002\u0010)\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-JN\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u00020\u00042\b\b\u0002\u00105\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010#Jb\u00108\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u00182\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00182\b\b\u0002\u0010)\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010-JN\u0010:\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u00020\u00042\b\b\u0002\u00105\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u00107R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<"}, d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultAssistChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultAssistChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "defaultElevatedAssistChipColors", "getDefaultElevatedAssistChipColors$material3_release", "assistChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "assistChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "assistChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class AssistChipDefaults {
    public static final int $stable = 0;
    private static final float Height = AssistChipTokens.INSTANCE.m2646getContainerHeightD9Ej5fM();
    public static final AssistChipDefaults INSTANCE = new AssistChipDefaults();
    private static final float IconSize = AssistChipTokens.INSTANCE.m2655getIconSizeD9Ej5fM();

    private AssistChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1527getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1528getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ChipColors assistChipColors(Composer composer, int i) {
        composer.startReplaceableGroup(1961061417);
        ComposerKt.sourceInformation(composer, "C(assistChipColors)952@47331L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1961061417, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:952)");
        }
        ChipColors defaultAssistChipColors$material3_release = getDefaultAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultAssistChipColors$material3_release;
    }

    /* renamed from: assistChipColors-oq7We08  reason: not valid java name */
    public final ChipColors m1523assistChipColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(-391745725);
        ComposerKt.sourceInformation(composer2, "C(assistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)977@48744L11:Chip.kt#uh7d8r");
        long r6 = (i3 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i3 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r10 = (i3 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r12 = (i3 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r14 = (i3 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r16 = (i3 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r18 = (i3 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r20 = (i3 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391745725, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:977)");
        }
        ChipColors r1 = getDefaultAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1607copyFD3wquc(r6, r8, r10, r12, r14, r16, r18, r20);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ChipColors getDefaultAssistChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ChipColors defaultAssistChipColorsCached$material3_release = colorScheme.getDefaultAssistChipColorsCached$material3_release();
        if (defaultAssistChipColorsCached$material3_release != null) {
            return defaultAssistChipColorsCached$material3_release;
        }
        ChipColors chipColors = r2;
        ChipColors chipColors2 = new ChipColors(Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getIconColor()), ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getIconColor()), Color.Companion.m3851getTransparent0d7_KjU(), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getDisabledIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getDisabledIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        ChipColors chipColors3 = chipColors;
        colorScheme2.setDefaultAssistChipColorsCached$material3_release(chipColors3);
        return chipColors3;
    }

    /* renamed from: assistChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1524assistChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(245366099);
        ComposerKt.sourceInformation(composer2, "C(assistChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? AssistChipTokens.INSTANCE.m2653getFlatContainerElevationD9Ej5fM() : f;
        float f7 = (i2 & 2) != 0 ? r4 : f2;
        float f8 = (i2 & 4) != 0 ? r4 : f3;
        float f9 = (i2 & 8) != 0 ? r4 : f4;
        float r8 = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m2647getDraggedContainerElevationD9Ej5fM() : f5;
        float f10 = (i2 & 32) != 0 ? r4 : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245366099, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:1029)");
        }
        ChipElevation chipElevation = new ChipElevation(r4, f7, f8, f9, r8, f10, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    /* renamed from: assistChipBorder-h1eT-Ww  reason: not valid java name */
    public final BorderStroke m1522assistChipBorderh1eTWw(boolean z, long j, long j2, float f, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1458649561);
        ComposerKt.sourceInformation(composer2, "C(assistChipBorder)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1049@52199L5,1050@52285L5:Chip.kt#uh7d8r");
        long value = (i2 & 2) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer2, 6) : j;
        long r2 = (i2 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        float r6 = (i2 & 8) != 0 ? AssistChipTokens.INSTANCE.m2654getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1458649561, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1053)");
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

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the assistChipBorder function that returns BorderStroke instead", replaceWith = @ReplaceWith(expression = "assistChipBorder(enabled, borderColor, disabledBorderColor, borderWidth)", imports = {}))
    /* renamed from: assistChipBorder-d_3_b6Q  reason: not valid java name */
    public final ChipBorder m1521assistChipBorderd_3_b6Q(long j, long j2, float f, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(382372847);
        ComposerKt.sourceInformation(composer2, "C(assistChipBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1072@53313L5,1073@53399L5:Chip.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer2, 6) : j;
        long r9 = (i2 & 2) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        float r11 = (i2 & 4) != 0 ? AssistChipTokens.INSTANCE.m2654getFlatOutlineWidthD9Ej5fM() : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382372847, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1076)");
        }
        ChipBorder chipBorder = new ChipBorder(value, r9, r11, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipBorder;
    }

    public final ChipColors elevatedAssistChipColors(Composer composer, int i) {
        composer.startReplaceableGroup(655175583);
        ComposerKt.sourceInformation(composer, "C(elevatedAssistChipColors)1087@53913L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(655175583, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1087)");
        }
        ChipColors defaultElevatedAssistChipColors$material3_release = getDefaultElevatedAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultElevatedAssistChipColors$material3_release;
    }

    /* renamed from: elevatedAssistChipColors-oq7We08  reason: not valid java name */
    public final ChipColors m1525elevatedAssistChipColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(-535762675);
        ComposerKt.sourceInformation(composer2, "C(elevatedAssistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)1112@55342L11:Chip.kt#uh7d8r");
        long r6 = (i3 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i3 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r10 = (i3 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r12 = (i3 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r14 = (i3 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r16 = (i3 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r18 = (i3 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r20 = (i3 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-535762675, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1112)");
        }
        ChipColors r1 = SuggestionChipDefaults.INSTANCE.getDefaultElevatedSuggestionChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1607copyFD3wquc(r6, r8, r10, r12, r14, r16, r18, r20);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ChipColors getDefaultElevatedAssistChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ChipColors defaultElevatedAssistChipColorsCached$material3_release = colorScheme.getDefaultElevatedAssistChipColorsCached$material3_release();
        if (defaultElevatedAssistChipColorsCached$material3_release != null) {
            return defaultElevatedAssistChipColorsCached$material3_release;
        }
        ChipColors chipColors = r2;
        ChipColors chipColors2 = new ChipColors(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getElevatedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getIconColor()), ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getIconColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getDisabledIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, AssistChipTokens.INSTANCE.getDisabledIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        ChipColors chipColors3 = chipColors;
        colorScheme2.setDefaultElevatedAssistChipColorsCached$material3_release(chipColors3);
        return chipColors3;
    }

    /* renamed from: elevatedAssistChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1526elevatedAssistChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1457698077);
        ComposerKt.sourceInformation(composer2, "C(elevatedAssistChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? AssistChipTokens.INSTANCE.m2648getElevatedContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? AssistChipTokens.INSTANCE.m2652getElevatedPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? AssistChipTokens.INSTANCE.m2650getElevatedFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? AssistChipTokens.INSTANCE.m2651getElevatedHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m2647getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? AssistChipTokens.INSTANCE.m2649getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457698077, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:1164)");
        }
        ChipElevation chipElevation = new ChipElevation(r4, r5, r6, r7, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return chipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(1988153916);
        ComposerKt.sourceInformation(composer, "C1174@58755L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1988153916, i, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:1174)");
        }
        Shape value = ShapesKt.getValue(AssistChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }
}
