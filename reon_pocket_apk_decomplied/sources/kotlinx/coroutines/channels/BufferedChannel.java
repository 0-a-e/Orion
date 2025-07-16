package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b$\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004à\u0001á\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u001a\u00020\u0007H\u0014J\u001f\u0010\u0001\u001a\u00020\u00072\u0014\u0010\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0001H\u0002J\u0019\u0010\u0001\u001a\u00020\u00072\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002¢\u0006\u0003\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0003\u0010\u0001J(\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u00002\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0001H\u0002¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0001\u001a\u00020\u0007H\u0014J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0003\u0010\u0001J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J>\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0010H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0002\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0001\u0010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0005\u0012\u0003H\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0005\u0012\u0003H\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u00012X\b\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0005\u0012\u0003H\u000108H\b¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00102\b\u0010\u0001\u001a\u00030¨\u00012#\u0010\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\bJ/\u0010©\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0010H@¢\u0006\u0003\u0010\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u0019\u0010­\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0003\u0010\u0001J\u001c\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0006\b¯\u0001\u0010\u0001J\u0002\u0010°\u0001\u001a\u0003H\u0001\"\u0005\b\u0001\u0010\u00012\u0007\u0010\u0001\u001a\u00028\u00002\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0005\u0012\u0003H\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u00012o\b\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(´\u0001\u0012\u0005\u0012\u0003H\u00010³\u0001H\b¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\b\u0010\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\b¢\u0006\u0003\u0010·\u0001J8\u0010¸\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H@¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\bÀ\u0001J\u001e\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J'\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J'\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0001\u001a\u00028\u0000H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÈ\u0001\u0010Æ\u0001J(\u0010É\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J(\u0010Ë\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J5\u0010Ì\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010Í\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010Î\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001JK\u0010Ñ\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Õ\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÖ\u0001J$\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ú\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Û\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ü\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Ý\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Þ\u0001J#\u0010ß\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004R\t\u0010\r\u001a\u00020\u000eX\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R&\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0004R\t\u0010D\u001a\u00020\u000eX\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0004R\t\u0010J\u001a\u00020\u000eX\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006â\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", "close", "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BufferedChannel.kt */
public class BufferedChannel<E> implements Channel<E> {
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU;
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU;
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    static {
        Class<BufferedChannel> cls = BufferedChannel.class;
        sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus$volatile");
        receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "receivers$volatile");
        bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd$volatile");
        completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag$volatile");
        sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "sendSegment$volatile");
        receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "receiveSegment$volatile");
        bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "bufferEndSegment$volatile");
        _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_closeCause$volatile");
        closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "closeHandler$volatile");
    }

    private final /* synthetic */ Object getAndUpdate$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
        return obj2;
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private final /* synthetic */ Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private final /* synthetic */ Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final /* synthetic */ Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    private final /* synthetic */ Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private final /* synthetic */ Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
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

    private final /* synthetic */ void setBufferEnd$volatile(long j) {
        this.bufferEnd$volatile = j;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j) {
        this.completedExpandBuffersAndPauseFlag$volatile = j;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j) {
        this.receivers$volatile = j;
    }

    private final /* synthetic */ void setSendSegment$volatile(Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j) {
        this.sendersAndCloseStatus$volatile = j;
    }

    private final /* synthetic */ void set_closeCause$volatile(Object obj) {
        this._closeCause$volatile = obj;
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.invoke(Long.valueOf(j)).longValue()));
    }

    /* access modifiers changed from: protected */
    public boolean isConflatedDropOldest() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onClosedIdempotent() {
    }

    /* access modifiers changed from: protected */
    public void onReceiveDequeued() {
    }

    /* access modifiers changed from: protected */
    public void onReceiveEnqueued() {
    }

    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public Object m8559receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m8557receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    public BufferedChannel(int i, Function1<? super E, Unit> function1) {
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i >= 0) {
            this.bufferEnd$volatile = BufferedChannelKt.initialBufferEnd(i);
            this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
            ChannelSegment channelSegment = new ChannelSegment(0, (ChannelSegment) null, this, 3);
            this.sendSegment$volatile = channelSegment;
            this.receiveSegment$volatile = channelSegment;
            if (isRendezvousOrUnlimited()) {
                channelSegment = BufferedChannelKt.NULL_SEGMENT;
                Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = channelSegment;
            this.onUndeliveredElementReceiveCancellationConstructor = function1 != null ? new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this) : null;
            this._closeCause$volatile = BufferedChannelKt.NO_CLOSE_CAUSE;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i + ", should be >=0").toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return Channel.DefaultImpls.poll(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Unit> continuation) {
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = 1152921504606846975L & andIncrement;
            boolean access$isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    Object onClosedSend = bufferedChannel.onClosedSend(e, continuation);
                    if (onClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend;
                    }
                }
            }
            int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i, e, j, (Object) null, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            } else if (access$updateCellSend == 1) {
                break;
            } else if (access$updateCellSend != 2) {
                if (access$updateCellSend == 3) {
                    Object sendOnNoWaiterSuspend = bufferedChannel.sendOnNoWaiterSuspend(channelSegment, i, e, j, continuation);
                    if (sendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return sendOnNoWaiterSuspend;
                    }
                } else if (access$updateCellSend == 4) {
                    if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Object onClosedSend2 = bufferedChannel.onClosedSend(e, continuation);
                    if (onClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend2;
                    }
                } else if (access$updateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
            } else if (access$isClosedForSend0) {
                channelSegment.onSlotCleaned();
                Object onClosedSend3 = bufferedChannel.onClosedSend(e, continuation);
                if (onClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return onClosedSend3;
                }
            } else if (DebugKt.getASSERTIONS_ENABLED()) {
                throw new AssertionError();
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        waiter.invokeOnCancellation(channelSegment, i + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, cancellableContinuation.getContext());
        }
        Continuation continuation = cancellableContinuation;
        Throwable sendException = getSendException();
        if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
            sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, (CoroutineStackFrame) continuation);
        }
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m7042constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return kotlinx.coroutines.channels.ChannelResult.Companion.m8583closedJP2dKIU(getSendException());
     */
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m8561trySendJP2dKIU(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = sendersAndCloseStatus$volatile$FU
            long r0 = r0.get(r14)
            boolean r0 = r14.shouldSendSuspend(r0)
            if (r0 == 0) goto L_0x0015
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.m8584failurePtdJZtk()
            return r15
        L_0x0015:
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$volatile$FU
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0023:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$volatile$FU
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = r14.isClosedForSend0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r1 = (long) r1
            long r1 = r9 / r1
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r3 = (long) r3
            long r3 = r9 % r3
            int r12 = (int) r3
            long r3 = r0.id
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0052
            kotlinx.coroutines.channels.ChannelSegment r1 = r14.findSegmentSend(r1, r0)
            if (r1 != 0) goto L_0x0050
            if (r11 == 0) goto L_0x0023
            goto L_0x0092
        L_0x0050:
            r13 = r1
            goto L_0x0053
        L_0x0052:
            r13 = r0
        L_0x0053:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00b4
            r1 = 1
            if (r0 == r1) goto L_0x00b7
            r1 = 2
            if (r0 == r1) goto L_0x008d
            r1 = 3
            if (r0 == r1) goto L_0x0081
            r1 = 4
            if (r0 == r1) goto L_0x0075
            r1 = 5
            if (r0 == r1) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            r13.cleanPrev()
        L_0x0073:
            r0 = r13
            goto L_0x0023
        L_0x0075:
            long r0 = r14.getReceiversCounter$kotlinx_coroutines_core()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L_0x0092
            r13.cleanPrev()
            goto L_0x0092
        L_0x0081:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x008d:
            if (r11 == 0) goto L_0x009d
            r13.onSlotCleaned()
        L_0x0092:
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r0 = r14.getSendException()
            java.lang.Object r15 = r15.m8583closedJP2dKIU(r0)
            goto L_0x00bf
        L_0x009d:
            boolean r15 = r8 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L_0x00a4
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8
            goto L_0x00a5
        L_0x00a4:
            r8 = 0
        L_0x00a5:
            if (r8 == 0) goto L_0x00aa
            r14.prepareSenderForSuspension(r8, r13, r12)
        L_0x00aa:
            r13.onSlotCleaned()
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.m8584failurePtdJZtk()
            goto L_0x00bf
        L_0x00b4:
            r13.cleanPrev()
        L_0x00b7:
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.Object r15 = r15.m8585successJP2dKIU(r0)
        L_0x00bf:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m8561trySendJP2dKIU(java.lang.Object):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BufferedChannel.kt */
    private static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        public void invokeOnCancellation(Segment<?> segment, int i) {
            this.$$delegate_0.invokeOnCancellation(segment, i);
        }

        public SendBroadcast(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.cont = cancellableContinuation;
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }
    }

    static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i, Object obj3) {
        Function4 function42;
        ChannelSegment channelSegment;
        BufferedChannel bufferedChannel2 = bufferedChannel;
        Object obj4 = obj2;
        if (obj3 == null) {
            if ((i & 32) != 0) {
                function42 = BufferedChannel$sendImpl$1.INSTANCE;
            } else {
                function42 = function4;
            }
            ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel2);
            while (true) {
                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel2);
                long j = andIncrement & 1152921504606846975L;
                boolean access$isClosedForSend0 = bufferedChannel2.isClosedForSend0(andIncrement);
                long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j2) {
                    ChannelSegment access$findSegmentSend = bufferedChannel2.findSegmentSend(j2, channelSegment2);
                    if (access$findSegmentSend != null) {
                        channelSegment = access$findSegmentSend;
                    } else if (access$isClosedForSend0) {
                        return function02.invoke();
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, obj, j, obj2, access$isClosedForSend0);
                if (access$updateCellSend == 0) {
                    channelSegment.cleanPrev();
                    return function0.invoke();
                } else if (access$updateCellSend == 1) {
                    return function0.invoke();
                } else {
                    if (access$updateCellSend != 2) {
                        if (access$updateCellSend == 3) {
                            return function42.invoke(channelSegment, Integer.valueOf(i2), obj, Long.valueOf(j));
                        } else if (access$updateCellSend != 4) {
                            if (access$updateCellSend == 5) {
                                channelSegment.cleanPrev();
                            }
                            channelSegment2 = channelSegment;
                        } else {
                            if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            return function02.invoke();
                        }
                    } else if (access$isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return function02.invoke();
                    } else {
                        Waiter waiter = obj4 instanceof Waiter ? (Waiter) obj4 : null;
                        if (waiter != null) {
                            bufferedChannel2.prepareSenderForSuspension(waiter, channelSegment, i2);
                        }
                        return function2.invoke(channelSegment, Integer.valueOf(i2));
                    }
                }
            }
        } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
    }

    private final <R> R sendImpl(E e, Object obj, Function0<? extends R> function0, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> function2, Function0<? extends R> function02, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> function4) {
        ChannelSegment channelSegment;
        Object obj2 = obj;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                ChannelSegment access$findSegmentSend = findSegmentSend(j2, channelSegment2);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    return function02.invoke();
                }
            } else {
                channelSegment = channelSegment2;
            }
            int access$updateCellSend = updateCellSend(channelSegment, i, e, j, obj, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                return function0.invoke();
            } else if (access$updateCellSend == 1) {
                return function0.invoke();
            } else {
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend == 3) {
                        return function4.invoke(channelSegment, Integer.valueOf(i), e, Long.valueOf(j));
                    } else if (access$updateCellSend != 4) {
                        if (access$updateCellSend == 5) {
                            channelSegment.cleanPrev();
                        }
                        channelSegment2 = channelSegment;
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        return function02.invoke();
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return function02.invoke();
                } else {
                    Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment, i);
                    }
                    return function2.invoke(channelSegment, Integer.valueOf(i));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: trySendDropOldest-JP2dKIU  reason: not valid java name */
    public final Object m8562trySendDropOldestJP2dKIU(E e) {
        ChannelSegment channelSegment;
        Symbol symbol = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                ChannelSegment access$findSegmentSend = findSegmentSend(j2, channelSegment2);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    return ChannelResult.Companion.m8583closedJP2dKIU(getSendException());
                }
            } else {
                channelSegment = channelSegment2;
            }
            int access$updateCellSend = updateCellSend(channelSegment, i, e, j, symbol, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m8585successJP2dKIU(Unit.INSTANCE);
            } else if (access$updateCellSend == 1) {
                return ChannelResult.Companion.m8585successJP2dKIU(Unit.INSTANCE);
            } else {
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (access$updateCellSend != 4) {
                        if (access$updateCellSend == 5) {
                            channelSegment.cleanPrev();
                        }
                        channelSegment2 = channelSegment;
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        return ChannelResult.Companion.m8583closedJP2dKIU(getSendException());
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return ChannelResult.Companion.m8583closedJP2dKIU(getSendException());
                } else {
                    Waiter waiter = symbol instanceof Waiter ? (Waiter) symbol : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment, i);
                    }
                    dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i));
                    return ChannelResult.Companion.m8585successJP2dKIU(Unit.INSTANCE);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r26v0, types: [kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: type inference failed for: r27v0, types: [kotlin.jvm.functions.Function0<kotlin.Unit>, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sendImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment<E> r20, int r21, E r22, long r23, kotlinx.coroutines.Waiter r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, kotlin.jvm.functions.Function0<kotlin.Unit> r27) {
        /*
            r19 = this;
            r8 = r19
            r9 = r25
            r7 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r6 = r25
            int r0 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00fb
            r10 = 1
            if (r0 == r10) goto L_0x00f7
            r11 = 2
            if (r0 == r11) goto L_0x00ef
            r12 = 4
            if (r0 == r12) goto L_0x00e0
            java.lang.String r13 = "unexpected"
            r14 = 5
            if (r0 != r14) goto L_0x00d6
            r20.cleanPrev()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$volatile$FU
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0032:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$volatile$FU
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r15 = r1 & r3
            boolean r17 = r8.isClosedForSend0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r1 = (long) r1
            long r1 = r15 / r1
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r3 = (long) r3
            long r3 = r15 % r3
            int r7 = (int) r3
            long r3 = r0.id
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0066
            kotlinx.coroutines.channels.ChannelSegment r1 = r8.findSegmentSend(r1, r0)
            if (r1 != 0) goto L_0x0064
            if (r17 == 0) goto L_0x0032
            java.lang.Object r0 = r27.invoke()
            goto L_0x00d3
        L_0x0064:
            r6 = r1
            goto L_0x0067
        L_0x0066:
            r6 = r0
        L_0x0067:
            r0 = r19
            r1 = r6
            r2 = r7
            r3 = r22
            r4 = r15
            r20 = r6
            r6 = r25
            r18 = r7
            r7 = r17
            int r0 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00ca
            if (r0 == r10) goto L_0x00c5
            if (r0 == r11) goto L_0x00a8
            r1 = 3
            if (r0 == r1) goto L_0x009e
            if (r0 == r12) goto L_0x008e
            if (r0 == r14) goto L_0x0088
            goto L_0x008b
        L_0x0088:
            r20.cleanPrev()
        L_0x008b:
            r0 = r20
            goto L_0x0032
        L_0x008e:
            long r0 = r19.getReceiversCounter$kotlinx_coroutines_core()
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0099
            r20.cleanPrev()
        L_0x0099:
            java.lang.Object r0 = r27.invoke()
            goto L_0x00d3
        L_0x009e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r13.toString()
            r0.<init>(r1)
            throw r0
        L_0x00a8:
            if (r17 == 0) goto L_0x00b2
            r20.onSlotCleaned()
            java.lang.Object r0 = r27.invoke()
            goto L_0x00d3
        L_0x00b2:
            boolean r0 = r9 instanceof kotlinx.coroutines.Waiter
            if (r0 == 0) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            r0 = 0
            r9 = r0
        L_0x00b9:
            if (r9 == 0) goto L_0x00c2
            r1 = r20
            r0 = r18
            r8.prepareSenderForSuspension(r9, r1, r0)
        L_0x00c2:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x00d3
        L_0x00c5:
            java.lang.Object r0 = r26.invoke()
            goto L_0x00d3
        L_0x00ca:
            r1 = r20
            r1.cleanPrev()
            java.lang.Object r0 = r26.invoke()
        L_0x00d3:
            kotlin.Unit r0 = (kotlin.Unit) r0
            goto L_0x0103
        L_0x00d6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r13.toString()
            r0.<init>(r1)
            throw r0
        L_0x00e0:
            long r0 = r19.getReceiversCounter$kotlinx_coroutines_core()
            int r0 = (r23 > r0 ? 1 : (r23 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00eb
            r20.cleanPrev()
        L_0x00eb:
            r27.invoke()
            goto L_0x0103
        L_0x00ef:
            r0 = r20
            r1 = r21
            r8.prepareSenderForSuspension(r9, r0, r1)
            goto L_0x0103
        L_0x00f7:
            r26.invoke()
            goto L_0x0103
        L_0x00fb:
            r0 = r20
            r20.cleanPrev()
            r26.invoke()
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlinx.coroutines.Waiter, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    /* access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> channelSegment, int i, E e, long j, Object obj, boolean z) {
        channelSegment.storeElement$kotlinx_coroutines_core(i, e);
        if (z) {
            return updateCellSendSlow(channelSegment, i, e, j, obj, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(j)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (obj == null) {
                return 3;
            } else {
                if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, obj)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, e)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                onReceiveDequeued();
                return 0;
            }
            if (channelSegment.getAndSetState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                channelSegment.onCancelledRequest(i, true);
            }
            return 5;
        }
        return updateCellSendSlow(channelSegment, i, e, j, obj, z);
    }

    private final int updateCellSendSlow(ChannelSegment<E> channelSegment, int i, E e, long j, Object obj, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onCancelledRequest(i, false);
                            return 4;
                        }
                    } else if (obj == null) {
                        return 3;
                    } else {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, obj)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                return 5;
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                return 5;
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                completeCloseOrCancel();
                return 4;
            } else if (!DebugKt.getASSERTIONS_ENABLED() || (state$kotlinx_coroutines_core instanceof Waiter) || (state$kotlinx_coroutines_core instanceof WaiterEB)) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                }
                if (tryResumeReceiver(state$kotlinx_coroutines_core, e)) {
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                    onReceiveDequeued();
                    return 0;
                }
                if (channelSegment.getAndSetState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                    channelSegment.onCancelledRequest(i, true);
                }
                return 5;
            } else {
                throw new AssertionError();
            }
        }
    }

    private final boolean shouldSendSuspend(long j) {
        if (isClosedForSend0(j)) {
            return false;
        }
        return !bufferOrRendezvousSend(j & 1152921504606846975L);
    }

    private final boolean bufferOrRendezvousSend(long j) {
        return j < getBufferEndCounter() || j < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean tryResumeReceiver(Object obj, E e) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e);
        }
        Function1<Throwable, Unit> function1 = null;
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching receiveCatching = (ReceiveCatching) obj;
            CancellableContinuation cancellableContinuation = receiveCatching.cont;
            ChannelResult r2 = ChannelResult.m8570boximpl(ChannelResult.Companion.m8585successJP2dKIU(e));
            Function1<E, Unit> function12 = this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e, receiveCatching.cont.getContext());
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation, r2, function1);
        } else if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e);
        } else if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation2 = (CancellableContinuation) obj;
            Function1<E, Unit> function13 = this.onUndeliveredElement;
            if (function13 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function13, e, cancellableContinuation2.getContext());
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation2, e, function1);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j) {
                ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Object access$updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, (Object) null);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException("unexpected".toString());
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                return bufferedChannel.receiveOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation);
            } else {
                channelSegment.cleanPrev();
                return access$updateCellReceive;
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    /* access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m7042constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <E> java.lang.Object m8557receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r13, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
        L_0x0019:
            r6 = r0
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.m8582unboximpl()
            goto L_0x00b4
        L_0x0032:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = receiveSegment$volatile$FU
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L_0x0047:
            boolean r1 = r13.isClosedForReceive()
            if (r1 == 0) goto L_0x0058
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r13 = r13.getCloseCause()
            java.lang.Object r13 = r14.m8583closedJP2dKIU(r13)
            goto L_0x00b4
        L_0x0058:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = receivers$volatile$FU
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r1
            long r7 = r4 / r7
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.id
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0079
            kotlinx.coroutines.channels.ChannelSegment r1 = r13.findSegmentReceive(r7, r14)
            if (r1 != 0) goto L_0x0078
            goto L_0x0047
        L_0x0078:
            r14 = r1
        L_0x0079:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = r7.updateCellReceive(r8, r9, r10, r12)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND
            if (r1 == r7) goto L_0x00b5
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED
            if (r1 != r7) goto L_0x009a
            long r7 = r13.getSendersCounter$kotlinx_coroutines_core()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0047
            r14.cleanPrev()
            goto L_0x0047
        L_0x009a:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER
            if (r1 != r7) goto L_0x00ab
            r6.label = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.m8558receiveCatchingOnNoWaiterSuspendGKJJFZk(r2, r3, r4, r6)
            if (r13 != r0) goto L_0x00b4
            return r0
        L_0x00ab:
            r14.cleanPrev()
            kotlinx.coroutines.channels.ChannelResult$Companion r13 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r13 = r13.m8585successJP2dKIU(r1)
        L_0x00b4:
            return r13
        L_0x00b5:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m8557receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v3, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: type inference failed for: r8v4, types: [kotlinx.coroutines.Waiter] */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m8558receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> r17, int r18, long r19, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r21) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            r8 = r18
            r9 = r19
            r1 = r21
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            if (r2 == 0) goto L_0x001e
            r2 = r1
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r2 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001e
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x0023
        L_0x001e:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r2 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            r2.<init>(r7, r1)
        L_0x0023:
            java.lang.Object r1 = r2.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L_0x0049
            if (r3 != r4) goto L_0x0041
            long r3 = r2.J$0
            int r0 = r2.I$0
            java.lang.Object r0 = r2.L$1
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            java.lang.Object r0 = r2.L$0
            kotlinx.coroutines.channels.BufferedChannel r0 = (kotlinx.coroutines.channels.BufferedChannel) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x015f
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r7
            r2.L$1 = r0
            r2.I$0 = r8
            r2.J$0 = r9
            r2.label = r4
            r12 = r2
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r12)
            kotlinx.coroutines.CancellableContinuationImpl r13 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r1)
            kotlinx.coroutines.channels.ReceiveCatching r14 = new kotlinx.coroutines.channels.ReceiveCatching     // Catch:{ all -> 0x0166 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r1)     // Catch:{ all -> 0x0166 }
            r14.<init>(r13)     // Catch:{ all -> 0x0166 }
            r6 = r14
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6     // Catch:{ all -> 0x0166 }
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            java.lang.Object r1 = r1.updateCellReceive(r2, r3, r4, r6)     // Catch:{ all -> 0x0166 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x0166 }
            if (r1 != r2) goto L_0x0087
            kotlinx.coroutines.Waiter r14 = (kotlinx.coroutines.Waiter) r14     // Catch:{ all -> 0x0166 }
            r7.prepareReceiverForSuspension(r14, r0, r8)     // Catch:{ all -> 0x0166 }
            goto L_0x014f
        L_0x0087:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x0166 }
            r8 = 0
            if (r1 != r2) goto L_0x0135
            long r1 = r16.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0166 }
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0099
            r17.cleanPrev()     // Catch:{ all -> 0x0166 }
        L_0x0099:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$volatile$FU     // Catch:{ all -> 0x0166 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0166 }
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0     // Catch:{ all -> 0x0166 }
        L_0x00a3:
            boolean r1 = r16.isClosedForReceive()     // Catch:{ all -> 0x0166 }
            if (r1 == 0) goto L_0x00b1
            r0 = r13
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0     // Catch:{ all -> 0x0166 }
            r7.onClosedReceiveCatchingOnNoWaiterSuspend(r0)     // Catch:{ all -> 0x0166 }
            goto L_0x014f
        L_0x00b1:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = receivers$volatile$FU     // Catch:{ all -> 0x0166 }
            long r9 = r1.getAndIncrement(r7)     // Catch:{ all -> 0x0166 }
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0166 }
            long r1 = (long) r1     // Catch:{ all -> 0x0166 }
            long r1 = r9 / r1
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0166 }
            long r3 = (long) r3     // Catch:{ all -> 0x0166 }
            long r3 = r9 % r3
            int r15 = (int) r3     // Catch:{ all -> 0x0166 }
            long r3 = r0.id     // Catch:{ all -> 0x0166 }
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x00d2
            kotlinx.coroutines.channels.ChannelSegment r1 = r7.findSegmentReceive(r1, r0)     // Catch:{ all -> 0x0166 }
            if (r1 != 0) goto L_0x00d1
            goto L_0x00a3
        L_0x00d1:
            r0 = r1
        L_0x00d2:
            r6 = r14
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6     // Catch:{ all -> 0x0166 }
            r1 = r16
            r2 = r0
            r3 = r15
            r4 = r9
            java.lang.Object r1 = r1.updateCellReceive(r2, r3, r4, r6)     // Catch:{ all -> 0x0166 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x0166 }
            if (r1 != r2) goto L_0x00f4
            r1 = r14
            kotlinx.coroutines.Waiter r1 = (kotlinx.coroutines.Waiter) r1     // Catch:{ all -> 0x0166 }
            boolean r1 = r1 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x0166 }
            if (r1 == 0) goto L_0x00ee
            r8 = r14
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8     // Catch:{ all -> 0x0166 }
        L_0x00ee:
            if (r8 == 0) goto L_0x014f
            r7.prepareReceiverForSuspension(r8, r0, r15)     // Catch:{ all -> 0x0166 }
            goto L_0x014f
        L_0x00f4:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x0166 }
            if (r1 != r2) goto L_0x0106
            long r1 = r16.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0166 }
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a3
            r0.cleanPrev()     // Catch:{ all -> 0x0166 }
            goto L_0x00a3
        L_0x0106:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x0166 }
            if (r1 == r2) goto L_0x0129
            r0.cleanPrev()     // Catch:{ all -> 0x0166 }
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion     // Catch:{ all -> 0x0166 }
            java.lang.Object r0 = r0.m8585successJP2dKIU(r1)     // Catch:{ all -> 0x0166 }
            kotlinx.coroutines.channels.ChannelResult r0 = kotlinx.coroutines.channels.ChannelResult.m8570boximpl(r0)     // Catch:{ all -> 0x0166 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r2 = r7.onUndeliveredElement     // Catch:{ all -> 0x0166 }
            if (r2 == 0) goto L_0x0125
            kotlin.coroutines.CoroutineContext r3 = r13.getContext()     // Catch:{ all -> 0x0166 }
            kotlin.jvm.functions.Function1 r8 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r2, r1, r3)     // Catch:{ all -> 0x0166 }
        L_0x0125:
            r13.resume(r0, r8)     // Catch:{ all -> 0x0166 }
            goto L_0x014f
        L_0x0129:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0166 }
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0166 }
            r0.<init>(r1)     // Catch:{ all -> 0x0166 }
            throw r0     // Catch:{ all -> 0x0166 }
        L_0x0135:
            r17.cleanPrev()     // Catch:{ all -> 0x0166 }
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion     // Catch:{ all -> 0x0166 }
            java.lang.Object r0 = r0.m8585successJP2dKIU(r1)     // Catch:{ all -> 0x0166 }
            kotlinx.coroutines.channels.ChannelResult r0 = kotlinx.coroutines.channels.ChannelResult.m8570boximpl(r0)     // Catch:{ all -> 0x0166 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r2 = r7.onUndeliveredElement     // Catch:{ all -> 0x0166 }
            if (r2 == 0) goto L_0x0125
            kotlin.coroutines.CoroutineContext r3 = r13.getContext()     // Catch:{ all -> 0x0166 }
            kotlin.jvm.functions.Function1 r8 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r2, r1, r3)     // Catch:{ all -> 0x0166 }
            goto L_0x0125
        L_0x014f:
            java.lang.Object r1 = r13.getResult()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r1 != r0) goto L_0x015c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r12)
        L_0x015c:
            if (r1 != r11) goto L_0x015f
            return r11
        L_0x015f:
            kotlinx.coroutines.channels.ChannelResult r1 = (kotlinx.coroutines.channels.ChannelResult) r1
            java.lang.Object r0 = r1.m8582unboximpl()
            return r0
        L_0x0166:
            r0 = move-exception
            r13.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m8558receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m7042constructorimpl(ChannelResult.m8570boximpl(ChannelResult.Companion.m8583closedJP2dKIU(getCloseCause()))));
    }

    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public Object m8560tryReceivePtdJZtk() {
        ChannelSegment channelSegment;
        long j = receivers$volatile$FU.get(this);
        long j2 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(j2)) {
            return ChannelResult.Companion.m8583closedJP2dKIU(getCloseCause());
        }
        if (j >= (j2 & 1152921504606846975L)) {
            return ChannelResult.Companion.m8584failurePtdJZtk();
        }
        Symbol access$getINTERRUPTED_RCV$p = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j3 = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j3) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j3, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, access$getINTERRUPTED_RCV$p);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = access$getINTERRUPTED_RCV$p instanceof Waiter ? (Waiter) access$getINTERRUPTED_RCV$p : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment.onSlotCleaned();
                return ChannelResult.Companion.m8584failurePtdJZtk();
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            } else if (access$updateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m8585successJP2dKIU(access$updateCellReceive);
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return ChannelResult.Companion.m8583closedJP2dKIU(getCloseCause());
    }

    /* access modifiers changed from: protected */
    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        if (!DebugKt.getASSERTIONS_ENABLED() || isConflatedDropOldest()) {
            ChannelSegment channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            while (true) {
                long j2 = receivers$volatile$FU.get(this);
                if (j >= Math.max(((long) this.capacity) + j2, getBufferEndCounter())) {
                    if (receivers$volatile$FU.compareAndSet(this, j2, j2 + 1)) {
                        long j3 = j2 / ((long) BufferedChannelKt.SEGMENT_SIZE);
                        int i = (int) (j2 % ((long) BufferedChannelKt.SEGMENT_SIZE));
                        if (channelSegment.id != j3) {
                            ChannelSegment findSegmentReceive = findSegmentReceive(j3, channelSegment);
                            if (findSegmentReceive == null) {
                                continue;
                            } else {
                                channelSegment = findSegmentReceive;
                            }
                        }
                        Object updateCellReceive = updateCellReceive(channelSegment, i, j2, (Object) null);
                        if (updateCellReceive != BufferedChannelKt.FAILED) {
                            channelSegment.cleanPrev();
                            Function1<E, Unit> function1 = this.onUndeliveredElement;
                            if (!(function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updateCellReceive, (UndeliveredElementException) null, 2, (Object) null)) == null)) {
                                throw callUndeliveredElementCatchingException$default;
                            }
                        } else if (j2 < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 16) != 0) {
                function32 = BufferedChannel$receiveImpl$1.INSTANCE;
            }
            ChannelSegment channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = receivers$volatile$FU.getAndIncrement(bufferedChannel);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment.id != j) {
                    ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = access$findSegmentReceive;
                    }
                }
                Object access$updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i2, andIncrement, obj);
                if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                    Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                    if (waiter != null) {
                        bufferedChannel.prepareReceiverForSuspension(waiter, channelSegment, i2);
                    }
                    return function3.invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
                } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return function32.invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
                } else {
                    channelSegment.cleanPrev();
                    return function1.invoke(access$updateCellReceive);
                }
            }
            return function0.invoke();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    private final <R> R receiveImpl(Object obj, Function1<? super E, ? extends R> function1, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function3, Function0<? extends R> function0, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function32) {
        ChannelSegment channelSegment;
        Object obj2 = obj;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, obj);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i);
                }
                Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function33 = function3;
                return function3.invoke(channelSegment, Integer.valueOf(i), Long.valueOf(andIncrement));
            }
            Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function34 = function3;
            if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                return function32.invoke(channelSegment, Integer.valueOf(i), Long.valueOf(andIncrement));
            } else {
                channelSegment.cleanPrev();
                Function1<? super E, ? extends R> function12 = function1;
                return function1.invoke(access$updateCellReceive);
            }
        }
        return function0.invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> channelSegment, int i, long j, Waiter waiter, Function1<? super E, Unit> function1, Function0<Unit> function0) {
        Object access$updateCellReceive = updateCellReceive(channelSegment, i, j, waiter);
        if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
            prepareReceiverForSuspension(waiter, channelSegment, i);
        } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
            if (j < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            while (!isClosedForReceive()) {
                long andIncrement = receivers$volatile$FU.getAndIncrement(this);
                long j2 = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j2) {
                    ChannelSegment access$findSegmentReceive = findSegmentReceive(j2, channelSegment2);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment2 = access$findSegmentReceive;
                    }
                }
                Object access$updateCellReceive2 = updateCellReceive(channelSegment2, i2, andIncrement, waiter);
                if (access$updateCellReceive2 == BufferedChannelKt.SUSPEND) {
                    if (!(waiter instanceof Waiter)) {
                        waiter = null;
                    }
                    if (waiter != null) {
                        prepareReceiverForSuspension(waiter, channelSegment2, i2);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                } else if (access$updateCellReceive2 == BufferedChannelKt.FAILED) {
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment2.cleanPrev();
                    }
                } else if (access$updateCellReceive2 != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment2.cleanPrev();
                    function1.invoke(access$updateCellReceive2);
                    return;
                } else {
                    throw new IllegalStateException("unexpected".toString());
                }
            }
            function0.invoke();
        } else {
            channelSegment.cleanPrev();
            function1.invoke(access$updateCellReceive);
        }
    }

    /* access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> channelSegment, int i, long j, Object obj) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
        }
        return updateCellReceiveSlow(channelSegment, i, j, obj);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> channelSegment, int i, long j, Object obj) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (j < (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                } else {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                return BufferedChannelKt.FAILED;
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    expandBuffer();
                    return BufferedChannelKt.FAILED;
                } else if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV)) {
                    boolean z = state$kotlinx_coroutines_core instanceof WaiterEB;
                    if (z) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        expandBuffer();
                        return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                    channelSegment.onCancelledRequest(i, false);
                    if (z) {
                        expandBuffer();
                    }
                    return BufferedChannelKt.FAILED;
                }
            }
        }
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, (Function1) null, 2, (Object) null);
        } else if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            return trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL;
        } else if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), true, (Function1) null, 2, (Object) null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    private final void expandBuffer() {
        if (!isRendezvousOrUnlimited()) {
            ChannelSegment channelSegment = (ChannelSegment) bufferEndSegment$volatile$FU.get(this);
            while (true) {
                long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                    if (channelSegment.id < j && channelSegment.getNext() != null) {
                        moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                    }
                    incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
                    return;
                }
                if (channelSegment.id != j) {
                    ChannelSegment findSegmentBufferEnd = findSegmentBufferEnd(j, channelSegment, andIncrement);
                    if (findSegmentBufferEnd == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentBufferEnd;
                    }
                }
                if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE)), andIncrement)) {
                    incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
                    return;
                }
                incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            }
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> channelSegment, int i, long j) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (!(state$kotlinx_coroutines_core instanceof Waiter) || j < receivers$volatile$FU.get(this) || !channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
            return updateCellExpandBufferSlow(channelSegment, i, j);
        }
        if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
            channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
            return true;
        }
        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
        channelSegment.onCancelledRequest(i, false);
        return false;
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> channelSegment, int i, long j) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core instanceof Waiter) {
                if (j < receivers$volatile$FU.get(this)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                        return true;
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                    channelSegment.onCancelledRequest(i, false);
                    return false;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                return false;
            } else {
                if (state$kotlinx_coroutines_core == null) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER)) {
                        return true;
                    }
                } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return true;
                } else {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                        throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
        return true;
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 1;
            }
            bufferedChannel.incCompletedExpandBufferAttempts(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void incCompletedExpandBufferAttempts(long j) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, j) & 4611686018427387904L) != 0) {
            do {
            } while ((completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & 4611686018427387904L) != 0);
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j) {
        long j2;
        long j3;
        if (!isRendezvousOrUnlimited()) {
            do {
            } while (getBufferEndCounter() <= j);
            int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
            int i = 0;
            while (i < access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p) {
                long bufferEndCounter = getBufferEndCounter();
                if (bufferEndCounter != (completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & DurationKt.MAX_MILLIS) || bufferEndCounter != getBufferEndCounter()) {
                    i++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU2 = completedExpandBuffersAndPauseFlag$volatile$FU;
            do {
                j2 = completedExpandBuffersAndPauseFlag$volatile$FU2.get(this);
            } while (!completedExpandBuffersAndPauseFlag$volatile$FU2.compareAndSet(this, j2, BufferedChannelKt.constructEBCompletedAndPauseFlag(j2 & DurationKt.MAX_MILLIS, true)));
            while (true) {
                long bufferEndCounter2 = getBufferEndCounter();
                long j4 = completedExpandBuffersAndPauseFlag$volatile$FU.get(this);
                long j5 = j4 & DurationKt.MAX_MILLIS;
                boolean z = (4611686018427387904L & j4) != 0;
                if (bufferEndCounter2 == j5 && bufferEndCounter2 == getBufferEndCounter()) {
                    break;
                } else if (!z) {
                    completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(this, j4, BufferedChannelKt.constructEBCompletedAndPauseFlag(j5, true));
                }
            }
            AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU3 = completedExpandBuffersAndPauseFlag$volatile$FU;
            do {
                j3 = completedExpandBuffersAndPauseFlag$volatile$FU3.get(this);
            } while (!completedExpandBuffersAndPauseFlag$volatile$FU3.compareAndSet(this, j3, BufferedChannelKt.constructEBCompletedAndPauseFlag(j3 & DurationKt.MAX_MILLIS, false)));
        }
    }

    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), (Function3) null, 8, (DefaultConstructorMarker) null);
    }

    private final void onClosedSelectOnSend(E e, SelectInstance<?> selectInstance) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, selectInstance.getContext());
        }
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectSend(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> selectInstance) {
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceive(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return obj2;
        }
        throw getReceiveException();
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceiveOrNull(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return obj2;
        }
        if (getCloseCause() == null) {
            return null;
        }
        throw getReceiveException();
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object obj, Object obj2) {
        Object obj3;
        if (obj2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            obj3 = ChannelResult.Companion.m8583closedJP2dKIU(getCloseCause());
        } else {
            obj3 = ChannelResult.Companion.m8585successJP2dKIU(obj2);
        }
        return ChannelResult.m8570boximpl(obj3);
    }

    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u0006HB¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BufferedChannel.kt */
    private final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        /* access modifiers changed from: private */
        public CancellableContinuationImpl<? super Boolean> continuation;
        /* access modifiers changed from: private */
        public Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation continuation2) {
            return ChannelIterator.DefaultImpls.next(this, continuation2);
        }

        public Object hasNext(Continuation<? super Boolean> continuation2) {
            ChannelSegment channelSegment;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j) {
                    ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = access$findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object access$updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, (Object) null);
                if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                    throw new IllegalStateException("unreachable".toString());
                } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return hasNextOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation2);
                } else {
                    channelSegment.cleanPrev();
                    this.receiveResult = access$updateCellReceive;
                    return Boxing.boxBoolean(true);
                }
            }
            return Boxing.boxBoolean(onClosedHasNext());
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX WARNING: type inference failed for: r9v0 */
        /* JADX WARNING: type inference failed for: r9v2, types: [kotlin.jvm.functions.Function1] */
        /* JADX WARNING: type inference failed for: r9v3, types: [kotlinx.coroutines.Waiter] */
        /* JADX WARNING: type inference failed for: r9v7 */
        /* JADX WARNING: type inference failed for: r9v8 */
        /* JADX WARNING: type inference failed for: r9v9 */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r11, int r12, long r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
            /*
                r10 = this;
                kotlinx.coroutines.channels.BufferedChannel<E> r6 = kotlinx.coroutines.channels.BufferedChannel.this
                kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r15)
                kotlinx.coroutines.CancellableContinuationImpl r7 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
                r10.continuation = r7     // Catch:{ all -> 0x00f9 }
                r5 = r10
                kotlinx.coroutines.Waiter r5 = (kotlinx.coroutines.Waiter) r5     // Catch:{ all -> 0x00f9 }
                r0 = r6
                r1 = r11
                r2 = r12
                r3 = r13
                java.lang.Object r0 = r0.updateCellReceive(r1, r2, r3, r5)     // Catch:{ all -> 0x00f9 }
                kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00f9 }
                if (r0 != r1) goto L_0x0026
                r13 = r10
                kotlinx.coroutines.Waiter r13 = (kotlinx.coroutines.Waiter) r13     // Catch:{ all -> 0x00f9 }
                r6.prepareReceiverForSuspension(r13, r11, r12)     // Catch:{ all -> 0x00f9 }
                goto L_0x00eb
            L_0x0026:
                kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00f9 }
                r8 = 1
                r9 = 0
                if (r0 != r12) goto L_0x00d1
                long r0 = r6.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00f9 }
                int r12 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r12 >= 0) goto L_0x0039
                r11.cleanPrev()     // Catch:{ all -> 0x00f9 }
            L_0x0039:
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = kotlinx.coroutines.channels.BufferedChannel.receiveSegment$volatile$FU     // Catch:{ all -> 0x00f9 }
                java.lang.Object r11 = r11.get(r6)     // Catch:{ all -> 0x00f9 }
                kotlinx.coroutines.channels.ChannelSegment r11 = (kotlinx.coroutines.channels.ChannelSegment) r11     // Catch:{ all -> 0x00f9 }
            L_0x0043:
                boolean r12 = r6.isClosedForReceive()     // Catch:{ all -> 0x00f9 }
                if (r12 == 0) goto L_0x004e
                r10.onClosedHasNextNoWaiterSuspend()     // Catch:{ all -> 0x00f9 }
                goto L_0x00eb
            L_0x004e:
                java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = kotlinx.coroutines.channels.BufferedChannel.receivers$volatile$FU     // Catch:{ all -> 0x00f9 }
                long r12 = r12.getAndIncrement(r6)     // Catch:{ all -> 0x00f9 }
                int r14 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00f9 }
                long r0 = (long) r14     // Catch:{ all -> 0x00f9 }
                long r0 = r12 / r0
                int r14 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00f9 }
                long r2 = (long) r14     // Catch:{ all -> 0x00f9 }
                long r2 = r12 % r2
                int r14 = (int) r2     // Catch:{ all -> 0x00f9 }
                long r2 = r11.id     // Catch:{ all -> 0x00f9 }
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 == 0) goto L_0x006f
                kotlinx.coroutines.channels.ChannelSegment r0 = r6.findSegmentReceive(r0, r11)     // Catch:{ all -> 0x00f9 }
                if (r0 != 0) goto L_0x006e
                goto L_0x0043
            L_0x006e:
                r11 = r0
            L_0x006f:
                r5 = r10
                kotlinx.coroutines.Waiter r5 = (kotlinx.coroutines.Waiter) r5     // Catch:{ all -> 0x00f9 }
                r0 = r6
                r1 = r11
                r2 = r14
                r3 = r12
                java.lang.Object r0 = r0.updateCellReceive(r1, r2, r3, r5)     // Catch:{ all -> 0x00f9 }
                kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00f9 }
                if (r0 != r1) goto L_0x0090
                r12 = r10
                kotlinx.coroutines.Waiter r12 = (kotlinx.coroutines.Waiter) r12     // Catch:{ all -> 0x00f9 }
                boolean r12 = r12 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x00f9 }
                if (r12 == 0) goto L_0x008a
                r9 = r10
                kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9     // Catch:{ all -> 0x00f9 }
            L_0x008a:
                if (r9 == 0) goto L_0x00eb
                r6.prepareReceiverForSuspension(r9, r11, r14)     // Catch:{ all -> 0x00f9 }
                goto L_0x00eb
            L_0x0090:
                kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00f9 }
                if (r0 != r14) goto L_0x00a2
                long r0 = r6.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00f9 }
                int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
                if (r12 >= 0) goto L_0x0043
                r11.cleanPrev()     // Catch:{ all -> 0x00f9 }
                goto L_0x0043
            L_0x00a2:
                kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x00f9 }
                if (r0 == r12) goto L_0x00c5
                r11.cleanPrev()     // Catch:{ all -> 0x00f9 }
                r10.receiveResult = r0     // Catch:{ all -> 0x00f9 }
                r10.continuation = r9     // Catch:{ all -> 0x00f9 }
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ all -> 0x00f9 }
                kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r6.onUndeliveredElement     // Catch:{ all -> 0x00f9 }
                if (r12 == 0) goto L_0x00c1
                kotlin.coroutines.CoroutineContext r13 = r7.getContext()     // Catch:{ all -> 0x00f9 }
                kotlin.jvm.functions.Function1 r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r12, r0, r13)     // Catch:{ all -> 0x00f9 }
            L_0x00c1:
                r7.resume(r11, r9)     // Catch:{ all -> 0x00f9 }
                goto L_0x00eb
            L_0x00c5:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f9 }
                java.lang.String r12 = "unexpected"
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00f9 }
                r11.<init>(r12)     // Catch:{ all -> 0x00f9 }
                throw r11     // Catch:{ all -> 0x00f9 }
            L_0x00d1:
                r11.cleanPrev()     // Catch:{ all -> 0x00f9 }
                r10.receiveResult = r0     // Catch:{ all -> 0x00f9 }
                r10.continuation = r9     // Catch:{ all -> 0x00f9 }
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ all -> 0x00f9 }
                kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r6.onUndeliveredElement     // Catch:{ all -> 0x00f9 }
                if (r12 == 0) goto L_0x00c1
                kotlin.coroutines.CoroutineContext r13 = r7.getContext()     // Catch:{ all -> 0x00f9 }
                kotlin.jvm.functions.Function1 r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r12, r0, r13)     // Catch:{ all -> 0x00f9 }
                goto L_0x00c1
            L_0x00eb:
                java.lang.Object r11 = r7.getResult()
                java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r11 != r12) goto L_0x00f8
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r15)
            L_0x00f8:
                return r11
            L_0x00f9:
                r11 = move-exception
                r7.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator.hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public void invokeOnCancellation(Segment<?> segment, int i) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i);
            }
        }

        /* access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m7042constructorimpl(false));
                return;
            }
            Continuation continuation2 = cancellableContinuationImpl;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, (CoroutineStackFrame) continuation2);
            }
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m7042constructorimpl(ResultKt.createFailure(closeCause)));
        }

        public E next() {
            E e = this.receiveResult;
            if (e != BufferedChannelKt.NO_RECEIVE_RESULT) {
                this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
                if (e != BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return e;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        public final boolean tryResumeHasNext(E e) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function1<Throwable, Unit> function1 = null;
            this.continuation = null;
            this.receiveResult = e;
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            Function1<E, Unit> function12 = BufferedChannel.this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e, cancellableContinuationImpl.getContext());
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation, true, function1);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m7042constructorimpl(false));
                return;
            }
            Continuation continuation2 = cancellableContinuationImpl;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, (CoroutineStackFrame) continuation2);
            }
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m7042constructorimpl(ResultKt.createFailure(closeCause)));
        }
    }

    /* access modifiers changed from: protected */
    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    /* access modifiers changed from: protected */
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    /* access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    public final boolean cancel(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core((Throwable) null);
    }

    public final void cancel(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th, true);
    }

    /* access modifiers changed from: protected */
    public boolean closeOrCancelImpl(Throwable th, boolean z) {
        if (z) {
            markCancellationStarted();
        }
        boolean m = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closeCause$volatile$FU, this, BufferedChannelKt.NO_CLOSE_CAUSE, th);
        if (z) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (m) {
            invokeCloseHandler();
        }
        return m;
    }

    private final void invokeCloseHandler() {
        Object obj;
        Symbol symbol;
        AtomicReferenceFieldUpdater closeHandler$volatile$FU2 = closeHandler$volatile$FU;
        do {
            obj = closeHandler$volatile$FU2.get(this);
            if (obj == null) {
                symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            } else {
                symbol = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU2, this, obj, symbol));
        if (obj != null) {
            Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
            ((Function1) obj).invoke(getCloseCause());
        }
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, (Object) null, function1)) {
            AtomicReferenceFieldUpdater closeHandler$volatile$FU2 = closeHandler$volatile$FU;
            do {
                Object obj = closeHandler$volatile$FU2.get(this);
                if (obj != BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
                    if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, BufferedChannelKt.CLOSE_HANDLER_CLOSED, BufferedChannelKt.CLOSE_HANDLER_INVOKED));
            function1.invoke(getCloseCause());
        }
    }

    private final void markClosed() {
        long j;
        long j2;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
            int i = (int) (j >> 60);
            if (i == 0) {
                j2 = BufferedChannelKt.constructSendersAndCloseStatus(j & 1152921504606846975L, 2);
            } else if (i == 1) {
                j2 = BufferedChannelKt.constructSendersAndCloseStatus(j & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, j2));
    }

    private final void markCancelled() {
        long j;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3)));
    }

    private final void markCancellationStarted() {
        long j;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j = sendersAndCloseStatus$volatile$FU2.get(this);
            if (((int) (j >> 60)) == 0) {
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU2.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 1)));
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final ChannelSegment<E> completeClose(long j) {
        ChannelSegment<E> closeLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(closeLinkedList);
            if (markAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(closeLinkedList, j);
        return closeLinkedList;
    }

    private final void completeCancel(long j) {
        removeUnprocessedElements(completeClose(j));
    }

    private final ChannelSegment<E> closeLinkedList() {
        ChannelSegment channelSegment = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment2;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (channelSegment3.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment3;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) channelSegment);
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> channelSegment) {
        do {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i--;
                if (-1 < i) {
                    long j = (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        return -1;
                    }
                    while (true) {
                        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                        if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                channelSegment.onSlotCleaned();
                                break;
                            }
                        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                            return j;
                        }
                    }
                } else {
                    channelSegment = (ChannelSegment) channelSegment.getPrev();
                }
            }
        } while (channelSegment != null);
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b3, code lost:
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.getPrev();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> r12) {
        /*
            r11 = this;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r11.onUndeliveredElement
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m8612constructorimpl$default(r1, r2, r1)
        L_0x0008:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b3
            long r6 = r12.id
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0016:
            java.lang.Object r8 = r12.getState$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r8 != r9) goto L_0x0048
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0040
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L_0x0040:
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto L_0x00af
        L_0x0048:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER
            if (r8 == r9) goto L_0x00a2
            if (r8 != 0) goto L_0x0051
            goto L_0x00a2
        L_0x0051:
            boolean r9 = r8 instanceof kotlinx.coroutines.Waiter
            if (r9 != 0) goto L_0x006e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x005a
            goto L_0x006e
        L_0x005a:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV
            if (r8 != r9) goto L_0x0067
            goto L_0x00bb
        L_0x0067:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            if (r8 == r9) goto L_0x0016
            goto L_0x00af
        L_0x006e:
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x0080
            r9 = r8
            kotlinx.coroutines.channels.WaiterEB r9 = (kotlinx.coroutines.channels.WaiterEB) r9
            kotlinx.coroutines.Waiter r9 = r9.waiter
            goto L_0x0083
        L_0x0080:
            r9 = r8
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9
        L_0x0083:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r10)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0097
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L_0x0097:
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m8617plusFjFbRPM(r3, r9)
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto L_0x00af
        L_0x00a2:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            r12.onSlotCleaned()
        L_0x00af:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b3:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r12 = r12.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r12 = (kotlinx.coroutines.channels.ChannelSegment) r12
            if (r12 != 0) goto L_0x0008
        L_0x00bb:
            if (r3 == 0) goto L_0x00e1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto L_0x00c7
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r11.resumeSenderOnCancelledChannel(r3)
            goto L_0x00e1
        L_0x00c7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        L_0x00d3:
            if (r5 >= r12) goto L_0x00e1
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0
            r11.resumeSenderOnCancelledChannel(r0)
            int r12 = r12 + -1
            goto L_0x00d3
        L_0x00e1:
            if (r1 != 0) goto L_0x00e4
            return
        L_0x00e4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> channelSegment, long j) {
        Object r0 = InlineList.m8612constructorimpl$default((Object) null, 1, (DefaultConstructorMarker) null);
        loop0:
        while (channelSegment != null) {
            for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i) < j) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            channelSegment.onSlotCleaned();
                            break;
                        }
                    } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            r0 = InlineList.m8617plusFjFbRPM(r0, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                            channelSegment.onCancelledRequest(i, true);
                            break;
                        }
                    } else if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                        break;
                    } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        r0 = InlineList.m8617plusFjFbRPM(r0, state$kotlinx_coroutines_core);
                        channelSegment.onCancelledRequest(i, true);
                        break;
                    }
                }
            }
            channelSegment = (ChannelSegment) channelSegment.getPrev();
        }
        if (r0 == null) {
            return;
        }
        if (!(r0 instanceof ArrayList)) {
            resumeReceiverOnClosedChannel((Waiter) r0);
            return;
        }
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) r0;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            Result.Companion companion = Result.Companion;
            ((SendBroadcast) waiter).getCont().resumeWith(Result.m7042constructorimpl(false));
        } else if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m7042constructorimpl(ResultKt.createFailure(z ? getReceiveException() : getSendException())));
        } else if (waiter instanceof ReceiveCatching) {
            Result.Companion companion3 = Result.Companion;
            ((ReceiveCatching) waiter).cont.resumeWith(Result.m7042constructorimpl(ChannelResult.m8570boximpl(ChannelResult.Companion.m8583closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    /* access modifiers changed from: private */
    public final boolean isClosedForSend0(long j) {
        return isClosed(j, false);
    }

    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean isClosedForReceive0(long j) {
        return isClosed(j, true);
    }

    private final boolean isClosed(long j, boolean z) {
        int i = (int) (j >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i == 2) {
            completeClose(j & 1152921504606846975L);
            if (z && hasElements$kotlinx_coroutines_core()) {
                return false;
            }
        } else if (i == 3) {
            completeCancel(j & 1152921504606846975L);
        } else {
            throw new IllegalStateException(("unexpected close status: " + i).toString());
        }
        return true;
    }

    public boolean isEmpty() {
        if (!isClosedForReceive() && !hasElements$kotlinx_coroutines_core()) {
            return !isClosedForReceive();
        }
        return false;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            long j = receiversCounter$kotlinx_coroutines_core / ((long) BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id == j || (channelSegment = findSegmentReceive(j, channelSegment)) != null) {
                channelSegment.cleanPrev();
                if (isCellNonEmpty(channelSegment, (int) (receiversCounter$kotlinx_coroutines_core % ((long) BufferedChannelKt.SEGMENT_SIZE)), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$volatile$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
            } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).id < j) {
                return false;
            }
        }
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> channelSegment, int i, long j) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV && j == getReceiversCounter$kotlinx_coroutines_core()) {
                    return true;
                }
                return false;
            }
        } while (!channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED));
        expandBuffer();
        return false;
    }

    /* access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long j, ChannelSegment<E> channelSegment) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater sendSegment$volatile$FU2 = sendSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0:
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
            if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r3 = SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) sendSegment$volatile$FU2.get(this);
                if (segment.id >= r3.id) {
                    break loop0;
                } else if (r3.tryIncPointers$kotlinx_coroutines_core()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(sendSegment$volatile$FU2, this, segment, r3)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r3.decPointers$kotlinx_coroutines_core()) {
                        r3.remove();
                    }
                }
            }
        }
        if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
        if (channelSegment2.id > j) {
            updateSendersCounterIfLower(channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE) >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment2.cleanPrev();
            return null;
        } else if (!DebugKt.getASSERTIONS_ENABLED() || channelSegment2.id == j) {
            return channelSegment2;
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long j, ChannelSegment<E> channelSegment) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater receiveSegment$volatile$FU2 = receiveSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0:
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j, function2);
            if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r3 = SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) receiveSegment$volatile$FU2.get(this);
                if (segment.id >= r3.id) {
                    break loop0;
                } else if (r3.tryIncPointers$kotlinx_coroutines_core()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(receiveSegment$volatile$FU2, this, segment, r3)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r3.decPointers$kotlinx_coroutines_core()) {
                        r3.remove();
                    }
                }
            }
        }
        if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
        if (!isRendezvousOrUnlimited() && j <= getBufferEndCounter() / ((long) BufferedChannelKt.SEGMENT_SIZE)) {
            AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = bufferEndSegment$volatile$FU;
            while (true) {
                Segment segment2 = (Segment) bufferEndSegment$volatile$FU2.get(this);
                Segment segment3 = channelSegment2;
                if (segment2.id >= segment3.id || !segment3.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment2, segment3)) {
                    if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                } else if (segment3.decPointers$kotlinx_coroutines_core()) {
                    segment3.remove();
                }
            }
        }
        if (channelSegment2.id > j) {
            updateReceiversCounterIfLower(channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE) >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment2.cleanPrev();
            return null;
        } else if (!DebugKt.getASSERTIONS_ENABLED() || channelSegment2.id == j) {
            return channelSegment2;
        } else {
            throw new AssertionError();
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long j, ChannelSegment<E> channelSegment, long j2) {
        Object findSegmentInternal;
        long j3 = j;
        AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = bufferEndSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0:
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j3, function2);
            if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r5 = SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) bufferEndSegment$volatile$FU2.get(this);
                if (segment.id >= r5.id) {
                    break loop0;
                } else if (r5.tryIncPointers$kotlinx_coroutines_core()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment, r5)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (r5.decPointers$kotlinx_coroutines_core()) {
                        r5.remove();
                    }
                }
            }
        }
        if (SegmentOrClosed.m8626isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
            incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m8624getSegmentimpl(findSegmentInternal);
        if (channelSegment2.id > j3) {
            if (bufferEnd$volatile$FU.compareAndSet(this, j2 + 1, channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE))) {
                incCompletedExpandBufferAttempts((channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) - j2);
                return null;
            }
            incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            return null;
        } else if (!DebugKt.getASSERTIONS_ENABLED() || channelSegment2.id == j3) {
            return channelSegment2;
        } else {
            throw new AssertionError();
        }
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long j, ChannelSegment<E> channelSegment) {
        ChannelSegment<E> channelSegment2;
        ChannelSegment<E> channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.isRemoved() || (channelSegment2 = (ChannelSegment) channelSegment.getNext()) == null) {
                AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU2 = bufferEndSegment$volatile$FU;
                while (true) {
                    Segment segment = (Segment) bufferEndSegment$volatile$FU2.get(this);
                    Segment segment2 = channelSegment;
                    if (segment.id < segment2.id) {
                        if (!segment2.tryIncPointers$kotlinx_coroutines_core()) {
                            continue;
                            break;
                        } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$volatile$FU2, this, segment, segment2)) {
                            if (segment.decPointers$kotlinx_coroutines_core()) {
                                segment.remove();
                                return;
                            }
                            return;
                        } else if (segment2.decPointers$kotlinx_coroutines_core()) {
                            segment2.remove();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
        }
    }

    private final void updateSendersCounterIfLower(long j) {
        long j2;
        long j3;
        AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU2 = sendersAndCloseStatus$volatile$FU;
        do {
            j2 = sendersAndCloseStatus$volatile$FU2.get(this);
            j3 = 1152921504606846975L & j2;
            if (j3 < j) {
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU.compareAndSet(this, j2, BufferedChannelKt.constructSendersAndCloseStatus(j3, (int) (j2 >> 60))));
    }

    private final void updateReceiversCounterIfLower(long j) {
        long j2;
        AtomicLongFieldUpdater receivers$volatile$FU2 = receivers$volatile$FU;
        do {
            j2 = receivers$volatile$FU2.get(this);
            if (j2 >= j || receivers$volatile$FU.compareAndSet(this, j2, j)) {
            }
            j2 = receivers$volatile$FU2.get(this);
            return;
        } while (receivers$volatile$FU.compareAndSet(this, j2, j));
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01e1, code lost:
        r3 = r3.getNext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e8, code lost:
        if (r3 != null) goto L_0x020c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$volatile$FU
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x0020
            if (r2 == r3) goto L_0x001a
            goto L_0x0025
        L_0x001a:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0025
        L_0x0020:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "capacity="
            r2.<init>(r5)
            int r5 = r0.capacity
            r2.append(r5)
            r5 = 44
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            kotlinx.coroutines.channels.ChannelSegment[] r2 = new kotlinx.coroutines.channels.ChannelSegment[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = receiveSegment$volatile$FU
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = sendSegment$volatile$FU
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = bufferEndSegment$volatile$FU
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0075:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r2.next()
            r8 = r4
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            kotlinx.coroutines.channels.ChannelSegment r9 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r8 == r9) goto L_0x0075
            r3.add(r4)
            goto L_0x0075
        L_0x008c:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0210
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00a5
            goto L_0x00bf
        L_0x00a5:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r8 = r4.id
        L_0x00aa:
            java.lang.Object r4 = r2.next()
            r10 = r4
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10
            long r10 = r10.id
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b9
            r3 = r4
            r8 = r10
        L_0x00b9:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00aa
        L_0x00bf:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            long r10 = r16.getReceiversCounter$kotlinx_coroutines_core()
            long r12 = r16.getSendersCounter$kotlinx_coroutines_core()
        L_0x00c9:
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r6
        L_0x00cc:
            if (r4 >= r2) goto L_0x01e1
            long r8 = r3.id
            int r14 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00de
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x01ea
        L_0x00de:
            java.lang.Object r15 = r3.getState$kotlinx_coroutines_core(r4)
            java.lang.Object r6 = r3.getElement$kotlinx_coroutines_core(r4)
            boolean r7 = r15 instanceof kotlinx.coroutines.CancellableContinuation
            if (r7 == 0) goto L_0x0100
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f4
            if (r14 < 0) goto L_0x00f4
            java.lang.String r7 = "receive"
            goto L_0x01aa
        L_0x00f4:
            if (r14 >= 0) goto L_0x00fc
            if (r7 < 0) goto L_0x00fc
            java.lang.String r7 = "send"
            goto L_0x01aa
        L_0x00fc:
            java.lang.String r7 = "cont"
            goto L_0x01aa
        L_0x0100:
            boolean r7 = r15 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r7 == 0) goto L_0x011a
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x010e
            if (r14 < 0) goto L_0x010e
            java.lang.String r7 = "onReceive"
            goto L_0x01aa
        L_0x010e:
            if (r14 >= 0) goto L_0x0116
            if (r7 < 0) goto L_0x0116
            java.lang.String r7 = "onSend"
            goto L_0x01aa
        L_0x0116:
            java.lang.String r7 = "select"
            goto L_0x01aa
        L_0x011a:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r7 == 0) goto L_0x0122
            java.lang.String r7 = "receiveCatching"
            goto L_0x01aa
        L_0x0122:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r7 == 0) goto L_0x012a
            java.lang.String r7 = "sendBroadcast"
            goto L_0x01aa
        L_0x012a:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r7 == 0) goto L_0x0143
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "EB("
            r7.<init>(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x01aa
        L_0x0143:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x014f
            r7 = 1
            goto L_0x0157
        L_0x014f:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0157:
            if (r7 == 0) goto L_0x015c
            java.lang.String r7 = "resuming_sender"
            goto L_0x01aa
        L_0x015c:
            if (r15 != 0) goto L_0x0160
            r7 = 1
            goto L_0x0168
        L_0x0160:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0168:
            if (r7 == 0) goto L_0x016c
            r7 = 1
            goto L_0x0174
        L_0x016c:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0174:
            if (r7 == 0) goto L_0x0178
            r7 = 1
            goto L_0x0180
        L_0x0178:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.POISONED
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0180:
            if (r7 == 0) goto L_0x0184
            r7 = 1
            goto L_0x018c
        L_0x0184:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x018c:
            if (r7 == 0) goto L_0x0190
            r7 = 1
            goto L_0x0198
        L_0x0190:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0198:
            if (r7 == 0) goto L_0x019c
            r7 = 1
            goto L_0x01a4
        L_0x019c:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x01a4:
            if (r7 != 0) goto L_0x01db
            java.lang.String r7 = r15.toString()
        L_0x01aa:
            if (r6 == 0) goto L_0x01c9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "("
            r8.<init>(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r1.append(r6)
            goto L_0x01db
        L_0x01c9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01db:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00cc
        L_0x01e1:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r2 = r3.getNext()
            r3 = r2
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            if (r3 != 0) goto L_0x020c
        L_0x01ea:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            char r2 = kotlin.text.StringsKt.last(r2)
            if (r2 != r5) goto L_0x0202
            int r2 = r1.length()
            r4 = 1
            int r2 = r2 - r4
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "deleteCharAt(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0202:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x020c:
            r6 = 0
            r7 = 1
            goto L_0x00c9
        L_0x0210:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r1v18, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toStringDebug$kotlinx_coroutines_core() {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "S="
            r1.<init>(r2)
            long r2 = r11.getSendersCounter$kotlinx_coroutines_core()
            r1.append(r2)
            java.lang.String r2 = ",R="
            r1.append(r2)
            long r2 = r11.getReceiversCounter$kotlinx_coroutines_core()
            r1.append(r2)
            java.lang.String r2 = ",B="
            r1.append(r2)
            long r2 = r11.getBufferEndCounter()
            r1.append(r2)
            java.lang.String r2 = ",B'="
            r1.append(r2)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = completedExpandBuffersAndPauseFlag$volatile$FU
            long r2 = r2.get(r11)
            r1.append(r2)
            java.lang.String r2 = ",C="
            r1.append(r2)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$volatile$FU
            long r2 = r2.get(r11)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r1.append(r2)
            r2 = 44
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$volatile$FU
            long r5 = r1.get(r11)
            long r3 = r5 >> r4
            int r1 = (int) r3
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x007c
            if (r1 == r4) goto L_0x0076
            if (r1 == r3) goto L_0x0070
            goto L_0x0081
        L_0x0070:
            java.lang.String r1 = "CANCELLED,"
            r0.append(r1)
            goto L_0x0081
        L_0x0076:
            java.lang.String r1 = "CLOSED,"
            r0.append(r1)
            goto L_0x0081
        L_0x007c:
            java.lang.String r1 = "CANCELLATION_STARTED,"
            r0.append(r1)
        L_0x0081:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "SEND_SEGM="
            r1.<init>(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = sendSegment$volatile$FU
            java.lang.Object r6 = r6.get(r11)
            java.lang.String r6 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r6)
            r1.append(r6)
            java.lang.String r6 = ",RCV_SEGM="
            r1.append(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = receiveSegment$volatile$FU
            java.lang.Object r6 = r6.get(r11)
            java.lang.String r6 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r6)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            boolean r1 = r11.isRendezvousOrUnlimited()
            if (r1 != 0) goto L_0x00d5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = ",EB_SEGM="
            r1.<init>(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = bufferEndSegment$volatile$FU
            java.lang.Object r6 = r6.get(r11)
            java.lang.String r6 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r6)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x00d5:
            java.lang.String r1 = "  "
            r0.append(r1)
            kotlinx.coroutines.channels.ChannelSegment[] r1 = new kotlinx.coroutines.channels.ChannelSegment[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = receiveSegment$volatile$FU
            java.lang.Object r3 = r3.get(r11)
            r6 = 0
            r1[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = sendSegment$volatile$FU
            java.lang.Object r3 = r3.get(r11)
            r1[r5] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = bufferEndSegment$volatile$FU
            java.lang.Object r3 = r3.get(r11)
            r1[r4] = r3
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L_0x010c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0123
            java.lang.Object r4 = r1.next()
            r5 = r4
            kotlinx.coroutines.channels.ChannelSegment r5 = (kotlinx.coroutines.channels.ChannelSegment) r5
            kotlinx.coroutines.channels.ChannelSegment r7 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r5 == r7) goto L_0x010c
            r3.add(r4)
            goto L_0x010c
        L_0x0123:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r1 = r3.iterator()
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0239
            java.lang.Object r3 = r1.next()
            boolean r4 = r1.hasNext()
            if (r4 != 0) goto L_0x013c
            goto L_0x0156
        L_0x013c:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r4 = r4.id
        L_0x0141:
            java.lang.Object r7 = r1.next()
            r8 = r7
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            long r8 = r8.id
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0150
            r3 = r7
            r4 = r8
        L_0x0150:
            boolean r7 = r1.hasNext()
            if (r7 != 0) goto L_0x0141
        L_0x0156:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
        L_0x0158:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r3)
            r1.append(r4)
            java.lang.String r4 = "=["
            r1.append(r4)
            boolean r4 = r3.isRemoved()
            if (r4 == 0) goto L_0x0172
            java.lang.String r4 = "*"
            goto L_0x0174
        L_0x0172:
            java.lang.String r4 = ""
        L_0x0174:
            r1.append(r4)
            long r4 = r3.id
            r1.append(r4)
            java.lang.String r4 = ",prev="
            r1.append(r4)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r4 = r3.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            r5 = 0
            if (r4 == 0) goto L_0x018f
            java.lang.String r4 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r4)
            goto L_0x0190
        L_0x018f:
            r4 = r5
        L_0x0190:
            r1.append(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r6
        L_0x01a0:
            if (r4 >= r1) goto L_0x0209
            java.lang.Object r7 = r3.getState$kotlinx_coroutines_core(r4)
            java.lang.Object r8 = r3.getElement$kotlinx_coroutines_core(r4)
            boolean r9 = r7 instanceof kotlinx.coroutines.CancellableContinuation
            if (r9 == 0) goto L_0x01b1
            java.lang.String r7 = "cont"
            goto L_0x01e2
        L_0x01b1:
            boolean r9 = r7 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r9 == 0) goto L_0x01b8
            java.lang.String r7 = "select"
            goto L_0x01e2
        L_0x01b8:
            boolean r9 = r7 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r9 == 0) goto L_0x01bf
            java.lang.String r7 = "receiveCatching"
            goto L_0x01e2
        L_0x01bf:
            boolean r9 = r7 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r9 == 0) goto L_0x01c6
            java.lang.String r7 = "send(broadcast)"
            goto L_0x01e2
        L_0x01c6:
            boolean r9 = r7 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x01de
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "EB("
            r9.<init>(r10)
            r9.append(r7)
            r7 = 41
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            goto L_0x01e2
        L_0x01de:
            java.lang.String r7 = java.lang.String.valueOf(r7)
        L_0x01e2:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "["
            r9.<init>(r10)
            r9.append(r4)
            java.lang.String r10 = "]=("
            r9.append(r10)
            r9.append(r7)
            r9.append(r2)
            r9.append(r8)
            java.lang.String r7 = "),"
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r0.append(r7)
            int r4 = r4 + 1
            goto L_0x01a0
        L_0x0209:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "next="
            r1.<init>(r4)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r4 = r3.getNext()
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            if (r4 == 0) goto L_0x021c
            java.lang.String r5 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r4)
        L_0x021c:
            r1.append(r5)
            java.lang.String r4 = "]  "
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = r3.getNext()
            r3 = r1
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            if (r3 != 0) goto L_0x0158
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0239:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toStringDebug$kotlinx_coroutines_core():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r0v18, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkSegmentStructureInvariants() {
        /*
            r10 = this;
            boolean r0 = r10.isRendezvousOrUnlimited()
            if (r0 == 0) goto L_0x002d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$volatile$FU
            java.lang.Object r0 = r0.get(r10)
            kotlinx.coroutines.channels.ChannelSegment r1 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r0 != r1) goto L_0x0015
            goto L_0x0049
        L_0x0015:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: "
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x002d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$volatile$FU
            java.lang.Object r0 = r0.get(r10)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            long r0 = r0.id
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = bufferEndSegment$volatile$FU
            java.lang.Object r2 = r2.get(r10)
            kotlinx.coroutines.channels.ChannelSegment r2 = (kotlinx.coroutines.channels.ChannelSegment) r2
            long r2 = r2.id
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0215
        L_0x0049:
            r0 = 3
            kotlinx.coroutines.channels.ChannelSegment[] r0 = new kotlinx.coroutines.channels.ChannelSegment[r0]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = receiveSegment$volatile$FU
            java.lang.Object r1 = r1.get(r10)
            r2 = 0
            r0[r2] = r1
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = sendSegment$volatile$FU
            java.lang.Object r1 = r1.get(r10)
            r3 = 1
            r0[r3] = r1
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = bufferEndSegment$volatile$FU
            java.lang.Object r1 = r1.get(r10)
            r4 = 2
            r0[r4] = r1
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x007e:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0095
            java.lang.Object r4 = r0.next()
            r5 = r4
            kotlinx.coroutines.channels.ChannelSegment r5 = (kotlinx.coroutines.channels.ChannelSegment) r5
            kotlinx.coroutines.channels.ChannelSegment r6 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r5 == r6) goto L_0x007e
            r1.add(r4)
            goto L_0x007e
        L_0x0095:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x020f
            java.lang.Object r1 = r0.next()
            boolean r4 = r0.hasNext()
            if (r4 != 0) goto L_0x00ae
            goto L_0x00c8
        L_0x00ae:
            r4 = r1
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r4 = r4.id
        L_0x00b3:
            java.lang.Object r6 = r0.next()
            r7 = r6
            kotlinx.coroutines.channels.ChannelSegment r7 = (kotlinx.coroutines.channels.ChannelSegment) r7
            long r7 = r7.id
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c2
            r1 = r6
            r4 = r7
        L_0x00c2:
            boolean r6 = r0.hasNext()
            if (r6 != 0) goto L_0x00b3
        L_0x00c8:
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getPrev()
            if (r0 != 0) goto L_0x01f7
        L_0x00d0:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            if (r0 == 0) goto L_0x01f6
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r0.getPrev()
            if (r0 == 0) goto L_0x010d
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r0.getPrev()
            if (r0 != r1) goto L_0x00f5
            goto L_0x010d
        L_0x00f5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The `segment.next.prev === segment` invariant is violated.\nChannel state: "
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x010d:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r2
            r5 = r4
        L_0x0111:
            if (r4 >= r0) goto L_0x01af
            java.lang.Object r6 = r1.getState$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01ab
            boolean r7 = r6 instanceof kotlinx.coroutines.Waiter
            if (r7 != 0) goto L_0x01ab
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x012f
            r7 = r3
            goto L_0x0137
        L_0x012f:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
        L_0x0137:
            if (r7 == 0) goto L_0x013b
            r7 = r3
            goto L_0x0143
        L_0x013b:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
        L_0x0143:
            java.lang.String r8 = "Check failed."
            if (r7 == 0) goto L_0x015f
            java.lang.Object r6 = r1.getElement$kotlinx_coroutines_core(r4)
            if (r6 != 0) goto L_0x014f
            r6 = r3
            goto L_0x0150
        L_0x014f:
            r6 = r2
        L_0x0150:
            if (r6 == 0) goto L_0x0155
            int r5 = r5 + 1
            goto L_0x01ab
        L_0x0155:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r8.toString()
            r0.<init>(r1)
            throw r0
        L_0x015f:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.POISONED
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x016b
            r7 = r3
            goto L_0x0173
        L_0x016b:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
        L_0x0173:
            if (r7 == 0) goto L_0x018b
            java.lang.Object r6 = r1.getElement$kotlinx_coroutines_core(r4)
            if (r6 != 0) goto L_0x017d
            r6 = r3
            goto L_0x017e
        L_0x017d:
            r6 = r2
        L_0x017e:
            if (r6 == 0) goto L_0x0181
            goto L_0x01ab
        L_0x0181:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r8.toString()
            r0.<init>(r1)
            throw r0
        L_0x018b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected segment cell state: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r2 = ".\nChannel state: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01ab:
            int r4 = r4 + 1
            goto L_0x0111
        L_0x01af:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            if (r5 != r0) goto L_0x01ea
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$volatile$FU
            java.lang.Object r0 = r0.get(r10)
            if (r1 == r0) goto L_0x01ea
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$volatile$FU
            java.lang.Object r0 = r0.get(r10)
            if (r1 == r0) goto L_0x01ea
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$volatile$FU
            java.lang.Object r0 = r0.get(r10)
            if (r1 != r0) goto L_0x01d2
            goto L_0x01ea
        L_0x01d2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Logically removed segment is reachable.\nChannel state: "
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x01ea:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r1.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1 = r0
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            goto L_0x00d0
        L_0x01f6:
            return
        L_0x01f7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: "
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x020f:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        L_0x0215:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "bufferEndSegment should not have lower id than receiveSegment.\nChannel state: "
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.checkSegmentStructureInvariants():void");
    }

    /* access modifiers changed from: private */
    public final Object onClosedSend(E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Continuation continuation2 = cancellableContinuation;
            Throwable sendException = getSendException();
            Result.Companion companion = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, (CoroutineStackFrame) continuation2);
            }
            continuation2.resumeWith(Result.m7042constructorimpl(ResultKt.createFailure(sendException)));
        } else {
            Throwable th = callUndeliveredElementCatchingException$default;
            ExceptionsKt.addSuppressed(th, getSendException());
            Continuation continuation3 = cancellableContinuation;
            Result.Companion companion2 = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation3 instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(th, (CoroutineStackFrame) continuation3);
            }
            continuation3.resumeWith(Result.m7042constructorimpl(ResultKt.createFailure(th)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r22, int r23, E r24, long r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            r21 = this;
            r9 = r21
            r0 = r24
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r27)
            kotlinx.coroutines.CancellableContinuationImpl r10 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r1)
            r7 = r10
            kotlinx.coroutines.Waiter r7 = (kotlinx.coroutines.Waiter) r7     // Catch:{ all -> 0x014f }
            r8 = 0
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            int r1 = r1.updateCellSend(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x014f }
            if (r1 == 0) goto L_0x0127
            r11 = 1
            if (r1 == r11) goto L_0x011b
            r12 = 2
            if (r1 == r12) goto L_0x0110
            r13 = 4
            if (r1 == r13) goto L_0x0100
            java.lang.String r14 = "unexpected"
            r15 = 5
            if (r1 != r15) goto L_0x00f6
            r22.cleanPrev()     // Catch:{ all -> 0x014f }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = sendSegment$volatile$FU     // Catch:{ all -> 0x014f }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x014f }
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1     // Catch:{ all -> 0x014f }
        L_0x003b:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$volatile$FU     // Catch:{ all -> 0x014f }
            long r2 = r2.getAndIncrement(r9)     // Catch:{ all -> 0x014f }
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r16 = r2 & r4
            boolean r18 = r9.isClosedForSend0(r2)     // Catch:{ all -> 0x014f }
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x014f }
            long r2 = (long) r2     // Catch:{ all -> 0x014f }
            long r2 = r16 / r2
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x014f }
            long r4 = (long) r4     // Catch:{ all -> 0x014f }
            long r4 = r16 % r4
            int r8 = (int) r4     // Catch:{ all -> 0x014f }
            long r4 = r1.id     // Catch:{ all -> 0x014f }
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0071
            kotlinx.coroutines.channels.ChannelSegment r2 = r9.findSegmentSend(r2, r1)     // Catch:{ all -> 0x014f }
            if (r2 != 0) goto L_0x006f
            if (r18 == 0) goto L_0x003b
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x014f }
        L_0x006a:
            r9.onClosedSendOnNoWaiterSuspend(r0, r1)     // Catch:{ all -> 0x014f }
            goto L_0x0138
        L_0x006f:
            r7 = r2
            goto L_0x0072
        L_0x0071:
            r7 = r1
        L_0x0072:
            r19 = r10
            kotlinx.coroutines.Waiter r19 = (kotlinx.coroutines.Waiter) r19     // Catch:{ all -> 0x014f }
            r1 = r21
            r2 = r7
            r3 = r8
            r4 = r24
            r5 = r16
            r22 = r7
            r7 = r19
            r20 = r8
            r8 = r18
            int r1 = r1.updateCellSend(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x014f }
            if (r1 == 0) goto L_0x00e5
            if (r1 == r11) goto L_0x00d6
            if (r1 == r12) goto L_0x00b7
            r2 = 3
            if (r1 == r2) goto L_0x00ad
            if (r1 == r13) goto L_0x009e
            if (r1 == r15) goto L_0x0098
            goto L_0x009b
        L_0x0098:
            r22.cleanPrev()     // Catch:{ all -> 0x014f }
        L_0x009b:
            r1 = r22
            goto L_0x003b
        L_0x009e:
            long r1 = r21.getReceiversCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x014f }
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a9
            r22.cleanPrev()     // Catch:{ all -> 0x014f }
        L_0x00a9:
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x014f }
            goto L_0x006a
        L_0x00ad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x014f }
            r0.<init>(r1)     // Catch:{ all -> 0x014f }
            throw r0     // Catch:{ all -> 0x014f }
        L_0x00b7:
            if (r18 == 0) goto L_0x00c0
            r22.onSlotCleaned()     // Catch:{ all -> 0x014f }
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x014f }
            goto L_0x006a
        L_0x00c0:
            r0 = r10
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x014f }
            boolean r0 = r0 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x014f }
            if (r0 == 0) goto L_0x00cb
            r0 = r10
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x014f }
            goto L_0x00cc
        L_0x00cb:
            r0 = 0
        L_0x00cc:
            if (r0 == 0) goto L_0x0138
            r2 = r22
            r1 = r20
            r9.prepareSenderForSuspension(r0, r2, r1)     // Catch:{ all -> 0x014f }
            goto L_0x0138
        L_0x00d6:
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x014f }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x014f }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014f }
            java.lang.Object r1 = kotlin.Result.m7042constructorimpl(r1)     // Catch:{ all -> 0x014f }
        L_0x00e1:
            r0.resumeWith(r1)     // Catch:{ all -> 0x014f }
            goto L_0x0138
        L_0x00e5:
            r2 = r22
            r2.cleanPrev()     // Catch:{ all -> 0x014f }
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x014f }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x014f }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014f }
            java.lang.Object r1 = kotlin.Result.m7042constructorimpl(r1)     // Catch:{ all -> 0x014f }
            goto L_0x00e1
        L_0x00f6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x014f }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x014f }
            r0.<init>(r1)     // Catch:{ all -> 0x014f }
            throw r0     // Catch:{ all -> 0x014f }
        L_0x0100:
            long r1 = r21.getReceiversCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x014f }
            int r1 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x010b
            r22.cleanPrev()     // Catch:{ all -> 0x014f }
        L_0x010b:
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x014f }
            goto L_0x006a
        L_0x0110:
            r0 = r10
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x014f }
            r1 = r22
            r2 = r23
            r9.prepareSenderForSuspension(r0, r1, r2)     // Catch:{ all -> 0x014f }
            goto L_0x0138
        L_0x011b:
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x014f }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x014f }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014f }
            java.lang.Object r1 = kotlin.Result.m7042constructorimpl(r1)     // Catch:{ all -> 0x014f }
            goto L_0x00e1
        L_0x0127:
            r1 = r22
            r22.cleanPrev()     // Catch:{ all -> 0x014f }
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x014f }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x014f }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014f }
            java.lang.Object r1 = kotlin.Result.m7042constructorimpl(r1)     // Catch:{ all -> 0x014f }
            goto L_0x00e1
        L_0x0138:
            java.lang.Object r0 = r10.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x0145
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r27)
        L_0x0145:
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x014c
            return r0
        L_0x014c:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x014f:
            r0 = move-exception
            r10.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
        r0 = kotlin.Result.Companion;
        r11.resumeWith(kotlin.Result.m7042constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <E> java.lang.Object sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r19, E r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r8 = r19
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r21)
            r10 = 1
            r9.<init>(r0, r10)
            r9.initCancellability()
            r11 = r9
            kotlinx.coroutines.CancellableContinuation r11 = (kotlinx.coroutines.CancellableContinuation) r11
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r8.onUndeliveredElement
            if (r0 != 0) goto L_0x00e0
            kotlinx.coroutines.channels.BufferedChannel$SendBroadcast r12 = new kotlinx.coroutines.channels.BufferedChannel$SendBroadcast
            r12.<init>(r11)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$volatile$FU
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0025:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$volatile$FU
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r13 = r1 & r3
            boolean r15 = r8.isClosedForSend0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r1 = (long) r1
            long r1 = r13 / r1
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r3 = (long) r3
            long r3 = r13 % r3
            int r7 = (int) r3
            long r3 = r0.id
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r16 = 0
            if (r3 == 0) goto L_0x0056
            kotlinx.coroutines.channels.ChannelSegment r1 = r8.findSegmentSend(r1, r0)
            if (r1 != 0) goto L_0x0054
            if (r15 == 0) goto L_0x0025
            goto L_0x009c
        L_0x0054:
            r6 = r1
            goto L_0x0057
        L_0x0056:
            r6 = r0
        L_0x0057:
            r0 = r19
            r1 = r6
            r2 = r7
            r3 = r20
            r4 = r13
            r17 = r6
            r6 = r12
            r18 = r7
            r7 = r15
            int r0 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00be
            if (r0 == r10) goto L_0x00c3
            r1 = 2
            if (r0 == r1) goto L_0x0097
            r1 = 3
            if (r0 == r1) goto L_0x008b
            r1 = 4
            if (r0 == r1) goto L_0x007f
            r1 = 5
            if (r0 == r1) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            r17.cleanPrev()
        L_0x007c:
            r0 = r17
            goto L_0x0025
        L_0x007f:
            long r0 = r19.getReceiversCounter$kotlinx_coroutines_core()
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x009c
            r17.cleanPrev()
            goto L_0x009c
        L_0x008b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0097:
            if (r15 == 0) goto L_0x00ac
            r17.onSlotCleaned()
        L_0x009c:
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r16)
            java.lang.Object r0 = kotlin.Result.m7042constructorimpl(r0)
            r11.resumeWith(r0)
            goto L_0x00d2
        L_0x00ac:
            boolean r0 = r12 instanceof kotlinx.coroutines.Waiter
            if (r0 == 0) goto L_0x00b3
            kotlinx.coroutines.Waiter r12 = (kotlinx.coroutines.Waiter) r12
            goto L_0x00b4
        L_0x00b3:
            r12 = 0
        L_0x00b4:
            if (r12 == 0) goto L_0x00d2
            r1 = r17
            r0 = r18
            r8.prepareSenderForSuspension(r12, r1, r0)
            goto L_0x00d2
        L_0x00be:
            r1 = r17
            r1.cleanPrev()
        L_0x00c3:
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            java.lang.Object r0 = kotlin.Result.m7042constructorimpl(r0)
            r11.resumeWith(r0)
        L_0x00d2:
            java.lang.Object r0 = r9.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x00df
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r21)
        L_0x00df:
            return r0
        L_0x00e0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: type inference failed for: r2v5, types: [kotlinx.coroutines.Waiter] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r10, int r11, long r12, kotlin.coroutines.Continuation<? super E> r14) {
        /*
            r9 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r14)
            kotlinx.coroutines.CancellableContinuationImpl r0 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
            r6 = r0
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6     // Catch:{ all -> 0x00e2 }
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            java.lang.Object r1 = r1.updateCellReceive(r2, r3, r4, r6)     // Catch:{ all -> 0x00e2 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00e2 }
            if (r1 != r2) goto L_0x0021
            r12 = r0
            kotlinx.coroutines.Waiter r12 = (kotlinx.coroutines.Waiter) r12     // Catch:{ all -> 0x00e2 }
            r9.prepareReceiverForSuspension(r12, r10, r11)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d4
        L_0x0021:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00e2 }
            r2 = 0
            if (r1 != r11) goto L_0x00c4
            long r3 = r9.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00e2 }
            int r11 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0033
            r10.cleanPrev()     // Catch:{ all -> 0x00e2 }
        L_0x0033:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = receiveSegment$volatile$FU     // Catch:{ all -> 0x00e2 }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ all -> 0x00e2 }
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10     // Catch:{ all -> 0x00e2 }
        L_0x003d:
            boolean r11 = r9.isClosedForReceive()     // Catch:{ all -> 0x00e2 }
            if (r11 == 0) goto L_0x004b
            r10 = r0
            kotlinx.coroutines.CancellableContinuation r10 = (kotlinx.coroutines.CancellableContinuation) r10     // Catch:{ all -> 0x00e2 }
            r9.onClosedReceiveOnNoWaiterSuspend(r10)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d4
        L_0x004b:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r11 = receivers$volatile$FU     // Catch:{ all -> 0x00e2 }
            long r11 = r11.getAndIncrement(r9)     // Catch:{ all -> 0x00e2 }
            int r13 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00e2 }
            long r3 = (long) r13     // Catch:{ all -> 0x00e2 }
            long r3 = r11 / r3
            int r13 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00e2 }
            long r5 = (long) r13     // Catch:{ all -> 0x00e2 }
            long r5 = r11 % r5
            int r13 = (int) r5     // Catch:{ all -> 0x00e2 }
            long r5 = r10.id     // Catch:{ all -> 0x00e2 }
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x006c
            kotlinx.coroutines.channels.ChannelSegment r1 = r9.findSegmentReceive(r3, r10)     // Catch:{ all -> 0x00e2 }
            if (r1 != 0) goto L_0x006b
            goto L_0x003d
        L_0x006b:
            r10 = r1
        L_0x006c:
            r8 = r0
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8     // Catch:{ all -> 0x00e2 }
            r3 = r9
            r4 = r10
            r5 = r13
            r6 = r11
            java.lang.Object r1 = r3.updateCellReceive(r4, r5, r6, r8)     // Catch:{ all -> 0x00e2 }
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00e2 }
            if (r1 != r3) goto L_0x008d
            r11 = r0
            kotlinx.coroutines.Waiter r11 = (kotlinx.coroutines.Waiter) r11     // Catch:{ all -> 0x00e2 }
            boolean r11 = r11 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x00e2 }
            if (r11 == 0) goto L_0x0087
            r2 = r0
            kotlinx.coroutines.Waiter r2 = (kotlinx.coroutines.Waiter) r2     // Catch:{ all -> 0x00e2 }
        L_0x0087:
            if (r2 == 0) goto L_0x00d4
            r9.prepareReceiverForSuspension(r2, r10, r13)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d4
        L_0x008d:
            kotlinx.coroutines.internal.Symbol r13 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00e2 }
            if (r1 != r13) goto L_0x009f
            long r3 = r9.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00e2 }
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x003d
            r10.cleanPrev()     // Catch:{ all -> 0x00e2 }
            goto L_0x003d
        L_0x009f:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x00e2 }
            if (r1 == r11) goto L_0x00b8
            r10.cleanPrev()     // Catch:{ all -> 0x00e2 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r10 = r9.onUndeliveredElement     // Catch:{ all -> 0x00e2 }
            if (r10 == 0) goto L_0x00b4
            kotlin.coroutines.CoroutineContext r11 = r0.getContext()     // Catch:{ all -> 0x00e2 }
            kotlin.jvm.functions.Function1 r2 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r10, r1, r11)     // Catch:{ all -> 0x00e2 }
        L_0x00b4:
            r0.resume(r1, r2)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d4
        L_0x00b8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e2 }
            java.lang.String r11 = "unexpected"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00e2 }
            r10.<init>(r11)     // Catch:{ all -> 0x00e2 }
            throw r10     // Catch:{ all -> 0x00e2 }
        L_0x00c4:
            r10.cleanPrev()     // Catch:{ all -> 0x00e2 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r10 = r9.onUndeliveredElement     // Catch:{ all -> 0x00e2 }
            if (r10 == 0) goto L_0x00b4
            kotlin.coroutines.CoroutineContext r11 = r0.getContext()     // Catch:{ all -> 0x00e2 }
            kotlin.jvm.functions.Function1 r2 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r10, r1, r11)     // Catch:{ all -> 0x00e2 }
            goto L_0x00b4
        L_0x00d4:
            java.lang.Object r10 = r0.getResult()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r10 != r11) goto L_0x00e1
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r14)
        L_0x00e1:
            return r10
        L_0x00e2:
            r10 = move-exception
            r0.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        r14.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void registerSelectForSend(kotlinx.coroutines.selects.SelectInstance<?> r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$volatile$FU
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x000a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$volatile$FU
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r1
            boolean r1 = r13.isClosedForSend0(r1)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r5 = (long) r2
            long r5 = r3 / r5
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r2
            long r7 = r3 % r7
            int r2 = (int) r7
            long r7 = r0.id
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0037
            kotlinx.coroutines.channels.ChannelSegment r5 = r13.findSegmentSend(r5, r0)
            if (r5 != 0) goto L_0x0036
            if (r1 == 0) goto L_0x000a
            goto L_0x0075
        L_0x0036:
            r0 = r5
        L_0x0037:
            r5 = r13
            r6 = r0
            r7 = r2
            r8 = r15
            r9 = r3
            r11 = r14
            r12 = r1
            int r5 = r5.updateCellSend(r6, r7, r8, r9, r11, r12)
            if (r5 == 0) goto L_0x0087
            r6 = 1
            if (r5 == r6) goto L_0x008a
            r6 = 2
            if (r5 == r6) goto L_0x0070
            r1 = 3
            if (r5 == r1) goto L_0x0064
            r1 = 4
            if (r5 == r1) goto L_0x0058
            r1 = 5
            if (r5 == r1) goto L_0x0054
            goto L_0x000a
        L_0x0054:
            r0.cleanPrev()
            goto L_0x000a
        L_0x0058:
            long r1 = r13.getReceiversCounter$kotlinx_coroutines_core()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0075
            r0.cleanPrev()
            goto L_0x0075
        L_0x0064:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x0070:
            if (r1 == 0) goto L_0x0079
            r0.onSlotCleaned()
        L_0x0075:
            r13.onClosedSelectOnSend(r15, r14)
            goto L_0x008f
        L_0x0079:
            boolean r15 = r14 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L_0x0080
            kotlinx.coroutines.Waiter r14 = (kotlinx.coroutines.Waiter) r14
            goto L_0x0081
        L_0x0080:
            r14 = 0
        L_0x0081:
            if (r14 == 0) goto L_0x008f
            r13.prepareSenderForSuspension(r14, r0, r2)
            goto L_0x008f
        L_0x0087:
            r0.cleanPrev()
        L_0x008a:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            r14.selectInRegistrationPhase(r15)
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.registerSelectForSend(kotlinx.coroutines.selects.SelectInstance, java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> selectInstance, Object obj) {
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, selectInstance);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i);
                    return;
                }
                return;
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else if (access$updateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                channelSegment.cleanPrev();
                selectInstance.selectInRegistrationPhase(access$updateCellReceive);
                return;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        onClosedSelectOnReceive(selectInstance);
    }
}
