package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AbstractPersistentList.kt */
final class AbstractPersistentList$removeAll$1 extends Lambda implements Function1<E, Boolean> {
    final /* synthetic */ Collection<E> $elements;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractPersistentList$removeAll$1(Collection<? extends E> collection) {
        super(1);
        this.$elements = collection;
    }

    public final Boolean invoke(E e) {
        return Boolean.valueOf(this.$elements.contains(e));
    }
}
