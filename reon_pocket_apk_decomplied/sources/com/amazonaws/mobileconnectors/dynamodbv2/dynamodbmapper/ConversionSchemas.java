package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ConversionSchema;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperFieldModel;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.BooleanSetToNumberSetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.BooleanToBooleanMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.BooleanToNumberMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.ByteArraySetToBinarySetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.ByteArrayToBinaryMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.ByteBufferSetToBinarySetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.ByteBufferToBinaryMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.CalendarSetToStringSetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.CalendarToStringMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.CustomMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.DateSetToStringSetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.DateToStringMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.ListToListMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.MapToMapMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.NumberSetToNumberSetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.NumberToNumberMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.ObjectSetToStringSetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.ObjectToMapMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.S3LinkToStringMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.StringSetToStringSetMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers.StringToStringMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.BigDecimalSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.BigDecimalUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.BigIntegerSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.BigIntegerUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.BooleanSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.BooleanUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ByteArraySetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ByteArrayUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ByteBufferSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ByteBufferUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ByteSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ByteUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.CalendarSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.CalendarUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.CustomUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.DateSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.DateUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.DoubleSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.DoubleUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.FloatSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.FloatUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.IntegerSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.IntegerUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ListUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.LongSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.LongUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.MapUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.NullableUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ObjectUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.S3LinkUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ShortSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.ShortUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.StringSetUnmarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers.StringUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ConversionSchemas {
    static final ConversionSchema DEFAULT;
    private static final Log LOGGER = LogFactory.getLog((Class<?>) ConversionSchemas.class);
    public static final ConversionSchema V1 = new StandardConversionSchema("V1ConversionSchema", new V1MarshallerSet(), new StandardUnmarshallerSet());
    public static final ConversionSchema V2 = new StandardConversionSchema("V2ConversionSchema", new V2MarshallerSet(), new StandardUnmarshallerSet());
    public static final ConversionSchema V2_COMPATIBLE;

    interface MarshallerSet {
        ArgumentMarshaller getMarshaller(Method method);

        ArgumentMarshaller getMemberMarshaller(Type type);
    }

    interface UnmarshallerSet {
        ArgumentUnmarshaller getMemberUnmarshaller(Type type);

        ArgumentUnmarshaller getUnmarshaller(Method method, Method method2);
    }

    static {
        StandardConversionSchema standardConversionSchema = new StandardConversionSchema("V2CompatibleConversionSchema", new V2CompatibleMarshallerSet(), new StandardUnmarshallerSet());
        V2_COMPATIBLE = standardConversionSchema;
        DEFAULT = standardConversionSchema;
    }

    static class StandardConversionSchema implements ConversionSchema {
        private final MarshallerSet marshallers;
        private final String name;
        private final UnmarshallerSet unmarshallers;

        public StandardConversionSchema(String str, MarshallerSet marshallerSet, UnmarshallerSet unmarshallerSet) {
            this.name = str;
            this.marshallers = new CachingMarshallerSet(new AnnotationAwareMarshallerSet(marshallerSet));
            this.unmarshallers = new CachingUnmarshallerSet(new AnnotationAwareUnmarshallerSet(unmarshallerSet));
        }

        public ItemConverter getConverter(ConversionSchema.Dependencies dependencies) {
            DynamoDBReflector dynamoDBReflector = (DynamoDBReflector) dependencies.get(DynamoDBReflector.class);
            if (dynamoDBReflector == null) {
                dynamoDBReflector = new DynamoDBReflector();
            }
            return new StandardItemConverter(this.marshallers, this.unmarshallers, dynamoDBReflector, (S3ClientCache) dependencies.get(S3ClientCache.class));
        }

        public String toString() {
            return this.name;
        }
    }

    static class StandardItemConverter implements ItemConverter {
        private final MarshallerSet marshallerSet;
        private final DynamoDBReflector reflector;
        private final S3ClientCache s3cc;
        private final UnmarshallerSet unmarshallerSet;

        public StandardItemConverter(MarshallerSet marshallerSet2, UnmarshallerSet unmarshallerSet2, DynamoDBReflector dynamoDBReflector, S3ClientCache s3ClientCache) {
            this.marshallerSet = marshallerSet2;
            this.unmarshallerSet = unmarshallerSet2;
            this.reflector = dynamoDBReflector;
            this.s3cc = s3ClientCache;
        }

        public DynamoDBMapperFieldModel getFieldModel(Method method) {
            DynamoDBMapperFieldModel.DynamoDBAttributeType dynamoDBAttributeType;
            String attributeName = this.reflector.getAttributeName(method);
            ArgumentMarshaller marshaller = getMarshaller(method);
            if (marshaller instanceof ArgumentMarshaller.StringAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.S;
            } else if (marshaller instanceof ArgumentMarshaller.NumberAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.N;
            } else if (marshaller instanceof ArgumentMarshaller.BinaryAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.B;
            } else if (marshaller instanceof ArgumentMarshaller.StringSetAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.SS;
            } else if (marshaller instanceof ArgumentMarshaller.NumberSetAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.NS;
            } else if (marshaller instanceof ArgumentMarshaller.BinarySetAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.BS;
            } else if (marshaller instanceof ArgumentMarshaller.BooleanAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL;
            } else if (marshaller instanceof ArgumentMarshaller.ListAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.L;
            } else if (marshaller instanceof ArgumentMarshaller.MapAttributeMarshaller) {
                dynamoDBAttributeType = DynamoDBMapperFieldModel.DynamoDBAttributeType.M;
            } else {
                throw new DynamoDBMappingException("Unrecognized marshaller type for " + method + ": " + marshaller);
            }
            return new DynamoDBMapperFieldModel(attributeName, dynamoDBAttributeType, marshaller);
        }

        public AttributeValue convert(Method method, Object obj) {
            if (obj == null) {
                return null;
            }
            return getMarshaller(method).marshall(obj);
        }

        public Map<String, AttributeValue> convert(Object obj) {
            AttributeValue convert;
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            HashMap hashMap = new HashMap();
            for (Method next : this.reflector.getRelevantGetters(cls)) {
                Object safeInvoke = ReflectionUtils.safeInvoke(next, obj, new Object[0]);
                if (!(safeInvoke == null || (convert = convert(next, safeInvoke)) == null)) {
                    hashMap.put(this.reflector.getAttributeName(next), convert);
                }
            }
            return hashMap;
        }

        private ArgumentMarshaller getMarshaller(Method method) {
            return augment(method.getGenericReturnType(), this.marshallerSet.getMarshaller(method));
        }

        private ArgumentMarshaller getMemberMarshaller(Type type) {
            return augment(type, this.marshallerSet.getMemberMarshaller(type));
        }

        private ArgumentMarshaller augment(Type type, ArgumentMarshaller argumentMarshaller) {
            if (argumentMarshaller instanceof ListToListMarshaller) {
                return getListToListMarshaller(type);
            }
            if (argumentMarshaller instanceof MapToMapMarshaller) {
                return getMapToMapMarshaller(type);
            }
            return argumentMarshaller instanceof ObjectToMapMarshaller ? getObjectToMapMarshaller(type) : argumentMarshaller;
        }

        private ArgumentMarshaller getListToListMarshaller(Type type) {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length == 1) {
                    return new ListToListMarshaller(getMemberMarshaller(actualTypeArguments[0]));
                }
                throw new DynamoDBMappingException("Cannot tell what type of objects belong in the List type " + type + "; unexpected number of type arguments.");
            }
            throw new DynamoDBMappingException("Cannot tell what type of objects belong in the List type " + type + ", which is not parameterized.");
        }

        private ArgumentMarshaller getMapToMapMarshaller(Type type) {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                if (actualTypeArguments == null || actualTypeArguments.length != 2) {
                    throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + "; unexpected number of type arguments.");
                } else if (actualTypeArguments[0] == String.class) {
                    return new MapToMapMarshaller(getMemberMarshaller(actualTypeArguments[1]));
                } else {
                    throw new DynamoDBMappingException("Only Map<String, ?> is supported.");
                }
            } else {
                throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + ", which is not parameterized.");
            }
        }

        private ArgumentMarshaller getObjectToMapMarshaller(Type type) {
            Type rawType = type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type;
            if (!(rawType instanceof Class)) {
                throw new DynamoDBMappingException("Cannot convert " + type + " to a class");
            } else if (((Class) rawType).getAnnotation(DynamoDBDocument.class) != null) {
                return new ObjectToMapMarshaller(this);
            } else {
                throw new DynamoDBMappingException("Cannot marshall type " + type + " without a custom marshaler or @DynamoDBDocument annotation.");
            }
        }

        public Object unconvert(Method method, Method method2, AttributeValue attributeValue) {
            return unmarshall(getUnmarshaller(method, method2), method2, attributeValue);
        }

        public <T> T unconvert(Class<T> cls, Map<String, AttributeValue> map) {
            T createObject = createObject(cls);
            if (map != null && !map.isEmpty()) {
                for (Method next : this.reflector.getRelevantGetters(cls)) {
                    AttributeValue attributeValue = map.get(this.reflector.getAttributeName(next));
                    if (attributeValue != null) {
                        setValue(createObject, next, attributeValue);
                    }
                }
            }
            return createObject;
        }

        private void setValue(Object obj, Method method, AttributeValue attributeValue) {
            Method setter = this.reflector.getSetter(method);
            ReflectionUtils.safeInvoke(setter, obj, unmarshall(getUnmarshaller(method, setter), setter, attributeValue));
        }

        private ArgumentUnmarshaller getUnmarshaller(Method method, Method method2) {
            return new NullableUnmarshaller(augment(method2.getGenericParameterTypes()[0], this.unmarshallerSet.getUnmarshaller(method, method2)));
        }

        private ArgumentUnmarshaller getMemberUnmarshaller(Type type) {
            return new NullableUnmarshaller(augment(type, this.unmarshallerSet.getMemberUnmarshaller(type)));
        }

        private ArgumentUnmarshaller augment(Type type, ArgumentUnmarshaller argumentUnmarshaller) {
            if (argumentUnmarshaller instanceof S3LinkUnmarshaller) {
                return new S3LinkUnmarshaller(this.s3cc);
            }
            if (argumentUnmarshaller instanceof ListUnmarshaller) {
                return getListUnmarshaller(type);
            }
            if (argumentUnmarshaller instanceof MapUnmarshaller) {
                return getMapUnmarshaller(type);
            }
            return argumentUnmarshaller instanceof ObjectUnmarshaller ? getObjectUnmarshaller(type) : argumentUnmarshaller;
        }

        private ArgumentUnmarshaller getListUnmarshaller(Type type) {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length == 1) {
                    return new ListUnmarshaller(getMemberUnmarshaller(actualTypeArguments[0]));
                }
                throw new DynamoDBMappingException("Cannot tell what type of objects belong in the List type " + type + "; unexpected number of type arguments.");
            }
            throw new DynamoDBMappingException("Cannot tell what type of objects belong in the List type " + type + ", which is not parameterized.");
        }

        private ArgumentUnmarshaller getMapUnmarshaller(Type type) {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                if (actualTypeArguments == null || actualTypeArguments.length != 2) {
                    throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + "; unexpected number of type arguments.");
                } else if (actualTypeArguments[0] == String.class) {
                    return new MapUnmarshaller(getMemberUnmarshaller(actualTypeArguments[1]));
                } else {
                    throw new DynamoDBMappingException("Only Map<String, ?> is supported.");
                }
            } else {
                throw new DynamoDBMappingException("Cannot tell what type of objects belong in the Map type " + type + ", which is not parameterized.");
            }
        }

        private ArgumentUnmarshaller getObjectUnmarshaller(Type type) {
            Type rawType = type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type;
            if (rawType instanceof Class) {
                Class cls = (Class) rawType;
                if (cls.getAnnotation(DynamoDBDocument.class) != null) {
                    return new ObjectUnmarshaller(this, cls);
                }
                throw new DynamoDBMappingException("Cannot unmarshall to type " + type + " without a custom marshaler or @DynamoDBDocument annotation.");
            }
            throw new DynamoDBMappingException("Cannot convert " + type + " to a class");
        }

        private static Object unmarshall(ArgumentUnmarshaller argumentUnmarshaller, Method method, AttributeValue attributeValue) {
            argumentUnmarshaller.typeCheck(attributeValue, method);
            try {
                return argumentUnmarshaller.unmarshall(attributeValue);
            } catch (IllegalArgumentException e) {
                throw new DynamoDBMappingException("Couldn't unmarshall value " + attributeValue + " for " + method, e);
            } catch (ParseException e2) {
                throw new DynamoDBMappingException("Error attempting to parse date string " + attributeValue + " for " + method, e2);
            }
        }

        private static <T> T createObject(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (InstantiationException e) {
                throw new DynamoDBMappingException("Failed to instantiate new instance of class", e);
            } catch (IllegalAccessException e2) {
                throw new DynamoDBMappingException("Failed to instantiate new instance of class", e2);
            }
        }
    }

    static final class V2MarshallerSet extends AbstractMarshallerSet {
        public V2MarshallerSet() {
            super(marshallers(), setMarshallers());
        }

        private static List<Pair<ArgumentMarshaller>> marshallers() {
            ArrayList arrayList = new ArrayList();
            ConversionSchemas.addStandardDateMarshallers(arrayList);
            ConversionSchemas.addV2BooleanMarshallers(arrayList);
            ConversionSchemas.addStandardNumberMarshallers(arrayList);
            ConversionSchemas.addStandardStringMarshallers(arrayList);
            ConversionSchemas.addStandardBinaryMarshallers(arrayList);
            ConversionSchemas.addStandardS3LinkMarshallers(arrayList);
            arrayList.add(Pair.of((Class<?>) List.class, (ArgumentMarshaller) ListToListMarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Map.class, (ArgumentMarshaller) MapToMapMarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Object.class, (ArgumentMarshaller) ObjectToMapMarshaller.instance()));
            return arrayList;
        }

        private static List<Pair<ArgumentMarshaller>> setMarshallers() {
            ArrayList arrayList = new ArrayList();
            ConversionSchemas.addStandardDateSetMarshallers(arrayList);
            ConversionSchemas.addStandardNumberSetMarshallers(arrayList);
            ConversionSchemas.addStandardStringSetMarshallers(arrayList);
            ConversionSchemas.addStandardBinarySetMarshallers(arrayList);
            return arrayList;
        }
    }

    static final class V2CompatibleMarshallerSet extends AbstractMarshallerSet {
        public V2CompatibleMarshallerSet() {
            super(marshallers(), setMarshallers());
        }

        private static List<Pair<ArgumentMarshaller>> marshallers() {
            ArrayList arrayList = new ArrayList();
            ConversionSchemas.addStandardDateMarshallers(arrayList);
            ConversionSchemas.addV1BooleanMarshallers(arrayList);
            ConversionSchemas.addStandardNumberMarshallers(arrayList);
            ConversionSchemas.addStandardStringMarshallers(arrayList);
            ConversionSchemas.addStandardBinaryMarshallers(arrayList);
            ConversionSchemas.addStandardS3LinkMarshallers(arrayList);
            arrayList.add(Pair.of((Class<?>) List.class, (ArgumentMarshaller) ListToListMarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Map.class, (ArgumentMarshaller) MapToMapMarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Object.class, (ArgumentMarshaller) ObjectToMapMarshaller.instance()));
            return arrayList;
        }

        private static List<Pair<ArgumentMarshaller>> setMarshallers() {
            ArrayList arrayList = new ArrayList();
            ConversionSchemas.addStandardDateSetMarshallers(arrayList);
            ConversionSchemas.addV1BooleanSetMarshallers(arrayList);
            ConversionSchemas.addStandardNumberSetMarshallers(arrayList);
            ConversionSchemas.addStandardStringSetMarshallers(arrayList);
            ConversionSchemas.addStandardBinarySetMarshallers(arrayList);
            arrayList.add(Pair.of((Class<?>) Object.class, (ArgumentMarshaller) ObjectSetToStringSetMarshaller.instance()));
            return arrayList;
        }
    }

    static final class V1MarshallerSet extends AbstractMarshallerSet {
        public V1MarshallerSet() {
            super(marshallers(), setMarshallers());
        }

        private static List<Pair<ArgumentMarshaller>> marshallers() {
            ArrayList arrayList = new ArrayList();
            ConversionSchemas.addStandardDateMarshallers(arrayList);
            ConversionSchemas.addV1BooleanMarshallers(arrayList);
            ConversionSchemas.addStandardNumberMarshallers(arrayList);
            ConversionSchemas.addStandardStringMarshallers(arrayList);
            ConversionSchemas.addStandardBinaryMarshallers(arrayList);
            ConversionSchemas.addStandardS3LinkMarshallers(arrayList);
            return arrayList;
        }

        private static List<Pair<ArgumentMarshaller>> setMarshallers() {
            ArrayList arrayList = new ArrayList();
            ConversionSchemas.addStandardDateSetMarshallers(arrayList);
            ConversionSchemas.addV1BooleanSetMarshallers(arrayList);
            ConversionSchemas.addStandardNumberSetMarshallers(arrayList);
            ConversionSchemas.addStandardStringSetMarshallers(arrayList);
            ConversionSchemas.addStandardBinarySetMarshallers(arrayList);
            arrayList.add(Pair.of((Class<?>) Object.class, (ArgumentMarshaller) ObjectSetToStringSetMarshaller.instance()));
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    public static void addStandardDateMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) Date.class, (ArgumentMarshaller) DateToStringMarshaller.instance()));
        list.add(Pair.of((Class<?>) Calendar.class, (ArgumentMarshaller) CalendarToStringMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addV1BooleanMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) Boolean.class, (ArgumentMarshaller) BooleanToNumberMarshaller.instance()));
        list.add(Pair.of((Class<?>) Boolean.TYPE, (ArgumentMarshaller) BooleanToNumberMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addV2BooleanMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) Boolean.class, (ArgumentMarshaller) BooleanToBooleanMarshaller.instance()));
        list.add(Pair.of((Class<?>) Boolean.TYPE, (ArgumentMarshaller) BooleanToBooleanMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardNumberMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) Number.class, (ArgumentMarshaller) NumberToNumberMarshaller.instance()));
        list.add(Pair.of((Class<?>) Byte.TYPE, (ArgumentMarshaller) NumberToNumberMarshaller.instance()));
        list.add(Pair.of((Class<?>) Short.TYPE, (ArgumentMarshaller) NumberToNumberMarshaller.instance()));
        list.add(Pair.of((Class<?>) Integer.TYPE, (ArgumentMarshaller) NumberToNumberMarshaller.instance()));
        list.add(Pair.of((Class<?>) Long.TYPE, (ArgumentMarshaller) NumberToNumberMarshaller.instance()));
        list.add(Pair.of((Class<?>) Float.TYPE, (ArgumentMarshaller) NumberToNumberMarshaller.instance()));
        list.add(Pair.of((Class<?>) Double.TYPE, (ArgumentMarshaller) NumberToNumberMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardStringMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) String.class, (ArgumentMarshaller) StringToStringMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardBinaryMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) ByteBuffer.class, (ArgumentMarshaller) ByteBufferToBinaryMarshaller.instance()));
        list.add(Pair.of((Class<?>) byte[].class, (ArgumentMarshaller) ByteArrayToBinaryMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardS3LinkMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) S3Link.class, (ArgumentMarshaller) S3LinkToStringMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardDateSetMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) Date.class, (ArgumentMarshaller) DateSetToStringSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Calendar.class, (ArgumentMarshaller) CalendarSetToStringSetMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardNumberSetMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) Number.class, (ArgumentMarshaller) NumberSetToNumberSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Byte.TYPE, (ArgumentMarshaller) NumberSetToNumberSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Short.TYPE, (ArgumentMarshaller) NumberSetToNumberSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Integer.TYPE, (ArgumentMarshaller) NumberSetToNumberSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Long.TYPE, (ArgumentMarshaller) NumberSetToNumberSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Float.TYPE, (ArgumentMarshaller) NumberSetToNumberSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Double.TYPE, (ArgumentMarshaller) NumberSetToNumberSetMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardStringSetMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) String.class, (ArgumentMarshaller) StringSetToStringSetMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addStandardBinarySetMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) ByteBuffer.class, (ArgumentMarshaller) ByteBufferSetToBinarySetMarshaller.instance()));
        list.add(Pair.of((Class<?>) byte[].class, (ArgumentMarshaller) ByteArraySetToBinarySetMarshaller.instance()));
    }

    /* access modifiers changed from: private */
    public static void addV1BooleanSetMarshallers(List<Pair<ArgumentMarshaller>> list) {
        list.add(Pair.of((Class<?>) Boolean.class, (ArgumentMarshaller) BooleanSetToNumberSetMarshaller.instance()));
        list.add(Pair.of((Class<?>) Boolean.TYPE, (ArgumentMarshaller) BooleanSetToNumberSetMarshaller.instance()));
    }

    private static class AbstractMarshallerSet implements MarshallerSet {
        private final List<Pair<ArgumentMarshaller>> marshallers;
        private final List<Pair<ArgumentMarshaller>> setMarshallers;

        public AbstractMarshallerSet(List<Pair<ArgumentMarshaller>> list, List<Pair<ArgumentMarshaller>> list2) {
            this.marshallers = list;
            this.setMarshallers = list2;
        }

        public ArgumentMarshaller getMarshaller(Method method) {
            Class<?> returnType = method.getReturnType();
            if (Set.class.isAssignableFrom(returnType)) {
                return getSet(method, ConversionSchemas.unwrapGenericSetParam(method.getGenericReturnType()));
            }
            return getScalar(method, returnType);
        }

        public ArgumentMarshaller getMemberMarshaller(Type type) {
            Class<?> resolveClass = ReflectionUtils.resolveClass(type);
            if (Set.class.isAssignableFrom(resolveClass)) {
                return getSet((Method) null, ConversionSchemas.unwrapGenericSetParam(type));
            }
            return getScalar((Method) null, resolveClass);
        }

        private ArgumentMarshaller getScalar(Method method, Class<?> cls) {
            String str;
            String str2;
            ArgumentMarshaller argumentMarshaller = (ArgumentMarshaller) ConversionSchemas.find(cls, this.marshallers);
            if (argumentMarshaller != null) {
                return argumentMarshaller;
            }
            if (method != null) {
                str2 = method.getDeclaringClass().toString();
                str = method.getName();
            } else {
                str2 = "?";
                str = str2;
            }
            throw new DynamoDBMappingException("Cannot marshall return type " + cls + " of method " + str2 + InstructionFileId.DOT + str + " without a custom marshaler.");
        }

        private ArgumentMarshaller getSet(Method method, Class<?> cls) {
            String str;
            String str2;
            ArgumentMarshaller argumentMarshaller = (ArgumentMarshaller) ConversionSchemas.find(cls, this.setMarshallers);
            if (argumentMarshaller != null) {
                return argumentMarshaller;
            }
            if (method != null) {
                str2 = method.getDeclaringClass().toString();
                str = method.getName();
            } else {
                str2 = "?";
                str = str2;
            }
            throw new DynamoDBMappingException("Cannot marshall return type Set<" + cls + "> of method " + str2 + InstructionFileId.DOT + str + " without a custom marshaller.");
        }
    }

    static class StandardUnmarshallerSet implements UnmarshallerSet {
        private final List<Pair<ArgumentUnmarshaller>> setUnmarshallers;
        private final List<Pair<ArgumentUnmarshaller>> unmarshallers;

        public StandardUnmarshallerSet() {
            this(unmarshallers(), setUnmarshallers());
        }

        public StandardUnmarshallerSet(List<Pair<ArgumentUnmarshaller>> list, List<Pair<ArgumentUnmarshaller>> list2) {
            this.unmarshallers = list;
            this.setUnmarshallers = list2;
        }

        private static List<Pair<ArgumentUnmarshaller>> unmarshallers() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Pair.of((Class<?>) Double.TYPE, (ArgumentUnmarshaller) DoubleUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Double.class, (ArgumentUnmarshaller) DoubleUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) BigDecimal.class, (ArgumentUnmarshaller) BigDecimalUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) BigInteger.class, (ArgumentUnmarshaller) BigIntegerUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Integer.TYPE, (ArgumentUnmarshaller) IntegerUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Integer.class, (ArgumentUnmarshaller) IntegerUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Float.TYPE, (ArgumentUnmarshaller) FloatUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Float.class, (ArgumentUnmarshaller) FloatUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Byte.TYPE, (ArgumentUnmarshaller) ByteUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Byte.class, (ArgumentUnmarshaller) ByteUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Long.TYPE, (ArgumentUnmarshaller) LongUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Long.class, (ArgumentUnmarshaller) LongUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Short.TYPE, (ArgumentUnmarshaller) ShortUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Short.class, (ArgumentUnmarshaller) ShortUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Boolean.TYPE, (ArgumentUnmarshaller) BooleanUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Boolean.class, (ArgumentUnmarshaller) BooleanUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Date.class, (ArgumentUnmarshaller) DateUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Calendar.class, (ArgumentUnmarshaller) CalendarUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) ByteBuffer.class, (ArgumentUnmarshaller) ByteBufferUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) byte[].class, (ArgumentUnmarshaller) ByteArrayUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) S3Link.class, (ArgumentUnmarshaller) S3LinkUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) String.class, (ArgumentUnmarshaller) StringUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) List.class, (ArgumentUnmarshaller) ListUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Map.class, (ArgumentUnmarshaller) MapUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Object.class, (ArgumentUnmarshaller) ObjectUnmarshaller.instance()));
            return arrayList;
        }

        private static List<Pair<ArgumentUnmarshaller>> setUnmarshallers() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Pair.of((Class<?>) Double.TYPE, (ArgumentUnmarshaller) DoubleSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Double.class, (ArgumentUnmarshaller) DoubleSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) BigDecimal.class, (ArgumentUnmarshaller) BigDecimalSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) BigInteger.class, (ArgumentUnmarshaller) BigIntegerSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Integer.TYPE, (ArgumentUnmarshaller) IntegerSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Integer.class, (ArgumentUnmarshaller) IntegerSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Float.TYPE, (ArgumentUnmarshaller) FloatSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Float.class, (ArgumentUnmarshaller) FloatSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Byte.TYPE, (ArgumentUnmarshaller) ByteSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Byte.class, (ArgumentUnmarshaller) ByteSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Long.TYPE, (ArgumentUnmarshaller) LongSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Long.class, (ArgumentUnmarshaller) LongSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Short.TYPE, (ArgumentUnmarshaller) ShortSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Short.class, (ArgumentUnmarshaller) ShortSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Boolean.TYPE, (ArgumentUnmarshaller) BooleanSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Boolean.class, (ArgumentUnmarshaller) BooleanSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Date.class, (ArgumentUnmarshaller) DateSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) Calendar.class, (ArgumentUnmarshaller) CalendarSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) ByteBuffer.class, (ArgumentUnmarshaller) ByteBufferSetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) byte[].class, (ArgumentUnmarshaller) ByteArraySetUnmarshaller.instance()));
            arrayList.add(Pair.of((Class<?>) String.class, (ArgumentUnmarshaller) StringSetUnmarshaller.instance()));
            return arrayList;
        }

        public ArgumentUnmarshaller getUnmarshaller(Method method, Method method2) {
            if (method2.getParameterTypes().length == 1) {
                Class cls = method2.getParameterTypes()[0];
                if (Set.class.isAssignableFrom(cls)) {
                    return getSet(method2, ConversionSchemas.unwrapGenericSetParam(method2.getGenericParameterTypes()[0]));
                }
                return getScalar(method2, cls);
            }
            throw new DynamoDBMappingException("Expected exactly one agument to " + method2);
        }

        public ArgumentUnmarshaller getMemberUnmarshaller(Type type) {
            Class<?> resolveClass = ReflectionUtils.resolveClass(type);
            if (Set.class.isAssignableFrom(resolveClass)) {
                return getSet((Method) null, ConversionSchemas.unwrapGenericSetParam(type));
            }
            return getScalar((Method) null, resolveClass);
        }

        private ArgumentUnmarshaller getSet(Method method, Class<?> cls) {
            String str;
            String str2;
            ArgumentUnmarshaller argumentUnmarshaller = (ArgumentUnmarshaller) ConversionSchemas.find(cls, this.setUnmarshallers);
            if (method != null) {
                str2 = method.getDeclaringClass().toString();
                str = method.getName();
            } else {
                str2 = "?";
                str = str2;
            }
            if (argumentUnmarshaller != null) {
                return argumentUnmarshaller;
            }
            throw new DynamoDBMappingException("Cannot unmarshall to parameter type Set<" + cls + "> of method " + str2 + InstructionFileId.DOT + str + " without a custom unmarshaler.");
        }

        private ArgumentUnmarshaller getScalar(Method method, Class<?> cls) {
            String str;
            String str2;
            ArgumentUnmarshaller argumentUnmarshaller = (ArgumentUnmarshaller) ConversionSchemas.find(cls, this.unmarshallers);
            if (method != null) {
                str2 = method.getDeclaringClass().toString();
                str = method.getName();
            } else {
                str2 = "?";
                str = str2;
            }
            if (argumentUnmarshaller != null) {
                return argumentUnmarshaller;
            }
            throw new DynamoDBMappingException("Cannot unmarshall to parameter type " + cls + "of method " + str2 + InstructionFileId.DOT + str + " without a custom unmarshaler.");
        }
    }

    /* access modifiers changed from: private */
    public static Class<?> unwrapGenericSetParam(Type type) {
        if (!(type instanceof ParameterizedType)) {
            Log log = LOGGER;
            log.warn("Set type " + type + " is not a ParameterizedType, using default marshaler and unmarshaler!");
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            Log log2 = LOGGER;
            log2.warn("Set type " + type + " does not have exactly one type argument, using default marshaler and unmarshaler!");
            return Object.class;
        } else if ("byte[]".equals(actualTypeArguments[0].toString())) {
            return byte[].class;
        } else {
            return (Class) actualTypeArguments[0];
        }
    }

    /* access modifiers changed from: private */
    public static <T> T find(Class<?> cls, List<Pair<T>> list) {
        for (Pair next : list) {
            if (next.key.isAssignableFrom(cls)) {
                return next.value;
            }
        }
        return null;
    }

    private static final class Pair<T> {
        public final Class<?> key;
        public final T value;

        public static Pair<ArgumentMarshaller> of(Class<?> cls, ArgumentMarshaller argumentMarshaller) {
            return new Pair<>(cls, argumentMarshaller);
        }

        public static Pair<ArgumentUnmarshaller> of(Class<?> cls, ArgumentUnmarshaller argumentUnmarshaller) {
            return new Pair<>(cls, argumentUnmarshaller);
        }

        private Pair(Class<?> cls, T t) {
            this.key = cls;
            this.value = t;
        }
    }

    static class AnnotationAwareMarshallerSet implements MarshallerSet {
        private final MarshallerSet wrapped;

        public AnnotationAwareMarshallerSet(MarshallerSet marshallerSet) {
            this.wrapped = marshallerSet;
        }

        public ArgumentMarshaller getMarshaller(Method method) {
            DynamoDBMarshalling dynamoDBMarshalling = (DynamoDBMarshalling) ReflectionUtils.getAnnotationFromGetterOrField(method, DynamoDBMarshalling.class);
            if (dynamoDBMarshalling != null) {
                return new CustomMarshaller(dynamoDBMarshalling.marshallerClass());
            }
            if (((DynamoDBNativeBoolean) ReflectionUtils.getAnnotationFromGetterOrField(method, DynamoDBNativeBoolean.class)) != null) {
                return BooleanToBooleanMarshaller.instance();
            }
            return this.wrapped.getMarshaller(method);
        }

        public ArgumentMarshaller getMemberMarshaller(Type type) {
            return this.wrapped.getMemberMarshaller(type);
        }
    }

    static class AnnotationAwareUnmarshallerSet implements UnmarshallerSet {
        private final UnmarshallerSet wrapped;

        public AnnotationAwareUnmarshallerSet(UnmarshallerSet unmarshallerSet) {
            this.wrapped = unmarshallerSet;
        }

        public ArgumentUnmarshaller getUnmarshaller(Method method, Method method2) {
            DynamoDBMarshalling dynamoDBMarshalling = (DynamoDBMarshalling) ReflectionUtils.getAnnotationFromGetterOrField(method, DynamoDBMarshalling.class);
            if (dynamoDBMarshalling != null) {
                return new CustomUnmarshaller(method.getReturnType(), dynamoDBMarshalling.marshallerClass());
            }
            return this.wrapped.getUnmarshaller(method, method2);
        }

        public ArgumentUnmarshaller getMemberUnmarshaller(Type type) {
            return this.wrapped.getMemberUnmarshaller(type);
        }
    }

    static class CachingMarshallerSet implements MarshallerSet {
        private final Map<Method, ArgumentMarshaller> cache = new HashMap();
        private final Map<Type, ArgumentMarshaller> memberCache = new HashMap();
        private final MarshallerSet wrapped;

        public CachingMarshallerSet(MarshallerSet marshallerSet) {
            this.wrapped = marshallerSet;
        }

        public ArgumentMarshaller getMarshaller(Method method) {
            synchronized (this.cache) {
                ArgumentMarshaller argumentMarshaller = this.cache.get(method);
                if (argumentMarshaller != null) {
                    return argumentMarshaller;
                }
                ArgumentMarshaller marshaller = this.wrapped.getMarshaller(method);
                this.cache.put(method, marshaller);
                return marshaller;
            }
        }

        public ArgumentMarshaller getMemberMarshaller(Type type) {
            synchronized (this.memberCache) {
                ArgumentMarshaller argumentMarshaller = this.memberCache.get(type);
                if (argumentMarshaller != null) {
                    return argumentMarshaller;
                }
                ArgumentMarshaller memberMarshaller = this.wrapped.getMemberMarshaller(type);
                this.memberCache.put(type, memberMarshaller);
                return memberMarshaller;
            }
        }
    }

    static class CachingUnmarshallerSet implements UnmarshallerSet {
        private final Map<Method, ArgumentUnmarshaller> cache = new HashMap();
        private final Map<Type, ArgumentUnmarshaller> memberCache = new HashMap();
        private final UnmarshallerSet wrapped;

        public CachingUnmarshallerSet(UnmarshallerSet unmarshallerSet) {
            this.wrapped = unmarshallerSet;
        }

        public ArgumentUnmarshaller getUnmarshaller(Method method, Method method2) {
            synchronized (this.cache) {
                ArgumentUnmarshaller argumentUnmarshaller = this.cache.get(method);
                if (argumentUnmarshaller != null) {
                    return argumentUnmarshaller;
                }
                ArgumentUnmarshaller unmarshaller = this.wrapped.getUnmarshaller(method, method2);
                this.cache.put(method, unmarshaller);
                return unmarshaller;
            }
        }

        public ArgumentUnmarshaller getMemberUnmarshaller(Type type) {
            synchronized (this.memberCache) {
                ArgumentUnmarshaller argumentUnmarshaller = this.memberCache.get(type);
                if (argumentUnmarshaller != null) {
                    return argumentUnmarshaller;
                }
                ArgumentUnmarshaller memberUnmarshaller = this.wrapped.getMemberUnmarshaller(type);
                this.memberCache.put(type, memberUnmarshaller);
                return memberUnmarshaller;
            }
        }
    }

    ConversionSchemas() {
        throw new UnsupportedOperationException();
    }
}
