package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ.\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJD\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020#H\u0016R$\u0010\n\u001a\u00020\u000b8WX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/font/ResourceFont;", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "(ILandroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLoadingStrategy-PKNRLFQ$annotations", "()V", "getLoadingStrategy-PKNRLFQ", "()I", "I", "getResId", "getStyle-_-LCdwA", "getVariationSettings", "()Landroidx/compose/ui/text/font/FontVariation$Settings;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "copy", "copy-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/ResourceFont;", "copy-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/ResourceFont;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Font.kt */
public final class ResourceFont implements Font {
    public static final int $stable = 0;
    private final int loadingStrategy;
    private final int resId;
    private final int style;
    private final FontVariation.Settings variationSettings;
    private final FontWeight weight;

    public /* synthetic */ ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, fontWeight, i2, settings, i3);
    }

    /* renamed from: getLoadingStrategy-PKNRLFQ$annotations  reason: not valid java name */
    public static /* synthetic */ void m6206getLoadingStrategyPKNRLFQ$annotations() {
    }

    private ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings, int i3) {
        this.resId = i;
        this.weight = fontWeight;
        this.style = i2;
        this.variationSettings = settings;
        this.loadingStrategy = i3;
    }

    public final int getResId() {
        return this.resId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ResourceFont(int r8, androidx.compose.ui.text.font.FontWeight r9, int r10, androidx.compose.ui.text.font.FontVariation.Settings r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            if (r14 == 0) goto L_0x000a
            androidx.compose.ui.text.font.FontWeight$Companion r9 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r9 = r9.getNormal()
        L_0x000a:
            r2 = r9
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0015
            androidx.compose.ui.text.font.FontStyle$Companion r9 = androidx.compose.ui.text.font.FontStyle.Companion
            int r10 = r9.m6165getNormal_LCdwA()
        L_0x0015:
            r3 = r10
            r9 = r13 & 8
            if (r9 == 0) goto L_0x0023
            androidx.compose.ui.text.font.FontVariation r9 = androidx.compose.ui.text.font.FontVariation.INSTANCE
            r10 = 0
            androidx.compose.ui.text.font.FontVariation$Setting[] r10 = new androidx.compose.ui.text.font.FontVariation.Setting[r10]
            androidx.compose.ui.text.font.FontVariation$Settings r11 = r9.m6180Settings6EWAqTQ(r2, r3, r10)
        L_0x0023:
            r4 = r11
            r9 = r13 & 16
            if (r9 == 0) goto L_0x002e
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r9 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r12 = r9.m6149getAsyncPKNRLFQ()
        L_0x002e:
            r5 = r12
            r6 = 0
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.ResourceFont.<init>(int, androidx.compose.ui.text.font.FontWeight, int, androidx.compose.ui.text.font.FontVariation$Settings, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public FontWeight getWeight() {
        return this.weight;
    }

    /* renamed from: getStyle-_-LCdwA  reason: not valid java name */
    public int m6210getStyle_LCdwA() {
        return this.style;
    }

    public final FontVariation.Settings getVariationSettings() {
        return this.variationSettings;
    }

    /* renamed from: getLoadingStrategy-PKNRLFQ  reason: not valid java name */
    public int m6209getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    /* renamed from: copy-RetOiIg$default  reason: not valid java name */
    public static /* synthetic */ ResourceFont m6205copyRetOiIg$default(ResourceFont resourceFont, int i, FontWeight fontWeight, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = resourceFont.resId;
        }
        if ((i3 & 2) != 0) {
            fontWeight = resourceFont.getWeight();
        }
        if ((i3 & 4) != 0) {
            i2 = resourceFont.m6210getStyle_LCdwA();
        }
        return resourceFont.m6208copyRetOiIg(i, fontWeight, i2);
    }

    /* renamed from: copy-RetOiIg  reason: not valid java name */
    public final ResourceFont m6208copyRetOiIg(int i, FontWeight fontWeight, int i2) {
        return m6204copyF3nL8kk$default(this, i, fontWeight, i2, m6209getLoadingStrategyPKNRLFQ(), (FontVariation.Settings) null, 16, (Object) null);
    }

    /* renamed from: copy-F3nL8kk$default  reason: not valid java name */
    public static /* synthetic */ ResourceFont m6204copyF3nL8kk$default(ResourceFont resourceFont, int i, FontWeight fontWeight, int i2, int i3, FontVariation.Settings settings, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = resourceFont.resId;
        }
        if ((i4 & 2) != 0) {
            fontWeight = resourceFont.getWeight();
        }
        FontWeight fontWeight2 = fontWeight;
        if ((i4 & 4) != 0) {
            i2 = resourceFont.m6210getStyle_LCdwA();
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = resourceFont.m6209getLoadingStrategyPKNRLFQ();
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            settings = resourceFont.variationSettings;
        }
        return resourceFont.m6207copyF3nL8kk(i, fontWeight2, i5, i6, settings);
    }

    /* renamed from: copy-F3nL8kk  reason: not valid java name */
    public final ResourceFont m6207copyF3nL8kk(int i, FontWeight fontWeight, int i2, int i3, FontVariation.Settings settings) {
        return new ResourceFont(i, fontWeight, i2, settings, i3, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont) obj;
        return this.resId == resourceFont.resId && Intrinsics.areEqual((Object) getWeight(), (Object) resourceFont.getWeight()) && FontStyle.m6158equalsimpl0(m6210getStyle_LCdwA(), resourceFont.m6210getStyle_LCdwA()) && Intrinsics.areEqual((Object) this.variationSettings, (Object) resourceFont.variationSettings) && FontLoadingStrategy.m6145equalsimpl0(m6209getLoadingStrategyPKNRLFQ(), resourceFont.m6209getLoadingStrategyPKNRLFQ());
    }

    public int hashCode() {
        return (((((((this.resId * 31) + getWeight().hashCode()) * 31) + FontStyle.m6159hashCodeimpl(m6210getStyle_LCdwA())) * 31) + FontLoadingStrategy.m6146hashCodeimpl(m6209getLoadingStrategyPKNRLFQ())) * 31) + this.variationSettings.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + getWeight() + ", style=" + FontStyle.m6160toStringimpl(m6210getStyle_LCdwA()) + ", loadingStrategy=" + FontLoadingStrategy.m6147toStringimpl(m6209getLoadingStrategyPKNRLFQ()) + ')';
    }
}
