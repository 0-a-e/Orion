package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "textLayoutResult", "", "Landroidx/compose/ui/text/TextLayoutResult;", "invoke", "(Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextStringSimpleNode.kt */
final class TextStringSimpleNode$applySemantics$1 extends Lambda implements Function1<List<TextLayoutResult>, Boolean> {
    final /* synthetic */ TextStringSimpleNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextStringSimpleNode$applySemantics$1(TextStringSimpleNode textStringSimpleNode) {
        super(1);
        this.this$0 = textStringSimpleNode;
    }

    public final Boolean invoke(List<TextLayoutResult> list) {
        ParagraphLayoutCache access$getLayoutCache = this.this$0.getLayoutCache();
        TextStyle access$getStyle$p = this.this$0.style;
        ColorProducer access$getOverrideColor$p = this.this$0.overrideColor;
        TextLayoutResult slowCreateTextLayoutResultOrNull = access$getLayoutCache.slowCreateTextLayoutResultOrNull(TextStyle.m6062mergedA7vx0o$default(access$getStyle$p, access$getOverrideColor$p != null ? access$getOverrideColor$p.m3897invoke0d7_KjU() : Color.Companion.m3852getUnspecified0d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16777214, (Object) null));
        if (slowCreateTextLayoutResultOrNull != null) {
            list.add(slowCreateTextLayoutResultOrNull);
        } else {
            slowCreateTextLayoutResultOrNull = null;
        }
        return Boolean.valueOf(slowCreateTextLayoutResultOrNull != null);
    }
}
