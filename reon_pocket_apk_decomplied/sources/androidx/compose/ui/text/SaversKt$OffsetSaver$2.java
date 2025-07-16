package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "it", "", "invoke-x-9fifI"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$OffsetSaver$2 extends Lambda implements Function1<Object, Offset> {
    public static final SaversKt$OffsetSaver$2 INSTANCE = new SaversKt$OffsetSaver$2();

    SaversKt$OffsetSaver$2() {
        super(1);
    }

    /* renamed from: invoke-x-9fifI  reason: not valid java name */
    public final Offset invoke(Object obj) {
        Float f;
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return Offset.m3551boximpl(Offset.Companion.m3577getUnspecifiedF1C5BW0());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f2 = null;
        if (obj2 != null) {
            f = (Float) obj2;
        } else {
            f = null;
        }
        Intrinsics.checkNotNull(f);
        float floatValue = f.floatValue();
        Object obj3 = list.get(1);
        if (obj3 != null) {
            f2 = (Float) obj3;
        }
        Intrinsics.checkNotNull(f2);
        return Offset.m3551boximpl(OffsetKt.Offset(floatValue, f2.floatValue()));
    }
}
