package androidx.compose.material3;

import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a6\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a>\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.m6614constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float RadiusSize;
    /* access modifiers changed from: private */
    public static final float StrokeWidth;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.state.ToggleableState[] r0 = androidx.compose.ui.state.ToggleableState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.On     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Off     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Indeterminate     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0153  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Checkbox(boolean r20, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r21, androidx.compose.ui.Modifier r22, boolean r23, androidx.compose.material3.CheckboxColors r24, androidx.compose.foundation.interaction.MutableInteractionSource r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r1 = r20
            r2 = r21
            r7 = r27
            r0 = -1406741137(0xffffffffac26d56f, float:-2.3708498E-12)
            r3 = r26
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r0)
            java.lang.String r4 = "C(Checkbox)P(!1,5,4,2)92@4242L8,93@4302L39,95@4350L328:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r28 & 1
            if (r4 == 0) goto L_0x001b
            r4 = r7 | 6
            goto L_0x002b
        L_0x001b:
            r4 = r7 & 6
            if (r4 != 0) goto L_0x002a
            boolean r4 = r3.changed((boolean) r1)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x0028
        L_0x0027:
            r4 = 2
        L_0x0028:
            r4 = r4 | r7
            goto L_0x002b
        L_0x002a:
            r4 = r7
        L_0x002b:
            r6 = r28 & 2
            r8 = 32
            if (r6 == 0) goto L_0x0034
            r4 = r4 | 48
            goto L_0x0043
        L_0x0034:
            r6 = r7 & 48
            if (r6 != 0) goto L_0x0043
            boolean r6 = r3.changedInstance(r2)
            if (r6 == 0) goto L_0x0040
            r6 = r8
            goto L_0x0042
        L_0x0040:
            r6 = 16
        L_0x0042:
            r4 = r4 | r6
        L_0x0043:
            r6 = r28 & 4
            if (r6 == 0) goto L_0x004a
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004a:
            r9 = r7 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x005d
            r9 = r22
            boolean r10 = r3.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0059
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r4 = r4 | r10
            goto L_0x005f
        L_0x005d:
            r9 = r22
        L_0x005f:
            r10 = r28 & 8
            if (r10 == 0) goto L_0x0066
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r11 = r7 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0079
            r11 = r23
            boolean r12 = r3.changed((boolean) r11)
            if (r12 == 0) goto L_0x0075
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r4 = r4 | r12
            goto L_0x007b
        L_0x0079:
            r11 = r23
        L_0x007b:
            r12 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x0094
            r12 = r28 & 16
            if (r12 != 0) goto L_0x008e
            r12 = r24
            boolean r13 = r3.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0090
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0092
        L_0x008e:
            r12 = r24
        L_0x0090:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0092:
            r4 = r4 | r13
            goto L_0x0096
        L_0x0094:
            r12 = r24
        L_0x0096:
            r13 = r28 & 32
            r14 = 196608(0x30000, float:2.75506E-40)
            if (r13 == 0) goto L_0x009e
            r4 = r4 | r14
            goto L_0x00b0
        L_0x009e:
            r14 = r14 & r7
            if (r14 != 0) goto L_0x00b0
            r14 = r25
            boolean r15 = r3.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00ac
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00ac:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r4 = r4 | r15
            goto L_0x00b2
        L_0x00b0:
            r14 = r25
        L_0x00b2:
            r15 = 74899(0x12493, float:1.04956E-40)
            r15 = r15 & r4
            r5 = 74898(0x12492, float:1.04954E-40)
            if (r15 != r5) goto L_0x00ca
            boolean r5 = r3.getSkipping()
            if (r5 != 0) goto L_0x00c2
            goto L_0x00ca
        L_0x00c2:
            r3.skipToGroupEnd()
            r4 = r11
            r5 = r12
            r6 = r14
            goto L_0x01b3
        L_0x00ca:
            r3.startDefaults()
            r5 = r7 & 1
            java.lang.String r15 = "CC(remember):Checkbox.kt#9igjgp"
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r17 = 1
            if (r5 == 0) goto L_0x00f2
            boolean r5 = r3.getDefaultsInvalid()
            if (r5 == 0) goto L_0x00df
            goto L_0x00f2
        L_0x00df:
            r3.skipToGroupEnd()
            r5 = r28 & 16
            if (r5 == 0) goto L_0x00e8
            r4 = r4 & r16
        L_0x00e8:
            r5 = r11
            r6 = r12
            r18 = r14
        L_0x00ec:
            r19 = r9
            r9 = r4
            r4 = r19
            goto L_0x0133
        L_0x00f2:
            if (r6 == 0) goto L_0x00f9
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r9 = r5
        L_0x00f9:
            if (r10 == 0) goto L_0x00fd
            r11 = r17
        L_0x00fd:
            r5 = r28 & 16
            if (r5 == 0) goto L_0x010b
            androidx.compose.material3.CheckboxDefaults r5 = androidx.compose.material3.CheckboxDefaults.INSTANCE
            r6 = 6
            androidx.compose.material3.CheckboxColors r5 = r5.colors(r3, r6)
            r4 = r4 & r16
            r12 = r5
        L_0x010b:
            if (r13 == 0) goto L_0x00e8
            r5 = 1557792488(0x5cda06e8, float:4.90953107E17)
            r3.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r15)
            java.lang.Object r5 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x0129
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r3.updateRememberedValue(r5)
        L_0x0129:
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            r3.endReplaceableGroup()
            r18 = r5
            r5 = r11
            r6 = r12
            goto L_0x00ec
        L_0x0133:
            r3.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0142
            r10 = -1
            java.lang.String r11 = "androidx.compose.material3.Checkbox (Checkbox.kt:94)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r10, r11)
        L_0x0142:
            androidx.compose.ui.state.ToggleableState r0 = androidx.compose.ui.state.ToggleableStateKt.ToggleableState(r20)
            r10 = 1557792614(0x5cda0766, float:4.90957437E17)
            r3.startReplaceableGroup(r10)
            java.lang.String r10 = "98@4471L29"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r10)
            if (r2 == 0) goto L_0x018e
            r10 = 1557792657(0x5cda0791, float:4.90958914E17)
            r3.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r15)
            r10 = r9 & 112(0x70, float:1.57E-43)
            r11 = 0
            if (r10 != r8) goto L_0x0164
            r8 = r17
            goto L_0x0165
        L_0x0164:
            r8 = r11
        L_0x0165:
            r10 = r9 & 14
            r12 = 4
            if (r10 != r12) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            r17 = r11
        L_0x016d:
            r8 = r8 | r17
            java.lang.Object r10 = r3.rememberedValue()
            if (r8 != 0) goto L_0x017d
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x0188
        L_0x017d:
            androidx.compose.material3.CheckboxKt$Checkbox$2$1 r8 = new androidx.compose.material3.CheckboxKt$Checkbox$2$1
            r8.<init>(r2, r1)
            r10 = r8
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r3.updateRememberedValue(r10)
        L_0x0188:
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r3.endReplaceableGroup()
            goto L_0x0190
        L_0x018e:
            r8 = 0
            r10 = r8
        L_0x0190:
            r3.endReplaceableGroup()
            r8 = 524160(0x7ff80, float:7.34505E-40)
            r15 = r9 & r8
            r16 = 0
            r8 = r0
            r9 = r10
            r10 = r4
            r11 = r5
            r12 = r6
            r13 = r18
            r14 = r3
            TriStateCheckbox(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ae
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ae:
            r9 = r4
            r4 = r5
            r5 = r6
            r6 = r18
        L_0x01b3:
            androidx.compose.runtime.ScopeUpdateScope r10 = r3.endRestartGroup()
            if (r10 == 0) goto L_0x01cd
            androidx.compose.material3.CheckboxKt$Checkbox$3 r11 = new androidx.compose.material3.CheckboxKt$Checkbox$3
            r0 = r11
            r1 = r20
            r2 = r21
            r3 = r9
            r7 = r27
            r8 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x01cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TriStateCheckbox(androidx.compose.ui.state.ToggleableState r19, kotlin.jvm.functions.Function0<kotlin.Unit> r20, androidx.compose.ui.Modifier r21, boolean r22, androidx.compose.material3.CheckboxColors r23, androidx.compose.foundation.interaction.MutableInteractionSource r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r7 = r20
            r8 = r26
            r0 = -1608358065(0xffffffffa022674f, float:-1.3756116E-19)
            r1 = r25
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TriStateCheckbox)P(5,4,3,1)142@6635L8,143@6695L39,162@7339L412:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r27 & 1
            r2 = 2
            if (r1 == 0) goto L_0x001c
            r1 = r8 | 6
            r5 = r19
            goto L_0x002e
        L_0x001c:
            r1 = r8 & 6
            r5 = r19
            if (r1 != 0) goto L_0x002d
            boolean r1 = r6.changed((java.lang.Object) r5)
            if (r1 == 0) goto L_0x002a
            r1 = 4
            goto L_0x002b
        L_0x002a:
            r1 = r2
        L_0x002b:
            r1 = r1 | r8
            goto L_0x002e
        L_0x002d:
            r1 = r8
        L_0x002e:
            r3 = r27 & 2
            if (r3 == 0) goto L_0x0035
            r1 = r1 | 48
            goto L_0x0045
        L_0x0035:
            r3 = r8 & 48
            if (r3 != 0) goto L_0x0045
            boolean r3 = r6.changedInstance(r7)
            if (r3 == 0) goto L_0x0042
            r3 = 32
            goto L_0x0044
        L_0x0042:
            r3 = 16
        L_0x0044:
            r1 = r1 | r3
        L_0x0045:
            r3 = r27 & 4
            if (r3 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r4 = r8 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x005f
            r4 = r21
            boolean r9 = r6.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r9
            goto L_0x0061
        L_0x005f:
            r4 = r21
        L_0x0061:
            r9 = r27 & 8
            if (r9 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r10 = r8 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x007b
            r10 = r22
            boolean r11 = r6.changed((boolean) r10)
            if (r11 == 0) goto L_0x0077
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r11
            goto L_0x007d
        L_0x007b:
            r10 = r22
        L_0x007d:
            r11 = r8 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x0096
            r11 = r27 & 16
            if (r11 != 0) goto L_0x0090
            r11 = r23
            boolean r12 = r6.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0092
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x0090:
            r11 = r23
        L_0x0092:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0094:
            r1 = r1 | r12
            goto L_0x0098
        L_0x0096:
            r11 = r23
        L_0x0098:
            r12 = r27 & 32
            r13 = 196608(0x30000, float:2.75506E-40)
            if (r12 == 0) goto L_0x00a0
            r1 = r1 | r13
            goto L_0x00b2
        L_0x00a0:
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00b2
            r13 = r24
            boolean r14 = r6.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00ae
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r1 = r1 | r14
            goto L_0x00b4
        L_0x00b2:
            r13 = r24
        L_0x00b4:
            r14 = 74899(0x12493, float:1.04956E-40)
            r14 = r14 & r1
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00ce
            boolean r14 = r6.getSkipping()
            if (r14 != 0) goto L_0x00c4
            goto L_0x00ce
        L_0x00c4:
            r6.skipToGroupEnd()
            r3 = r4
            r4 = r10
            r5 = r11
            r10 = r6
            r6 = r13
            goto L_0x01e0
        L_0x00ce:
            r6.startDefaults()
            r14 = r8 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r14 == 0) goto L_0x00ef
            boolean r14 = r6.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00df
            goto L_0x00ef
        L_0x00df:
            r6.skipToGroupEnd()
            r3 = r27 & 16
            if (r3 == 0) goto L_0x00e7
            r1 = r1 & r15
        L_0x00e7:
            r3 = r1
            r16 = r10
            r17 = r11
            r18 = r13
            goto L_0x013d
        L_0x00ef:
            if (r3 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00f7
        L_0x00f6:
            r3 = r4
        L_0x00f7:
            if (r9 == 0) goto L_0x00fb
            r4 = 1
            r10 = r4
        L_0x00fb:
            r4 = r27 & 16
            if (r4 == 0) goto L_0x0108
            androidx.compose.material3.CheckboxDefaults r4 = androidx.compose.material3.CheckboxDefaults.INSTANCE
            r9 = 6
            androidx.compose.material3.CheckboxColors r4 = r4.colors(r6, r9)
            r1 = r1 & r15
            r11 = r4
        L_0x0108:
            if (r12 == 0) goto L_0x0135
            r4 = 1797978171(0x6b2af83b, float:2.0668962E26)
            r6.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Checkbox.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r4)
            java.lang.Object r4 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x0128
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r4)
        L_0x0128:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r6.endReplaceableGroup()
            r18 = r4
            r16 = r10
            r17 = r11
            r4 = r3
            goto L_0x013c
        L_0x0135:
            r4 = r3
            r16 = r10
            r17 = r11
            r18 = r13
        L_0x013c:
            r3 = r1
        L_0x013d:
            r6.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x014c
            r1 = -1
            java.lang.String r9 = "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:144)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r9)
        L_0x014c:
            r0 = 1797978252(0x6b2af88c, float:2.0669112E26)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "154@7139L133"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            if (r7 == 0) goto L_0x0190
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m5865getCheckboxo7Vup1c()
            androidx.compose.material3.tokens.CheckboxTokens r9 = androidx.compose.material3.tokens.CheckboxTokens.INSTANCE
            float r9 = r9.m2671getStateLayerSizeD9Ej5fM()
            float r2 = (float) r2
            float r9 = r9 / r2
            float r10 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r9)
            r14 = 54
            r15 = 4
            r9 = 0
            r11 = 0
            r13 = r6
            androidx.compose.foundation.Indication r9 = androidx.compose.material.ripple.RippleKt.m1491rememberRipple9IZ8Weo(r9, r10, r11, r13, r14, r15)
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.semantics.Role r10 = androidx.compose.ui.semantics.Role.m5857boximpl(r1)
            r1 = r19
            r2 = r18
            r11 = r3
            r3 = r9
            r9 = r4
            r4 = r16
            r5 = r10
            r10 = r6
            r6 = r20
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m1008triStateToggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0197
        L_0x0190:
            r11 = r3
            r9 = r4
            r10 = r6
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0197:
            r10.endReplaceableGroup()
            if (r7 == 0) goto L_0x01a5
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            goto L_0x01a9
        L_0x01a5:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x01a9:
            androidx.compose.ui.Modifier r1 = r9.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            float r1 = CheckboxDefaultPadding
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m670padding3ABfNKs(r0, r1)
            int r0 = r11 >> 9
            r0 = r0 & 14
            int r1 = r11 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r11 >> 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r0 | r1
            r1 = r16
            r2 = r19
            r4 = r17
            r5 = r10
            CheckboxImpl(r1, r2, r3, r4, r5, r6)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d9:
            r3 = r9
            r4 = r16
            r5 = r17
            r6 = r18
        L_0x01e0:
            androidx.compose.runtime.ScopeUpdateScope r9 = r10.endRestartGroup()
            if (r9 == 0) goto L_0x01f9
            androidx.compose.material3.CheckboxKt$TriStateCheckbox$2 r10 = new androidx.compose.material3.CheckboxKt$TriStateCheckbox$2
            r0 = r10
            r1 = r19
            r2 = r20
            r7 = r26
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x01f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v43, resolved type: androidx.compose.material3.CheckDrawingCache} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: androidx.compose.material3.CheckDrawingCache} */
    /* JADX WARNING: type inference failed for: r7v21 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CheckboxImpl(boolean r35, androidx.compose.ui.state.ToggleableState r36, androidx.compose.ui.Modifier r37, androidx.compose.material3.CheckboxColors r38, androidx.compose.runtime.Composer r39, int r40) {
        /*
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r40
            r0 = 2007131616(0x77a265e0, float:6.5876434E33)
            r6 = r39
            androidx.compose.runtime.Composer r14 = r6.startRestartGroup(r0)
            java.lang.String r6 = "C(CheckboxImpl)P(1,3,2)264@12013L23,265@12076L443,281@12578L458,296@13058L32,297@13119L21,298@13167L24,299@13221L27,304@13371L538,300@13253L656:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r6)
            r6 = r5 & 6
            r15 = 2
            if (r6 != 0) goto L_0x0028
            boolean r6 = r14.changed((boolean) r1)
            if (r6 == 0) goto L_0x0025
            r6 = 4
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r6 = r6 | r5
            goto L_0x0029
        L_0x0028:
            r6 = r5
        L_0x0029:
            r7 = r5 & 48
            if (r7 != 0) goto L_0x0039
            boolean r7 = r14.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x0036
            r7 = 32
            goto L_0x0038
        L_0x0036:
            r7 = 16
        L_0x0038:
            r6 = r6 | r7
        L_0x0039:
            r7 = r5 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0049
            boolean r7 = r14.changed((java.lang.Object) r3)
            if (r7 == 0) goto L_0x0046
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r6 = r6 | r7
        L_0x0049:
            r7 = r5 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x0059
            boolean r7 = r14.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0056
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0058
        L_0x0056:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0058:
            r6 = r6 | r7
        L_0x0059:
            r13 = r6
            r6 = r13 & 1171(0x493, float:1.641E-42)
            r7 = 1170(0x492, float:1.64E-42)
            if (r6 != r7) goto L_0x006d
            boolean r6 = r14.getSkipping()
            if (r6 != 0) goto L_0x0067
            goto L_0x006d
        L_0x0067:
            r14.skipToGroupEnd()
            r10 = r3
            goto L_0x02e8
        L_0x006d:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r12 = -1
            if (r6 == 0) goto L_0x0079
            java.lang.String r6 = "androidx.compose.material3.CheckboxImpl (Checkbox.kt:263)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r12, r6)
        L_0x0079:
            int r0 = r13 >> 3
            r11 = r0 & 14
            r10 = 0
            androidx.compose.animation.core.Transition r16 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r10, (androidx.compose.runtime.Composer) r14, (int) r11, (int) r15)
            androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1 r6 = androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1.INSTANCE
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r9 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r14.startReplaceableGroup(r9)
            java.lang.String r8 = "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            kotlin.jvm.internal.FloatCompanionObject r7 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r17 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r7)
            r7 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r14.startReplaceableGroup(r7)
            r39 = r13
            java.lang.String r13 = "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
            java.lang.Object r18 = r16.getCurrentState()
            androidx.compose.ui.state.ToggleableState r18 = (androidx.compose.ui.state.ToggleableState) r18
            r7 = 1800065638(0x6b4ad266, float:2.451966E26)
            r14.startReplaceableGroup(r7)
            r20 = r13
            java.lang.String r13 = "C:Checkbox.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r9 = "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:274)"
            r15 = 0
            if (r21 == 0) goto L_0x00c3
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r15, r12, r9)
        L_0x00c3:
            int[] r21 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r18 = r18.ordinal()
            r10 = r21[r18]
            r12 = 1
            r15 = 3
            r23 = 0
            r24 = 1065353216(0x3f800000, float:1.0)
            if (r10 == r12) goto L_0x00e2
            r12 = 2
            if (r10 == r12) goto L_0x00df
            if (r10 != r15) goto L_0x00d9
            goto L_0x00e2
        L_0x00d9:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00df:
            r10 = r23
            goto L_0x00e4
        L_0x00e2:
            r10 = r24
        L_0x00e4:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x00ed
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ed:
            r14.endReplaceableGroup()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.Object r12 = r16.getTargetState()
            androidx.compose.ui.state.ToggleableState r12 = (androidx.compose.ui.state.ToggleableState) r12
            r14.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
            boolean r26 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r5 = -1
            if (r26 == 0) goto L_0x010b
            r15 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r15, r5, r9)
        L_0x010b:
            int[] r7 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r9 = r12.ordinal()
            r7 = r7[r9]
            r12 = 1
            if (r7 == r12) goto L_0x0126
            r9 = 2
            if (r7 == r9) goto L_0x0123
            r9 = 3
            if (r7 != r9) goto L_0x011d
            goto L_0x0126
        L_0x011d:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0123:
            r7 = r23
            goto L_0x0128
        L_0x0126:
            r7 = r24
        L_0x0128:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0131
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0131:
            r14.endReplaceableGroup()
            java.lang.Float r9 = java.lang.Float.valueOf(r7)
            androidx.compose.animation.core.Transition$Segment r7 = r16.getSegment()
            r15 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)
            java.lang.Object r5 = r6.invoke(r7, r14, r5)
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
            java.lang.String r15 = "FloatAnimation"
            r25 = 0
            r6 = r16
            r7 = r10
            r10 = r8
            r8 = r9
            r9 = r5
            r5 = r10
            r10 = r17
            r17 = r11
            r11 = r15
            r15 = -1
            r12 = r14
            r19 = r39
            r3 = r13
            r15 = r20
            r13 = r25
            androidx.compose.runtime.State r13 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r14.endReplaceableGroup()
            r14.endReplaceableGroup()
            androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 r6 = androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.INSTANCE
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r7 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r14.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            kotlin.jvm.internal.FloatCompanionObject r5 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r5)
            r5 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r14.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            java.lang.Object r5 = r16.getCurrentState()
            androidx.compose.ui.state.ToggleableState r5 = (androidx.compose.ui.state.ToggleableState) r5
            r7 = -1426969489(0xffffffffaaf22c6f, float:-4.3018668E-13)
            r14.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r9 = "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:290)"
            if (r8 == 0) goto L_0x01a2
            r8 = 0
            r11 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r8, r11, r9)
        L_0x01a2:
            int[] r8 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r8[r5]
            r8 = 1
            if (r5 == r8) goto L_0x01bc
            r8 = 2
            if (r5 == r8) goto L_0x01bc
            r8 = 3
            if (r5 != r8) goto L_0x01b6
            r5 = r24
            goto L_0x01be
        L_0x01b6:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01bc:
            r5 = r23
        L_0x01be:
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x01c7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01c7:
            r14.endReplaceableGroup()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.Object r8 = r16.getTargetState()
            androidx.compose.ui.state.ToggleableState r8 = (androidx.compose.ui.state.ToggleableState) r8
            r14.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01e5
            r3 = 0
            r11 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r7, r3, r11, r9)
        L_0x01e5:
            int[] r3 = androidx.compose.material3.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r7 = r8.ordinal()
            r3 = r3[r7]
            r7 = 1
            if (r3 == r7) goto L_0x01ff
            r7 = 2
            if (r3 == r7) goto L_0x01ff
            r7 = 3
            if (r3 != r7) goto L_0x01f9
            r23 = r24
            goto L_0x01ff
        L_0x01f9:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01ff:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0208
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0208:
            r14.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r23)
            androidx.compose.animation.core.Transition$Segment r3 = r16.getSegment()
            r7 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            java.lang.Object r3 = r6.invoke(r3, r14, r9)
            r9 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            java.lang.String r11 = "FloatAnimation"
            r6 = r16
            r7 = r5
            r12 = r14
            r3 = r13
            r13 = r25
            androidx.compose.runtime.State r5 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r14.endReplaceableGroup()
            r14.endReplaceableGroup()
            r6 = -661291556(0xffffffffd8957ddc, float:-1.31494236E15)
            r14.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Checkbox.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r6)
            java.lang.Object r7 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x025d
            androidx.compose.material3.CheckDrawingCache r7 = new androidx.compose.material3.CheckDrawingCache
            r26 = 7
            r27 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r22 = r7
            r22.<init>(r23, r24, r25, r26, r27)
            r14.updateRememberedValue(r7)
        L_0x025d:
            r34 = r7
            androidx.compose.material3.CheckDrawingCache r34 = (androidx.compose.material3.CheckDrawingCache) r34
            r14.endReplaceableGroup()
            int r7 = r19 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r17 | r7
            androidx.compose.runtime.State r7 = r4.checkmarkColor$material3_release(r2, r14, r7)
            r8 = r19 & 126(0x7e, float:1.77E-43)
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | r8
            androidx.compose.runtime.State r8 = r4.boxColor$material3_release(r1, r2, r14, r0)
            androidx.compose.runtime.State r0 = r4.borderColor$material3_release(r1, r2, r14, r0)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getCenter()
            r10 = r37
            r11 = 0
            r12 = 0
            r13 = 2
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r10, r9, r12, r13, r11)
            float r11 = CheckboxSize
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m734requiredSize3ABfNKs(r9, r11)
            r11 = -661291243(0xffffffffd8957f15, float:-1.31498437E15)
            r14.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r6)
            boolean r6 = r14.changed((java.lang.Object) r8)
            boolean r11 = r14.changed((java.lang.Object) r0)
            r6 = r6 | r11
            boolean r11 = r14.changed((java.lang.Object) r7)
            r6 = r6 | r11
            boolean r11 = r14.changed((java.lang.Object) r3)
            r6 = r6 | r11
            boolean r11 = r14.changed((java.lang.Object) r5)
            r6 = r6 | r11
            java.lang.Object r11 = r14.rememberedValue()
            if (r6 != 0) goto L_0x02bf
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r11 != r6) goto L_0x02d6
        L_0x02bf:
            androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1 r6 = new androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
            r28 = r6
            r29 = r8
            r30 = r0
            r31 = r7
            r32 = r3
            r33 = r5
            r28.<init>(r29, r30, r31, r32, r33, r34)
            r11 = r6
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r14.updateRememberedValue(r11)
        L_0x02d6:
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r14.endReplaceableGroup()
            r0 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r9, r11, r14, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02e8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02e8:
            androidx.compose.runtime.ScopeUpdateScope r6 = r14.endRestartGroup()
            if (r6 == 0) goto L_0x0303
            androidx.compose.material3.CheckboxKt$CheckboxImpl$2 r7 = new androidx.compose.material3.CheckboxKt$CheckboxImpl$2
            r0 = r7
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r40
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x0303:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material3.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    public static final void m1603drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f;
        float f4 = f2;
        float f5 = f4 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        float r1 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc());
        if (Color.m3817equalsimpl0(j, j2)) {
            DrawScope.CC.m4472drawRoundRectuAw5IA$default(drawScope, j, 0, SizeKt.Size(r1, r1), CornerRadiusKt.CornerRadius$default(f3, 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 226, (Object) null);
            return;
        }
        float f6 = r1 - (((float) 2) * f4);
        DrawScope.CC.m4472drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f4, f4), SizeKt.Size(f6, f6), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f3 - f4), 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        float f7 = r1 - f4;
        DrawScope.CC.m4472drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f5, f5), SizeKt.Size(f7, f7), CornerRadiusKt.CornerRadius$default(f3 - f5, 0.0f, 2, (Object) null), stroke, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak  reason: not valid java name */
    public static final void m1604drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        float f4 = f2;
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.Companion.m4232getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        float r1 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f4);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f4);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f4);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f4);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * r1, lerp3 * r1);
        checkDrawingCache.getCheckPath().lineTo(lerp * r1, lerp2 * r1);
        checkDrawingCache.getCheckPath().lineTo(0.8f * r1, r1 * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.CC.m4466drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }

    static {
        float f = (float) 2;
        CheckboxDefaultPadding = Dp.m6614constructorimpl(f);
        StrokeWidth = Dp.m6614constructorimpl(f);
        RadiusSize = Dp.m6614constructorimpl(f);
    }
}
