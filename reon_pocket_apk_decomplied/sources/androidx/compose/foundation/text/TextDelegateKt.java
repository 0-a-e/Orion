package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\f\u0010\u0018\u001a\u00020\u0010*\u00020\u0019H\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "ceilToIntPx", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextDelegate.kt */
public final class TextDelegateKt {
    public static final int ceilToIntPx(float f) {
        return MathKt.roundToInt((float) Math.ceil((double) f));
    }

    /* renamed from: updateTextDelegate-rm0N8CA$default  reason: not valid java name */
    public static /* synthetic */ TextDelegate m1118updateTextDelegaterm0N8CA$default(TextDelegate textDelegate, AnnotatedString annotatedString, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z, int i, int i2, int i3, List list, int i4, Object obj) {
        int i5 = i4;
        return m1117updateTextDelegaterm0N8CA(textDelegate, annotatedString, textStyle, density, resolver, (i5 & 32) != 0 ? true : z, (i5 & 64) != 0 ? TextOverflow.Companion.m6511getClipgIe3tQ8() : i, (i5 & 128) != 0 ? Integer.MAX_VALUE : i2, (i5 & 256) != 0 ? 1 : i3, list);
    }

    /* renamed from: updateTextDelegate-rm0N8CA  reason: not valid java name */
    public static final TextDelegate m1117updateTextDelegaterm0N8CA(TextDelegate textDelegate, AnnotatedString annotatedString, TextStyle textStyle, Density density, FontFamily.Resolver resolver, boolean z, int i, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list) {
        AnnotatedString annotatedString2 = annotatedString;
        if (Intrinsics.areEqual((Object) textDelegate.getText(), (Object) annotatedString)) {
            TextStyle textStyle2 = textStyle;
            if (Intrinsics.areEqual((Object) textDelegate.getStyle(), (Object) textStyle)) {
                if (textDelegate.getSoftWrap() != z) {
                    Density density2 = density;
                    FontFamily.Resolver resolver2 = resolver;
                    int i4 = i;
                    int i5 = i2;
                    int i6 = i3;
                    List<AnnotatedString.Range<Placeholder>> list2 = list;
                    return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, (DefaultConstructorMarker) null);
                } else if (!TextOverflow.m6504equalsimpl0(textDelegate.m1115getOverflowgIe3tQ8(), i)) {
                    Density density3 = density;
                    FontFamily.Resolver resolver3 = resolver;
                    int i52 = i2;
                    int i62 = i3;
                    List<AnnotatedString.Range<Placeholder>> list22 = list;
                    return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, (DefaultConstructorMarker) null);
                } else if (textDelegate.getMaxLines() == i2) {
                    if (textDelegate.getMinLines() == i3) {
                        Density density4 = density;
                        if (Intrinsics.areEqual((Object) textDelegate.getDensity(), (Object) density)) {
                            if (!Intrinsics.areEqual((Object) textDelegate.getPlaceholders(), (Object) list)) {
                                FontFamily.Resolver resolver4 = resolver;
                            } else if (textDelegate.getFontFamilyResolver() == resolver) {
                                return textDelegate;
                            }
                            return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, (DefaultConstructorMarker) null);
                        }
                    } else {
                        Density density5 = density;
                    }
                    FontFamily.Resolver resolver5 = resolver;
                    List<AnnotatedString.Range<Placeholder>> list222 = list;
                    return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, (DefaultConstructorMarker) null);
                } else {
                    Density density6 = density;
                    FontFamily.Resolver resolver6 = resolver;
                    int i622 = i3;
                    List<AnnotatedString.Range<Placeholder>> list2222 = list;
                    return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, (DefaultConstructorMarker) null);
                }
            }
        } else {
            TextStyle textStyle3 = textStyle;
        }
        Density density7 = density;
        FontFamily.Resolver resolver7 = resolver;
        boolean z2 = z;
        int i42 = i;
        int i522 = i2;
        int i6222 = i3;
        List<AnnotatedString.Range<Placeholder>> list22222 = list;
        return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, (DefaultConstructorMarker) null);
    }
}
