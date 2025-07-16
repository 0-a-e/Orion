package androidx.compose.runtime.saveable;

import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003BE\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u00018\u00002\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0002JK\u0010\u001e\u001a\u00020\u001a2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\rX\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00028\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableHolder;", "T", "Landroidx/compose/runtime/saveable/SaverScope;", "Landroidx/compose/runtime/RememberObserver;", "saver", "Landroidx/compose/runtime/saveable/Saver;", "", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "key", "", "value", "inputs", "", "(Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "entry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "[Ljava/lang/Object;", "Ljava/lang/Object;", "valueProvider", "Lkotlin/Function0;", "canBeSaved", "", "getValueIfInputsDidntChange", "([Ljava/lang/Object;)Ljava/lang/Object;", "onAbandoned", "", "onForgotten", "onRemembered", "register", "update", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class SaveableHolder<T> implements SaverScope, RememberObserver {
    private SaveableStateRegistry.Entry entry;
    private Object[] inputs;
    private String key;
    private SaveableStateRegistry registry;
    /* access modifiers changed from: private */
    public Saver<T, Object> saver;
    /* access modifiers changed from: private */
    public T value;
    private final Function0<Object> valueProvider = new SaveableHolder$valueProvider$1(this);

    public SaveableHolder(Saver<T, Object> saver2, SaveableStateRegistry saveableStateRegistry, String str, T t, Object[] objArr) {
        this.saver = saver2;
        this.registry = saveableStateRegistry;
        this.key = str;
        this.value = t;
        this.inputs = objArr;
    }

    public final void update(Saver<T, Object> saver2, SaveableStateRegistry saveableStateRegistry, String str, T t, Object[] objArr) {
        boolean z;
        boolean z2 = true;
        if (this.registry != saveableStateRegistry) {
            this.registry = saveableStateRegistry;
            z = true;
        } else {
            z = false;
        }
        if (!Intrinsics.areEqual((Object) this.key, (Object) str)) {
            this.key = str;
        } else {
            z2 = z;
        }
        this.saver = saver2;
        this.value = t;
        this.inputs = objArr;
        SaveableStateRegistry.Entry entry2 = this.entry;
        if (entry2 != null && z2) {
            if (entry2 != null) {
                entry2.unregister();
            }
            this.entry = null;
            register();
        }
    }

    private final void register() {
        SaveableStateRegistry saveableStateRegistry = this.registry;
        if (this.entry != null) {
            throw new IllegalArgumentException(("entry(" + this.entry + ") is not null").toString());
        } else if (saveableStateRegistry != null) {
            RememberSaveableKt.requireCanBeSaved(saveableStateRegistry, this.valueProvider.invoke());
            this.entry = saveableStateRegistry.registerProvider(this.key, this.valueProvider);
        }
    }

    public boolean canBeSaved(Object obj) {
        SaveableStateRegistry saveableStateRegistry = this.registry;
        return saveableStateRegistry == null || saveableStateRegistry.canBeSaved(obj);
    }

    public void onRemembered() {
        register();
    }

    public void onForgotten() {
        SaveableStateRegistry.Entry entry2 = this.entry;
        if (entry2 != null) {
            entry2.unregister();
        }
    }

    public void onAbandoned() {
        SaveableStateRegistry.Entry entry2 = this.entry;
        if (entry2 != null) {
            entry2.unregister();
        }
    }

    public final T getValueIfInputsDidntChange(Object[] objArr) {
        if (Arrays.equals(objArr, this.inputs)) {
            return this.value;
        }
        return null;
    }
}
