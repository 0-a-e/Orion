package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aJ\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aJ\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/DefaultDrawerItemsColor;", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedContainerColor", "unselectedContainerColor", "selectedBadgeColor", "unselectedBadgeColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedBadgeColor-0d7_KjU", "()J", "J", "getSelectedContainerColor-0d7_KjU", "getSelectedIconColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedBadgeColor-0d7_KjU", "getUnselectedContainerColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "badgeColor", "Landroidx/compose/runtime/State;", "selected", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "containerColor", "equals", "other", "", "hashCode", "", "iconColor", "textColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class DefaultDrawerItemsColor implements NavigationDrawerItemColors {
    private final long selectedBadgeColor;
    private final long selectedContainerColor;
    private final long selectedIconColor;
    private final long selectedTextColor;
    private final long unselectedBadgeColor;
    private final long unselectedContainerColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ DefaultDrawerItemsColor(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultDrawerItemsColor(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.selectedIconColor = j;
        this.unselectedIconColor = j2;
        this.selectedTextColor = j3;
        this.unselectedTextColor = j4;
        this.selectedContainerColor = j5;
        this.unselectedContainerColor = j6;
        this.selectedBadgeColor = j7;
        this.unselectedBadgeColor = j8;
    }

    /* renamed from: getSelectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m1800getSelectedIconColor0d7_KjU() {
        return this.selectedIconColor;
    }

    /* renamed from: getUnselectedIconColor-0d7_KjU  reason: not valid java name */
    public final long m1804getUnselectedIconColor0d7_KjU() {
        return this.unselectedIconColor;
    }

    /* renamed from: getSelectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m1801getSelectedTextColor0d7_KjU() {
        return this.selectedTextColor;
    }

    /* renamed from: getUnselectedTextColor-0d7_KjU  reason: not valid java name */
    public final long m1805getUnselectedTextColor0d7_KjU() {
        return this.unselectedTextColor;
    }

    /* renamed from: getSelectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1799getSelectedContainerColor0d7_KjU() {
        return this.selectedContainerColor;
    }

    /* renamed from: getUnselectedContainerColor-0d7_KjU  reason: not valid java name */
    public final long m1803getUnselectedContainerColor0d7_KjU() {
        return this.unselectedContainerColor;
    }

    /* renamed from: getSelectedBadgeColor-0d7_KjU  reason: not valid java name */
    public final long m1798getSelectedBadgeColor0d7_KjU() {
        return this.selectedBadgeColor;
    }

    /* renamed from: getUnselectedBadgeColor-0d7_KjU  reason: not valid java name */
    public final long m1802getUnselectedBadgeColor0d7_KjU() {
        return this.unselectedBadgeColor;
    }

    public State<Color> iconColor(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(1141354218);
        ComposerKt.sourceInformation(composer, "C(iconColor)860@33273L78:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141354218, i, -1, "androidx.compose.material3.DefaultDrawerItemsColor.iconColor (NavigationDrawer.kt:859)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(z ? this.selectedIconColor : this.unselectedIconColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public State<Color> textColor(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(1275109558);
        ComposerKt.sourceInformation(composer, "C(textColor)865@33452L78:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1275109558, i, -1, "androidx.compose.material3.DefaultDrawerItemsColor.textColor (NavigationDrawer.kt:864)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(z ? this.selectedTextColor : this.unselectedTextColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public State<Color> containerColor(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-433512770);
        ComposerKt.sourceInformation(composer, "C(containerColor)870@33636L110:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-433512770, i, -1, "androidx.compose.material3.DefaultDrawerItemsColor.containerColor (NavigationDrawer.kt:869)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(z ? this.selectedContainerColor : this.unselectedContainerColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    public State<Color> badgeColor(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(-561675044);
        ComposerKt.sourceInformation(composer, "C(badgeColor)877@33848L102:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561675044, i, -1, "androidx.compose.material3.DefaultDrawerItemsColor.badgeColor (NavigationDrawer.kt:876)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(z ? this.selectedBadgeColor : this.unselectedBadgeColor), composer, 0);
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
        if (!(obj instanceof DefaultDrawerItemsColor)) {
            return false;
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = (DefaultDrawerItemsColor) obj;
        if (Color.m3817equalsimpl0(this.selectedIconColor, defaultDrawerItemsColor.selectedIconColor) && Color.m3817equalsimpl0(this.unselectedIconColor, defaultDrawerItemsColor.unselectedIconColor) && Color.m3817equalsimpl0(this.selectedTextColor, defaultDrawerItemsColor.selectedTextColor) && Color.m3817equalsimpl0(this.unselectedTextColor, defaultDrawerItemsColor.unselectedTextColor) && Color.m3817equalsimpl0(this.selectedContainerColor, defaultDrawerItemsColor.selectedContainerColor) && Color.m3817equalsimpl0(this.unselectedContainerColor, defaultDrawerItemsColor.unselectedContainerColor) && Color.m3817equalsimpl0(this.selectedBadgeColor, defaultDrawerItemsColor.selectedBadgeColor)) {
            return Color.m3817equalsimpl0(this.unselectedBadgeColor, defaultDrawerItemsColor.unselectedBadgeColor);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Color.m3823hashCodeimpl(this.selectedIconColor) * 31) + Color.m3823hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m3823hashCodeimpl(this.selectedTextColor)) * 31) + Color.m3823hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m3823hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m3823hashCodeimpl(this.unselectedContainerColor)) * 31) + Color.m3823hashCodeimpl(this.selectedBadgeColor)) * 31) + Color.m3823hashCodeimpl(this.unselectedBadgeColor);
    }
}
