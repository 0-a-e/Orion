package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJ:\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/RadioButtonDefaults;", "", "()V", "defaultRadioButtonColors", "Landroidx/compose/material3/RadioButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultRadioButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RadioButtonColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RadioButtonColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    public final RadioButtonColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-1191566130);
        ComposerKt.sourceInformation(composer, "C(colors)139@5810L11:RadioButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1191566130, i, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:139)");
        }
        RadioButtonColors defaultRadioButtonColors$material3_release = getDefaultRadioButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultRadioButtonColors$material3_release;
    }

    /* renamed from: colors-ro_MJ88  reason: not valid java name */
    public final RadioButtonColors m2089colorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-351083046);
        ComposerKt.sourceInformation(composer2, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)158@6771L11:RadioButton.kt#uh7d8r");
        long r5 = (i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r7 = (i2 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r9 = (i2 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r11 = (i2 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-351083046, i, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:158)");
        }
        RadioButtonColors r1 = getDefaultRadioButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer2, 6)).m2084copyjRlVdoo(r5, r7, r9, r11);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final RadioButtonColors getDefaultRadioButtonColors$material3_release(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        RadioButtonColors defaultRadioButtonColorsCached$material3_release = colorScheme.getDefaultRadioButtonColorsCached$material3_release();
        if (defaultRadioButtonColorsCached$material3_release != null) {
            return defaultRadioButtonColorsCached$material3_release;
        }
        RadioButtonColors radioButtonColors = new RadioButtonColors(ColorSchemeKt.fromToken(colorScheme2, RadioButtonTokens.INSTANCE.getSelectedIconColor()), ColorSchemeKt.fromToken(colorScheme2, RadioButtonTokens.INSTANCE.getUnselectedIconColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, RadioButtonTokens.INSTANCE.getDisabledSelectedIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, RadioButtonTokens.INSTANCE.getDisabledUnselectedIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultRadioButtonColorsCached$material3_release(radioButtonColors);
        return radioButtonColors;
    }
}
