package androidx.compose.ui.graphics;

import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ColorSpaceVerificationHelper$$ExternalSyntheticLambda45 implements DoubleUnaryOperator {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ColorSpaceVerificationHelper$$ExternalSyntheticLambda45(Function1 function1) {
        this.f$0 = function1;
    }

    public final double applyAsDouble(double d) {
        return ColorSpaceVerificationHelper.androidColorSpace$lambda$0(this.f$0, d);
    }
}
