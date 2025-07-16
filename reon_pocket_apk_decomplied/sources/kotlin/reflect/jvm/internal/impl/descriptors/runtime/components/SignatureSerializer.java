package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* compiled from: ReflectKotlinClass.kt */
final class SignatureSerializer {
    public static final SignatureSerializer INSTANCE = new SignatureSerializer();

    private SignatureSerializer() {
    }

    public final String methodDesc(Method method) {
        Intrinsics.checkNotNullParameter(method, FirebaseAnalytics.Param.METHOD);
        StringBuilder sb = new StringBuilder("(");
        Class[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
        for (Class cls : parameterTypes) {
            Intrinsics.checkNotNull(cls);
            sb.append(ReflectClassUtilKt.getDesc(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String constructorDesc(Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        StringBuilder sb = new StringBuilder("(");
        Class[] parameterTypes = constructor.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
        for (Class cls : parameterTypes) {
            Intrinsics.checkNotNull(cls);
            sb.append(ReflectClassUtilKt.getDesc(cls));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String fieldDesc(Field field) {
        Intrinsics.checkNotNullParameter(field, "field");
        Class<?> type = field.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return ReflectClassUtilKt.getDesc(type);
    }
}
