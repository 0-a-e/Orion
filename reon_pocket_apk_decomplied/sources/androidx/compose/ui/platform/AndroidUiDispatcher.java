package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b*\u0001\n\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\u0015\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0017H\u0000¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0017H\u0000¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/compose/ui/platform/AndroidUiDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "choreographer", "Landroid/view/Choreographer;", "handler", "Landroid/os/Handler;", "(Landroid/view/Choreographer;Landroid/os/Handler;)V", "getChoreographer", "()Landroid/view/Choreographer;", "dispatchCallback", "androidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1", "Landroidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1;", "frameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "lock", "", "scheduledFrameDispatch", "", "scheduledTrampolineDispatch", "spareToRunOnFrame", "", "Landroid/view/Choreographer$FrameCallback;", "toRunOnFrame", "toRunTrampolined", "Lkotlin/collections/ArrayDeque;", "Ljava/lang/Runnable;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "nextTask", "performFrameDispatch", "frameTimeNanos", "", "performTrampolineDispatch", "postFrameCallback", "callback", "postFrameCallback$ui_release", "removeFrameCallback", "removeFrameCallback$ui_release", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidUiDispatcher.android.kt */
public final class AndroidUiDispatcher extends CoroutineDispatcher {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<CoroutineContext> Main$delegate = LazyKt.lazy(AndroidUiDispatcher$Companion$Main$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final ThreadLocal<CoroutineContext> currentThread = new AndroidUiDispatcher$Companion$currentThread$1();
    private final Choreographer choreographer;
    private final AndroidUiDispatcher$dispatchCallback$1 dispatchCallback;
    private final MonotonicFrameClock frameClock;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public boolean scheduledFrameDispatch;
    private boolean scheduledTrampolineDispatch;
    private List<Choreographer.FrameCallback> spareToRunOnFrame;
    /* access modifiers changed from: private */
    public List<Choreographer.FrameCallback> toRunOnFrame;
    private final ArrayDeque<Runnable> toRunTrampolined;

    public /* synthetic */ AndroidUiDispatcher(Choreographer choreographer2, Handler handler2, DefaultConstructorMarker defaultConstructorMarker) {
        this(choreographer2, handler2);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    private AndroidUiDispatcher(Choreographer choreographer2, Handler handler2) {
        this.choreographer = choreographer2;
        this.handler = handler2;
        this.lock = new Object();
        this.toRunTrampolined = new ArrayDeque<>();
        this.toRunOnFrame = new ArrayList();
        this.spareToRunOnFrame = new ArrayList();
        this.dispatchCallback = new AndroidUiDispatcher$dispatchCallback$1(this);
        this.frameClock = new AndroidUiFrameClock(choreographer2, this);
    }

    private final Runnable nextTask() {
        Runnable removeFirstOrNull;
        synchronized (this.lock) {
            removeFirstOrNull = this.toRunTrampolined.removeFirstOrNull();
        }
        return removeFirstOrNull;
    }

    /* access modifiers changed from: private */
    public final void performTrampolineDispatch() {
        boolean z;
        do {
            Runnable nextTask = nextTask();
            while (nextTask != null) {
                nextTask.run();
                nextTask = nextTask();
            }
            synchronized (this.lock) {
                if (this.toRunTrampolined.isEmpty()) {
                    z = false;
                    this.scheduledTrampolineDispatch = false;
                } else {
                    z = true;
                }
            }
        } while (z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        r0 = r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r1 >= r0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r2.get(r1).doFrame(r5);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void performFrameDispatch(long r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            boolean r1 = r4.scheduledFrameDispatch     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 0
            r4.scheduledFrameDispatch = r1     // Catch:{ all -> 0x002b }
            java.util.List<android.view.Choreographer$FrameCallback> r2 = r4.toRunOnFrame     // Catch:{ all -> 0x002b }
            java.util.List<android.view.Choreographer$FrameCallback> r3 = r4.spareToRunOnFrame     // Catch:{ all -> 0x002b }
            r4.toRunOnFrame = r3     // Catch:{ all -> 0x002b }
            r4.spareToRunOnFrame = r2     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            int r0 = r2.size()
        L_0x0019:
            if (r1 >= r0) goto L_0x0027
            java.lang.Object r3 = r2.get(r1)
            android.view.Choreographer$FrameCallback r3 = (android.view.Choreographer.FrameCallback) r3
            r3.doFrame(r5)
            int r1 = r1 + 1
            goto L_0x0019
        L_0x0027:
            r2.clear()
            return
        L_0x002b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidUiDispatcher.performFrameDispatch(long):void");
    }

    public final void postFrameCallback$ui_release(Choreographer.FrameCallback frameCallback) {
        synchronized (this.lock) {
            this.toRunOnFrame.add(frameCallback);
            if (!this.scheduledFrameDispatch) {
                this.scheduledFrameDispatch = true;
                this.choreographer.postFrameCallback(this.dispatchCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeFrameCallback$ui_release(Choreographer.FrameCallback frameCallback) {
        synchronized (this.lock) {
            this.toRunOnFrame.remove(frameCallback);
        }
    }

    public final MonotonicFrameClock getFrameClock() {
        return this.frameClock;
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        synchronized (this.lock) {
            this.toRunTrampolined.addLast(runnable);
            if (!this.scheduledTrampolineDispatch) {
                this.scheduledTrampolineDispatch = true;
                this.handler.post(this.dispatchCallback);
                if (!this.scheduledFrameDispatch) {
                    this.scheduledFrameDispatch = true;
                    this.choreographer.postFrameCallback(this.dispatchCallback);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AndroidUiDispatcher$Companion;", "", "()V", "CurrentThread", "Lkotlin/coroutines/CoroutineContext;", "getCurrentThread", "()Lkotlin/coroutines/CoroutineContext;", "Main", "getMain", "Main$delegate", "Lkotlin/Lazy;", "currentThread", "Ljava/lang/ThreadLocal;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidUiDispatcher.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoroutineContext getMain() {
            return (CoroutineContext) AndroidUiDispatcher.Main$delegate.getValue();
        }

        public final CoroutineContext getCurrentThread() {
            if (AndroidUiDispatcher_androidKt.isMainThread()) {
                return getMain();
            }
            CoroutineContext coroutineContext = (CoroutineContext) AndroidUiDispatcher.currentThread.get();
            if (coroutineContext != null) {
                return coroutineContext;
            }
            throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
        }
    }
}
