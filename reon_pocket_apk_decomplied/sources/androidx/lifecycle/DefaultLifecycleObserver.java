package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultLifecycleObserver.kt */
public interface DefaultLifecycleObserver extends LifecycleObserver {

    /* renamed from: androidx.lifecycle.DefaultLifecycleObserver$-CC  reason: invalid class name */
    /* compiled from: DefaultLifecycleObserver.kt */
    public final /* synthetic */ class CC {
        public static void $default$onCreate(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        public static void $default$onDestroy(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        public static void $default$onPause(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        public static void $default$onResume(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        public static void $default$onStart(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }

        public static void $default$onStop(DefaultLifecycleObserver _this, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        }
    }

    void onCreate(LifecycleOwner lifecycleOwner);

    void onDestroy(LifecycleOwner lifecycleOwner);

    void onPause(LifecycleOwner lifecycleOwner);

    void onResume(LifecycleOwner lifecycleOwner);

    void onStart(LifecycleOwner lifecycleOwner);

    void onStop(LifecycleOwner lifecycleOwner);
}
