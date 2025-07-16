package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "invoke", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarInputField$5 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBarInputField$5(String str, boolean z, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextFieldColors textFieldColors) {
        super(3);
        this.$query = str;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$placeholder = function2;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$colors = textFieldColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C492@23058L15,478@22354L880:SearchBar.android.kt#uh7d8r");
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        if ((i & 6) == 0) {
            i2 = i | (composer2.changedInstance(function22) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-951844929, i2, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.android.kt:478)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String str = this.$query;
            boolean z = this.$enabled;
            VisualTransformation none = VisualTransformation.Companion.getNone();
            InteractionSource interactionSource = this.$interactionSource;
            Function2<Composer, Integer, Unit> function23 = this.$placeholder;
            Function2<Composer, Integer, Unit> function24 = this.$leadingIcon;
            Function2 composableLambda = function24 != null ? ComposableLambdaKt.composableLambda(composer2, -1030845367, true, new SearchBar_androidKt$SearchBarInputField$5$1$1(function24)) : null;
            Function2<Composer, Integer, Unit> function25 = this.$trailingIcon;
            textFieldDefaults.DecorationBox(str, function2, z, true, none, interactionSource, false, (Function2<? super Composer, ? super Integer, Unit>) null, function23, composableLambda, function25 != null ? ComposableLambdaKt.composableLambda(composer2, -1558904811, true, new SearchBar_androidKt$SearchBarInputField$5$2$1(function25)) : null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer2, 6), this.$colors, TextFieldDefaults.m2416contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, (Object) null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m1720getLambda1$material3_release(), composer, ((i2 << 3) & 112) | 27648, 113246208, 14528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
