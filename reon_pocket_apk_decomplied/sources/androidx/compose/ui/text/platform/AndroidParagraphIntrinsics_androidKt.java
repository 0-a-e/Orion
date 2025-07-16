package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"hasEmojiCompat", "", "Landroidx/compose/ui/text/TextStyle;", "getHasEmojiCompat", "(Landroidx/compose/ui/text/TextStyle;)Z", "ActualParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolveTextDirectionHeuristics", "", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "resolveTextDirectionHeuristics-HklW4sA", "(ILandroidx/compose/ui/text/intl/LocaleList;)I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidParagraphIntrinsics.android.kt */
public final class AndroidParagraphIntrinsics_androidKt {
    /* renamed from: resolveTextDirectionHeuristics-HklW4sA$default  reason: not valid java name */
    public static /* synthetic */ int m6314resolveTextDirectionHeuristicsHklW4sA$default(int i, LocaleList localeList, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            localeList = null;
        }
        return m6313resolveTextDirectionHeuristicsHklW4sA(i, localeList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        if (r5 == null) goto L_0x006d;
     */
    /* renamed from: resolveTextDirectionHeuristics-HklW4sA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int m6313resolveTextDirectionHeuristicsHklW4sA(int r5, androidx.compose.ui.text.intl.LocaleList r6) {
        /*
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r0 = r0.m6475getContentOrLtrs_7Xco()
            boolean r0 = androidx.compose.ui.text.style.TextDirection.m6470equalsimpl0(r5, r0)
            r1 = 2
            if (r0 == 0) goto L_0x000f
            goto L_0x0079
        L_0x000f:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r0 = r0.m6476getContentOrRtls_7Xco()
            boolean r0 = androidx.compose.ui.text.style.TextDirection.m6470equalsimpl0(r5, r0)
            r2 = 3
            if (r0 == 0) goto L_0x001e
        L_0x001c:
            r1 = r2
            goto L_0x0079
        L_0x001e:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r0 = r0.m6477getLtrs_7Xco()
            boolean r0 = androidx.compose.ui.text.style.TextDirection.m6470equalsimpl0(r5, r0)
            r3 = 0
            if (r0 == 0) goto L_0x002d
            r1 = r3
            goto L_0x0079
        L_0x002d:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r0 = r0.m6478getRtls_7Xco()
            boolean r0 = androidx.compose.ui.text.style.TextDirection.m6470equalsimpl0(r5, r0)
            r4 = 1
            if (r0 == 0) goto L_0x003c
            r1 = r4
            goto L_0x0079
        L_0x003c:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r0 = r0.m6474getContents_7Xco()
            boolean r0 = androidx.compose.ui.text.style.TextDirection.m6470equalsimpl0(r5, r0)
            if (r0 == 0) goto L_0x004a
            r5 = r4
            goto L_0x0054
        L_0x004a:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r0 = r0.m6479getUnspecifieds_7Xco()
            boolean r5 = androidx.compose.ui.text.style.TextDirection.m6470equalsimpl0(r5, r0)
        L_0x0054:
            if (r5 == 0) goto L_0x007a
            if (r6 == 0) goto L_0x006d
            androidx.compose.ui.text.intl.Locale r5 = r6.get(r3)
            androidx.compose.ui.text.intl.PlatformLocale r5 = r5.getPlatformLocale$ui_text_release()
            java.lang.String r6 = "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r6)
            androidx.compose.ui.text.intl.AndroidLocale r5 = (androidx.compose.ui.text.intl.AndroidLocale) r5
            java.util.Locale r5 = r5.getJavaLocale()
            if (r5 != 0) goto L_0x0071
        L_0x006d:
            java.util.Locale r5 = java.util.Locale.getDefault()
        L_0x0071:
            int r5 = androidx.core.text.TextUtilsCompat.getLayoutDirectionFromLocale(r5)
            if (r5 == 0) goto L_0x0079
            if (r5 == r4) goto L_0x001c
        L_0x0079:
            return r1
        L_0x007a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Invalid TextDirection."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt.m6313resolveTextDirectionHeuristicsHklW4sA(int, androidx.compose.ui.text.intl.LocaleList):int");
    }

    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, Density density, FontFamily.Resolver resolver) {
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.getParagraphStyle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean getHasEmojiCompat(androidx.compose.ui.text.TextStyle r1) {
        /*
            androidx.compose.ui.text.PlatformTextStyle r1 = r1.getPlatformStyle()
            if (r1 == 0) goto L_0x0015
            androidx.compose.ui.text.PlatformParagraphStyle r1 = r1.getParagraphStyle()
            if (r1 == 0) goto L_0x0015
            int r1 = r1.m5980getEmojiSupportMatch_3YsG6Y()
            androidx.compose.ui.text.EmojiSupportMatch r1 = androidx.compose.ui.text.EmojiSupportMatch.m5900boximpl(r1)
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            androidx.compose.ui.text.EmojiSupportMatch$Companion r0 = androidx.compose.ui.text.EmojiSupportMatch.Companion
            int r0 = r0.m5908getNone_3YsG6Y()
            if (r1 != 0) goto L_0x0020
            r1 = 0
            goto L_0x0028
        L_0x0020:
            int r1 = r1.m5906unboximpl()
            boolean r1 = androidx.compose.ui.text.EmojiSupportMatch.m5903equalsimpl0(r1, r0)
        L_0x0028:
            r1 = r1 ^ 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(androidx.compose.ui.text.TextStyle):boolean");
    }
}
