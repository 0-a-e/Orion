package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionRegistrarImpl.kt */
final class SelectionRegistrarImpl$Companion$Saver$2 extends Lambda implements Function1<Long, SelectionRegistrarImpl> {
    public static final SelectionRegistrarImpl$Companion$Saver$2 INSTANCE = new SelectionRegistrarImpl$Companion$Saver$2();

    SelectionRegistrarImpl$Companion$Saver$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    public final SelectionRegistrarImpl invoke(long j) {
        return new SelectionRegistrarImpl(j, (DefaultConstructorMarker) null);
    }
}
