package androidx.compose.ui.node;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a1\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\bH\u0000\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"viewAdaptersKey", "", "tagKey", "key", "", "getOrAddAdapter", "T", "Landroidx/compose/ui/node/ViewAdapter;", "Landroid/view/View;", "id", "factory", "Lkotlin/Function0;", "(Landroid/view/View;ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "getViewAdapter", "Landroidx/compose/ui/node/MergedViewAdapter;", "getViewAdapterIfExists", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewInterop.android.kt */
public final class ViewInterop_androidKt {
    private static final int viewAdaptersKey = tagKey("ViewAdapter");

    public static final <T extends ViewAdapter> T getOrAddAdapter(View view, int i, Function0<? extends T> function0) {
        T t;
        T t2;
        MergedViewAdapter viewAdapter = getViewAdapter(view);
        List<ViewAdapter> adapters = viewAdapter.getAdapters();
        int size = adapters.size();
        int i2 = 0;
        while (true) {
            t = null;
            if (i2 >= size) {
                t2 = null;
                break;
            }
            t2 = adapters.get(i2);
            if (((ViewAdapter) t2).getId() == i) {
                break;
            }
            i2++;
        }
        if (t2 instanceof ViewAdapter) {
            t = (ViewAdapter) t2;
        }
        if (t != null) {
            return t;
        }
        T t3 = (ViewAdapter) function0.invoke();
        viewAdapter.getAdapters().add(t3);
        return t3;
    }

    public static final int tagKey(String str) {
        return str.hashCode() | 50331648;
    }

    public static final MergedViewAdapter getViewAdapterIfExists(View view) {
        Object tag = view.getTag(viewAdaptersKey);
        if (tag instanceof MergedViewAdapter) {
            return (MergedViewAdapter) tag;
        }
        return null;
    }

    public static final MergedViewAdapter getViewAdapter(View view) {
        int i = viewAdaptersKey;
        Object tag = view.getTag(i);
        MergedViewAdapter mergedViewAdapter = tag instanceof MergedViewAdapter ? (MergedViewAdapter) tag : null;
        if (mergedViewAdapter != null) {
            return mergedViewAdapter;
        }
        MergedViewAdapter mergedViewAdapter2 = new MergedViewAdapter();
        view.setTag(i, mergedViewAdapter2);
        return mergedViewAdapter2;
    }
}
