package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010$J\u0001\u0010#\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b2\b\b\u0002\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\u001b2\b\b\u0002\u0010*\u001a\u00020\u001b2\b\b\u0002\u0010+\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u001b2\b\b\u0002\u0010/\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u001b2\b\b\u0002\u00101\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103JN\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0011*\u00020\u00128@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/material3/InputChipDefaults;", "", "()V", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", "F", "Height", "getHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultInputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultInputChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "inputChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "Landroidx/compose/ui/graphics/Color;", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "inputChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class InputChipDefaults {
    public static final int $stable = 0;
    private static final float AvatarSize = InputChipTokens.INSTANCE.m2938getAvatarSizeD9Ej5fM();
    private static final float Height = InputChipTokens.INSTANCE.m2940getContainerHeightD9Ej5fM();
    public static final InputChipDefaults INSTANCE = new InputChipDefaults();
    private static final float IconSize = InputChipTokens.INSTANCE.m2942getLeadingIconSizeD9Ej5fM();

    private InputChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1912getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1913getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getAvatarSize-D9Ej5fM  reason: not valid java name */
    public final float m1911getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    public final SelectableChipColors inputChipColors(Composer composer, int i) {
        composer.startReplaceableGroup(-770375587);
        ComposerKt.sourceInformation(composer, "C(inputChipColors)1480@74502L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-770375587, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1480)");
        }
        SelectableChipColors defaultInputChipColors$material3_release = getDefaultInputChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultInputChipColors$material3_release;
    }

    /* renamed from: inputChipColors-kwJvTHA  reason: not valid java name */
    public final SelectableChipColors m1915inputChipColorskwJvTHA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(1312840646);
        ComposerKt.sourceInformation(composer2, "C(inputChipColors)P(0:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1516@76628L11:Chip.kt#uh7d8r");
        long r6 = (i4 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i4 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r10 = (i4 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r12 = (i4 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r14 = (i4 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r16 = (i4 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r18 = (i4 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r20 = (i4 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        long r22 = (i4 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j9;
        long r24 = (i4 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j10;
        long r26 = (i4 & 1024) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j11;
        long r28 = (i4 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j12;
        long r30 = (i4 & 4096) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1312840646, i, i2, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1516)");
        }
        SelectableChipColors r1 = getDefaultInputChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2148copydaRQuJA(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final SelectableChipColors getDefaultInputChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SelectableChipColors defaultInputChipColorsCached$material3_release = colorScheme.getDefaultInputChipColorsCached$material3_release();
        if (defaultInputChipColorsCached$material3_release != null) {
            return defaultInputChipColorsCached$material3_release;
        }
        SelectableChipColors selectableChipColors = r2;
        SelectableChipColors selectableChipColors2 = new SelectableChipColors(Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.Companion.m3851getTransparent0d7_KjU(), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getSelectedContainerColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getDisabledSelectedContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, InputChipTokens.INSTANCE.getSelectedTrailingIconColor()), (DefaultConstructorMarker) null);
        SelectableChipColors selectableChipColors3 = selectableChipColors;
        colorScheme2.setDefaultInputChipColorsCached$material3_release(selectableChipColors3);
        return selectableChipColors3;
    }

    /* renamed from: inputChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1916inputChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1745270109);
        ComposerKt.sourceInformation(composer2, "C(inputChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? InputChipTokens.INSTANCE.m2939getContainerElevationD9Ej5fM() : f;
        float f7 = (i2 & 2) != 0 ? r4 : f2;
        float f8 = (i2 & 4) != 0 ? r4 : f3;
        float f9 = (i2 & 8) != 0 ? r4 : f4;
        float r8 = (i2 & 16) != 0 ? InputChipTokens.INSTANCE.m2941getDraggedContainerElevationD9Ej5fM() : f5;
        float f10 = (i2 & 32) != 0 ? r4 : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1745270109, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1580)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(r4, f7, f8, f9, r8, f10, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    /* renamed from: inputChipBorder-_7El2pE  reason: not valid java name */
    public final BorderStroke m1914inputChipBorder_7El2pE(boolean z, boolean z2, long j, long j2, long j3, long j4, float f, float f2, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(2050575347);
        ComposerKt.sourceInformation(composer2, "C(inputChipBorder)P(4,5,0:c#ui.graphics.Color,6:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,7:c#ui.unit.Dp)1609@81579L5,1611@81726L5:Chip.kt#uh7d8r");
        long value = (i3 & 4) != 0 ? ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), composer2, 6) : j;
        long r7 = (i3 & 8) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j2;
        long r3 = (i3 & 16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long r9 = (i3 & 32) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j4;
        float r11 = (i3 & 64) != 0 ? InputChipTokens.INSTANCE.m2945getUnselectedOutlineWidthD9Ej5fM() : f;
        float r1 = (i3 & 128) != 0 ? InputChipTokens.INSTANCE.m2943getSelectedOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2050575347, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1616)");
        }
        if (!z) {
            value = z2 ? r9 : r3;
        } else if (z2) {
            value = r7;
        }
        if (z2) {
            r11 = r1;
        }
        BorderStroke r12 = BorderStrokeKt.m241BorderStrokecXLIe8U(r11, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r12;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(1052444143);
        ComposerKt.sourceInformation(composer, "C1626@82446L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052444143, i, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1626)");
        }
        Shape value = ShapesKt.getValue(InputChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }
}
