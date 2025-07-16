package androidx.compose.material3;

import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\r\u0010%\u001a\u00020\bH\u0017¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\bH\u0014J\b\u0010.\u001a\u00020\bH\u0014J\b\u0010/\u001a\u00020\bH\u0016J*\u00100\u001a\u00020\b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\u0011¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\u001aH\u0016J\u0006\u00106\u001a\u00020\bJ\u000e\u00107\u001a\u00020\b2\u0006\u00105\u001a\u000208R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000RA\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\u00112\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\u00118B@BX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetWindow;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "onDismissRequest", "Lkotlin/Function0;", "", "composeView", "Landroid/view/View;", "saveId", "Ljava/util/UUID;", "(Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function0;Landroid/view/View;Ljava/util/UUID;)V", "backCallback", "", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "displayWidth", "", "getDisplayWidth", "()I", "params", "Landroid/view/WindowManager$LayoutParams;", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "windowManager", "Landroid/view/WindowManager;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "dismiss", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "maybeRegisterBackCallback", "maybeUnregisterBackCallback", "onAttachedToWindow", "onDetachedFromWindow", "onGlobalLayout", "setCustomContent", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setLayoutDirection", "layoutDirection", "show", "superSetLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Api33Impl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheetWindow extends AbstractComposeView implements ViewTreeObserver.OnGlobalLayoutListener, ViewRootForInspector {
    private Object backCallback;
    private final View composeView;
    private final MutableState content$delegate;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;
    private final ModalBottomSheetProperties properties;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final WindowManager windowManager;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.compose.ui.unit.LayoutDirection[] r0 = androidx.compose.ui.unit.LayoutDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Ltr     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Rtl     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetWindow.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ AbstractComposeView getSubCompositionView() {
        return ViewRootForInspector.CC.$default$getSubCompositionView(this);
    }

    public /* synthetic */ View getViewRoot() {
        return ViewRootForInspector.CC.$default$getViewRoot(this);
    }

    public void onGlobalLayout() {
    }

    public void setLayoutDirection(int i) {
    }

    public ModalBottomSheetWindow(ModalBottomSheetProperties modalBottomSheetProperties, Function0<Unit> function0, View view, UUID uuid) {
        super(view.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.properties = modalBottomSheetProperties;
        this.onDismissRequest = function0;
        this.composeView = view;
        setId(16908290);
        View view2 = this;
        ViewTreeLifecycleOwner.set(view2, ViewTreeLifecycleOwner.get(view));
        ViewTreeViewModelStoreOwner.set(view2, ViewTreeViewModelStoreOwner.get(view));
        ViewTreeSavedStateRegistryOwner.set(view2, ViewTreeSavedStateRegistryOwner.get(view));
        setTag(R.id.compose_view_saveable_id_tag, "Popup:" + uuid);
        setClipChildren(false);
        Object systemService = view.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388691;
        layoutParams.type = 1000;
        layoutParams.width = getDisplayWidth();
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.setTitle(view.getContext().getResources().getString(R.string.default_popup_window_title));
        layoutParams.token = view.getApplicationWindowToken();
        layoutParams.flags &= -163841;
        layoutParams.flags |= 512;
        if (ModalBottomSheet_androidKt.shouldApplySecureFlag(modalBottomSheetProperties.getSecurePolicy(), ModalBottomSheet_androidKt.isFlagSecureEnabled(view))) {
            layoutParams.flags |= 8192;
        } else {
            layoutParams.flags &= -8193;
        }
        if (!modalBottomSheetProperties.isFocusable()) {
            layoutParams.flags |= 8;
        } else {
            layoutParams.flags &= -9;
        }
        this.params = layoutParams;
        this.content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1715getLambda2$material3_release(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final int getDisplayWidth() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    /* access modifiers changed from: protected */
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public void Content(Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-463309699);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)563@23901L9:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-463309699, i2, -1, "androidx.compose.material3.ModalBottomSheetWindow.Content (ModalBottomSheet.android.kt:562)");
            }
            getContent().invoke(startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheetWindow$Content$4(this, i));
        }
    }

    public static /* synthetic */ void setCustomContent$default(ModalBottomSheetWindow modalBottomSheetWindow, CompositionContext compositionContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            compositionContext = null;
        }
        modalBottomSheetWindow.setCustomContent(compositionContext, function2);
    }

    public final void setCustomContent(CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (compositionContext != null) {
            setParentCompositionContext(compositionContext);
        }
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    public final void dismiss() {
        View view = this;
        ViewTreeLifecycleOwner.set(view, (LifecycleOwner) null);
        ViewTreeSavedStateRegistryOwner.set(view, (SavedStateRegistryOwner) null);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.windowManager.removeViewImmediate(view);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        if (keyEvent.getKeyCode() == 4 && this.properties.getShouldDismissOnBackPress()) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                }
                return true;
            } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                this.onDismissRequest.invoke();
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeRegisterBackCallback();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeUnregisterBackCallback();
    }

    private final void maybeRegisterBackCallback() {
        if (this.properties.getShouldDismissOnBackPress() && Build.VERSION.SDK_INT >= 33) {
            if (this.backCallback == null) {
                this.backCallback = Api33Impl.createBackCallback(this.onDismissRequest);
            }
            Api33Impl.maybeRegisterBackCallback(this, this.backCallback);
        }
    }

    private final void maybeUnregisterBackCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
        }
        this.backCallback = null;
    }

    public final void superSetLayoutDirection(LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i2);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetWindow$Api33Impl;", "", "()V", "createBackCallback", "Landroid/window/OnBackInvokedCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "maybeRegisterBackCallback", "view", "Landroid/view/View;", "backCallback", "maybeUnregisterBackCallback", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
    private static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @JvmStatic
        public static final OnBackInvokedCallback createBackCallback(Function0<Unit> function0) {
            return new ModalBottomSheetWindow$Api33Impl$$ExternalSyntheticLambda0(function0);
        }

        /* access modifiers changed from: private */
        public static final void createBackCallback$lambda$0(Function0 function0) {
            function0.invoke();
        }

        @JvmStatic
        public static final void maybeRegisterBackCallback(View view, Object obj) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if ((obj instanceof OnBackInvokedCallback) && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                findOnBackInvokedDispatcher.registerOnBackInvokedCallback(DurationKt.NANOS_IN_MILLIS, (OnBackInvokedCallback) obj);
            }
        }

        @JvmStatic
        public static final void maybeUnregisterBackCallback(View view, Object obj) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher;
            if ((obj instanceof OnBackInvokedCallback) && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj);
            }
        }
    }
}
