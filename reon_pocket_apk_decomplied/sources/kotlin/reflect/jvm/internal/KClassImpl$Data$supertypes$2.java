package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$supertypes$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    final /* synthetic */ KClassImpl<T>.Data this$0;
    final /* synthetic */ KClassImpl<T> this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$supertypes$2(KClassImpl<T>.Data data, KClassImpl<T> kClassImpl) {
        super(0);
        this.this$0 = data;
        this.this$1 = kClassImpl;
    }

    public final List<KTypeImpl> invoke() {
        Collection<KotlinType> supertypes = this.this$0.getDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
        ArrayList arrayList = new ArrayList(supertypes.size());
        KClassImpl<T>.Data data = this.this$0;
        KClassImpl<T> kClassImpl = this.this$1;
        for (KotlinType kotlinType : supertypes) {
            Intrinsics.checkNotNull(kotlinType);
            arrayList.add(new KTypeImpl(kotlinType, new KClassImpl$Data$supertypes$2$1$1(kotlinType, data, kClassImpl)));
        }
        Collection collection = arrayList;
        if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.this$0.getDescriptor())) {
            Iterable iterable = arrayList;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ClassKind kind = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) it.next()).getType()).getKind();
                    Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
                    if (kind != ClassKind.INTERFACE && kind != ClassKind.ANNOTATION_CLASS) {
                        break;
                    }
                }
            }
            SimpleType anyType = DescriptorUtilsKt.getBuiltIns(this.this$0.getDescriptor()).getAnyType();
            Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
            collection.add(new KTypeImpl(anyType, AnonymousClass3.INSTANCE));
        }
        return CollectionsKt.compact(arrayList);
    }
}
