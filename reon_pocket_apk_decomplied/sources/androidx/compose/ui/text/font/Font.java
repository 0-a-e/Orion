package androidx.compose.ui.text.font;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eR\u001a\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/Font;", "", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getLoadingStrategy-PKNRLFQ", "()I", "style", "Landroidx/compose/ui/text/font/FontStyle;", "getStyle-_-LCdwA", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "Companion", "ResourceLoader", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Font.kt */
public interface Font {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long MaximumAsyncTimeoutMillis = 15000;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H'ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/Font$ResourceLoader;", "", "load", "font", "Landroidx/compose/ui/text/font/Font;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Deprecated(message = "Replaced with FontFamily.Resolver during the introduction of async fonts, all usages should be replaced. Custom subclasses can be converted into a FontFamily.Resolver by calling createFontFamilyResolver(myFontFamilyResolver, context)")
    /* compiled from: Font.kt */
    public interface ResourceLoader {
        @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
        Object load(Font font);
    }

    /* renamed from: getLoadingStrategy-PKNRLFQ  reason: not valid java name */
    int m6128getLoadingStrategyPKNRLFQ();

    /* renamed from: getStyle-_-LCdwA  reason: not valid java name */
    int m6129getStyle_LCdwA();

    FontWeight getWeight();

    /* renamed from: androidx.compose.ui.text.font.Font$-CC  reason: invalid class name */
    /* compiled from: Font.kt */
    public final /* synthetic */ class CC {
        /* renamed from: $default$getLoadingStrategy-PKNRLFQ  reason: not valid java name */
        public static int m6130$default$getLoadingStrategyPKNRLFQ(Font _this) {
            return FontLoadingStrategy.Companion.m6150getBlockingPKNRLFQ();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/text/font/Font$Companion;", "", "()V", "MaximumAsyncTimeoutMillis", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Font.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long MaximumAsyncTimeoutMillis = 15000;

        private Companion() {
        }
    }
}
