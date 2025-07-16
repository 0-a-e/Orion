package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/AnnotatedString$Range;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeSaver$1 extends Lambda implements Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object> {
    public static final SaversKt$AnnotationRangeSaver$1 INSTANCE = new SaversKt$AnnotationRangeSaver$1();

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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1.WhenMappings.<clinit>():void");
        }
    }

    SaversKt$AnnotationRangeSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope saverScope, AnnotatedString.Range<? extends Object> range) {
        AnnotationType annotationType;
        Object obj;
        Object item = range.getItem();
        if (item instanceof ParagraphStyle) {
            annotationType = AnnotationType.Paragraph;
        } else if (item instanceof SpanStyle) {
            annotationType = AnnotationType.Span;
        } else if (item instanceof VerbatimTtsAnnotation) {
            annotationType = AnnotationType.VerbatimTts;
        } else if (item instanceof UrlAnnotation) {
            annotationType = AnnotationType.Url;
        } else {
            annotationType = AnnotationType.String;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
        if (i == 1) {
            Object item2 = range.getItem();
            Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
            obj = SaversKt.save((ParagraphStyle) item2, SaversKt.getParagraphStyleSaver(), saverScope);
        } else if (i == 2) {
            Object item3 = range.getItem();
            Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
            obj = SaversKt.save((SpanStyle) item3, SaversKt.getSpanStyleSaver(), saverScope);
        } else if (i == 3) {
            Object item4 = range.getItem();
            Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
            obj = SaversKt.save((VerbatimTtsAnnotation) item4, SaversKt.VerbatimTtsAnnotationSaver, saverScope);
        } else if (i == 4) {
            Object item5 = range.getItem();
            Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
            obj = SaversKt.save((UrlAnnotation) item5, SaversKt.UrlAnnotationSaver, saverScope);
        } else if (i == 5) {
            obj = SaversKt.save(range.getItem());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.arrayListOf(SaversKt.save(annotationType), obj, SaversKt.save(Integer.valueOf(range.getStart())), SaversKt.save(Integer.valueOf(range.getEnd())), SaversKt.save(range.getTag()));
    }
}
