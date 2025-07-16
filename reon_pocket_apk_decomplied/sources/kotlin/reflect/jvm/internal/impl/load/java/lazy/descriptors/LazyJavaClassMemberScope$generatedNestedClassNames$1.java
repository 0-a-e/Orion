package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$generatedNestedClassNames$1 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$generatedNestedClassNames$1(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.$c = lazyJavaResolverContext;
        this.this$0 = lazyJavaClassMemberScope;
    }

    public final Set<Name> invoke() {
        LazyJavaResolverContext lazyJavaResolverContext = this.$c;
        return CollectionsKt.toSet(lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().getNestedClassNames(lazyJavaResolverContext, this.this$0.getOwnerDescriptor()));
    }
}
