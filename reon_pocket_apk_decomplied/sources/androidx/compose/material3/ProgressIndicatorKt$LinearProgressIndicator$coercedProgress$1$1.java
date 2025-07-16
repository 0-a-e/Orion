package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ Function0<Float> $progress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1(Function0<Float> function0) {
        super(0);
        this.$progress = function0;
    }

    public final Float invoke() {
        return Float.valueOf(RangesKt.coerceIn(this.$progress.invoke().floatValue(), 0.0f, 1.0f));
    }
}
