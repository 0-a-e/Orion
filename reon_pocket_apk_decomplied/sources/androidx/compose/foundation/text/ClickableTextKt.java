package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onHover", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-03UYbkw", "(Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "containsWithinBounds", "Landroidx/compose/ui/text/MultiParagraph;", "positionOffset", "Landroidx/compose/ui/geometry/Offset;", "containsWithinBounds-Uv8p0NA", "(Landroidx/compose/ui/text/MultiParagraph;J)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClickableText.kt */
public final class ClickableTextKt {
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011a  */
    /* renamed from: ClickableText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1053ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.text.TextStyle r26, boolean r27, int r28, int r29, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r30, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r8 = r31
            r9 = r33
            r10 = r34
            r0 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)79@3637L52,88@3936L297:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r9 | 6
            r4 = r2
            r2 = r24
            goto L_0x0032
        L_0x001e:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002f
            r2 = r24
            boolean r4 = r1.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r9
            goto L_0x0032
        L_0x002f:
            r2 = r24
            r4 = r9
        L_0x0032:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r9 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r25
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r4 = r4 | r7
            goto L_0x004e
        L_0x004c:
            r6 = r25
        L_0x004e:
            r7 = r10 & 4
            if (r7 == 0) goto L_0x0055
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r11 = r9 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x0068
            r11 = r26
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0064
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r12
            goto L_0x006a
        L_0x0068:
            r11 = r26
        L_0x006a:
            r12 = r10 & 8
            if (r12 == 0) goto L_0x0071
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r13 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x0084
            r13 = r27
            boolean r14 = r1.changed((boolean) r13)
            if (r14 == 0) goto L_0x0080
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r4 = r4 | r14
            goto L_0x0086
        L_0x0084:
            r13 = r27
        L_0x0086:
            r14 = r10 & 16
            if (r14 == 0) goto L_0x008d
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x008d:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00a3
            r15 = r28
            boolean r16 = r1.changed((int) r15)
            if (r16 == 0) goto L_0x009e
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r4 = r4 | r16
            goto L_0x00a5
        L_0x00a3:
            r15 = r28
        L_0x00a5:
            r16 = r10 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b2
            r18 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r18
            r3 = r29
            goto L_0x00c5
        L_0x00b2:
            r18 = r9 & r17
            r3 = r29
            if (r18 != 0) goto L_0x00c5
            boolean r18 = r1.changed((int) r3)
            if (r18 == 0) goto L_0x00c1
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r4 = r4 | r18
        L_0x00c5:
            r18 = r10 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00d2
            r20 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r20
            r0 = r30
            goto L_0x00e5
        L_0x00d2:
            r20 = r9 & r19
            r0 = r30
            if (r20 != 0) goto L_0x00e5
            boolean r21 = r1.changedInstance(r0)
            if (r21 == 0) goto L_0x00e1
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r4 = r4 | r21
        L_0x00e5:
            r0 = r10 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00ed
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00eb:
            r4 = r4 | r0
            goto L_0x00fe
        L_0x00ed:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x00fe
            boolean r0 = r1.changedInstance(r8)
            if (r0 == 0) goto L_0x00fb
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00eb
        L_0x00fb:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00eb
        L_0x00fe:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r4
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011a
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x010e
            goto L_0x011a
        L_0x010e:
            r1.skipToGroupEnd()
            r7 = r30
            r2 = r6
            r4 = r13
            r5 = r15
            r6 = r3
            r3 = r11
            goto L_0x0213
        L_0x011a:
            if (r5 == 0) goto L_0x0121
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r0
        L_0x0121:
            if (r7 == 0) goto L_0x012a
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            goto L_0x012b
        L_0x012a:
            r0 = r11
        L_0x012b:
            if (r12 == 0) goto L_0x012f
            r2 = 1
            goto L_0x0130
        L_0x012f:
            r2 = r13
        L_0x0130:
            if (r14 == 0) goto L_0x0139
            androidx.compose.ui.text.style.TextOverflow$Companion r5 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r5 = r5.m6511getClipgIe3tQ8()
            goto L_0x013a
        L_0x0139:
            r5 = r15
        L_0x013a:
            if (r16 == 0) goto L_0x013f
            r3 = 2147483647(0x7fffffff, float:NaN)
        L_0x013f:
            if (r18 == 0) goto L_0x0146
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$1 r7 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$1.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            goto L_0x0148
        L_0x0146:
            r7 = r30
        L_0x0148:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0157
            r11 = -1
            java.lang.String r12 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:78)"
            r13 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r4, r11, r12)
        L_0x0157:
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r11)
            java.lang.Object r11 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            r13 = 0
            if (r11 != r12) goto L_0x0177
            r12 = 2
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r13, r12, r13)
            r1.updateRememberedValue(r11)
        L_0x0177:
            r1.endReplaceableGroup()
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            r14 = -797094589(0xffffffffd07d4d43, float:-1.69987963E10)
            r1.startReplaceableGroup(r14)
            boolean r14 = r1.changed((java.lang.Object) r11)
            boolean r15 = r1.changedInstance(r8)
            r14 = r14 | r15
            java.lang.Object r15 = r1.rememberedValue()
            if (r14 != 0) goto L_0x019d
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r15 != r14) goto L_0x01a8
        L_0x019d:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1 r14 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1
            r14.<init>(r11, r8, r13)
            r15 = r14
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r1.updateRememberedValue(r15)
        L_0x01a8:
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r12, (java.lang.Object) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r15)
            androidx.compose.ui.Modifier r12 = r6.then(r12)
            r13 = -797094184(0xffffffffd07d4ed8, float:-1.6999211E10)
            r1.startReplaceableGroup(r13)
            boolean r13 = r1.changed((java.lang.Object) r11)
            boolean r14 = r1.changedInstance(r7)
            r13 = r13 | r14
            java.lang.Object r14 = r1.rememberedValue()
            if (r13 != 0) goto L_0x01d2
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x01dd
        L_0x01d2:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1 r13 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            r13.<init>(r11, r7)
            r14 = r13
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r1.updateRememberedValue(r14)
        L_0x01dd:
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r1.endReplaceableGroup()
            r11 = 58254(0xe38e, float:8.1631E-41)
            r11 = r11 & r4
            int r13 = r4 << 6
            r13 = r13 & r17
            r11 = r11 | r13
            int r4 = r4 << 3
            r4 = r4 & r19
            r22 = r11 | r4
            r23 = 896(0x380, float:1.256E-42)
            r18 = 0
            r19 = 0
            r20 = 0
            r11 = r24
            r13 = r0
            r15 = r5
            r16 = r2
            r17 = r3
            r21 = r1
            androidx.compose.foundation.text.BasicTextKt.m1048BasicTextRWo7tUw(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x020f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x020f:
            r4 = r2
            r2 = r6
            r6 = r3
            r3 = r0
        L_0x0213:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x022c
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$3 r12 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
            r0 = r12
            r1 = r24
            r8 = r31
            r9 = r33
            r10 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m1053ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0139  */
    /* renamed from: ClickableText-03UYbkw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1052ClickableText03UYbkw(androidx.compose.ui.text.AnnotatedString r25, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.text.TextStyle r28, boolean r29, int r30, int r31, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r32, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r2 = r26
            r9 = r33
            r10 = r35
            r11 = r36
            r0 = 1020774372(0x3cd7c7e4, float:0.026340432)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r3 = "C(ClickableText)P(8,3,1,7,6,5:c#ui.text.style.TextOverflow!1,4)156@7018L52,157@7096L24,179@7815L303:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            r3 = r11 & 1
            if (r3 == 0) goto L_0x0020
            r3 = r10 | 6
            r5 = r3
            r3 = r25
            goto L_0x0034
        L_0x0020:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0031
            r3 = r25
            boolean r5 = r1.changed((java.lang.Object) r3)
            if (r5 == 0) goto L_0x002e
            r5 = 4
            goto L_0x002f
        L_0x002e:
            r5 = 2
        L_0x002f:
            r5 = r5 | r10
            goto L_0x0034
        L_0x0031:
            r3 = r25
            r5 = r10
        L_0x0034:
            r6 = r11 & 2
            if (r6 == 0) goto L_0x003b
            r5 = r5 | 48
            goto L_0x004b
        L_0x003b:
            r6 = r10 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004b
            boolean r6 = r1.changedInstance(r2)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r5 = r5 | r6
        L_0x004b:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0052
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0065
            r7 = r27
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0061
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r5 = r5 | r8
            goto L_0x0067
        L_0x0065:
            r7 = r27
        L_0x0067:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006e
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0081
            r12 = r28
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x007d
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r5 = r5 | r13
            goto L_0x0083
        L_0x0081:
            r12 = r28
        L_0x0083:
            r13 = r11 & 16
            r14 = 57344(0xe000, float:8.0356E-41)
            if (r13 == 0) goto L_0x008d
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008d:
            r15 = r10 & r14
            if (r15 != 0) goto L_0x00a1
            r15 = r29
            boolean r16 = r1.changed((boolean) r15)
            if (r16 == 0) goto L_0x009c
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r5 = r5 | r16
            goto L_0x00a3
        L_0x00a1:
            r15 = r29
        L_0x00a3:
            r16 = r11 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b0
            r18 = 196608(0x30000, float:2.75506E-40)
            r5 = r5 | r18
            r14 = r30
            goto L_0x00c3
        L_0x00b0:
            r18 = r10 & r17
            r14 = r30
            if (r18 != 0) goto L_0x00c3
            boolean r18 = r1.changed((int) r14)
            if (r18 == 0) goto L_0x00bf
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r5 = r5 | r18
        L_0x00c3:
            r18 = r11 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00d0
            r20 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r20
            r4 = r31
            goto L_0x00e3
        L_0x00d0:
            r20 = r10 & r19
            r4 = r31
            if (r20 != 0) goto L_0x00e3
            boolean r21 = r1.changed((int) r4)
            if (r21 == 0) goto L_0x00df
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r5 = r5 | r21
        L_0x00e3:
            r0 = r11 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00ee
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r22
            r3 = r32
            goto L_0x0103
        L_0x00ee:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r10 & r22
            r3 = r32
            if (r22 != 0) goto L_0x0103
            boolean r22 = r1.changedInstance(r3)
            if (r22 == 0) goto L_0x00ff
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x0101:
            r5 = r5 | r22
        L_0x0103:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x010b
            r3 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0109:
            r5 = r5 | r3
            goto L_0x011c
        L_0x010b:
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r10
            if (r3 != 0) goto L_0x011c
            boolean r3 = r1.changedInstance(r9)
            if (r3 == 0) goto L_0x0119
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0109
        L_0x0119:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0109
        L_0x011c:
            r3 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r3 & r5
            r4 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r4) goto L_0x0139
            boolean r3 = r1.getSkipping()
            if (r3 != 0) goto L_0x012c
            goto L_0x0139
        L_0x012c:
            r1.skipToGroupEnd()
            r8 = r32
            r3 = r7
            r4 = r12
            r6 = r14
            r5 = r15
            r7 = r31
            goto L_0x0262
        L_0x0139:
            if (r6 == 0) goto L_0x0140
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r7 = r3
        L_0x0140:
            if (r8 == 0) goto L_0x0149
            androidx.compose.ui.text.TextStyle$Companion r3 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r3 = r3.getDefault()
            goto L_0x014a
        L_0x0149:
            r3 = r12
        L_0x014a:
            if (r13 == 0) goto L_0x014e
            r4 = 1
            goto L_0x014f
        L_0x014e:
            r4 = r15
        L_0x014f:
            if (r16 == 0) goto L_0x0158
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r6 = r6.m6511getClipgIe3tQ8()
            goto L_0x0159
        L_0x0158:
            r6 = r14
        L_0x0159:
            if (r18 == 0) goto L_0x015f
            r8 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0161
        L_0x015f:
            r8 = r31
        L_0x0161:
            if (r0 == 0) goto L_0x0168
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$4 r0 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$4.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            goto L_0x016a
        L_0x0168:
            r0 = r32
        L_0x016a:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0179
            r12 = -1
            java.lang.String r13 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:155)"
            r14 = 1020774372(0x3cd7c7e4, float:0.026340432)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r5, r12, r13)
        L_0x0179:
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r12)
            java.lang.String r13 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            java.lang.Object r14 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r14 != r15) goto L_0x0199
            r14 = 0
            r15 = 2
            androidx.compose.runtime.MutableState r14 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r14, r14, r15, r14)
            r1.updateRememberedValue(r14)
        L_0x0199:
            r1.endReplaceableGroup()
            androidx.compose.runtime.MutableState r14 = (androidx.compose.runtime.MutableState) r14
            r15 = 773894976(0x2e20b340, float:3.6538994E-11)
            r1.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r15)
            r1.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r13)
            java.lang.Object r12 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x01cc
            kotlin.coroutines.EmptyCoroutineContext r12 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
            kotlinx.coroutines.CoroutineScope r12 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r12, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r13 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r13.<init>(r12)
            r1.updateRememberedValue(r13)
            r12 = r13
        L_0x01cc:
            r1.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r12 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r12
            kotlinx.coroutines.CoroutineScope r12 = r12.getCoroutineScope()
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1 r15 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1
            r16 = 0
            r27 = r15
            r28 = r12
            r29 = r26
            r30 = r14
            r31 = r33
            r32 = r16
            r27.<init>(r28, r29, r30, r31, r32)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput(r13, r9, r2, r15)
            androidx.compose.ui.Modifier r13 = r7.then(r12)
            r12 = -797090299(0xffffffffd07d5e05, float:-1.70031892E10)
            r1.startReplaceableGroup(r12)
            boolean r12 = r1.changed((java.lang.Object) r14)
            boolean r15 = r1.changedInstance(r0)
            r12 = r12 | r15
            java.lang.Object r15 = r1.rememberedValue()
            if (r12 != 0) goto L_0x0216
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r15 != r12) goto L_0x0221
        L_0x0216:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1 r12 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$5$1
            r12.<init>(r14, r0)
            r15 = r12
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r1.updateRememberedValue(r15)
        L_0x0221:
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r1.endReplaceableGroup()
            r12 = r5 & 14
            int r14 = r5 >> 3
            r27 = r0
            r0 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r14
            r0 = r0 | r12
            int r12 = r5 << 3
            r12 = r12 & r17
            r0 = r0 | r12
            r5 = r5 & r19
            r23 = r0 | r5
            r24 = 896(0x380, float:1.256E-42)
            r19 = 0
            r20 = 0
            r21 = 0
            r12 = r25
            r14 = r3
            r16 = r6
            r17 = r4
            r18 = r8
            r22 = r1
            androidx.compose.foundation.text.BasicTextKt.m1048BasicTextRWo7tUw(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x025c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x025c:
            r5 = r4
            r4 = r3
            r3 = r7
            r7 = r8
            r8 = r27
        L_0x0262:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x027d
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$6 r13 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$6
            r0 = r13
            r1 = r25
            r2 = r26
            r9 = r33
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x027d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m1052ClickableText03UYbkw(androidx.compose.ui.text.AnnotatedString, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final Integer ClickableText_03UYbkw$getOffset(MutableState<TextLayoutResult> mutableState, long j) {
        MultiParagraph multiParagraph;
        TextLayoutResult value = mutableState.getValue();
        if (value == null || (multiParagraph = value.getMultiParagraph()) == null) {
            return null;
        }
        if (!m1054containsWithinBoundsUv8p0NA(multiParagraph, j)) {
            multiParagraph = null;
        }
        if (multiParagraph != null) {
            return Integer.valueOf(multiParagraph.m5913getOffsetForPositionk4lQ0M(j));
        }
        return null;
    }

    /* renamed from: containsWithinBounds-Uv8p0NA  reason: not valid java name */
    private static final boolean m1054containsWithinBoundsUv8p0NA(MultiParagraph multiParagraph, long j) {
        float r0 = Offset.m3552component1impl(j);
        float r3 = Offset.m3553component2impl(j);
        return r0 > 0.0f && r3 >= 0.0f && r0 <= multiParagraph.getWidth() && r3 <= multiParagraph.getHeight();
    }
}
