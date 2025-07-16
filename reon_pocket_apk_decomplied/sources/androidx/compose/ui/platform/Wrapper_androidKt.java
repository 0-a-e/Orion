package androidx.compose.ui.platform;

import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.ui.R;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\u0002¢\u0006\u0002\u0010\u0010\u001a,\u0010\u0011\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\u0000¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "createSubcomposition", "Landroidx/compose/runtime/ReusableComposition;", "container", "Landroidx/compose/ui/node/LayoutNode;", "parent", "Landroidx/compose/runtime/CompositionContext;", "doSetContent", "Landroidx/compose/runtime/Composition;", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "setContent", "Landroidx/compose/ui/platform/AbstractComposeView;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Wrapper.android.kt */
public final class Wrapper_androidKt {
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static final ReusableComposition createSubcomposition(LayoutNode layoutNode, CompositionContext compositionContext) {
        return CompositionKt.ReusableComposition(new UiApplier(layoutNode), compositionContext);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.runtime.Composition setContent(androidx.compose.ui.platform.AbstractComposeView r3, androidx.compose.runtime.CompositionContext r4, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r5) {
        /*
            androidx.compose.ui.platform.GlobalSnapshotManager r0 = androidx.compose.ui.platform.GlobalSnapshotManager.INSTANCE
            r0.ensureStarted()
            int r0 = r3.getChildCount()
            r1 = 0
            if (r0 <= 0) goto L_0x0019
            r0 = 0
            android.view.View r0 = r3.getChildAt(r0)
            boolean r2 = r0 instanceof androidx.compose.ui.platform.AndroidComposeView
            if (r2 == 0) goto L_0x001c
            r1 = r0
            androidx.compose.ui.platform.AndroidComposeView r1 = (androidx.compose.ui.platform.AndroidComposeView) r1
            goto L_0x001c
        L_0x0019:
            r3.removeAllViews()
        L_0x001c:
            if (r1 != 0) goto L_0x0034
            androidx.compose.ui.platform.AndroidComposeView r1 = new androidx.compose.ui.platform.AndroidComposeView
            android.content.Context r0 = r3.getContext()
            kotlin.coroutines.CoroutineContext r2 = r4.getEffectCoroutineContext()
            r1.<init>(r0, r2)
            android.view.View r0 = r1.getView()
            android.view.ViewGroup$LayoutParams r2 = DefaultLayoutParams
            r3.addView((android.view.View) r0, (android.view.ViewGroup.LayoutParams) r2)
        L_0x0034:
            androidx.compose.runtime.Composition r3 = doSetContent(r1, r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.Wrapper_androidKt.setContent(androidx.compose.ui.platform.AbstractComposeView, androidx.compose.runtime.CompositionContext, kotlin.jvm.functions.Function2):androidx.compose.runtime.Composition");
    }

    private static final Composition doSetContent(AndroidComposeView androidComposeView, CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() && androidComposeView.getTag(R.id.inspection_slot_table_set) == null) {
            androidComposeView.setTag(R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
        }
        Composition Composition = CompositionKt.Composition(new UiApplier(androidComposeView.getRoot()), compositionContext);
        Object tag = androidComposeView.getView().getTag(R.id.wrapped_composition_tag);
        WrappedComposition wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, Composition);
            androidComposeView.getView().setTag(R.id.wrapped_composition_tag, wrappedComposition);
        }
        wrappedComposition.setContent(function2);
        return wrappedComposition;
    }
}
