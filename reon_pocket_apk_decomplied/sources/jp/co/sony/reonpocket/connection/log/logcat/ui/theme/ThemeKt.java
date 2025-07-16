package jp.co.sony.reonpocket.connection.log.logcat.ui.theme;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "LogCatLoggerTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Theme.kt */
public final class ThemeKt {
    private static final ColorScheme DarkColorScheme = ColorSchemeKt.m1683darkColorSchemeCXl9yA$default(ColorKt.getPurple80(), 0, 0, 0, 0, ColorKt.getPurpleGrey80(), 0, 0, 0, ColorKt.getPink80(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 15, (Object) null);
    private static final ColorScheme LightColorScheme = ColorSchemeKt.m1687lightColorSchemeCXl9yA$default(ColorKt.getPurple40(), 0, 0, 0, 0, ColorKt.getPurpleGrey40(), 0, 0, 0, ColorKt.getPink40(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 15, (Object) null);

    public static final void LogCatLoggerTheme(boolean z, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        ColorScheme colorScheme;
        Intrinsics.checkNotNullParameter(function2, FirebaseAnalytics.Param.CONTENT);
        Composer startRestartGroup = composer.startRestartGroup(475705630);
        if ((i & 14) == 0) {
            i3 = (((i2 & 1) != 0 || !startRestartGroup.changed(z)) ? 2 : 4) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    z = DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0);
                    i3 &= -15;
                }
                if (i4 != 0) {
                    z2 = true;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(475705630, i3, -1, "jp.co.sony.reonpocket.connection.log.logcat.ui.theme.LogCatLoggerTheme (Theme.kt:45)");
            }
            startRestartGroup.startReplaceableGroup(-731639044);
            if (!z2 || Build.VERSION.SDK_INT < 31) {
                colorScheme = z ? DarkColorScheme : LightColorScheme;
            } else {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Context context = (Context) consume;
                colorScheme = z ? DynamicTonalPaletteKt.dynamicDarkColorScheme(context) : DynamicTonalPaletteKt.dynamicLightColorScheme(context);
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume2;
            startRestartGroup.startReplaceableGroup(-731627840);
            if (!view.isInEditMode()) {
                EffectsKt.SideEffect(new ThemeKt$LogCatLoggerTheme$1(view, colorScheme, z), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceableGroup();
            MaterialThemeKt.MaterialTheme(colorScheme, (Shapes) null, TypeKt.getTypography(), function2, startRestartGroup, ((i3 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        boolean z3 = z;
        boolean z4 = z2;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ThemeKt$LogCatLoggerTheme$2(z3, z4, function2, i, i2));
        }
    }
}
