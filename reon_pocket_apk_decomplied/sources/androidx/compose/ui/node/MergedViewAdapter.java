package androidx.compose.ui.node;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0012\u001a\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\b¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/MergedViewAdapter;", "Landroidx/compose/ui/node/ViewAdapter;", "()V", "adapters", "", "getAdapters", "()Ljava/util/List;", "id", "", "getId", "()I", "didInsert", "", "view", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "didUpdate", "get", "T", "factory", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "willInsert", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewInterop.android.kt */
public final class MergedViewAdapter implements ViewAdapter {
    public static final int $stable = 8;
    private final List<ViewAdapter> adapters = new ArrayList();
    private final int id;

    public int getId() {
        return this.id;
    }

    public final List<ViewAdapter> getAdapters() {
        return this.adapters;
    }

    public final <T extends ViewAdapter> T get(int i, Function0<? extends T> function0) {
        T t;
        T t2;
        List<ViewAdapter> adapters2 = getAdapters();
        int size = adapters2.size();
        int i2 = 0;
        while (true) {
            t = null;
            if (i2 >= size) {
                t2 = null;
                break;
            }
            t2 = adapters2.get(i2);
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
        getAdapters().add(t3);
        return t3;
    }

    public void willInsert(View view, ViewGroup viewGroup) {
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).willInsert(view, viewGroup);
        }
    }

    public void didInsert(View view, ViewGroup viewGroup) {
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).didInsert(view, viewGroup);
        }
    }

    public void didUpdate(View view, ViewGroup viewGroup) {
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).didUpdate(view, viewGroup);
        }
    }
}
