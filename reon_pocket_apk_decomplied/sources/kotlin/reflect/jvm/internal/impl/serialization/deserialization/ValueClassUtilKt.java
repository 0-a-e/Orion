package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: ValueClassUtil.kt */
public final class ValueClassUtilKt {
    public static final <T extends SimpleTypeMarker> ValueClassRepresentation<T> loadValueClassRepresentation(ProtoBuf.Class classR, NameResolver nameResolver, TypeTable typeTable, Function1<? super ProtoBuf.Type, ? extends T> function1, Function1<? super Name, ? extends T> function12) {
        SimpleTypeMarker simpleTypeMarker;
        List<ProtoBuf.Type> list;
        Intrinsics.checkNotNullParameter(classR, "<this>");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(function1, "typeDeserializer");
        Intrinsics.checkNotNullParameter(function12, "typeOfPublicProperty");
        if (classR.getMultiFieldValueClassUnderlyingNameCount() > 0) {
            List<Integer> multiFieldValueClassUnderlyingNameList = classR.getMultiFieldValueClassUnderlyingNameList();
            Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingNameList, "getMultiFieldValueClassUnderlyingNameList(...)");
            Iterable<Integer> iterable = multiFieldValueClassUnderlyingNameList;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Integer num : iterable) {
                Intrinsics.checkNotNull(num);
                arrayList.add(NameResolverUtilKt.getName(nameResolver, num.intValue()));
            }
            List list2 = (List) arrayList;
            Pair pair = TuplesKt.to(Integer.valueOf(classR.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(classR.getMultiFieldValueClassUnderlyingTypeCount()));
            if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(Integer.valueOf(list2.size()), 0))) {
                List<Integer> multiFieldValueClassUnderlyingTypeIdList = classR.getMultiFieldValueClassUnderlyingTypeIdList();
                Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingTypeIdList, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
                Iterable<Integer> iterable2 = multiFieldValueClassUnderlyingTypeIdList;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (Integer num2 : iterable2) {
                    Intrinsics.checkNotNull(num2);
                    arrayList2.add(typeTable.get(num2.intValue()));
                }
                list = (List) arrayList2;
            } else if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(0, Integer.valueOf(list2.size())))) {
                list = classR.getMultiFieldValueClassUnderlyingTypeList();
            } else {
                throw new IllegalStateException(("class " + NameResolverUtilKt.getName(nameResolver, classR.getFqName()) + " has illegal multi-field value class representation").toString());
            }
            Intrinsics.checkNotNull(list);
            Iterable<Object> iterable3 = list;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
            for (Object invoke : iterable3) {
                arrayList3.add(function1.invoke(invoke));
            }
            return new MultiFieldValueClassRepresentation<>(CollectionsKt.zip(list2, (List) arrayList3));
        } else if (!classR.hasInlineClassUnderlyingPropertyName()) {
            return null;
        } else {
            Name name = NameResolverUtilKt.getName(nameResolver, classR.getInlineClassUnderlyingPropertyName());
            ProtoBuf.Type inlineClassUnderlyingType = ProtoTypeTableUtilKt.inlineClassUnderlyingType(classR, typeTable);
            if ((inlineClassUnderlyingType != null && (simpleTypeMarker = (SimpleTypeMarker) function1.invoke(inlineClassUnderlyingType)) != null) || (simpleTypeMarker = (SimpleTypeMarker) function12.invoke(name)) != null) {
                return new InlineClassRepresentation<>(name, simpleTypeMarker);
            }
            throw new IllegalStateException(("cannot determine underlying type for value class " + NameResolverUtilKt.getName(nameResolver, classR.getFqName()) + " with property " + name).toString());
        }
    }
}
