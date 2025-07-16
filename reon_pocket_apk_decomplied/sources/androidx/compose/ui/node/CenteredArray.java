package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0014\u0010\tJ \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0001\u0002\u0001\u00020\u0003¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/node/CenteredArray;", "", "data", "", "constructor-impl", "([I)[I", "mid", "", "getMid-impl", "([I)I", "equals", "", "other", "equals-impl", "([ILjava/lang/Object;)Z", "get", "index", "get-impl", "([II)I", "hashCode", "hashCode-impl", "set", "", "value", "set-impl", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: MyersDiff.kt */
final class CenteredArray {
    private final int[] data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CenteredArray m5454boximpl(int[] iArr) {
        return new CenteredArray(iArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m5455constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5456equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof CenteredArray) && Intrinsics.areEqual((Object) iArr, (Object) ((CenteredArray) obj).m5463unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5457equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual((Object) iArr, (Object) iArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5460hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5462toStringimpl(int[] iArr) {
        return "CenteredArray(data=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m5456equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5460hashCodeimpl(this.data);
    }

    public String toString() {
        return m5462toStringimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int[] m5463unboximpl() {
        return this.data;
    }

    private /* synthetic */ CenteredArray(int[] iArr) {
        this.data = iArr;
    }

    /* renamed from: getMid-impl  reason: not valid java name */
    private static final int m5459getMidimpl(int[] iArr) {
        return iArr.length / 2;
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final int m5458getimpl(int[] iArr, int i) {
        return iArr[i + m5459getMidimpl(iArr)];
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m5461setimpl(int[] iArr, int i, int i2) {
        iArr[i + m5459getMidimpl(iArr)] = i2;
    }
}
