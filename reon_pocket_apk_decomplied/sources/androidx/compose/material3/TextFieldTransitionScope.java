package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÇ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2z\u0010\u000f\u001av\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0011X\u0002²\u0006\n\u0010\u0015\u001a\u00020\bX\u0002²\u0006\n\u0010\u0016\u001a\u00020\bX\u0002"}, d2 = {"Landroidx/compose/material3/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material3/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material3/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.material3.InputPhase[] r0 = androidx.compose.material3.InputPhase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.material3.InputPhase r1 = androidx.compose.material3.InputPhase.Focused     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.material3.InputPhase r1 = androidx.compose.material3.InputPhase.UnfocusedEmpty     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.material3.InputPhase r1 = androidx.compose.material3.InputPhase.UnfocusedNotEmpty     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldTransitionScope.WhenMappings.<clinit>():void");
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0232, code lost:
        if (r8 != false) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01eb, code lost:
        if (r8 != false) goto L_0x01e3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03d7  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03fe  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01dd  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2454TransitionDTcfvLk(androidx.compose.material3.InputPhase r25, long r26, long r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r30, boolean r31, kotlin.jvm.functions.Function7<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34) {
        /*
            r24 = this;
            r2 = r25
            r7 = r30
            r8 = r31
            r10 = r34
            r0 = -995111872(0xffffffffc4afcc40, float:-1406.3828)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)313@12767L59,315@12868L325,326@13240L1101,354@14389L354,365@14791L299,375@15136L186,381@15332L174:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r10 & 6
            if (r3 != 0) goto L_0x0025
            boolean r3 = r1.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0022
            r3 = 4
            goto L_0x0023
        L_0x0022:
            r3 = 2
        L_0x0023:
            r3 = r3 | r10
            goto L_0x0026
        L_0x0025:
            r3 = r10
        L_0x0026:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0039
            r5 = r26
            boolean r9 = r1.changed((long) r5)
            if (r9 == 0) goto L_0x0035
            r9 = 32
            goto L_0x0037
        L_0x0035:
            r9 = 16
        L_0x0037:
            r3 = r3 | r9
            goto L_0x003b
        L_0x0039:
            r5 = r26
        L_0x003b:
            r9 = r10 & 384(0x180, float:5.38E-43)
            r14 = r28
            if (r9 != 0) goto L_0x004d
            boolean r9 = r1.changed((long) r14)
            if (r9 == 0) goto L_0x004a
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r9 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r3 = r3 | r9
        L_0x004d:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x005d
            boolean r9 = r1.changedInstance(r7)
            if (r9 == 0) goto L_0x005a
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x005c
        L_0x005a:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x005c:
            r3 = r3 | r9
        L_0x005d:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x006d
            boolean r9 = r1.changed((boolean) r8)
            if (r9 == 0) goto L_0x006a
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006c
        L_0x006a:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x006c:
            r3 = r3 | r9
        L_0x006d:
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x0081
            r9 = r32
            boolean r11 = r1.changedInstance(r9)
            if (r11 == 0) goto L_0x007d
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007f
        L_0x007d:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x007f:
            r3 = r3 | r11
            goto L_0x0083
        L_0x0081:
            r9 = r32
        L_0x0083:
            r11 = 74899(0x12493, float:1.04956E-40)
            r11 = r11 & r3
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r11 != r12) goto L_0x0098
            boolean r11 = r1.getSkipping()
            if (r11 != 0) goto L_0x0093
            goto L_0x0098
        L_0x0093:
            r1.skipToGroupEnd()
            goto L_0x0532
        L_0x0098:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r13 = -1
            if (r11 == 0) goto L_0x00a4
            java.lang.String r11 = "androidx.compose.material3.TextFieldTransitionScope.Transition (TextFieldImpl.kt:309)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r13, r11)
        L_0x00a4:
            r0 = r3 & 14
            r0 = r0 | 48
            java.lang.String r11 = "TextFieldInputState"
            r12 = 0
            androidx.compose.animation.core.Transition r0 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r11, (androidx.compose.runtime.Composer) r1, (int) r0, (int) r12)
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelProgress$2 r11 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r4 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            kotlin.jvm.internal.FloatCompanionObject r16 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r16 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r16)
            r12 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r1.startReplaceableGroup(r12)
            java.lang.String r13 = "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            java.lang.Object r19 = r0.getCurrentState()
            androidx.compose.material3.InputPhase r19 = (androidx.compose.material3.InputPhase) r19
            r12 = 240378898(0xe53e412, float:2.611757E-30)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "C:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            boolean r21 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r2 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:319)"
            if (r21 == 0) goto L_0x00f0
            r5 = 240378898(0xe53e412, float:2.611757E-30)
            r6 = 0
            r9 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r6, r9, r2)
        L_0x00f0:
            int[] r5 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r6 = r19.ordinal()
            r5 = r5[r6]
            r6 = 3
            r9 = 1
            r21 = 1065353216(0x3f800000, float:1.0)
            if (r5 == r9) goto L_0x010c
            r9 = 2
            if (r5 == r9) goto L_0x010a
            if (r5 != r6) goto L_0x0104
            goto L_0x010c
        L_0x0104:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x010a:
            r5 = 0
            goto L_0x010e
        L_0x010c:
            r5 = r21
        L_0x010e:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0117
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0117:
            r1.endReplaceableGroup()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.Object r9 = r0.getTargetState()
            androidx.compose.material3.InputPhase r9 = (androidx.compose.material3.InputPhase) r9
            r6 = 240378898(0xe53e412, float:2.611757E-30)
            r1.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            boolean r20 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r18 = r13
            if (r20 == 0) goto L_0x013b
            r10 = 0
            r13 = -1
            androidx.compose.runtime.ComposerKt.traceEventStart(r6, r10, r13, r2)
            goto L_0x013c
        L_0x013b:
            r13 = -1
        L_0x013c:
            int[] r2 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r6 = r9.ordinal()
            r2 = r2[r6]
            r6 = 1
            if (r2 == r6) goto L_0x0156
            r6 = 2
            if (r2 == r6) goto L_0x0154
            r6 = 3
            if (r2 != r6) goto L_0x014e
            goto L_0x0156
        L_0x014e:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0154:
            r2 = 0
            goto L_0x0158
        L_0x0156:
            r2 = r21
        L_0x0158:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0161
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0161:
            r1.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.animation.core.Transition$Segment r6 = r0.getSegment()
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            java.lang.Object r6 = r11.invoke(r6, r1, r10)
            androidx.compose.animation.core.FiniteAnimationSpec r6 = (androidx.compose.animation.core.FiniteAnimationSpec) r6
            java.lang.String r10 = "LabelProgress"
            r20 = 196608(0x30000, float:2.75506E-40)
            r11 = r0
            r23 = r12
            r9 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r12 = r5
            r5 = r18
            r13 = r2
            r14 = r6
            r15 = r16
            r16 = r10
            r17 = r1
            r18 = r20
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r11, r12, r13, r14, r15, r16, r17, r18)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2 r6 = androidx.compose.material3.TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r10 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r1.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            kotlin.jvm.internal.FloatCompanionObject r10 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r15 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r10)
            r1.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            java.lang.Object r10 = r0.getCurrentState()
            androidx.compose.material3.InputPhase r10 = (androidx.compose.material3.InputPhase) r10
            r11 = 2067512179(0x7b3bbb73, float:9.747614E35)
            r1.startReplaceableGroup(r11)
            r14 = r23
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01d0
            java.lang.String r12 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:347)"
            r9 = -1
            r13 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r13, r9, r12)
            goto L_0x01d2
        L_0x01d0:
            r9 = -1
            r13 = 0
        L_0x01d2:
            int[] r12 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r12[r10]
            r12 = 1
            if (r10 == r12) goto L_0x01ee
            r12 = 2
            if (r10 == r12) goto L_0x01eb
            r12 = 3
            if (r10 != r12) goto L_0x01e5
        L_0x01e3:
            r10 = 0
            goto L_0x01f0
        L_0x01e5:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01eb:
            if (r8 == 0) goto L_0x01ee
            goto L_0x01e3
        L_0x01ee:
            r10 = r21
        L_0x01f0:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x01f9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f9:
            r1.endReplaceableGroup()
            java.lang.Float r12 = java.lang.Float.valueOf(r10)
            java.lang.Object r10 = r0.getTargetState()
            androidx.compose.material3.InputPhase r10 = (androidx.compose.material3.InputPhase) r10
            r1.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            r23 = r14
            if (r16 == 0) goto L_0x0219
            java.lang.String r14 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:347)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r13, r9, r14)
        L_0x0219:
            int[] r11 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r11[r10]
            r11 = 1
            if (r10 == r11) goto L_0x0235
            r11 = 2
            if (r10 == r11) goto L_0x0232
            r11 = 3
            if (r10 != r11) goto L_0x022c
        L_0x022a:
            r10 = 0
            goto L_0x0237
        L_0x022c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0232:
            if (r8 == 0) goto L_0x0235
            goto L_0x022a
        L_0x0235:
            r10 = r21
        L_0x0237:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0240
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0240:
            r1.endReplaceableGroup()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            androidx.compose.animation.core.Transition$Segment r11 = r0.getSegment()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)
            java.lang.Object r6 = r6.invoke(r11, r1, r14)
            r14 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            java.lang.String r16 = "PlaceholderOpacity"
            r11 = r0
            r6 = r13
            r13 = r10
            r10 = r23
            r17 = r1
            r18 = r20
            androidx.compose.runtime.State r22 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r11, r12, r13, r14, r15, r16, r17, r18)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 r11 = androidx.compose.material3.TextFieldTransitionScope$Transition$prefixSuffixOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r12 = -1338768149(0xffffffffb03404eb, float:-6.549061E-10)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            kotlin.jvm.internal.FloatCompanionObject r4 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r15 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r4)
            r4 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r1.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            java.lang.Object r4 = r0.getCurrentState()
            androidx.compose.material3.InputPhase r4 = (androidx.compose.material3.InputPhase) r4
            r12 = 5829913(0x58f519, float:8.169448E-39)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x02a1
            java.lang.String r13 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:358)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r6, r9, r13)
        L_0x02a1:
            int[] r13 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r13[r4]
            r13 = 1
            if (r4 == r13) goto L_0x02bd
            r13 = 2
            if (r4 == r13) goto L_0x02b9
            r13 = 3
            if (r4 != r13) goto L_0x02b3
            goto L_0x02bd
        L_0x02b3:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x02b9:
            if (r8 == 0) goto L_0x02bd
            r4 = 0
            goto L_0x02bf
        L_0x02bd:
            r4 = r21
        L_0x02bf:
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x02c8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02c8:
            r1.endReplaceableGroup()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r13 = r0.getTargetState()
            androidx.compose.material3.InputPhase r13 = (androidx.compose.material3.InputPhase) r13
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x02e6
            java.lang.String r14 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:358)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r6, r9, r14)
        L_0x02e6:
            int[] r12 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r13 = r13.ordinal()
            r12 = r12[r13]
            r13 = 1
            if (r12 == r13) goto L_0x0302
            r13 = 2
            if (r12 == r13) goto L_0x02fe
            r13 = 3
            if (r12 != r13) goto L_0x02f8
            goto L_0x0302
        L_0x02f8:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x02fe:
            if (r8 == 0) goto L_0x0302
            r21 = 0
        L_0x0302:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x030b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x030b:
            r1.endReplaceableGroup()
            java.lang.Float r13 = java.lang.Float.valueOf(r21)
            androidx.compose.animation.core.Transition$Segment r12 = r0.getSegment()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            java.lang.Object r11 = r11.invoke(r12, r1, r14)
            r14 = r11
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            java.lang.String r16 = "PrefixSuffixOpacity"
            r11 = r0
            r12 = r4
            r17 = r1
            r18 = r20
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r11, r12, r13, r14, r15, r16, r17, r18)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2 r11 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            r12 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            java.lang.Object r12 = r0.getTargetState()
            androidx.compose.material3.InputPhase r12 = (androidx.compose.material3.InputPhase) r12
            r13 = -1468066062(0xffffffffa87f16f2, float:-1.4160319E-14)
            r1.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            java.lang.String r15 = "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:369)"
            if (r14 == 0) goto L_0x035c
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r6, r9, r15)
        L_0x035c:
            int[] r14 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r12 = r12.ordinal()
            r12 = r14[r12]
            r14 = 1
            if (r12 != r14) goto L_0x036a
            r16 = r26
            goto L_0x036c
        L_0x036a:
            r16 = r28
        L_0x036c:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0375
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0375:
            r1.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r12 = androidx.compose.ui.graphics.Color.m3820getColorSpaceimpl(r16)
            r14 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r14)
            boolean r14 = r1.changed((java.lang.Object) r12)
            java.lang.Object r6 = r1.rememberedValue()
            if (r14 != 0) goto L_0x0399
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r6 != r14) goto L_0x03a8
        L_0x0399:
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r6 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r6)
            java.lang.Object r6 = r6.invoke(r12)
            androidx.compose.animation.core.TwoWayConverter r6 = (androidx.compose.animation.core.TwoWayConverter) r6
            r1.updateRememberedValue(r6)
        L_0x03a8:
            r1.endReplaceableGroup()
            androidx.compose.animation.core.TwoWayConverter r6 = (androidx.compose.animation.core.TwoWayConverter) r6
            r12 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            java.lang.Object r12 = r0.getCurrentState()
            androidx.compose.material3.InputPhase r12 = (androidx.compose.material3.InputPhase) r12
            r1.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x03cc
            r14 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r14, r9, r15)
        L_0x03cc:
            int[] r14 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r12 = r12.ordinal()
            r12 = r14[r12]
            r14 = 1
            if (r12 != r14) goto L_0x03da
            r16 = r26
            goto L_0x03dc
        L_0x03da:
            r16 = r28
        L_0x03dc:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x03e5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03e5:
            r1.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r12 = androidx.compose.ui.graphics.Color.m3806boximpl(r16)
            java.lang.Object r14 = r0.getTargetState()
            androidx.compose.material3.InputPhase r14 = (androidx.compose.material3.InputPhase) r14
            r1.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0402
            r10 = 0
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r10, r9, r15)
        L_0x0402:
            int[] r9 = androidx.compose.material3.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r10 = r14.ordinal()
            r9 = r9[r10]
            r10 = 1
            if (r9 != r10) goto L_0x0410
            r14 = r26
            goto L_0x0412
        L_0x0410:
            r14 = r28
        L_0x0412:
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x041b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x041b:
            r1.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r13 = androidx.compose.ui.graphics.Color.m3806boximpl(r14)
            androidx.compose.animation.core.Transition$Segment r9 = r0.getSegment()
            r10 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)
            java.lang.Object r9 = r11.invoke(r9, r1, r14)
            r14 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            r18 = 229376(0x38000, float:3.21424E-40)
            java.lang.String r16 = "LabelTextStyleColor"
            r11 = r0
            r15 = r6
            r17 = r1
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r11, r12, r13, r14, r15, r16, r17, r18)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2 r9 = androidx.compose.material3.TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = r3 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 384(0x180, float:5.38E-43)
            r11 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            java.lang.Object r11 = r0.getTargetState()
            int r12 = r10 >> 6
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r11 = r7.invoke(r11, r1, r12)
            androidx.compose.ui.graphics.Color r11 = (androidx.compose.ui.graphics.Color) r11
            long r11 = r11.m3826unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r11 = androidx.compose.ui.graphics.Color.m3820getColorSpaceimpl(r11)
            r12 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            boolean r12 = r1.changed((java.lang.Object) r11)
            java.lang.Object r13 = r1.rememberedValue()
            if (r12 != 0) goto L_0x048f
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x049f
        L_0x048f:
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r12 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r12)
            java.lang.Object r11 = r12.invoke(r11)
            r13 = r11
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r1.updateRememberedValue(r13)
        L_0x049f:
            r1.endReplaceableGroup()
            r15 = r13
            androidx.compose.animation.core.TwoWayConverter r15 = (androidx.compose.animation.core.TwoWayConverter) r15
            r11 = 3
            int r10 = r10 << r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r11
            r11 = 3136(0xc40, float:4.394E-42)
            r10 = r10 | r11
            r11 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r1.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            java.lang.Object r5 = r0.getCurrentState()
            int r10 = r10 >> 9
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            java.lang.Object r12 = r7.invoke(r5, r1, r11)
            java.lang.Object r5 = r0.getTargetState()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object r13 = r7.invoke(r5, r1, r10)
            androidx.compose.animation.core.Transition$Segment r5 = r0.getSegment()
            r10 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object r5 = r9.invoke(r5, r1, r10)
            r14 = r5
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            r18 = 229376(0x38000, float:3.21424E-40)
            java.lang.String r16 = "LabelContentColor"
            r11 = r0
            r17 = r1
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r11, r12, r13, r14, r15, r16, r17, r18)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            float r2 = Transition_DTcfvLk$lambda$1(r2)
            java.lang.Float r12 = java.lang.Float.valueOf(r2)
            long r5 = Transition_DTcfvLk$lambda$7(r6)
            androidx.compose.ui.graphics.Color r13 = androidx.compose.ui.graphics.Color.m3806boximpl(r5)
            long r5 = Transition_DTcfvLk$lambda$8(r0)
            androidx.compose.ui.graphics.Color r14 = androidx.compose.ui.graphics.Color.m3806boximpl(r5)
            float r0 = Transition_DTcfvLk$lambda$3(r22)
            java.lang.Float r15 = java.lang.Float.valueOf(r0)
            float r0 = Transition_DTcfvLk$lambda$5(r4)
            java.lang.Float r16 = java.lang.Float.valueOf(r0)
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r3
            java.lang.Integer r18 = java.lang.Integer.valueOf(r0)
            r11 = r32
            r11.invoke(r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0532
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0532:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x0553
            androidx.compose.material3.TextFieldTransitionScope$Transition$1 r12 = new androidx.compose.material3.TextFieldTransitionScope$Transition$1
            r0 = r12
            r1 = r24
            r2 = r25
            r3 = r26
            r5 = r28
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r34
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0553:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldTransitionScope.m2454TransitionDTcfvLk(androidx.compose.material3.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function7, androidx.compose.runtime.Composer, int):void");
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$7(State<Color> state) {
        return state.getValue().m3826unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$8(State<Color> state) {
        return state.getValue().m3826unboximpl();
    }
}
