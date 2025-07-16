package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\rJN\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "()V", "DropdownMenuItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "defaultMenuItemColors", "Landroidx/compose/material3/MenuItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "itemColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuDefaults {
    public static final int $stable = 0;
    private static final PaddingValues DropdownMenuItemContentPadding = PaddingKt.m664PaddingValuesYgX7TsA(MenuKt.DropdownMenuItemHorizontalPadding, Dp.m6614constructorimpl((float) 0));
    public static final MenuDefaults INSTANCE = new MenuDefaults();

    private MenuDefaults() {
    }

    public final MenuItemColors itemColors(Composer composer, int i) {
        composer.startReplaceableGroup(1326531516);
        ComposerKt.sourceInformation(composer, "C(itemColors)67@2725L11:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1326531516, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:67)");
        }
        MenuItemColors defaultMenuItemColors$material3_release = getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultMenuItemColors$material3_release;
    }

    /* renamed from: itemColors-5tl4gsc  reason: not valid java name */
    public final MenuItemColors m1966itemColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1278543580);
        ComposerKt.sourceInformation(composer2, "C(itemColors)P(4:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)91@3951L11:Menu.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r13 = (i2 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r15 = (i2 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1278543580, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:91)");
        }
        MenuItemColors r1 = getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1968copytNS2XkQ(r5, r7, r9, r11, r13, r15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final MenuItemColors getDefaultMenuItemColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        MenuItemColors defaultMenuItemColorsCached$material3_release = colorScheme.getDefaultMenuItemColorsCached$material3_release();
        if (defaultMenuItemColorsCached$material3_release != null) {
            return defaultMenuItemColorsCached$material3_release;
        }
        MenuItemColors menuItemColors = new MenuItemColors(ColorSchemeKt.fromToken(colorScheme2, MenuTokens.INSTANCE.getListItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, MenuTokens.INSTANCE.getListItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, MenuTokens.INSTANCE.getListItemTrailingIconColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, MenuTokens.INSTANCE.getListItemDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, MenuTokens.INSTANCE.getListItemDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, MenuTokens.INSTANCE.getListItemDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultMenuItemColorsCached$material3_release(menuItemColors);
        return menuItemColors;
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }
}
