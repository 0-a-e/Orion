package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a,\u0010\b\u001a\u00020\t*\u00020\t2\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0000¨\u0006\f"}, d2 = {"collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "target", "Ljava/util/SortedSet;", "", "transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: JvmAnnotatedString.jvm.kt */
public final class JvmAnnotatedString_jvmKt {
    public static final AnnotatedString transform(AnnotatedString annotatedString, Function3<? super String, ? super Integer, ? super Integer, String> function3) {
        List list;
        List list2;
        TreeSet sortedSetOf = SetsKt.sortedSetOf(0, Integer.valueOf(annotatedString.getText().length()));
        SortedSet sortedSet = sortedSetOf;
        collectRangeTransitions(annotatedString.getSpanStylesOrNull$ui_text_release(), sortedSet);
        collectRangeTransitions(annotatedString.getParagraphStylesOrNull$ui_text_release(), sortedSet);
        collectRangeTransitions(annotatedString.getAnnotations$ui_text_release(), sortedSet);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(0, 0));
        CollectionsKt.windowed$default(sortedSetOf, 2, 0, false, new JvmAnnotatedString_jvmKt$transform$1(objectRef, function3, annotatedString, mutableMapOf), 6, (Object) null);
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release();
        List list3 = null;
        if (spanStylesOrNull$ui_text_release != null) {
            ArrayList arrayList = new ArrayList(spanStylesOrNull$ui_text_release.size());
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range range = spanStylesOrNull$ui_text_release.get(i);
                Object item = range.getItem();
                Object obj = mutableMapOf.get(Integer.valueOf(range.getStart()));
                Intrinsics.checkNotNull(obj);
                int intValue = ((Number) obj).intValue();
                Object obj2 = mutableMapOf.get(Integer.valueOf(range.getEnd()));
                Intrinsics.checkNotNull(obj2);
                arrayList.add(new AnnotatedString.Range(item, intValue, ((Number) obj2).intValue()));
            }
            list = arrayList;
        } else {
            list = null;
        }
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release != null) {
            ArrayList arrayList2 = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
            int size2 = paragraphStylesOrNull$ui_text_release.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range range2 = paragraphStylesOrNull$ui_text_release.get(i2);
                Object item2 = range2.getItem();
                Object obj3 = mutableMapOf.get(Integer.valueOf(range2.getStart()));
                Intrinsics.checkNotNull(obj3);
                int intValue2 = ((Number) obj3).intValue();
                Object obj4 = mutableMapOf.get(Integer.valueOf(range2.getEnd()));
                Intrinsics.checkNotNull(obj4);
                arrayList2.add(new AnnotatedString.Range(item2, intValue2, ((Number) obj4).intValue()));
            }
            list2 = arrayList2;
        } else {
            list2 = null;
        }
        List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
        if (annotations$ui_text_release != null) {
            ArrayList arrayList3 = new ArrayList(annotations$ui_text_release.size());
            int size3 = annotations$ui_text_release.size();
            for (int i3 = 0; i3 < size3; i3++) {
                AnnotatedString.Range range3 = annotations$ui_text_release.get(i3);
                Object item3 = range3.getItem();
                Object obj5 = mutableMapOf.get(Integer.valueOf(range3.getStart()));
                Intrinsics.checkNotNull(obj5);
                int intValue3 = ((Number) obj5).intValue();
                Object obj6 = mutableMapOf.get(Integer.valueOf(range3.getEnd()));
                Intrinsics.checkNotNull(obj6);
                arrayList3.add(new AnnotatedString.Range(item3, intValue3, ((Number) obj6).intValue()));
            }
            list3 = arrayList3;
        }
        return new AnnotatedString((String) objectRef.element, list, list2, list3);
    }

    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> list, SortedSet<Integer> sortedSet) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range range = (AnnotatedString.Range) list.get(i);
                sortedSet.add(Integer.valueOf(range.getStart()));
                sortedSet.add(Integer.valueOf(range.getEnd()));
            }
        }
    }
}
