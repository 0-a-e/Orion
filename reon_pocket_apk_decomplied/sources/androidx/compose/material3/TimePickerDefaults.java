package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJ\u0001\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/TimePickerDefaults;", "", "()V", "defaultTimePickerColors", "Landroidx/compose/material3/TimePickerColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTimePickerColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TimePickerColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TimePickerColors;", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "selectorColor", "containerColor", "periodSelectorBorderColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "colors-u3YEpmA", "(JJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "layoutType-sDNSZnc", "(Landroidx/compose/runtime/Composer;I)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePickerDefaults {
    public static final int $stable = 0;
    public static final TimePickerDefaults INSTANCE = new TimePickerDefaults();

    private TimePickerDefaults() {
    }

    public final TimePickerColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-2085808058);
        ComposerKt.sourceInformation(composer, "C(colors)263@12764L11:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2085808058, i, -1, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:263)");
        }
        TimePickerColors defaultTimePickerColors$material3_release = getDefaultTimePickerColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTimePickerColors$material3_release;
    }

    /* renamed from: colors-u3YEpmA  reason: not valid java name */
    public final TimePickerColors m2480colorsu3YEpmA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(-646352288);
        ComposerKt.sourceInformation(composer2, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color,10:c#ui.graphics.Color,12:c#ui.graphics.Color,11:c#ui.graphics.Color,13:c#ui.graphics.Color)309@15502L11:TimePicker.kt#uh7d8r");
        long r6 = (i4 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r14 = (i4 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r16 = (i4 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r8 = (i4 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r10 = (i4 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r12 = (i4 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r18 = (i4 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r20 = (i4 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        long r22 = (i4 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j9;
        long r24 = (i4 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j10;
        long r26 = (i4 & 1024) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j11;
        long r28 = (i4 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j12;
        long r30 = (i4 & 4096) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j13;
        long r32 = (i4 & 8192) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j14;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-646352288, i, i2, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:309)");
        }
        TimePickerColors r1 = getDefaultTimePickerColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2461copydVHXu7A(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final TimePickerColors getDefaultTimePickerColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        TimePickerColors defaultTimePickerColorsCached$material3_release = colorScheme.getDefaultTimePickerColorsCached$material3_release();
        if (defaultTimePickerColorsCached$material3_release != null) {
            return defaultTimePickerColorsCached$material3_release;
        }
        TimePickerColors timePickerColors = new TimePickerColors(ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getClockDialColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getClockDialSelectorHandleContainerColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getPeriodSelectorOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getClockDialSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getClockDialUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getPeriodSelectorSelectedContainerColor()), Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getPeriodSelectorSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getPeriodSelectorUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getTimeSelectorSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getTimeSelectorUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getTimeSelectorSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, TimePickerTokens.INSTANCE.getTimeSelectorUnselectedLabelTextColor()), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultTimePickerColorsCached$material3_release(timePickerColors);
        return timePickerColors;
    }

    /* renamed from: layoutType-sDNSZnc  reason: not valid java name */
    public final int m2481layoutTypesDNSZnc(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 517161502, "C(layoutType)358@18364L27:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(517161502, i, -1, "androidx.compose.material3.TimePickerDefaults.layoutType (TimePicker.kt:358)");
        }
        int defaultTimePickerLayoutType = TimePicker_androidKt.getDefaultTimePickerLayoutType(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTimePickerLayoutType;
    }
}
