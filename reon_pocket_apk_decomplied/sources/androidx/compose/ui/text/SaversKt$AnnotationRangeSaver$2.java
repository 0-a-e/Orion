package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString$Range;", "", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeSaver$2 extends Lambda implements Function1<Object, AnnotatedString.Range<? extends Object>> {
    public static final SaversKt$AnnotationRangeSaver$2 INSTANCE = new SaversKt$AnnotationRangeSaver$2();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Savers.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.compose.ui.text.AnnotationType[] r0 = androidx.compose.ui.text.AnnotationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.text.AnnotationType r1 = androidx.compose.ui.text.AnnotationType.Paragraph     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.text.AnnotationType r1 = androidx.compose.ui.text.AnnotationType.Span     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.text.AnnotationType r1 = androidx.compose.ui.text.AnnotationType.VerbatimTts     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.text.AnnotationType r1 = androidx.compose.ui.text.AnnotationType.Url     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.compose.ui.text.AnnotationType r1 = androidx.compose.ui.text.AnnotationType.String     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2.WhenMappings.<clinit>():void");
        }
    }

    SaversKt$AnnotationRangeSaver$2() {
        super(1);
    }

    public final AnnotatedString.Range<? extends Object> invoke(Object obj) {
        AnnotationType annotationType;
        Integer num;
        Integer num2;
        String str;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Object obj3 = null;
        if (obj2 != null) {
            annotationType = (AnnotationType) obj2;
        } else {
            annotationType = null;
        }
        Intrinsics.checkNotNull(annotationType);
        Object obj4 = list.get(2);
        if (obj4 != null) {
            num = (Integer) obj4;
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Object obj5 = list.get(3);
        if (obj5 != null) {
            num2 = (Integer) obj5;
        } else {
            num2 = null;
        }
        Intrinsics.checkNotNull(num2);
        int intValue2 = num2.intValue();
        Object obj6 = list.get(4);
        if (obj6 != null) {
            str = (String) obj6;
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
        if (i == 1) {
            Object obj7 = list.get(1);
            Saver<ParagraphStyle, Object> paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
            if ((!Intrinsics.areEqual(obj7, (Object) false) || (paragraphStyleSaver instanceof NonNullValueClassSaver)) && obj7 != null) {
                obj3 = paragraphStyleSaver.restore(obj7);
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else if (i == 2) {
            Object obj8 = list.get(1);
            Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
            if ((!Intrinsics.areEqual(obj8, (Object) false) || (spanStyleSaver instanceof NonNullValueClassSaver)) && obj8 != null) {
                obj3 = spanStyleSaver.restore(obj8);
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else if (i == 3) {
            Object obj9 = list.get(1);
            Saver access$getVerbatimTtsAnnotationSaver$p = SaversKt.VerbatimTtsAnnotationSaver;
            if ((!Intrinsics.areEqual(obj9, (Object) false) || (access$getVerbatimTtsAnnotationSaver$p instanceof NonNullValueClassSaver)) && obj9 != null) {
                obj3 = (VerbatimTtsAnnotation) access$getVerbatimTtsAnnotationSaver$p.restore(obj9);
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else if (i == 4) {
            Object obj10 = list.get(1);
            Saver access$getUrlAnnotationSaver$p = SaversKt.UrlAnnotationSaver;
            if ((!Intrinsics.areEqual(obj10, (Object) false) || (access$getUrlAnnotationSaver$p instanceof NonNullValueClassSaver)) && obj10 != null) {
                obj3 = (UrlAnnotation) access$getUrlAnnotationSaver$p.restore(obj10);
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else if (i == 5) {
            Object obj11 = list.get(1);
            if (obj11 != null) {
                obj3 = (String) obj11;
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
