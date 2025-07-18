package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.ULong;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u0002\u0004\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ULongRange.kt */
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final long first;
    private final long last;
    private final long step;

    public /* synthetic */ ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private ULongProgression(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j3 != Long.MIN_VALUE) {
            this.first = j;
            this.last = UProgressionUtilKt.m8246getProgressionLastElement7ftBX0g(j, j2, j3);
            this.step = j3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: getFirst-s-VKNKU  reason: not valid java name */
    public final long m8270getFirstsVKNKU() {
        return this.first;
    }

    /* renamed from: getLast-s-VKNKU  reason: not valid java name */
    public final long m8271getLastsVKNKU() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.first, this.last, this.step, (DefaultConstructorMarker) null);
    }

    public boolean isEmpty() {
        int i = (this.step > 0 ? 1 : (this.step == 0 ? 0 : -1));
        long j = this.first;
        long j2 = this.last;
        if (i > 0) {
            if (UByte$$ExternalSyntheticBackport0.m(j, j2) > 0) {
                return true;
            }
        } else if (UByte$$ExternalSyntheticBackport0.m(j, j2) < 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) obj).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) obj;
                if (!(this.first == uLongProgression.first && this.last == uLongProgression.last && this.step == uLongProgression.step)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.first;
        long j2 = this.last;
        long j3 = this.step;
        return (((((int) ULong.m7216constructorimpl(j ^ ULong.m7216constructorimpl(j >>> 32))) * 31) + ((int) ULong.m7216constructorimpl(j2 ^ ULong.m7216constructorimpl(j2 >>> 32)))) * 31) + ((int) ((j3 >>> 32) ^ j3));
    }

    public String toString() {
        long j;
        StringBuilder sb;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append(ULong.m7262toStringimpl(this.first));
            sb.append("..");
            sb.append(ULong.m7262toStringimpl(this.last));
            sb.append(" step ");
            j = this.step;
        } else {
            sb = new StringBuilder();
            sb.append(ULong.m7262toStringimpl(this.first));
            sb.append(" downTo ");
            sb.append(ULong.m7262toStringimpl(this.last));
            sb.append(" step ");
            j = -this.step;
        }
        sb.append(j);
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ULongRange.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: fromClosedRange-7ftBX0g  reason: not valid java name */
        public final ULongProgression m8272fromClosedRange7ftBX0g(long j, long j2, long j3) {
            return new ULongProgression(j, j2, j3, (DefaultConstructorMarker) null);
        }
    }
}
