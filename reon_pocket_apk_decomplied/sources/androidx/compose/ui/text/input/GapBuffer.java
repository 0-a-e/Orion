package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/GapBuffer;", "", "initBuffer", "", "initGapStart", "", "initGapEnd", "([CII)V", "buffer", "capacity", "gapEnd", "gapStart", "append", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "delete", "start", "end", "gapLength", "get", "", "index", "length", "makeSureAvailableSpace", "requestSize", "replace", "text", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GapBuffer.kt */
final class GapBuffer {
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    public GapBuffer(char[] cArr, int i, int i2) {
        this.capacity = cArr.length;
        this.buffer = cArr;
        this.gapStart = i;
        this.gapEnd = i2;
    }

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    public final char get(int i) {
        int i2 = this.gapStart;
        if (i < i2) {
            return this.buffer[i];
        }
        return this.buffer[(i - i2) + this.gapEnd];
    }

    private final void makeSureAvailableSpace(int i) {
        if (i > gapLength()) {
            int gapLength = i - gapLength();
            int i2 = this.capacity;
            do {
                i2 *= 2;
            } while (i2 - this.capacity < gapLength);
            char[] cArr = new char[i2];
            ArraysKt.copyInto(this.buffer, cArr, 0, 0, this.gapStart);
            int i3 = this.capacity;
            int i4 = this.gapEnd;
            int i5 = i3 - i4;
            int i6 = i2 - i5;
            ArraysKt.copyInto(this.buffer, cArr, i6, i4, i5 + i4);
            this.buffer = cArr;
            this.capacity = i2;
            this.gapEnd = i6;
        }
    }

    private final void delete(int i, int i2) {
        int i3 = this.gapStart;
        if (i < i3 && i2 <= i3) {
            int i4 = i3 - i2;
            char[] cArr = this.buffer;
            ArraysKt.copyInto(cArr, cArr, this.gapEnd - i4, i2, i3);
            this.gapStart = i;
            this.gapEnd -= i4;
        } else if (i >= i3 || i2 < i3) {
            int gapLength = i + gapLength();
            int gapLength2 = i2 + gapLength();
            int i5 = this.gapEnd;
            char[] cArr2 = this.buffer;
            ArraysKt.copyInto(cArr2, cArr2, this.gapStart, i5, gapLength);
            this.gapStart += gapLength - i5;
            this.gapEnd = gapLength2;
        } else {
            this.gapEnd = i2 + gapLength();
            this.gapStart = i;
        }
    }

    public final void replace(int i, int i2, String str) {
        makeSureAvailableSpace(str.length() - (i2 - i));
        delete(i, i2);
        GapBufferKt.toCharArray(str, this.buffer, this.gapStart);
        this.gapStart += str.length();
    }

    public final void append(StringBuilder sb) {
        sb.append(this.buffer, 0, this.gapStart);
        char[] cArr = this.buffer;
        int i = this.gapEnd;
        sb.append(cArr, i, this.capacity - i);
    }

    public final int length() {
        return this.capacity - gapLength();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(sb);
        return sb.toString();
    }
}
