package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Original", "Saveable", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListSaver.kt */
final class ListSaverKt$listSaver$1 extends Lambda implements Function2<SaverScope, Original, Object> {
    final /* synthetic */ Function2<SaverScope, Original, List<Saveable>> $save;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListSaverKt$listSaver$1(Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> function2) {
        super(2);
        this.$save = function2;
    }

    public final Object invoke(SaverScope saverScope, Original original) {
        List invoke = this.$save.invoke(saverScope, original);
        int size = invoke.size();
        int i = 0;
        while (i < size) {
            Object obj = invoke.get(i);
            if (obj == null || saverScope.canBeSaved(obj)) {
                i++;
            } else {
                throw new IllegalArgumentException("item can't be saved".toString());
            }
        }
        Collection collection = invoke;
        if (!collection.isEmpty()) {
            return new ArrayList(collection);
        }
        return null;
    }
}
