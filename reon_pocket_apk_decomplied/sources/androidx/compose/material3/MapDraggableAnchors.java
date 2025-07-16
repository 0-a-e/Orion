package androidx.compose.material3;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rJ\u001f\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/MapDraggableAnchors;", "T", "Landroidx/compose/material3/DraggableAnchors;", "anchors", "", "", "(Ljava/util/Map;)V", "size", "", "getSize", "()I", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "", "(FZ)Ljava/lang/Object;", "equals", "other", "", "hasAnchorFor", "value", "(Ljava/lang/Object;)Z", "hashCode", "maxAnchor", "minAnchor", "positionOf", "(Ljava/lang/Object;)F", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class MapDraggableAnchors<T> implements DraggableAnchors<T> {
    private final Map<T, Float> anchors;

    public MapDraggableAnchors(Map<T, Float> map) {
        this.anchors = map;
    }

    public float positionOf(T t) {
        Float f = this.anchors.get(t);
        if (f != null) {
            return f.floatValue();
        }
        return Float.NaN;
    }

    public boolean hasAnchorFor(T t) {
        return this.anchors.containsKey(t);
    }

    public T closestAnchor(float f) {
        Object obj;
        Iterator it = this.anchors.entrySet().iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            obj = it.next();
            if (it.hasNext()) {
                float abs = Math.abs(f - ((Number) ((Map.Entry) obj).getValue()).floatValue());
                do {
                    Object next = it.next();
                    float abs2 = Math.abs(f - ((Number) ((Map.Entry) next).getValue()).floatValue());
                    if (Float.compare(abs, abs2) > 0) {
                        obj = next;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }

    public T closestAnchor(float f, boolean z) {
        Object obj;
        Iterator it = this.anchors.entrySet().iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            obj = it.next();
            if (it.hasNext()) {
                float floatValue = ((Number) ((Map.Entry) obj).getValue()).floatValue();
                float f2 = z ? floatValue - f : f - floatValue;
                if (f2 < 0.0f) {
                    f2 = Float.POSITIVE_INFINITY;
                }
                do {
                    Object next = it.next();
                    float floatValue2 = ((Number) ((Map.Entry) next).getValue()).floatValue();
                    float f3 = z ? floatValue2 - f : f - floatValue2;
                    if (f3 < 0.0f) {
                        f3 = Float.POSITIVE_INFINITY;
                    }
                    if (Float.compare(f2, f3) > 0) {
                        obj = next;
                        f2 = f3;
                    }
                } while (it.hasNext());
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }

    public float minAnchor() {
        Float minOrNull = CollectionsKt.minOrNull(this.anchors.values());
        if (minOrNull != null) {
            return minOrNull.floatValue();
        }
        return Float.NaN;
    }

    public float maxAnchor() {
        Float maxOrNull = CollectionsKt.maxOrNull(this.anchors.values());
        if (maxOrNull != null) {
            return maxOrNull.floatValue();
        }
        return Float.NaN;
    }

    public int getSize() {
        return this.anchors.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapDraggableAnchors)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.anchors, (Object) ((MapDraggableAnchors) obj).anchors);
    }

    public int hashCode() {
        return this.anchors.hashCode() * 31;
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.anchors + ')';
    }
}
