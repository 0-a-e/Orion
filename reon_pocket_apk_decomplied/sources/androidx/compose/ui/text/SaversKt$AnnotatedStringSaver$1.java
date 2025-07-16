package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/AnnotatedString;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotatedStringSaver$1 extends Lambda implements Function2<SaverScope, AnnotatedString, Object> {
    public static final SaversKt$AnnotatedStringSaver$1 INSTANCE = new SaversKt$AnnotatedStringSaver$1();

    SaversKt$AnnotatedStringSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope saverScope, AnnotatedString annotatedString) {
        return CollectionsKt.arrayListOf(SaversKt.save(annotatedString.getText()), SaversKt.save(annotatedString.getSpanStyles(), SaversKt.AnnotationRangeListSaver, saverScope), SaversKt.save(annotatedString.getParagraphStyles(), SaversKt.AnnotationRangeListSaver, saverScope), SaversKt.save(annotatedString.getAnnotations$ui_text_release(), SaversKt.AnnotationRangeListSaver, saverScope));
    }
}
