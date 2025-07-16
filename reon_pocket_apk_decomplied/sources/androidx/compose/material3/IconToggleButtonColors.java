package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0017J\u0013\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/IconToggleButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedContainerColor-0d7_KjU", "()J", "J", "getCheckedContentColor-0d7_KjU", "getContainerColor-0d7_KjU", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "containerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor$material3_release", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconToggleButtonColors {
    public static final int $stable = 0;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ IconToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private IconToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.containerColor = j;
        this.contentColor = j2;
        this.disabledContainerColor = j3;
        this.disabledContentColor = j4;
        this.checkedContainerColor = j5;
        this.checkedContentColor = j6;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1907getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getContentColor-0d7_KjU  reason: not valid java name */
    public final long m1908getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1909getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: getDisabledContentColor-0d7_KjU  reason: not valid java name */
    public final long m1910getDisabledContentColor0d7_KjU() {
        return this.disabledContentColor;
    }

    /* renamed from: getCheckedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1905getCheckedContainerColor0d7_KjU() {
        return this.checkedContainerColor;
    }

    /* renamed from: getCheckedContentColor-0d7_KjU  reason: not valid java name */
    public final long m1906getCheckedContentColor0d7_KjU() {
        return this.checkedContentColor;
    }

    public final State<Color> containerColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(1175394478);
        ComposerKt.sourceInformation(composer, "C(containerColor)P(1)956@45271L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1175394478, i, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:950)");
        }
        if (!z) {
            j = this.disabledContainerColor;
        } else if (!z2) {
            j = this.containerColor;
        } else {
            j = this.checkedContainerColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public final State<Color> contentColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(1340854054);
        ComposerKt.sourceInformation(composer, "C(contentColor)P(1)972@45813L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1340854054, i, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:966)");
        }
        if (!z) {
            j = this.disabledContentColor;
        } else if (!z2) {
            j = this.contentColor;
        } else {
            j = this.checkedContentColor;
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j), composer, 0);
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
        if (obj == null || !(obj instanceof IconToggleButtonColors)) {
            return false;
        }
        IconToggleButtonColors iconToggleButtonColors = (IconToggleButtonColors) obj;
        return Color.m3817equalsimpl0(this.containerColor, iconToggleButtonColors.containerColor) && Color.m3817equalsimpl0(this.contentColor, iconToggleButtonColors.contentColor) && Color.m3817equalsimpl0(this.disabledContainerColor, iconToggleButtonColors.disabledContainerColor) && Color.m3817equalsimpl0(this.disabledContentColor, iconToggleButtonColors.disabledContentColor) && Color.m3817equalsimpl0(this.checkedContainerColor, iconToggleButtonColors.checkedContainerColor) && Color.m3817equalsimpl0(this.checkedContentColor, iconToggleButtonColors.checkedContentColor);
    }

    public int hashCode() {
        return (((((((((Color.m3823hashCodeimpl(this.containerColor) * 31) + Color.m3823hashCodeimpl(this.contentColor)) * 31) + Color.m3823hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m3823hashCodeimpl(this.disabledContentColor)) * 31) + Color.m3823hashCodeimpl(this.checkedContainerColor)) * 31) + Color.m3823hashCodeimpl(this.checkedContentColor);
    }
}
