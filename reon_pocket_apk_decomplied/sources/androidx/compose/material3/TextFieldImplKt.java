package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b42\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001¢\u0006\u0002\u0010I\u001a9\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u0012\u0010R\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u0012\u0010U\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u001c\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010A\u001a\u00020?2\u0006\u0010W\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007\"\u0016\u0010\u0011\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0016\u0010\u0013\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0019\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007\"\u000e\u0010\u001b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007\"\u000e\u0010\u001f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001a\u00020\u0005X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007\"\u000e\u0010\"\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0016\u0010#\u001a\u00020$X\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006X"}, d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String ContainerId = "Container";
    private static final float HorizontalIconPadding = Dp.m6614constructorimpl((float) 12);
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    private static final float MinTextLineHeight = Dp.m6614constructorimpl((float) 24);
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    private static final float PrefixSuffixTextPadding = Dp.m6614constructorimpl((float) 2);
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding = Dp.m6614constructorimpl((float) 4);
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0476  */
    /* JADX WARNING: Removed duplicated region for block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CommonDecorationBox(androidx.compose.material3.TextFieldType r41, java.lang.String r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.ui.text.input.VisualTransformation r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, boolean r52, boolean r53, boolean r54, androidx.compose.foundation.interaction.InteractionSource r55, androidx.compose.foundation.layout.PaddingValues r56, androidx.compose.material3.TextFieldColors r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            r4 = r44
            r3 = r45
            r2 = r55
            r1 = r57
            r0 = r60
            r15 = r61
            r14 = r62
            r5 = -947035500(0xffffffffc78d6294, float:-72389.16)
            r6 = r59
            androidx.compose.runtime.Composer r13 = r6.startRestartGroup(r5)
            java.lang.String r5 = "C(CommonDecorationBox)P(15,16,4,17,7,9,8,14,10,12,13,11,3,6,5,2)80@3145L105,84@3300L25,95@3684L10,102@4027L6900:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            r5 = r14 & 1
            if (r5 == 0) goto L_0x0025
            r5 = r0 | 6
            r12 = r41
            goto L_0x0037
        L_0x0025:
            r5 = r0 & 6
            r12 = r41
            if (r5 != 0) goto L_0x0036
            boolean r5 = r13.changed((java.lang.Object) r12)
            if (r5 == 0) goto L_0x0033
            r5 = 4
            goto L_0x0034
        L_0x0033:
            r5 = 2
        L_0x0034:
            r5 = r5 | r0
            goto L_0x0037
        L_0x0036:
            r5 = r0
        L_0x0037:
            r8 = r14 & 2
            if (r8 == 0) goto L_0x0040
            r5 = r5 | 48
            r11 = r42
            goto L_0x0052
        L_0x0040:
            r8 = r0 & 48
            r11 = r42
            if (r8 != 0) goto L_0x0052
            boolean r8 = r13.changed((java.lang.Object) r11)
            if (r8 == 0) goto L_0x004f
            r8 = 32
            goto L_0x0051
        L_0x004f:
            r8 = 16
        L_0x0051:
            r5 = r5 | r8
        L_0x0052:
            r8 = r14 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x005d
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0071
        L_0x005d:
            r8 = r0 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0071
            r8 = r43
            boolean r18 = r13.changedInstance(r8)
            if (r18 == 0) goto L_0x006c
            r18 = r16
            goto L_0x006e
        L_0x006c:
            r18 = r17
        L_0x006e:
            r5 = r5 | r18
            goto L_0x0073
        L_0x0071:
            r8 = r43
        L_0x0073:
            r18 = r14 & 8
            r19 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x007c
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x007c:
            r7 = r0 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x008c
            boolean r7 = r13.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0089
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r7 = r19
        L_0x008b:
            r5 = r5 | r7
        L_0x008c:
            r7 = r14 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x0097
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0097:
            r7 = r0 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x00a7
            boolean r7 = r13.changedInstance(r3)
            if (r7 == 0) goto L_0x00a4
            r7 = r20
            goto L_0x00a6
        L_0x00a4:
            r7 = r21
        L_0x00a6:
            r5 = r5 | r7
        L_0x00a7:
            r7 = r14 & 32
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r7 == 0) goto L_0x00b4
            r5 = r5 | r23
            r9 = r46
            goto L_0x00c7
        L_0x00b4:
            r24 = r0 & r23
            r9 = r46
            if (r24 != 0) goto L_0x00c7
            boolean r25 = r13.changedInstance(r9)
            if (r25 == 0) goto L_0x00c3
            r25 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r25 = r22
        L_0x00c5:
            r5 = r5 | r25
        L_0x00c7:
            r25 = r14 & 64
            r26 = 1572864(0x180000, float:2.204052E-39)
            if (r25 == 0) goto L_0x00d2
            r5 = r5 | r26
            r6 = r47
            goto L_0x00e5
        L_0x00d2:
            r27 = r0 & r26
            r6 = r47
            if (r27 != 0) goto L_0x00e5
            boolean r28 = r13.changedInstance(r6)
            if (r28 == 0) goto L_0x00e1
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r5 = r5 | r28
        L_0x00e5:
            r10 = r14 & 128(0x80, float:1.794E-43)
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            if (r10 == 0) goto L_0x00f0
            r5 = r5 | r29
            r6 = r48
            goto L_0x0103
        L_0x00f0:
            r30 = r0 & r29
            r6 = r48
            if (r30 != 0) goto L_0x0103
            boolean r30 = r13.changedInstance(r6)
            if (r30 == 0) goto L_0x00ff
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x0101:
            r5 = r5 | r30
        L_0x0103:
            r6 = r14 & 256(0x100, float:3.59E-43)
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            if (r6 == 0) goto L_0x010e
            r5 = r5 | r30
            r8 = r49
            goto L_0x0121
        L_0x010e:
            r30 = r0 & r30
            r8 = r49
            if (r30 != 0) goto L_0x0121
            boolean r30 = r13.changedInstance(r8)
            if (r30 == 0) goto L_0x011d
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r5 = r5 | r30
        L_0x0121:
            r8 = r14 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r8 == 0) goto L_0x012c
            r5 = r5 | r30
            r0 = r50
            goto L_0x013f
        L_0x012c:
            r30 = r0 & r30
            r0 = r50
            if (r30 != 0) goto L_0x013f
            boolean r30 = r13.changedInstance(r0)
            if (r30 == 0) goto L_0x013b
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013d
        L_0x013b:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013d:
            r5 = r5 | r30
        L_0x013f:
            r0 = r14 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0148
            r18 = r15 | 6
            r9 = r51
            goto L_0x015e
        L_0x0148:
            r30 = r15 & 6
            r9 = r51
            if (r30 != 0) goto L_0x015c
            boolean r30 = r13.changedInstance(r9)
            if (r30 == 0) goto L_0x0157
            r18 = 4
            goto L_0x0159
        L_0x0157:
            r18 = 2
        L_0x0159:
            r18 = r15 | r18
            goto L_0x015e
        L_0x015c:
            r18 = r15
        L_0x015e:
            r9 = r14 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x0165
            r18 = r18 | 48
            goto L_0x0178
        L_0x0165:
            r30 = r15 & 48
            r11 = r52
            if (r30 != 0) goto L_0x0178
            boolean r30 = r13.changed((boolean) r11)
            if (r30 == 0) goto L_0x0174
            r24 = 32
            goto L_0x0176
        L_0x0174:
            r24 = 16
        L_0x0176:
            r18 = r18 | r24
        L_0x0178:
            r11 = r18
            r12 = r14 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x0181
            r11 = r11 | 384(0x180, float:5.38E-43)
            goto L_0x0193
        L_0x0181:
            r3 = r15 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0193
            r3 = r53
            boolean r18 = r13.changed((boolean) r3)
            if (r18 == 0) goto L_0x018e
            goto L_0x0190
        L_0x018e:
            r16 = r17
        L_0x0190:
            r11 = r11 | r16
            goto L_0x0195
        L_0x0193:
            r3 = r53
        L_0x0195:
            r3 = r14 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x019c
            r11 = r11 | 3072(0xc00, float:4.305E-42)
            goto L_0x01ad
        L_0x019c:
            r4 = r15 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x01ad
            r4 = r54
            boolean r16 = r13.changed((boolean) r4)
            if (r16 == 0) goto L_0x01aa
            r19 = 2048(0x800, float:2.87E-42)
        L_0x01aa:
            r11 = r11 | r19
            goto L_0x01af
        L_0x01ad:
            r4 = r54
        L_0x01af:
            r4 = r14 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x01b6
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01c5
        L_0x01b6:
            r4 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x01c5
            boolean r4 = r13.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x01c1
            goto L_0x01c3
        L_0x01c1:
            r20 = r21
        L_0x01c3:
            r11 = r11 | r20
        L_0x01c5:
            r4 = 32768(0x8000, float:4.5918E-41)
            r4 = r4 & r14
            if (r4 == 0) goto L_0x01ce
            r11 = r11 | r23
            goto L_0x01e2
        L_0x01ce:
            r4 = r15 & r23
            if (r4 != 0) goto L_0x01e2
            r4 = r56
            boolean r16 = r13.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x01dd
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01df
        L_0x01dd:
            r16 = r22
        L_0x01df:
            r11 = r11 | r16
            goto L_0x01e4
        L_0x01e2:
            r4 = r56
        L_0x01e4:
            r16 = r14 & r22
            if (r16 == 0) goto L_0x01eb
            r11 = r11 | r26
            goto L_0x01fc
        L_0x01eb:
            r16 = r15 & r26
            if (r16 != 0) goto L_0x01fc
            boolean r16 = r13.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x01f8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x01fa
        L_0x01f8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x01fa:
            r11 = r11 | r16
        L_0x01fc:
            r16 = 131072(0x20000, float:1.83671E-40)
            r16 = r14 & r16
            if (r16 == 0) goto L_0x0207
            r11 = r11 | r29
            r4 = r58
            goto L_0x021a
        L_0x0207:
            r16 = r15 & r29
            r4 = r58
            if (r16 != 0) goto L_0x021a
            boolean r16 = r13.changedInstance(r4)
            if (r16 == 0) goto L_0x0216
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0218
        L_0x0216:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0218:
            r11 = r11 | r16
        L_0x021a:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r4 = r5 & r16
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r14) goto L_0x024c
            r4 = 4793491(0x492493, float:6.717112E-39)
            r4 = r4 & r11
            r14 = 4793490(0x492492, float:6.71711E-39)
            if (r4 != r14) goto L_0x024c
            boolean r4 = r13.getSkipping()
            if (r4 != 0) goto L_0x0234
            goto L_0x024c
        L_0x0234:
            r13.skipToGroupEnd()
            r6 = r46
            r7 = r47
            r8 = r48
            r9 = r49
            r10 = r50
            r11 = r51
            r12 = r52
            r14 = r54
            r1 = r13
            r13 = r53
            goto L_0x0470
        L_0x024c:
            r4 = 0
            if (r7 == 0) goto L_0x0252
            r26 = r4
            goto L_0x0254
        L_0x0252:
            r26 = r46
        L_0x0254:
            if (r25 == 0) goto L_0x0259
            r29 = r4
            goto L_0x025b
        L_0x0259:
            r29 = r47
        L_0x025b:
            if (r10 == 0) goto L_0x0260
            r30 = r4
            goto L_0x0262
        L_0x0260:
            r30 = r48
        L_0x0262:
            if (r6 == 0) goto L_0x0267
            r31 = r4
            goto L_0x0269
        L_0x0267:
            r31 = r49
        L_0x0269:
            if (r8 == 0) goto L_0x026e
            r32 = r4
            goto L_0x0270
        L_0x026e:
            r32 = r50
        L_0x0270:
            if (r0 == 0) goto L_0x0273
            goto L_0x0275
        L_0x0273:
            r4 = r51
        L_0x0275:
            r0 = 0
            if (r9 == 0) goto L_0x027b
            r33 = r0
            goto L_0x027d
        L_0x027b:
            r33 = r52
        L_0x027d:
            if (r12 == 0) goto L_0x0281
            r12 = 1
            goto L_0x0283
        L_0x0281:
            r12 = r53
        L_0x0283:
            if (r3 == 0) goto L_0x0287
            r3 = r0
            goto L_0x0289
        L_0x0287:
            r3 = r54
        L_0x0289:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0297
            r6 = -947035500(0xffffffffc78d6294, float:-72389.16)
            java.lang.String r7 = "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:79)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r5, r11, r7)
        L_0x0297:
            r6 = -646389284(0xffffffffd978e1dc, float:-4.37838308E15)
            r13.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):TextFieldImpl.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            r6 = r5 & 112(0x70, float:1.57E-43)
            r7 = 32
            if (r6 != r7) goto L_0x02aa
            r6 = 1
            goto L_0x02ab
        L_0x02aa:
            r6 = r0
        L_0x02ab:
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r7 = 2048(0x800, float:2.87E-42)
            if (r5 != r7) goto L_0x02b3
            r5 = 1
            goto L_0x02b4
        L_0x02b3:
            r5 = r0
        L_0x02b4:
            r5 = r5 | r6
            java.lang.Object r6 = r13.rememberedValue()
            if (r5 != 0) goto L_0x02c7
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x02c4
            goto L_0x02c7
        L_0x02c4:
            r10 = r44
            goto L_0x02e5
        L_0x02c7:
            androidx.compose.ui.text.AnnotatedString r5 = new androidx.compose.ui.text.AnnotatedString
            r6 = 6
            r7 = 0
            r8 = 0
            r9 = 0
            r46 = r5
            r47 = r42
            r48 = r8
            r49 = r9
            r50 = r6
            r51 = r7
            r46.<init>(r47, r48, r49, r50, r51)
            r10 = r44
            androidx.compose.ui.text.input.TransformedText r6 = r10.filter(r5)
            r13.updateRememberedValue(r6)
        L_0x02e5:
            androidx.compose.ui.text.input.TransformedText r6 = (androidx.compose.ui.text.input.TransformedText) r6
            r13.endReplaceableGroup()
            androidx.compose.ui.text.AnnotatedString r5 = r6.getText()
            java.lang.String r16 = r5.getText()
            int r5 = r11 >> 12
            r5 = r5 & 14
            androidx.compose.runtime.State r5 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r2, r13, r5)
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x030a
            androidx.compose.material3.InputPhase r5 = androidx.compose.material3.InputPhase.Focused
        L_0x0308:
            r11 = r5
            goto L_0x031a
        L_0x030a:
            r5 = r16
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0317
            androidx.compose.material3.InputPhase r5 = androidx.compose.material3.InputPhase.UnfocusedEmpty
            goto L_0x0308
        L_0x0317:
            androidx.compose.material3.InputPhase r5 = androidx.compose.material3.InputPhase.UnfocusedNotEmpty
            goto L_0x0308
        L_0x031a:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1 r5 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
            r5.<init>(r1, r12, r3, r2)
            r9 = r5
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            androidx.compose.material3.MaterialTheme r5 = androidx.compose.material3.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material3.Typography r5 = r5.getTypography(r13, r6)
            androidx.compose.ui.text.TextStyle r23 = r5.getBodyLarge()
            androidx.compose.ui.text.TextStyle r24 = r5.getBodySmall()
            long r7 = r23.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r5.m3852getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r7, r14)
            if (r5 == 0) goto L_0x0351
            long r7 = r24.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r5.m3852getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r7, r14)
            if (r5 == 0) goto L_0x0371
        L_0x0351:
            long r7 = r23.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r5.m3852getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r7, r14)
            if (r5 != 0) goto L_0x0374
            long r7 = r24.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r5.m3852getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m3817equalsimpl0(r7, r14)
            if (r5 == 0) goto L_0x0374
        L_0x0371:
            r22 = 1
            goto L_0x0376
        L_0x0374:
            r22 = r0
        L_0x0376:
            androidx.compose.material3.TextFieldTransitionScope r27 = androidx.compose.material3.TextFieldTransitionScope.INSTANCE
            r5 = -646388325(0xffffffffd978e59b, float:-4.37864051E15)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "*104@4123L10"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.material3.MaterialTheme r5 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r5 = r5.getTypography(r13, r6)
            androidx.compose.ui.text.TextStyle r5 = r5.getBodySmall()
            long r7 = r5.m6072getColor0d7_KjU()
            r5 = -646388264(0xffffffffd978e5d8, float:-4.37865688E15)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "*105@4217L22"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            if (r22 == 0) goto L_0x03b7
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r5.m3852getUnspecified0d7_KjU()
            int r5 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x03a9
            goto L_0x03b7
        L_0x03a9:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r5 = r9.invoke(r11, r13, r5)
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r7 = r5.m3826unboximpl()
        L_0x03b7:
            r34 = r7
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r5 = -646388132(0xffffffffd978e65c, float:-4.37869231E15)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "*107@4316L10"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.material3.MaterialTheme r5 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r5 = r5.getTypography(r13, r6)
            androidx.compose.ui.text.TextStyle r5 = r5.getBodyLarge()
            long r5 = r5.m6072getColor0d7_KjU()
            r7 = -646388071(0xffffffffd978e699, float:-4.37870869E15)
            r13.startReplaceableGroup(r7)
            java.lang.String r7 = "*108@4410L22"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            if (r22 == 0) goto L_0x03fe
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r7.m3852getUnspecified0d7_KjU()
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x03f0
            goto L_0x03fe
        L_0x03f0:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r5 = r9.invoke(r11, r13, r5)
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r5 = r5.m3826unboximpl()
        L_0x03fe:
            r36 = r5
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            if (r45 == 0) goto L_0x0409
            r0 = 1
        L_0x0409:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3 r15 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3
            r5 = r15
            r6 = r45
            r7 = r57
            r8 = r12
            r28 = r9
            r9 = r3
            r10 = r55
            r38 = r11
            r11 = r26
            r39 = r12
            r12 = r16
            r14 = r13
            r13 = r31
            r1 = r14
            r2 = 1
            r14 = r32
            r46 = r3
            r3 = r15
            r15 = r29
            r16 = r30
            r17 = r4
            r18 = r41
            r19 = r43
            r20 = r33
            r21 = r56
            r25 = r58
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r5 = 1290853831(0x4cf0ddc7, float:1.2628332E8)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r5, r2, r3)
            r14 = r2
            kotlin.jvm.functions.Function7 r14 = (kotlin.jvm.functions.Function7) r14
            r16 = 1769472(0x1b0000, float:2.479558E-39)
            r6 = r27
            r7 = r38
            r8 = r34
            r10 = r36
            r12 = r28
            r13 = r0
            r15 = r1
            r6.m2454TransitionDTcfvLk(r7, r8, r10, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x045f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x045f:
            r14 = r46
            r11 = r4
            r6 = r26
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r12 = r33
            r13 = r39
        L_0x0470:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 == 0) goto L_0x04a0
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4 r22 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4
            r0 = r22
            r1 = r41
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r45
            r40 = r15
            r15 = r55
            r16 = r56
            r17 = r57
            r18 = r58
            r19 = r60
            r20 = r61
            r21 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r40
            r1.updateScope(r0)
        L_0x04a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: Decoration-KTwxG1Y  reason: not valid java name */
    public static final void m2445DecorationKTwxG1Y(long j, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1520066345);
        ComposerKt.sourceInformation(startRestartGroup, "C(Decoration)P(1:c#ui.graphics.Color,2):TextFieldImpl.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) textStyle) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                textStyle = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, i3, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:271)");
            }
            Function2 composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1449369305, true, new TextFieldImplKt$Decoration$contentWithColor$1(j, function2));
            if (textStyle != null) {
                startRestartGroup.startReplaceableGroup(1830467586);
                ComposerKt.sourceInformation(startRestartGroup, "279@11381L63");
                ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, startRestartGroup, i3 & 1022);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(1830467667);
                ComposerKt.sourceInformation(startRestartGroup, "281@11462L18");
                composableLambda.invoke(startRestartGroup, 6);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        TextStyle textStyle2 = textStyle;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j, textStyle2, function2, i, i2));
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new TextFieldImplKt$defaultErrorSemantics$1(str), 1, (Object) null) : modifier;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = (float) 16;
        TextFieldPadding = Dp.m6614constructorimpl(f);
        MinFocusedLabelLineHeight = Dp.m6614constructorimpl(f);
        MinSupportingTextLineHeight = Dp.m6614constructorimpl(f);
        float f2 = (float) 48;
        IconDefaultSizeModifier = SizeKt.m726defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m6614constructorimpl(f2), Dp.m6614constructorimpl(f2));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
