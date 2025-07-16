package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u001az\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ao\u0010&\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001ao\u0010)\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010(\u001ao\u0010+\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ExtendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "ExtendedFabEndIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "ExtendedFabMinimumWidth", "ExtendedFabStartIconPadding", "ExtendedFabTextPadding", "ExtendedFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public final class FloatingActionButtonKt {
    /* access modifiers changed from: private */
    public static final ExitTransition ExtendedFabCollapseAnimation = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, MotionTokens.INSTANCE.getEasingLinearCubicBezier(), 2, (Object) null), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.shrinkHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, (Object) null), Alignment.Companion.getStart(), false, (Function1) null, 12, (Object) null));
    /* access modifiers changed from: private */
    public static final float ExtendedFabEndIconPadding = Dp.m6614constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final EnterTransition ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 100, MotionTokens.INSTANCE.getEasingLinearCubicBezier()), 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, (Object) null), Alignment.Companion.getStart(), false, (Function1) null, 12, (Object) null));
    /* access modifiers changed from: private */
    public static final float ExtendedFabMinimumWidth = Dp.m6614constructorimpl((float) 80);
    /* access modifiers changed from: private */
    public static final float ExtendedFabStartIconPadding = Dp.m6614constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final float ExtendedFabTextPadding = Dp.m6614constructorimpl((float) 20);

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010c  */
    /* renamed from: FloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1882FloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, androidx.compose.ui.graphics.Shape r32, long r33, long r35, androidx.compose.material3.FloatingActionButtonElevation r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r10 = r39
            r11 = r41
            r12 = r42
            r0 = -731723913(0xffffffffd462c777, float:-3.89603629E12)
            r1 = r40
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)96@4769L5,97@4833L14,98@4875L31,99@4984L11,100@5047L39,110@5412L54,103@5133L933:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r11 | 6
            r13 = r30
            goto L_0x002f
        L_0x001d:
            r1 = r11 & 6
            r13 = r30
            if (r1 != 0) goto L_0x002e
            boolean r1 = r9.changedInstance(r13)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r11
            goto L_0x002f
        L_0x002e:
            r1 = r11
        L_0x002f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0049
        L_0x0036:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0049
            r3 = r31
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
            goto L_0x004b
        L_0x0049:
            r3 = r31
        L_0x004b:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0064
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005e
            r4 = r32
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0060
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r4 = r32
        L_0x0060:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r5
            goto L_0x0066
        L_0x0064:
            r4 = r32
        L_0x0066:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007f
            r5 = r12 & 8
            if (r5 != 0) goto L_0x0079
            r5 = r33
            boolean r7 = r9.changed((long) r5)
            if (r7 == 0) goto L_0x007b
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x0079:
            r5 = r33
        L_0x007b:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r7
            goto L_0x0081
        L_0x007f:
            r5 = r33
        L_0x0081:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r12 & 16
            if (r7 != 0) goto L_0x0094
            r7 = r35
            boolean r14 = r9.changed((long) r7)
            if (r14 == 0) goto L_0x0096
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r7 = r35
        L_0x0096:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r14
            goto L_0x009c
        L_0x009a:
            r7 = r35
        L_0x009c:
            r14 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00b6
            r14 = r12 & 32
            if (r14 != 0) goto L_0x00b0
            r14 = r37
            boolean r15 = r9.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r14 = r37
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r37
        L_0x00b8:
            r15 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c3
            r1 = r1 | r16
            r0 = r38
            goto L_0x00d6
        L_0x00c3:
            r16 = r11 & r16
            r0 = r38
            if (r16 != 0) goto L_0x00d6
            boolean r17 = r9.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d2
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r1 = r1 | r17
        L_0x00d6:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00df
            r1 = r1 | r17
            goto L_0x00ef
        L_0x00df:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00ef
            boolean r0 = r9.changedInstance(r10)
            if (r0 == 0) goto L_0x00ec
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r1 = r1 | r0
        L_0x00ef:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x010c
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x00ff
            goto L_0x010c
        L_0x00ff:
            r9.skipToGroupEnd()
            r2 = r31
            r11 = r38
            r3 = r4
            r4 = r5
            r6 = r7
            r8 = r14
            goto L_0x025a
        L_0x010c:
            r9.startDefaults()
            r0 = r11 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0142
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0120
            goto L_0x0142
        L_0x0120:
            r9.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0129
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0129:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x012f
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x012f:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0134
            r1 = r1 & r3
        L_0x0134:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013a
            r1 = r1 & r17
        L_0x013a:
            r0 = r31
            r2 = r38
            r3 = r1
            r1 = r14
            goto L_0x01d2
        L_0x0142:
            if (r2 == 0) goto L_0x0149
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x014b
        L_0x0149:
            r0 = r31
        L_0x014b:
            r2 = r12 & 4
            r3 = 6
            if (r2 == 0) goto L_0x015b
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r9, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r18 = r2
            goto L_0x015d
        L_0x015b:
            r18 = r4
        L_0x015d:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x016a
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r2.getContainerColor(r9, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r5 = r2
        L_0x016a:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x017f
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r5, r9, r2)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
            r21 = r1
            r19 = r2
            goto L_0x0183
        L_0x017f:
            r21 = r1
            r19 = r7
        L_0x0183:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x019e
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r2 = 0
            r3 = 0
            r4 = 0
            r14 = 0
            r22 = r5
            r5 = r14
            r6 = r9
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m1874elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r21 & r17
            r14 = r1
            r1 = r2
            goto L_0x01a2
        L_0x019e:
            r22 = r5
            r1 = r21
        L_0x01a2:
            if (r15 == 0) goto L_0x01c8
            r2 = 2094975814(0x7cdecb46, float:9.254502E36)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):FloatingActionButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            java.lang.Object r2 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x01c2
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r2)
        L_0x01c2:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r9.endReplaceableGroup()
            goto L_0x01ca
        L_0x01c8:
            r2 = r38
        L_0x01ca:
            r3 = r1
            r1 = r14
            r4 = r18
            r7 = r19
            r5 = r22
        L_0x01d2:
            r9.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x01e4
            r14 = -1
            java.lang.String r15 = "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:102)"
            r11 = -731723913(0xffffffffd462c777, float:-3.89603629E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r3, r14, r15)
        L_0x01e4:
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2 r11 = androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2.INSTANCE
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r14 = 0
            r15 = 0
            r12 = 1
            androidx.compose.ui.Modifier r14 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r15, r11, r12, r14)
            float r21 = r1.m1877tonalElevationD9Ej5fM$material3_release()
            r11 = r2
            androidx.compose.foundation.interaction.InteractionSource r11 = (androidx.compose.foundation.interaction.InteractionSource) r11
            int r15 = r3 >> 18
            r15 = r15 & 14
            int r16 = r3 >> 12
            r16 = r16 & 112(0x70, float:1.57E-43)
            r15 = r15 | r16
            androidx.compose.runtime.State r11 = r1.shadowElevation$material3_release(r11, r9, r15)
            java.lang.Object r11 = r11.getValue()
            androidx.compose.ui.unit.Dp r11 = (androidx.compose.ui.unit.Dp) r11
            float r22 = r11.m6628unboximpl()
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3 r11 = new androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
            r11.<init>(r7, r10)
            r15 = 1249316354(0x4a770e02, float:4047744.5)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r15, r12, r11)
            r25 = r11
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r11 = r3 & 14
            int r12 = r3 << 3
            r15 = r12 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r12
            r11 = r11 | r15
            r15 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            r11 = r11 | r12
            r12 = 1879048192(0x70000000, float:1.58456325E29)
            int r3 = r3 << 9
            r3 = r3 & r12
            r27 = r11 | r3
            r28 = 6
            r29 = 260(0x104, float:3.64E-43)
            r15 = 0
            r23 = 0
            r13 = r30
            r16 = r4
            r17 = r5
            r19 = r7
            r24 = r2
            r26 = r9
            androidx.compose.material3.SurfaceKt.m2306Surfaceo_FOJdg(r13, r14, r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0254
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0254:
            r11 = r2
            r3 = r4
            r4 = r5
            r6 = r7
            r2 = r0
            r8 = r1
        L_0x025a:
            androidx.compose.runtime.ScopeUpdateScope r13 = r9.endRestartGroup()
            if (r13 == 0) goto L_0x0274
            androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$4 r14 = new androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$4
            r0 = r14
            r1 = r30
            r9 = r11
            r10 = r39
            r11 = r41
            r12 = r42
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0274:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1882FloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:144:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x010e  */
    /* renamed from: SmallFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1884SmallFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.graphics.Shape r28, long r29, long r31, androidx.compose.material3.FloatingActionButtonElevation r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r11 = r37
            r12 = r38
            r0 = 1444748300(0x561d1c0c, float:4.3185946E13)
            r1 = r36
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SmallFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)159@7912L10,160@7981L14,161@8023L31,162@8132L11,163@8195L39,166@8281L431:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r10 = r26
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r10 = r26
            if (r1 != 0) goto L_0x002c
            boolean r1 = r9.changedInstance(r10)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0047
        L_0x0034:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0047
            r3 = r27
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r27
        L_0x0049:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005c
            r4 = r28
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r4 = r28
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r28
        L_0x0064:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007d
            r5 = r12 & 8
            if (r5 != 0) goto L_0x0077
            r5 = r29
            boolean r7 = r9.changed((long) r5)
            if (r7 == 0) goto L_0x0079
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r5 = r29
        L_0x0079:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r7
            goto L_0x007f
        L_0x007d:
            r5 = r29
        L_0x007f:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0098
            r7 = r12 & 16
            if (r7 != 0) goto L_0x0092
            r7 = r31
            boolean r13 = r9.changed((long) r7)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r7 = r31
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r13
            goto L_0x009a
        L_0x0098:
            r7 = r31
        L_0x009a:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00b4
            r13 = r12 & 32
            if (r13 != 0) goto L_0x00ae
            r13 = r33
            boolean r14 = r9.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r13 = r33
        L_0x00b0:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r1 = r1 | r14
            goto L_0x00b6
        L_0x00b4:
            r13 = r33
        L_0x00b6:
            r14 = r12 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00be
            r1 = r1 | r15
            goto L_0x00d1
        L_0x00be:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00d1
            r15 = r34
            boolean r16 = r9.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00cc
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r1 = r1 | r16
            goto L_0x00d3
        L_0x00d1:
            r15 = r34
        L_0x00d3:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00dc
            r1 = r1 | r17
            goto L_0x00f0
        L_0x00dc:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00f0
            r0 = r35
            boolean r17 = r9.changedInstance(r0)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r1 = r1 | r17
            goto L_0x00f2
        L_0x00f0:
            r0 = r35
        L_0x00f2:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r1 & r17
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x010e
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0103
            goto L_0x010e
        L_0x0103:
            r9.skipToGroupEnd()
            r2 = r27
            r3 = r4
            r4 = r5
            r6 = r7
            r8 = r13
            goto L_0x0234
        L_0x010e:
            r9.startDefaults()
            r0 = r11 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0143
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0122
            goto L_0x0143
        L_0x0122:
            r9.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x012b
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012b:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0131
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0131:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0136
            r1 = r1 & r3
        L_0x0136:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013c
            r1 = r1 & r17
        L_0x013c:
            r0 = r27
            r3 = r1
            r1 = r13
            r2 = r15
            goto L_0x01d4
        L_0x0143:
            if (r2 == 0) goto L_0x014a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x014c
        L_0x014a:
            r0 = r27
        L_0x014c:
            r2 = r12 & 4
            r3 = 6
            if (r2 == 0) goto L_0x015c
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getSmallShape(r9, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r18 = r2
            goto L_0x015e
        L_0x015c:
            r18 = r4
        L_0x015e:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x016b
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r2.getContainerColor(r9, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r5 = r2
        L_0x016b:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x0180
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r5, r9, r2)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
            r21 = r1
            r19 = r2
            goto L_0x0184
        L_0x0180:
            r21 = r1
            r19 = r7
        L_0x0184:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x019f
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r2 = 0
            r3 = 0
            r4 = 0
            r13 = 0
            r22 = r5
            r5 = r13
            r6 = r9
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m1874elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r21 & r17
            r13 = r1
            r1 = r2
            goto L_0x01a3
        L_0x019f:
            r22 = r5
            r1 = r21
        L_0x01a3:
            if (r14 == 0) goto L_0x01cb
            r2 = 585135857(0x22e076f1, float:6.0841256E-18)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):FloatingActionButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            java.lang.Object r2 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x01c3
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r2)
        L_0x01c3:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r9.endReplaceableGroup()
            r3 = r1
            r1 = r13
            goto L_0x01ce
        L_0x01cb:
            r3 = r1
            r1 = r13
            r2 = r15
        L_0x01ce:
            r4 = r18
            r7 = r19
            r5 = r22
        L_0x01d4:
            r9.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01e6
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:165)"
            r15 = 1444748300(0x561d1c0c, float:4.3185946E13)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r3, r13, r14)
        L_0x01e6:
            androidx.compose.material3.tokens.FabPrimarySmallTokens r13 = androidx.compose.material3.tokens.FabPrimarySmallTokens.INSTANCE
            float r13 = r13.m2846getContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.FabPrimarySmallTokens r14 = androidx.compose.material3.tokens.FabPrimarySmallTokens.INSTANCE
            float r14 = r14.m2845getContainerHeightD9Ej5fM()
            r15 = 12
            r16 = 0
            r17 = 0
            r18 = 0
            r27 = r0
            r28 = r13
            r29 = r14
            r30 = r17
            r31 = r18
            r32 = r15
            r33 = r16
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.m746sizeInqDBjuR0$default(r27, r28, r29, r30, r31, r32, r33)
            r13 = 33554318(0x1ffff8e, float:9.403891E-38)
            r24 = r3 & r13
            r25 = 0
            r13 = r26
            r15 = r4
            r16 = r5
            r18 = r7
            r20 = r1
            r21 = r2
            r22 = r35
            r23 = r9
            m1882FloatingActionButtonXz6DiA(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x022e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022e:
            r15 = r2
            r3 = r4
            r4 = r5
            r6 = r7
            r2 = r0
            r8 = r1
        L_0x0234:
            androidx.compose.runtime.ScopeUpdateScope r13 = r9.endRestartGroup()
            if (r13 == 0) goto L_0x024e
            androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$2 r14 = new androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$2
            r0 = r14
            r1 = r26
            r9 = r15
            r10 = r35
            r11 = r37
            r12 = r38
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x024e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1884SmallFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:144:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x010e  */
    /* renamed from: LargeFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1883LargeFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.graphics.Shape r28, long r29, long r31, androidx.compose.material3.FloatingActionButtonElevation r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r11 = r37
            r12 = r38
            r0 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            r1 = r36
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LargeFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)211@10558L10,212@10627L14,213@10669L31,214@10778L11,215@10841L39,218@10927L431:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r10 = r26
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r10 = r26
            if (r1 != 0) goto L_0x002c
            boolean r1 = r9.changedInstance(r10)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0047
        L_0x0034:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0047
            r3 = r27
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0043
            r4 = 32
            goto L_0x0045
        L_0x0043:
            r4 = 16
        L_0x0045:
            r1 = r1 | r4
            goto L_0x0049
        L_0x0047:
            r3 = r27
        L_0x0049:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0062
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005c
            r4 = r28
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r4 = r28
        L_0x005e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r5
            goto L_0x0064
        L_0x0062:
            r4 = r28
        L_0x0064:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007d
            r5 = r12 & 8
            if (r5 != 0) goto L_0x0077
            r5 = r29
            boolean r7 = r9.changed((long) r5)
            if (r7 == 0) goto L_0x0079
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r5 = r29
        L_0x0079:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r7
            goto L_0x007f
        L_0x007d:
            r5 = r29
        L_0x007f:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x0098
            r7 = r12 & 16
            if (r7 != 0) goto L_0x0092
            r7 = r31
            boolean r13 = r9.changed((long) r7)
            if (r13 == 0) goto L_0x0094
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r7 = r31
        L_0x0094:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r13
            goto L_0x009a
        L_0x0098:
            r7 = r31
        L_0x009a:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00b4
            r13 = r12 & 32
            if (r13 != 0) goto L_0x00ae
            r13 = r33
            boolean r14 = r9.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r13 = r33
        L_0x00b0:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r1 = r1 | r14
            goto L_0x00b6
        L_0x00b4:
            r13 = r33
        L_0x00b6:
            r14 = r12 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00be
            r1 = r1 | r15
            goto L_0x00d1
        L_0x00be:
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00d1
            r15 = r34
            boolean r16 = r9.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00cc
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r1 = r1 | r16
            goto L_0x00d3
        L_0x00d1:
            r15 = r34
        L_0x00d3:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00dc
            r1 = r1 | r17
            goto L_0x00f0
        L_0x00dc:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00f0
            r0 = r35
            boolean r17 = r9.changedInstance(r0)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r1 = r1 | r17
            goto L_0x00f2
        L_0x00f0:
            r0 = r35
        L_0x00f2:
            r17 = 4793491(0x492493, float:6.717112E-39)
            r0 = r1 & r17
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x010e
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0103
            goto L_0x010e
        L_0x0103:
            r9.skipToGroupEnd()
            r2 = r27
            r3 = r4
            r4 = r5
            r6 = r7
            r8 = r13
            goto L_0x0234
        L_0x010e:
            r9.startDefaults()
            r0 = r11 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0143
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0122
            goto L_0x0143
        L_0x0122:
            r9.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x012b
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x012b:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0131
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0131:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0136
            r1 = r1 & r3
        L_0x0136:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013c
            r1 = r1 & r17
        L_0x013c:
            r0 = r27
            r3 = r1
            r1 = r13
            r2 = r15
            goto L_0x01d4
        L_0x0143:
            if (r2 == 0) goto L_0x014a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x014c
        L_0x014a:
            r0 = r27
        L_0x014c:
            r2 = r12 & 4
            r3 = 6
            if (r2 == 0) goto L_0x015c
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getLargeShape(r9, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r18 = r2
            goto L_0x015e
        L_0x015c:
            r18 = r4
        L_0x015e:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x016b
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r2.getContainerColor(r9, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r5 = r2
        L_0x016b:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x0180
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r5, r9, r2)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
            r21 = r1
            r19 = r2
            goto L_0x0184
        L_0x0180:
            r21 = r1
            r19 = r7
        L_0x0184:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x019f
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r2 = 0
            r3 = 0
            r4 = 0
            r13 = 0
            r22 = r5
            r5 = r13
            r6 = r9
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m1874elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r21 & r17
            r13 = r1
            r1 = r2
            goto L_0x01a3
        L_0x019f:
            r22 = r5
            r1 = r21
        L_0x01a3:
            if (r14 == 0) goto L_0x01cb
            r2 = 2133197715(0x7f260393, float:2.206704E38)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):FloatingActionButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            java.lang.Object r2 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x01c3
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r2)
        L_0x01c3:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r9.endReplaceableGroup()
            r3 = r1
            r1 = r13
            goto L_0x01ce
        L_0x01cb:
            r3 = r1
            r1 = r13
            r2 = r15
        L_0x01ce:
            r4 = r18
            r7 = r19
            r5 = r22
        L_0x01d4:
            r9.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01e6
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:217)"
            r15 = -1650866856(0xffffffff9d99c558, float:-4.070281E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r3, r13, r14)
        L_0x01e6:
            androidx.compose.material3.tokens.FabPrimaryLargeTokens r13 = androidx.compose.material3.tokens.FabPrimaryLargeTokens.INSTANCE
            float r13 = r13.m2835getContainerWidthD9Ej5fM()
            androidx.compose.material3.tokens.FabPrimaryLargeTokens r14 = androidx.compose.material3.tokens.FabPrimaryLargeTokens.INSTANCE
            float r14 = r14.m2834getContainerHeightD9Ej5fM()
            r15 = 12
            r16 = 0
            r17 = 0
            r18 = 0
            r27 = r0
            r28 = r13
            r29 = r14
            r30 = r17
            r31 = r18
            r32 = r15
            r33 = r16
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.m746sizeInqDBjuR0$default(r27, r28, r29, r30, r31, r32, r33)
            r13 = 33554318(0x1ffff8e, float:9.403891E-38)
            r24 = r3 & r13
            r25 = 0
            r13 = r26
            r15 = r4
            r16 = r5
            r18 = r7
            r20 = r1
            r21 = r2
            r22 = r35
            r23 = r9
            m1882FloatingActionButtonXz6DiA(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x022e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022e:
            r15 = r2
            r3 = r4
            r4 = r5
            r6 = r7
            r2 = r0
            r8 = r1
        L_0x0234:
            androidx.compose.runtime.ScopeUpdateScope r13 = r9.endRestartGroup()
            if (r13 == 0) goto L_0x024e
            androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$2 r14 = new androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$2
            r0 = r14
            r1 = r26
            r9 = r15
            r10 = r35
            r11 = r37
            r12 = r38
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x024e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1883LargeFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010c  */
    /* renamed from: ExtendedFloatingActionButton-X-z6DiA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1881ExtendedFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.graphics.Shape r28, long r29, long r31, androidx.compose.material3.FloatingActionButtonElevation r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r10 = r35
            r11 = r37
            r12 = r38
            r0 = -326283107(0xffffffffec8d509d, float:-1.3667138E27)
            r1 = r36
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExtendedFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)266@13342L16,267@13417L14,268@13459L31,269@13568L11,270@13631L39,273@13726L595:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r11 | 6
            r15 = r26
            goto L_0x002f
        L_0x001d:
            r1 = r11 & 6
            r15 = r26
            if (r1 != 0) goto L_0x002e
            boolean r1 = r9.changedInstance(r15)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r11
            goto L_0x002f
        L_0x002e:
            r1 = r11
        L_0x002f:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0049
        L_0x0036:
            r3 = r11 & 48
            if (r3 != 0) goto L_0x0049
            r3 = r27
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
            goto L_0x004b
        L_0x0049:
            r3 = r27
        L_0x004b:
            r4 = r11 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0064
            r4 = r12 & 4
            if (r4 != 0) goto L_0x005e
            r4 = r28
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0060
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r4 = r28
        L_0x0060:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r5
            goto L_0x0066
        L_0x0064:
            r4 = r28
        L_0x0066:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007f
            r5 = r12 & 8
            if (r5 != 0) goto L_0x0079
            r5 = r29
            boolean r7 = r9.changed((long) r5)
            if (r7 == 0) goto L_0x007b
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x0079:
            r5 = r29
        L_0x007b:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r7
            goto L_0x0081
        L_0x007f:
            r5 = r29
        L_0x0081:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r12 & 16
            if (r7 != 0) goto L_0x0094
            r7 = r31
            boolean r13 = r9.changed((long) r7)
            if (r13 == 0) goto L_0x0096
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r7 = r31
        L_0x0096:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r13
            goto L_0x009c
        L_0x009a:
            r7 = r31
        L_0x009c:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00b6
            r13 = r12 & 32
            if (r13 != 0) goto L_0x00b0
            r13 = r33
            boolean r14 = r9.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b2
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r13 = r33
        L_0x00b2:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r14
            goto L_0x00b8
        L_0x00b6:
            r13 = r33
        L_0x00b8:
            r14 = r12 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c3
            r1 = r1 | r16
            r0 = r34
            goto L_0x00d6
        L_0x00c3:
            r16 = r11 & r16
            r0 = r34
            if (r16 != 0) goto L_0x00d6
            boolean r17 = r9.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00d2
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r1 = r1 | r17
        L_0x00d6:
            r0 = r12 & 128(0x80, float:1.794E-43)
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            if (r0 == 0) goto L_0x00df
            r1 = r1 | r17
            goto L_0x00ef
        L_0x00df:
            r0 = r11 & r17
            if (r0 != 0) goto L_0x00ef
            boolean r0 = r9.changedInstance(r10)
            if (r0 == 0) goto L_0x00ec
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00ec:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ee:
            r1 = r1 | r0
        L_0x00ef:
            r0 = 4793491(0x492493, float:6.717112E-39)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x010c
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x00ff
            goto L_0x010c
        L_0x00ff:
            r9.skipToGroupEnd()
            r2 = r27
            r11 = r34
            r3 = r4
            r4 = r5
            r6 = r7
            r8 = r13
            goto L_0x0232
        L_0x010c:
            r9.startDefaults()
            r0 = r11 & 1
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0142
            boolean r0 = r9.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0120
            goto L_0x0142
        L_0x0120:
            r9.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0129
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0129:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x012f
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x012f:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0134
            r1 = r1 & r3
        L_0x0134:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x013a
            r1 = r1 & r18
        L_0x013a:
            r0 = r27
            r2 = r34
            r3 = r1
            r1 = r13
            goto L_0x01d2
        L_0x0142:
            if (r2 == 0) goto L_0x0149
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x014b
        L_0x0149:
            r0 = r27
        L_0x014b:
            r2 = r12 & 4
            r3 = 6
            if (r2 == 0) goto L_0x015b
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getExtendedFabShape(r9, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r19 = r2
            goto L_0x015d
        L_0x015b:
            r19 = r4
        L_0x015d:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x016a
            androidx.compose.material3.FloatingActionButtonDefaults r2 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r2 = r2.getContainerColor(r9, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r5 = r2
        L_0x016a:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x017f
            int r2 = r1 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r5, r9, r2)
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            r1 = r1 & r4
            r22 = r1
            r20 = r2
            goto L_0x0183
        L_0x017f:
            r22 = r1
            r20 = r7
        L_0x0183:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x019e
            androidx.compose.material3.FloatingActionButtonDefaults r1 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r7 = 24576(0x6000, float:3.4438E-41)
            r8 = 15
            r2 = 0
            r3 = 0
            r4 = 0
            r13 = 0
            r23 = r5
            r5 = r13
            r6 = r9
            androidx.compose.material3.FloatingActionButtonElevation r1 = r1.m1874elevationxZ9QkE(r2, r3, r4, r5, r6, r7, r8)
            r2 = r22 & r18
            r13 = r1
            r1 = r2
            goto L_0x01a2
        L_0x019e:
            r23 = r5
            r1 = r22
        L_0x01a2:
            if (r14 == 0) goto L_0x01c8
            r2 = -2039336939(0xffffffff86723015, float:-4.5550466E-35)
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):FloatingActionButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            java.lang.Object r2 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x01c2
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r2)
        L_0x01c2:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r9.endReplaceableGroup()
            goto L_0x01ca
        L_0x01c8:
            r2 = r34
        L_0x01ca:
            r3 = r1
            r1 = r13
            r4 = r19
            r7 = r20
            r5 = r23
        L_0x01d2:
            r9.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01e4
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:272)"
            r11 = -326283107(0xffffffffec8d509d, float:-1.3667138E27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r3, r13, r14)
        L_0x01e4:
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2 r11 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2
            r11.<init>(r10)
            r13 = 398457247(0x17bff99f, float:1.2406099E-24)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r13, r14, r11)
            r22 = r11
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            r11 = r3 & 14
            r11 = r11 | r17
            r13 = r3 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            r13 = r3 & 896(0x380, float:1.256E-42)
            r11 = r11 | r13
            r13 = r3 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r3
            r11 = r11 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r3
            r11 = r11 | r13
            r13 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r13
            r24 = r11 | r3
            r25 = 0
            r13 = r26
            r14 = r0
            r15 = r4
            r16 = r5
            r18 = r7
            r20 = r1
            r21 = r2
            r23 = r9
            m1882FloatingActionButtonXz6DiA(r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x022c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x022c:
            r11 = r2
            r3 = r4
            r4 = r5
            r6 = r7
            r2 = r0
            r8 = r1
        L_0x0232:
            androidx.compose.runtime.ScopeUpdateScope r13 = r9.endRestartGroup()
            if (r13 == 0) goto L_0x024c
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3 r14 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3
            r0 = r14
            r1 = r26
            r9 = r11
            r10 = r35
            r11 = r37
            r12 = r38
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x024c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1881ExtendedFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0110  */
    /* renamed from: ExtendedFloatingActionButton-ElI5-7k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1880ExtendedFloatingActionButtonElI57k(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.ui.graphics.Shape r33, long r34, long r36, androidx.compose.material3.FloatingActionButtonElevation r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r1 = r28
            r2 = r29
            r13 = r41
            r14 = r42
            r0 = -1387401842(0xffffffffad4ded8e, float:-1.1705649E-11)
            r3 = r40
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(ExtendedFloatingActionButton)P(9,4,7,6,3,8,0:c#ui.graphics.Color,1:c#ui.graphics.Color)336@16884L16,337@16959L14,338@17001L31,339@17110L11,340@17173L39,342@17222L1269:FloatingActionButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r14 & 1
            if (r4 == 0) goto L_0x001d
            r4 = r13 | 6
            goto L_0x002d
        L_0x001d:
            r4 = r13 & 6
            if (r4 != 0) goto L_0x002c
            boolean r4 = r3.changedInstance(r1)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r13
            goto L_0x002d
        L_0x002c:
            r4 = r13
        L_0x002d:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0034
            r4 = r4 | 48
            goto L_0x0044
        L_0x0034:
            r5 = r13 & 48
            if (r5 != 0) goto L_0x0044
            boolean r5 = r3.changedInstance(r2)
            if (r5 == 0) goto L_0x0041
            r5 = 32
            goto L_0x0043
        L_0x0041:
            r5 = 16
        L_0x0043:
            r4 = r4 | r5
        L_0x0044:
            r5 = r14 & 4
            if (r5 == 0) goto L_0x004b
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r5 = r13 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x005e
            r5 = r30
            boolean r6 = r3.changedInstance(r5)
            if (r6 == 0) goto L_0x005a
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r4 = r4 | r6
            goto L_0x0060
        L_0x005e:
            r5 = r30
        L_0x0060:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r7 = r13 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007a
            r7 = r31
            boolean r8 = r3.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0076
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r8
            goto L_0x007c
        L_0x007a:
            r7 = r31
        L_0x007c:
            r8 = r14 & 16
            if (r8 == 0) goto L_0x0083
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0096
        L_0x0083:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x0096
            r9 = r32
            boolean r10 = r3.changed((boolean) r9)
            if (r10 == 0) goto L_0x0092
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0092:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r4 = r4 | r10
            goto L_0x0098
        L_0x0096:
            r9 = r32
        L_0x0098:
            r10 = 196608(0x30000, float:2.75506E-40)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00b2
            r10 = r14 & 32
            if (r10 != 0) goto L_0x00ac
            r10 = r33
            boolean r11 = r3.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x00ae
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ac:
            r10 = r33
        L_0x00ae:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r4 = r4 | r11
            goto L_0x00b4
        L_0x00b2:
            r10 = r33
        L_0x00b4:
            r11 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 & r13
            if (r11 != 0) goto L_0x00ce
            r11 = r14 & 64
            if (r11 != 0) goto L_0x00c8
            r11 = r34
            boolean r15 = r3.changed((long) r11)
            if (r15 == 0) goto L_0x00ca
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00c8:
            r11 = r34
        L_0x00ca:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r4 = r4 | r15
            goto L_0x00d0
        L_0x00ce:
            r11 = r34
        L_0x00d0:
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = r13 & r15
            if (r16 != 0) goto L_0x00ea
            r15 = r14 & 128(0x80, float:1.794E-43)
            r0 = r36
            if (r15 != 0) goto L_0x00e5
            boolean r16 = r3.changed((long) r0)
            if (r16 == 0) goto L_0x00e5
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e7
        L_0x00e5:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e7:
            r4 = r4 | r16
            goto L_0x00ec
        L_0x00ea:
            r0 = r36
        L_0x00ec:
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0108
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 != 0) goto L_0x0101
            r15 = r38
            boolean r17 = r3.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x0103
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0105
        L_0x0101:
            r15 = r38
        L_0x0103:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0105:
            r4 = r4 | r17
            goto L_0x010a
        L_0x0108:
            r15 = r38
        L_0x010a:
            r0 = r14 & 512(0x200, float:7.175E-43)
            r1 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0112
            r4 = r4 | r1
            goto L_0x0125
        L_0x0112:
            r1 = r1 & r13
            if (r1 != 0) goto L_0x0125
            r1 = r39
            boolean r17 = r3.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x0120
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0122
        L_0x0120:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0122:
            r4 = r4 | r17
            goto L_0x0127
        L_0x0125:
            r1 = r39
        L_0x0127:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r1 = r4 & r17
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r5) goto L_0x0148
            boolean r1 = r3.getSkipping()
            if (r1 != 0) goto L_0x0138
            goto L_0x0148
        L_0x0138:
            r3.skipToGroupEnd()
            r13 = r28
            r4 = r7
            r5 = r9
            r6 = r10
            r7 = r11
            r11 = r15
            r9 = r36
            r12 = r39
            goto L_0x027b
        L_0x0148:
            r3.startDefaults()
            r1 = r13 & 1
            r17 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r1 == 0) goto L_0x0186
            boolean r1 = r3.getDefaultsInvalid()
            if (r1 == 0) goto L_0x015f
            goto L_0x0186
        L_0x015f:
            r3.skipToGroupEnd()
            r0 = r14 & 32
            if (r0 == 0) goto L_0x0168
            r4 = r4 & r19
        L_0x0168:
            r0 = r14 & 64
            if (r0 == 0) goto L_0x016e
            r4 = r4 & r18
        L_0x016e:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0174
            r4 = r4 & r17
        L_0x0174:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x017c
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r4 = r4 & r0
        L_0x017c:
            r0 = r39
            r1 = r7
            r6 = r10
            r7 = r11
            r12 = r15
            r10 = r36
            goto L_0x0213
        L_0x0186:
            if (r6 == 0) goto L_0x018d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x018e
        L_0x018d:
            r1 = r7
        L_0x018e:
            if (r8 == 0) goto L_0x0191
            r9 = 1
        L_0x0191:
            r6 = r14 & 32
            r7 = 6
            if (r6 == 0) goto L_0x019f
            androidx.compose.material3.FloatingActionButtonDefaults r6 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r6 = r6.getExtendedFabShape(r3, r7)
            r4 = r4 & r19
            goto L_0x01a0
        L_0x019f:
            r6 = r10
        L_0x01a0:
            r8 = r14 & 64
            if (r8 == 0) goto L_0x01ad
            androidx.compose.material3.FloatingActionButtonDefaults r8 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            long r7 = r8.getContainerColor(r3, r7)
            r4 = r4 & r18
            goto L_0x01ae
        L_0x01ad:
            r7 = r11
        L_0x01ae:
            r10 = r14 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x01bd
            int r10 = r4 >> 18
            r10 = r10 & 14
            long r10 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r7, r3, r10)
            r4 = r4 & r17
            goto L_0x01bf
        L_0x01bd:
            r10 = r36
        L_0x01bf:
            r12 = r14 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x01ea
            androidx.compose.material3.FloatingActionButtonDefaults r12 = androidx.compose.material3.FloatingActionButtonDefaults.INSTANCE
            r15 = 24576(0x6000, float:3.4438E-41)
            r17 = 15
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r31 = r12
            r32 = r18
            r33 = r19
            r34 = r21
            r35 = r22
            r36 = r3
            r37 = r15
            r38 = r17
            androidx.compose.material3.FloatingActionButtonElevation r12 = r31.m1874elevationxZ9QkE(r32, r33, r34, r35, r36, r37, r38)
            r15 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r4 = r4 & r15
            goto L_0x01eb
        L_0x01ea:
            r12 = r15
        L_0x01eb:
            if (r0 == 0) goto L_0x0211
            r0 = -2039333397(0xffffffff86723deb, float:-4.556063E-35)
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):FloatingActionButton.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            java.lang.Object r0 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r0 != r15) goto L_0x020b
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r0)
        L_0x020b:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r3.endReplaceableGroup()
            goto L_0x0213
        L_0x0211:
            r0 = r39
        L_0x0213:
            r3.endDefaults()
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0225
            r15 = -1
            java.lang.String r5 = "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:341)"
            r13 = -1387401842(0xffffffffad4ded8e, float:-1.1705649E-11)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r4, r15, r5)
        L_0x0225:
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5 r5 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5
            r13 = r28
            r5.<init>(r9, r2, r13)
            r15 = 1172118032(0x45dd1a10, float:7075.258)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r15, r2, r5)
            r24 = r2
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r2 = r4 >> 6
            r5 = r2 & 14
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            int r4 = r4 >> 9
            r5 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            r5 = r4 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r4
            r2 = r2 | r5
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r4
            r2 = r2 | r5
            r5 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r5
            r26 = r2 | r4
            r27 = 0
            r15 = r30
            r16 = r1
            r17 = r6
            r18 = r7
            r20 = r10
            r22 = r12
            r23 = r0
            r25 = r3
            m1882FloatingActionButtonXz6DiA(r15, r16, r17, r18, r20, r22, r23, r24, r25, r26, r27)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0276
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0276:
            r4 = r1
            r5 = r9
            r9 = r10
            r11 = r12
            r12 = r0
        L_0x027b:
            androidx.compose.runtime.ScopeUpdateScope r15 = r3.endRestartGroup()
            if (r15 == 0) goto L_0x0299
            androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$6 r16 = new androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$6
            r0 = r16
            r1 = r28
            r2 = r29
            r3 = r30
            r13 = r41
            r14 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m1880ExtendedFloatingActionButtonElI57k(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }
}
