package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraph_androidKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001ax\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\f\u0010!\u001a\u00020\u0001*\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"DefaultMaxLines", "", "Paragraph", "Landroidx/compose/ui/text/Paragraph;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "maxLines", "ellipsis", "", "Paragraph-_EkL_-Y", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JIZ)Landroidx/compose/ui/text/Paragraph;", "width", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "Paragraph-UdtVg6A", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;IZ)Landroidx/compose/ui/text/Paragraph;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ceilToInt", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Paragraph.kt */
public final class ParagraphKt {
    public static final int DefaultMaxLines = Integer.MAX_VALUE;

    public static /* synthetic */ Paragraph Paragraph$default(String str, TextStyle textStyle, List list, List list2, int i, boolean z, float f, Density density, Font.ResourceLoader resourceLoader, int i2, Object obj) {
        return Paragraph(str, textStyle, (List<AnnotatedString.Range<SpanStyle>>) (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (List<AnnotatedString.Range<Placeholder>>) (i2 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 16) != 0 ? Integer.MAX_VALUE : i, (i2 & 32) != 0 ? false : z, f, density, resourceLoader);
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated, instead pass FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "Paragraph(text, style, spanStyles, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    public static final Paragraph Paragraph(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z, float f, Density density, Font.ResourceLoader resourceLoader) {
        return AndroidParagraph_androidKt.ActualParagraph(str, textStyle, list, list2, i, z, f, density, resourceLoader);
    }

    public static /* synthetic */ Paragraph Paragraph$default(String str, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List list, List list2, int i, boolean z, int i2, Object obj) {
        List list3;
        int i3 = i2;
        List emptyList = (i3 & 32) != 0 ? CollectionsKt.emptyList() : list;
        if ((i3 & 64) != 0) {
            list3 = CollectionsKt.emptyList();
        } else {
            list3 = list2;
        }
        return Paragraph(str, textStyle, f, density, resolver, (List<AnnotatedString.Range<SpanStyle>>) emptyList, (List<AnnotatedString.Range<Placeholder>>) list3, (i3 & 128) != 0 ? Integer.MAX_VALUE : i, (i3 & 256) != 0 ? false : z);
    }

    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "Paragraph(text, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, spanStyles, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public static final Paragraph Paragraph(String str, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z) {
        return AndroidParagraph_androidKt.m6316ActualParagraphO3s9Psw(str, textStyle, list, list2, i, z, ConstraintsKt.Constraints$default(0, ceilToInt(f), 0, 0, 13, (Object) null), density, resolver);
    }

    /* renamed from: Paragraph-UdtVg6A$default  reason: not valid java name */
    public static /* synthetic */ Paragraph m5934ParagraphUdtVg6A$default(String str, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, List list2, int i, boolean z, int i2, Object obj) {
        List list3;
        int i3 = i2;
        List emptyList = (i3 & 32) != 0 ? CollectionsKt.emptyList() : list;
        if ((i3 & 64) != 0) {
            list3 = CollectionsKt.emptyList();
        } else {
            list3 = list2;
        }
        return m5933ParagraphUdtVg6A(str, textStyle, j, density, resolver, emptyList, list3, (i3 & 128) != 0 ? Integer.MAX_VALUE : i, (i3 & 256) != 0 ? false : z);
    }

    /* renamed from: Paragraph-UdtVg6A  reason: not valid java name */
    public static final Paragraph m5933ParagraphUdtVg6A(String str, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, boolean z) {
        return AndroidParagraph_androidKt.m6316ActualParagraphO3s9Psw(str, textStyle, list, list2, i, z, j, density, resolver);
    }

    public static /* synthetic */ Paragraph Paragraph$default(ParagraphIntrinsics paragraphIntrinsics, int i, boolean z, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Paragraph(paragraphIntrinsics, i, z, f);
    }

    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "Paragraph(paragraphIntrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public static final Paragraph Paragraph(ParagraphIntrinsics paragraphIntrinsics, int i, boolean z, float f) {
        return AndroidParagraph_androidKt.m6315ActualParagraphhBUhpc(paragraphIntrinsics, i, z, ConstraintsKt.Constraints$default(0, ceilToInt(f), 0, 0, 13, (Object) null));
    }

    /* renamed from: Paragraph-_EkL_-Y$default  reason: not valid java name */
    public static /* synthetic */ Paragraph m5936Paragraph_EkL_Y$default(ParagraphIntrinsics paragraphIntrinsics, long j, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return m5935Paragraph_EkL_Y(paragraphIntrinsics, j, i, z);
    }

    /* renamed from: Paragraph-_EkL_-Y  reason: not valid java name */
    public static final Paragraph m5935Paragraph_EkL_Y(ParagraphIntrinsics paragraphIntrinsics, long j, int i, boolean z) {
        return AndroidParagraph_androidKt.m6315ActualParagraphhBUhpc(paragraphIntrinsics, i, z, j);
    }

    public static final int ceilToInt(float f) {
        return (int) ((float) Math.ceil((double) f));
    }
}
