package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Vertices.kt */
final class Vertices$outOfBounds$1 extends Lambda implements Function1<Integer, Boolean> {
    final /* synthetic */ List<Offset> $positions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Vertices$outOfBounds$1(List<Offset> list) {
        super(1);
        this.$positions = list;
    }

    public final Boolean invoke(int i) {
        return Boolean.valueOf(i < 0 || i >= this.$positions.size());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
