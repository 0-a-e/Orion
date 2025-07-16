package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: StaticScopeForKotlinEnum.kt */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    /* access modifiers changed from: private */
    public final ClassDescriptor containingClass;
    /* access modifiers changed from: private */
    public final boolean enumEntriesCanBeUsed;
    private final NotNullLazyValue functions$delegate;
    private final NotNullLazyValue properties$delegate;

    public Void getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return null;
    }

    public StaticScopeForKotlinEnum(StorageManager storageManager, ClassDescriptor classDescriptor, boolean z) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(classDescriptor, "containingClass");
        this.containingClass = classDescriptor;
        this.enumEntriesCanBeUsed = z;
        classDescriptor.getKind();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.functions$delegate = storageManager.createLazyValue(new StaticScopeForKotlinEnum$functions$2(this));
        this.properties$delegate = storageManager.createLazyValue(new StaticScopeForKotlinEnum$properties$2(this));
    }

    static {
        Class<StaticScopeForKotlinEnum> cls = StaticScopeForKotlinEnum.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "functions", "getFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "properties", "getProperties()Ljava/util/List;"))};
    }

    private final List<SimpleFunctionDescriptor> getFunctions() {
        return (List) StorageKt.getValue(this.functions$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final List<PropertyDescriptor> getProperties() {
        return (List) StorageKt.getValue(this.properties$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    public List<CallableMemberDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt.plus(getFunctions(), getProperties());
    }

    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        Collection smartList = new SmartList();
        for (Object next : getFunctions()) {
            if (Intrinsics.areEqual((Object) ((SimpleFunctionDescriptor) next).getName(), (Object) name)) {
                smartList.add(next);
            }
        }
        return (SmartList) smartList;
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        Collection<PropertyDescriptor> smartList = new SmartList<>();
        for (Object next : getProperties()) {
            if (Intrinsics.areEqual((Object) ((PropertyDescriptor) next).getName(), (Object) name)) {
                smartList.add(next);
            }
        }
        return smartList;
    }
}
