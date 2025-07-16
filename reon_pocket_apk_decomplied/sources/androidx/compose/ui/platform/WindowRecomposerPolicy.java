package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.android.HandlerDispatcherKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0001J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0001J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0005J*\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0003\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\b¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/platform/WindowRecomposerPolicy;", "", "()V", "factory", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "compareAndSetFactory", "", "expected", "createAndInstallWindowRecomposer", "Landroidx/compose/runtime/Recomposer;", "rootView", "Landroid/view/View;", "createAndInstallWindowRecomposer$ui_release", "getAndSetFactory", "setFactory", "", "withFactory", "R", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/WindowRecomposerFactory;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposerPolicy {
    public static final int $stable = 8;
    public static final WindowRecomposerPolicy INSTANCE = new WindowRecomposerPolicy();
    private static final AtomicReference<WindowRecomposerFactory> factory = new AtomicReference<>(WindowRecomposerFactory.Companion.getLifecycleAware());

    private WindowRecomposerPolicy() {
    }

    public final WindowRecomposerFactory getAndSetFactory(WindowRecomposerFactory windowRecomposerFactory) {
        return factory.getAndSet(windowRecomposerFactory);
    }

    public final boolean compareAndSetFactory(WindowRecomposerFactory windowRecomposerFactory, WindowRecomposerFactory windowRecomposerFactory2) {
        return ComplexDouble$$ExternalSyntheticBackport0.m(factory, windowRecomposerFactory, windowRecomposerFactory2);
    }

    public final void setFactory(WindowRecomposerFactory windowRecomposerFactory) {
        factory.set(windowRecomposerFactory);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (compareAndSetFactory(r5, r1) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        kotlin.ExceptionsKt.addSuppressed(r6, new java.lang.IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R withFactory(androidx.compose.ui.platform.WindowRecomposerFactory r5, kotlin.jvm.functions.Function0<? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "WindowRecomposerFactory was set to unexpected value; cannot safely restore old state"
            androidx.compose.ui.platform.WindowRecomposerFactory r1 = r4.getAndSetFactory(r5)
            r2 = 1
            java.lang.Object r6 = r6.invoke()     // Catch:{ all -> 0x001e }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            boolean r5 = r4.compareAndSetFactory(r5, r1)
            if (r5 == 0) goto L_0x0018
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            return r6
        L_0x0018:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>(r0)
            throw r5
        L_0x001e:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            boolean r5 = r4.compareAndSetFactory(r5, r1)
            if (r5 != 0) goto L_0x0035
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>(r0)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            kotlin.ExceptionsKt.addSuppressed(r6, r5)
            throw r6
        L_0x0035:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.WindowRecomposerPolicy.withFactory(androidx.compose.ui.platform.WindowRecomposerFactory, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public final Recomposer createAndInstallWindowRecomposer$ui_release(View view) {
        Recomposer createRecomposer = factory.get().createRecomposer(view);
        WindowRecomposer_androidKt.setCompositionContext(view, createRecomposer);
        view.addOnAttachStateChangeListener(new WindowRecomposerPolicy$createAndInstallWindowRecomposer$1(BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, HandlerDispatcherKt.from(view.getHandler(), "windowRecomposer cleanup").getImmediate(), (CoroutineStart) null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(createRecomposer, view, (Continuation<? super WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1>) null), 2, (Object) null)));
        return createRecomposer;
    }
}
