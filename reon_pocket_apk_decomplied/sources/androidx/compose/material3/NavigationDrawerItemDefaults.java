package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/NavigationDrawerItemDefaults;", "", "()V", "ItemPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedContainerColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContainerColor", "selectedIconColor", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedBadgeColor", "unselectedBadgeColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationDrawerItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class NavigationDrawerItemDefaults {
    public static final int $stable = 0;
    public static final NavigationDrawerItemDefaults INSTANCE = new NavigationDrawerItemDefaults();
    private static final PaddingValues ItemPadding = PaddingKt.m665PaddingValuesYgX7TsA$default(Dp.m6614constructorimpl((float) 12), 0.0f, 2, (Object) null);

    private NavigationDrawerItemDefaults() {
    }

    /* renamed from: colors-oq7We08  reason: not valid java name */
    public final NavigationDrawerItemColors m2008colorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(-1574983348);
        ComposerKt.sourceInformation(composer2, "C(colors)P(1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.Color)822@31780L5,823@31867L5,824@31948L5,825@32033L5,826@32119L5,827@32209L5:NavigationDrawer.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6) : j;
        long value2 = (i3 & 2) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getContainerColor(), composer2, 6) : j2;
        long value3 = (i3 & 4) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIconColor(), composer2, 6) : j3;
        long value4 = (i3 & 8) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveIconColor(), composer2, 6) : j4;
        long value5 = (i3 & 16) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveLabelTextColor(), composer2, 6) : j5;
        long value6 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveLabelTextColor(), composer2, 6) : j6;
        long j9 = (i3 & 64) != 0 ? value5 : j7;
        long j10 = (i3 & 128) != 0 ? value6 : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1574983348, i, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:830)");
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = new DefaultDrawerItemsColor(value3, value4, value5, value6, value, value2, j9, j10, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultDrawerItemsColor;
    }

    public final PaddingValues getItemPadding() {
        return ItemPadding;
    }
}
