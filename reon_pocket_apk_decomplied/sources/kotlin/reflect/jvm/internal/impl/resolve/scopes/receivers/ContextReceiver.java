package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ContextReceiver.kt */
public final class ContextReceiver extends AbstractReceiverValue implements ImplicitContextReceiver {
    private final Name customLabelName;
    private final CallableDescriptor declarationDescriptor;

    public CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextReceiver(CallableDescriptor callableDescriptor, KotlinType kotlinType, Name name, ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(callableDescriptor, "declarationDescriptor");
        Intrinsics.checkNotNullParameter(kotlinType, "receiverType");
        this.declarationDescriptor = callableDescriptor;
        this.customLabelName = name;
    }

    public String toString() {
        return "Cxt { " + getDeclarationDescriptor() + " }";
    }
}
