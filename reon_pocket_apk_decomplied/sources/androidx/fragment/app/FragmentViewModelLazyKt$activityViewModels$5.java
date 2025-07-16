package androidx.fragment.app;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: FragmentViewModelLazy.kt */
public final class FragmentViewModelLazyKt$activityViewModels$5 extends Lambda implements Function0<CreationExtras> {
    final /* synthetic */ Function0<CreationExtras> $extrasProducer;
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$5(Function0<? extends CreationExtras> function0, Fragment fragment) {
        super(0);
        this.$extrasProducer = function0;
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
        /*
            r1 = this;
            kotlin.jvm.functions.Function0<androidx.lifecycle.viewmodel.CreationExtras> r0 = r1.$extrasProducer
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
            if (r0 != 0) goto L_0x0016
        L_0x000c:
            androidx.fragment.app.Fragment r0 = r1.$this_activityViewModels
            androidx.fragment.app.FragmentActivity r0 = r0.requireActivity()
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$5.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
