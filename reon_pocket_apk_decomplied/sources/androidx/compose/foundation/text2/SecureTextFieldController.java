package androidx.compose.foundation.text2;

import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text2/SecureTextFieldController;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "getCodepointTransformation", "()Landroidx/compose/foundation/text2/input/CodepointTransformation;", "focusChangeModifier", "Landroidx/compose/ui/Modifier;", "getFocusChangeModifier", "()Landroidx/compose/ui/Modifier;", "passwordRevealFilter", "Landroidx/compose/foundation/text2/PasswordRevealFilter;", "getPasswordRevealFilter", "()Landroidx/compose/foundation/text2/PasswordRevealFilter;", "resetTimerSignal", "Lkotlinx/coroutines/channels/Channel;", "", "scheduleHide", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
public final class SecureTextFieldController {
    public static final int $stable = 8;
    private final CodepointTransformation codepointTransformation = new SecureTextFieldController$$ExternalSyntheticLambda0(this);
    private final Modifier focusChangeModifier = FocusChangedModifierKt.onFocusChanged(Modifier.Companion, new SecureTextFieldController$focusChangeModifier$1(this));
    private final PasswordRevealFilter passwordRevealFilter = new PasswordRevealFilter(new SecureTextFieldController$passwordRevealFilter$1(this));
    /* access modifiers changed from: private */
    public final Channel<Unit> resetTimerSignal = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);

    public SecureTextFieldController(CoroutineScope coroutineScope) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final PasswordRevealFilter getPasswordRevealFilter() {
        return this.passwordRevealFilter;
    }

    public final CodepointTransformation getCodepointTransformation() {
        return this.codepointTransformation;
    }

    /* access modifiers changed from: private */
    public static final int codepointTransformation$lambda$0(SecureTextFieldController secureTextFieldController, int i, int i2) {
        if (i == secureTextFieldController.passwordRevealFilter.getRevealCodepointIndex$foundation_release()) {
            return i2;
        }
        return 8226;
    }

    public final Modifier getFocusChangeModifier() {
        return this.focusChangeModifier;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text2.SecureTextFieldController$1", f = "BasicSecureTextField.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text2.SecureTextFieldController$1  reason: invalid class name */
    /* compiled from: BasicSecureTextField.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SecureTextFieldController this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow consumeAsFlow = FlowKt.consumeAsFlow(this.this$0.resetTimerSignal);
                final SecureTextFieldController secureTextFieldController = this.this$0;
                this.label = 1;
                if (FlowKt.collectLatest(consumeAsFlow, new Function2<Unit, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 

                        /* access modifiers changed from: private */
                        public final void scheduleHide() {
                            if (!ChannelResult.m8580isSuccessimpl(this.resetTimerSignal.m8593trySendJP2dKIU(Unit.INSTANCE))) {
                                this.passwordRevealFilter.hide();
                            }
                        }
                    }
