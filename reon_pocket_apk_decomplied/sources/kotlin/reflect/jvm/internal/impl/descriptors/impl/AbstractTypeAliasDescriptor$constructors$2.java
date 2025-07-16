package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractTypeAliasDescriptor.kt */
final class AbstractTypeAliasDescriptor$constructors$2 extends Lambda implements Function0<Collection<? extends TypeAliasConstructorDescriptor>> {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeAliasDescriptor$constructors$2(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(0);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    public final Collection<TypeAliasConstructorDescriptor> invoke() {
        return this.this$0.getTypeAliasConstructors();
    }
}
