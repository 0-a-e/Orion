package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = lazyJavaResolverContext;
    }

    public final List<ClassConstructorDescriptor> invoke() {
        Collection<JavaConstructor> constructors = this.this$0.jClass.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (JavaConstructor access$resolveConstructor : constructors) {
            arrayList.add(this.this$0.resolveConstructor(access$resolveConstructor));
        }
        if (this.this$0.jClass.isRecord()) {
            ClassConstructorDescriptor access$createDefaultRecordConstructor = this.this$0.createDefaultRecordConstructor();
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(access$createDefaultRecordConstructor, false, false, 2, (Object) null);
            Iterable iterable = arrayList;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual((Object) MethodSignatureMappingKt.computeJvmDescriptor$default((ClassConstructorDescriptor) it.next(), false, false, 2, (Object) null), (Object) computeJvmDescriptor$default)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            arrayList.add(access$createDefaultRecordConstructor);
            this.$c.getComponents().getJavaResolverCache().recordConstructor(this.this$0.jClass, access$createDefaultRecordConstructor);
        }
        LazyJavaResolverContext lazyJavaResolverContext = this.$c;
        lazyJavaResolverContext.getComponents().getSyntheticPartsProvider().generateConstructors(lazyJavaResolverContext, this.this$0.getOwnerDescriptor(), arrayList);
        SignatureEnhancement signatureEnhancement = this.$c.getComponents().getSignatureEnhancement();
        LazyJavaResolverContext lazyJavaResolverContext2 = this.$c;
        Collection collection = arrayList;
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this.this$0;
        if (collection.isEmpty()) {
            collection = CollectionsKt.listOfNotNull(lazyJavaClassMemberScope.createDefaultConstructor());
        }
        return CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext2, collection));
    }
}
