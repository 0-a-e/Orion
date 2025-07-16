package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\tH\b\u001a!\u0010\r\u001a\u0002H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f*\u0002H\u000eH\u0000¢\u0006\u0002\u0010\u0010\u001as\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u001328\b\b\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\b\u001ag\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u00132\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0000¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u001f\u001a\u0002H\u0013H\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "POINTERS_SHIFT", "", "addConditionally", "", "Lkotlinx/atomicfu/AtomicInt;", "delta", "condition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cur", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "findSegmentAndMoveForward", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "Lkotlinx/atomicfu/AtomicRef;", "id", "", "startFrom", "createNewSegment", "Lkotlin/Function2;", "prev", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "to", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConcurrentLinkedList.kt */
public final class ConcurrentLinkedListKt {
    /* access modifiers changed from: private */
    public static final Symbol CLOSED = new Symbol("CLOSED");
    private static final int POINTERS_SHIFT = 16;

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super S, ? extends S>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S extends kotlinx.coroutines.internal.Segment<S>> java.lang.Object findSegmentInternal(S r4, long r5, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super S, ? extends S> r7) {
        /*
        L_0x0000:
            long r0 = r4.id
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0012
            boolean r0 = r4.isRemoved()
            if (r0 == 0) goto L_0x000d
            goto L_0x0012
        L_0x000d:
            java.lang.Object r4 = kotlinx.coroutines.internal.SegmentOrClosed.m8621constructorimpl(r4)
            return r4
        L_0x0012:
            r0 = r4
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r0
            java.lang.Object r0 = r0.getNextOrClosed()
            kotlinx.coroutines.internal.Symbol r1 = CLOSED
            if (r0 != r1) goto L_0x0026
            kotlinx.coroutines.internal.Symbol r4 = CLOSED
            java.lang.Object r4 = kotlinx.coroutines.internal.SegmentOrClosed.m8621constructorimpl(r4)
            return r4
        L_0x0026:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r0
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            if (r0 == 0) goto L_0x002e
        L_0x002c:
            r4 = r0
            goto L_0x0000
        L_0x002e:
            long r0 = r4.id
            r2 = 1
            long r0 = r0 + r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Object r0 = r7.invoke(r0, r4)
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            r1 = r0
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r1
            boolean r1 = r4.trySetNext(r1)
            if (r1 == 0) goto L_0x0000
            boolean r1 = r4.isRemoved()
            if (r1 == 0) goto L_0x002c
            r4.remove()
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ConcurrentLinkedListKt.findSegmentInternal(kotlinx.coroutines.internal.Segment, long, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static final /* synthetic */ <S extends Segment<S>> boolean moveForward$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, S s) {
        while (true) {
            Segment segment = (Segment) atomicReferenceFieldUpdater.get(obj);
            if (segment.id >= s.id) {
                return true;
            }
            if (!s.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, segment, s)) {
                if (segment.decPointers$kotlinx_coroutines_core()) {
                    segment.remove();
                }
                return true;
            } else if (s.decPointers$kotlinx_coroutines_core()) {
                s.remove();
            }
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> boolean moveForward$atomicfu$array(AtomicReferenceArray atomicReferenceArray, int i, S s) {
        while (true) {
            Segment segment = (Segment) atomicReferenceArray.get(i);
            if (segment.id >= s.id) {
                return true;
            }
            if (!s.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, segment, s)) {
                if (segment.decPointers$kotlinx_coroutines_core()) {
                    segment.remove();
                }
                return true;
            } else if (s.decPointers$kotlinx_coroutines_core()) {
                s.remove();
            }
        }
    }

    public static final /* synthetic */ <S extends Segment<S>> Object findSegmentAndMoveForward$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        Object findSegmentInternal;
        loop0:
        while (true) {
            findSegmentInternal = findSegmentInternal(s, j, function2);
            if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r1 = SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(obj);
                if (segment.id >= r1.id) {
                    break loop0;
                } else if (r1.tryIncPointers$kotlinx_coroutines_core()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, segment, r1)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r1.decPointers$kotlinx_coroutines_core()) {
                        r1.remove();
                    }
                }
            }
        }
        return findSegmentInternal;
    }

    public static final /* synthetic */ <S extends Segment<S>> Object findSegmentAndMoveForward$atomicfu$array(AtomicReferenceArray atomicReferenceArray, int i, long j, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        Object findSegmentInternal;
        loop0:
        while (true) {
            findSegmentInternal = findSegmentInternal(s, j, function2);
            if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r1 = SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceArray.get(i);
                if (segment.id >= r1.id) {
                    break loop0;
                } else if (r1.tryIncPointers$kotlinx_coroutines_core()) {
                    if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, segment, r1)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r1.decPointers$kotlinx_coroutines_core()) {
                        r1.remove();
                    }
                }
            }
        }
        return findSegmentInternal;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int i, Function1<? super Integer, Boolean> function1) {
        int i2;
        do {
            i2 = atomicIntegerFieldUpdater.get(obj);
            if (!function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i2, i2 + i));
        return true;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu$array(AtomicIntegerArray atomicIntegerArray, int i, int i2, Function1<? super Integer, Boolean> function1) {
        int i3;
        do {
            i3 = atomicIntegerArray.get(i);
            if (!function1.invoke(Integer.valueOf(i3)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i3, i3 + i2));
        return true;
    }

    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n) {
        while (true) {
            N access$getNextOrClosed = n.getNextOrClosed();
            if (access$getNextOrClosed == CLOSED) {
                return n;
            }
            N n2 = (ConcurrentLinkedListNode) access$getNextOrClosed;
            if (n2 != null) {
                n = n2;
            } else if (n.markAsClosed()) {
                return n;
            }
        }
    }
}
