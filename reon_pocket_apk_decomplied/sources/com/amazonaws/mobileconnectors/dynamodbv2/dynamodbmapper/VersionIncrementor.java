package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.scheduling.WorkQueueKt;

class VersionIncrementor {
    private static final Incrementor BIG_INTEGER = new Incrementor() {
        public Object increment(Object obj) {
            if (obj == null) {
                return BigInteger.ONE;
            }
            return ((BigInteger) obj).add(BigInteger.ONE);
        }
    };
    private static final Incrementor BYTE = new Incrementor() {
        public Object increment(Object obj) {
            if (obj == null) {
                return (byte) 1;
            }
            return Byte.valueOf((byte) ((((Byte) obj).byteValue() + 1) % WorkQueueKt.MASK));
        }
    };
    private static final Incrementor INTEGER = new Incrementor() {
        public Object increment(Object obj) {
            if (obj == null) {
                return 1;
            }
            return Integer.valueOf(((Integer) obj).intValue() + 1);
        }
    };
    private static final Incrementor LONG = new Incrementor() {
        public Object increment(Object obj) {
            if (obj == null) {
                return 1L;
            }
            return Long.valueOf(((Long) obj).longValue() + 1);
        }
    };
    private static final Incrementor SHORT = new Incrementor() {
        public Object increment(Object obj) {
            if (obj == null) {
                return (short) 1;
            }
            return Short.valueOf((short) (((Short) obj).shortValue() + 1));
        }
    };
    private final Map<Method, Incrementor> cache = new HashMap();

    private interface Incrementor {
        Object increment(Object obj);
    }

    VersionIncrementor() {
    }

    public Object increment(Method method, Object obj) {
        return getIncrementor(method).increment(obj);
    }

    private Incrementor getIncrementor(Method method) {
        Incrementor incrementor;
        synchronized (this.cache) {
            Incrementor incrementor2 = this.cache.get(method);
            if (incrementor2 != null) {
                return incrementor2;
            }
            Class<?> returnType = method.getReturnType();
            if (matches(returnType, BigInteger.class)) {
                incrementor = BIG_INTEGER;
            } else {
                if (matches(returnType, Long.class, Long.TYPE)) {
                    incrementor = LONG;
                } else {
                    if (matches(returnType, Integer.class, Integer.TYPE)) {
                        incrementor = INTEGER;
                    } else {
                        if (matches(returnType, Short.class, Short.TYPE)) {
                            incrementor = SHORT;
                        } else {
                            if (matches(returnType, Byte.class, Byte.TYPE)) {
                                incrementor = BYTE;
                            } else {
                                throw new DynamoDBMappingException("Unsupported parameter type for " + DynamoDBVersionAttribute.class + ": " + returnType + ". Must be a whole-number type.");
                            }
                        }
                    }
                }
            }
            this.cache.put(method, incrementor);
            return incrementor;
        }
    }

    private static boolean matches(Class<?> cls, Class<?>... clsArr) {
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}
