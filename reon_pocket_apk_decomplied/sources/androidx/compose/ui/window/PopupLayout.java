package androidx.compose.ui.window;

import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001BO\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\r\u0010_\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010`J\u0010\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020%H\u0002J\b\u0010c\u001a\u000200H\u0002J\u0006\u0010d\u001a\u00020\u0005J\u0010\u0010e\u001a\u00020\u00162\u0006\u0010f\u001a\u00020gH\u0016J5\u0010h\u001a\u00020\u00052\u0006\u0010i\u001a\u00020\u00162\u0006\u0010j\u001a\u00020%2\u0006\u0010k\u001a\u00020%2\u0006\u0010l\u001a\u00020%2\u0006\u0010m\u001a\u00020%H\u0010¢\u0006\u0002\bnJ\u001d\u0010o\u001a\u00020\u00052\u0006\u0010p\u001a\u00020%2\u0006\u0010q\u001a\u00020%H\u0010¢\u0006\u0002\brJ\b\u0010s\u001a\u00020\u0005H\u0014J\b\u0010t\u001a\u00020\u0005H\u0014J\u0012\u0010u\u001a\u00020\u00162\b\u0010f\u001a\u0004\u0018\u00010vH\u0016J\u0006\u0010w\u001a\u00020\u0005J\u0010\u0010x\u001a\u00020\u00052\u0006\u0010y\u001a\u00020\u0016H\u0002J&\u0010 \u001a\u00020\u00052\u0006\u0010z\u001a\u00020{2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u001c¢\u0006\u0002\u0010|J\u0010\u0010}\u001a\u00020\u00052\u0006\u0010~\u001a\u00020\u0016H\u0002J\u0011\u0010\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0013\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020\u0005J\u0012\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020?H\u0002J0\u0010\u0001\u001a\u00020\u00052\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020?J\u000f\u0010\u0001\u001a\u00020\u0005H\u0001¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u000207J\u0007\u0010\u0001\u001a\u00020\u0005R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000RA\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u001c2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u001c8B@BX\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010$\u001a\u00020%8BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u00020-X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010.R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0002008\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R/\u00108\u001a\u0004\u0018\u0001072\b\u0010\u001b\u001a\u0004\u0018\u0001078B@BX\u0002¢\u0006\u0012\n\u0004\b=\u0010#\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR5\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\u001b\u001a\u0004\u0018\u00010D8F@FX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bJ\u0010#\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010R\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0018R\u000e\u0010T\u001a\u00020UX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/window/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/PopupProperties;", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "popupLayoutHelper", "Landroidx/compose/ui/window/PopupLayoutHelper;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;Landroidx/compose/ui/window/PopupLayoutHelper;)V", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "<set-?>", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "displayHeight", "", "getDisplayHeight", "()I", "displayWidth", "getDisplayWidth", "locationOnScreen", "", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "params", "Landroid/view/WindowManager$LayoutParams;", "getParams$ui_release$annotations", "()V", "getParams$ui_release", "()Landroid/view/WindowManager$LayoutParams;", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setParentLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "parentLayoutCoordinates$delegate", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "windowManager", "Landroid/view/WindowManager;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "applyNewFlags", "flags", "createLayoutParams", "dismiss", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "onAttachedToWindow", "onDetachedFromWindow", "onTouchEvent", "Landroid/view/MotionEvent;", "pollForLocationOnScreenChange", "setClippingEnabled", "clippingEnabled", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setIsFocusable", "isFocusable", "setLayoutDirection", "layoutDirection", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "show", "superSetLayoutDirection", "updateParameters", "updateParentBounds", "updateParentBounds$ui_release", "updateParentLayoutCoordinates", "updatePosition", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class PopupLayout extends AbstractComposeView implements ViewRootForInspector {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Function1<PopupLayout, Unit> onCommitAffectingPopupPosition = PopupLayout$Companion$onCommitAffectingPopupPosition$1.INSTANCE;
    private final State canCalculatePosition$delegate;
    private final View composeView;
    private final MutableState content$delegate;
    private final int[] locationOnScreen;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;
    private IntRect parentBounds;
    private final MutableState parentLayoutCoordinates$delegate;
    private LayoutDirection parentLayoutDirection;
    private final MutableState popupContentSize$delegate;
    private final PopupLayoutHelper popupLayoutHelper;
    private PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private PopupProperties properties;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final SnapshotStateObserver snapshotStateObserver;
    private String testTag;
    private final WindowManager windowManager;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidPopup.android.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupLayout.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void getParams$ui_release$annotations() {
    }

    public /* synthetic */ View getViewRoot() {
        return ViewRootForInspector.CC.$default$getViewRoot(this);
    }

    public void setLayoutDirection(int i) {
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public final void setTestTag(String str) {
        this.testTag = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PopupLayout(kotlin.jvm.functions.Function0 r11, androidx.compose.ui.window.PopupProperties r12, java.lang.String r13, android.view.View r14, androidx.compose.ui.unit.Density r15, androidx.compose.ui.window.PopupPositionProvider r16, java.util.UUID r17, androidx.compose.ui.window.PopupLayoutHelper r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x001d
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0014
            androidx.compose.ui.window.PopupLayoutHelperImpl29 r0 = new androidx.compose.ui.window.PopupLayoutHelperImpl29
            r0.<init>()
            androidx.compose.ui.window.PopupLayoutHelper r0 = (androidx.compose.ui.window.PopupLayoutHelper) r0
            goto L_0x001b
        L_0x0014:
            androidx.compose.ui.window.PopupLayoutHelperImpl r0 = new androidx.compose.ui.window.PopupLayoutHelperImpl
            r0.<init>()
            androidx.compose.ui.window.PopupLayoutHelper r0 = (androidx.compose.ui.window.PopupLayoutHelper) r0
        L_0x001b:
            r9 = r0
            goto L_0x001f
        L_0x001d:
            r9 = r18
        L_0x001f:
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupLayout.<init>(kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, java.lang.String, android.view.View, androidx.compose.ui.unit.Density, androidx.compose.ui.window.PopupPositionProvider, java.util.UUID, androidx.compose.ui.window.PopupLayoutHelper, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public PopupLayout(Function0<Unit> function0, PopupProperties popupProperties, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid, PopupLayoutHelper popupLayoutHelper2) {
        super(view.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.onDismissRequest = function0;
        this.properties = popupProperties;
        this.testTag = str;
        this.composeView = view;
        this.popupLayoutHelper = popupLayoutHelper2;
        Object systemService = view.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        this.params = createLayoutParams();
        this.positionProvider = popupPositionProvider;
        this.parentLayoutDirection = LayoutDirection.Ltr;
        this.popupContentSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.parentLayoutCoordinates$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf(new PopupLayout$canCalculatePosition$2(this));
        float r9 = Dp.m6614constructorimpl((float) 8);
        this.maxSupportedElevation = r9;
        this.previousWindowVisibleFrame = new Rect();
        this.snapshotStateObserver = new SnapshotStateObserver(new PopupLayout$snapshotStateObserver$1(this));
        setId(16908290);
        View view2 = this;
        ViewTreeLifecycleOwner.set(view2, ViewTreeLifecycleOwner.get(view));
        ViewTreeViewModelStoreOwner.set(view2, ViewTreeViewModelStoreOwner.get(view));
        ViewTreeSavedStateRegistryOwner.set(view2, ViewTreeSavedStateRegistryOwner.get(view));
        int i = R.id.compose_view_saveable_id_tag;
        setTag(i, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(density.m6550toPx0680j_4(r9));
        setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setRect(0, 0, view.getWidth(), view.getHeight());
                outline.setAlpha(0.0f);
            }
        });
        this.content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidPopup_androidKt.INSTANCE.m6881getLambda1$ui_release(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.locationOnScreen = new int[2];
    }

    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.params;
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        this.positionProvider = popupPositionProvider;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        this.parentLayoutDirection = layoutDirection;
    }

    /* renamed from: getPopupContentSize-bOM6tXw  reason: not valid java name */
    public final IntSize m6882getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    /* renamed from: setPopupContentSize-fhxjrPA  reason: not valid java name */
    public final void m6883setPopupContentSizefhxjrPA(IntSize intSize) {
        this.popupContentSize$delegate.setValue(intSize);
    }

    /* access modifiers changed from: private */
    public final LayoutCoordinates getParentLayoutCoordinates() {
        return (LayoutCoordinates) this.parentLayoutCoordinates$delegate.getValue();
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.parentLayoutCoordinates$delegate.setValue(layoutCoordinates);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
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

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    public final void setContent(CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public void Content(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-857613600);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)476@19626L9:AndroidPopup.android.kt#2oxthz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-857613600, i, -1, "androidx.compose.ui.window.PopupLayout.Content (AndroidPopup.android.kt:475)");
        }
        getContent().invoke(startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PopupLayout$Content$4(this, i));
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotStateObserver.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotStateObserver.stop();
        this.snapshotStateObserver.clear();
    }

    public void internalOnMeasure$ui_release(int i, int i2) {
        if (this.properties.getUsePlatformDefaultWidth()) {
            super.internalOnMeasure$ui_release(i, i2);
        } else {
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(getDisplayWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getDisplayHeight(), Integer.MIN_VALUE));
        }
    }

    public void internalOnLayout$ui_release(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        super.internalOnLayout$ui_release(z, i, i2, i3, i4);
        if (!this.properties.getUsePlatformDefaultWidth() && (childAt = getChildAt(0)) != null) {
            this.params.width = childAt.getMeasuredWidth();
            this.params.height = childAt.getMeasuredHeight();
            this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
        }
    }

    private final int getDisplayWidth() {
        return MathKt.roundToInt(((float) getContext().getResources().getConfiguration().screenWidthDp) * getContext().getResources().getDisplayMetrics().density);
    }

    private final int getDisplayHeight() {
        return MathKt.roundToInt(((float) getContext().getResources().getConfiguration().screenHeightDp) * getContext().getResources().getDisplayMetrics().density);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        if (keyEvent.getKeyCode() == 4 && this.properties.getDismissOnBackPress()) {
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
                Function0<Unit> function0 = this.onDismissRequest;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private final void setIsFocusable(boolean z) {
        int i;
        if (!z) {
            i = this.params.flags | 8;
        } else {
            i = this.params.flags & -9;
        }
        applyNewFlags(i);
    }

    private final void setSecurePolicy(SecureFlagPolicy secureFlagPolicy) {
        int i;
        if (SecureFlagPolicy_androidKt.shouldApplySecureFlag(secureFlagPolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView))) {
            i = this.params.flags | 8192;
        } else {
            i = this.params.flags & -8193;
        }
        applyNewFlags(i);
    }

    private final void setClippingEnabled(boolean z) {
        int i;
        if (z) {
            i = this.params.flags & -513;
        } else {
            i = this.params.flags | 512;
        }
        applyNewFlags(i);
    }

    public final void updateParameters(Function0<Unit> function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
        this.onDismissRequest = function0;
        if (popupProperties.getUsePlatformDefaultWidth() && !this.properties.getUsePlatformDefaultWidth()) {
            this.params.width = -2;
            this.params.height = -2;
            this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
        }
        this.properties = popupProperties;
        this.testTag = str;
        setIsFocusable(popupProperties.getFocusable());
        setSecurePolicy(popupProperties.getSecurePolicy());
        setClippingEnabled(popupProperties.getClippingEnabled());
        superSetLayoutDirection(layoutDirection);
    }

    private final void applyNewFlags(int i) {
        this.params.flags = i;
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
    }

    public final void updateParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        setParentLayoutCoordinates(layoutCoordinates);
        updateParentBounds$ui_release();
    }

    public final void pollForLocationOnScreenChange() {
        int[] iArr = this.locationOnScreen;
        int i = iArr[0];
        int i2 = iArr[1];
        this.composeView.getLocationOnScreen(iArr);
        int[] iArr2 = this.locationOnScreen;
        if (i != iArr2[0] || i2 != iArr2[1]) {
            updateParentBounds$ui_release();
        }
    }

    public final void updateParentBounds$ui_release() {
        LayoutCoordinates parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            long r1 = parentLayoutCoordinates.m5318getSizeYbymL2g();
            long positionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
            IntRect r0 = IntRectKt.m6780IntRectVbeCjmY(IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3562getXimpl(positionInWindow)), MathKt.roundToInt(Offset.m3563getYimpl(positionInWindow))), r1);
            if (!Intrinsics.areEqual((Object) r0, (Object) this.parentBounds)) {
                this.parentBounds = r0;
                updatePosition();
            }
        }
    }

    public final void updatePosition() {
        IntSize r0;
        IntRect intRect = this.parentBounds;
        if (intRect != null && (r0 = m6882getPopupContentSizebOM6tXw()) != null) {
            long r6 = r0.m6794unboximpl();
            Rect rect = this.previousWindowVisibleFrame;
            this.popupLayoutHelper.getWindowVisibleDisplayFrame(this.composeView, rect);
            IntRect access$toIntBounds = AndroidPopup_androidKt.toIntBounds(rect);
            long IntSize = IntSizeKt.IntSize(access$toIntBounds.getWidth(), access$toIntBounds.getHeight());
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = IntOffset.Companion.m6758getZeronOccac();
            this.snapshotStateObserver.observeReads(this, onCommitAffectingPopupPosition, new PopupLayout$updatePosition$1(longRef, this, intRect, IntSize, r6));
            this.params.x = IntOffset.m6748getXimpl(longRef.element);
            this.params.y = IntOffset.m6749getYimpl(longRef.element);
            if (this.properties.getExcludeFromSystemGesture()) {
                this.popupLayoutHelper.setGestureExclusionRects(this, IntSize.m6790getWidthimpl(IntSize), IntSize.m6789getHeightimpl(IntSize));
            }
            this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
        }
    }

    public final void dismiss() {
        View view = this;
        ViewTreeLifecycleOwner.set(view, (LifecycleOwner) null);
        this.windowManager.removeViewImmediate(view);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.properties.getDismissOnClickOutside()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent != null && motionEvent.getAction() == 0 && (motionEvent.getX() < 0.0f || motionEvent.getX() >= ((float) getWidth()) || motionEvent.getY() < 0.0f || motionEvent.getY() >= ((float) getHeight()))) {
            Function0<Unit> function0 = this.onDismissRequest;
            if (function0 != null) {
                function0.invoke();
            }
            return true;
        } else if (motionEvent == null || motionEvent.getAction() != 4) {
            return super.onTouchEvent(motionEvent);
        } else {
            Function0<Unit> function02 = this.onDismissRequest;
            if (function02 != null) {
                function02.invoke();
            }
            return true;
        }
    }

    private final void superSetLayoutDirection(LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i2);
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags &= -8552473;
        layoutParams.flags |= 262144;
        layoutParams.type = PointerIconCompat.TYPE_HAND;
        layoutParams.token = this.composeView.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.composeView.getContext().getResources().getString(R.string.default_popup_window_title));
        return layoutParams;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/window/PopupLayout$Companion;", "", "()V", "onCommitAffectingPopupPosition", "Lkotlin/Function1;", "Landroidx/compose/ui/window/PopupLayout;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidPopup.android.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
