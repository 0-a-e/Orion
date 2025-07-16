package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/DrawerDefaults;", "", "()V", "DismissibleDrawerElevation", "Landroidx/compose/ui/unit/Dp;", "getDismissibleDrawerElevation-D9Ej5fM", "()F", "F", "MaximumDrawerWidth", "getMaximumDrawerWidth-D9Ej5fM", "ModalDrawerElevation", "getModalDrawerElevation-D9Ej5fM", "PermanentDrawerElevation", "getPermanentDrawerElevation-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "scrimColor", "getScrimColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationDrawer.kt */
public final class DrawerDefaults {
    public static final int $stable = 0;
    private static final float DismissibleDrawerElevation = NavigationDrawerTokens.INSTANCE.m2975getStandardContainerElevationD9Ej5fM();
    public static final DrawerDefaults INSTANCE = new DrawerDefaults();
    private static final float MaximumDrawerWidth = NavigationDrawerTokens.INSTANCE.m2972getContainerWidthD9Ej5fM();
    private static final float ModalDrawerElevation = NavigationDrawerTokens.INSTANCE.m2974getModalContainerElevationD9Ej5fM();
    private static final float PermanentDrawerElevation = NavigationDrawerTokens.INSTANCE.m2975getStandardContainerElevationD9Ej5fM();

    private DrawerDefaults() {
    }

    /* renamed from: getModalDrawerElevation-D9Ej5fM  reason: not valid java name */
    public final float m1825getModalDrawerElevationD9Ej5fM() {
        return ModalDrawerElevation;
    }

    /* renamed from: getPermanentDrawerElevation-D9Ej5fM  reason: not valid java name */
    public final float m1826getPermanentDrawerElevationD9Ej5fM() {
        return PermanentDrawerElevation;
    }

    /* renamed from: getDismissibleDrawerElevation-D9Ej5fM  reason: not valid java name */
    public final float m1823getDismissibleDrawerElevationD9Ej5fM() {
        return DismissibleDrawerElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(928378975);
        ComposerKt.sourceInformation(composer, "C680@25937L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(928378975, i, -1, "androidx.compose.material3.DrawerDefaults.<get-shape> (NavigationDrawer.kt:680)");
        }
        Shape value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final long getScrimColor(Composer composer, int i) {
        composer.startReplaceableGroup(-1055074989);
        ComposerKt.sourceInformation(composer, "C684@26109L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1055074989, i, -1, "androidx.compose.material3.DrawerDefaults.<get-scrimColor> (NavigationDrawer.kt:684)");
        }
        long r0 = Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    public final long getContainerColor(Composer composer, int i) {
        composer.startReplaceableGroup(-1797317261);
        ComposerKt.sourceInformation(composer, "C687@26298L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1797317261, i, -1, "androidx.compose.material3.DrawerDefaults.<get-containerColor> (NavigationDrawer.kt:687)");
        }
        long value = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: getMaximumDrawerWidth-D9Ej5fM  reason: not valid java name */
    public final float m1824getMaximumDrawerWidthD9Ej5fM() {
        return MaximumDrawerWidth;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        composer.startReplaceableGroup(-909973510);
        ComposerKt.sourceInformation(composer, "C697@26580L29:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-909973510, i, -1, "androidx.compose.material3.DrawerDefaults.<get-windowInsets> (NavigationDrawer.kt:697)");
        }
        WindowInsets r5 = WindowInsetsKt.m771onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 6), WindowInsetsSides.m785plusgK_yJZ4(WindowInsetsSides.Companion.m800getVerticalJoeWqyM(), WindowInsetsSides.Companion.m798getStartJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r5;
    }
}
