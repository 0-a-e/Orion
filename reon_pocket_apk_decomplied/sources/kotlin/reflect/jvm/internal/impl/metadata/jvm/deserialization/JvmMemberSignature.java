package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmMemberSignature.kt */
public abstract class JvmMemberSignature {
    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    private JvmMemberSignature() {
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class Method extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public static /* synthetic */ Method copy$default(Method method, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = method.name;
            }
            if ((i & 2) != 0) {
                str2 = method.desc;
            }
            return method.copy(str, str2);
        }

        public final Method copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "desc");
            return new Method(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Method)) {
                return false;
            }
            Method method = (Method) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) method.name) && Intrinsics.areEqual((Object) this.desc, (Object) method.desc);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Method(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "desc");
            this.name = str;
            this.desc = str2;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public String asString() {
            return getName() + getDesc();
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class Field extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.desc;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            Field field = (Field) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) field.name) && Intrinsics.areEqual((Object) this.desc, (Object) field.desc);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Field(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "desc");
            this.name = str;
            this.desc = str2;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public String asString() {
            return getName() + ':' + getDesc();
        }
    }

    public final String toString() {
        return asString();
    }
}
