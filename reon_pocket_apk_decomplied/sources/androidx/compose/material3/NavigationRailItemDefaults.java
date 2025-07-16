package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJD\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/NavigationRailItemDefaults;", "", "()V", "defaultNavigationRailItemColors", "Landroidx/compose/material3/NavigationRailItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationRailItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationRailItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationRailItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationRailItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
public final class NavigationRailItemDefaults {
    public static final int $stable = 0;
    public static final NavigationRailItemDefaults INSTANCE = new NavigationRailItemDefaults();

    private NavigationRailItemDefaults() {
    }

    public final NavigationRailItemColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-2014332261);
        ComposerKt.sourceInformation(composer, "C(colors)293@12417L11:NavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2014332261, i, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:293)");
        }
        NavigationRailItemColors defaultNavigationRailItemColors$material3_release = getDefaultNavigationRailItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultNavigationRailItemColors$material3_release;
    }

    /* renamed from: colors-69fazGs  reason: not valid java name */
    public final NavigationRailItemColors m2030colors69fazGs(long j, long j2, long j3, long j4, long j5, long j6, long j7, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-2104358508);
        ComposerKt.sourceInformation(composer2, "C(colors)P(3:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)310@13443L5,311@13527L5,312@13608L5,313@13691L5,314@13779L5,317@14002L11:NavigationRail.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIconColor(), composer2, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveLabelTextColor(), composer2, 6) : j2;
        long value3 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6) : j3;
        long value4 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveIconColor(), composer2, 6) : j4;
        long value5 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveLabelTextColor(), composer2, 6) : j5;
        long r17 = (i2 & 32) != 0 ? Color.m3815copywmQWz5c$default(value4, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r19 = (i2 & 64) != 0 ? Color.m3815copywmQWz5c$default(value5, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2104358508, i, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:317)");
        }
        NavigationRailItemColors r1 = getDefaultNavigationRailItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2021copy4JmcsL4(value, value2, value3, value4, value5, r17, r19);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final NavigationRailItemColors getDefaultNavigationRailItemColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        NavigationRailItemColors defaultNavigationRailItemColorsCached$material3_release = colorScheme.getDefaultNavigationRailItemColorsCached$material3_release();
        if (defaultNavigationRailItemColorsCached$material3_release != null) {
            return defaultNavigationRailItemColorsCached$material3_release;
        }
        NavigationRailItemColors navigationRailItemColors = new NavigationRailItemColors(ColorSchemeKt.fromToken(colorScheme2, NavigationRailTokens.INSTANCE.getActiveIconColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationRailTokens.INSTANCE.getActiveLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationRailTokens.INSTANCE.getActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationRailTokens.INSTANCE.getInactiveIconColor()), ColorSchemeKt.fromToken(colorScheme2, NavigationRailTokens.INSTANCE.getInactiveLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, NavigationRailTokens.INSTANCE.getInactiveIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, NavigationRailTokens.INSTANCE.getInactiveLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultNavigationRailItemColorsCached$material3_release(navigationRailItemColors);
        return navigationRailItemColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    /* renamed from: colors-zjMxDiM  reason: not valid java name */
    public final /* synthetic */ NavigationRailItemColors m2031colorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1621601574);
        ComposerKt.sourceInformation(composer2, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)350@15620L5,351@15704L5,352@15785L5,353@15868L5,354@15956L5:NavigationRail.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIconColor(), composer2, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveLabelTextColor(), composer2, 6) : j2;
        long value3 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6) : j3;
        long value4 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveIconColor(), composer2, 6) : j4;
        long value5 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(NavigationRailTokens.INSTANCE.getInactiveLabelTextColor(), composer2, 6) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1621601574, i, -1, "androidx.compose.material3.NavigationRailItemDefaults.colors (NavigationRail.kt:355)");
        }
        NavigationRailItemColors navigationRailItemColors = new NavigationRailItemColors(value, value2, value3, value4, value5, Color.m3815copywmQWz5c$default(value4, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(value5, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return navigationRailItemColors;
    }
}
