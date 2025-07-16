package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.DispatcherKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@¢\u0006\u0002\u0010\u000fJB\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "injectedContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/coroutines/CoroutineContext;)V", "asyncLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "preload", "", "family", "Landroidx/compose/ui/text/font/FontFamily;", "resourceLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/PlatformFontLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "createDefaultTypeface", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final CoroutineExceptionHandler DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    /* access modifiers changed from: private */
    public static final FontMatcher fontMatcher = new FontMatcher();
    private CoroutineScope asyncLoadScope;
    /* access modifiers changed from: private */
    public final AsyncTypefaceCache asyncTypefaceCache;

    public FontListFontFamilyTypefaceAdapter() {
        this((AsyncTypefaceCache) null, (CoroutineContext) null, 3, (DefaultConstructorMarker) null);
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache2, CoroutineContext coroutineContext) {
        this.asyncTypefaceCache = asyncTypefaceCache2;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(DropExceptionHandler.plus(DispatcherKt.getFontCacheManagementDispatcher()).plus(coroutineContext).plus(SupervisorKt.SupervisorJob((Job) coroutineContext.get(Job.Key))));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache2, (i & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext);
    }

    public final Object preload(FontFamily fontFamily, PlatformFontLoader platformFontLoader, Continuation<? super Unit> continuation) {
        FontFamily fontFamily2 = fontFamily;
        PlatformFontLoader platformFontLoader2 = platformFontLoader;
        if (!(fontFamily2 instanceof FontListFontFamily)) {
            return Unit.INSTANCE;
        }
        FontListFontFamily fontListFontFamily = (FontListFontFamily) fontFamily2;
        List<Font> fonts = fontListFontFamily.getFonts();
        List<Font> fonts2 = fontListFontFamily.getFonts();
        ArrayList arrayList = new ArrayList(fonts2.size());
        int size = fonts2.size();
        for (int i = 0; i < size; i++) {
            Font font = fonts2.get(i);
            if (FontLoadingStrategy.m6145equalsimpl0(font.m6128getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m6149getAsyncPKNRLFQ())) {
                arrayList.add(font);
            }
        }
        List list = arrayList;
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Font font2 = (Font) list.get(i2);
            arrayList2.add(TuplesKt.to(font2.getWeight(), FontStyle.m6155boximpl(font2.m6129getStyle_LCdwA())));
        }
        List list2 = arrayList2;
        HashSet hashSet = new HashSet(list2.size());
        ArrayList arrayList3 = new ArrayList(list2.size());
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Object obj = list2.get(i3);
            if (hashSet.add((Pair) obj)) {
                arrayList3.add(obj);
            }
        }
        List list3 = arrayList3;
        List arrayList4 = new ArrayList();
        int size4 = list3.size();
        int i4 = 0;
        while (i4 < size4) {
            Pair pair = (Pair) list3.get(i4);
            FontWeight fontWeight = (FontWeight) pair.component1();
            int r4 = ((FontStyle) pair.component2()).m6161unboximpl();
            List<Font> r15 = fontMatcher.m6154matchFontRetOiIg((List<? extends Font>) fonts, fontWeight, r4);
            TypefaceRequest typefaceRequest = r1;
            TypefaceRequest typefaceRequest2 = new TypefaceRequest(fontFamily, fontWeight, r4, FontSynthesis.Companion.m6175getAllGVVA2EU(), platformFontLoader.getCacheKey(), (DefaultConstructorMarker) null);
            List list4 = (List) FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(r15, typefaceRequest, this.asyncTypefaceCache, platformFontLoader2, FontListFontFamilyTypefaceAdapter$preload$2$1.INSTANCE).component1();
            if (list4 != null) {
                arrayList4.add(CollectionsKt.first(list4));
            }
            i4++;
            FontFamily fontFamily3 = fontFamily;
        }
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FontListFontFamilyTypefaceAdapter$preload$3(arrayList4, this, platformFontLoader2, (Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1<? super TypefaceResult.Immutable, Unit> function1, Function1<? super TypefaceRequest, ? extends Object> function12) {
        if (!(typefaceRequest.getFontFamily() instanceof FontListFontFamily)) {
            return null;
        }
        Pair access$firstImmediatelyAvailable = FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(fontMatcher.m6154matchFontRetOiIg((List<? extends Font>) ((FontListFontFamily) typefaceRequest.getFontFamily()).getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.m6215getFontStyle_LCdwA()), typefaceRequest, this.asyncTypefaceCache, platformFontLoader, function12);
        List list = (List) access$firstImmediatelyAvailable.component1();
        Object component2 = access$firstImmediatelyAvailable.component2();
        if (list == null) {
            return new TypefaceResult.Immutable(component2, false, 2, (DefaultConstructorMarker) null);
        }
        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list, component2, typefaceRequest, this.asyncTypefaceCache, function1, platformFontLoader);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.asyncLoadScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new FontListFontFamilyTypefaceAdapter$resolve$1(asyncFontListLoader, (Continuation<? super FontListFontFamilyTypefaceAdapter$resolve$1>) null), 1, (Object) null);
        return new TypefaceResult.Async(asyncFontListLoader);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter$Companion;", "", "()V", "DropExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDropExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.fontMatcher;
        }

        public final CoroutineExceptionHandler getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        }
    }
}
