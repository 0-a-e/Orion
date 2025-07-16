package androidx.compose.foundation.text2.input;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0007\u001a6\u0010\r\u001a\u00020\u000e*\u00020\u00012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010H@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0006H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019*\u00020\u0001H\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"TextFieldState", "Landroidx/compose/foundation/text2/input/TextFieldState;", "initialValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "rememberTextFieldState", "initialText", "", "initialSelectionInChars", "Landroidx/compose/ui/text/TextRange;", "rememberTextFieldState-Le-punE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text2/input/TextFieldState;", "clearText", "", "forEachTextValue", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/compose/foundation/text2/input/TextFieldState;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTextAndPlaceCursorAtEnd", "text", "setTextAndSelectAll", "textAsFlow", "Lkotlinx/coroutines/flow/Flow;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldState.kt */
public final class TextFieldStateKt {
    public static final TextFieldState TextFieldState(TextFieldValue textFieldValue) {
        return new TextFieldState(textFieldValue.getText(), textFieldValue.m6299getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
    }

    public static final Flow<TextFieldCharSequence> textAsFlow(TextFieldState textFieldState) {
        return SnapshotStateKt.snapshotFlow(new TextFieldStateKt$textAsFlow$1(textFieldState));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberTextFieldState-Le-punE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text2.input.TextFieldState m1353rememberTextFieldStateLepunE(java.lang.String r7, long r8, androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = -855595317(0xffffffffcd00a6cb, float:-1.34900912E8)
            r10.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberTextFieldState)P(1,0:c#ui.text.TextRange)471@18563L107:TextFieldState.kt#b7kqo7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0011
            java.lang.String r7 = ""
        L_0x0011:
            r12 = r12 & 2
            if (r12 == 0) goto L_0x001d
            int r8 = r7.length()
            long r8 = androidx.compose.ui.text.TextRangeKt.TextRange(r8)
        L_0x001d:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0029
            r12 = -1
            java.lang.String r1 = "androidx.compose.foundation.text2.input.rememberTextFieldState (TextFieldState.kt:471)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r12, r1)
        L_0x0029:
            r11 = 0
            java.lang.Object[] r0 = new java.lang.Object[r11]
            androidx.compose.foundation.text2.input.TextFieldState$Saver r11 = androidx.compose.foundation.text2.input.TextFieldState.Saver.INSTANCE
            r1 = r11
            androidx.compose.runtime.saveable.Saver r1 = (androidx.compose.runtime.saveable.Saver) r1
            r11 = 650674345(0x26c880a9, float:1.3912661E-15)
            r10.startReplaceableGroup(r11)
            boolean r11 = r10.changed((java.lang.Object) r7)
            boolean r12 = r10.changed((long) r8)
            r11 = r11 | r12
            java.lang.Object r12 = r10.rememberedValue()
            if (r11 != 0) goto L_0x004e
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0059
        L_0x004e:
            androidx.compose.foundation.text2.input.TextFieldStateKt$rememberTextFieldState$1$1 r11 = new androidx.compose.foundation.text2.input.TextFieldStateKt$rememberTextFieldState$1$1
            r11.<init>(r7, r8)
            r12 = r11
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r10.updateRememberedValue(r12)
        L_0x0059:
            r3 = r12
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r10.endReplaceableGroup()
            r5 = 56
            r6 = 4
            r2 = 0
            r4 = r10
            java.lang.Object r7 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.foundation.text2.input.TextFieldState r7 = (androidx.compose.foundation.text2.input.TextFieldState) r7
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0073
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0073:
            r10.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.TextFieldStateKt.m1353rememberTextFieldStateLepunE(java.lang.String, long, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.text2.input.TextFieldState");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object forEachTextValue(androidx.compose.foundation.text2.input.TextFieldState r4, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.text2.input.TextFieldCharSequence, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.text2.input.TextFieldStateKt$forEachTextValue$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.foundation.text2.input.TextFieldStateKt$forEachTextValue$1 r0 = (androidx.compose.foundation.text2.input.TextFieldStateKt$forEachTextValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text2.input.TextFieldStateKt$forEachTextValue$1 r0 = new androidx.compose.foundation.text2.input.TextFieldStateKt$forEachTextValue$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 == r3) goto L_0x002e
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0042
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.Flow r4 = textAsFlow(r4)
            r0.label = r3
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.collectLatest(r4, r5, r0)
            if (r4 != r1) goto L_0x0042
            return r1
        L_0x0042:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "textAsFlow expected not to complete without exception"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.TextFieldStateKt.forEachTextValue(androidx.compose.foundation.text2.input.TextFieldState, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void setTextAndPlaceCursorAtEnd(TextFieldState textFieldState, String str) {
        TextFieldBuffer startEdit = textFieldState.startEdit(textFieldState.getText());
        startEdit.replace(0, startEdit.getLength(), str);
        TextFieldBufferKt.placeCursorAtEnd(startEdit);
        textFieldState.commitEdit(startEdit);
    }

    public static final void setTextAndSelectAll(TextFieldState textFieldState, String str) {
        TextFieldBuffer startEdit = textFieldState.startEdit(textFieldState.getText());
        startEdit.replace(0, startEdit.getLength(), str);
        TextFieldBufferKt.selectAll(startEdit);
        textFieldState.commitEdit(startEdit);
    }

    public static final void clearText(TextFieldState textFieldState) {
        TextFieldBuffer startEdit = textFieldState.startEdit(textFieldState.getText());
        TextFieldBufferKt.delete(startEdit, 0, startEdit.getLength());
        TextFieldBufferKt.placeCursorAtEnd(startEdit);
        textFieldState.commitEdit(startEdit);
    }
}
