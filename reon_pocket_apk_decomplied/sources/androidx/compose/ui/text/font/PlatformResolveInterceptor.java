package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "", "interceptFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "interceptFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "interceptFontStyle-T2F_aPo", "(I)I", "interceptFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "interceptFontSynthesis-Mscr08Y", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.kt */
public interface PlatformResolveInterceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: androidx.compose.ui.text.font.PlatformResolveInterceptor$-CC  reason: invalid class name */
    /* compiled from: FontFamilyResolver.kt */
    public final /* synthetic */ class CC {
        public static FontFamily $default$interceptFontFamily(PlatformResolveInterceptor _this, FontFamily fontFamily) {
            return fontFamily;
        }

        /* renamed from: $default$interceptFontStyle-T2F_aPo  reason: not valid java name */
        public static int m6185$default$interceptFontStyleT2F_aPo(PlatformResolveInterceptor _this, int i) {
            return i;
        }

        /* renamed from: $default$interceptFontSynthesis-Mscr08Y  reason: not valid java name */
        public static int m6186$default$interceptFontSynthesisMscr08Y(PlatformResolveInterceptor _this, int i) {
            return i;
        }

        public static FontWeight $default$interceptFontWeight(PlatformResolveInterceptor _this, FontWeight fontWeight) {
            return fontWeight;
        }
    }

    FontFamily interceptFontFamily(FontFamily fontFamily);

    /* renamed from: interceptFontStyle-T2F_aPo  reason: not valid java name */
    int m6183interceptFontStyleT2F_aPo(int i);

    /* renamed from: interceptFontSynthesis-Mscr08Y  reason: not valid java name */
    int m6184interceptFontSynthesisMscr08Y(int i);

    FontWeight interceptFontWeight(FontWeight fontWeight);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "getDefault$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontFamilyResolver.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PlatformResolveInterceptor Default = new PlatformResolveInterceptor$Companion$Default$1();

        private Companion() {
        }

        public final PlatformResolveInterceptor getDefault$ui_text_release() {
            return Default;
        }
    }
}
