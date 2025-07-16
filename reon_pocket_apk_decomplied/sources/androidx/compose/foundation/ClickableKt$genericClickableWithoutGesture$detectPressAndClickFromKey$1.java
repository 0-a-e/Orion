package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ Map<Key, PressInteraction.Press> $currentKeyPressInteractions;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ CoroutineScope $indicationScope;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Offset> $keyClickOffset;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1(boolean z, Map<Key, PressInteraction.Press> map, State<Offset> state, CoroutineScope coroutineScope, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.$enabled = z;
        this.$currentKeyPressInteractions = map;
        this.$keyClickOffset = state;
        this.$indicationScope = coroutineScope;
        this.$onClick = function0;
        this.$interactionSource = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m256invokeZmokQxo(((KeyEvent) obj).m4946unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m256invokeZmokQxo(android.view.KeyEvent keyEvent) {
        boolean z = true;
        if (!this.$enabled || !Clickable_androidKt.m263isPressZmokQxo(keyEvent)) {
            if (this.$enabled && Clickable_androidKt.m261isClickZmokQxo(keyEvent)) {
                PressInteraction.Press remove = this.$currentKeyPressInteractions.remove(Key.m4646boximpl(KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent)));
                if (remove != null) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.$indicationScope, (CoroutineContext) null, (CoroutineStart) null, new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1(this.$interactionSource, remove, (Continuation<? super ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1>) null), 3, (Object) null);
                }
                this.$onClick.invoke();
                return Boolean.valueOf(z);
            }
        } else if (!this.$currentKeyPressInteractions.containsKey(Key.m4646boximpl(KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent)))) {
            final PressInteraction.Press press = new PressInteraction.Press(this.$keyClickOffset.getValue().m3572unboximpl(), (DefaultConstructorMarker) null);
            this.$currentKeyPressInteractions.put(Key.m4646boximpl(KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent)), press);
            CoroutineScope coroutineScope = this.$indicationScope;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", f = "Clickable.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1  reason: invalid class name */
    /* compiled from: Clickable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(mutableInteractionSource, press, continuation);
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
                if (mutableInteractionSource.emit(press, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
