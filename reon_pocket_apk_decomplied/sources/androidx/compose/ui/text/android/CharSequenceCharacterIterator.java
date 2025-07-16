package androidx.compose.ui.text.android;

import java.text.CharacterIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CharCompanionObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\t\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/android/CharSequenceCharacterIterator;", "Ljava/lang/Object;", "Ljava/text/CharacterIterator;", "charSequence", "", "start", "", "end", "(Ljava/lang/CharSequence;II)V", "index", "clone", "", "current", "", "first", "getBeginIndex", "getEndIndex", "getIndex", "last", "next", "previous", "setIndex", "position", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CharSequenceCharacterIterator.kt */
public final class CharSequenceCharacterIterator implements CharacterIterator {
    public static final int $stable = 8;
    private final CharSequence charSequence;
    private final int end;
    private int index;
    private final int start;

    public CharSequenceCharacterIterator(CharSequence charSequence2, int i, int i2) {
        this.charSequence = charSequence2;
        this.start = i;
        this.end = i2;
        this.index = i;
    }

    public char first() {
        this.index = this.start;
        return current();
    }

    public char last() {
        int i = this.start;
        int i2 = this.end;
        if (i == i2) {
            this.index = i2;
            return CharCompanionObject.MAX_VALUE;
        }
        int i3 = i2 - 1;
        this.index = i3;
        return this.charSequence.charAt(i3);
    }

    public char current() {
        int i = this.index;
        return i == this.end ? CharCompanionObject.MAX_VALUE : this.charSequence.charAt(i);
    }

    public char next() {
        int i = this.index + 1;
        this.index = i;
        int i2 = this.end;
        if (i < i2) {
            return this.charSequence.charAt(i);
        }
        this.index = i2;
        return CharCompanionObject.MAX_VALUE;
    }

    public char previous() {
        int i = this.index;
        if (i <= this.start) {
            return CharCompanionObject.MAX_VALUE;
        }
        int i2 = i - 1;
        this.index = i2;
        return this.charSequence.charAt(i2);
    }

    public char setIndex(int i) {
        int i2 = this.start;
        if (i > this.end || i2 > i) {
            throw new IllegalArgumentException("invalid position");
        }
        this.index = i;
        return current();
    }

    public int getBeginIndex() {
        return this.start;
    }

    public int getEndIndex() {
        return this.end;
    }

    public int getIndex() {
        return this.index;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}
