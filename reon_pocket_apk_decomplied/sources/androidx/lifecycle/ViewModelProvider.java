package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0016\u0017\u0018\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ&\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0002¢\u0006\u0002\u0010\u0012J.\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0002¢\u0006\u0002\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/lifecycle/ViewModelProvider;", "", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "store", "Landroidx/lifecycle/ViewModelStore;", "defaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "get", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AndroidViewModelFactory", "Factory", "NewInstanceFactory", "OnRequeryFactory", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewModelProvider.kt */
public class ViewModelProvider {
    private final CreationExtras defaultCreationExtras;
    private final Factory factory;
    private final ViewModelStore store;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "()V", "onRequery", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewModelProvider.kt */
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory2) {
        this(viewModelStore, factory2, (CreationExtras) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(viewModelStore, "store");
        Intrinsics.checkNotNullParameter(factory2, "factory");
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(viewModelStore, "store");
        Intrinsics.checkNotNullParameter(factory2, "factory");
        Intrinsics.checkNotNullParameter(creationExtras, "defaultCreationExtras");
        this.store = viewModelStore;
        this.factory = factory2;
        this.defaultCreationExtras = creationExtras;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory2, (i & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J-\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewModelProvider.kt */
    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;

        <T extends ViewModel> T create(Class<T> cls);

        <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras);

        /* renamed from: androidx.lifecycle.ViewModelProvider$Factory$-CC  reason: invalid class name */
        /* compiled from: ViewModelProvider.kt */
        public final /* synthetic */ class CC {
            static {
                Companion companion = Factory.Companion;
            }

            @JvmStatic
            public static Factory from(ViewModelInitializer<?>... viewModelInitializerArr) {
                return Factory.Companion.from(viewModelInitializerArr);
            }

            public static ViewModel $default$create(Factory _this, Class cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
            }

            public static ViewModel $default$create(Factory _this, Class cls, CreationExtras creationExtras) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                Intrinsics.checkNotNullParameter(creationExtras, "extras");
                return _this.create(cls);
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\"\u0006\u0012\u0002\b\u00030\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory$Companion;", "", "()V", "from", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ViewModelProvider.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @JvmStatic
            public final Factory from(ViewModelInitializer<?>... viewModelInitializerArr) {
                Intrinsics.checkNotNullParameter(viewModelInitializerArr, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner) {
        this(viewModelStoreOwner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(viewModelStoreOwner), ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory2) {
        this(viewModelStoreOwner.getViewModelStore(), factory2, ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Intrinsics.checkNotNullParameter(factory2, "factory");
    }

    public <T extends ViewModel> T get(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T get(String str, Class<T> cls) {
        T t;
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        T t2 = this.store.get(str);
        if (cls.isInstance(t2)) {
            Factory factory2 = this.factory;
            OnRequeryFactory onRequeryFactory = factory2 instanceof OnRequeryFactory ? (OnRequeryFactory) factory2 : null;
            if (onRequeryFactory != null) {
                Intrinsics.checkNotNull(t2);
                onRequeryFactory.onRequery(t2);
            }
            Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t2;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.set(NewInstanceFactory.VIEW_MODEL_KEY, str);
        try {
            t = this.factory.create(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t = this.factory.create(cls);
        }
        this.store.put(str, t);
        return t;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewModelProvider.kt */
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;
        /* access modifiers changed from: private */
        public static NewInstanceFactory sInstance;

        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return Factory.CC.$default$create(this, cls, creationExtras);
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            try {
                T newInstance = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                modelC…wInstance()\n            }");
                return (ViewModel) newInstance;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078GX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion;", "", "()V", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "instance", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "getInstance$annotations", "getInstance", "()Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "sInstance", "ViewModelKeyImpl", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ViewModelProvider.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public static /* synthetic */ void getInstance$annotations() {
            }

            private Companion() {
            }

            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory access$getSInstance$cp = NewInstanceFactory.sInstance;
                Intrinsics.checkNotNull(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: ViewModelProvider.kt */
            private static final class ViewModelKeyImpl implements CreationExtras.Key<String> {
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ-\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0010J-\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "()V", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "unused", "", "(Landroid/app/Application;I)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewModelProvider.kt */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final CreationExtras.Key<Application> APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        /* access modifiers changed from: private */
        public static AndroidViewModelFactory sInstance;
        private final Application application;

        @JvmStatic
        public static final AndroidViewModelFactory getInstance(Application application2) {
            return Companion.getInstance(application2);
        }

        private AndroidViewModelFactory(Application application2, int i) {
            this.application = application2;
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application2) {
            this(application2, 0);
            Intrinsics.checkNotNullParameter(application2, "application");
        }

        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(creationExtras, "extras");
            if (this.application != null) {
                return create(cls);
            }
            Application application2 = (Application) creationExtras.get(APPLICATION_KEY);
            if (application2 != null) {
                return create(cls, application2);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Application application2 = this.application;
            if (application2 != null) {
                return create(cls, application2);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application2) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                T t = (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application2});
                Intrinsics.checkNotNullExpressionValue(t, "{\n                try {\n…          }\n            }");
                return t;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion;", "", "()V", "APPLICATION_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/app/Application;", "DEFAULT_KEY", "", "sInstance", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "defaultFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "defaultFactory$lifecycle_viewmodel_release", "getInstance", "application", "ApplicationKeyImpl", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ViewModelProvider.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner viewModelStoreOwner) {
                Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
                return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : NewInstanceFactory.Companion.getInstance();
            }

            @JvmStatic
            public final AndroidViewModelFactory getInstance(Application application) {
                Intrinsics.checkNotNullParameter(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory access$getSInstance$cp = AndroidViewModelFactory.sInstance;
                Intrinsics.checkNotNull(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/app/Application;", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* compiled from: ViewModelProvider.kt */
            private static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }
        }
    }
}
