package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableIntState;", "Landroidx/compose/runtime/SnapshotMutableIntStateImpl;", "Landroid/os/Parcelable;", "value", "", "(I)V", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ParcelableSnapshotMutableIntState.android.kt */
public final class ParcelableSnapshotMutableIntState extends SnapshotMutableIntStateImpl implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<ParcelableSnapshotMutableIntState> CREATOR = new ParcelableSnapshotMutableIntState$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public int describeContents() {
        return 0;
    }

    public ParcelableSnapshotMutableIntState(int i) {
        super(i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getIntValue());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableIntState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableIntState;", "getCREATOR$annotations", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ParcelableSnapshotMutableIntState.android.kt */
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
