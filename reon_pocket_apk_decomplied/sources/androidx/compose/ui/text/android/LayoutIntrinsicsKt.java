package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"minIntrinsicWidth", "", "text", "", "paint", "Landroid/text/TextPaint;", "shouldIncreaseMaxIntrinsic", "", "desiredWidth", "charSequence", "textPaint", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutIntrinsics.kt */
public final class LayoutIntrinsicsKt {
    public static final float minIntrinsicWidth(CharSequence charSequence, TextPaint textPaint) {
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        int i = 0;
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, 0, charSequence.length()));
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(10, new LayoutIntrinsicsKt$$ExternalSyntheticLambda0());
        int next = lineInstance.next();
        while (true) {
            int i2 = i;
            i = next;
            int i3 = i2;
            if (i == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue() < i - i3) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(i3), Integer.valueOf(i)));
                }
            }
            next = lineInstance.next();
        }
        float f = 0.0f;
        for (Pair pair2 : priorityQueue) {
            f = Math.max(f, Layout.getDesiredWidth(charSequence, ((Number) pair2.component1()).intValue(), ((Number) pair2.component2()).intValue(), textPaint));
        }
        return f;
    }

    /* access modifiers changed from: private */
    public static final int minIntrinsicWidth$lambda$0(Pair pair, Pair pair2) {
        return (((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue()) - (((Number) pair2.getSecond()).intValue() - ((Number) pair2.getFirst()).intValue());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (androidx.compose.ui.text.android.SpannedExtensionsKt.hasSpan(r2, androidx.compose.ui.text.android.style.LetterSpacingSpanEm.class) == false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean shouldIncreaseMaxIntrinsic(float r1, java.lang.CharSequence r2, android.text.TextPaint r3) {
        /*
            r0 = 0
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x0006
            goto L_0x0024
        L_0x0006:
            boolean r1 = r2 instanceof android.text.Spanned
            if (r1 == 0) goto L_0x001c
            android.text.Spanned r2 = (android.text.Spanned) r2
            java.lang.Class<androidx.compose.ui.text.android.style.LetterSpacingSpanPx> r1 = androidx.compose.ui.text.android.style.LetterSpacingSpanPx.class
            boolean r1 = androidx.compose.ui.text.android.SpannedExtensionsKt.hasSpan(r2, r1)
            if (r1 != 0) goto L_0x0026
            java.lang.Class<androidx.compose.ui.text.android.style.LetterSpacingSpanEm> r1 = androidx.compose.ui.text.android.style.LetterSpacingSpanEm.class
            boolean r1 = androidx.compose.ui.text.android.SpannedExtensionsKt.hasSpan(r2, r1)
            if (r1 != 0) goto L_0x0026
        L_0x001c:
            float r1 = r3.getLetterSpacing()
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x0026
        L_0x0024:
            r1 = 0
            goto L_0x0027
        L_0x0026:
            r1 = 1
        L_0x0027:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutIntrinsicsKt.shouldIncreaseMaxIntrinsic(float, java.lang.CharSequence, android.text.TextPaint):boolean");
    }
}
