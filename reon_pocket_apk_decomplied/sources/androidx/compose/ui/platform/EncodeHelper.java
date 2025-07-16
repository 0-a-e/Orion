package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidClipboardManager.android.kt */
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(SpanStyle spanStyle) {
        if (!Color.m3817equalsimpl0(spanStyle.m6001getColor0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m5784encode8_81llA(spanStyle.m6001getColor0d7_KjU());
        }
        if (!TextUnit.m6808equalsimpl0(spanStyle.m6002getFontSizeXSAIIZE(), TextUnit.Companion.m6822getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m5781encodeR2X_6o(spanStyle.m6002getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle r0 = spanStyle.m6003getFontStyle4Lr2A7w();
        if (r0 != null) {
            int r02 = r0.m6161unboximpl();
            encode((byte) 4);
            m5786encodenzbMABs(r02);
        }
        FontSynthesis r03 = spanStyle.m6004getFontSynthesisZQGJjVo();
        if (r03 != null) {
            int r04 = r03.m6174unboximpl();
            encode((byte) 5);
            m5783encode6p3vJLY(r04);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m6808equalsimpl0(spanStyle.m6005getLetterSpacingXSAIIZE(), TextUnit.Companion.m6822getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m5781encodeR2X_6o(spanStyle.m6005getLetterSpacingXSAIIZE());
        }
        BaselineShift r05 = spanStyle.m6000getBaselineShift5SSeXJ0();
        if (r05 != null) {
            float r06 = r05.m6349unboximpl();
            encode((byte) 8);
            m5782encode4Dl_Bck(r06);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m3817equalsimpl0(spanStyle.m5999getBackground0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m5784encode8_81llA(spanStyle.m5999getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode-8_81llA  reason: not valid java name */
    public final void m5784encode8_81llA(long j) {
        m5785encodeVKZWuLQ(j);
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m5781encodeR2X_6o(long j) {
        long r0 = TextUnit.m6810getTypeUIouoOA(j);
        byte b = 0;
        if (!TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6845getUnspecifiedUIouoOA())) {
            if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6844getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m6839equalsimpl0(r0, TextUnitType.Companion.m6843getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (!TextUnitType.m6839equalsimpl0(TextUnit.m6810getTypeUIouoOA(j), TextUnitType.Companion.m6845getUnspecifiedUIouoOA())) {
            encode(TextUnit.m6811getValueimpl(j));
        }
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m5786encodenzbMABs(int i) {
        byte b = 0;
        if (!FontStyle.m6158equalsimpl0(i, FontStyle.Companion.m6165getNormal_LCdwA()) && FontStyle.m6158equalsimpl0(i, FontStyle.Companion.m6164getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m5783encode6p3vJLY(int i) {
        byte b = 0;
        if (!FontSynthesis.m6169equalsimpl0(i, FontSynthesis.Companion.m6176getNoneGVVA2EU())) {
            if (FontSynthesis.m6169equalsimpl0(i, FontSynthesis.Companion.m6175getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m6169equalsimpl0(i, FontSynthesis.Companion.m6178getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m6169equalsimpl0(i, FontSynthesis.Companion.m6177getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m5782encode4Dl_Bck(float f) {
        encode(f);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m5784encode8_81llA(shadow.m4199getColor0d7_KjU());
        encode(Offset.m3562getXimpl(shadow.m4200getOffsetF1C5BW0()));
        encode(Offset.m3563getYimpl(shadow.m4200getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* renamed from: encode-VKZWuLQ  reason: not valid java name */
    public final void m5785encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(String str) {
        this.parcel.writeString(str);
    }
}
