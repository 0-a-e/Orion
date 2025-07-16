package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"load", "Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/ResourceFont;", "context", "Landroid/content/Context;", "loadAsync", "(Landroidx/compose/ui/text/font/ResourceFont;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFontLoader.android.kt */
public final class AndroidFontLoader_androidKt {
    /* access modifiers changed from: private */
    public static final Typeface load(ResourceFont resourceFont, Context context) {
        Typeface font = ResourcesCompat.getFont(context, resourceFont.getResId());
        Intrinsics.checkNotNull(font);
        return font;
    }

    /* access modifiers changed from: private */
    public static final Object loadAsync(ResourceFont resourceFont, Context context, Continuation<? super Typeface> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ResourcesCompat.getFont(context, resourceFont.getResId(), new AndroidFontLoader_androidKt$loadAsync$2$1(cancellableContinuationImpl, resourceFont), (Handler) null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
