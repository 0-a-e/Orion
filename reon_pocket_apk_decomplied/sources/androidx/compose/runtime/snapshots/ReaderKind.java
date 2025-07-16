package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/snapshots/ReaderKind;", "", "mask", "", "constructor-impl", "(I)I", "getMask", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isReadIn", "reader", "isReadIn-h_f27i8", "(II)Z", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "withReadIn", "withReadIn-3QSx2Dw", "(II)I", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: StateObjectImpl.kt */
public final class ReaderKind {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int mask;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ReaderKind m3401boximpl(int i) {
        return new ReaderKind(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3402constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3404equalsimpl(int i, Object obj) {
        return (obj instanceof ReaderKind) && i == ((ReaderKind) obj).m3410unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3405equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3406hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: isReadIn-h_f27i8  reason: not valid java name */
    public static final boolean m3407isReadInh_f27i8(int i, int i2) {
        return (i & i2) != 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3408toStringimpl(int i) {
        return "ReaderKind(mask=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m3404equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m3406hashCodeimpl(this.mask);
    }

    public String toString() {
        return m3408toStringimpl(this.mask);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3410unboximpl() {
        return this.mask;
    }

    private /* synthetic */ ReaderKind(int i) {
        this.mask = i;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ int m3403constructorimpl$default(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m3402constructorimpl(i);
    }

    public final int getMask() {
        return this.mask;
    }

    /* renamed from: withReadIn-3QSx2Dw  reason: not valid java name */
    public static final int m3409withReadIn3QSx2Dw(int i, int i2) {
        return m3402constructorimpl(i | i2);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/snapshots/ReaderKind$Companion;", "", "()V", "Composition", "Landroidx/compose/runtime/snapshots/ReaderKind;", "getComposition-6f8NoZ8", "()I", "SnapshotFlow", "getSnapshotFlow-6f8NoZ8", "SnapshotStateObserver", "getSnapshotStateObserver-6f8NoZ8", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: StateObjectImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getComposition-6f8NoZ8  reason: not valid java name */
        public final int m3411getComposition6f8NoZ8() {
            return ReaderKind.m3402constructorimpl(1);
        }

        /* renamed from: getSnapshotStateObserver-6f8NoZ8  reason: not valid java name */
        public final int m3413getSnapshotStateObserver6f8NoZ8() {
            return ReaderKind.m3402constructorimpl(2);
        }

        /* renamed from: getSnapshotFlow-6f8NoZ8  reason: not valid java name */
        public final int m3412getSnapshotFlow6f8NoZ8() {
            return ReaderKind.m3402constructorimpl(4);
        }
    }
}
