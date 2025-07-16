package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001am\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a\"\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a8\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020+H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Surface.kt */
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, SurfaceKt$LocalAbsoluteTonalElevation$1.INSTANCE, 1, (Object) null);

    /* renamed from: Surface-T9BRK9s  reason: not valid java name */
    public static final void m2303SurfaceT9BRK9s(Modifier modifier, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        long j3;
        float f3;
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-513881741);
        ComposerKt.sourceInformation(composer2, "C(Surface)P(4,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)103@5146L11,104@5193L22,*110@5410L7,111@5439L867:Surface.kt#uh7d8r");
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        Shape rectangleShape = (i2 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long r5 = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU() : j;
        if ((i2 & 8) != 0) {
            j3 = ColorSchemeKt.m1681contentColorForek8zF_U(r5, composer2, (i3 >> 6) & 14);
        } else {
            j3 = j2;
        }
        float r9 = (i2 & 16) != 0 ? Dp.m6614constructorimpl((float) 0) : f;
        if ((i2 & 32) != 0) {
            f3 = Dp.m6614constructorimpl((float) 0);
        } else {
            f3 = f2;
        }
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, i3, -1, "androidx.compose.material3.Surface (Surface.kt:109)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r2 = Dp.m6614constructorimpl(((Dp) consume).m6628unboximpl() + r9);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j3)), providableCompositionLocal.provides(Dp.m6612boximpl(r2))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -70914509, true, new SurfaceKt$Surface$1(modifier2, rectangleShape, r5, r2, borderStroke2, f3, function2)), composer2, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* renamed from: Surface-o_FOJdg  reason: not valid java name */
    public static final void m2306Surfaceo_FOJdg(Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        long j3;
        float f3;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i3;
        composer2.startReplaceableGroup(-789752804);
        ComposerKt.sourceInformation(composer2, "C(Surface)P(7,6,4,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp!1,5)208@10602L11,209@10649L22,213@10820L39,*216@10957L7,217@10986L1027:Surface.kt#uh7d8r");
        Modifier modifier2 = (i5 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z2 = (i5 & 4) != 0 ? true : z;
        Shape rectangleShape = (i5 & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long r8 = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU() : j;
        if ((i5 & 32) != 0) {
            j3 = ColorSchemeKt.m1681contentColorForek8zF_U(r8, composer2, (i4 >> 12) & 14);
        } else {
            j3 = j2;
        }
        float r10 = (i5 & 64) != 0 ? Dp.m6614constructorimpl((float) 0) : f;
        if ((i5 & 128) != 0) {
            f3 = Dp.m6614constructorimpl((float) 0);
        } else {
            f3 = f2;
        }
        BorderStroke borderStroke2 = (i5 & 256) != 0 ? null : borderStroke;
        if ((i5 & 512) != 0) {
            composer2.startReplaceableGroup(-746940902);
            ComposerKt.sourceInformation(composer2, "CC(remember):Surface.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            composer.endReplaceableGroup();
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, i4, i2, "androidx.compose.material3.Surface (Surface.kt:215)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r102 = Dp.m6614constructorimpl(((Dp) consume).m6628unboximpl() + r10);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j3)), providableCompositionLocal.provides(Dp.m6612boximpl(r102))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1279702876, true, new SurfaceKt$Surface$3(modifier2, rectangleShape, r8, r102, borderStroke2, mutableInteractionSource2, z2, function0, f3, function2)), composer2, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* renamed from: Surface-d85dljk  reason: not valid java name */
    public static final void m2304Surfaced85dljk(boolean z, Function0<Unit> function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        long j3;
        float f3;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i3;
        composer2.startReplaceableGroup(540296512);
        ComposerKt.sourceInformation(composer2, "C(Surface)P(8,7,6,4,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,5)318@16254L11,319@16301L22,323@16472L39,*326@16609L7,327@16638L1069:Surface.kt#uh7d8r");
        Modifier modifier2 = (i5 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z3 = (i5 & 8) != 0 ? true : z2;
        Shape rectangleShape = (i5 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long r8 = (i5 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU() : j;
        if ((i5 & 64) != 0) {
            j3 = ColorSchemeKt.m1681contentColorForek8zF_U(r8, composer2, (i4 >> 15) & 14);
        } else {
            j3 = j2;
        }
        float r10 = (i5 & 128) != 0 ? Dp.m6614constructorimpl((float) 0) : f;
        if ((i5 & 256) != 0) {
            f3 = Dp.m6614constructorimpl((float) 0);
        } else {
            f3 = f2;
        }
        BorderStroke borderStroke2 = (i5 & 512) != 0 ? null : borderStroke;
        if ((i5 & 1024) != 0) {
            composer2.startReplaceableGroup(-746935250);
            ComposerKt.sourceInformation(composer2, "CC(remember):Surface.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, i4, i2, "androidx.compose.material3.Surface (Surface.kt:325)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r102 = Dp.m6614constructorimpl(((Dp) consume).m6628unboximpl() + r10);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j3)), providableCompositionLocal.provides(Dp.m6612boximpl(r102))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -1164547968, true, new SurfaceKt$Surface$5(modifier2, rectangleShape, r8, r102, borderStroke2, z, mutableInteractionSource2, z3, function0, f3, function2)), composer2, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* renamed from: Surface-d85dljk  reason: not valid java name */
    public static final void m2305Surfaced85dljk(boolean z, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        long j3;
        float f3;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i3;
        composer2.startReplaceableGroup(-1877401889);
        ComposerKt.sourceInformation(composer2, "C(Surface)P(1,8,7,5,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,6)429@22016L11,430@22063L22,434@22234L39,*437@22371L7,438@22400L1079:Surface.kt#uh7d8r");
        Modifier modifier2 = (i5 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z3 = (i5 & 8) != 0 ? true : z2;
        Shape rectangleShape = (i5 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long r8 = (i5 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer2, 6).m1667getSurface0d7_KjU() : j;
        if ((i5 & 64) != 0) {
            j3 = ColorSchemeKt.m1681contentColorForek8zF_U(r8, composer2, (i4 >> 15) & 14);
        } else {
            j3 = j2;
        }
        float r10 = (i5 & 128) != 0 ? Dp.m6614constructorimpl((float) 0) : f;
        if ((i5 & 256) != 0) {
            f3 = Dp.m6614constructorimpl((float) 0);
        } else {
            f3 = f2;
        }
        BorderStroke borderStroke2 = (i5 & 512) != 0 ? null : borderStroke;
        if ((i5 & 1024) != 0) {
            composer2.startReplaceableGroup(-746929488);
            ComposerKt.sourceInformation(composer2, "CC(remember):Surface.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877401889, i4, i2, "androidx.compose.material3.Surface (Surface.kt:436)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float r102 = Dp.m6614constructorimpl(((Dp) consume).m6628unboximpl() + r10);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j3)), providableCompositionLocal.provides(Dp.m6612boximpl(r102))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 712720927, true, new SurfaceKt$Surface$7(modifier2, rectangleShape, r8, r102, borderStroke2, z, mutableInteractionSource2, z3, function1, f3, function2)), composer2, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* access modifiers changed from: private */
    /* renamed from: surface-XO-JAsU  reason: not valid java name */
    public static final Modifier m2309surfaceXOJAsU(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Shape shape2;
        Modifier modifier2;
        Shape shape3 = shape;
        BorderStroke borderStroke2 = borderStroke;
        Modifier r0 = GraphicsLayerModifierKt.m3978graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0, shape, false, (RenderEffect) null, 0, 0, 0, 124895, (Object) null);
        BorderStroke borderStroke3 = borderStroke;
        if (borderStroke3 != null) {
            shape2 = shape;
            modifier2 = BorderKt.border(Modifier.Companion, borderStroke3, shape2);
        } else {
            shape2 = shape;
            modifier2 = Modifier.Companion;
        }
        return ClipKt.clip(BackgroundKt.m213backgroundbw27NRU(r0.then(modifier2), j, shape2), shape2);
    }

    /* access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-CLU3JFs  reason: not valid java name */
    public static final long m2310surfaceColorAtElevationCLU3JFs(long j, float f, Composer composer, int i) {
        composer.startReplaceableGroup(-2079918090);
        ComposerKt.sourceInformation(composer, "C(surfaceColorAtElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)483@23968L11,483@23980L37:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:483)");
        }
        long r8 = ColorSchemeKt.m1679applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j, f, composer, (i << 3) & PointerIconCompat.TYPE_TEXT);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r8;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }
}
