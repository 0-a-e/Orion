package androidx.compose.foundation.layout;

import android.view.View;
import android.view.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 E2\u00020\u0001:\u0001EB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010=\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\bJ\u000e\u0010C\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0003J\u000e\u0010D\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\fR\u0011\u0010!\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u0011\u0010#\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0010R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010-\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\fR\u0011\u0010/\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0010R\u0011\u00101\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\fR\u0011\u00103\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0010R\u0011\u00105\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\fR\u0011\u00107\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\fR\u0011\u00109\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0010R\u0011\u0010;\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0010¨\u0006F"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder;", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "view", "Landroid/view/View;", "(Landroidx/core/view/WindowInsetsCompat;Landroid/view/View;)V", "accessCount", "", "captionBar", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getCaptionBar", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "captionBarIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "getCaptionBarIgnoringVisibility", "()Landroidx/compose/foundation/layout/ValueInsets;", "consumes", "", "getConsumes", "()Z", "displayCutout", "getDisplayCutout", "ime", "getIme", "imeAnimationSource", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget", "insetsListener", "Landroidx/compose/foundation/layout/InsetsListener;", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility", "safeContent", "Landroidx/compose/foundation/layout/WindowInsets;", "getSafeContent", "()Landroidx/compose/foundation/layout/WindowInsets;", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility", "waterfall", "getWaterfall", "decrementAccessors", "", "incrementAccessors", "update", "windowInsets", "types", "updateImeAnimationSource", "updateImeAnimationTarget", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsets.android.kt */
public final class WindowInsetsHolder {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean testInsets;
    /* access modifiers changed from: private */
    public static final WeakHashMap<View, WindowInsetsHolder> viewMap = new WeakHashMap<>();
    private int accessCount;
    private final AndroidWindowInsets captionBar;
    private final ValueInsets captionBarIgnoringVisibility;
    private final boolean consumes;
    private final AndroidWindowInsets displayCutout;
    private final AndroidWindowInsets ime;
    private final ValueInsets imeAnimationSource;
    private final ValueInsets imeAnimationTarget;
    private final InsetsListener insetsListener;
    private final AndroidWindowInsets mandatorySystemGestures;
    private final AndroidWindowInsets navigationBars;
    private final ValueInsets navigationBarsIgnoringVisibility;
    private final WindowInsets safeContent;
    private final WindowInsets safeDrawing;
    private final WindowInsets safeGestures;
    private final AndroidWindowInsets statusBars;
    private final ValueInsets statusBarsIgnoringVisibility;
    private final AndroidWindowInsets systemBars;
    private final ValueInsets systemBarsIgnoringVisibility;
    private final AndroidWindowInsets systemGestures;
    private final AndroidWindowInsets tappableElement;
    private final ValueInsets tappableElementIgnoringVisibility;
    private final ValueInsets waterfall;

