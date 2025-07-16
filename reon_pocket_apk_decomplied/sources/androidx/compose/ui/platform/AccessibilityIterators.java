package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators;", "", "()V", "AbstractTextSegmentIterator", "CharacterTextSegmentIterator", "LineTextSegmentIterator", "PageTextSegmentIterator", "ParagraphTextSegmentIterator", "TextSegmentIterator", "WordTextSegmentIterator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AccessibilityIterators.android.kt */
public final class AccessibilityIterators {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "", "following", "", "current", "", "preceding", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityIterators.android.kt */
    public interface TextSegmentIterator {
        int[] following(int i);

        int[] preceding(int i);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "()V", "segment", "", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getRange", "start", "", "end", "initialize", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityIterators.android.kt */
    public static abstract class AbstractTextSegmentIterator implements TextSegmentIterator {
        public static final int $stable = 8;
        private final int[] segment = new int[2];
        protected String text;

        /* access modifiers changed from: protected */
        public final String getText() {
            String str = this.text;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("text");
            return null;
        }

        /* access modifiers changed from: protected */
        public final void setText(String str) {
            this.text = str;
        }

        public void initialize(String str) {
            setText(str);
        }

        /* access modifiers changed from: protected */
        public final int[] getRange(int i, int i2) {
            if (i < 0 || i2 < 0 || i == i2) {
                return null;
            }
            int[] iArr = this.segment;
            iArr[0] = i;
            iArr[1] = i2;
            return iArr;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityIterators.android.kt */
    public static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static CharacterTextSegmentIterator instance;
        private BreakIterator impl;

        public /* synthetic */ CharacterTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
            this(locale);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator$Companion;", "", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CharacterTextSegmentIterator getInstance(Locale locale) {
                if (CharacterTextSegmentIterator.instance == null) {
                    CharacterTextSegmentIterator.instance = new CharacterTextSegmentIterator(locale, (DefaultConstructorMarker) null);
                }
                CharacterTextSegmentIterator access$getInstance$cp = CharacterTextSegmentIterator.instance;
                Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
                return access$getInstance$cp;
            }
        }

        private CharacterTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }

        public void initialize(String str) {
            super.initialize(str);
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            breakIterator.setText(str);
        }

