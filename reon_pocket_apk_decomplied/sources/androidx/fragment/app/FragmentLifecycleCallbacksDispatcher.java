package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/fragment/app/FragmentLifecycleCallbacksDispatcher;", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "lifecycleCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/fragment/app/FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder;", "dispatchOnFragmentActivityCreated", "", "f", "Landroidx/fragment/app/Fragment;", "savedInstanceState", "Landroid/os/Bundle;", "onlyRecursive", "", "dispatchOnFragmentAttached", "dispatchOnFragmentCreated", "dispatchOnFragmentDestroyed", "dispatchOnFragmentDetached", "dispatchOnFragmentPaused", "dispatchOnFragmentPreAttached", "dispatchOnFragmentPreCreated", "dispatchOnFragmentResumed", "dispatchOnFragmentSaveInstanceState", "outState", "dispatchOnFragmentStarted", "dispatchOnFragmentStopped", "dispatchOnFragmentViewCreated", "v", "Landroid/view/View;", "dispatchOnFragmentViewDestroyed", "registerFragmentLifecycleCallbacks", "cb", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "recursive", "unregisterFragmentLifecycleCallbacks", "FragmentLifecycleCallbacksHolder", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentLifecycleCallbacksDispatcher.kt */
public final class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager fragmentManager;
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> lifecycleCallbacks = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder;", "", "callback", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "recursive", "", "(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;Z)V", "getCallback", "()Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "getRecursive", "()Z", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FragmentLifecycleCallbacksDispatcher.kt */
    private static final class FragmentLifecycleCallbacksHolder {
        private final FragmentManager.FragmentLifecycleCallbacks callback;
        private final boolean recursive;

        public FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            Intrinsics.checkNotNullParameter(fragmentLifecycleCallbacks, "callback");
            this.callback = fragmentLifecycleCallbacks;
            this.recursive = z;
        }

        public final FragmentManager.FragmentLifecycleCallbacks getCallback() {
            return this.callback;
        }

        public final boolean getRecursive() {
            return this.recursive;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager2) {
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        this.fragmentManager = fragmentManager2;
    }

    public final void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        Intrinsics.checkNotNullParameter(fragmentLifecycleCallbacks, "cb");
        this.lifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    public final void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        Intrinsics.checkNotNullParameter(fragmentLifecycleCallbacks, "cb");
        synchronized (this.lifecycleCallbacks) {
            int size = this.lifecycleCallbacks.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.lifecycleCallbacks.get(i).getCallback() == fragmentLifecycleCallbacks) {
                    this.lifecycleCallbacks.remove(i);
                    break;
                } else {
                    i++;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void dispatchOnFragmentPreAttached(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Context context = this.fragmentManager.getHost().getContext();
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentPreAttached(this.fragmentManager, fragment, context);
            }
        }
    }

    public final void dispatchOnFragmentAttached(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Context context = this.fragmentManager.getHost().getContext();
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentAttached(this.fragmentManager, fragment, context);
            }
        }
    }

    public final void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentPreCreated(this.fragmentManager, fragment, bundle);
            }
        }
    }

    public final void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentCreated(this.fragmentManager, fragment, bundle);
            }
        }
    }

    public final void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentActivityCreated(this.fragmentManager, fragment, bundle);
            }
        }
    }

    public final void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(view, "v");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(fragment, view, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentViewCreated(this.fragmentManager, fragment, view, bundle);
            }
        }
    }

    public final void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentStarted(this.fragmentManager, fragment);
            }
        }
    }

    public final void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentResumed(this.fragmentManager, fragment);
            }
        }
    }

    public final void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentPaused(this.fragmentManager, fragment);
            }
        }
    }

    public final void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentStopped(this.fragmentManager, fragment);
            }
        }
    }

    public final void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentSaveInstanceState(this.fragmentManager, fragment, bundle);
            }
        }
    }

    public final void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentViewDestroyed(this.fragmentManager, fragment);
            }
        }
    }

    public final void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentDestroyed(this.fragmentManager, fragment);
            }
        }
    }

    public final void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.lifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.getRecursive()) {
                next.getCallback().onFragmentDetached(this.fragmentManager, fragment);
            }
        }
    }
}
