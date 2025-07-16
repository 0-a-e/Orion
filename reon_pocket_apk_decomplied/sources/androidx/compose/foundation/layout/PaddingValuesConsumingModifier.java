package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesConsumingModifier;", "Landroidx/compose/foundation/layout/InsetsConsumingModifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "calculateInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifierLocalInsets", "equals", "", "other", "", "hashCode", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.kt */
final class PaddingValuesConsumingModifier extends InsetsConsumingModifier {
    private final PaddingValues paddingValues;

    public PaddingValuesConsumingModifier(PaddingValues paddingValues2) {
        super((DefaultConstructorMarker) null);
        this.paddingValues = paddingValues2;
    }

    public WindowInsets calculateInsets(WindowInsets windowInsets) {
        return WindowInsetsKt.add(WindowInsetsKt.asInsets(this.paddingValues), windowInsets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingValuesConsumingModifier)) {
            return false;
        }
        return Intrinsics.areEqual((Object) ((PaddingValuesConsumingModifier) obj).paddingValues, (Object) this.paddingValues);
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }
}
