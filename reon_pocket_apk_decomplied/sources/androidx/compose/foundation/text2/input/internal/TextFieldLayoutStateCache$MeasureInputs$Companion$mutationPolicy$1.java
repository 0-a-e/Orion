package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.internal.TextFieldLayoutStateCache;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/foundation/text2/input/internal/TextFieldLayoutStateCache$MeasureInputs$Companion$mutationPolicy$1", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/foundation/text2/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "equivalent", "", "a", "b", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldLayoutStateCache.kt */
public final class TextFieldLayoutStateCache$MeasureInputs$Companion$mutationPolicy$1 implements SnapshotMutationPolicy<TextFieldLayoutStateCache.MeasureInputs> {
    public /* synthetic */ Object merge(Object obj, Object obj2, Object obj3) {
        return SnapshotMutationPolicy.CC.$default$merge(this, obj, obj2, obj3);
    }

    TextFieldLayoutStateCache$MeasureInputs$Companion$mutationPolicy$1() {
    }

    public boolean equivalent(TextFieldLayoutStateCache.MeasureInputs measureInputs, TextFieldLayoutStateCache.MeasureInputs measureInputs2) {
        if (measureInputs == null || measureInputs2 == null) {
            if (!((measureInputs == null) ^ (measureInputs2 == null))) {
                return true;
            }
        } else if (measureInputs.getDensityValue() == measureInputs2.getDensityValue() && measureInputs.getFontScale() == measureInputs2.getFontScale() && measureInputs.getLayoutDirection() == measureInputs2.getLayoutDirection() && Intrinsics.areEqual((Object) measureInputs.getFontFamilyResolver(), (Object) measureInputs2.getFontFamilyResolver()) && Constraints.m6519equalsimpl0(measureInputs.m1407getConstraintsmsEJaDk(), measureInputs2.m1407getConstraintsmsEJaDk())) {
            return true;
        }
        return false;
    }
}
