package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010:\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010:\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bA\u0010BJD\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\u00042\b\b\u0002\u0010H\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\r\u0010L\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010L\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010BJD\u0010N\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\u00042\b\b\u0002\u0010H\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010KJ\r\u0010P\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010P\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bQ\u0010BJD\u0010R\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\u00042\b\b\u0002\u0010H\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bS\u0010KJ\r\u0010T\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010T\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010BJ\r\u0010V\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010V\u001a\u00020.2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\bW\u0010BR\u0016\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0016\u0010\u0019\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\nR\u0016\u0010\u001c\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001d\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0011\u0010)\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0011\u0010+\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b,\u0010 R\u0018\u0010-\u001a\u00020.*\u00020/8@X\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u00020.*\u00020/8@X\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u0018\u00104\u001a\u00020.*\u00020/8@X\u0004¢\u0006\u0006\u001a\u0004\b5\u00101R\u0018\u00106\u001a\u00020.*\u00020/8@X\u0004¢\u0006\u0006\u001a\u0004\b7\u00101R\u0018\u00108\u001a\u00020.*\u00020/8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u00101\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ButtonWithIconContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getButtonWithIconContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconHorizontalStartPadding", "ContentPadding", "getContentPadding", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "TextButtonWithIconHorizontalEndPadding", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledTonalShape", "getFilledTonalShape", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "textShape", "getTextShape", "defaultButtonColors", "Landroidx/compose/material3/ButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "defaultElevatedButtonColors", "getDefaultElevatedButtonColors$material3_release", "defaultFilledTonalButtonColors", "getDefaultFilledTonalButtonColors$material3_release", "defaultOutlinedButtonColors", "getDefaultOutlinedButtonColors$material3_release", "defaultTextButtonColors", "getDefaultTextButtonColors$material3_release", "buttonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "textButtonColors", "textButtonColors-ro_MJ88", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Button.kt */
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconHorizontalStartPadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize = FilledButtonTokens.INSTANCE.m2892getIconSizeD9Ej5fM();
    private static final float IconSpacing;
    private static final float MinHeight = Dp.m6614constructorimpl((float) 40);
    private static final float MinWidth = Dp.m6614constructorimpl((float) 58);
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;
    private static final PaddingValues TextButtonWithIconContentPadding;
    private static final float TextButtonWithIconHorizontalEndPadding;

    private ButtonDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return TextButtonWithIconContentPadding;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1561getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1560getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1558getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM  reason: not valid java name */
    public final float m1559getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1234923021);
        ComposerKt.sourceInformation(composer, "C527@25371L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, i, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:527)");
        }
        Shape value = ShapesKt.getValue(FilledButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getElevatedShape(Composer composer, int i) {
        composer.startReplaceableGroup(2143958791);
        ComposerKt.sourceInformation(composer, "C530@25512L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143958791, i, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:530)");
        }
        Shape value = ShapesKt.getValue(ElevatedButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getFilledTonalShape(Composer composer, int i) {
        composer.startReplaceableGroup(-886584987);
        ComposerKt.sourceInformation(composer, "C533@25662L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-886584987, i, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:533)");
        }
        Shape value = ShapesKt.getValue(FilledTonalButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        composer.startReplaceableGroup(-2045213065);
        ComposerKt.sourceInformation(composer, "C536@25803L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045213065, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:536)");
        }
        Shape value = ShapesKt.getValue(OutlinedButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getTextShape(Composer composer, int i) {
        composer.startReplaceableGroup(-349121587);
        ComposerKt.sourceInformation(composer, "C539@25931L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, i, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:539)");
        }
        Shape value = ShapesKt.getValue(TextButtonTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final ButtonColors buttonColors(Composer composer, int i) {
        composer.startReplaceableGroup(1449248637);
        ComposerKt.sourceInformation(composer, "C(buttonColors)546@26125L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1449248637, i, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:546)");
        }
        ButtonColors defaultButtonColors$material3_release = getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors$material3_release;
    }

    /* renamed from: buttonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1552buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-339300779);
        ComposerKt.sourceInformation(composer2, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)563@26923L11:Button.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, i, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:563)");
        }
        ButtonColors r1 = getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1547copyjRlVdoo(r5, r7, r9, r11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ButtonColors getDefaultButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ButtonColors defaultButtonColorsCached$material3_release = colorScheme.getDefaultButtonColorsCached$material3_release();
        if (defaultButtonColorsCached$material3_release != null) {
            return defaultButtonColorsCached$material3_release;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme2, FilledButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme2, FilledButtonTokens.INSTANCE.getLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledButtonTokens.INSTANCE.getDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultButtonColorsCached$material3_release(buttonColors);
        return buttonColors;
    }

    public final ButtonColors elevatedButtonColors(Composer composer, int i) {
        composer.startReplaceableGroup(2025043443);
        ComposerKt.sourceInformation(composer, "C(elevatedButtonColors)589@28094L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2025043443, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:589)");
        }
        ButtonColors defaultElevatedButtonColors$material3_release = getDefaultElevatedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultElevatedButtonColors$material3_release;
    }

    /* renamed from: elevatedButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1554elevatedButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1507908383);
        ComposerKt.sourceInformation(composer2, "C(elevatedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)606@28941L11:Button.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507908383, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:606)");
        }
        ButtonColors r1 = getDefaultElevatedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1547copyjRlVdoo(r5, r7, r9, r11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ButtonColors getDefaultElevatedButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ButtonColors defaultElevatedButtonColorsCached$material3_release = colorScheme.getDefaultElevatedButtonColorsCached$material3_release();
        if (defaultElevatedButtonColorsCached$material3_release != null) {
            return defaultElevatedButtonColorsCached$material3_release;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme2, ElevatedButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme2, ElevatedButtonTokens.INSTANCE.getLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, ElevatedButtonTokens.INSTANCE.getDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultElevatedButtonColorsCached$material3_release(buttonColors);
        return buttonColors;
    }

    public final ButtonColors filledTonalButtonColors(Composer composer, int i) {
        composer.startReplaceableGroup(824987837);
        ComposerKt.sourceInformation(composer, "C(filledTonalButtonColors)632@30162L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(824987837, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:632)");
        }
        ButtonColors defaultFilledTonalButtonColors$material3_release = getDefaultFilledTonalButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultFilledTonalButtonColors$material3_release;
    }

    /* renamed from: filledTonalButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1556filledTonalButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1670757653);
        ComposerKt.sourceInformation(composer2, "C(filledTonalButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)649@31034L11:Button.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670757653, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:649)");
        }
        ButtonColors r1 = getDefaultFilledTonalButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1547copyjRlVdoo(r5, r7, r9, r11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ButtonColors getDefaultFilledTonalButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ButtonColors defaultFilledTonalButtonColorsCached$material3_release = colorScheme.getDefaultFilledTonalButtonColorsCached$material3_release();
        if (defaultFilledTonalButtonColorsCached$material3_release != null) {
            return defaultFilledTonalButtonColorsCached$material3_release;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme2, FilledTonalButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTonalButtonTokens.INSTANCE.getLabelTextColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultFilledTonalButtonColorsCached$material3_release(buttonColors);
        return buttonColors;
    }

    public final ButtonColors outlinedButtonColors(Composer composer, int i) {
        composer.startReplaceableGroup(-1344886725);
        ComposerKt.sourceInformation(composer, "C(outlinedButtonColors)675@32279L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344886725, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:675)");
        }
        ButtonColors defaultOutlinedButtonColors$material3_release = getDefaultOutlinedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedButtonColors$material3_release;
    }

    /* renamed from: outlinedButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1562outlinedButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1778526249);
        ComposerKt.sourceInformation(composer2, "C(outlinedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)692@33130L11:Button.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778526249, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:692)");
        }
        ButtonColors r1 = getDefaultOutlinedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1547copyjRlVdoo(r5, r7, r9, r11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ButtonColors getDefaultOutlinedButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ButtonColors defaultOutlinedButtonColorsCached$material3_release = colorScheme.getDefaultOutlinedButtonColorsCached$material3_release();
        if (defaultOutlinedButtonColorsCached$material3_release != null) {
            return defaultOutlinedButtonColorsCached$material3_release;
        }
        ButtonColors buttonColors = new ButtonColors(Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, OutlinedButtonTokens.INSTANCE.getLabelTextColor()), Color.Companion.m3851getTransparent0d7_KjU(), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultOutlinedButtonColorsCached$material3_release(buttonColors);
        return buttonColors;
    }

    public final ButtonColors textButtonColors(Composer composer, int i) {
        composer.startReplaceableGroup(1880341584);
        ComposerKt.sourceInformation(composer, "C(textButtonColors)717@34189L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1880341584, i, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:717)");
        }
        ButtonColors defaultTextButtonColors$material3_release = getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextButtonColors$material3_release;
    }

    /* renamed from: textButtonColors-ro_MJ88  reason: not valid java name */
    public final ButtonColors m1563textButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1402274782);
        ComposerKt.sourceInformation(composer2, "C(textButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)734@35007L11:Button.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, i, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:734)");
        }
        ButtonColors r1 = getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m1547copyjRlVdoo(r5, r7, r9, r11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final ButtonColors getDefaultTextButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ButtonColors defaultTextButtonColorsCached$material3_release = colorScheme.getDefaultTextButtonColorsCached$material3_release();
        if (defaultTextButtonColorsCached$material3_release != null) {
            return defaultTextButtonColorsCached$material3_release;
        }
        ButtonColors buttonColors = new ButtonColors(Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, TextButtonTokens.INSTANCE.getLabelTextColor()), Color.Companion.m3851getTransparent0d7_KjU(), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, TextButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultTextButtonColorsCached$material3_release(buttonColors);
        return buttonColors;
    }

    /* renamed from: buttonElevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m1553buttonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1827791191);
        ComposerKt.sourceInformation(composer2, "C(buttonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? FilledButtonTokens.INSTANCE.m2887getContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? FilledButtonTokens.INSTANCE.m2893getPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? FilledButtonTokens.INSTANCE.m2890getFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? FilledButtonTokens.INSTANCE.m2891getHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? FilledButtonTokens.INSTANCE.m2889getDisabledContainerElevationD9Ej5fM() : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, i, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:772)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(r4, r5, r6, r7, r8, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    /* renamed from: elevatedButtonElevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m1555elevatedButtonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1065482445);
        ComposerKt.sourceInformation(composer2, "C(elevatedButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? ElevatedButtonTokens.INSTANCE.m2803getContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? ElevatedButtonTokens.INSTANCE.m2809getPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? ElevatedButtonTokens.INSTANCE.m2806getFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? ElevatedButtonTokens.INSTANCE.m2807getHoverContainerElevationD9Ej5fM() : f4;
        float r8 = (i2 & 16) != 0 ? ElevatedButtonTokens.INSTANCE.m2805getDisabledContainerElevationD9Ej5fM() : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1065482445, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:798)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(r4, r5, r6, r7, r8, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    /* renamed from: filledTonalButtonElevation-R_JCAzs  reason: not valid java name */
    public final ButtonElevation m1557filledTonalButtonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        float f6;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(5982871);
        ComposerKt.sourceInformation(composer2, "C(filledTonalButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        float r4 = (i2 & 1) != 0 ? FilledTonalButtonTokens.INSTANCE.m2910getContainerElevationD9Ej5fM() : f;
        float r5 = (i2 & 2) != 0 ? FilledTonalButtonTokens.INSTANCE.m2916getPressedContainerElevationD9Ej5fM() : f2;
        float r6 = (i2 & 4) != 0 ? FilledTonalButtonTokens.INSTANCE.m2913getFocusContainerElevationD9Ej5fM() : f3;
        float r7 = (i2 & 8) != 0 ? FilledTonalButtonTokens.INSTANCE.m2914getHoverContainerElevationD9Ej5fM() : f4;
        if ((i2 & 16) != 0) {
            f6 = Dp.m6614constructorimpl((float) 0);
        } else {
            f6 = f5;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5982871, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:825)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(r4, r5, r6, r7, f6, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buttonElevation;
    }

    public final BorderStroke getOutlinedButtonBorder(Composer composer, int i) {
        composer.startReplaceableGroup(-563957672);
        ComposerKt.sourceInformation(composer, "C838@40260L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563957672, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:836)");
        }
        BorderStroke r5 = BorderStrokeKt.m241BorderStrokecXLIe8U(OutlinedButtonTokens.INSTANCE.m2995getOutlineWidthD9Ej5fM(), ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r5;
    }

    static {
        float r0 = Dp.m6614constructorimpl((float) 24);
        ButtonHorizontalPadding = r0;
        float f = (float) 8;
        float r2 = Dp.m6614constructorimpl(f);
        ButtonVerticalPadding = r2;
        PaddingValues r3 = PaddingKt.m666PaddingValuesa9UjIt4(r0, r2, r0, r2);
        ContentPadding = r3;
        float f2 = (float) 16;
        float r5 = Dp.m6614constructorimpl(f2);
        ButtonWithIconHorizontalStartPadding = r5;
        ButtonWithIconContentPadding = PaddingKt.m666PaddingValuesa9UjIt4(r5, r2, r0, r2);
        float r02 = Dp.m6614constructorimpl((float) 12);
        TextButtonHorizontalPadding = r02;
        TextButtonContentPadding = PaddingKt.m666PaddingValuesa9UjIt4(r02, r3.m687calculateTopPaddingD9Ej5fM(), r02, r3.m684calculateBottomPaddingD9Ej5fM());
        float r22 = Dp.m6614constructorimpl(f2);
        TextButtonWithIconHorizontalEndPadding = r22;
        TextButtonWithIconContentPadding = PaddingKt.m666PaddingValuesa9UjIt4(r02, r3.m687calculateTopPaddingD9Ej5fM(), r22, r3.m684calculateBottomPaddingD9Ej5fM());
        IconSpacing = Dp.m6614constructorimpl(f);
    }
}
