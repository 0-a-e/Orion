package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "", "zOrder", "", "constructor-impl", "(I)I", "getZOrder", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: AndroidExternalSurface.android.kt */
public final class AndroidExternalSurfaceZOrder {
    /* access modifiers changed from: private */
    public static final int Behind = m200constructorimpl(0);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int MediaOverlay = m200constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int OnTop = m200constructorimpl(2);
    private final int zOrder;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ AndroidExternalSurfaceZOrder m199boximpl(int i) {
        return new AndroidExternalSurfaceZOrder(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m200constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m201equalsimpl(int i, Object obj) {
        return (obj instanceof AndroidExternalSurfaceZOrder) && i == ((AndroidExternalSurfaceZOrder) obj).m205unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m202equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m203hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m204toStringimpl(int i) {
        return "AndroidExternalSurfaceZOrder(zOrder=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m201equalsimpl(this.zOrder, obj);
    }

    public int hashCode() {
        return m203hashCodeimpl(this.zOrder);
    }

    public String toString() {
        return m204toStringimpl(this.zOrder);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m205unboximpl() {
        return this.zOrder;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder$Companion;", "", "()V", "Behind", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "getBehind-B_4ceCc", "()I", "I", "MediaOverlay", "getMediaOverlay-B_4ceCc", "OnTop", "getOnTop-B_4ceCc", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidExternalSurface.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getBehind-B_4ceCc  reason: not valid java name */
        public final int m206getBehindB_4ceCc() {
            return AndroidExternalSurfaceZOrder.Behind;
        }

        /* renamed from: getMediaOverlay-B_4ceCc  reason: not valid java name */
        public final int m207getMediaOverlayB_4ceCc() {
            return AndroidExternalSurfaceZOrder.MediaOverlay;
        }

        /* renamed from: getOnTop-B_4ceCc  reason: not valid java name */
        public final int m208getOnTopB_4ceCc() {
            return AndroidExternalSurfaceZOrder.OnTop;
        }
    }

    private /* synthetic */ AndroidExternalSurfaceZOrder(int i) {
        this.zOrder = i;
    }

    public final int getZOrder() {
        return this.zOrder;
    }
}
