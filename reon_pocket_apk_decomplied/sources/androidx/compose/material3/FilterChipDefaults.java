package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u0001\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%JN\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/J^\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u00020\u00182\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u0001\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010%JN\u0010?\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010/R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u000f*\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultElevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedFilterChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "getDefaultFilterChipColors$material3_release", "elevatedFilterChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class FilterChipDefaults {
    public static final int $stable = 0;
    private static final float Height = FilterChipTokens.INSTANCE.m2919getContainerHeightD9Ej5fM();
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float IconSize = FilterChipTokens.INSTANCE.m2935getIconSizeD9Ej5fM();

    private FilterChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1870getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1871getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final SelectableChipColors filterChipColors(Composer composer, int i) {
        composer.startReplaceableGroup(-1743772077);
        ComposerKt.sourceInformation(composer, "C(filterChipColors)1197@59368L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1743772077, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1197)");
        }
        SelectableChipColors defaultFilterChipColors$material3_release = getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultFilterChipColors$material3_release;
    }

    /* renamed from: filterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m1868filterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(-1831479801);
        ComposerKt.sourceInformation(composer2, "C(filterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1231@61356L11:Chip.kt#uh7d8r");
        long r6 = (i4 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i4 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r12 = (i4 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r14 = (i4 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r16 = (i4 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r18 = (i4 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r20 = (i4 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r22 = (i4 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        long r24 = (i4 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j9;
        long r26 = (i4 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j10;
        long r28 = (i4 & 1024) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j11;
        long r30 = (i4 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, i, i2, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1231)");
        }
        SelectableChipColors r1 = getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2148copydaRQuJA(r6, r8, r12, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final SelectableChipColors getDefaultFilterChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SelectableChipColors defaultFilterChipColorsCached$material3_release = colorScheme.getDefaultFilterChipColorsCached$material3_release();
        if (defaultFilterChipColorsCached$material3_release != null) {
            return defaultFilterChipColorsCached$material3_release;
        }
        SelectableChipColors selectableChipColors = r2;
        SelectableChipColors selectableChipColors2 = new SelectableChipColors(Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getLeadingIconUnselectedColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getLeadingIconUnselectedColor()), Color.Companion.m3851getTransparent0d7_KjU(), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getFlatSelectedContainerColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), (DefaultConstructorMarker) null);
        SelectableChipColors selectableChipColors3 = selectableChipColors;
        colorScheme2.setDefaultFilterChipColorsCached$material3_release(selectableChipColors3);
        return selectableChipColors3;
    }

    /* renamed from: filterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1869filterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-757972185);
        ComposerKt.sourceInformation(composer2, "C(filterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? FilterChipTokens.INSTANCE.m2926getFlatContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? FilterChipTokens.INSTANCE.m2930getFlatSelectedPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? FilterChipTokens.INSTANCE.m2927getFlatSelectedFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? FilterChipTokens.INSTANCE.m2928getFlatSelectedHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m2920getDraggedContainerElevationD9Ej5fM() : f5;
        float f7 = (i2 & 32) != 0 ? r4 : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1294)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(r4, r5, r6, r7, r8, f7, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    /* renamed from: filterChipBorder-_7El2pE  reason: not valid java name */
    public final BorderStroke m1867filterChipBorder_7El2pE(boolean z, boolean z2, long j, long j2, long j3, long j4, float f, float f2, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(-1138342447);
        ComposerKt.sourceInformation(composer2, "C(filterChipBorder)P(4,5,0:c#ui.graphics.Color,6:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,7:c#ui.unit.Dp)1324@66465L5,1326@66617L5:Chip.kt#uh7d8r");
        long value = (i3 & 4) != 0 ? ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer2, 6) : j;
        long r7 = (i3 & 8) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j2;
        long r3 = (i3 & 16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long r9 = (i3 & 32) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j4;
        float r11 = (i3 & 64) != 0 ? FilterChipTokens.INSTANCE.m2933getFlatUnselectedOutlineWidthD9Ej5fM() : f;
        float r1 = (i3 & 128) != 0 ? FilterChipTokens.INSTANCE.m2929getFlatSelectedOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1138342447, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1331)");
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

    public final SelectableChipColors elevatedFilterChipColors(Composer composer, int i) {
        composer.startReplaceableGroup(1082953289);
        ComposerKt.sourceInformation(composer, "C(elevatedFilterChipColors)1345@67458L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1082953289, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1345)");
        }
        SelectableChipColors defaultElevatedFilterChipColors$material3_release = getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultElevatedFilterChipColors$material3_release;
    }

    /* renamed from: elevatedFilterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m1865elevatedFilterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(-915841711);
        ComposerKt.sourceInformation(composer2, "C(elevatedFilterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1379@69467L11:Chip.kt#uh7d8r");
        long r6 = (i4 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i4 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r12 = (i4 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r14 = (i4 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r16 = (i4 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r18 = (i4 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r20 = (i4 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r22 = (i4 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        long r24 = (i4 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j9;
        long r26 = (i4 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j10;
        long r28 = (i4 & 1024) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j11;
        long r30 = (i4 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, i, i2, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1379)");
        }
        SelectableChipColors r1 = getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2148copydaRQuJA(r6, r8, r12, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SelectableChipColors defaultElevatedFilterChipColorsCached$material3_release = colorScheme.getDefaultElevatedFilterChipColorsCached$material3_release();
        if (defaultElevatedFilterChipColorsCached$material3_release != null) {
            return defaultElevatedFilterChipColorsCached$material3_release;
        }
        SelectableChipColors selectableChipColors = r2;
        SelectableChipColors selectableChipColors2 = new SelectableChipColors(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getLeadingIconUnselectedColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getLeadingIconUnselectedColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), (DefaultConstructorMarker) null);
        SelectableChipColors selectableChipColors3 = selectableChipColors;
        colorScheme2.setDefaultElevatedFilterChipColorsCached$material3_release(selectableChipColors3);
        return selectableChipColors3;
    }

    /* renamed from: elevatedFilterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1866elevatedFilterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(684803697);
        ComposerKt.sourceInformation(composer2, "C(elevatedFilterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? FilterChipTokens.INSTANCE.m2921getElevatedContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? FilterChipTokens.INSTANCE.m2925getElevatedPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? FilterChipTokens.INSTANCE.m2923getElevatedFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? FilterChipTokens.INSTANCE.m2924getElevatedHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m2920getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? FilterChipTokens.INSTANCE.m2922getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1442)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(r4, r5, r6, r7, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1598643637);
        ComposerKt.sourceInformation(composer, "C1452@73786L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, i, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1452)");
        }
        Shape value = ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }
}
