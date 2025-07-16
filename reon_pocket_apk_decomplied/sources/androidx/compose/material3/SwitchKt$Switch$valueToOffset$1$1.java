package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "value", "", "invoke", "(Z)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$valueToOffset$1$1 extends Lambda implements Function1<Boolean, Float> {
    final /* synthetic */ float $maxBound;
    final /* synthetic */ float $minBound;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$valueToOffset$1$1(float f, float f2) {
        super(1);
        this.$maxBound = f;
        this.$minBound = f2;
    }

    public final Float invoke(boolean z) {
        return Float.valueOf(z ? this.$maxBound : this.$minBound);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }
}
