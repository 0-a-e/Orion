package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$performRecompose$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ControlledComposition $composition;
    final /* synthetic */ IdentityArraySet<Object> $modifiedValues;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$performRecompose$1$1(IdentityArraySet<Object> identityArraySet, ControlledComposition controlledComposition) {
        super(0);
        this.$modifiedValues = identityArraySet;
        this.$composition = controlledComposition;
    }

    public final void invoke() {
        IdentityArraySet<Object> identityArraySet = this.$modifiedValues;
        ControlledComposition controlledComposition = this.$composition;
        Object[] values = identityArraySet.getValues();
        int size = identityArraySet.size();
        for (int i = 0; i < size; i++) {
            Object obj = values[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            controlledComposition.recordWriteOf(obj);
        }
    }
}
