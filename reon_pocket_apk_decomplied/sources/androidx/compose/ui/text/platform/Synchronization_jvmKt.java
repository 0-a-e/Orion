package androidx.compose.ui.text.platform;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a*\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"createSynchronizedObject", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/text/platform/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Synchronization.jvm.kt */
public final class Synchronization_jvmKt {
    public static final SynchronizedObject createSynchronizedObject() {
        return new SynchronizedObject();
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m6325synchronized(SynchronizedObject synchronizedObject, Function0<? extends R> function0) {
        R invoke;
        synchronized (synchronizedObject) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }
}
