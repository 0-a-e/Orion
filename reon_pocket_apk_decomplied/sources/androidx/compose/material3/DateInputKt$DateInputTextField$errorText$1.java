package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MutableState;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$errorText$1 extends Lambda implements Function0<MutableState<String>> {
    public static final DateInputKt$DateInputTextField$errorText$1 INSTANCE = new DateInputKt$DateInputTextField$errorText$1();

    DateInputKt$DateInputTextField$errorText$1() {
        super(0);
    }

    public final MutableState<String> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
