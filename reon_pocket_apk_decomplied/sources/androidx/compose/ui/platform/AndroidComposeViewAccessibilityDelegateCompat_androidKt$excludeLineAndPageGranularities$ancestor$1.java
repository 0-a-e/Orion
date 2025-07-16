package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;", "invoke", "(Landroidx/compose/ui/node/LayoutNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 extends Lambda implements Function1<LayoutNode, Boolean> {
    public static final AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1();

    AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r3.contains(androidx.compose.ui.semantics.SemanticsActions.INSTANCE.getSetText()) != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r3) {
        /*
            r2 = this;
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.getCollapsedSemantics$ui_release()
            if (r3 == 0) goto L_0x001a
            boolean r0 = r3.isMergingSemanticsOfDescendants()
            r1 = 1
            if (r0 != r1) goto L_0x001a
            androidx.compose.ui.semantics.SemanticsActions r0 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.getSetText()
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
    }
}
