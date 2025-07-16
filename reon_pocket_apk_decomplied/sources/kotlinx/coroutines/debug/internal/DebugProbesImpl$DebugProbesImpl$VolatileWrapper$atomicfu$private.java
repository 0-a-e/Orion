package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DebugProbesImpl.kt */
/* synthetic */ class DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private {
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicIntegerFieldUpdater installations$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater sequenceNumber$volatile$FU;
    private volatile /* synthetic */ int installations$volatile;
    private volatile /* synthetic */ long sequenceNumber$volatile;

    static {
        Class<DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private> cls = DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.class;
        installations$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "installations$volatile");
        sequenceNumber$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "sequenceNumber$volatile");
    }

    private DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private() {
    }

    public /* synthetic */ DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final /* synthetic */ int getInstallations$volatile() {
        return this.installations$volatile;
    }

    private final /* synthetic */ long getSequenceNumber$volatile() {
        return this.sequenceNumber$volatile;
    }

    private final /* synthetic */ void setInstallations$volatile(int i) {
        this.installations$volatile = i;
    }

    private final /* synthetic */ void setSequenceNumber$volatile(long j) {
        this.sequenceNumber$volatile = j;
    }
}
