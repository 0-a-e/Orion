package androidx.compose.material3;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.core.math.MathUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a \u0010\u0012\u001a\u00020\u0013*\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"delinearized", "", "rgbComponent", "", "dynamicDarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "context", "Landroid/content/Context;", "dynamicDarkColorScheme31", "tonalPalette", "Landroidx/compose/material3/TonalPalette;", "dynamicDarkColorScheme34", "dynamicLightColorScheme", "dynamicLightColorScheme31", "dynamicLightColorScheme34", "dynamicTonalPalette", "labInvf", "ft", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "setLuminance-DxMtmZc", "(JF)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DynamicTonalPalette.android.kt */
public final class DynamicTonalPaletteKt {
    private static final float labInvf(float f) {
        float f2 = f * f * f;
        return f2 > 0.008856452f ? f2 : ((((float) 116) * f) - ((float) 16)) / 903.2963f;
    }

    public static final TonalPalette dynamicTonalPalette(Context context) {
        Context context2 = context;
        long r2 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170461);
        return new TonalPalette(r2, ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170462), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 98.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 96.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170463), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 94.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 92.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170464), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 87.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170465), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170466), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170467), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170468), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170470), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 24.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 22.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170471), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 17.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 12.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170472), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 6.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170469), 4.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170473), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170474), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170475), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 98.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 96.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170476), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 94.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 92.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170477), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 87.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170478), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170479), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170480), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170481), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170483), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 24.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 22.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170484), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 17.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 12.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170485), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 6.0f), m1832setLuminanceDxMtmZc(ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170482), 4.0f), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170486), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170487), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170488), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170489), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170490), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170491), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170492), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170493), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170494), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170495), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170496), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170497), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170498), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170499), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170500), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170501), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170502), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170503), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170504), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170505), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170506), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170507), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170508), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170509), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170510), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170511), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170512), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170513), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170514), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170515), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170516), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170517), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170518), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170519), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170520), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170521), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170522), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170523), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170524), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170525), (DefaultConstructorMarker) null);
    }

    public static final ColorScheme dynamicLightColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicLightColorScheme34(context);
        }
        return dynamicLightColorScheme31(dynamicTonalPalette(context));
    }

    public static final ColorScheme dynamicDarkColorScheme(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return dynamicDarkColorScheme34(context);
        }
        return dynamicDarkColorScheme31(dynamicTonalPalette(context));
    }

    /* renamed from: setLuminance-DxMtmZc  reason: not valid java name */
    public static final long m1832setLuminanceDxMtmZc(long j, float f) {
        double d = (double) f;
        boolean z = true;
        boolean z2 = d < 1.0E-4d;
        if (d <= 99.9999d) {
            z = false;
        }
        if (z2 || z) {
            int delinearized = delinearized(((float) 100) * labInvf((f + ((float) 16)) / ((float) 116)));
            return ColorKt.Color$default(delinearized, delinearized, delinearized, 0, 8, (Object) null);
        }
        long r7 = Color.m3813convertvNxB06k(j, ColorSpaces.INSTANCE.getCieLab());
        return Color.m3813convertvNxB06k(ColorKt.Color$default(f, Color.m3808component2impl(r7), Color.m3809component3impl(r7), 0.0f, ColorSpaces.INSTANCE.getCieLab(), 8, (Object) null), ColorSpaces.INSTANCE.getSrgb());
    }

    private static final int delinearized(float f) {
        double d = (double) (f / ((float) 100));
        return MathUtils.clamp(MathKt.roundToInt((d <= 0.0031308d ? d * 12.92d : (Math.pow(d, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d), 0, 255);
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette tonalPalette) {
        long r0 = tonalPalette.m2565getPrimary400d7_KjU();
        long r2 = tonalPalette.m2562getPrimary1000d7_KjU();
        long r4 = tonalPalette.m2570getPrimary900d7_KjU();
        long r6 = tonalPalette.m2561getPrimary100d7_KjU();
        long r8 = tonalPalette.m2569getPrimary800d7_KjU();
        long r10 = tonalPalette.m2578getSecondary400d7_KjU();
        long r12 = tonalPalette.m2575getSecondary1000d7_KjU();
        long r14 = tonalPalette.m2583getSecondary900d7_KjU();
        long r16 = tonalPalette.m2574getSecondary100d7_KjU();
        long r18 = tonalPalette.m2591getTertiary400d7_KjU();
        long r20 = tonalPalette.m2588getTertiary1000d7_KjU();
        long r22 = tonalPalette.m2596getTertiary900d7_KjU();
        long r24 = tonalPalette.m2587getTertiary100d7_KjU();
        long r26 = tonalPalette.m2558getNeutralVariant980d7_KjU();
        long r28 = tonalPalette.m2537getNeutralVariant100d7_KjU();
        long r30 = tonalPalette.m2558getNeutralVariant980d7_KjU();
        long r32 = tonalPalette.m2537getNeutralVariant100d7_KjU();
        long r34 = tonalPalette.m2553getNeutralVariant900d7_KjU();
        long r36 = tonalPalette.m2544getNeutralVariant300d7_KjU();
        long r40 = tonalPalette.m2541getNeutralVariant200d7_KjU();
        long r42 = tonalPalette.m2556getNeutralVariant950d7_KjU();
        long r52 = tonalPalette.m2547getNeutralVariant500d7_KjU();
        long r54 = tonalPalette.m2551getNeutralVariant800d7_KjU();
        long r56 = tonalPalette.m2536getNeutralVariant00d7_KjU();
        long r58 = tonalPalette.m2558getNeutralVariant980d7_KjU();
        long r70 = tonalPalette.m2552getNeutralVariant870d7_KjU();
        return ColorSchemeKt.m1687lightColorSchemeCXl9yA$default(r0, r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, tonalPalette.m2565getPrimary400d7_KjU(), r40, r42, 0, 0, 0, 0, r52, r54, r56, r58, tonalPalette.m2555getNeutralVariant940d7_KjU(), tonalPalette.m2554getNeutralVariant920d7_KjU(), tonalPalette.m2553getNeutralVariant900d7_KjU(), tonalPalette.m2557getNeutralVariant960d7_KjU(), tonalPalette.m2538getNeutralVariant1000d7_KjU(), r70, 62914560, 0, (Object) null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context context) {
        Context context2 = context;
        long r3 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170528);
        long r5 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170529);
        long r7 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170526);
        long r9 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170527);
        long r11 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170571);
        long r13 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170532);
        long r15 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170533);
        long r17 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170530);
        long r19 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170531);
        long r21 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170536);
        long r23 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170537);
        long r25 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170534);
        long r27 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170535);
        long r29 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170538);
        long r31 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170539);
        long r33 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170540);
        long r35 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170541);
        long r37 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170549);
        long r39 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170550);
        long r43 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170583);
        long r45 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170584);
        long r55 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170551);
        long r57 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170624);
        long r61 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170547);
        long r73 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170548);
        return ColorSchemeKt.m1687lightColorSchemeCXl9yA$default(r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170528), r43, r45, 0, 0, 0, 0, r55, r57, 0, r61, ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170544), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170545), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170546), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170542), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170543), r73, 331350016, 0, (Object) null);
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette tonalPalette) {
        long r0 = tonalPalette.m2569getPrimary800d7_KjU();
        long r2 = tonalPalette.m2563getPrimary200d7_KjU();
        long r4 = tonalPalette.m2564getPrimary300d7_KjU();
        long r6 = tonalPalette.m2570getPrimary900d7_KjU();
        long r8 = tonalPalette.m2565getPrimary400d7_KjU();
        long r10 = tonalPalette.m2582getSecondary800d7_KjU();
        long r12 = tonalPalette.m2576getSecondary200d7_KjU();
        long r14 = tonalPalette.m2577getSecondary300d7_KjU();
        long r16 = tonalPalette.m2583getSecondary900d7_KjU();
        long r18 = tonalPalette.m2595getTertiary800d7_KjU();
        long r20 = tonalPalette.m2589getTertiary200d7_KjU();
        long r22 = tonalPalette.m2590getTertiary300d7_KjU();
        long r24 = tonalPalette.m2596getTertiary900d7_KjU();
        long r26 = tonalPalette.m2548getNeutralVariant60d7_KjU();
        long r28 = tonalPalette.m2553getNeutralVariant900d7_KjU();
        long r30 = tonalPalette.m2548getNeutralVariant60d7_KjU();
        long r32 = tonalPalette.m2553getNeutralVariant900d7_KjU();
        long r34 = tonalPalette.m2544getNeutralVariant300d7_KjU();
        long r36 = tonalPalette.m2551getNeutralVariant800d7_KjU();
        long r40 = tonalPalette.m2553getNeutralVariant900d7_KjU();
        long r42 = tonalPalette.m2541getNeutralVariant200d7_KjU();
        long r52 = tonalPalette.m2549getNeutralVariant600d7_KjU();
        long r54 = tonalPalette.m2544getNeutralVariant300d7_KjU();
        long r56 = tonalPalette.m2536getNeutralVariant00d7_KjU();
        long r58 = tonalPalette.m2543getNeutralVariant240d7_KjU();
        long r70 = tonalPalette.m2548getNeutralVariant60d7_KjU();
        return ColorSchemeKt.m1683darkColorSchemeCXl9yA$default(r0, r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, tonalPalette.m2569getPrimary800d7_KjU(), r40, r42, 0, 0, 0, 0, r52, r54, r56, r58, tonalPalette.m2539getNeutralVariant120d7_KjU(), tonalPalette.m2540getNeutralVariant170d7_KjU(), tonalPalette.m2542getNeutralVariant220d7_KjU(), tonalPalette.m2537getNeutralVariant100d7_KjU(), tonalPalette.m2545getNeutralVariant40d7_KjU(), r70, 62914560, 0, (Object) null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context context) {
        Context context2 = context;
        long r3 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170571);
        long r5 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170572);
        long r7 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170569);
        long r9 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170570);
        long r11 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170528);
        long r13 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170575);
        long r15 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170576);
        long r17 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170573);
        long r19 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170574);
        long r21 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170579);
        long r23 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170580);
        long r25 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170577);
        long r27 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170578);
        long r29 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170581);
        long r31 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170582);
        long r33 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170583);
        long r35 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170584);
        long r37 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170592);
        long r39 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170593);
        long r43 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170540);
        long r45 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170541);
        long r55 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170594);
        long r57 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170625);
        long r61 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170590);
        long r73 = ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170591);
        return ColorSchemeKt.m1683darkColorSchemeCXl9yA$default(r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170571), r43, r45, 0, 0, 0, 0, r55, r57, 0, r61, ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170587), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170588), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170589), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170585), ColorResourceHelper.INSTANCE.m1638getColorWaAFU9c(context2, 17170586), r73, 331350016, 0, (Object) null);
    }
}
