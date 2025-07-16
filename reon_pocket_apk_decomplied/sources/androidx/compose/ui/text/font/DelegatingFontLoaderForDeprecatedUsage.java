package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.Font;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/DelegatingFontLoaderForDeprecatedUsage;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "loader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "getLoader$ui_text_release", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "awaitLoad", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DelegatingFontLoaderForDeprecatedUsage.android.kt */
public final class DelegatingFontLoaderForDeprecatedUsage implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey = new Object();
    private final Font.ResourceLoader loader;

    public DelegatingFontLoaderForDeprecatedUsage(Font.ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public final Font.ResourceLoader getLoader$ui_text_release() {
        return this.loader;
    }

    public Object getCacheKey() {
        return this.cacheKey;
    }

    public Object loadBlocking(Font font) {
        return this.loader.load(font);
    }

    public Object awaitLoad(Font font, Continuation<Object> continuation) {
        return this.loader.load(font);
    }
}
