package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/unit/TextUnitType;", "", "type", "", "constructor-impl", "(J)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: TextUnit.kt */
public final class TextUnitType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Em = m6837constructorimpl(8589934592L);
    /* access modifiers changed from: private */
    public static final long Sp = m6837constructorimpl(4294967296L);
    /* access modifiers changed from: private */
    public static final long Unspecified = m6837constructorimpl(0);
    private final long type;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextUnitType m6836boximpl(long j) {
        return new TextUnitType(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m6837constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6838equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnitType) && j == ((TextUnitType) obj).m6842unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6839equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6840hashCodeimpl(long j) {
        return UByte$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m6838equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m6840hashCodeimpl(this.type);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m6842unboximpl() {
        return this.type;
    }

    private /* synthetic */ TextUnitType(long j) {
        this.type = j;
    }

    public String toString() {
        return m6841toStringimpl(this.type);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6841toStringimpl(long j) {
        if (m6839equalsimpl0(j, Unspecified)) {
            return "Unspecified";
        }
        if (m6839equalsimpl0(j, Sp)) {
            return "Sp";
        }
        if (m6839equalsimpl0(j, Em)) {
            return "Em";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/unit/TextUnitType$Companion;", "", "()V", "Em", "Landroidx/compose/ui/unit/TextUnitType;", "getEm-UIouoOA", "()J", "J", "Sp", "getSp-UIouoOA", "Unspecified", "getUnspecified-UIouoOA", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextUnit.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-UIouoOA  reason: not valid java name */
        public final long m6845getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }

        /* renamed from: getSp-UIouoOA  reason: not valid java name */
        public final long m6844getSpUIouoOA() {
            return TextUnitType.Sp;
        }

        /* renamed from: getEm-UIouoOA  reason: not valid java name */
        public final long m6843getEmUIouoOA() {
            return TextUnitType.Em;
        }
    }
}
