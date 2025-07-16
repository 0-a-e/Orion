package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class RememberSaveableKt$rememberSaveable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $finalKey;
    final /* synthetic */ SaveableHolder<T> $holder;
    final /* synthetic */ Object[] $inputs;
    final /* synthetic */ SaveableStateRegistry $registry;
    final /* synthetic */ Saver<T, ? extends Object> $saver;
    final /* synthetic */ T $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RememberSaveableKt$rememberSaveable$1(SaveableHolder<T> saveableHolder, Saver<T, ? extends Object> saver, SaveableStateRegistry saveableStateRegistry, String str, T t, Object[] objArr) {
        super(0);
        this.$holder = saveableHolder;
        this.$saver = saver;
        this.$registry = saveableStateRegistry;
        this.$finalKey = str;
        this.$value = t;
        this.$inputs = objArr;
    }

    public final void invoke() {
        this.$holder.update(this.$saver, this.$registry, this.$finalKey, this.$value, this.$inputs);
    }
}
