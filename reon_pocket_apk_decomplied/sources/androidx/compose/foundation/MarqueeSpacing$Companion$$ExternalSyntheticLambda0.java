package androidx.compose.foundation;

import androidx.compose.foundation.MarqueeSpacing;
import androidx.compose.ui.unit.Density;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MarqueeSpacing$Companion$$ExternalSyntheticLambda0 implements MarqueeSpacing {
    public final /* synthetic */ float f$0;

    public /* synthetic */ MarqueeSpacing$Companion$$ExternalSyntheticLambda0(float f) {
        this.f$0 = f;
    }

    public final int calculateSpacing(Density density, int i, int i2) {
        return MarqueeSpacing.Companion.fractionOfContainer$lambda$0(this.f$0, density, i, i2);
    }
}
