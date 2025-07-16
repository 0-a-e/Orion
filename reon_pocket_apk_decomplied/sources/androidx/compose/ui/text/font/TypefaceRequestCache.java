package androidx.compose.ui.text.font;

import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J(\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0017J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u0010\u001a\u00020\t2\u001e\u0010\u0016\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0017\u0012\u0004\u0012\u00020\n0\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceRequestCache;", "", "()V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text_release", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "resultCache", "Landroidx/compose/ui/text/caches/LruCache;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/TypefaceResult;", "size", "", "getSize$ui_text_release", "()I", "get", "typefaceRequest", "get$ui_text_release", "preWarmCache", "", "typefaceRequests", "", "resolveTypeface", "Lkotlin/Function1;", "runCached", "Landroidx/compose/runtime/State;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
public final class TypefaceRequestCache {
    public static final int $stable = 8;
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();
    /* access modifiers changed from: private */
    public final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>(16);

    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r5 = (androidx.compose.ui.text.font.TypefaceResult) r5.invoke(new androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r0 = r3.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r3.resultCache.get(r4) != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r5.getCacheable() == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        r3.resultCache.put(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0054, code lost:
        throw new java.lang.IllegalStateException("Could not load font", r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.State<java.lang.Object> runCached(androidx.compose.ui.text.font.TypefaceRequest r4, kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.font.TypefaceResult, kotlin.Unit>, ? extends androidx.compose.ui.text.font.TypefaceResult> r5) {
        /*
            r3 = this;
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r3.lock
            monitor-enter(r0)
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x0055 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0055 }
            androidx.compose.ui.text.font.TypefaceResult r1 = (androidx.compose.ui.text.font.TypefaceResult) r1     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x001f
            boolean r2 = r1.getCacheable()     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0017
            androidx.compose.runtime.State r1 = (androidx.compose.runtime.State) r1     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)
            return r1
        L_0x0017:
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x0055 }
            java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x0055 }
            androidx.compose.ui.text.font.TypefaceResult r1 = (androidx.compose.ui.text.font.TypefaceResult) r1     // Catch:{ all -> 0x0055 }
        L_0x001f:
            monitor-exit(r0)
            androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1 r0 = new androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1     // Catch:{ Exception -> 0x004a }
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x004a }
            java.lang.Object r5 = r5.invoke(r0)     // Catch:{ Exception -> 0x004a }
            androidx.compose.ui.text.font.TypefaceResult r5 = (androidx.compose.ui.text.font.TypefaceResult) r5     // Catch:{ Exception -> 0x004a }
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r3.lock
            monitor-enter(r0)
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x0047 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0041
            boolean r1 = r5.getCacheable()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0041
            androidx.compose.ui.text.caches.LruCache<androidx.compose.ui.text.font.TypefaceRequest, androidx.compose.ui.text.font.TypefaceResult> r1 = r3.resultCache     // Catch:{ all -> 0x0047 }
            r1.put(r4, r5)     // Catch:{ all -> 0x0047 }
        L_0x0041:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)
            androidx.compose.runtime.State r5 = (androidx.compose.runtime.State) r5
            return r5
        L_0x0047:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x004a:
            r4 = move-exception
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Could not load font"
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r5.<init>(r0, r4)
            throw r5
        L_0x0055:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.TypefaceRequestCache.runCached(androidx.compose.ui.text.font.TypefaceRequest, kotlin.jvm.functions.Function1):androidx.compose.runtime.State");
    }

    public final void preWarmCache(List<TypefaceRequest> list, Function1<? super TypefaceRequest, ? extends TypefaceResult> function1) {
        TypefaceResult typefaceResult;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TypefaceRequest typefaceRequest = list.get(i);
            synchronized (this.lock) {
                typefaceResult = this.resultCache.get(typefaceRequest);
            }
            if (typefaceResult == null) {
                try {
                    TypefaceResult typefaceResult2 = (TypefaceResult) function1.invoke(typefaceRequest);
                    if (!(typefaceResult2 instanceof TypefaceResult.Async)) {
                        synchronized (this.lock) {
                            TypefaceResult put = this.resultCache.put(typefaceRequest, typefaceResult2);
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("Could not load font", e);
                }
            }
        }
    }

    public final TypefaceResult get$ui_text_release(TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResult;
        synchronized (this.lock) {
            typefaceResult = this.resultCache.get(typefaceRequest);
        }
        return typefaceResult;
    }

    public final int getSize$ui_text_release() {
        int size;
        synchronized (this.lock) {
            size = this.resultCache.size();
        }
        return size;
    }
}
