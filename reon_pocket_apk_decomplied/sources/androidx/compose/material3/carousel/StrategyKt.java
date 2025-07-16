package androidx.compose.material3.carousel;

import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a0\u0010\u0000\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002¨\u0006\u000e"}, d2 = {"lerp", "Landroidx/compose/material3/carousel/Keyline;", "start", "end", "fraction", "", "Landroidx/compose/material3/carousel/KeylineList;", "from", "to", "outputMin", "outputMax", "inputMin", "inputMax", "value", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Strategy.kt */
public final class StrategyKt {
    public static final Keyline lerp(Keyline keyline, Keyline keyline2, float f) {
        int i = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
        return new Keyline(MathHelpersKt.lerp(keyline.getSize(), keyline2.getSize(), f), MathHelpersKt.lerp(keyline.getOffset(), keyline2.getOffset(), f), MathHelpersKt.lerp(keyline.getUnadjustedOffset(), keyline2.getUnadjustedOffset(), f), i < 0 ? keyline.isFocal() : keyline2.isFocal(), i < 0 ? keyline.isAnchor() : keyline2.isAnchor(), i < 0 ? keyline.isPivot() : keyline2.isPivot(), MathHelpersKt.lerp(keyline.getCutoff(), keyline2.getCutoff(), f));
    }

    public static final KeylineList lerp(KeylineList keylineList, KeylineList keylineList2, float f) {
        List list = keylineList;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(lerp((Keyline) list.get(i), keylineList2.get(i), f));
        }
        return new KeylineList(arrayList);
    }

    /* access modifiers changed from: private */
    public static final float lerp(float f, float f2, float f3, float f4, float f5) {
        if (f5 <= f3) {
            return f;
        }
        return f5 >= f4 ? f2 : MathHelpersKt.lerp(f, f2, (f5 - f3) / (f4 - f3));
    }
}
