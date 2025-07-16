package androidx.compose.ui.text.android.animation;

import android.text.Layout;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.LayoutCompatKt;
import androidx.compose.ui.text.android.LayoutHelper;
import java.text.Bidi;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/android/animation/SegmentBreaker;", "", "()V", "breakInWords", "", "", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "breakOffsets", "segmentType", "Landroidx/compose/ui/text/android/animation/SegmentType;", "breakSegmentWithChar", "Landroidx/compose/ui/text/android/animation/Segment;", "dropSpaces", "", "breakSegmentWithDocument", "breakSegmentWithLine", "breakSegmentWithParagraph", "breakSegmentWithWord", "breakSegments", "breakWithBreakIterator", "text", "", "breaker", "Ljava/text/BreakIterator;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentBreaker.kt */
public final class SegmentBreaker {
    public static final int $stable = 0;
    public static final SegmentBreaker INSTANCE = new SegmentBreaker();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SegmentBreaker.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.ui.text.android.animation.SegmentType[] r0 = androidx.compose.ui.text.android.animation.SegmentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.text.android.animation.SegmentType r1 = androidx.compose.ui.text.android.animation.SegmentType.Document     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.text.android.animation.SegmentType r1 = androidx.compose.ui.text.android.animation.SegmentType.Paragraph     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.text.android.animation.SegmentType r1 = androidx.compose.ui.text.android.animation.SegmentType.Line     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.text.android.animation.SegmentType r1 = androidx.compose.ui.text.android.animation.SegmentType.Word     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.ui.text.android.animation.SegmentType r1 = androidx.compose.ui.text.android.animation.SegmentType.Character     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.animation.SegmentBreaker.WhenMappings.<clinit>():void");
        }
    }

    private SegmentBreaker() {
    }

    private final List<Integer> breakInWords(LayoutHelper layoutHelper) {
        List<Integer> breakWithBreakIterator = breakWithBreakIterator(layoutHelper.getLayout().getText(), BreakIterator.getLineInstance(Locale.getDefault()));
        TreeSet treeSet = new TreeSet();
        int size = breakWithBreakIterator.size();
        for (int i = 0; i < size; i++) {
            treeSet.add(Integer.valueOf(breakWithBreakIterator.get(i).intValue()));
        }
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i2 = 0; i2 < paragraphCount; i2++) {
            Bidi analyzeBidi = layoutHelper.analyzeBidi(i2);
            if (analyzeBidi != null) {
                int paragraphStart = layoutHelper.getParagraphStart(i2);
                int runCount = analyzeBidi.getRunCount();
                for (int i3 = 0; i3 < runCount; i3++) {
                    treeSet.add(Integer.valueOf(analyzeBidi.getRunStart(i3) + paragraphStart));
                }
            }
        }
        return CollectionsKt.toList(treeSet);
    }

    private final List<Integer> breakWithBreakIterator(CharSequence charSequence, BreakIterator breakIterator) {
        CharSequenceCharacterIterator charSequenceCharacterIterator = new CharSequenceCharacterIterator(charSequence, 0, charSequence.length());
        List<Integer> mutableListOf = CollectionsKt.mutableListOf(0);
        breakIterator.setText(charSequenceCharacterIterator);
        while (breakIterator.next() != -1) {
            mutableListOf.add(Integer.valueOf(breakIterator.current()));
        }
        return mutableListOf;
    }

    public final List<Integer> breakOffsets(LayoutHelper layoutHelper, SegmentType segmentType) {
        Layout layout = layoutHelper.getLayout();
        CharSequence text = layout.getText();
        int i = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        int i2 = 0;
        if (i == 1) {
            return CollectionsKt.listOf(0, Integer.valueOf(text.length()));
        } else if (i == 2) {
            List<Integer> mutableListOf = CollectionsKt.mutableListOf(0);
            int paragraphCount = layoutHelper.getParagraphCount();
            while (i2 < paragraphCount) {
                mutableListOf.add(Integer.valueOf(layoutHelper.getParagraphEnd(i2)));
                i2++;
            }
            return mutableListOf;
        } else if (i == 3) {
            List<Integer> mutableListOf2 = CollectionsKt.mutableListOf(0);
            int lineCount = layout.getLineCount();
            while (i2 < lineCount) {
                mutableListOf2.add(Integer.valueOf(layout.getLineEnd(i2)));
                i2++;
            }
            return mutableListOf2;
        } else if (i == 4) {
            return breakInWords(layoutHelper);
        } else {
            if (i == 5) {
                return breakWithBreakIterator(text, BreakIterator.getCharacterInstance(Locale.getDefault()));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final List<Segment> breakSegments(LayoutHelper layoutHelper, SegmentType segmentType, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        if (i == 1) {
            return breakSegmentWithDocument(layoutHelper);
        }
        if (i == 2) {
            return breakSegmentWithParagraph(layoutHelper);
        }
        if (i == 3) {
            return breakSegmentWithLine(layoutHelper, z);
        }
        if (i == 4) {
            return breakSegmentWithWord(layoutHelper, z);
        }
        if (i == 5) {
            return breakSegmentWithChar(layoutHelper, z);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<Segment> breakSegmentWithDocument(LayoutHelper layoutHelper) {
        return CollectionsKt.listOf(new Segment(0, layoutHelper.getLayout().getText().length(), 0, 0, layoutHelper.getLayout().getWidth(), layoutHelper.getLayout().getHeight()));
    }

    private final List<Segment> breakSegmentWithParagraph(LayoutHelper layoutHelper) {
        List<Segment> arrayList = new ArrayList<>();
        Layout layout = layoutHelper.getLayout();
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i = 0; i < paragraphCount; i++) {
            int paragraphStart = layoutHelper.getParagraphStart(i);
            int paragraphEnd = layoutHelper.getParagraphEnd(i);
            arrayList.add(new Segment(paragraphStart, paragraphEnd, 0, layout.getLineTop(LayoutCompatKt.getLineForOffset(layout, paragraphStart, false)), layout.getWidth(), layout.getLineBottom(LayoutCompatKt.getLineForOffset(layout, paragraphEnd, true))));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithLine(LayoutHelper layoutHelper, boolean z) {
        List<Segment> arrayList = new ArrayList<>();
        Layout layout = layoutHelper.getLayout();
        int lineCount = layoutHelper.getLayout().getLineCount();
        for (int i = 0; i < lineCount; i++) {
            arrayList.add(new Segment(layout.getLineStart(i), layout.getLineEnd(i), z ? (int) ((float) Math.ceil((double) layout.getLineLeft(i))) : 0, layout.getLineTop(i), z ? (int) ((float) Math.ceil((double) layout.getLineRight(i))) : layout.getWidth(), layout.getLineBottom(i)));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithWord(LayoutHelper layoutHelper, boolean z) {
        int i;
        LayoutHelper layoutHelper2 = layoutHelper;
        Layout layout = layoutHelper.getLayout();
        int ceil = (int) ((float) Math.ceil((double) layout.getPaint().measureText(" ")));
        List<Integer> breakOffsets = breakOffsets(layoutHelper2, SegmentType.Word);
        if (breakOffsets.size() != 0) {
            boolean z2 = true;
            if (breakOffsets.size() != 1) {
                List<Segment> arrayList = new ArrayList<>();
                boolean z3 = false;
                Integer num = breakOffsets.get(0);
                int lastIndex = CollectionsKt.getLastIndex(breakOffsets);
                int i2 = 0;
                while (i2 < lastIndex) {
                    i2++;
                    Integer num2 = breakOffsets.get(i2);
                    int intValue = num2.intValue();
                    int intValue2 = num.intValue();
                    int lineForOffset = LayoutCompatKt.getLineForOffset(layout, intValue2, z3);
                    boolean z4 = layout.getParagraphDirection(lineForOffset) == -1 ? z2 : z3;
                    boolean isRtlCharAt = layout.isRtlCharAt(intValue2);
                    if (isRtlCharAt != z4) {
                        z2 = z3;
                    }
                    int i3 = lineForOffset;
                    int ceil2 = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue2, z2, z3)));
                    boolean z5 = isRtlCharAt == z4;
                    int i4 = lastIndex;
                    int ceil3 = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue, z5, true)));
                    int min = Math.min(ceil2, ceil3);
                    int max = Math.max(ceil2, ceil3);
                    if (!z || intValue == 0 || layout.getText().charAt(intValue - 1) != ' ') {
                        i = i3;
                    } else {
                        i = i3;
                        if (layout.getLineEnd(i) != intValue) {
                            if (isRtlCharAt) {
                                min += ceil;
                            } else {
                                max -= ceil;
                            }
                        }
                    }
                    arrayList.add(new Segment(intValue2, intValue, min, layout.getLineTop(i), max, layout.getLineBottom(i)));
                    num = num2;
                    lastIndex = i4;
                    z2 = true;
                    z3 = false;
                }
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }

    private final List<Segment> breakSegmentWithChar(LayoutHelper layoutHelper, boolean z) {
        int i;
        LayoutHelper layoutHelper2 = layoutHelper;
        List<Segment> arrayList = new ArrayList<>();
        List<Integer> breakOffsets = breakOffsets(layoutHelper2, SegmentType.Character);
        if (breakOffsets.size() != 0) {
            boolean z2 = true;
            if (breakOffsets.size() != 1) {
                List arrayList2 = new ArrayList();
                boolean z3 = false;
                Integer num = breakOffsets.get(0);
                int lastIndex = CollectionsKt.getLastIndex(breakOffsets);
                int i2 = 0;
                while (i2 < lastIndex) {
                    i2++;
                    Integer num2 = breakOffsets.get(i2);
                    int intValue = num2.intValue();
                    int intValue2 = num.intValue();
                    Layout layout = layoutHelper.getLayout();
                    if (!z || intValue != intValue2 + 1 || !layoutHelper2.isLineEndSpace(layout.getText().charAt(intValue2))) {
                        int lineForOffset = LayoutCompatKt.getLineForOffset(layout, intValue2, z3);
                        boolean z4 = layout.getParagraphDirection(lineForOffset) == -1 ? z2 : z3;
                        boolean isRtlCharAt = layout.isRtlCharAt(intValue2);
                        if (isRtlCharAt != z4) {
                            z2 = z3;
                        }
                        Layout layout2 = layout;
                        int ceil = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue2, z2, z3)));
                        i = lastIndex;
                        int ceil2 = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue, isRtlCharAt == z4, true)));
                        Layout layout3 = layout2;
                        arrayList.add(new Segment(intValue2, intValue, Math.min(ceil, ceil2), layout3.getLineTop(lineForOffset), Math.max(ceil, ceil2), layout3.getLineBottom(lineForOffset)));
                    } else {
                        i = lastIndex;
                    }
                    arrayList2.add(Unit.INSTANCE);
                    num = num2;
                    lastIndex = i;
                    z2 = true;
                    z3 = false;
                }
                return arrayList;
            }
        }
        CollectionsKt.emptyList();
        return arrayList;
    }
}
