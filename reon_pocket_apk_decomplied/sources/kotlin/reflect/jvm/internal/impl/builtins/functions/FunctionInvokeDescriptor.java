package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* compiled from: FunctionInvokeDescriptor.kt */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z);
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isTailrec() {
        return false;
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, kind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z);
        setHasStableParameterNames(false);
    }

    /* access modifiers changed from: protected */
    public FunctionDescriptor doSubstitute(FunctionDescriptorImpl.CopyConfiguration copyConfiguration) {
        Intrinsics.checkNotNullParameter(copyConfiguration, RemoteConfigUtil.KEY_REMOTE_CONFIG);
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.doSubstitute(copyConfiguration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        Iterable<ValueParameterDescriptor> iterable = valueParameters;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (ValueParameterDescriptor type : iterable) {
                KotlinType type2 = type.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2) != null) {
                    List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                    Iterable<ValueParameterDescriptor> iterable2 = valueParameters2;
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                    for (ValueParameterDescriptor type3 : iterable2) {
                        KotlinType type4 = type3.getType();
                        Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                        arrayList.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type4));
                    }
                    return functionInvokeDescriptor.replaceParameterNames((List) arrayList);
                }
            }
        }
        return functionInvokeDescriptor;
    }

    /* access modifiers changed from: protected */
    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return new FunctionInvokeDescriptor(declarationDescriptor, (FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    private final FunctionDescriptor replaceParameterNames(List<Name> list) {
        Name name;
        int size = getValueParameters().size() - list.size();
        boolean z = true;
        if (size == 0) {
            List<ValueParameterDescriptor> valueParameters = getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            Iterable<Pair> zip = CollectionsKt.zip(list, valueParameters);
            if (!(zip instanceof Collection) || !((Collection) zip).isEmpty()) {
                for (Pair pair : zip) {
                    if (!Intrinsics.areEqual((Object) (Name) pair.component1(), (Object) ((ValueParameterDescriptor) pair.component2()).getName())) {
                    }
                }
            }
            return this;
        }
        List<ValueParameterDescriptor> valueParameters2 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        Iterable<ValueParameterDescriptor> iterable = valueParameters2;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ValueParameterDescriptor valueParameterDescriptor : iterable) {
            Name name2 = valueParameterDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            int index = valueParameterDescriptor.getIndex();
            int i = index - size;
            if (i >= 0 && (name = list.get(i)) != null) {
                name2 = name;
            }
            arrayList.add(valueParameterDescriptor.copy(this, name2, index));
        }
        List list2 = (List) arrayList;
        FunctionDescriptorImpl.CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        Iterable iterable2 = list;
        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
            Iterator it = iterable2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Name) it.next()) == null) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        FunctionDescriptorImpl.CopyConfiguration original = newCopyBuilder.setHasSynthesizedParameterNames(z).setValueParameters(list2).setOriginal((CallableMemberDescriptor) getOriginal());
        Intrinsics.checkNotNullExpressionValue(original, "setOriginal(...)");
        FunctionDescriptor doSubstitute = super.doSubstitute(original);
        Intrinsics.checkNotNull(doSubstitute);
        return doSubstitute;
    }

    /* compiled from: FunctionInvokeDescriptor.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor functionClassDescriptor, boolean z) {
            Intrinsics.checkNotNullParameter(functionClassDescriptor, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClassDescriptor.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClassDescriptor, (FunctionInvokeDescriptor) null, CallableMemberDescriptor.Kind.DECLARATION, z, (DefaultConstructorMarker) null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClassDescriptor.getThisAsReceiverParameter();
            List emptyList = CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object next : declaredTypeParameters) {
                if (((TypeParameterDescriptor) next).getVariance() != Variance.IN_VARIANCE) {
                    break;
                }
                arrayList.add(next);
            }
            Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(arrayList);
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(withIndex, 10));
            for (IndexedValue indexedValue : withIndex) {
                arrayList2.add(FunctionInvokeDescriptor.Factory.createValueParameter(functionInvokeDescriptor, indexedValue.getIndex(), (TypeParameterDescriptor) indexedValue.getValue()));
            }
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, emptyList, emptyList2, (List) arrayList2, (KotlinType) ((TypeParameterDescriptor) CollectionsKt.last(declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor functionInvokeDescriptor, int i, TypeParameterDescriptor typeParameterDescriptor) {
            String str;
            String asString = typeParameterDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            if (Intrinsics.areEqual((Object) asString, (Object) "T")) {
                str = "instance";
            } else if (Intrinsics.areEqual((Object) asString, (Object) "E")) {
                str = "receiver";
            } else {
                str = asString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            Name identifier = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            SimpleType defaultType = typeParameterDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(functionInvokeDescriptor, (ValueParameterDescriptor) null, i, empty, identifier, defaultType, false, false, false, (KotlinType) null, sourceElement);
        }
    }
}
