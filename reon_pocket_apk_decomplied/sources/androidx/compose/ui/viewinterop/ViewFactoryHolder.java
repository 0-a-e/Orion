package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004BI\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011BG\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0015J\b\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0019H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R<\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR<\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\"@BX\u000e¢\u0006\b\n\u0000\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010(R<\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u0014\u0010,\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "T", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "context", "Landroid/content/Context;", "factory", "Lkotlin/Function1;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "saveStateRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "compositeKeyHash", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/saveable/SaveableStateRegistry;ILandroidx/compose/ui/node/Owner;)V", "typedView", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroid/view/View;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/runtime/saveable/SaveableStateRegistry;ILandroidx/compose/ui/node/Owner;)V", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "value", "", "releaseBlock", "getReleaseBlock", "()Lkotlin/jvm/functions/Function1;", "setReleaseBlock", "(Lkotlin/jvm/functions/Function1;)V", "resetBlock", "getResetBlock", "setResetBlock", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "savableRegistryEntry", "setSavableRegistryEntry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;)V", "saveStateKey", "", "Landroid/view/View;", "updateBlock", "getUpdateBlock", "setUpdateBlock", "viewRoot", "getViewRoot", "()Landroid/view/View;", "registerSaveStateProvider", "unregisterSaveStateProvider", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {
    public static final int $stable = 8;
    private final int compositeKeyHash;
    private final NestedScrollDispatcher dispatcher;
    private Function1<? super T, Unit> releaseBlock;
    private Function1<? super T, Unit> resetBlock;
    private SaveableStateRegistry.Entry savableRegistryEntry;
    private final String saveStateKey;
    private final SaveableStateRegistry saveStateRegistry;
    /* access modifiers changed from: private */
    public final T typedView;
    private Function1<? super T, Unit> updateBlock;

    public /* synthetic */ AbstractComposeView getSubCompositionView() {
        return ViewRootForInspector.CC.$default$getSubCompositionView(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ ViewFactoryHolder(Context context, CompositionContext compositionContext, View view, NestedScrollDispatcher nestedScrollDispatcher, SaveableStateRegistry saveableStateRegistry, int i, Owner owner, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : compositionContext, view, (i2 & 8) != 0 ? new NestedScrollDispatcher() : nestedScrollDispatcher, saveableStateRegistry, i, owner);
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    private ViewFactoryHolder(Context context, CompositionContext compositionContext, T t, NestedScrollDispatcher nestedScrollDispatcher, SaveableStateRegistry saveableStateRegistry, int i, Owner owner) {
        super(context, compositionContext, i, nestedScrollDispatcher, t, owner);
        this.typedView = t;
        this.dispatcher = nestedScrollDispatcher;
        this.saveStateRegistry = saveableStateRegistry;
        this.compositeKeyHash = i;
        setClipChildren(false);
        String valueOf = String.valueOf(i);
        this.saveStateKey = valueOf;
        SparseArray sparseArray = null;
        Object consumeRestored = saveableStateRegistry != null ? saveableStateRegistry.consumeRestored(valueOf) : null;
        sparseArray = consumeRestored instanceof SparseArray ? (SparseArray) consumeRestored : sparseArray;
        if (sparseArray != null) {
            t.restoreHierarchyState(sparseArray);
        }
        registerSaveStateProvider();
        this.updateBlock = AndroidView_androidKt.getNoOpUpdate();
        this.resetBlock = AndroidView_androidKt.getNoOpUpdate();
        this.releaseBlock = AndroidView_androidKt.getNoOpUpdate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewFactoryHolder(Context context, Function1 function1, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i, Owner owner, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, function1, (i2 & 4) != 0 ? null : compositionContext, saveableStateRegistry, i, owner);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder(Context context, Function1<? super Context, ? extends T> function1, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i, Owner owner) {
        this(context, compositionContext, (View) function1.invoke(context), (NestedScrollDispatcher) null, saveableStateRegistry, i, owner, 8, (DefaultConstructorMarker) null);
        Function1<? super Context, ? extends T> function12 = function1;
    }

    public View getViewRoot() {
        return this;
    }

    private final void setSavableRegistryEntry(SaveableStateRegistry.Entry entry) {
        SaveableStateRegistry.Entry entry2 = this.savableRegistryEntry;
        if (entry2 != null) {
            entry2.unregister();
        }
        this.savableRegistryEntry = entry;
    }

    public final Function1<T, Unit> getUpdateBlock() {
        return this.updateBlock;
    }

    public final void setUpdateBlock(Function1<? super T, Unit> function1) {
        this.updateBlock = function1;
        setUpdate(new ViewFactoryHolder$updateBlock$1(this));
    }

    public final Function1<T, Unit> getResetBlock() {
        return this.resetBlock;
    }

    public final void setResetBlock(Function1<? super T, Unit> function1) {
        this.resetBlock = function1;
        setReset(new ViewFactoryHolder$resetBlock$1(this));
    }

    public final Function1<T, Unit> getReleaseBlock() {
        return this.releaseBlock;
    }

    public final void setReleaseBlock(Function1<? super T, Unit> function1) {
        this.releaseBlock = function1;
        setRelease(new ViewFactoryHolder$releaseBlock$1(this));
    }

    private final void registerSaveStateProvider() {
        SaveableStateRegistry saveableStateRegistry = this.saveStateRegistry;
        if (saveableStateRegistry != null) {
            setSavableRegistryEntry(saveableStateRegistry.registerProvider(this.saveStateKey, new ViewFactoryHolder$registerSaveStateProvider$1(this)));
        }
    }

    /* access modifiers changed from: private */
    public final void unregisterSaveStateProvider() {
        setSavableRegistryEntry((SaveableStateRegistry.Entry) null);
    }
}
