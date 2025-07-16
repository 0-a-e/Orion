package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallCenteredTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0012\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0013JD\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJK\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010'H\u0007¢\u0006\u0002\u0010(JK\u0010)\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010'H\u0007¢\u0006\u0002\u0010(J\r\u0010*\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0013JD\u0010*\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001bJ\r\u0010,\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0013JD\u0010,\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010\u001bJ'\u0010.\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0007¢\u0006\u0002\u0010/JD\u00100\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010\u001bJ\r\u00102\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0013JD\u00102\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\b*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u00020\b*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0010\u001a\u00020\b*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "()V", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "defaultCenterAlignedTopAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCenterAlignedTopAppBarColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "defaultLargeTopAppBarColors", "getDefaultLargeTopAppBarColors$material3_release", "defaultMediumTopAppBarColors", "getDefaultMediumTopAppBarColors$material3_release", "defaultTopAppBarColors", "getDefaultTopAppBarColors$material3_release", "centerAlignedTopAppBarColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "centerAlignedTopAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "enterAlwaysScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "smallTopAppBarColors", "smallTopAppBarColors-zjMxDiM", "topAppBarColors", "topAppBarColors-zjMxDiM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();

    private TopAppBarDefaults() {
    }

    public final TopAppBarColors topAppBarColors(Composer composer, int i) {
        composer.startReplaceableGroup(-1388520854);
        ComposerKt.sourceInformation(composer, "C(topAppBarColors)697@33524L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1388520854, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:697)");
        }
        TopAppBarColors defaultTopAppBarColors$material3_release = getDefaultTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTopAppBarColors$material3_release;
    }

    /* renamed from: topAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2620topAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(2142919275);
        ComposerKt.sourceInformation(composer2, "C(topAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)717@34568L11:AppBar.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r13 = (i2 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2142919275, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:717)");
        }
        TopAppBarColors r1 = getDefaultTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2610copyt635Npw(r5, r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final TopAppBarColors getDefaultTopAppBarColors$material3_release(ColorScheme colorScheme) {
        long j;
        TopAppBarColors defaultTopAppBarColorsCached$material3_release = colorScheme.getDefaultTopAppBarColorsCached$material3_release();
        if (defaultTopAppBarColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallTokens.INSTANCE.getContainerColor());
            if (Color.m3817equalsimpl0(ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallTokens.INSTANCE.getContainerColor()), colorScheme.m1667getSurface0d7_KjU())) {
                j = ColorSchemeKt.m1690surfaceColorAtElevation3ABfNKs(colorScheme, TopAppBarSmallTokens.INSTANCE.m3209getOnScrollContainerElevationD9Ej5fM());
            } else {
                j = ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallTokens.INSTANCE.getContainerColor());
            }
            defaultTopAppBarColorsCached$material3_release = new TopAppBarColors(fromToken, j, ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallTokens.INSTANCE.getHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallTokens.INSTANCE.getTrailingIconColor()), (DefaultConstructorMarker) null);
            colorScheme.setDefaultTopAppBarColorsCached$material3_release(defaultTopAppBarColorsCached$material3_release);
        }
        return defaultTopAppBarColorsCached$material3_release;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead.", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* renamed from: smallTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2619smallTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-1717201472);
        ComposerKt.sourceInformation(composer2, "C(smallTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)766@36857L5,767@36918L11,767@36930L148,771@37162L5,772@37239L5,773@37325L5,775@37365L196:AppBar.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(TopAppBarSmallTokens.INSTANCE.getContainerColor(), composer2, 6) : j;
        long r3 = (i2 & 2) != 0 ? ColorSchemeKt.m1679applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), value, TopAppBarSmallTokens.INSTANCE.m3209getOnScrollContainerElevationD9Ej5fM(), composer, ((i3 << 3) & 112) | 384) : j2;
        long value2 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(TopAppBarSmallTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j3;
        long value3 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineColor(), composer2, 6) : j4;
        long value4 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(TopAppBarSmallTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1717201472, i3, -1, "androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors (AppBar.kt:775)");
        }
        TopAppBarColors topAppBarColors = m2620topAppBarColorszjMxDiM(value, r3, value2, value3, value4, composer, i3 & 524286, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        composer.startReplaceableGroup(2143182847);
        ComposerKt.sourceInformation(composer, "C788@37729L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, i, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:788)");
        }
        WindowInsets r5 = WindowInsetsKt.m771onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 6), WindowInsetsSides.m785plusgK_yJZ4(WindowInsetsSides.Companion.m795getHorizontalJoeWqyM(), WindowInsetsSides.Companion.m799getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r5;
    }

    public final TopAppBarColors centerAlignedTopAppBarColors(Composer composer, int i) {
        composer.startReplaceableGroup(513940029);
        ComposerKt.sourceInformation(composer, "C(centerAlignedTopAppBarColors)798@38113L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(513940029, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:798)");
        }
        TopAppBarColors defaultCenterAlignedTopAppBarColors$material3_release = getDefaultCenterAlignedTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultCenterAlignedTopAppBarColors$material3_release;
    }

    /* renamed from: centerAlignedTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2616centerAlignedTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1896017784);
        ComposerKt.sourceInformation(composer2, "C(centerAlignedTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)818@39191L11:AppBar.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r13 = (i2 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896017784, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:818)");
        }
        TopAppBarColors r1 = getDefaultCenterAlignedTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2610copyt635Npw(r5, r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final TopAppBarColors getDefaultCenterAlignedTopAppBarColors$material3_release(ColorScheme colorScheme) {
        long j;
        TopAppBarColors defaultCenterAlignedTopAppBarColorsCached$material3_release = colorScheme.getDefaultCenterAlignedTopAppBarColorsCached$material3_release();
        if (defaultCenterAlignedTopAppBarColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallCenteredTokens.INSTANCE.getContainerColor());
            if (Color.m3817equalsimpl0(ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallCenteredTokens.INSTANCE.getContainerColor()), colorScheme.m1667getSurface0d7_KjU())) {
                j = ColorSchemeKt.m1690surfaceColorAtElevation3ABfNKs(colorScheme, TopAppBarSmallTokens.INSTANCE.m3209getOnScrollContainerElevationD9Ej5fM());
            } else {
                j = ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallCenteredTokens.INSTANCE.getContainerColor());
            }
            defaultCenterAlignedTopAppBarColorsCached$material3_release = new TopAppBarColors(fromToken, j, ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallCenteredTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallCenteredTokens.INSTANCE.getHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarSmallCenteredTokens.INSTANCE.getTrailingIconColor()), (DefaultConstructorMarker) null);
            colorScheme.setDefaultCenterAlignedTopAppBarColorsCached$material3_release(defaultCenterAlignedTopAppBarColorsCached$material3_release);
        }
        return defaultCenterAlignedTopAppBarColorsCached$material3_release;
    }

    public final TopAppBarColors mediumTopAppBarColors(Composer composer, int i) {
        composer.startReplaceableGroup(1268886463);
        ComposerKt.sourceInformation(composer, "C(mediumTopAppBarColors)853@40809L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1268886463, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:853)");
        }
        TopAppBarColors defaultMediumTopAppBarColors$material3_release = getDefaultMediumTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultMediumTopAppBarColors$material3_release;
    }

    /* renamed from: mediumTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2618mediumTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-582474442);
        ComposerKt.sourceInformation(composer2, "C(mediumTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)874@41904L11:AppBar.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r13 = (i2 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582474442, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:874)");
        }
        TopAppBarColors r1 = getDefaultMediumTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2610copyt635Npw(r5, r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final TopAppBarColors getDefaultMediumTopAppBarColors$material3_release(ColorScheme colorScheme) {
        long j;
        TopAppBarColors defaultMediumTopAppBarColorsCached$material3_release = colorScheme.getDefaultMediumTopAppBarColorsCached$material3_release();
        if (defaultMediumTopAppBarColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme, TopAppBarMediumTokens.INSTANCE.getContainerColor());
            if (Color.m3817equalsimpl0(ColorSchemeKt.fromToken(colorScheme, TopAppBarMediumTokens.INSTANCE.getContainerColor()), colorScheme.m1667getSurface0d7_KjU())) {
                j = ColorSchemeKt.m1690surfaceColorAtElevation3ABfNKs(colorScheme, TopAppBarSmallTokens.INSTANCE.m3209getOnScrollContainerElevationD9Ej5fM());
            } else {
                j = ColorSchemeKt.fromToken(colorScheme, TopAppBarMediumTokens.INSTANCE.getContainerColor());
            }
            defaultMediumTopAppBarColorsCached$material3_release = new TopAppBarColors(fromToken, j, ColorSchemeKt.fromToken(colorScheme, TopAppBarMediumTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarMediumTokens.INSTANCE.getHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarMediumTokens.INSTANCE.getTrailingIconColor()), (DefaultConstructorMarker) null);
            colorScheme.setDefaultMediumTopAppBarColorsCached$material3_release(defaultMediumTopAppBarColorsCached$material3_release);
        }
        return defaultMediumTopAppBarColorsCached$material3_release;
    }

    public final TopAppBarColors largeTopAppBarColors(Composer composer, int i) {
        composer.startReplaceableGroup(1744932393);
        ComposerKt.sourceInformation(composer, "C(largeTopAppBarColors)906@43352L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1744932393, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:906)");
        }
        TopAppBarColors defaultLargeTopAppBarColors$material3_release = getDefaultLargeTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultLargeTopAppBarColors$material3_release;
    }

    /* renamed from: largeTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2617largeTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1471507700);
        ComposerKt.sourceInformation(composer2, "C(largeTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)927@44440L11:AppBar.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r13 = (i2 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471507700, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:927)");
        }
        TopAppBarColors r1 = getDefaultLargeTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2610copyt635Npw(r5, r7, r9, r11, r13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final TopAppBarColors getDefaultLargeTopAppBarColors$material3_release(ColorScheme colorScheme) {
        long j;
        TopAppBarColors defaultLargeTopAppBarColorsCached$material3_release = colorScheme.getDefaultLargeTopAppBarColorsCached$material3_release();
        if (defaultLargeTopAppBarColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme, TopAppBarLargeTokens.INSTANCE.getContainerColor());
            if (Color.m3817equalsimpl0(ColorSchemeKt.fromToken(colorScheme, TopAppBarLargeTokens.INSTANCE.getContainerColor()), colorScheme.m1667getSurface0d7_KjU())) {
                j = ColorSchemeKt.m1690surfaceColorAtElevation3ABfNKs(colorScheme, TopAppBarSmallTokens.INSTANCE.m3209getOnScrollContainerElevationD9Ej5fM());
            } else {
                j = ColorSchemeKt.fromToken(colorScheme, TopAppBarLargeTokens.INSTANCE.getContainerColor());
            }
            defaultLargeTopAppBarColorsCached$material3_release = new TopAppBarColors(fromToken, j, ColorSchemeKt.fromToken(colorScheme, TopAppBarLargeTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarLargeTokens.INSTANCE.getHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, TopAppBarLargeTokens.INSTANCE.getTrailingIconColor()), (DefaultConstructorMarker) null);
            colorScheme.setDefaultLargeTopAppBarColorsCached$material3_release(defaultLargeTopAppBarColorsCached$material3_release);
        }
        return defaultLargeTopAppBarColorsCached$material3_release;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(286497075);
        ComposerKt.sourceInformation(composer, "C(pinnedScrollBehavior)P(1)967@46281L24:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        if ((i2 & 2) != 0) {
            function0 = TopAppBarDefaults$pinnedScrollBehavior$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286497075, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:969)");
        }
        PinnedScrollBehavior pinnedScrollBehavior = new PinnedScrollBehavior(topAppBarState, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pinnedScrollBehavior;
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(959086674);
        ComposerKt.sourceInformation(composer, "C(enterAlwaysScrollBehavior)P(3!1,2)989@47555L24,992@47781L26:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        if ((i2 & 2) != 0) {
            function0 = TopAppBarDefaults$enterAlwaysScrollBehavior$1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959086674, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:994)");
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return enterAlwaysScrollBehavior;
    }

    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1757023234);
        ComposerKt.sourceInformation(composer, "C(exitUntilCollapsedScrollBehavior)P(3!1,2)1022@49309L24,1025@49535L26:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        if ((i2 & 2) != 0) {
            function0 = TopAppBarDefaults$exitUntilCollapsedScrollBehavior$1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1757023234, i, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:1027)");
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = new ExitUntilCollapsedScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return exitUntilCollapsedScrollBehavior;
    }
}
