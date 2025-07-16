package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "", "state", "Landroidx/compose/runtime/MutableState;", "", "constructor-impl", "(Landroidx/compose/runtime/MutableState;)Landroidx/compose/runtime/MutableState;", "attachToScope", "attachToScope-impl", "(Landroidx/compose/runtime/MutableState;)V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/MutableState;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/MutableState;)I", "invalidateScope", "invalidateScope-impl", "toString", "", "toString-impl", "(Landroidx/compose/runtime/MutableState;)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: ObservableScopeInvalidator.kt */
public final class ObservableScopeInvalidator {
    private final MutableState<Unit> state;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ObservableScopeInvalidator m906boximpl(MutableState mutableState) {
        return new ObservableScopeInvalidator(mutableState);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static MutableState<Unit> m907constructorimpl(MutableState<Unit> mutableState) {
        return mutableState;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m909equalsimpl(MutableState<Unit> mutableState, Object obj) {
        return (obj instanceof ObservableScopeInvalidator) && Intrinsics.areEqual((Object) mutableState, (Object) ((ObservableScopeInvalidator) obj).m914unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m910equalsimpl0(MutableState<Unit> mutableState, MutableState<Unit> mutableState2) {
        return Intrinsics.areEqual((Object) mutableState, (Object) mutableState2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m911hashCodeimpl(MutableState<Unit> mutableState) {
        return mutableState.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m913toStringimpl(MutableState<Unit> mutableState) {
        return "ObservableScopeInvalidator(state=" + mutableState + ')';
    }

    public boolean equals(Object obj) {
        return m909equalsimpl(this.state, obj);
    }

    public int hashCode() {
        return m911hashCodeimpl(this.state);
    }

    public String toString() {
        return m913toStringimpl(this.state);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ MutableState m914unboximpl() {
        return this.state;
    }

    private /* synthetic */ ObservableScopeInvalidator(MutableState mutableState) {
        this.state = mutableState;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ MutableState m908constructorimpl$default(MutableState mutableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            mutableState = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        }
        return m907constructorimpl(mutableState);
    }

    /* renamed from: attachToScope-impl  reason: not valid java name */
    public static final void m905attachToScopeimpl(MutableState<Unit> mutableState) {
        mutableState.getValue();
    }

    /* renamed from: invalidateScope-impl  reason: not valid java name */
    public static final void m912invalidateScopeimpl(MutableState<Unit> mutableState) {
        mutableState.setValue(Unit.INSTANCE);
    }
}
