package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;

/* compiled from: DeserializedPackageMemberScope.kt */
public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    private final String debugName;
    private final PackageFragmentDescriptor packageDescriptor;
    private final FqName packageFqName;

    /* access modifiers changed from: protected */
    public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializedPackageMemberScope(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r17, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r18, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r19, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r20, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r21, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r22, java.lang.String r23, kotlin.jvm.functions.Function0<? extends java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name>> r24) {
        /*
            r16 = this;
            r6 = r16
            r14 = r17
            r15 = r23
            java.lang.String r0 = "packageDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "proto"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "nameResolver"
            r2 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "metadataVersion"
            r3 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "components"
            r4 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "debugName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "classNames"
            r5 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r10 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r0 = r18.getTypeTable()
            java.lang.String r7 = "getTypeTable(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            r10.<init>(r0)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable$Companion r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r18.getVersionRequirementTable()
            java.lang.String r8 = "getVersionRequirementTable(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r11 = r0.create(r7)
            r7 = r22
            r8 = r17
            r9 = r19
            r12 = r20
            r13 = r21
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r7.createContext(r8, r9, r10, r11, r12, r13)
            java.util.List r3 = r18.getFunctionList()
            java.lang.String r0 = "getFunctionList(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.util.List r4 = r18.getPropertyList()
            java.lang.String r0 = "getPropertyList(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.util.List r7 = r18.getTypeAliasList()
            java.lang.String r0 = "getTypeAliasList(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r0 = r16
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r6.packageDescriptor = r14
            r6.debugName = r15
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r17.getFqName()
            r6.packageFqName = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope.<init>(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents, java.lang.String, kotlin.jvm.functions.Function0):void");
    }

    public List<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Collection<DeclarationDescriptor> computeDescriptors = computeDescriptors(descriptorKindFilter, function1, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = getC().getComponents().getFictitiousClassDescriptorFactories();
        Collection arrayList = new ArrayList();
        for (ClassDescriptorFactory allContributedClassesIfPossible : fictitiousClassDescriptorFactories) {
            CollectionsKt.addAll(arrayList, allContributedClassesIfPossible.getAllContributedClassesIfPossible(this.packageFqName));
        }
        return CollectionsKt.plus(computeDescriptors, (List) arrayList);
    }

    /* access modifiers changed from: protected */
    public boolean hasClass(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!super.hasClass(name)) {
            Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = getC().getComponents().getFictitiousClassDescriptorFactories();
            if (!(fictitiousClassDescriptorFactories instanceof Collection) || !((Collection) fictitiousClassDescriptorFactories).isEmpty()) {
                for (ClassDescriptorFactory shouldCreateClass : fictitiousClassDescriptorFactories) {
                    if (shouldCreateClass.shouldCreateClass(this.packageFqName, name)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ClassId createClassId(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ClassId(this.packageFqName, name);
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        recordLookup(name, lookupLocation);
        return super.getContributedClassifier(name, lookupLocation);
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, this.packageDescriptor, name);
    }

    /* access modifiers changed from: protected */
    public Set<Name> getNonDeclaredFunctionNames() {
        return SetsKt.emptySet();
    }

    /* access modifiers changed from: protected */
    public Set<Name> getNonDeclaredVariableNames() {
        return SetsKt.emptySet();
    }

    /* access modifiers changed from: protected */
    public Set<Name> getNonDeclaredClassifierNames() {
        return SetsKt.emptySet();
    }

    public String toString() {
        return this.debugName;
    }
}
