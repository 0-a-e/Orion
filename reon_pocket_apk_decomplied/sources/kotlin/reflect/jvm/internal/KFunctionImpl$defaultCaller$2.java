package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Executable;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: KFunctionImpl.kt */
final class KFunctionImpl$defaultCaller$2 extends Lambda implements Function0<Caller<? extends Executable>> {
    final /* synthetic */ KFunctionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.this$0 = kFunctionImpl;
    }

    public final Caller<Executable> invoke() {
        Member member;
        CallerImpl callerImpl;
        CallerImpl.Method method;
        JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.this$0.getDescriptor());
        if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor descriptor = this.this$0.getDescriptor();
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (!InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) || !(descriptor instanceof ConstructorDescriptor) || !((ConstructorDescriptor) descriptor).isPrimary()) {
                KDeclarationContainerImpl container = this.this$0.getContainer();
                JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
                String methodName = kotlinFunction.getMethodName();
                String methodDesc = kotlinFunction.getMethodDesc();
                Member member2 = this.this$0.getCaller().getMember();
                Intrinsics.checkNotNull(member2);
                member = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(member2.getModifiers()));
            } else {
                throw new KotlinReflectionInternalError(this.this$0.getDescriptor().getContainingDeclaration() + " cannot have default arguments");
            }
        } else if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this.this$0.isAnnotationConstructor()) {
                Class<?> jClass = this.this$0.getContainer().getJClass();
                Iterable<KParameter> parameters = this.this$0.getParameters();
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                for (KParameter name : parameters) {
                    String name2 = name.getName();
                    Intrinsics.checkNotNull(name2);
                    arrayList.add(name2);
                }
                return new AnnotationConstructorCaller(jClass, (List) arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, (List) null, 16, (DefaultConstructorMarker) null);
            }
            member = this.this$0.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
            Class<?> jClass2 = this.this$0.getContainer().getJClass();
            Iterable<Method> iterable = methods;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Method name3 : iterable) {
                arrayList2.add(name3.getName());
            }
            return new AnnotationConstructorCaller(jClass2, (List) arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
        } else {
            member = null;
        }
        if (member instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            callerImpl = kFunctionImpl.createConstructorCaller((Constructor) member, kFunctionImpl.getDescriptor(), true);
        } else if (member instanceof Method) {
            if (this.this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                DeclarationDescriptor containingDeclaration2 = this.this$0.getDescriptor().getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((ClassDescriptor) containingDeclaration2).isCompanionObject()) {
                    method = this.this$0.createJvmStaticInObjectCaller((Method) member);
                    callerImpl = method;
                }
            }
            method = this.this$0.createStaticMethodCaller((Method) member);
            callerImpl = method;
        } else {
            callerImpl = null;
        }
        if (callerImpl != null) {
            return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(callerImpl, this.this$0.getDescriptor(), true);
        }
        return null;
    }
}
