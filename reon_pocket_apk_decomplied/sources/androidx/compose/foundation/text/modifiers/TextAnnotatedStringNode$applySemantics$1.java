package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "textLayoutResult", "", "Landroidx/compose/ui/text/TextLayoutResult;", "invoke", "(Ljava/util/List;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextAnnotatedStringNode.kt */
final class TextAnnotatedStringNode$applySemantics$1 extends Lambda implements Function1<List<TextLayoutResult>, Boolean> {
    final /* synthetic */ TextAnnotatedStringNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextAnnotatedStringNode$applySemantics$1(TextAnnotatedStringNode textAnnotatedStringNode) {
        super(1);
        this.this$0 = textAnnotatedStringNode;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(java.util.List<androidx.compose.ui.text.TextLayoutResult> r38) {
        /*
            r37 = this;
            r0 = r37
            androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r1 = r0.this$0
            androidx.compose.foundation.text.modifiers.MultiParagraphLayoutCache r1 = r1.getLayoutCache()
            androidx.compose.ui.text.TextLayoutResult r2 = r1.getLayoutOrNull()
            if (r2 == 0) goto L_0x00b8
            androidx.compose.ui.text.TextLayoutInput r1 = new androidx.compose.ui.text.TextLayoutInput
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            androidx.compose.ui.text.AnnotatedString r4 = r3.getText()
            androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r3 = r0.this$0
            androidx.compose.ui.text.TextStyle r5 = r3.style
            androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode r3 = r0.this$0
            androidx.compose.ui.graphics.ColorProducer r3 = r3.overrideColor
            if (r3 == 0) goto L_0x002b
            long r6 = r3.m3897invoke0d7_KjU()
            goto L_0x0031
        L_0x002b:
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r6 = r3.m3852getUnspecified0d7_KjU()
        L_0x0031:
            r35 = 16777214(0xfffffe, float:2.3509884E-38)
            r36 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.ui.text.TextStyle.m6062mergedA7vx0o$default(r5, r6, r8, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r33, r34, r35, r36)
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            java.util.List r6 = r3.getPlaceholders()
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            int r7 = r3.getMaxLines()
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            boolean r8 = r3.getSoftWrap()
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            int r9 = r3.m6011getOverflowgIe3tQ8()
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            androidx.compose.ui.unit.Density r10 = r3.getDensity()
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            androidx.compose.ui.unit.LayoutDirection r11 = r3.getLayoutDirection()
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            androidx.compose.ui.text.font.FontFamily$Resolver r12 = r3.getFontFamilyResolver()
            androidx.compose.ui.text.TextLayoutInput r3 = r2.getLayoutInput()
            long r13 = r3.m6010getConstraintsmsEJaDk()
            r15 = 0
            r3 = r1
            r3.<init>((androidx.compose.ui.text.AnnotatedString) r4, (androidx.compose.ui.text.TextStyle) r5, (java.util.List) r6, (int) r7, (boolean) r8, (int) r9, (androidx.compose.ui.unit.Density) r10, (androidx.compose.ui.unit.LayoutDirection) r11, (androidx.compose.ui.text.font.FontFamily.Resolver) r12, (long) r13, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            r6 = 2
            r7 = 0
            r4 = 0
            androidx.compose.ui.text.TextLayoutResult r1 = androidx.compose.ui.text.TextLayoutResult.m6012copyO0kMr_c$default(r2, r3, r4, r6, r7)
            if (r1 == 0) goto L_0x00b8
            r2 = r38
            r2.add(r1)
            goto L_0x00b9
        L_0x00b8:
            r1 = 0
        L_0x00b9:
            if (r1 == 0) goto L_0x00bd
            r1 = 1
            goto L_0x00be
        L_0x00bd:
            r1 = 0
        L_0x00be:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1.invoke(java.util.List):java.lang.Boolean");
    }
}
