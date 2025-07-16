package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.Lifecycle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Wrapper.android.kt */
final class WrappedComposition$setContent$1 extends Lambda implements Function1<AndroidComposeView.ViewTreeOwners, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ WrappedComposition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrappedComposition$setContent$1(WrappedComposition wrappedComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(1);
        this.this$0 = wrappedComposition;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AndroidComposeView.ViewTreeOwners) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
        if (!this.this$0.disposed) {
            Lifecycle lifecycle = viewTreeOwners.getLifecycleOwner().getLifecycle();
            this.this$0.lastContent = this.$content;
            if (this.this$0.addedToLifecycle == null) {
                this.this$0.addedToLifecycle = lifecycle;
                lifecycle.addObserver(this.this$0);
            } else if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                Composition original = this.this$0.getOriginal();
                final WrappedComposition wrappedComposition = this.this$0;
                final Function2<Composer, Integer, Unit> function2 = this.$content;
                original.setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C135@5473L56,137@5555L176:Wrapper.android.kt#itgzvw");
                        if ((i & 11) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2000640158, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:124)");
                            }
                            Object tag = wrappedComposition.getOwner().getTag(R.id.inspection_slot_table_set);
                            Set set = TypeIntrinsics.isMutableSet(tag) ? (Set) tag : null;
                            if (set == null) {
                                ViewParent parent = wrappedComposition.getOwner().getParent();
                                View view = parent instanceof View ? (View) parent : null;
                                Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                                set = TypeIntrinsics.isMutableSet(tag2) ? (Set) tag2 : null;
                            }
                            if (set != null) {
                                set.add(composer.getCompositionData());
                                composer.collectParameterInformation();
                            }
                            AndroidComposeView owner = wrappedComposition.getOwner();
                            final WrappedComposition wrappedComposition = wrappedComposition;
                            EffectsKt.LaunchedEffect((Object) owner, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 72);
                            ProvidedValue<Set<CompositionData>> provides = InspectionTablesKt.getLocalInspectionTables().provides(set);
                            final WrappedComposition wrappedComposition2 = wrappedComposition;
                            final Function2<Composer, Integer, Unit> function2 = function2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1193460702, true, new Function2<Composer, Integer, Unit>() {
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer, int i) {
                                    ComposerKt.sourceInformation(composer, "C138@5658L47:Wrapper.android.kt#itgzvw");
                                    if ((i & 11) != 2 || !composer.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1193460702, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:138)");
                                        }
                                        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(wrappedComposition2.getOwner(), function2, composer, 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer.skipToGroupEnd();
                                }
                            }), composer, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1", f = "Wrapper.android.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1  reason: invalid class name */
                    /* compiled from: Wrapper.android.kt */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(wrappedComposition, continuation);
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
                                if (wrappedComposition.getOwner().boundsUpdatesEventLoop(this) == coroutine_suspended) {
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
                }));
            }
        }
    }
}
