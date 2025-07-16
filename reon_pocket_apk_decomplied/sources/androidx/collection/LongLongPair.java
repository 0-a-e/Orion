package androidx.collection;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\nJ\t\u0010\n\u001a\u00020\u0003H\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/collection/LongLongPair;", "", "first", "", "second", "(JJ)V", "getFirst", "()J", "getSecond", "component1", "component2", "equals", "", "other", "hashCode", "", "toString", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LongLongPair.kt */
public final class LongLongPair {
    private final long first;
    private final long second;

    public LongLongPair(long j, long j2) {
        this.first = j;
        this.second = j2;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        if (longLongPair.first == this.first && longLongPair.second == this.second) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return UByte$$ExternalSyntheticBackport0.m(this.first) ^ UByte$$ExternalSyntheticBackport0.m(this.second);
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