        public int[] following(int i) {
            int length = getText().length();
            if (length <= 0 || i >= length) {
                return null;
            }
            if (i < 0) {
                i = 0;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (!breakIterator.isBoundary(i)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    i = breakIterator2.following(i);
                } else {
                    BreakIterator breakIterator3 = this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator3 = null;
                    }
                    int following = breakIterator3.following(i);
                    if (following == -1) {
                        return null;
                    }
                    return getRange(i, following);
                }
            } while (i != -1);
            return null;
        }

        public int[] preceding(int i) {
            int length = getText().length();
            if (length <= 0 || i <= 0) {
                return null;
            }
            if (i > length) {
                i = length;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (!breakIterator.isBoundary(i)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    i = breakIterator2.preceding(i);
                } else {
                    BreakIterator breakIterator3 = this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator3 = null;
                    }
                    int preceding = breakIterator3.preceding(i);
                    if (preceding == -1) {
                        return null;
                    }
                    return getRange(preceding, i);
                }
            } while (i != -1);
            return null;
        }

        private final void onLocaleChanged(Locale locale) {
            this.impl = BreakIterator.getCharacterInstance(locale);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "isEndBoundary", "", "index", "isLetterOrDigit", "isStartBoundary", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityIterators.android.kt */
    public static final class WordTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static WordTextSegmentIterator instance;
        private BreakIterator impl;

        public /* synthetic */ WordTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
            this(locale);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator$Companion;", "", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final WordTextSegmentIterator getInstance(Locale locale) {
                if (WordTextSegmentIterator.instance == null) {
                    WordTextSegmentIterator.instance = new WordTextSegmentIterator(locale, (DefaultConstructorMarker) null);
                }
                WordTextSegmentIterator access$getInstance$cp = WordTextSegmentIterator.instance;
                Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
                return access$getInstance$cp;
            }
        }

        private WordTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }

        public void initialize(String str) {
            super.initialize(str);
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            breakIterator.setText(str);
        }

        private final void onLocaleChanged(Locale locale) {
            this.impl = BreakIterator.getWordInstance(locale);
        }

        public int[] following(int i) {
            if (getText().length() <= 0 || i >= getText().length()) {
                return null;
            }
            if (i < 0) {
                i = 0;
            }
            while (!isLetterOrDigit(i) && !isStartBoundary(i)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                i = breakIterator.following(i);
                if (i == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator2 = null;
            }
            int following = breakIterator2.following(i);
            if (following == -1 || !isEndBoundary(following)) {
                return null;
            }
            return getRange(i, following);
        }

        public int[] preceding(int i) {
            int length = getText().length();
            if (length <= 0 || i <= 0) {
                return null;
            }
            if (i > length) {
                i = length;
            }
            while (i > 0 && !isLetterOrDigit(i - 1) && !isEndBoundary(i)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                i = breakIterator.preceding(i);
                if (i == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator2 = null;
            }
            int preceding = breakIterator2.preceding(i);
            if (preceding == -1 || !isStartBoundary(preceding)) {
                return null;
            }
            return getRange(preceding, i);
        }

        private final boolean isStartBoundary(int i) {
            if (!isLetterOrDigit(i) || (i != 0 && isLetterOrDigit(i - 1))) {
                return false;
            }
            return true;
        }

        private final boolean isEndBoundary(int i) {
            return i > 0 && isLetterOrDigit(i + -1) && (i == getText().length() || !isLetterOrDigit(i));
        }

        private final boolean isLetterOrDigit(int i) {
            if (i < 0 || i >= getText().length()) {
                return false;
            }
            return Character.isLetterOrDigit(getText().codePointAt(i));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "following", "", "current", "", "isEndBoundary", "", "index", "isStartBoundary", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityIterators.android.kt */
    public static final class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static ParagraphTextSegmentIterator instance;

        public /* synthetic */ ParagraphTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator$Companion;", "", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ParagraphTextSegmentIterator getInstance() {
                if (ParagraphTextSegmentIterator.instance == null) {
                    ParagraphTextSegmentIterator.instance = new ParagraphTextSegmentIterator((DefaultConstructorMarker) null);
                }
                ParagraphTextSegmentIterator access$getInstance$cp = ParagraphTextSegmentIterator.instance;
                Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
                return access$getInstance$cp;
            }
        }

        private ParagraphTextSegmentIterator() {
        }

        public int[] following(int i) {
            int length = getText().length();
            if (length <= 0 || i >= length) {
                return null;
            }
            if (i < 0) {
                i = 0;
            }
            while (i < length && getText().charAt(i) == 10 && !isStartBoundary(i)) {
                i++;
            }
            if (i >= length) {
                return null;
            }
            int i2 = i + 1;
            while (i2 < length && !isEndBoundary(i2)) {
                i2++;
            }
            return getRange(i, i2);
        }

        public int[] preceding(int i) {
            int length = getText().length();
            if (length <= 0 || i <= 0) {
                return null;
            }
            if (i > length) {
                i = length;
            }
            while (i > 0 && getText().charAt(i - 1) == 10 && !isEndBoundary(i)) {
                i--;
            }
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            while (i2 > 0 && !isStartBoundary(i2)) {
                i2--;
            }
            return getRange(i2, i);
        }

        private final boolean isStartBoundary(int i) {
            if (getText().charAt(i) == 10 || (i != 0 && getText().charAt(i - 1) != 10)) {
                return false;
            }
            return true;
        }

        private final boolean isEndBoundary(int i) {
            return i > 0 && getText().charAt(i + -1) != 10 && (i == getText().length() || getText().charAt(i) == 10);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityIterators.android.kt */
    public static final class LineTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
        /* access modifiers changed from: private */
        public static LineTextSegmentIterator lineInstance;
        private TextLayoutResult layoutResult;

        public /* synthetic */ LineTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator$Companion;", "", "()V", "DirectionEnd", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionStart", "lineInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LineTextSegmentIterator getInstance() {
                if (LineTextSegmentIterator.lineInstance == null) {
                    LineTextSegmentIterator.lineInstance = new LineTextSegmentIterator((DefaultConstructorMarker) null);
                }
                LineTextSegmentIterator access$getLineInstance$cp = LineTextSegmentIterator.lineInstance;
                Intrinsics.checkNotNull(access$getLineInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
                return access$getLineInstance$cp;
            }
        }

        private LineTextSegmentIterator() {
        }

        public final void initialize(String str, TextLayoutResult textLayoutResult) {
            setText(str);
            this.layoutResult = textLayoutResult;
        }

        public int[] following(int i) {
            int i2;
            if (getText().length() <= 0 || i >= getText().length()) {
                return null;
            }
            if (i < 0) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                i2 = textLayoutResult.getLineForOffset(0);
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(i);
                i2 = getLineEdgeIndex(lineForOffset, DirectionStart) == i ? lineForOffset : lineForOffset + 1;
            }
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (i2 >= textLayoutResult3.getLineCount()) {
                return null;
            }
            return getRange(getLineEdgeIndex(i2, DirectionStart), getLineEdgeIndex(i2, DirectionEnd) + 1);
        }

        public int[] preceding(int i) {
            int i2;
            if (getText().length() <= 0 || i <= 0) {
                return null;
            }
            if (i > getText().length()) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                i2 = textLayoutResult.getLineForOffset(getText().length());
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(i);
                i2 = getLineEdgeIndex(lineForOffset, DirectionEnd) + 1 == i ? lineForOffset : lineForOffset - 1;
            }
            if (i2 < 0) {
                return null;
            }
            return getRange(getLineEdgeIndex(i2, DirectionStart), getLineEdgeIndex(i2, DirectionEnd) + 1);
        }

        private final int getLineEdgeIndex(int i, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult = null;
            }
            int lineStart = textLayoutResult.getLineStart(i);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.getLineStart(i);
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.getLineEnd$default(textLayoutResult5, i, false, 2, (Object) null) - 1;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "tempRect", "Landroid/graphics/Rect;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AccessibilityIterators.android.kt */
    public static final class PageTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
        /* access modifiers changed from: private */
        public static PageTextSegmentIterator pageInstance;
        private TextLayoutResult layoutResult;
        private SemanticsNode node;
        private Rect tempRect;

        public /* synthetic */ PageTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator$Companion;", "", "()V", "DirectionEnd", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionStart", "pageInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PageTextSegmentIterator getInstance() {
                if (PageTextSegmentIterator.pageInstance == null) {
                    PageTextSegmentIterator.pageInstance = new PageTextSegmentIterator((DefaultConstructorMarker) null);
                }
                PageTextSegmentIterator access$getPageInstance$cp = PageTextSegmentIterator.pageInstance;
                Intrinsics.checkNotNull(access$getPageInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
                return access$getPageInstance$cp;
            }
        }

        private PageTextSegmentIterator() {
            this.tempRect = new Rect();
        }

        public final void initialize(String str, TextLayoutResult textLayoutResult, SemanticsNode semanticsNode) {
            setText(str);
            this.layoutResult = textLayoutResult;
            this.node = semanticsNode;
        }

        public int[] following(int i) {
            int i2;
            TextLayoutResult textLayoutResult = null;
            if (getText().length() <= 0 || i >= getText().length()) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                int roundToInt = MathKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
                int coerceAtLeast = RangesKt.coerceAtLeast(0, i);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtLeast);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) + ((float) roundToInt);
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult4 = null;
                }
                TextLayoutResult textLayoutResult5 = this.layoutResult;
                if (textLayoutResult5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult5 = null;
                }
                if (lineTop < textLayoutResult4.getLineTop(textLayoutResult5.getLineCount() - 1)) {
                    TextLayoutResult textLayoutResult6 = this.layoutResult;
                    if (textLayoutResult6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult6;
                    }
                    i2 = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    TextLayoutResult textLayoutResult7 = this.layoutResult;
                    if (textLayoutResult7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult7;
                    }
                    i2 = textLayoutResult.getLineCount();
                }
                return getRange(coerceAtLeast, getLineEdgeIndex(i2 - 1, DirectionEnd) + 1);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        public int[] preceding(int i) {
            int i2;
            TextLayoutResult textLayoutResult = null;
            if (getText().length() <= 0 || i <= 0) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                int roundToInt = MathKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
                int coerceAtMost = RangesKt.coerceAtMost(getText().length(), i);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtMost);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) - ((float) roundToInt);
                if (lineTop > 0.0f) {
                    TextLayoutResult textLayoutResult4 = this.layoutResult;
                    if (textLayoutResult4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult4;
                    }
                    i2 = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    i2 = 0;
                }
                if (coerceAtMost == getText().length() && i2 < lineForOffset) {
                    i2++;
                }
                return getRange(getLineEdgeIndex(i2, DirectionStart), coerceAtMost);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        private final int getLineEdgeIndex(int i, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult = null;
            }
            int lineStart = textLayoutResult.getLineStart(i);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.getLineStart(i);
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.getLineEnd$default(textLayoutResult5, i, false, 2, (Object) null) - 1;
        }
    }
}
