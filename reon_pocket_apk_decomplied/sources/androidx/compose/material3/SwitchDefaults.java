package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000eJ²\u0001\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u00020\t*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "defaultSwitchColors", "Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m6614constructorimpl((float) 16);

    private SwitchDefaults() {
    }

    public final SwitchColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(435552781);
        ComposerKt.sourceInformation(composer, "C(colors)269@10190L11:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435552781, i, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:269)");
        }
        SwitchColors defaultSwitchColors$material3_release = getDefaultSwitchColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSwitchColors$material3_release;
    }

    /* renamed from: colors-V1nXRL4  reason: not valid java name */
    public final SwitchColors m2335colorsV1nXRL4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(1937926421);
        ComposerKt.sourceInformation(composer2, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,14:c#ui.graphics.Color,15:c#ui.graphics.Color,12:c#ui.graphics.Color,13:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,8:c#ui.graphics.Color,9:c#ui.graphics.Color)294@11942L5,295@12016L5,297@12143L5,298@12222L5,299@12300L5,300@12391L5,301@12467L5,302@12558L5,304@12675L11,305@12780L5,307@12888L11,309@13054L5,311@13169L11,312@13279L5,314@13398L11,315@13507L5,317@13615L11,319@13744L5,321@13860L11,322@13967L5,324@14084L11:Switch.kt#uh7d8r");
        long value = (i4 & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer2, 6) : j;
        long value2 = (i4 & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer2, 6) : j2;
        long r12 = (i4 & 4) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j3;
        long value3 = (i4 & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), composer2, 6) : j4;
        long value4 = (i4 & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer2, 6) : j5;
        long value5 = (i4 & 32) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer2, 6) : j6;
        long value6 = (i4 & 64) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer2, 6) : j7;
        long value7 = (i4 & 128) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer2, 6) : j8;
        long r24 = (i4 & 256) != 0 ? ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer2, 6), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU()) : j9;
        long r26 = (i4 & 512) != 0 ? ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU()) : j10;
        long r28 = (i4 & 1024) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j11;
        long r30 = (i4 & 2048) != 0 ? ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU()) : j12;
        long r32 = (i4 & 4096) != 0 ? ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU()) : j13;
        long r34 = (i4 & 8192) != 0 ? ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU()) : j14;
        long r36 = (i4 & 16384) != 0 ? ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU()) : j15;
        long r38 = (i4 & 32768) != 0 ? ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU()) : j16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i, i2, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:325)");
        }
        SwitchColors switchColors = new SwitchColors(value, value2, r12, value3, value4, value5, value6, value7, r24, r26, r28, r30, r32, r34, r36, r38, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return switchColors;
    }

    public final SwitchColors getDefaultSwitchColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SwitchColors defaultSwitchColorsCached$material3_release = colorScheme.getDefaultSwitchColorsCached$material3_release();
        if (defaultSwitchColorsCached$material3_release != null) {
            return defaultSwitchColorsCached$material3_release;
        }
        long fromToken = ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getSelectedHandleColor());
        SwitchColors switchColors = r2;
        long j = fromToken;
        SwitchColors switchColors2 = new SwitchColors(j, ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getSelectedTrackColor()), Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getSelectedIconColor()), ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedHandleColor()), ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedTrackColor()), ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getUnselectedIconColor()), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledSelectedHandleColor()), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledSelectedTrackColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), Color.Companion.m3851getTransparent0d7_KjU(), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledSelectedIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SwitchTokens.INSTANCE.getDisabledUnselectedIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), (DefaultConstructorMarker) null);
        SwitchColors switchColors3 = switchColors;
        colorScheme2.setDefaultSwitchColorsCached$material3_release(switchColors3);
        return switchColors3;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2336getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
