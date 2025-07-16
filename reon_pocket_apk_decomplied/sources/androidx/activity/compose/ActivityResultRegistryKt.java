package androidx.activity.compose;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActivityResultRegistry.kt */
public final class ActivityResultRegistryKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <I, O> androidx.activity.compose.ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(androidx.activity.result.contract.ActivityResultContract<I, O> r15, kotlin.jvm.functions.Function1<? super O, kotlin.Unit> r16, androidx.compose.runtime.Composer r17, int r18) {
        /*
            r6 = r15
            r14 = r17
            r0 = -1408504823(0xffffffffac0bec09, float:-1.9884114E-12)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberLauncherForActivityResult)86@3568L30,87@3625L30,91@3794L49,*93@3924L7,96@4078L46,97@4152L85,103@4420L204,103@4364L260:ActivityResultRegistry.kt#q1dkbc"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r18 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r15, r14, r0)
            int r1 = r18 >> 3
            r1 = r1 & 14
            r2 = r16
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r14, r1)
            r1 = 0
            java.lang.Object[] r7 = new java.lang.Object[r1]
            androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 r1 = androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1.INSTANCE
            r10 = r1
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r12 = 3072(0xc00, float:4.305E-42)
            r13 = 6
            r8 = 0
            r9 = 0
            r11 = r17
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r7, r8, (java.lang.String) r9, r10, (androidx.compose.runtime.Composer) r11, (int) r12, (int) r13)
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
            androidx.activity.compose.LocalActivityResultRegistryOwner r1 = androidx.activity.compose.LocalActivityResultRegistryOwner.INSTANCE
            r8 = 6
            androidx.activity.result.ActivityResultRegistryOwner r1 = r1.getCurrent(r14, r8)
            if (r1 == 0) goto L_0x00dd
            androidx.activity.result.ActivityResultRegistry r9 = r1.getActivityResultRegistry()
            r1 = -1672765924(0xffffffff9c4b9e1c, float:-6.7371417E-22)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):ActivityResultRegistry.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            java.lang.Object r2 = r17.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0060
            androidx.activity.compose.ActivityResultLauncherHolder r2 = new androidx.activity.compose.ActivityResultLauncherHolder
            r2.<init>()
            r14.updateRememberedValue(r2)
        L_0x0060:
            androidx.activity.compose.ActivityResultLauncherHolder r2 = (androidx.activity.compose.ActivityResultLauncherHolder) r2
            r17.endReplaceableGroup()
            r3 = -1672765850(0xffffffff9c4b9e66, float:-6.737179E-22)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            java.lang.Object r3 = r17.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0082
            androidx.activity.compose.ManagedActivityResultLauncher r3 = new androidx.activity.compose.ManagedActivityResultLauncher
            r3.<init>(r2, r0)
            r14.updateRememberedValue(r3)
        L_0x0082:
            r10 = r3
            androidx.activity.compose.ManagedActivityResultLauncher r10 = (androidx.activity.compose.ManagedActivityResultLauncher) r10
            r17.endReplaceableGroup()
            r0 = -1672765582(0xffffffff9c4b9f72, float:-6.7373144E-22)
            r14.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            boolean r0 = r14.changed((java.lang.Object) r2)
            boolean r1 = r14.changed((java.lang.Object) r9)
            r0 = r0 | r1
            boolean r1 = r14.changed((java.lang.Object) r7)
            r0 = r0 | r1
            boolean r1 = r14.changed((java.lang.Object) r15)
            r0 = r0 | r1
            boolean r1 = r14.changed((java.lang.Object) r5)
            r0 = r0 | r1
            java.lang.Object r1 = r17.rememberedValue()
            if (r0 != 0) goto L_0x00b7
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00c7
        L_0x00b7:
            androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1 r11 = new androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1
            r0 = r11
            r1 = r2
            r2 = r9
            r3 = r7
            r4 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = r11
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r14.updateRememberedValue(r1)
        L_0x00c7:
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r17.endReplaceableGroup()
            int r0 = r18 << 6
            r5 = r0 & 896(0x380, float:1.256E-42)
            r0 = r9
            r1 = r7
            r2 = r15
            r4 = r17
            androidx.compose.runtime.EffectsKt.DisposableEffect(r0, r1, r2, r3, r4, r5)
            r17.endReplaceableGroup()
            return r10
        L_0x00dd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.compose.ActivityResultRegistryKt.rememberLauncherForActivityResult(androidx.activity.result.contract.ActivityResultContract, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):androidx.activity.compose.ManagedActivityResultLauncher");
    }
}
