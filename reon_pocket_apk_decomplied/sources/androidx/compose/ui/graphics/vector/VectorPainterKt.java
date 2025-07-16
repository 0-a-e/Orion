package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.VectorProperty;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010$\u001a\u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a \u0001\u0010\"\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u0002012@\u0010)\u001a<\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b+\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00100\u001a\u000201H\u0000ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u00192\u0006\u0010:\u001a\u00020\u0005H\u0000\u001a&\u0010;\u001a\u00020\u0003*\u00020<2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00030>¢\u0006\u0002\b?H\b\u001a&\u0010@\u001a\u00020\u001b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createVectorPainterFromImageVector", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "density", "Landroidx/compose/ui/unit/Density;", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "obtainViewportSize", "Landroidx/compose/ui/geometry/Size;", "defaultSize", "viewportWidth", "", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "rememberVectorPainter", "image", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "name", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createGroupComponent", "currentGroup", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* renamed from: rememberVectorPainter-mlNsNFs  reason: not valid java name */
    public static final VectorPainter m4608rememberVectorPaintermlNsNFs(float f, float f2, float f3, float f4, String str, long j, int i, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        composer2.startReplaceableGroup(-964365210);
        ComposerKt.sourceInformation(composer2, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)85@3689L207:VectorPainter.kt#huu6hf");
        float f5 = Float.NaN;
        float f6 = (i3 & 4) != 0 ? Float.NaN : f3;
        if ((i3 & 8) == 0) {
            f5 = f4;
        }
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long r5 = (i3 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        int r7 = (i3 & 64) != 0 ? BlendMode.Companion.m3744getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:85)");
        }
        VectorPainter r0 = m4609rememberVectorPaintervIP8VLU(f, f2, f6, f5, str2, r5, r7, false, function4, composer, (i4 & 14) | 12582912 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | ((i4 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: androidx.compose.ui.graphics.ColorFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.compose.runtime.Composition} */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011c, code lost:
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x011e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberVectorPainter-vIP8VLU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.vector.VectorPainter m4609rememberVectorPaintervIP8VLU(float r16, float r17, float r18, float r19, java.lang.String r20, long r21, int r23, boolean r24, kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r0 = r25
            r1 = r26
            r2 = r28
            r3 = 1068590786(0x3fb166c2, float:1.3859484)
            r1.startReplaceableGroup(r3)
            java.lang.String r4 = "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)128@5474L7,131@5667L94,*134@5773L28,142@6079L28,143@6135L487:VectorPainter.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            r4 = r2 & 4
            r5 = 2143289344(0x7fc00000, float:NaN)
            if (r4 == 0) goto L_0x0019
            r4 = r5
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r6 = r2 & 8
            if (r6 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = r19
        L_0x0022:
            r6 = r2 & 16
            if (r6 == 0) goto L_0x0029
            java.lang.String r6 = "VectorRootGroup"
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r2 & 32
            if (r7 == 0) goto L_0x0036
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r7.m3852getUnspecified0d7_KjU()
            goto L_0x0038
        L_0x0036:
            r7 = r21
        L_0x0038:
            r9 = r2 & 64
            if (r9 == 0) goto L_0x0043
            androidx.compose.ui.graphics.BlendMode$Companion r9 = androidx.compose.ui.graphics.BlendMode.Companion
            int r9 = r9.m3744getSrcIn0nO6VwU()
            goto L_0x0045
        L_0x0043:
            r9 = r23
        L_0x0045:
            r2 = r2 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x004b
            r2 = 0
            goto L_0x004d
        L_0x004b:
            r2 = r24
        L_0x004d:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x005b
            r11 = -1
            java.lang.String r12 = "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:127)"
            r13 = r27
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r13, r11, r12)
        L_0x005b:
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r11, r12)
            java.lang.Object r3 = r1.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r26)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            r11 = r16
            r12 = r17
            long r11 = m4606obtainSizePxVpY3zN4(r3, r11, r12)
            long r13 = m4607obtainViewportSizePq9zytI(r11, r4, r5)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m3806boximpl(r7)
            androidx.compose.ui.graphics.BlendMode r15 = androidx.compose.ui.graphics.BlendMode.m3712boximpl(r9)
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r10)
            java.lang.String r10 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r10)
            boolean r3 = r1.changed((java.lang.Object) r3)
            boolean r10 = r1.changed((java.lang.Object) r15)
            r3 = r3 | r10
            java.lang.Object r10 = r26.rememberedValue()
            if (r3 != 0) goto L_0x00a8
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r10 != r3) goto L_0x00af
        L_0x00a8:
            androidx.compose.ui.graphics.ColorFilter r10 = m4605createColorFilterxETnrds(r7, r9)
            r1.updateRememberedValue(r10)
        L_0x00af:
            r26.endReplaceableGroup()
            r3 = r10
            androidx.compose.ui.graphics.ColorFilter r3 = (androidx.compose.ui.graphics.ColorFilter) r3
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            java.lang.Object r7 = r26.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            r9 = 1
            if (r7 != r8) goto L_0x00d6
            androidx.compose.ui.graphics.vector.VectorPainter r7 = new androidx.compose.ui.graphics.vector.VectorPainter
            r8 = 0
            r7.<init>(r8, r9, r8)
            r1.updateRememberedValue(r7)
        L_0x00d6:
            r26.endReplaceableGroup()
            androidx.compose.ui.graphics.vector.VectorPainter r7 = (androidx.compose.ui.graphics.vector.VectorPainter) r7
            r16 = r7
            r17 = r11
            r19 = r13
            r21 = r6
            r22 = r3
            r23 = r2
            m4603configureVectorPainterT4PVSW8(r16, r17, r19, r21, r22, r23)
            r2 = 0
            androidx.compose.runtime.CompositionContext r2 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r1, r2)
            java.lang.Float r3 = java.lang.Float.valueOf(r4)
            java.lang.Float r4 = java.lang.Float.valueOf(r5)
            r5 = 1618982084(0x607fb4c4, float:7.370227E19)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            boolean r3 = r1.changed((java.lang.Object) r3)
            boolean r4 = r1.changed((java.lang.Object) r4)
            r3 = r3 | r4
            boolean r4 = r1.changed((java.lang.Object) r0)
            r3 = r3 | r4
            java.lang.Object r4 = r26.rememberedValue()
            if (r3 != 0) goto L_0x011e
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0157
        L_0x011e:
            androidx.compose.runtime.Composition r3 = r7.getComposition$ui_release()
            if (r3 == 0) goto L_0x012d
            boolean r4 = r3.isDisposed()
            if (r4 == 0) goto L_0x012b
            goto L_0x012d
        L_0x012b:
            r4 = r3
            goto L_0x0143
        L_0x012d:
            androidx.compose.ui.graphics.vector.VectorApplier r3 = new androidx.compose.ui.graphics.vector.VectorApplier
            androidx.compose.ui.graphics.vector.VectorComponent r4 = r7.getVector$ui_release()
            androidx.compose.ui.graphics.vector.GroupComponent r4 = r4.getRoot()
            androidx.compose.ui.graphics.vector.VNode r4 = (androidx.compose.ui.graphics.vector.VNode) r4
            r3.<init>(r4)
            androidx.compose.runtime.Applier r3 = (androidx.compose.runtime.Applier) r3
            androidx.compose.runtime.Composition r2 = androidx.compose.runtime.CompositionKt.Composition(r3, r2)
            r4 = r2
        L_0x0143:
            androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1 r2 = new androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$2$1$1
            r2.<init>(r0, r13)
            r0 = -824421385(0xffffffffcedc53f7, float:-1.84824512E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r0, r9, r2)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r4.setContent(r0)
            r1.updateRememberedValue(r4)
        L_0x0157:
            r26.endReplaceableGroup()
            androidx.compose.runtime.Composition r4 = (androidx.compose.runtime.Composition) r4
            r7.setComposition$ui_release(r4)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0168
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0168:
            r26.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.m4609rememberVectorPaintervIP8VLU(float, float, float, float, java.lang.String, long, int, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.graphics.vector.VectorPainter");
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i) {
        composer.startReplaceableGroup(1413834416);
        ComposerKt.sourceInformation(composer, "C(rememberVectorPainter)169@6989L7,170@7008L232:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:168)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        Integer valueOf = Integer.valueOf(imageVector.getGenId$ui_release());
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) valueOf) | composer.changed((Object) density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            rememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        VectorPainter vectorPainter = (VectorPainter) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return vectorPainter;
    }

    /* renamed from: obtainSizePx-VpY3zN4  reason: not valid java name */
    private static final long m4606obtainSizePxVpY3zN4(Density density, float f, float f2) {
        return SizeKt.Size(density.m6550toPx0680j_4(f), density.m6550toPx0680j_4(f2));
    }

    /* renamed from: obtainViewportSize-Pq9zytI  reason: not valid java name */
    private static final long m4607obtainViewportSizePq9zytI(long j, float f, float f2) {
        if (Float.isNaN(f)) {
            f = Size.m3631getWidthimpl(j);
        }
        if (Float.isNaN(f2)) {
            f2 = Size.m3628getHeightimpl(j);
        }
        return SizeKt.Size(f, f2);
    }

    /* renamed from: configureVectorPainter-T4PVSW8$default  reason: not valid java name */
    public static /* synthetic */ VectorPainter m4604configureVectorPainterT4PVSW8$default(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z, int i, Object obj) {
        return m4603configureVectorPainterT4PVSW8(vectorPainter, j, j2, (i & 4) != 0 ? RootGroupName : str, colorFilter, (i & 16) != 0 ? false : z);
    }

    /* renamed from: configureVectorPainter-T4PVSW8  reason: not valid java name */
    public static final VectorPainter m4603configureVectorPainterT4PVSW8(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z) {
        vectorPainter.m4600setSizeuvyYCjk$ui_release(j);
        vectorPainter.setAutoMirror$ui_release(z);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.m4601setViewportSizeuvyYCjk$ui_release(j2);
        vectorPainter.setName$ui_release(str);
        return vectorPainter;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density density, ImageVector imageVector, GroupComponent groupComponent) {
        long r3 = m4606obtainSizePxVpY3zN4(density, imageVector.m4575getDefaultWidthD9Ej5fM(), imageVector.m4574getDefaultHeightD9Ej5fM());
        return m4603configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), r3, m4607obtainViewportSizePq9zytI(r3, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m4605createColorFilterxETnrds(imageVector.m4577getTintColor0d7_KjU(), imageVector.m4576getTintBlendMode0nO6VwU()), imageVector.getAutoMirror());
    }

    public static final GroupComponent createGroupComponent(GroupComponent groupComponent, VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = vectorGroup.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m4585setPathFillTypeoQ8Xj4U(vectorPath.m4610getPathFillTypeRgk1Os());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m4586setStrokeLineCapBeK7IIE(vectorPath.m4611getStrokeLineCapKaPHkGw());
                pathComponent.m4587setStrokeLineJoinWw9F2mQ(vectorPath.m4612getStrokeLineJoinLxFBmk8());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
        return groupComponent;
    }

    public static final void RenderVectorGroup(VectorGroup vectorGroup, Map<String, ? extends VectorConfig> map, Composer composer, int i, int i2) {
        int i3;
        Map<String, ? extends VectorConfig> map2;
        Composer composer2;
        Map<String, ? extends VectorConfig> map3;
        Map<String, ? extends VectorConfig> map4;
        VectorGroup vectorGroup2 = vectorGroup;
        int i4 = i;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-446179233);
        ComposerKt.sourceInformation(startRestartGroup, "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf");
        if ((i5 & 1) != 0) {
            i3 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) vectorGroup2) ? 4 : 2) | i4;
        } else {
            i3 = i4;
        }
        int i6 = i5 & 2;
        if (i6 != 0) {
            i3 |= 16;
        }
        if (i6 == 2 && (i3 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            map2 = map;
            composer2 = startRestartGroup;
        } else {
            Map<String, ? extends VectorConfig> emptyMap = i6 != 0 ? MapsKt.emptyMap() : map;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446179233, i3, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:426)");
            }
            Iterator<VectorNode> it = vectorGroup.iterator();
            while (it.hasNext()) {
                VectorNode next = it.next();
                if (next instanceof VectorPath) {
                    startRestartGroup.startReplaceableGroup(-326282007);
                    ComposerKt.sourceInformation(startRestartGroup, "430@15882L1719");
                    VectorPath vectorPath = (VectorPath) next;
                    VectorConfig vectorConfig = (VectorConfig) emptyMap.get(vectorPath.getName());
                    if (vectorConfig == null) {
                        vectorConfig = new VectorPainterKt$RenderVectorGroup$config$1();
                    }
                    VectorConfig vectorConfig2 = vectorConfig;
                    Iterator<VectorNode> it2 = it;
                    VectorConfig vectorConfig3 = vectorConfig2;
                    Composer composer3 = startRestartGroup;
                    VectorComposeKt.m4591Path9cdaXJ4((List) vectorConfig2.getOrDefault(VectorProperty.PathData.INSTANCE, vectorPath.getPathData()), vectorPath.m4610getPathFillTypeRgk1Os(), vectorPath.getName(), (Brush) vectorConfig2.getOrDefault(VectorProperty.Fill.INSTANCE, vectorPath.getFill()), ((Number) vectorConfig2.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(vectorPath.getFillAlpha()))).floatValue(), (Brush) vectorConfig2.getOrDefault(VectorProperty.Stroke.INSTANCE, vectorPath.getStroke()), ((Number) vectorConfig2.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(vectorPath.getStrokeAlpha()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(vectorPath.getStrokeLineWidth()))).floatValue(), vectorPath.m4611getStrokeLineCapKaPHkGw(), vectorPath.m4612getStrokeLineJoinLxFBmk8(), vectorPath.getStrokeLineMiter(), ((Number) vectorConfig3.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(vectorPath.getTrimPathStart()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(vectorPath.getTrimPathEnd()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(vectorPath.getTrimPathOffset()))).floatValue(), composer3, 8, 0, 0);
                    composer3.endReplaceableGroup();
                    VectorGroup vectorGroup3 = vectorGroup;
                    it = it2;
                    map4 = emptyMap;
                    int i7 = i2;
                    startRestartGroup = composer3;
                } else {
                    Iterator<VectorNode> it3 = it;
                    Map<String, ? extends VectorConfig> map5 = emptyMap;
                    Composer composer4 = startRestartGroup;
                    if (next instanceof VectorGroup) {
                        composer4.startReplaceableGroup(-326280149);
                        ComposerKt.sourceInformation(composer4, "475@17740L1368");
                        VectorGroup vectorGroup4 = (VectorGroup) next;
                        map3 = map5;
                        VectorConfig vectorConfig4 = (VectorConfig) map3.get(vectorGroup4.getName());
                        if (vectorConfig4 == null) {
                            vectorConfig4 = new VectorPainterKt$RenderVectorGroup$config$2();
                        }
                        VectorComposeKt.Group(vectorGroup4.getName(), ((Number) vectorConfig4.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(vectorGroup4.getRotation()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(vectorGroup4.getPivotX()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(vectorGroup4.getPivotY()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(vectorGroup4.getScaleX()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(vectorGroup4.getScaleY()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(vectorGroup4.getTranslationX()))).floatValue(), ((Number) vectorConfig4.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(vectorGroup4.getTranslationY()))).floatValue(), (List) vectorConfig4.getOrDefault(VectorProperty.PathData.INSTANCE, vectorGroup4.getClipPathData()), ComposableLambdaKt.composableLambda(composer4, 1450046638, true, new VectorPainterKt$RenderVectorGroup$1(next, map3)), composer4, 939524096, 0);
                        composer4.endReplaceableGroup();
                    } else {
                        map3 = map5;
                        composer4.startReplaceableGroup(-326278679);
                        composer4.endReplaceableGroup();
                    }
                    VectorGroup vectorGroup5 = vectorGroup;
                    int i8 = i2;
                    startRestartGroup = composer4;
                    map4 = map3;
                    it = it3;
                }
                int i9 = i;
            }
            map2 = emptyMap;
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VectorPainterKt$RenderVectorGroup$2(vectorGroup, map2, i, i2));
        }
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long r0 = drawScope.m4433getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r3 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4527scale0AR0LA0(-1.0f, 1.0f, r0);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r3);
    }

    /* access modifiers changed from: private */
    /* renamed from: createColorFilter-xETnrds  reason: not valid java name */
    public static final ColorFilter m4605createColorFilterxETnrds(long j, int i) {
        if (j != Color.Companion.m3852getUnspecified0d7_KjU()) {
            return ColorFilter.Companion.m3860tintxETnrds(j, i);
        }
        return null;
    }
}
