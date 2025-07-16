package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\r\u001aG\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u0013\u001ag\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0019\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\u001a\u001aG\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u001b\u001aW\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u0002H\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u0002H\u00052\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0002\u0010\u001d\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"EmptyObjectLongMap", "Landroidx/collection/MutableObjectLongMap;", "", "emptyObjectLongMap", "Landroidx/collection/ObjectLongMap;", "K", "mutableObjectLongMapOf", "key1", "value1", "", "(Ljava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key2", "value2", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key3", "value3", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key4", "value4", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "key5", "value5", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "objectLongMap", "objectLongMapOf", "(Ljava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ObjectLongMap.kt */
public final class ObjectLongMapKt {
    private static final MutableObjectLongMap<Object> EmptyObjectLongMap = new MutableObjectLongMap<>(0);

    public static final <K> ObjectLongMap<K> emptyObjectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        Intrinsics.checkNotNull(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.emptyObjectLongMap>");
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        Intrinsics.checkNotNull(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.objectLongMap>");
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2, K k3, long j3) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        mutableObjectLongMap.set(k4, j4);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4, K k5, long j5) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, (DefaultConstructorMarker) null);
        K k6 = k;
        long j6 = j;
        mutableObjectLongMap.set(k, j);
        K k7 = k2;
        long j7 = j2;
        mutableObjectLongMap.set(k2, j2);
        K k8 = k3;
        long j8 = j3;
        mutableObjectLongMap.set(k3, j3);
        K k9 = k4;
        long j9 = j4;
        mutableObjectLongMap.set(k4, j4);
        mutableObjectLongMap.set(k5, j5);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf() {
        return new MutableObjectLongMap<>(0, 1, (DefaultConstructorMarker) null);
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2, K k3, long j3) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, (DefaultConstructorMarker) null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        mutableObjectLongMap.set(k4, j4);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4, K k5, long j5) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, (DefaultConstructorMarker) null);
        K k6 = k;
        long j6 = j;
        mutableObjectLongMap.set(k, j);
        K k7 = k2;
        long j7 = j2;
        mutableObjectLongMap.set(k2, j2);
        K k8 = k3;
        long j8 = j3;
        mutableObjectLongMap.set(k3, j3);
        K k9 = k4;
        long j9 = j4;
        mutableObjectLongMap.set(k4, j4);
        mutableObjectLongMap.set(k5, j5);
        return mutableObjectLongMap;
    }
}
