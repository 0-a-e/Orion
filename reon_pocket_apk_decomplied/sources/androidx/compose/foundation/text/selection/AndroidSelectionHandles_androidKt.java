package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t\u001a5\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0013\u001a+\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u0017\u001a\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\rH\u0000\u001a \u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0000\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a\"\u0010\u001f\u001a\u00020\u0012*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0000¨\u0006 "}, d2 = {"HandlePopup", "", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/foundation/text/selection/HandleReferencePoint;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "offsetProvider", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "SelectionHandleIcon", "iconVisible", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "isHandleLtrDirection", "areHandlesCrossed", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
public final class AndroidSelectionHandles_androidKt {
    public static final void SelectionHandle(OffsetProvider offsetProvider, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, Modifier modifier, Composer composer, int i) {
        int i2;
        OffsetProvider offsetProvider2 = offsetProvider;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-626955031);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionHandle)P(4,2)72@3246L7,73@3258L817:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) offsetProvider2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        boolean z3 = z;
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 32 : 16;
        }
        ResolvedTextDirection resolvedTextDirection2 = resolvedTextDirection;
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) resolvedTextDirection2) ? 256 : 128;
        }
        boolean z4 = z2;
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        }
        Modifier modifier2 = modifier;
        if ((57344 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 16384 : 8192;
        }
        int i4 = i2;
        if ((46811 & i4) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-626955031, i4, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:66)");
            }
            boolean isLeft = isLeft(z, resolvedTextDirection, z2);
            HandleReferencePoint handleReferencePoint = isLeft ? HandleReferencePoint.TopRight : HandleReferencePoint.TopLeft;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            HandlePopup(offsetProvider2, handleReferencePoint, ComposableLambdaKt.composableLambda(startRestartGroup, 1868300064, true, new AndroidSelectionHandles_androidKt$SelectionHandle$1((ViewConfiguration) consume, modifier, isLeft, offsetProvider, z)), startRestartGroup, (i4 & 14) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$SelectionHandle$2(offsetProvider, z, resolvedTextDirection, z2, modifier, i));
        }
    }

    public static final void SelectionHandleIcon(Modifier modifier, Function0<Boolean> function0, boolean z, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2111672474);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionHandleIcon)P(2)99@4233L129:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111672474, i2, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:98)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m744sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), function0, z), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$SelectionHandleIcon$1(modifier, function0, z, i));
        }
    }

    public static final Modifier drawSelectionHandle(Modifier modifier, Function0<Boolean> function0, boolean z) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new AndroidSelectionHandles_androidKt$drawSelectionHandle$1(function0, z), 1, (Object) null);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f) {
        float f2 = f;
        int ceil = ((int) ((float) Math.ceil((double) f2))) * 2;
        ImageBitmap imageBitmap = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope canvasDrawScope = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || ceil > imageBitmap.getWidth() || ceil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m4051ImageBitmapx__hDU$default(ceil, ceil, ImageBitmapConfig.Companion.m4045getAlpha8_sVssgQ(), false, (ColorSpace) null, 24, (Object) null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            HandleImageCache.INSTANCE.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long Size = androidx.compose.ui.geometry.SizeKt.Size((float) imageBitmap2.getWidth(), (float) imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r8 = drawParams.m4369component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m4372setSizeuvyYCjk(Size);
        canvas2.save();
        DrawScope drawScope = canvasDrawScope2;
        DrawScope drawScope2 = drawScope;
        DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope2, Color.Companion.m3842getBlack0d7_KjU(), 0, drawScope.m4434getSizeNHjbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m3719getClear0nO6VwU(), 58, (Object) null);
        DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope2, ColorKt.Color(4278190080L), Offset.Companion.m3578getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f2, f2), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        ImageBitmap imageBitmap3 = imageBitmap2;
        DrawScope.CC.m4457drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4278190080L), f, OffsetKt.Offset(f2, f2), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m4372setSizeuvyYCjk(r8);
        return imageBitmap3;
    }

    public static final void HandlePopup(OffsetProvider offsetProvider, HandleReferencePoint handleReferencePoint, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        OffsetProvider offsetProvider2 = offsetProvider;
        HandleReferencePoint handleReferencePoint2 = handleReferencePoint;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(345017889);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandlePopup)P(2,1)224@8202L127,227@8334L190:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) offsetProvider2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) handleReferencePoint2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(345017889, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:223)");
            }
            int i4 = i2 << 3;
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) handleReferencePoint2) | startRestartGroup.changed((Object) offsetProvider2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new HandlePositionProvider(handleReferencePoint2, offsetProvider2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidPopup_androidKt.Popup((HandlePositionProvider) rememberedValue, (Function0<Unit>) null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function2, startRestartGroup, (i4 & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$HandlePopup$1(offsetProvider2, handleReferencePoint2, function22, i3));
        }
    }

    public static final boolean isLeft(boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        if (z) {
            return isHandleLtrDirection(resolvedTextDirection, z2);
        }
        return !isHandleLtrDirection(resolvedTextDirection, z2);
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection resolvedTextDirection, boolean z) {
        return (resolvedTextDirection == ResolvedTextDirection.Ltr && !z) || (resolvedTextDirection == ResolvedTextDirection.Rtl && z);
    }
}
