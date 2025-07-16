package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0014\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJN\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u0010(\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001cJN\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010'J\u0017\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u00101\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001cJN\u00103\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010'R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0012\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/material3/CardDefaults;", "", "()V", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "defaultCardColors", "Landroidx/compose/material3/CardColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCardColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CardColors;", "defaultElevatedCardColors", "getDefaultElevatedCardColors$material3_release", "defaultOutlinedCardColors", "getDefaultOutlinedCardColors$material3_release", "cardColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Card.kt */
public final class CardDefaults {
    public static final int $stable = 0;
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(1266660211);
        ComposerKt.sourceInformation(composer, "C352@16204L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1266660211, i, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:352)");
        }
        Shape value = ShapesKt.getValue(FilledCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getElevatedShape(Composer composer, int i) {
        composer.startReplaceableGroup(-133496185);
        ComposerKt.sourceInformation(composer, "C355@16341L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-133496185, i, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:355)");
        }
        Shape value = ShapesKt.getValue(ElevatedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        composer.startReplaceableGroup(1095404023);
        ComposerKt.sourceInformation(composer, "C358@16478L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095404023, i, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:358)");
        }
        Shape value = ShapesKt.getValue(OutlinedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: cardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1574cardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-574898487);
        ComposerKt.sourceInformation(composer2, "C(cardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? FilledCardTokens.INSTANCE.m2894getContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? FilledCardTokens.INSTANCE.m2900getPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? FilledCardTokens.INSTANCE.m2897getFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? FilledCardTokens.INSTANCE.m2898getHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? FilledCardTokens.INSTANCE.m2896getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? FilledCardTokens.INSTANCE.m2895getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-574898487, i, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:378)");
        }
        CardElevation cardElevation = new CardElevation(r4, r5, r6, r7, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    /* renamed from: elevatedCardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1576elevatedCardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1154241939);
        ComposerKt.sourceInformation(composer2, "C(elevatedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? ElevatedCardTokens.INSTANCE.m2810getContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? ElevatedCardTokens.INSTANCE.m2816getPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? ElevatedCardTokens.INSTANCE.m2813getFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? ElevatedCardTokens.INSTANCE.m2814getHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? ElevatedCardTokens.INSTANCE.m2812getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? ElevatedCardTokens.INSTANCE.m2811getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1154241939, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:406)");
        }
        CardElevation cardElevation = new CardElevation(r4, r5, r6, r7, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    /* renamed from: outlinedCardElevation-aqJV_2Y  reason: not valid java name */
    public final CardElevation m1578outlinedCardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-97678773);
        ComposerKt.sourceInformation(composer2, "C(outlinedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? OutlinedCardTokens.INSTANCE.m2996getContainerElevationD9Ej5fM() : f;
        float f7 = (i2 & 2) != 0 ? r4 : f2;
        float f8 = (i2 & 4) != 0 ? r4 : f3;
        float f9 = (i2 & 8) != 0 ? r4 : f4;
        float r8 = (i2 & 16) != 0 ? OutlinedCardTokens.INSTANCE.m2998getDraggedContainerElevationD9Ej5fM() : f5;
        float r9 = (i2 & 32) != 0 ? OutlinedCardTokens.INSTANCE.m2997getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97678773, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:434)");
        }
        CardElevation cardElevation = new CardElevation(r4, f7, f8, f9, r8, r9, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    public final CardColors cardColors(Composer composer, int i) {
        composer.startReplaceableGroup(-1876034303);
        ComposerKt.sourceInformation(composer, "C(cardColors)448@20842L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1876034303, i, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:448)");
        }
        CardColors defaultCardColors$material3_release = getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultCardColors$material3_release;
    }

    /* renamed from: cardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1573cardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-1589582123);
        ComposerKt.sourceInformation(composer2, "C(cardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)462@21453L31,465@21651L11:Card.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i2 & 2) != 0 ? ColorSchemeKt.m1681contentColorForek8zF_U(r6, composer2, i3 & 14) : j2;
        long r10 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r12 = (i2 & 8) != 0 ? Color.m3815copywmQWz5c$default(r8, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589582123, i3, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:465)");
        }
        CardColors r1 = getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1568copyjRlVdoo(r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final CardColors getDefaultCardColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        CardColors defaultCardColorsCached$material3_release = colorScheme.getDefaultCardColorsCached$material3_release();
        if (defaultCardColorsCached$material3_release != null) {
            return defaultCardColorsCached$material3_release;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1680contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getContainerColor())), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.m1690surfaceColorAtElevation3ABfNKs(colorScheme2, FilledCardTokens.INSTANCE.m2895getDisabledContainerElevationD9Ej5fM())), Color.m3815copywmQWz5c$default(ColorSchemeKt.m1680contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, FilledCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final CardColors elevatedCardColors(Composer composer, int i) {
        composer.startReplaceableGroup(1610137975);
        ComposerKt.sourceInformation(composer, "C(elevatedCardColors)498@23021L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1610137975, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:498)");
        }
        CardColors defaultElevatedCardColors$material3_release = getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultElevatedCardColors$material3_release;
    }

    /* renamed from: elevatedCardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1575elevatedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(139558303);
        ComposerKt.sourceInformation(composer2, "C(elevatedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)512@23689L31,515@23887L11:Card.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i2 & 2) != 0 ? ColorSchemeKt.m1681contentColorForek8zF_U(r6, composer2, i3 & 14) : j2;
        long r10 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r12 = (i2 & 8) != 0 ? Color.m3815copywmQWz5c$default(r8, 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139558303, i3, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:515)");
        }
        CardColors r1 = getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1568copyjRlVdoo(r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final CardColors getDefaultElevatedCardColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        CardColors defaultElevatedCardColorsCached$material3_release = colorScheme.getDefaultElevatedCardColorsCached$material3_release();
        if (defaultElevatedCardColorsCached$material3_release != null) {
            return defaultElevatedCardColorsCached$material3_release;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1680contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getContainerColor())), ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.m1690surfaceColorAtElevation3ABfNKs(colorScheme2, ElevatedCardTokens.INSTANCE.m2811getDisabledContainerElevationD9Ej5fM())), Color.m3815copywmQWz5c$default(ColorSchemeKt.m1680contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, ElevatedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultElevatedCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final CardColors outlinedCardColors(Composer composer, int i) {
        composer.startReplaceableGroup(-1204388929);
        ComposerKt.sourceInformation(composer, "C(outlinedCardColors)547@25299L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1204388929, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:547)");
        }
        CardColors defaultOutlinedCardColors$material3_release = getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedCardColors$material3_release;
    }

    /* renamed from: outlinedCardColors-ro_MJ88  reason: not valid java name */
    public final CardColors m1577outlinedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-1112362409);
        ComposerKt.sourceInformation(composer2, "C(outlinedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)561@25967L31,563@26097L31,564@26184L11:Card.kt#uh7d8r");
        long r6 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r8 = (i2 & 2) != 0 ? ColorSchemeKt.m1681contentColorForek8zF_U(r6, composer2, i3 & 14) : j2;
        long r10 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r12 = (i2 & 8) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.m1681contentColorForek8zF_U(r6, composer2, i3 & 14), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112362409, i3, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:564)");
        }
        CardColors r1 = getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1568copyjRlVdoo(r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final CardColors getDefaultOutlinedCardColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        CardColors defaultOutlinedCardColorsCached$material3_release = colorScheme.getDefaultOutlinedCardColorsCached$material3_release();
        if (defaultOutlinedCardColorsCached$material3_release != null) {
            return defaultOutlinedCardColorsCached$material3_release;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m1680contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor())), ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.m1680contentColorFor4WTKRHQ(colorScheme2, ColorSchemeKt.fromToken(colorScheme2, OutlinedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultOutlinedCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final BorderStroke outlinedCardBorder(boolean z, Composer composer, int i, int i2) {
        long j;
        composer.startReplaceableGroup(-392936593);
        ComposerKt.sourceInformation(composer, "C(outlinedCardBorder)602@27787L72:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-392936593, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:590)");
        }
        if (z) {
            composer.startReplaceableGroup(-31426386);
            ComposerKt.sourceInformation(composer, "592@27395L5");
            j = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-31426319);
            ComposerKt.sourceInformation(composer, "594@27470L5,597@27615L11");
            j = ColorKt.m3861compositeOverOWjLjI(Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.m1690surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer, 6), OutlinedCardTokens.INSTANCE.m2997getDisabledContainerElevationD9Ej5fM()));
            composer.endReplaceableGroup();
        }
        composer.startReplaceableGroup(-31425948);
        ComposerKt.sourceInformation(composer, "CC(remember):Card.kt#9igjgp");
        boolean changed = composer.changed(j);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BorderStrokeKt.m241BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.m3002getOutlineWidthD9Ej5fM(), j);
            composer.updateRememberedValue(rememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) rememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStroke;
    }
}
