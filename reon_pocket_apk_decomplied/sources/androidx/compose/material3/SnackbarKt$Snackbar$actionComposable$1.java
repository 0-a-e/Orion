package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$actionComposable$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $actionColor;
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ SnackbarData $snackbarData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$actionComposable$1(long j, SnackbarData snackbarData, String str) {
        super(2);
        this.$actionColor = j;
        this.$snackbarData = snackbarData;
        this.$actionLabel = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r16, int r17) {
        /*
            r15 = this;
            r0 = r15
            r13 = r16
            r1 = r17
            java.lang.String r2 = "C214@10104L44,215@10176L32,213@10052L219:Snackbar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r1 & 3
            r3 = 2
            if (r2 != r3) goto L_0x001b
            boolean r2 = r16.getSkipping()
            if (r2 != 0) goto L_0x0016
            goto L_0x001b
        L_0x0016:
            r16.skipToGroupEnd()
            goto L_0x009c
        L_0x001b:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x002a
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:213)"
            r4 = -1378313599(0xffffffffadd89a81, float:-2.462497E-11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x002a:
            androidx.compose.material3.ButtonDefaults r1 = androidx.compose.material3.ButtonDefaults.INSTANCE
            long r4 = r0.$actionColor
            r11 = 24576(0x6000, float:3.4438E-41)
            r12 = 13
            r2 = 0
            r6 = 0
            r8 = 0
            r10 = r16
            androidx.compose.material3.ButtonColors r5 = r1.m1563textButtonColorsro_MJ88(r2, r4, r6, r8, r10, r11, r12)
            r1 = -2057496839(0xffffffff855d16f9, float:-1.03955895E-35)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Snackbar.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            androidx.compose.material3.SnackbarData r1 = r0.$snackbarData
            boolean r1 = r13.changed((java.lang.Object) r1)
            androidx.compose.material3.SnackbarData r2 = r0.$snackbarData
            java.lang.Object r3 = r16.rememberedValue()
            if (r1 != 0) goto L_0x005f
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x006a
        L_0x005f:
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1 r1 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
            r1.<init>(r2)
            r3 = r1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r13.updateRememberedValue(r3)
        L_0x006a:
            r1 = r3
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r16.endReplaceableGroup()
            androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$2 r2 = new androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$2
            java.lang.String r3 = r0.$actionLabel
            r2.<init>(r3)
            r3 = 521110564(0x1f0f8424, float:3.0390732E-20)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r3, r4, r2)
            r10 = r2
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            r12 = 805306368(0x30000000, float:4.656613E-10)
            r14 = 494(0x1ee, float:6.92E-43)
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = r16
            r13 = r14
            androidx.compose.material3.ButtonKt.TextButton(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x009c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
