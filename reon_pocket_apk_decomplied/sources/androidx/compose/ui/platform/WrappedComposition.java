package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionServiceKey;
import androidx.compose.runtime.CompositionServices;
import androidx.compose.ui.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0016J#\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010&R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u001b\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Landroidx/compose/ui/platform/WrappedComposition;", "Landroidx/compose/runtime/Composition;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/compose/runtime/CompositionServices;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "original", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/Composition;)V", "addedToLifecycle", "Landroidx/lifecycle/Lifecycle;", "disposed", "", "hasInvalidations", "getHasInvalidations", "()Z", "isDisposed", "lastContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "getOriginal", "()Landroidx/compose/runtime/Composition;", "getOwner", "()Landroidx/compose/ui/platform/AndroidComposeView;", "dispose", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setContent", "content", "(Lkotlin/jvm/functions/Function2;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Wrapper.android.kt */
final class WrappedComposition implements Composition, LifecycleEventObserver, CompositionServices {
    /* access modifiers changed from: private */
    public Lifecycle addedToLifecycle;
    /* access modifiers changed from: private */
    public boolean disposed;
    /* access modifiers changed from: private */
    public Function2<? super Composer, ? super Integer, Unit> lastContent = ComposableSingletons$Wrapper_androidKt.INSTANCE.m5766getLambda1$ui_release();
    private final Composition original;
    private final AndroidComposeView owner;

    public WrappedComposition(AndroidComposeView androidComposeView, Composition composition) {
        this.owner = androidComposeView;
        this.original = composition;
    }

    public final AndroidComposeView getOwner() {
        return this.owner;
    }

    public final Composition getOriginal() {
        return this.original;
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.owner.setOnViewTreeOwnersAvailable(new WrappedComposition$setContent$1(this, function2));
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(R.id.wrapped_composition_tag, (Object) null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.original.dispose();
    }

    public boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    public boolean isDisposed() {
        return this.original.isDisposed();
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else if (event == Lifecycle.Event.ON_CREATE && !this.disposed) {
            setContent(this.lastContent);
        }
    }

    public <T> T getCompositionService(CompositionServiceKey<T> compositionServiceKey) {
        Composition composition = this.original;
        CompositionServices compositionServices = composition instanceof CompositionServices ? (CompositionServices) composition : null;
        if (compositionServices != null) {
            return compositionServices.getCompositionService(compositionServiceKey);
        }
        return null;
    }
}
