package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0000H\fø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\f¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0001\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/NodeKind;", "T", "", "mask", "", "constructor-impl", "(I)I", "getMask", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "or", "or-H91voCI", "(II)I", "or-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: NodeKind.kt */
public final class NodeKind<T> {
    private final int mask;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NodeKind m5646boximpl(int i) {
        return new NodeKind(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> int m5647constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5648equalsimpl(int i, Object obj) {
        return (obj instanceof NodeKind) && i == ((NodeKind) obj).m5654unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5649equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5650hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: or-H91voCI  reason: not valid java name */
    public static final int m5651orH91voCI(int i, int i2) {
        return i | i2;
    }

    /* renamed from: or-impl  reason: not valid java name */
    public static final int m5652orimpl(int i, int i2) {
        return i | i2;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5653toStringimpl(int i) {
        return "NodeKind(mask=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m5648equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m5650hashCodeimpl(this.mask);
    }

    public String toString() {
        return m5653toStringimpl(this.mask);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5654unboximpl() {
        return this.mask;
    }

    private /* synthetic */ NodeKind(int i) {
        this.mask = i;
    }

    public final int getMask() {
        return this.mask;
    }
}
