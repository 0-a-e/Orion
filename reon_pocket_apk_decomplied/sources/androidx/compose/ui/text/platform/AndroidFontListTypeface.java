package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ*\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\b\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "getNativeTypeface", "fontWeight", "fontStyle", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "This is not supported after downloadable fonts.")
/* compiled from: AndroidFontListTypeface.android.kt */
public final class AndroidFontListTypeface implements AndroidTypeface {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FontMatcher fontMatcher = new FontMatcher();
    private final FontFamily fontFamily;
    private final FontMatcher fontMatcher$1;
    private final Map<Font, Typeface> loadedTypefaces;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AndroidFontListTypeface(androidx.compose.ui.text.font.FontListFontFamily r9, android.content.Context r10, java.util.List<kotlin.Pair<androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle>> r11, androidx.compose.ui.text.font.FontMatcher r12) {
        /*
            r8 = this;
            r8.<init>()
            r8.fontMatcher$1 = r12
            java.util.List r12 = r9.getFonts()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.size()
            r0.<init>(r1)
            int r1 = r12.size()
            r2 = 0
            r3 = r2
        L_0x0018:
            if (r3 >= r1) goto L_0x003a
            java.lang.Object r4 = r12.get(r3)
            r5 = r4
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            int r5 = r5.m6128getLoadingStrategyPKNRLFQ()
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r6 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r6 = r6.m6150getBlockingPKNRLFQ()
            boolean r5 = androidx.compose.ui.text.font.FontLoadingStrategy.m6145equalsimpl0(r5, r6)
            if (r5 == 0) goto L_0x0037
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            r5.add(r4)
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x003a:
            java.util.List r0 = (java.util.List) r0
            if (r11 == 0) goto L_0x00b3
            java.util.ArrayList r12 = new java.util.ArrayList
            int r1 = r11.size()
            r12.<init>(r1)
            int r1 = r11.size()
            r3 = r2
        L_0x004c:
            if (r3 >= r1) goto L_0x0079
            java.lang.Object r4 = r11.get(r3)
            r5 = r12
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r6 = r4.component1()
            androidx.compose.ui.text.font.FontWeight r6 = (androidx.compose.ui.text.font.FontWeight) r6
            java.lang.Object r4 = r4.component2()
            androidx.compose.ui.text.font.FontStyle r4 = (androidx.compose.ui.text.font.FontStyle) r4
            int r4 = r4.m6161unboximpl()
            androidx.compose.ui.text.font.FontMatcher r7 = r8.fontMatcher$1
            java.util.List r4 = r7.m6154matchFontRetOiIg((java.util.List<? extends androidx.compose.ui.text.font.Font>) r0, (androidx.compose.ui.text.font.FontWeight) r6, (int) r4)
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            r5.add(r4)
            int r3 = r3 + 1
            goto L_0x004c
        L_0x0079:
            java.util.List r12 = (java.util.List) r12
            java.util.List r11 = androidx.compose.ui.util.ListUtilsKt.fastFilterNotNull(r12)
            if (r11 == 0) goto L_0x00b3
            java.util.HashSet r12 = new java.util.HashSet
            int r1 = r11.size()
            r12.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = r11.size()
            r1.<init>(r3)
            int r3 = r11.size()
            r4 = r2
        L_0x0098:
            if (r4 >= r3) goto L_0x00b0
            java.lang.Object r5 = r11.get(r4)
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            boolean r6 = r12.add(r6)
            if (r6 == 0) goto L_0x00ad
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            r6.add(r5)
        L_0x00ad:
            int r4 = r4 + 1
            goto L_0x0098
        L_0x00b0:
            java.util.List r1 = (java.util.List) r1
            goto L_0x00b4
        L_0x00b3:
            r1 = 0
        L_0x00b4:
            if (r1 != 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r0 = r1
        L_0x00b8:
            r11 = r0
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ 1
            if (r11 == 0) goto L_0x00fd
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            java.util.Map r11 = (java.util.Map) r11
            int r12 = r0.size()
        L_0x00ce:
            if (r2 >= r12) goto L_0x00f6
            java.lang.Object r1 = r0.get(r2)
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            androidx.compose.ui.text.platform.AndroidTypefaceCache r3 = androidx.compose.ui.text.platform.AndroidTypefaceCache.INSTANCE     // Catch:{ Exception -> 0x00e2 }
            android.graphics.Typeface r3 = r3.getOrCreate(r10, r1)     // Catch:{ Exception -> 0x00e2 }
            r11.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            int r2 = r2 + 1
            goto L_0x00ce
        L_0x00e2:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Cannot create Typeface from "
            r10.<init>(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00f6:
            r8.loadedTypefaces = r11
            androidx.compose.ui.text.font.FontFamily r9 = (androidx.compose.ui.text.font.FontFamily) r9
            r8.fontFamily = r9
            return
        L_0x00fd:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Could not match font"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidFontListTypeface.<init>(androidx.compose.ui.text.font.FontListFontFamily, android.content.Context, java.util.List, androidx.compose.ui.text.font.FontMatcher):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontListFontFamily, context, (i & 4) != 0 ? null : list, (i & 8) != 0 ? fontMatcher : fontMatcher2);
    }

    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidFontListTypeface.android.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: getNativeTypeface-PYhJU0U  reason: not valid java name */
    public Typeface m6306getNativeTypefacePYhJU0U(FontWeight fontWeight, int i, int i2) {
        Font font = (Font) CollectionsKt.firstOrNull(this.fontMatcher$1.m6154matchFontRetOiIg((List<? extends Font>) new ArrayList(this.loadedTypefaces.keySet()), fontWeight, i));
        if (font != null) {
            Typeface typeface = this.loadedTypefaces.get(font);
            if (typeface != null) {
                Object r4 = FontSynthesis_androidKt.m6179synthesizeTypefaceFxwP2eA(i2, typeface, font, fontWeight, i);
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface) r4;
            }
            throw new IllegalStateException("Could not load typeface".toString());
        }
        throw new IllegalStateException("Could not load font".toString());
    }
}
