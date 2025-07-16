package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB)\b\u0000\u0012\b\u0010\n\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ7\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\bH\u0016J\r\u0010'\u001a\u00028\u0000H&¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\bH\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J+\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c0\"2\u0006\u00103\u001a\u00020\bH\u0017¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020-2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\u001cH\u0016J \u00108\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020:2\u0006\u00103\u001a\u00020\bH\u0016J*\u00108\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020:2\u0006\u00103\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016JL\u0010=\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020>2\u0006\u00103\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010:2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010<H\u0017J\b\u0010C\u001a\u00020\u001aH\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0003\u001a\u00020\u00048\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u00020\u00148G¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Landroidx/fragment/app/FragmentHostCallback;", "H", "Landroidx/fragment/app/FragmentContainer;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "windowAnimations", "", "(Landroid/content/Context;Landroid/os/Handler;I)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "Landroid/app/Activity;", "(Landroid/app/Activity;Landroid/content/Context;Landroid/os/Handler;I)V", "getActivity", "()Landroid/app/Activity;", "getContext", "()Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "getHandler", "()Landroid/os/Handler;", "onDump", "", "prefix", "", "fd", "Ljava/io/FileDescriptor;", "writer", "Ljava/io/PrintWriter;", "args", "", "(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "onFindViewById", "Landroid/view/View;", "id", "onGetHost", "()Ljava/lang/Object;", "onGetLayoutInflater", "Landroid/view/LayoutInflater;", "onGetWindowAnimations", "onHasView", "", "onHasWindowAnimations", "onRequestPermissionsFromFragment", "fragment", "Landroidx/fragment/app/Fragment;", "permissions", "requestCode", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;I)V", "onShouldSaveFragmentState", "onShouldShowRequestPermissionRationale", "permission", "onStartActivityFromFragment", "intent", "Landroid/content/Intent;", "options", "Landroid/os/Bundle;", "onStartIntentSenderFromFragment", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "onSupportInvalidateOptionsMenu", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentHostCallback.kt */
public abstract class FragmentHostCallback<H> extends FragmentContainer {
    private final Activity activity;
    private final Context context;
    private final FragmentManager fragmentManager;
    private final Handler handler;
    private final int windowAnimations;

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(printWriter, "writer");
    }

    public View onFindViewById(int i) {
        return null;
    }

    public abstract H onGetHost();

    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    @Deprecated(message = "Have your FragmentHostCallback implement {@link ActivityResultRegistryOwner}\n      to allow Fragments to use\n      {@link Fragment#registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with {@link RequestMultiplePermissions}. This method will still be called when Fragments\n      call the deprecated <code>requestPermissions()</code> method.")
    public void onRequestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        return false;
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public FragmentHostCallback(Activity activity2, Context context2, Handler handler2, int i) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(handler2, "handler");
        this.activity = activity2;
        this.context = context2;
        this.handler = handler2;
        this.windowAnimations = i;
        this.fragmentManager = new FragmentManagerImpl();
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(Context context2, Handler handler2, int i) {
        this(context2 instanceof Activity ? (Activity) context2 : null, context2, handler2, i);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(handler2, "handler");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
    }

    public LayoutInflater onGetLayoutInflater() {
        LayoutInflater from = LayoutInflater.from(this.context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        return from;
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        onStartActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (i == -1) {
            ContextCompat.startActivity(this.context, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host".toString());
    }

    @Deprecated(message = "Have your FragmentHostCallback implement {@link ActivityResultRegistryOwner}\n      to allow Fragments to use\n      {@link Fragment#registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with {@link StartIntentSenderForResult}. This method will still be called when Fragments\n      call the deprecated <code>startIntentSenderForResult()</code> method.")
    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Fragment fragment2 = fragment;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IntentSender intentSender2 = intentSender;
        Intrinsics.checkNotNullParameter(intentSender, "intent");
        if (i == -1) {
            Activity activity2 = this.activity;
            if (activity2 != null) {
                ActivityCompat.startIntentSenderForResult(activity2, intentSender, i, intent, i2, i3, i4, bundle);
                return;
            }
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host".toString());
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host".toString());
    }

    public int onGetWindowAnimations() {
        return this.windowAnimations;
    }
}
