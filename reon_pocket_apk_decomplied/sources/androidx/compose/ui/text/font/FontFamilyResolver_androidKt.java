package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001aD\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"createFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "emptyCacheFontFamilyResolver", "resolveAsTypeface", "Landroidx/compose/runtime/State;", "Landroid/graphics/Typeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolveAsTypeface-Wqqsr6A", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamilyResolver.android.kt */
public final class FontFamilyResolver_androidKt {
    public static final FontFamily.Resolver createFontFamilyResolver(Context context) {
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), (TypefaceRequestCache) null, (FontListFontFamilyTypefaceAdapter) null, (PlatformFontFamilyTypefaceAdapter) null, 28, (DefaultConstructorMarker) null);
    }

    public static final FontFamily.Resolver createFontFamilyResolver(Context context, CoroutineContext coroutineContext) {
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), FontFamilyResolverKt.getGlobalTypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), coroutineContext), (PlatformFontFamilyTypefaceAdapter) null, 16, (DefaultConstructorMarker) null);
    }

    public static final FontFamily.Resolver emptyCacheFontFamilyResolver(Context context) {
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), (PlatformResolveInterceptor) null, new TypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(new AsyncTypefaceCache(), (CoroutineContext) null, 2, (DefaultConstructorMarker) null), (PlatformFontFamilyTypefaceAdapter) null, 18, (DefaultConstructorMarker) null);
    }

    /* renamed from: resolveAsTypeface-Wqqsr6A$default  reason: not valid java name */
    public static /* synthetic */ State m6135resolveAsTypefaceWqqsr6A$default(FontFamily.Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            fontFamily = null;
        }
        if ((i3 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i3 & 4) != 0) {
            i = FontStyle.Companion.m6165getNormal_LCdwA();
        }
        if ((i3 & 8) != 0) {
            i2 = FontSynthesis.Companion.m6175getAllGVVA2EU();
        }
        return m6134resolveAsTypefaceWqqsr6A(resolver, fontFamily, fontWeight, i, i2);
    }

    /* renamed from: resolveAsTypeface-Wqqsr6A  reason: not valid java name */
    public static final State<Typeface> m6134resolveAsTypefaceWqqsr6A(FontFamily.Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
        State<Object> r0 = resolver.m6131resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.compose.runtime.State<android.graphics.Typeface>");
        return r0;
    }
}
