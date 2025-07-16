package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u000fB\u001b\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "T", "Landroidx/compose/runtime/SnapshotMutableStateImpl;", "Landroid/os/Parcelable;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParcelableSnapshotMutableState.android.kt */
public final class ParcelableSnapshotMutableState<T> extends SnapshotMutableStateImpl<T> implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<ParcelableSnapshotMutableState<Object>> CREATOR = new ParcelableSnapshotMutableState$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int PolicyNeverEquals = 0;
    private static final int PolicyReferentialEquality = 2;
    private static final int PolicyStructuralEquality = 1;

    public int describeContents() {
        return 0;
    }

    public ParcelableSnapshotMutableState(T t, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        super(t, snapshotMutationPolicy);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeValue(getValue());
        SnapshotMutationPolicy policy = getPolicy();
        if (Intrinsics.areEqual((Object) policy, (Object) SnapshotStateKt.neverEqualPolicy())) {
            i2 = 0;
        } else if (Intrinsics.areEqual((Object) policy, (Object) SnapshotStateKt.structuralEqualityPolicy())) {
            i2 = 1;
        } else if (Intrinsics.areEqual((Object) policy, (Object) SnapshotStateKt.referentialEqualityPolicy())) {
            i2 = 2;
        } else {
            throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
        }
        parcel.writeInt(i2);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00048\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "getCREATOR$annotations", "PolicyNeverEquals", "", "PolicyReferentialEquality", "PolicyStructuralEquality", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ParcelableSnapshotMutableState.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }

        private Companion() {
        }
    }
}
