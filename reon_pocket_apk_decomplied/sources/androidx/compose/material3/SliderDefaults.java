package androidx.compose.material3;

import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.LayoutDirection;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0018J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001bJ3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001eJ\r\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001fJv\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,JN\u0010-\u001a\u00020\t*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "defaultSliderColors", "Landroidx/compose/material3/SliderColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "drawTrack-LUBghH0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJ)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(1376295968);
        ComposerKt.sourceInformation(composer, "C(colors)886@36284L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:886)");
        }
        SliderColors defaultSliderColors$material3_release = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSliderColors$material3_release;
    }

    /* renamed from: colors-q0g_0yA  reason: not valid java name */
    public final SliderColors m2192colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(885588574);
        ComposerKt.sourceInformation(composer2, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)927@38583L11:Slider.kt#uh7d8r");
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:927)");
        }
        SliderColors r1 = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2175copyK518z4(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final SliderColors getDefaultSliderColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        SliderColors defaultSliderColorsCached$material3_release = colorScheme.getDefaultSliderColorsCached$material3_release();
        if (defaultSliderColorsCached$material3_release != null) {
            return defaultSliderColorsCached$material3_release;
        }
        SliderColors sliderColors = r2;
        SliderColors sliderColors2 = new SliderColors(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getActiveTrackColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getTickMarksActiveContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getInactiveTrackColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getTickMarksInactiveContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledHandleColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), colorScheme.m1667getSurface0d7_KjU()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        SliderColors sliderColors3 = sliderColors;
        colorScheme2.setDefaultSliderColorsCached$material3_release(sliderColors3);
        return sliderColors3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014e  */
    /* renamed from: Thumb-9LiSoMs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2191Thumb9LiSoMs(androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.ui.Modifier r30, androidx.compose.material3.SliderColors r31, boolean r32, long r33, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r28 = this;
            r10 = r28
            r2 = r29
            r8 = r36
            r0 = -290277409(0xffffffffeeb2b7df, float:-2.765531E28)
            r1 = r35
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)983@41717L8,987@41833L46,988@41922L658,988@41888L692,1006@42779L5,1014@43049L143,1009@42833L595:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r37 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r8 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r8 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r8
            goto L_0x002b
        L_0x002a:
            r3 = r8
        L_0x002b:
            r6 = r37 & 2
            if (r6 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r8 & 48
            if (r7 != 0) goto L_0x0045
            r7 = r30
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0041
            r9 = 32
            goto L_0x0043
        L_0x0041:
            r9 = 16
        L_0x0043:
            r3 = r3 | r9
            goto L_0x0047
        L_0x0045:
            r7 = r30
        L_0x0047:
            r9 = r8 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0060
            r9 = r37 & 4
            if (r9 != 0) goto L_0x005a
            r9 = r31
            boolean r11 = r1.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x005c
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r9 = r31
        L_0x005c:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r3 = r3 | r11
            goto L_0x0062
        L_0x0060:
            r9 = r31
        L_0x0062:
            r11 = r37 & 8
            if (r11 == 0) goto L_0x0069
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r12 = r8 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x007c
            r12 = r32
            boolean r13 = r1.changed((boolean) r12)
            if (r13 == 0) goto L_0x0078
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r13
            goto L_0x007e
        L_0x007c:
            r12 = r32
        L_0x007e:
            r13 = r37 & 16
            if (r13 == 0) goto L_0x0085
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0085:
            r14 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x0099
            r14 = r33
            boolean r16 = r1.changed((long) r14)
            if (r16 == 0) goto L_0x0094
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r3 = r3 | r16
            goto L_0x009b
        L_0x0099:
            r14 = r33
        L_0x009b:
            r16 = r37 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a4
            r3 = r3 | r17
            goto L_0x00b5
        L_0x00a4:
            r16 = r8 & r17
            if (r16 != 0) goto L_0x00b5
            boolean r16 = r1.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r3 = r3 | r16
        L_0x00b5:
            r16 = 74899(0x12493, float:1.04956E-40)
            r4 = r3 & r16
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r4 != r5) goto L_0x00cf
            boolean r4 = r1.getSkipping()
            if (r4 != 0) goto L_0x00c6
            goto L_0x00cf
        L_0x00c6:
            r1.skipToGroupEnd()
            r3 = r7
            r4 = r9
            r5 = r12
            r6 = r14
            goto L_0x01f4
        L_0x00cf:
            r1.startDefaults()
            r4 = r8 & 1
            r5 = 1
            if (r4 == 0) goto L_0x00eb
            boolean r4 = r1.getDefaultsInvalid()
            if (r4 == 0) goto L_0x00de
            goto L_0x00eb
        L_0x00de:
            r1.skipToGroupEnd()
            r4 = r37 & 4
            if (r4 == 0) goto L_0x00e7
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e7:
            r4 = r3
            r3 = r12
            r13 = r14
            goto L_0x010c
        L_0x00eb:
            if (r6 == 0) goto L_0x00f2
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r7 = r4
        L_0x00f2:
            r4 = r37 & 4
            if (r4 == 0) goto L_0x0101
            int r4 = r3 >> 15
            r4 = r4 & 14
            androidx.compose.material3.SliderColors r4 = r10.colors(r1, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r4
        L_0x0101:
            if (r11 == 0) goto L_0x0104
            r12 = r5
        L_0x0104:
            if (r13 == 0) goto L_0x00e7
            long r13 = androidx.compose.material3.SliderKt.ThumbSize
            r4 = r3
            r3 = r12
        L_0x010c:
            r1.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x011b
            r6 = -1
            java.lang.String r11 = "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:986)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r6, r11)
        L_0x011b:
            r0 = -1142853013(0xffffffffbbe1726b, float:-0.0068800948)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            java.lang.Object r6 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r6 != r11) goto L_0x0139
            androidx.compose.runtime.snapshots.SnapshotStateList r6 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            r1.updateRememberedValue(r6)
        L_0x0139:
            androidx.compose.runtime.snapshots.SnapshotStateList r6 = (androidx.compose.runtime.snapshots.SnapshotStateList) r6
            r1.endReplaceableGroup()
            r11 = -1142852924(0xffffffffbbe172c4, float:-0.006880136)
            r1.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            r0 = r4 & 14
            r11 = 4
            if (r0 != r11) goto L_0x014e
            r11 = r5
            goto L_0x014f
        L_0x014e:
            r11 = 0
        L_0x014f:
            java.lang.Object r12 = r1.rememberedValue()
            r15 = 0
            if (r11 != 0) goto L_0x015e
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0169
        L_0x015e:
            androidx.compose.material3.SliderDefaults$Thumb$1$1 r11 = new androidx.compose.material3.SliderDefaults$Thumb$1$1
            r11.<init>(r2, r6, r15)
            r12 = r11
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r1.updateRememberedValue(r12)
        L_0x0169:
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r1.endReplaceableGroup()
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r12, (androidx.compose.runtime.Composer) r1, (int) r0)
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r0 = r6.isEmpty()
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x017f
            float r0 = androidx.compose.material3.SliderKt.ThumbPressedElevation
            goto L_0x0183
        L_0x017f:
            float r0 = androidx.compose.material3.SliderKt.ThumbDefaultElevation
        L_0x0183:
            androidx.compose.material3.tokens.SliderTokens r5 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r5 = r5.getHandleShape()
            r6 = 6
            androidx.compose.ui.graphics.Shape r5 = androidx.compose.material3.ShapesKt.getValue(r5, r1, r6)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m743size6HolHcs(r7, r13)
            r12 = r2
            androidx.compose.foundation.interaction.InteractionSource r12 = (androidx.compose.foundation.interaction.InteractionSource) r12
            androidx.compose.material3.tokens.SliderTokens r11 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r11 = r11.m3139getStateLayerSizeD9Ej5fM()
            r15 = 2
            float r4 = (float) r15
            float r11 = r11 / r4
            float r4 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r11)
            r16 = 54
            r17 = 4
            r11 = 0
            r18 = 0
            r15 = r12
            r12 = r4
            r26 = r13
            r13 = r18
            r4 = r15
            r15 = r1
            androidx.compose.foundation.Indication r11 = androidx.compose.material.ripple.RippleKt.m1491rememberRipple9IZ8Weo(r11, r12, r13, r15, r16, r17)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.IndicationKt.indication(r6, r4, r11)
            r6 = 0
            r11 = 0
            r12 = 2
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.HoverableKt.hoverable$default(r4, r2, r11, r12, r6)
            if (r3 == 0) goto L_0x01c3
            goto L_0x01c8
        L_0x01c3:
            float r0 = (float) r11
            float r0 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r0)
        L_0x01c8:
            r17 = r0
            r24 = 24
            r25 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r18 = r5
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ShadowKt.m3472shadows4CzXII$default(r16, r17, r18, r19, r20, r22, r24, r25)
            long r11 = r9.m2186thumbColorvNxB06k$material3_release(r3)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m213backgroundbw27NRU(r0, r11, r5)
            r4 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r1, r4)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ef
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ef:
            r5 = r3
            r3 = r7
            r4 = r9
            r6 = r26
        L_0x01f4:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x020d
            androidx.compose.material3.SliderDefaults$Thumb$2 r12 = new androidx.compose.material3.SliderDefaults$Thumb$2
            r0 = r12
            r1 = r28
            r2 = r29
            r8 = r36
            r9 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r9)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x020d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.m2191Thumb9LiSoMs(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(message = "Use version that supports slider state")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Track(androidx.compose.material3.SliderPositions r22, androidx.compose.ui.Modifier r23, androidx.compose.material3.SliderColors r24, boolean r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r21 = this;
            r8 = r21
            r6 = r27
            r0 = -1546713545(0xffffffffa3cf0637, float:-2.2445617E-17)
            r1 = r26
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Track)P(3,2)1043@44335L8,1054@44796L1870,1050@44688L1978:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r28 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r6 | 6
            r4 = r2
            r2 = r22
            goto L_0x0030
        L_0x001c:
            r2 = r6 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r22
            boolean r4 = r1.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r6
            goto L_0x0030
        L_0x002d:
            r2 = r22
            r4 = r6
        L_0x0030:
            r5 = r28 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r7 = r6 & 48
            if (r7 != 0) goto L_0x004a
            r7 = r23
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r4 = r4 | r9
            goto L_0x004c
        L_0x004a:
            r7 = r23
        L_0x004c:
            r9 = r6 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0065
            r9 = r28 & 4
            if (r9 != 0) goto L_0x005f
            r9 = r24
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0061
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r9 = r24
        L_0x0061:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r10
            goto L_0x0067
        L_0x0065:
            r9 = r24
        L_0x0067:
            r10 = r28 & 8
            if (r10 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r11 = r6 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0081
            r11 = r25
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r12
            goto L_0x0083
        L_0x0081:
            r11 = r25
        L_0x0083:
            r12 = r28 & 16
            if (r12 == 0) goto L_0x008a
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x008a:
            r12 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009a
            boolean r12 = r1.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r4 = r4 | r12
        L_0x009a:
            r12 = r4 & 9363(0x2493, float:1.312E-41)
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00b0
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x00a7
            goto L_0x00b0
        L_0x00a7:
            r1.skipToGroupEnd()
            r2 = r1
            r3 = r7
            r4 = r9
            r5 = r11
            goto L_0x0189
        L_0x00b0:
            r1.startDefaults()
            r12 = r6 & 1
            r13 = 1
            if (r12 == 0) goto L_0x00d0
            boolean r12 = r1.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00bf
            goto L_0x00d0
        L_0x00bf:
            r1.skipToGroupEnd()
            r5 = r28 & 4
            if (r5 == 0) goto L_0x00c8
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c8:
            r5 = r7
        L_0x00c9:
            r7 = r11
        L_0x00ca:
            r20 = r9
            r9 = r4
            r4 = r20
            goto L_0x00eb
        L_0x00d0:
            if (r5 == 0) goto L_0x00d7
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x00d8
        L_0x00d7:
            r5 = r7
        L_0x00d8:
            r7 = r28 & 4
            if (r7 == 0) goto L_0x00e7
            int r7 = r4 >> 12
            r7 = r7 & 14
            androidx.compose.material3.SliderColors r7 = r8.colors(r1, r7)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r7
        L_0x00e7:
            if (r10 == 0) goto L_0x00c9
            r7 = r13
            goto L_0x00ca
        L_0x00eb:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00fa
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1045)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r10, r11)
        L_0x00fa:
            r0 = 0
            long r10 = r4.m2188trackColorWaAFU9c$material3_release(r7, r0)
            long r14 = r4.m2188trackColorWaAFU9c$material3_release(r7, r13)
            r23 = r14
            long r14 = r4.m2187tickColorWaAFU9c$material3_release(r7, r0)
            r26 = r1
            long r0 = r4.m2187tickColorWaAFU9c$material3_release(r7, r13)
            r12 = 0
            r3 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r12, r13, r3)
            float r12 = androidx.compose.material3.SliderKt.getTrackHeight()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r3, r12)
            r12 = -1134219991(0xffffffffbc652d29, float:-0.013987818)
            r2 = r26
            r2.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            boolean r12 = r2.changed((long) r10)
            r9 = r9 & 14
            r13 = 4
            if (r9 != r13) goto L_0x0135
            r13 = 1
            goto L_0x0136
        L_0x0135:
            r13 = 0
        L_0x0136:
            r9 = r12 | r13
            r12 = r23
            boolean r16 = r2.changed((long) r12)
            r9 = r9 | r16
            boolean r16 = r2.changed((long) r14)
            r9 = r9 | r16
            boolean r16 = r2.changed((long) r0)
            r9 = r9 | r16
            r23 = r4
            java.lang.Object r4 = r2.rememberedValue()
            if (r9 != 0) goto L_0x015c
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x0173
        L_0x015c:
            androidx.compose.material3.SliderDefaults$Track$1$1 r4 = new androidx.compose.material3.SliderDefaults$Track$1$1
            r9 = r4
            r16 = r12
            r12 = r22
            r18 = r14
            r13 = r16
            r15 = r18
            r17 = r0
            r9.<init>(r10, r12, r13, r15, r17)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r2.updateRememberedValue(r4)
        L_0x0173:
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r2.endReplaceableGroup()
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r3, r4, r2, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0185
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0185:
            r4 = r23
            r3 = r5
            r5 = r7
        L_0x0189:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x01a2
            androidx.compose.material3.SliderDefaults$Track$2 r10 = new androidx.compose.material3.SliderDefaults$Track$2
            r0 = r10
            r1 = r21
            r2 = r22
            r6 = r27
            r7 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderPositions, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Track(androidx.compose.material3.SliderState r23, androidx.compose.ui.Modifier r24, androidx.compose.material3.SliderColors r25, boolean r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r22 = this;
            r8 = r22
            r6 = r28
            r0 = 593554206(0x2360eb1e, float:1.2192852E-17)
            r1 = r27
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Track)P(3,2)1121@47426L8,1132@47886L300,1128@47778L408:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r29 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r6 | 6
            r4 = r2
            r2 = r23
            goto L_0x0030
        L_0x001c:
            r2 = r6 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r23
            boolean r4 = r1.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r6
            goto L_0x0030
        L_0x002d:
            r2 = r23
            r4 = r6
        L_0x0030:
            r5 = r29 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r7 = r6 & 48
            if (r7 != 0) goto L_0x004a
            r7 = r24
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r4 = r4 | r9
            goto L_0x004c
        L_0x004a:
            r7 = r24
        L_0x004c:
            r9 = r6 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0065
            r9 = r29 & 4
            if (r9 != 0) goto L_0x005f
            r9 = r25
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0061
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r9 = r25
        L_0x0061:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r10
            goto L_0x0067
        L_0x0065:
            r9 = r25
        L_0x0067:
            r10 = r29 & 8
            if (r10 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r11 = r6 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0081
            r11 = r26
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r12
            goto L_0x0083
        L_0x0081:
            r11 = r26
        L_0x0083:
            r12 = r29 & 16
            if (r12 == 0) goto L_0x008a
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x008a:
            r12 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009a
            boolean r12 = r1.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r4 = r4 | r12
        L_0x009a:
            r12 = r4 & 9363(0x2493, float:1.312E-41)
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00b0
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x00a7
            goto L_0x00b0
        L_0x00a7:
            r1.skipToGroupEnd()
            r2 = r1
            r3 = r7
            r4 = r9
            r5 = r11
            goto L_0x0184
        L_0x00b0:
            r1.startDefaults()
            r12 = r6 & 1
            r13 = 1
            if (r12 == 0) goto L_0x00d0
            boolean r12 = r1.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00bf
            goto L_0x00d0
        L_0x00bf:
            r1.skipToGroupEnd()
            r5 = r29 & 4
            if (r5 == 0) goto L_0x00c8
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c8:
            r5 = r7
        L_0x00c9:
            r7 = r11
        L_0x00ca:
            r21 = r9
            r9 = r4
            r4 = r21
            goto L_0x00eb
        L_0x00d0:
            if (r5 == 0) goto L_0x00d7
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x00d8
        L_0x00d7:
            r5 = r7
        L_0x00d8:
            r7 = r29 & 4
            if (r7 == 0) goto L_0x00e7
            int r7 = r4 >> 12
            r7 = r7 & 14
            androidx.compose.material3.SliderColors r7 = r8.colors(r1, r7)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r7
        L_0x00e7:
            if (r10 == 0) goto L_0x00c9
            r7 = r13
            goto L_0x00ca
        L_0x00eb:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00fa
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1123)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r10, r11)
        L_0x00fa:
            r0 = 0
            long r11 = r4.m2188trackColorWaAFU9c$material3_release(r7, r0)
            long r14 = r4.m2188trackColorWaAFU9c$material3_release(r7, r13)
            r24 = r14
            long r14 = r4.m2187tickColorWaAFU9c$material3_release(r7, r0)
            r27 = r1
            long r0 = r4.m2187tickColorWaAFU9c$material3_release(r7, r13)
            r10 = 0
            r3 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r10, r13, r3)
            float r10 = androidx.compose.material3.SliderKt.getTrackHeight()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r3, r10)
            r10 = -1134216901(0xffffffffbc65393b, float:-0.013990696)
            r2 = r27
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            r9 = r9 & 14
            r10 = 4
            if (r9 != r10) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r13 = 0
        L_0x0131:
            boolean r9 = r2.changed((long) r11)
            r9 = r9 | r13
            r19 = r4
            r27 = r5
            r4 = r24
            boolean r10 = r2.changed((long) r4)
            r9 = r9 | r10
            boolean r10 = r2.changed((long) r14)
            r9 = r9 | r10
            boolean r10 = r2.changed((long) r0)
            r9 = r9 | r10
            java.lang.Object r10 = r2.rememberedValue()
            if (r9 != 0) goto L_0x0159
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x016d
        L_0x0159:
            androidx.compose.material3.SliderDefaults$Track$3$1 r20 = new androidx.compose.material3.SliderDefaults$Track$3$1
            r9 = r20
            r10 = r23
            r15 = r14
            r13 = r4
            r17 = r0
            r9.<init>(r10, r11, r13, r15, r17)
            r10 = r20
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.updateRememberedValue(r10)
        L_0x016d:
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.endReplaceableGroup()
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r3, r10, r2, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017f:
            r3 = r27
            r5 = r7
            r4 = r19
        L_0x0184:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x019d
            androidx.compose.material3.SliderDefaults$Track$4 r10 = new androidx.compose.material3.SliderDefaults$Track$4
            r0 = r10
            r1 = r22
            r2 = r23
            r6 = r28
            r7 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Track(androidx.compose.material3.RangeSliderState r23, androidx.compose.ui.Modifier r24, androidx.compose.material3.SliderColors r25, boolean r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r22 = this;
            r8 = r22
            r6 = r28
            r0 = -1617869097(0xffffffff9f9146d7, float:-6.1527083E-20)
            r1 = r27
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Track)P(3,2)1161@48985L8,1172@49445L367,1168@49337L475:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r29 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r6 | 6
            r4 = r2
            r2 = r23
            goto L_0x0030
        L_0x001c:
            r2 = r6 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r23
            boolean r4 = r1.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r6
            goto L_0x0030
        L_0x002d:
            r2 = r23
            r4 = r6
        L_0x0030:
            r5 = r29 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            goto L_0x004a
        L_0x0037:
            r7 = r6 & 48
            if (r7 != 0) goto L_0x004a
            r7 = r24
            boolean r9 = r1.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x0046
            r9 = 32
            goto L_0x0048
        L_0x0046:
            r9 = 16
        L_0x0048:
            r4 = r4 | r9
            goto L_0x004c
        L_0x004a:
            r7 = r24
        L_0x004c:
            r9 = r6 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0065
            r9 = r29 & 4
            if (r9 != 0) goto L_0x005f
            r9 = r25
            boolean r10 = r1.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0061
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r9 = r25
        L_0x0061:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r10
            goto L_0x0067
        L_0x0065:
            r9 = r25
        L_0x0067:
            r10 = r29 & 8
            if (r10 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r11 = r6 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0081
            r11 = r26
            boolean r12 = r1.changed((boolean) r11)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r12
            goto L_0x0083
        L_0x0081:
            r11 = r26
        L_0x0083:
            r12 = r29 & 16
            if (r12 == 0) goto L_0x008a
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x008a:
            r12 = r6 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009a
            boolean r12 = r1.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x0097
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r4 = r4 | r12
        L_0x009a:
            r12 = r4 & 9363(0x2493, float:1.312E-41)
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00b0
            boolean r12 = r1.getSkipping()
            if (r12 != 0) goto L_0x00a7
            goto L_0x00b0
        L_0x00a7:
            r1.skipToGroupEnd()
            r2 = r1
            r3 = r7
            r4 = r9
            r5 = r11
            goto L_0x0184
        L_0x00b0:
            r1.startDefaults()
            r12 = r6 & 1
            r13 = 1
            if (r12 == 0) goto L_0x00d0
            boolean r12 = r1.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00bf
            goto L_0x00d0
        L_0x00bf:
            r1.skipToGroupEnd()
            r5 = r29 & 4
            if (r5 == 0) goto L_0x00c8
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00c8:
            r5 = r7
        L_0x00c9:
            r7 = r11
        L_0x00ca:
            r21 = r9
            r9 = r4
            r4 = r21
            goto L_0x00eb
        L_0x00d0:
            if (r5 == 0) goto L_0x00d7
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x00d8
        L_0x00d7:
            r5 = r7
        L_0x00d8:
            r7 = r29 & 4
            if (r7 == 0) goto L_0x00e7
            int r7 = r4 >> 12
            r7 = r7 & 14
            androidx.compose.material3.SliderColors r7 = r8.colors(r1, r7)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r9 = r7
        L_0x00e7:
            if (r10 == 0) goto L_0x00c9
            r7 = r13
            goto L_0x00ca
        L_0x00eb:
            r1.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x00fa
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1163)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r10, r11)
        L_0x00fa:
            r0 = 0
            long r11 = r4.m2188trackColorWaAFU9c$material3_release(r7, r0)
            long r14 = r4.m2188trackColorWaAFU9c$material3_release(r7, r13)
            r24 = r14
            long r14 = r4.m2187tickColorWaAFU9c$material3_release(r7, r0)
            r27 = r1
            long r0 = r4.m2187tickColorWaAFU9c$material3_release(r7, r13)
            r10 = 0
            r3 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r10, r13, r3)
            float r10 = androidx.compose.material3.SliderKt.getTrackHeight()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r3, r10)
            r10 = -1134215342(0xffffffffbc653f52, float:-0.0139921475)
            r2 = r27
            r2.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember):Slider.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r10)
            r9 = r9 & 14
            r10 = 4
            if (r9 != r10) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r13 = 0
        L_0x0131:
            boolean r9 = r2.changed((long) r11)
            r9 = r9 | r13
            r19 = r4
            r27 = r5
            r4 = r24
            boolean r10 = r2.changed((long) r4)
            r9 = r9 | r10
            boolean r10 = r2.changed((long) r14)
            r9 = r9 | r10
            boolean r10 = r2.changed((long) r0)
            r9 = r9 | r10
            java.lang.Object r10 = r2.rememberedValue()
            if (r9 != 0) goto L_0x0159
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x016d
        L_0x0159:
            androidx.compose.material3.SliderDefaults$Track$5$1 r20 = new androidx.compose.material3.SliderDefaults$Track$5$1
            r9 = r20
            r10 = r23
            r15 = r14
            r13 = r4
            r17 = r0
            r9.<init>(r10, r11, r13, r15, r17)
            r10 = r20
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.updateRememberedValue(r10)
        L_0x016d:
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r2.endReplaceableGroup()
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r3, r10, r2, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017f:
            r3 = r27
            r5 = r7
            r4 = r19
        L_0x0184:
            androidx.compose.runtime.ScopeUpdateScope r9 = r2.endRestartGroup()
            if (r9 == 0) goto L_0x019d
            androidx.compose.material3.SliderDefaults$Track$6 r10 = new androidx.compose.material3.SliderDefaults$Track$6
            r0 = r10
            r1 = r22
            r2 = r23
            r6 = r28
            r7 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawTrack-LUBghH0  reason: not valid java name */
    public final void m2190drawTrackLUBghH0(DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4) {
        long j5;
        long j6;
        DrawScope drawScope2 = drawScope;
        float[] fArr2 = fArr;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(0.0f, Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0()));
        long j7 = z ? Offset2 : Offset;
        long j8 = z ? Offset : Offset2;
        float r17 = drawScope2.m6550toPx0680j_4(SliderKt.TickSize);
        float r7 = drawScope2.m6550toPx0680j_4(SliderKt.getTrackHeight());
        long j9 = j8;
        long j10 = j7;
        float[] fArr3 = fArr2;
        DrawScope.CC.m4462drawLineNGM6Ib0$default(drawScope, j, j7, j8, r7, StrokeCap.Companion.m4231getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, MainPresenterKt.EIGHT_HOURS_IN_MINUTES, (Object) null);
        DrawScope.CC.m4462drawLineNGM6Ib0$default(drawScope, j2, OffsetKt.Offset(Offset.m3562getXimpl(j10) + ((Offset.m3562getXimpl(j9) - Offset.m3562getXimpl(j10)) * f), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3562getXimpl(j10) + ((Offset.m3562getXimpl(j9) - Offset.m3562getXimpl(j10)) * f2), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0())), r7, StrokeCap.Companion.m4231getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, MainPresenterKt.EIGHT_HOURS_IN_MINUTES, (Object) null);
        int length = fArr3.length;
        int i = 0;
        while (i < length) {
            float f3 = fArr3[i];
            if (f3 > f2 || f3 < f) {
                j5 = j9;
                j6 = j3;
            } else {
                j5 = j9;
                j6 = j4;
            }
            long j11 = j10;
            DrawScope.CC.m4457drawCircleVaOC9Bg$default(drawScope, j6, r17 / 2.0f, OffsetKt.Offset(Offset.m3562getXimpl(OffsetKt.m3585lerpWko1d7g(j11, j5, f3)), Offset.m3563getYimpl(drawScope.m4433getCenterF1C5BW0())), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
            i++;
            j9 = j5;
            j10 = j11;
        }
    }
}
