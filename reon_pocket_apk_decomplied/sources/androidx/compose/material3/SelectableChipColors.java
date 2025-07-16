package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0001\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J%\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010 J%\u0010#\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010 R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\r\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/material3/SelectableChipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "containerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "copy", "copy-daRQuJA", "(JJJJJJJJJJJJJ)Landroidx/compose/material3/SelectableChipColors;", "equals", "other", "hashCode", "", "labelColor-WaAFU9c$material3_release", "(ZZ)J", "leadingIconContentColor", "leadingIconContentColor-WaAFU9c$material3_release", "trailingIconContentColor", "trailingIconContentColor-WaAFU9c$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class SelectableChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;

    public /* synthetic */ SelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13);
    }

    private SelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        this.containerColor = j;
        this.labelColor = j2;
        this.leadingIconColor = j3;
        this.trailingIconColor = j4;
        this.disabledContainerColor = j5;
        this.disabledLabelColor = j6;
        this.disabledLeadingIconColor = j7;
        this.disabledTrailingIconColor = j8;
        this.selectedContainerColor = j9;
        this.disabledSelectedContainerColor = j10;
        this.selectedLabelColor = j11;
        this.selectedLeadingIconColor = j12;
        this.selectedTrailingIconColor = j13;
    }

    /* renamed from: copy-daRQuJA$default  reason: not valid java name */
    public static /* synthetic */ SelectableChipColors m2147copydaRQuJA$default(SelectableChipColors selectableChipColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i, Object obj) {
        long j14;
        SelectableChipColors selectableChipColors2 = selectableChipColors;
        int i2 = i;
        long j15 = (i2 & 1) != 0 ? selectableChipColors2.containerColor : j;
        long j16 = (i2 & 2) != 0 ? selectableChipColors2.labelColor : j2;
        long j17 = (i2 & 4) != 0 ? selectableChipColors2.leadingIconColor : j3;
        long j18 = (i2 & 8) != 0 ? selectableChipColors2.trailingIconColor : j4;
        long j19 = (i2 & 16) != 0 ? selectableChipColors2.disabledContainerColor : j5;
        long j20 = (i2 & 32) != 0 ? selectableChipColors2.disabledLabelColor : j6;
        long j21 = (i2 & 64) != 0 ? selectableChipColors2.disabledLeadingIconColor : j7;
        long j22 = (i2 & 128) != 0 ? selectableChipColors2.disabledTrailingIconColor : j8;
        long j23 = (i2 & 256) != 0 ? selectableChipColors2.selectedContainerColor : j9;
        long j24 = (i2 & 512) != 0 ? selectableChipColors2.disabledSelectedContainerColor : j10;
        long j25 = (i2 & 1024) != 0 ? selectableChipColors2.selectedLabelColor : j11;
        long j26 = (i2 & 2048) != 0 ? selectableChipColors2.selectedLeadingIconColor : j12;
        if ((i2 & 4096) != 0) {
            j14 = selectableChipColors2.selectedTrailingIconColor;
        } else {
            j14 = j13;
        }
        return selectableChipColors.m2148copydaRQuJA(j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j14);
    }

    public final State<Color> containerColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-2126903408);
        ComposerKt.sourceInformation(composer, "C(containerColor)2572@121754L28:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2126903408, i, -1, "androidx.compose.material3.SelectableChipColors.containerColor (Chip.kt:2566)");
        }
        if (!z) {
            j = z2 ? this.disabledSelectedContainerColor : this.disabledContainerColor;
        } else if (!z2) {
            j = this.containerColor;
        } else {
            j = this.selectedContainerColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: labelColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2149labelColorWaAFU9c$material3_release(boolean z, boolean z2) {
        if (!z) {
            return this.disabledLabelColor;
        }
        if (!z2) {
            return this.labelColor;
        }
        return this.selectedLabelColor;
    }

    /* renamed from: leadingIconContentColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2150leadingIconContentColorWaAFU9c$material3_release(boolean z, boolean z2) {
        if (!z) {
            return this.disabledLeadingIconColor;
        }
        if (!z2) {
            return this.leadingIconColor;
        }
        return this.selectedLeadingIconColor;
    }

    /* renamed from: trailingIconContentColor-WaAFU9c$material3_release  reason: not valid java name */
    public final long m2151trailingIconContentColorWaAFU9c$material3_release(boolean z, boolean z2) {
        if (!z) {
            return this.disabledTrailingIconColor;
        }
        if (!z2) {
            return this.trailingIconColor;
        }
        return this.selectedTrailingIconColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SelectableChipColors)) {
            return false;
        }
        SelectableChipColors selectableChipColors = (SelectableChipColors) obj;
        return Color.m3817equalsimpl0(this.containerColor, selectableChipColors.containerColor) && Color.m3817equalsimpl0(this.labelColor, selectableChipColors.labelColor) && Color.m3817equalsimpl0(this.leadingIconColor, selectableChipColors.leadingIconColor) && Color.m3817equalsimpl0(this.trailingIconColor, selectableChipColors.trailingIconColor) && Color.m3817equalsimpl0(this.disabledContainerColor, selectableChipColors.disabledContainerColor) && Color.m3817equalsimpl0(this.disabledLabelColor, selectableChipColors.disabledLabelColor) && Color.m3817equalsimpl0(this.disabledLeadingIconColor, selectableChipColors.disabledLeadingIconColor) && Color.m3817equalsimpl0(this.disabledTrailingIconColor, selectableChipColors.disabledTrailingIconColor) && Color.m3817equalsimpl0(this.selectedContainerColor, selectableChipColors.selectedContainerColor) && Color.m3817equalsimpl0(this.disabledSelectedContainerColor, selectableChipColors.disabledSelectedContainerColor) && Color.m3817equalsimpl0(this.selectedLabelColor, selectableChipColors.selectedLabelColor) && Color.m3817equalsimpl0(this.selectedLeadingIconColor, selectableChipColors.selectedLeadingIconColor) && Color.m3817equalsimpl0(this.selectedTrailingIconColor, selectableChipColors.selectedTrailingIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Color.m3823hashCodeimpl(this.containerColor) * 31) + Color.m3823hashCodeimpl(this.labelColor)) * 31) + Color.m3823hashCodeimpl(this.leadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.trailingIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m3823hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m3823hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m3823hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m3823hashCodeimpl(this.disabledSelectedContainerColor)) * 31) + Color.m3823hashCodeimpl(this.selectedLabelColor)) * 31) + Color.m3823hashCodeimpl(this.selectedLeadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.selectedTrailingIconColor);
    }

    /* renamed from: copy-daRQuJA  reason: not valid java name */
    public final SelectableChipColors m2148copydaRQuJA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        return new SelectableChipColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.containerColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.labelColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.leadingIconColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.trailingIconColor, j5 != Color.Companion.m3852getUnspecified0d7_KjU() ? j5 : this.disabledContainerColor, j6 != Color.Companion.m3852getUnspecified0d7_KjU() ? j6 : this.disabledLabelColor, j7 != Color.Companion.m3852getUnspecified0d7_KjU() ? j7 : this.disabledLeadingIconColor, j8 != Color.Companion.m3852getUnspecified0d7_KjU() ? j8 : this.disabledTrailingIconColor, j9 != Color.Companion.m3852getUnspecified0d7_KjU() ? j9 : this.selectedContainerColor, j10 != Color.Companion.m3852getUnspecified0d7_KjU() ? j10 : this.disabledSelectedContainerColor, j11 != Color.Companion.m3852getUnspecified0d7_KjU() ? j11 : this.selectedLabelColor, j12 != Color.Companion.m3852getUnspecified0d7_KjU() ? j12 : this.selectedLeadingIconColor, j13 != Color.Companion.m3852getUnspecified0d7_KjU() ? j13 : this.selectedTrailingIconColor, (DefaultConstructorMarker) null);
    }
}
