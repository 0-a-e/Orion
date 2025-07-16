package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0007\u001a\u00020\b*\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\b\u000fH@¢\u0006\u0002\u0010\u0010\"$\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"LocalPlatformTextInputMethodOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/PlatformTextInputSessionHandler;", "getLocalPlatformTextInputMethodOverride$annotations", "()V", "getLocalPlatformTextInputMethodOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "establishTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformTextInputModifierNode.kt */
public final class PlatformTextInputModifierNodeKt {
    private static final ProvidableCompositionLocal<PlatformTextInputSessionHandler> LocalPlatformTextInputMethodOverride = CompositionLocalKt.staticCompositionLocalOf(PlatformTextInputModifierNodeKt$LocalPlatformTextInputMethodOverride$1.INSTANCE);

    public static /* synthetic */ void getLocalPlatformTextInputMethodOverride$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object establishTextInputSession(androidx.compose.ui.platform.PlatformTextInputModifierNode r4, kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1 r0 = (androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1 r0 = new androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1
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
            goto L_0x0065
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.ui.Modifier$Node r6 = r4.getNode()
            boolean r6 = r6.isAttached()
            if (r6 == 0) goto L_0x006b
            androidx.compose.ui.node.DelegatableNode r4 = (androidx.compose.ui.node.DelegatableNode) r4
            androidx.compose.ui.node.LayoutNode r6 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r4)
            androidx.compose.runtime.CompositionLocalMap r6 = r6.getCompositionLocalMap()
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.platform.PlatformTextInputSessionHandler> r2 = LocalPlatformTextInputMethodOverride
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            java.lang.Object r6 = r6.get(r2)
            androidx.compose.ui.platform.PlatformTextInputSessionHandler r6 = (androidx.compose.ui.platform.PlatformTextInputSessionHandler) r6
            if (r6 != 0) goto L_0x005c
            androidx.compose.ui.node.Owner r4 = androidx.compose.ui.node.DelegatableNodeKt.requireOwner(r4)
            r6 = r4
            androidx.compose.ui.platform.PlatformTextInputSessionHandler r6 = (androidx.compose.ui.platform.PlatformTextInputSessionHandler) r6
        L_0x005c:
            r0.label = r3
            java.lang.Object r4 = r6.textInputSession(r5, r0)
            if (r4 != r1) goto L_0x0065
            return r1
        L_0x0065:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L_0x006b:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "establishTextInputSession called from an unattached node"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.establishTextInputSession(androidx.compose.ui.platform.PlatformTextInputModifierNode, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ProvidableCompositionLocal<PlatformTextInputSessionHandler> getLocalPlatformTextInputMethodOverride() {
        return LocalPlatformTextInputMethodOverride;
    }
}
