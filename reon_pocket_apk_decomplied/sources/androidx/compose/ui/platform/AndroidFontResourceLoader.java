package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "load", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated(message = "Replaced with PlatformFontLoader during the introduction of async fonts, all usages should be replaced", replaceWith = @ReplaceWith(expression = "PlatformFontLoader", imports = {}))
/* compiled from: AndroidFontResourceLoader.android.kt */
public final class AndroidFontResourceLoader implements Font.ResourceLoader {
    public static final int $stable = 8;
    private final Context context;

    public AndroidFontResourceLoader(Context context2) {
        this.context = context2;
    }

    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    public Typeface load(Font font) {
        if (!(font instanceof ResourceFont)) {
            throw new IllegalArgumentException("Unknown font type: " + font);
        } else if (Build.VERSION.SDK_INT >= 26) {
            return AndroidFontResourceLoaderHelper.INSTANCE.create(this.context, ((ResourceFont) font).getResId());
        } else {
            Typeface font2 = ResourcesCompat.getFont(this.context, ((ResourceFont) font).getResId());
            Intrinsics.checkNotNull(font2);
            return font2;
        }
    }
}
