package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/Shadow;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$ShadowSaver$2 extends Lambda implements Function1<Object, Shadow> {
    public static final SaversKt$ShadowSaver$2 INSTANCE = new SaversKt$ShadowSaver$2();

    SaversKt$ShadowSaver$2() {
        super(1);
    }

    public final Shadow invoke(Object obj) {
        Color color;
        Offset offset;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<Color, Object> saver = SaversKt.getSaver(Color.Companion);
        Float f = null;
        if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
            color = saver.restore(obj2);
        } else {
            color = null;
        }
        Intrinsics.checkNotNull(color);
        long r2 = color.m3826unboximpl();
        Object obj3 = list.get(1);
        Saver<Offset, Object> saver2 = SaversKt.getSaver(Offset.Companion);
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
            offset = saver2.restore(obj3);
        } else {
            offset = null;
        }
        Intrinsics.checkNotNull(offset);
        long r5 = offset.m3572unboximpl();
        Object obj4 = list.get(2);
        if (obj4 != null) {
            f = (Float) obj4;
        }
        Intrinsics.checkNotNull(f);
        return new Shadow(r2, r5, f.floatValue(), (DefaultConstructorMarker) null);
    }
}
