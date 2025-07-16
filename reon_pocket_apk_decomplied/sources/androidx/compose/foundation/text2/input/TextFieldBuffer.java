package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.internal.ChangeTracker;
import androidx.compose.foundation.text2.input.internal.PartialGapBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001VB%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u0014\u0010!\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010!\u001a\u00060\u0001j\u0002`\u00022\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010!\u001a\u00060\u0001j\u0002`\u00022\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0006\u0010(\u001a\u00020%J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0011J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011H\u0002J\u001a\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011H\u0002J\u001a\u00103\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u0010/J \u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0002J\u000e\u00109\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010:\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010;\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010<\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u001e\u0010=\u001a\u0002012\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%J9\u0010=\u001a\u0002012\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010>\u001a\u00020\u00112\b\b\u0002\u0010?\u001a\u00020\u0011H\u0000¢\u0006\u0002\b@J(\u0010A\u001a\u0002012\u0006\u0010*\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H\u0002J\"\u0010E\u001a\u0002012\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u0006\u0010H\u001a\u000201J\u0018\u0010I\u001a\u0002012\u0006\u0010-\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u0018\u0010L\u001a\u0002012\u0006\u0010-\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\bM\u0010KJ\u0015\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020%H\u0000¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020RH\u0016J\u001c\u0010S\u001a\u00020\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\bUR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013R&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001a8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010\u001dR\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text2/input/internal/ChangeTracker;", "sourceValue", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;Landroidx/compose/foundation/text2/input/internal/ChangeTracker;Landroidx/compose/foundation/text2/input/TextFieldCharSequence;)V", "buffer", "Landroidx/compose/foundation/text2/input/internal/PartialGapBuffer;", "changeTracker", "changes", "Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "getChanges", "()Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "codepointLength", "", "getCodepointLength", "()I", "hasSelection", "", "()Z", "length", "getLength", "<set-?>", "Landroidx/compose/ui/text/TextRange;", "selectionInChars", "getSelectionInChars-d9O1mEE", "()J", "J", "selectionInCodepoints", "getSelectionInCodepoints-d9O1mEE", "append", "char", "", "text", "", "start", "end", "asCharSequence", "charAt", "index", "charIndexToCodepointIndex", "charsToCodepoints", "range", "charsToCodepoints-GEjPoXI", "(J)J", "clearChangeList", "", "codepointIndexToCharIndex", "codepointsToChars", "codepointsToChars-GEjPoXI", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "placeCursorAfterCharAt", "placeCursorAfterCodepointAt", "placeCursorBeforeCharAt", "placeCursorBeforeCodepointAt", "replace", "textStart", "textEnd", "replace$foundation_release", "requireValidIndex", "startExclusive", "endExclusive", "inCodepoints", "requireValidRange", "requireValidRange-72CqOWE", "(JZ)V", "revertAllChanges", "selectCharsIn", "selectCharsIn-5zc-tL8", "(J)V", "selectCodepointsIn", "selectCodepointsIn-5zc-tL8", "setTextIfChanged", "newText", "setTextIfChanged$foundation_release", "toString", "", "toTextFieldCharSequence", "composition", "toTextFieldCharSequence-OEnZFl4$foundation_release", "ChangeList", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldBuffer.kt */
public final class TextFieldBuffer implements Appendable {
    public static final int $stable = 8;
    private final PartialGapBuffer buffer;
    private ChangeTracker changeTracker;
    private long selectionInChars;
    private final TextFieldCharSequence sourceValue;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldBuffer.kt */
    public interface ChangeList {
        int getChangeCount();

        /* renamed from: getOriginalRange--jx7JFs  reason: not valid java name */
        long m1343getOriginalRangejx7JFs(int i);

        /* renamed from: getRange--jx7JFs  reason: not valid java name */
        long m1344getRangejx7JFs(int i);
    }

    private final int charIndexToCodepointIndex(int i) {
        return i;
    }

    private final int codepointIndexToCharIndex(int i) {
        return i;
    }

    public TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker2, TextFieldCharSequence textFieldCharSequence2) {
        this.sourceValue = textFieldCharSequence2;
        this.buffer = new PartialGapBuffer(textFieldCharSequence);
        this.changeTracker = changeTracker2 != null ? new ChangeTracker(changeTracker2) : null;
        this.selectionInChars = textFieldCharSequence.m1346getSelectionInCharsd9O1mEE();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker2, TextFieldCharSequence textFieldCharSequence2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldCharSequence, (i & 2) != 0 ? null : changeTracker2, (i & 4) != 0 ? textFieldCharSequence : textFieldCharSequence2);
    }

    public final int getLength() {
        return this.buffer.length();
    }

    public final int getCodepointLength() {
        return Character.codePointCount(this.buffer, 0, getLength());
    }

    public final ChangeList getChanges() {
        ChangeList changeList = this.changeTracker;
        if (changeList == null) {
            changeList = EmptyChangeList.INSTANCE;
        }
        return changeList;
    }

    public final boolean hasSelection() {
        return !TextRange.m6036getCollapsedimpl(this.selectionInChars);
    }

    /* renamed from: getSelectionInChars-d9O1mEE  reason: not valid java name */
    public final long m1338getSelectionInCharsd9O1mEE() {
        return this.selectionInChars;
    }

    /* renamed from: getSelectionInCodepoints-d9O1mEE  reason: not valid java name */
    public final long m1339getSelectionInCodepointsd9O1mEE() {
        return m1334charsToCodepointsGEjPoXI(this.selectionInChars);
    }

    public final void replace(int i, int i2, CharSequence charSequence) {
        replace$foundation_release(i, i2, charSequence, 0, charSequence.length());
    }

    public static /* synthetic */ void replace$foundation_release$default(TextFieldBuffer textFieldBuffer, int i, int i2, CharSequence charSequence, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = charSequence.length();
        }
        textFieldBuffer.replace$foundation_release(i, i2, charSequence, i6, i4);
    }

    public final void replace$foundation_release(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (i > i2) {
            throw new IllegalArgumentException(("Expected start=" + i + " <= end=" + i2).toString());
        } else if (i3 <= i4) {
            onTextWillChange(i, i2, i4 - i3);
            this.buffer.replace(i, i2, charSequence, i3, i4);
        } else {
            throw new IllegalArgumentException(("Expected textStart=" + i3 + " <= textEnd=" + i4).toString());
        }
    }

    public final void setTextIfChanged$foundation_release(CharSequence charSequence) {
        int i;
        int i2;
        int i3;
        int i4;
        CharSequence charSequence2 = this.buffer;
        int length = charSequence2.length();
        int length2 = charSequence.length();
        boolean z = false;
        if (charSequence2.length() <= 0 || charSequence.length() <= 0) {
            i3 = length;
            i = length2;
            i4 = 0;
            i2 = 0;
        } else {
            int i5 = 0;
            int i6 = 0;
            boolean z2 = false;
            while (true) {
                if (!z) {
                    if (charSequence2.charAt(i5) == charSequence.charAt(i6)) {
                        i5++;
                        i6++;
                    } else {
                        z = true;
                    }
                }
                if (!z2) {
                    if (charSequence2.charAt(length - 1) == charSequence.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z2 = true;
                    }
                }
                if (i5 >= length || i6 >= length2 || (z && z2)) {
                    i3 = length;
                    i = length2;
                    i4 = i5;
                    i2 = i6;
                }
            }
            i3 = length;
            i = length2;
            i4 = i5;
            i2 = i6;
        }
        if (i4 < i3 || i2 < i) {
            replace$foundation_release(i4, i3, charSequence, i2, i);
        }
    }

    public Appendable append(CharSequence charSequence) {
        TextFieldBuffer textFieldBuffer = this;
        if (charSequence != null) {
            onTextWillChange(getLength(), getLength(), charSequence.length());
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), charSequence, 0, 0, 24, (Object) null);
        }
        return this;
    }

    public Appendable append(CharSequence charSequence, int i, int i2) {
        TextFieldBuffer textFieldBuffer = this;
        if (charSequence != null) {
            onTextWillChange(getLength(), getLength(), i2 - i);
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), charSequence.subSequence(i, i2), 0, 0, 24, (Object) null);
        }
        return this;
    }

    public Appendable append(char c) {
        TextFieldBuffer textFieldBuffer = this;
        onTextWillChange(getLength(), getLength(), 1);
        PartialGapBuffer partialGapBuffer = this.buffer;
        PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), String.valueOf(c), 0, 0, 24, (Object) null);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r5 == r1) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onTextWillChange(int r4, int r5, int r6) {
        /*
            r3 = this;
            androidx.compose.foundation.text2.input.internal.ChangeTracker r0 = r3.changeTracker
            if (r0 != 0) goto L_0x000d
            androidx.compose.foundation.text2.input.internal.ChangeTracker r0 = new androidx.compose.foundation.text2.input.internal.ChangeTracker
            r1 = 1
            r2 = 0
            r0.<init>(r2, r1, r2)
            r3.changeTracker = r0
        L_0x000d:
            r0.trackChange(r4, r5, r6)
            int r0 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r4, r5)
            long r1 = r3.selectionInChars
            int r5 = androidx.compose.ui.text.TextRange.m6040getMinimpl(r1)
            long r1 = r3.selectionInChars
            int r1 = androidx.compose.ui.text.TextRange.m6039getMaximpl(r1)
            if (r1 >= r0) goto L_0x0027
            return
        L_0x0027:
            if (r5 > r0) goto L_0x0030
            if (r4 > r1) goto L_0x0030
            int r4 = r4 - r0
            int r6 = r6 - r4
            if (r5 != r1) goto L_0x003c
            goto L_0x003b
        L_0x0030:
            if (r5 <= r0) goto L_0x0037
            if (r1 >= r4) goto L_0x0037
            int r0 = r0 + r6
            r5 = r0
            goto L_0x0046
        L_0x0037:
            if (r5 < r4) goto L_0x003f
            int r4 = r4 - r0
            int r6 = r6 - r4
        L_0x003b:
            int r5 = r5 + r6
        L_0x003c:
            int r0 = r1 + r6
            goto L_0x0046
        L_0x003f:
            if (r0 >= r5) goto L_0x0046
            int r5 = r0 + r6
            int r4 = r4 - r0
            int r6 = r6 - r4
            goto L_0x003c
        L_0x0046:
            long r4 = androidx.compose.ui.text.TextRangeKt.TextRange(r5, r0)
            r3.selectionInChars = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.TextFieldBuffer.onTextWillChange(int, int, int):void");
    }

    public final char charAt(int i) {
        return this.buffer.charAt(i);
    }

    public String toString() {
        return this.buffer.toString();
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    private final void clearChangeList() {
        ChangeTracker changeTracker2 = this.changeTracker;
        if (changeTracker2 != null) {
            changeTracker2.clearChanges();
        }
    }

    public final void revertAllChanges() {
        replace(0, getLength(), this.sourceValue.toString());
        this.selectionInChars = this.sourceValue.m1346getSelectionInCharsd9O1mEE();
        clearChangeList();
    }

    public final void placeCursorBeforeCodepointAt(int i) {
        requireValidIndex(i, true, false, true);
        this.selectionInChars = TextRangeKt.TextRange(codepointIndexToCharIndex(i));
    }

    public final void placeCursorBeforeCharAt(int i) {
        requireValidIndex(i, true, false, false);
        this.selectionInChars = TextRangeKt.TextRange(i);
    }

    public final void placeCursorAfterCodepointAt(int i) {
        requireValidIndex(i, false, true, true);
        this.selectionInChars = TextRangeKt.TextRange(codepointIndexToCharIndex(RangesKt.coerceAtMost(i + 1, getCodepointLength())));
    }

    public final void placeCursorAfterCharAt(int i) {
        requireValidIndex(i, false, true, false);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(i + 1, getLength()));
    }

    /* renamed from: selectCodepointsIn-5zc-tL8  reason: not valid java name */
    public final void m1341selectCodepointsIn5zctL8(long j) {
        m1336requireValidRange72CqOWE(j, true);
        this.selectionInChars = m1335codepointsToCharsGEjPoXI(j);
    }

    /* renamed from: selectCharsIn-5zc-tL8  reason: not valid java name */
    public final void m1340selectCharsIn5zctL8(long j) {
        m1336requireValidRange72CqOWE(j, false);
        this.selectionInChars = j;
    }

    /* renamed from: toTextFieldCharSequence-OEnZFl4$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1337toTextFieldCharSequenceOEnZFl4$foundation_release$default(TextFieldBuffer textFieldBuffer, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            textRange = null;
        }
        return textFieldBuffer.m1342toTextFieldCharSequenceOEnZFl4$foundation_release(textRange);
    }

    /* renamed from: toTextFieldCharSequence-OEnZFl4$foundation_release  reason: not valid java name */
    public final TextFieldCharSequence m1342toTextFieldCharSequenceOEnZFl4$foundation_release(TextRange textRange) {
        return TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(this.buffer.toString(), this.selectionInChars, textRange);
    }

    private final void requireValidIndex(int i, boolean z, boolean z2, boolean z3) {
        int i2 = z ? 0 : -1;
        int length = z2 ? getLength() : getLength() + 1;
        if (z3) {
            i2 = charIndexToCodepointIndex(i2);
            length = charIndexToCodepointIndex(length);
        }
        if (i2 > i || i >= length) {
            String str = z3 ? "codepoints" : "chars";
            throw new IllegalArgumentException(("Expected " + i + " to be in [" + i2 + ", " + length + ") " + str).toString());
        }
    }

    /* renamed from: requireValidRange-72CqOWE  reason: not valid java name */
    private final void m1336requireValidRange72CqOWE(long j, boolean z) {
        long TextRange = TextRangeKt.TextRange(0, getLength());
        if (z) {
            TextRange = m1334charsToCodepointsGEjPoXI(TextRange);
        }
        if (!TextRange.m6032contains5zctL8(TextRange, j)) {
            String str = z ? "codepoints" : "chars";
            throw new IllegalArgumentException(("Expected " + TextRange.m6045toStringimpl(j) + " to be in " + TextRange.m6045toStringimpl(TextRange) + " (" + str + ')').toString());
        }
    }

    /* renamed from: codepointsToChars-GEjPoXI  reason: not valid java name */
    private final long m1335codepointsToCharsGEjPoXI(long j) {
        return TextRangeKt.TextRange(codepointIndexToCharIndex(TextRange.m6042getStartimpl(j)), codepointIndexToCharIndex(TextRange.m6037getEndimpl(j)));
    }

    /* renamed from: charsToCodepoints-GEjPoXI  reason: not valid java name */
    private final long m1334charsToCodepointsGEjPoXI(long j) {
        return TextRangeKt.TextRange(charIndexToCodepointIndex(TextRange.m6042getStartimpl(j)), charIndexToCodepointIndex(TextRange.m6037getEndimpl(j)));
    }
}
