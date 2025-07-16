package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0013\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0002J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fJ\b\u0010&\u001a\u00020'H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldCharSequenceWrapper;", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "compositionInChars", "getCompositionInChars-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "length", "", "getLength", "()I", "selectionInChars", "getSelectionInChars-d9O1mEE", "()J", "J", "contentEquals", "", "other", "equals", "", "get", "", "index", "hashCode", "subSequence", "startIndex", "endIndex", "toCharArray", "", "destination", "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCharSequence.kt */
final class TextFieldCharSequenceWrapper implements TextFieldCharSequence {
    private final TextRange compositionInChars;
    private final long selectionInChars;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequenceWrapper(CharSequence charSequence, long j, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j, textRange);
    }

    private TextFieldCharSequenceWrapper(CharSequence charSequence, long j, TextRange textRange) {
        this.text = charSequence;
        this.selectionInChars = TextRangeKt.m6048coerceIn8ffj60Q(j, 0, charSequence.length());
        this.compositionInChars = textRange != null ? TextRange.m6030boximpl(TextRangeKt.m6048coerceIn8ffj60Q(textRange.m6046unboximpl(), 0, charSequence.length())) : null;
    }

    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final /* bridge */ int length() {
        return getLength();
    }

    public int getLength() {
        return this.text.length();
    }

    /* renamed from: getSelectionInChars-d9O1mEE  reason: not valid java name */
    public long m1352getSelectionInCharsd9O1mEE() {
        return this.selectionInChars;
    }

    /* renamed from: getCompositionInChars-MzsxiRA  reason: not valid java name */
    public TextRange m1351getCompositionInCharsMzsxiRA() {
        return this.compositionInChars;
    }

    public char get(int i) {
        return this.text.charAt(i);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.text.subSequence(i, i2);
    }

    public String toString() {
        return this.text.toString();
    }

    public boolean contentEquals(CharSequence charSequence) {
        return StringsKt.contentEquals(this.text, charSequence);
    }

    public final void toCharArray(char[] cArr, int i, int i2, int i3) {
        ToCharArray_androidKt.toCharArray(this.text, cArr, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextFieldCharSequenceWrapper textFieldCharSequenceWrapper = (TextFieldCharSequenceWrapper) obj;
        return TextRange.m6035equalsimpl0(m1352getSelectionInCharsd9O1mEE(), textFieldCharSequenceWrapper.m1352getSelectionInCharsd9O1mEE()) && Intrinsics.areEqual((Object) m1351getCompositionInCharsMzsxiRA(), (Object) textFieldCharSequenceWrapper.m1351getCompositionInCharsMzsxiRA()) && contentEquals(textFieldCharSequenceWrapper.text);
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + TextRange.m6043hashCodeimpl(m1352getSelectionInCharsd9O1mEE())) * 31;
        TextRange r1 = m1351getCompositionInCharsMzsxiRA();
        return hashCode + (r1 != null ? TextRange.m6043hashCodeimpl(r1.m6046unboximpl()) : 0);
    }
}
