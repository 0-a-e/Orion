package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Image.kt */
public final class ImageKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-2123228673);
        ComposerKt.sourceInformation(composer2, "C(Image)P(2,4,6!1,5)96@4585L177:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i3, -1, "androidx.compose.foundation.Image (Image.kt:95)");
        }
        m274Image5hnEew(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, FilterQuality.Companion.m3917getLowfv9h1I(), composer, (i3 & 112) | 8 | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* renamed from: Image-5h-nEew  reason: not valid java name */
    public static final void m274Image5hnEew(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        int i5 = i3;
        composer2.startReplaceableGroup(-1396260732);
        ComposerKt.sourceInformation(composer2, "C(Image)P(2,4,7!1,5!,6:c#ui.graphics.FilterQuality)153@7224L73,154@7302L248:Image.kt#71ulvw");
        Modifier modifier2 = (i5 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i5 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i5 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i5 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i5 & 64) != 0 ? null : colorFilter;
        int r16 = (i5 & 128) != 0 ? DrawScope.Companion.m4474getDefaultFilterQualityfv9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396260732, i4, -1, "androidx.compose.foundation.Image (Image.kt:152)");
        }
        composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer2.changed((Object) imageBitmap);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BitmapPainterKt.m4564BitmapPainterQZhYCtY$default(imageBitmap, 0, 0, r16, 6, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Image((Painter) (BitmapPainter) rememberedValue, str, modifier2, center, fit, f2, colorFilter2, composer, (i4 & 112) | 8 | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (i4 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    public static final void Image(ImageVector imageVector, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(1595907091);
        ComposerKt.sourceInformation(composer2, "C(Image)P(5,3,6!1,4)198@9330L34,197@9309L237:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i3, -1, "androidx.compose.foundation.Image (Image.kt:197)");
        }
        ImageVector imageVector2 = imageVector;
        Image((Painter) VectorPainterKt.rememberVectorPainter(imageVector, composer2, i3 & 14), str, modifier2, center, fit, f2, colorFilter2, composer, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    public static final void Image(Painter painter, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        Modifier modifier2;
        String str2 = str;
        Composer startRestartGroup = composer.startRestartGroup(1142754848);
        ComposerKt.sourceInformation(startRestartGroup, "C(Image)P(6,3,5!1,4)255@11931L329:Image.kt#71ulvw");
        Modifier modifier3 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1142754848, i, -1, "androidx.compose.foundation.Image (Image.kt:243)");
        } else {
            int i3 = i;
        }
        if (str2 != null) {
            Modifier modifier4 = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(-175855396);
            boolean changed = startRestartGroup.changed((Object) str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ImageKt$Image$semantics$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            modifier2 = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) rememberedValue, 1, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        Modifier paint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier3.then(modifier2)), painter, false, center, fit, f2, colorFilter2, 2, (Object) null);
        MeasurePolicy measurePolicy = ImageKt$Image$1.INSTANCE;
        startRestartGroup.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(1)123@4784L23,126@4935L385:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        startRestartGroup.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new ImageKt$Image$$inlined$Layout$1(constructor));
        } else {
            startRestartGroup.useNode();
        }
        Composer r8 = Updater.m3282constructorimpl(startRestartGroup);
        Updater.m3289setimpl(r8, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3289setimpl(r8, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.m3289setimpl(r8, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (r8.getInserting() || !Intrinsics.areEqual(r8.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
            r8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            r8.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ImageKt$Image$2(painter, str, modifier3, center, fit, f2, colorFilter2, i, i2));
        }
    }
}
