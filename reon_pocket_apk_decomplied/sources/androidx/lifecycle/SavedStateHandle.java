package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u001e\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u0002H\u0016H\u0002¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160 \"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007J\u001d\u0010$\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0017J\b\u0010\r\u001a\u00020\u000eH\u0007J&\u0010%\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u0001H\u0016H\u0002¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000eH\u0007R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "initialState", "", "", "(Ljava/util/Map;)V", "()V", "flows", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "liveDatas", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "regular", "savedStateProvider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProviders", "clearSavedStateProvider", "", "key", "contains", "", "get", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "getLiveData", "Landroidx/lifecycle/MutableLiveData;", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "hasInitialValue", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "keys", "", "remove", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "setSavedStateProvider", "provider", "Companion", "SavingStateLiveData", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SavedStateHandle.kt */
public final class SavedStateHandle {
    /* access modifiers changed from: private */
    public static final Class<? extends Object>[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    /* access modifiers changed from: private */
    public final Map<String, MutableStateFlow<Object>> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    /* access modifiers changed from: private */
    public final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    @JvmStatic
    public static final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    /* access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "this$0");
        for (Map.Entry next : MapsKt.toMap(savedStateHandle.savedStateProviders).entrySet()) {
            savedStateHandle.set((String) next.getKey(), ((SavedStateRegistry.SavedStateProvider) next.getValue()).saveState());
        }
        Set<String> keySet = savedStateHandle.regular.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next2 : keySet) {
            arrayList.add(next2);
            arrayList2.add(savedStateHandle.regular.get(next2));
        }
        return BundleKt.bundleOf(TuplesKt.to(KEYS, arrayList), TuplesKt.to(VALUES, arrayList2));
    }

    public SavedStateHandle(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "initialState");
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateHandle$$ExternalSyntheticLambda0(this);
        linkedHashMap.putAll(map);
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateHandle$$ExternalSyntheticLambda0(this);
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    public final boolean contains(String str) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        return this.regular.containsKey(str);
    }

    public final <T> MutableLiveData<T> getLiveData(String str) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(str, false, (Object) null);
        Intrinsics.checkNotNull(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    public final <T> MutableLiveData<T> getLiveData(String str, T t) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        return getLiveDataInternal(str, true, t);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z, T t) {
        SavingStateLiveData savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.liveDatas.get(str);
        MutableLiveData<T> mutableLiveData = savingStateLiveData2 instanceof MutableLiveData ? savingStateLiveData2 : null;
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        if (this.regular.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData(this, str, this.regular.get(str));
        } else if (z) {
            this.regular.put(str, t);
            savingStateLiveData = new SavingStateLiveData(this, str, t);
        } else {
            savingStateLiveData = new SavingStateLiveData(this, str);
        }
        this.liveDatas.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    public final <T> StateFlow<T> getStateFlow(String str, T t) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        Map<String, MutableStateFlow<Object>> map = this.flows;
        MutableStateFlow<Object> mutableStateFlow = map.get(str);
        if (mutableStateFlow == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t);
            }
            mutableStateFlow = StateFlowKt.MutableStateFlow(this.regular.get(str));
            this.flows.put(str, mutableStateFlow);
            map.put(str, mutableStateFlow);
        }
        StateFlow<T> asStateFlow = FlowKt.asStateFlow(mutableStateFlow);
        Intrinsics.checkNotNull(asStateFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return asStateFlow;
    }

    public final Set<String> keys() {
        return SetsKt.plus(SetsKt.plus(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    public final <T> T get(String str) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        try {
            return this.regular.get(str);
        } catch (ClassCastException unused) {
            remove(str);
            return null;
        }
    }

    public final <T> void set(String str, T t) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        if (Companion.validateValue(t)) {
            SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(str);
            MutableLiveData mutableLiveData = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
            if (mutableLiveData != null) {
                mutableLiveData.setValue(t);
            } else {
                this.regular.put(str, t);
            }
            MutableStateFlow mutableStateFlow = this.flows.get(str);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(t);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder("Can't put value with type ");
        Intrinsics.checkNotNull(t);
        sb.append(t.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    public final <T> T remove(String str) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        T remove = this.regular.remove(str);
        SavingStateLiveData remove2 = this.liveDatas.remove(str);
        if (remove2 != null) {
            remove2.detach();
        }
        this.flows.remove(str);
        return remove;
    }

    public final void setSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider2) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        Intrinsics.checkNotNullParameter(savedStateProvider2, "provider");
        this.savedStateProviders.put(str, savedStateProvider2);
    }

    public final void clearSavedStateProvider(String str) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        this.savedStateProviders.remove(str);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "key", "", "value", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "detach", "", "setValue", "(Ljava/lang/Object;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SavedStateHandle.kt */
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t) {
            super(t);
            Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
            this.key = str;
            this.handle = savedStateHandle;
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
            this.key = str;
            this.handle = savedStateHandle;
        }

        public void setValue(T t) {
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null) {
                savedStateHandle.regular.put(this.key, t);
                MutableStateFlow mutableStateFlow = (MutableStateFlow) savedStateHandle.flows.get(this.key);
                if (mutableStateFlow != null) {
                    mutableStateFlow.setValue(t);
                }
            }
            super.setValue(t);
        }

        public final void detach() {
            this.handle = null;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0007R \u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "()V", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "KEYS", "", "VALUES", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "defaultState", "validateValue", "", "value", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SavedStateHandle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(SavedStateHandle.KEYS);
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(SavedStateHandle.VALUES);
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state".toString());
                }
                Map linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i = 0; i < size; i++) {
                    Object obj = parcelableArrayList.get(i);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
                }
                return new SavedStateHandle(linkedHashMap);
            } else if (bundle2 == null) {
                return new SavedStateHandle();
            } else {
                Map hashMap = new HashMap();
                for (String str : bundle2.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(str, TransferTable.COLUMN_KEY);
                    hashMap.put(str, bundle2.get(str));
                }
                return new SavedStateHandle(hashMap);
            }
        }

        public final boolean validateValue(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.ACCEPTABLE_CLASSES) {
                Intrinsics.checkNotNull(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }
}
