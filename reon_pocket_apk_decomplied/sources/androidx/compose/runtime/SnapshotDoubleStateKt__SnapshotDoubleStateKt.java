package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\n¨\u0006\f"}, d2 = {"mutableDoubleStateOf", "Landroidx/compose/runtime/MutableDoubleState;", "value", "", "getValue", "Landroidx/compose/runtime/DoubleState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotDoubleStateKt")
/* compiled from: SnapshotDoubleState.kt */
final /* synthetic */ class SnapshotDoubleStateKt__SnapshotDoubleStateKt {
    public static final MutableDoubleState mutableDoubleStateOf(double d) {
        return ActualAndroid_androidKt.createSnapshotMutableDoubleState(d);
    }

    public static final double getValue(DoubleState doubleState, Object obj, KProperty<?> kProperty) {
        return doubleState.getDoubleValue();
    }

    public static final void setValue(MutableDoubleState mutableDoubleState, Object obj, KProperty<?> kProperty, double d) {
        mutableDoubleState.setDoubleValue(d);
    }
}
