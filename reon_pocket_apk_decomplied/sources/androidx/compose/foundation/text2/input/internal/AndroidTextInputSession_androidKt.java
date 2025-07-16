package androidx.compose.foundation.text2.input.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002\u001a \u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a8\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017H@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u000b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005¨\u0006\u001e"}, d2 = {"TAG", "", "TIA_DEBUG", "", "getTIA_DEBUG$annotations", "()V", "hasFlag", "bits", "", "flag", "logDebug", "", "tag", "content", "Lkotlin/Function0;", "platformSpecificTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "state", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeAction", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/input/ImeOptions;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "Landroid/view/inputmethod/EditorInfo;", "textFieldValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextInputSession.android.kt */
public final class AndroidTextInputSession_androidKt {
    private static final String TAG = "AndroidTextInputSession";
    public static final boolean TIA_DEBUG = false;

    public static /* synthetic */ void getTIA_DEBUG$annotations() {
    }

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    private static final void logDebug(String str, Function0<String> function0) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object platformSpecificTextInputSession(androidx.compose.ui.platform.PlatformTextInputSession r11, androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r12, androidx.compose.ui.text.input.ImeOptions r13, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.ImeAction, kotlin.Unit> r14, kotlin.coroutines.Continuation<?> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 r0 = (androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 r0 = new androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1
            r0.<init>(r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 == r3) goto L_0x002e
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0053
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r15)
            android.view.View r15 = r11.getView()
            androidx.compose.foundation.text2.input.internal.ComposeInputMethodManager r7 = androidx.compose.foundation.text2.input.internal.ComposeInputMethodManager_androidKt.ComposeInputMethodManager(r15)
            androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 r15 = new androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2
            r10 = 0
            r4 = r15
            r5 = r11
            r6 = r12
            r8 = r13
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r15, r0)
            if (r11 != r1) goto L_0x0053
            return r1
        L_0x0053:
            kotlin.KotlinNothingValueException r11 = new kotlin.KotlinNothingValueException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt.platformSpecificTextInputSession(androidx.compose.ui.platform.PlatformTextInputSession, androidx.compose.foundation.text2.input.internal.TransformedTextFieldState, androidx.compose.ui.text.input.ImeOptions, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void update(android.view.inputmethod.EditorInfo r6, androidx.compose.foundation.text2.input.TextFieldCharSequence r7, androidx.compose.ui.text.input.ImeOptions r8) {
        /*
            int r0 = r8.m6250getImeActioneUduSuo()
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6237getDefaulteUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            r2 = 3
            r3 = 2
            r4 = 6
            r5 = 1
            if (r1 == 0) goto L_0x001e
            boolean r0 = r8.getSingleLine()
            if (r0 == 0) goto L_0x001c
            goto L_0x007e
        L_0x001c:
            r4 = 0
            goto L_0x007e
        L_0x001e:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6241getNoneeUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x002c
            r4 = r5
            goto L_0x007e
        L_0x002c:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6239getGoeUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x003a
            r4 = r3
            goto L_0x007e
        L_0x003a:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6240getNexteUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0048
            r4 = 5
            goto L_0x007e
        L_0x0048:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6242getPreviouseUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0056
            r4 = 7
            goto L_0x007e
        L_0x0056:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6243getSearcheUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0064
            r4 = r2
            goto L_0x007e
        L_0x0064:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6244getSendeUduSuo()
            boolean r1 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0072
            r4 = 4
            goto L_0x007e
        L_0x0072:
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6238getDoneeUduSuo()
            boolean r0 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x01b9
        L_0x007e:
            r6.imeOptions = r4
            int r0 = r8.m6251getKeyboardTypePjHm6EE()
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6292getTextPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0093
        L_0x0090:
            r2 = r5
            goto L_0x010c
        L_0x0093:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6285getAsciiPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00a7
            int r0 = r6.imeOptions
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            r6.imeOptions = r0
            goto L_0x0090
        L_0x00a7:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6288getNumberPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00b5
            r2 = r3
            goto L_0x010c
        L_0x00b5:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6291getPhonePjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00c2
            goto L_0x010c
        L_0x00c2:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6293getUriPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00d1
            r2 = 17
            goto L_0x010c
        L_0x00d1:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6287getEmailPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00e0
            r2 = 33
            goto L_0x010c
        L_0x00e0:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6290getPasswordPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00ef
            r2 = 129(0x81, float:1.81E-43)
            goto L_0x010c
        L_0x00ef:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6289getNumberPasswordPjHm6EE()
            boolean r1 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x00fe
            r2 = 18
            goto L_0x010c
        L_0x00fe:
            androidx.compose.ui.text.input.KeyboardType$Companion r1 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r1 = r1.m6286getDecimalPjHm6EE()
            boolean r0 = androidx.compose.ui.text.input.KeyboardType.m6272equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x01ad
            r2 = 8194(0x2002, float:1.1482E-41)
        L_0x010c:
            r6.inputType = r2
            boolean r0 = r8.getSingleLine()
            if (r0 != 0) goto L_0x013a
            int r0 = r6.inputType
            boolean r0 = hasFlag(r0, r5)
            if (r0 == 0) goto L_0x013a
            int r0 = r6.inputType
            r1 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 | r1
            r6.inputType = r0
            int r0 = r8.m6250getImeActioneUduSuo()
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6237getDefaulteUduSuo()
            boolean r0 = androidx.compose.ui.text.input.ImeAction.m6225equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x013a
            int r0 = r6.imeOptions
            r1 = 1073741824(0x40000000, float:2.0)
            r0 = r0 | r1
            r6.imeOptions = r0
        L_0x013a:
            int r0 = r6.inputType
            boolean r0 = hasFlag(r0, r5)
            if (r0 == 0) goto L_0x018c
            int r0 = r8.m6249getCapitalizationIUNYP9k()
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6265getCharactersIUNYP9k()
            boolean r1 = androidx.compose.ui.text.input.KeyboardCapitalization.m6257equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x0159
            int r0 = r6.inputType
            r0 = r0 | 4096(0x1000, float:5.74E-42)
            r6.inputType = r0
            goto L_0x017e
        L_0x0159:
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6268getWordsIUNYP9k()
            boolean r1 = androidx.compose.ui.text.input.KeyboardCapitalization.m6257equalsimpl0(r0, r1)
            if (r1 == 0) goto L_0x016c
            int r0 = r6.inputType
            r0 = r0 | 8192(0x2000, float:1.14794E-41)
            r6.inputType = r0
            goto L_0x017e
        L_0x016c:
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6267getSentencesIUNYP9k()
            boolean r0 = androidx.compose.ui.text.input.KeyboardCapitalization.m6257equalsimpl0(r0, r1)
            if (r0 == 0) goto L_0x017e
            int r0 = r6.inputType
            r0 = r0 | 16384(0x4000, float:2.2959E-41)
            r6.inputType = r0
        L_0x017e:
            boolean r8 = r8.getAutoCorrect()
            if (r8 == 0) goto L_0x018c
            int r8 = r6.inputType
            r0 = 32768(0x8000, float:4.5918E-41)
            r8 = r8 | r0
            r6.inputType = r8
        L_0x018c:
            long r0 = r7.m1346getSelectionInCharsd9O1mEE()
            int r8 = androidx.compose.ui.text.TextRange.m6042getStartimpl(r0)
            r6.initialSelStart = r8
            long r0 = r7.m1346getSelectionInCharsd9O1mEE()
            int r8 = androidx.compose.ui.text.TextRange.m6037getEndimpl(r0)
            r6.initialSelEnd = r8
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            androidx.core.view.inputmethod.EditorInfoCompat.setInitialSurroundingText(r6, r7)
            int r7 = r6.imeOptions
            r8 = 33554432(0x2000000, float:9.403955E-38)
            r7 = r7 | r8
            r6.imeOptions = r7
            return
        L_0x01ad:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Invalid Keyboard Type"
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x01b9:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "invalid ImeAction"
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt.update(android.view.inputmethod.EditorInfo, androidx.compose.foundation.text2.input.TextFieldCharSequence, androidx.compose.ui.text.input.ImeOptions):void");
    }

    static /* synthetic */ void logDebug$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TAG;
        }
        logDebug(str, function0);
    }
}
