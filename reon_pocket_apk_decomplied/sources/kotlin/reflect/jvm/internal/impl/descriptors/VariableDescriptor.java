package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public interface VariableDescriptor extends ValueDescriptor {
    ConstantValue<?> getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();

    VariableDescriptor substitute(TypeSubstitutor typeSubstitutor);
}
