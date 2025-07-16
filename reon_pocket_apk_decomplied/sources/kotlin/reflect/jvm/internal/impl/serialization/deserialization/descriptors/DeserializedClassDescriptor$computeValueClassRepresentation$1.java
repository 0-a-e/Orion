package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: DeserializedClassDescriptor.kt */
/* synthetic */ class DeserializedClassDescriptor$computeValueClassRepresentation$1 extends FunctionReference implements Function1<ProtoBuf.Type, SimpleType> {
    DeserializedClassDescriptor$computeValueClassRepresentation$1(Object obj) {
        super(1, obj);
    }

    public final String getSignature() {
        return "computeValueClassRepresentation$simpleType(Lorg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;)Lorg/jetbrains/kotlin/types/SimpleType;";
    }

    public final String getName() {
        return "simpleType";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Intrinsics.Kotlin.class);
    }

    public final SimpleType invoke(ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "p0");
        return TypeDeserializer.simpleType$default((TypeDeserializer) this.receiver, type, false, 2, (Object) null);
    }
}
