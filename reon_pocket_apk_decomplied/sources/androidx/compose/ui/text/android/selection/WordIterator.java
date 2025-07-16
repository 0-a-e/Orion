package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", "start", "", "end", "locale", "Ljava/util/Locale;", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "iterator", "Ljava/text/BreakIterator;", "checkOffsetIsValid", "", "offset", "getBeginning", "getPrevWordBeginningOnTwoWordsBoundary", "", "getEnd", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterLetterOrDigit", "isAfterPunctuation", "isOnLetterOrDigit", "isOnPunctuation", "isPunctuationEndBoundary", "isPunctuationStartBoundary", "nextBoundary", "prevBoundary", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WordIterator.kt */
public final class WordIterator {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int WINDOW_WIDTH = 50;
    private final CharSequence charSequence;
    private final int end;
    private final BreakIterator iterator;
    private final int start;

    public WordIterator(CharSequence charSequence2, int i, int i2, Locale locale) {
        this.charSequence = charSequence2;
        if (i < 0 || i > charSequence2.length()) {
            throw new IllegalArgumentException("input start index is outside the CharSequence".toString());
        } else if (i2 < 0 || i2 > charSequence2.length()) {
            throw new IllegalArgumentException("input end index is outside the CharSequence".toString());
        } else {
            BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
            this.iterator = wordInstance;
            this.start = Math.max(0, i - 50);
            this.end = Math.min(charSequence2.length(), i2 + 50);
            wordInstance.setText(new CharSequenceCharacterIterator(charSequence2, i, i2));
        }
    }

    public final int nextBoundary(int i) {
        checkOffsetIsValid(i);
        return this.iterator.following(i);
    }

    public final int prevBoundary(int i) {
        checkOffsetIsValid(i);
        return this.iterator.preceding(i);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int i) {
        return getBeginning(i, true);
    }

    public final int getNextWordEndOnTwoWordBoundary(int i) {
        return getEnd(i, true);
    }

    public final int getPunctuationBeginning(int i) {
        checkOffsetIsValid(i);
        while (i != -1 && !isPunctuationStartBoundary(i)) {
            i = prevBoundary(i);
        }
        return i;
    }

    public final int getPunctuationEnd(int i) {
        checkOffsetIsValid(i);
        while (i != -1 && !isPunctuationEndBoundary(i)) {
            i = nextBoundary(i);
        }
        return i;
    }

    public final boolean isAfterPunctuation(int i) {
        int i2 = this.start + 1;
        if (i > this.end || i2 > i) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointBefore(this.charSequence, i));
    }

    public final boolean isOnPunctuation(int i) {
        int i2 = this.start;
        if (i >= this.end || i2 > i) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointAt(this.charSequence, i));
    }

    private final int getBeginning(int i, boolean z) {
        checkOffsetIsValid(i);
        if (isOnLetterOrDigit(i)) {
            return (!this.iterator.isBoundary(i) || (isAfterLetterOrDigit(i) && z)) ? this.iterator.preceding(i) : i;
        }
        if (isAfterLetterOrDigit(i)) {
            return this.iterator.preceding(i);
        }
        return -1;
    }

    private final int getEnd(int i, boolean z) {
        checkOffsetIsValid(i);
        if (isAfterLetterOrDigit(i)) {
            return (!this.iterator.isBoundary(i) || (isOnLetterOrDigit(i) && z)) ? this.iterator.following(i) : i;
        }
        if (isOnLetterOrDigit(i)) {
            return this.iterator.following(i);
        }
        return -1;
    }

    private final boolean isPunctuationStartBoundary(int i) {
        return isOnPunctuation(i) && !isAfterPunctuation(i);
    }

    private final boolean isPunctuationEndBoundary(int i) {
        return !isOnPunctuation(i) && isAfterPunctuation(i);
    }

    private final boolean isAfterLetterOrDigit(int i) {
        int i2 = this.start + 1;
        if (i > this.end || i2 > i || !Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, i))) {
            return false;
        }
        return true;
    }

    private final boolean isOnLetterOrDigit(int i) {
        return i < this.end && this.start <= i && Character.isLetterOrDigit(Character.codePointAt(this.charSequence, i));
    }

    private final void checkOffsetIsValid(int i) {
        int i2 = this.start;
        if (i > this.end || i2 > i) {
            throw new IllegalArgumentException(("Invalid offset: " + i + ". Valid range is [" + this.start + " , " + this.end + ']').toString());
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WordIterator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPunctuation$ui_text_release(int i) {
            int type = Character.getType(i);
            return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
        }
    }
}
