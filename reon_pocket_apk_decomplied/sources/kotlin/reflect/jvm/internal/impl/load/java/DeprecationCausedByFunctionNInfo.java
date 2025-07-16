package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfo;

/* compiled from: utils.kt */
public final class DeprecationCausedByFunctionNInfo extends DescriptorBasedDeprecationInfo {
    private final DeclarationDescriptor target;

    public DeprecationCausedByFunctionNInfo(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "target");
        this.target = declarationDescriptor;
    }

    public DeprecationLevelValue getDeprecationLevel() {
        return DeprecationLevelValue.ERROR;
    }
}
