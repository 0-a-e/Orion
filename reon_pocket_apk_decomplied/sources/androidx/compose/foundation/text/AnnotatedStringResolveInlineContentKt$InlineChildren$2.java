package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnnotatedStringResolveInlineContent.kt */
final class AnnotatedStringResolveInlineContentKt$InlineChildren$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> $inlineContents;
    final /* synthetic */ AnnotatedString $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnnotatedStringResolveInlineContentKt$InlineChildren$2(AnnotatedString annotatedString, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list, int i) {
        super(2);
        this.$text = annotatedString;
        this.$inlineContents = list;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AnnotatedStringResolveInlineContentKt.InlineChildren(this.$text, this.$inlineContents, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
