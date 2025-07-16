package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "", "getIndex", "", "key", "getKey", "index", "Empty", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutKeyIndexMap.kt */
public interface LazyLayoutKeyIndexMap {
    public static final Empty Empty = Empty.$$INSTANCE;

    int getIndex(Object obj);

    Object getKey(int i);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap$Empty;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "()V", "getIndex", "", "key", "", "getKey", "", "index", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutKeyIndexMap.kt */
    public static final class Empty implements LazyLayoutKeyIndexMap {
        static final /* synthetic */ Empty $$INSTANCE = new Empty();

        public int getIndex(Object obj) {
            return -1;
        }

        public Void getKey(int i) {
            return null;
        }

        private Empty() {
        }
    }
}
