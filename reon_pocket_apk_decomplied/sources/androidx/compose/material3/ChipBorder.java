package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/ChipBorder;", "", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "borderStroke", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "borderStroke$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the chipBorder functions instead")
/* compiled from: Chip.kt */
public final class ChipBorder {
    public static final int $stable = 0;
    private final long borderColor;
    private final float borderWidth;
    private final long disabledBorderColor;

    public /* synthetic */ ChipBorder(long j, long j2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, f);
    }

    private ChipBorder(long j, long j2, float f) {
        this.borderColor = j;
        this.disabledBorderColor = j2;
        this.borderWidth = f;
    }

    public final State<BorderStroke> borderStroke$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(1899621712);
        ComposerKt.sourceInformation(composer, "C(borderStroke)2678@125915L120:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899621712, i, -1, "androidx.compose.material3.ChipBorder.borderStroke (Chip.kt:2677)");
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m241BorderStrokecXLIe8U(this.borderWidth, z ? this.borderColor : this.disabledBorderColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChipBorder)) {
            return false;
        }
        ChipBorder chipBorder = (ChipBorder) obj;
        return Color.m3817equalsimpl0(this.borderColor, chipBorder.borderColor) && Color.m3817equalsimpl0(this.disabledBorderColor, chipBorder.disabledBorderColor) && Dp.m6619equalsimpl0(this.borderWidth, chipBorder.borderWidth);
    }

    public int hashCode() {
        return (((Color.m3823hashCodeimpl(this.borderColor) * 31) + Color.m3823hashCodeimpl(this.disabledBorderColor)) * 31) + Dp.m6620hashCodeimpl(this.borderWidth);
    }
}
