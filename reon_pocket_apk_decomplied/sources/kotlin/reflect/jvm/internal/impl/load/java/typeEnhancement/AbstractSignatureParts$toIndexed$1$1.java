package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: AbstractSignatureParts.kt */
final class AbstractSignatureParts$toIndexed$1$1 extends Lambda implements Function1<AbstractSignatureParts.TypeAndDefaultQualifiers, Iterable<? extends AbstractSignatureParts.TypeAndDefaultQualifiers>> {
    final /* synthetic */ TypeSystemContext $this_with;
    final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractSignatureParts$toIndexed$1$1(AbstractSignatureParts<TAnnotation> abstractSignatureParts, TypeSystemContext typeSystemContext) {
        super(1);
        this.this$0 = abstractSignatureParts;
        this.$this_with = typeSystemContext;
    }

    public final Iterable<AbstractSignatureParts.TypeAndDefaultQualifiers> invoke(AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers) {
        TypeConstructorMarker typeConstructor;
        List<TypeParameterMarker> parameters;
        AbstractSignatureParts.TypeAndDefaultQualifiers typeAndDefaultQualifiers2;
        KotlinTypeMarker type;
        Intrinsics.checkNotNullParameter(typeAndDefaultQualifiers, "it");
        List list = null;
        if (this.this$0.getSkipRawTypeArguments() && (type = typeAndDefaultQualifiers.getType()) != null && this.$this_with.isRawType(type)) {
            return null;
        }
        KotlinTypeMarker type2 = typeAndDefaultQualifiers.getType();
        if (!(type2 == null || (typeConstructor = this.$this_with.typeConstructor(type2)) == null || (parameters = this.$this_with.getParameters(typeConstructor)) == null)) {
            Iterable iterable = parameters;
            Iterable arguments = this.$this_with.getArguments(typeAndDefaultQualifiers.getType());
            TypeSystemContext typeSystemContext = this.$this_with;
            AbstractSignatureParts<TAnnotation> abstractSignatureParts = this.this$0;
            Iterator it = iterable.iterator();
            Iterator it2 = arguments.iterator();
            ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable, 10), CollectionsKt.collectionSizeOrDefault(arguments, 10)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                TypeArgumentMarker typeArgumentMarker = (TypeArgumentMarker) it2.next();
                TypeParameterMarker typeParameterMarker = (TypeParameterMarker) next;
                if (typeSystemContext.isStarProjection(typeArgumentMarker)) {
                    typeAndDefaultQualifiers2 = new AbstractSignatureParts.TypeAndDefaultQualifiers((KotlinTypeMarker) null, typeAndDefaultQualifiers.getDefaultQualifiers(), typeParameterMarker);
                } else {
                    KotlinTypeMarker type3 = typeSystemContext.getType(typeArgumentMarker);
                    typeAndDefaultQualifiers2 = new AbstractSignatureParts.TypeAndDefaultQualifiers(type3, abstractSignatureParts.extractAndMergeDefaultQualifiers(type3, typeAndDefaultQualifiers.getDefaultQualifiers()), typeParameterMarker);
                }
                arrayList.add(typeAndDefaultQualifiers2);
            }
            list = arrayList;
        }
        return list;
    }
}
