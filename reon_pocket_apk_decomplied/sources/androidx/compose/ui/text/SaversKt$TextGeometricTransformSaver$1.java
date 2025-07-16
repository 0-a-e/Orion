package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextGeometricTransform;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$TextGeometricTransformSaver$1 extends Lambda implements Function2<SaverScope, TextGeometricTransform, Object> {
    public static final SaversKt$TextGeometricTransformSaver$1 INSTANCE = new SaversKt$TextGeometricTransformSaver$1();

    SaversKt$TextGeometricTransformSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
        return CollectionsKt.arrayListOf(Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX()));
    }
}
