package kotlin.time;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeSources.kt */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* access modifiers changed from: protected */
    public long read() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m8511plusAssignLRDsOJo(long j) {
        long r0 = Duration.m8421toLongimpl(j, getUnit());
        if (((r0 - 1) | 1) == Long.MAX_VALUE) {
            long r02 = Duration.m8378divUwyO8pc(j, 2);
            if ((1 | (Duration.m8421toLongimpl(r02, getUnit()) - 1)) == Long.MAX_VALUE) {
                m8510overflowLRDsOJo(j);
                return;
            }
            long j2 = this.reading;
            try {
                m8511plusAssignLRDsOJo(r02);
                m8511plusAssignLRDsOJo(Duration.m8410minusLRDsOJo(j, r02));
            } catch (IllegalStateException e) {
                this.reading = j2;
                throw e;
            }
        } else {
            long j3 = this.reading;
            long j4 = j3 + r0;
            if ((r0 ^ j3) >= 0 && (j3 ^ j4) < 0) {
                m8510overflowLRDsOJo(j);
            }
            this.reading = j4;
        }
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m8510overflowLRDsOJo(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + Duration.m8424toStringimpl(j) + '.');
    }
}
