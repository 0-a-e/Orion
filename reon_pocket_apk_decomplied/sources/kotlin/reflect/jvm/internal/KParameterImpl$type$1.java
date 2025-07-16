package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: KParameterImpl.kt */
final class KParameterImpl$type$1 extends Lambda implements Function0<Type> {
    final /* synthetic */ KParameterImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KParameterImpl$type$1(KParameterImpl kParameterImpl) {
        super(0);
        this.this$0 = kParameterImpl;
    }

    public final Type invoke() {
        ParameterDescriptor access$getDescriptor = this.this$0.getDescriptor();
        if (!(access$getDescriptor instanceof ReceiverParameterDescriptor) || !Intrinsics.areEqual((Object) UtilKt.getInstanceReceiverParameter(this.this$0.getCallable().getDescriptor()), (Object) access$getDescriptor) || this.this$0.getCallable().getDescriptor().getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Caller<?> caller = this.this$0.getCallable().getCaller();
            if (caller instanceof ValueClassAwareCaller) {
                List<T> slice = CollectionsKt.slice(caller.getParameterTypes(), ((ValueClassAwareCaller) caller).getRealSlicesOfParameters(this.this$0.getIndex()));
                KParameterImpl kParameterImpl = this.this$0;
                Type[] typeArr = (Type[]) slice.toArray(new Type[0]);
                return kParameterImpl.compoundType((Type[]) Arrays.copyOf(typeArr, typeArr.length));
            } else if (!(caller instanceof ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller)) {
                return caller.getParameterTypes().get(this.this$0.getIndex());
            } else {
                KParameterImpl kParameterImpl2 = this.this$0;
                Class[] clsArr = (Class[]) ((ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller) caller).getOriginalParametersGroups().get(this.this$0.getIndex()).toArray(new Class[0]);
                return kParameterImpl2.compoundType((Type[]) Arrays.copyOf(clsArr, clsArr.length));
            }
        } else {
            DeclarationDescriptor containingDeclaration = this.this$0.getCallable().getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + access$getDescriptor);
        }
    }
}
