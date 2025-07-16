package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.SecureFlagPolicy;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¹\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a>\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\u001e\u001a0\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\r2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010!\u001a\u00020\"H\u0003ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a-\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\"2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0\u0018H\u0007¢\u0006\u0002\u0010)\u001a\f\u0010*\u001a\u00020\"*\u00020+H\u0002\u001a\u001c\u0010,\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0003\u001a\u0014\u0010/\u001a\u00020\"*\u0002002\u0006\u00101\u001a\u00020\"H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062²\u0006\n\u00103\u001a\u00020.X\u0002²\u0006\u0015\u00104\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetPopup", "(Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "isFlagSecureEnabled", "Landroid/view/View;", "modalBottomSheetAnchors", "fullHeight", "", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3_release", "alpha", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.android.kt */
public final class ModalBottomSheet_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.window.SecureFlagPolicy[] r0 = androidx.compose.ui.window.SecureFlagPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.window.SecureFlagPolicy r1 = androidx.compose.ui.window.SecureFlagPolicy.SecureOff     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.window.SecureFlagPolicy r1 = androidx.compose.ui.window.SecureFlagPolicy.SecureOn     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.window.SecureFlagPolicy r1 = androidx.compose.ui.window.SecureFlagPolicy.Inherit     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x04fe  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0515  */
    /* JADX WARNING: Removed duplicated region for block: B:307:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0117  */
    /* renamed from: ModalBottomSheet-dYc4hso  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1982ModalBottomSheetdYc4hso(kotlin.jvm.functions.Function0<kotlin.Unit> r42, androidx.compose.ui.Modifier r43, androidx.compose.material3.SheetState r44, float r45, androidx.compose.ui.graphics.Shape r46, long r47, long r49, float r51, long r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.foundation.layout.WindowInsets r55, androidx.compose.material3.ModalBottomSheetProperties r56, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, androidx.compose.runtime.Composer r58, int r59, int r60, int r61) {
        /*
            r1 = r42
            r15 = r59
            r14 = r60
            r13 = r61
            r0 = 944867294(0x385187de, float:4.995602E-5)
            r2 = r58
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(ModalBottomSheet)P(5,4,10,9:c#ui.unit.Dp,8,0:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.unit.Dp,7:c#ui.graphics.Color,3,12,6)139@6724L31,141@6855L13,142@6918L14,143@6960L31,145@7093L10,147@7240L12,152@7505L7,153@7528L44,153@7517L55,156@7589L24,157@7653L277,166@7984L143,174@8216L350,172@8133L5284,280@13492L41,280@13465L68:ModalBottomSheet.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x001d
            r3 = r15 | 6
            goto L_0x002d
        L_0x001d:
            r3 = r15 & 6
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0029
            r3 = 4
            goto L_0x002a
        L_0x0029:
            r3 = 2
        L_0x002a:
            r3 = r3 | r15
            goto L_0x002d
        L_0x002c:
            r3 = r15
        L_0x002d:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0034
            r3 = r3 | 48
            goto L_0x0047
        L_0x0034:
            r9 = r15 & 48
            if (r9 != 0) goto L_0x0047
            r9 = r43
            boolean r10 = r2.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0043
            r10 = 32
            goto L_0x0045
        L_0x0043:
            r10 = 16
        L_0x0045:
            r3 = r3 | r10
            goto L_0x0049
        L_0x0047:
            r9 = r43
        L_0x0049:
            r10 = r15 & 384(0x180, float:5.38E-43)
            if (r10 != 0) goto L_0x0063
            r10 = r13 & 4
            if (r10 != 0) goto L_0x005c
            r10 = r44
            boolean r16 = r2.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x005e
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r10 = r44
        L_0x005e:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r3 = r3 | r16
            goto L_0x0065
        L_0x0063:
            r10 = r44
        L_0x0065:
            r16 = r13 & 8
            if (r16 == 0) goto L_0x006c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006c:
            r4 = r15 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x0080
            r4 = r45
            boolean r17 = r2.changed((float) r4)
            if (r17 == 0) goto L_0x007b
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r3 = r3 | r17
            goto L_0x0082
        L_0x0080:
            r4 = r45
        L_0x0082:
            r7 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009c
            r7 = r13 & 16
            if (r7 != 0) goto L_0x0095
            r7 = r46
            boolean r18 = r2.changed((java.lang.Object) r7)
            if (r18 == 0) goto L_0x0097
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r7 = r46
        L_0x0097:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r18
            goto L_0x009e
        L_0x009c:
            r7 = r46
        L_0x009e:
            r18 = 196608(0x30000, float:2.75506E-40)
            r18 = r15 & r18
            if (r18 != 0) goto L_0x00b8
            r18 = r13 & 32
            r8 = r47
            if (r18 != 0) goto L_0x00b3
            boolean r19 = r2.changed((long) r8)
            if (r19 == 0) goto L_0x00b3
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r19
            goto L_0x00ba
        L_0x00b8:
            r8 = r47
        L_0x00ba:
            r19 = 1572864(0x180000, float:2.204052E-39)
            r19 = r15 & r19
            if (r19 != 0) goto L_0x00d4
            r19 = r13 & 64
            r11 = r49
            if (r19 != 0) goto L_0x00cf
            boolean r21 = r2.changed((long) r11)
            if (r21 == 0) goto L_0x00cf
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r21
            goto L_0x00d6
        L_0x00d4:
            r11 = r49
        L_0x00d6:
            r5 = r13 & 128(0x80, float:1.794E-43)
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            if (r5 == 0) goto L_0x00e1
            r3 = r3 | r22
            r0 = r51
            goto L_0x00f4
        L_0x00e1:
            r22 = r15 & r22
            r0 = r51
            if (r22 != 0) goto L_0x00f4
            boolean r23 = r2.changed((float) r0)
            if (r23 == 0) goto L_0x00f0
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r23
        L_0x00f4:
            r23 = 100663296(0x6000000, float:2.4074124E-35)
            r23 = r15 & r23
            if (r23 != 0) goto L_0x010d
            r0 = r13 & 256(0x100, float:3.59E-43)
            r7 = r52
            if (r0 != 0) goto L_0x0109
            boolean r0 = r2.changed((long) r7)
            if (r0 == 0) goto L_0x0109
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010b
        L_0x0109:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010b:
            r3 = r3 | r0
            goto L_0x010f
        L_0x010d:
            r7 = r52
        L_0x010f:
            r0 = r13 & 512(0x200, float:7.175E-43)
            r9 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0117
            r3 = r3 | r9
            goto L_0x012a
        L_0x0117:
            r9 = r9 & r15
            if (r9 != 0) goto L_0x012a
            r9 = r54
            boolean r23 = r2.changedInstance(r9)
            if (r23 == 0) goto L_0x0125
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0127
        L_0x0125:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0127:
            r3 = r3 | r23
            goto L_0x012c
        L_0x012a:
            r9 = r54
        L_0x012c:
            r23 = r14 & 6
            if (r23 != 0) goto L_0x0146
            r4 = r13 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x013f
            r4 = r55
            boolean r23 = r2.changed((java.lang.Object) r4)
            if (r23 == 0) goto L_0x0141
            r23 = 4
            goto L_0x0143
        L_0x013f:
            r4 = r55
        L_0x0141:
            r23 = 2
        L_0x0143:
            r23 = r14 | r23
            goto L_0x014a
        L_0x0146:
            r4 = r55
            r23 = r14
        L_0x014a:
            r24 = r14 & 48
            if (r24 != 0) goto L_0x0164
            r4 = r13 & 2048(0x800, float:2.87E-42)
            if (r4 != 0) goto L_0x015d
            r4 = r56
            boolean r24 = r2.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x015f
            r17 = 32
            goto L_0x0161
        L_0x015d:
            r4 = r56
        L_0x015f:
            r17 = 16
        L_0x0161:
            r23 = r23 | r17
            goto L_0x0166
        L_0x0164:
            r4 = r56
        L_0x0166:
            r4 = r23
            r7 = r13 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0171
            r4 = r4 | 384(0x180, float:5.38E-43)
            r8 = r57
            goto L_0x0184
        L_0x0171:
            r7 = r14 & 384(0x180, float:5.38E-43)
            r8 = r57
            if (r7 != 0) goto L_0x0184
            boolean r7 = r2.changedInstance(r8)
            if (r7 == 0) goto L_0x0180
            r19 = 256(0x100, float:3.59E-43)
            goto L_0x0182
        L_0x0180:
            r19 = 128(0x80, float:1.794E-43)
        L_0x0182:
            r4 = r4 | r19
        L_0x0184:
            r7 = 306783379(0x12492493, float:6.34695E-28)
            r7 = r7 & r3
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r8) goto L_0x01b1
            r7 = r4 & 147(0x93, float:2.06E-43)
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L_0x01b1
            boolean r7 = r2.getSkipping()
            if (r7 != 0) goto L_0x019a
            goto L_0x01b1
        L_0x019a:
            r2.skipToGroupEnd()
            r3 = r43
            r4 = r45
            r5 = r46
            r6 = r47
            r15 = r55
            r40 = r56
            r14 = r9
            r8 = r11
            r11 = r51
            r12 = r52
            goto L_0x050f
        L_0x01b1:
            r2.startDefaults()
            r7 = r15 & 1
            r8 = 0
            if (r7 == 0) goto L_0x0209
            boolean r7 = r2.getDefaultsInvalid()
            if (r7 == 0) goto L_0x01c0
            goto L_0x0209
        L_0x01c0:
            r2.skipToGroupEnd()
            r0 = r13 & 4
            if (r0 == 0) goto L_0x01c9
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x01c9:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x01d1
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = r3 & r0
        L_0x01d1:
            r0 = r13 & 32
            if (r0 == 0) goto L_0x01d9
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r0
        L_0x01d9:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x01e1
            r0 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r0
        L_0x01e1:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01e9
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r0
        L_0x01e9:
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01ef
            r4 = r4 & -15
        L_0x01ef:
            r0 = r13 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01f5
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x01f5:
            r0 = r43
            r8 = r46
            r18 = r47
            r5 = r52
            r7 = r55
            r40 = r56
            r13 = r3
            r14 = r4
            r3 = r45
            r4 = r51
            goto L_0x02dc
        L_0x0209:
            if (r6 == 0) goto L_0x0210
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x0212
        L_0x0210:
            r6 = r43
        L_0x0212:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x021f
            r7 = 3
            r10 = 0
            androidx.compose.material3.SheetState r7 = rememberModalBottomSheetState(r8, r10, r2, r8, r7)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0220
        L_0x021f:
            r7 = r10
        L_0x0220:
            if (r16 == 0) goto L_0x0229
            androidx.compose.material3.BottomSheetDefaults r10 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r10 = r10.m1534getSheetMaxWidthD9Ej5fM()
            goto L_0x022b
        L_0x0229:
            r10 = r45
        L_0x022b:
            r16 = r13 & 16
            if (r16 == 0) goto L_0x023e
            androidx.compose.material3.BottomSheetDefaults r8 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r43 = r6
            r6 = 6
            androidx.compose.ui.graphics.Shape r8 = r8.getExpandedShape(r2, r6)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = r3 & r17
            goto L_0x0243
        L_0x023e:
            r43 = r6
            r6 = 6
            r8 = r46
        L_0x0243:
            r17 = r13 & 32
            r44 = r7
            if (r17 == 0) goto L_0x0256
            androidx.compose.material3.BottomSheetDefaults r7 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r18 = r7.getContainerColor(r2, r6)
            r6 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r6
            r6 = r18
            goto L_0x0258
        L_0x0256:
            r6 = r47
        L_0x0258:
            r18 = r13 & 64
            if (r18 == 0) goto L_0x0269
            int r11 = r3 >> 15
            r11 = r11 & 14
            long r11 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r6, r2, r11)
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r3 = r3 & r18
        L_0x0269:
            if (r5 == 0) goto L_0x0272
            androidx.compose.material3.BottomSheetDefaults r5 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r5 = r5.m1533getElevationD9Ej5fM()
            goto L_0x0274
        L_0x0272:
            r5 = r51
        L_0x0274:
            r45 = r5
            r5 = r13 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0288
            androidx.compose.material3.BottomSheetDefaults r5 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r18 = r6
            r6 = 6
            long r23 = r5.getScrimColor(r2, r6)
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r3 = r3 & r5
            goto L_0x028c
        L_0x0288:
            r18 = r6
            r23 = r52
        L_0x028c:
            if (r0 == 0) goto L_0x0295
            androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt r0 = androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m1714getLambda1$material3_release()
            goto L_0x0296
        L_0x0295:
            r0 = r9
        L_0x0296:
            r5 = r13 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x02a4
            androidx.compose.material3.BottomSheetDefaults r5 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r6 = 6
            androidx.compose.foundation.layout.WindowInsets r5 = r5.getWindowInsets(r2, r6)
            r4 = r4 & -15
            goto L_0x02a6
        L_0x02a4:
            r5 = r55
        L_0x02a6:
            r6 = r13 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x02cd
            androidx.compose.material3.ModalBottomSheetDefaults r6 = androidx.compose.material3.ModalBottomSheetDefaults.INSTANCE
            r7 = 7
            r9 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r46 = r6
            r47 = r25
            r48 = r26
            r49 = r27
            r50 = r7
            r51 = r9
            androidx.compose.material3.ModalBottomSheetProperties r6 = androidx.compose.material3.ModalBottomSheetDefaults.properties$default(r46, r47, r48, r49, r50, r51)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            r9 = r0
            r13 = r3
            r14 = r4
            r7 = r5
            r40 = r6
            goto L_0x02d3
        L_0x02cd:
            r40 = r56
            r9 = r0
            r13 = r3
            r14 = r4
            r7 = r5
        L_0x02d3:
            r3 = r10
            r5 = r23
            r0 = r43
            r10 = r44
            r4 = r45
        L_0x02dc:
            r2.endDefaults()
            boolean r23 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r23 == 0) goto L_0x02f0
            java.lang.String r15 = "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:150)"
            r49 = r7
            r7 = 944867294(0x385187de, float:4.995602E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r13, r14, r15)
            goto L_0x02f2
        L_0x02f0:
            r49 = r7
        L_0x02f2:
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r22 = r14
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r14)
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            r14 = -203430466(0xfffffffff3dfe5be, float:-3.5477964E31)
            r2.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember):ModalBottomSheet.android.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r15 = r13 & 896(0x380, float:1.256E-42)
            r15 = r15 ^ 384(0x180, float:5.38E-43)
            r50 = r9
            r9 = 256(0x100, float:3.59E-43)
            if (r15 <= r9) goto L_0x032a
            boolean r20 = r2.changed((java.lang.Object) r10)
            if (r20 != 0) goto L_0x0327
            goto L_0x032a
        L_0x0327:
            r52 = r4
            goto L_0x0330
        L_0x032a:
            r52 = r4
            r4 = r13 & 384(0x180, float:5.38E-43)
            if (r4 != r9) goto L_0x0332
        L_0x0330:
            r4 = 1
            goto L_0x0333
        L_0x0332:
            r4 = 0
        L_0x0333:
            boolean r9 = r2.changed((java.lang.Object) r7)
            r4 = r4 | r9
            java.lang.Object r9 = r2.rememberedValue()
            if (r4 != 0) goto L_0x0346
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r9 != r4) goto L_0x0351
        L_0x0346:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1 r4 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
            r4.<init>(r10, r7)
            r9 = r4
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r2.updateRememberedValue(r9)
        L_0x0351:
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r2.endReplaceableGroup()
            r4 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r9, r2, r4)
            r7 = 773894976(0x2e20b340, float:3.6538994E-11)
            r2.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r2.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            java.lang.Object r7 = r2.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r7 != r9) goto L_0x038d
            kotlin.coroutines.EmptyCoroutineContext r7 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            kotlinx.coroutines.CoroutineScope r7 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r7, r2)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r9 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r9.<init>(r7)
            r2.updateRememberedValue(r9)
            r7 = r9
        L_0x038d:
            r2.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r7 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r7
            kotlinx.coroutines.CoroutineScope r7 = r7.getCoroutineScope()
            r2.endReplaceableGroup()
            r9 = -203430341(0xfffffffff3dfe63b, float:-3.5478266E31)
            r2.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r9 = 256(0x100, float:3.59E-43)
            if (r15 <= r9) goto L_0x03ac
            boolean r16 = r2.changed((java.lang.Object) r10)
            if (r16 != 0) goto L_0x03b0
        L_0x03ac:
            r4 = r13 & 384(0x180, float:5.38E-43)
            if (r4 != r9) goto L_0x03b2
        L_0x03b0:
            r4 = 1
            goto L_0x03b3
        L_0x03b2:
            r4 = 0
        L_0x03b3:
            boolean r9 = r2.changedInstance(r7)
            r4 = r4 | r9
            r9 = r13 & 14
            r53 = r11
            r11 = 4
            if (r9 != r11) goto L_0x03c1
            r11 = 1
            goto L_0x03c2
        L_0x03c1:
            r11 = 0
        L_0x03c2:
            r4 = r4 | r11
            java.lang.Object r11 = r2.rememberedValue()
            if (r4 != 0) goto L_0x03d1
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r11 != r4) goto L_0x03dc
        L_0x03d1:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1 r4 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
            r4.<init>(r10, r7, r1)
            r11 = r4
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r2.updateRememberedValue(r11)
        L_0x03dc:
            r26 = r11
            kotlin.jvm.functions.Function0 r26 = (kotlin.jvm.functions.Function0) r26
            r2.endReplaceableGroup()
            r4 = -203430010(0xfffffffff3dfe786, float:-3.5479067E31)
            r2.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            boolean r4 = r2.changedInstance(r7)
            r11 = 256(0x100, float:3.59E-43)
            if (r15 <= r11) goto L_0x03fa
            boolean r12 = r2.changed((java.lang.Object) r10)
            if (r12 != 0) goto L_0x03fe
        L_0x03fa:
            r12 = r13 & 384(0x180, float:5.38E-43)
            if (r12 != r11) goto L_0x0400
        L_0x03fe:
            r11 = 1
            goto L_0x0401
        L_0x0400:
            r11 = 0
        L_0x0401:
            r4 = r4 | r11
            r11 = 4
            if (r9 != r11) goto L_0x0407
            r11 = 1
            goto L_0x0408
        L_0x0407:
            r11 = 0
        L_0x0408:
            r4 = r4 | r11
            java.lang.Object r11 = r2.rememberedValue()
            if (r4 != 0) goto L_0x0417
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r11 != r4) goto L_0x0422
        L_0x0417:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1 r4 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
            r4.<init>(r7, r10, r1)
            r11 = r4
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r2.updateRememberedValue(r11)
        L_0x0422:
            r30 = r11
            kotlin.jvm.functions.Function1 r30 = (kotlin.jvm.functions.Function1) r30
            r2.endReplaceableGroup()
            r4 = -203429778(0xfffffffff3dfe86e, float:-3.5479627E31)
            r2.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r4 = 256(0x100, float:3.59E-43)
            if (r15 <= r4) goto L_0x043c
            boolean r11 = r2.changed((java.lang.Object) r10)
            if (r11 != 0) goto L_0x0440
        L_0x043c:
            r11 = r13 & 384(0x180, float:5.38E-43)
            if (r11 != r4) goto L_0x0442
        L_0x0440:
            r4 = 1
            goto L_0x0443
        L_0x0442:
            r4 = 0
        L_0x0443:
            boolean r11 = r2.changedInstance(r7)
            r4 = r4 | r11
            r11 = 4
            if (r9 != r11) goto L_0x044d
            r9 = 1
            goto L_0x044e
        L_0x044d:
            r9 = 0
        L_0x044e:
            r4 = r4 | r9
            java.lang.Object r9 = r2.rememberedValue()
            if (r4 != 0) goto L_0x045d
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r9 != r4) goto L_0x0468
        L_0x045d:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1 r4 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1
            r4.<init>(r10, r7, r1)
            r9 = r4
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r2.updateRememberedValue(r9)
        L_0x0468:
            r4 = r9
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.endReplaceableGroup()
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3 r9 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3
            r23 = r9
            r24 = r5
            r27 = r10
            r28 = r0
            r29 = r3
            r31 = r8
            r32 = r18
            r34 = r53
            r36 = r52
            r37 = r50
            r38 = r7
            r39 = r57
            r23.<init>(r24, r26, r27, r28, r29, r30, r31, r32, r34, r36, r37, r38, r39)
            r7 = -1311525899(0xffffffffb1d3b3f5, float:-6.161367E-9)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r7, r11, r9)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            int r9 = r22 >> 3
            r9 = r9 & 14
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            r12 = 6
            int r11 = r22 << 6
            r11 = r11 & 896(0x380, float:1.256E-42)
            r9 = r9 | r11
            r43 = r40
            r44 = r4
            r45 = r49
            r46 = r7
            r47 = r2
            r48 = r9
            ModalBottomSheetPopup(r43, r44, r45, r46, r47, r48)
            boolean r4 = r10.getHasExpandedState()
            if (r4 == 0) goto L_0x04f8
            r4 = -203424502(0xfffffffff3dffd0a, float:-3.5492384E31)
            r2.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r4 = 256(0x100, float:3.59E-43)
            if (r15 <= r4) goto L_0x04c9
            boolean r7 = r2.changed((java.lang.Object) r10)
            if (r7 != 0) goto L_0x04cd
        L_0x04c9:
            r7 = r13 & 384(0x180, float:5.38E-43)
            if (r7 != r4) goto L_0x04d0
        L_0x04cd:
            r16 = 1
            goto L_0x04d2
        L_0x04d0:
            r16 = 0
        L_0x04d2:
            java.lang.Object r4 = r2.rememberedValue()
            if (r16 != 0) goto L_0x04e0
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r4 != r7) goto L_0x04eb
        L_0x04e0:
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$4$1 r4 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$4$1
            r7 = 0
            r4.<init>(r10, r7)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.updateRememberedValue(r4)
        L_0x04eb:
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.endReplaceableGroup()
            r7 = 6
            int r7 = r13 >> 6
            r7 = r7 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r10, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r4, (androidx.compose.runtime.Composer) r2, (int) r7)
        L_0x04f8:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0501
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0501:
            r15 = r49
            r14 = r50
            r11 = r52
            r4 = r3
            r12 = r5
            r5 = r8
            r6 = r18
            r8 = r53
            r3 = r0
        L_0x050f:
            androidx.compose.runtime.ScopeUpdateScope r2 = r2.endRestartGroup()
            if (r2 == 0) goto L_0x0539
            androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$5 r20 = new androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$5
            r0 = r20
            r1 = r42
            r41 = r2
            r2 = r3
            r3 = r10
            r10 = r11
            r11 = r12
            r13 = r14
            r14 = r15
            r15 = r40
            r16 = r57
            r17 = r59
            r18 = r60
            r19 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r41
            r1.updateScope(r0)
        L_0x0539:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m1982ModalBottomSheetdYc4hso(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.ModalBottomSheetProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1261794383);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(1)363@16906L69:ModalBottomSheet.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            function1 = ModalBottomSheet_androidKt$rememberModalBottomSheetState$1.INSTANCE;
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:363)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(z2, function12, SheetValue.Hidden, false, composer, (i & 14) | 384 | (i & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m1983Scrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        long j2 = j;
        Function0<Unit> function02 = function0;
        boolean z2 = z;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1053897700);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)372@17135L121,391@17696L62,387@17590L168:ModalBottomSheet.android.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed(j2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        int i4 = i2;
        if ((i4 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053897700, i4, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:370)");
            }
            if (j2 != Color.Companion.m3852getUnspecified0d7_KjU()) {
                int i5 = i4;
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (String) null, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 28);
                startRestartGroup.startReplaceableGroup(-1858718943);
                ComposerKt.sourceInformation(startRestartGroup, "378@17368L124");
                boolean z3 = true;
                if (z2) {
                    Modifier modifier2 = Modifier.Companion;
                    startRestartGroup.startReplaceableGroup(-1858718859);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    boolean z4 = (i5 & 112) == 32;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(function02, (Continuation<? super ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function02, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue), ModalBottomSheet_androidKt$Scrim$dismissSheet$2.INSTANCE);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
                startRestartGroup.startReplaceableGroup(-1858718531);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                if ((i5 & 14) != 4) {
                    z3 = false;
                }
                boolean changed = startRestartGroup.changed((Object) animateFloatAsState) | z3;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new ModalBottomSheet_androidKt$Scrim$1$1(j2, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue2, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheet_androidKt$Scrim$2(j, function0, z, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier modalBottomSheetAnchors(Modifier modifier, SheetState sheetState, float f) {
        return OnRemeasuredModifierKt.onSizeChanged(modifier, new ModalBottomSheet_androidKt$modalBottomSheetAnchors$1(sheetState, f));
    }

    public static final void ModalBottomSheetPopup(ModalBottomSheetProperties modalBottomSheetProperties, Function0<Unit> function0, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        ModalBottomSheetProperties modalBottomSheetProperties2 = modalBottomSheetProperties;
        Function0<Unit> function02 = function0;
        WindowInsets windowInsets2 = windowInsets;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(738805080);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheetPopup)P(2,1,3)437@19070L7,438@19091L38,439@19158L28,440@19213L29,441@19290L7,442@19331L941,470@20319L248,470@20278L289:ModalBottomSheet.android.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modalBottomSheetProperties2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changed((Object) windowInsets2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        int i4 = i2;
        if ((i4 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(738805080, i4, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:436)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume;
            UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1.INSTANCE, startRestartGroup, 3072, 6);
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function22, startRestartGroup, (i4 >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            startRestartGroup.startReplaceableGroup(173201889);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            ModalBottomSheetWindow modalBottomSheetWindow = rememberedValue;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                ModalBottomSheetWindow modalBottomSheetWindow2 = new ModalBottomSheetWindow(modalBottomSheetProperties2, function02, view, uuid);
                modalBottomSheetWindow2.setCustomContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-114385661, true, new ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1(windowInsets2, rememberUpdatedState)));
                startRestartGroup.updateRememberedValue(modalBottomSheetWindow2);
                modalBottomSheetWindow = modalBottomSheetWindow2;
            }
            ModalBottomSheetWindow modalBottomSheetWindow3 = (ModalBottomSheetWindow) modalBottomSheetWindow;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(173202877);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(modalBottomSheetWindow3) | startRestartGroup.changed((Object) layoutDirection);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1(modalBottomSheetWindow3, layoutDirection);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect((Object) modalBottomSheetWindow3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheetPopup$2(modalBottomSheetProperties, function0, windowInsets, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetPopup$lambda$8(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
