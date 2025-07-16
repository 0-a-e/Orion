package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011J8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/IconButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "enabled", "", "containerColor-vNxB06k$material3_release", "(Z)J", "contentColor-vNxB06k$material3_release", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/IconButtonColors;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconButtonColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ IconButtonColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private IconButtonColors(long j, long j2, long j3, long j4) {
        this.containerColor = j;
        this.contentColor = j2;
        this.disabledContainerColor = j3;
        this.disabledContentColor = j4;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1889getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getContentColor-0d7_KjU  reason: not valid java name */
    public final long m1890getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1891getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: getDisabledContentColor-0d7_KjU  reason: not valid java name */
    public final long m1892getDisabledContentColor0d7_KjU() {
        return this.disabledContentColor;
    }

    /* renamed from: copy-jRlVdoo$default  reason: not valid java name */
    public static /* synthetic */ IconButtonColors m1885copyjRlVdoo$default(IconButtonColors iconButtonColors, long j, long j2, long j3, long j4, int i, Object obj) {
        IconButtonColors iconButtonColors2 = iconButtonColors;
        return iconButtonColors.m1888copyjRlVdoo((i & 1) != 0 ? iconButtonColors2.containerColor : j, (i & 2) != 0 ? iconButtonColors2.contentColor : j2, (i & 4) != 0 ? iconButtonColors2.disabledContainerColor : j3, (i & 8) != 0 ? iconButtonColors2.disabledContentColor : j4);
    }

    /* renamed from: containerColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m1886containerColorvNxB06k$material3_release(boolean z) {
        return z ? this.containerColor : this.disabledContainerColor;
    }

    /* renamed from: contentColor-vNxB06k$material3_release  reason: not valid java name */
    public final long m1887contentColorvNxB06k$material3_release(boolean z) {
        return z ? this.contentColor : this.disabledContentColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IconButtonColors)) {
            return false;
        }
        IconButtonColors iconButtonColors = (IconButtonColors) obj;
        return Color.m3817equalsimpl0(this.containerColor, iconButtonColors.containerColor) && Color.m3817equalsimpl0(this.contentColor, iconButtonColors.contentColor) && Color.m3817equalsimpl0(this.disabledContainerColor, iconButtonColors.disabledContainerColor) && Color.m3817equalsimpl0(this.disabledContentColor, iconButtonColors.disabledContentColor);
    }

    public int hashCode() {
        return (((((Color.m3823hashCodeimpl(this.containerColor) * 31) + Color.m3823hashCodeimpl(this.contentColor)) * 31) + Color.m3823hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m3823hashCodeimpl(this.disabledContentColor);
    }

    /* renamed from: copy-jRlVdoo  reason: not valid java name */
    public final IconButtonColors m1888copyjRlVdoo(long j, long j2, long j3, long j4) {
        return new IconButtonColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.containerColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.contentColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.disabledContainerColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.disabledContentColor, (DefaultConstructorMarker) null);
    }
}
