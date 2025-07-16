package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.util.StringUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class ReflectionUtils {
    ReflectionUtils() {
    }

    static Object safeInvoke(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new DynamoDBMappingException("Couldn't invoke " + method, e);
        } catch (IllegalArgumentException e2) {
            throw new DynamoDBMappingException("Couldn't invoke " + method, e2);
        } catch (InvocationTargetException e3) {
            throw new DynamoDBMappingException("Couldn't invoke " + method, e3);
        }
    }

    static String getFieldNameByGetter(Method method, boolean z) {
        String str;
        String name = method.getName();
        if (name.startsWith("get")) {
            str = name.substring(3);
        } else if (name.startsWith("is")) {
            str = name.substring(2);
        } else {
            str = "";
        }
        if (str.length() == 0) {
            throw new DynamoDBMappingException("Getter must begin with 'get' or 'is', and the field name must contain at least one character.");
        } else if (!z) {
            return str;
        } else {
            return StringUtils.lowerCase(str.substring(0, 1)) + str.substring(1);
        }
    }

    static Field getClassFieldByName(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (SecurityException e) {
            throw new DynamoDBMappingException("Denied access to the [" + str + "] field in class [" + cls + "].", e);
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    static <T extends Annotation> T getAnnotationFromGetterOrField(Method method, Class<T> cls) {
        T annotation = method.getAnnotation(cls);
        if (annotation != null) {
            return annotation;
        }
        Field classFieldByName = getClassFieldByName(method.getDeclaringClass(), getFieldNameByGetter(method, true));
        if (classFieldByName != null) {
            return classFieldByName.getAnnotation(cls);
        }
        return null;
    }

    static <T extends Annotation> boolean getterOrFieldHasAnnotation(Method method, Class<T> cls) {
        return getAnnotationFromGetterOrField(method, cls) != null;
    }

    static Class<?> resolveClass(Type type) {
        Type rawType = type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type;
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        throw new DynamoDBMappingException("Cannot resolve class for type " + type);
    }
}
