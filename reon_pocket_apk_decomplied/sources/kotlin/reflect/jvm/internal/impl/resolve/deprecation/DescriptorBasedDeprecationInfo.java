package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* compiled from: DescriptorBasedDeprecationInfo.kt */
public abstract class DescriptorBasedDeprecationInfo extends DeprecationInfo {
    public boolean getForcePropagationToOverrides() {
        return false;
    }

    public boolean getPropagatesToOverrides() {
        return getForcePropagationToOverrides();
    }
}
