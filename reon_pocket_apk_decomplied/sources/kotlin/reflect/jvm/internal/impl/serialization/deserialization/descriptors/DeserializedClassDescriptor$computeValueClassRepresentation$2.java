package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: DeserializedClassDescriptor.kt */
/* synthetic */ class DeserializedClassDescriptor$computeValueClassRepresentation$2 extends FunctionReference implements Function1<Name, SimpleType> {
    DeserializedClassDescriptor$computeValueClassRepresentation$2(Object obj) {
        super(1, obj);
    }

    public final String getSignature() {
        return "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;";
    }

    public final String getName() {
        return "getValueClassPropertyType";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DeserializedClassDescriptor.class);
    }

    public final SimpleType invoke(Name name) {
        Intrinsics.checkNotNullParameter(name, "p0");
        return ((DeserializedClassDescriptor) this.receiver).getValueClassPropertyType(name);
    }
}
