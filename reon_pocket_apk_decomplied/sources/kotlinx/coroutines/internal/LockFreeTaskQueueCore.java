package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ,*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002,-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J&\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0004\b\u0001\u0010#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0%J\b\u0010&\u001a\u00020\u001aH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010(\u001a\u0004\u0018\u00010\u0002J,\u0010)\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R#\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0004R\t\u0010\u000b\u001a\u00020\fX\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LockFreeTaskQueue.kt */
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater _state$volatile$FU;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    private final /* synthetic */ AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    private final /* synthetic */ AtomicReferenceArray getArray() {
        return this.array;
    }

    private final /* synthetic */ Object get_next$volatile() {
        return this._next$volatile;
    }

    private final /* synthetic */ long get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void set_next$volatile(Object obj) {
        this._next$volatile = obj;
    }

    private final /* synthetic */ void set_state$volatile(long j) {
        this._state$volatile = j;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.invoke(Long.valueOf(j)).longValue()));
    }

    private final /* synthetic */ long updateAndGet$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        Number invoke;
        do {
            j = atomicLongFieldUpdater.get(obj);
            invoke = function1.invoke(Long.valueOf(j));
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, invoke.longValue()));
        return invoke.longValue();
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.capacity = i;
        this.singleConsumer = z;
        int i2 = i - 1;
        this.mask = i2;
        this.array = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        } else if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final boolean isEmpty() {
        long j = _state$volatile$FU.get(this);
        return ((int) (HEAD_MASK & j)) == ((int) ((j & TAIL_MASK) >> 30));
    }

    public final int getSize() {
        long j = _state$volatile$FU.get(this);
        return (((int) ((j & TAIL_MASK) >> 30)) - ((int) (HEAD_MASK & j))) & MAX_CAPACITY_MASK;
    }

    public final boolean close() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & CLOSED_MASK) != 0) {
                return true;
            }
            if ((FROZEN_MASK & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j | CLOSED_MASK));
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[LOOP:1: B:20:0x0073->B:23:0x008a, LOOP_START, PHI: r0 
      PHI: (r0v3 kotlinx.coroutines.internal.LockFreeTaskQueueCore) = (r0v2 kotlinx.coroutines.internal.LockFreeTaskQueueCore), (r0v5 kotlinx.coroutines.internal.LockFreeTaskQueueCore) binds: [B:19:0x0069, B:23:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int addLast(E r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = _state$volatile$FU
        L_0x0004:
            long r3 = r0.get(r13)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0018
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r14 = Companion
            int r14 = r14.addFailReason(r3)
            return r14
        L_0x0018:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r1 = Companion
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r2 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r9 = 30
            long r5 = r5 >> r9
            int r9 = (int) r5
            int r10 = r13.mask
            int r5 = r9 + 2
            r5 = r5 & r10
            r6 = r2 & r10
            r11 = 1
            if (r5 != r6) goto L_0x0034
            return r11
        L_0x0034:
            boolean r5 = r13.singleConsumer
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            if (r5 != 0) goto L_0x0055
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r13.getArray()
            r12 = r9 & r10
            java.lang.Object r5 = r5.get(r12)
            if (r5 == 0) goto L_0x0055
            int r1 = r13.capacity
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L_0x0054
            int r9 = r9 - r2
            r2 = r9 & r6
            int r1 = r1 >> 1
            if (r2 <= r1) goto L_0x0004
        L_0x0054:
            return r11
        L_0x0055:
            int r2 = r9 + 1
            r2 = r2 & r6
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = _state$volatile$FU
            long r11 = r1.updateTail(r3, r2)
            r1 = r5
            r2 = r13
            r5 = r11
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L_0x0004
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.getArray()
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L_0x0073:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = _state$volatile$FU
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x008c
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.next()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.fillPlaceholder(r9, r14)
            if (r0 != 0) goto L_0x0073
        L_0x008c:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.addLast(java.lang.Object):int");
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int i, E e) {
        Object obj = getArray().get(this.mask & i);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != i) {
            return null;
        }
        getArray().set(i & this.mask, e);
        return this;
    }

    public final Object removeFirstOrNull() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((FROZEN_MASK & j) != 0) {
                return REMOVE_FROZEN;
            }
            Companion companion = Companion;
            int i = (int) (HEAD_MASK & j);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.mask;
            if ((i2 & i3) == (i3 & i)) {
                return null;
            }
            Object obj = getArray().get(this.mask & i);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i4 = (i + 1) & MAX_CAPACITY_MASK;
                if (_state$volatile$FU.compareAndSet(this, j, companion.updateHead(j, i4))) {
                    getArray().set(this.mask & i, (Object) null);
                    return obj;
                } else if (this.singleConsumer) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.removeSlowPath(i, i4);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int i, int i2) {
        long j;
        Companion companion;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            companion = Companion;
            i3 = (int) (HEAD_MASK & j);
            if (DebugKt.getASSERTIONS_ENABLED() && i3 != i) {
                throw new AssertionError();
            } else if ((FROZEN_MASK & j) != 0) {
                return next();
            }
        } while (!_state$volatile$FU.compareAndSet(this, j, companion.updateHead(j, i2)));
        getArray().set(this.mask & i3, (Object) null);
        return null;
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    private final long markFrozen() {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & FROZEN_MASK) != 0) {
                return j;
            }
            j2 = j | FROZEN_MASK;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
        return j2;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long j) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$volatile$FU;
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_next$volatile$FU, this, (Object) null, allocateNextCopy(j));
        }
    }

    private final LockFreeTaskQueueCore<E> allocateNextCopy(long j) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i = (int) (HEAD_MASK & j);
        int i2 = (int) ((TAIL_MASK & j) >> 30);
        while (true) {
            int i3 = this.mask;
            if ((i & i3) != (i3 & i2)) {
                Object obj = getArray().get(this.mask & i);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                lockFreeTaskQueueCore.getArray().set(lockFreeTaskQueueCore.mask & i, obj);
                i++;
            } else {
                _state$volatile$FU.set(lockFreeTaskQueueCore, Companion.wo(j, FROZEN_MASK));
                return lockFreeTaskQueueCore;
            }
        }
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> function1) {
        ArrayList arrayList = new ArrayList(this.capacity);
        long j = _state$volatile$FU.get(this);
        int i = (int) (HEAD_MASK & j);
        int i2 = (int) ((j & TAIL_MASK) >> 30);
        while (true) {
            int i3 = this.mask;
            if ((i & i3) == (i3 & i2)) {
                return arrayList;
            }
            Object obj = getArray().get(this.mask & i);
            if (obj != null && !(obj instanceof Placeholder)) {
                arrayList.add(function1.invoke(obj));
            }
            i++;
        }
    }

    public final boolean isClosed() {
        return (_state$volatile$FU.get(this) & CLOSED_MASK) != 0;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int addFailReason(long j) {
            return (j & LockFreeTaskQueueCore.CLOSED_MASK) != 0 ? 2 : 1;
        }

        public final long wo(long j, long j2) {
            return j & (~j2);
        }

        private Companion() {
        }

        public final long updateHead(long j, int i) {
            return wo(j, LockFreeTaskQueueCore.HEAD_MASK) | ((long) i);
        }

        public final long updateTail(long j, int i) {
            return wo(j, LockFreeTaskQueueCore.TAIL_MASK) | (((long) i) << 30);
        }

        public final <T> T withState(long j, Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return function2.invoke(Integer.valueOf((int) (LockFreeTaskQueueCore.HEAD_MASK & j)), Integer.valueOf((int) ((j & LockFreeTaskQueueCore.TAIL_MASK) >> 30)));
        }
    }

    static {
        Class<LockFreeTaskQueueCore> cls = LockFreeTaskQueueCore.class;
        _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next$volatile");
        _state$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "_state$volatile");
    }
}
