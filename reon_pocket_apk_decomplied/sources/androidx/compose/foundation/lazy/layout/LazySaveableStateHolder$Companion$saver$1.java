package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
final class LazySaveableStateHolder$Companion$saver$1 extends Lambda implements Function2<SaverScope, LazySaveableStateHolder, Map<String, ? extends List<? extends Object>>> {
    public static final LazySaveableStateHolder$Companion$saver$1 INSTANCE = new LazySaveableStateHolder$Companion$saver$1();

    LazySaveableStateHolder$Companion$saver$1() {
        super(2);
    }

    public final Map<String, List<Object>> invoke(SaverScope saverScope, LazySaveableStateHolder lazySaveableStateHolder) {
        Map<String, List<Object>> performSave = lazySaveableStateHolder.performSave();
        if (performSave.isEmpty()) {
            return null;
        }
        return performSave;
    }
}
