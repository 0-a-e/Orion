package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent;", "", "firstLine", "Landroidx/compose/ui/unit/TextUnit;", "restLine", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLine-XSAIIZE", "()J", "J", "getRestLine-XSAIIZE", "copy", "copy-NB67dxo", "(JJ)Landroidx/compose/ui/text/style/TextIndent;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextIndent.kt */
public final class TextIndent {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TextIndent None = new TextIndent(0, 0, 3, (DefaultConstructorMarker) null);
    private final long firstLine;
    private final long restLine;

    public /* synthetic */ TextIndent(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    private TextIndent(long j, long j2) {
        this.firstLine = j;
        this.restLine = j2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextIndent(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TextUnitKt.getSp(0) : j, (i & 2) != 0 ? TextUnitKt.getSp(0) : j2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getFirstLine-XSAIIZE  reason: not valid java name */
    public final long m6486getFirstLineXSAIIZE() {
        return this.firstLine;
    }

    /* renamed from: getRestLine-XSAIIZE  reason: not valid java name */
    public final long m6487getRestLineXSAIIZE() {
        return this.restLine;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/style/TextIndent$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/style/TextIndent;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextIndent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        private Companion() {
        }

        public final TextIndent getNone() {
            return TextIndent.None;
        }
    }

    /* renamed from: copy-NB67dxo$default  reason: not valid java name */
    public static /* synthetic */ TextIndent m6484copyNB67dxo$default(TextIndent textIndent, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = textIndent.firstLine;
        }
        if ((i & 2) != 0) {
            j2 = textIndent.restLine;
        }
        return textIndent.m6485copyNB67dxo(j, j2);
    }

    /* renamed from: copy-NB67dxo  reason: not valid java name */
    public final TextIndent m6485copyNB67dxo(long j, long j2) {
        return new TextIndent(j, j2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return TextUnit.m6808equalsimpl0(this.firstLine, textIndent.firstLine) && TextUnit.m6808equalsimpl0(this.restLine, textIndent.restLine);
    }

    public int hashCode() {
        return (TextUnit.m6812hashCodeimpl(this.firstLine) * 31) + TextUnit.m6812hashCodeimpl(this.restLine);
    }

    public String toString() {
        return "TextIndent(firstLine=" + TextUnit.m6818toStringimpl(this.firstLine) + ", restLine=" + TextUnit.m6818toStringimpl(this.restLine) + ')';
    }
}
