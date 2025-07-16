package androidx.compose.ui.draw;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001e\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007HÆ\u0003J$\u0010\f\u001a\u00020\u00002\u0019\b\u0002\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007HÆ\u0001J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\f\u0010\u0019\u001a\u00020\u0017*\u00020\u001aH\u0016R\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/draw/DrawWithCacheElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/CacheDrawModifierNodeImpl;", "onBuildDrawCache", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getOnBuildDrawCache", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
final class DrawWithCacheElement extends ModifierNodeElement<CacheDrawModifierNodeImpl> {
    private final Function1<CacheDrawScope, DrawResult> onBuildDrawCache;

    public static /* synthetic */ DrawWithCacheElement copy$default(DrawWithCacheElement drawWithCacheElement, Function1<CacheDrawScope, DrawResult> function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = drawWithCacheElement.onBuildDrawCache;
        }
        return drawWithCacheElement.copy(function1);
    }

    public final Function1<CacheDrawScope, DrawResult> component1() {
        return this.onBuildDrawCache;
    }

    public final DrawWithCacheElement copy(Function1<? super CacheDrawScope, DrawResult> function1) {
        return new DrawWithCacheElement(function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DrawWithCacheElement) && Intrinsics.areEqual((Object) this.onBuildDrawCache, (Object) ((DrawWithCacheElement) obj).onBuildDrawCache);
    }

    public int hashCode() {
        return this.onBuildDrawCache.hashCode();
    }

    public String toString() {
        return "DrawWithCacheElement(onBuildDrawCache=" + this.onBuildDrawCache + ')';
    }

    public final Function1<CacheDrawScope, DrawResult> getOnBuildDrawCache() {
        return this.onBuildDrawCache;
    }

    public DrawWithCacheElement(Function1<? super CacheDrawScope, DrawResult> function1) {
        this.onBuildDrawCache = function1;
    }

    public CacheDrawModifierNodeImpl create() {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), this.onBuildDrawCache);
    }

    public void update(CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl) {
        cacheDrawModifierNodeImpl.setBlock(this.onBuildDrawCache);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("drawWithCache");
        inspectorInfo.getProperties().set("onBuildDrawCache", this.onBuildDrawCache);
    }
}
