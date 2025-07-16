package androidx.compose.ui.graphics;

import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ColorSpaceVerificationHelper$$ExternalSyntheticLambda46 implements DoubleUnaryOperator {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ColorSpaceVerificationHelper$$ExternalSyntheticLambda46(Function1 function1) {
        this.f$0 = function1;
    }

    public final double applyAsDouble(double d) {
        return ColorSpaceVerificationHelper.androidColorSpace$lambda$1(this.f$0, d);
    }
}
