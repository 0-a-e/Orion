package androidx.compose.ui.window;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.platform.AbstractComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010#\u001a\u00020\nH\u0017¢\u0006\u0002\u0010$J5\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0010¢\u0006\u0002\b+J\u001d\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014H\u0010¢\u0006\u0002\b/J&\u0010\u000f\u001a\u00020\n2\u0006\u00100\u001a\u0002012\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b¢\u0006\u0002\u00102RA\u0010\f\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b2\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0019@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Landroidx/compose/ui/window/DialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "(Landroid/content/Context;Landroid/view/Window;)V", "<set-?>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "displayHeight", "", "getDisplayHeight", "()I", "displayWidth", "getDisplayWidth", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "usePlatformDefaultWidth", "getUsePlatformDefaultWidth", "setUsePlatformDefaultWidth", "(Z)V", "getWindow", "()Landroid/view/Window;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class DialogLayout extends AbstractComposeView implements DialogWindowProvider {
    private final MutableState content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidDialog_androidKt.INSTANCE.m6880getLambda1$ui_release(), (SnapshotMutationPolicy) null, 2, (Object) null);
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private boolean usePlatformDefaultWidth;
    private final Window window;

    public Window getWindow() {
        return this.window;
    }

    public DialogLayout(Context context, Window window2) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.window = window2;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public final void setUsePlatformDefaultWidth(boolean z) {
        this.usePlatformDefaultWidth = z;
    }

    /* access modifiers changed from: protected */
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void setContent(CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        createComposition();
    }

    public void internalOnMeasure$ui_release(int i, int i2) {
        if (this.usePlatformDefaultWidth) {
            super.internalOnMeasure$ui_release(i, i2);
        } else {
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(getDisplayWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getDisplayHeight(), Integer.MIN_VALUE));
        }
    }

    public void internalOnLayout$ui_release(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        super.internalOnLayout$ui_release(z, i, i2, i3, i4);
        if (!this.usePlatformDefaultWidth && (childAt = getChildAt(0)) != null) {
            getWindow().setLayout(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        }
    }

    private final int getDisplayWidth() {
        return MathKt.roundToInt(((float) getContext().getResources().getConfiguration().screenWidthDp) * getContext().getResources().getDisplayMetrics().density);
    }

    private final int getDisplayHeight() {
        return MathKt.roundToInt(((float) getContext().getResources().getConfiguration().screenHeightDp) * getContext().getResources().getDisplayMetrics().density);
    }

    public void Content(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1735448596);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)269@10475L9:AndroidDialog.android.kt#2oxthz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1735448596, i, -1, "androidx.compose.ui.window.DialogLayout.Content (AndroidDialog.android.kt:268)");
        }
        getContent().invoke(startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogLayout$Content$4(this, i));
        }
    }
}
