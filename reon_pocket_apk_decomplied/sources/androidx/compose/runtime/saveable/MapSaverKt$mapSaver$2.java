package androidx.compose.runtime.saveable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "list", "", "", "invoke", "(Ljava/util/List;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MapSaver.kt */
final class MapSaverKt$mapSaver$2 extends Lambda implements Function1<List<? extends Object>, T> {
    final /* synthetic */ Function1<Map<String, ? extends Object>, T> $restore;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapSaverKt$mapSaver$2(Function1<? super Map<String, ? extends Object>, ? extends T> function1) {
        super(1);
        this.$restore = function1;
    }

    public final T invoke(List<? extends Object> list) {
        Map linkedHashMap = new LinkedHashMap();
        if (list.size() % 2 == 0) {
            for (int i = 0; i < list.size(); i += 2) {
                Object obj = list.get(i);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, list.get(i + 1));
            }
            return this.$restore.invoke(linkedHashMap);
        }
        throw new IllegalStateException("non-zero remainder".toString());
    }
}
