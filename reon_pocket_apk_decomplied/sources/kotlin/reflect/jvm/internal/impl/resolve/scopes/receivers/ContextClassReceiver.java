package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ContextClassReceiver.kt */
public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitContextReceiver {
    private final ClassDescriptor classDescriptor;
    private final Name customLabelName;

    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextClassReceiver(ClassDescriptor classDescriptor2, KotlinType kotlinType, Name name, ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        Intrinsics.checkNotNullParameter(kotlinType, "receiverType");
        this.classDescriptor = classDescriptor2;
        this.customLabelName = name;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}
