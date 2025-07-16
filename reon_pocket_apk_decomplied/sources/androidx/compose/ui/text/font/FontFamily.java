package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u00038G¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/font/FontFamily;", "", "canLoadSynchronously", "", "(Z)V", "getCanLoadSynchronously$annotations", "()V", "getCanLoadSynchronously", "()Z", "Companion", "Resolver", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "Landroidx/compose/ui/text/font/LoadedFontFamily;", "Landroidx/compose/ui/text/font/SystemFontFamily;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamily.kt */
public abstract class FontFamily {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final GenericFontFamily Cursive = new GenericFontFamily("cursive", "FontFamily.Cursive");
    /* access modifiers changed from: private */
    public static final SystemFontFamily Default = new DefaultFontFamily();
    /* access modifiers changed from: private */
    public static final GenericFontFamily Monospace = new GenericFontFamily("monospace", "FontFamily.Monospace");
    /* access modifiers changed from: private */
    public static final GenericFontFamily SansSerif = new GenericFontFamily("sans-serif", "FontFamily.SansSerif");
    /* access modifiers changed from: private */
    public static final GenericFontFamily Serif = new GenericFontFamily("serif", "FontFamily.Serif");
    private final boolean canLoadSynchronously;

    public /* synthetic */ FontFamily(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    public static /* synthetic */ void getCanLoadSynchronously$annotations() {
    }

    private FontFamily(boolean z) {
        this.canLoadSynchronously = z;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006JB\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0001\u0001\u0011ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/FontFamily$Resolver;", "", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontFamily.kt */
    public interface Resolver {
        Object preload(FontFamily fontFamily, Continuation<? super Unit> continuation);

        /* renamed from: resolve-DPcqOEQ  reason: not valid java name */
        State<Object> m6131resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2);

        /* renamed from: androidx.compose.ui.text.font.FontFamily$Resolver$-CC  reason: invalid class name */
        /* compiled from: FontFamily.kt */
        public final /* synthetic */ class CC {
            /* renamed from: resolve-DPcqOEQ$default  reason: not valid java name */
            public static /* synthetic */ State m6132resolveDPcqOEQ$default(Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i, int i2, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 1) != 0) {
                        fontFamily = null;
                    }
                    if ((i3 & 2) != 0) {
                        fontWeight = FontWeight.Companion.getNormal();
                    }
                    if ((i3 & 4) != 0) {
                        i = FontStyle.Companion.m6165getNormal_LCdwA();
                    }
                    if ((i3 & 8) != 0) {
                        i2 = FontSynthesis.Companion.m6175getAllGVVA2EU();
                    }
                    return resolver.m6131resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/FontFamily$Companion;", "", "()V", "Cursive", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getCursive", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Default", "Landroidx/compose/ui/text/font/SystemFontFamily;", "getDefault", "()Landroidx/compose/ui/text/font/SystemFontFamily;", "Monospace", "getMonospace", "SansSerif", "getSansSerif", "Serif", "getSerif", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FontFamily.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SystemFontFamily getDefault() {
            return FontFamily.Default;
        }

        public final GenericFontFamily getSansSerif() {
            return FontFamily.SansSerif;
        }

        public final GenericFontFamily getSerif() {
            return FontFamily.Serif;
        }

        public final GenericFontFamily getMonospace() {
            return FontFamily.Monospace;
        }

        public final GenericFontFamily getCursive() {
            return FontFamily.Cursive;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Unused property that has no meaning. Do not use.")
    public final boolean getCanLoadSynchronously() {
        return this.canLoadSynchronously;
    }
}
