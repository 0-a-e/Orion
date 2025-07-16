package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJV\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\"\u0010#J%\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001aH\u0001¢\u0006\u0004\b%\u0010#R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00038@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledIconColor-0d7_KjU", "()J", "J", "getDisabledTextColor-0d7_KjU", "indicatorColor", "getIndicatorColor-0d7_KjU$material3_release", "getSelectedIconColor-0d7_KjU", "getSelectedIndicatorColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "copy", "copy-4JmcsL4", "(JJJJJJJ)Landroidx/compose/material3/NavigationBarItemColors;", "equals", "", "other", "hashCode", "", "iconColor", "Landroidx/compose/runtime/State;", "selected", "enabled", "iconColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor", "textColor$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
public final class NavigationBarItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    private NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.selectedIconColor = j;
        this.selectedTextColor = j2;
        this.selectedIndicatorColor = j3;
        this.unselectedIconColor = j4;
        this.unselectedTextColor = j5;
        this.disabledIconColor = j6;
        this.disabledTextColor = j7;
    }

    /* renamed from: getSelectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m1994getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* renamed from: getSelectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m1996getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* renamed from: getSelectedIndicatorColor-0d7_KjU  reason: not valid java name */
    public final long m1995getSelectedIndicatorColor0d7_KjU() {
        return this.selectedIndicatorColor;
    }

    /* renamed from: getUnselectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m1997getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* renamed from: getUnselectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m1998getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    /* renamed from: getDisabledIconColor-0d7_KjU  reason: not valid java name */
    public final long m1991getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m1992getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: copy-4JmcsL4$default  reason: not valid java name */
    public static /* synthetic */ NavigationBarItemColors m1989copy4JmcsL4$default(NavigationBarItemColors navigationBarItemColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, Object obj) {
        long j8;
        NavigationBarItemColors navigationBarItemColors2 = navigationBarItemColors;
        long j9 = (i & 1) != 0 ? navigationBarItemColors2.selectedIconColor : j;
        long j10 = (i & 2) != 0 ? navigationBarItemColors2.selectedTextColor : j2;
        long j11 = (i & 4) != 0 ? navigationBarItemColors2.selectedIndicatorColor : j3;
        long j12 = (i & 8) != 0 ? navigationBarItemColors2.unselectedIconColor : j4;
        long j13 = (i & 16) != 0 ? navigationBarItemColors2.unselectedTextColor : j5;
        long j14 = (i & 32) != 0 ? navigationBarItemColors2.disabledIconColor : j6;
        if ((i & 64) != 0) {
            j8 = navigationBarItemColors2.disabledTextColor;
        } else {
            j8 = j7;
        }
        return navigationBarItemColors.m1990copy4JmcsL4(j9, j10, j11, j12, j13, j14, j8);
    }

    public final State<Color> iconColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-1012982249);
        ComposerKt.sourceInformation(composer, "C(iconColor)P(1)428@19238L132:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1012982249, i, -1, "androidx.compose.material3.NavigationBarItemColors.iconColor (NavigationBar.kt:422)");
        }
        if (!z2) {
            j = this.disabledIconColor;
        } else if (z) {
            j = this.selectedIconColor;
        } else {
            j = this.unselectedIconColor;
        }
        State<Color> r9 = SingleValueAnimationKt.m105animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r9;
    }

    public final State<Color> textColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-1833866293);
        ComposerKt.sourceInformation(composer, "C(textColor)P(1)447@19868L132:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1833866293, i, -1, "androidx.compose.material3.NavigationBarItemColors.textColor (NavigationBar.kt:441)");
        }
        if (!z2) {
            j = this.disabledTextColor;
        } else if (z) {
            j = this.selectedTextColor;
        } else {
            j = this.unselectedTextColor;
        }
        State<Color> r9 = SingleValueAnimationKt.m105animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r9;
    }

    /* renamed from: getIndicatorColor-0d7_KjU$material3_release  reason: not valid java name */
    public final long m1993getIndicatorColor0d7_KjU$material3_release() {
        return this.selectedIndicatorColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) obj;
        return Color.m3817equalsimpl0(this.selectedIconColor, navigationBarItemColors.selectedIconColor) && Color.m3817equalsimpl0(this.unselectedIconColor, navigationBarItemColors.unselectedIconColor) && Color.m3817equalsimpl0(this.selectedTextColor, navigationBarItemColors.selectedTextColor) && Color.m3817equalsimpl0(this.unselectedTextColor, navigationBarItemColors.unselectedTextColor) && Color.m3817equalsimpl0(this.selectedIndicatorColor, navigationBarItemColors.selectedIndicatorColor) && Color.m3817equalsimpl0(this.disabledIconColor, navigationBarItemColors.disabledIconColor) && Color.m3817equalsimpl0(this.disabledTextColor, navigationBarItemColors.disabledTextColor);
    }

    public int hashCode() {
        return (((((((((((Color.m3823hashCodeimpl(this.selectedIconColor) * 31) + Color.m3823hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m3823hashCodeimpl(this.selectedTextColor)) * 31) + Color.m3823hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m3823hashCodeimpl(this.selectedIndicatorColor)) * 31) + Color.m3823hashCodeimpl(this.disabledIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledTextColor);
    }

    /* renamed from: copy-4JmcsL4  reason: not valid java name */
    public final NavigationBarItemColors m1990copy4JmcsL4(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        return new NavigationBarItemColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.selectedIconColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.selectedTextColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.selectedIndicatorColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.unselectedIconColor, j5 != Color.Companion.m3852getUnspecified0d7_KjU() ? j5 : this.unselectedTextColor, j6 != Color.Companion.m3852getUnspecified0d7_KjU() ? j6 : this.disabledIconColor, j7 != Color.Companion.m3852getUnspecified0d7_KjU() ? j7 : this.disabledTextColor, (DefaultConstructorMarker) null);
    }
}
