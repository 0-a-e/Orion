package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: HapticFeedbackType.kt */
public final class HapticFeedbackType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m4618boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4619constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4620equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).m4624unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4621equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4622hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m4620equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4622hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4624unboximpl() {
        return this.value;
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    public String toString() {
        return m4623toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4623toStringimpl(int i) {
        Companion companion = Companion;
        if (m4621equalsimpl0(i, companion.m4625getLongPress5zf0vsI())) {
            return "LongPress";
        }
        if (m4621equalsimpl0(i, companion.m4626getTextHandleMove5zf0vsI())) {
            return "TextHandleMove";
        }
        return "Invalid";
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nR\u0017\u0010\u0003\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "()V", "LongPress", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getLongPress-5zf0vsI", "()I", "TextHandleMove", "getTextHandleMove-5zf0vsI", "values", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HapticFeedbackType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getLongPress-5zf0vsI  reason: not valid java name */
        public final int m4625getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4628getLongPress5zf0vsI();
        }

        /* renamed from: getTextHandleMove-5zf0vsI  reason: not valid java name */
        public final int m4626getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4629getTextHandleMove5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return CollectionsKt.listOf(HapticFeedbackType.m4618boximpl(m4625getLongPress5zf0vsI()), HapticFeedbackType.m4618boximpl(m4626getTextHandleMove5zf0vsI()));
        }
    }
}
