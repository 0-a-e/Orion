package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/RichTooltipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "titleContentColor", "actionContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionContentColor-0d7_KjU", "()J", "J", "getContainerColor-0d7_KjU", "getContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RichTooltipColors;", "equals", "", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
public final class RichTooltipColors {
    public static final int $stable = 0;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;

    public /* synthetic */ RichTooltipColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private RichTooltipColors(long j, long j2, long j3, long j4) {
        this.containerColor = j;
        this.contentColor = j2;
        this.titleContentColor = j3;
        this.actionContentColor = j4;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m2094getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getContentColor-0d7_KjU  reason: not valid java name */
    public final long m2095getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU  reason: not valid java name */
    public final long m2096getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    /* renamed from: getActionContentColor-0d7_KjU  reason: not valid java name */
    public final long m2093getActionContentColor0d7_KjU() {
        return this.actionContentColor;
    }

    /* renamed from: copy-jRlVdoo$default  reason: not valid java name */
    public static /* synthetic */ RichTooltipColors m2091copyjRlVdoo$default(RichTooltipColors richTooltipColors, long j, long j2, long j3, long j4, int i, Object obj) {
        RichTooltipColors richTooltipColors2 = richTooltipColors;
        return richTooltipColors.m2092copyjRlVdoo((i & 1) != 0 ? richTooltipColors2.containerColor : j, (i & 2) != 0 ? richTooltipColors2.contentColor : j2, (i & 4) != 0 ? richTooltipColors2.titleContentColor : j3, (i & 8) != 0 ? richTooltipColors2.actionContentColor : j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RichTooltipColors)) {
            return false;
        }
        RichTooltipColors richTooltipColors = (RichTooltipColors) obj;
        return Color.m3817equalsimpl0(this.containerColor, richTooltipColors.containerColor) && Color.m3817equalsimpl0(this.contentColor, richTooltipColors.contentColor) && Color.m3817equalsimpl0(this.titleContentColor, richTooltipColors.titleContentColor) && Color.m3817equalsimpl0(this.actionContentColor, richTooltipColors.actionContentColor);
    }

    public int hashCode() {
        return (((((Color.m3823hashCodeimpl(this.containerColor) * 31) + Color.m3823hashCodeimpl(this.contentColor)) * 31) + Color.m3823hashCodeimpl(this.titleContentColor)) * 31) + Color.m3823hashCodeimpl(this.actionContentColor);
    }

    /* renamed from: copy-jRlVdoo  reason: not valid java name */
    public final RichTooltipColors m2092copyjRlVdoo(long j, long j2, long j3, long j4) {
        return new RichTooltipColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.containerColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.contentColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.titleContentColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.actionContentColor, (DefaultConstructorMarker) null);
    }
}
