package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory {
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    private ConstantValueFactory() {
    }

    public final ArrayValue createArrayValue(List<? extends ConstantValue<?>> list, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(list, "value");
        Intrinsics.checkNotNullParameter(kotlinType, TransferTable.COLUMN_TYPE);
        return new TypedArrayValue(list, kotlinType);
    }

    public static /* synthetic */ ConstantValue createConstantValue$default(ConstantValueFactory constantValueFactory, Object obj, ModuleDescriptor moduleDescriptor, int i, Object obj2) {
        if ((i & 2) != 0) {
            moduleDescriptor = null;
        }
        return constantValueFactory.createConstantValue(obj, moduleDescriptor);
    }

    public final ConstantValue<?> createConstantValue(Object obj, ModuleDescriptor moduleDescriptor) {
        if (obj instanceof Byte) {
            return new ByteValue(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new ShortValue(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new IntValue(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new LongValue(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new CharValue(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new FloatValue(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new DoubleValue(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new BooleanValue(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new StringValue((String) obj);
        }
        if (obj instanceof byte[]) {
            return createArrayValue(ArraysKt.toList((byte[]) obj), moduleDescriptor, PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return createArrayValue(ArraysKt.toList((short[]) obj), moduleDescriptor, PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return createArrayValue(ArraysKt.toList((int[]) obj), moduleDescriptor, PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return createArrayValue(ArraysKt.toList((long[]) obj), moduleDescriptor, PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return createArrayValue(ArraysKt.toList((char[]) obj), moduleDescriptor, PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return createArrayValue(ArraysKt.toList((float[]) obj), moduleDescriptor, PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return createArrayValue(ArraysKt.toList((double[]) obj), moduleDescriptor, PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return createArrayValue(ArraysKt.toList((boolean[]) obj), moduleDescriptor, PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new NullValue();
        }
        return null;
    }

    private final ArrayValue createArrayValue(List<?> list, ModuleDescriptor moduleDescriptor, PrimitiveType primitiveType) {
        Collection arrayList = new ArrayList();
        for (Object createConstantValue$default : CollectionsKt.toList(list)) {
            ConstantValue createConstantValue$default2 = createConstantValue$default(this, createConstantValue$default, (ModuleDescriptor) null, 2, (Object) null);
            if (createConstantValue$default2 != null) {
                arrayList.add(createConstantValue$default2);
            }
        }
        List list2 = (List) arrayList;
        if (moduleDescriptor == null) {
            return new ArrayValue(list2, new ConstantValueFactory$createArrayValue$1(primitiveType));
        }
        SimpleType primitiveArrayKotlinType = moduleDescriptor.getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
        Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "getPrimitiveArrayKotlinType(...)");
        return new TypedArrayValue(list2, primitiveArrayKotlinType);
    }
}
