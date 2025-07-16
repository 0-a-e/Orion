package androidx.compose.material3;

import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Text.kt */
final class TextKt$Text$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ FontFamily $fontFamily;
    final /* synthetic */ long $fontSize;
    final /* synthetic */ FontStyle $fontStyle;
    final /* synthetic */ FontWeight $fontWeight;
    final /* synthetic */ Map<String, InlineTextContent> $inlineContent;
    final /* synthetic */ long $letterSpacing;
    final /* synthetic */ long $lineHeight;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ int $overflow;
    final /* synthetic */ boolean $softWrap;
    final /* synthetic */ TextStyle $style;
    final /* synthetic */ AnnotatedString $text;
    final /* synthetic */ TextAlign $textAlign;
    final /* synthetic */ TextDecoration $textDecoration;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextKt$Text$5(AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, int i4, int i5, int i6) {
        super(2);
        this.$text = annotatedString;
        this.$modifier = modifier;
        this.$color = j;
        this.$fontSize = j2;
        this.$fontStyle = fontStyle;
        this.$fontWeight = fontWeight;
        this.$fontFamily = fontFamily;
        this.$letterSpacing = j3;
        this.$textDecoration = textDecoration;
        this.$textAlign = textAlign;
        this.$lineHeight = j4;
        this.$overflow = i;
        this.$softWrap = z;
        this.$maxLines = i2;
        this.$minLines = i3;
        this.$inlineContent = map;
        this.$onTextLayout = function1;
        this.$style = textStyle;
        this.$$changed = i4;
        this.$$changed1 = i5;
        this.$$default = i6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        AnnotatedString annotatedString = this.$text;
        AnnotatedString annotatedString2 = annotatedString;
        TextKt.m2457TextIbK3jfQ(annotatedString2, this.$modifier, this.$color, this.$fontSize, this.$fontStyle, this.$fontWeight, this.$fontFamily, this.$letterSpacing, this.$textDecoration, this.$textAlign, this.$lineHeight, this.$overflow, this.$softWrap, this.$maxLines, this.$minLines, this.$inlineContent, this.$onTextLayout, this.$style, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
