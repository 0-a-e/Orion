package androidx.compose.material3;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"androidx/compose/material3/ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "isListeningToGlobalLayout", "", "dispose", "", "onGlobalLayout", "onViewAttachedToWindow", "p0", "Landroid/view/View;", "onViewDetachedFromWindow", "registerOnGlobalLayoutListener", "unregisterOnGlobalLayoutListener", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
public final class ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ Function0<Unit> $onKeyboardVisibilityChange;
    final /* synthetic */ View $view;
    private boolean isListeningToGlobalLayout;

    ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(View view, Function0<Unit> function0) {
        this.$view = view;
        this.$onKeyboardVisibilityChange = function0;
        view.addOnAttachStateChangeListener(this);
        registerOnGlobalLayoutListener();
    }

    public void onViewAttachedToWindow(View view) {
        registerOnGlobalLayoutListener();
    }

    public void onViewDetachedFromWindow(View view) {
        unregisterOnGlobalLayoutListener();
    }

    public void onGlobalLayout() {
        this.$onKeyboardVisibilityChange.invoke();
    }

    private final void registerOnGlobalLayoutListener() {
        if (!this.isListeningToGlobalLayout && this.$view.isAttachedToWindow()) {
            this.$view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.isListeningToGlobalLayout = true;
        }
    }

    private final void unregisterOnGlobalLayoutListener() {
        if (this.isListeningToGlobalLayout) {
            this.$view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.isListeningToGlobalLayout = false;
        }
    }

    public final void dispose() {
        unregisterOnGlobalLayoutListener();
        this.$view.removeOnAttachStateChangeListener(this);
    }
}
