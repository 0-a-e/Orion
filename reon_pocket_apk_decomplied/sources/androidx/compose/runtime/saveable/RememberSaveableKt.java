package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0004\b\u0000\u0010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0003H\u0002\u001aa\u0010\b\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ag\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"MaxSupportedRadix", "", "mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "", "inner", "rememberSaveable", "inputs", "", "saver", "key", "", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "value", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: androidx.compose.runtime.saveable.SaveableHolder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: androidx.compose.runtime.saveable.SaveableHolder} */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberSaveable  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T m3400rememberSaveable(java.lang.Object[] r8, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r9, java.lang.String r10, kotlin.jvm.functions.Function0<? extends T> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = 441892779(0x1a56bfab, float:4.440899E-23)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSaveable)P(1,3,2)71@3180L23,81@3526L7,83@3552L313,93@3940L82:RememberSaveable.kt#r2ddri"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r14 & 2
            if (r1 == 0) goto L_0x0013
            androidx.compose.runtime.saveable.Saver r9 = androidx.compose.runtime.saveable.SaverKt.autoSaver()
        L_0x0013:
            r14 = r14 & 4
            r1 = 0
            if (r14 == 0) goto L_0x0019
            r10 = r1
        L_0x0019:
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x0025
            r14 = -1
            java.lang.String r2 = "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:70)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r14, r2)
        L_0x0025:
            r13 = 0
            int r14 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r12, r13)
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0035
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0045
        L_0x0035:
            int r10 = MaxSupportedRadix
            int r10 = kotlin.text.CharsKt.checkRadix(r10)
            java.lang.String r10 = java.lang.Integer.toString(r14, r10)
            java.lang.String r14 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r14)
        L_0x0045:
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r0, r2)
            java.lang.Object r14 = r12.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.runtime.saveable.SaveableStateRegistry r14 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r14
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            java.lang.Object r0 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x009a
            if (r14 == 0) goto L_0x0084
            java.lang.Object r0 = r14.consumeRestored(r10)
            if (r0 == 0) goto L_0x0084
            java.lang.Object r1 = r9.restore(r0)
        L_0x0084:
            if (r1 != 0) goto L_0x008c
            java.lang.Object r0 = r11.invoke()
            r5 = r0
            goto L_0x008d
        L_0x008c:
            r5 = r1
        L_0x008d:
            androidx.compose.runtime.saveable.SaveableHolder r0 = new androidx.compose.runtime.saveable.SaveableHolder
            r1 = r0
            r2 = r9
            r3 = r14
            r4 = r10
            r6 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r12.updateRememberedValue(r0)
        L_0x009a:
            r12.endReplaceableGroup()
            r2 = r0
            androidx.compose.runtime.saveable.SaveableHolder r2 = (androidx.compose.runtime.saveable.SaveableHolder) r2
            java.lang.Object r0 = r2.getValueIfInputsDidntChange(r8)
            if (r0 != 0) goto L_0x00aa
            java.lang.Object r0 = r11.invoke()
        L_0x00aa:
            androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1 r11 = new androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1
            r1 = r11
            r3 = r9
            r4 = r14
            r5 = r10
            r6 = r0
            r7 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            androidx.compose.runtime.EffectsKt.SideEffect(r11, r12, r13)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00c3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00c3:
            r12.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.RememberSaveableKt.m3400rememberSaveable(java.lang.Object[], androidx.compose.runtime.saveable.Saver, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [androidx.compose.runtime.saveable.Saver, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> androidx.compose.runtime.MutableState<T> rememberSaveable(java.lang.Object[] r8, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r9, java.lang.String r10, kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>> r11, androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            r0 = -202053668(0xfffffffff3f4e7dc, float:-3.8806857E31)
            r12.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSaveable)P(1,3,2)127@5317L106:RememberSaveable.kt#r2ddri"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r14 = r14 & 4
            if (r14 == 0) goto L_0x0010
            r10 = 0
        L_0x0010:
            r3 = r10
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x001d
            r10 = -1
            java.lang.String r14 = "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:127)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r10, r14)
        L_0x001d:
            int r10 = r8.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r8, r10)
            androidx.compose.runtime.saveable.Saver r2 = mutableStateSaver(r9)
            r8 = r13 & 896(0x380, float:1.256E-42)
            r8 = r8 | 8
            r9 = r13 & 7168(0x1c00, float:1.0045E-41)
            r6 = r8 | r9
            r7 = 0
            r4 = r11
            r5 = r12
            java.lang.Object r8 = rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0040
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0040:
            r12.endReplaceableGroup()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable(java.lang.Object[], androidx.compose.runtime.saveable.Saver, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.MutableState");
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new RememberSaveableKt$mutableStateSaver$1$1(saver), new RememberSaveableKt$mutableStateSaver$1$2(saver));
    }

    /* access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String str;
        if (obj != null && !saveableStateRegistry.canBeSaved(obj)) {
            if (obj instanceof SnapshotMutableState) {
                SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
                if (snapshotMutableState.getPolicy() == SnapshotStateKt.neverEqualPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                    str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                str = obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
            }
            throw new IllegalArgumentException(str);
        }
    }
}
