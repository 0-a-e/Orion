package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1(MutableState<TextFieldValue> mutableState, TimePickerState timePickerState, TimePickerColors timePickerColors, MutableState<TextFieldValue> mutableState2) {
        super(2);
        this.$hourValue$delegate = mutableState;
        this.$state = timePickerState;
        this.$colors = timePickerColors;
        this.$minuteValue$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r12 = r24
            r1 = r25
            java.lang.String r2 = "C839@37313L411,851@37793L353,866@38455L38,837@37224L1318,869@38555L85,872@38749L376,885@39197L331,900@39839L38,870@38653L1273:TimePicker.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001c
            boolean r2 = r24.getSkipping()
            if (r2 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r24.skipToGroupEnd()
            goto L_0x022b
        L_0x001c:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002b
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:837)"
            r4 = 1306700887(0x4de2ac57, float:4.7536816E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x002b:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = -1645133303(0xffffffff9df14209, float:-6.3860448E-21)
            r12.startReplaceableGroup(r2)
            java.lang.String r13 = "CC(remember):TimePicker.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$hourValue$delegate
            boolean r2 = r12.changed((java.lang.Object) r2)
            androidx.compose.material3.TimePickerState r3 = r0.$state
            boolean r3 = r12.changed((java.lang.Object) r3)
            r2 = r2 | r3
            androidx.compose.material3.TimePickerState r3 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r4 = r0.$hourValue$delegate
            java.lang.Object r5 = r24.rememberedValue()
            if (r2 != 0) goto L_0x0059
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r5 != r2) goto L_0x0064
        L_0x0059:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1 r2 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1
            r2.<init>(r3, r4)
            r5 = r2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r12.updateRememberedValue(r5)
        L_0x0064:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r24.endReplaceableGroup()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.key.KeyInputModifierKt.onKeyEvent(r1, r5)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$hourValue$delegate
            androidx.compose.ui.text.input.TextFieldValue r2 = androidx.compose.material3.TimePickerKt.TimeInputImpl$lambda$5(r2)
            r3 = -1645132823(0xffffffff9df143e9, float:-6.3862386E-21)
            r12.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            androidx.compose.material3.TimePickerState r3 = r0.$state
            boolean r3 = r12.changed((java.lang.Object) r3)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r4 = r0.$hourValue$delegate
            boolean r4 = r12.changed((java.lang.Object) r4)
            r3 = r3 | r4
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r5 = r0.$hourValue$delegate
            java.lang.Object r6 = r24.rememberedValue()
            if (r3 != 0) goto L_0x009b
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x00a6
        L_0x009b:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1 r3 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$2$1
            r3.<init>(r4, r5)
            r6 = r3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r12.updateRememberedValue(r6)
        L_0x00a6:
            r3 = r6
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r24.endReplaceableGroup()
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.material3.Selection$Companion r5 = androidx.compose.material3.Selection.Companion
            int r5 = r5.m2168getHourJiIwxys()
            androidx.compose.ui.text.input.ImeAction$Companion r6 = androidx.compose.ui.text.input.ImeAction.Companion
            int r18 = r6.m6240getNexteUduSuo()
            androidx.compose.ui.text.input.KeyboardType$Companion r6 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r17 = r6.m6288getNumberPjHm6EE()
            androidx.compose.foundation.text.KeyboardOptions r6 = new androidx.compose.foundation.text.KeyboardOptions
            r20 = 19
            r21 = 0
            r15 = 0
            r16 = 0
            r19 = 0
            r14 = r6
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            r7 = -1645132161(0xffffffff9df1467f, float:-6.386506E-21)
            r12.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            androidx.compose.material3.TimePickerState r7 = r0.$state
            boolean r7 = r12.changed((java.lang.Object) r7)
            androidx.compose.material3.TimePickerState r8 = r0.$state
            java.lang.Object r9 = r24.rememberedValue()
            if (r7 != 0) goto L_0x00ee
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x00f9
        L_0x00ee:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$3$1 r7 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$3$1
            r7.<init>(r8)
            r9 = r7
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r12.updateRememberedValue(r9)
        L_0x00f9:
            r17 = r9
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r24.endReplaceableGroup()
            androidx.compose.foundation.text.KeyboardActions r7 = new androidx.compose.foundation.text.KeyboardActions
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 59
            r22 = 0
            r14 = r7
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            androidx.compose.material3.TimePickerColors r8 = r0.$colors
            r10 = 24576(0x6000, float:3.4438E-41)
            r11 = 0
            r9 = r24
            androidx.compose.material3.TimePickerKt.m2484TimePickerTextFieldlxUZ_iY(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r2 = androidx.compose.material3.TimePickerKt.DisplaySeparatorWidth
            androidx.compose.material3.tokens.TimeInputTokens r3 = androidx.compose.material3.tokens.TimeInputTokens.INSTANCE
            float r3 = r3.m3173getPeriodSelectorContainerHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m744sizeVpY3zN4(r1, r2, r3)
            r2 = 6
            androidx.compose.material3.TimePickerKt.DisplaySeparator(r1, r12, r2)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = -1645131867(0xffffffff9df147a5, float:-6.3866248E-21)
            r12.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$minuteValue$delegate
            boolean r2 = r12.changed((java.lang.Object) r2)
            androidx.compose.material3.TimePickerState r3 = r0.$state
            boolean r3 = r12.changed((java.lang.Object) r3)
            r2 = r2 | r3
            androidx.compose.material3.TimePickerState r3 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r4 = r0.$minuteValue$delegate
            java.lang.Object r5 = r24.rememberedValue()
            if (r2 != 0) goto L_0x015f
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r5 != r2) goto L_0x016a
        L_0x015f:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$4$1 r2 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$4$1
            r2.<init>(r3, r4)
            r5 = r2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r12.updateRememberedValue(r5)
        L_0x016a:
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r24.endReplaceableGroup()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.key.KeyInputModifierKt.onPreviewKeyEvent(r1, r5)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r2 = r0.$minuteValue$delegate
            androidx.compose.ui.text.input.TextFieldValue r2 = androidx.compose.material3.TimePickerKt.TimeInputImpl$lambda$8(r2)
            r3 = -1645131419(0xffffffff9df14965, float:-6.3868057E-21)
            r12.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            androidx.compose.material3.TimePickerState r3 = r0.$state
            boolean r3 = r12.changed((java.lang.Object) r3)
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r4 = r0.$minuteValue$delegate
            boolean r4 = r12.changed((java.lang.Object) r4)
            r3 = r3 | r4
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.input.TextFieldValue> r5 = r0.$minuteValue$delegate
            java.lang.Object r6 = r24.rememberedValue()
            if (r3 != 0) goto L_0x01a1
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x01ac
        L_0x01a1:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1 r3 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$5$1
            r3.<init>(r4, r5)
            r6 = r3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r12.updateRememberedValue(r6)
        L_0x01ac:
            r3 = r6
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r24.endReplaceableGroup()
            androidx.compose.material3.TimePickerState r4 = r0.$state
            androidx.compose.material3.Selection$Companion r5 = androidx.compose.material3.Selection.Companion
            int r5 = r5.m2169getMinuteJiIwxys()
            androidx.compose.ui.text.input.ImeAction$Companion r6 = androidx.compose.ui.text.input.ImeAction.Companion
            int r18 = r6.m6238getDoneeUduSuo()
            androidx.compose.ui.text.input.KeyboardType$Companion r6 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r17 = r6.m6288getNumberPjHm6EE()
            androidx.compose.foundation.text.KeyboardOptions r6 = new androidx.compose.foundation.text.KeyboardOptions
            r20 = 19
            r21 = 0
            r15 = 0
            r16 = 0
            r19 = 0
            r14 = r6
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            r7 = -1645130777(0xffffffff9df14be7, float:-6.387065E-21)
            r12.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            androidx.compose.material3.TimePickerState r7 = r0.$state
            boolean r7 = r12.changed((java.lang.Object) r7)
            androidx.compose.material3.TimePickerState r8 = r0.$state
            java.lang.Object r9 = r24.rememberedValue()
            if (r7 != 0) goto L_0x01f4
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x01ff
        L_0x01f4:
            androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$6$1 r7 = new androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$6$1
            r7.<init>(r8)
            r9 = r7
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r12.updateRememberedValue(r9)
        L_0x01ff:
            r16 = r9
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16
            r24.endReplaceableGroup()
            androidx.compose.foundation.text.KeyboardActions r7 = new androidx.compose.foundation.text.KeyboardActions
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 59
            r21 = 0
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.material3.TimePickerColors r8 = r0.$colors
            r10 = 24576(0x6000, float:3.4438E-41)
            r11 = 0
            r9 = r24
            androidx.compose.material3.TimePickerKt.m2484TimePickerTextFieldlxUZ_iY(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x022b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
