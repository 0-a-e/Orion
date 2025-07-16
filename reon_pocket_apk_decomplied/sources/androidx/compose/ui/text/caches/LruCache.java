package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00012\b\u0010\u001f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\b\u001a\u00020\u0005J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010)J\u001d\u0010*\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010)J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,J$\u0010-\u001a\u0002H.\"\u0004\b\u0002\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\b¢\u0006\u0004\b1\u00102J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\fX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000ej\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00066"}, d2 = {"Landroidx/compose/ui/text/caches/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "keySet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "missCount", "monitor", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "putCount", "<set-?>", "size", "()I", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "synchronizedValue", "R", "block", "Lkotlin/Function0;", "synchronizedValue$ui_text_release", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toString", "", "trimToSize", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LruCache.kt */
public class LruCache<K, V> {
    public static final int $stable = 8;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    /* access modifiers changed from: private */
    public final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public LruCache(int i) {
        if (i > 0) {
            this.maxSize = i;
            this.map = new HashMap<>(0, 0.75f);
            this.keySet = new LinkedHashSet<>();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public void resize(int i) {
        if (i > 0) {
            synchronized (this.monitor) {
                this.maxSize = i;
                Unit unit = Unit.INSTANCE;
            }
            trimToSize(i);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = create(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r2 = r5.monitor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r5.createCount++;
        r3 = r5.map.put(r6, r0);
        r5.keySet.remove(r6);
        r5.keySet.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r3 == null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r5.map.put(r6, r3);
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r5.size = size() + safeSizeOf(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r1 == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        entryRemoved(false, r6, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        trimToSize(r5.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r6) {
        /*
            r5 = this;
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r5.monitor
            monitor-enter(r0)
            java.util.HashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x001d
            java.util.LinkedHashSet<K> r2 = r5.keySet     // Catch:{ all -> 0x006c }
            r2.remove(r6)     // Catch:{ all -> 0x006c }
            java.util.LinkedHashSet<K> r2 = r5.keySet     // Catch:{ all -> 0x006c }
            r2.add(r6)     // Catch:{ all -> 0x006c }
            int r6 = r5.hitCount     // Catch:{ all -> 0x006c }
            int r6 = r6 + 1
            r5.hitCount = r6     // Catch:{ all -> 0x006c }
            monitor-exit(r0)
            return r1
        L_0x001d:
            int r2 = r5.missCount     // Catch:{ all -> 0x006c }
            int r2 = r2 + 1
            r5.missCount = r2     // Catch:{ all -> 0x006c }
            monitor-exit(r0)
            java.lang.Object r0 = r5.create(r6)
            if (r0 != 0) goto L_0x002c
            r6 = 0
            return r6
        L_0x002c:
            androidx.compose.ui.text.platform.SynchronizedObject r2 = r5.monitor
            monitor-enter(r2)
            int r3 = r5.createCount     // Catch:{ all -> 0x0069 }
            int r3 = r3 + 1
            r5.createCount = r3     // Catch:{ all -> 0x0069 }
            java.util.HashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0069 }
            java.lang.Object r3 = r3.put(r6, r0)     // Catch:{ all -> 0x0069 }
            java.util.LinkedHashSet<K> r4 = r5.keySet     // Catch:{ all -> 0x0069 }
            r4.remove(r6)     // Catch:{ all -> 0x0069 }
            java.util.LinkedHashSet<K> r4 = r5.keySet     // Catch:{ all -> 0x0069 }
            r4.add(r6)     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x004e
            java.util.HashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0069 }
            r1.put(r6, r3)     // Catch:{ all -> 0x0069 }
            r1 = r3
            goto L_0x0059
        L_0x004e:
            int r3 = r5.size()     // Catch:{ all -> 0x0069 }
            int r4 = r5.safeSizeOf(r6, r0)     // Catch:{ all -> 0x0069 }
            int r3 = r3 + r4
            r5.size = r3     // Catch:{ all -> 0x0069 }
        L_0x0059:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0069 }
            monitor-exit(r2)
            if (r1 == 0) goto L_0x0063
            r2 = 0
            r5.entryRemoved(r2, r6, r0, r1)
            return r1
        L_0x0063:
            int r6 = r5.maxSize
            r5.trimToSize(r6)
            return r0
        L_0x0069:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        L_0x006c:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw null;
        }
        synchronized (this.monitor) {
            this.putCount++;
            this.size = size() + safeSizeOf(k, v);
            put = this.map.put(k, v);
            if (put != null) {
                this.size = size() - safeSizeOf(k, put);
            }
            if (this.keySet.contains(k)) {
                this.keySet.remove(k);
            }
            this.keySet.add(k);
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r8) {
        /*
            r7 = this;
        L_0x0000:
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r7.monitor
            monitor-enter(r0)
            int r1 = r7.size()     // Catch:{ all -> 0x0099 }
            if (r1 < 0) goto L_0x0091
            java.util.HashMap<K, V> r1 = r7.map     // Catch:{ all -> 0x0099 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0017
            int r1 = r7.size()     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0091
        L_0x0017:
            java.util.HashMap<K, V> r1 = r7.map     // Catch:{ all -> 0x0099 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0099 }
            java.util.LinkedHashSet<K> r2 = r7.keySet     // Catch:{ all -> 0x0099 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0099 }
            if (r1 != r2) goto L_0x0091
            int r1 = r7.size()     // Catch:{ all -> 0x0099 }
            r2 = 1
            r3 = 0
            if (r1 <= r8) goto L_0x007c
            java.util.HashMap<K, V> r1 = r7.map     // Catch:{ all -> 0x0099 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x007c
            java.util.LinkedHashSet<K> r1 = r7.keySet     // Catch:{ all -> 0x0099 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x0099 }
            java.lang.Object r1 = kotlin.collections.CollectionsKt.first(r1)     // Catch:{ all -> 0x0099 }
            java.util.HashMap<K, V> r4 = r7.map     // Catch:{ all -> 0x0099 }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x0099 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0074
            java.util.HashMap<K, V> r5 = r7.map     // Catch:{ all -> 0x0099 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0099 }
            java.util.Map r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r5)     // Catch:{ all -> 0x0099 }
            r5.remove(r1)     // Catch:{ all -> 0x0099 }
            java.util.LinkedHashSet<K> r5 = r7.keySet     // Catch:{ all -> 0x0099 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x0099 }
            java.util.Collection r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r5)     // Catch:{ all -> 0x0099 }
            r5.remove(r1)     // Catch:{ all -> 0x0099 }
            int r5 = r7.size()     // Catch:{ all -> 0x0099 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x0099 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0099 }
            int r6 = r7.safeSizeOf(r1, r4)     // Catch:{ all -> 0x0099 }
            int r5 = r5 - r6
            r7.size = r5     // Catch:{ all -> 0x0099 }
            int r5 = r7.evictionCount     // Catch:{ all -> 0x0099 }
            int r5 = r5 + r2
            r7.evictionCount = r5     // Catch:{ all -> 0x0099 }
            goto L_0x007e
        L_0x0074:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0099 }
            java.lang.String r1 = "inconsistent state"
            r8.<init>(r1)     // Catch:{ all -> 0x0099 }
            throw r8     // Catch:{ all -> 0x0099 }
        L_0x007c:
            r1 = r3
            r4 = r1
        L_0x007e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0099 }
            monitor-exit(r0)
            if (r1 != 0) goto L_0x0086
            if (r4 != 0) goto L_0x0086
            return
        L_0x0086:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r7.entryRemoved(r2, r1, r4, r3)
            goto L_0x0000
        L_0x0091:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0099 }
            java.lang.String r1 = "map/keySet size inconsistency"
            r8.<init>(r1)     // Catch:{ all -> 0x0099 }
            throw r8     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.trimToSize(int):void");
    }

    public final V remove(K k) {
        V remove;
        k.getClass();
        synchronized (this.monitor) {
            remove = this.map.remove(k);
            this.keySet.remove(k);
            if (remove != null) {
                this.size = size() - safeSizeOf(k, remove);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (remove != null) {
            entryRemoved(false, k, remove, (V) null);
        }
        return remove;
    }

    private final int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k + '=' + v).toString());
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final Map<K, V> snapshot() {
        Map<K, V> map2;
        synchronized (this.monitor) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = this.keySet.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                V v = this.map.get(next);
                Intrinsics.checkNotNull(v);
                linkedHashMap.put(next, v);
            }
            map2 = linkedHashMap;
        }
        return map2;
    }

    public String toString() {
        String str;
        synchronized (this.monitor) {
            int i = this.hitCount;
            int i2 = this.missCount + i;
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
        }
        return str;
    }

    public final <R> R synchronizedValue$ui_text_release(Function0<? extends R> function0) {
        R invoke;
        synchronized (this.monitor) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    public final int size() {
        int i;
        synchronized (this.monitor) {
            i = this.size;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.monitor) {
            i = this.maxSize;
        }
        return i;
    }

    public final int hitCount() {
        int i;
        synchronized (this.monitor) {
            i = this.hitCount;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.monitor) {
            i = this.missCount;
        }
        return i;
    }

    public final int createCount() {
        int i;
        synchronized (this.monitor) {
            i = this.createCount;
        }
        return i;
    }

    public final int putCount() {
        int i;
        synchronized (this.monitor) {
            i = this.putCount;
        }
        return i;
    }

    public final int evictionCount() {
        int i;
        synchronized (this.monitor) {
            i = this.evictionCount;
        }
        return i;
    }
}
