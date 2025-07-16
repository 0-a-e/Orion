package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0004\u001a\u0013\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a$\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"TextRange", "Landroidx/compose/ui/text/TextRange;", "index", "", "(I)J", "start", "end", "(II)J", "packWithCheck", "", "coerceIn", "minimumValue", "maximumValue", "coerceIn-8ffj60Q", "(JII)J", "substring", "", "", "range", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextRange.kt */
public final class TextRangeKt {
    /* renamed from: substring-FDrldGo  reason: not valid java name */
    public static final String m6049substringFDrldGo(CharSequence charSequence, long j) {
        return charSequence.subSequence(TextRange.m6040getMinimpl(j), TextRange.m6039getMaximpl(j)).toString();
    }

    public static final long TextRange(int i, int i2) {
        return TextRange.m6031constructorimpl(packWithCheck(i, i2));
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }

    /* renamed from: coerceIn-8ffj60Q  reason: not valid java name */
    public static final long m6048coerceIn8ffj60Q(long j, int i, int i2) {
        int coerceIn = RangesKt.coerceIn(TextRange.m6042getStartimpl(j), i, i2);
        int coerceIn2 = RangesKt.coerceIn(TextRange.m6037getEndimpl(j), i, i2);
        if (coerceIn == TextRange.m6042getStartimpl(j) && coerceIn2 == TextRange.m6037getEndimpl(j)) {
            return j;
        }
        return TextRange(coerceIn, coerceIn2);
    }

    private static final long packWithCheck(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
        } else if (i2 >= 0) {
            return (((long) i2) & 4294967295L) | (((long) i) << 32);
        } else {
            throw new IllegalArgumentException(("end cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
        }
    }
}
