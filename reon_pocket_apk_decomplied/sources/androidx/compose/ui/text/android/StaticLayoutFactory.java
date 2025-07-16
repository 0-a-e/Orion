package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JØ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0003\u0010\u0016\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory;", "", "()V", "delegate", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "create", "Landroid/text/StaticLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "start", "end", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "isFallbackLineSpacingEnabled", "layout", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StaticLayoutFactory.kt */
public final class StaticLayoutFactory {
    public static final int $stable = 8;
    public static final StaticLayoutFactory INSTANCE = new StaticLayoutFactory();
    private static final StaticLayoutFactoryImpl delegate = new StaticLayoutFactory23();

    private StaticLayoutFactory() {
    }

    public static /* synthetic */ StaticLayout create$default(StaticLayoutFactory staticLayoutFactory, CharSequence charSequence, TextPaint textPaint, int i, int i2, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i4, TextUtils.TruncateAt truncateAt, int i5, float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2, int i11, Object obj) {
        int i12 = i11;
        return staticLayoutFactory.create(charSequence, textPaint, i, (i12 & 8) != 0 ? 0 : i2, (i12 & 16) != 0 ? charSequence.length() : i3, (i12 & 32) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release() : textDirectionHeuristic, (i12 & 64) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_LAYOUT_ALIGNMENT$ui_text_release() : alignment, (i12 & 128) != 0 ? Integer.MAX_VALUE : i4, (i12 & 256) != 0 ? null : truncateAt, (i12 & 512) != 0 ? i : i5, (i12 & 1024) != 0 ? 1.0f : f, (i12 & 2048) != 0 ? 0.0f : f2, (i12 & 4096) != 0 ? 0 : i6, (i12 & 8192) != 0 ? false : z, (i12 & 16384) != 0 ? true : z2, (32768 & i12) != 0 ? 0 : i7, (65536 & i12) != 0 ? 0 : i8, (131072 & i12) != 0 ? 0 : i9, (262144 & i12) != 0 ? 0 : i10, (524288 & i12) != 0 ? null : iArr, (i12 & 1048576) != 0 ? null : iArr2);
    }

    public final StaticLayout create(CharSequence charSequence, TextPaint textPaint, int i, int i2, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i4, TextUtils.TruncateAt truncateAt, int i5, float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2) {
        CharSequence charSequence2 = charSequence;
        StaticLayoutFactoryImpl staticLayoutFactoryImpl = delegate;
        StaticLayoutParams staticLayoutParams = r0;
        CharSequence charSequence3 = charSequence;
        StaticLayoutParams staticLayoutParams2 = new StaticLayoutParams(charSequence3, i2, i3, textPaint, i, textDirectionHeuristic, alignment, i4, truncateAt, i5, f, f2, i6, z, z2, i7, i8, i9, i10, iArr, iArr2);
        return staticLayoutFactoryImpl.create(staticLayoutParams);
    }

    public final boolean isFallbackLineSpacingEnabled(StaticLayout staticLayout, boolean z) {
        return delegate.isFallbackLineSpacingEnabled(staticLayout, z);
    }
}
