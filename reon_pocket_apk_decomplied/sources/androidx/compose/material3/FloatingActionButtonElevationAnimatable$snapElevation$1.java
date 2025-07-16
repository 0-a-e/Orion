package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.FloatingActionButtonElevationAnimatable", f = "FloatingActionButton.kt", i = {0}, l = {609}, m = "snapElevation", n = {"this"}, s = {"L$0"})
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonElevationAnimatable$snapElevation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FloatingActionButtonElevationAnimatable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonElevationAnimatable$snapElevation$1(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Continuation<? super FloatingActionButtonElevationAnimatable$snapElevation$1> continuation) {
        super(continuation);
        this.this$0 = floatingActionButtonElevationAnimatable;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.snapElevation(this);
    }
}
