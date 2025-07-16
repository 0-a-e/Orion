package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClickableText.kt */
final class ClickableTextKt$ClickableText$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Integer, Unit> $onClick;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ int $overflow;
    final /* synthetic */ boolean $softWrap;
    final /* synthetic */ TextStyle $style;
    final /* synthetic */ AnnotatedString $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableTextKt$ClickableText$3(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1<? super TextLayoutResult, Unit> function1, Function1<? super Integer, Unit> function12, int i3, int i4) {
        super(2);
        this.$text = annotatedString;
        this.$modifier = modifier;
        this.$style = textStyle;
        this.$softWrap = z;
        this.$overflow = i;
        this.$maxLines = i2;
        this.$onTextLayout = function1;
        this.$onClick = function12;
        this.$$changed = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ClickableTextKt.m1053ClickableText4YKlhWE(this.$text, this.$modifier, this.$style, this.$softWrap, this.$overflow, this.$maxLines, this.$onTextLayout, this.$onClick, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
