package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFontLoader.android.kt */
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public Typeface loadBlocking(Font font) {
        Typeface typeface;
        Object obj;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        Object obj2 = null;
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int r0 = font.m6128getLoadingStrategyPKNRLFQ();
        if (FontLoadingStrategy.m6145equalsimpl0(r0, FontLoadingStrategy.Companion.m6150getBlockingPKNRLFQ())) {
            typeface = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
        } else if (FontLoadingStrategy.m6145equalsimpl0(r0, FontLoadingStrategy.Companion.m6151getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion = Result.Companion;
                AndroidFontLoader androidFontLoader = this;
                obj = Result.m7042constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, this.context));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m7042constructorimpl(ResultKt.createFailure(th));
            }
            if (!Result.m7048isFailureimpl(obj)) {
                obj2 = obj;
            }
            typeface = (Typeface) obj2;
        } else if (FontLoadingStrategy.m6145equalsimpl0(r0, FontLoadingStrategy.Companion.m6149getAsyncPKNRLFQ())) {
            throw new UnsupportedOperationException("Unsupported Async font load path");
        } else {
            throw new IllegalArgumentException("Unknown loading type " + FontLoadingStrategy.m6147toStringimpl(font.m6128getLoadingStrategyPKNRLFQ()));
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typeface, ((ResourceFont) font).getVariationSettings(), this.context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object awaitLoad(androidx.compose.ui.text.font.Font r6, kotlin.coroutines.Continuation<? super android.graphics.Typeface> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = (androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = new androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.text.font.AndroidFontLoader r0 = (androidx.compose.ui.text.font.AndroidFontLoader) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0071
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0059
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.AndroidFont
            if (r7 == 0) goto L_0x005a
            androidx.compose.ui.text.font.AndroidFont r6 = (androidx.compose.ui.text.font.AndroidFont) r6
            androidx.compose.ui.text.font.AndroidFont$TypefaceLoader r7 = r6.getTypefaceLoader()
            android.content.Context r2 = r5.context
            r0.label = r4
            java.lang.Object r7 = r7.awaitLoad(r2, r6, r0)
            if (r7 != r1) goto L_0x0059
            return r1
        L_0x0059:
            return r7
        L_0x005a:
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.ResourceFont
            if (r7 == 0) goto L_0x0080
            r7 = r6
            androidx.compose.ui.text.font.ResourceFont r7 = (androidx.compose.ui.text.font.ResourceFont) r7
            android.content.Context r2 = r5.context
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = androidx.compose.ui.text.font.AndroidFontLoader_androidKt.loadAsync(r7, r2, r0)
            if (r7 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r0 = r5
        L_0x0071:
            android.graphics.Typeface r7 = (android.graphics.Typeface) r7
            androidx.compose.ui.text.font.ResourceFont r6 = (androidx.compose.ui.text.font.ResourceFont) r6
            androidx.compose.ui.text.font.FontVariation$Settings r6 = r6.getVariationSettings()
            android.content.Context r0 = r0.context
            android.graphics.Typeface r6 = androidx.compose.ui.text.font.PlatformTypefaces_androidKt.setFontVariationSettings(r7, r6, r0)
            return r6
        L_0x0080:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown font type: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFontLoader.awaitLoad(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object getCacheKey() {
        return this.cacheKey;
    }
}
