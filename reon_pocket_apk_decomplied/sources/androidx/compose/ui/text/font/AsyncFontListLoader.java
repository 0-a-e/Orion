package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010 \u001a\u00020\u000eH@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H@¢\u0006\u0004\b#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028V@RX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "cacheable", "", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
public final class AsyncFontListLoader implements State<Object> {
    public static final int $stable = 0;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable = true;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    /* access modifiers changed from: private */
    public final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;
    private final MutableState value$delegate;

    public AsyncFontListLoader(List<? extends Font> list, Object obj, TypefaceRequest typefaceRequest2, AsyncTypefaceCache asyncTypefaceCache2, Function1<? super TypefaceResult.Immutable, Unit> function1, PlatformFontLoader platformFontLoader2) {
        this.fontList = list;
        this.typefaceRequest = typefaceRequest2;
        this.asyncTypefaceCache = asyncTypefaceCache2;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader2;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final boolean getCacheable$ui_text_release() {
        return this.cacheable;
    }

    public final void setCacheable$ui_text_release(boolean z) {
        this.cacheable = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076 A[SYNTHETIC, Splitter:B:27:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2 A[SYNTHETIC, Splitter:B:38:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            boolean r2 = r0 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$load$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            androidx.compose.ui.text.font.AsyncFontListLoader$load$1 r2 = (androidx.compose.ui.text.font.AsyncFontListLoader$load$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            androidx.compose.ui.text.font.AsyncFontListLoader$load$1 r2 = new androidx.compose.ui.text.font.AsyncFontListLoader$load$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 2
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 == r7) goto L_0x004b
            if (r4 != r6) goto L_0x0043
            int r4 = r2.I$1
            int r9 = r2.I$0
            java.lang.Object r10 = r2.L$1
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r2.L$0
            androidx.compose.ui.text.font.AsyncFontListLoader r11 = (androidx.compose.ui.text.font.AsyncFontListLoader) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0040 }
            goto L_0x0106
        L_0x0040:
            r0 = move-exception
            goto L_0x012f
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004b:
            int r4 = r2.I$1
            int r9 = r2.I$0
            java.lang.Object r10 = r2.L$2
            androidx.compose.ui.text.font.Font r10 = (androidx.compose.ui.text.font.Font) r10
            java.lang.Object r11 = r2.L$1
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r2.L$0
            androidx.compose.ui.text.font.AsyncFontListLoader r12 = (androidx.compose.ui.text.font.AsyncFontListLoader) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0065 }
            r15 = r12
            r18 = r11
            r11 = r10
            r10 = r18
            goto L_0x00bc
        L_0x0065:
            r0 = move-exception
            r11 = r12
            goto L_0x012f
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.List<androidx.compose.ui.text.font.Font> r0 = r1.fontList     // Catch:{ all -> 0x012d }
            int r4 = r0.size()     // Catch:{ all -> 0x012d }
            r15 = r1
            r14 = r8
        L_0x0074:
            if (r14 >= r4) goto L_0x0112
            java.lang.Object r9 = r0.get(r14)     // Catch:{ all -> 0x010a }
            r13 = r9
            androidx.compose.ui.text.font.Font r13 = (androidx.compose.ui.text.font.Font) r13     // Catch:{ all -> 0x010a }
            int r9 = r13.m6128getLoadingStrategyPKNRLFQ()     // Catch:{ all -> 0x010a }
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r10 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion     // Catch:{ all -> 0x010a }
            int r10 = r10.m6149getAsyncPKNRLFQ()     // Catch:{ all -> 0x010a }
            boolean r9 = androidx.compose.ui.text.font.FontLoadingStrategy.m6145equalsimpl0(r9, r10)     // Catch:{ all -> 0x010a }
            if (r9 == 0) goto L_0x010d
            androidx.compose.ui.text.font.AsyncTypefaceCache r9 = r15.asyncTypefaceCache     // Catch:{ all -> 0x010a }
            androidx.compose.ui.text.font.PlatformFontLoader r11 = r15.platformFontLoader     // Catch:{ all -> 0x010a }
            androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1 r10 = new androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1     // Catch:{ all -> 0x010a }
            r10.<init>(r15, r13, r5)     // Catch:{ all -> 0x010a }
            r16 = r10
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16     // Catch:{ all -> 0x010a }
            r2.L$0 = r15     // Catch:{ all -> 0x010a }
            r2.L$1 = r0     // Catch:{ all -> 0x010a }
            r2.L$2 = r13     // Catch:{ all -> 0x010a }
            r2.I$0 = r14     // Catch:{ all -> 0x010a }
            r2.I$1 = r4     // Catch:{ all -> 0x010a }
            r2.label = r7     // Catch:{ all -> 0x010a }
            r12 = 0
            r10 = r13
            r17 = r13
            r13 = r16
            r16 = r14
            r14 = r2
            java.lang.Object r9 = r9.runCached(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x010a }
            if (r9 != r3) goto L_0x00b6
            return r3
        L_0x00b6:
            r10 = r0
            r0 = r9
            r9 = r16
            r11 = r17
        L_0x00bc:
            if (r0 == 0) goto L_0x00f2
            androidx.compose.ui.text.font.TypefaceRequest r3 = r15.typefaceRequest     // Catch:{ all -> 0x010a }
            int r3 = r3.m6216getFontSynthesisGVVA2EU()     // Catch:{ all -> 0x010a }
            androidx.compose.ui.text.font.TypefaceRequest r4 = r15.typefaceRequest     // Catch:{ all -> 0x010a }
            androidx.compose.ui.text.font.FontWeight r4 = r4.getFontWeight()     // Catch:{ all -> 0x010a }
            androidx.compose.ui.text.font.TypefaceRequest r5 = r15.typefaceRequest     // Catch:{ all -> 0x010a }
            int r5 = r5.m6215getFontStyle_LCdwA()     // Catch:{ all -> 0x010a }
            java.lang.Object r0 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m6179synthesizeTypefaceFxwP2eA(r3, r0, r11, r4, r5)     // Catch:{ all -> 0x010a }
            r15.setValue(r0)     // Catch:{ all -> 0x010a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010a }
            kotlin.coroutines.CoroutineContext r2 = r2.getContext()
            boolean r2 = kotlinx.coroutines.JobKt.isActive(r2)
            r15.cacheable = r8
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r3 = r15.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r4 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r5 = r15.getValue()
            r4.<init>(r5, r2)
            r3.invoke(r4)
            return r0
        L_0x00f2:
            r2.L$0 = r15     // Catch:{ all -> 0x010a }
            r2.L$1 = r10     // Catch:{ all -> 0x010a }
            r2.L$2 = r5     // Catch:{ all -> 0x010a }
            r2.I$0 = r9     // Catch:{ all -> 0x010a }
            r2.I$1 = r4     // Catch:{ all -> 0x010a }
            r2.label = r6     // Catch:{ all -> 0x010a }
            java.lang.Object r0 = kotlinx.coroutines.YieldKt.yield(r2)     // Catch:{ all -> 0x010a }
            if (r0 != r3) goto L_0x0105
            return r3
        L_0x0105:
            r11 = r15
        L_0x0106:
            r14 = r9
            r0 = r10
            r15 = r11
            goto L_0x010f
        L_0x010a:
            r0 = move-exception
            r11 = r15
            goto L_0x012f
        L_0x010d:
            r16 = r14
        L_0x010f:
            int r14 = r14 + r7
            goto L_0x0074
        L_0x0112:
            kotlin.coroutines.CoroutineContext r0 = r2.getContext()
            boolean r0 = kotlinx.coroutines.JobKt.isActive(r0)
            r15.cacheable = r8
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r2 = r15.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r3 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r4 = r15.getValue()
            r3.<init>(r4, r0)
            r2.invoke(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x012d:
            r0 = move-exception
            r11 = r1
        L_0x012f:
            kotlin.coroutines.CoroutineContext r2 = r2.getContext()
            boolean r2 = kotlinx.coroutines.JobKt.isActive(r2)
            r11.cacheable = r8
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.font.TypefaceResult$Immutable, kotlin.Unit> r3 = r11.onCompletion
            androidx.compose.ui.text.font.TypefaceResult$Immutable r4 = new androidx.compose.ui.text.font.TypefaceResult$Immutable
            java.lang.Object r5 = r11.getValue()
            r4.<init>(r5, r2)
            r3.invoke(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font r7, kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = (androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.text.font.Font r7 = (androidx.compose.ui.text.font.Font) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CancellationException -> 0x0080, Exception -> 0x0050 }
            goto L_0x004e
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2 r8 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2     // Catch:{ CancellationException -> 0x0080, Exception -> 0x0050 }
            r8.<init>(r6, r7, r4)     // Catch:{ CancellationException -> 0x0080, Exception -> 0x0050 }
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch:{ CancellationException -> 0x0080, Exception -> 0x0050 }
            r0.L$0 = r7     // Catch:{ CancellationException -> 0x0080, Exception -> 0x0050 }
            r0.label = r3     // Catch:{ CancellationException -> 0x0080, Exception -> 0x0050 }
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r8, r0)     // Catch:{ CancellationException -> 0x0080, Exception -> 0x0050 }
            if (r8 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r4 = r8
            goto L_0x008b
        L_0x0050:
            r8 = move-exception
            kotlin.coroutines.CoroutineContext r1 = r0.getContext()
            kotlinx.coroutines.CoroutineExceptionHandler$Key r2 = kotlinx.coroutines.CoroutineExceptionHandler.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r1 = r1.get(r2)
            kotlinx.coroutines.CoroutineExceptionHandler r1 = (kotlinx.coroutines.CoroutineExceptionHandler) r1
            if (r1 == 0) goto L_0x008b
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Unable to load font "
            r3.<init>(r5)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r2.<init>(r7, r8)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1.handleException(r0, r2)
            goto L_0x008b
        L_0x0080:
            r7 = move-exception
            kotlin.coroutines.CoroutineContext r8 = r0.getContext()
            boolean r8 = kotlinx.coroutines.JobKt.isActive(r8)
            if (r8 == 0) goto L_0x008c
        L_0x008b:
            return r4
        L_0x008c:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
