package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/FabPosition;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: Scaffold.kt */
public final class FabPosition {
    /* access modifiers changed from: private */
    public static final int Center = m1855constructorimpl(1);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int End = m1855constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int EndOverlay = m1855constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Start = m1855constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FabPosition m1854boximpl(int i) {
        return new FabPosition(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1855constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1856equalsimpl(int i, Object obj) {
        return (obj instanceof FabPosition) && i == ((FabPosition) obj).m1860unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1857equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1858hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1856equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1858hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1860unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/FabPosition$Companion;", "", "()V", "Center", "Landroidx/compose/material3/FabPosition;", "getCenter-ERTFSPs", "()I", "I", "End", "getEnd-ERTFSPs", "EndOverlay", "getEndOverlay-ERTFSPs", "Start", "getStart-ERTFSPs", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Scaffold.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getStart-ERTFSPs  reason: not valid java name */
        public final int m1864getStartERTFSPs() {
            return FabPosition.Start;
        }

        /* renamed from: getCenter-ERTFSPs  reason: not valid java name */
        public final int m1861getCenterERTFSPs() {
            return FabPosition.Center;
        }

        /* renamed from: getEnd-ERTFSPs  reason: not valid java name */
        public final int m1862getEndERTFSPs() {
            return FabPosition.End;
        }

        /* renamed from: getEndOverlay-ERTFSPs  reason: not valid java name */
        public final int m1863getEndOverlayERTFSPs() {
            return FabPosition.EndOverlay;
        }
    }

    private /* synthetic */ FabPosition(int i) {
        this.value = i;
    }

    public String toString() {
        return m1859toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1859toStringimpl(int i) {
        if (m1857equalsimpl0(i, Start)) {
            return "FabPosition.Start";
        }
        if (m1857equalsimpl0(i, Center)) {
            return "FabPosition.Center";
        }
        if (m1857equalsimpl0(i, End)) {
            return "FabPosition.End";
        }
        return "FabPosition.EndOverlay";
    }
}
