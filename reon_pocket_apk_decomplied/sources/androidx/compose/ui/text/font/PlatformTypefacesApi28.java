package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ<\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi28;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "()V", "createAndroidTypefaceApi28", "Landroid/graphics/Typeface;", "genericFontFamily", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createAndroidTypefaceApi28-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createDefault", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "familyName", "weight", "style", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "optionalOnDeviceFontFamilyByName", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformTypefaces.android.kt */
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM  reason: not valid java name */
    public Typeface m6203optionalOnDeviceFontFamilyByName78DK7lM(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, Context context) {
        Typeface typeface;
        if (Intrinsics.areEqual((Object) str, (Object) FontFamily.Companion.getSansSerif().getName())) {
            typeface = m6202createNamedRetOiIg(FontFamily.Companion.getSansSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual((Object) str, (Object) FontFamily.Companion.getSerif().getName())) {
            typeface = m6202createNamedRetOiIg(FontFamily.Companion.getSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual((Object) str, (Object) FontFamily.Companion.getMonospace().getName())) {
            typeface = m6202createNamedRetOiIg(FontFamily.Companion.getMonospace(), fontWeight, i);
        } else if (Intrinsics.areEqual((Object) str, (Object) FontFamily.Companion.getCursive().getName())) {
            typeface = m6202createNamedRetOiIg(FontFamily.Companion.getCursive(), fontWeight, i);
        } else {
            typeface = m6200loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typeface, settings, context);
    }

    /* renamed from: createDefault-FO1MlWM  reason: not valid java name */
    public Typeface m6201createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        return m6198createAndroidTypefaceApi28RetOiIg((String) null, fontWeight, i);
    }

    /* renamed from: createNamed-RetOiIg  reason: not valid java name */
    public Typeface m6202createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        return m6198createAndroidTypefaceApi28RetOiIg(genericFontFamily.getName(), fontWeight, i);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg  reason: not valid java name */
    private final Typeface m6200loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        Typeface r6 = m6198createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
        if (Intrinsics.areEqual((Object) r6, (Object) TypefaceHelperMethodsApi28.INSTANCE.create(Typeface.DEFAULT, fontWeight.getWeight(), FontStyle.m6158equalsimpl0(i, FontStyle.Companion.m6164getItalic_LCdwA()))) || Intrinsics.areEqual((Object) r6, (Object) m6198createAndroidTypefaceApi28RetOiIg((String) null, fontWeight, i))) {
            return null;
        }
        return r6;
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg$default  reason: not valid java name */
    static /* synthetic */ Typeface m6199createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m6198createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0019: MOVE  (r0v10 java.lang.CharSequence) = (r2v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* renamed from: createAndroidTypefaceApi28-RetOiIg  reason: not valid java name */
    private final android.graphics.Typeface m6198createAndroidTypefaceApi28RetOiIg(java.lang.String r2, androidx.compose.ui.text.font.FontWeight r3, int r4) {
        /*
            r1 = this;
            androidx.compose.ui.text.font.FontStyle$Companion r0 = androidx.compose.ui.text.font.FontStyle.Companion
            int r0 = r0.m6165getNormal_LCdwA()
            boolean r0 = androidx.compose.ui.text.font.FontStyle.m6158equalsimpl0(r4, r0)
            if (r0 == 0) goto L_0x0026
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r0 = r0.getNormal()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0026
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0023
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0026
        L_0x0023:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            return r2
        L_0x0026:
            if (r2 != 0) goto L_0x002b
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            goto L_0x0030
        L_0x002b:
            r0 = 0
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r0)
        L_0x0030:
            int r3 = r3.getWeight()
            androidx.compose.ui.text.font.FontStyle$Companion r0 = androidx.compose.ui.text.font.FontStyle.Companion
            int r0 = r0.m6164getItalic_LCdwA()
            boolean r4 = androidx.compose.ui.text.font.FontStyle.m6158equalsimpl0(r4, r0)
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.PlatformTypefacesApi28.m6198createAndroidTypefaceApi28RetOiIg(java.lang.String, androidx.compose.ui.text.font.FontWeight, int):android.graphics.Typeface");
    }
}
