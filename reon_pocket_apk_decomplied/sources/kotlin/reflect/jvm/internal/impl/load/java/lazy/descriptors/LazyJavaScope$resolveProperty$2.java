package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$resolveProperty$2 extends Lambda implements Function0<NullableLazyValue<? extends ConstantValue<?>>> {
    final /* synthetic */ JavaField $field;
    final /* synthetic */ Ref.ObjectRef<PropertyDescriptorImpl> $propertyDescriptor;
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaScope$resolveProperty$2(LazyJavaScope lazyJavaScope, JavaField javaField, Ref.ObjectRef<PropertyDescriptorImpl> objectRef) {
        super(0);
        this.this$0 = lazyJavaScope;
        this.$field = javaField;
        this.$propertyDescriptor = objectRef;
    }

    public final NullableLazyValue<ConstantValue<?>> invoke() {
        StorageManager storageManager = this.this$0.getC().getStorageManager();
        final LazyJavaScope lazyJavaScope = this.this$0;
        final JavaField javaField = this.$field;
        final Ref.ObjectRef<PropertyDescriptorImpl> objectRef = this.$propertyDescriptor;
        return storageManager.createNullableLazyValue(new Function0<ConstantValue<?>>() {
            public final ConstantValue<?> invoke() {
                return lazyJavaScope.getC().getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(javaField, (PropertyDescriptor) objectRef.element);
            }
        });
    }
}
