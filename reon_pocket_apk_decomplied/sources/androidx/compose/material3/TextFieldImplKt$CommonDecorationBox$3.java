package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "labelProgress", "", "labelTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "labelContentColor", "placeholderAlphaProgress", "prefixSuffixAlphaProgress", "invoke-eopBjH0", "(FJJFFLandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3 extends Lambda implements Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> {
    final /* synthetic */ TextStyle $bodyLarge;
    final /* synthetic */ TextStyle $bodySmall;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $container;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $transformedText;
    final /* synthetic */ TextFieldType $type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.compose.material3.TextFieldType[] r0 = androidx.compose.material3.TextFieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.TextFieldType r1 = androidx.compose.material3.TextFieldType.Filled     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.TextFieldType r1 = androidx.compose.material3.TextFieldType.Outlined     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3(Function2<? super Composer, ? super Integer, Unit> function2, TextFieldColors textFieldColors, boolean z, boolean z2, InteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function22, String str, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function28, boolean z3, PaddingValues paddingValues, boolean z4, TextStyle textStyle, TextStyle textStyle2, Function2<? super Composer, ? super Integer, Unit> function29) {
        super(7);
        this.$label = function2;
        this.$colors = textFieldColors;
        this.$enabled = z;
        this.$isError = z2;
        this.$interactionSource = interactionSource;
        this.$placeholder = function22;
        this.$transformedText = str;
        this.$prefix = function23;
        this.$suffix = function24;
        this.$leadingIcon = function25;
        this.$trailingIcon = function26;
        this.$supportingText = function27;
        this.$type = textFieldType;
        this.$innerTextField = function28;
        this.$singleLine = z3;
        this.$contentPadding = paddingValues;
        this.$shouldOverrideTextStyleColor = z4;
        this.$bodyLarge = textStyle;
        this.$bodySmall = textStyle2;
        this.$container = function29;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        m2446invokeeopBjH0(((Number) obj).floatValue(), ((Color) obj2).m3826unboximpl(), ((Color) obj3).m3826unboximpl(), ((Number) obj4).floatValue(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: invoke-eopBjH0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2446invokeeopBjH0(float r21, long r22, long r24, float r26, float r27, androidx.compose.runtime.Composer r28, int r29) {
        /*
            r20 = this;
            r0 = r20
            r10 = r21
            r9 = r26
            r11 = r27
            r15 = r28
            r1 = r29
            java.lang.String r2 = "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r1 & 6
            if (r2 != 0) goto L_0x0020
            boolean r2 = r15.changed((float) r10)
            if (r2 == 0) goto L_0x001d
            r2 = 4
            goto L_0x001e
        L_0x001d:
            r2 = 2
        L_0x001e:
            r2 = r2 | r1
            goto L_0x0021
        L_0x0020:
            r2 = r1
        L_0x0021:
            r3 = r1 & 48
            r7 = r22
            if (r3 != 0) goto L_0x0033
            boolean r3 = r15.changed((long) r7)
            if (r3 == 0) goto L_0x0030
            r3 = 32
            goto L_0x0032
        L_0x0030:
            r3 = 16
        L_0x0032:
            r2 = r2 | r3
        L_0x0033:
            r3 = r1 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0046
            r3 = r24
            boolean r5 = r15.changed((long) r3)
            if (r5 == 0) goto L_0x0042
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0044
        L_0x0042:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0044:
            r2 = r2 | r5
            goto L_0x0048
        L_0x0046:
            r3 = r24
        L_0x0048:
            r5 = r1 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x0058
            boolean r5 = r15.changed((float) r9)
            if (r5 == 0) goto L_0x0055
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0057
        L_0x0055:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0057:
            r2 = r2 | r5
        L_0x0058:
            r1 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r1 != 0) goto L_0x0068
            boolean r1 = r15.changed((float) r11)
            if (r1 == 0) goto L_0x0065
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0067
        L_0x0065:
            r1 = 8192(0x2000, float:1.14794E-41)
        L_0x0067:
            r2 = r2 | r1
        L_0x0068:
            r14 = r2
            r1 = 74899(0x12493, float:1.04956E-40)
            r1 = r1 & r14
            r2 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r2) goto L_0x007e
            boolean r1 = r28.getSkipping()
            if (r1 != 0) goto L_0x0079
            goto L_0x007e
        L_0x0079:
            r28.skipToGroupEnd()
            goto L_0x0329
        L_0x007e:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x008d
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)"
            r5 = 1290853831(0x4cf0ddc7, float:1.2628332E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r14, r1, r2)
        L_0x008d:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$label
            r6 = 0
            r2 = 1
            if (r5 == 0) goto L_0x00b1
            boolean r1 = r0.$shouldOverrideTextStyleColor
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 r12 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
            r17 = r1
            r1 = r12
            r13 = r2
            r2 = r21
            r3 = r24
            r6 = r17
            r7 = r22
            r1.<init>(r2, r3, r5, r6, r7)
            r1 = -382297919(0xffffffffe93698c1, float:-1.3796616E25)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r13, r12)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r7 = r1
            goto L_0x00b3
        L_0x00b1:
            r13 = r2
            r7 = 0
        L_0x00b3:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            r6 = 0
            r5 = r28
            androidx.compose.runtime.State r1 = r1.placeholderColor$material3_release(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3826unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$placeholder
            r8 = 0
            if (r3 == 0) goto L_0x00f1
            java.lang.String r3 = r0.$transformedText
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x00f1
            int r3 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x00f1
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 r3 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$placeholder
            r3.<init>(r9, r1, r4)
            r1 = -524658155(0xffffffffe0ba5a15, float:-1.0742455E20)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r13, r3)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r9 = r1
            goto L_0x00f2
        L_0x00f1:
            r9 = 0
        L_0x00f2:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            r6 = 0
            r5 = r28
            androidx.compose.runtime.State r1 = r1.prefixColor$material3_release(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r3 = r1.m3826unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$prefix
            if (r1 == 0) goto L_0x012a
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x012a
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1 r12 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
            androidx.compose.ui.text.TextStyle r5 = r0.$bodyLarge
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$prefix
            r1 = r12
            r2 = r27
            r1.<init>(r2, r3, r5, r6)
            r1 = 1824482619(0x6cbf653b, float:1.851063E27)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r13, r12)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r12 = r1
            goto L_0x012b
        L_0x012a:
            r12 = 0
        L_0x012b:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            r6 = 0
            r5 = r28
            androidx.compose.runtime.State r1 = r1.suffixColor$material3_release(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r3 = r1.m3826unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$suffix
            if (r1 == 0) goto L_0x0163
            int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0163
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1 r8 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
            androidx.compose.ui.text.TextStyle r5 = r0.$bodyLarge
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r6 = r0.$suffix
            r1 = r8
            r2 = r27
            r1.<init>(r2, r3, r5, r6)
            r1 = 907456412(0x3616af9c, float:2.245396E-6)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r13, r8)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8 = r1
            goto L_0x0164
        L_0x0163:
            r8 = 0
        L_0x0164:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            r5 = 0
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r28
            r27 = r5
            androidx.compose.runtime.State r1 = r22.leadingIconColor$material3_release(r23, r24, r25, r26, r27)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3826unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$leadingIcon
            if (r3 == 0) goto L_0x019b
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 r4 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
            r4.<init>(r1, r3)
            r1 = 90769583(0x56908af, float:1.0957202E-35)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r13, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r1
            goto L_0x019c
        L_0x019b:
            r5 = 0
        L_0x019c:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            r6 = 0
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r28
            r27 = r6
            androidx.compose.runtime.State r1 = r22.trailingIconColor$material3_release(r23, r24, r25, r26, r27)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3826unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$trailingIcon
            if (r3 == 0) goto L_0x01d3
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1 r4 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
            r4.<init>(r1, r3)
            r1 = 2077796155(0x7bd8a73b, float:2.2498559E36)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r13, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6 = r1
            goto L_0x01d4
        L_0x01d3:
            r6 = 0
        L_0x01d4:
            androidx.compose.material3.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            r11 = 0
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r28
            r27 = r11
            androidx.compose.runtime.State r1 = r22.supportingTextColor$material3_release(r23, r24, r25, r26, r27)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3826unboximpl()
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$supportingText
            if (r3 == 0) goto L_0x020e
            androidx.compose.ui.text.TextStyle r4 = r0.$bodySmall
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1 r11 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
            r11.<init>(r1, r4, r3)
            r1 = -1531019900(0xffffffffa4be7d84, float:-8.2612E-17)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r13, r11)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r19 = r1
            goto L_0x0210
        L_0x020e:
            r19 = 0
        L_0x0210:
            androidx.compose.material3.TextFieldType r1 = r0.$type
            int[] r2 = androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r13) goto L_0x02d7
            r3 = 2
            if (r1 == r3) goto L_0x022a
            r1 = 404045277(0x18153ddd, float:1.9289032E-24)
            r15.startReplaceableGroup(r1)
            r28.endReplaceableGroup()
            goto L_0x0320
        L_0x022a:
            r1 = 404043576(0x18153738, float:1.9285677E-24)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "222@9289L38,245@10297L420,234@9756L1141"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = 404043645(0x1815377d, float:1.9285813E-24)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):TextFieldImpl.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            java.lang.Object r3 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x025f
            androidx.compose.ui.geometry.Size$Companion r3 = androidx.compose.ui.geometry.Size.Companion
            long r3 = r3.m3640getZeroNHjbRc()
            androidx.compose.ui.geometry.Size r3 = androidx.compose.ui.geometry.Size.m3619boximpl(r3)
            r4 = 2
            r11 = 0
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r11, r4, r11)
            r15.updateRememberedValue(r3)
        L_0x025f:
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r28.endReplaceableGroup()
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1 r4 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
            androidx.compose.foundation.layout.PaddingValues r11 = r0.$contentPadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$container
            r4.<init>(r3, r11, r2)
            r2 = 1902535592(0x716663a8, float:1.1408325E30)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r2, r13, r4)
            r18 = r2
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$innerTextField
            boolean r11 = r0.$singleLine
            r13 = 404044653(0x18153b6d, float:1.9287801E-24)
            r15.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r14 & 14
            r13 = 4
            if (r1 != r13) goto L_0x0290
            r1 = 1
            goto L_0x0291
        L_0x0290:
            r1 = 0
        L_0x0291:
            java.lang.Object r13 = r28.rememberedValue()
            if (r1 != 0) goto L_0x029f
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r13 != r1) goto L_0x02aa
        L_0x029f:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
            r1.<init>(r10, r3)
            r13 = r1
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r15.updateRememberedValue(r13)
        L_0x02aa:
            r1 = r13
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r13 = r11
            r11 = r1
            r28.endReplaceableGroup()
            androidx.compose.foundation.layout.PaddingValues r1 = r0.$contentPadding
            r3 = r14
            r14 = r1
            int r1 = r3 << 27
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r3
            r16 = r1 | 6
            r17 = 48
            r1 = r2
            r2 = r4
            r3 = r9
            r4 = r7
            r7 = r12
            r9 = r13
            r10 = r21
            r12 = r18
            r13 = r19
            r0 = r15
            r15 = r28
            androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r28.endReplaceableGroup()
            r0 = r20
            goto L_0x0320
        L_0x02d7:
            r3 = r14
            r0 = r15
            r1 = 404042583(0x18153357, float:1.9283719E-24)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "204@8500L667"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1 r1 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
            r0 = r20
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$container
            r1.<init>(r2)
            r2 = -2124779163(0xffffffff815a7165, float:-4.0121633E-38)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r2, r4, r1)
            r11 = r1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$innerTextField
            boolean r13 = r0.$singleLine
            androidx.compose.foundation.layout.PaddingValues r14 = r0.$contentPadding
            int r3 = r3 << 27
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r16 = r3 | 6
            r17 = 6
            r3 = r7
            r4 = r9
            r7 = r12
            r9 = r13
            r10 = r21
            r12 = r19
            r13 = r14
            r14 = r28
            r15 = r16
            r16 = r17
            androidx.compose.material3.TextFieldKt.TextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r28.endReplaceableGroup()
        L_0x0320:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0329
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0329:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3.m2446invokeeopBjH0(float, long, long, float, float, androidx.compose.runtime.Composer, int):void");
    }
}
