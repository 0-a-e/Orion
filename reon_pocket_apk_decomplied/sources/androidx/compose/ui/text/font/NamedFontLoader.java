package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.AndroidFont;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/NamedFontLoader;", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "()V", "awaitLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DeviceFontFamilyNameFont.android.kt */
final class NamedFontLoader implements AndroidFont.TypefaceLoader {
    public static final NamedFontLoader INSTANCE = new NamedFontLoader();

    private NamedFontLoader() {
    }

    public Typeface loadBlocking(Context context, AndroidFont androidFont) {
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = androidFont instanceof DeviceFontFamilyNameFont ? (DeviceFontFamilyNameFont) androidFont : null;
        if (deviceFontFamilyNameFont != null) {
            return deviceFontFamilyNameFont.loadCached(context);
        }
        return null;
    }

    public Object awaitLoad(Context context, AndroidFont androidFont, Continuation<? super Typeface> continuation) {
        throw new UnsupportedOperationException("All preloaded fonts are optional local.");
    }
}
