package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0016H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u001a\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0016H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u001cR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledLeadingIconColor-0d7_KjU", "()J", "J", "getDisabledTextColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getLeadingIconColor-0d7_KjU", "getTextColor-0d7_KjU", "getTrailingIconColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/MenuItemColors;", "equals", "", "other", "hashCode", "", "enabled", "leadingIconColor-XeAY9LY$material3_release", "(ZLandroidx/compose/runtime/Composer;I)J", "Landroidx/compose/runtime/State;", "textColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trailingIconColor-XeAY9LY$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuItemColors {
    public static final int $stable = 0;
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    public /* synthetic */ MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.textColor = j;
        this.leadingIconColor = j2;
        this.trailingIconColor = j3;
        this.disabledTextColor = j4;
        this.disabledLeadingIconColor = j5;
        this.disabledTrailingIconColor = j6;
    }

    /* renamed from: getTextColor-0d7_KjU  reason: not valid java name */
    public final long m1973getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* renamed from: getLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m1972getLeadingIconColor0d7_KjU() {
        return this.leadingIconColor;
    }

    /* renamed from: getTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m1974getTrailingIconColor0d7_KjU() {
        return this.trailingIconColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU  reason: not valid java name */
    public final long m1970getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* renamed from: getDisabledLeadingIconColor-0d7_KjU  reason: not valid java name */
    public final long m1969getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* renamed from: getDisabledTrailingIconColor-0d7_KjU  reason: not valid java name */
    public final long m1971getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* renamed from: copy-tNS2XkQ$default  reason: not valid java name */
    public static /* synthetic */ MenuItemColors m1967copytNS2XkQ$default(MenuItemColors menuItemColors, long j, long j2, long j3, long j4, long j5, long j6, int i, Object obj) {
        long j7;
        MenuItemColors menuItemColors2 = menuItemColors;
        long j8 = (i & 1) != 0 ? menuItemColors2.textColor : j;
        long j9 = (i & 2) != 0 ? menuItemColors2.leadingIconColor : j2;
        long j10 = (i & 4) != 0 ? menuItemColors2.trailingIconColor : j3;
        long j11 = (i & 8) != 0 ? menuItemColors2.disabledTextColor : j4;
        long j12 = (i & 16) != 0 ? menuItemColors2.disabledLeadingIconColor : j5;
        if ((i & 32) != 0) {
            j7 = menuItemColors2.disabledTrailingIconColor;
        } else {
            j7 = j6;
        }
        return menuItemColors.m1968copytNS2XkQ(j8, j9, j10, j11, j12, j7);
    }

    public final State<Color> textColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-1023108655);
        ComposerKt.sourceInformation(composer, "C(textColor)179@7855L67:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1023108655, i, -1, "androidx.compose.material3.MenuItemColors.textColor (Menu.kt:178)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(z ? this.textColor : this.disabledTextColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: leadingIconColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m1975leadingIconColorXeAY9LY$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-395881771);
        ComposerKt.sourceInformation(composer, "C(leadingIconColor):Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-395881771, i, -1, "androidx.compose.material3.MenuItemColors.leadingIconColor (Menu.kt:189)");
        }
        long j = z ? this.leadingIconColor : this.disabledLeadingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return j;
    }

    /* renamed from: trailingIconColor-XeAY9LY$material3_release  reason: not valid java name */
    public final long m1976trailingIconColorXeAY9LY$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-892832569);
        ComposerKt.sourceInformation(composer, "C(trailingIconColor):Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-892832569, i, -1, "androidx.compose.material3.MenuItemColors.trailingIconColor (Menu.kt:198)");
        }
        long j = z ? this.trailingIconColor : this.disabledTrailingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MenuItemColors)) {
            return false;
        }
        MenuItemColors menuItemColors = (MenuItemColors) obj;
        return Color.m3817equalsimpl0(this.textColor, menuItemColors.textColor) && Color.m3817equalsimpl0(this.leadingIconColor, menuItemColors.leadingIconColor) && Color.m3817equalsimpl0(this.trailingIconColor, menuItemColors.trailingIconColor) && Color.m3817equalsimpl0(this.disabledTextColor, menuItemColors.disabledTextColor) && Color.m3817equalsimpl0(this.disabledLeadingIconColor, menuItemColors.disabledLeadingIconColor) && Color.m3817equalsimpl0(this.disabledTrailingIconColor, menuItemColors.disabledTrailingIconColor);
    }

    public int hashCode() {
        return (((((((((Color.m3823hashCodeimpl(this.textColor) * 31) + Color.m3823hashCodeimpl(this.leadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.trailingIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledTextColor)) * 31) + Color.m3823hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m3823hashCodeimpl(this.disabledTrailingIconColor);
    }

    /* renamed from: copy-tNS2XkQ  reason: not valid java name */
    public final MenuItemColors m1968copytNS2XkQ(long j, long j2, long j3, long j4, long j5, long j6) {
        return new MenuItemColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.textColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.leadingIconColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.trailingIconColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.disabledTextColor, j5 != Color.Companion.m3852getUnspecified0d7_KjU() ? j5 : this.disabledLeadingIconColor, j6 != Color.Companion.m3852getUnspecified0d7_KjU() ? j6 : this.disabledTrailingIconColor, (DefaultConstructorMarker) null);
    }
}
