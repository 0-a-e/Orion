package androidx.compose.foundation.text2.input.internal;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2", f = "AndroidTextInputSession.android.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidTextInputSession.android.kt */
final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ ComposeInputMethodManager $composeImm;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
    final /* synthetic */ TransformedTextFieldState $state;
    final /* synthetic */ PlatformTextInputSession $this_platformSpecificTextInputSession;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2(PlatformTextInputSession platformTextInputSession, TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, Function1<? super ImeAction, Unit> function1, Continuation<? super AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2> continuation) {
        super(2, continuation);
        this.$this_platformSpecificTextInputSession = platformTextInputSession;
        this.$state = transformedTextFieldState;
        this.$composeImm = composeInputMethodManager;
        this.$imeOptions = imeOptions;
        this.$onImeAction = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 androidTextInputSession_androidKt$platformSpecificTextInputSession$2 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2(this.$this_platformSpecificTextInputSession, this.$state, this.$composeImm, this.$imeOptions, this.$onImeAction, continuation);
        androidTextInputSession_androidKt$platformSpecificTextInputSession$2.L$0 = obj;
        return androidTextInputSession_androidKt$platformSpecificTextInputSession$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        return ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1", f = "AndroidTextInputSession.android.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1  reason: invalid class name */
    /* compiled from: AndroidTextInputSession.android.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(transformedTextFieldState, composeInputMethodManager, imeOptions, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (transformedTextFieldState.collectImeNotifications(new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1$$ExternalSyntheticLambda0(composeInputMethodManager, imeOptions), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2) {
            if (!TextRange.m6035equalsimpl0(textFieldCharSequence.m1346getSelectionInCharsd9O1mEE(), textFieldCharSequence2.m1346getSelectionInCharsd9O1mEE()) || !Intrinsics.areEqual((Object) textFieldCharSequence.m1345getCompositionInCharsMzsxiRA(), (Object) textFieldCharSequence2.m1345getCompositionInCharsMzsxiRA())) {
                int r0 = TextRange.m6040getMinimpl(textFieldCharSequence2.m1346getSelectionInCharsd9O1mEE());
                int r1 = TextRange.m6039getMaximpl(textFieldCharSequence2.m1346getSelectionInCharsd9O1mEE());
                TextRange r2 = textFieldCharSequence2.m1345getCompositionInCharsMzsxiRA();
                int i = -1;
                int r22 = r2 != null ? TextRange.m6040getMinimpl(r2.m6046unboximpl()) : -1;
                TextRange r4 = textFieldCharSequence2.m1345getCompositionInCharsMzsxiRA();
                if (r4 != null) {
                    i = TextRange.m6039getMaximpl(r4.m6046unboximpl());
                }
                composeInputMethodManager.updateSelection(r0, r1, r22, i);
            }
            if (!textFieldCharSequence.contentEquals(textFieldCharSequence2) && !KeyboardType.m6272equalsimpl0(imeOptions.m6251getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6290getPasswordPjHm6EE())) {
                composeInputMethodManager.restartInput();
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineStart coroutineStart = CoroutineStart.UNDISPATCHED;
            final TransformedTextFieldState transformedTextFieldState = this.$state;
            final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
            final ImeOptions imeOptions = this.$imeOptions;
            Job unused = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, coroutineStart, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 1, (Object) null);
            this.label = 1;
            if (this.$this_platformSpecificTextInputSession.startInputMethod(new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$$ExternalSyntheticLambda0(this.$state, this.$imeOptions, this.$composeImm, this.$onImeAction), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    public static final InputConnection invokeSuspend$lambda$0(TransformedTextFieldState transformedTextFieldState, ImeOptions imeOptions, ComposeInputMethodManager composeInputMethodManager, Function1 function1, EditorInfo editorInfo) {
        AndroidTextInputSession_androidKt.logDebug$default((String) null, new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$1(transformedTextFieldState), 1, (Object) null);
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1 androidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1(transformedTextFieldState, composeInputMethodManager, function1);
        AndroidTextInputSession_androidKt.update(editorInfo, transformedTextFieldState.getText(), imeOptions);
        return new StatelessInputConnection(androidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1);
    }
}
