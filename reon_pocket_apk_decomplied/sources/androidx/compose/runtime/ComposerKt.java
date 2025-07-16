package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0000\u001a(\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u00042\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\b\u0010:\u001a\u00020;H\u0007\u001aP\u0010<\u001a>\u0012\u0004\u0012\u0002H>\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H@0?j\b\u0012\u0004\u0012\u0002H@`A0=j\u001e\u0012\u0004\u0012\u0002H>\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H@0?j\b\u0012\u0004\u0012\u0002H@`A`B\"\u0004\b\u0000\u0010>\"\u0004\b\u0001\u0010@H\u0002\u001a\u0010\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020;H\u0000\u001a\u001f\u0010C\u001a\u00020D2\u0006\u00107\u001a\u00020;2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040FH\b\u001a\u0018\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020I2\u0006\u0010G\u001a\u000205H\u0007\u001a\u0010\u0010J\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0007\u001a \u0010K\u001a\u00020D2\u0006\u0010H\u001a\u00020I2\u0006\u0010L\u001a\u00020\n2\u0006\u0010G\u001a\u000205H\u0007\u001a\b\u0010M\u001a\u00020DH\u0007\u001a(\u0010N\u001a\u00020D2\u0006\u0010L\u001a\u00020\n2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u000205H\u0007\u001a\u0018\u0010N\u001a\u00020D2\u0006\u0010L\u001a\u00020\n2\u0006\u0010Q\u001a\u000205H\u0007\u001a\f\u0010R\u001a\u00020;*\u00020\nH\u0002\u001a\f\u0010S\u001a\u00020\n*\u00020;H\u0002\u001a3\u0010T\u001a\u0002HU\"\u0004\b\u0000\u0010U*\u00020I2\u0006\u0010V\u001a\u00020;2\u0011\u0010W\u001a\r\u0012\u0004\u0012\u0002HU0F¢\u0006\u0002\bXH\b¢\u0006\u0002\u0010Y\u001a\u001c\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040[*\u00020\\2\u0006\u0010]\u001a\u00020^H\u0002\u001a\u0014\u0010_\u001a\u00020D*\u00020`2\u0006\u0010a\u001a\u00020bH\u0000\u001a\u001c\u0010c\u001a\u00020\n*\u00020d2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nH\u0002\u001a(\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00020h*\b\u0012\u0004\u0012\u00020\u00020h2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002\u001a\u001a\u0010k\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00020h2\u0006\u0010l\u001a\u00020\nH\u0002\u001a\u001a\u0010m\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00020h2\u0006\u0010l\u001a\u00020\nH\u0002\u001a$\u0010n\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020h2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002\u001a,\u0010o\u001a\u00020D*\b\u0012\u0004\u0012\u00020\u00020h2\u0006\u0010l\u001a\u00020\n2\u0006\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010\u0004H\u0002\u001a$\u0010s\u001a\u00020\n*\u00020d2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\nH\u0002\u001aY\u0010w\u001a\u0004\u0018\u0001H@\"\u0004\b\u0000\u0010>\"\u0004\b\u0001\u0010@*4\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u0002H@0?0=j\u001e\u0012\u0004\u0012\u0002H>\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H@0?j\b\u0012\u0004\u0012\u0002H@`A`B2\u0006\u0010L\u001a\u0002H>H\u0002¢\u0006\u0002\u0010x\u001a_\u0010y\u001a\u00020;\"\u0004\b\u0000\u0010>\"\u0004\b\u0001\u0010@*4\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u0002H@0?0=j\u001e\u0012\u0004\u0012\u0002H>\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H@0?j\b\u0012\u0004\u0012\u0002H@`A`B2\u0006\u0010L\u001a\u0002H>2\u0006\u00107\u001a\u0002H@H\u0002¢\u0006\u0002\u0010z\u001aa\u0010{\u001a\u0004\u0018\u00010D\"\u0004\b\u0000\u0010>\"\u0004\b\u0001\u0010@*4\u0012\u0004\u0012\u0002H>\u0012\n\u0012\b\u0012\u0004\u0012\u0002H@0?0=j\u001e\u0012\u0004\u0012\u0002H>\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H@0?j\b\u0012\u0004\u0012\u0002H@`A`B2\u0006\u0010L\u001a\u0002H>2\u0006\u00107\u001a\u0002H@H\u0002¢\u0006\u0002\u0010|\u001a\u0014\u0010}\u001a\u00020D*\u00020`2\u0006\u0010a\u001a\u00020bH\u0000\u001a'\u0010~\u001a\u00020D*\u00020`2\u0006\u0010\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u001d\u0010\u0001\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020h2\u0006\u0010l\u001a\u00020\nH\u0002\u001a#\u0010\u0001\u001a\u00020D*\b\u0012\u0004\u0012\u00020\u00020h2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\nH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0006\"\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0006\"\u000e\u0010\u000f\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u001c\u0010\u0011\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0016\u0010\u0014\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0006\"\u000e\u0010\u0016\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u001c\u0010\u0017\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0016\u0010\u001a\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0006\"\u001c\u0010\u001c\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\b\"\u0016\u0010\u001f\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0006\"\u001c\u0010!\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\b\"\u0016\u0010$\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0006\"\u001c\u0010&\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\b\"\u0016\u0010)\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u0006\"\u0016\u0010+\u001a\u00020\n8\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b,\u0010\u0006\"\u000e\u0010-\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0018\u0010.\u001a\u00020\u0004*\u00020/8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006\u0001"}, d2 = {"InvalidationLocationAscending", "Ljava/util/Comparator;", "Landroidx/compose/runtime/Invalidation;", "compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "reuseKey", "getReuseKey$annotations", "rootKey", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeRuntimeError", "", "message", "", "getKey", "value", "left", "right", "isTraceInProgress", "", "multiMap", "Ljava/util/HashMap;", "K", "Ljava/util/LinkedHashSet;", "V", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "runtimeCheck", "", "lazyMessage", "Lkotlin/Function0;", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", "T", "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "deactivateCurrentGroup", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "index", "root", "filterToRange", "", "start", "end", "findInsertLocation", "location", "findLocation", "firstInRange", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "nearestCommonRootOf", "a", "b", "common", "pop", "(Ljava/util/HashMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Unit;", "removeCurrentGroup", "removeData", "group", "data", "removeLocation", "removeRange", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerKt {
    /* access modifiers changed from: private */
    public static final Comparator<Invalidation> InvalidationLocationAscending = new ComposerKt$$ExternalSyntheticLambda0();
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    public static final int compositionLocalMapKey = 202;
    /* access modifiers changed from: private */
    public static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    private static final Object invocation = new OpaqueKey("provider");
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final Object provider = new OpaqueKey("provider");
    public static final int providerKey = 201;
    private static final Object providerMaps = new OpaqueKey("providers");
    public static final int providerMapsKey = 204;
    private static final Object providerValues = new OpaqueKey("providerValues");
    public static final int providerValuesKey = 203;
    private static final Object reference = new OpaqueKey("reference");
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;

    /* access modifiers changed from: private */
    public static final boolean asBool(int i) {
        return i != 0;
    }

    /* access modifiers changed from: private */
    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer composer, boolean z, Function0<? extends T> function0) {
        T rememberedValue = composer.rememberedValue();
        if (!z && rememberedValue != Composer.Companion.getEmpty()) {
            return rememberedValue;
        }
        T invoke = function0.invoke();
        composer.updateRememberedValue(invoke);
        return invoke;
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer composer, String str) {
        composer.sourceInformation(str);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer composer, int i, String str) {
        composer.sourceInformationMarkerStart(i, str);
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer compositionTracer2 = compositionTracer;
        return compositionTracer2 != null && compositionTracer2.isTraceInProgress();
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int i, int i2, int i3, String str) {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(i, i2, i3, str);
        }
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
        }
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer composer) {
        composer.sourceInformationMarkerEnd();
    }

    public static final void removeCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        Iterator<Object> groupSlots = slotWriter.groupSlots();
        while (groupSlots.hasNext()) {
            Object next = groupSlots.next();
            if (next instanceof ComposeNodeLifecycleCallback) {
                rememberManager.releasing((ComposeNodeLifecycleCallback) next);
            }
            if (next instanceof RememberObserverHolder) {
                rememberManager.forgetting(((RememberObserverHolder) next).getWrapped());
            }
            if (next instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) next).release();
            }
        }
        slotWriter.removeGroup();
    }

    public static final void deactivateCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        int currentGroup = slotWriter.getCurrentGroup();
        int currentGroupEnd = slotWriter.getCurrentGroupEnd();
        while (currentGroup < currentGroupEnd) {
            Object node = slotWriter.node(currentGroup);
            if (node instanceof ComposeNodeLifecycleCallback) {
                rememberManager.deactivating((ComposeNodeLifecycleCallback) node);
            }
            int access$slotIndex = slotWriter.slotIndex(slotWriter.groups, slotWriter.groupIndexToAddress(currentGroup));
            int i = currentGroup + 1;
            int access$dataIndex = slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i));
            for (int i2 = access$slotIndex; i2 < access$dataIndex; i2++) {
                int i3 = i2 - access$slotIndex;
                Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(i2)];
                if (obj instanceof RememberObserverHolder) {
                    RememberObserver wrapped = ((RememberObserverHolder) obj).getWrapped();
                    if (!(wrapped instanceof ReusableRememberObserver)) {
                        removeData(slotWriter, currentGroup, i3, obj);
                        rememberManager.forgetting(wrapped);
                    }
                } else if (obj instanceof RecomposeScopeImpl) {
                    removeData(slotWriter, currentGroup, i3, obj);
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            currentGroup = i;
        }
    }

    private static final void removeData(SlotWriter slotWriter, int i, int i2, Object obj) {
        if (!(obj == slotWriter.set(i, i2, Composer.Companion.getEmpty()))) {
            composeRuntimeError("Slot table is out of sync".toString());
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: private */
    public static final <K, V> HashMap<K, LinkedHashSet<V>> multiMap() {
        return new HashMap<>();
    }

    /* access modifiers changed from: private */
    public static final <K, V> boolean put(HashMap<K, LinkedHashSet<V>> hashMap, K k, V v) {
        Map map = hashMap;
        Object obj = map.get(k);
        if (obj == null) {
            obj = new LinkedHashSet();
            map.put(k, obj);
        }
        return ((LinkedHashSet) obj).add(v);
    }

    private static final <K, V> Unit remove(HashMap<K, LinkedHashSet<V>> hashMap, K k, V v) {
        LinkedHashSet linkedHashSet = hashMap.get(k);
        if (linkedHashSet == null) {
            return null;
        }
        linkedHashSet.remove(v);
        if (linkedHashSet.isEmpty()) {
            hashMap.remove(k);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final <K, V> V pop(HashMap<K, LinkedHashSet<V>> hashMap, K k) {
        V firstOrNull;
        LinkedHashSet linkedHashSet = hashMap.get(k);
        if (linkedHashSet == null || (firstOrNull = CollectionsKt.firstOrNull(linkedHashSet)) == null) {
            return null;
        }
        remove(hashMap, k, firstOrNull);
        return firstOrNull;
    }

    /* access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey == null) {
            return null;
        }
        if ((!Intrinsics.areEqual(joinedKey.getLeft(), obj2) || !Intrinsics.areEqual(joinedKey.getRight(), obj3)) && (obj = getKey(joinedKey.getLeft(), obj2, obj3)) == null) {
            obj = getKey(joinedKey.getRight(), obj2, obj3);
        }
        return obj;
    }

    private static final int findLocation(List<Invalidation> list, int i) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int compare = Intrinsics.compare(list.get(i3).getLocation(), i);
            if (compare < 0) {
                i2 = i3 + 1;
            } else if (compare <= 0) {
                return i3;
            } else {
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    private static final int findInsertLocation(List<Invalidation> list, int i) {
        int findLocation = findLocation(list, i);
        return findLocation < 0 ? -(findLocation + 1) : findLocation;
    }

    /* access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int findLocation = findLocation(list, i);
        IdentityArraySet identityArraySet = null;
        if (findLocation < 0) {
            int i2 = -(findLocation + 1);
            if (obj != null) {
                identityArraySet = new IdentityArraySet();
                identityArraySet.add(obj);
            }
            list.add(i2, new Invalidation(recomposeScopeImpl, i, identityArraySet));
        } else if (obj == null) {
            list.get(findLocation).setInstances((IdentityArraySet<Object>) null);
        } else {
            IdentityArraySet<Object> instances = list.get(findLocation).getInstances();
            if (instances != null) {
                instances.add(obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i, int i2) {
        int findInsertLocation = findInsertLocation(list, i);
        if (findInsertLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(findInsertLocation);
        if (invalidation.getLocation() < i2) {
            return invalidation;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i) {
        int findLocation = findLocation(list, i);
        if (findLocation >= 0) {
            return list.remove(findLocation);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i, int i2) {
        int findInsertLocation = findInsertLocation(list, i);
        while (findInsertLocation < list.size() && list.get(findInsertLocation).getLocation() < i2) {
            list.remove(findInsertLocation);
        }
    }

    /* access modifiers changed from: private */
    public static final List<Invalidation> filterToRange(List<Invalidation> list, int i, int i2) {
        List<Invalidation> arrayList = new ArrayList<>();
        for (int findInsertLocation = findInsertLocation(list, i); findInsertLocation < list.size(); findInsertLocation++) {
            Invalidation invalidation = list.get(findInsertLocation);
            if (invalidation.getLocation() >= i2) {
                break;
            }
            arrayList.add(invalidation);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        List<Object> arrayList = new ArrayList<>();
        SlotReader openReader = slotTable.openReader();
        try {
            collectNodesFrom$lambda$11$collectFromGroup(openReader, arrayList, slotTable.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            openReader.close();
        }
    }

    private static final void collectNodesFrom$lambda$11$collectFromGroup(SlotReader slotReader, List<Object> list, int i) {
        if (slotReader.isNode(i)) {
            list.add(slotReader.node(i));
            return;
        }
        int i2 = i + 1;
        int groupSize = i + slotReader.groupSize(i);
        while (i2 < groupSize) {
            collectNodesFrom$lambda$11$collectFromGroup(slotReader, list, i2);
            i2 += slotReader.groupSize(i2);
        }
    }

    private static final int distanceFrom(SlotReader slotReader, int i, int i2) {
        int i3 = 0;
        while (i > 0 && i != i2) {
            i = slotReader.parent(i);
            i3++;
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i, int i2, int i3) {
        if (i == i2) {
            return i;
        }
        if (i == i3 || i2 == i3) {
            return i3;
        }
        if (slotReader.parent(i) == i2) {
            return i2;
        }
        if (slotReader.parent(i2) == i) {
            return i;
        }
        if (slotReader.parent(i) == slotReader.parent(i2)) {
            return slotReader.parent(i);
        }
        int distanceFrom = distanceFrom(slotReader, i, i3);
        int distanceFrom2 = distanceFrom(slotReader, i2, i3);
        int i4 = distanceFrom - distanceFrom2;
        for (int i5 = 0; i5 < i4; i5++) {
            i = slotReader.parent(i);
        }
        int i6 = distanceFrom2 - distanceFrom;
        for (int i7 = 0; i7 < i6; i7++) {
            i2 = slotReader.parent(i2);
        }
        while (i != i2) {
            i = slotReader.parent(i);
            i2 = slotReader.parent(i2);
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getReference() {
        return reference;
    }

    public static final void runtimeCheck(boolean z, Function0<? extends Object> function0) {
        if (!z) {
            composeRuntimeError(function0.invoke().toString());
            throw new KotlinNothingValueException();
        }
    }

    public static final void runtimeCheck(boolean z) {
        if (!z) {
            composeRuntimeError("Check failed".toString());
            throw new KotlinNothingValueException();
        }
    }

    public static final Void composeRuntimeError(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    /* access modifiers changed from: private */
    public static final int InvalidationLocationAscending$lambda$15(Invalidation invalidation, Invalidation invalidation2) {
        return Intrinsics.compare(invalidation.getLocation(), invalidation2.getLocation());
    }
}
