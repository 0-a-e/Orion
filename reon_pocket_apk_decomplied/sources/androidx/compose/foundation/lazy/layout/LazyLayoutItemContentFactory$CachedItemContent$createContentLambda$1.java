package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
final class LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyLayoutItemContentFactory this$0;
    final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
        super(2);
        this.this$0 = lazyLayoutItemContentFactory;
        this.this$1 = cachedItemContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C99@3690L258,107@3961L219:LazyLayoutItemContentFactory.kt#wow0x6");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1403994769, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:91)");
            }
            LazyLayoutItemProvider invoke = this.this$0.getItemProvider().invoke();
            int index = this.this$1.getIndex();
            if ((index >= invoke.getItemCount() || !Intrinsics.areEqual(invoke.getKey(index), this.this$1.getKey())) && (index = invoke.getIndex(this.this$1.getKey())) != -1) {
                this.this$1.index = index;
            }
            int i2 = index;
            boolean z = i2 != -1;
            LazyLayoutItemContentFactory lazyLayoutItemContentFactory = this.this$0;
            LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this.this$1;
            composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(z));
            boolean changed = composer.changed(z);
            if (z) {
                ComposerKt.sourceInformationMarkerStart(composer, -1642427978, "C100@3750L184:LazyLayoutItemContentFactory.kt#wow0x6");
                LazyLayoutItemContentFactoryKt.m868SkippableItemJVlU9Rs(invoke, StableValue.m916constructorimpl(lazyLayoutItemContentFactory.saveableStateHolder), i2, StableValue.m916constructorimpl(cachedItemContent.getKey()), composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
            } else {
                composer.deactivateToEndGroup(changed);
            }
            composer.endReusableGroup();
            Object key = this.this$1.getKey();
            final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent2 = this.this$1;
            EffectsKt.DisposableEffect(key, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    return new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1(cachedItemContent2);
                }
            }, composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
