package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\bJ\u0011\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\bJ\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010&\u001a\u00020 2\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010*\u001a\u00020+J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\bJ\u000e\u0010,\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\t\u0010-\u001a\u00020$H\bJ\t\u0010.\u001a\u00020\u0004H\bJ&\u0010/\u001a\u00020$2\n\u0010'\u001a\u00060(j\u0002`)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u0018J\u0014\u00101\u001a\u00020$2\n\u00102\u001a\u00060(j\u0002`)H\u0016J\t\u00103\u001a\u00020\u0007H\bJ\t\u00104\u001a\u00020\u0004H\bJ\u0014\u00105\u001a\u00020\u00042\n\u00106\u001a\u00060\u001dR\u00020\u0000H\u0002J\u000e\u00107\u001a\b\u0018\u00010\u001dR\u00020\u0000H\u0002J\u0012\u00108\u001a\u00020\u00182\n\u00106\u001a\u00060\u001dR\u00020\u0000J\"\u00109\u001a\u00020$2\n\u00106\u001a\u00060\u001dR\u00020\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004J\t\u0010<\u001a\u00020\u0007H\bJ\u000e\u0010=\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u0007J\u0018\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0018H\u0002J\u0006\u0010C\u001a\u00020$J\b\u0010D\u001a\u00020\tH\u0016J\t\u0010E\u001a\u00020\u0018H\bJ\u0012\u0010F\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J$\u0010H\u001a\u0004\u0018\u00010 *\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u00020\u0018H\u0002R\t\u0010\u000b\u001a\u00020\fX\u0004R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u00020\u00048Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00158\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\t\u0010\u001a\u001a\u00020\u0011X\u0004R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u001dR\u00020\u00000\u001c8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "availableCpuPermits", "getAvailableCpuPermits", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "createdWorkers", "getCreatedWorkers", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "isTerminated", "", "()Z", "parkedWorkersStack", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "addToGlobalQueue", "task", "Lkotlinx/coroutines/scheduling/Task;", "state", "blockingTasks", "close", "", "createNewWorker", "createTask", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "currentWorker", "decrementBlockingTasks", "decrementCreatedWorkers", "dispatch", "tailDispatch", "execute", "command", "incrementBlockingTasks", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "releaseCpuPermit", "runSafely", "shutdown", "timeout", "signalBlockingWork", "stateSnapshot", "skipUnpark", "signalCpuWork", "toString", "tryAcquireCpuPermit", "tryCreateWorker", "tryUnpark", "submitToLocalQueue", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CoroutineScheduler.kt */
public final class CoroutineScheduler implements Executor, Closeable {
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final int CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 2097151;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    private static final int PARKED = -1;
    private static final long PARKED_INDEX_MASK = 2097151;
    private static final long PARKED_VERSION_INC = 2097152;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater controlState$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$volatile$FU;
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    public final String schedulerName;
    public final ResizableAtomicArray<Worker> workers;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CoroutineScheduler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.WhenMappings.<clinit>():void");
        }
    }

    private final int blockingTasks(long j) {
        return (int) ((j & BLOCKING_MASK) >> 21);
    }

    private final int createdWorkers(long j) {
        return (int) (j & TarConstants.MAXID);
    }

    private final /* synthetic */ long getControlState$volatile() {
        return this.controlState$volatile;
    }

    private final /* synthetic */ long getParkedWorkersStack$volatile() {
        return this.parkedWorkersStack$volatile;
    }

    private final /* synthetic */ int get_isTerminated$volatile() {
        return this._isTerminated$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void setControlState$volatile(long j) {
        this.controlState$volatile = j;
    }

    private final /* synthetic */ void setParkedWorkersStack$volatile(long j) {
        this.parkedWorkersStack$volatile = j;
    }

    private final /* synthetic */ void set_isTerminated$volatile(int i) {
        this._isTerminated$volatile = i;
    }

    public final int availableCpuPermits(long j) {
        return (int) ((j & CPU_PERMITS_MASK) >> 42);
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i < 1) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        } else if (i2 < i) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        } else if (i2 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        } else if (j > 0) {
            this.globalCpuQueue = new GlobalQueue();
            this.globalBlockingQueue = new GlobalQueue();
            this.workers = new ResizableAtomicArray<>((i + 1) * 2);
            this.controlState$volatile = ((long) i) << 42;
            this._isTerminated$volatile = 0;
        } else {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        AtomicLongFieldUpdater parkedWorkersStack$volatile$FU2 = parkedWorkersStack$volatile$FU;
        while (true) {
            long j = parkedWorkersStack$volatile$FU2.get(this);
            int i3 = (int) (TarConstants.MAXID & j);
            long j2 = (PARKED_VERSION_INC + j) & PARKED_VERSION_MASK;
            if (i3 == i) {
                i3 = i2 == 0 ? parkedWorkersStackNextIndex(worker) : i2;
            }
            if (i3 >= 0) {
                if (parkedWorkersStack$volatile$FU.compareAndSet(this, j, j2 | ((long) i3))) {
                    return;
                }
            }
        }
    }

    public final boolean parkedWorkersStackPush(Worker worker) {
        long j;
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        AtomicLongFieldUpdater parkedWorkersStack$volatile$FU2 = parkedWorkersStack$volatile$FU;
        do {
            j = parkedWorkersStack$volatile$FU2.get(this);
            int i = (int) (TarConstants.MAXID & j);
            j2 = (PARKED_VERSION_INC + j) & PARKED_VERSION_MASK;
            indexInArray = worker.getIndexInArray();
            if (!DebugKt.getASSERTIONS_ENABLED() || indexInArray != 0) {
                worker.setNextParkedWorker(this.workers.get(i));
            } else {
                throw new AssertionError();
            }
        } while (!parkedWorkersStack$volatile$FU.compareAndSet(this, j, j2 | ((long) indexInArray)));
        return true;
    }

    private final Worker parkedWorkersStackPop() {
        AtomicLongFieldUpdater parkedWorkersStack$volatile$FU2 = parkedWorkersStack$volatile$FU;
        while (true) {
            long j = parkedWorkersStack$volatile$FU2.get(this);
            Worker worker = this.workers.get((int) (TarConstants.MAXID & j));
            if (worker == null) {
                return null;
            }
            long j2 = (PARKED_VERSION_INC + j) & PARKED_VERSION_MASK;
            int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
            if (parkedWorkersStackNextIndex >= 0) {
                if (parkedWorkersStack$volatile$FU.compareAndSet(this, j, ((long) parkedWorkersStackNextIndex) | j2)) {
                    worker.setNextParkedWorker(NOT_IN_STACK);
                    return worker;
                }
            }
        }
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final int getCreatedWorkers() {
        return (int) (controlState$volatile$FU.get(this) & TarConstants.MAXID);
    }

    private final int getAvailableCpuPermits() {
        return (int) ((controlState$volatile$FU.get(this) & CPU_PERMITS_MASK) >> 42);
    }

    private final int incrementCreatedWorkers() {
        return (int) (controlState$volatile$FU.incrementAndGet(this) & TarConstants.MAXID);
    }

    private final int decrementCreatedWorkers() {
        return (int) (controlState$volatile$FU.getAndDecrement(this) & TarConstants.MAXID);
    }

    private final long incrementBlockingTasks() {
        return controlState$volatile$FU.addAndGet(this, PARKED_VERSION_INC);
    }

    private final void decrementBlockingTasks() {
        controlState$volatile$FU.addAndGet(this, PARKED_VERSION_MASK);
    }

    private final boolean tryAcquireCpuPermit() {
        long j;
        AtomicLongFieldUpdater access$getControlState$volatile$FU = controlState$volatile$FU;
        do {
            j = access$getControlState$volatile$FU.get(this);
            if (((int) ((CPU_PERMITS_MASK & j) >> 42)) == 0) {
                return false;
            }
        } while (!controlState$volatile$FU.compareAndSet(this, j, j - 4398046511104L));
        return true;
    }

    private final long releaseCpuPermit() {
        return controlState$volatile$FU.addAndGet(this, 4398046511104L);
    }

    public final boolean isTerminated() {
        return _isTerminated$volatile$FU.get(this) != 0;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CoroutineScheduler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack$volatile");
        controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "controlState$volatile");
        _isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated$volatile");
    }

    public void execute(Runnable runnable) {
        dispatch$default(this, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    public void close() {
        shutdown(10000);
    }

    public final void shutdown(long j) {
        int i;
        Task task;
        if (_isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            Worker currentWorker = currentWorker();
            synchronized (this.workers) {
                i = (int) (controlState$volatile$FU.get(this) & TarConstants.MAXID);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Worker worker = this.workers.get(i2);
                    Intrinsics.checkNotNull(worker);
                    Worker worker2 = worker;
                    if (worker2 != currentWorker) {
                        while (worker2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(worker2);
                            worker2.join(j);
                        }
                        if (!DebugKt.getASSERTIONS_ENABLED() || worker2.state == WorkerState.TERMINATED) {
                            worker2.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                        } else {
                            throw new AssertionError();
                        }
                    }
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            this.globalBlockingQueue.close();
            this.globalCpuQueue.close();
            while (true) {
                if (currentWorker != null) {
                    task = currentWorker.findTask(true);
                    if (task != null) {
                        continue;
                        runSafely(task);
                    }
                }
                task = (Task) this.globalCpuQueue.removeFirstOrNull();
                if (task == null && (task = (Task) this.globalBlockingQueue.removeFirstOrNull()) == null) {
                    break;
                }
                runSafely(task);
            }
            if (currentWorker != null) {
                currentWorker.tryReleaseCpu(WorkerState.TERMINATED);
            }
            if (!DebugKt.getASSERTIONS_ENABLED() || ((int) ((controlState$volatile$FU.get(this) & CPU_PERMITS_MASK) >> 42)) == this.corePoolSize) {
                parkedWorkersStack$volatile$FU.set(this, 0);
                controlState$volatile$FU.set(this, 0);
                return;
            }
            throw new AssertionError();
        }
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = TasksKt.NonBlockingContext;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z) {
        long j;
        AbstractTimeSource access$getTimeSource$p = AbstractTimeSourceKt.timeSource;
        if (access$getTimeSource$p != null) {
            access$getTimeSource$p.trackTask();
        }
        Task createTask = createTask(runnable, taskContext);
        boolean z2 = false;
        boolean z3 = createTask.taskContext.getTaskMode() == 1;
        if (z3) {
            j = controlState$volatile$FU.addAndGet(this, PARKED_VERSION_INC);
        } else {
            j = 0;
        }
        Worker currentWorker = currentWorker();
        Task submitToLocalQueue = submitToLocalQueue(currentWorker, createTask, z);
        if (submitToLocalQueue == null || addToGlobalQueue(submitToLocalQueue)) {
            if (z && currentWorker != null) {
                z2 = true;
            }
            if (z3) {
                signalBlockingWork(j, z2);
            } else if (!z2) {
                signalCpuWork();
            }
        } else {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
    }

    public final Task createTask(Runnable runnable, TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, nanoTime, taskContext);
        }
        Task task = (Task) runnable;
        task.submissionTime = nanoTime;
        task.taskContext = taskContext;
        return task;
    }

    private final void signalBlockingWork(long j, boolean z) {
        if (!z && !tryUnpark() && !tryCreateWorker(j)) {
            tryUnpark();
        }
    }

    public final void signalCpuWork() {
        if (!tryUnpark() && !tryCreateWorker$default(this, 0, 1, (Object) null)) {
            tryUnpark();
        }
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = controlState$volatile$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(j);
    }

    private final boolean tryCreateWorker(long j) {
        if (RangesKt.coerceAtLeast(((int) (TarConstants.MAXID & j)) - ((int) ((j & BLOCKING_MASK) >> 21)), 0) < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean tryUnpark() {
        Worker parkedWorkersStackPop;
        do {
            parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
        } while (!Worker.workerCtl$volatile$FU.compareAndSet(parkedWorkersStackPop, -1, 0));
        LockSupport.unpark(parkedWorkersStackPop);
        return true;
    }

    private final int createNewWorker() {
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = controlState$volatile$FU.get(this);
            int i = (int) (j & TarConstants.MAXID);
            int coerceAtLeast = RangesKt.coerceAtLeast(i - ((int) ((j & BLOCKING_MASK) >> 21)), 0);
            if (coerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i2 = ((int) (controlState$volatile$FU.get(this) & TarConstants.MAXID)) + 1;
            if (i2 <= 0 || this.workers.get(i2) != null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Worker worker = new Worker(this, i2);
            this.workers.setSynchronized(i2, worker);
            if (i2 == ((int) (TarConstants.MAXID & controlState$volatile$FU.incrementAndGet(this)))) {
                int i3 = coerceAtLeast + 1;
                worker.start();
                return i3;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Task submitToLocalQueue(Worker worker, Task task, boolean z) {
        if (worker == null || worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, z);
    }

    private final Worker currentWorker() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker == null || !Intrinsics.areEqual((Object) CoroutineScheduler.this, (Object) this)) {
            return null;
        }
        return worker;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int currentLength = this.workers.currentLength();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < currentLength; i6++) {
            Worker worker = this.workers.get(i6);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int i7 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (i7 == 1) {
                    i3++;
                } else if (i7 == 2) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(size$kotlinx_coroutines_core);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i7 == 3) {
                    i++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(size$kotlinx_coroutines_core);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i7 == 4) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(size$kotlinx_coroutines_core);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i7 == 5) {
                    i5++;
                }
            }
        }
        long j = controlState$volatile$FU.get(this);
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (TarConstants.MAXID & j)) + ", blocking tasks = " + ((int) ((BLOCKING_MASK & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((CPU_PERMITS_MASK & j) >> 42))) + "}]";
    }

    public final void runSafely(Task task) {
        AbstractTimeSource access$getTimeSource$p;
        try {
            task.run();
            access$getTimeSource$p = AbstractTimeSourceKt.timeSource;
            if (access$getTimeSource$p == null) {
                return;
            }
        } catch (Throwable th) {
            AbstractTimeSource access$getTimeSource$p2 = AbstractTimeSourceKt.timeSource;
            if (access$getTimeSource$p2 != null) {
                access$getTimeSource$p2.unTrackTask();
            }
            throw th;
        }
        access$getTimeSource$p.unTrackTask();
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020 H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020\u000eH\u0002J\n\u0010,\u001a\u0004\u0018\u00010 H\u0002J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0003H\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\b\u00105\u001a\u00020%H\u0002J\n\u00106\u001a\u0004\u0018\u00010 H\u0002J\b\u00107\u001a\u00020%H\u0016J\u0006\u00108\u001a\u00020\u0010J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020%H\u0002J\u000e\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001dJ\u0016\u0010>\u001a\u0004\u0018\u00010 2\n\u0010?\u001a\u00060\u0003j\u0002`@H\u0002J\b\u0010A\u001a\u00020%H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0006\u0010\"\u001a\u00020#¨\u0006B"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "", "minDelayUntilStealableTaskNs", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "terminationDeadline", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "beforeTask", "executeTask", "task", "findAnyTask", "scanLocalQueue", "findBlockingTask", "findCpuTask", "findTask", "idleReset", "mode", "inStack", "isIo", "nextInt", "upperBound", "park", "pollGlobalQueues", "run", "runSingleTask", "runWorker", "tryAcquireCpuPermit", "tryPark", "tryReleaseCpu", "newState", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryTerminateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CoroutineScheduler.kt */
    public final class Worker extends Thread {
        /* access modifiers changed from: private */
        public static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private final Ref.ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        private final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        private final /* synthetic */ void setWorkerCtl$volatile(int i) {
            this.workerCtl$volatile = i;
        }

        private Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref.ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            Worker worker = this;
            int nanoTime = (int) System.nanoTime();
            this.rngState = nanoTime == 0 ? 42 : nanoTime;
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        private final boolean tryAcquireCpuPermit() {
            long j;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater access$getControlState$volatile$FU = CoroutineScheduler.controlState$volatile$FU;
            do {
                j = access$getControlState$volatile$FU.get(coroutineScheduler);
                if (((int) ((CoroutineScheduler.CPU_PERMITS_MASK & j) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.controlState$volatile$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.controlState$volatile$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public void run() {
            runWorker();
        }

        private final void runWorker() {
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            tryPark();
                        } else if (!z) {
                            z = true;
                        } else {
                            tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0;
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final long runSingleTask() {
            Task task;
            WorkerState workerState = this.state;
            boolean z = workerState == WorkerState.CPU_ACQUIRED;
            if (z) {
                task = findCpuTask();
            } else {
                task = findBlockingTask();
            }
            if (task == null) {
                long j = this.minDelayUntilStealableTaskNs;
                if (j == 0) {
                    return -1;
                }
                return j;
            }
            CoroutineScheduler.this.runSafely(task);
            if (!z) {
                CoroutineScheduler.controlState$volatile$FU.addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_MASK);
            }
            if (!DebugKt.getASSERTIONS_ENABLED() || this.state == workerState) {
                return 0;
            }
            throw new AssertionError();
        }

        public final boolean isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            workerCtl$volatile$FU.set(this, -1);
            while (inStack() && workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        private final void beforeTask(int i) {
            if (i != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork();
            }
        }

        private final void afterTask(int i) {
            if (i != 0) {
                CoroutineScheduler.controlState$volatile$FU.addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_MASK);
                WorkerState workerState = this.state;
                if (workerState == WorkerState.TERMINATED) {
                    return;
                }
                if (!DebugKt.getASSERTIONS_ENABLED() || workerState == WorkerState.BLOCKING) {
                    this.state = WorkerState.DORMANT;
                    return;
                }
                throw new AssertionError();
            }
        }

        public final int nextInt(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            if ((i6 & i) == 0) {
                return i5 & i6;
            }
            return (i5 & Integer.MAX_VALUE) % i;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0;
                tryTerminateWorker();
            }
        }

        private final void tryTerminateWorker() {
            ResizableAtomicArray<Worker> resizableAtomicArray = CoroutineScheduler.this.workers;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (resizableAtomicArray) {
                if (!coroutineScheduler.isTerminated()) {
                    if (((int) (CoroutineScheduler.controlState$volatile$FU.get(coroutineScheduler) & TarConstants.MAXID)) > coroutineScheduler.corePoolSize) {
                        if (workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                            int i = this.indexInArray;
                            setIndexInArray(0);
                            coroutineScheduler.parkedWorkersStackTopUpdate(this, i, 0);
                            int andDecrement = (int) (CoroutineScheduler.controlState$volatile$FU.getAndDecrement(coroutineScheduler) & TarConstants.MAXID);
                            if (andDecrement != i) {
                                Worker worker = coroutineScheduler.workers.get(andDecrement);
                                Intrinsics.checkNotNull(worker);
                                Worker worker2 = worker;
                                coroutineScheduler.workers.setSynchronized(i, worker2);
                                worker2.setIndexInArray(i);
                                coroutineScheduler.parkedWorkersStackTopUpdate(worker2, andDecrement, i);
                            }
                            coroutineScheduler.workers.setSynchronized(andDecrement, null);
                            Unit unit = Unit.INSTANCE;
                            this.state = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        private final void idleReset(int i) {
            this.terminationDeadline = 0;
            if (this.state != WorkerState.PARKING) {
                return;
            }
            if (!DebugKt.getASSERTIONS_ENABLED() || i == 1) {
                this.state = WorkerState.BLOCKING;
                return;
            }
            throw new AssertionError();
        }

        public final Task findTask(boolean z) {
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z);
            }
            return findBlockingTask();
        }

        private final Task findBlockingTask() {
            Task pollBlocking = this.localQueue.pollBlocking();
            if (pollBlocking != null) {
                return pollBlocking;
            }
            Task task = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            return task == null ? trySteal(1) : task;
        }

        private final Task findCpuTask() {
            Task pollCpu = this.localQueue.pollCpu();
            if (pollCpu != null) {
                return pollCpu;
            }
            Task task = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            return task == null ? trySteal(2) : task;
        }

        private final Task findAnyTask(boolean z) {
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (z) {
                boolean z2 = nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z2 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task poll = this.localQueue.poll();
                if (poll != null) {
                    return poll;
                }
                if (!z2 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (task != null) {
                    return task;
                }
                return (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task task2 = (Task) CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (task2 != null) {
                return task2;
            }
            return (Task) CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final Task trySteal(int i) {
            int i2 = (int) (CoroutineScheduler.controlState$volatile$FU.get(CoroutineScheduler.this) & TarConstants.MAXID);
            if (i2 < 2) {
                return null;
            }
            int nextInt = nextInt(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                nextInt++;
                if (nextInt > i2) {
                    nextInt = 1;
                }
                Worker worker = coroutineScheduler.workers.get(nextInt);
                if (worker == null || worker == this) {
                    int i4 = i;
                } else {
                    long trySteal = worker.localQueue.trySteal(i, this.stolenTask);
                    if (trySteal == -1) {
                        Task task = (Task) this.stolenTask.element;
                        this.stolenTask.element = null;
                        return task;
                    } else if (trySteal > 0) {
                        j = Math.min(j, trySteal);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.minDelayUntilStealableTaskNs = j;
            return null;
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            afterTask(taskMode);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CoroutineScheduler.kt */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }

        static {
            WorkerState[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    private final boolean addToGlobalQueue(Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            return this.globalBlockingQueue.addLast(task);
        }
        return this.globalCpuQueue.addLast(task);
    }
}
