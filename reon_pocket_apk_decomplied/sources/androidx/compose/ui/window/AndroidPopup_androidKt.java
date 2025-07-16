package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0013\b\b\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002H\u0007\u001a\f\u0010\"\u001a\u00020\u001e*\u00020 H\u0000\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&²\u0006\u0015\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010X\u0002"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isPopupLayout", "", "view", "Landroid/view/View;", "testTag", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* renamed from: Popup-K5zGePQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m6876PopupK5zGePQ(androidx.compose.ui.Alignment r25, long r26, kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.window.PopupProperties r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r7 = r32
            r0 = 295309329(0x119a1011, float:2.4306818E-28)
            r1 = r31
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)195@8726L128,202@8860L165:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r33 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r7 | 6
            r4 = r3
            r3 = r25
            goto L_0x002e
        L_0x001a:
            r3 = r7 & 14
            if (r3 != 0) goto L_0x002b
            r3 = r25
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r7
            goto L_0x002e
        L_0x002b:
            r3 = r25
            r4 = r7
        L_0x002e:
            r5 = r33 & 2
            if (r5 == 0) goto L_0x0037
            r4 = r4 | 48
            r8 = r26
            goto L_0x0049
        L_0x0037:
            r6 = r7 & 112(0x70, float:1.57E-43)
            r8 = r26
            if (r6 != 0) goto L_0x0049
            boolean r6 = r1.changed((long) r8)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r4 = r4 | r6
        L_0x0049:
            r6 = r33 & 4
            if (r6 == 0) goto L_0x0050
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r10 = r7 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x0063
            r10 = r28
            boolean r11 = r1.changedInstance(r10)
            if (r11 == 0) goto L_0x005f
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r11
            goto L_0x0065
        L_0x0063:
            r10 = r28
        L_0x0065:
            r11 = r33 & 8
            if (r11 == 0) goto L_0x006c
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r12 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x007f
            r12 = r29
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x007b
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r4 = r4 | r13
            goto L_0x0081
        L_0x007f:
            r12 = r29
        L_0x0081:
            r13 = r33 & 16
            if (r13 == 0) goto L_0x008a
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r15 = r30
            goto L_0x009e
        L_0x008a:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r7
            r15 = r30
            if (r13 != 0) goto L_0x009e
            boolean r13 = r1.changedInstance(r15)
            if (r13 == 0) goto L_0x009b
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r4 = r4 | r13
        L_0x009e:
            r13 = 46811(0xb6db, float:6.5596E-41)
            r13 = r13 & r4
            r14 = 9362(0x2492, float:1.3119E-41)
            if (r13 != r14) goto L_0x00b5
            boolean r13 = r1.getSkipping()
            if (r13 != 0) goto L_0x00ad
            goto L_0x00b5
        L_0x00ad:
            r1.skipToGroupEnd()
            r2 = r3
            r4 = r10
            r5 = r12
            goto L_0x0147
        L_0x00b5:
            if (r2 == 0) goto L_0x00be
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            goto L_0x00bf
        L_0x00be:
            r2 = r3
        L_0x00bf:
            if (r5 == 0) goto L_0x00c6
            r3 = 0
            long r8 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r3, r3)
        L_0x00c6:
            r13 = r8
            r3 = 0
            if (r6 == 0) goto L_0x00cc
            r5 = r3
            goto L_0x00cd
        L_0x00cc:
            r5 = r10
        L_0x00cd:
            if (r11 == 0) goto L_0x00e7
            androidx.compose.ui.window.PopupProperties r6 = new androidx.compose.ui.window.PopupProperties
            r23 = 63
            r24 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r16 = r6
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x00e8
        L_0x00e7:
            r6 = r12
        L_0x00e8:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x00f4
            r8 = -1
            java.lang.String r9 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r4, r8, r9)
        L_0x00f4:
            androidx.compose.ui.unit.IntOffset r0 = androidx.compose.ui.unit.IntOffset.m6739boximpl(r13)
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            boolean r8 = r1.changed((java.lang.Object) r2)
            boolean r0 = r1.changed((java.lang.Object) r0)
            r0 = r0 | r8
            java.lang.Object r8 = r1.rememberedValue()
            if (r0 != 0) goto L_0x011a
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r8 != r0) goto L_0x0122
        L_0x011a:
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r8 = new androidx.compose.ui.window.AlignmentOffsetPositionProvider
            r8.<init>(r2, r13, r3)
            r1.updateRememberedValue(r8)
        L_0x0122:
            r1.endReplaceableGroup()
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r8 = (androidx.compose.ui.window.AlignmentOffsetPositionProvider) r8
            androidx.compose.ui.window.PopupPositionProvider r8 = (androidx.compose.ui.window.PopupPositionProvider) r8
            int r0 = r4 >> 3
            r0 = r0 & 8176(0x1ff0, float:1.1457E-41)
            r3 = 0
            r9 = r5
            r10 = r6
            r11 = r30
            r12 = r1
            r16 = r13
            r13 = r0
            r14 = r3
            Popup(r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0143
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0143:
            r4 = r5
            r5 = r6
            r8 = r16
        L_0x0147:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 == 0) goto L_0x0160
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1 r11 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
            r0 = r11
            r1 = r2
            r2 = r8
            r6 = r30
            r7 = r32
            r8 = r33
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0160:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.m6876PopupK5zGePQ(androidx.compose.ui.Alignment, long, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Popup(androidx.compose.ui.window.PopupPositionProvider r35, kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.ui.window.PopupProperties r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r11 = r35
            r12 = r38
            r13 = r40
            r0 = -830247068(0xffffffffce836f64, float:-1.1025577E9)
            r1 = r39
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Popup)P(2,1,3)229@9749L7,230@9788L7,231@9832L7,232@9887L7,233@9923L28,234@9978L29,235@10026L38,236@10087L944,264@11037L417,279@11460L229,288@11695L166,300@12424L175,310@12777L771:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r41 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r13 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x002a
            boolean r1 = r14.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r13
            goto L_0x002b
        L_0x002a:
            r1 = r13
        L_0x002b:
            r2 = r41 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0045
            r3 = r36
            boolean r4 = r14.changedInstance(r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r1 = r1 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r36
        L_0x0047:
            r4 = r41 & 4
            if (r4 == 0) goto L_0x004e
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0061
            r5 = r37
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r1 = r1 | r6
            goto L_0x0063
        L_0x0061:
            r5 = r37
        L_0x0063:
            r6 = r41 & 8
            if (r6 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x006a:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007a
            boolean r6 = r14.changedInstance(r12)
            if (r6 == 0) goto L_0x0077
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r6
        L_0x007a:
            r15 = r1
            r1 = r15 & 5851(0x16db, float:8.199E-42)
            r6 = 1170(0x492, float:1.64E-42)
            if (r1 != r6) goto L_0x008f
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0088
            goto L_0x008f
        L_0x0088:
            r14.skipToGroupEnd()
            r2 = r3
            r3 = r5
            goto L_0x0299
        L_0x008f:
            r10 = 0
            if (r2 == 0) goto L_0x0095
            r22 = r10
            goto L_0x0097
        L_0x0095:
            r22 = r3
        L_0x0097:
            if (r4 == 0) goto L_0x00b1
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r30 = 63
            r31 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r23 = r1
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31)
            goto L_0x00b3
        L_0x00b1:
            r23 = r5
        L_0x00b3:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00bf
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x00bf:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r2)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r8 = r0
            android.view.View r8 = (android.view.View) r8
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r2)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r9 = r0
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r0 = LocalPopupTestTag
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r2)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r24 = r0
            java.lang.String r24 = (java.lang.String) r24
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r2)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r7 = 0
            androidx.compose.runtime.CompositionContext r6 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r14, r7)
            int r1 = r15 >> 9
            r1 = r1 & 14
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r14, r1)
            java.lang.Object[] r1 = new java.lang.Object[r7]
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1 r2 = androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1.INSTANCE
            r4 = r2
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r16 = 3080(0xc08, float:4.316E-42)
            r17 = 6
            r2 = 0
            r3 = 0
            r32 = r5
            r5 = r14
            r33 = r6
            r6 = r16
            r7 = r17
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            java.util.UUID r7 = (java.util.UUID) r7
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            java.lang.Object r1 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0190
            androidx.compose.ui.window.PopupLayout r6 = new androidx.compose.ui.window.PopupLayout
            r16 = 128(0x80, float:1.794E-43)
            r17 = 0
            r18 = 0
            r5 = r0
            r0 = r6
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r8
            r8 = r5
            r5 = r9
            r9 = r6
            r6 = r35
            r36 = r8
            r8 = r18
            r34 = r9
            r9 = r16
            r12 = r10
            r10 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
            r1 = r32
            r2 = r34
            r0.<init>(r2, r1)
            r1 = 1302892335(0x4da88f2f, float:3.53494496E8)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r1, r3, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r2.setContent(r1, r0)
            r14.updateRememberedValue(r2)
            r1 = r2
            goto L_0x0193
        L_0x0190:
            r36 = r0
            r12 = r10
        L_0x0193:
            r14.endReplaceableGroup()
            androidx.compose.ui.window.PopupLayout r1 = (androidx.compose.ui.window.PopupLayout) r1
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2
            r16 = r0
            r17 = r1
            r18 = r22
            r19 = r23
            r20 = r24
            r21 = r36
            r16.<init>(r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r14, (int) r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3
            r16 = r0
            r16.<init>(r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r2 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r14, r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4
            r0.<init>(r1, r11)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r3 = r15 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r14, (int) r3)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5
            r0.<init>(r1, r12)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3 = 72
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r14, (int) r3)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7 r3 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7
            r3.<init>(r1)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r3)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8 r3 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8
            r4 = r36
            r3.<init>(r1, r4)
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
            r1 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            int r1 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r14, r2)
            androidx.compose.runtime.CompositionLocalMap r4 = r14.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r6 = r14.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0215
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0215:
            r14.startReusableNode()
            boolean r6 = r14.getInserting()
            if (r6 == 0) goto L_0x0222
            r14.createNode(r5)
            goto L_0x0225
        L_0x0222:
            r14.useNode()
        L_0x0225:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m3282constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r3, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r5, r4, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetCompositeKeyHash()
            boolean r4 = r5.getInserting()
            if (r4 != 0) goto L_0x0255
            java.lang.Object r4 = r5.rememberedValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 != 0) goto L_0x0263
        L_0x0255:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            r5.updateRememberedValue(r4)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r5.apply(r1, r3)
        L_0x0263:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r14, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r0)
            r0 = 1097164990(0x416568be, float:14.338072)
            java.lang.String r1 = "C:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r14.endReplaceableGroup()
            r14.endNode()
            r14.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0295
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0295:
            r2 = r22
            r3 = r23
        L_0x0299:
            androidx.compose.runtime.ScopeUpdateScope r7 = r14.endRestartGroup()
            if (r7 == 0) goto L_0x02b2
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9 r8 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9
            r0 = r8
            r1 = r35
            r4 = r38
            r5 = r40
            r6 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x02b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.Popup(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final void PopupTestTag(String str, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-498879600);
        ComposerKt.sourceInformation(startRestartGroup, "C(PopupTestTag)P(1)334@13923L75:AndroidPopup.android.kt#2oxthz");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:333)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) LocalPopupTestTag.provides(str), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidPopup_androidKt$PopupTestTag$1(str, function2, i));
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(1406149896);
        ComposerKt.sourceInformation(composer, "CC(SimpleStack)P(1)342@14261L979:AndroidPopup.android.kt#2oxthz");
        MeasurePolicy measurePolicy = AndroidPopup_androidKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int i2 = (((((i << 3) & 112) | ((i >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer r4 = Updater.m3282constructorimpl(composer);
        Updater.m3289setimpl(r4, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r4.getInserting() || !Intrinsics.areEqual(r4.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String str) {
        return (view instanceof PopupLayout) && (str == null || Intrinsics.areEqual((Object) str, (Object) ((PopupLayout) view).getTestTag()));
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
