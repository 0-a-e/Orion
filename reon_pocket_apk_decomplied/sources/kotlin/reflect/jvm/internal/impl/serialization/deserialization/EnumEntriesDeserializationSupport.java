package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* compiled from: EnumEntriesDeserializationSupport.kt */
public interface EnumEntriesDeserializationSupport {
    Boolean canSynthesizeEnumEntries();

    /* compiled from: EnumEntriesDeserializationSupport.kt */
    public static final class Default implements EnumEntriesDeserializationSupport {
        public static final Default INSTANCE = new Default();

        public Boolean canSynthesizeEnumEntries() {
            return null;
        }

        private Default() {
        }
    }
}
