package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*R+\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0006R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/InsetsPaddingModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "<set-?>", "consumedInsets", "getConsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setConsumedInsets", "consumedInsets$delegate", "Landroidx/compose/runtime/MutableState;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "unconsumedInsets", "getUnconsumedInsets", "setUnconsumedInsets", "unconsumedInsets$delegate", "value", "getValue", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.kt */
public final class InsetsPaddingModifier implements LayoutModifier, ModifierLocalConsumer, ModifierLocalProvider<WindowInsets> {
    public static final int $stable = 0;
    private final MutableState consumedInsets$delegate;
    private final WindowInsets insets;
    private final MutableState unconsumedInsets$delegate;

    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public InsetsPaddingModifier(WindowInsets windowInsets) {
        this.insets = windowInsets;
        this.unconsumedInsets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInsets, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.consumedInsets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInsets, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final WindowInsets getUnconsumedInsets() {
        return (WindowInsets) this.unconsumedInsets$delegate.getValue();
    }

    private final void setUnconsumedInsets(WindowInsets windowInsets) {
        this.unconsumedInsets$delegate.setValue(windowInsets);
    }

    private final WindowInsets getConsumedInsets() {
        return (WindowInsets) this.consumedInsets$delegate.getValue();
    }

    private final void setConsumedInsets(WindowInsets windowInsets) {
        this.consumedInsets$delegate.setValue(windowInsets);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m614measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Density density = measureScope;
        int left = getUnconsumedInsets().getLeft(density, measureScope.getLayoutDirection());
        int top = getUnconsumedInsets().getTop(density);
        int right = getUnconsumedInsets().getRight(density, measureScope.getLayoutDirection()) + left;
        int bottom = getUnconsumedInsets().getBottom(density) + top;
        Placeable r6 = measurable.m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(j, -right, -bottom));
        int r5 = ConstraintsKt.m6540constrainWidthK40F9xA(j, r6.getWidth() + right);
        int r0 = ConstraintsKt.m6539constrainHeightK40F9xA(j, r6.getHeight() + bottom);
        return MeasureScope.CC.layout$default(measureScope, r5, r0, (Map) null, new InsetsPaddingModifier$measure$1(r6, left, top), 4, (Object) null);
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        WindowInsets windowInsets = (WindowInsets) modifierLocalReadScope.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        setUnconsumedInsets(WindowInsetsKt.exclude(this.insets, windowInsets));
        setConsumedInsets(WindowInsetsKt.union(windowInsets, this.insets));
    }

    public ProvidableModifierLocal<WindowInsets> getKey() {
        return WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
    }

    public WindowInsets getValue() {
        return getConsumedInsets();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsPaddingModifier)) {
            return false;
        }
        return Intrinsics.areEqual((Object) ((InsetsPaddingModifier) obj).insets, (Object) this.insets);
    }

    public int hashCode() {
        return this.insets.hashCode();
    }
}
