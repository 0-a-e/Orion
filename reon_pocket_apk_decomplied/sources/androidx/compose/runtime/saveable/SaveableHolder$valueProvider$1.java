package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class SaveableHolder$valueProvider$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ SaveableHolder<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveableHolder$valueProvider$1(SaveableHolder<T> saveableHolder) {
        super(0);
        this.this$0 = saveableHolder;
    }

    public final Object invoke() {
        Saver access$getSaver$p = this.this$0.saver;
        SaveableHolder<T> saveableHolder = this.this$0;
        SaverScope saverScope = saveableHolder;
        Object access$getValue$p = saveableHolder.value;
        if (access$getValue$p != null) {
            return access$getSaver$p.save(saverScope, access$getValue$p);
        }
        throw new IllegalArgumentException("Value should be initialized".toString());
    }
}