    public /* synthetic */ WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsetsCompat, view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x007d, code lost:
        r7 = (r7 = r10.getDisplayCutout()).getWaterfallInsets();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private WindowInsetsHolder(androidx.core.view.WindowInsetsCompat r10, android.view.View r11) {
        /*
            r9 = this;
            r9.<init>()
            androidx.compose.foundation.layout.WindowInsetsHolder$Companion r0 = Companion
            int r1 = androidx.core.view.WindowInsetsCompat.Type.captionBar()
            java.lang.String r2 = "captionBar"
            androidx.compose.foundation.layout.AndroidWindowInsets r1 = r0.systemInsets(r10, r1, r2)
            r9.captionBar = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.displayCutout()
            java.lang.String r2 = "displayCutout"
            androidx.compose.foundation.layout.AndroidWindowInsets r1 = r0.systemInsets(r10, r1, r2)
            r9.displayCutout = r1
            int r2 = androidx.core.view.WindowInsetsCompat.Type.ime()
            java.lang.String r3 = "ime"
            androidx.compose.foundation.layout.AndroidWindowInsets r2 = r0.systemInsets(r10, r2, r3)
            r9.ime = r2
            int r3 = androidx.core.view.WindowInsetsCompat.Type.mandatorySystemGestures()
            java.lang.String r4 = "mandatorySystemGestures"
            androidx.compose.foundation.layout.AndroidWindowInsets r3 = r0.systemInsets(r10, r3, r4)
            r9.mandatorySystemGestures = r3
            int r4 = androidx.core.view.WindowInsetsCompat.Type.navigationBars()
            java.lang.String r5 = "navigationBars"
            androidx.compose.foundation.layout.AndroidWindowInsets r4 = r0.systemInsets(r10, r4, r5)
            r9.navigationBars = r4
            int r4 = androidx.core.view.WindowInsetsCompat.Type.statusBars()
            java.lang.String r5 = "statusBars"
            androidx.compose.foundation.layout.AndroidWindowInsets r4 = r0.systemInsets(r10, r4, r5)
            r9.statusBars = r4
            int r4 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            java.lang.String r5 = "systemBars"
            androidx.compose.foundation.layout.AndroidWindowInsets r4 = r0.systemInsets(r10, r4, r5)
            r9.systemBars = r4
            int r5 = androidx.core.view.WindowInsetsCompat.Type.systemGestures()
            java.lang.String r6 = "systemGestures"
            androidx.compose.foundation.layout.AndroidWindowInsets r5 = r0.systemInsets(r10, r5, r6)
            r9.systemGestures = r5
            int r6 = androidx.core.view.WindowInsetsCompat.Type.tappableElement()
            java.lang.String r7 = "tappableElement"
            androidx.compose.foundation.layout.AndroidWindowInsets r6 = r0.systemInsets(r10, r6, r7)
            r9.tappableElement = r6
            if (r10 == 0) goto L_0x0083
            androidx.core.view.DisplayCutoutCompat r7 = r10.getDisplayCutout()
            if (r7 == 0) goto L_0x0083
            androidx.core.graphics.Insets r7 = r7.getWaterfallInsets()
            if (r7 != 0) goto L_0x0085
        L_0x0083:
            androidx.core.graphics.Insets r7 = androidx.core.graphics.Insets.NONE
        L_0x0085:
            java.lang.String r8 = "waterfall"
            androidx.compose.foundation.layout.ValueInsets r7 = androidx.compose.foundation.layout.WindowInsets_androidKt.ValueInsets(r7, r8)
            r9.waterfall = r7
            androidx.compose.foundation.layout.WindowInsets r4 = (androidx.compose.foundation.layout.WindowInsets) r4
            androidx.compose.foundation.layout.WindowInsets r2 = (androidx.compose.foundation.layout.WindowInsets) r2
            androidx.compose.foundation.layout.WindowInsets r2 = androidx.compose.foundation.layout.WindowInsetsKt.union(r4, r2)
            androidx.compose.foundation.layout.WindowInsets r1 = (androidx.compose.foundation.layout.WindowInsets) r1
            androidx.compose.foundation.layout.WindowInsets r1 = androidx.compose.foundation.layout.WindowInsetsKt.union(r2, r1)
            r9.safeDrawing = r1
            androidx.compose.foundation.layout.WindowInsets r6 = (androidx.compose.foundation.layout.WindowInsets) r6
            androidx.compose.foundation.layout.WindowInsets r3 = (androidx.compose.foundation.layout.WindowInsets) r3
            androidx.compose.foundation.layout.WindowInsets r2 = androidx.compose.foundation.layout.WindowInsetsKt.union(r6, r3)
            androidx.compose.foundation.layout.WindowInsets r5 = (androidx.compose.foundation.layout.WindowInsets) r5
            androidx.compose.foundation.layout.WindowInsets r2 = androidx.compose.foundation.layout.WindowInsetsKt.union(r2, r5)
            androidx.compose.foundation.layout.WindowInsets r7 = (androidx.compose.foundation.layout.WindowInsets) r7
            androidx.compose.foundation.layout.WindowInsets r2 = androidx.compose.foundation.layout.WindowInsetsKt.union(r2, r7)
            r9.safeGestures = r2
            androidx.compose.foundation.layout.WindowInsets r1 = androidx.compose.foundation.layout.WindowInsetsKt.union(r1, r2)
            r9.safeContent = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.captionBar()
            java.lang.String r2 = "captionBarIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r1 = r0.valueInsetsIgnoringVisibility(r10, r1, r2)
            r9.captionBarIgnoringVisibility = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.navigationBars()
            java.lang.String r2 = "navigationBarsIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r1 = r0.valueInsetsIgnoringVisibility(r10, r1, r2)
            r9.navigationBarsIgnoringVisibility = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.statusBars()
            java.lang.String r2 = "statusBarsIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r1 = r0.valueInsetsIgnoringVisibility(r10, r1, r2)
            r9.statusBarsIgnoringVisibility = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            java.lang.String r2 = "systemBarsIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r1 = r0.valueInsetsIgnoringVisibility(r10, r1, r2)
            r9.systemBarsIgnoringVisibility = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.tappableElement()
            java.lang.String r2 = "tappableElementIgnoringVisibility"
            androidx.compose.foundation.layout.ValueInsets r1 = r0.valueInsetsIgnoringVisibility(r10, r1, r2)
            r9.tappableElementIgnoringVisibility = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.ime()
            java.lang.String r2 = "imeAnimationTarget"
            androidx.compose.foundation.layout.ValueInsets r1 = r0.valueInsetsIgnoringVisibility(r10, r1, r2)
            r9.imeAnimationTarget = r1
            int r1 = androidx.core.view.WindowInsetsCompat.Type.ime()
            java.lang.String r2 = "imeAnimationSource"
            androidx.compose.foundation.layout.ValueInsets r10 = r0.valueInsetsIgnoringVisibility(r10, r1, r2)
            r9.imeAnimationSource = r10
            android.view.ViewParent r10 = r11.getParent()
            boolean r11 = r10 instanceof android.view.View
            r0 = 0
            if (r11 == 0) goto L_0x011d
            android.view.View r10 = (android.view.View) r10
            goto L_0x011e
        L_0x011d:
            r10 = r0
        L_0x011e:
            if (r10 == 0) goto L_0x0127
            int r11 = androidx.compose.ui.R.id.consume_window_insets_tag
            java.lang.Object r10 = r10.getTag(r11)
            goto L_0x0128
        L_0x0127:
            r10 = r0
        L_0x0128:
            boolean r11 = r10 instanceof java.lang.Boolean
            if (r11 == 0) goto L_0x012f
            r0 = r10
            java.lang.Boolean r0 = (java.lang.Boolean) r0
        L_0x012f:
            if (r0 == 0) goto L_0x0136
            boolean r10 = r0.booleanValue()
            goto L_0x0137
        L_0x0136:
            r10 = 1
        L_0x0137:
            r9.consumes = r10
            androidx.compose.foundation.layout.InsetsListener r10 = new androidx.compose.foundation.layout.InsetsListener
            r10.<init>(r9)
            r9.insetsListener = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsHolder.<init>(androidx.core.view.WindowInsetsCompat, android.view.View):void");
    }

    public final AndroidWindowInsets getCaptionBar() {
        return this.captionBar;
    }

    public final AndroidWindowInsets getDisplayCutout() {
        return this.displayCutout;
    }

    public final AndroidWindowInsets getIme() {
        return this.ime;
    }

    public final AndroidWindowInsets getMandatorySystemGestures() {
        return this.mandatorySystemGestures;
    }

    public final AndroidWindowInsets getNavigationBars() {
        return this.navigationBars;
    }

    public final AndroidWindowInsets getStatusBars() {
        return this.statusBars;
    }

    public final AndroidWindowInsets getSystemBars() {
        return this.systemBars;
    }

    public final AndroidWindowInsets getSystemGestures() {
        return this.systemGestures;
    }

    public final AndroidWindowInsets getTappableElement() {
        return this.tappableElement;
    }

    public final ValueInsets getWaterfall() {
        return this.waterfall;
    }

    public final WindowInsets getSafeDrawing() {
        return this.safeDrawing;
    }

    public final WindowInsets getSafeGestures() {
        return this.safeGestures;
    }

    public final WindowInsets getSafeContent() {
        return this.safeContent;
    }

    public final ValueInsets getCaptionBarIgnoringVisibility() {
        return this.captionBarIgnoringVisibility;
    }

    public final ValueInsets getNavigationBarsIgnoringVisibility() {
        return this.navigationBarsIgnoringVisibility;
    }

    public final ValueInsets getStatusBarsIgnoringVisibility() {
        return this.statusBarsIgnoringVisibility;
    }

    public final ValueInsets getSystemBarsIgnoringVisibility() {
        return this.systemBarsIgnoringVisibility;
    }

    public final ValueInsets getTappableElementIgnoringVisibility() {
        return this.tappableElementIgnoringVisibility;
    }

    public final ValueInsets getImeAnimationTarget() {
        return this.imeAnimationTarget;
    }

    public final ValueInsets getImeAnimationSource() {
        return this.imeAnimationSource;
    }

    public final boolean getConsumes() {
        return this.consumes;
    }

    public final void incrementAccessors(View view) {
        if (this.accessCount == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, this.insetsListener);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener(this.insetsListener);
            ViewCompat.setWindowInsetsAnimationCallback(view, this.insetsListener);
        }
        this.accessCount++;
    }

    public final void decrementAccessors(View view) {
        int i = this.accessCount - 1;
        this.accessCount = i;
        if (i == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, (OnApplyWindowInsetsListener) null);
            ViewCompat.setWindowInsetsAnimationCallback(view, (WindowInsetsAnimationCompat.Callback) null);
            view.removeOnAttachStateChangeListener(this.insetsListener);
        }
    }

    public static /* synthetic */ void update$default(WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsetsCompat, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        windowInsetsHolder.update(windowInsetsCompat, i);
    }

    public final void update(WindowInsetsCompat windowInsetsCompat, int i) {
        if (testInsets) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            Intrinsics.checkNotNull(windowInsets);
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }
        this.captionBar.update$foundation_layout_release(windowInsetsCompat, i);
        this.ime.update$foundation_layout_release(windowInsetsCompat, i);
        this.displayCutout.update$foundation_layout_release(windowInsetsCompat, i);
        this.navigationBars.update$foundation_layout_release(windowInsetsCompat, i);
        this.statusBars.update$foundation_layout_release(windowInsetsCompat, i);
        this.systemBars.update$foundation_layout_release(windowInsetsCompat, i);
        this.systemGestures.update$foundation_layout_release(windowInsetsCompat, i);
        this.tappableElement.update$foundation_layout_release(windowInsetsCompat, i);
        this.mandatorySystemGestures.update$foundation_layout_release(windowInsetsCompat, i);
        if (i == 0) {
            this.captionBarIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar())));
            this.navigationBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())));
            this.statusBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())));
            this.systemBarsIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars())));
            this.tappableElementIgnoringVisibility.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement())));
            DisplayCutoutCompat displayCutout2 = windowInsetsCompat.getDisplayCutout();
            if (displayCutout2 != null) {
                this.waterfall.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(displayCutout2.getWaterfallInsets()));
            }
        }
        Snapshot.Companion.sendApplyNotifications();
    }

    public final void updateImeAnimationSource(WindowInsetsCompat windowInsetsCompat) {
        this.imeAnimationSource.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime())));
    }

    public final void updateImeAnimationTarget(WindowInsetsCompat windowInsetsCompat) {
        this.imeAnimationTarget.setValue$foundation_layout_release(WindowInsets_androidKt.toInsetsValues(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime())));
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder$Companion;", "", "()V", "testInsets", "", "viewMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "current", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsetsHolder;", "getOrCreateFor", "view", "setUseTestInsets", "", "systemInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "type", "", "name", "", "valueInsetsIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WindowInsets.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setUseTestInsets(boolean z) {
            WindowInsetsHolder.testInsets = z;
        }

        public final WindowInsetsHolder current(Composer composer, int i) {
            composer.startReplaceableGroup(-1366542614);
            ComposerKt.sourceInformation(composer, "C(current)627@22834L7,630@22901L186:WindowInsets.android.kt#2w3rfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1366542614, i, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:626)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(composer);
            View view = (View) consume;
            WindowInsetsHolder orCreateFor = getOrCreateFor(view);
            EffectsKt.DisposableEffect((Object) orCreateFor, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new WindowInsetsHolder$Companion$current$1(orCreateFor, view), composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return orCreateFor;
        }

        private final WindowInsetsHolder getOrCreateFor(View view) {
            WindowInsetsHolder windowInsetsHolder;
            synchronized (WindowInsetsHolder.viewMap) {
                Map access$getViewMap$cp = WindowInsetsHolder.viewMap;
                Object obj = access$getViewMap$cp.get(view);
                if (obj == null) {
                    obj = new WindowInsetsHolder((WindowInsetsCompat) null, view, (DefaultConstructorMarker) null);
                    access$getViewMap$cp.put(view, obj);
                }
                windowInsetsHolder = (WindowInsetsHolder) obj;
            }
            return windowInsetsHolder;
        }

        /* access modifiers changed from: private */
        public final AndroidWindowInsets systemInsets(WindowInsetsCompat windowInsetsCompat, int i, String str) {
            AndroidWindowInsets androidWindowInsets = new AndroidWindowInsets(i, str);
            if (windowInsetsCompat != null) {
                androidWindowInsets.update$foundation_layout_release(windowInsetsCompat, i);
            }
            return androidWindowInsets;
        }

        /* access modifiers changed from: private */
        public final ValueInsets valueInsetsIgnoringVisibility(WindowInsetsCompat windowInsetsCompat, int i, String str) {
            Insets insets;
            if (windowInsetsCompat == null || (insets = windowInsetsCompat.getInsetsIgnoringVisibility(i)) == null) {
                insets = Insets.NONE;
            }
            return WindowInsets_androidKt.ValueInsets(insets, str);
        }
    }
}
