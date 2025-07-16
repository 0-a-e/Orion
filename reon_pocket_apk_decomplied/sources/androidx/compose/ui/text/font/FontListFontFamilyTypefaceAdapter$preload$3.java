package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
final class FontListFontFamilyTypefaceAdapter$preload$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Font> $asyncLoads;
    final /* synthetic */ PlatformFontLoader $resourceLoader;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FontListFontFamilyTypefaceAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FontListFontFamilyTypefaceAdapter$preload$3(List<Font> list, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontLoader platformFontLoader, Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3> continuation) {
        super(2, continuation);
        this.$asyncLoads = list;
        this.this$0 = fontListFontFamilyTypefaceAdapter;
        this.$resourceLoader = platformFontLoader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FontListFontFamilyTypefaceAdapter$preload$3 fontListFontFamilyTypefaceAdapter$preload$3 = new FontListFontFamilyTypefaceAdapter$preload$3(this.$asyncLoads, this.this$0, this.$resourceLoader, continuation);
        fontListFontFamilyTypefaceAdapter$preload$3.L$0 = obj;
        return fontListFontFamilyTypefaceAdapter$preload$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontListFontFamilyTypefaceAdapter$preload$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            List<Font> list = this.$asyncLoads;
            HashSet hashSet = new HashSet(list.size());
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Font font = list.get(i2);
                if (hashSet.add(font)) {
                    arrayList.add(font);
                }
            }
            List list2 = arrayList;
            FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.this$0;
            PlatformFontLoader platformFontLoader = this.$resourceLoader;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList2.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FontListFontFamilyTypefaceAdapter$preload$3$2$1(fontListFontFamilyTypefaceAdapter, (Font) list2.get(i3), platformFontLoader, (Continuation<? super FontListFontFamilyTypefaceAdapter$preload$3$2$1>) null), 3, (Object) null));
            }
            this.label = 1;
            if (AwaitKt.joinAll((Collection<? extends Job>) arrayList2, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
