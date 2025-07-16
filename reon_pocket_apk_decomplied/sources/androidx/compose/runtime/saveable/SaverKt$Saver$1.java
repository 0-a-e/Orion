package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00018\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"androidx/compose/runtime/saveable/SaverKt$Saver$1", "Landroidx/compose/runtime/saveable/Saver;", "restore", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "(Landroidx/compose/runtime/saveable/SaverScope;Ljava/lang/Object;)Ljava/lang/Object;", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Saver.kt */
public final class SaverKt$Saver$1 implements Saver<Original, Saveable> {
    final /* synthetic */ Function1<Saveable, Original> $restore;
    final /* synthetic */ Function2<SaverScope, Original, Saveable> $save;

    SaverKt$Saver$1(Function2<? super SaverScope, ? super Original, ? extends Saveable> function2, Function1<? super Saveable, ? extends Original> function1) {
        this.$save = function2;
        this.$restore = function1;
    }

    public Saveable save(SaverScope saverScope, Original original) {
        return this.$save.invoke(saverScope, original);
    }

    public Original restore(Saveable saveable) {
        return this.$restore.invoke(saveable);
    }
}
