package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
final class TextFieldScrollKt$textFieldScrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldScrollKt$textFieldScrollable$2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z, MutableInteractionSource mutableInteractionSource) {
        super(3);
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceableGroup(805428266);
        ComposerKt.sourceInformation(composer, "C68@2901L7,70@3046L412,83@3610L352:TextFieldScroll.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(805428266, i, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:68)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = this.$scrollerPosition.getOrientation() == Orientation.Vertical || !(consume == LayoutDirection.Rtl);
        composer.startReplaceableGroup(753734506);
        boolean changed = composer.changed((Object) this.$scrollerPosition);
        TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1(textFieldScrollerPosition);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ScrollableState rememberScrollableState = ScrollableStateKt.rememberScrollableState((Function1) rememberedValue, composer, 0);
        TextFieldScrollerPosition textFieldScrollerPosition2 = this.$scrollerPosition;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed2 = composer.changed((Object) rememberScrollableState) | composer.changed((Object) textFieldScrollerPosition2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1(rememberScrollableState, textFieldScrollerPosition2);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier scrollable$default = ScrollableKt.scrollable$default(Modifier.Companion, (TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) rememberedValue2, this.$scrollerPosition.getOrientation(), this.$enabled && this.$scrollerPosition.getMaximum() != 0.0f, z, (FlingBehavior) null, this.$interactionSource, 16, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scrollable$default;
    }
}
