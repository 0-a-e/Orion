package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "nc", "Landroidx/compose/runtime/Composer;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposableLambdaN.jvm.kt */
final class ComposableLambdaNImpl$invoke$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Object[] $args;
    final /* synthetic */ int $realParams;
    final /* synthetic */ ComposableLambdaNImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposableLambdaNImpl$invoke$1(Object[] objArr, int i, ComposableLambdaNImpl composableLambdaNImpl) {
        super(2);
        this.$args = objArr;
        this.$realParams = i;
        this.this$0 = composableLambdaNImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Object[] array = ArraysKt.slice((T[]) this.$args, RangesKt.until(0, this.$realParams)).toArray(new Object[0]);
        Object obj = this.$args[this.$realParams + 1];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int updateChangedFlags = RecomposeScopeImplKt.updateChangedFlags(((Integer) obj).intValue());
        int length = (this.$args.length - this.$realParams) - 2;
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj2 = this.$args[this.$realParams + 2 + i2];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            objArr[i2] = Integer.valueOf(RecomposeScopeImplKt.updateChangedFlags(((Integer) obj2).intValue()));
        }
        ComposableLambdaNImpl composableLambdaNImpl = this.this$0;
        SpreadBuilder spreadBuilder = new SpreadBuilder(4);
        spreadBuilder.addSpread(array);
        spreadBuilder.add(composer);
        spreadBuilder.add(Integer.valueOf(updateChangedFlags | 1));
        spreadBuilder.addSpread(objArr);
        composableLambdaNImpl.invoke(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
    }
}
