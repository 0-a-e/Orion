package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "()V", "prefetcher", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "getPrefetcher$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "setPrefetcher$foundation_release", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;)V", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "PrefetchHandle", "Prefetcher", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetchState.kt */
public final class LazyLayoutPrefetchState {
    public static final int $stable = 0;
    private Prefetcher prefetcher;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u0001\u0002\u0004\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$PrefetchRequest;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutPrefetchState.kt */
    public interface PrefetchHandle {
        void cancel();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$Prefetcher;", "", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyLayoutPrefetchState.kt */
    public interface Prefetcher {
        /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
        PrefetchHandle m902schedulePrefetch0kLqBqw(int i, long j);
    }

    public final Prefetcher getPrefetcher$foundation_release() {
        return this.prefetcher;
    }

    public final void setPrefetcher$foundation_release(Prefetcher prefetcher2) {
        this.prefetcher = prefetcher2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.m902schedulePrefetch0kLqBqw(r2, r3);
     */
    /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle m901schedulePrefetch0kLqBqw(int r2, long r3) {
        /*
            r1 = this;
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$Prefetcher r0 = r1.prefetcher
            if (r0 == 0) goto L_0x000a
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r2 = r0.m902schedulePrefetch0kLqBqw(r2, r3)
            if (r2 != 0) goto L_0x000e
        L_0x000a:
            androidx.compose.foundation.lazy.layout.DummyHandle r2 = androidx.compose.foundation.lazy.layout.DummyHandle.INSTANCE
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r2 = (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle) r2
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.m901schedulePrefetch0kLqBqw(int, long):androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle");
    }
}
