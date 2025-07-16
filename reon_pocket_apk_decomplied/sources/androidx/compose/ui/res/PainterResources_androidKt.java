package androidx.compose.ui.res;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a1\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rR\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"errorMessage", "", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "path", "", "res", "Landroid/content/res/Resources;", "id", "", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "changingConfigurations", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;IILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PainterResources.android.kt */
public final class PainterResources_androidKt {
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.compose.ui.graphics.ImageBitmap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.painter.Painter painterResource(int r9, androidx.compose.runtime.Composer r10, int r11) {
        /*
            r0 = 473971343(0x1c403a8f, float:6.3603156E-22)
            r10.startReplaceableGroup(r0)
            java.lang.String r1 = "C(painterResource)57@2406L7,58@2428L11,59@2456L25:PainterResources.android.kt#ccshc7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.res.painterResource (PainterResources.android.kt:56)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r1, r2)
        L_0x0017:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r2)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            android.content.Context r0 = (android.content.Context) r0
            r1 = 0
            android.content.res.Resources r3 = androidx.compose.ui.res.Resources_androidKt.resources(r10, r1)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x0052
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r10.updateRememberedValue(r2)
        L_0x0052:
            r10.endReplaceableGroup()
            android.util.TypedValue r2 = (android.util.TypedValue) r2
            r4 = 1
            r3.getValue(r9, r2, r4)
            java.lang.CharSequence r5 = r2.string
            if (r5 == 0) goto L_0x0093
            java.lang.String r6 = ".xml"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 2
            r8 = 0
            boolean r6 = kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (boolean) r1, (int) r7, (java.lang.Object) r8)
            if (r6 != r4) goto L_0x0093
            r4 = -738265327(0xffffffffd3fef711, float:-2.19013356E12)
            r10.startReplaceableGroup(r4)
            java.lang.String r4 = "64@2687L72,65@2768L34"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            android.content.res.Resources$Theme r0 = r0.getTheme()
            int r5 = r2.changingConfigurations
            int r11 = r11 << 6
            r11 = r11 & 896(0x380, float:1.256E-42)
            r7 = r11 | 72
            r2 = r0
            r4 = r9
            r6 = r10
            androidx.compose.ui.graphics.vector.ImageVector r9 = loadVectorResource(r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.graphics.vector.VectorPainter r9 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r9, r10, r1)
            r10.endReplaceableGroup()
            androidx.compose.ui.graphics.painter.Painter r9 = (androidx.compose.ui.graphics.painter.Painter) r9
            goto L_0x00eb
        L_0x0093:
            r11 = -738265172(0xffffffffd3fef7ac, float:-2.19015388E12)
            r10.startReplaceableGroup(r11)
            java.lang.String r11 = "68@2888L96"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            android.content.res.Resources$Theme r0 = r0.getTheme()
            r1 = 1618982084(0x607fb4c4, float:7.370227E19)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r5)
            boolean r11 = r10.changed((java.lang.Object) r11)
            r11 = r11 | r1
            boolean r0 = r10.changed((java.lang.Object) r0)
            r11 = r11 | r0
            java.lang.Object r0 = r10.rememberedValue()
            if (r11 != 0) goto L_0x00cd
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r0 != r11) goto L_0x00d4
        L_0x00cd:
            androidx.compose.ui.graphics.ImageBitmap r0 = loadImageBitmapResource(r5, r3, r9)
            r10.updateRememberedValue(r0)
        L_0x00d4:
            r10.endReplaceableGroup()
            r2 = r0
            androidx.compose.ui.graphics.ImageBitmap r2 = (androidx.compose.ui.graphics.ImageBitmap) r2
            androidx.compose.ui.graphics.painter.BitmapPainter r9 = new androidx.compose.ui.graphics.painter.BitmapPainter
            r7 = 6
            r8 = 0
            r3 = 0
            r5 = 0
            r1 = r9
            r1.<init>(r2, r3, r5, r7, r8)
            r10.endReplaceableGroup()
            androidx.compose.ui.graphics.painter.Painter r9 = (androidx.compose.ui.graphics.painter.Painter) r9
        L_0x00eb:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x00f4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f4:
            r10.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.res.PainterResources_androidKt.painterResource(int, androidx.compose.runtime.Composer, int):androidx.compose.ui.graphics.painter.Painter");
    }

    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources resources, int i, int i2, Composer composer, int i3) {
        composer.startReplaceableGroup(21855625);
        ComposerKt.sourceInformation(composer, "C(loadVectorResource)P(3,2,1)87@3470L7:PainterResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21855625, i3, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:86)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalImageVectorCache());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageVectorCache imageVectorCache = (ImageVectorCache) consume;
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = imageVectorCache.get(key);
        if (imageVectorEntry == null) {
            XmlResourceParser xml = resources.getXml(i);
            if (Intrinsics.areEqual((Object) XmlVectorParser_androidKt.seekToStartTag(xml).getName(), (Object) "vector")) {
                imageVectorEntry = VectorResources_androidKt.loadVectorResourceInner(theme, resources, xml, i2);
                imageVectorCache.set(key, imageVectorEntry);
            } else {
                throw new IllegalArgumentException(errorMessage);
            }
        }
        ImageVector imageVector = imageVectorEntry.getImageVector();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageVector;
    }

    /* access modifiers changed from: private */
    public static final ImageBitmap loadImageBitmapResource(CharSequence charSequence, Resources resources, int i) {
        try {
            return ImageResources_androidKt.imageResource(ImageBitmap.Companion, resources, i);
        } catch (Exception e) {
            throw new ResourceResolutionException("Error attempting to load resource: " + charSequence, e);
        }
    }
}
