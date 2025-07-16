package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u001d\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0015\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013J\u0012\u0010!\u001a\u00020\u00152\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\"\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010#J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010$\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010#J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/collection/LruCache;", "K", "", "V", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "lock", "Landroidx/collection/internal/Lock;", "map", "Landroidx/collection/internal/LruHashMap;", "missCount", "putCount", "size", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "toString", "", "trimToSize", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LruCache.kt */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    /* access modifiers changed from: protected */
    public V create(K k) {
        Intrinsics.checkNotNullParameter(k, TransferTable.COLUMN_KEY);
        return null;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
        Intrinsics.checkNotNullParameter(k, TransferTable.COLUMN_KEY);
        Intrinsics.checkNotNullParameter(v, "oldValue");
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        Intrinsics.checkNotNullParameter(k, TransferTable.COLUMN_KEY);
        Intrinsics.checkNotNullParameter(v, "value");
        return 1;
    }

    public LruCache(int i) {
        this.maxSize = i;
        if (i > 0) {
            this.map = new LruHashMap<>(0, 0.75f);
            this.lock = new Lock();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public void resize(int i) {
        if (i > 0) {
            synchronized (this.lock) {
                this.maxSize = i;
                Unit unit = Unit.INSTANCE;
            }
            trimToSize(i);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r0 = create(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r0 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        r1 = r5.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r5.createCount++;
        r2 = r5.map.put(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (r2 == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        r5.map.put(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        r5.size += safeSizeOf(r6, r0);
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r2 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        entryRemoved(false, r6, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        trimToSize(r5.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r6) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.collection.internal.Lock r0 = r5.lock
            monitor-enter(r0)
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x005b }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x0018
            int r6 = r5.hitCount     // Catch:{ all -> 0x005b }
            int r6 = r6 + 1
            r5.hitCount = r6     // Catch:{ all -> 0x005b }
            monitor-exit(r0)
            return r1
        L_0x0018:
            int r1 = r5.missCount     // Catch:{ all -> 0x005b }
            int r1 = r1 + 1
            r5.missCount = r1     // Catch:{ all -> 0x005b }
            monitor-exit(r0)
            java.lang.Object r0 = r5.create(r6)
            if (r0 != 0) goto L_0x0027
            r6 = 0
            return r6
        L_0x0027:
            androidx.collection.internal.Lock r1 = r5.lock
            monitor-enter(r1)
            int r2 = r5.createCount     // Catch:{ all -> 0x0058 }
            int r2 = r2 + 1
            r5.createCount = r2     // Catch:{ all -> 0x0058 }
            androidx.collection.internal.LruHashMap<K, V> r2 = r5.map     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.put(r6, r0)     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x003e
            androidx.collection.internal.LruHashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0058 }
            r3.put(r6, r2)     // Catch:{ all -> 0x0058 }
            goto L_0x0049
        L_0x003e:
            int r3 = r5.size     // Catch:{ all -> 0x0058 }
            int r4 = r5.safeSizeOf(r6, r0)     // Catch:{ all -> 0x0058 }
            int r3 = r3 + r4
            r5.size = r3     // Catch:{ all -> 0x0058 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0058 }
        L_0x0049:
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0052
            r1 = 0
            r5.entryRemoved(r1, r6, r0, r2)
            r0 = r2
            goto L_0x0057
        L_0x0052:
            int r6 = r5.maxSize
            r5.trimToSize(r6)
        L_0x0057:
            return r0
        L_0x0058:
            r6 = move-exception
            monitor-exit(r1)
            throw r6
        L_0x005b:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K k, V v) {
        V put;
        Intrinsics.checkNotNullParameter(k, TransferTable.COLUMN_KEY);
        Intrinsics.checkNotNullParameter(v, "value");
        synchronized (this.lock) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            put = this.map.put(k, v);
            if (put != null) {
                this.size -= safeSizeOf(k, put);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!".toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r6) {
        /*
            r5 = this;
        L_0x0000:
            androidx.collection.internal.Lock r0 = r5.lock
            monitor-enter(r0)
            int r1 = r5.size     // Catch:{ all -> 0x0062 }
            if (r1 < 0) goto L_0x0056
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0062 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0013
            int r1 = r5.size     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0056
        L_0x0013:
            int r1 = r5.size     // Catch:{ all -> 0x0062 }
            if (r1 <= r6) goto L_0x0054
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0062 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0020
            goto L_0x0054
        L_0x0020:
            androidx.collection.internal.LruHashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0062 }
            java.util.Set r1 = r1.getEntries()     // Catch:{ all -> 0x0062 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x0062 }
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)     // Catch:{ all -> 0x0062 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0032
            monitor-exit(r0)
            return
        L_0x0032:
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x0062 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0062 }
            androidx.collection.internal.LruHashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0062 }
            r3.remove(r2)     // Catch:{ all -> 0x0062 }
            int r3 = r5.size     // Catch:{ all -> 0x0062 }
            int r4 = r5.safeSizeOf(r2, r1)     // Catch:{ all -> 0x0062 }
            int r3 = r3 - r4
            r5.size = r3     // Catch:{ all -> 0x0062 }
            int r3 = r5.evictionCount     // Catch:{ all -> 0x0062 }
            r4 = 1
            int r3 = r3 + r4
            r5.evictionCount = r3     // Catch:{ all -> 0x0062 }
            monitor-exit(r0)
            r0 = 0
            r5.entryRemoved(r4, r2, r1, r0)
            goto L_0x0000
        L_0x0054:
            monitor-exit(r0)
            return
        L_0x0056:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0062 }
            r1.<init>(r6)     // Catch:{ all -> 0x0062 }
            throw r1     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }

    public final V remove(K k) {
        V remove;
        Intrinsics.checkNotNullParameter(k, TransferTable.COLUMN_KEY);
        synchronized (this.lock) {
            remove = this.map.remove(k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
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

    public final int size() {
        int i;
        synchronized (this.lock) {
            i = this.size;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.lock) {
            i = this.maxSize;
        }
        return i;
    }

    public final int hitCount() {
        int i;
        synchronized (this.lock) {
            i = this.hitCount;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.lock) {
            i = this.missCount;
        }
        return i;
    }

    public final int createCount() {
        int i;
        synchronized (this.lock) {
            i = this.createCount;
        }
        return i;
    }

    public final int putCount() {
        int i;
        synchronized (this.lock) {
            i = this.putCount;
        }
        return i;
    }

    public final int evictionCount() {
        int i;
        synchronized (this.lock) {
            i = this.evictionCount;
        }
        return i;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            for (Map.Entry entry : this.map.getEntries()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            Unit unit = Unit.INSTANCE;
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            int i = this.hitCount;
            int i2 = this.missCount + i;
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
        }
        return str;
    }
}
