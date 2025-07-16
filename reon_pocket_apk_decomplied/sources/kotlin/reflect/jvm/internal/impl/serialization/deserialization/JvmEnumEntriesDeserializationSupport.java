package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* compiled from: EnumEntriesDeserializationSupport.kt */
public final class JvmEnumEntriesDeserializationSupport implements EnumEntriesDeserializationSupport {
    public static final JvmEnumEntriesDeserializationSupport INSTANCE = new JvmEnumEntriesDeserializationSupport();

    private JvmEnumEntriesDeserializationSupport() {
    }

    public Boolean canSynthesizeEnumEntries() {
        return true;
    }
}
