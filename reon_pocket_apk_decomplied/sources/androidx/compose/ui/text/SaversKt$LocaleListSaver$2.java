package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/intl/LocaleList;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$LocaleListSaver$2 extends Lambda implements Function1<Object, LocaleList> {
    public static final SaversKt$LocaleListSaver$2 INSTANCE = new SaversKt$LocaleListSaver$2();

    SaversKt$LocaleListSaver$2() {
        super(1);
    }

    public final LocaleList invoke(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            Collection collection = arrayList;
            Saver<Locale, Object> saver = SaversKt.getSaver(Locale.Companion);
            Locale locale = null;
            if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                locale = saver.restore(obj2);
            }
            Intrinsics.checkNotNull(locale);
            collection.add(locale);
        }
        return new LocaleList((List<Locale>) arrayList);
    }
}
