package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer;", "", "text", "", "(Ljava/lang/String;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "length", "getLength", "()I", "getText", "()Ljava/lang/String;", "setText", "get", "", "index", "replace", "", "start", "end", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GapBuffer.kt */
public final class PartialGapBuffer {
    public static final int $stable = 8;
    public static final int BUF_SIZE = 255;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd = -1;
    private int bufStart = -1;
    private GapBuffer buffer;
    private String text;

    public PartialGapBuffer(String str) {
        this.text = str;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer$Companion;", "", "()V", "BUF_SIZE", "", "NOWHERE", "SURROUNDING_SIZE", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: GapBuffer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final int getLength() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.length();
        }
        return (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    public final void replace(int i, int i2, String str) {
        if (i > i2) {
            throw new IllegalArgumentException(("start index must be less than or equal to end index: " + i + " > " + i2).toString());
        } else if (i >= 0) {
            GapBuffer gapBuffer = this.buffer;
            if (gapBuffer == null) {
                int max = Math.max(255, str.length() + 128);
                char[] cArr = new char[max];
                int min = Math.min(i, 64);
                int min2 = Math.min(this.text.length() - i2, 64);
                int i3 = i - min;
                GapBuffer_jvmKt.toCharArray(this.text, cArr, 0, i3, i);
                int i4 = max - min2;
                int i5 = min2 + i2;
                GapBuffer_jvmKt.toCharArray(this.text, cArr, i4, i2, i5);
                GapBufferKt.toCharArray(str, cArr, min);
                this.buffer = new GapBuffer(cArr, min + str.length(), i4);
                this.bufStart = i3;
                this.bufEnd = i5;
                return;
            }
            int i6 = this.bufStart;
            int i7 = i - i6;
            int i8 = i2 - i6;
            if (i7 < 0 || i8 > gapBuffer.length()) {
                this.text = toString();
                this.buffer = null;
                this.bufStart = -1;
                this.bufEnd = -1;
                replace(i, i2, str);
                return;
            }
            gapBuffer.replace(i7, i8, str);
        } else {
            throw new IllegalArgumentException(("start must be non-negative, but was " + i).toString());
        }
    }

    public final char get(int i) {
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

    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        String str = this.text;
        sb.append(str, this.bufEnd, str.length());
        return sb.toString();
    }
}
