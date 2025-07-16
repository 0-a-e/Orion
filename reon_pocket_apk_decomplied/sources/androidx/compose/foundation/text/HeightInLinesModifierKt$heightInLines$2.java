package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: HeightInLinesModifier.kt */
final class HeightInLinesModifierKt$heightInLines$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeightInLinesModifierKt$heightInLines$2(int i, int i2, TextStyle textStyle) {
        super(3);
        this.$minLines = i;
        this.$maxLines = i2;
        this.$textStyle = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(408240218);
        ComposerKt.sourceInformation(composer2, "C62@2391L7,63@2452L7,64@2507L7,68@2678L96,71@2795L312,80@3135L366,96@3533L428:HeightInLinesModifier.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(408240218, i, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:59)");
        }
        HeightInLinesModifierKt.validateMinMaxLines(this.$minLines, this.$maxLines);
        if (this.$minLines == 1 && this.$maxLines == Integer.MAX_VALUE) {
            Modifier.Companion companion = Modifier.Companion;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return companion;
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        ComposerKt.sourceInformationMarkerEnd(composer);
        FontFamily.Resolver resolver = (FontFamily.Resolver) consume2;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        TextStyle textStyle = this.$textStyle;
        composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer2.changed((Object) textStyle) | composer2.changed((Object) layoutDirection);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TextStyle textStyle2 = (TextStyle) rememberedValue;
        composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed2 = composer2.changed((Object) resolver) | composer2.changed((Object) textStyle2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            FontFamily fontFamily = textStyle2.getFontFamily();
            FontWeight fontWeight = textStyle2.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r9 = textStyle2.m6074getFontStyle4Lr2A7w();
            int r92 = r9 != null ? r9.m6161unboximpl() : FontStyle.Companion.m6165getNormal_LCdwA();
            FontSynthesis r10 = textStyle2.m6075getFontSynthesisZQGJjVo();
            rememberedValue2 = resolver.m6131resolveDPcqOEQ(fontFamily, fontWeight, r92, r10 != null ? r10.m6174unboximpl() : FontSynthesis.Companion.m6175getAllGVVA2EU());
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        State state = (State) rememberedValue2;
        Object[] objArr = {density, resolver, this.$textStyle, layoutDirection, invoke$lambda$2(state)};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z = false;
        for (int i2 = 0; i2 < 5; i2++) {
            z |= composer2.changed(objArr[i2]);
        }
        Object rememberedValue3 = composer.rememberedValue();
        if (z || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = Integer.valueOf(IntSize.m6789getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        int intValue = ((Number) rememberedValue3).intValue();
        Object[] objArr2 = {density, resolver, this.$textStyle, layoutDirection, invoke$lambda$2(state)};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z2 = false;
        for (int i3 = 0; i3 < 5; i3++) {
            z2 |= composer2.changed(objArr2[i3]);
        }
        Object rememberedValue4 = composer.rememberedValue();
        if (z2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = Integer.valueOf(IntSize.m6789getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + 10 + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
            composer2.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        int intValue2 = ((Number) rememberedValue4).intValue() - intValue;
        int i4 = this.$minLines;
        Integer num = null;
        Integer valueOf = i4 == 1 ? null : Integer.valueOf(((i4 - 1) * intValue2) + intValue);
        int i5 = this.$maxLines;
        if (i5 != Integer.MAX_VALUE) {
            num = Integer.valueOf(intValue + (intValue2 * (i5 - 1)));
        }
        Modifier r2 = SizeKt.m729heightInVpY3zN4(Modifier.Companion, valueOf != null ? density.m6547toDpu2uoSUM(valueOf.intValue()) : Dp.Companion.m6634getUnspecifiedD9Ej5fM(), num != null ? density.m6547toDpu2uoSUM(num.intValue()) : Dp.Companion.m6634getUnspecifiedD9Ej5fM());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r2;
    }

    private static final Object invoke$lambda$2(State<? extends Object> state) {
        return state.getValue();
    }
}
