package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\b\u0000\u0018\u0000 92\u00020\u0001:\u00019B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0002J\u0006\u0010,\u001a\u00020)J\u0016\u0010-\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011J\u0011\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0011H\u0002J\u0006\u00101\u001a\u000202J\u001e\u00103\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u000204J\u0016\u00105\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011J\u0016\u00106\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011J\u0006\u00107\u001a\u00020\u0007J\b\u00108\u001a\u00020\u0003H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u001aR$\u0010%\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "changeTracker", "Landroidx/compose/foundation/text2/input/internal/ChangeTracker;", "getChangeTracker", "()Landroidx/compose/foundation/text2/input/internal/ChangeTracker;", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "compositionEnd", "getCompositionEnd", "()I", "compositionStart", "getCompositionStart", "cursor", "getCursor", "setCursor", "(I)V", "gapBuffer", "Landroidx/compose/foundation/text2/input/internal/PartialGapBuffer;", "length", "getLength", "getSelection-d9O1mEE", "()J", "value", "selectionEnd", "getSelectionEnd", "setSelectionEnd", "selectionStart", "getSelectionStart", "setSelectionStart", "checkRange", "", "start", "end", "commitComposition", "delete", "get", "", "index", "hasComposition", "", "replace", "", "setComposition", "setSelection", "toAnnotatedString", "toString", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditingBuffer.kt */
public final class EditingBuffer {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOWHERE = -1;
    private final ChangeTracker changeTracker;
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j);
    }

    public /* synthetic */ EditingBuffer(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    private EditingBuffer(AnnotatedString annotatedString, long j) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.changeTracker = new ChangeTracker((ChangeTracker) null, 1, (DefaultConstructorMarker) null);
        this.selectionStart = TextRange.m6042getStartimpl(j);
        this.selectionEnd = TextRange.m6037getEndimpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        checkRange(TextRange.m6042getStartimpl(j), TextRange.m6037getEndimpl(j));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/EditingBuffer$Companion;", "", "()V", "NOWHERE", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: EditingBuffer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ChangeTracker getChangeTracker() {
        return this.changeTracker;
    }

    public final int getSelectionStart() {
        return this.selectionStart;
    }

    private final void setSelectionStart(int i) {
        if (i >= 0) {
            this.selectionStart = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionStart to a negative value: " + i).toString());
    }

    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    private final void setSelectionEnd(int i) {
        if (i >= 0) {
            this.selectionEnd = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionEnd to a negative value: " + i).toString());
    }

    public final int getCompositionStart() {
        return this.compositionStart;
    }

    public final int getCompositionEnd() {
        return this.compositionEnd;
    }

    public final boolean hasComposition() {
        return this.compositionStart != -1;
    }

    /* renamed from: getComposition-MzsxiRA  reason: not valid java name */
    public final TextRange m1369getCompositionMzsxiRA() {
        if (hasComposition()) {
            return TextRange.m6030boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m1370getSelectiond9O1mEE() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getCursor() {
        int i = this.selectionStart;
        int i2 = this.selectionEnd;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final void setCursor(int i) {
        setSelection(i, i);
    }

    public final char get(int i) {
        return this.gapBuffer.charAt(i);
    }

    public final int getLength() {
        return this.gapBuffer.length();
    }

    private EditingBuffer(String str, long j) {
        this(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), j, (DefaultConstructorMarker) null);
    }

    public final void replace(int i, int i2, CharSequence charSequence) {
        checkRange(i, i2);
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        int i3 = 0;
        int i4 = min;
        while (i4 < max && i3 < charSequence.length() && charSequence.charAt(i3) == this.gapBuffer.charAt(i4)) {
            i3++;
            i4++;
        }
        int length = charSequence.length();
        int i5 = max;
        while (i5 > min && length > i3 && charSequence.charAt(length - 1) == this.gapBuffer.charAt(i5 - 1)) {
            length--;
            i5--;
        }
        this.changeTracker.trackChange(i4, i5, length - i3);
        PartialGapBuffer.replace$default(this.gapBuffer, min, max, charSequence, 0, 0, 24, (Object) null);
        setSelectionStart(charSequence.length() + min);
        setSelectionEnd(min + charSequence.length());
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete(int i, int i2) {
        checkRange(i, i2);
        long TextRange = TextRangeKt.TextRange(i, i2);
        this.changeTracker.trackChange(i, i2, 0);
        PartialGapBuffer.replace$default(this.gapBuffer, TextRange.m6040getMinimpl(TextRange), TextRange.m6039getMaximpl(TextRange), "", 0, 0, 24, (Object) null);
        long r13 = EditingBufferKt.m1371updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), TextRange);
        setSelectionStart(TextRange.m6042getStartimpl(r13));
        setSelectionEnd(TextRange.m6037getEndimpl(r13));
        if (hasComposition()) {
            long r132 = EditingBufferKt.m1371updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), TextRange);
            if (TextRange.m6036getCollapsedimpl(r132)) {
                commitComposition();
                return;
            }
            this.compositionStart = TextRange.m6040getMinimpl(r132);
            this.compositionEnd = TextRange.m6039getMaximpl(r132);
        }
    }

    public final void setSelection(int i, int i2) {
        int coerceIn = RangesKt.coerceIn(i, 0, getLength());
        int coerceIn2 = RangesKt.coerceIn(i2, 0, getLength());
        setSelectionStart(coerceIn);
        setSelectionEnd(coerceIn2);
    }

    public final void setComposition(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.length()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.length());
        } else if (i2 < 0 || i2 > this.gapBuffer.length()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.length());
        } else if (i < i2) {
            this.compositionStart = i;
            this.compositionEnd = i2;
        } else {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + i + " > " + i2);
        }
    }

    public final void commitComposition() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    public final AnnotatedString toAnnotatedString() {
        return new AnnotatedString(toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null);
    }

    private final void checkRange(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.length()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.length());
        } else if (i2 < 0 || i2 > this.gapBuffer.length()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.length());
        }
    }
}
