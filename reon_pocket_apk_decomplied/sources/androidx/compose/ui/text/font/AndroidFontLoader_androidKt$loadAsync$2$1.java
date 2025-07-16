package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"androidx/compose/ui/text/font/AndroidFontLoader_androidKt$loadAsync$2$1", "Landroidx/core/content/res/ResourcesCompat$FontCallback;", "onFontRetrievalFailed", "", "reason", "", "onFontRetrieved", "typeface", "Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFontLoader.android.kt */
public final class AndroidFontLoader_androidKt$loadAsync$2$1 extends ResourcesCompat.FontCallback {
    final /* synthetic */ CancellableContinuation<Typeface> $continuation;
    final /* synthetic */ ResourceFont $this_loadAsync;

    AndroidFontLoader_androidKt$loadAsync$2$1(CancellableContinuation<? super Typeface> cancellableContinuation, ResourceFont resourceFont) {
        this.$continuation = cancellableContinuation;
        this.$this_loadAsync = resourceFont;
    }

    public void onFontRetrieved(Typeface typeface) {
        Result.Companion companion = Result.Companion;
        this.$continuation.resumeWith(Result.m7042constructorimpl(typeface));
    }

    public void onFontRetrievalFailed(int i) {
        CancellableContinuation<Typeface> cancellableContinuation = this.$continuation;
        cancellableContinuation.cancel(new IllegalStateException("Unable to load font " + this.$this_loadAsync + " (reason=" + i + ')'));
    }
}
