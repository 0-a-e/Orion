package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$updateViewHolderParams$5 extends Lambda implements Function2<LayoutNode, LayoutDirection, Unit> {
    public static final AndroidView_androidKt$updateViewHolderParams$5 INSTANCE = new AndroidView_androidKt$updateViewHolderParams$5();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidView.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.compose.ui.unit.LayoutDirection[] r0 = androidx.compose.ui.unit.LayoutDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Ltr     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Rtl     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$5.WhenMappings.<clinit>():void");
        }
    }

    AndroidView_androidKt$updateViewHolderParams$5() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (LayoutDirection) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode layoutNode, LayoutDirection layoutDirection) {
        ViewFactoryHolder access$requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        access$requireViewFactoryHolder.setLayoutDirection(i2);
    }
}
