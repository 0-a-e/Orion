package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemProviderImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "intervalContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "itemCount", "", "getItemCount", "()I", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "Item", "", "index", "key", "", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "equals", "", "other", "getContentType", "getIndex", "getKey", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemProvider.kt */
final class LazyGridItemProviderImpl implements LazyGridItemProvider {
    /* access modifiers changed from: private */
    public final LazyGridIntervalContent intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final LazyGridState state;

    public LazyGridItemProviderImpl(LazyGridState lazyGridState, LazyGridIntervalContent lazyGridIntervalContent, LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap) {
        this.state = lazyGridState;
        this.intervalContent = lazyGridIntervalContent;
        this.keyIndexMap = lazyLayoutKeyIndexMap;
    }

    public LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    public Object getKey(int i) {
        Object key = getKeyIndexMap().getKey(i);
        return key == null ? this.intervalContent.getKey(i) : key;
    }

    public Object getContentType(int i) {
        return this.intervalContent.getContentType(i);
    }

    public void Item(int i, Object obj, Composer composer, int i2) {
        Composer startRestartGroup = composer.startRestartGroup(1493551140);
        ComposerKt.sourceInformation(startRestartGroup, "C(Item)75@2884L216:LazyGridItemProvider.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1493551140, i2, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item (LazyGridItemProvider.kt:74)");
        }
        LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(obj, i, this.state.getPinnedItems$foundation_release(), ComposableLambdaKt.composableLambda(startRestartGroup, 726189336, true, new LazyGridItemProviderImpl$Item$1(this, i)), startRestartGroup, ((i2 << 3) & 112) | 3592);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyGridItemProviderImpl$Item$2(this, i, obj, i2));
        }
    }

    public LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.intervalContent.getSpanLayoutProvider$foundation_release();
    }

    public int getIndex(Object obj) {
        return getKeyIndexMap().getIndex(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyGridItemProviderImpl)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.intervalContent, (Object) ((LazyGridItemProviderImpl) obj).intervalContent);
    }

    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}
