package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0002\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(H\u0007¢\u0006\u0002\u00106J\r\u0010\u001e\u001a\u00020\u0013H\u0007¢\u0006\u0002\u00107JÂ\u0003\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u0002092\b\b\u0002\u0010>\u001a\u0002092\b\b\u0002\u0010?\u001a\u0002092\b\b\u0002\u0010@\u001a\u0002092\b\b\u0002\u0010A\u001a\u0002092\b\b\u0002\u0010B\u001a\u0002092\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010E\u001a\u0002092\b\b\u0002\u0010F\u001a\u0002092\b\b\u0002\u0010G\u001a\u0002092\b\b\u0002\u0010H\u001a\u0002092\b\b\u0002\u0010I\u001a\u0002092\b\b\u0002\u0010J\u001a\u0002092\b\b\u0002\u0010K\u001a\u0002092\b\b\u0002\u0010L\u001a\u0002092\b\b\u0002\u0010M\u001a\u0002092\b\b\u0002\u0010N\u001a\u0002092\b\b\u0002\u0010O\u001a\u0002092\b\b\u0002\u0010P\u001a\u0002092\b\b\u0002\u0010Q\u001a\u0002092\b\b\u0002\u0010R\u001a\u0002092\b\b\u0002\u0010S\u001a\u0002092\b\b\u0002\u0010T\u001a\u0002092\b\b\u0002\u0010U\u001a\u0002092\b\b\u0002\u0010V\u001a\u0002092\b\b\u0002\u0010W\u001a\u0002092\b\b\u0002\u0010X\u001a\u0002092\b\b\u0002\u0010Y\u001a\u0002092\b\b\u0002\u0010Z\u001a\u0002092\b\b\u0002\u0010[\u001a\u0002092\b\b\u0002\u0010\\\u001a\u0002092\b\b\u0002\u0010]\u001a\u0002092\b\b\u0002\u0010^\u001a\u0002092\b\b\u0002\u0010_\u001a\u0002092\b\b\u0002\u0010`\u001a\u0002092\b\b\u0002\u0010a\u001a\u0002092\b\b\u0002\u0010b\u001a\u0002092\b\b\u0002\u0010c\u001a\u0002092\b\b\u0002\u0010d\u001a\u000209H\u0007ø\u0001\u0000¢\u0006\u0004\be\u0010fJ8\u00103\u001a\u0002042\b\b\u0002\u0010g\u001a\u00020\u00042\b\b\u0002\u0010h\u001a\u00020\u00042\b\b\u0002\u0010i\u001a\u00020\u00042\b\b\u0002\u0010j\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bk\u0010lR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00148AX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "focusedBorderThickness", "unfocusedBorderThickness", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness = Dp.m6614constructorimpl((float) 2);
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m6614constructorimpl((float) 56);
    private static final float MinWidth = Dp.m6614constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness = Dp.m6614constructorimpl((float) 1);

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1066756961);
        ComposerKt.sourceInformation(composer, "C1409@77141L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:1409)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m2043getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m2044getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2045getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2042getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x012c, code lost:
        if ((r10 & 64) != 0) goto L_0x014d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01b8  */
    /* renamed from: ContainerBox-nbWgWpA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2039ContainerBoxnbWgWpA(boolean r20, boolean r21, androidx.compose.foundation.interaction.InteractionSource r22, androidx.compose.material3.TextFieldColors r23, androidx.compose.ui.graphics.Shape r24, float r25, float r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r19 = this;
            r9 = r28
            r10 = r29
            r0 = 1461761386(0x5720b56a, float:1.76701028E14)
            r1 = r27
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)1456@79023L5,1460@79190L203,1472@79535L51,1468@79402L216:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r10 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r9 | 6
            r12 = r20
            goto L_0x002d
        L_0x001b:
            r1 = r9 & 6
            r12 = r20
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changed((boolean) r12)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r9
            goto L_0x002d
        L_0x002c:
            r1 = r9
        L_0x002d:
            r2 = r10 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r21
            goto L_0x0048
        L_0x0036:
            r2 = r9 & 48
            r13 = r21
            if (r2 != 0) goto L_0x0048
            boolean r2 = r11.changed((boolean) r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r10 & 4
            if (r2 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            r14 = r22
            goto L_0x0063
        L_0x0051:
            r2 = r9 & 384(0x180, float:5.38E-43)
            r14 = r22
            if (r2 != 0) goto L_0x0063
            boolean r2 = r11.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0060
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r2
        L_0x0063:
            r2 = r10 & 8
            if (r2 == 0) goto L_0x006c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r15 = r23
            goto L_0x007e
        L_0x006c:
            r2 = r9 & 3072(0xc00, float:4.305E-42)
            r15 = r23
            if (r2 != 0) goto L_0x007e
            boolean r2 = r11.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x007b
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r2
        L_0x007e:
            r2 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x0097
            r2 = r10 & 16
            if (r2 != 0) goto L_0x0091
            r2 = r24
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0093
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0091:
            r2 = r24
        L_0x0093:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r1 = r1 | r3
            goto L_0x0099
        L_0x0097:
            r2 = r24
        L_0x0099:
            r3 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 & r9
            if (r3 != 0) goto L_0x00b3
            r3 = r10 & 32
            if (r3 != 0) goto L_0x00ad
            r3 = r25
            boolean r4 = r11.changed((float) r3)
            if (r4 == 0) goto L_0x00af
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00ad:
            r3 = r25
        L_0x00af:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r1 = r1 | r4
            goto L_0x00b5
        L_0x00b3:
            r3 = r25
        L_0x00b5:
            r4 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 & r9
            if (r4 != 0) goto L_0x00cf
            r4 = r10 & 64
            if (r4 != 0) goto L_0x00c9
            r4 = r26
            boolean r5 = r11.changed((float) r4)
            if (r5 == 0) goto L_0x00cb
            r5 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00c9:
            r4 = r26
        L_0x00cb:
            r5 = 524288(0x80000, float:7.34684E-40)
        L_0x00cd:
            r1 = r1 | r5
            goto L_0x00d1
        L_0x00cf:
            r4 = r26
        L_0x00d1:
            r5 = r10 & 128(0x80, float:1.794E-43)
            r6 = 12582912(0xc00000, float:1.7632415E-38)
            if (r5 == 0) goto L_0x00db
            r1 = r1 | r6
            r8 = r19
            goto L_0x00ed
        L_0x00db:
            r5 = r9 & r6
            r8 = r19
            if (r5 != 0) goto L_0x00ed
            boolean r5 = r11.changed((java.lang.Object) r8)
            if (r5 == 0) goto L_0x00ea
            r5 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ec
        L_0x00ea:
            r5 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ec:
            r1 = r1 | r5
        L_0x00ed:
            r5 = 4793491(0x492493, float:6.717112E-39)
            r5 = r5 & r1
            r6 = 4793490(0x492492, float:6.71711E-39)
            if (r5 != r6) goto L_0x0105
            boolean r5 = r11.getSkipping()
            if (r5 != 0) goto L_0x00fd
            goto L_0x0105
        L_0x00fd:
            r11.skipToGroupEnd()
            r6 = r2
            r7 = r3
            r8 = r4
            goto L_0x01c0
        L_0x0105:
            r11.startDefaults()
            r5 = r9 & 1
            r6 = -3670017(0xffffffffffc7ffff, float:NaN)
            r7 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r5 == 0) goto L_0x012f
            boolean r5 = r11.getDefaultsInvalid()
            if (r5 == 0) goto L_0x011c
            goto L_0x012f
        L_0x011c:
            r11.skipToGroupEnd()
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0125
            r1 = r1 & r16
        L_0x0125:
            r5 = r10 & 32
            if (r5 == 0) goto L_0x012a
            r1 = r1 & r7
        L_0x012a:
            r5 = r10 & 64
            if (r5 == 0) goto L_0x014e
            goto L_0x014d
        L_0x012f:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0140
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r2 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r2 = r2.getContainerShape()
            r5 = 6
            androidx.compose.ui.graphics.Shape r2 = androidx.compose.material3.ShapesKt.getValue(r2, r11, r5)
            r1 = r1 & r16
        L_0x0140:
            r5 = r10 & 32
            if (r5 == 0) goto L_0x0147
            float r3 = FocusedBorderThickness
            r1 = r1 & r7
        L_0x0147:
            r5 = r10 & 64
            if (r5 == 0) goto L_0x014e
            float r4 = UnfocusedBorderThickness
        L_0x014d:
            r1 = r1 & r6
        L_0x014e:
            r7 = r2
            r16 = r3
            r17 = r4
            r11.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0162
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1459)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x0162:
            r0 = r1 & 8190(0x1ffe, float:1.1477E-41)
            int r1 = r1 >> 3
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r2 = r2 | r0
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r18 = r2 | r1
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r16
            r6 = r17
            r9 = r7
            r7 = r11
            r8 = r18
            androidx.compose.runtime.State r1 = androidx.compose.material3.TextFieldDefaultsKt.m2444animateBorderStrokeAsStateNuRrP5Q(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            java.lang.Object r1 = r1.getValue()
            androidx.compose.foundation.BorderStroke r1 = (androidx.compose.foundation.BorderStroke) r1
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.BorderKt.border(r2, r1, r9)
            r1 = r23
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r11
            r6 = r0
            androidx.compose.runtime.State r0 = r1.containerColor$material3_release(r2, r3, r4, r5, r6)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m3826unboximpl()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m213backgroundbw27NRU(r7, r0, r9)
            r1 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r11, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01bb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01bb:
            r6 = r9
            r7 = r16
            r8 = r17
        L_0x01c0:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 == 0) goto L_0x01e2
            androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1 r16 = new androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1
            r0 = r16
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r9 = r28
            r10 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.m2039ContainerBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: contentPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2038contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m2041contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2041contentPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m666PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-471651810);
        ComposerKt.sourceInformation(composer, "C(colors)1492@80238L11,1492@80250L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1492)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedTextFieldColors;
    }

    /* renamed from: colors-0hiis_0  reason: not valid java name */
    public final TextFieldColors m2040colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Composer composer2 = composer;
        int i8 = i6;
        int i9 = i7;
        composer2.startReplaceableGroup(1767617725);
        ComposerKt.sourceInformation(composer2, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)1593@87042L11,1593@87054L30:TextFieldDefaults.kt#uh7d8r");
        long r7 = (i8 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r9 = (i8 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r11 = (i8 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r13 = (i8 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r15 = (i8 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r17 = (i8 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r19 = (i8 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r21 = (i8 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        long r23 = (i8 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j9;
        long r25 = (i8 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i8 & 1024) != 0 ? null : textSelectionColors;
        long r28 = (i8 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j11;
        long r30 = (i8 & 4096) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j12;
        long r32 = (i8 & 8192) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j13;
        long r34 = (i8 & 16384) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j14;
        long r36 = (32768 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j15;
        long r38 = (65536 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j16;
        long r40 = (131072 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j17;
        long r42 = (262144 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j18;
        long r44 = (524288 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j19;
        long r46 = (1048576 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j20;
        long r48 = (2097152 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j21;
        long r50 = (4194304 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j22;
        long r52 = (8388608 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j23;
        long r54 = (16777216 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j24;
        long r56 = (33554432 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j25;
        long r58 = (67108864 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j26;
        long r60 = (134217728 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j27;
        long r62 = (268435456 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j28;
        long r64 = (536870912 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j29;
        long r66 = (i8 & 1073741824) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j30;
        long r68 = (i9 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j31;
        long r70 = (i9 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j32;
        long r72 = (i9 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j33;
        long r74 = (i9 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j34;
        long r76 = (i9 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j35;
        long r78 = (i9 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j36;
        long r80 = (i9 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j37;
        long r82 = (i9 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j38;
        long r84 = (i9 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j39;
        long r86 = (i9 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j40;
        long r88 = (i9 & 1024) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j41;
        long r90 = (i9 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1593)");
        }
        TextFieldColors r1 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), composer2, (i5 >> 6) & 112).m2372copyejIjP34(r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, textSelectionColors2, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        ColorScheme colorScheme2 = colorScheme;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-292363577);
        ComposerKt.sourceInformation(composer2, "C*1654@90670L7,1688@93420L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1641)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached$material3_release = colorScheme.getDefaultOutlinedTextFieldColorsCached$material3_release();
        if (defaultOutlinedTextFieldColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long r8 = Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long r12 = Color.Companion.m3851getTransparent0d7_KjU();
            long r14 = Color.Companion.m3851getTransparent0d7_KjU();
            long r16 = Color.Companion.m3851getTransparent0d7_KjU();
            long r18 = Color.Companion.m3851getTransparent0d7_KjU();
            TextFieldColors textFieldColors = r3;
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldColors textFieldColors2 = new TextFieldColors(fromToken, fromToken2, r8, fromToken3, r12, r14, r16, r18, fromToken4, fromToken5, (TextSelectionColors) consume, ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), (DefaultConstructorMarker) null);
            defaultOutlinedTextFieldColorsCached$material3_release = textFieldColors;
            colorScheme2.setDefaultOutlinedTextFieldColorsCached$material3_release(defaultOutlinedTextFieldColorsCached$material3_release);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedTextFieldColorsCached$material3_release;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DecorationBox(java.lang.String r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, boolean r44, boolean r45, androidx.compose.ui.text.input.VisualTransformation r46, androidx.compose.foundation.interaction.InteractionSource r47, boolean r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.material3.TextFieldColors r56, androidx.compose.foundation.layout.PaddingValues r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            r41 = this;
            r15 = r41
            r4 = r44
            r7 = r47
            r14 = r60
            r13 = r61
            r12 = r62
            r0 = -350442135(0xffffffffeb1cad69, float:-1.8941133E26)
            r1 = r59
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1778@99554L8,1789@99842L709:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0023
            r1 = r14 | 6
            r5 = r42
            goto L_0x0035
        L_0x0023:
            r1 = r14 & 6
            r5 = r42
            if (r1 != 0) goto L_0x0034
            boolean r1 = r0.changed((java.lang.Object) r5)
            if (r1 == 0) goto L_0x0031
            r1 = 4
            goto L_0x0032
        L_0x0031:
            r1 = 2
        L_0x0032:
            r1 = r1 | r14
            goto L_0x0035
        L_0x0034:
            r1 = r14
        L_0x0035:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x003c
            r1 = r1 | 48
            goto L_0x004f
        L_0x003c:
            r6 = r14 & 48
            if (r6 != 0) goto L_0x004f
            r6 = r43
            boolean r10 = r0.changedInstance(r6)
            if (r10 == 0) goto L_0x004b
            r10 = 32
            goto L_0x004d
        L_0x004b:
            r10 = 16
        L_0x004d:
            r1 = r1 | r10
            goto L_0x0051
        L_0x004f:
            r6 = r43
        L_0x0051:
            r10 = r12 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x005a
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x005a:
            r10 = r14 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x006a
            boolean r10 = r0.changed((boolean) r4)
            if (r10 == 0) goto L_0x0067
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r10 = r16
        L_0x0069:
            r1 = r1 | r10
        L_0x006a:
            r10 = r12 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x0075
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0075:
            r10 = r14 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x0089
            r10 = r45
            boolean r19 = r0.changed((boolean) r10)
            if (r19 == 0) goto L_0x0084
            r19 = r17
            goto L_0x0086
        L_0x0084:
            r19 = r18
        L_0x0086:
            r1 = r1 | r19
            goto L_0x008b
        L_0x0089:
            r10 = r45
        L_0x008b:
            r19 = r12 & 16
            r20 = 8192(0x2000, float:1.14794E-41)
            r21 = 16384(0x4000, float:2.2959E-41)
            if (r19 == 0) goto L_0x0096
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00aa
        L_0x0096:
            r2 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x00aa
            r2 = r46
            boolean r19 = r0.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x00a5
            r19 = r21
            goto L_0x00a7
        L_0x00a5:
            r19 = r20
        L_0x00a7:
            r1 = r1 | r19
            goto L_0x00ac
        L_0x00aa:
            r2 = r46
        L_0x00ac:
            r19 = r12 & 32
            r22 = 131072(0x20000, float:1.83671E-40)
            r23 = 65536(0x10000, float:9.18355E-41)
            r24 = 196608(0x30000, float:2.75506E-40)
            if (r19 == 0) goto L_0x00b9
            r1 = r1 | r24
            goto L_0x00ca
        L_0x00b9:
            r19 = r14 & r24
            if (r19 != 0) goto L_0x00ca
            boolean r19 = r0.changed((java.lang.Object) r7)
            if (r19 == 0) goto L_0x00c6
            r19 = r22
            goto L_0x00c8
        L_0x00c6:
            r19 = r23
        L_0x00c8:
            r1 = r1 | r19
        L_0x00ca:
            r19 = r12 & 64
            r25 = 1572864(0x180000, float:2.204052E-39)
            if (r19 == 0) goto L_0x00d5
            r1 = r1 | r25
            r3 = r48
            goto L_0x00e8
        L_0x00d5:
            r26 = r14 & r25
            r3 = r48
            if (r26 != 0) goto L_0x00e8
            boolean r27 = r0.changed((boolean) r3)
            if (r27 == 0) goto L_0x00e4
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e6
        L_0x00e4:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e6:
            r1 = r1 | r27
        L_0x00e8:
            r8 = r12 & 128(0x80, float:1.794E-43)
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            if (r8 == 0) goto L_0x00f3
            r1 = r1 | r28
            r9 = r49
            goto L_0x0106
        L_0x00f3:
            r29 = r14 & r28
            r9 = r49
            if (r29 != 0) goto L_0x0106
            boolean r30 = r0.changedInstance(r9)
            if (r30 == 0) goto L_0x0102
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0104
        L_0x0102:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0104:
            r1 = r1 | r30
        L_0x0106:
            r11 = r12 & 256(0x100, float:3.59E-43)
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            if (r11 == 0) goto L_0x0111
            r1 = r1 | r31
            r2 = r50
            goto L_0x0124
        L_0x0111:
            r31 = r14 & r31
            r2 = r50
            if (r31 != 0) goto L_0x0124
            boolean r31 = r0.changedInstance(r2)
            if (r31 == 0) goto L_0x0120
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0122
        L_0x0120:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0122:
            r1 = r1 | r31
        L_0x0124:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r31 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x012f
            r1 = r1 | r31
            r3 = r51
            goto L_0x0142
        L_0x012f:
            r31 = r14 & r31
            r3 = r51
            if (r31 != 0) goto L_0x0142
            boolean r31 = r0.changedInstance(r3)
            if (r31 == 0) goto L_0x013e
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0140
        L_0x013e:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0140:
            r1 = r1 | r31
        L_0x0142:
            r3 = r12 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014b
            r26 = r13 | 6
            r5 = r52
            goto L_0x0161
        L_0x014b:
            r31 = r13 & 6
            r5 = r52
            if (r31 != 0) goto L_0x015f
            boolean r31 = r0.changedInstance(r5)
            if (r31 == 0) goto L_0x015a
            r26 = 4
            goto L_0x015c
        L_0x015a:
            r26 = 2
        L_0x015c:
            r26 = r13 | r26
            goto L_0x0161
        L_0x015f:
            r26 = r13
        L_0x0161:
            r5 = r12 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0168
            r26 = r26 | 48
            goto L_0x017b
        L_0x0168:
            r31 = r13 & 48
            r6 = r53
            if (r31 != 0) goto L_0x017b
            boolean r31 = r0.changedInstance(r6)
            if (r31 == 0) goto L_0x0177
            r27 = 32
            goto L_0x0179
        L_0x0177:
            r27 = 16
        L_0x0179:
            r26 = r26 | r27
        L_0x017b:
            r6 = r26
            r9 = r12 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0184
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0198
        L_0x0184:
            r10 = r13 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0198
            r10 = r54
            boolean r26 = r0.changedInstance(r10)
            if (r26 == 0) goto L_0x0193
            r30 = 256(0x100, float:3.59E-43)
            goto L_0x0195
        L_0x0193:
            r30 = r16
        L_0x0195:
            r6 = r6 | r30
            goto L_0x019a
        L_0x0198:
            r10 = r54
        L_0x019a:
            r10 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01a1
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b3
        L_0x01a1:
            r4 = r13 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x01b3
            r4 = r55
            boolean r16 = r0.changedInstance(r4)
            if (r16 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ae:
            r17 = r18
        L_0x01b0:
            r6 = r6 | r17
            goto L_0x01b5
        L_0x01b3:
            r4 = r55
        L_0x01b5:
            r4 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x01cd
            r4 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r4 != 0) goto L_0x01c8
            r4 = r56
            boolean r16 = r0.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x01ca
            r20 = r21
            goto L_0x01ca
        L_0x01c8:
            r4 = r56
        L_0x01ca:
            r6 = r6 | r20
            goto L_0x01cf
        L_0x01cd:
            r4 = r56
        L_0x01cf:
            r16 = r13 & r24
            if (r16 != 0) goto L_0x01ea
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r12 & r16
            r4 = r57
            if (r16 != 0) goto L_0x01e5
            boolean r16 = r0.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x01e5
            r16 = r22
            goto L_0x01e7
        L_0x01e5:
            r16 = r23
        L_0x01e7:
            r6 = r6 | r16
            goto L_0x01ec
        L_0x01ea:
            r4 = r57
        L_0x01ec:
            r16 = r12 & r23
            if (r16 == 0) goto L_0x01f5
            r6 = r6 | r25
            r4 = r58
            goto L_0x0208
        L_0x01f5:
            r17 = r13 & r25
            r4 = r58
            if (r17 != 0) goto L_0x0208
            boolean r17 = r0.changedInstance(r4)
            if (r17 == 0) goto L_0x0204
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0206
        L_0x0204:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x0206:
            r6 = r6 | r17
        L_0x0208:
            r17 = r12 & r22
            if (r17 == 0) goto L_0x020f
            r6 = r6 | r28
            goto L_0x0220
        L_0x020f:
            r17 = r13 & r28
            if (r17 != 0) goto L_0x0220
            boolean r17 = r0.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x021c
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x021e
        L_0x021c:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x021e:
            r6 = r6 | r17
        L_0x0220:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r4 = r1 & r17
            r13 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r13) goto L_0x0255
            r4 = 4793491(0x492493, float:6.717112E-39)
            r4 = r4 & r6
            r13 = 4793490(0x492492, float:6.71711E-39)
            if (r4 != r13) goto L_0x0255
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x023a
            goto L_0x0255
        L_0x023a:
            r0.skipToGroupEnd()
            r8 = r48
            r9 = r49
            r10 = r50
            r11 = r51
            r12 = r52
            r13 = r53
            r14 = r54
            r16 = r55
            r17 = r56
            r38 = r57
            r18 = r58
            goto L_0x03e8
        L_0x0255:
            r0.startDefaults()
            r4 = r14 & 1
            if (r4 == 0) goto L_0x0291
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0263
            goto L_0x0291
        L_0x0263:
            r0.skipToGroupEnd()
            r2 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x026e
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r2
        L_0x026e:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x0278
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r6 = r6 & r2
        L_0x0278:
            r2 = r48
            r8 = r49
            r11 = r50
            r3 = r51
            r4 = r52
            r9 = r54
            r13 = r55
            r10 = r56
            r38 = r57
            r39 = r58
            r5 = r6
            r6 = r53
            goto L_0x0339
        L_0x0291:
            if (r19 == 0) goto L_0x0295
            r4 = 0
            goto L_0x0297
        L_0x0295:
            r4 = r48
        L_0x0297:
            r13 = 0
            if (r8 == 0) goto L_0x029c
            r8 = r13
            goto L_0x029e
        L_0x029c:
            r8 = r49
        L_0x029e:
            if (r11 == 0) goto L_0x02a2
            r11 = r13
            goto L_0x02a4
        L_0x02a2:
            r11 = r50
        L_0x02a4:
            if (r2 == 0) goto L_0x02a8
            r2 = r13
            goto L_0x02aa
        L_0x02a8:
            r2 = r51
        L_0x02aa:
            if (r3 == 0) goto L_0x02ae
            r3 = r13
            goto L_0x02b0
        L_0x02ae:
            r3 = r52
        L_0x02b0:
            if (r5 == 0) goto L_0x02b4
            r5 = r13
            goto L_0x02b6
        L_0x02b4:
            r5 = r53
        L_0x02b6:
            if (r9 == 0) goto L_0x02ba
            r9 = r13
            goto L_0x02bc
        L_0x02ba:
            r9 = r54
        L_0x02bc:
            if (r10 == 0) goto L_0x02bf
            goto L_0x02c1
        L_0x02bf:
            r13 = r55
        L_0x02c1:
            r10 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x02d3
            int r10 = r6 >> 21
            r10 = r10 & 14
            androidx.compose.material3.TextFieldColors r10 = r15.colors(r0, r10)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r6 & r17
            goto L_0x02d5
        L_0x02d3:
            r10 = r56
        L_0x02d5:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r12 & r17
            if (r17 == 0) goto L_0x0300
            r17 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r48 = r41
            r49 = r19
            r50 = r20
            r51 = r21
            r52 = r22
            r53 = r17
            r54 = r18
            androidx.compose.foundation.layout.PaddingValues r17 = m2038contentPaddinga9UjIt4$default(r48, r49, r50, r51, r52, r53, r54)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r6 = r6 & r18
            goto L_0x0302
        L_0x0300:
            r17 = r57
        L_0x0302:
            r48 = r2
            if (r16 == 0) goto L_0x0324
            androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1 r2 = new androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1
            r49 = r5
            r5 = r44
            r2.<init>(r5, r4, r7, r10)
            r50 = r3
            r3 = -1448570018(0xffffffffa9a8935e, float:-7.486263E-14)
            r16 = r4
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r4, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = r48
            r4 = r50
            r39 = r2
            goto L_0x0332
        L_0x0324:
            r50 = r3
            r16 = r4
            r49 = r5
            r5 = r44
            r3 = r48
            r4 = r50
            r39 = r58
        L_0x0332:
            r5 = r6
            r2 = r16
            r38 = r17
            r6 = r49
        L_0x0339:
            r0.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x034a
            r7 = -350442135(0xffffffffeb1cad69, float:-1.8941133E26)
            java.lang.String r12 = "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1788)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r1, r5, r12)
        L_0x034a:
            androidx.compose.material3.TextFieldType r16 = androidx.compose.material3.TextFieldType.Outlined
            int r7 = r1 << 3
            r12 = r7 & 112(0x70, float:1.57E-43)
            r12 = r12 | 6
            r7 = r7 & 896(0x380, float:1.256E-42)
            r7 = r7 | r12
            int r12 = r1 >> 3
            r14 = r12 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r14
            int r14 = r1 >> 9
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r14 & r17
            r7 = r7 | r17
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r14 & r17
            r7 = r7 | r17
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r14 & r17
            r7 = r7 | r17
            int r17 = r5 << 21
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r17 & r18
            r7 = r7 | r18
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r17 & r18
            r7 = r7 | r18
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r17 & r18
            r35 = r7 | r17
            int r7 = r5 >> 9
            r7 = r7 & 14
            int r17 = r1 >> 6
            r17 = r17 & 112(0x70, float:1.57E-43)
            r7 = r7 | r17
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r7
            r7 = r14 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r7
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r12
            r1 = r1 | r7
            r7 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r5
            r1 = r1 | r7
            int r7 = r5 << 6
            r12 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r12
            r1 = r1 | r7
            int r5 = r5 << 3
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r7
            r36 = r1 | r5
            r37 = 0
            r17 = r42
            r18 = r43
            r19 = r46
            r20 = r8
            r21 = r11
            r22 = r3
            r23 = r4
            r24 = r6
            r25 = r9
            r26 = r13
            r27 = r45
            r28 = r44
            r29 = r2
            r30 = r47
            r31 = r38
            r32 = r10
            r33 = r39
            r34 = r0
            androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03db
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03db:
            r12 = r4
            r14 = r9
            r17 = r10
            r10 = r11
            r16 = r13
            r18 = r39
            r11 = r3
            r13 = r6
            r9 = r8
            r8 = r2
        L_0x03e8:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 == 0) goto L_0x041a
            androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2 r22 = new androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2
            r0 = r22
            r1 = r41
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r46
            r40 = r7
            r7 = r47
            r15 = r16
            r16 = r17
            r17 = r38
            r19 = r60
            r20 = r61
            r21 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r40
            r1.updateScope(r0)
        L_0x041a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
