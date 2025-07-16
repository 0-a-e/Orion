package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/UrlAnnotation;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$UrlAnnotationSaver$2 extends Lambda implements Function1<Object, UrlAnnotation> {
    public static final SaversKt$UrlAnnotationSaver$2 INSTANCE = new SaversKt$UrlAnnotationSaver$2();

    SaversKt$UrlAnnotationSaver$2() {
        super(1);
    }

    public final UrlAnnotation invoke(Object obj) {
        String str;
        if (obj != null) {
            str = (String) obj;
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        return new UrlAnnotation(str);
    }
}
