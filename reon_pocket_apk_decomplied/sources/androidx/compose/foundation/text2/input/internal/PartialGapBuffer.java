package androidx.compose.foundation.text2.input.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/PartialGapBuffer;", "", "text", "(Ljava/lang/CharSequence;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/foundation/text2/input/internal/GapBuffer;", "length", "getLength", "()I", "contentEquals", "", "other", "get", "", "index", "replace", "", "start", "end", "textStart", "textEnd", "subSequence", "startIndex", "endIndex", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GapBuffer.kt */
public final class PartialGapBuffer implements CharSequence {
    public static final int $stable = 8;
    public static final int BUF_SIZE = 255;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd = -1;
    private int bufStart = -1;
    private GapBuffer buffer;
    private CharSequence text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/PartialGapBuffer$Companion;", "", "()V", "BUF_SIZE", "", "NOWHERE", "SURROUNDING_SIZE", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GapBuffer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PartialGapBuffer(CharSequence charSequence) {
        this.text = charSequence;
    }

    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final /* bridge */ int length() {
        return getLength();
    }

    public int getLength() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.length();
        }
        return (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    public static /* synthetic */ void replace$default(PartialGapBuffer partialGapBuffer, int i, int i2, CharSequence charSequence, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = charSequence.length();
        }
        partialGapBuffer.replace(i, i2, charSequence, i6, i4);
    }

    public final void replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (i > i2) {
            throw new IllegalArgumentException(("start=" + i + " > end=" + i2).toString());
        } else if (i3 > i4) {
            throw new IllegalArgumentException(("textStart=" + i3 + " > textEnd=" + i4).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(("start must be non-negative, but was " + i).toString());
        } else if (i3 >= 0) {
            GapBuffer gapBuffer = this.buffer;
            int i5 = i4 - i3;
            if (gapBuffer == null) {
                int max = Math.max(255, i5 + 128);
                char[] cArr = new char[max];
                int min = Math.min(i, 64);
                int min2 = Math.min(this.text.length() - i2, 64);
                int i6 = i - min;
                ToCharArray_androidKt.toCharArray(this.text, cArr, 0, i6, i);
                int i7 = max - min2;
                int i8 = min2 + i2;
                ToCharArray_androidKt.toCharArray(this.text, cArr, i7, i2, i8);
                ToCharArray_androidKt.toCharArray(charSequence, cArr, min, i3, i4);
                this.buffer = new GapBuffer(cArr, min + i5, i7);
                this.bufStart = i6;
                this.bufEnd = i8;
                return;
            }
            int i9 = this.bufStart;
            int i10 = i - i9;
            int i11 = i2 - i9;
            if (i10 < 0 || i11 > gapBuffer.length()) {
                this.text = toString();
                this.buffer = null;
                this.bufStart = -1;
                this.bufEnd = -1;
                replace(i, i2, charSequence, i3, i4);
                return;
            }
            gapBuffer.replace(i10, i11, charSequence, i3, i4);
        } else {
            throw new IllegalArgumentException(("textStart must be non-negative, but was " + i3).toString());
        }
    }

    public char get(int i) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.charAt(i);
        }
        if (i < this.bufStart) {
            return this.text.charAt(i);
        }
        int length = gapBuffer.length();
        int i2 = this.bufStart;
        if (i < length + i2) {
            return gapBuffer.get(i - i2);
        }
        return this.text.charAt(i - ((length - this.bufEnd) + i2));
    }

    public CharSequence subSequence(int i, int i2) {
        return toString().subSequence(i, i2);
    }

    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        CharSequence charSequence = this.text;
        sb.append(charSequence, this.bufEnd, charSequence.length());
        return sb.toString();
    }

    public final boolean contentEquals(CharSequence charSequence) {
        return Intrinsics.areEqual((Object) toString(), (Object) charSequence.toString());
    }
}
