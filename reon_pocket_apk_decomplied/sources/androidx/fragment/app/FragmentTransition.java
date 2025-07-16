package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\fH\u0007J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u000fH\u0007J,\u0010\u001b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0007R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/fragment/app/FragmentTransition;", "", "()V", "PLATFORM_IMPL", "Landroidx/fragment/app/FragmentTransitionImpl;", "SUPPORT_IMPL", "callSharedElementStartEnd", "", "inFragment", "Landroidx/fragment/app/Fragment;", "outFragment", "isPop", "", "sharedElements", "Landroidx/collection/ArrayMap;", "", "Landroid/view/View;", "isStart", "resolveSupportImpl", "setViewVisibility", "views", "", "visibility", "", "supportsTransition", "findKeyForValue", "value", "retainValues", "namedViews", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FragmentTransition.kt */
public final class FragmentTransition {
    public static final FragmentTransition INSTANCE;
    public static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionCompat21();
    public static final FragmentTransitionImpl SUPPORT_IMPL;

    private FragmentTransition() {
    }

    static {
        FragmentTransition fragmentTransition = new FragmentTransition();
        INSTANCE = fragmentTransition;
        SUPPORT_IMPL = fragmentTransition.resolveSupportImpl();
    }

    private final FragmentTransitionImpl resolveSupportImpl() {
        try {
            Class<?> cls = Class.forName("androidx.transition.FragmentTransitionSupport");
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (FragmentTransitionImpl) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        Intrinsics.checkNotNullParameter(arrayMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : arrayMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), (Object) str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry key : linkedHashMap.entrySet()) {
            arrayList.add((String) key.getKey());
        }
        return (String) CollectionsKt.firstOrNull((List) arrayList);
    }

    @JvmStatic
    public static final void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        Intrinsics.checkNotNullParameter(arrayMap, "<this>");
        Intrinsics.checkNotNullParameter(arrayMap2, "namedViews");
        int size = arrayMap.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    @JvmStatic
    public static final void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback sharedElementCallback;
        Intrinsics.checkNotNullParameter(fragment, "inFragment");
        Intrinsics.checkNotNullParameter(fragment2, "outFragment");
        Intrinsics.checkNotNullParameter(arrayMap, "sharedElements");
        if (z) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            Map map = arrayMap;
            Collection arrayList = new ArrayList(map.size());
            for (Map.Entry value : map.entrySet()) {
                arrayList.add((View) value.getValue());
            }
            List list = (List) arrayList;
            Collection arrayList2 = new ArrayList(map.size());
            for (Map.Entry key : map.entrySet()) {
                arrayList2.add((String) key.getKey());
            }
            List list2 = (List) arrayList2;
            if (z2) {
                sharedElementCallback.onSharedElementStart(list2, list, (List<View>) null);
            } else {
                sharedElementCallback.onSharedElementEnd(list2, list, (List<View>) null);
            }
        }
    }

    @JvmStatic
    public static final void setViewVisibility(List<? extends View> list, int i) {
        Intrinsics.checkNotNullParameter(list, "views");
        for (View visibility : list) {
            visibility.setVisibility(i);
        }
    }

    @JvmStatic
    public static final boolean supportsTransition() {
        return (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true;
    }
}
