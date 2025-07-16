package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J%\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J°\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0013\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00101\u001a\u000202H\u0016J%\u00103\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010+J%\u00105\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010+J%\u00107\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010+R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0015R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0015R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b#\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0015R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/material3/SwitchColors;", "", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "(JJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedBorderColor-0d7_KjU", "()J", "J", "getCheckedIconColor-0d7_KjU", "getCheckedThumbColor-0d7_KjU", "getCheckedTrackColor-0d7_KjU", "getDisabledCheckedBorderColor-0d7_KjU", "getDisabledCheckedIconColor-0d7_KjU", "getDisabledCheckedThumbColor-0d7_KjU", "getDisabledCheckedTrackColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedIconColor-0d7_KjU", "getDisabledUncheckedThumbColor-0d7_KjU", "getDisabledUncheckedTrackColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedIconColor-0d7_KjU", "getUncheckedThumbColor-0d7_KjU", "getUncheckedTrackColor-0d7_KjU", "borderColor", "enabled", "", "checked", "borderColor-WaAFU9c$material3_release", "(ZZ)J", "copy", "copy-Q_H9qLU", "(JJJJJJJJJJJJJJJJ)Landroidx/compose/material3/SwitchColors;", "equals", "other", "hashCode", "", "iconColor", "iconColor-WaAFU9c$material3_release", "thumbColor", "thumbColor-WaAFU9c$material3_release", "trackColor", "trackColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedIconColor;
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16);
    }

    private SwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.checkedBorderColor = j3;
        this.checkedIconColor = j4;
        this.uncheckedThumbColor = j5;
        this.uncheckedTrackColor = j6;
        this.uncheckedBorderColor = j7;
        this.uncheckedIconColor = j8;
        this.disabledCheckedThumbColor = j9;
        this.disabledCheckedTrackColor = j10;
        this.disabledCheckedBorderColor = j11;
        this.disabledCheckedIconColor = j12;
        this.disabledUncheckedThumbColor = j13;
        this.disabledUncheckedTrackColor = j14;
        this.disabledUncheckedBorderColor = j15;
        this.disabledUncheckedIconColor = j16;
    }

    /* renamed from: getCheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2318getCheckedThumbColor0d7_KjU() {
        return this.checkedThumbColor;
    }

    /* renamed from: getCheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2319getCheckedTrackColor0d7_KjU() {
        return this.checkedTrackColor;
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2316getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* renamed from: getCheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2317getCheckedIconColor0d7_KjU() {
        return this.checkedIconColor;
    }

    /* renamed from: getUncheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2330getUncheckedThumbColor0d7_KjU() {
        return this.uncheckedThumbColor;
    }

    /* renamed from: getUncheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2331getUncheckedTrackColor0d7_KjU() {
        return this.uncheckedTrackColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2328getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getUncheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2329getUncheckedIconColor0d7_KjU() {
        return this.uncheckedIconColor;
    }

    /* renamed from: getDisabledCheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2322getDisabledCheckedThumbColor0d7_KjU() {
        return this.disabledCheckedThumbColor;
    }

    /* renamed from: getDisabledCheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2323getDisabledCheckedTrackColor0d7_KjU() {
        return this.disabledCheckedTrackColor;
    }

    /* renamed from: getDisabledCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2320getDisabledCheckedBorderColor0d7_KjU() {
        return this.disabledCheckedBorderColor;
    }

    /* renamed from: getDisabledCheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2321getDisabledCheckedIconColor0d7_KjU() {
        return this.disabledCheckedIconColor;
    }

    /* renamed from: getDisabledUncheckedThumbColor-0d7_KjU  reason: not valid java name */
    public final long m2326getDisabledUncheckedThumbColor0d7_KjU() {
        return this.disabledUncheckedThumbColor;
    }

    /* renamed from: getDisabledUncheckedTrackColor-0d7_KjU  reason: not valid java name */
    public final long m2327getDisabledUncheckedTrackColor0d7_KjU() {
        return this.disabledUncheckedTrackColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m2324getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledUncheckedIconColor-0d7_KjU  reason: not valid java name */
    public final long m2325getDisabledUncheckedIconColor0d7_KjU() {
        return this.disabledUncheckedIconColor;
    }

    /* renamed from: copy-Q_H9qLU$default  reason: not valid java name */
    public static /* synthetic */ SwitchColors m2313copyQ_H9qLU$default(SwitchColors switchColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i, Object obj) {
        long j17;
        SwitchColors switchColors2 = switchColors;
        int i2 = i;
        long j18 = (i2 & 1) != 0 ? switchColors2.checkedThumbColor : j;
        long j19 = (i2 & 2) != 0 ? switchColors2.checkedTrackColor : j2;
        long j20 = (i2 & 4) != 0 ? switchColors2.checkedBorderColor : j3;
        long j21 = (i2 & 8) != 0 ? switchColors2.checkedIconColor : j4;
        long j22 = (i2 & 16) != 0 ? switchColors2.uncheckedThumbColor : j5;
        long j23 = (i2 & 32) != 0 ? switchColors2.uncheckedTrackColor : j6;
        long j24 = (i2 & 64) != 0 ? switchColors2.uncheckedBorderColor : j7;
        long j25 = (i2 & 128) != 0 ? switchColors2.uncheckedIconColor : j8;
        long j26 = (i2 & 256) != 0 ? switchColors2.disabledCheckedThumbColor : j9;
        long j27 = (i2 & 512) != 0 ? switchColors2.disabledCheckedTrackColor : j10;
        long j28 = (i2 & 1024) != 0 ? switchColors2.disabledCheckedBorderColor : j11;
        long j29 = (i2 & 2048) != 0 ? switchColors2.disabledCheckedIconColor : j12;
        long j30 = (i2 & 4096) != 0 ? switchColors2.disabledUncheckedThumbColor : j13;
        long j31 = (i2 & 8192) != 0 ? switchColors2.disabledUncheckedTrackColor : j14;
        long j32 = (i2 & 16384) != 0 ? switchColors2.disabledUncheckedBorderColor : j15;
        if ((i2 & 32768) != 0) {
            j17 = switchColors2.disabledUncheckedIconColor;
        } else {
            j17 = j16;
        }
        return switchColors.m2315copyQ_H9qLU(j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j17);
    }

    /* renamed from: thumbColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2333thumbColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedThumbColor : this.uncheckedThumbColor : z2 ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
    }

    /* renamed from: trackColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2334trackColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedTrackColor : this.uncheckedTrackColor : z2 ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
    }

    /* renamed from: borderColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2314borderColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedBorderColor : this.uncheckedBorderColor : z2 ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
    }

    /* renamed from: iconColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2332iconColorWaAFU9c$material3_release(boolean z, boolean z2) {
        return z ? z2 ? this.checkedIconColor : this.uncheckedIconColor : z2 ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        return Color.m3817equalsimpl0(this.checkedThumbColor, switchColors.checkedThumbColor) && Color.m3817equalsimpl0(this.checkedTrackColor, switchColors.checkedTrackColor) && Color.m3817equalsimpl0(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.m3817equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && Color.m3817equalsimpl0(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Color.m3817equalsimpl0(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Color.m3817equalsimpl0(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.m3817equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Color.m3817equalsimpl0(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Color.m3817equalsimpl0(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Color.m3817equalsimpl0(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.m3817equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Color.m3817equalsimpl0(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Color.m3817equalsimpl0(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Color.m3817equalsimpl0(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.m3817equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Color.m3823hashCodeimpl(this.checkedThumbColor) * 31) + Color.m3823hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m3823hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m3823hashCodeimpl(this.checkedIconColor)) * 31) + Color.m3823hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m3823hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m3823hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m3823hashCodeimpl(this.uncheckedIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m3823hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m3823hashCodeimpl(this.disabledCheckedBorderColor)) * 31) + Color.m3823hashCodeimpl(this.disabledCheckedIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m3823hashCodeimpl(this.disabledUncheckedTrackColor)) * 31) + Color.m3823hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m3823hashCodeimpl(this.disabledUncheckedIconColor);
    }

    /* renamed from: copy-Q_H9qLU  reason: not valid java name */
    public final SwitchColors m2315copyQ_H9qLU(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        return new SwitchColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.checkedThumbColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.checkedTrackColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.checkedBorderColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.checkedIconColor, j5 != Color.Companion.m3852getUnspecified0d7_KjU() ? j5 : this.uncheckedThumbColor, j6 != Color.Companion.m3852getUnspecified0d7_KjU() ? j6 : this.uncheckedTrackColor, j7 != Color.Companion.m3852getUnspecified0d7_KjU() ? j7 : this.uncheckedBorderColor, j8 != Color.Companion.m3852getUnspecified0d7_KjU() ? j8 : this.uncheckedIconColor, j9 != Color.Companion.m3852getUnspecified0d7_KjU() ? j9 : this.disabledCheckedThumbColor, j10 != Color.Companion.m3852getUnspecified0d7_KjU() ? j10 : this.disabledCheckedTrackColor, j11 != Color.Companion.m3852getUnspecified0d7_KjU() ? j11 : this.disabledCheckedBorderColor, j12 != Color.Companion.m3852getUnspecified0d7_KjU() ? j12 : this.disabledCheckedIconColor, j13 != Color.Companion.m3852getUnspecified0d7_KjU() ? j13 : this.disabledUncheckedThumbColor, j14 != Color.Companion.m3852getUnspecified0d7_KjU() ? j14 : this.disabledUncheckedTrackColor, j15 != Color.Companion.m3852getUnspecified0d7_KjU() ? j15 : this.disabledUncheckedBorderColor, j16 != Color.Companion.m3852getUnspecified0d7_KjU() ? j16 : this.disabledUncheckedIconColor, (DefaultConstructorMarker) null);
    }
}
