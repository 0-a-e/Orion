package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0015\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0013\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0018J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"J\n\u0010#\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0013\u0010(\u001a\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u0012J\u0015\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", "", "string", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "dataAvailable", "", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeByte", "", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeFloat", "", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeInt", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeString", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidClipboardManager.android.kt */
public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel obtain = Parcel.obtain();
        this.parcel = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0112, code lost:
        r4 = r21;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.SpanStyle decodeSpanStyle() {
        /*
            r22 = this;
            androidx.compose.ui.platform.MutableSpanStyle r15 = new androidx.compose.ui.platform.MutableSpanStyle
            r0 = r15
            r19 = 16383(0x3fff, float:2.2957E-41)
            r20 = 0
            r1 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r21 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r0.<init>(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r17, r18, r19, r20)
            r0 = r22
        L_0x0024:
            android.os.Parcel r1 = r0.parcel
            int r1 = r1.dataAvail()
            r2 = 1
            if (r1 <= r2) goto L_0x0112
            byte r1 = r22.decodeByte()
            r3 = 8
            if (r1 != r2) goto L_0x0045
            int r1 = r22.dataAvailable()
            if (r1 < r3) goto L_0x0112
            long r1 = r22.m5769decodeColor0d7_KjU()
            r4 = r21
            r4.m5800setColor8_81llA(r1)
            goto L_0x0024
        L_0x0045:
            r4 = r21
            r5 = 2
            r6 = 5
            if (r1 != r5) goto L_0x005b
            int r1 = r22.dataAvailable()
            if (r1 < r6) goto L_0x0114
            long r1 = r22.m5772decodeTextUnitXSAIIZE()
            r4.m5801setFontSizeR2X_6o(r1)
        L_0x0058:
            r21 = r4
            goto L_0x0024
        L_0x005b:
            r5 = 3
            r7 = 4
            if (r1 != r5) goto L_0x006d
            int r1 = r22.dataAvailable()
            if (r1 < r7) goto L_0x0114
            androidx.compose.ui.text.font.FontWeight r1 = r22.decodeFontWeight()
            r4.setFontWeight(r1)
            goto L_0x0058
        L_0x006d:
            if (r1 != r7) goto L_0x0081
            int r1 = r22.dataAvailable()
            if (r1 < r2) goto L_0x0114
            int r1 = r22.m5770decodeFontStyle_LCdwA()
            androidx.compose.ui.text.font.FontStyle r1 = androidx.compose.ui.text.font.FontStyle.m6155boximpl(r1)
            r4.m5802setFontStylemLjRB2g(r1)
            goto L_0x0058
        L_0x0081:
            if (r1 != r6) goto L_0x0095
            int r1 = r22.dataAvailable()
            if (r1 < r2) goto L_0x0114
            int r1 = r22.m5771decodeFontSynthesisGVVA2EU()
            androidx.compose.ui.text.font.FontSynthesis r1 = androidx.compose.ui.text.font.FontSynthesis.m6166boximpl(r1)
            r4.m5803setFontSynthesistDdu0R4(r1)
            goto L_0x0058
        L_0x0095:
            r2 = 6
            if (r1 != r2) goto L_0x00a0
            java.lang.String r1 = r22.decodeString()
            r4.setFontFeatureSettings(r1)
            goto L_0x0058
        L_0x00a0:
            r2 = 7
            if (r1 != r2) goto L_0x00b1
            int r1 = r22.dataAvailable()
            if (r1 < r6) goto L_0x0114
            long r1 = r22.m5772decodeTextUnitXSAIIZE()
            r4.m5804setLetterSpacingR2X_6o(r1)
            goto L_0x0058
        L_0x00b1:
            if (r1 != r3) goto L_0x00c5
            int r1 = r22.dataAvailable()
            if (r1 < r7) goto L_0x0114
            float r1 = r22.m5767decodeBaselineShifty9eOQZs()
            androidx.compose.ui.text.style.BaselineShift r1 = androidx.compose.ui.text.style.BaselineShift.m6343boximpl(r1)
            r4.m5799setBaselineShift_isdbwI(r1)
            goto L_0x0058
        L_0x00c5:
            r2 = 9
            if (r1 != r2) goto L_0x00d7
            int r1 = r22.dataAvailable()
            if (r1 < r3) goto L_0x0114
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r22.decodeTextGeometricTransform()
            r4.setTextGeometricTransform(r1)
            goto L_0x0058
        L_0x00d7:
            r2 = 10
            if (r1 != r2) goto L_0x00ea
            int r1 = r22.dataAvailable()
            if (r1 < r3) goto L_0x0114
            long r1 = r22.m5769decodeColor0d7_KjU()
            r4.m5798setBackground8_81llA(r1)
            goto L_0x0058
        L_0x00ea:
            r2 = 11
            if (r1 != r2) goto L_0x00fd
            int r1 = r22.dataAvailable()
            if (r1 < r7) goto L_0x0114
            androidx.compose.ui.text.style.TextDecoration r1 = r22.decodeTextDecoration()
            r4.setTextDecoration(r1)
            goto L_0x0058
        L_0x00fd:
            r2 = 12
            if (r1 != r2) goto L_0x0058
            int r1 = r22.dataAvailable()
            r2 = 20
            if (r1 < r2) goto L_0x0114
            androidx.compose.ui.graphics.Shadow r1 = r22.decodeShadow()
            r4.setShadow(r1)
            goto L_0x0058
        L_0x0112:
            r4 = r21
        L_0x0114:
            androidx.compose.ui.text.SpanStyle r1 = r4.toSpanStyle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.DecodeHelper.decodeSpanStyle():androidx.compose.ui.text.SpanStyle");
    }

    /* renamed from: decodeColor-0d7_KjU  reason: not valid java name */
    public final long m5769decodeColor0d7_KjU() {
        return Color.m3812constructorimpl(m5768decodeULongsVKNKU());
    }

    /* renamed from: decodeTextUnit-XSAIIZE  reason: not valid java name */
    public final long m5772decodeTextUnitXSAIIZE() {
        long j;
        byte decodeByte = decodeByte();
        if (decodeByte == 1) {
            j = TextUnitType.Companion.m6844getSpUIouoOA();
        } else if (decodeByte == 2) {
            j = TextUnitType.Companion.m6843getEmUIouoOA();
        } else {
            j = TextUnitType.Companion.m6845getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m6839equalsimpl0(j, TextUnitType.Companion.m6845getUnspecifiedUIouoOA())) {
            return TextUnit.Companion.m6822getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m6823TextUnitanM5pPY(decodeFloat(), j);
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* renamed from: decodeFontStyle-_-LCdwA  reason: not valid java name */
    public final int m5770decodeFontStyle_LCdwA() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontStyle.Companion.m6165getNormal_LCdwA();
        }
        if (decodeByte == 1) {
            return FontStyle.Companion.m6164getItalic_LCdwA();
        }
        return FontStyle.Companion.m6165getNormal_LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU  reason: not valid java name */
    public final int m5771decodeFontSynthesisGVVA2EU() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontSynthesis.Companion.m6176getNoneGVVA2EU();
        }
        if (decodeByte == 1) {
            return FontSynthesis.Companion.m6175getAllGVVA2EU();
        }
        if (decodeByte == 3) {
            return FontSynthesis.Companion.m6177getStyleGVVA2EU();
        }
        if (decodeByte == 2) {
            return FontSynthesis.Companion.m6178getWeightGVVA2EU();
        }
        return FontSynthesis.Companion.m6176getNoneGVVA2EU();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs  reason: not valid java name */
    private final float m5767decodeBaselineShifty9eOQZs() {
        return BaselineShift.m6344constructorimpl(decodeFloat());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        int decodeInt = decodeInt();
        boolean z = (TextDecoration.Companion.getLineThrough().getMask() & decodeInt) != 0;
        boolean z2 = (decodeInt & TextDecoration.Companion.getUnderline().getMask()) != 0;
        if (z && z2) {
            return TextDecoration.Companion.combine(CollectionsKt.listOf(TextDecoration.Companion.getLineThrough(), TextDecoration.Companion.getUnderline()));
        } else if (z) {
            return TextDecoration.Companion.getLineThrough();
        } else {
            if (z2) {
                return TextDecoration.Companion.getUnderline();
            }
            return TextDecoration.Companion.getNone();
        }
    }

    private final Shadow decodeShadow() {
        return new Shadow(m5769decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), (DefaultConstructorMarker) null);
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    /* renamed from: decodeULong-s-VKNKU  reason: not valid java name */
    private final long m5768decodeULongsVKNKU() {
        return ULong.m7216constructorimpl(this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }
}
