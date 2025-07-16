package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/HotReloader;", "", "()V", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HotReloader.kt */
final class HotReloader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0002J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0001H\u0001¢\u0006\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/HotReloader$Companion;", "", "()V", "clearErrors", "", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndCompose", "token", "saveStateAndDispose", "context", "simulateHotReload", "simulateHotReload$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HotReloader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Object saveStateAndDispose(Object obj) {
            return Recomposer.Companion.saveStateAndDisposeForHotReload$runtime_release();
        }

        private final void loadStateAndCompose(Object obj) {
            Recomposer.Companion.loadStateAndComposeForHotReload$runtime_release(obj);
        }

        public final void simulateHotReload$runtime_release(Object obj) {
            loadStateAndCompose(saveStateAndDispose(obj));
        }

        public final void invalidateGroupsWithKey$runtime_release(int i) {
            Recomposer.Companion.invalidateGroupsWithKey$runtime_release(i);
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            return Recomposer.Companion.getCurrentErrors$runtime_release();
        }

        public final void clearErrors$runtime_release() {
            Recomposer.Companion.clearErrors$runtime_release();
        }
    }
}
