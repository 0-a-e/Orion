package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.utils.CharsetNames;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Charsets.kt */
public final class Charsets {
    public static final Charsets INSTANCE = new Charsets();
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;
    private static volatile Charset utf_32;
    private static volatile Charset utf_32be;
    private static volatile Charset utf_32le;

    private Charsets() {
    }

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        UTF_8 = forName;
        Charset forName2 = Charset.forName(CharsetNames.UTF_16);
        Intrinsics.checkNotNullExpressionValue(forName2, "forName(...)");
        UTF_16 = forName2;
        Charset forName3 = Charset.forName(CharsetNames.UTF_16BE);
        Intrinsics.checkNotNullExpressionValue(forName3, "forName(...)");
        UTF_16BE = forName3;
        Charset forName4 = Charset.forName(CharsetNames.UTF_16LE);
        Intrinsics.checkNotNullExpressionValue(forName4, "forName(...)");
        UTF_16LE = forName4;
        Charset forName5 = Charset.forName(CharsetNames.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(forName5, "forName(...)");
        US_ASCII = forName5;
        Charset forName6 = Charset.forName(CharsetNames.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(forName6, "forName(...)");
        ISO_8859_1 = forName6;
    }

    public final Charset UTF32() {
        Charset charset = utf_32;
        if (charset != null) {
            return charset;
        }
        Charsets charsets = this;
        Charset forName = Charset.forName("UTF-32");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        utf_32 = forName;
        return forName;
    }

    public final Charset UTF32_LE() {
        Charset charset = utf_32le;
        if (charset != null) {
            return charset;
        }
        Charsets charsets = this;
        Charset forName = Charset.forName("UTF-32LE");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        utf_32le = forName;
        return forName;
    }

    public final Charset UTF32_BE() {
        Charset charset = utf_32be;
        if (charset != null) {
            return charset;
        }
        Charsets charsets = this;
        Charset forName = Charset.forName("UTF-32BE");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        utf_32be = forName;
        return forName;
    }
}
