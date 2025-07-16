package androidx.compose.ui.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"DefaultCacheSize", "", "rememberTextMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "cacheSize", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/TextMeasurer;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextMeasurerHelper.kt */
public final class TextMeasurerHelperKt {
    private static final int DefaultCacheSize = 8;

    public static final TextMeasurer rememberTextMeasurer(int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1538166871);
        ComposerKt.sourceInformation(composer, "C(rememberTextMeasurer)46@1995L7,47@2034L7,48@2089L7,50@2109L151:TextMeasurerHelper.kt#ruzxt2");
        if ((i3 & 1) != 0) {
            i = DefaultCacheSize;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1538166871, i2, -1, "androidx.compose.ui.text.rememberTextMeasurer (TextMeasurerHelper.kt:45)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        ComposerKt.sourceInformationMarkerEnd(composer);
        FontFamily.Resolver resolver = (FontFamily.Resolver) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        Object[] objArr = {resolver, density, layoutDirection, Integer.valueOf(i)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z = false;
        for (int i4 = 0; i4 < 4; i4++) {
            z |= composer.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextMeasurer(resolver, density, layoutDirection, i);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TextMeasurer textMeasurer = (TextMeasurer) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textMeasurer;
    }
}
