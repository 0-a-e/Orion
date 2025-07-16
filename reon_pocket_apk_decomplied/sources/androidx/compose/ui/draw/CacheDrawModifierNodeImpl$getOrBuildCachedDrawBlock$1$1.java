package androidx.compose.ui.draw;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
final class CacheDrawModifierNodeImpl$getOrBuildCachedDrawBlock$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CacheDrawScope $this_apply;
    final /* synthetic */ CacheDrawModifierNodeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CacheDrawModifierNodeImpl$getOrBuildCachedDrawBlock$1$1(CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl, CacheDrawScope cacheDrawScope) {
        super(0);
        this.this$0 = cacheDrawModifierNodeImpl;
        this.$this_apply = cacheDrawScope;
    }

    public final void invoke() {
        this.this$0.getBlock().invoke(this.$this_apply);
    }
}
