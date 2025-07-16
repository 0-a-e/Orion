package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/runtime/saveable/SaverScope;J)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$OffsetSaver$1 extends Lambda implements Function2<SaverScope, Offset, Object> {
    public static final SaversKt$OffsetSaver$1 INSTANCE = new SaversKt$OffsetSaver$1();

    SaversKt$OffsetSaver$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m5985invokeUv8p0NA((SaverScope) obj, ((Offset) obj2).m3572unboximpl());
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final Object m5985invokeUv8p0NA(SaverScope saverScope, long j) {
        if (Offset.m3559equalsimpl0(j, Offset.Companion.m3577getUnspecifiedF1C5BW0())) {
            return (Serializable) false;
        }
        return CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(Offset.m3562getXimpl(j))), SaversKt.save(Float.valueOf(Offset.m3563getYimpl(j))));
    }
}
