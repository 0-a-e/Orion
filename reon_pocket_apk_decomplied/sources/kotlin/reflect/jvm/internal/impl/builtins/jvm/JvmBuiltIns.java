package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltIns.kt */
public final class JvmBuiltIns extends KotlinBuiltIns {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    private final NotNullLazyValue customizer$delegate;
    private final Kind kind;
    /* access modifiers changed from: private */
    public Function0<Settings> settingsComputation;

    /* compiled from: JvmBuiltIns.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Kind[] r0 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Kind r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.FROM_DEPENDENCIES     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Kind r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.FROM_CLASS_LOADER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Kind r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.FALLBACK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns(StorageManager storageManager, Kind kind2) {
        super(storageManager);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kind2, "kind");
        this.kind = kind2;
        this.customizer$delegate = storageManager.createLazyValue(new JvmBuiltIns$customizer$2(this, storageManager));
        int i = WhenMappings.$EnumSwitchMapping$0[kind2.ordinal()];
        if (i == 2) {
            createBuiltInsModule(false);
        } else if (i == 3) {
            createBuiltInsModule(true);
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        static {
            Kind[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    public static final class Settings {
        private final boolean isAdditionalBuiltInsFeatureSupported;
        private final ModuleDescriptor ownerModuleDescriptor;

        public Settings(ModuleDescriptor moduleDescriptor, boolean z) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = moduleDescriptor;
            this.isAdditionalBuiltInsFeatureSupported = z;
        }

        public final ModuleDescriptor getOwnerModuleDescriptor() {
            return this.ownerModuleDescriptor;
        }

        public final boolean isAdditionalBuiltInsFeatureSupported() {
            return this.isAdditionalBuiltInsFeatureSupported;
        }
    }

    public final void setPostponedSettingsComputation(Function0<Settings> function0) {
        Intrinsics.checkNotNullParameter(function0, "computation");
        this.settingsComputation = function0;
    }

    public final void initialize(ModuleDescriptor moduleDescriptor, boolean z) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        setPostponedSettingsComputation(new JvmBuiltIns$initialize$1(moduleDescriptor, z));
    }

    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) StorageKt.getValue(this.customizer$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* access modifiers changed from: protected */
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }

    /* access modifiers changed from: protected */
    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    /* access modifiers changed from: protected */
    public List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> classDescriptorFactories = super.getClassDescriptorFactories();
        Intrinsics.checkNotNullExpressionValue(classDescriptorFactories, "getClassDescriptorFactories(...)");
        StorageManager storageManager = getStorageManager();
        Intrinsics.checkNotNullExpressionValue(storageManager, "getStorageManager(...)");
        ModuleDescriptorImpl builtInsModule = getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(builtInsModule, "getBuiltInsModule(...)");
        return CollectionsKt.plus(classDescriptorFactories, new JvmBuiltInClassDescriptorFactory(storageManager, builtInsModule, (Function1) null, 4, (DefaultConstructorMarker) null));
    }
}
